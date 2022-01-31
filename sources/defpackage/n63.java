package defpackage;

import com.google.android.gms.common.api.Status;

/* renamed from: n63  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class n63 extends t43 {
    public final String c;
    public final /* synthetic */ q63 d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n63(q63 q63, t43 t43, String str) {
        super(t43.f3307a, t43.b);
        this.d = q63;
        this.c = str;
    }

    @Override // defpackage.t43
    public final void c(String str) {
        q63.d.a("onCodeSent", new Object[0]);
        p63 p63 = this.d.c.get(this.c);
        if (p63 != null) {
            for (t43 t43 : p63.b) {
                t43.c(str);
            }
            p63.g = true;
            p63.d = str;
            if (p63.f2772a <= 0) {
                this.d.h(this.c);
            } else if (!p63.c) {
                this.d.i(this.c);
            } else if (!gj1.x1(p63.e)) {
                q63.f(this.d, this.c);
            }
        }
    }

    @Override // defpackage.t43
    public final void d(Status status) {
        wa2 wa2 = q63.d;
        String K = gj1.K(status.g);
        String str = status.h;
        wa2.b(hj1.c0(new StringBuilder(String.valueOf(K).length() + 39 + String.valueOf(str).length()), "SMS verification code request failed: ", K, " ", str), new Object[0]);
        p63 p63 = this.d.c.get(this.c);
        if (p63 != null) {
            for (t43 t43 : p63.b) {
                t43.d(status);
            }
            this.d.e(this.c);
        }
    }
}
