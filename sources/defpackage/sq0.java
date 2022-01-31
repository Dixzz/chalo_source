package defpackage;

import android.content.Intent;
import android.view.View;
import app.zophop.R;
import app.zophop.ui.activities.TripPlanningStopBasedActivity;
import app.zophop.ui.activities.UniversalPickerActivity;
import app.zophop.ui.fragments.HomeScreenMainFragment;

/* renamed from: sq0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class sq0 implements View.OnClickListener {
    public final /* synthetic */ HomeScreenMainFragment f;

    public /* synthetic */ sq0(HomeScreenMainFragment homeScreenMainFragment) {
        this.f = homeScreenMainFragment;
    }

    public final void onClick(View view) {
        HomeScreenMainFragment homeScreenMainFragment = this.f;
        HomeScreenMainFragment.a aVar = HomeScreenMainFragment.v;
        n86.e(homeScreenMainFragment, "this$0");
        ui1.m0(new ed1("home screen search bar clicked", Long.MIN_VALUE));
        if (ui1.e0()) {
            TripPlanningStopBasedActivity.r0(homeScreenMainFragment.c(), null, null, "homeScreen tripPlanner hook");
            return;
        }
        Intent intent = new Intent(homeScreenMainFragment.c(), UniversalPickerActivity.class);
        intent.putExtra("extra:search_copy", homeScreenMainFragment.getString(R.string.search_route_copy));
        intent.putExtra("extra:source", "Home Screen");
        homeScreenMainFragment.startActivity(intent);
    }
}
