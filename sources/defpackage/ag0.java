package defpackage;

import android.view.View;
import app.zophop.ui.activities.TripDetailsActivity;

/* renamed from: ag0  reason: default package */
/* compiled from: TripDetailsActivity */
public class ag0 implements View.OnClickListener {
    public final /* synthetic */ TripDetailsActivity f;

    public ag0(TripDetailsActivity tripDetailsActivity) {
        this.f = tripDetailsActivity;
    }

    public void onClick(View view) {
        TripDetailsActivity tripDetailsActivity = this.f;
        tn0.b(tripDetailsActivity.getFragmentManager(), tripDetailsActivity.getIntent().getStringExtra("trip_details:response"), tripDetailsActivity.getClass().getSimpleName());
    }
}
