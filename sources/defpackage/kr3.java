package defpackage;

import defpackage.ru3;

/* renamed from: kr3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class kr3 extends ru3<kr3, a> implements dw3 {
    private static final kr3 zzf;
    private static volatile jw3<kr3> zzg;
    private int zzc;
    private String zzd = "";
    private zu3<mr3> zze = mw3.i;

    /* renamed from: kr3$a */
    /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class a extends ru3.b<kr3, a> implements dw3 {
        public a(nr3 nr3) {
            super(kr3.zzf);
        }
    }

    static {
        kr3 kr3 = new kr3();
        zzf = kr3;
        ru3.p(kr3.class, kr3);
    }

    @Override // defpackage.ru3
    public final Object n(int i, Object obj, Object obj2) {
        switch (nr3.f2597a[i - 1]) {
            case 1:
                return new kr3();
            case 2:
                return new a(null);
            case 3:
                return new ow3(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b", new Object[]{"zzc", "zzd", "zze", mr3.class});
            case 4:
                return zzf;
            case 5:
                jw3<kr3> jw3 = zzg;
                if (jw3 == null) {
                    synchronized (kr3.class) {
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
