package defpackage;

import defpackage.ru3;
import java.util.Objects;

/* renamed from: eq3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class eq3 extends ru3<eq3, a> implements dw3 {
    private static final eq3 zzh;
    private static volatile jw3<eq3> zzi;
    private int zzc;
    private hq3 zzd;
    private fq3 zze;
    private boolean zzf;
    private String zzg = "";

    /* renamed from: eq3$a */
    /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class a extends ru3.b<eq3, a> implements dw3 {
        public a() {
            super(eq3.zzh);
        }

        public a(iq3 iq3) {
            super(eq3.zzh);
        }
    }

    static {
        eq3 eq3 = new eq3();
        zzh = eq3;
        ru3.p(eq3.class, eq3);
    }

    public static eq3 C() {
        return zzh;
    }

    public static void t(eq3 eq3, String str) {
        Objects.requireNonNull(eq3);
        str.getClass();
        eq3.zzc |= 8;
        eq3.zzg = str;
    }

    public final boolean A() {
        return (this.zzc & 8) != 0;
    }

    public final String B() {
        return this.zzg;
    }

    @Override // defpackage.ru3
    public final Object n(int i, Object obj, Object obj2) {
        switch (iq3.f1559a[i - 1]) {
            case 1:
                return new eq3();
            case 2:
                return new a(null);
            case 3:
                return new ow3(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဇ\u0002\u0004ဈ\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
            case 4:
                return zzh;
            case 5:
                jw3<eq3> jw3 = zzi;
                if (jw3 == null) {
                    synchronized (eq3.class) {
                        jw3 = zzi;
                        if (jw3 == null) {
                            jw3 = new ru3.a<>(zzh);
                            zzi = jw3;
                        }
                    }
                }
                return jw3;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final boolean u() {
        return (this.zzc & 1) != 0;
    }

    public final hq3 v() {
        hq3 hq3 = this.zzd;
        return hq3 == null ? hq3.B() : hq3;
    }

    public final boolean w() {
        return (this.zzc & 2) != 0;
    }

    public final fq3 x() {
        fq3 fq3 = this.zze;
        return fq3 == null ? fq3.D() : fq3;
    }

    public final boolean y() {
        return (this.zzc & 4) != 0;
    }

    public final boolean z() {
        return this.zzf;
    }
}
