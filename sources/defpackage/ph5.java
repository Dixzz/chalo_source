package defpackage;

import android.content.IntentFilter;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.truecaller.android.sdk.TrueException;
import com.truecaller.android.sdk.clients.VerificationCallback;
import com.truecaller.android.sdk.models.CreateInstallationModel;
import java.util.Map;

/* renamed from: ph5  reason: default package */
/* compiled from: OtpInstallationCallback */
public class ph5 extends lh5 {
    public final String d;
    public final CreateInstallationModel e;
    public final ch5 f;
    public final rh5 g;

    public ph5(String str, CreateInstallationModel createInstallationModel, VerificationCallback verificationCallback, rh5 rh5, boolean z, ch5 ch5) {
        super(verificationCallback, z, 1);
        this.d = str;
        this.e = createInstallationModel;
        this.f = ch5;
        this.g = rh5;
    }

    @Override // defpackage.lh5
    public void a() {
        this.e.setVerificationAttempt(2);
        ch5 ch5 = this.f;
        String str = this.d;
        CreateInstallationModel createInstallationModel = this.e;
        dh5 dh5 = (dh5) ch5;
        ((ah5) dh5.d).d();
        dh5.b.b(str, createInstallationModel).enqueue(this);
    }

    @Override // defpackage.lh5
    public void b(Object obj) {
        Map<String, Object> map = (Map) obj;
        Double d2 = (Double) map.get("status");
        if (d2.doubleValue() == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            ch5 ch5 = this.f;
            System.currentTimeMillis();
            ((dh5) ch5).h = (String) map.get("verificationToken");
            c(map);
        } else if (d2.doubleValue() == 1.0d) {
            String str = (String) map.get("accessToken");
            dh5 dh5 = (dh5) this.f;
            dh5.f838a.a(String.format("Bearer %s", str)).enqueue(new nh5(str, this.f2221a, dh5, true));
        } else {
            this.f2221a.onRequestFailure(this.b, new TrueException(1, TrueException.TYPE_UNKNOWN_MESSAGE));
        }
    }

    public void c(Map<String, Object> map) {
        Double d2 = (Double) map.get("tokenTtl");
        if (d2 == null) {
            d2 = Double.valueOf(300.0d);
        }
        bh5 bh5 = new bh5();
        bh5.f433a.put("ttl", d2.toString());
        this.f2221a.onRequestSuccess(1, bh5);
        rh5 rh5 = this.g;
        VerificationCallback verificationCallback = this.f2221a;
        if (rh5.f3081a.get() != null) {
            new sd2(rh5.f3081a.get()).a();
            rh5.f3081a.get().registerReceiver(new sh5(verificationCallback), new IntentFilter("com.google.android.gms.auth.api.phone.SMS_RETRIEVED"));
        }
    }

    public ph5(String str, CreateInstallationModel createInstallationModel, VerificationCallback verificationCallback, boolean z, ch5 ch5, rh5 rh5, int i) {
        super(verificationCallback, z, i);
        this.d = str;
        this.e = createInstallationModel;
        this.f = ch5;
        this.g = rh5;
    }
}
