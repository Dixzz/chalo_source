package defpackage;

import android.content.Intent;
import android.view.View;
import app.zophop.models.TransitMode;
import app.zophop.ui.activities.NearbyStopsActivity;
import app.zophop.ui.fragments.HomeScreenMainFragment;

/* renamed from: np0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class np0 implements View.OnClickListener {
    public final /* synthetic */ HomeScreenMainFragment f;

    public /* synthetic */ np0(HomeScreenMainFragment homeScreenMainFragment) {
        this.f = homeScreenMainFragment;
    }

    public final void onClick(View view) {
        HomeScreenMainFragment homeScreenMainFragment = this.f;
        HomeScreenMainFragment.a aVar = HomeScreenMainFragment.v;
        n86.e(homeScreenMainFragment, "this$0");
        ui1.m0(new ed1("nearby stops more clicked", 86400000));
        TransitMode transitMode = TransitMode.bus;
        ve activity = homeScreenMainFragment.c();
        Float f2 = NearbyStopsActivity.Y;
        Intent intent = new Intent(activity, NearbyStopsActivity.class);
        intent.putExtra("nearby:mode", transitMode.toString());
        homeScreenMainFragment.startActivity(intent);
    }
}
