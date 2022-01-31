package defpackage;

import defpackage.ru3;
import java.util.List;

/* renamed from: hq3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class hq3 extends ru3<hq3, a> implements dw3 {
    private static final hq3 zzh;
    private static volatile jw3<hq3> zzi;
    private int zzc;
    private int zzd;
    private String zze = "";
    private boolean zzf;
    private zu3<String> zzg = mw3.i;

    /* renamed from: hq3$a */
    /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class a extends ru3.b<hq3, a> implements dw3 {
        public a(iq3 iq3) {
            super(hq3.zzh);
        }
    }

    /* renamed from: hq3$b */
    /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public enum b implements wu3 {
        UNKNOWN_MATCH_TYPE(0),
        REGEXP(1),
        BEGINS_WITH(2),
        ENDS_WITH(3),
        PARTIAL(4),
        EXACT(5),
        IN_LIST(6);
        
        private static final vu3<b> zzh = new lq3();
        private final int zzi;

        private b(int i) {
            this.zzi = i;
        }

        public static yu3 zzb() {
            return qq3.f2980a;
        }

        public final String toString() {
            return "<" + b.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzi + " name=" + name() + '>';
        }

        @Override // defpackage.wu3
        public final int zza() {
            return this.zzi;
        }

        public static b zza(int i) {
            switch (i) {
                case 0:
                    return UNKNOWN_MATCH_TYPE;
                case 1:
                    return REGEXP;
                case 2:
                    return BEGINS_WITH;
                case 3:
                    return ENDS_WITH;
                case 4:
                    return PARTIAL;
                case 5:
                    return EXACT;
                case 6:
                    return IN_LIST;
                default:
                    return null;
            }
        }
    }

    static {
        hq3 hq3 = new hq3();
        zzh = hq3;
        ru3.p(hq3.class, hq3);
    }

    public static hq3 B() {
        return zzh;
    }

    public final int A() {
        return this.zzg.size();
    }

    @Override // defpackage.ru3
    public final Object n(int i, Object obj, Object obj2) {
        switch (iq3.f1559a[i - 1]) {
            case 1:
                return new hq3();
            case 2:
                return new a(null);
            case 3:
                return new ow3(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ဇ\u0002\u0004\u001a", new Object[]{"zzc", "zzd", b.zzb(), "zze", "zzf", "zzg"});
            case 4:
                return zzh;
            case 5:
                jw3<hq3> jw3 = zzi;
                if (jw3 == null) {
                    synchronized (hq3.class) {
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

    public final boolean t() {
        return (this.zzc & 1) != 0;
    }

    public final b u() {
        b zza = b.zza(this.zzd);
        return zza == null ? b.UNKNOWN_MATCH_TYPE : zza;
    }

    public final boolean v() {
        return (this.zzc & 2) != 0;
    }

    public final String w() {
        return this.zze;
    }

    public final boolean x() {
        return (this.zzc & 4) != 0;
    }

    public final boolean y() {
        return this.zzf;
    }

    public final List<String> z() {
        return this.zzg;
    }
}
