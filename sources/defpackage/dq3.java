package defpackage;

import defpackage.ru3;
import java.util.List;
import java.util.Objects;

/* renamed from: dq3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class dq3 extends ru3<dq3, a> implements dw3 {
    private static final dq3 zzl;
    private static volatile jw3<dq3> zzm;
    private int zzc;
    private int zzd;
    private String zze = "";
    private zu3<eq3> zzf = mw3.i;
    private boolean zzg;
    private fq3 zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;

    /* renamed from: dq3$a */
    /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class a extends ru3.b<dq3, a> implements dw3 {
        public a() {
            super(dq3.zzl);
        }

        public a(iq3 iq3) {
            super(dq3.zzl);
        }
    }

    static {
        dq3 dq3 = new dq3();
        zzl = dq3;
        ru3.p(dq3.class, dq3);
    }

    public static a H() {
        return (a) zzl.q();
    }

    public static void u(dq3 dq3, int i, eq3 eq3) {
        Objects.requireNonNull(dq3);
        eq3.getClass();
        zu3<eq3> zu3 = dq3.zzf;
        if (!zu3.zza()) {
            dq3.zzf = ru3.l(zu3);
        }
        dq3.zzf.set(i, eq3);
    }

    public static void v(dq3 dq3, String str) {
        Objects.requireNonNull(dq3);
        str.getClass();
        dq3.zzc |= 2;
        dq3.zze = str;
    }

    public final int A() {
        return this.zzf.size();
    }

    public final boolean B() {
        return (this.zzc & 8) != 0;
    }

    public final fq3 C() {
        fq3 fq3 = this.zzh;
        return fq3 == null ? fq3.D() : fq3;
    }

    public final boolean D() {
        return this.zzi;
    }

    public final boolean E() {
        return this.zzj;
    }

    public final boolean F() {
        return (this.zzc & 64) != 0;
    }

    public final boolean G() {
        return this.zzk;
    }

    @Override // defpackage.ru3
    public final Object n(int i, Object obj, Object obj2) {
        switch (iq3.f1559a[i - 1]) {
            case 1:
                return new dq3();
            case 2:
                return new a(null);
            case 3:
                return new ow3(zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u001b\u0004ဇ\u0002\u0005ဉ\u0003\u0006ဇ\u0004\u0007ဇ\u0005\bဇ\u0006", new Object[]{"zzc", "zzd", "zze", "zzf", eq3.class, "zzg", "zzh", "zzi", "zzj", "zzk"});
            case 4:
                return zzl;
            case 5:
                jw3<dq3> jw3 = zzm;
                if (jw3 == null) {
                    synchronized (dq3.class) {
                        jw3 = zzm;
                        if (jw3 == null) {
                            jw3 = new ru3.a<>(zzl);
                            zzm = jw3;
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

    public final eq3 t(int i) {
        return this.zzf.get(i);
    }

    public final boolean w() {
        return (this.zzc & 1) != 0;
    }

    public final int x() {
        return this.zzd;
    }

    public final String y() {
        return this.zze;
    }

    public final List<eq3> z() {
        return this.zzf;
    }
}
