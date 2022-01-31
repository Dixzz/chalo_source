package defpackage;

import android.text.TextUtils;
import android.util.Base64;
import com.google.android.gms.internal.p000firebaseauthapi.zzvz;
import com.google.android.gms.internal.p000firebaseauthapi.zzwg;
import com.google.android.gms.internal.p000firebaseauthapi.zzwm;
import com.google.android.gms.internal.p000firebaseauthapi.zzwo;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* renamed from: mz2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class mz2 implements e63<y73> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ x73 f2464a;
    public final /* synthetic */ zzvz b;
    public final /* synthetic */ t43 c;
    public final /* synthetic */ zzwg d;
    public final /* synthetic */ e63 e;

    public mz2(y03 y03, x73 x73, zzvz zzvz, t43 t43, zzwg zzwg, e63 e63) {
        this.f2464a = x73;
        this.b = zzvz;
        this.c = t43;
        this.d = zzwg;
        this.e = e63;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.e63
    public final void c(y73 y73) {
        String str;
        y73 y732 = y73;
        List<zzwm> list = null;
        if (this.f2464a.a("EMAIL")) {
            this.b.g = null;
        } else {
            String str2 = this.f2464a.h;
            if (str2 != null) {
                this.b.g = str2;
            }
        }
        if (this.f2464a.a("DISPLAY_NAME")) {
            this.b.i = null;
        } else {
            String str3 = this.f2464a.g;
            if (str3 != null) {
                this.b.i = str3;
            }
        }
        if (this.f2464a.a("PHOTO_URL")) {
            this.b.j = null;
        } else {
            String str4 = this.f2464a.k;
            if (str4 != null) {
                this.b.j = str4;
            }
        }
        if (!TextUtils.isEmpty(this.f2464a.i)) {
            zzvz zzvz = this.b;
            byte[] bytes = "redacted".getBytes();
            if (bytes == null) {
                str = null;
            } else {
                str = Base64.encodeToString(bytes, 0);
            }
            Objects.requireNonNull(zzvz);
            gj1.j(str);
            zzvz.l = str;
        }
        zzwo zzwo = y732.g;
        if (zzwo != null) {
            list = zzwo.f;
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        zzvz zzvz2 = this.b;
        Objects.requireNonNull(zzvz2);
        zzwo zzwo2 = new zzwo();
        zzvz2.k = zzwo2;
        zzwo2.f.addAll(list);
        t43 t43 = this.c;
        zzwg zzwg = this.d;
        Objects.requireNonNull(zzwg, "null reference");
        String str5 = y732.h;
        String str6 = y732.i;
        if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str6)) {
            zzwg = new zzwg(str6, str5, Long.valueOf(y732.j), zzwg.i);
        }
        t43.a(zzwg, this.b);
    }

    @Override // defpackage.e63
    public final void zza(String str) {
        this.e.zza(str);
    }
}
