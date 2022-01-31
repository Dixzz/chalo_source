package defpackage;

import android.app.AlertDialog;
import app.zophop.R;
import app.zophop.ui.fragments.UserProofsOverviewFragment;

/* renamed from: at0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class at0 implements q {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserProofsOverviewFragment f328a;

    public /* synthetic */ at0(UserProofsOverviewFragment userProofsOverviewFragment) {
        this.f328a = userProofsOverviewFragment;
    }

    @Override // defpackage.q
    public final void a(Object obj) {
        UserProofsOverviewFragment userProofsOverviewFragment = this.f328a;
        Boolean bool = (Boolean) obj;
        int i = UserProofsOverviewFragment.m;
        n86.e(userProofsOverviewFragment, "this$0");
        n86.d(bool, "lIsPermissionGranted");
        if (bool.booleanValue()) {
            userProofsOverviewFragment.k();
            return;
        }
        ve activity = userProofsOverviewFragment.c();
        n86.c(activity);
        if (!t4.d(activity, "android.permission.CAMERA")) {
            String string = userProofsOverviewFragment.getString(R.string.camera_prompt);
            n86.d(string, "getString(R.string.camera_prompt)");
            ve activity2 = userProofsOverviewFragment.c();
            if (activity2 != null) {
                AlertDialog.Builder builder = new AlertDialog.Builder(activity2);
                builder.setMessage(string).setCancelable(true).setPositiveButton(userProofsOverviewFragment.getString(R.string.settings), new ys0(userProofsOverviewFragment, activity2)).setNegativeButton(userProofsOverviewFragment.getString(R.string.cancel), new vs0(userProofsOverviewFragment));
                builder.create().show();
            }
        }
    }
}
