package defpackage;

import defpackage.ru3;

/* renamed from: zq3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class zq3 extends ru3<zq3, a> implements dw3 {
    private static final zq3 zzf;
    private static volatile jw3<zq3> zzg;
    private int zzc;
    private int zzd = 1;
    private zu3<vq3> zze = mw3.i;

    /* renamed from: zq3$a */
    /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class a extends ru3.b<zq3, a> implements dw3 {
        public a(er3 er3) {
            super(zq3.zzf);
        }
    }

    /* renamed from: zq3$b */
    /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public enum b implements wu3 {
        RADS(1),
        PROVISIONING(2);
        
        private static final vu3<b> zzc = new hr3();
        private final int zzd;

        private b(int i) {
            this.zzd = i;
        }

        public static yu3 zzb() {
            return ir3.f1564a;
        }

        public final String toString() {
            return "<" + b.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzd + " name=" + name() + '>';
        }

        @Override // defpackage.wu3
        public final int zza() {
            return this.zzd;
        }

        public static b zza(int i) {
            if (i == 1) {
                return RADS;
            }
            if (i != 2) {
                return null;
            }
            return PROVISIONING;
        }
    }

    static {
        zq3 zq3 = new zq3();
        zzf = zq3;
        ru3.p(zq3.class, zq3);
    }

    @Override // defpackage.ru3
    public final Object n(int i, Object obj, Object obj2) {
        switch (er3.f1019a[i - 1]) {
            case 1:
                return new zq3();
            case 2:
                return new a(null);
            case 3:
                return new ow3(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u001b", new Object[]{"zzc", "zzd", b.zzb(), "zze", vq3.class});
            case 4:
                return zzf;
            case 5:
                jw3<zq3> jw3 = zzg;
                if (jw3 == null) {
                    synchronized (zq3.class) {
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
}
