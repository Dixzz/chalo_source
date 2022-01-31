package com.rabbitmq.client.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WorkPool<K, W> {
    private static final int MAX_QUEUE_LENGTH = 1000;
    private final Set<K> inProgress = new HashSet();
    private final Map<K, VariableLinkedBlockingQueue<W>> pool = new HashMap();
    private final SetQueue<K> ready = new SetQueue<>();
    private final Set<K> unlimited = new HashSet();

    private void dormantToReady(K k) {
        this.ready.addIfNotPresent(k);
    }

    private int drainTo(VariableLinkedBlockingQueue<W> variableLinkedBlockingQueue, Collection<W> collection, int i) {
        int i2 = 0;
        while (i2 < i) {
            W poll = variableLinkedBlockingQueue.poll();
            if (poll == null) {
                break;
            }
            collection.add(poll);
            i2++;
        }
        return i2;
    }

    private void inProgressToDormant(K k) {
        this.inProgress.remove(k);
    }

    private void inProgressToReady(K k) {
        this.inProgress.remove(k);
        this.ready.addIfNotPresent(k);
    }

    private boolean isDormant(K k) {
        return !isInProgress(k) && !isReady(k) && isRegistered(k);
    }

    private boolean isInProgress(K k) {
        return this.inProgress.contains(k);
    }

    private boolean isReady(K k) {
        return this.ready.contains(k);
    }

    private boolean isRegistered(K k) {
        return this.pool.containsKey(k);
    }

    private boolean moreWorkItems(K k) {
        VariableLinkedBlockingQueue<W> variableLinkedBlockingQueue = this.pool.get(k);
        return variableLinkedBlockingQueue != null && !variableLinkedBlockingQueue.isEmpty();
    }

    private K readyToInProgress() {
        K poll = this.ready.poll();
        if (poll != null) {
            this.inProgress.add(poll);
        }
        return poll;
    }

    private void setCapacities(int i) {
        for (VariableLinkedBlockingQueue<W> variableLinkedBlockingQueue : this.pool.values()) {
            variableLinkedBlockingQueue.setCapacity(i);
        }
    }

    public boolean addWorkItem(K k, W w) {
        VariableLinkedBlockingQueue<W> variableLinkedBlockingQueue;
        synchronized (this) {
            variableLinkedBlockingQueue = this.pool.get(k);
        }
        if (variableLinkedBlockingQueue == null) {
            return false;
        }
        try {
            variableLinkedBlockingQueue.put(w);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
        synchronized (this) {
            if (!isDormant(k)) {
                return false;
            }
            dormantToReady(k);
            return true;
        }
    }

    public boolean finishWorkBlock(K k) {
        synchronized (this) {
            if (!isRegistered(k)) {
                return false;
            }
            if (!this.inProgress.contains(k)) {
                throw new IllegalStateException("Client " + ((Object) k) + " not in progress");
            } else if (moreWorkItems(k)) {
                inProgressToReady(k);
                return true;
            } else {
                inProgressToDormant(k);
                return false;
            }
        }
    }

    public synchronized void limit(K k) {
        this.unlimited.remove(k);
        if (this.unlimited.isEmpty()) {
            setCapacities(1000);
        }
    }

    public K nextWorkBlock(Collection<W> collection, int i) {
        K readyToInProgress;
        synchronized (this) {
            readyToInProgress = readyToInProgress();
            if (readyToInProgress != null) {
                drainTo(this.pool.get(readyToInProgress), collection, i);
            }
        }
        return readyToInProgress;
    }

    public void registerKey(K k) {
        synchronized (this) {
            if (!this.pool.containsKey(k)) {
                this.pool.put(k, new VariableLinkedBlockingQueue<>(this.unlimited.isEmpty() ? 1000 : Integer.MAX_VALUE));
            }
        }
    }

    public synchronized void unlimit(K k) {
        this.unlimited.add(k);
        if (!this.unlimited.isEmpty()) {
            setCapacities(Integer.MAX_VALUE);
        }
    }

    public void unregisterAllKeys() {
        synchronized (this) {
            this.pool.clear();
            this.ready.clear();
            this.inProgress.clear();
            this.unlimited.clear();
        }
    }

    public void unregisterKey(K k) {
        synchronized (this) {
            this.pool.remove(k);
            this.ready.remove(k);
            this.inProgress.remove(k);
            this.unlimited.remove(k);
        }
    }
}
