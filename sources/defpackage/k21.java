package defpackage;

import android.content.Context;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import app.zophop.R;
import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.models.mTicketing.superPass.SuperPassSubType;
import app.zophop.ui.fragments.superPassValidation.SoundVerificationFragmentSuperPass;

/* renamed from: k21  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class k21 implements Toolbar.OnMenuItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SoundVerificationFragmentSuperPass f2012a;
    public final /* synthetic */ SuperPass b;

    public /* synthetic */ k21(SoundVerificationFragmentSuperPass soundVerificationFragmentSuperPass, SuperPass superPass) {
        this.f2012a = soundVerificationFragmentSuperPass;
        this.b = superPass;
    }

    @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        SoundVerificationFragmentSuperPass soundVerificationFragmentSuperPass = this.f2012a;
        SuperPass superPass = this.b;
        SoundVerificationFragmentSuperPass.a aVar = SoundVerificationFragmentSuperPass.i;
        n86.e(soundVerificationFragmentSuperPass, "this$0");
        n86.e(superPass, "$lSuperPass");
        if (menuItem.getItemId() != R.id.report_problem_menu) {
            return true;
        }
        y20 R = xt.f3961a.R();
        Context requireContext = soundVerificationFragmentSuperPass.requireContext();
        n86.d(requireContext, "requireContext()");
        R.b(requireContext, "transactionRelatedScreen", "soundVerificationStatusScreen", soundVerificationFragmentSuperPass.f().f(superPass), false);
        SuperPassSubType superPassSubType = soundVerificationFragmentSuperPass.f().f;
        String str = soundVerificationFragmentSuperPass.f().e;
        ed1 l = hj1.l("report problem clicked v2", Long.MIN_VALUE, "type", "activationScreenTicketingProblemsV2");
        l.a("problemSource", "soundVerificationStatusScreen");
        n86.e(l, "lEvent");
        n86.e(superPassSubType, "superPassSubType");
        n86.e(str, "superPassId");
        hj1.I0(l, "isSuperPass", Boolean.TRUE, superPassSubType, "productSubType");
        l.a("passId", str);
        ui1.m0(l);
        return true;
    }
}
