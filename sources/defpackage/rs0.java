package defpackage;

import android.app.AlertDialog;
import app.zophop.R;
import app.zophop.ui.fragments.UserProofUploadFragment;

/* renamed from: rs0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class rs0 implements q {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserProofUploadFragment f3124a;

    public /* synthetic */ rs0(UserProofUploadFragment userProofUploadFragment) {
        this.f3124a = userProofUploadFragment;
    }

    @Override // defpackage.q
    public final void a(Object obj) {
        UserProofUploadFragment userProofUploadFragment = this.f3124a;
        Boolean bool = (Boolean) obj;
        int i = UserProofUploadFragment.m;
        n86.e(userProofUploadFragment, "this$0");
        n86.d(bool, "lIsPermissionGranted");
        if (bool.booleanValue()) {
            userProofUploadFragment.k();
            return;
        }
        ve activity = userProofUploadFragment.c();
        n86.c(activity);
        if (!t4.d(activity, "android.permission.CAMERA")) {
            String string = userProofUploadFragment.getString(R.string.camera_prompt);
            n86.d(string, "getString(R.string.camera_prompt)");
            ve activity2 = userProofUploadFragment.c();
            if (activity2 != null) {
                AlertDialog.Builder builder = new AlertDialog.Builder(activity2);
                builder.setMessage(string).setCancelable(true).setPositiveButton(userProofUploadFragment.getString(R.string.settings), new ms0(userProofUploadFragment, activity2)).setNegativeButton(userProofUploadFragment.getString(R.string.cancel), new ts0(userProofUploadFragment));
                builder.create().show();
            }
        }
    }
}
