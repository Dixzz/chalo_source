package defpackage;

import defpackage.ug2;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

/* renamed from: nk2  reason: default package */
public final class nk2 extends ug2<nk2, a> implements bi2 {
    private static volatile ii2<nk2> zzbg;
    private static final nk2 zzbir;
    private zg2<b> zzbiq = li2.h;

    /* renamed from: nk2$a */
    public static final class a extends ug2.a<nk2, a> implements bi2 {
        public a(ok2 ok2) {
            super(nk2.zzbir);
        }
    }

    /* renamed from: nk2$b */
    public static final class b extends ug2<b, a> implements bi2 {
        private static volatile ii2<b> zzbg;
        private static final b zzbiv;
        private int zzbb;
        private String zzbis = "";
        private long zzbit;
        private long zzbiu;
        private int zzya;

        /* renamed from: nk2$b$a */
        public static final class a extends ug2.a<b, a> implements bi2 {
            public a() {
                super(b.zzbiv);
            }

            public a(ok2 ok2) {
                super(b.zzbiv);
            }
        }

        static {
            b bVar = new b();
            zzbiv = bVar;
            ug2.k(b.class, bVar);
        }

        public static void n(b bVar, long j) {
            bVar.zzbb |= 4;
            bVar.zzbit = j;
        }

        public static void o(b bVar, String str) {
            Objects.requireNonNull(bVar);
            Objects.requireNonNull(str);
            bVar.zzbb |= 2;
            bVar.zzbis = str;
        }

        public static void p(b bVar, long j) {
            bVar.zzbb |= 8;
            bVar.zzbiu = j;
        }

        public static a u() {
            return (a) ((ug2.a) zzbiv.i(5, null, null));
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [ii2<nk2$b>, ug2$b] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // defpackage.ug2
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object i(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
            // Method dump skipped, instructions count: 118
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.nk2.b.i(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }

        public final int m() {
            return this.zzya;
        }

        public final boolean q() {
            return (this.zzbb & 1) == 1;
        }

        public final String r() {
            return this.zzbis;
        }

        public final long s() {
            return this.zzbit;
        }

        public final long t() {
            return this.zzbiu;
        }
    }

    static {
        nk2 nk2 = new nk2();
        zzbir = nk2;
        ug2.k(nk2.class, nk2);
    }

    public static nk2 n() {
        return zzbir;
    }

    public static nk2 p(byte[] bArr) throws ah2 {
        ug2 ug2 = (ug2) zzbir.i(4, null, null);
        try {
            ki2 ki2 = ki2.c;
            ki2.b(ug2).i(ug2, bArr, 0, bArr.length, new qf2());
            ki2.b(ug2).a(ug2);
            if (ug2.zzex == 0) {
                boolean z = true;
                byte byteValue = ((Byte) ug2.i(1, null, null)).byteValue();
                if (byteValue != 1) {
                    if (byteValue == 0) {
                        z = false;
                    } else {
                        z = ki2.b(ug2).j(ug2);
                        ug2.i(2, z ? ug2 : null, null);
                    }
                }
                if (z) {
                    return (nk2) ug2;
                }
                throw new ah2(new cj2().getMessage());
            }
            throw new RuntimeException();
        } catch (IOException e) {
            if (e.getCause() instanceof ah2) {
                throw ((ah2) e.getCause());
            }
            throw new ah2(e.getMessage());
        } catch (IndexOutOfBoundsException unused) {
            throw ah2.a();
        }
    }

    /* JADX WARN: Type inference failed for: r2v13, types: [ii2<nk2>, ug2$b] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // defpackage.ug2
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object i(int r2, java.lang.Object r3, java.lang.Object r4) {
        /*
        // Method dump skipped, instructions count: 104
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.nk2.i(int, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    public final List<b> m() {
        return this.zzbiq;
    }
}
