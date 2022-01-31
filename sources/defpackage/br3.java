package defpackage;

import defpackage.ru3;
import java.util.List;

/* renamed from: br3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class br3 extends ru3<br3, a> implements dw3 {
    private static final br3 zzf;
    private static volatile jw3<br3> zzg;
    private int zzc;
    private int zzd;
    private av3 zze = qv3.i;

    /* renamed from: br3$a */
    /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class a extends ru3.b<br3, a> implements dw3 {
        public a() {
            super(br3.zzf);
        }

        public a(er3 er3) {
            super(br3.zzf);
        }
    }

    static {
        br3 br3 = new br3();
        zzf = br3;
        ru3.p(br3.class, br3);
    }

    public static a A() {
        return (a) zzf.q();
    }

    public static void u(br3 br3, int i) {
        br3.zzc |= 1;
        br3.zzd = i;
    }

    public static void v(br3 br3, Iterable iterable) {
        av3 av3 = br3.zze;
        if (!((lt3) av3).f) {
            br3.zze = ru3.m(av3);
        }
        it3.f(iterable, br3.zze);
    }

    @Override // defpackage.ru3
    public final Object n(int i, Object obj, Object obj2) {
        switch (er3.f1019a[i - 1]) {
            case 1:
                return new br3();
            case 2:
                return new a(null);
            case 3:
                return new ow3(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001င\u0000\u0002\u0014", new Object[]{"zzc", "zzd", "zze"});
            case 4:
                return zzf;
            case 5:
                jw3<br3> jw3 = zzg;
                if (jw3 == null) {
                    synchronized (br3.class) {
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

    public final long t(int i) {
        qv3 qv3 = (qv3) this.zze;
        qv3.n(i);
        return qv3.g[i];
    }

    public final boolean w() {
        return (this.zzc & 1) != 0;
    }

    public final int x() {
        return this.zzd;
    }

    public final List<Long> y() {
        return this.zze;
    }

    public final int z() {
        return ((qv3) this.zze).size();
    }
}
