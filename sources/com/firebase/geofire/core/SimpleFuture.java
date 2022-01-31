package com.firebase.geofire.core;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SimpleFuture<V> implements Future<V> {
    private boolean isSet = false;
    private final Lock lock;
    private V object = null;
    private final Condition setCondition;

    public SimpleFuture() {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.setCondition = reentrantLock.newCondition();
    }

    public boolean cancel(boolean z) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public V get() throws InterruptedException, ExecutionException {
        this.lock.lock();
        while (!this.isSet) {
            try {
                this.setCondition.await();
            } finally {
                this.lock.unlock();
            }
        }
        return this.object;
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        this.lock.lock();
        try {
            return this.isSet;
        } finally {
            this.lock.unlock();
        }
    }

    public synchronized void put(V v) {
        this.lock.lock();
        try {
            this.object = v;
            this.isSet = true;
            this.setCondition.signalAll();
        } finally {
            this.lock.unlock();
        }
    }

    @Override // java.util.concurrent.Future
    public V get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        this.lock.lock();
        while (!this.isSet) {
            try {
                if (!this.setCondition.await(j, timeUnit)) {
                    throw new TimeoutException();
                }
            } finally {
                this.lock.unlock();
            }
        }
        return this.object;
    }
}
