package defpackage;

import android.view.View;
import app.zophop.R;
import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.ui.fragments.superPassHistory.SuperPassBookingSummaryFragment;
import defpackage.xt;

/* renamed from: tz0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class tz0 implements View.OnClickListener {
    public final /* synthetic */ SuperPassBookingSummaryFragment f;
    public final /* synthetic */ SuperPass g;

    public /* synthetic */ tz0(SuperPassBookingSummaryFragment superPassBookingSummaryFragment, SuperPass superPass) {
        this.f = superPassBookingSummaryFragment;
        this.g = superPass;
    }

    public final void onClick(View view) {
        SuperPassBookingSummaryFragment superPassBookingSummaryFragment = this.f;
        SuperPass superPass = this.g;
        int i = SuperPassBookingSummaryFragment.j;
        n86.e(superPassBookingSummaryFragment, "this$0");
        n86.e(superPass, "$lSuperPass");
        ed1 ed1 = new ed1("renew btn clicked", Long.MIN_VALUE);
        superPassBookingSummaryFragment.i(ed1, superPass);
        ui1.m0(ed1);
        if (!superPass.getSuperPassRepurchaseProperties().getVerificationFlag()) {
            ed1 ed12 = new ed1("product selection activity launched", Long.MIN_VALUE);
            superPassBookingSummaryFragment.i(ed12, superPass);
            ui1.m0(ed12);
            superPassBookingSummaryFragment.l(superPass.getSuperPassRepurchaseProperties().getConfigId());
        } else if (!superPass.getSuperPassRepurchaseProperties().isRenewable()) {
            superPassBookingSummaryFragment.l(superPass.getSuperPassRepurchaseProperties().getConfigId());
        } else if (!superPass.getSuperPassRepurchaseProperties().isVerificationExpired()) {
            v91 v91 = superPassBookingSummaryFragment.h;
            if (v91 != null) {
                v91.l = hj1.H("randomUUID().toString()");
                xt.t1 t1Var = xt.f3961a;
                t1Var.c().b(hj1.D(t1Var), v91.l);
                v91.j.j(Boolean.TRUE);
                return;
            }
            n86.l("viewModel");
            throw null;
        } else if (superPassBookingSummaryFragment.c() != null) {
            String string = superPassBookingSummaryFragment.getString(R.string.validity_expired);
            n86.d(string, "getString(R.string.validity_expired)");
            String string2 = superPassBookingSummaryFragment.getString(R.string.validity_expired_desc);
            n86.d(string2, "getString(R.string.validity_expired_desc)");
            SuperPassBookingSummaryFragment.n(superPassBookingSummaryFragment, superPass, string, string2, true, false, null, 32);
        }
    }
}
