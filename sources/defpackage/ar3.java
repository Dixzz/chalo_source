package defpackage;

import defpackage.ru3;
import java.util.List;
import java.util.Objects;

/* renamed from: ar3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class ar3 extends ru3<ar3, a> implements dw3 {
    private static final ar3 zzg;
    private static volatile jw3<ar3> zzh;
    private av3 zzc;
    private av3 zzd;
    private zu3<tq3> zze;
    private zu3<br3> zzf;

    /* renamed from: ar3$a */
    /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class a extends ru3.b<ar3, a> implements dw3 {
        public a() {
            super(ar3.zzg);
        }

        public a(er3 er3) {
            super(ar3.zzg);
        }
    }

    static {
        ar3 ar3 = new ar3();
        zzg = ar3;
        ru3.p(ar3.class, ar3);
    }

    public ar3() {
        qv3 qv3 = qv3.i;
        this.zzc = qv3;
        this.zzd = qv3;
        mw3<Object> mw3 = mw3.i;
        this.zze = mw3;
        this.zzf = mw3;
    }

    public static void A(ar3 ar3) {
        Objects.requireNonNull(ar3);
        ar3.zzd = qv3.i;
    }

    public static void B(ar3 ar3, int i) {
        zu3<br3> zu3 = ar3.zzf;
        if (!zu3.zza()) {
            ar3.zzf = ru3.l(zu3);
        }
        ar3.zzf.remove(i);
    }

    public static void C(ar3 ar3, Iterable iterable) {
        av3 av3 = ar3.zzd;
        if (!((lt3) av3).f) {
            ar3.zzd = ru3.m(av3);
        }
        it3.f(iterable, ar3.zzd);
    }

    public static void E(ar3 ar3, Iterable iterable) {
        zu3<tq3> zu3 = ar3.zze;
        if (!zu3.zza()) {
            ar3.zze = ru3.l(zu3);
        }
        it3.f(iterable, ar3.zze);
    }

    public static void G(ar3 ar3, Iterable iterable) {
        zu3<br3> zu3 = ar3.zzf;
        if (!zu3.zza()) {
            ar3.zzf = ru3.l(zu3);
        }
        it3.f(iterable, ar3.zzf);
    }

    public static a L() {
        return (a) zzg.q();
    }

    public static ar3 M() {
        return zzg;
    }

    public static void v(ar3 ar3) {
        Objects.requireNonNull(ar3);
        ar3.zzc = qv3.i;
    }

    public static void w(ar3 ar3, int i) {
        zu3<tq3> zu3 = ar3.zze;
        if (!zu3.zza()) {
            ar3.zze = ru3.l(zu3);
        }
        ar3.zze.remove(i);
    }

    public static void x(ar3 ar3, Iterable iterable) {
        av3 av3 = ar3.zzc;
        if (!((lt3) av3).f) {
            ar3.zzc = ru3.m(av3);
        }
        it3.f(iterable, ar3.zzc);
    }

    public final List<Long> D() {
        return this.zzd;
    }

    public final int F() {
        return ((qv3) this.zzd).size();
    }

    public final List<tq3> H() {
        return this.zze;
    }

    public final int I() {
        return this.zze.size();
    }

    public final List<br3> J() {
        return this.zzf;
    }

    public final int K() {
        return this.zzf.size();
    }

    @Override // defpackage.ru3
    public final Object n(int i, Object obj, Object obj2) {
        switch (er3.f1019a[i - 1]) {
            case 1:
                return new ar3();
            case 2:
                return new a(null);
            case 3:
                return new ow3(zzg, "\u0001\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u0015\u0002\u0015\u0003\u001b\u0004\u001b", new Object[]{"zzc", "zzd", "zze", tq3.class, "zzf", br3.class});
            case 4:
                return zzg;
            case 5:
                jw3<ar3> jw3 = zzh;
                if (jw3 == null) {
                    synchronized (ar3.class) {
                        jw3 = zzh;
                        if (jw3 == null) {
                            jw3 = new ru3.a<>(zzg);
                            zzh = jw3;
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

    public final tq3 t(int i) {
        return this.zze.get(i);
    }

    public final List<Long> u() {
        return this.zzc;
    }

    public final int y() {
        return ((qv3) this.zzc).size();
    }

    public final br3 z(int i) {
        return this.zzf.get(i);
    }
}
