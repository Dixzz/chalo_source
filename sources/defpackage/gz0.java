package defpackage;

import android.view.View;
import app.zophop.ui.fragments.superPassHistory.SuperPassApplicationBookingSummaryFragment;

/* renamed from: gz0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class gz0 implements View.OnClickListener {
    public final /* synthetic */ SuperPassApplicationBookingSummaryFragment f;

    public /* synthetic */ gz0(SuperPassApplicationBookingSummaryFragment superPassApplicationBookingSummaryFragment) {
        this.f = superPassApplicationBookingSummaryFragment;
    }

    public final void onClick(View view) {
        SuperPassApplicationBookingSummaryFragment superPassApplicationBookingSummaryFragment = this.f;
        int i = SuperPassApplicationBookingSummaryFragment.i;
        n86.e(superPassApplicationBookingSummaryFragment, "this$0");
        ed1 ed1 = new ed1("expand fare split clicked", Long.MIN_VALUE);
        superPassApplicationBookingSummaryFragment.i(ed1);
        ui1.m0(ed1);
        t91 t91 = superPassApplicationBookingSummaryFragment.h;
        if (t91 != null) {
            wh whVar = t91.d;
            Boolean d = t91.g.d();
            n86.c(d);
            whVar.b("keyFareLayoutExpansionState", Boolean.valueOf(!d.booleanValue()));
            return;
        }
        n86.l("viewModel");
        throw null;
    }
}
