package defpackage;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p000firebaseauthapi.zznq;
import com.google.android.gms.internal.p000firebaseauthapi.zzvz;
import com.google.android.gms.internal.p000firebaseauthapi.zzwg;
import com.google.android.gms.internal.p000firebaseauthapi.zzwr;
import java.util.Objects;

/* renamed from: t43  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public class t43 {

    /* renamed from: a  reason: collision with root package name */
    public final e53 f3307a;
    public final wa2 b;

    public t43(e53 e53, wa2 wa2) {
        Objects.requireNonNull(e53, "null reference");
        this.f3307a = e53;
        Objects.requireNonNull(wa2, "null reference");
        this.b = wa2;
    }

    public final void a(zzwg zzwg, zzvz zzvz) {
        try {
            this.f3307a.e2(zzwg, zzvz);
        } catch (RemoteException unused) {
            this.b.b("RemoteException when sending get token and account info user response", new Object[0]);
        }
    }

    public final void b(zzwr zzwr) {
        try {
            this.f3307a.w3(zzwr);
        } catch (RemoteException unused) {
            this.b.b("RemoteException when sending password reset response.", new Object[0]);
        }
    }

    public void c(String str) {
        try {
            this.f3307a.f0(str);
        } catch (RemoteException unused) {
            this.b.b("RemoteException when sending send verification code response.", new Object[0]);
        }
    }

    public void d(Status status) {
        try {
            this.f3307a.z1(status);
        } catch (RemoteException unused) {
            this.b.b("RemoteException when sending failure result.", new Object[0]);
        }
    }

    public final void e(zznq zznq) {
        try {
            this.f3307a.i1(zznq);
        } catch (RemoteException unused) {
            this.b.b("RemoteException when sending failure result for mfa", new Object[0]);
        }
    }
}
