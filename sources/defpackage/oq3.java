package defpackage;

import defpackage.ru3;
import java.util.List;
import java.util.Objects;

/* renamed from: oq3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class oq3 extends ru3<oq3, a> implements dw3 {
    private static final oq3 zzm;
    private static volatile jw3<oq3> zzn;
    private int zzc;
    private long zzd;
    private String zze = "";
    private int zzf;
    private zu3<pq3> zzg;
    private zu3<nq3> zzh;
    private zu3<cq3> zzi;
    private String zzj;
    private boolean zzk;
    private zu3<lr3> zzl;

    /* renamed from: oq3$a */
    /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class a extends ru3.b<oq3, a> implements dw3 {
        public a() {
            super(oq3.zzm);
        }

        public a(rq3 rq3) {
            super(oq3.zzm);
        }
    }

    static {
        oq3 oq3 = new oq3();
        zzm = oq3;
        ru3.p(oq3.class, oq3);
    }

    public oq3() {
        mw3<Object> mw3 = mw3.i;
        this.zzg = mw3;
        this.zzh = mw3;
        this.zzi = mw3;
        this.zzj = "";
        this.zzl = mw3;
    }

    public static a E() {
        return (a) zzm.q();
    }

    public static oq3 F() {
        return zzm;
    }

    public static void u(oq3 oq3) {
        Objects.requireNonNull(oq3);
        oq3.zzi = mw3.i;
    }

    public static void v(oq3 oq3, int i, nq3 nq3) {
        Objects.requireNonNull(oq3);
        zu3<nq3> zu3 = oq3.zzh;
        if (!zu3.zza()) {
            oq3.zzh = ru3.l(zu3);
        }
        oq3.zzh.set(i, nq3);
    }

    public final List<pq3> A() {
        return this.zzg;
    }

    public final int B() {
        return this.zzh.size();
    }

    public final List<cq3> C() {
        return this.zzi;
    }

    public final boolean D() {
        return this.zzk;
    }

    @Override // defpackage.ru3
    public final Object n(int i, Object obj, Object obj2) {
        switch (rq3.f3118a[i - 1]) {
            case 1:
                return new oq3();
            case 2:
                return new a(null);
            case 3:
                return new ow3(zzm, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0004\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004\u001b\u0005\u001b\u0006\u001b\u0007ဈ\u0003\bဇ\u0004\t\u001b", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", pq3.class, "zzh", nq3.class, "zzi", cq3.class, "zzj", "zzk", "zzl", lr3.class});
            case 4:
                return zzm;
            case 5:
                jw3<oq3> jw3 = zzn;
                if (jw3 == null) {
                    synchronized (oq3.class) {
                        jw3 = zzn;
                        if (jw3 == null) {
                            jw3 = new ru3.a<>(zzm);
                            zzn = jw3;
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

    public final nq3 t(int i) {
        return this.zzh.get(i);
    }

    public final boolean w() {
        return (this.zzc & 1) != 0;
    }

    public final long x() {
        return this.zzd;
    }

    public final boolean y() {
        return (this.zzc & 2) != 0;
    }

    public final String z() {
        return this.zze;
    }
}
