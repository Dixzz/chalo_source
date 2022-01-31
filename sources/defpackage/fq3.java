package defpackage;

import defpackage.ru3;

/* renamed from: fq3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class fq3 extends ru3<fq3, b> implements dw3 {
    private static final fq3 zzi;
    private static volatile jw3<fq3> zzj;
    private int zzc;
    private int zzd;
    private boolean zze;
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";

    /* renamed from: fq3$a */
    /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public enum a implements wu3 {
        UNKNOWN_COMPARISON_TYPE(0),
        LESS_THAN(1),
        GREATER_THAN(2),
        EQUAL(3),
        BETWEEN(4);
        
        private static final vu3<a> zzf = new kq3();
        private final int zzg;

        private a(int i) {
            this.zzg = i;
        }

        public static yu3 zzb() {
            return jq3.f1970a;
        }

        public final String toString() {
            return "<" + a.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzg + " name=" + name() + '>';
        }

        @Override // defpackage.wu3
        public final int zza() {
            return this.zzg;
        }

        public static a zza(int i) {
            if (i == 0) {
                return UNKNOWN_COMPARISON_TYPE;
            }
            if (i == 1) {
                return LESS_THAN;
            }
            if (i == 2) {
                return GREATER_THAN;
            }
            if (i == 3) {
                return EQUAL;
            }
            if (i != 4) {
                return null;
            }
            return BETWEEN;
        }
    }

    /* renamed from: fq3$b */
    /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class b extends ru3.b<fq3, b> implements dw3 {
        public b(iq3 iq3) {
            super(fq3.zzi);
        }
    }

    static {
        fq3 fq3 = new fq3();
        zzi = fq3;
        ru3.p(fq3.class, fq3);
    }

    public static fq3 D() {
        return zzi;
    }

    public final String A() {
        return this.zzg;
    }

    public final boolean B() {
        return (this.zzc & 16) != 0;
    }

    public final String C() {
        return this.zzh;
    }

    @Override // defpackage.ru3
    public final Object n(int i, Object obj, Object obj2) {
        switch (iq3.f1559a[i - 1]) {
            case 1:
                return new fq3();
            case 2:
                return new b(null);
            case 3:
                return new ow3(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004", new Object[]{"zzc", "zzd", a.zzb(), "zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzi;
            case 5:
                jw3<fq3> jw3 = zzj;
                if (jw3 == null) {
                    synchronized (fq3.class) {
                        jw3 = zzj;
                        if (jw3 == null) {
                            jw3 = new ru3.a<>(zzi);
                            zzj = jw3;
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

    public final boolean t() {
        return (this.zzc & 1) != 0;
    }

    public final a u() {
        a zza = a.zza(this.zzd);
        return zza == null ? a.UNKNOWN_COMPARISON_TYPE : zza;
    }

    public final boolean v() {
        return (this.zzc & 2) != 0;
    }

    public final boolean w() {
        return this.zze;
    }

    public final boolean x() {
        return (this.zzc & 4) != 0;
    }

    public final String y() {
        return this.zzf;
    }

    public final boolean z() {
        return (this.zzc & 8) != 0;
    }
}
