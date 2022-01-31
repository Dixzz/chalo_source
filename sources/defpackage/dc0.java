package defpackage;

import android.widget.TextView;
import app.zophop.R;
import app.zophop.ui.activities.ActivePassScreen;
import com.freshchat.consumer.sdk.beans.config.DefaultRefreshIntervals;
import java.util.Objects;

/* renamed from: dc0  reason: default package */
/* compiled from: ActivePassScreen */
public class dc0 implements Runnable {
    public final /* synthetic */ long f;
    public final /* synthetic */ ActivePassScreen g;

    public dc0(ActivePassScreen activePassScreen, long j) {
        this.g = activePassScreen;
        this.f = j;
    }

    public void run() {
        if (ui1.Q() > this.f) {
            this.g.z.removeCallbacks(this);
            ActivePassScreen activePassScreen = this.g;
            Objects.requireNonNull(activePassScreen);
            jz5.b().g(new ed1("mpass activation duration expired dialog shown", Long.MIN_VALUE));
            lm0 a2 = lm0.a(activePassScreen.getFragmentManager(), activePassScreen.getResources().getString(R.string.activation_expired_pass_title), activePassScreen.getResources().getString(R.string.activation_expired_pass_copy), activePassScreen.getResources().getString(R.string.got_it), activePassScreen.getResources().getString(R.string.see_details));
            a2.setCancelable(false);
            ic0 ic0 = new ic0(activePassScreen);
            TextView textView = a2.i;
            if (textView != null) {
                textView.setOnClickListener(ic0);
            } else {
                a2.q = ic0;
            }
            jc0 jc0 = new jc0(activePassScreen);
            TextView textView2 = a2.j;
            if (textView2 != null) {
                textView2.setOnClickListener(jc0);
            } else {
                a2.r = jc0;
            }
        } else {
            this.g.z.postDelayed(this, DefaultRefreshIntervals.ACTIVE_CONV_MAX_FETCH_INTERVAL);
        }
    }
}
