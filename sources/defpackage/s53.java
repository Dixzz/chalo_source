package defpackage;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import com.google.android.gms.internal.p000firebaseauthapi.zzvl;
import com.google.android.gms.internal.p000firebaseauthapi.zzvx;
import com.google.android.gms.internal.p000firebaseauthapi.zzwg;
import com.google.android.gms.internal.p000firebaseauthapi.zzwr;
import com.google.android.gms.internal.p000firebaseauthapi.zzwt;
import com.google.android.gms.internal.p000firebaseauthapi.zzxg;
import com.google.android.gms.internal.p000firebaseauthapi.zzxk;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Objects;

/* renamed from: s53  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class s53 extends f63 implements s63 {

    /* renamed from: a  reason: collision with root package name */
    public i53 f3188a;
    public j53 b;
    public h63 c;
    public final r53 d;
    public final Context e;
    public final String f;
    public t53 g;

    public s53(Context context, String str, r53 r53) {
        this.e = context.getApplicationContext();
        gj1.j(str);
        this.f = str;
        this.d = r53;
        u(null, null, null);
        Map<String, WeakReference<s63>> map = t63.b;
        synchronized (map) {
            ((u2) map).put(str, new WeakReference(this));
        }
    }

    @Override // defpackage.f63
    public final void a(g73 g73, e63<zzwg> e63) {
        h63 h63 = this.c;
        gj1.a1(h63.a("/token", this.f), g73, e63, zzwg.class, h63.b);
    }

    @Override // defpackage.f63
    public final void b(j83 j83, e63<zzxk> e63) {
        i53 i53 = this.f3188a;
        gj1.a1(i53.a("/verifyCustomToken", this.f), j83, e63, zzxk.class, i53.b);
    }

    @Override // defpackage.f63
    public final void c(Context context, zzxg zzxg, e63<i83> e63) {
        Objects.requireNonNull(zzxg, "null reference");
        i53 i53 = this.f3188a;
        gj1.a1(i53.a("/verifyAssertion", this.f), zzxg, e63, i83.class, i53.b);
    }

    @Override // defpackage.f63
    public final void d(z73 z73, e63<a83> e63) {
        i53 i53 = this.f3188a;
        gj1.a1(i53.a("/signupNewUser", this.f), z73, e63, a83.class, i53.b);
    }

    @Override // defpackage.f63
    public final void e(Context context, l83 l83, e63<m83> e63) {
        i53 i53 = this.f3188a;
        gj1.a1(i53.a("/verifyPassword", this.f), l83, e63, m83.class, i53.b);
    }

    @Override // defpackage.f63
    public final void f(t73 t73, e63<zzwr> e63) {
        i53 i53 = this.f3188a;
        gj1.a1(i53.a("/resetPassword", this.f), t73, e63, zzwr.class, i53.b);
    }

    @Override // defpackage.f63
    public final void g(h73 h73, e63<zzvx> e63) {
        i53 i53 = this.f3188a;
        gj1.a1(i53.a("/getAccountInfo", this.f), h73, e63, zzvx.class, i53.b);
    }

    @Override // defpackage.f63
    public final void h(x73 x73, e63<y73> e63) {
        i53 i53 = this.f3188a;
        gj1.a1(i53.a("/setAccountInfo", this.f), x73, e63, y73.class, i53.b);
    }

    @Override // defpackage.f63
    public final void i(w63 w63, e63<zzvl> e63) {
        i53 i53 = this.f3188a;
        gj1.a1(i53.a("/createAuthUri", this.f), w63, e63, zzvl.class, i53.b);
    }

    @Override // defpackage.f63
    public final void j(l73 l73, e63<m73> e63) {
        if (l73.j != null) {
            v().e = l73.j.zzd();
        }
        i53 i53 = this.f3188a;
        gj1.a1(i53.a("/getOobConfirmationCode", this.f), l73, e63, m73.class, i53.b);
    }

    @Override // defpackage.f63
    public final void k(zzwt zzwt, e63<w73> e63) {
        if (!TextUtils.isEmpty(zzwt.i)) {
            v().e = zzwt.i;
        }
        i53 i53 = this.f3188a;
        gj1.a1(i53.a("/sendVerificationCode", this.f), zzwt, e63, w73.class, i53.b);
    }

    @Override // defpackage.f63
    public final void l(Context context, n83 n83, e63<o83> e63) {
        Objects.requireNonNull(n83, "null reference");
        i53 i53 = this.f3188a;
        gj1.a1(i53.a("/verifyPhoneNumber", this.f), n83, e63, o83.class, i53.b);
    }

    @Override // defpackage.f63
    public final void m(y63 y63, e63<Void> e63) {
        i53 i53 = this.f3188a;
        gj1.a1(i53.a("/deleteAccount", this.f), y63, e63, Void.class, i53.b);
    }

    @Override // defpackage.f63
    public final void n(String str, e63<Void> e63) {
        t53 v = v();
        Objects.requireNonNull(v);
        v.d = !TextUtils.isEmpty(str);
        t43 t43 = ((p03) e63).f2753a;
        Objects.requireNonNull(t43);
        try {
            t43.f3307a.f();
        } catch (RemoteException unused) {
            t43.b.b("RemoteException when setting FirebaseUI Version", new Object[0]);
        }
    }

    @Override // defpackage.f63
    public final void o(z63 z63, e63<a73> e63) {
        i53 i53 = this.f3188a;
        gj1.a1(i53.a("/emailLinkSignin", this.f), z63, e63, a73.class, i53.b);
    }

    @Override // defpackage.f63
    public final void p(c83 c83, e63<d83> e63) {
        if (!TextUtils.isEmpty(c83.i)) {
            v().e = c83.i;
        }
        j53 j53 = this.b;
        gj1.a1(j53.a("/mfaEnrollment:start", this.f), c83, e63, d83.class, j53.b);
    }

    @Override // defpackage.f63
    public final void q(Context context, b73 b73, e63<c73> e63) {
        Objects.requireNonNull(b73, "null reference");
        j53 j53 = this.b;
        gj1.a1(j53.a("/mfaEnrollment:finalize", this.f), b73, e63, c73.class, j53.b);
    }

    @Override // defpackage.f63
    public final void r(p83 p83, e63<q83> e63) {
        j53 j53 = this.b;
        gj1.a1(j53.a("/mfaEnrollment:withdraw", this.f), p83, e63, q83.class, j53.b);
    }

    @Override // defpackage.f63
    public final void s(e83 e83, e63<f83> e63) {
        if (!TextUtils.isEmpty(e83.i)) {
            v().e = e83.i;
        }
        j53 j53 = this.b;
        gj1.a1(j53.a("/mfaSignIn:start", this.f), e83, e63, f83.class, j53.b);
    }

    @Override // defpackage.f63
    public final void t(Context context, d73 d73, e63<e73> e63) {
        j53 j53 = this.b;
        gj1.a1(j53.a("/mfaSignIn:finalize", this.f), d73, e63, e73.class, j53.b);
    }

    public final void u(h63 h63, i53 i53, j53 j53) {
        r63 r63;
        String str;
        r63 r632;
        String str2;
        this.c = null;
        this.f3188a = null;
        this.b = null;
        String l1 = gj1.l1("firebear.secureToken");
        if (TextUtils.isEmpty(l1)) {
            String str3 = this.f;
            Map<String, r63> map = t63.f3313a;
            synchronized (map) {
                r632 = (r63) ((u2) map).get(str3);
            }
            if (r632 != null) {
                String str4 = r632.f3048a;
                String valueOf = String.valueOf(t63.c(str4, r632.b, str4.contains(ProductDiscountsObject.KEY_DELIMITER)));
                str2 = valueOf.length() != 0 ? "".concat(valueOf) : new String("");
            } else {
                str2 = "https://";
            }
            l1 = String.valueOf(str2).concat("securetoken.googleapis.com/v1");
        } else {
            String valueOf2 = String.valueOf(l1);
            if (valueOf2.length() != 0) {
                "Found hermetic configuration for secureToken URL: ".concat(valueOf2);
            } else {
                new String("Found hermetic configuration for secureToken URL: ");
            }
        }
        if (this.c == null) {
            this.c = new h63(l1, v());
        }
        String l12 = gj1.l1("firebear.identityToolkit");
        if (TextUtils.isEmpty(l12)) {
            l12 = t63.b(this.f);
        } else {
            String valueOf3 = String.valueOf(l12);
            if (valueOf3.length() != 0) {
                "Found hermetic configuration for identityToolkit URL: ".concat(valueOf3);
            } else {
                new String("Found hermetic configuration for identityToolkit URL: ");
            }
        }
        if (this.f3188a == null) {
            this.f3188a = new i53(l12, v());
        }
        String l13 = gj1.l1("firebear.identityToolkitV2");
        if (TextUtils.isEmpty(l13)) {
            String str5 = this.f;
            Map<String, r63> map2 = t63.f3313a;
            synchronized (map2) {
                r63 = (r63) ((u2) map2).get(str5);
            }
            if (r63 != null) {
                String str6 = r63.f3048a;
                String valueOf4 = String.valueOf(t63.c(str6, r63.b, str6.contains(ProductDiscountsObject.KEY_DELIMITER)));
                str = valueOf4.length() != 0 ? "".concat(valueOf4) : new String("");
            } else {
                str = "https://";
            }
            l13 = String.valueOf(str).concat("identitytoolkit.googleapis.com/v2/accounts");
        } else {
            String valueOf5 = String.valueOf(l13);
            if (valueOf5.length() != 0) {
                "Found hermetic configuration for identityToolkitV2 URL: ".concat(valueOf5);
            } else {
                new String("Found hermetic configuration for identityToolkitV2 URL: ");
            }
        }
        if (this.b == null) {
            this.b = new j53(l13, v());
        }
    }

    public final t53 v() {
        if (this.g == null) {
            this.g = new t53(this.e, this.d.a());
        }
        return this.g;
    }

    @Override // defpackage.s63
    public final void zza() {
        u(null, null, null);
    }
}
