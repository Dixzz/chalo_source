package defpackage;

import android.widget.TextView;
import app.zophop.ui.activities.ActiveMTicketScreen;

/* renamed from: zb0  reason: default package */
/* compiled from: ActiveMTicketScreen */
public class zb0 implements Runnable {
    public final /* synthetic */ TextView f;
    public final /* synthetic */ ActiveMTicketScreen g;

    public zb0(ActiveMTicketScreen activeMTicketScreen, TextView textView) {
        this.g = activeMTicketScreen;
        this.f = textView;
    }

    public void run() {
        TextView textView = this.f;
        textView.setText(jh1.i(ui1.Q()) + ", " + jh1.d(ui1.Q()));
        this.g.B.postDelayed(this, 1000);
    }
}
