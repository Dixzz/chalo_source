package defpackage;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import app.zophop.ui.fragments.UserProofUploadFragment;

/* renamed from: ms0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class ms0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ UserProofUploadFragment f;
    public final /* synthetic */ ve g;

    public /* synthetic */ ms0(UserProofUploadFragment userProofUploadFragment, ve veVar) {
        this.f = userProofUploadFragment;
        this.g = veVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        UserProofUploadFragment userProofUploadFragment = this.f;
        ve veVar = this.g;
        int i2 = UserProofUploadFragment.m;
        n86.e(userProofUploadFragment, "this$0");
        n86.e(veVar, "$it");
        userProofUploadFragment.l(false);
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", veVar.getPackageName(), null));
        userProofUploadFragment.startActivityForResult(intent, 101);
    }
}
