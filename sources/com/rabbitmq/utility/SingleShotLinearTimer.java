package com.rabbitmq.utility;

public class SingleShotLinearTimer {
    private static final long NANOS_IN_MILLI = 1000000;
    private volatile Runnable _task;
    private Thread _thread;

    public class TimerThread implements Runnable {
        private final long _runTime;

        public TimerThread(long j) {
            this._runTime = (System.nanoTime() / SingleShotLinearTimer.NANOS_IN_MILLI) + j;
        }

        public void run() {
            while (true) {
                try {
                    long nanoTime = System.nanoTime() / SingleShotLinearTimer.NANOS_IN_MILLI;
                    if (nanoTime >= this._runTime || SingleShotLinearTimer.this._task == null) {
                        Runnable runnable = SingleShotLinearTimer.this._task;
                    } else {
                        try {
                            synchronized (this) {
                                wait(this._runTime - nanoTime);
                            }
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                } finally {
                    SingleShotLinearTimer.this._task = null;
                }
            }
            Runnable runnable2 = SingleShotLinearTimer.this._task;
            if (runnable2 != null) {
                runnable2.run();
            }
        }
    }

    public void cancel() {
        this._task = null;
    }

    public synchronized void schedule(Runnable runnable, int i) {
        if (runnable == null) {
            throw new IllegalArgumentException("Don't schedule a null task");
        } else if (this._task != null) {
            throw new UnsupportedOperationException("Don't schedule more than one task");
        } else if (i >= 0) {
            this._task = runnable;
            Thread thread = new Thread(new TimerThread((long) i));
            this._thread = thread;
            thread.setDaemon(true);
            this._thread.start();
        } else {
            throw new IllegalArgumentException("Timeout must not be negative");
        }
    }
}
