package defpackage;

import android.view.View;
import app.zophop.ui.fragments.superPassHistory.SuperPassApplicationBookingSummaryFragment;

/* renamed from: iz0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class iz0 implements View.OnClickListener {
    public final /* synthetic */ SuperPassApplicationBookingSummaryFragment f;

    public /* synthetic */ iz0(SuperPassApplicationBookingSummaryFragment superPassApplicationBookingSummaryFragment) {
        this.f = superPassApplicationBookingSummaryFragment;
    }

    public final void onClick(View view) {
        SuperPassApplicationBookingSummaryFragment superPassApplicationBookingSummaryFragment = this.f;
        int i = SuperPassApplicationBookingSummaryFragment.i;
        n86.e(superPassApplicationBookingSummaryFragment, "this$0");
        ed1 ed1 = new ed1("submitted proofs expanded", Long.MIN_VALUE);
        superPassApplicationBookingSummaryFragment.i(ed1);
        ui1.m0(ed1);
        t91 t91 = superPassApplicationBookingSummaryFragment.h;
        if (t91 != null) {
            wh whVar = t91.d;
            Boolean d = t91.e.d();
            n86.c(d);
            whVar.b("keyProofDocumentsExpansionState", Boolean.valueOf(!d.booleanValue()));
            return;
        }
        n86.l("viewModel");
        throw null;
    }
}
