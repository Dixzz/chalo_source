package defpackage;

import android.view.View;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.models.mTicketing.superPass.SuperPassSubType;
import app.zophop.ui.fragments.superPassHistory.SuperPassBookingSummaryFragment;

/* renamed from: rz0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class rz0 implements View.OnClickListener {
    public final /* synthetic */ SuperPassBookingSummaryFragment f;
    public final /* synthetic */ SuperPass g;

    public /* synthetic */ rz0(SuperPassBookingSummaryFragment superPassBookingSummaryFragment, SuperPass superPass) {
        this.f = superPassBookingSummaryFragment;
        this.g = superPass;
    }

    public final void onClick(View view) {
        SuperPassBookingSummaryFragment superPassBookingSummaryFragment = this.f;
        SuperPass superPass = this.g;
        int i = SuperPassBookingSummaryFragment.j;
        n86.e(superPassBookingSummaryFragment, "this$0");
        n86.e(superPass, "$lSuperPass");
        ed1 ed1 = new ed1("view trip history btn clicked", Long.MIN_VALUE);
        superPassBookingSummaryFragment.i(ed1, superPass);
        ui1.m0(ed1);
        String passId = superPass.getSuperPassProperties().getPassId();
        SuperPassSubType superPassSubType = superPassBookingSummaryFragment.j().g;
        n86.c(superPassSubType);
        i01 i01 = new i01("sourceBookingSummarySuperPassActivity", passId, superPassSubType, null);
        n86.d(i01, "actionSuperPassBookingSu…sSubType!!\n\n            )");
        vh1 vh1 = vh1.f3649a;
        n86.f(superPassBookingSummaryFragment, "$this$findNavController");
        NavController d = NavHostFragment.d(superPassBookingSummaryFragment);
        n86.b(d, "NavHostFragment.findNavController(this)");
        vh1.a(d, i01);
    }
}
