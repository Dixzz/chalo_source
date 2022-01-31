package defpackage;

import android.content.Intent;
import app.zophop.scanPay.ScanPayBaseActivity;
import app.zophop.scanPay.ScanPayPaymentActivity;
import com.google.firebase.analytics.FirebaseAnalytics;

/* renamed from: p80  reason: default package */
/* compiled from: ScanPayBaseActivity */
public class p80 implements Runnable {
    public final /* synthetic */ String f;
    public final /* synthetic */ ScanPayBaseActivity g;

    public p80(ScanPayBaseActivity scanPayBaseActivity, String str) {
        this.g = scanPayBaseActivity;
        this.f = str;
    }

    public void run() {
        if (this.g.n.size() >= 4) {
            this.g.n0("scan pay qr scan", null, this.f);
            Intent intent = new Intent(this.g, ScanPayPaymentActivity.class);
            intent.setFlags(536870912);
            intent.putExtra("busNo", this.g.n.get(0));
            intent.putExtra("agency", this.g.n.get(1));
            intent.putExtra(FirebaseAnalytics.Param.DISCOUNT, this.g.n.get(2));
            intent.putExtra("version", this.g.n.get(3));
            this.g.startActivity(intent);
            return;
        }
        this.g.n0("scan pay invalid scan", null, this.f);
        ScanPayBaseActivity.k0(this.g);
    }
}
