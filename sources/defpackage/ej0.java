package defpackage;

import android.app.Activity;
import android.view.View;
import app.zophop.models.Favourites.RouteStoreType;
import app.zophop.ui.activities.TripPlanningActivity;
import app.zophop.ui.activities.UniversalPickerActivity;
import com.google.firebase.analytics.FirebaseAnalytics;

/* renamed from: ej0  reason: default package */
/* compiled from: FavoriteListAdapter */
public class ej0 implements View.OnClickListener {
    public final /* synthetic */ mf1 f;
    public final /* synthetic */ bj0 g;

    public ej0(bj0 bj0, mf1 mf1) {
        this.g = bj0;
        this.f = mf1;
    }

    public void onClick(View view) {
        xt.f3961a.Y().a(this.f, System.currentTimeMillis());
        if (this.g.n.equals(RouteStoreType.RECENT)) {
            ed1 ed1 = new ed1("universal item clicked", Long.MIN_VALUE);
            ed1.a(FirebaseAnalytics.Param.LOCATION, this.f.c);
            UniversalPickerActivity.l0(ed1, FirebaseAnalytics.Param.LOCATION, vn.K0(this.g.g), null, true, false);
        }
        TripPlanningActivity.m0((Activity) this.g.g, null, this.f, false);
    }
}
