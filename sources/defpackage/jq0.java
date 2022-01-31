package defpackage;

import android.content.Intent;
import android.view.View;
import app.zophop.R;
import app.zophop.models.RouteWithoutTimings;
import app.zophop.models.Stop;
import app.zophop.ui.activities.PickStopFilterableActivity;
import app.zophop.ui.fragments.HomeScreenMainFragment;
import com.google.gson.Gson;

/* renamed from: jq0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class jq0 implements View.OnClickListener {
    public final /* synthetic */ HomeScreenMainFragment f;
    public final /* synthetic */ RouteWithoutTimings g;
    public final /* synthetic */ Stop h;

    public /* synthetic */ jq0(HomeScreenMainFragment homeScreenMainFragment, RouteWithoutTimings routeWithoutTimings, Stop stop) {
        this.f = homeScreenMainFragment;
        this.g = routeWithoutTimings;
        this.h = stop;
    }

    public final void onClick(View view) {
        HomeScreenMainFragment homeScreenMainFragment = this.f;
        RouteWithoutTimings routeWithoutTimings = this.g;
        Stop stop = this.h;
        HomeScreenMainFragment.a aVar = HomeScreenMainFragment.v;
        n86.e(homeScreenMainFragment, "this$0");
        Intent intent = new Intent(homeScreenMainFragment.c(), PickStopFilterableActivity.class);
        intent.putExtra("extra:search_copy", homeScreenMainFragment.getString(R.string.type_station_name));
        intent.putExtra("stop_list", new Gson().toJson(routeWithoutTimings == null ? null : routeWithoutTimings.getStopSequence()));
        if (stop != null) {
            intent.putExtra("mode", stop.getMode().toString());
            intent.putExtra("remove_till_stop", stop.getName());
        }
        homeScreenMainFragment.p.a(intent, null);
    }
}
