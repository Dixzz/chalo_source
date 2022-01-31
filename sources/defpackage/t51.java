package defpackage;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import app.zophop.ui.fragments.superpassPurchase.SuperPassUserProofsOverviewFragment;

/* renamed from: t51  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class t51 implements DialogInterface.OnClickListener {
    public final /* synthetic */ SuperPassUserProofsOverviewFragment f;
    public final /* synthetic */ ve g;

    public /* synthetic */ t51(SuperPassUserProofsOverviewFragment superPassUserProofsOverviewFragment, ve veVar) {
        this.f = superPassUserProofsOverviewFragment;
        this.g = veVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        SuperPassUserProofsOverviewFragment superPassUserProofsOverviewFragment = this.f;
        ve veVar = this.g;
        int i2 = SuperPassUserProofsOverviewFragment.m;
        n86.e(superPassUserProofsOverviewFragment, "this$0");
        n86.e(veVar, "$it");
        superPassUserProofsOverviewFragment.l(false);
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", veVar.getPackageName(), null));
        superPassUserProofsOverviewFragment.startActivityForResult(intent, 101);
    }
}
