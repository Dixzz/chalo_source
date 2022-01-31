package defpackage;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import sun.misc.Unsafe;

/* renamed from: ci2  reason: default package */
public final class ci2<T> implements pi2<T> {
    public static final Unsafe q = jj2.j();

    /* renamed from: a  reason: collision with root package name */
    public final int[] f567a;
    public final Object[] b;
    public final int c;
    public final int d;
    public final int e;
    public final zh2 f;
    public final boolean g;
    public final boolean h;
    public final int[] i;
    public final int[] j;
    public final int[] k;
    public final fi2 l;
    public final kh2 m;
    public final dj2<?, ?> n;
    public final hg2<?> o;
    public final uh2 p;

    /* JADX WARN: Incorrect args count in method signature: ([I[Ljava/lang/Object;IIILzh2;ZZ[I[I[ILfi2;Lkh2;Ldj2<**>;Lhg2<*>;Luh2;)V */
    public ci2(int[] iArr, Object[] objArr, int i2, int i3, int i4, zh2 zh2, boolean z, int[] iArr2, int[] iArr3, int[] iArr4, fi2 fi2, kh2 kh2, dj2 dj2, hg2 hg2, uh2 uh2) {
        this.f567a = iArr;
        this.b = objArr;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        boolean z2 = zh2 instanceof ug2;
        this.h = z;
        this.g = hg2 != null && hg2.f(zh2);
        this.i = iArr2;
        this.j = iArr3;
        this.k = iArr4;
        this.l = fi2;
        this.m = kh2;
        this.n = dj2;
        this.o = hg2;
        this.f = zh2;
        this.p = uh2;
    }

    public static <E> List<E> J(Object obj, long j2) {
        return (List) jj2.t(obj, j2);
    }

    public static <T> double K(T t, long j2) {
        return ((Double) jj2.t(t, j2)).doubleValue();
    }

    public static <T> float L(T t, long j2) {
        return ((Float) jj2.t(t, j2)).floatValue();
    }

    public static <T> int M(T t, long j2) {
        return ((Integer) jj2.t(t, j2)).intValue();
    }

    public static <T> long N(T t, long j2) {
        return ((Long) jj2.t(t, j2)).longValue();
    }

    public static <T> boolean O(T t, long j2) {
        return ((Boolean) jj2.t(t, j2)).booleanValue();
    }

    public static ej2 P(Object obj) {
        ug2 ug2 = (ug2) obj;
        ej2 ej2 = ug2.zzjp;
        if (ej2 != ej2.f) {
            return ej2;
        }
        ej2 e2 = ej2.e();
        ug2.zzjp = e2;
        return e2;
    }

    public static int e(pi2<?> pi2, int i2, byte[] bArr, int i3, int i4, zg2<?> zg2, qf2 qf2) throws IOException {
        int l2 = l(pi2, bArr, i3, i4, qf2);
        while (true) {
            zg2.add(qf2.c);
            if (l2 >= i4) {
                break;
            }
            int L0 = gj1.L0(bArr, l2, qf2);
            if (i2 != qf2.f2938a) {
                break;
            }
            l2 = l(pi2, bArr, L0, i4, qf2);
        }
        return l2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v1, resolved type: ci2 */
    /* JADX WARN: Multi-variable type inference failed */
    public static int k(pi2 pi2, byte[] bArr, int i2, int i3, int i4, qf2 qf2) throws IOException {
        ci2 ci2 = (ci2) pi2;
        Object a2 = ci2.l.a(ci2.f);
        int p2 = ci2.p(a2, bArr, i2, i3, i4, qf2);
        ci2.a(a2);
        qf2.c = a2;
        return p2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: pi2 */
    /* JADX WARN: Multi-variable type inference failed */
    public static int l(pi2 pi2, byte[] bArr, int i2, int i3, qf2 qf2) throws IOException {
        int i4 = i2 + 1;
        byte b2 = bArr[i2];
        byte b3 = b2;
        if (b2 < 0) {
            i4 = gj1.J0(b2, bArr, i4, qf2);
            b3 = qf2.f2938a;
        }
        if (b3 < 0 || b3 > i3 - i4) {
            throw ah2.a();
        }
        Object d2 = pi2.d();
        int i5 = (b3 == 1 ? 1 : 0) + i4;
        pi2.i(d2, bArr, i4, i5, qf2);
        pi2.a(d2);
        qf2.c = d2;
        return i5;
    }

    /* JADX WARN: Incorrect args count in method signature: <T:Ljava/lang/Object;>(Ljava/lang/Class<TT;>;Lxh2;Lfi2;Lkh2;Ldj2<**>;Lhg2<*>;Luh2;)Lci2<TT;>; */
    public static ci2 q(xh2 xh2, fi2 fi2, kh2 kh2, dj2 dj2, hg2 hg2, uh2 uh2) {
        int i2;
        int i3;
        int i4;
        boolean z;
        int i5;
        int i6;
        int i7;
        Field field;
        Field field2;
        Field field3;
        if (xh2 instanceof mi2) {
            mi2 mi2 = (mi2) xh2;
            ni2 ni2 = mi2.b;
            int i8 = 1;
            int i9 = 2;
            boolean z2 = ((ni2.d & 1) == 1 ? (char) 1 : 2) == 2;
            if (ni2.e == 0) {
                i4 = 0;
                i3 = 0;
                i2 = 0;
            } else {
                int i10 = ni2.h;
                int i11 = ni2.i;
                i4 = ni2.l;
                i3 = i10;
                i2 = i11;
            }
            int[] iArr = new int[(i4 << 2)];
            Object[] objArr = new Object[(i4 << 1)];
            int i12 = ni2.j;
            int[] iArr2 = i12 > 0 ? new int[i12] : null;
            int i13 = ni2.m;
            int[] iArr3 = i13 > 0 ? new int[i13] : null;
            if (ni2.a()) {
                int i14 = ni2.x;
                int i15 = 0;
                int i16 = 0;
                int i17 = 0;
                while (true) {
                    if (i14 >= mi2.b.k || i15 >= ((i14 - i3) << i9)) {
                        if (ni2.z > pg2.MAP.id()) {
                            int i18 = ni2.A << i8;
                            Object obj = ni2.b[i18];
                            if (obj instanceof Field) {
                                field2 = (Field) obj;
                            } else {
                                field2 = ni2.b(ni2.c, (String) obj);
                                ni2.b[i18] = field2;
                            }
                            i5 = (int) jj2.b(field2);
                            int i19 = (ni2.A << i8) + i8;
                            Object obj2 = ni2.b[i19];
                            if (obj2 instanceof Field) {
                                field3 = (Field) obj2;
                            } else {
                                field3 = ni2.b(ni2.c, (String) obj2);
                                ni2.b[i19] = field3;
                            }
                            i6 = (int) jj2.b(field3);
                            i7 = 0;
                        } else {
                            i5 = (int) jj2.b(ni2.C);
                            if (ni2.e()) {
                                int i20 = (ni2.B / 32) + (ni2.f << i8);
                                Object obj3 = ni2.b[i20];
                                if (obj3 instanceof Field) {
                                    field = (Field) obj3;
                                } else {
                                    field = ni2.b(ni2.c, (String) obj3);
                                    ni2.b[i20] = field;
                                }
                                i6 = (int) jj2.b(field);
                                i7 = ni2.B % 32;
                            } else {
                                i7 = 0;
                                i6 = 0;
                            }
                        }
                        iArr[i15] = ni2.x;
                        int i21 = i15 + 1;
                        int i22 = ni2.y;
                        z = z2;
                        int i23 = ((i22 & 256) != 0 ? 268435456 : 0) | ((i22 & 512) != 0 ? 536870912 : 0);
                        int i24 = ni2.z;
                        iArr[i21] = i23 | (i24 << 20) | i5;
                        iArr[i15 + 2] = (i7 << 20) | i6;
                        Object obj4 = ni2.F;
                        if (obj4 != null) {
                            int i25 = (i15 / 4) << 1;
                            objArr[i25] = obj4;
                            Object obj5 = ni2.D;
                            if (obj5 != null) {
                                objArr[i25 + 1] = obj5;
                            } else {
                                Object obj6 = ni2.E;
                                if (obj6 != null) {
                                    objArr[i25 + 1] = obj6;
                                }
                            }
                        } else {
                            Object obj7 = ni2.D;
                            if (obj7 != null) {
                                objArr[((i15 / 4) << 1) + 1] = obj7;
                            } else {
                                Object obj8 = ni2.E;
                                if (obj8 != null) {
                                    objArr[((i15 / 4) << 1) + 1] = obj8;
                                }
                            }
                        }
                        if (i24 == 50) {
                            iArr2[i16] = i15;
                            i16++;
                        } else if (i24 >= 18 && i24 <= 49) {
                            iArr3[i17] = iArr[i21] & 1048575;
                            i17++;
                        }
                        if (!ni2.a()) {
                            break;
                        }
                        i14 = ni2.x;
                    } else {
                        for (int i26 = 0; i26 < 4; i26++) {
                            iArr[i15 + i26] = -1;
                        }
                        z = z2;
                    }
                    i15 += 4;
                    z2 = z;
                    i8 = 1;
                    i9 = 2;
                }
            } else {
                z = z2;
            }
            ni2 ni22 = mi2.b;
            return new ci2(iArr, objArr, i3, i2, ni22.k, mi2.f2382a, z, ni22.n, iArr2, iArr3, fi2, kh2, dj2, hg2, uh2);
        }
        aj2 aj2 = (aj2) xh2;
        throw new NoSuchMethodError();
    }

    public static void r(int i2, Object obj, xj2 xj2) throws IOException {
        if (obj instanceof String) {
            ((dg2) xj2).f832a.i(i2, (String) obj);
            return;
        }
        ((dg2) xj2).f832a.f(i2, (uf2) obj);
    }

    public static <UT, UB> void s(dj2<UT, UB> dj2, T t, xj2 xj2) throws IOException {
        dj2.b(dj2.i(t), xj2);
    }

    public final yg2<?> A(int i2) {
        return (yg2) this.b[((i2 / 4) << 1) + 1];
    }

    public final int B(int i2) {
        return this.f567a[i2 + 1];
    }

    public final int C(int i2) {
        return this.f567a[i2 + 2];
    }

    public final int D(int i2) {
        int i3 = this.c;
        if (i2 >= i3) {
            int i4 = this.e;
            if (i2 < i4) {
                int i5 = (i2 - i3) << 2;
                if (this.f567a[i5] == i2) {
                    return i5;
                }
                return -1;
            } else if (i2 <= this.d) {
                int i6 = i4 - i3;
                int length = (this.f567a.length / 4) - 1;
                while (i6 <= length) {
                    int i7 = (length + i6) >>> 1;
                    int i8 = i7 << 2;
                    int i9 = this.f567a[i8];
                    if (i2 == i9) {
                        return i8;
                    }
                    if (i2 < i9) {
                        length = i7 - 1;
                    } else {
                        i6 = i7 + 1;
                    }
                }
            }
        }
        return -1;
    }

    public final void E(T t, int i2) {
        if (!this.h) {
            int i3 = this.f567a[i2 + 2];
            long j2 = (long) (i3 & 1048575);
            jj2.f.e(t, j2, jj2.o(t, j2) | (1 << (i3 >>> 20)));
        }
    }

    public final void F(T t, int i2, int i3) {
        jj2.f.e(t, (long) (this.f567a[i3 + 2] & 1048575), i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:170:0x052a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void G(T r19, defpackage.xj2 r20) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 1492
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ci2.G(java.lang.Object, xj2):void");
    }

    public final void H(T t, T t2, int i2) {
        int[] iArr = this.f567a;
        int i3 = iArr[i2 + 1];
        int i4 = iArr[i2];
        long j2 = (long) (i3 & 1048575);
        if (w(t2, i4, i2)) {
            Object t3 = jj2.t(t, j2);
            Object t4 = jj2.t(t2, j2);
            if (t3 != null && t4 != null) {
                jj2.f(t, j2, wg2.a(t3, t4));
                F(t, i4, i2);
            } else if (t4 != null) {
                jj2.f(t, j2, t4);
                F(t, i4, i2);
            }
        }
    }

    public final boolean I(T t, T t2, int i2) {
        return v(t, i2) == v(t2, i2);
    }

    @Override // defpackage.pi2
    public final void a(T t) {
        int[] iArr = this.j;
        if (iArr != null) {
            for (int i2 : iArr) {
                long B = (long) (B(i2) & 1048575);
                Object t2 = jj2.t(t, B);
                if (t2 != null) {
                    jj2.f(t, B, this.p.d(t2));
                }
            }
        }
        int[] iArr2 = this.k;
        if (iArr2 != null) {
            for (int i3 : iArr2) {
                this.m.a(t, (long) i3);
            }
        }
        this.n.c(t);
        if (this.g) {
            this.o.e(t);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005c, code lost:
        if (defpackage.ri2.t(defpackage.jj2.t(r10, r6), defpackage.jj2.t(r11, r6)) != false) goto L_0x01a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0070, code lost:
        if (defpackage.jj2.p(r10, r6) == defpackage.jj2.p(r11, r6)) goto L_0x01a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0082, code lost:
        if (defpackage.jj2.o(r10, r6) == defpackage.jj2.o(r11, r6)) goto L_0x01a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0096, code lost:
        if (defpackage.jj2.p(r10, r6) == defpackage.jj2.p(r11, r6)) goto L_0x01a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a8, code lost:
        if (defpackage.jj2.o(r10, r6) == defpackage.jj2.o(r11, r6)) goto L_0x01a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ba, code lost:
        if (defpackage.jj2.o(r10, r6) == defpackage.jj2.o(r11, r6)) goto L_0x01a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00cc, code lost:
        if (defpackage.jj2.o(r10, r6) == defpackage.jj2.o(r11, r6)) goto L_0x01a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00e2, code lost:
        if (defpackage.ri2.t(defpackage.jj2.t(r10, r6), defpackage.jj2.t(r11, r6)) != false) goto L_0x01a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00f8, code lost:
        if (defpackage.ri2.t(defpackage.jj2.t(r10, r6), defpackage.jj2.t(r11, r6)) != false) goto L_0x01a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x010e, code lost:
        if (defpackage.ri2.t(defpackage.jj2.t(r10, r6), defpackage.jj2.t(r11, r6)) != false) goto L_0x01a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0120, code lost:
        if (defpackage.jj2.q(r10, r6) == defpackage.jj2.q(r11, r6)) goto L_0x01a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0132, code lost:
        if (defpackage.jj2.o(r10, r6) == defpackage.jj2.o(r11, r6)) goto L_0x01a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0146, code lost:
        if (defpackage.jj2.p(r10, r6) == defpackage.jj2.p(r11, r6)) goto L_0x01a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0157, code lost:
        if (defpackage.jj2.o(r10, r6) == defpackage.jj2.o(r11, r6)) goto L_0x01a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x016a, code lost:
        if (defpackage.jj2.p(r10, r6) == defpackage.jj2.p(r11, r6)) goto L_0x01a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x017d, code lost:
        if (defpackage.jj2.p(r10, r6) == defpackage.jj2.p(r11, r6)) goto L_0x01a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x018e, code lost:
        if (defpackage.jj2.o(r10, r6) == defpackage.jj2.o(r11, r6)) goto L_0x01a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01a1, code lost:
        if (defpackage.jj2.p(r10, r6) == defpackage.jj2.p(r11, r6)) goto L_0x01a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        if (defpackage.ri2.t(defpackage.jj2.t(r10, r6), defpackage.jj2.t(r11, r6)) != false) goto L_0x01a4;
     */
    @Override // defpackage.pi2
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(T r10, T r11) {
        /*
        // Method dump skipped, instructions count: 610
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ci2.b(java.lang.Object, java.lang.Object):boolean");
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00ce, code lost:
        if (r3 != null) goto L_0x00e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00e0, code lost:
        if (r3 != null) goto L_0x00e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00e2, code lost:
        r7 = r3.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e6, code lost:
        r2 = (r2 * 53) + r7;
     */
    @Override // defpackage.pi2
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int c(T r9) {
        /*
        // Method dump skipped, instructions count: 476
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ci2.c(java.lang.Object):int");
    }

    @Override // defpackage.pi2
    public final T d() {
        return (T) this.l.a(this.f);
    }

    @Override // defpackage.pi2
    public final void f(T t, T t2) {
        Objects.requireNonNull(t2);
        for (int i2 = 0; i2 < this.f567a.length; i2 += 4) {
            int B = B(i2);
            long j2 = (long) (1048575 & B);
            int i3 = this.f567a[i2];
            switch ((B & 267386880) >>> 20) {
                case 0:
                    if (v(t2, i2)) {
                        jj2.d(t, j2, jj2.s(t2, j2));
                        E(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (v(t2, i2)) {
                        jj2.f.d(t, j2, jj2.r(t2, j2));
                        E(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (!v(t2, i2)) {
                        break;
                    }
                    jj2.e(t, j2, jj2.p(t2, j2));
                    E(t, i2);
                    break;
                case 3:
                    if (!v(t2, i2)) {
                        break;
                    }
                    jj2.e(t, j2, jj2.p(t2, j2));
                    E(t, i2);
                    break;
                case 4:
                    if (!v(t2, i2)) {
                        break;
                    }
                    jj2.f.e(t, j2, jj2.o(t2, j2));
                    E(t, i2);
                    break;
                case 5:
                    if (!v(t2, i2)) {
                        break;
                    }
                    jj2.e(t, j2, jj2.p(t2, j2));
                    E(t, i2);
                    break;
                case 6:
                    if (!v(t2, i2)) {
                        break;
                    }
                    jj2.f.e(t, j2, jj2.o(t2, j2));
                    E(t, i2);
                    break;
                case 7:
                    if (v(t2, i2)) {
                        jj2.f.g(t, j2, jj2.q(t2, j2));
                        E(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (!v(t2, i2)) {
                        break;
                    }
                    jj2.f(t, j2, jj2.t(t2, j2));
                    E(t, i2);
                    break;
                case 9:
                case 17:
                    u(t, t2, i2);
                    break;
                case 10:
                    if (!v(t2, i2)) {
                        break;
                    }
                    jj2.f(t, j2, jj2.t(t2, j2));
                    E(t, i2);
                    break;
                case 11:
                    if (!v(t2, i2)) {
                        break;
                    }
                    jj2.f.e(t, j2, jj2.o(t2, j2));
                    E(t, i2);
                    break;
                case 12:
                    if (!v(t2, i2)) {
                        break;
                    }
                    jj2.f.e(t, j2, jj2.o(t2, j2));
                    E(t, i2);
                    break;
                case 13:
                    if (!v(t2, i2)) {
                        break;
                    }
                    jj2.f.e(t, j2, jj2.o(t2, j2));
                    E(t, i2);
                    break;
                case 14:
                    if (!v(t2, i2)) {
                        break;
                    }
                    jj2.e(t, j2, jj2.p(t2, j2));
                    E(t, i2);
                    break;
                case 15:
                    if (!v(t2, i2)) {
                        break;
                    }
                    jj2.f.e(t, j2, jj2.o(t2, j2));
                    E(t, i2);
                    break;
                case 16:
                    if (!v(t2, i2)) {
                        break;
                    }
                    jj2.e(t, j2, jj2.p(t2, j2));
                    E(t, i2);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.m.b(t, t2, j2);
                    break;
                case 50:
                    uh2 uh2 = this.p;
                    Class<?> cls = ri2.f3084a;
                    jj2.f(t, j2, uh2.b(jj2.t(t, j2), jj2.t(t2, j2)));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (!w(t2, i3, i2)) {
                        break;
                    }
                    jj2.f(t, j2, jj2.t(t2, j2));
                    F(t, i3, i2);
                    break;
                case 60:
                case 68:
                    H(t, t2, i2);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (!w(t2, i3, i2)) {
                        break;
                    }
                    jj2.f(t, j2, jj2.t(t2, j2));
                    F(t, i3, i2);
                    break;
            }
        }
        if (!this.h) {
            dj2<?, ?> dj2 = this.n;
            Class<?> cls2 = ri2.f3084a;
            dj2.f(t, dj2.g(dj2.i(t), dj2.i(t2)));
            if (this.g) {
                ri2.e(this.o, t, t2);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:137:0x0304, code lost:
        if ((r5 instanceof defpackage.uf2) != false) goto L_0x0306;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x030e, code lost:
        r5 = defpackage.bg2.m(r7, (java.lang.String) r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x0424, code lost:
        if ((r2 instanceof defpackage.uf2) != false) goto L_0x0693;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:308:0x0691, code lost:
        if ((r2 instanceof defpackage.uf2) != false) goto L_0x0693;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:310:0x069a, code lost:
        r2 = defpackage.bg2.m(r9, (java.lang.String) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x009f, code lost:
        if ((r5 instanceof defpackage.uf2) != false) goto L_0x0306;
     */
    @Override // defpackage.pi2
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int g(T r14) {
        /*
        // Method dump skipped, instructions count: 2166
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ci2.g(java.lang.Object):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x04fb  */
    @Override // defpackage.pi2
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void h(T r13, defpackage.xj2 r14) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 1448
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ci2.h(java.lang.Object, xj2):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v27, types: [int] */
    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0069, code lost:
        if (r7 == 0) goto L_0x00d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00d1, code lost:
        if (r7 == 0) goto L_0x00d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00d3, code lost:
        r0 = defpackage.gj1.L0(r12, r10, r11);
        r1 = r11.f2938a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0172, code lost:
        if (r0 == r10) goto L_0x01b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01ae, code lost:
        if (r0 == r15) goto L_0x01b0;
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // defpackage.pi2
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void i(T r23, byte[] r24, int r25, int r26, defpackage.qf2 r27) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 534
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ci2.i(java.lang.Object, byte[], int, int, qf2):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v7, resolved type: pi2 */
    /* JADX DEBUG: Multi-variable search result rejected for r7v9, resolved type: pi2 */
    /* JADX DEBUG: Multi-variable search result rejected for r6v19, resolved type: pi2 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.pi2
    public final boolean j(T t) {
        int i2;
        int i3;
        boolean z;
        int[] iArr = this.i;
        if (!(iArr == null || iArr.length == 0)) {
            int i4 = -1;
            int length = iArr.length;
            int i5 = 0;
            for (int i6 = 0; i6 < length; i6 = i2 + 1) {
                int i7 = iArr[i6];
                int D = D(i7);
                int B = B(D);
                if (!this.h) {
                    int i8 = this.f567a[D + 2];
                    int i9 = i8 & 1048575;
                    i3 = 1 << (i8 >>> 20);
                    if (i9 != i4) {
                        i2 = i6;
                        i5 = q.getInt(t, (long) i9);
                        i4 = i9;
                    } else {
                        i2 = i6;
                    }
                } else {
                    i2 = i6;
                    i3 = 0;
                }
                if (((268435456 & B) != 0) && !x(t, D, i5, i3)) {
                    return false;
                }
                int i10 = (267386880 & B) >>> 20;
                if (i10 != 9 && i10 != 17) {
                    if (i10 != 27) {
                        if (i10 == 60 || i10 == 68) {
                            if (w(t, i7, D) && !y(D).j(jj2.t(t, (long) (B & 1048575)))) {
                                return false;
                            }
                        } else if (i10 != 49) {
                            if (i10 == 50 && !this.p.h(jj2.t(t, (long) (B & 1048575))).isEmpty()) {
                                this.p.g(z(D));
                                throw null;
                            }
                        }
                    }
                    List list = (List) jj2.t(t, (long) (B & 1048575));
                    if (!list.isEmpty()) {
                        pi2 y = y(D);
                        int i11 = 0;
                        while (true) {
                            if (i11 >= list.size()) {
                                break;
                            } else if (!y.j(list.get(i11))) {
                                z = false;
                                break;
                            } else {
                                i11++;
                            }
                        }
                    }
                    z = true;
                    if (!z) {
                        return false;
                    }
                } else if (x(t, D, i5, i3) && !y(D).j(jj2.t(t, (long) (B & 1048575)))) {
                    return false;
                }
            }
            if (!this.g || this.o.b(t).b()) {
                return true;
            }
            return false;
        }
        return true;
    }

    public final int m(T t, byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j2, int i9, qf2 qf2) throws IOException {
        int i10;
        Object obj;
        Object obj2;
        Object obj3;
        long j3;
        int i11;
        int i12;
        Unsafe unsafe = q;
        long j4 = (long) (this.f567a[i9 + 2] & 1048575);
        boolean z = true;
        switch (i8) {
            case 51:
                if (i6 == 1) {
                    obj = Double.valueOf(Double.longBitsToDouble(gj1.N1(bArr, i2)));
                    unsafe.putObject(t, j2, obj);
                    i10 = i2 + 8;
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 52:
                if (i6 == 5) {
                    obj2 = Float.valueOf(Float.intBitsToFloat(gj1.B1(bArr, i2)));
                    unsafe.putObject(t, j2, obj2);
                    i10 = i2 + 4;
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 53:
            case 54:
                if (i6 == 0) {
                    i10 = gj1.p1(bArr, i2, qf2);
                    j3 = qf2.b;
                    obj3 = Long.valueOf(j3);
                    unsafe.putObject(t, j2, obj3);
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 55:
            case 62:
                if (i6 == 0) {
                    i10 = gj1.L0(bArr, i2, qf2);
                    i11 = qf2.f2938a;
                    obj3 = Integer.valueOf(i11);
                    unsafe.putObject(t, j2, obj3);
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 56:
            case 65:
                if (i6 == 1) {
                    obj = Long.valueOf(gj1.N1(bArr, i2));
                    unsafe.putObject(t, j2, obj);
                    i10 = i2 + 8;
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 57:
            case 64:
                if (i6 == 5) {
                    obj2 = Integer.valueOf(gj1.B1(bArr, i2));
                    unsafe.putObject(t, j2, obj2);
                    i10 = i2 + 4;
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 58:
                if (i6 == 0) {
                    i10 = gj1.p1(bArr, i2, qf2);
                    if (qf2.b == 0) {
                        z = false;
                    }
                    obj3 = Boolean.valueOf(z);
                    unsafe.putObject(t, j2, obj3);
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 59:
                if (i6 == 2) {
                    i10 = gj1.L0(bArr, i2, qf2);
                    i12 = qf2.f2938a;
                    if (i12 == 0) {
                        obj3 = "";
                        unsafe.putObject(t, j2, obj3);
                        unsafe.putInt(t, j4, i5);
                        return i10;
                    } else if ((i7 & 536870912) == 0 || lj2.e(bArr, i10, i10 + i12)) {
                        unsafe.putObject(t, j2, new String(bArr, i10, i12, wg2.f3775a));
                        i10 += i12;
                        unsafe.putInt(t, j4, i5);
                        return i10;
                    } else {
                        throw ah2.d();
                    }
                }
                return i2;
            case 60:
                if (i6 == 2) {
                    i10 = l(y(i9), bArr, i2, i3, qf2);
                    Object object = unsafe.getInt(t, j4) == i5 ? unsafe.getObject(t, j2) : null;
                    obj3 = qf2.c;
                    if (object != null) {
                        obj3 = wg2.a(object, obj3);
                    }
                    unsafe.putObject(t, j2, obj3);
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 61:
                if (i6 == 2) {
                    i10 = gj1.L0(bArr, i2, qf2);
                    i12 = qf2.f2938a;
                    if (i12 == 0) {
                        obj3 = uf2.g;
                        unsafe.putObject(t, j2, obj3);
                        unsafe.putInt(t, j4, i5);
                        return i10;
                    }
                    unsafe.putObject(t, j2, uf2.n(bArr, i10, i12));
                    i10 += i12;
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 63:
                if (i6 == 0) {
                    int L0 = gj1.L0(bArr, i2, qf2);
                    int i13 = qf2.f2938a;
                    yg2 yg2 = (yg2) this.b[((i9 / 4) << 1) + 1];
                    if (yg2 == null || yg2.l(i13) != null) {
                        unsafe.putObject(t, j2, Integer.valueOf(i13));
                        i10 = L0;
                        unsafe.putInt(t, j4, i5);
                        return i10;
                    }
                    P(t).b(i4, Long.valueOf((long) i13));
                    return L0;
                }
                return i2;
            case 66:
                if (i6 == 0) {
                    i10 = gj1.L0(bArr, i2, qf2);
                    i11 = ag2.b(qf2.f2938a);
                    obj3 = Integer.valueOf(i11);
                    unsafe.putObject(t, j2, obj3);
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 67:
                if (i6 == 0) {
                    i10 = gj1.p1(bArr, i2, qf2);
                    j3 = ag2.a(qf2.b);
                    obj3 = Long.valueOf(j3);
                    unsafe.putObject(t, j2, obj3);
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 68:
                if (i6 == 3) {
                    i10 = k(y(i9), bArr, i2, i3, (i4 & -8) | 4, qf2);
                    Object object2 = unsafe.getInt(t, j4) == i5 ? unsafe.getObject(t, j2) : null;
                    obj3 = qf2.c;
                    if (object2 != null) {
                        obj3 = wg2.a(object2, obj3);
                    }
                    unsafe.putObject(t, j2, obj3);
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            default:
                return i2;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:231:0x0166 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:233:0x0177 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:234:0x019b */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:235:0x0177 */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x02a9, code lost:
        if (r32.b != 0) goto L_0x02c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x02ac, code lost:
        r4 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x02ad, code lost:
        r13.d(r13.h, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x02b2, code lost:
        if (r1 >= r22) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x02b4, code lost:
        r4 = defpackage.gj1.L0(r20, r1, r32);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x02ba, code lost:
        if (r23 != r32.f2938a) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x02bc, code lost:
        r1 = defpackage.gj1.p1(r20, r4, r32);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x02c4, code lost:
        if (r32.b == 0) goto L_0x02ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x02c6, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:257:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:258:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:260:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:261:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01ac, code lost:
        if (r4 == 0) goto L_0x01c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01af, code lost:
        r13.add(defpackage.uf2.n(r20, r1, r4));
        r1 = r1 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01b7, code lost:
        if (r1 >= r22) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01b9, code lost:
        r4 = defpackage.gj1.L0(r20, r1, r32);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01bf, code lost:
        if (r23 != r32.f2938a) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01c1, code lost:
        r1 = defpackage.gj1.L0(r20, r4, r32);
        r4 = r32.f2938a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01c7, code lost:
        if (r4 != 0) goto L_0x01af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01c9, code lost:
        r13.add(defpackage.uf2.g);
     */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0242  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x020c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int n(T r19, byte[] r20, int r21, int r22, int r23, int r24, int r25, int r26, long r27, int r29, long r30, defpackage.qf2 r32) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 1140
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ci2.n(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, qf2):int");
    }

    /* JADX WARN: Incorrect args count in method signature: <K:Ljava/lang/Object;V:Ljava/lang/Object;>(TT;[BIIIIJLqf2;)I */
    public final int o(Object obj, byte[] bArr, int i2, int i3, int i4, long j2, qf2 qf2) throws IOException {
        Unsafe unsafe = q;
        Object obj2 = this.b[(i4 / 4) << 1];
        Object object = unsafe.getObject(obj, j2);
        if (this.p.f(object)) {
            Object c2 = this.p.c(obj2);
            this.p.b(c2, object);
            unsafe.putObject(obj, j2, c2);
            object = c2;
        }
        this.p.g(obj2);
        this.p.i(object);
        int L0 = gj1.L0(bArr, i2, qf2);
        int i5 = qf2.f2938a;
        if (i5 < 0 || i5 > i3 - L0) {
            throw ah2.a();
        }
        throw null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:112:0x02f2, code lost:
        if (r0 == r2) goto L_0x033e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x033c, code lost:
        if (r0 == r15) goto L_0x033e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0340, code lost:
        r15 = r30;
        r14 = r31;
        r12 = r32;
        r1 = r33;
        r13 = r34;
        r11 = r35;
        r9 = r36;
        r6 = r19;
        r7 = r26;
        r10 = r27;
        r8 = -1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x036d A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int p(T r31, byte[] r32, int r33, int r34, int r35, defpackage.qf2 r36) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 1110
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ci2.p(java.lang.Object, byte[], int, int, int, qf2):int");
    }

    public final <K, V> void t(xj2 xj2, int i2, Object obj, int i3) throws IOException {
        if (obj != null) {
            this.p.g(this.b[(i3 / 4) << 1]);
            Map<?, ?> h2 = this.p.h(obj);
            dg2 dg2 = (dg2) xj2;
            Objects.requireNonNull(dg2);
            Iterator<Map.Entry<?, ?>> it = h2.entrySet().iterator();
            if (it.hasNext()) {
                Map.Entry<?, ?> next = it.next();
                dg2.f832a.p(i2, 2);
                next.getKey();
                next.getValue();
                throw null;
            }
        }
    }

    public final void u(T t, T t2, int i2) {
        long j2 = (long) (this.f567a[i2 + 1] & 1048575);
        if (v(t2, i2)) {
            Object t3 = jj2.t(t, j2);
            Object t4 = jj2.t(t2, j2);
            if (t3 != null && t4 != null) {
                jj2.f(t, j2, wg2.a(t3, t4));
                E(t, i2);
            } else if (t4 != null) {
                jj2.f(t, j2, t4);
                E(t, i2);
            }
        }
    }

    public final boolean v(T t, int i2) {
        if (this.h) {
            int i3 = this.f567a[i2 + 1];
            long j2 = (long) (i3 & 1048575);
            switch ((i3 & 267386880) >>> 20) {
                case 0:
                    return jj2.s(t, j2) != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                case 1:
                    return jj2.r(t, j2) != 0.0f;
                case 2:
                    return jj2.p(t, j2) != 0;
                case 3:
                    return jj2.p(t, j2) != 0;
                case 4:
                    return jj2.o(t, j2) != 0;
                case 5:
                    return jj2.p(t, j2) != 0;
                case 6:
                    return jj2.o(t, j2) != 0;
                case 7:
                    return jj2.q(t, j2);
                case 8:
                    Object t2 = jj2.t(t, j2);
                    if (t2 instanceof String) {
                        return !((String) t2).isEmpty();
                    }
                    if (t2 instanceof uf2) {
                        return !uf2.g.equals(t2);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return jj2.t(t, j2) != null;
                case 10:
                    return !uf2.g.equals(jj2.t(t, j2));
                case 11:
                    return jj2.o(t, j2) != 0;
                case 12:
                    return jj2.o(t, j2) != 0;
                case 13:
                    return jj2.o(t, j2) != 0;
                case 14:
                    return jj2.p(t, j2) != 0;
                case 15:
                    return jj2.o(t, j2) != 0;
                case 16:
                    return jj2.p(t, j2) != 0;
                case 17:
                    return jj2.t(t, j2) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            int i4 = this.f567a[i2 + 2];
            return (jj2.o(t, (long) (i4 & 1048575)) & (1 << (i4 >>> 20))) != 0;
        }
    }

    public final boolean w(T t, int i2, int i3) {
        return jj2.o(t, (long) (this.f567a[i3 + 2] & 1048575)) == i2;
    }

    public final boolean x(T t, int i2, int i3, int i4) {
        return this.h ? v(t, i2) : (i3 & i4) != 0;
    }

    public final pi2 y(int i2) {
        int i3 = (i2 / 4) << 1;
        Object[] objArr = this.b;
        pi2 pi2 = (pi2) objArr[i3];
        if (pi2 != null) {
            return pi2;
        }
        pi2<T> a2 = ki2.c.a((Class) objArr[i3 + 1]);
        this.b[i3] = a2;
        return a2;
    }

    public final Object z(int i2) {
        return this.b[(i2 / 4) << 1];
    }
}
