package defpackage;

import android.content.Intent;
import app.zophop.ui.activities.HomeActivity;
import com.freshchat.consumer.sdk.beans.config.DefaultRefreshIntervals;

/* renamed from: wv0  reason: default package */
/* compiled from: QrCodeScannerFragment */
public class wv0 implements Runnable {
    public final /* synthetic */ yv0 f;

    public wv0(yv0 yv0) {
        this.f = yv0;
    }

    public void run() {
        long Q = ui1.Q();
        yv0 yv0 = this.f;
        if (Q > yv0.n) {
            yv0.m.removeCallbacks(this);
            Intent intent = new Intent(this.f.c(), HomeActivity.class);
            intent.setFlags(268468224);
            this.f.startActivity(intent);
            return;
        }
        yv0.m.postDelayed(this, DefaultRefreshIntervals.ACTIVE_CONV_MAX_FETCH_INTERVAL);
    }
}
