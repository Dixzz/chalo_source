package defpackage;

import android.widget.TextView;
import app.zophop.R;
import app.zophop.ui.activities.ActiveMTicketScreen;
import com.freshchat.consumer.sdk.beans.config.DefaultRefreshIntervals;
import java.util.Objects;

/* renamed from: xb0  reason: default package */
/* compiled from: ActiveMTicketScreen */
public class xb0 implements Runnable {
    public final /* synthetic */ ActiveMTicketScreen f;

    public xb0(ActiveMTicketScreen activeMTicketScreen) {
        this.f = activeMTicketScreen;
    }

    public void run() {
        long Q = ui1.Q();
        ActiveMTicketScreen activeMTicketScreen = this.f;
        if (Q > activeMTicketScreen.l) {
            activeMTicketScreen.C.removeCallbacks(this);
            ActiveMTicketScreen activeMTicketScreen2 = this.f;
            Objects.requireNonNull(activeMTicketScreen2);
            jz5.b().g(new ed1("mticket activation duration expired dialog shown", Long.MIN_VALUE));
            lm0 a2 = lm0.a(activeMTicketScreen2.getFragmentManager(), activeMTicketScreen2.getResources().getString(R.string.activation_expired_mticket_title), activeMTicketScreen2.getResources().getString(R.string.activation_expired_mticket_copy), activeMTicketScreen2.getResources().getString(R.string.got_it), activeMTicketScreen2.getResources().getString(R.string.see_details));
            a2.setCancelable(false);
            bc0 bc0 = new bc0(activeMTicketScreen2);
            TextView textView = a2.i;
            if (textView != null) {
                textView.setOnClickListener(bc0);
            } else {
                a2.q = bc0;
            }
            cc0 cc0 = new cc0(activeMTicketScreen2);
            TextView textView2 = a2.j;
            if (textView2 != null) {
                textView2.setOnClickListener(cc0);
            } else {
                a2.r = cc0;
            }
        } else {
            activeMTicketScreen.C.postDelayed(this, DefaultRefreshIntervals.ACTIVE_CONV_MAX_FETCH_INTERVAL);
        }
    }
}
