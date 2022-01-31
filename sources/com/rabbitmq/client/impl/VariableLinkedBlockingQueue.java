package com.rabbitmq.client.impl;

import j$.lang.Iterable;
import j$.util.Collection;
import j$.util.Iterator;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.Predicate;
import j$.util.stream.Stream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class VariableLinkedBlockingQueue<E> extends AbstractQueue<E> implements BlockingQueue<E>, Serializable, Collection {
    private static final long serialVersionUID = -6903933977591709194L;
    private int capacity;
    private final AtomicInteger count;
    private transient Node<E> head;
    private transient Node<E> last;
    private final Condition notEmpty;
    private final Condition notFull;
    private final ReentrantLock putLock;
    private final ReentrantLock takeLock;

    public class Itr implements Iterator<E>, j$.util.Iterator {
        private Node<E> current;
        private E currentElement;
        private Node<E> lastRet;

        public Itr() {
            ReentrantLock reentrantLock = VariableLinkedBlockingQueue.this.putLock;
            ReentrantLock reentrantLock2 = VariableLinkedBlockingQueue.this.takeLock;
            reentrantLock.lock();
            reentrantLock2.lock();
            try {
                Node<E> node = VariableLinkedBlockingQueue.this.head.next;
                this.current = node;
                if (node != null) {
                    this.currentElement = node.item;
                }
            } finally {
                reentrantLock2.unlock();
                reentrantLock.unlock();
            }
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // j$.util.Iterator
        public boolean hasNext() {
            return this.current != null;
        }

        @Override // j$.util.Iterator, java.util.Iterator
        public E next() {
            ReentrantLock reentrantLock = VariableLinkedBlockingQueue.this.putLock;
            ReentrantLock reentrantLock2 = VariableLinkedBlockingQueue.this.takeLock;
            reentrantLock.lock();
            reentrantLock2.lock();
            try {
                Node<E> node = this.current;
                if (node != null) {
                    E e = this.currentElement;
                    this.lastRet = node;
                    Node<E> node2 = node.next;
                    this.current = node2;
                    if (node2 != null) {
                        this.currentElement = node2.item;
                    }
                    return e;
                }
                throw new NoSuchElementException();
            } finally {
                reentrantLock2.unlock();
                reentrantLock.unlock();
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x0035 A[Catch:{ all -> 0x005d }] */
        @Override // j$.util.Iterator
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void remove() {
            /*
            // Method dump skipped, instructions count: 107
            */
            throw new UnsupportedOperationException("Method not decompiled: com.rabbitmq.client.impl.VariableLinkedBlockingQueue.Itr.remove():void");
        }
    }

    public static class Node<E> {
        public volatile E item;
        public Node<E> next;

        public Node(E e) {
            this.item = e;
        }
    }

    public VariableLinkedBlockingQueue() {
        this(Integer.MAX_VALUE);
    }

    private E extract() {
        Node<E> node = this.head.next;
        this.head = node;
        E e = node.item;
        node.item = null;
        return e;
    }

    private void fullyLock() {
        this.putLock.lock();
        this.takeLock.lock();
    }

    private void fullyUnlock() {
        this.takeLock.unlock();
        this.putLock.unlock();
    }

    private void insert(E e) {
        Node<E> node = this.last;
        Node<E> node2 = new Node<>(e);
        node.next = node2;
        this.last = node2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.rabbitmq.client.impl.VariableLinkedBlockingQueue<E> */
    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.count.set(0);
        Node<E> node = new Node<>(null);
        this.head = node;
        this.last = node;
        while (true) {
            Object readObject = objectInputStream.readObject();
            if (readObject != null) {
                add(readObject);
            } else {
                return;
            }
        }
    }

    private void signalNotEmpty() {
        ReentrantLock reentrantLock = this.takeLock;
        reentrantLock.lock();
        try {
            this.notEmpty.signal();
        } finally {
            reentrantLock.unlock();
        }
    }

    private void signalNotFull() {
        ReentrantLock reentrantLock = this.putLock;
        reentrantLock.lock();
        try {
            this.notFull.signal();
        } finally {
            reentrantLock.unlock();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        fullyLock();
        try {
            objectOutputStream.defaultWriteObject();
            Node<E> node = this.head;
            while (true) {
                node = node.next;
                if (node != null) {
                    objectOutputStream.writeObject(node.item);
                } else {
                    objectOutputStream.writeObject(null);
                    return;
                }
            }
        } finally {
            fullyUnlock();
        }
    }

    @Override // j$.util.Collection
    public void clear() {
        fullyLock();
        try {
            this.head.next = null;
            if (this.count.getAndSet(0) >= this.capacity) {
                this.notFull.signalAll();
            }
        } finally {
            fullyUnlock();
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(java.util.Collection<? super E> collection) {
        Objects.requireNonNull(collection);
        if (collection != this) {
            fullyLock();
            try {
                Node<E> node = this.head;
                node.next = null;
                int i = 0;
                if (this.count.getAndSet(0) >= this.capacity) {
                    this.notFull.signalAll();
                }
                for (Node<E> node2 = node.next; node2 != null; node2 = node2.next) {
                    collection.add(node2.item);
                    node2.item = null;
                    i++;
                }
                return i;
            } finally {
                fullyUnlock();
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override // j$.util.Collection, j$.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    @Override // j$.util.Collection, java.util.AbstractCollection, java.util.Collection, j$.lang.Iterable, java.lang.Iterable
    public java.util.Iterator<E> iterator() {
        return new Itr();
    }

    @Override // java.util.concurrent.BlockingQueue
    public boolean offer(E e, long j, TimeUnit timeUnit) throws InterruptedException {
        Objects.requireNonNull(e);
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.putLock;
        AtomicInteger atomicInteger = this.count;
        reentrantLock.lockInterruptibly();
        while (atomicInteger.get() >= this.capacity) {
            try {
                if (nanos <= 0) {
                    return false;
                }
                try {
                    nanos = this.notFull.awaitNanos(nanos);
                } catch (InterruptedException e2) {
                    this.notFull.signal();
                    throw e2;
                }
            } finally {
                reentrantLock.unlock();
            }
        }
        insert(e);
        int andIncrement = atomicInteger.getAndIncrement();
        if (andIncrement + 1 < this.capacity) {
            this.notFull.signal();
        }
        reentrantLock.unlock();
        if (andIncrement != 0) {
            return true;
        }
        signalNotEmpty();
        return true;
    }

    @Override // j$.util.Collection, java.util.Collection
    public /* synthetic */ Stream parallelStream() {
        return Collection.CC.$default$parallelStream(this);
    }

    @Override // java.util.Queue
    public E peek() {
        if (this.count.get() == 0) {
            return null;
        }
        ReentrantLock reentrantLock = this.takeLock;
        reentrantLock.lock();
        try {
            Node<E> node = this.head.next;
            if (node == null) {
                return null;
            }
            E e = node.item;
            reentrantLock.unlock();
            return e;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public E poll(long j, TimeUnit timeUnit) throws InterruptedException {
        long nanos = timeUnit.toNanos(j);
        AtomicInteger atomicInteger = this.count;
        ReentrantLock reentrantLock = this.takeLock;
        reentrantLock.lockInterruptibly();
        while (atomicInteger.get() <= 0) {
            try {
                if (nanos <= 0) {
                    return null;
                }
                try {
                    nanos = this.notEmpty.awaitNanos(nanos);
                } catch (InterruptedException e) {
                    this.notEmpty.signal();
                    throw e;
                }
            } finally {
                reentrantLock.unlock();
            }
        }
        E extract = extract();
        int andDecrement = atomicInteger.getAndDecrement();
        if (andDecrement > 1) {
            this.notEmpty.signal();
        }
        reentrantLock.unlock();
        if (andDecrement >= this.capacity) {
            signalNotFull();
        }
        return extract;
    }

    @Override // java.util.concurrent.BlockingQueue
    public void put(E e) throws InterruptedException {
        Objects.requireNonNull(e);
        ReentrantLock reentrantLock = this.putLock;
        AtomicInteger atomicInteger = this.count;
        reentrantLock.lockInterruptibly();
        while (atomicInteger.get() >= this.capacity) {
            try {
                this.notFull.await();
            } catch (InterruptedException e2) {
                this.notFull.signal();
                throw e2;
            }
        }
        try {
            insert(e);
            int andIncrement = atomicInteger.getAndIncrement();
            if (andIncrement + 1 < this.capacity) {
                this.notFull.signal();
            }
            if (andIncrement == 0) {
                signalNotEmpty();
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public int remainingCapacity() {
        return this.capacity - this.count.get();
    }

    @Override // j$.util.Collection
    public boolean remove(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        fullyLock();
        try {
            Node<E> node = this.head;
            Node<E> node2 = node.next;
            while (true) {
                node = node2;
                if (node == null) {
                    break;
                } else if (obj.equals(node.item)) {
                    z = true;
                    break;
                } else {
                    node2 = node.next;
                }
            }
            if (z) {
                node.item = null;
                node.next = node.next;
                if (this.count.getAndDecrement() >= this.capacity) {
                    this.notFull.signalAll();
                }
            }
            return z;
        } finally {
            fullyUnlock();
        }
    }

    @Override // j$.util.Collection
    public /* synthetic */ boolean removeIf(Predicate predicate) {
        return Collection.CC.$default$removeIf(this, predicate);
    }

    public void setCapacity(int i) {
        int i2 = this.capacity;
        this.capacity = i;
        int i3 = this.count.get();
        if (i > i3 && i3 >= i2) {
            signalNotFull();
        }
    }

    @Override // j$.util.Collection
    public int size() {
        return this.count.get();
    }

    @Override // j$.util.Collection, java.util.Collection, j$.lang.Iterable, java.lang.Iterable
    public /* synthetic */ Spliterator spliterator() {
        return Collection.CC.$default$spliterator(this);
    }

    @Override // j$.util.Collection, java.util.Collection
    public /* synthetic */ Stream stream() {
        return Collection.CC.$default$stream(this);
    }

    /* JADX INFO: finally extract failed */
    @Override // java.util.concurrent.BlockingQueue
    public E take() throws InterruptedException {
        AtomicInteger atomicInteger = this.count;
        ReentrantLock reentrantLock = this.takeLock;
        reentrantLock.lockInterruptibly();
        while (atomicInteger.get() == 0) {
            try {
                this.notEmpty.await();
            } catch (InterruptedException e) {
                this.notEmpty.signal();
                throw e;
            }
        }
        try {
            E extract = extract();
            int andDecrement = atomicInteger.getAndDecrement();
            if (andDecrement > 1) {
                this.notEmpty.signal();
            }
            reentrantLock.unlock();
            if (andDecrement >= this.capacity) {
                signalNotFull();
            }
            return extract;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // j$.util.Collection
    public Object[] toArray() {
        fullyLock();
        try {
            Object[] objArr = new Object[this.count.get()];
            int i = 0;
            Node<E> node = this.head.next;
            while (node != null) {
                int i2 = i + 1;
                objArr[i] = node.item;
                node = node.next;
                i = i2;
            }
            return objArr;
        } finally {
            fullyUnlock();
        }
    }

    public String toString() {
        fullyLock();
        try {
            return super.toString();
        } finally {
            fullyUnlock();
        }
    }

    public VariableLinkedBlockingQueue(int i) {
        this.count = new AtomicInteger(0);
        ReentrantLock reentrantLock = new ReentrantLock();
        this.takeLock = reentrantLock;
        this.notEmpty = reentrantLock.newCondition();
        ReentrantLock reentrantLock2 = new ReentrantLock();
        this.putLock = reentrantLock2;
        this.notFull = reentrantLock2.newCondition();
        if (i > 0) {
            this.capacity = i;
            Node<E> node = new Node<>(null);
            this.head = node;
            this.last = node;
            return;
        }
        throw new IllegalArgumentException();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v8, resolved type: T[] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // j$.util.Collection, java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        fullyLock();
        try {
            int i = this.count.get();
            if (tArr.length < i) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i));
            }
            int i2 = 0;
            Node<E> node = this.head.next;
            while (node != null) {
                int i3 = i2 + 1;
                tArr[i2] = node.item;
                node = node.next;
                i2 = i3;
            }
            return tArr;
        } finally {
            fullyUnlock();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.rabbitmq.client.impl.VariableLinkedBlockingQueue<E> */
    /* JADX WARN: Multi-variable type inference failed */
    public VariableLinkedBlockingQueue(java.util.Collection<? extends E> collection) {
        this(Integer.MAX_VALUE);
        java.util.Iterator<? extends E> it = collection.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(java.util.Collection<? super E> collection, int i) {
        Objects.requireNonNull(collection);
        if (collection != this) {
            int i2 = 0;
            if (i <= 0) {
                return 0;
            }
            fullyLock();
            try {
                Node<E> node = this.head.next;
                while (node != null && i2 < i) {
                    collection.add(node.item);
                    node.item = null;
                    node = node.next;
                    i2++;
                }
                if (i2 != 0) {
                    this.head.next = node;
                    if (this.count.getAndAdd(-i2) >= this.capacity) {
                        this.notFull.signalAll();
                    }
                }
                return i2;
            } finally {
                fullyUnlock();
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    /* JADX INFO: finally extract failed */
    @Override // java.util.Queue
    public E poll() {
        AtomicInteger atomicInteger = this.count;
        E e = null;
        if (atomicInteger.get() == 0) {
            return null;
        }
        int i = -1;
        ReentrantLock reentrantLock = this.takeLock;
        reentrantLock.lock();
        try {
            if (atomicInteger.get() > 0) {
                e = extract();
                i = atomicInteger.getAndDecrement();
                if (i > 1) {
                    this.notEmpty.signal();
                }
            }
            reentrantLock.unlock();
            if (i >= this.capacity) {
                signalNotFull();
            }
            return e;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // java.util.concurrent.BlockingQueue, java.util.Queue
    public boolean offer(E e) {
        Objects.requireNonNull(e);
        AtomicInteger atomicInteger = this.count;
        if (atomicInteger.get() >= this.capacity) {
            return false;
        }
        int i = -1;
        ReentrantLock reentrantLock = this.putLock;
        reentrantLock.lock();
        try {
            if (atomicInteger.get() < this.capacity) {
                insert(e);
                i = atomicInteger.getAndIncrement();
                if (i + 1 < this.capacity) {
                    this.notFull.signal();
                }
            }
            if (i == 0) {
                signalNotEmpty();
            }
            if (i >= 0) {
                return true;
            }
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }
}
