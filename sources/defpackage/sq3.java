package defpackage;

import defpackage.ru3;
import java.util.Objects;

/* renamed from: sq3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class sq3 extends ru3<sq3, a> implements dw3 {
    private static final sq3 zzh;
    private static volatile jw3<sq3> zzi;
    private int zzc;
    private int zzd;
    private ar3 zze;
    private ar3 zzf;
    private boolean zzg;

    /* renamed from: sq3$a */
    /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class a extends ru3.b<sq3, a> implements dw3 {
        public a() {
            super(sq3.zzh);
        }

        public a(er3 er3) {
            super(sq3.zzh);
        }
    }

    static {
        sq3 sq3 = new sq3();
        zzh = sq3;
        ru3.p(sq3.class, sq3);
    }

    public static a E() {
        return (a) zzh.q();
    }

    public static void t(sq3 sq3, int i) {
        sq3.zzc |= 1;
        sq3.zzd = i;
    }

    public static void u(sq3 sq3, ar3 ar3) {
        Objects.requireNonNull(sq3);
        sq3.zze = ar3;
        sq3.zzc |= 2;
    }

    public static void v(sq3 sq3, boolean z) {
        sq3.zzc |= 8;
        sq3.zzg = z;
    }

    public static void y(sq3 sq3, ar3 ar3) {
        Objects.requireNonNull(sq3);
        ar3.getClass();
        sq3.zzf = ar3;
        sq3.zzc |= 4;
    }

    public final boolean A() {
        return (this.zzc & 4) != 0;
    }

    public final ar3 B() {
        ar3 ar3 = this.zzf;
        return ar3 == null ? ar3.M() : ar3;
    }

    public final boolean C() {
        return (this.zzc & 8) != 0;
    }

    public final boolean D() {
        return this.zzg;
    }

    @Override // defpackage.ru3
    public final Object n(int i, Object obj, Object obj2) {
        switch (er3.f1019a[i - 1]) {
            case 1:
                return new sq3();
            case 2:
                return new a(null);
            case 3:
                return new ow3(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဇ\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
            case 4:
                return zzh;
            case 5:
                jw3<sq3> jw3 = zzi;
                if (jw3 == null) {
                    synchronized (sq3.class) {
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

    public final boolean w() {
        return (this.zzc & 1) != 0;
    }

    public final int x() {
        return this.zzd;
    }

    public final ar3 z() {
        ar3 ar3 = this.zze;
        return ar3 == null ? ar3.M() : ar3;
    }
}
