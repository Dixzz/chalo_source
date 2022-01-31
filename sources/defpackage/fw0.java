package defpackage;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import app.zophop.ui.activities.SchedulerDescriptionActivity;
import app.zophop.ui.fragments.SchedulerInputFormFragment;
import com.google.gson.Gson;
import java.util.Objects;
import zophop.models.Itinerary;

/* renamed from: fw0  reason: default package */
/* compiled from: SchedulerInputFormFragment */
public class fw0 implements View.OnClickListener {
    public final /* synthetic */ Itinerary f;
    public final /* synthetic */ SchedulerInputFormFragment g;

    public fw0(SchedulerInputFormFragment schedulerInputFormFragment, Itinerary itinerary) {
        this.g = schedulerInputFormFragment;
        this.f = itinerary;
    }

    public void onClick(View view) {
        SchedulerInputFormFragment schedulerInputFormFragment = this.g;
        int i = SchedulerInputFormFragment.v;
        Objects.requireNonNull(schedulerInputFormFragment);
        xt.f3961a.l().put("card_details_tut_shown", String.valueOf(true));
        String json = new Gson().toJson(this.f);
        Activity activity = this.g.getActivity();
        int i2 = this.g.h;
        int i3 = SchedulerDescriptionActivity.m;
        Intent intent = new Intent(activity, SchedulerDescriptionActivity.class);
        intent.putExtra("itineary_description", json);
        intent.putExtra("time_details", i2);
        activity.startActivity(intent);
    }
}
