package defpackage;

import android.view.View;
import app.zophop.ui.activities.TripDetailsActivity;

/* renamed from: yf0  reason: default package */
/* compiled from: TripDetailsActivity */
public class yf0 implements View.OnClickListener {
    public final /* synthetic */ TripDetailsActivity f;

    public yf0(TripDetailsActivity tripDetailsActivity) {
        this.f = tripDetailsActivity;
    }

    public void onClick(View view) {
        this.f.onBackPressed();
    }
}
