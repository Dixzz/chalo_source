package defpackage;

import android.view.View;
import app.zophop.models.mTicketing.superPass.pendingSuperPass.PendingSuperPass;
import app.zophop.ui.fragments.superPassHistory.PendingSuperPassBookingSummaryFragment;

/* renamed from: cz0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class cz0 implements View.OnClickListener {
    public final /* synthetic */ PendingSuperPassBookingSummaryFragment f;
    public final /* synthetic */ PendingSuperPass g;

    public /* synthetic */ cz0(PendingSuperPassBookingSummaryFragment pendingSuperPassBookingSummaryFragment, PendingSuperPass pendingSuperPass) {
        this.f = pendingSuperPassBookingSummaryFragment;
        this.g = pendingSuperPass;
    }

    public final void onClick(View view) {
        PendingSuperPassBookingSummaryFragment pendingSuperPassBookingSummaryFragment = this.f;
        PendingSuperPass pendingSuperPass = this.g;
        int i = PendingSuperPassBookingSummaryFragment.i;
        n86.e(pendingSuperPassBookingSummaryFragment, "this$0");
        n86.e(pendingSuperPass, "$lPendingSuperPass");
        ed1 ed1 = new ed1("expand fare split clicked", Long.MIN_VALUE);
        pendingSuperPassBookingSummaryFragment.i(ed1, pendingSuperPass);
        ui1.m0(ed1);
        s91 s91 = pendingSuperPassBookingSummaryFragment.h;
        if (s91 != null) {
            wh whVar = s91.d;
            Boolean d = s91.g.d();
            n86.c(d);
            whVar.b("keyFareLayoutExpansionState", Boolean.valueOf(!d.booleanValue()));
            return;
        }
        n86.l("viewModel");
        throw null;
    }
}
