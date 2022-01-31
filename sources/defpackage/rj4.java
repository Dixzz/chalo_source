package defpackage;

import java.util.concurrent.Executor;

/* renamed from: rj4  reason: default package */
/* compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
public final class rj4<TResult, TContinuationResult> implements vi4<TContinuationResult>, ui4, si4, sj4 {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f3089a;
    public final xi4<TResult, TContinuationResult> b;
    public final wj4<TContinuationResult> c;

    public rj4(Executor executor, xi4<TResult, TContinuationResult> xi4, wj4<TContinuationResult> wj4) {
        this.f3089a = executor;
        this.b = xi4;
        this.c = wj4;
    }

    @Override // defpackage.sj4
    public final void a(yi4<TResult> yi4) {
        this.f3089a.execute(new qj4(this, yi4));
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
