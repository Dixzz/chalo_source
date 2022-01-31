package defpackage;

import defpackage.ru3;

/* renamed from: mr3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class mr3 extends ru3<mr3, b> implements dw3 {
    private static final mr3 zzk;
    private static volatile jw3<mr3> zzl;
    private int zzc;
    private int zzd;
    private String zze = "";
    private boolean zzf;
    private long zzg;
    private double zzh;
    private zu3<mr3> zzi = mw3.i;
    private String zzj = "";

    /* renamed from: mr3$a */
    /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public enum a implements wu3 {
        UNKNOWN(0),
        STRING(1),
        NUMBER(2),
        BOOLEAN(3),
        STATEMENT(4);
        
        private static final vu3<a> zzf = new pr3();
        private final int zzg;

        private a(int i) {
            this.zzg = i;
        }

        public static yu3 zzb() {
            return or3.f2725a;
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
                return UNKNOWN;
            }
            if (i == 1) {
                return STRING;
            }
            if (i == 2) {
                return NUMBER;
            }
            if (i == 3) {
                return BOOLEAN;
            }
            if (i != 4) {
                return null;
            }
            return STATEMENT;
        }
    }

    /* renamed from: mr3$b */
    /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class b extends ru3.b<mr3, b> implements dw3 {
        public b(nr3 nr3) {
            super(mr3.zzk);
        }
    }

    static {
        mr3 mr3 = new mr3();
        zzk = mr3;
        ru3.p(mr3.class, mr3);
    }

    @Override // defpackage.ru3
    public final Object n(int i, Object obj, Object obj2) {
        switch (nr3.f2597a[i - 1]) {
            case 1:
                return new mr3();
            case 2:
                return new b(null);
            case 3:
                return new ow3(zzk, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0001\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ဇ\u0002\u0004ဂ\u0003\u0005က\u0004\u0006\u001b\u0007ဈ\u0005", new Object[]{"zzc", "zzd", a.zzb(), "zze", "zzf", "zzg", "zzh", "zzi", mr3.class, "zzj"});
            case 4:
                return zzk;
            case 5:
                jw3<mr3> jw3 = zzl;
                if (jw3 == null) {
                    synchronized (mr3.class) {
                        jw3 = zzl;
                        if (jw3 == null) {
                            jw3 = new ru3.a<>(zzk);
                            zzl = jw3;
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
