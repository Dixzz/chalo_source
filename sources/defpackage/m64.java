package defpackage;

/* renamed from: m64  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class m64 {

    /* renamed from: a  reason: collision with root package name */
    public final String f2331a;
    public final String b;
    public final long c;
    public final long d;
    public final long e;
    public final long f;
    public final long g;
    public final Long h;
    public final Long i;
    public final Long j;
    public final Boolean k;

    public m64(String str, String str2, long j2, long j3, long j4, long j5, long j6, Long l, Long l2, Long l3, Boolean bool) {
        gj1.j(str);
        gj1.j(str2);
        boolean z = true;
        gj1.b(j2 >= 0);
        gj1.b(j3 >= 0);
        gj1.b(j4 >= 0);
        gj1.b(j6 < 0 ? false : z);
        this.f2331a = str;
        this.b = str2;
        this.c = j2;
        this.d = j3;
        this.e = j4;
        this.f = j5;
        this.g = j6;
        this.h = l;
        this.i = l2;
        this.j = l3;
        this.k = bool;
    }

    public final m64 a(long j2) {
        return new m64(this.f2331a, this.b, this.c, this.d, this.e, j2, this.g, this.h, this.i, this.j, this.k);
    }

    public final m64 b(long j2, long j3) {
        return new m64(this.f2331a, this.b, this.c, this.d, this.e, this.f, j2, Long.valueOf(j3), this.i, this.j, this.k);
    }

    public final m64 c(Long l, Long l2, Boolean bool) {
        return new m64(this.f2331a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, l, l2, (bool == null || bool.booleanValue()) ? bool : null);
    }

    public m64(String str, String str2, long j2) {
        this(str, str2, 0, 0, 0, j2, 0, null, null, null, null);
    }
}
