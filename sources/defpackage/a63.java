package defpackage;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p000firebaseauthapi.zzno;
import com.google.android.gms.internal.p000firebaseauthapi.zznq;
import com.google.android.gms.internal.p000firebaseauthapi.zzvl;
import com.google.android.gms.internal.p000firebaseauthapi.zzvz;
import com.google.android.gms.internal.p000firebaseauthapi.zzwg;
import com.google.android.gms.internal.p000firebaseauthapi.zzwr;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.internal.zzai;
import com.google.firebase.auth.internal.zzao;
import java.util.Objects;

/* renamed from: a63  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class a63 extends d53 {
    public final /* synthetic */ d63 f;

    public a63(d63 d63) {
        this.f = d63;
    }

    @Override // defpackage.e53
    public final void E0(String str) throws RemoteException {
        int i = this.f.f798a;
        boolean z = i == 7;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        gj1.o(z, sb.toString());
        d63 d63 = this.f;
        Objects.requireNonNull(d63);
        d63.a();
        gj1.o(d63.q, "no success or failure set on method implementation");
    }

    public final void F(Status status, AuthCredential authCredential, String str, String str2) {
        zzao zzao = this.f.f;
        if (zzao != null) {
            zzao.zzb(status);
        }
        d63 d63 = this.f;
        d63.m = authCredential;
        d63.n = str;
        d63.o = str2;
        zzao zzao2 = d63.f;
        if (zzao2 != null) {
            zzao2.zzb(status);
        }
        d63 d632 = this.f;
        d632.q = true;
        d632.s.a(null, status);
    }

    @Override // defpackage.e53
    public final void G2(zzno zzno) {
        F(zzno.f, zzno.g, zzno.h, zzno.i);
    }

    @Override // defpackage.e53
    public final void H1(zzvl zzvl) throws RemoteException {
        int i = this.f.f798a;
        boolean z = i == 3;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        gj1.o(z, sb.toString());
        d63 d63 = this.f;
        d63.k = zzvl;
        d63.a();
        gj1.o(d63.q, "no success or failure set on method implementation");
    }

    @Override // defpackage.e53
    public final void K3(Status status, PhoneAuthCredential phoneAuthCredential) throws RemoteException {
        int i = this.f.f798a;
        boolean z = i == 2;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        gj1.o(z, sb.toString());
        F(status, phoneAuthCredential, null, null);
    }

    @Override // defpackage.e53
    public final void R1(zzwg zzwg) throws RemoteException {
        int i = this.f.f798a;
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Unexpected response type: ");
        sb.append(i);
        gj1.o(z, sb.toString());
        d63 d63 = this.f;
        d63.i = zzwg;
        d63.a();
        gj1.o(d63.q, "no success or failure set on method implementation");
    }

    @Override // defpackage.e53
    public final void X(PhoneAuthCredential phoneAuthCredential) throws RemoteException {
        int i = this.f.f798a;
        boolean z = i == 8;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        gj1.o(z, sb.toString());
        d63 d63 = this.f;
        d63.q = true;
        d63.h.execute(new z53(this, new w53(phoneAuthCredential)));
    }

    @Override // defpackage.e53
    public final void b() throws RemoteException {
        int i = this.f.f798a;
        boolean z = i == 6;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        gj1.o(z, sb.toString());
        d63.i(this.f);
    }

    @Override // defpackage.e53
    public final void b1(String str) throws RemoteException {
        int i = this.f.f798a;
        boolean z = i == 8;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        gj1.o(z, sb.toString());
        d63 d63 = this.f;
        Objects.requireNonNull(d63);
        d63.q = true;
        this.f.h.execute(new z53(this, new x53(str)));
    }

    @Override // defpackage.e53
    public final void e2(zzwg zzwg, zzvz zzvz) throws RemoteException {
        int i = this.f.f798a;
        boolean z = i == 2;
        StringBuilder sb = new StringBuilder(37);
        sb.append("Unexpected response type: ");
        sb.append(i);
        gj1.o(z, sb.toString());
        d63 d63 = this.f;
        d63.i = zzwg;
        d63.j = zzvz;
        d63.a();
        gj1.o(d63.q, "no success or failure set on method implementation");
    }

    @Override // defpackage.e53
    public final void f() throws RemoteException {
        int i = this.f.f798a;
        boolean z = i == 9;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        gj1.o(z, sb.toString());
        d63.i(this.f);
    }

    @Override // defpackage.e53
    public final void f0(String str) throws RemoteException {
        int i = this.f.f798a;
        boolean z = i == 8;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        gj1.o(z, sb.toString());
        Objects.requireNonNull(this.f);
        this.f.h.execute(new z53(this, new v53(str)));
    }

    @Override // defpackage.e53
    public final void h() throws RemoteException {
        int i = this.f.f798a;
        boolean z = i == 5;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        gj1.o(z, sb.toString());
        d63.i(this.f);
    }

    @Override // defpackage.e53
    public final void i1(zznq zznq) {
        d63 d63 = this.f;
        d63.p = zznq;
        d63.h(zzai.zza("REQUIRES_SECOND_FACTOR_AUTH"));
    }

    @Override // defpackage.e53
    public final void w3(zzwr zzwr) throws RemoteException {
        int i = this.f.f798a;
        boolean z = i == 4;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        gj1.o(z, sb.toString());
        d63 d63 = this.f;
        d63.l = zzwr;
        d63.a();
        gj1.o(d63.q, "no success or failure set on method implementation");
    }

    @Override // defpackage.e53
    public final void z1(Status status) throws RemoteException {
        String str = status.h;
        if (str != null) {
            if (str.contains("MISSING_MFA_PENDING_CREDENTIAL")) {
                status = new Status(17081, null);
            } else if (str.contains("MISSING_MFA_ENROLLMENT_ID")) {
                status = new Status(17082, null);
            } else if (str.contains("INVALID_MFA_PENDING_CREDENTIAL")) {
                status = new Status(17083, null);
            } else if (str.contains("MFA_ENROLLMENT_NOT_FOUND")) {
                status = new Status(17084, null);
            } else if (str.contains("ADMIN_ONLY_OPERATION")) {
                status = new Status(17085, null);
            } else if (str.contains("UNVERIFIED_EMAIL")) {
                status = new Status(17086, null);
            } else if (str.contains("SECOND_FACTOR_EXISTS")) {
                status = new Status(17087, null);
            } else if (str.contains("SECOND_FACTOR_LIMIT_EXCEEDED")) {
                status = new Status(17088, null);
            } else if (str.contains("UNSUPPORTED_FIRST_FACTOR")) {
                status = new Status(17089, null);
            } else if (str.contains("EMAIL_CHANGE_NEEDS_VERIFICATION")) {
                status = new Status(17090, null);
            }
        }
        d63 d63 = this.f;
        if (d63.f798a == 8) {
            d63.q = true;
            d63.h.execute(new z53(this, new y53(status)));
            return;
        }
        zzao zzao = d63.f;
        if (zzao != null) {
            zzao.zzb(status);
        }
        d63 d632 = this.f;
        d632.q = true;
        d632.s.a(null, status);
    }
}
