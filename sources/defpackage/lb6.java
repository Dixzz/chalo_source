package defpackage;

import java.lang.Thread;
import java.util.List;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* renamed from: lb6  reason: default package */
/* compiled from: CoroutineExceptionHandlerImpl.kt */
public final class lb6 {

    /* renamed from: a  reason: collision with root package name */
    public static final List<CoroutineExceptionHandler> f2198a = hd3.b3(hd3.s(a.a()));

    public static final void a(m66 m66, Throwable th) {
        Throwable th2;
        for (CoroutineExceptionHandler coroutineExceptionHandler : f2198a) {
            try {
                coroutineExceptionHandler.handleException(m66, th);
            } catch (Throwable th3) {
                Thread currentThread = Thread.currentThread();
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler = currentThread.getUncaughtExceptionHandler();
                if (th == th3) {
                    th2 = th;
                } else {
                    th2 = new RuntimeException("Exception while trying to handle coroutine exception", th3);
                    hd3.l(th2, th);
                }
                uncaughtExceptionHandler.uncaughtException(currentThread, th2);
            }
        }
        Thread currentThread2 = Thread.currentThread();
        currentThread2.getUncaughtExceptionHandler().uncaughtException(currentThread2, th);
    }
}
