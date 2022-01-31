package defpackage;

import android.app.Activity;
import android.view.View;
import app.zophop.models.Stop;
import app.zophop.ui.activities.TripPlanningActivity;
import app.zophop.ui.activities.UniversalPickerActivity;
import java.util.Objects;

/* renamed from: yk0  reason: default package */
/* compiled from: UniversalSearchAdapter */
public class yk0 implements View.OnClickListener {
    public final /* synthetic */ Stop f;
    public final /* synthetic */ wk0 g;

    public yk0(wk0 wk0, Stop stop) {
        this.g = wk0;
        this.f = stop;
    }

    public void onClick(View view) {
        wk0 wk0 = this.g;
        Stop stop = this.f;
        Objects.requireNonNull(wk0);
        ed1 ed1 = new ed1("universal item clicked", Long.MIN_VALUE);
        ed1.a("stop", stop.getName());
        ed1.a("stopId", stop.getId());
        UniversalPickerActivity.l0(ed1, "stop", true, wk0.h, false, false);
        xt.f3961a.b0().d(stop);
        TripPlanningActivity.m0((Activity) wk0.f, null, new mf1(stop.getName(), stop.getLatLong()), false);
    }
}
