package defpackage;

import defpackage.ru3;

/* renamed from: lr3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class lr3 extends ru3<lr3, a> implements dw3 {
    private static final lr3 zzf;
    private static volatile jw3<lr3> zzg;
    private int zzc;
    private zu3<mr3> zzd = mw3.i;
    private jr3 zze;

    /* renamed from: lr3$a */
    /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class a extends ru3.b<lr3, a> implements dw3 {
        public a(nr3 nr3) {
            super(lr3.zzf);
        }
    }

    static {
        lr3 lr3 = new lr3();
        zzf = lr3;
        ru3.p(lr3.class, lr3);
    }

    @Override // defpackage.ru3
    public final Object n(int i, Object obj, Object obj2) {
        switch (nr3.f2597a[i - 1]) {
            case 1:
                return new lr3();
            case 2:
                return new a(null);
            case 3:
                return new ow3(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000", new Object[]{"zzc", "zzd", mr3.class, "zze"});
            case 4:
                return zzf;
            case 5:
                jw3<lr3> jw3 = zzg;
                if (jw3 == null) {
                    synchronized (lr3.class) {
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
