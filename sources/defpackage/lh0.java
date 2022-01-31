package defpackage;

import android.widget.TextView;
import app.zophop.R;
import app.zophop.ui.activities.ValidationScreen;
import com.freshchat.consumer.sdk.beans.config.DefaultRefreshIntervals;

/* renamed from: lh0  reason: default package */
/* compiled from: ValidationScreen */
public class lh0 implements Runnable {
    public final /* synthetic */ ValidationScreen f;

    public lh0(ValidationScreen validationScreen) {
        this.f = validationScreen;
    }

    public void run() {
        String str;
        long Q = ui1.Q();
        ValidationScreen validationScreen = this.f;
        if (Q > validationScreen.m) {
            validationScreen.l.removeCallbacks(this);
            xt.f3961a.g0().a();
            ValidationScreen validationScreen2 = this.f;
            String str2 = null;
            if (validationScreen2.q != null) {
                jz5.b().g(new ed1("mpass activation duration expired dialog shown", Long.MIN_VALUE));
                str2 = validationScreen2.getResources().getString(R.string.activation_expired_pass_title);
                str = validationScreen2.getResources().getString(R.string.activation_expired_pass_copy);
            } else if (validationScreen2.p != null) {
                jz5.b().g(new ed1("mticket activation duration expired dialog shown", Long.MIN_VALUE));
                str2 = validationScreen2.getResources().getString(R.string.activation_expired_mticket_title);
                str = validationScreen2.getResources().getString(R.string.activation_expired_mticket_copy);
            } else {
                str = null;
            }
            lm0 a2 = lm0.a(validationScreen2.getFragmentManager(), str2, str, validationScreen2.getResources().getString(R.string.got_it), validationScreen2.getResources().getString(R.string.see_details));
            a2.setCancelable(false);
            oh0 oh0 = new oh0(validationScreen2);
            TextView textView = a2.i;
            if (textView != null) {
                textView.setOnClickListener(oh0);
            } else {
                a2.q = oh0;
            }
            ph0 ph0 = new ph0(validationScreen2);
            TextView textView2 = a2.j;
            if (textView2 != null) {
                textView2.setOnClickListener(ph0);
            } else {
                a2.r = ph0;
            }
        } else {
            validationScreen.l.postDelayed(this, DefaultRefreshIntervals.ACTIVE_CONV_MAX_FETCH_INTERVAL);
        }
    }
}
