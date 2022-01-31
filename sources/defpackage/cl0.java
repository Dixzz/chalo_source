package defpackage;

import android.app.Activity;
import android.view.View;
import app.zophop.ui.activities.TripPlanningActivity;
import app.zophop.ui.activities.UniversalPickerActivity;
import com.google.firebase.analytics.FirebaseAnalytics;

/* renamed from: cl0  reason: default package */
/* compiled from: UniversalSearchAdapter */
public class cl0 implements View.OnClickListener {
    public final /* synthetic */ mf1 f;
    public final /* synthetic */ wk0 g;

    public cl0(wk0 wk0, mf1 mf1) {
        this.g = wk0;
        this.f = mf1;
    }

    public void onClick(View view) {
        ed1 ed1 = new ed1("universal item clicked", Long.MIN_VALUE);
        ed1.a(FirebaseAnalytics.Param.LOCATION, this.f.c);
        UniversalPickerActivity.l0(ed1, FirebaseAnalytics.Param.LOCATION, true, this.g.h, false, false);
        TripPlanningActivity.m0((Activity) this.g.f, null, this.f, false);
    }
}
