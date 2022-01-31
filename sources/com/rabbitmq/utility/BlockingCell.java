package com.rabbitmq.utility;

import java.util.concurrent.TimeoutException;

public class BlockingCell<T> {
    private static final long INFINITY = -1;
    private static final long NANOS_IN_MILLI = 1000000;
    private boolean _filled = false;
    private T _value;

    public synchronized T get() throws InterruptedException {
        while (!this._filled) {
            wait();
        }
        return this._value;
    }

    public synchronized void set(T t) {
        if (!this._filled) {
            this._value = t;
            this._filled = true;
            notifyAll();
        } else {
            throw new AssertionError("BlockingCell can only be set once");
        }
    }

    public synchronized boolean setIfUnset(T t) {
        if (this._filled) {
            return false;
        }
        set(t);
        return true;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:1:0x0001 */
    /* JADX WARNING: Removed duplicated region for block: B:1:0x0001 A[LOOP:0: B:1:0x0001->B:2:?, LOOP_START, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized T uninterruptibleGet() {
        /*
            r1 = this;
            monitor-enter(r1)
        L_0x0001:
            java.lang.Object r0 = r1.get()     // Catch:{ InterruptedException -> 0x0001, all -> 0x0007 }
            monitor-exit(r1)
            return r0
        L_0x0007:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rabbitmq.utility.BlockingCell.uninterruptibleGet():java.lang.Object");
    }

    public synchronized T uninterruptibleGet(int i) throws TimeoutException {
        long nanoTime;
        long j;
        nanoTime = System.nanoTime() / NANOS_IN_MILLI;
        long j2 = (long) i;
        j = nanoTime + j2;
        while (true) {
            try {
            } catch (InterruptedException unused) {
                if (j2 != -1) {
                    nanoTime = System.nanoTime() / NANOS_IN_MILLI;
                    if (nanoTime >= j) {
                        throw new TimeoutException();
                    }
                }
            }
        }
        return get(j - nanoTime);
    }

    public synchronized T get(long j) throws InterruptedException, TimeoutException {
        if (j == -1) {
            return get();
        } else if (j >= 0) {
            long currentTimeMillis = System.currentTimeMillis() + j;
            while (!this._filled) {
                long currentTimeMillis2 = System.currentTimeMillis();
                if (currentTimeMillis2 >= currentTimeMillis) {
                    break;
                }
                wait(currentTimeMillis - currentTimeMillis2);
            }
            if (this._filled) {
                return this._value;
            }
            throw new TimeoutException();
        } else {
            throw new AssertionError("Timeout cannot be less than zero");
        }
    }
}
