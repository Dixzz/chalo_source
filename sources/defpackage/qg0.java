package defpackage;

import app.zophop.models.Stop;
import app.zophop.ui.activities.TripPlanningStopBasedActivity;

/* renamed from: qg0  reason: default package */
/* compiled from: TripPlanningStopBasedActivity */
public class qg0 implements ci1<Stop> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TripPlanningStopBasedActivity f2941a;

    public qg0(TripPlanningStopBasedActivity tripPlanningStopBasedActivity) {
        this.f2941a = tripPlanningStopBasedActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.ci1
    public void a(Stop stop) {
        Stop stop2 = stop;
        String name = stop2.getName();
        TripPlanningStopBasedActivity tripPlanningStopBasedActivity = this.f2941a;
        tripPlanningStopBasedActivity.w = false;
        tripPlanningStopBasedActivity._inputFrom.setText(name);
        this.f2941a._inputFrom.setSelection(name.length());
        TripPlanningStopBasedActivity tripPlanningStopBasedActivity2 = this.f2941a;
        tripPlanningStopBasedActivity2.o = stop2;
        tripPlanningStopBasedActivity2._clearFromStopImageView.setVisibility(8);
        if (this.f2941a.k0()) {
            this.f2941a.u0();
            return;
        }
        TripPlanningStopBasedActivity tripPlanningStopBasedActivity3 = this.f2941a;
        tripPlanningStopBasedActivity3.l0(tripPlanningStopBasedActivity3._inputTo);
    }
}
