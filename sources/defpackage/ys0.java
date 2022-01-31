package defpackage;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import app.zophop.ui.fragments.UserProofsOverviewFragment;

/* renamed from: ys0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class ys0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ UserProofsOverviewFragment f;
    public final /* synthetic */ ve g;

    public /* synthetic */ ys0(UserProofsOverviewFragment userProofsOverviewFragment, ve veVar) {
        this.f = userProofsOverviewFragment;
        this.g = veVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        UserProofsOverviewFragment userProofsOverviewFragment = this.f;
        ve veVar = this.g;
        int i2 = UserProofsOverviewFragment.m;
        n86.e(userProofsOverviewFragment, "this$0");
        n86.e(veVar, "$it");
        userProofsOverviewFragment.l(false);
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", veVar.getPackageName(), null));
        userProofsOverviewFragment.startActivityForResult(intent, 101);
    }
}
