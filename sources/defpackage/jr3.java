package defpackage;

import defpackage.ru3;

/* renamed from: jr3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class jr3 extends ru3<jr3, a> implements dw3 {
    private static final jr3 zzd;
    private static volatile jw3<jr3> zze;
    private zu3<kr3> zzc = mw3.i;

    /* renamed from: jr3$a */
    /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class a extends ru3.b<jr3, a> implements dw3 {
        public a(nr3 nr3) {
            super(jr3.zzd);
        }
    }

    static {
        jr3 jr3 = new jr3();
        zzd = jr3;
        ru3.p(jr3.class, jr3);
    }

    @Override // defpackage.ru3
    public final Object n(int i, Object obj, Object obj2) {
        switch (nr3.f2597a[i - 1]) {
            case 1:
                return new jr3();
            case 2:
                return new a(null);
            case 3:
                return new ow3(zzd, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzc", kr3.class});
            case 4:
                return zzd;
            case 5:
                jw3<jr3> jw3 = zze;
                if (jw3 == null) {
                    synchronized (jr3.class) {
                        jw3 = zze;
                        if (jw3 == null) {
                            jw3 = new ru3.a<>(zzd);
                            zze = jw3;
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
