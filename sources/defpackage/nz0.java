package defpackage;

import android.view.View;
import app.zophop.ui.fragments.superPassHistory.SuperPassBookingSummaryFragment;

/* renamed from: nz0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class nz0 implements View.OnClickListener {
    public final /* synthetic */ SuperPassBookingSummaryFragment f;

    public /* synthetic */ nz0(SuperPassBookingSummaryFragment superPassBookingSummaryFragment) {
        this.f = superPassBookingSummaryFragment;
    }

    public final void onClick(View view) {
        SuperPassBookingSummaryFragment superPassBookingSummaryFragment = this.f;
        int i = SuperPassBookingSummaryFragment.j;
        n86.e(superPassBookingSummaryFragment, "this$0");
        ed1 ed1 = new ed1("submitted proofs expanded", Long.MIN_VALUE);
        ed1.a("source", "superPassBookingSummaryFragment");
        ed1.a("isSuperPass", Boolean.TRUE);
        ui1.m0(ed1);
        v91 v91 = superPassBookingSummaryFragment.h;
        if (v91 != null) {
            wh whVar = v91.d;
            Boolean d = v91.f.d();
            n86.c(d);
            whVar.b("keyProofDocumentsExpansionState", Boolean.valueOf(!d.booleanValue()));
            return;
        }
        n86.l("viewModel");
        throw null;
    }
}
