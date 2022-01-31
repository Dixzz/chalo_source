package defpackage;

import defpackage.ru3;

/* renamed from: vq3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class vq3 extends ru3<vq3, a> implements dw3 {
    private static final vq3 zzf;
    private static volatile jw3<vq3> zzg;
    private int zzc;
    private String zzd = "";
    private long zze;

    /* renamed from: vq3$a */
    /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class a extends ru3.b<vq3, a> implements dw3 {
        public a(er3 er3) {
            super(vq3.zzf);
        }
    }

    static {
        vq3 vq3 = new vq3();
        zzf = vq3;
        ru3.p(vq3.class, vq3);
    }

    @Override // defpackage.ru3
    public final Object n(int i, Object obj, Object obj2) {
        switch (er3.f1019a[i - 1]) {
            case 1:
                return new vq3();
            case 2:
                return new a(null);
            case 3:
                return new ow3(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001", new Object[]{"zzc", "zzd", "zze"});
            case 4:
                return zzf;
            case 5:
                jw3<vq3> jw3 = zzg;
                if (jw3 == null) {
                    synchronized (vq3.class) {
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
}
