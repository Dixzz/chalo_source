package defpackage;

import java.util.concurrent.Future;

/* renamed from: oa6  reason: default package */
/* compiled from: Future.kt */
public final class oa6 extends pa6 {
    public final Future<?> f;

    public oa6(Future<?> future) {
        this.f = future;
    }

    @Override // defpackage.qa6
    public void a(Throwable th) {
        this.f.cancel(false);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.s76
    public s56 invoke(Throwable th) {
        this.f.cancel(false);
        return s56.f3190a;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("CancelFutureOnCancel[");
        i0.append(this.f);
        i0.append(']');
        return i0.toString();
    }
}
