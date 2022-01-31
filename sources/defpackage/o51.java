package defpackage;

import android.content.DialogInterface;
import app.zophop.ui.fragments.superpassPurchase.SuperPassUserProofsOverviewFragment;

/* renamed from: o51  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class o51 implements DialogInterface.OnClickListener {
    public final /* synthetic */ SuperPassUserProofsOverviewFragment f;

    public /* synthetic */ o51(SuperPassUserProofsOverviewFragment superPassUserProofsOverviewFragment) {
        this.f = superPassUserProofsOverviewFragment;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        SuperPassUserProofsOverviewFragment superPassUserProofsOverviewFragment = this.f;
        int i2 = SuperPassUserProofsOverviewFragment.m;
        n86.e(superPassUserProofsOverviewFragment, "this$0");
        superPassUserProofsOverviewFragment.l(true);
        dialogInterface.dismiss();
    }
}
