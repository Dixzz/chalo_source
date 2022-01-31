package defpackage;

import android.content.DialogInterface;
import app.zophop.ui.fragments.superpassPurchase.SuperPassUserProofUploadFragment;

/* renamed from: m51  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class m51 implements DialogInterface.OnClickListener {
    public final /* synthetic */ SuperPassUserProofUploadFragment f;

    public /* synthetic */ m51(SuperPassUserProofUploadFragment superPassUserProofUploadFragment) {
        this.f = superPassUserProofUploadFragment;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        SuperPassUserProofUploadFragment superPassUserProofUploadFragment = this.f;
        int i2 = SuperPassUserProofUploadFragment.m;
        n86.e(superPassUserProofUploadFragment, "this$0");
        superPassUserProofUploadFragment.l(true);
        dialogInterface.dismiss();
    }
}
