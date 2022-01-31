package defpackage;

import com.truecaller.android.sdk.TrueException;
import com.truecaller.android.sdk.TrueProfile;
import com.truecaller.android.sdk.clients.VerificationCallback;
import com.truecaller.android.sdk.models.VerifyInstallationModel;
import java.util.Map;

/* renamed from: qh5  reason: default package */
/* compiled from: VerifyInstallationCallback */
public class qh5 extends lh5<Map<String, Object>> {
    public TrueProfile d;
    public ch5 e;
    public String f;
    public VerifyInstallationModel g;

    public qh5(String str, VerifyInstallationModel verifyInstallationModel, VerificationCallback verificationCallback, TrueProfile trueProfile, ch5 ch5, boolean z) {
        super(verificationCallback, z, 5);
        this.d = trueProfile;
        this.e = ch5;
        this.f = str;
        this.g = verifyInstallationModel;
    }

    @Override // defpackage.lh5
    public void a() {
        ch5 ch5 = this.e;
        ((dh5) ch5).b.a(this.f, this.g).enqueue(this);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.lh5
    public void b(Map<String, Object> map) {
        Map<String, Object> map2 = map;
        if (map2.containsKey("accessToken")) {
            String str = (String) map2.get("accessToken");
            bh5 bh5 = new bh5();
            bh5.f433a.put("accessToken", str);
            this.f2221a.onRequestSuccess(this.b, bh5);
            ch5 ch5 = this.e;
            TrueProfile trueProfile = this.d;
            dh5 dh5 = (dh5) ch5;
            dh5.f838a.b(String.format("Bearer %s", str), trueProfile).enqueue(new mh5(str, trueProfile, dh5, true));
            return;
        }
        this.f2221a.onRequestFailure(this.b, new TrueException(1, TrueException.TYPE_UNKNOWN_MESSAGE));
    }
}
