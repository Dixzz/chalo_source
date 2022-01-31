package defpackage;

import android.os.Build;
import android.view.View;
import android.widget.Toast;
import app.zophop.ui.fragments.UserProofUploadFragment;

/* renamed from: ns0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class ns0 implements View.OnClickListener {
    public final /* synthetic */ UserProofUploadFragment f;

    public /* synthetic */ ns0(UserProofUploadFragment userProofUploadFragment) {
        this.f = userProofUploadFragment;
    }

    public final void onClick(View view) {
        UserProofUploadFragment userProofUploadFragment = this.f;
        int i = UserProofUploadFragment.m;
        n86.e(userProofUploadFragment, "this$0");
        ed1 ed1 = new ed1("upload proof button clicked", Long.MIN_VALUE);
        userProofUploadFragment.i(ed1);
        ui1.m0(ed1);
        if (ui1.T(userProofUploadFragment.c(), "android.permission.CAMERA")) {
            userProofUploadFragment.k();
        } else if (Build.VERSION.SDK_INT >= 23) {
            r<String> rVar = userProofUploadFragment.j;
            if (rVar != null) {
                rVar.a("android.permission.CAMERA", null);
            } else {
                n86.l("requestCameraPermission");
                throw null;
            }
        } else {
            Toast.makeText(userProofUploadFragment.c(), "Please give camera permissions", 1).show();
        }
    }
}
