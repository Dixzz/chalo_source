package defpackage;

import app.zophop.models.Stop;
import app.zophop.ui.activities.TripPlanningStopBasedActivity;

/* renamed from: rg0  reason: default package */
/* compiled from: TripPlanningStopBasedActivity */
public class rg0 implements ci1<Stop> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TripPlanningStopBasedActivity f3078a;

    public rg0(TripPlanningStopBasedActivity tripPlanningStopBasedActivity) {
        this.f3078a = tripPlanningStopBasedActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.ci1
    public void a(Stop stop) {
        Stop stop2 = stop;
        this.f3078a.x = false;
        String name = stop2.getName();
        this.f3078a._inputTo.setText(name);
        this.f3078a._inputTo.setSelection(name.length());
        TripPlanningStopBasedActivity tripPlanningStopBasedActivity = this.f3078a;
        tripPlanningStopBasedActivity.p = stop2;
        tripPlanningStopBasedActivity._clearToStopImageView.setVisibility(8);
        if (this.f3078a.k0()) {
            this.f3078a.u0();
            return;
        }
        TripPlanningStopBasedActivity tripPlanningStopBasedActivity2 = this.f3078a;
        tripPlanningStopBasedActivity2.l0(tripPlanningStopBasedActivity2._inputFrom);
    }
}
