package defpackage;

import defpackage.ru3;

/* renamed from: tq3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class tq3 extends ru3<tq3, a> implements dw3 {
    private static final tq3 zzf;
    private static volatile jw3<tq3> zzg;
    private int zzc;
    private int zzd;
    private long zze;

    /* renamed from: tq3$a */
    /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class a extends ru3.b<tq3, a> implements dw3 {
        public a() {
            super(tq3.zzf);
        }

        public a(er3 er3) {
            super(tq3.zzf);
        }
    }

    static {
        tq3 tq3 = new tq3();
        zzf = tq3;
        ru3.p(tq3.class, tq3);
    }

    public static void t(tq3 tq3, int i) {
        tq3.zzc |= 1;
        tq3.zzd = i;
    }

    public static void u(tq3 tq3, long j) {
        tq3.zzc |= 2;
        tq3.zze = j;
    }

    public static a z() {
        return (a) zzf.q();
    }

    @Override // defpackage.ru3
    public final Object n(int i, Object obj, Object obj2) {
        switch (er3.f1019a[i - 1]) {
            case 1:
                return new tq3();
            case 2:
                return new a(null);
            case 3:
                return new ow3(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဂ\u0001", new Object[]{"zzc", "zzd", "zze"});
            case 4:
                return zzf;
            case 5:
                jw3<tq3> jw3 = zzg;
                if (jw3 == null) {
                    synchronized (tq3.class) {
                        jw3 = zzg;
                        if (jw3 == null) {
                            jw3 = new ru3.a<>(zzf);
                            zzg = jw3;
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

    public final boolean v() {
        return (this.zzc & 1) != 0;
    }

    public final int w() {
        return this.zzd;
    }

    public final boolean x() {
        return (this.zzc & 2) != 0;
    }

    public final long y() {
        return this.zze;
    }
}
