package defpackage;

import com.truecaller.android.sdk.TrueProfile;
import com.truecaller.android.sdk.clients.VerificationCallback;

/* renamed from: nh5  reason: default package */
/* compiled from: FetchProfileCallback */
public class nh5 extends lh5<TrueProfile> {
    public String d;
    public ch5 e;

    public nh5(String str, VerificationCallback verificationCallback, ch5 ch5, boolean z) {
        super(verificationCallback, true, 6);
        this.d = str;
        this.e = ch5;
    }

    @Override // defpackage.lh5
    public void a() {
        ch5 ch5 = this.e;
        String str = this.d;
        ((dh5) ch5).f838a.a(String.format("Bearer %s", str)).enqueue(this);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.lh5
    public void b(TrueProfile trueProfile) {
        TrueProfile trueProfile2 = trueProfile;
        trueProfile2.accessToken = this.d;
        bh5 bh5 = new bh5();
        bh5.f433a.put("profile", trueProfile2);
        this.f2221a.onRequestSuccess(this.b, bh5);
    }
}
