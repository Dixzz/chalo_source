package defpackage;

import android.view.View;
import app.zophop.R;
import app.zophop.models.Stop;
import app.zophop.ui.activities.TripPlanningStopBasedActivity;
import com.google.firebase.analytics.FirebaseAnalytics;

/* renamed from: jg0  reason: default package */
/* compiled from: TripPlanningStopBasedActivity */
public class jg0 implements View.OnClickListener {
    public final /* synthetic */ TripPlanningStopBasedActivity f;

    public jg0(TripPlanningStopBasedActivity tripPlanningStopBasedActivity) {
        this.f = tripPlanningStopBasedActivity;
    }

    public void onClick(View view) {
        String str;
        String str2;
        TripPlanningStopBasedActivity tripPlanningStopBasedActivity = this.f;
        ed1 ed1 = new ed1("tripPlannerStopBased swap button clicked", Long.MIN_VALUE);
        if (tripPlanningStopBasedActivity._inputFrom.getText() != null) {
            str = tripPlanningStopBasedActivity._inputFrom.getText().toString().trim();
        } else {
            str = "";
        }
        if (tripPlanningStopBasedActivity._inputTo.getText() != null) {
            str2 = tripPlanningStopBasedActivity._inputTo.getText().toString().trim();
        } else {
            str2 = "";
        }
        ed1.a("city", xt.f3961a.k().d().getName());
        ed1.a(FirebaseAnalytics.Param.ORIGIN, str);
        hj1.K0(ed1, FirebaseAnalytics.Param.DESTINATION, str2, ed1);
        TripPlanningStopBasedActivity tripPlanningStopBasedActivity2 = this.f;
        String trim = tripPlanningStopBasedActivity2._inputFrom.getText().toString().trim();
        String trim2 = tripPlanningStopBasedActivity2._inputTo.getText().toString().trim();
        if (trim.equals("")) {
            tripPlanningStopBasedActivity2.x = false;
            tripPlanningStopBasedActivity2._inputTo.setText("");
            tripPlanningStopBasedActivity2._inputTo.setHint(tripPlanningStopBasedActivity2.getString(R.string.hint_end_stop));
            tripPlanningStopBasedActivity2._inputFrom.setText(trim2);
            tripPlanningStopBasedActivity2.o = tripPlanningStopBasedActivity2.p;
            tripPlanningStopBasedActivity2.p = null;
        } else if (trim2.equals("")) {
            tripPlanningStopBasedActivity2.w = false;
            tripPlanningStopBasedActivity2._inputFrom.setText("");
            tripPlanningStopBasedActivity2._inputFrom.setHint(tripPlanningStopBasedActivity2.getString(R.string.hint_start_stop));
            tripPlanningStopBasedActivity2._inputTo.setText(trim);
            tripPlanningStopBasedActivity2.p = tripPlanningStopBasedActivity2.o;
            tripPlanningStopBasedActivity2.o = null;
        } else {
            tripPlanningStopBasedActivity2.x = false;
            tripPlanningStopBasedActivity2.w = false;
            tripPlanningStopBasedActivity2._inputTo.setText(trim);
            tripPlanningStopBasedActivity2._inputFrom.setText(trim2);
            Stop stop = tripPlanningStopBasedActivity2.p;
            tripPlanningStopBasedActivity2.p = tripPlanningStopBasedActivity2.o;
            tripPlanningStopBasedActivity2.o = stop;
            tripPlanningStopBasedActivity2.u0();
        }
    }
}
