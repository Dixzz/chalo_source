package defpackage;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.zzap;
import com.google.android.gms.measurement.internal.zzaq;

/* renamed from: va4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class va4 {

    /* renamed from: a  reason: collision with root package name */
    public String f3625a;
    public String b;
    public long c;
    public Bundle d;

    public va4(String str, String str2, Bundle bundle, long j) {
        this.f3625a = str;
        this.b = str2;
        this.d = bundle;
        this.c = j;
    }

    public static va4 b(zzaq zzaq) {
        return new va4(zzaq.f, zzaq.h, zzaq.g.m1(), zzaq.i);
    }

    public final zzaq a() {
        return new zzaq(this.f3625a, new zzap(new Bundle(this.d)), this.b, this.c);
    }

    public final String toString() {
        String str = this.b;
        String str2 = this.f3625a;
        String valueOf = String.valueOf(this.d);
        StringBuilder sb = new StringBuilder(valueOf.length() + hj1.g0(str2, hj1.g0(str, 21)));
        sb.append("origin=");
        sb.append(str);
        sb.append(",name=");
        sb.append(str2);
        return hj1.a0(sb, ",params=", valueOf);
    }
}
