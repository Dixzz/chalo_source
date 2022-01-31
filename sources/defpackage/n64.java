package defpackage;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.measurement.internal.zzap;
import java.util.Iterator;
import java.util.Objects;

/* renamed from: n64  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class n64 {

    /* renamed from: a  reason: collision with root package name */
    public final String f2517a;
    public final String b;
    public final String c;
    public final long d;
    public final long e;
    public final zzap f;

    public n64(vb4 vb4, String str, String str2, String str3, long j, long j2, zzap zzap) {
        gj1.j(str2);
        gj1.j(str3);
        Objects.requireNonNull(zzap, "null reference");
        this.f2517a = str2;
        this.b = str3;
        this.c = TextUtils.isEmpty(str) ? null : str;
        this.d = j;
        this.e = j2;
        if (j2 != 0 && j2 > j) {
            vb4.g().i.c("Event created with reverse previous/current timestamps. appId, name", ra4.q(str2), ra4.q(str3));
        }
        this.f = zzap;
    }

    public final n64 a(vb4 vb4, long j) {
        return new n64(vb4, this.c, this.f2517a, this.b, this.d, j, this.f);
    }

    public final String toString() {
        String str = this.f2517a;
        String str2 = this.b;
        String valueOf = String.valueOf(this.f);
        StringBuilder sb = new StringBuilder(valueOf.length() + String.valueOf(str2).length() + String.valueOf(str).length() + 33);
        sb.append("Event{appId='");
        sb.append(str);
        sb.append("', name='");
        sb.append(str2);
        sb.append("', params=");
        sb.append(valueOf);
        sb.append('}');
        return sb.toString();
    }

    public n64(vb4 vb4, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        zzap zzap;
        gj1.j(str2);
        gj1.j(str3);
        this.f2517a = str2;
        this.b = str3;
        this.c = TextUtils.isEmpty(str) ? null : str;
        this.d = j;
        this.e = j2;
        if (j2 != 0 && j2 > j) {
            vb4.g().i.b("Event created with reverse previous/current timestamps. appId", ra4.q(str2));
        }
        if (!bundle.isEmpty()) {
            Bundle bundle2 = new Bundle(bundle);
            Iterator<String> it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next == null) {
                    vb4.g().f.a("Param name can't be null");
                    it.remove();
                } else {
                    Object C = vb4.t().C(next, bundle2.get(next));
                    if (C == null) {
                        vb4.g().i.b("Param value can't be null", vb4.u().w(next));
                        it.remove();
                    } else {
                        vb4.t().H(bundle2, next, C);
                    }
                }
            }
            zzap = new zzap(bundle2);
        } else {
            zzap = new zzap(new Bundle());
        }
        this.f = zzap;
    }
}
