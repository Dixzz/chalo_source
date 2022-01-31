package defpackage;

import android.view.View;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.ui.activities.TripPlanningActivity;
import com.google.firebase.analytics.FirebaseAnalytics;

/* renamed from: hg0  reason: default package */
/* compiled from: TripPlanningActivity */
public class hg0 implements View.OnClickListener {
    public final /* synthetic */ TripPlanningActivity f;

    public hg0(TripPlanningActivity tripPlanningActivity) {
        this.f = tripPlanningActivity;
    }

    public void onClick(View view) {
        TripPlanningActivity tripPlanningActivity = this.f;
        ed1 ed1 = new ed1("tripPlanner swap button clicked", Long.MIN_VALUE);
        View findViewById = tripPlanningActivity._inputForm.findViewById(R.id.input_from);
        View findViewById2 = tripPlanningActivity._inputForm.findViewById(R.id.input_to);
        String trim = ((TextView) findViewById.findViewById(R.id.header_title)).getText().toString().trim();
        String trim2 = ((TextView) findViewById2.findViewById(R.id.header_title)).getText().toString().trim();
        ed1.a("city", xt.f3961a.k().d().getName());
        ed1.a(FirebaseAnalytics.Param.ORIGIN, trim);
        hj1.K0(ed1, FirebaseAnalytics.Param.DESTINATION, trim2, ed1);
        TripPlanningActivity tripPlanningActivity2 = this.f;
        View findViewById3 = tripPlanningActivity2._inputForm.findViewById(R.id.input_from);
        View findViewById4 = tripPlanningActivity2._inputForm.findViewById(R.id.input_to);
        TextView textView = (TextView) findViewById3.findViewById(R.id.header_title);
        TextView textView2 = (TextView) findViewById4.findViewById(R.id.header_title);
        String trim3 = textView.getText().toString().trim();
        String trim4 = textView2.getText().toString().trim();
        if (trim3.equals("")) {
            textView2.setText("");
            textView2.setHint(tripPlanningActivity2.getString(R.string.enter_destination_location));
            textView.setText(trim4);
            tripPlanningActivity2.k = tripPlanningActivity2.l;
            tripPlanningActivity2.l = null;
        } else if (trim4.equals("")) {
            textView.setText("");
            textView.setHint(tripPlanningActivity2.getString(R.string.enter_origin_location));
            textView2.setText(trim3);
            tripPlanningActivity2.l = tripPlanningActivity2.k;
            tripPlanningActivity2.k = null;
        } else {
            mf1 mf1 = tripPlanningActivity2.k;
            textView2.setText(trim3);
            textView.setText(trim4);
            tripPlanningActivity2.k = tripPlanningActivity2.l;
            tripPlanningActivity2.l = mf1;
            tripPlanningActivity2.o0();
        }
    }
}
