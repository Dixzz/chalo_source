package defpackage;

import android.view.View;
import app.zophop.ui.activities.TripsSchedulesDirectionActivity;

/* renamed from: zg0  reason: default package */
/* compiled from: TripsSchedulesDirectionActivity */
public class zg0 implements View.OnClickListener {
    public final /* synthetic */ String f;
    public final /* synthetic */ TripsSchedulesDirectionActivity g;

    public zg0(TripsSchedulesDirectionActivity tripsSchedulesDirectionActivity, String str) {
        this.g = tripsSchedulesDirectionActivity;
        this.f = str;
    }

    public void onClick(View view) {
        w40 c0 = xt.f3961a.c0();
        TripsSchedulesDirectionActivity tripsSchedulesDirectionActivity = this.g;
        c0.b(tripsSchedulesDirectionActivity, tripsSchedulesDirectionActivity.m, tripsSchedulesDirectionActivity.l, this.f);
    }
}
