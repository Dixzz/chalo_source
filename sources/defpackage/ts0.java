package defpackage;

import android.content.DialogInterface;
import app.zophop.ui.fragments.UserProofUploadFragment;

/* renamed from: ts0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class ts0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ UserProofUploadFragment f;

    public /* synthetic */ ts0(UserProofUploadFragment userProofUploadFragment) {
        this.f = userProofUploadFragment;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        UserProofUploadFragment userProofUploadFragment = this.f;
        int i2 = UserProofUploadFragment.m;
        n86.e(userProofUploadFragment, "this$0");
        userProofUploadFragment.l(true);
        dialogInterface.dismiss();
    }
}
