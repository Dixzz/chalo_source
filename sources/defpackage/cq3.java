package defpackage;

import defpackage.ru3;
import java.util.List;
import java.util.Objects;

/* renamed from: cq3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class cq3 extends ru3<cq3, a> implements dw3 {
    private static final cq3 zzi;
    private static volatile jw3<cq3> zzj;
    private int zzc;
    private int zzd;
    private zu3<gq3> zze;
    private zu3<dq3> zzf;
    private boolean zzg;
    private boolean zzh;

    /* renamed from: cq3$a */
    /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class a extends ru3.b<cq3, a> implements dw3 {
        public a() {
            super(cq3.zzi);
        }

        public a(iq3 iq3) {
            super(cq3.zzi);
        }
    }

    static {
        cq3 cq3 = new cq3();
        zzi = cq3;
        ru3.p(cq3.class, cq3);
    }

    public cq3() {
        mw3<Object> mw3 = mw3.i;
        this.zze = mw3;
        this.zzf = mw3;
    }

    public static void u(cq3 cq3, int i, dq3 dq3) {
        Objects.requireNonNull(cq3);
        zu3<dq3> zu3 = cq3.zzf;
        if (!zu3.zza()) {
            cq3.zzf = ru3.l(zu3);
        }
        cq3.zzf.set(i, dq3);
    }

    public static void v(cq3 cq3, int i, gq3 gq3) {
        Objects.requireNonNull(cq3);
        zu3<gq3> zu3 = cq3.zze;
        if (!zu3.zza()) {
            cq3.zze = ru3.l(zu3);
        }
        cq3.zze.set(i, gq3);
    }

    public final int A() {
        return this.zze.size();
    }

    public final List<dq3> B() {
        return this.zzf;
    }

    public final int C() {
        return this.zzf.size();
    }

    @Override // defpackage.ru3
    public final Object n(int i, Object obj, Object obj2) {
        switch (iq3.f1559a[i - 1]) {
            case 1:
                return new cq3();
            case 2:
                return new a(null);
            case 3:
                return new ow3(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဇ\u0001\u0005ဇ\u0002", new Object[]{"zzc", "zzd", "zze", gq3.class, "zzf", dq3.class, "zzg", "zzh"});
            case 4:
                return zzi;
            case 5:
                jw3<cq3> jw3 = zzj;
                if (jw3 == null) {
                    synchronized (cq3.class) {
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

    public final gq3 t(int i) {
        return this.zze.get(i);
    }

    public final boolean w() {
        return (this.zzc & 1) != 0;
    }

    public final int x() {
        return this.zzd;
    }

    public final dq3 y(int i) {
        return this.zzf.get(i);
    }

    public final List<gq3> z() {
        return this.zze;
    }
}
