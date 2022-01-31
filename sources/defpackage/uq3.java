package defpackage;

import defpackage.ru3;
import defpackage.wq3;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* renamed from: uq3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class uq3 extends ru3<uq3, a> implements dw3 {
    private static final uq3 zzi;
    private static volatile jw3<uq3> zzj;
    private int zzc;
    private zu3<wq3> zzd = mw3.i;
    private String zze = "";
    private long zzf;
    private long zzg;
    private int zzh;

    /* renamed from: uq3$a */
    /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class a extends ru3.b<uq3, a> implements dw3 {
        public a() {
            super(uq3.zzi);
        }

        public final a l(int i, wq3 wq3) {
            if (this.h) {
                i();
                this.h = false;
            }
            uq3.x((uq3) this.g, i, wq3);
            return this;
        }

        public final a m(long j) {
            if (this.h) {
                i();
                this.h = false;
            }
            uq3.y((uq3) this.g, j);
            return this;
        }

        public final a o(wq3.a aVar) {
            if (this.h) {
                i();
                this.h = false;
            }
            uq3.z((uq3) this.g, (wq3) ((ru3) aVar.k()));
            return this;
        }

        public final a p(String str) {
            if (this.h) {
                i();
                this.h = false;
            }
            uq3.B((uq3) this.g, str);
            return this;
        }

        public final wq3 q(int i) {
            return ((uq3) this.g).t(i);
        }

        public final List<wq3> s() {
            return Collections.unmodifiableList(((uq3) this.g).u());
        }

        public final int t() {
            return ((uq3) this.g).C();
        }

        public final a u(int i) {
            if (this.h) {
                i();
                this.h = false;
            }
            uq3.w((uq3) this.g, i);
            return this;
        }

        public final String v() {
            return ((uq3) this.g).E();
        }

        public final long w() {
            return ((uq3) this.g).G();
        }

        public final long x() {
            return ((uq3) this.g).I();
        }

        public a(er3 er3) {
            super(uq3.zzi);
        }
    }

    static {
        uq3 uq3 = new uq3();
        zzi = uq3;
        ru3.p(uq3.class, uq3);
    }

    public static void A(uq3 uq3, Iterable iterable) {
        uq3.N();
        it3.f(iterable, uq3.zzd);
    }

    public static void B(uq3 uq3, String str) {
        Objects.requireNonNull(uq3);
        str.getClass();
        uq3.zzc |= 1;
        uq3.zze = str;
    }

    public static void D(uq3 uq3, long j) {
        uq3.zzc |= 4;
        uq3.zzg = j;
    }

    public static a L() {
        return (a) zzi.q();
    }

    public static void v(uq3 uq3) {
        Objects.requireNonNull(uq3);
        uq3.zzd = mw3.i;
    }

    public static void w(uq3 uq3, int i) {
        uq3.N();
        uq3.zzd.remove(i);
    }

    public static void x(uq3 uq3, int i, wq3 wq3) {
        Objects.requireNonNull(uq3);
        wq3.getClass();
        uq3.N();
        uq3.zzd.set(i, wq3);
    }

    public static void y(uq3 uq3, long j) {
        uq3.zzc |= 2;
        uq3.zzf = j;
    }

    public static void z(uq3 uq3, wq3 wq3) {
        Objects.requireNonNull(uq3);
        wq3.getClass();
        uq3.N();
        uq3.zzd.add(wq3);
    }

    public final int C() {
        return this.zzd.size();
    }

    public final String E() {
        return this.zze;
    }

    public final boolean F() {
        return (this.zzc & 2) != 0;
    }

    public final long G() {
        return this.zzf;
    }

    public final boolean H() {
        return (this.zzc & 4) != 0;
    }

    public final long I() {
        return this.zzg;
    }

    public final boolean J() {
        return (this.zzc & 8) != 0;
    }

    public final int K() {
        return this.zzh;
    }

    public final void N() {
        zu3<wq3> zu3 = this.zzd;
        if (!zu3.zza()) {
            this.zzd = ru3.l(zu3);
        }
    }

    @Override // defpackage.ru3
    public final Object n(int i, Object obj, Object obj2) {
        switch (er3.f1019a[i - 1]) {
            case 1:
                return new uq3();
            case 2:
                return new a(null);
            case 3:
                return new ow3(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u001b\u0002ဈ\u0000\u0003ဂ\u0001\u0004ဂ\u0002\u0005င\u0003", new Object[]{"zzc", "zzd", wq3.class, "zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzi;
            case 5:
                jw3<uq3> jw3 = zzj;
                if (jw3 == null) {
                    synchronized (uq3.class) {
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

    public final wq3 t(int i) {
        return this.zzd.get(i);
    }

    public final List<wq3> u() {
        return this.zzd;
    }
}
