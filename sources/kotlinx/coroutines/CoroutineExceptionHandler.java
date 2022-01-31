package kotlinx.coroutines;

import defpackage.m66;

/* compiled from: CoroutineExceptionHandler.kt */
public interface CoroutineExceptionHandler extends m66.a {
    public static final /* synthetic */ int d = 0;

    /* compiled from: CoroutineExceptionHandler.kt */
    public static final class a implements m66.b<CoroutineExceptionHandler> {
        public static final /* synthetic */ a f = new a();
    }

    void handleException(m66 m66, Throwable th);
}
