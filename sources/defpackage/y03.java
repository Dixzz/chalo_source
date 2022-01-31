package defpackage;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p000firebaseauthapi.zzno;
import com.google.android.gms.internal.p000firebaseauthapi.zzvz;
import com.google.android.gms.internal.p000firebaseauthapi.zzwg;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.internal.zzai;
import com.google.firebase.auth.zze;
import java.util.Objects;

/* renamed from: y03  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class y03 {

    /* renamed from: a  reason: collision with root package name */
    public final f63 f3986a;

    public y03(f63 f63) {
        this.f3986a = f63;
    }

    public static void b(y03 y03, i83 i83, t43 t43, e63 e63) {
        Status status;
        if (i83.f || !TextUtils.isEmpty(i83.q)) {
            zze a2 = i83.a();
            String str = i83.j;
            String str2 = i83.s;
            if (i83.f) {
                status = new Status(FirebaseError.ERROR_ACCOUNT_EXISTS_WITH_DIFFERENT_CREDENTIAL, null);
            } else {
                status = zzai.zza(i83.q);
            }
            zzno zzno = new zzno(status, a2, str, str2);
            Objects.requireNonNull(t43);
            try {
                t43.f3307a.G2(zzno);
            } catch (RemoteException unused) {
                t43.b.b("RemoteException when sending failure result with credential", new Object[0]);
            }
        } else {
            y03.f(new zzwg(i83.h, i83.g, Long.valueOf(i83.i), "Bearer"), i83.l, i83.k, Boolean.valueOf(i83.m), i83.a(), t43, e63);
        }
    }

    public static void c(y03 y03, t43 t43, zzwg zzwg, x73 x73, e63 e63) {
        Objects.requireNonNull(t43, "null reference");
        y03.f3986a.g(new h73(zzwg.g), new lz2(y03, e63, t43, zzwg, x73));
    }

    public static void d(y03 y03, t43 t43, zzwg zzwg, zzvz zzvz, x73 x73, e63 e63) {
        Objects.requireNonNull(t43, "null reference");
        Objects.requireNonNull(zzwg, "null reference");
        Objects.requireNonNull(zzvz, "null reference");
        Objects.requireNonNull(x73, "null reference");
        Objects.requireNonNull(e63, "null reference");
        y03.f3986a.h(x73, new mz2(y03, x73, zzvz, t43, zzwg, e63));
    }

    public final void e(String str, e63<zzwg> e63) {
        gj1.j(str);
        zzwg m1 = zzwg.m1(str);
        if (m1.zzb()) {
            e63.c(m1);
            return;
        }
        this.f3986a.a(new g73(m1.f), new x03(e63));
    }

    public final void f(zzwg zzwg, String str, String str2, Boolean bool, zze zze, t43 t43, e63 e63) {
        Objects.requireNonNull(zzwg, "null reference");
        Objects.requireNonNull(e63, "null reference");
        Objects.requireNonNull(t43, "null reference");
        this.f3986a.g(new h73(zzwg.g), new nz2(e63, str2, str, bool, zze, t43, zzwg));
    }
}
