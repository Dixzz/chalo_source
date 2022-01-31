package defpackage;

import defpackage.ru3;
import java.util.Objects;

/* renamed from: gq3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class gq3 extends ru3<gq3, a> implements dw3 {
    private static final gq3 zzj;
    private static volatile jw3<gq3> zzk;
    private int zzc;
    private int zzd;
    private String zze = "";
    private eq3 zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;

    /* renamed from: gq3$a */
    /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class a extends ru3.b<gq3, a> implements dw3 {
        public a() {
            super(gq3.zzj);
        }

        public a(iq3 iq3) {
            super(gq3.zzj);
        }
    }

    static {
        gq3 gq3 = new gq3();
        zzj = gq3;
        ru3.p(gq3.class, gq3);
    }

    public static a C() {
        return (a) zzj.q();
    }

    public static void t(gq3 gq3, String str) {
        Objects.requireNonNull(gq3);
        str.getClass();
        gq3.zzc |= 2;
        gq3.zze = str;
    }

    public final boolean A() {
        return (this.zzc & 32) != 0;
    }

    public final boolean B() {
        return this.zzi;
    }

    @Override // defpackage.ru3
    public final Object n(int i, Object obj, Object obj2) {
        switch (iq3.f1559a[i - 1]) {
            case 1:
                return new gq3();
            case 2:
                return new a(null);
            case 3:
                return new ow3(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0003ဉ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
            case 4:
                return zzj;
            case 5:
                jw3<gq3> jw3 = zzk;
                if (jw3 == null) {
                    synchronized (gq3.class) {
                        jw3 = zzk;
                        if (jw3 == null) {
                            jw3 = new ru3.a<>(zzj);
                            zzk = jw3;
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

    public final int v() {
        return this.zzd;
    }

    public final String w() {
        return this.zze;
    }

    public final eq3 x() {
        eq3 eq3 = this.zzf;
        return eq3 == null ? eq3.C() : eq3;
    }

    public final boolean y() {
        return this.zzg;
    }

    public final boolean z() {
        return this.zzh;
    }
}
