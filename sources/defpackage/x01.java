package defpackage;

import android.content.Context;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import app.zophop.R;
import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.ui.activities.SuperPassBookingSummaryActivity;
import app.zophop.ui.fragments.superPassValidation.ActiveSuperPassFragment;

/* renamed from: x01  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class x01 implements Toolbar.OnMenuItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ActiveSuperPassFragment f3867a;
    public final /* synthetic */ SuperPass b;

    public /* synthetic */ x01(ActiveSuperPassFragment activeSuperPassFragment, SuperPass superPass) {
        this.f3867a = activeSuperPassFragment;
        this.b = superPass;
    }

    @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        ActiveSuperPassFragment activeSuperPassFragment = this.f3867a;
        SuperPass superPass = this.b;
        ActiveSuperPassFragment.a aVar = ActiveSuperPassFragment.i;
        gi1 gi1 = gi1.f1265a;
        n86.e(activeSuperPassFragment, "this$0");
        n86.e(superPass, "$lSuperPass");
        if (menuItem.getItemId() == R.id.report_problem) {
            y20 R = xt.f3961a.R();
            Context requireContext = activeSuperPassFragment.requireContext();
            n86.d(requireContext, "requireContext()");
            R.b(requireContext, "transactionRelatedScreen", "activeSuperPassScreen", activeSuperPassFragment.g().f(superPass), false);
            ed1 l = hj1.l("report problem clicked v2", Long.MIN_VALUE, "type", "qrCodeScreenTicketingProblemsV2");
            l.a("problemSource", "activeSuperPassScreen");
            gi1.d(l, superPass);
            ui1.m0(l);
            return true;
        } else if (menuItem.getItemId() != R.id.view_trip_receipt) {
            return true;
        } else {
            ed1 l2 = hj1.l("view trip receipt from menu clicked", Long.MIN_VALUE, "source", "sourceActiveSuperPassQRScreen");
            gi1.f(l2, superPass);
            ui1.m0(l2);
            Context context = activeSuperPassFragment.getContext();
            if (context == null) {
                return true;
            }
            SuperPassBookingSummaryActivity.t0(superPass.getSuperPassProperties().getPassId(), superPass.getSuperPassProperties().getProductSubType(), superPass.getLastActivationTimeStamp(), "sourceActiveSuperPassQRScreen", context);
            return true;
        }
    }
}
