package defpackage;

import android.content.Context;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import app.zophop.R;
import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.ui.activities.SuperPassBookingSummaryActivity;
import app.zophop.ui.fragments.superPassValidation.ActivateSuperPassFragment;

/* renamed from: u01  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class u01 implements Toolbar.OnMenuItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ActivateSuperPassFragment f3439a;
    public final /* synthetic */ SuperPass b;

    public /* synthetic */ u01(ActivateSuperPassFragment activateSuperPassFragment, SuperPass superPass) {
        this.f3439a = activateSuperPassFragment;
        this.b = superPass;
    }

    @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        ActivateSuperPassFragment activateSuperPassFragment = this.f3439a;
        SuperPass superPass = this.b;
        ActivateSuperPassFragment.a aVar = ActivateSuperPassFragment.h;
        gi1 gi1 = gi1.f1265a;
        n86.e(activateSuperPassFragment, "this$0");
        n86.e(superPass, "$lSuperPass");
        if (menuItem.getItemId() == R.id.report_problem) {
            y20 R = xt.f3961a.R();
            Context requireContext = activateSuperPassFragment.requireContext();
            n86.d(requireContext, "requireContext()");
            R.b(requireContext, "transactionRelatedScreen", "activateSuperPassScreen", activateSuperPassFragment.f().f(superPass), false);
            ed1 l = hj1.l("report problem clicked v2", Long.MIN_VALUE, "type", "activationScreenTicketingProblemsV2");
            l.a("problemSource", "activateSuperPassScreen");
            gi1.d(l, superPass);
            ui1.m0(l);
            return true;
        } else if (menuItem.getItemId() != R.id.view_summary) {
            return true;
        } else {
            ed1 l2 = hj1.l("super pass menu view summary clicked", Long.MIN_VALUE, "source", "Activate Super pass Screen");
            gi1.d(l2, superPass);
            ui1.m0(l2);
            Context context = activateSuperPassFragment.getContext();
            if (context == null) {
                return true;
            }
            SuperPassBookingSummaryActivity.s0(superPass.getSuperPassProperties().getPassId(), superPass.getSuperPassProperties().getProductSubType(), "Activate Super pass Screen", context);
            return true;
        }
    }
}
