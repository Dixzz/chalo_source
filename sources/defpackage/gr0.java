package defpackage;

import android.content.Intent;
import android.view.View;
import app.zophop.ui.activities.HomeScreenMapActivity;
import app.zophop.ui.fragments.HomeScreenMainFragment;

/* renamed from: gr0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class gr0 implements View.OnClickListener {
    public final /* synthetic */ HomeScreenMainFragment f;

    public /* synthetic */ gr0(HomeScreenMainFragment homeScreenMainFragment) {
        this.f = homeScreenMainFragment;
    }

    public final void onClick(View view) {
        HomeScreenMainFragment homeScreenMainFragment = this.f;
        HomeScreenMainFragment.a aVar = HomeScreenMainFragment.v;
        n86.e(homeScreenMainFragment, "this$0");
        ui1.m0(new ed1("home screen map thumbnail clicked", Long.MIN_VALUE));
        Intent intent = new Intent(homeScreenMainFragment.getContext(), HomeScreenMapActivity.class);
        intent.setFlags(536870912);
        homeScreenMainFragment.startActivity(intent);
    }
}
