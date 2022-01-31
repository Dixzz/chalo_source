package defpackage;

import app.zophop.models.UniversalSearchItem;
import app.zophop.ui.activities.TripPlanningStopBasedActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* renamed from: ng0  reason: default package */
/* compiled from: TripPlanningStopBasedActivity */
public class ng0 implements Runnable {
    public final /* synthetic */ String f;
    public final /* synthetic */ boolean g;
    public final /* synthetic */ TripPlanningStopBasedActivity h;

    public ng0(TripPlanningStopBasedActivity tripPlanningStopBasedActivity, String str, boolean z) {
        this.h = tripPlanningStopBasedActivity;
        this.f = str;
        this.g = z;
    }

    public void run() {
        TripPlanningStopBasedActivity tripPlanningStopBasedActivity = this.h;
        String str = this.f;
        boolean z = this.g;
        String str2 = TripPlanningStopBasedActivity.z;
        tripPlanningStopBasedActivity.p0();
        if (vn.K0(tripPlanningStopBasedActivity)) {
            String uuid = UUID.randomUUID().toString();
            if (z) {
                tripPlanningStopBasedActivity.k = uuid;
            } else {
                tripPlanningStopBasedActivity.l = uuid;
            }
            List<UniversalSearchItem> e = xt.f3961a.j0().e(str, "universalSearch", "stops", uuid);
            if (((ArrayList) e).size() != 0) {
                tk0 tk0 = tripPlanningStopBasedActivity.t;
                tk0.g.j(e, str);
                tk0.h = str;
                tk0.notifyDataSetChanged();
            } else {
                tripPlanningStopBasedActivity.t.a();
            }
            tripPlanningStopBasedActivity.t.e(true);
            return;
        }
        List<UniversalSearchItem> f2 = xt.f3961a.j0().f(str);
        tk0 tk02 = tripPlanningStopBasedActivity.t;
        tk02.g.j(f2, str);
        tk02.h = str;
        tk02.notifyDataSetChanged();
        tripPlanningStopBasedActivity.o0(z);
        tripPlanningStopBasedActivity.t.e(false);
    }
}
