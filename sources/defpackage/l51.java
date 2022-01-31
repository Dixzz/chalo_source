package defpackage;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import app.zophop.ui.fragments.superpassPurchase.SuperPassUserProofUploadFragment;

/* renamed from: l51  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class l51 implements DialogInterface.OnClickListener {
    public final /* synthetic */ SuperPassUserProofUploadFragment f;
    public final /* synthetic */ ve g;

    public /* synthetic */ l51(SuperPassUserProofUploadFragment superPassUserProofUploadFragment, ve veVar) {
        this.f = superPassUserProofUploadFragment;
        this.g = veVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        SuperPassUserProofUploadFragment superPassUserProofUploadFragment = this.f;
        ve veVar = this.g;
        int i2 = SuperPassUserProofUploadFragment.m;
        n86.e(superPassUserProofUploadFragment, "this$0");
        n86.e(veVar, "$it");
        superPassUserProofUploadFragment.l(false);
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", veVar.getPackageName(), null));
        superPassUserProofUploadFragment.startActivityForResult(intent, 101);
    }
}
