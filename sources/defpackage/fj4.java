package defpackage;

import java.util.concurrent.Executor;

/* renamed from: fj4  reason: default package */
/* compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
public final class fj4<TResult, TContinuationResult> implements sj4<TResult> {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f1130a;
    public final qi4<TResult, TContinuationResult> b;
    public final wj4<TContinuationResult> c;

    public fj4(Executor executor, qi4<TResult, TContinuationResult> qi4, wj4<TContinuationResult> wj4) {
        this.f1130a = executor;
        this.b = qi4;
        this.c = wj4;
    }

    @Override // defpackage.sj4
    public final void a(yi4<TResult> yi4) {
        this.f1130a.execute(new ej4(this, yi4));
    }
}
