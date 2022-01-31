package defpackage;

import android.view.View;
import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.ui.fragments.superPassHistory.SuperPassBookingSummaryFragment;

/* renamed from: uz0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class uz0 implements View.OnClickListener {
    public final /* synthetic */ SuperPassBookingSummaryFragment f;
    public final /* synthetic */ SuperPass g;

    public /* synthetic */ uz0(SuperPassBookingSummaryFragment superPassBookingSummaryFragment, SuperPass superPass) {
        this.f = superPassBookingSummaryFragment;
        this.g = superPass;
    }

    public final void onClick(View view) {
        SuperPassBookingSummaryFragment superPassBookingSummaryFragment = this.f;
        SuperPass superPass = this.g;
        int i = SuperPassBookingSummaryFragment.j;
        n86.e(superPassBookingSummaryFragment, "this$0");
        n86.e(superPass, "$lSuperPass");
        ed1 ed1 = new ed1("expand fare split clicked", Long.MIN_VALUE);
        superPassBookingSummaryFragment.i(ed1, superPass);
        ui1.m0(ed1);
        v91 v91 = superPassBookingSummaryFragment.h;
        if (v91 != null) {
            wh whVar = v91.d;
            Boolean d = v91.h.d();
            n86.c(d);
            whVar.b("keyFareLayoutExpansionState", Boolean.valueOf(!d.booleanValue()));
            return;
        }
        n86.l("viewModel");
        throw null;
    }
}
