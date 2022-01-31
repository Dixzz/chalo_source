package defpackage;

import android.content.DialogInterface;
import app.zophop.ui.fragments.UserProofsOverviewFragment;

/* renamed from: vs0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class vs0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ UserProofsOverviewFragment f;

    public /* synthetic */ vs0(UserProofsOverviewFragment userProofsOverviewFragment) {
        this.f = userProofsOverviewFragment;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        UserProofsOverviewFragment userProofsOverviewFragment = this.f;
        int i2 = UserProofsOverviewFragment.m;
        n86.e(userProofsOverviewFragment, "this$0");
        userProofsOverviewFragment.l(true);
        dialogInterface.dismiss();
    }
}
