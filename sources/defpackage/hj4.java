package defpackage;

import java.util.concurrent.Executor;

/* renamed from: hj4  reason: default package */
/* compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
public final class hj4<TResult, TContinuationResult> implements vi4<TContinuationResult>, ui4, si4, sj4 {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f1380a;
    public final qi4<TResult, yi4<TContinuationResult>> b;
    public final wj4<TContinuationResult> c;

    public hj4(Executor executor, qi4<TResult, yi4<TContinuationResult>> qi4, wj4<TContinuationResult> wj4) {
        this.f1380a = executor;
        this.b = qi4;
        this.c = wj4;
    }

    @Override // defpackage.sj4
    public final void a(yi4<TResult> yi4) {
        this.f1380a.execute(new gj4(this, yi4));
    }

    @Override // defpackage.si4
    public final void onCanceled() {
        this.c.v();
    }

    @Override // defpackage.ui4
    public final void onFailure(Exception exc) {
        this.c.u(exc);
    }

    @Override // defpackage.vi4
    public final void onSuccess(TContinuationResult tcontinuationresult) {
        this.c.t(tcontinuationresult);
    }
}
