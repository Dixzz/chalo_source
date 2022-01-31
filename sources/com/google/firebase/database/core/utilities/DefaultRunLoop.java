package com.google.firebase.database.core.utilities;

import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.core.RunLoop;
import com.google.firebase.database.core.ThreadInitializer;
import java.lang.Thread;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public abstract class DefaultRunLoop implements RunLoop {
    private ScheduledThreadPoolExecutor executor;

    public class FirebaseThreadFactory implements ThreadFactory {
        private FirebaseThreadFactory() {
        }

        public Thread newThread(Runnable runnable) {
            Thread newThread = DefaultRunLoop.this.getThreadFactory().newThread(runnable);
            ThreadInitializer threadInitializer = DefaultRunLoop.this.getThreadInitializer();
            threadInitializer.setName(newThread, "FirebaseDatabaseWorker");
            threadInitializer.setDaemon(newThread, true);
            threadInitializer.setUncaughtExceptionHandler(newThread, new Thread.UncaughtExceptionHandler() {
                /* class com.google.firebase.database.core.utilities.DefaultRunLoop.FirebaseThreadFactory.AnonymousClass1 */

                public void uncaughtException(Thread thread, Throwable th) {
                    DefaultRunLoop.this.handleException(th);
                }
            });
            return newThread;
        }
    }

    public DefaultRunLoop() {
        AnonymousClass1 r1 = new ScheduledThreadPoolExecutor(1, new FirebaseThreadFactory()) {
            /* class com.google.firebase.database.core.utilities.DefaultRunLoop.AnonymousClass1 */

            public void afterExecute(Runnable runnable, Throwable th) {
                super.afterExecute(runnable, th);
                if (th == null && (runnable instanceof Future)) {
                    Future future = (Future) runnable;
                    try {
                        if (future.isDone()) {
                            future.get();
                        }
                    } catch (CancellationException unused) {
                    } catch (ExecutionException e) {
                        th = e.getCause();
                    } catch (InterruptedException unused2) {
                        Thread.currentThread().interrupt();
                    }
                }
                if (th != null) {
                    DefaultRunLoop.this.handleException(th);
                }
            }
        };
        this.executor = r1;
        r1.setKeepAliveTime(3, TimeUnit.SECONDS);
    }

    public static String messageForException(Throwable th) {
        if (th instanceof OutOfMemoryError) {
            return "Firebase Database encountered an OutOfMemoryError. You may need to reduce the amount of data you are syncing to the client (e.g. by using queries or syncing a deeper path). See https://firebase.google.com/docs/database/ios/structure-data#best_practices_for_data_structure and https://firebase.google.com/docs/database/android/retrieve-data#filtering_data";
        }
        if (th instanceof NoClassDefFoundError) {
            return "A symbol that the Firebase Database SDK depends on failed to load. This usually indicates that your project includes an incompatible version of another Firebase dependency. If updating your dependencies to the latest version does not resolve this issue, please file a report at https://github.com/firebase/firebase-android-sdk";
        }
        if (th instanceof DatabaseException) {
            return "";
        }
        StringBuilder i0 = hj1.i0("Uncaught exception in Firebase Database runloop (");
        i0.append(FirebaseDatabase.getSdkVersion());
        i0.append("). If you are not already on the latest version of the Firebase SDKs, try updating your dependencies. Should this problem persist, please file a report at https://github.com/firebase/firebase-android-sdk");
        return i0.toString();
    }

    public ScheduledExecutorService getExecutorService() {
        return this.executor;
    }

    public ThreadFactory getThreadFactory() {
        return Executors.defaultThreadFactory();
    }

    public ThreadInitializer getThreadInitializer() {
        return ThreadInitializer.defaultInstance;
    }

    public abstract void handleException(Throwable th);

    @Override // com.google.firebase.database.core.RunLoop
    public void restart() {
        this.executor.setCorePoolSize(1);
    }

    @Override // com.google.firebase.database.core.RunLoop
    public ScheduledFuture schedule(Runnable runnable, long j) {
        return this.executor.schedule(runnable, j, TimeUnit.MILLISECONDS);
    }

    @Override // com.google.firebase.database.core.RunLoop
    public void scheduleNow(Runnable runnable) {
        this.executor.execute(runnable);
    }

    @Override // com.google.firebase.database.core.RunLoop
    public void shutdown() {
        this.executor.setCorePoolSize(0);
    }
}
