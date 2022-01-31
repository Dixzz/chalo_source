package defpackage;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import app.zophop.models.Stop;
import app.zophop.models.TransitMode;
import app.zophop.ui.activities.RouteDetailsActivity;
import app.zophop.ui.activities.TripDetailsActivity;
import app.zophop.ui.fragments.ResultFragment;
import app.zophop.ui.views.SummaryView;
import com.google.gson.Gson;
import java.util.Iterator;
import java.util.Objects;
import zophop.models.Itinerary;
import zophop.models.Leg;
import zophop.models.LegMode;

/* renamed from: aw0  reason: default package */
/* compiled from: ResultFragment */
public class aw0 implements View.OnClickListener {
    public final /* synthetic */ String f;
    public final /* synthetic */ String g;
    public final /* synthetic */ SummaryView.a h;
    public final /* synthetic */ Itinerary i;
    public final /* synthetic */ ResultFragment j;

    public aw0(ResultFragment resultFragment, String str, String str2, SummaryView.a aVar, Itinerary itinerary) {
        this.j = resultFragment;
        this.f = str;
        this.g = str2;
        this.h = aVar;
        this.i = itinerary;
    }

    public void onClick(View view) {
        ed1 ed1 = new ed1("trip planner result clicked", Long.MAX_VALUE);
        ed1.a("resultType", this.f);
        ed1.a("Recommended", this.g);
        ed1.a("isEtaVisible", String.valueOf(this.h.o()));
        jz5.b().g(ed1);
        Iterator<Leg> it = this.i.legs.iterator();
        Leg leg = null;
        int i2 = 0;
        int i3 = 0;
        while (it.hasNext()) {
            Leg next = it.next();
            if (next.mode.equals(LegMode.WALK) || next.mode.equals(LegMode.AUTO) || !next.mode.equals(LegMode.BUS)) {
                i3++;
            } else {
                i2++;
                leg = next;
            }
        }
        if (i2 == 1 && i3 == 0) {
            Stop l = vn.l(leg.first_stop);
            Stop l2 = vn.l(leg.last_stop);
            TransitMode transitMode = TransitMode.getTransitMode(leg.mode.toString());
            Activity activity = this.j.getActivity();
            Intent r0 = RouteDetailsActivity.r0(activity, leg.route_id, l, l2, transitMode, "trip results");
            r0.putExtra("isBoardingStopBasedOnLocation", false);
            activity.startActivity(r0);
            return;
        }
        Intent intent = new Intent(this.j.getActivity(), TripDetailsActivity.class);
        int indexOf = this.j.f.itineraries.indexOf(this.i);
        intent.putExtra("trip_details:response", new Gson().toJson(this.i));
        intent.putExtra("extra:tag", this.g);
        ResultFragment resultFragment = this.j;
        String str = this.f;
        Objects.requireNonNull(resultFragment);
        if (indexOf == -1) {
            b00 b00 = b00.f358a;
            c00 a2 = b00.a();
            StringBuilder i0 = hj1.i0("trip request=>");
            i0.append(new Gson().toJson(resultFragment.i));
            i0.append(" result type=> ");
            i0.append(str);
            a2.a("IOBE", i0.toString());
        }
        this.j.startActivity(intent);
    }
}
