package defpackage;

import android.view.View;
import app.zophop.models.mTicketing.BookableSuperPassConfiguration;
import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.ui.fragments.superPassHistory.SuperPassBookingSummaryFragment;

/* renamed from: qz0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class qz0 implements View.OnClickListener {
    public final /* synthetic */ SuperPassBookingSummaryFragment f;
    public final /* synthetic */ BookableSuperPassConfiguration g;
    public final /* synthetic */ SuperPass h;
    public final /* synthetic */ hm0 i;

    public /* synthetic */ qz0(SuperPassBookingSummaryFragment superPassBookingSummaryFragment, BookableSuperPassConfiguration bookableSuperPassConfiguration, SuperPass superPass, hm0 hm0) {
        this.f = superPassBookingSummaryFragment;
        this.g = bookableSuperPassConfiguration;
        this.h = superPass;
        this.i = hm0;
    }

    public final void onClick(View view) {
        SuperPassBookingSummaryFragment superPassBookingSummaryFragment = this.f;
        BookableSuperPassConfiguration bookableSuperPassConfiguration = this.g;
        SuperPass superPass = this.h;
        hm0 hm0 = this.i;
        int i2 = SuperPassBookingSummaryFragment.j;
        n86.e(superPassBookingSummaryFragment, "this$0");
        n86.e(superPass, "$lSuperPass");
        n86.c(bookableSuperPassConfiguration);
        superPassBookingSummaryFragment.k(bookableSuperPassConfiguration, superPass);
        hm0.dismiss();
    }
}
