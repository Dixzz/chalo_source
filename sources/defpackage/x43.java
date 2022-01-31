package defpackage;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.internal.p000firebaseauthapi.zzlc;
import com.google.android.gms.internal.p000firebaseauthapi.zzle;
import com.google.android.gms.internal.p000firebaseauthapi.zzlg;
import com.google.android.gms.internal.p000firebaseauthapi.zzli;
import com.google.android.gms.internal.p000firebaseauthapi.zzlk;
import com.google.android.gms.internal.p000firebaseauthapi.zzlm;
import com.google.android.gms.internal.p000firebaseauthapi.zzlo;
import com.google.android.gms.internal.p000firebaseauthapi.zzlq;
import com.google.android.gms.internal.p000firebaseauthapi.zzls;
import com.google.android.gms.internal.p000firebaseauthapi.zzlu;
import com.google.android.gms.internal.p000firebaseauthapi.zzlw;
import com.google.android.gms.internal.p000firebaseauthapi.zzly;
import com.google.android.gms.internal.p000firebaseauthapi.zzma;
import com.google.android.gms.internal.p000firebaseauthapi.zzmc;
import com.google.android.gms.internal.p000firebaseauthapi.zzme;
import com.google.android.gms.internal.p000firebaseauthapi.zzmg;
import com.google.android.gms.internal.p000firebaseauthapi.zzmi;
import com.google.android.gms.internal.p000firebaseauthapi.zzmk;
import com.google.android.gms.internal.p000firebaseauthapi.zzmm;
import com.google.android.gms.internal.p000firebaseauthapi.zzmo;
import com.google.android.gms.internal.p000firebaseauthapi.zzmq;
import com.google.android.gms.internal.p000firebaseauthapi.zzms;
import com.google.android.gms.internal.p000firebaseauthapi.zzmu;
import com.google.android.gms.internal.p000firebaseauthapi.zzmw;
import com.google.android.gms.internal.p000firebaseauthapi.zzmy;
import com.google.android.gms.internal.p000firebaseauthapi.zzna;
import com.google.android.gms.internal.p000firebaseauthapi.zznc;
import com.google.android.gms.internal.p000firebaseauthapi.zzne;
import com.google.android.gms.internal.p000firebaseauthapi.zzng;
import com.google.android.gms.internal.p000firebaseauthapi.zzni;
import com.google.android.gms.internal.p000firebaseauthapi.zznk;
import com.google.android.gms.internal.p000firebaseauthapi.zznm;
import com.google.android.gms.internal.p000firebaseauthapi.zzwt;
import com.google.android.gms.internal.p000firebaseauthapi.zzxg;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.UserProfileChangeRequest;
import java.util.Objects;

/* renamed from: x43  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class x43 extends g53 {
    public static final wa2 h = new wa2("FirebaseAuth", "FirebaseAuthFallback:");
    public final y03 f;
    public final q63 g;

    public x43(Context context, String str) {
        Objects.requireNonNull(context, "null reference");
        r53 b = r53.b();
        gj1.j(str);
        this.f = new y03(new s53(context, str, b));
        this.g = new q63(context);
    }

    public static boolean F(long j, boolean z) {
        if (j > 0 && z) {
            return true;
        }
        h.b("App hash will not be appended to the request.", new Object[0]);
        return false;
    }

    @Override // defpackage.h53
    public final void D0(zzlq zzlq, e53 e53) throws RemoteException {
        Objects.requireNonNull(zzlq, "null reference");
        Objects.requireNonNull(e53, "null reference");
        y03 y03 = this.f;
        String str = zzlq.g;
        String zzd = zzlq.f.zzd();
        String smsCode = zzlq.f.getSmsCode();
        String str2 = zzlq.h;
        gj1.j(smsCode);
        gj1.j(zzd);
        b73 b73 = new b73(str, zzd, smsCode, str2);
        String str3 = zzlq.g;
        t43 t43 = new t43(e53, h);
        Objects.requireNonNull(y03);
        y03.e(str3, new i03(y03, b73, t43));
    }

    @Override // defpackage.h53
    public final void D2(zzmm zzmm, e53 e53) throws RemoteException {
        Objects.requireNonNull(zzmm, "null reference");
        Objects.requireNonNull(e53, "null reference");
        y03 y03 = this.f;
        String str = zzmm.f;
        t43 t43 = new t43(e53, h);
        Objects.requireNonNull(y03);
        y03.f3986a.n(str, new p03(t43));
    }

    @Override // defpackage.h53
    public final void E2(zzmq zzmq, e53 e53) {
        Objects.requireNonNull(zzmq, "null reference");
        Objects.requireNonNull(zzmq.f, "null reference");
        Objects.requireNonNull(e53, "null reference");
        y03 y03 = this.f;
        zzxg zzxg = zzmq.f;
        t43 t43 = new t43(e53, h);
        Objects.requireNonNull(y03);
        Objects.requireNonNull(zzxg, "null reference");
        zzxg.t = true;
        y03.f3986a.c(null, zzxg, new r03(y03, t43));
    }

    @Override // defpackage.h53
    public final void E3(zzmy zzmy, e53 e53) throws RemoteException {
        Objects.requireNonNull(e53, "null reference");
        Objects.requireNonNull(zzmy, "null reference");
        PhoneAuthCredential phoneAuthCredential = zzmy.f;
        Objects.requireNonNull(phoneAuthCredential, "null reference");
        y03 y03 = this.f;
        n83 R0 = gj1.R0(phoneAuthCredential);
        t43 t43 = new t43(e53, h);
        Objects.requireNonNull(y03);
        y03.f3986a.l(null, R0, new uz2(y03, t43));
    }

    @Override // defpackage.h53
    public final void F0(zzng zzng, e53 e53) {
        Objects.requireNonNull(zzng, "null reference");
        gj1.j(zzng.f);
        Objects.requireNonNull(e53, "null reference");
        y03 y03 = this.f;
        String str = zzng.f;
        t43 t43 = new t43(e53, h);
        Objects.requireNonNull(y03);
        gj1.j(str);
        y03.e(str, new a03(y03, t43));
    }

    @Override // defpackage.h53
    public final void G3(zzms zzms, e53 e53) {
        Objects.requireNonNull(zzms, "null reference");
        gj1.j(zzms.f);
        Objects.requireNonNull(e53, "null reference");
        j83 j83 = new j83(zzms.f, zzms.g);
        y03 y03 = this.f;
        t43 t43 = new t43(e53, h);
        Objects.requireNonNull(y03);
        y03.f3986a.b(j83, new g03(y03, t43));
    }

    @Override // defpackage.h53
    public final void I1(zzme zzme, e53 e53) throws RemoteException {
        Objects.requireNonNull(zzme, "null reference");
        gj1.j(zzme.f);
        Objects.requireNonNull(e53, "null reference");
        y03 y03 = this.f;
        String str = zzme.f;
        t43 t43 = new t43(e53, h);
        Objects.requireNonNull(y03);
        gj1.j(str);
        y03.e(str, new m03(y03, t43));
    }

    @Override // defpackage.h53
    public final void J0(zzmi zzmi, e53 e53) throws RemoteException {
        Objects.requireNonNull(zzmi, "null reference");
        gj1.j(zzmi.f);
        Objects.requireNonNull(e53, "null reference");
        y03 y03 = this.f;
        String str = zzmi.f;
        ActionCodeSettings actionCodeSettings = zzmi.g;
        String str2 = zzmi.h;
        t43 t43 = new t43(e53, h);
        Objects.requireNonNull(y03);
        gj1.j(str);
        l73 l73 = new l73(actionCodeSettings.zzf());
        gj1.j(str);
        l73.g = str;
        l73.j = actionCodeSettings;
        l73.k = str2;
        y03.f3986a.j(l73, new pz2(t43));
    }

    @Override // defpackage.h53
    public final void J3(zzmk zzmk, e53 e53) throws RemoteException {
        Objects.requireNonNull(e53, "null reference");
        Objects.requireNonNull(zzmk, "null reference");
        zzwt zzwt = zzmk.f;
        Objects.requireNonNull(zzwt, "null reference");
        String str = zzwt.f;
        t43 t43 = new t43(e53, h);
        if (this.g.a(str)) {
            if (zzwt.h) {
                this.g.e(str);
            } else {
                this.g.c(t43, str);
                return;
            }
        }
        long j = zzwt.g;
        boolean z = zzwt.l;
        if (F(j, z)) {
            zzwt.n = new u63(this.g.d());
        }
        this.g.b(str, t43, j, z);
        y03 y03 = this.f;
        n63 n63 = new n63(this.g, t43, str);
        Objects.requireNonNull(y03);
        gj1.j(zzwt.f);
        y03.f3986a.k(zzwt, new tz2(n63));
    }

    @Override // defpackage.h53
    public final void K1(zzma zzma, e53 e53) {
        Objects.requireNonNull(zzma, "null reference");
        gj1.j(zzma.f);
        Objects.requireNonNull(zzma.g, "null reference");
        Objects.requireNonNull(e53, "null reference");
        y03 y03 = this.f;
        String str = zzma.f;
        zzxg zzxg = zzma.g;
        t43 t43 = new t43(e53, h);
        Objects.requireNonNull(y03);
        gj1.j(str);
        Objects.requireNonNull(zzxg, "null reference");
        y03.e(str, new zz2(y03, zzxg, t43));
    }

    @Override // defpackage.h53
    public final void M0(zzlo zzlo, e53 e53) throws RemoteException {
        Objects.requireNonNull(zzlo, "null reference");
        gj1.j(zzlo.f);
        Objects.requireNonNull(e53, "null reference");
        y03 y03 = this.f;
        String str = zzlo.f;
        t43 t43 = new t43(e53, h);
        Objects.requireNonNull(y03);
        gj1.j(str);
        y03.e(str, new o03(y03, t43));
    }

    @Override // defpackage.h53
    public final void N2(zzmg zzmg, e53 e53) throws RemoteException {
        Objects.requireNonNull(zzmg, "null reference");
        gj1.j(zzmg.f);
        Objects.requireNonNull(e53, "null reference");
        y03 y03 = this.f;
        String str = zzmg.f;
        ActionCodeSettings actionCodeSettings = zzmg.g;
        t43 t43 = new t43(e53, h);
        Objects.requireNonNull(y03);
        gj1.j(str);
        l73 l73 = new l73(4);
        gj1.j(str);
        l73.i = str;
        if (actionCodeSettings != null) {
            l73.j = actionCodeSettings;
        }
        y03.f3986a.j(l73, new q03(t43));
    }

    @Override // defpackage.h53
    public final void O(zzlg zzlg, e53 e53) {
        Objects.requireNonNull(zzlg, "null reference");
        gj1.j(zzlg.f);
        gj1.j(zzlg.g);
        Objects.requireNonNull(e53, "null reference");
        y03 y03 = this.f;
        String str = zzlg.f;
        String str2 = zzlg.g;
        t43 t43 = new t43(e53, h);
        Objects.requireNonNull(y03);
        gj1.j(str);
        gj1.j(str2);
        y03.e(str, new v03(y03, str2, t43));
    }

    @Override // defpackage.h53
    public final void S1(zzmw zzmw, e53 e53) {
        Objects.requireNonNull(zzmw, "null reference");
        Objects.requireNonNull(zzmw.f, "null reference");
        Objects.requireNonNull(e53, "null reference");
        y03 y03 = this.f;
        EmailAuthCredential emailAuthCredential = zzmw.f;
        t43 t43 = new t43(e53, h);
        Objects.requireNonNull(y03);
        Objects.requireNonNull(emailAuthCredential, "null reference");
        if (emailAuthCredential.zzf()) {
            y03.e(emailAuthCredential.zze(), new jz2(y03, emailAuthCredential, t43));
            return;
        }
        y03.f3986a.o(new z63(emailAuthCredential, null), new kz2(y03, t43));
    }

    @Override // defpackage.h53
    public final void U0(zzna zzna, e53 e53) throws RemoteException {
        Objects.requireNonNull(zzna, "null reference");
        Objects.requireNonNull(e53, "null reference");
        String str = zzna.g;
        t43 t43 = new t43(e53, h);
        if (this.g.a(str)) {
            if (zzna.j) {
                this.g.e(str);
            } else {
                this.g.c(t43, str);
                return;
            }
        }
        long j = zzna.i;
        boolean z = zzna.n;
        String str2 = zzna.f;
        String str3 = zzna.g;
        String str4 = zzna.h;
        String str5 = zzna.m;
        String str6 = zzna.l;
        gj1.j(str3);
        c83 c83 = new c83(str2, str3, str4, str5, str6);
        if (F(j, z)) {
            c83.l = new u63(this.g.d());
        }
        this.g.b(str, t43, j, z);
        y03 y03 = this.f;
        n63 n63 = new n63(this.g, t43, str);
        Objects.requireNonNull(y03);
        y03.f3986a.p(c83, new f03(n63));
    }

    @Override // defpackage.h53
    public final void W2(zznk zznk, e53 e53) {
        Objects.requireNonNull(zznk, "null reference");
        gj1.j(zznk.g);
        Objects.requireNonNull(zznk.f, "null reference");
        Objects.requireNonNull(e53, "null reference");
        y03 y03 = this.f;
        String str = zznk.g;
        UserProfileChangeRequest userProfileChangeRequest = zznk.f;
        t43 t43 = new t43(e53, h);
        Objects.requireNonNull(y03);
        gj1.j(str);
        Objects.requireNonNull(userProfileChangeRequest, "null reference");
        y03.e(str, new t03(y03, userProfileChangeRequest, t43));
    }

    @Override // defpackage.h53
    public final void X0(zzlu zzlu, e53 e53) {
        Objects.requireNonNull(zzlu, "null reference");
        Objects.requireNonNull(e53, "null reference");
        gj1.j(zzlu.f);
        y03 y03 = this.f;
        String str = zzlu.f;
        t43 t43 = new t43(e53, h);
        Objects.requireNonNull(y03);
        gj1.j(str);
        y03.f3986a.a(new g73(str), new rz2(t43));
    }

    @Override // defpackage.h53
    public final void X1(zzni zzni, e53 e53) {
        Objects.requireNonNull(zzni, "null reference");
        gj1.j(zzni.f);
        gj1.j(zzni.g);
        Objects.requireNonNull(e53, "null reference");
        y03 y03 = this.f;
        String str = zzni.f;
        String str2 = zzni.g;
        t43 t43 = new t43(e53, h);
        Objects.requireNonNull(y03);
        gj1.j(str);
        gj1.j(str2);
        y03.e(str2, new c03(y03, str, t43));
    }

    @Override // defpackage.h53
    public final void Y1(zzli zzli, e53 e53) throws RemoteException {
        Objects.requireNonNull(zzli, "null reference");
        gj1.j(zzli.f);
        Objects.requireNonNull(e53, "null reference");
        y03 y03 = this.f;
        String str = zzli.f;
        String str2 = zzli.g;
        t43 t43 = new t43(e53, h);
        Objects.requireNonNull(y03);
        gj1.j(str);
        y03.f3986a.f(new t73(str, null, str2), new qz2(t43));
    }

    @Override // defpackage.h53
    public final void Y2(zzls zzls, e53 e53) throws RemoteException {
        Objects.requireNonNull(zzls, "null reference");
        Objects.requireNonNull(e53, "null reference");
        y03 y03 = this.f;
        String str = zzls.g;
        String zzd = zzls.f.zzd();
        String smsCode = zzls.f.getSmsCode();
        gj1.j(smsCode);
        gj1.j(zzd);
        d73 d73 = new d73(str, zzd, smsCode);
        t43 t43 = new t43(e53, h);
        Objects.requireNonNull(y03);
        y03.f3986a.t(null, d73, new j03(y03, t43));
    }

    @Override // defpackage.h53
    public final void a0(zzmc zzmc, e53 e53) throws RemoteException {
        Objects.requireNonNull(e53, "null reference");
        Objects.requireNonNull(zzmc, "null reference");
        PhoneAuthCredential phoneAuthCredential = zzmc.g;
        Objects.requireNonNull(phoneAuthCredential, "null reference");
        String str = zzmc.f;
        gj1.j(str);
        y03 y03 = this.f;
        n83 R0 = gj1.R0(phoneAuthCredential);
        t43 t43 = new t43(e53, h);
        Objects.requireNonNull(y03);
        gj1.j(str);
        y03.e(str, new xz2(y03, R0, t43));
    }

    @Override // defpackage.h53
    public final void e0(zzlk zzlk, e53 e53) throws RemoteException {
        Objects.requireNonNull(zzlk, "null reference");
        gj1.j(zzlk.f);
        gj1.j(zzlk.g);
        Objects.requireNonNull(e53, "null reference");
        y03 y03 = this.f;
        String str = zzlk.f;
        String str2 = zzlk.g;
        String str3 = zzlk.h;
        t43 t43 = new t43(e53, h);
        Objects.requireNonNull(y03);
        gj1.j(str);
        gj1.j(str2);
        y03.f3986a.f(new t73(str, str2, str3), new sz2(t43));
    }

    @Override // defpackage.h53
    public final void h2(zznm zznm, e53 e53) {
        Objects.requireNonNull(zznm, "null reference");
        ActionCodeSettings actionCodeSettings = zznm.h;
        String str = zznm.f;
        String str2 = zznm.g;
        gj1.j(str);
        gj1.j(str2);
        Objects.requireNonNull(actionCodeSettings, "null reference");
        l73 l73 = new l73(actionCodeSettings, str2, str);
        y03 y03 = this.f;
        t43 t43 = new t43(e53, h);
        Objects.requireNonNull(y03);
        y03.f3986a.j(l73, new q03(t43));
    }

    @Override // defpackage.h53
    public final void i2(zzlw zzlw, e53 e53) {
        Objects.requireNonNull(zzlw, "null reference");
        gj1.j(zzlw.f);
        y03 y03 = this.f;
        String str = zzlw.f;
        String str2 = zzlw.g;
        t43 t43 = new t43(e53, h);
        Objects.requireNonNull(y03);
        gj1.j(str);
        y03.f3986a.i(new w63(str, str2), new oz2(t43));
    }

    @Override // defpackage.h53
    public final void i3(zzlc zzlc, e53 e53) throws RemoteException {
        Objects.requireNonNull(zzlc, "null reference");
        gj1.j(zzlc.f);
        Objects.requireNonNull(e53, "null reference");
        y03 y03 = this.f;
        String str = zzlc.f;
        String str2 = zzlc.g;
        t43 t43 = new t43(e53, h);
        Objects.requireNonNull(y03);
        gj1.j(str);
        x73 x73 = new x73();
        gj1.j(str);
        x73.j = str;
        x73.n = str2;
        y03.f3986a.h(x73, new w03(t43));
    }

    @Override // defpackage.h53
    public final void o0(zzne zzne, e53 e53) throws RemoteException {
        Objects.requireNonNull(zzne, "null reference");
        Objects.requireNonNull(e53, "null reference");
        y03 y03 = this.f;
        String str = zzne.f;
        String str2 = zzne.g;
        t43 t43 = new t43(e53, h);
        Objects.requireNonNull(y03);
        gj1.j(str);
        gj1.j(str2);
        y03.e(str, new e03(y03, str2, t43));
    }

    @Override // defpackage.h53
    public final void o3(zzmo zzmo, e53 e53) {
        Objects.requireNonNull(zzmo, "null reference");
        Objects.requireNonNull(e53, "null reference");
        y03 y03 = this.f;
        String str = zzmo.f;
        t43 t43 = new t43(e53, h);
        Objects.requireNonNull(y03);
        y03.f3986a.d(new z73(str), new s03(y03, t43));
    }

    @Override // defpackage.h53
    public final void p3(zzmu zzmu, e53 e53) {
        Objects.requireNonNull(zzmu, "null reference");
        gj1.j(zzmu.f);
        gj1.j(zzmu.g);
        Objects.requireNonNull(e53, "null reference");
        y03 y03 = this.f;
        String str = zzmu.f;
        String str2 = zzmu.g;
        String str3 = zzmu.h;
        t43 t43 = new t43(e53, h);
        Objects.requireNonNull(y03);
        gj1.j(str);
        gj1.j(str2);
        y03.f3986a.e(null, new l83(str, str2, str3), new iz2(y03, t43));
    }

    @Override // defpackage.h53
    public final void u2(zzle zzle, e53 e53) {
        Objects.requireNonNull(zzle, "null reference");
        gj1.j(zzle.f);
        gj1.j(zzle.g);
        Objects.requireNonNull(e53, "null reference");
        y03 y03 = this.f;
        String str = zzle.f;
        String str2 = zzle.g;
        t43 t43 = new t43(e53, h);
        Objects.requireNonNull(y03);
        gj1.j(str);
        gj1.j(str2);
        y03.e(str, new u03(y03, str2, t43));
    }

    @Override // defpackage.h53
    public final void x3(zznc zznc, e53 e53) throws RemoteException {
        Objects.requireNonNull(zznc, "null reference");
        Objects.requireNonNull(e53, "null reference");
        String phoneNumber = zznc.f.getPhoneNumber();
        t43 t43 = new t43(e53, h);
        if (this.g.a(phoneNumber)) {
            if (zznc.j) {
                this.g.e(phoneNumber);
            } else {
                this.g.c(t43, phoneNumber);
                return;
            }
        }
        long j = zznc.i;
        boolean z = zznc.n;
        String str = zznc.g;
        String uid = zznc.f.getUid();
        String phoneNumber2 = zznc.f.getPhoneNumber();
        String str2 = zznc.h;
        String str3 = zznc.m;
        String str4 = zznc.l;
        gj1.j(phoneNumber2);
        e83 e83 = new e83(str, uid, phoneNumber2, str2, str3, str4);
        if (F(j, z)) {
            e83.m = new u63(this.g.d());
        }
        this.g.b(phoneNumber, t43, j, z);
        y03 y03 = this.f;
        n63 n63 = new n63(this.g, t43, phoneNumber);
        Objects.requireNonNull(y03);
        y03.f3986a.s(e83, new k03(n63));
    }

    @Override // defpackage.h53
    public final void y3(zzlm zzlm, e53 e53) {
        Objects.requireNonNull(zzlm, "null reference");
        gj1.j(zzlm.f);
        gj1.j(zzlm.g);
        Objects.requireNonNull(e53, "null reference");
        y03 y03 = this.f;
        String str = zzlm.f;
        String str2 = zzlm.g;
        String str3 = zzlm.h;
        t43 t43 = new t43(e53, h);
        Objects.requireNonNull(y03);
        gj1.j(str);
        gj1.j(str2);
        y03.f3986a.d(new z73(str, str2, str3), new hz2(y03, t43));
    }

    @Override // defpackage.h53
    public final void z3(zzly zzly, e53 e53) {
        Objects.requireNonNull(zzly, "null reference");
        gj1.j(zzly.f);
        gj1.j(zzly.g);
        gj1.j(zzly.h);
        Objects.requireNonNull(e53, "null reference");
        y03 y03 = this.f;
        String str = zzly.f;
        String str2 = zzly.g;
        String str3 = zzly.h;
        t43 t43 = new t43(e53, h);
        Objects.requireNonNull(y03);
        gj1.j(str);
        gj1.j(str2);
        gj1.j(str3);
        y03.e(str3, new vz2(y03, str, str2, t43));
    }
}
