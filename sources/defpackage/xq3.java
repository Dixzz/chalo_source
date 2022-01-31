package defpackage;

import defpackage.ru3;
import defpackage.yq3;
import java.util.List;
import java.util.Objects;

/* renamed from: xq3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class xq3 extends ru3<xq3, a> implements dw3 {
    private static final xq3 zzd;
    private static volatile jw3<xq3> zze;
    private zu3<yq3> zzc = mw3.i;

    /* renamed from: xq3$a */
    /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class a extends ru3.b<xq3, a> implements dw3 {
        public a() {
            super(xq3.zzd);
        }

        public final a l(yq3.a aVar) {
            if (this.h) {
                i();
                this.h = false;
            }
            xq3.v((xq3) this.g, (yq3) ((ru3) aVar.k()));
            return this;
        }

        public a(er3 er3) {
            super(xq3.zzd);
        }
    }

    static {
        xq3 xq3 = new xq3();
        zzd = xq3;
        ru3.p(xq3.class, xq3);
    }

    public static void v(xq3 xq3, yq3 yq3) {
        Objects.requireNonNull(xq3);
        zu3<yq3> zu3 = xq3.zzc;
        if (!zu3.zza()) {
            xq3.zzc = ru3.l(zu3);
        }
        xq3.zzc.add(yq3);
    }

    public static a w() {
        return (a) zzd.q();
    }

    @Override // defpackage.ru3
    public final Object n(int i, Object obj, Object obj2) {
        switch (er3.f1019a[i - 1]) {
            case 1:
                return new xq3();
            case 2:
                return new a(null);
            case 3:
                return new ow3(zzd, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzc", yq3.class});
            case 4:
                return zzd;
            case 5:
                jw3<xq3> jw3 = zze;
                if (jw3 == null) {
                    synchronized (xq3.class) {
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

    public final yq3 t() {
        return this.zzc.get(0);
    }

    public final List<yq3> u() {
        return this.zzc;
    }
}
