package defpackage;

import app.zophop.ui.activities.SuperPassCashPaymentWebViewActivity;
import defpackage.jm0;

/* renamed from: vf0  reason: default package */
/* compiled from: SuperPassCashPaymentWebViewActivity.kt */
public final class vf0 implements jm0.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SuperPassCashPaymentWebViewActivity f3642a;

    public vf0(SuperPassCashPaymentWebViewActivity superPassCashPaymentWebViewActivity) {
        this.f3642a = superPassCashPaymentWebViewActivity;
    }

    @Override // defpackage.jm0.a
    public void a() {
        ed1 ed1 = new ed1("renew disabled product error dialog rendered", Long.MIN_VALUE);
        String str = this.f3642a.s;
        if (str != null) {
            ed1.a("renew disabled product source", str);
            ui1.m0(ed1);
            return;
        }
        n86.l("source");
        throw null;
    }

    @Override // defpackage.jm0.a
    public void b() {
    }
}
