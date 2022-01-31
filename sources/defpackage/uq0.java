package defpackage;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import app.zophop.ui.fragments.HomeScreenMainFragment;

/* renamed from: uq0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class uq0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ Context f;
    public final /* synthetic */ HomeScreenMainFragment g;

    public /* synthetic */ uq0(Context context, HomeScreenMainFragment homeScreenMainFragment) {
        this.f = context;
        this.g = homeScreenMainFragment;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Context context = this.f;
        HomeScreenMainFragment homeScreenMainFragment = this.g;
        HomeScreenMainFragment.a aVar = HomeScreenMainFragment.v;
        n86.e(context, "$it");
        n86.e(homeScreenMainFragment, "this$0");
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", context.getPackageName(), null));
        homeScreenMainFragment.m.a(intent, null);
    }
}
