package defpackage;

import android.widget.TextView;
import app.zophop.ui.activities.ActivePassScreen;

/* renamed from: gc0  reason: default package */
/* compiled from: ActivePassScreen */
public class gc0 implements Runnable {
    public final /* synthetic */ TextView f;
    public final /* synthetic */ ActivePassScreen g;

    public gc0(ActivePassScreen activePassScreen, TextView textView) {
        this.g = activePassScreen;
        this.f = textView;
    }

    public void run() {
        TextView textView = this.f;
        textView.setText(jh1.i(ui1.Q()) + ", " + jh1.d(ui1.Q()));
        this.g.w.postDelayed(this, 1000);
    }
}
