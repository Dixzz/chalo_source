package com.crashlytics.android.answers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class BackgroundManager {
    private static final int BACKGROUND_DELAY = 5000;
    public final AtomicReference<ScheduledFuture<?>> backgroundFutureRef = new AtomicReference<>();
    private final ScheduledExecutorService executorService;
    private volatile boolean flushOnBackground = true;
    public boolean inBackground = true;
    private final List<Listener> listeners = new ArrayList();

    public interface Listener {
        void onBackground();
    }

    public BackgroundManager(ScheduledExecutorService scheduledExecutorService) {
        this.executorService = scheduledExecutorService;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void notifyBackground() {
        for (Listener listener : this.listeners) {
            listener.onBackground();
        }
    }

    public void onActivityPaused() {
        if (this.flushOnBackground && !this.inBackground) {
            this.inBackground = true;
            try {
                this.backgroundFutureRef.compareAndSet(null, this.executorService.schedule(new Runnable() {
                    /* class com.crashlytics.android.answers.BackgroundManager.AnonymousClass1 */

                    public void run() {
                        BackgroundManager.this.backgroundFutureRef.set(null);
                        BackgroundManager.this.notifyBackground();
                    }
                }, 5000, TimeUnit.MILLISECONDS));
            } catch (RejectedExecutionException unused) {
            }
        }
    }

    public void onActivityResumed() {
        this.inBackground = false;
        ScheduledFuture<?> andSet = this.backgroundFutureRef.getAndSet(null);
        if (andSet != null) {
            andSet.cancel(false);
        }
    }

    public void registerListener(Listener listener) {
        this.listeners.add(listener);
    }

    public void setFlushOnBackground(boolean z) {
        this.flushOnBackground = z;
    }
}
