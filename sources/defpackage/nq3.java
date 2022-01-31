package defpackage;

import defpackage.ru3;
import java.util.Objects;

/* renamed from: nq3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class nq3 extends ru3<nq3, a> implements dw3 {
    private static final nq3 zzh;
    private static volatile jw3<nq3> zzi;
    private int zzc;
    private String zzd = "";
    private boolean zze;
    private boolean zzf;
    private int zzg;

    /* renamed from: nq3$a */
    /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class a extends ru3.b<nq3, a> implements dw3 {
        public a() {
            super(nq3.zzh);
        }

        public final String l() {
            return ((nq3) this.g).t();
        }

        public final int m() {
            return ((nq3) this.g).y();
        }

        public a(rq3 rq3) {
            super(nq3.zzh);
        }
    }

    static {
        nq3 nq3 = new nq3();
        zzh = nq3;
        ru3.p(nq3.class, nq3);
    }

    public static void u(nq3 nq3, String str) {
        Objects.requireNonNull(nq3);
        str.getClass();
        nq3.zzc |= 1;
        nq3.zzd = str;
    }

    @Override // defpackage.ru3
    public final Object n(int i, Object obj, Object obj2) {
        switch (rq3.f3118a[i - 1]) {
            case 1:
                return new nq3();
            case 2:
                return new a(null);
            case 3:
                return new ow3(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004င\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
            case 4:
                return zzh;
            case 5:
                jw3<nq3> jw3 = zzi;
                if (jw3 == null) {
                    synchronized (nq3.class) {
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

    public final String t() {
        return this.zzd;
    }

    public final boolean v() {
        return this.zze;
    }

    public final boolean w() {
        return this.zzf;
    }

    public final boolean x() {
        return (this.zzc & 8) != 0;
    }

    public final int y() {
        return this.zzg;
    }
}
