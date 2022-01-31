package defpackage;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import app.zophop.ui.activities.HomeScreenMapActivity;

/* renamed from: n90  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class n90 implements DialogInterface.OnClickListener {
    public final /* synthetic */ HomeScreenMapActivity f;

    public /* synthetic */ n90(HomeScreenMapActivity homeScreenMapActivity) {
        this.f = homeScreenMapActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        HomeScreenMapActivity homeScreenMapActivity = this.f;
        int i2 = HomeScreenMapActivity.o;
        n86.e(homeScreenMapActivity, "this$0");
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", homeScreenMapActivity.getPackageName(), null));
        homeScreenMapActivity.k.a(intent, null);
    }
}
