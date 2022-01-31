package defpackage;

import defpackage.ru3;

/* renamed from: pq3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class pq3 extends ru3<pq3, a> implements dw3 {
    private static final pq3 zzf;
    private static volatile jw3<pq3> zzg;
    private int zzc;
    private String zzd = "";
    private String zze = "";

    /* renamed from: pq3$a */
    /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class a extends ru3.b<pq3, a> implements dw3 {
        public a(rq3 rq3) {
            super(pq3.zzf);
        }
    }

    static {
        pq3 pq3 = new pq3();
        zzf = pq3;
        ru3.p(pq3.class, pq3);
    }

    @Override // defpackage.ru3
    public final Object n(int i, Object obj, Object obj2) {
        switch (rq3.f3118a[i - 1]) {
            case 1:
                return new pq3();
            case 2:
                return new a(null);
            case 3:
                return new ow3(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzc", "zzd", "zze"});
            case 4:
                return zzf;
            case 5:
                jw3<pq3> jw3 = zzg;
                if (jw3 == null) {
                    synchronized (pq3.class) {
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

    public final String t() {
        return this.zzd;
    }

    public final String u() {
        return this.zze;
    }
}
