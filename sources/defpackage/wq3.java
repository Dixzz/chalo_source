package defpackage;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import defpackage.ru3;
import java.util.List;
import java.util.Objects;

/* renamed from: wq3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class wq3 extends ru3<wq3, a> implements dw3 {
    private static final wq3 zzj;
    private static volatile jw3<wq3> zzk;
    private int zzc;
    private String zzd = "";
    private String zze = "";
    private long zzf;
    private float zzg;
    private double zzh;
    private zu3<wq3> zzi = mw3.i;

    /* renamed from: wq3$a */
    /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class a extends ru3.b<wq3, a> implements dw3 {
        public a() {
            super(wq3.zzj);
        }

        public final a l(double d) {
            if (this.h) {
                i();
                this.h = false;
            }
            wq3.u((wq3) this.g, d);
            return this;
        }

        public final a m(long j) {
            if (this.h) {
                i();
                this.h = false;
            }
            wq3.v((wq3) this.g, j);
            return this;
        }

        public final a o(String str) {
            if (this.h) {
                i();
                this.h = false;
            }
            wq3.y((wq3) this.g, str);
            return this;
        }

        public final a p(String str) {
            if (this.h) {
                i();
                this.h = false;
            }
            wq3.C((wq3) this.g, str);
            return this;
        }

        public a(er3 er3) {
            super(wq3.zzj);
        }
    }

    static {
        wq3 wq3 = new wq3();
        zzj = wq3;
        ru3.p(wq3.class, wq3);
    }

    public static void B(wq3 wq3) {
        wq3.zzc &= -5;
        wq3.zzf = 0;
    }

    public static void C(wq3 wq3, String str) {
        Objects.requireNonNull(wq3);
        str.getClass();
        wq3.zzc |= 2;
        wq3.zze = str;
    }

    public static void D(wq3 wq3) {
        wq3.zzc &= -17;
        wq3.zzh = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    public static void G(wq3 wq3) {
        Objects.requireNonNull(wq3);
        wq3.zzi = mw3.i;
    }

    public static a P() {
        return (a) zzj.q();
    }

    public static void t(wq3 wq3) {
        wq3.zzc &= -3;
        wq3.zze = zzj.zze;
    }

    public static void u(wq3 wq3, double d) {
        wq3.zzc |= 16;
        wq3.zzh = d;
    }

    public static void v(wq3 wq3, long j) {
        wq3.zzc |= 4;
        wq3.zzf = j;
    }

    public static void w(wq3 wq3, wq3 wq32) {
        Objects.requireNonNull(wq3);
        zu3<wq3> zu3 = wq3.zzi;
        if (!zu3.zza()) {
            wq3.zzi = ru3.l(zu3);
        }
        wq3.zzi.add(wq32);
    }

    public static void x(wq3 wq3, Iterable iterable) {
        zu3<wq3> zu3 = wq3.zzi;
        if (!zu3.zza()) {
            wq3.zzi = ru3.l(zu3);
        }
        it3.f(iterable, wq3.zzi);
    }

    public static void y(wq3 wq3, String str) {
        Objects.requireNonNull(wq3);
        str.getClass();
        wq3.zzc |= 1;
        wq3.zzd = str;
    }

    public final String A() {
        return this.zzd;
    }

    public final boolean E() {
        return (this.zzc & 2) != 0;
    }

    public final String F() {
        return this.zze;
    }

    public final boolean H() {
        return (this.zzc & 4) != 0;
    }

    public final long I() {
        return this.zzf;
    }

    public final boolean J() {
        return (this.zzc & 8) != 0;
    }

    public final float K() {
        return this.zzg;
    }

    public final boolean L() {
        return (this.zzc & 16) != 0;
    }

    public final double M() {
        return this.zzh;
    }

    public final List<wq3> N() {
        return this.zzi;
    }

    public final int O() {
        return this.zzi.size();
    }

    @Override // defpackage.ru3
    public final Object n(int i, Object obj, Object obj2) {
        switch (er3.f1019a[i - 1]) {
            case 1:
                return new wq3();
            case 2:
                return new a(null);
            case 3:
                return new ow3(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ခ\u0003\u0005က\u0004\u0006\u001b", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", wq3.class});
            case 4:
                return zzj;
            case 5:
                jw3<wq3> jw3 = zzk;
                if (jw3 == null) {
                    synchronized (wq3.class) {
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

    public final boolean z() {
        return (this.zzc & 1) != 0;
    }
}
