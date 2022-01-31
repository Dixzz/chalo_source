package defpackage;

import kotlinx.coroutines.CoroutineExceptionHandler;

/* renamed from: lh1  reason: default package */
/* compiled from: CoroutineExceptionHandler.kt */
public final class lh1 extends h66 implements CoroutineExceptionHandler {
    public lh1(CoroutineExceptionHandler.a aVar) {
        super(aVar);
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public void handleException(m66 m66, Throwable th) {
        n86.j("getCoroutineExceptionHandler: exception = ", th.getMessage());
        n86.j("getCoroutineExceptionHandler: cause = ", th.getCause());
        b00 b00 = b00.f358a;
        b00.a().b(th);
    }
}
