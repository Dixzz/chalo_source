package defpackage;

import android.content.Context;

/* renamed from: i40  reason: default package */
/* compiled from: ReferralFeature */
public class i40 implements v20 {
    public i40(Context context) {
        context.getSharedPreferences("referral:store", 0).edit();
        jz5 b = jz5.b();
        b.k(this, b.e, true, 0);
    }

    @Override // defpackage.v20
    public String a(String str) {
        return hj1.S("https://play.google.com/store/apps/details?id=", str);
    }

    @Override // defpackage.v20
    public void b() {
    }

    public void onEvent(ff1 ff1) {
        jz5.b().g(new ed1("referral awarded", Long.MIN_VALUE));
        jz5.b().g(new te1(ff1.f1116a));
    }
}
