package defpackage;

import android.content.Context;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import app.zophop.R;
import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.ui.activities.SuperPassBookingSummaryActivity;
import app.zophop.ui.fragments.superPassValidation.SoundFragmentSuperPass;

/* renamed from: t11  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class t11 implements Toolbar.OnMenuItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SoundFragmentSuperPass f3293a;
    public final /* synthetic */ SuperPass b;

    public /* synthetic */ t11(SoundFragmentSuperPass soundFragmentSuperPass, SuperPass superPass) {
        this.f3293a = soundFragmentSuperPass;
        this.b = superPass;
    }

    @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        SoundFragmentSuperPass soundFragmentSuperPass = this.f3293a;
        SuperPass superPass = this.b;
        SoundFragmentSuperPass.a aVar = SoundFragmentSuperPass.j;
        gi1 gi1 = gi1.f1265a;
        n86.e(soundFragmentSuperPass, "this$0");
        n86.e(superPass, "$lSuperPass");
        if (menuItem.getItemId() == R.id.report_problem) {
            y20 R = xt.f3961a.R();
            Context requireContext = soundFragmentSuperPass.requireContext();
            n86.d(requireContext, "requireContext()");
            R.b(requireContext, "transactionRelatedScreen", "soundScreen", soundFragmentSuperPass.j().f(superPass), false);
            ed1 l = hj1.l("report problem clicked v2", Long.MIN_VALUE, "type", "activationScreenTicketingProblemsV2");
            l.a("problemSource", "soundScreen");
            gi1.d(l, superPass);
            ui1.m0(l);
            return true;
        } else if (menuItem.getItemId() != R.id.view_trip_receipt) {
            return true;
        } else {
            n86.j("syncActivationsAndFetchSuperPassTripReceipts: 3 activation time = ", Long.valueOf(superPass.getLastActivationTimeStamp()));
            ed1 ed1 = new ed1("view trip receipt from menu clicked", Long.MIN_VALUE);
            ed1.a("source", "sourceActiveSuperPassSoundScreen");
            gi1.f(ed1, superPass);
            ui1.m0(ed1);
            Context context = soundFragmentSuperPass.getContext();
            if (context == null) {
                return true;
            }
            SuperPassBookingSummaryActivity.t0(superPass.getSuperPassProperties().getPassId(), superPass.getSuperPassProperties().getProductSubType(), superPass.getLastActivationTimeStamp(), "sourceActiveSuperPassVisualValidationScreen", context);
            return true;
        }
    }
}
