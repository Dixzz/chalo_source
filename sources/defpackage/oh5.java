package defpackage;

import android.os.Handler;
import com.razorpay.AnalyticsConstants;
import com.truecaller.android.sdk.clients.VerificationCallback;
import com.truecaller.android.sdk.models.CreateInstallationModel;
import java.util.Map;

/* renamed from: oh5  reason: default package */
/* compiled from: MissedCallInstallationCallback */
public class oh5 extends ph5 {
    public Runnable h;
    public Handler i;
    public String j;
    public String k;

    public oh5(String str, CreateInstallationModel createInstallationModel, VerificationCallback verificationCallback, rh5 rh5, boolean z, ch5 ch5, Handler handler) {
        super(str, createInstallationModel, verificationCallback, z, ch5, rh5, 3);
        this.i = handler;
    }

    @Override // defpackage.ph5
    public void c(Map<String, Object> map) {
        if (AnalyticsConstants.CALL.equals((String) map.get("method"))) {
            this.j = (String) map.get("pattern");
            Double d = (Double) map.get("tokenTtl");
            if (d == null) {
                d = Double.valueOf(40.0d);
            }
            bh5 bh5 = new bh5();
            bh5.f433a.put("ttl", d.toString());
            this.f2221a.onRequestSuccess(this.b, bh5);
            kh5 kh5 = new kh5(this);
            this.h = kh5;
            this.i.postDelayed(kh5, d.longValue() * 1000);
            return;
        }
        super.c(map);
    }

    public void d(boolean z) {
        if (z || this.j != null) {
            ((ah5) ((dh5) this.f).d).i.a();
            ((ah5) ((dh5) this.f).d).d();
            if (!(this.k == null || this.j == null)) {
                ch5 ch5 = this.f;
                StringBuilder sb = new StringBuilder();
                String[] split = this.j.split(",");
                for (String str : split) {
                    String str2 = this.k;
                    sb.append(str2.charAt((str2.length() - Integer.parseInt(str)) - 1));
                }
                ((dh5) ch5).i = sb.toString();
                this.f2221a.onRequestSuccess(4, null);
            }
            Handler handler = this.i;
            if (handler != null) {
                handler.removeCallbacks(this.h);
                this.i = null;
            }
        }
    }
}
