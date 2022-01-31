package defpackage;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import defpackage.ru3;
import java.util.Objects;

/* renamed from: cr3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class cr3 extends ru3<cr3, a> implements dw3 {
    private static final cr3 zzj;
    private static volatile jw3<cr3> zzk;
    private int zzc;
    private long zzd;
    private String zze = "";
    private String zzf = "";
    private long zzg;
    private float zzh;
    private double zzi;

    /* renamed from: cr3$a */
    /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class a extends ru3.b<cr3, a> implements dw3 {
        public a() {
            super(cr3.zzj);
        }

        public final a l(long j) {
            if (this.h) {
                i();
                this.h = false;
            }
            cr3.v((cr3) this.g, j);
            return this;
        }

        public final a m(String str) {
            if (this.h) {
                i();
                this.h = false;
            }
            cr3.w((cr3) this.g, str);
            return this;
        }

        public final a o(long j) {
            if (this.h) {
                i();
                this.h = false;
            }
            cr3.A((cr3) this.g, j);
            return this;
        }

        public a(er3 er3) {
            super(cr3.zzj);
        }
    }

    static {
        cr3 cr3 = new cr3();
        zzj = cr3;
        ru3.p(cr3.class, cr3);
    }

    public static void A(cr3 cr3, long j) {
        cr3.zzc |= 8;
        cr3.zzg = j;
    }

    public static void B(cr3 cr3, String str) {
        Objects.requireNonNull(cr3);
        str.getClass();
        cr3.zzc |= 4;
        cr3.zzf = str;
    }

    public static void D(cr3 cr3) {
        cr3.zzc &= -33;
        cr3.zzi = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    public static a K() {
        return (a) zzj.q();
    }

    public static void t(cr3 cr3) {
        cr3.zzc &= -5;
        cr3.zzf = zzj.zzf;
    }

    public static void u(cr3 cr3, double d) {
        cr3.zzc |= 32;
        cr3.zzi = d;
    }

    public static void v(cr3 cr3, long j) {
        cr3.zzc |= 1;
        cr3.zzd = j;
    }

    public static void w(cr3 cr3, String str) {
        Objects.requireNonNull(cr3);
        str.getClass();
        cr3.zzc |= 2;
        cr3.zze = str;
    }

    public static void z(cr3 cr3) {
        cr3.zzc &= -9;
        cr3.zzg = 0;
    }

    public final String C() {
        return this.zze;
    }

    public final boolean E() {
        return (this.zzc & 4) != 0;
    }

    public final String F() {
        return this.zzf;
    }

    public final boolean G() {
        return (this.zzc & 8) != 0;
    }

    public final long H() {
        return this.zzg;
    }

    public final boolean I() {
        return (this.zzc & 32) != 0;
    }

    public final double J() {
        return this.zzi;
    }

    @Override // defpackage.ru3
    public final Object n(int i, Object obj, Object obj2) {
        switch (er3.f1019a[i - 1]) {
            case 1:
                return new cr3();
            case 2:
                return new a(null);
            case 3:
                return new ow3(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဂ\u0003\u0005ခ\u0004\u0006က\u0005", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
            case 4:
                return zzj;
            case 5:
                jw3<cr3> jw3 = zzk;
                if (jw3 == null) {
                    synchronized (cr3.class) {
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

    public final boolean x() {
        return (this.zzc & 1) != 0;
    }

    public final long y() {
        return this.zzd;
    }
}
