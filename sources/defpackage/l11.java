package defpackage;

import android.content.Context;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import app.zophop.R;
import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.models.mTicketing.superPass.SuperPassSubType;
import app.zophop.ui.activities.SuperPassBookingSummaryActivity;
import app.zophop.ui.fragments.superPassValidation.ActiveSuperPassVisualValidationFragment;

/* renamed from: l11  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class l11 implements Toolbar.OnMenuItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ActiveSuperPassVisualValidationFragment f2150a;
    public final /* synthetic */ SuperPass b;

    public /* synthetic */ l11(ActiveSuperPassVisualValidationFragment activeSuperPassVisualValidationFragment, SuperPass superPass) {
        this.f2150a = activeSuperPassVisualValidationFragment;
        this.b = superPass;
    }

    @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        ActiveSuperPassVisualValidationFragment activeSuperPassVisualValidationFragment = this.f2150a;
        SuperPass superPass = this.b;
        ActiveSuperPassVisualValidationFragment.a aVar = ActiveSuperPassVisualValidationFragment.i;
        n86.e(activeSuperPassVisualValidationFragment, "this$0");
        n86.e(superPass, "$lSuperPass");
        if (menuItem.getItemId() == R.id.report_problem) {
            y20 R = xt.f3961a.R();
            Context requireContext = activeSuperPassVisualValidationFragment.requireContext();
            n86.d(requireContext, "requireContext()");
            R.b(requireContext, "transactionRelatedScreen", "activeSuperPassScreen", activeSuperPassVisualValidationFragment.g().f(superPass), false);
            SuperPassSubType superPassSubType = activeSuperPassVisualValidationFragment.g().f;
            String str = activeSuperPassVisualValidationFragment.g().e;
            ed1 l = hj1.l("report problem clicked v2", Long.MIN_VALUE, "type", "qrCodeScreenTicketingProblemsV2");
            l.a("problemSource", "activeSuperPassScreen");
            n86.e(l, "lEvent");
            n86.e(superPassSubType, "superPassSubType");
            n86.e(str, "superPassId");
            hj1.I0(l, "isSuperPass", Boolean.TRUE, superPassSubType, "productSubType");
            l.a("passId", str);
            ui1.m0(l);
            return true;
        } else if (menuItem.getItemId() != R.id.view_trip_receipt) {
            return true;
        } else {
            ed1 l2 = hj1.l("view trip receipt from menu clicked", Long.MIN_VALUE, "source", "sourceActiveSuperPassVisualValidationScreen");
            gi1.f1265a.f(l2, superPass);
            ui1.m0(l2);
            Context context = activeSuperPassVisualValidationFragment.getContext();
            if (context == null) {
                return true;
            }
            SuperPassBookingSummaryActivity.t0(superPass.getSuperPassProperties().getPassId(), superPass.getSuperPassProperties().getProductSubType(), superPass.getLastActivationTimeStamp(), "sourceActiveSuperPassSoundScreen", context);
            return true;
        }
    }
}
