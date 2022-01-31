package defpackage;

import android.app.Activity;
import android.util.Pair;
import android.view.View;
import app.zophop.models.Stop;
import app.zophop.ui.activities.TripPlanningActivity;
import java.util.Objects;

/* renamed from: bl0  reason: default package */
/* compiled from: UniversalSearchAdapter */
public class bl0 implements View.OnClickListener {
    public final /* synthetic */ Pair f;
    public final /* synthetic */ wk0 g;

    public bl0(wk0 wk0, Pair pair) {
        this.g = wk0;
        this.f = pair;
    }

    public void onClick(View view) {
        wk0 wk0 = this.g;
        Pair pair = this.f;
        Objects.requireNonNull(wk0);
        Stop stop = (Stop) pair.first;
        Stop stop2 = (Stop) pair.second;
        mf1 mf1 = new mf1(stop.getName(), stop.getLatLong());
        mf1 mf12 = new mf1(stop2.getName(), stop2.getLatLong());
        TripPlanningActivity.m0((Activity) wk0.f, mf1, mf12, false);
        wk0.e(stop.getName(), stop2.getName(), wk0.h);
        xt.f3961a.X().a(mf1, mf12);
    }
}
