package defpackage;

import com.google.firebase.perf.util.Constants;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import sun.misc.Unsafe;

/* renamed from: dm2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class dm2<T> implements mm2<T> {
    public static final int[] p = new int[0];
    public static final Unsafe q = ln2.x();

    /* renamed from: a  reason: collision with root package name */
    public final int[] f857a;
    public final Object[] b;
    public final int c;
    public final int d;
    public final bm2 e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final int[] i;
    public final int j;
    public final int k;
    public final ql2 l;
    public final zm2<?, ?> m;
    public final t93<?> n;
    public final xl2 o;

    /* JADX WARN: Incorrect args count in method signature: ([I[Ljava/lang/Object;IILbm2;ZZ[IIILfm2;Lql2;Lzm2<**>;Lt93<*>;Lxl2;)V */
    public dm2(int[] iArr, Object[] objArr, int i2, int i3, bm2 bm2, boolean z, int[] iArr2, int i4, int i5, fm2 fm2, ql2 ql2, zm2 zm2, t93 t93, xl2 xl2) {
        this.f857a = iArr;
        this.b = objArr;
        this.c = i2;
        this.d = i3;
        this.g = bm2 instanceof ea3;
        this.h = z;
        this.f = t93 != null && t93.a(bm2);
        this.i = iArr2;
        this.j = i4;
        this.k = i5;
        this.l = ql2;
        this.m = zm2;
        this.n = t93;
        this.e = bm2;
        this.o = xl2;
    }

    public static final void C(int i2, Object obj, o93 o93) throws IOException {
        if (obj instanceof String) {
            o93.f2666a.s(i2, (String) obj);
            return;
        }
        o93.f2666a.t(i2, (g93) obj);
    }

    public static an2 D(Object obj) {
        ea3 ea3 = (ea3) obj;
        an2 an2 = ea3.zzc;
        if (an2 != an2.f) {
            return an2;
        }
        an2 a2 = an2.a();
        ea3.zzc = a2;
        return a2;
    }

    /* JADX WARN: Incorrect args count in method signature: <T:Ljava/lang/Object;>(Ljava/lang/Class<TT;>;Lzl2;Lfm2;Lql2;Lzm2<**>;Lt93<*>;Lxl2;)Ldm2<TT;>; */
    public static dm2 F(zl2 zl2, fm2 fm2, ql2 ql2, zm2 zm2, t93 t93, xl2 xl2) {
        if (zl2 instanceof lm2) {
            return G((lm2) zl2, fm2, ql2, zm2, t93, xl2);
        }
        xm2 xm2 = (xm2) zl2;
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:124:0x0275  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0278  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0290  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0293  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> defpackage.dm2<T> G(defpackage.lm2 r35, defpackage.fm2 r36, defpackage.ql2 r37, defpackage.zm2<?, ?> r38, defpackage.t93<?> r39, defpackage.xl2 r40) {
        /*
        // Method dump skipped, instructions count: 1038
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.dm2.G(lm2, fm2, ql2, zm2, t93, xl2):dm2");
    }

    public static Field H(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + name.length() + String.valueOf(arrays).length());
            hj1.V0(sb, "Field ", str, " for ", name);
            throw new RuntimeException(hj1.a0(sb, " not found. Known fields are ", arrays));
        }
    }

    public static boolean n(int i2) {
        return (i2 & 536870912) != 0;
    }

    public static <T> double o(T t, long j2) {
        return ((Double) ln2.t(t, j2)).doubleValue();
    }

    public static <T> float p(T t, long j2) {
        return ((Float) ln2.t(t, j2)).floatValue();
    }

    public static <T> int q(T t, long j2) {
        return ((Integer) ln2.t(t, j2)).intValue();
    }

    public static <T> long r(T t, long j2) {
        return ((Long) ln2.t(t, j2)).longValue();
    }

    public static <T> boolean s(T t, long j2) {
        return ((Boolean) ln2.t(t, j2)).booleanValue();
    }

    public final int A(int i2, int i3) {
        int length = (this.f857a.length / 3) - 1;
        while (i3 <= length) {
            int i4 = (length + i3) >>> 1;
            int i5 = i4 * 3;
            int i6 = this.f857a[i5];
            if (i2 == i6) {
                return i5;
            }
            if (i2 < i6) {
                length = i4 - 1;
            } else {
                i3 = i4 + 1;
            }
        }
        return -1;
    }

    public final void B(T t, o93 o93) throws IOException {
        int i2;
        if (!this.f) {
            int length = this.f857a.length;
            Unsafe unsafe = q;
            int i3 = 1048575;
            int i4 = 0;
            int i5 = 1048575;
            int i6 = 0;
            while (i4 < length) {
                int l2 = l(i4);
                int[] iArr = this.f857a;
                int i7 = iArr[i4];
                int i8 = (l2 >>> 20) & Constants.MAX_HOST_LENGTH;
                if (i8 <= 17) {
                    int i9 = iArr[i4 + 2];
                    int i10 = i9 & i3;
                    if (i10 != i5) {
                        i6 = unsafe.getInt(t, (long) i10);
                        i5 = i10;
                    }
                    i2 = 1 << (i9 >>> 20);
                } else {
                    i2 = 0;
                }
                long j2 = (long) (l2 & i3);
                switch (i8) {
                    case 0:
                        if ((i6 & i2) != 0) {
                            o93.b(i7, ln2.r(t, j2));
                            continue;
                        }
                        i4 += 3;
                        i3 = 1048575;
                    case 1:
                        if ((i6 & i2) != 0) {
                            o93.a(i7, ln2.p(t, j2));
                        } else {
                            continue;
                        }
                        i4 += 3;
                        i3 = 1048575;
                    case 2:
                        if ((i6 & i2) != 0) {
                            o93.f2666a.o(i7, unsafe.getLong(t, j2));
                        } else {
                            continue;
                        }
                        i4 += 3;
                        i3 = 1048575;
                    case 3:
                        if ((i6 & i2) != 0) {
                            o93.f2666a.o(i7, unsafe.getLong(t, j2));
                        } else {
                            continue;
                        }
                        i4 += 3;
                        i3 = 1048575;
                    case 4:
                        if ((i6 & i2) != 0) {
                            o93.f2666a.l(i7, unsafe.getInt(t, j2));
                        } else {
                            continue;
                        }
                        i4 += 3;
                        i3 = 1048575;
                    case 5:
                        if ((i6 & i2) != 0) {
                            o93.f2666a.q(i7, unsafe.getLong(t, j2));
                        } else {
                            continue;
                        }
                        i4 += 3;
                        i3 = 1048575;
                    case 6:
                        if ((i6 & i2) != 0) {
                            o93.f2666a.n(i7, unsafe.getInt(t, j2));
                        } else {
                            continue;
                        }
                        i4 += 3;
                        i3 = 1048575;
                    case 7:
                        if ((i6 & i2) != 0) {
                            o93.f2666a.r(i7, ln2.n(t, j2));
                        } else {
                            continue;
                        }
                        i4 += 3;
                        i3 = 1048575;
                    case 8:
                        if ((i6 & i2) != 0) {
                            C(i7, unsafe.getObject(t, j2), o93);
                        } else {
                            continue;
                        }
                        i4 += 3;
                        i3 = 1048575;
                    case 9:
                        if ((i6 & i2) != 0) {
                            o93.e(i7, unsafe.getObject(t, j2), P(i4));
                        } else {
                            continue;
                        }
                        i4 += 3;
                        i3 = 1048575;
                    case 10:
                        if ((i6 & i2) != 0) {
                            o93.f2666a.t(i7, (g93) unsafe.getObject(t, j2));
                        } else {
                            continue;
                        }
                        i4 += 3;
                        i3 = 1048575;
                    case 11:
                        if ((i6 & i2) != 0) {
                            o93.f2666a.m(i7, unsafe.getInt(t, j2));
                        } else {
                            continue;
                        }
                        i4 += 3;
                        i3 = 1048575;
                    case 12:
                        if ((i6 & i2) != 0) {
                            o93.f2666a.l(i7, unsafe.getInt(t, j2));
                        } else {
                            continue;
                        }
                        i4 += 3;
                        i3 = 1048575;
                    case 13:
                        if ((i6 & i2) != 0) {
                            o93.f2666a.n(i7, unsafe.getInt(t, j2));
                        } else {
                            continue;
                        }
                        i4 += 3;
                        i3 = 1048575;
                    case 14:
                        if ((i6 & i2) != 0) {
                            o93.f2666a.q(i7, unsafe.getLong(t, j2));
                        } else {
                            continue;
                        }
                        i4 += 3;
                        i3 = 1048575;
                    case 15:
                        if ((i6 & i2) != 0) {
                            o93.c(i7, unsafe.getInt(t, j2));
                        } else {
                            continue;
                        }
                        i4 += 3;
                        i3 = 1048575;
                    case 16:
                        if ((i6 & i2) != 0) {
                            o93.d(i7, unsafe.getLong(t, j2));
                        } else {
                            continue;
                        }
                        i4 += 3;
                        i3 = 1048575;
                    case 17:
                        if ((i6 & i2) != 0) {
                            o93.f(i7, unsafe.getObject(t, j2), P(i4));
                        } else {
                            continue;
                        }
                        i4 += 3;
                        i3 = 1048575;
                    case 18:
                        om2.d(this.f857a[i4], (List) unsafe.getObject(t, j2), o93, false);
                        continue;
                        i4 += 3;
                        i3 = 1048575;
                    case 19:
                        om2.e(this.f857a[i4], (List) unsafe.getObject(t, j2), o93, false);
                        continue;
                        i4 += 3;
                        i3 = 1048575;
                    case 20:
                        om2.f(this.f857a[i4], (List) unsafe.getObject(t, j2), o93, false);
                        continue;
                        i4 += 3;
                        i3 = 1048575;
                    case 21:
                        om2.g(this.f857a[i4], (List) unsafe.getObject(t, j2), o93, false);
                        continue;
                        i4 += 3;
                        i3 = 1048575;
                    case 22:
                        om2.k(this.f857a[i4], (List) unsafe.getObject(t, j2), o93, false);
                        continue;
                        i4 += 3;
                        i3 = 1048575;
                    case 23:
                        om2.i(this.f857a[i4], (List) unsafe.getObject(t, j2), o93, false);
                        continue;
                        i4 += 3;
                        i3 = 1048575;
                    case 24:
                        om2.n(this.f857a[i4], (List) unsafe.getObject(t, j2), o93, false);
                        continue;
                        i4 += 3;
                        i3 = 1048575;
                    case 25:
                        om2.q(this.f857a[i4], (List) unsafe.getObject(t, j2), o93, false);
                        continue;
                        i4 += 3;
                        i3 = 1048575;
                    case 26:
                        om2.r(this.f857a[i4], (List) unsafe.getObject(t, j2), o93);
                        break;
                    case 27:
                        om2.t(this.f857a[i4], (List) unsafe.getObject(t, j2), o93, P(i4));
                        break;
                    case 28:
                        om2.s(this.f857a[i4], (List) unsafe.getObject(t, j2), o93);
                        break;
                    case 29:
                        om2.l(this.f857a[i4], (List) unsafe.getObject(t, j2), o93, false);
                        break;
                    case 30:
                        om2.p(this.f857a[i4], (List) unsafe.getObject(t, j2), o93, false);
                        break;
                    case 31:
                        om2.o(this.f857a[i4], (List) unsafe.getObject(t, j2), o93, false);
                        break;
                    case 32:
                        om2.j(this.f857a[i4], (List) unsafe.getObject(t, j2), o93, false);
                        break;
                    case 33:
                        om2.m(this.f857a[i4], (List) unsafe.getObject(t, j2), o93, false);
                        break;
                    case 34:
                        om2.h(this.f857a[i4], (List) unsafe.getObject(t, j2), o93, false);
                        break;
                    case 35:
                        om2.d(this.f857a[i4], (List) unsafe.getObject(t, j2), o93, true);
                        break;
                    case 36:
                        om2.e(this.f857a[i4], (List) unsafe.getObject(t, j2), o93, true);
                        break;
                    case 37:
                        om2.f(this.f857a[i4], (List) unsafe.getObject(t, j2), o93, true);
                        break;
                    case 38:
                        om2.g(this.f857a[i4], (List) unsafe.getObject(t, j2), o93, true);
                        break;
                    case 39:
                        om2.k(this.f857a[i4], (List) unsafe.getObject(t, j2), o93, true);
                        break;
                    case 40:
                        om2.i(this.f857a[i4], (List) unsafe.getObject(t, j2), o93, true);
                        break;
                    case 41:
                        om2.n(this.f857a[i4], (List) unsafe.getObject(t, j2), o93, true);
                        break;
                    case 42:
                        om2.q(this.f857a[i4], (List) unsafe.getObject(t, j2), o93, true);
                        break;
                    case 43:
                        om2.l(this.f857a[i4], (List) unsafe.getObject(t, j2), o93, true);
                        break;
                    case 44:
                        om2.p(this.f857a[i4], (List) unsafe.getObject(t, j2), o93, true);
                        break;
                    case 45:
                        om2.o(this.f857a[i4], (List) unsafe.getObject(t, j2), o93, true);
                        break;
                    case 46:
                        om2.j(this.f857a[i4], (List) unsafe.getObject(t, j2), o93, true);
                        break;
                    case 47:
                        om2.m(this.f857a[i4], (List) unsafe.getObject(t, j2), o93, true);
                        break;
                    case 48:
                        om2.h(this.f857a[i4], (List) unsafe.getObject(t, j2), o93, true);
                        break;
                    case 49:
                        om2.u(this.f857a[i4], (List) unsafe.getObject(t, j2), o93, P(i4));
                        break;
                    case 50:
                        if (unsafe.getObject(t, j2) != null) {
                            vl2 vl2 = (vl2) Q(i4);
                            throw null;
                        }
                        break;
                    case 51:
                        if (x(t, i7, i4)) {
                            o93.b(i7, o(t, j2));
                            break;
                        }
                        break;
                    case 52:
                        if (x(t, i7, i4)) {
                            o93.a(i7, p(t, j2));
                            break;
                        }
                        break;
                    case 53:
                        if (x(t, i7, i4)) {
                            o93.f2666a.o(i7, r(t, j2));
                            break;
                        }
                        break;
                    case 54:
                        if (x(t, i7, i4)) {
                            o93.f2666a.o(i7, r(t, j2));
                            break;
                        }
                        break;
                    case 55:
                        if (x(t, i7, i4)) {
                            o93.f2666a.l(i7, q(t, j2));
                            break;
                        }
                        break;
                    case 56:
                        if (x(t, i7, i4)) {
                            o93.f2666a.q(i7, r(t, j2));
                            break;
                        }
                        break;
                    case 57:
                        if (x(t, i7, i4)) {
                            o93.f2666a.n(i7, q(t, j2));
                            break;
                        }
                        break;
                    case 58:
                        if (x(t, i7, i4)) {
                            o93.f2666a.r(i7, s(t, j2));
                            break;
                        }
                        break;
                    case 59:
                        if (x(t, i7, i4)) {
                            C(i7, unsafe.getObject(t, j2), o93);
                            break;
                        }
                        break;
                    case 60:
                        if (x(t, i7, i4)) {
                            o93.e(i7, unsafe.getObject(t, j2), P(i4));
                            break;
                        }
                        break;
                    case 61:
                        if (x(t, i7, i4)) {
                            o93.f2666a.t(i7, (g93) unsafe.getObject(t, j2));
                            break;
                        }
                        break;
                    case 62:
                        if (x(t, i7, i4)) {
                            o93.f2666a.m(i7, q(t, j2));
                            break;
                        }
                        break;
                    case 63:
                        if (x(t, i7, i4)) {
                            o93.f2666a.l(i7, q(t, j2));
                            break;
                        }
                        break;
                    case 64:
                        if (x(t, i7, i4)) {
                            o93.f2666a.n(i7, q(t, j2));
                            break;
                        }
                        break;
                    case 65:
                        if (x(t, i7, i4)) {
                            o93.f2666a.q(i7, r(t, j2));
                            break;
                        }
                        break;
                    case 66:
                        if (x(t, i7, i4)) {
                            o93.c(i7, q(t, j2));
                            break;
                        }
                        break;
                    case 67:
                        if (x(t, i7, i4)) {
                            o93.d(i7, r(t, j2));
                            break;
                        }
                        break;
                    case 68:
                        if (x(t, i7, i4)) {
                            o93.f(i7, unsafe.getObject(t, j2), P(i4));
                            break;
                        }
                        break;
                }
                i4 += 3;
                i3 = 1048575;
            }
            zm2<?, ?> zm2 = this.m;
            zm2.r(zm2.j(t), o93);
            return;
        }
        this.n.b(t);
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v32, types: [int] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int E(T r29, byte[] r30, int r31, int r32, int r33, defpackage.v83 r34) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 1200
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.dm2.E(java.lang.Object, byte[], int, int, int, v83):int");
    }

    public final void I(T t, T t2, int i2) {
        long j2 = (long) (this.f857a[i2 + 1] & 1048575);
        if (v(t2, i2)) {
            Object t3 = ln2.t(t, j2);
            Object t4 = ln2.t(t2, j2);
            if (t3 != null && t4 != null) {
                ln2.e.o(t, j2, ka3.c(t3, t4));
                w(t, i2);
            } else if (t4 != null) {
                ln2.e.o(t, j2, t4);
                w(t, i2);
            }
        }
    }

    public final void J(T t, T t2, int i2) {
        int[] iArr = this.f857a;
        int i3 = iArr[i2 + 1];
        int i4 = iArr[i2];
        long j2 = (long) (i3 & 1048575);
        if (x(t2, i4, i2)) {
            Object t3 = x(t, i4, i2) ? ln2.t(t, j2) : null;
            Object t4 = ln2.t(t2, j2);
            if (t3 != null && t4 != null) {
                ln2.e.o(t, j2, ka3.c(t3, t4));
                y(t, i4, i2);
            } else if (t4 != null) {
                ln2.e.o(t, j2, t4);
                y(t, i4, i2);
            }
        }
    }

    public final int K(T t) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        Unsafe unsafe = q;
        int i21 = 1048575;
        int i22 = 0;
        int i23 = 0;
        int i24 = 1048575;
        int i25 = 0;
        while (i22 < this.f857a.length) {
            int l2 = l(i22);
            int[] iArr = this.f857a;
            int i26 = iArr[i22];
            int i27 = (l2 >>> 20) & Constants.MAX_HOST_LENGTH;
            if (i27 <= 17) {
                int i28 = iArr[i22 + 2];
                int i29 = i28 & i21;
                i2 = 1 << (i28 >>> 20);
                if (i29 != i24) {
                    i25 = unsafe.getInt(t, (long) i29);
                    i24 = i29;
                }
            } else {
                i2 = 0;
            }
            long j2 = (long) (i21 & l2);
            switch (i27) {
                case 0:
                    if ((i25 & i2) == 0) {
                        break;
                    } else {
                        i4 = n93.B(i26);
                        i3 = i4 + 8;
                        i23 += i3;
                        break;
                    }
                case 1:
                    if ((i25 & i2) == 0) {
                        break;
                    } else {
                        i5 = n93.B(i26);
                        i3 = i5 + 4;
                        i23 += i3;
                        break;
                    }
                case 2:
                    if ((i2 & i25) == 0) {
                        break;
                    } else {
                        long j3 = unsafe.getLong(t, j2);
                        i7 = n93.B(i26);
                        i6 = n93.c(j3);
                        i3 = i7 + i6;
                        i23 += i3;
                        break;
                    }
                case 3:
                    if ((i2 & i25) == 0) {
                        break;
                    } else {
                        long j4 = unsafe.getLong(t, j2);
                        i7 = n93.B(i26);
                        i6 = n93.c(j4);
                        i3 = i7 + i6;
                        i23 += i3;
                        break;
                    }
                case 4:
                    if ((i2 & i25) == 0) {
                        break;
                    } else {
                        int i30 = unsafe.getInt(t, j2);
                        i8 = n93.B(i26);
                        i9 = n93.C(i30);
                        i3 = i9 + i8;
                        i23 += i3;
                        break;
                    }
                case 5:
                    if ((i25 & i2) == 0) {
                        break;
                    } else {
                        i4 = n93.B(i26);
                        i3 = i4 + 8;
                        i23 += i3;
                        break;
                    }
                case 6:
                    if ((i25 & i2) == 0) {
                        break;
                    } else {
                        i5 = n93.B(i26);
                        i3 = i5 + 4;
                        i23 += i3;
                        break;
                    }
                case 7:
                    if ((i25 & i2) == 0) {
                        break;
                    } else {
                        i10 = n93.B(i26);
                        i3 = i10 + 1;
                        i23 += i3;
                        break;
                    }
                case 8:
                    if ((i2 & i25) == 0) {
                        break;
                    } else {
                        Object object = unsafe.getObject(t, j2);
                        if (!(object instanceof g93)) {
                            i8 = n93.B(i26);
                            i9 = n93.d((String) object);
                            i3 = i9 + i8;
                            i23 += i3;
                            break;
                        } else {
                            i12 = n93.B(i26);
                            i13 = ((g93) object).e();
                            i11 = n93.b(i13);
                            i23 = i11 + i13 + i12 + i23;
                            break;
                        }
                    }
                case 9:
                    if ((i2 & i25) == 0) {
                        break;
                    } else {
                        i3 = om2.P(i26, unsafe.getObject(t, j2), P(i22));
                        i23 += i3;
                        break;
                    }
                case 10:
                    if ((i2 & i25) == 0) {
                        break;
                    } else {
                        i12 = n93.B(i26);
                        i13 = ((g93) unsafe.getObject(t, j2)).e();
                        i11 = n93.b(i13);
                        i23 = i11 + i13 + i12 + i23;
                        break;
                    }
                case 11:
                    if ((i2 & i25) == 0) {
                        break;
                    } else {
                        int i31 = unsafe.getInt(t, j2);
                        i8 = n93.B(i26);
                        i9 = n93.b(i31);
                        i3 = i9 + i8;
                        i23 += i3;
                        break;
                    }
                case 12:
                    if ((i2 & i25) == 0) {
                        break;
                    } else {
                        int i32 = unsafe.getInt(t, j2);
                        i8 = n93.B(i26);
                        i9 = n93.C(i32);
                        i3 = i9 + i8;
                        i23 += i3;
                        break;
                    }
                case 13:
                    if ((i25 & i2) == 0) {
                        break;
                    } else {
                        i5 = n93.B(i26);
                        i3 = i5 + 4;
                        i23 += i3;
                        break;
                    }
                case 14:
                    if ((i25 & i2) == 0) {
                        break;
                    } else {
                        i4 = n93.B(i26);
                        i3 = i4 + 8;
                        i23 += i3;
                        break;
                    }
                case 15:
                    if ((i2 & i25) == 0) {
                        break;
                    } else {
                        int i33 = unsafe.getInt(t, j2);
                        i8 = n93.B(i26);
                        i9 = n93.b(n93.g(i33));
                        i3 = i9 + i8;
                        i23 += i3;
                        break;
                    }
                case 16:
                    if ((i2 & i25) == 0) {
                        break;
                    } else {
                        long j5 = unsafe.getLong(t, j2);
                        i7 = n93.B(i26);
                        i6 = n93.c(n93.h(j5));
                        i3 = i7 + i6;
                        i23 += i3;
                        break;
                    }
                case 17:
                    if ((i2 & i25) == 0) {
                        break;
                    } else {
                        i3 = n93.j(i26, (bm2) unsafe.getObject(t, j2), P(i22));
                        i23 += i3;
                        break;
                    }
                case 18:
                    i3 = om2.N(i26, (List) unsafe.getObject(t, j2));
                    i23 += i3;
                    break;
                case 19:
                    i3 = om2.L(i26, (List) unsafe.getObject(t, j2));
                    i23 += i3;
                    break;
                case 20:
                    i3 = om2.x(i26, (List) unsafe.getObject(t, j2));
                    i23 += i3;
                    break;
                case 21:
                    i3 = om2.z(i26, (List) unsafe.getObject(t, j2), false);
                    i23 += i3;
                    break;
                case 22:
                    i3 = om2.F(i26, (List) unsafe.getObject(t, j2), false);
                    i23 += i3;
                    break;
                case 23:
                    i3 = om2.N(i26, (List) unsafe.getObject(t, j2));
                    i23 += i3;
                    break;
                case 24:
                    i3 = om2.L(i26, (List) unsafe.getObject(t, j2));
                    i23 += i3;
                    break;
                case 25:
                    Class<?> cls = om2.f2710a;
                    int size = ((List) unsafe.getObject(t, j2)).size();
                    if (size == 0) {
                        i14 = 0;
                    } else {
                        i14 = (n93.B(i26) + 1) * size;
                    }
                    i23 += i14;
                    break;
                case 26:
                    i3 = om2.O(i26, (List) unsafe.getObject(t, j2));
                    i23 += i3;
                    break;
                case 27:
                    i3 = om2.Q(i26, (List) unsafe.getObject(t, j2), P(i22));
                    i23 += i3;
                    break;
                case 28:
                    i3 = om2.R(i26, (List) unsafe.getObject(t, j2));
                    i23 += i3;
                    break;
                case 29:
                    i3 = om2.H(i26, (List) unsafe.getObject(t, j2), false);
                    i23 += i3;
                    break;
                case 30:
                    i3 = om2.D(i26, (List) unsafe.getObject(t, j2), false);
                    i23 += i3;
                    break;
                case 31:
                    i3 = om2.L(i26, (List) unsafe.getObject(t, j2));
                    i23 += i3;
                    break;
                case 32:
                    i3 = om2.N(i26, (List) unsafe.getObject(t, j2));
                    i23 += i3;
                    break;
                case 33:
                    i3 = om2.J(i26, (List) unsafe.getObject(t, j2), false);
                    i23 += i3;
                    break;
                case 34:
                    i3 = om2.B(i26, (List) unsafe.getObject(t, j2), false);
                    i23 += i3;
                    break;
                case 35:
                    i17 = om2.M((List) unsafe.getObject(t, j2));
                    if (i17 <= 0) {
                        break;
                    } else {
                        i16 = n93.B(i26);
                        i15 = n93.b(i17);
                        i14 = i15 + i16 + i17;
                        i23 += i14;
                        break;
                    }
                case 36:
                    i17 = om2.K((List) unsafe.getObject(t, j2));
                    if (i17 <= 0) {
                        break;
                    } else {
                        i16 = n93.B(i26);
                        i15 = n93.b(i17);
                        i14 = i15 + i16 + i17;
                        i23 += i14;
                        break;
                    }
                case 37:
                    i17 = om2.w((List) unsafe.getObject(t, j2));
                    if (i17 <= 0) {
                        break;
                    } else {
                        i16 = n93.B(i26);
                        i15 = n93.b(i17);
                        i14 = i15 + i16 + i17;
                        i23 += i14;
                        break;
                    }
                case 38:
                    i17 = om2.y((List) unsafe.getObject(t, j2));
                    if (i17 <= 0) {
                        break;
                    } else {
                        i16 = n93.B(i26);
                        i15 = n93.b(i17);
                        i14 = i15 + i16 + i17;
                        i23 += i14;
                        break;
                    }
                case 39:
                    i17 = om2.E((List) unsafe.getObject(t, j2));
                    if (i17 <= 0) {
                        break;
                    } else {
                        i16 = n93.B(i26);
                        i15 = n93.b(i17);
                        i14 = i15 + i16 + i17;
                        i23 += i14;
                        break;
                    }
                case 40:
                    i17 = om2.M((List) unsafe.getObject(t, j2));
                    if (i17 <= 0) {
                        break;
                    } else {
                        i16 = n93.B(i26);
                        i15 = n93.b(i17);
                        i14 = i15 + i16 + i17;
                        i23 += i14;
                        break;
                    }
                case 41:
                    i17 = om2.K((List) unsafe.getObject(t, j2));
                    if (i17 <= 0) {
                        break;
                    } else {
                        i16 = n93.B(i26);
                        i15 = n93.b(i17);
                        i14 = i15 + i16 + i17;
                        i23 += i14;
                        break;
                    }
                case 42:
                    Class<?> cls2 = om2.f2710a;
                    i17 = ((List) unsafe.getObject(t, j2)).size();
                    if (i17 <= 0) {
                        break;
                    } else {
                        i16 = n93.B(i26);
                        i15 = n93.b(i17);
                        i14 = i15 + i16 + i17;
                        i23 += i14;
                        break;
                    }
                case 43:
                    i17 = om2.G((List) unsafe.getObject(t, j2));
                    if (i17 <= 0) {
                        break;
                    } else {
                        i16 = n93.B(i26);
                        i15 = n93.b(i17);
                        i14 = i15 + i16 + i17;
                        i23 += i14;
                        break;
                    }
                case 44:
                    i17 = om2.C((List) unsafe.getObject(t, j2));
                    if (i17 <= 0) {
                        break;
                    } else {
                        i16 = n93.B(i26);
                        i15 = n93.b(i17);
                        i14 = i15 + i16 + i17;
                        i23 += i14;
                        break;
                    }
                case 45:
                    i17 = om2.K((List) unsafe.getObject(t, j2));
                    if (i17 <= 0) {
                        break;
                    } else {
                        i16 = n93.B(i26);
                        i15 = n93.b(i17);
                        i14 = i15 + i16 + i17;
                        i23 += i14;
                        break;
                    }
                case 46:
                    i17 = om2.M((List) unsafe.getObject(t, j2));
                    if (i17 <= 0) {
                        break;
                    } else {
                        i16 = n93.B(i26);
                        i15 = n93.b(i17);
                        i14 = i15 + i16 + i17;
                        i23 += i14;
                        break;
                    }
                case 47:
                    i17 = om2.I((List) unsafe.getObject(t, j2));
                    if (i17 <= 0) {
                        break;
                    } else {
                        i16 = n93.B(i26);
                        i15 = n93.b(i17);
                        i14 = i15 + i16 + i17;
                        i23 += i14;
                        break;
                    }
                case 48:
                    i17 = om2.A((List) unsafe.getObject(t, j2));
                    if (i17 <= 0) {
                        break;
                    } else {
                        i16 = n93.B(i26);
                        i15 = n93.b(i17);
                        i14 = i15 + i16 + i17;
                        i23 += i14;
                        break;
                    }
                case 49:
                    i3 = om2.S(i26, (List) unsafe.getObject(t, j2), P(i22));
                    i23 += i3;
                    break;
                case 50:
                    xl2.a(i26, unsafe.getObject(t, j2), Q(i22));
                    break;
                case 51:
                    if (!x(t, i26, i22)) {
                        break;
                    } else {
                        i4 = n93.B(i26);
                        i3 = i4 + 8;
                        i23 += i3;
                        break;
                    }
                case 52:
                    if (!x(t, i26, i22)) {
                        break;
                    } else {
                        i5 = n93.B(i26);
                        i3 = i5 + 4;
                        i23 += i3;
                        break;
                    }
                case 53:
                    if (!x(t, i26, i22)) {
                        break;
                    } else {
                        long r = r(t, j2);
                        i7 = n93.B(i26);
                        i6 = n93.c(r);
                        i3 = i7 + i6;
                        i23 += i3;
                        break;
                    }
                case 54:
                    if (!x(t, i26, i22)) {
                        break;
                    } else {
                        long r2 = r(t, j2);
                        i7 = n93.B(i26);
                        i6 = n93.c(r2);
                        i3 = i7 + i6;
                        i23 += i3;
                        break;
                    }
                case 55:
                    if (!x(t, i26, i22)) {
                        break;
                    } else {
                        int q2 = q(t, j2);
                        i8 = n93.B(i26);
                        i9 = n93.C(q2);
                        i3 = i9 + i8;
                        i23 += i3;
                        break;
                    }
                case 56:
                    if (!x(t, i26, i22)) {
                        break;
                    } else {
                        i4 = n93.B(i26);
                        i3 = i4 + 8;
                        i23 += i3;
                        break;
                    }
                case 57:
                    if (!x(t, i26, i22)) {
                        break;
                    } else {
                        i5 = n93.B(i26);
                        i3 = i5 + 4;
                        i23 += i3;
                        break;
                    }
                case 58:
                    if (!x(t, i26, i22)) {
                        break;
                    } else {
                        i10 = n93.B(i26);
                        i3 = i10 + 1;
                        i23 += i3;
                        break;
                    }
                case 59:
                    if (!x(t, i26, i22)) {
                        break;
                    } else {
                        Object object2 = unsafe.getObject(t, j2);
                        if (!(object2 instanceof g93)) {
                            i8 = n93.B(i26);
                            i9 = n93.d((String) object2);
                            i3 = i9 + i8;
                            i23 += i3;
                            break;
                        } else {
                            i19 = n93.B(i26);
                            i20 = ((g93) object2).e();
                            i18 = n93.b(i20);
                            i14 = i18 + i20 + i19;
                            i23 += i14;
                            break;
                        }
                    }
                case 60:
                    if (!x(t, i26, i22)) {
                        break;
                    } else {
                        i3 = om2.P(i26, unsafe.getObject(t, j2), P(i22));
                        i23 += i3;
                        break;
                    }
                case 61:
                    if (!x(t, i26, i22)) {
                        break;
                    } else {
                        i19 = n93.B(i26);
                        i20 = ((g93) unsafe.getObject(t, j2)).e();
                        i18 = n93.b(i20);
                        i14 = i18 + i20 + i19;
                        i23 += i14;
                        break;
                    }
                case 62:
                    if (!x(t, i26, i22)) {
                        break;
                    } else {
                        int q3 = q(t, j2);
                        i8 = n93.B(i26);
                        i9 = n93.b(q3);
                        i3 = i9 + i8;
                        i23 += i3;
                        break;
                    }
                case 63:
                    if (!x(t, i26, i22)) {
                        break;
                    } else {
                        int q4 = q(t, j2);
                        i8 = n93.B(i26);
                        i9 = n93.C(q4);
                        i3 = i9 + i8;
                        i23 += i3;
                        break;
                    }
                case 64:
                    if (!x(t, i26, i22)) {
                        break;
                    } else {
                        i5 = n93.B(i26);
                        i3 = i5 + 4;
                        i23 += i3;
                        break;
                    }
                case 65:
                    if (!x(t, i26, i22)) {
                        break;
                    } else {
                        i4 = n93.B(i26);
                        i3 = i4 + 8;
                        i23 += i3;
                        break;
                    }
                case 66:
                    if (!x(t, i26, i22)) {
                        break;
                    } else {
                        int q5 = q(t, j2);
                        i8 = n93.B(i26);
                        i9 = n93.b(n93.g(q5));
                        i3 = i9 + i8;
                        i23 += i3;
                        break;
                    }
                case 67:
                    if (!x(t, i26, i22)) {
                        break;
                    } else {
                        long r3 = r(t, j2);
                        i7 = n93.B(i26);
                        i6 = n93.c(n93.h(r3));
                        i3 = i7 + i6;
                        i23 += i3;
                        break;
                    }
                case 68:
                    if (!x(t, i26, i22)) {
                        break;
                    } else {
                        i3 = n93.j(i26, (bm2) unsafe.getObject(t, j2), P(i22));
                        i23 += i3;
                        break;
                    }
            }
            i22 += 3;
            i21 = 1048575;
        }
        zm2<?, ?> zm2 = this.m;
        int q6 = zm2.q(zm2.j(t)) + i23;
        if (!this.f) {
            return q6;
        }
        this.n.b(t);
        throw null;
    }

    public final int L(T t) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        Unsafe unsafe = q;
        int i17 = 0;
        for (int i18 = 0; i18 < this.f857a.length; i18 += 3) {
            int l2 = l(i18);
            int i19 = (l2 >>> 20) & Constants.MAX_HOST_LENGTH;
            int i20 = this.f857a[i18];
            long j2 = (long) (l2 & 1048575);
            if (i19 >= y93.DOUBLE_LIST_PACKED.zza() && i19 <= y93.SINT64_LIST_PACKED.zza()) {
                int i21 = this.f857a[i18 + 2];
            }
            switch (i19) {
                case 0:
                    if (v(t, i18)) {
                        i3 = n93.B(i20);
                        i2 = i3 + 8;
                        break;
                    } else {
                        continue;
                    }
                case 1:
                    if (v(t, i18)) {
                        i4 = n93.B(i20);
                        i2 = i4 + 4;
                        break;
                    } else {
                        continue;
                    }
                case 2:
                    if (v(t, i18)) {
                        long l3 = ln2.l(t, j2);
                        i5 = n93.B(i20);
                        i6 = n93.c(l3);
                        i2 = i6 + i5;
                        break;
                    } else {
                        continue;
                    }
                case 3:
                    if (v(t, i18)) {
                        long l4 = ln2.l(t, j2);
                        i5 = n93.B(i20);
                        i6 = n93.c(l4);
                        i2 = i6 + i5;
                        break;
                    } else {
                        continue;
                    }
                case 4:
                    if (v(t, i18)) {
                        int j3 = ln2.j(t, j2);
                        i7 = n93.B(i20);
                        i8 = n93.C(j3);
                        i2 = i8 + i7;
                        break;
                    } else {
                        continue;
                    }
                case 5:
                    if (v(t, i18)) {
                        i3 = n93.B(i20);
                        i2 = i3 + 8;
                        break;
                    } else {
                        continue;
                    }
                case 6:
                    if (v(t, i18)) {
                        i4 = n93.B(i20);
                        i2 = i4 + 4;
                        break;
                    } else {
                        continue;
                    }
                case 7:
                    if (v(t, i18)) {
                        i9 = n93.B(i20);
                        i2 = i9 + 1;
                        break;
                    } else {
                        continue;
                    }
                case 8:
                    if (v(t, i18)) {
                        Object t2 = ln2.t(t, j2);
                        if (!(t2 instanceof g93)) {
                            i7 = n93.B(i20);
                            i8 = n93.d((String) t2);
                            i2 = i8 + i7;
                            break;
                        } else {
                            i12 = n93.B(i20);
                            i13 = ((g93) t2).e();
                            i11 = n93.b(i13);
                            i10 = i11 + i13 + i12;
                            i17 += i10;
                        }
                    } else {
                        continue;
                    }
                case 9:
                    if (v(t, i18)) {
                        i2 = om2.P(i20, ln2.t(t, j2), P(i18));
                        break;
                    } else {
                        continue;
                    }
                case 10:
                    if (v(t, i18)) {
                        i12 = n93.B(i20);
                        i13 = ((g93) ln2.t(t, j2)).e();
                        i11 = n93.b(i13);
                        i10 = i11 + i13 + i12;
                        i17 += i10;
                    } else {
                        continue;
                    }
                case 11:
                    if (v(t, i18)) {
                        int j4 = ln2.j(t, j2);
                        i7 = n93.B(i20);
                        i8 = n93.b(j4);
                        i2 = i8 + i7;
                        break;
                    } else {
                        continue;
                    }
                case 12:
                    if (v(t, i18)) {
                        int j5 = ln2.j(t, j2);
                        i7 = n93.B(i20);
                        i8 = n93.C(j5);
                        i2 = i8 + i7;
                        break;
                    } else {
                        continue;
                    }
                case 13:
                    if (v(t, i18)) {
                        i4 = n93.B(i20);
                        i2 = i4 + 4;
                        break;
                    } else {
                        continue;
                    }
                case 14:
                    if (v(t, i18)) {
                        i3 = n93.B(i20);
                        i2 = i3 + 8;
                        break;
                    } else {
                        continue;
                    }
                case 15:
                    if (v(t, i18)) {
                        int j6 = ln2.j(t, j2);
                        i7 = n93.B(i20);
                        i8 = n93.b(n93.g(j6));
                        i2 = i8 + i7;
                        break;
                    } else {
                        continue;
                    }
                case 16:
                    if (v(t, i18)) {
                        long l5 = ln2.l(t, j2);
                        i5 = n93.B(i20);
                        i6 = n93.c(n93.h(l5));
                        i2 = i6 + i5;
                        break;
                    } else {
                        continue;
                    }
                case 17:
                    if (v(t, i18)) {
                        i2 = n93.j(i20, (bm2) ln2.t(t, j2), P(i18));
                        break;
                    } else {
                        continue;
                    }
                case 18:
                    i2 = om2.N(i20, (List) ln2.t(t, j2));
                    break;
                case 19:
                    i2 = om2.L(i20, (List) ln2.t(t, j2));
                    break;
                case 20:
                    i2 = om2.x(i20, (List) ln2.t(t, j2));
                    break;
                case 21:
                    i2 = om2.z(i20, (List) ln2.t(t, j2), false);
                    break;
                case 22:
                    i2 = om2.F(i20, (List) ln2.t(t, j2), false);
                    break;
                case 23:
                    i2 = om2.N(i20, (List) ln2.t(t, j2));
                    break;
                case 24:
                    i2 = om2.L(i20, (List) ln2.t(t, j2));
                    break;
                case 25:
                    Class<?> cls = om2.f2710a;
                    int size = ((List) ln2.t(t, j2)).size();
                    if (size == 0) {
                        i2 = 0;
                        break;
                    } else {
                        i2 = size * (n93.B(i20) + 1);
                        break;
                    }
                case 26:
                    i2 = om2.O(i20, (List) ln2.t(t, j2));
                    break;
                case 27:
                    i2 = om2.Q(i20, (List) ln2.t(t, j2), P(i18));
                    break;
                case 28:
                    i2 = om2.R(i20, (List) ln2.t(t, j2));
                    break;
                case 29:
                    i2 = om2.H(i20, (List) ln2.t(t, j2), false);
                    break;
                case 30:
                    i2 = om2.D(i20, (List) ln2.t(t, j2), false);
                    break;
                case 31:
                    i2 = om2.L(i20, (List) ln2.t(t, j2));
                    break;
                case 32:
                    i2 = om2.N(i20, (List) ln2.t(t, j2));
                    break;
                case 33:
                    i2 = om2.J(i20, (List) ln2.t(t, j2), false);
                    break;
                case 34:
                    i2 = om2.B(i20, (List) ln2.t(t, j2), false);
                    break;
                case 35:
                    i16 = om2.M((List) unsafe.getObject(t, j2));
                    if (i16 > 0) {
                        i15 = n93.B(i20);
                        i14 = n93.b(i16);
                        i10 = i14 + i15 + i16;
                        i17 += i10;
                    } else {
                        continue;
                    }
                case 36:
                    i16 = om2.K((List) unsafe.getObject(t, j2));
                    if (i16 > 0) {
                        i15 = n93.B(i20);
                        i14 = n93.b(i16);
                        i10 = i14 + i15 + i16;
                        i17 += i10;
                    } else {
                        continue;
                    }
                case 37:
                    i16 = om2.w((List) unsafe.getObject(t, j2));
                    if (i16 > 0) {
                        i15 = n93.B(i20);
                        i14 = n93.b(i16);
                        i10 = i14 + i15 + i16;
                        i17 += i10;
                    } else {
                        continue;
                    }
                case 38:
                    i16 = om2.y((List) unsafe.getObject(t, j2));
                    if (i16 > 0) {
                        i15 = n93.B(i20);
                        i14 = n93.b(i16);
                        i10 = i14 + i15 + i16;
                        i17 += i10;
                    } else {
                        continue;
                    }
                case 39:
                    i16 = om2.E((List) unsafe.getObject(t, j2));
                    if (i16 > 0) {
                        i15 = n93.B(i20);
                        i14 = n93.b(i16);
                        i10 = i14 + i15 + i16;
                        i17 += i10;
                    } else {
                        continue;
                    }
                case 40:
                    i16 = om2.M((List) unsafe.getObject(t, j2));
                    if (i16 > 0) {
                        i15 = n93.B(i20);
                        i14 = n93.b(i16);
                        i10 = i14 + i15 + i16;
                        i17 += i10;
                    } else {
                        continue;
                    }
                case 41:
                    i16 = om2.K((List) unsafe.getObject(t, j2));
                    if (i16 > 0) {
                        i15 = n93.B(i20);
                        i14 = n93.b(i16);
                        i10 = i14 + i15 + i16;
                        i17 += i10;
                    } else {
                        continue;
                    }
                case 42:
                    Class<?> cls2 = om2.f2710a;
                    i16 = ((List) unsafe.getObject(t, j2)).size();
                    if (i16 > 0) {
                        i15 = n93.B(i20);
                        i14 = n93.b(i16);
                        i10 = i14 + i15 + i16;
                        i17 += i10;
                    } else {
                        continue;
                    }
                case 43:
                    i16 = om2.G((List) unsafe.getObject(t, j2));
                    if (i16 > 0) {
                        i15 = n93.B(i20);
                        i14 = n93.b(i16);
                        i10 = i14 + i15 + i16;
                        i17 += i10;
                    } else {
                        continue;
                    }
                case 44:
                    i16 = om2.C((List) unsafe.getObject(t, j2));
                    if (i16 > 0) {
                        i15 = n93.B(i20);
                        i14 = n93.b(i16);
                        i10 = i14 + i15 + i16;
                        i17 += i10;
                    } else {
                        continue;
                    }
                case 45:
                    i16 = om2.K((List) unsafe.getObject(t, j2));
                    if (i16 > 0) {
                        i15 = n93.B(i20);
                        i14 = n93.b(i16);
                        i10 = i14 + i15 + i16;
                        i17 += i10;
                    } else {
                        continue;
                    }
                case 46:
                    i16 = om2.M((List) unsafe.getObject(t, j2));
                    if (i16 > 0) {
                        i15 = n93.B(i20);
                        i14 = n93.b(i16);
                        i10 = i14 + i15 + i16;
                        i17 += i10;
                    } else {
                        continue;
                    }
                case 47:
                    i16 = om2.I((List) unsafe.getObject(t, j2));
                    if (i16 > 0) {
                        i15 = n93.B(i20);
                        i14 = n93.b(i16);
                        i10 = i14 + i15 + i16;
                        i17 += i10;
                    } else {
                        continue;
                    }
                case 48:
                    i16 = om2.A((List) unsafe.getObject(t, j2));
                    if (i16 > 0) {
                        i15 = n93.B(i20);
                        i14 = n93.b(i16);
                        i10 = i14 + i15 + i16;
                        i17 += i10;
                    } else {
                        continue;
                    }
                case 49:
                    i2 = om2.S(i20, (List) ln2.t(t, j2), P(i18));
                    break;
                case 50:
                    xl2.a(i20, ln2.t(t, j2), Q(i18));
                    continue;
                case 51:
                    if (x(t, i20, i18)) {
                        i3 = n93.B(i20);
                        i2 = i3 + 8;
                        break;
                    } else {
                        continue;
                    }
                case 52:
                    if (x(t, i20, i18)) {
                        i4 = n93.B(i20);
                        i2 = i4 + 4;
                        break;
                    } else {
                        continue;
                    }
                case 53:
                    if (x(t, i20, i18)) {
                        long r = r(t, j2);
                        i5 = n93.B(i20);
                        i6 = n93.c(r);
                        i2 = i6 + i5;
                        break;
                    } else {
                        continue;
                    }
                case 54:
                    if (x(t, i20, i18)) {
                        long r2 = r(t, j2);
                        i5 = n93.B(i20);
                        i6 = n93.c(r2);
                        i2 = i6 + i5;
                        break;
                    } else {
                        continue;
                    }
                case 55:
                    if (x(t, i20, i18)) {
                        int q2 = q(t, j2);
                        i7 = n93.B(i20);
                        i8 = n93.C(q2);
                        i2 = i8 + i7;
                        break;
                    } else {
                        continue;
                    }
                case 56:
                    if (x(t, i20, i18)) {
                        i3 = n93.B(i20);
                        i2 = i3 + 8;
                        break;
                    } else {
                        continue;
                    }
                case 57:
                    if (x(t, i20, i18)) {
                        i4 = n93.B(i20);
                        i2 = i4 + 4;
                        break;
                    } else {
                        continue;
                    }
                case 58:
                    if (x(t, i20, i18)) {
                        i9 = n93.B(i20);
                        i2 = i9 + 1;
                        break;
                    } else {
                        continue;
                    }
                case 59:
                    if (x(t, i20, i18)) {
                        Object t3 = ln2.t(t, j2);
                        if (!(t3 instanceof g93)) {
                            i7 = n93.B(i20);
                            i8 = n93.d((String) t3);
                            i2 = i8 + i7;
                            break;
                        } else {
                            i12 = n93.B(i20);
                            i13 = ((g93) t3).e();
                            i11 = n93.b(i13);
                            i10 = i11 + i13 + i12;
                            i17 += i10;
                        }
                    } else {
                        continue;
                    }
                case 60:
                    if (x(t, i20, i18)) {
                        i2 = om2.P(i20, ln2.t(t, j2), P(i18));
                        break;
                    } else {
                        continue;
                    }
                case 61:
                    if (x(t, i20, i18)) {
                        i12 = n93.B(i20);
                        i13 = ((g93) ln2.t(t, j2)).e();
                        i11 = n93.b(i13);
                        i10 = i11 + i13 + i12;
                        i17 += i10;
                    } else {
                        continue;
                    }
                case 62:
                    if (x(t, i20, i18)) {
                        int q3 = q(t, j2);
                        i7 = n93.B(i20);
                        i8 = n93.b(q3);
                        i2 = i8 + i7;
                        break;
                    } else {
                        continue;
                    }
                case 63:
                    if (x(t, i20, i18)) {
                        int q4 = q(t, j2);
                        i7 = n93.B(i20);
                        i8 = n93.C(q4);
                        i2 = i8 + i7;
                        break;
                    } else {
                        continue;
                    }
                case 64:
                    if (x(t, i20, i18)) {
                        i4 = n93.B(i20);
                        i2 = i4 + 4;
                        break;
                    } else {
                        continue;
                    }
                case 65:
                    if (x(t, i20, i18)) {
                        i3 = n93.B(i20);
                        i2 = i3 + 8;
                        break;
                    } else {
                        continue;
                    }
                case 66:
                    if (x(t, i20, i18)) {
                        int q5 = q(t, j2);
                        i7 = n93.B(i20);
                        i8 = n93.b(n93.g(q5));
                        i2 = i8 + i7;
                        break;
                    } else {
                        continue;
                    }
                case 67:
                    if (x(t, i20, i18)) {
                        long r3 = r(t, j2);
                        i5 = n93.B(i20);
                        i6 = n93.c(n93.h(r3));
                        i2 = i6 + i5;
                        break;
                    } else {
                        continue;
                    }
                case 68:
                    if (x(t, i20, i18)) {
                        i2 = n93.j(i20, (bm2) ln2.t(t, j2), P(i18));
                        break;
                    } else {
                        continue;
                    }
                default:
            }
            i17 += i2;
        }
        zm2<?, ?> zm2 = this.m;
        return zm2.q(zm2.j(t)) + i17;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:57)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:15)
        */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x0451 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01cd  */
    public final int M(T r16, byte[] r17, int r18, int r19, int r20, int r21, int r22, int r23, long r24, int r26, long r27, defpackage.v83 r29) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 1174
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.dm2.M(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, v83):int");
    }

    /* JADX WARN: Incorrect args count in method signature: <K:Ljava/lang/Object;V:Ljava/lang/Object;>(TT;[BIIIJLv83;)I */
    public final int N(Object obj, byte[] bArr, int i2, int i3, int i4, long j2) throws IOException {
        Unsafe unsafe = q;
        Object Q = Q(i4);
        Object object = unsafe.getObject(obj, j2);
        if (!((wl2) object).f) {
            wl2 b2 = wl2.g.b();
            xl2.c(b2, object);
            unsafe.putObject(obj, j2, b2);
        }
        vl2 vl2 = (vl2) Q;
        throw null;
    }

    public final int O(T t, byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j2, int i9, v83 v83) throws IOException {
        Unsafe unsafe = q;
        long j3 = (long) (this.f857a[i9 + 2] & 1048575);
        switch (i8) {
            case 51:
                if (i6 == 1) {
                    unsafe.putObject(t, j2, Double.valueOf(Double.longBitsToDouble(gj1.U1(bArr, i2))));
                    unsafe.putInt(t, j3, i5);
                    return i2 + 8;
                }
                break;
            case 52:
                if (i6 == 5) {
                    unsafe.putObject(t, j2, Float.valueOf(Float.intBitsToFloat(gj1.L1(bArr, i2))));
                    unsafe.putInt(t, j3, i5);
                    return i2 + 4;
                }
                break;
            case 53:
            case 54:
                if (i6 == 0) {
                    int D1 = gj1.D1(bArr, i2, v83);
                    unsafe.putObject(t, j2, Long.valueOf(v83.b));
                    unsafe.putInt(t, j3, i5);
                    return D1;
                }
                break;
            case 55:
            case 62:
                if (i6 == 0) {
                    int N0 = gj1.N0(bArr, i2, v83);
                    unsafe.putObject(t, j2, Integer.valueOf(v83.f3616a));
                    unsafe.putInt(t, j3, i5);
                    return N0;
                }
                break;
            case 56:
            case 65:
                if (i6 == 1) {
                    unsafe.putObject(t, j2, Long.valueOf(gj1.U1(bArr, i2)));
                    unsafe.putInt(t, j3, i5);
                    return i2 + 8;
                }
                break;
            case 57:
            case 64:
                if (i6 == 5) {
                    unsafe.putObject(t, j2, Integer.valueOf(gj1.L1(bArr, i2)));
                    unsafe.putInt(t, j3, i5);
                    return i2 + 4;
                }
                break;
            case 58:
                if (i6 == 0) {
                    int D12 = gj1.D1(bArr, i2, v83);
                    unsafe.putObject(t, j2, Boolean.valueOf(v83.b != 0));
                    unsafe.putInt(t, j3, i5);
                    return D12;
                }
                break;
            case 59:
                if (i6 == 2) {
                    int N02 = gj1.N0(bArr, i2, v83);
                    int i10 = v83.f3616a;
                    if (i10 == 0) {
                        unsafe.putObject(t, j2, "");
                    } else if ((i7 & 536870912) == 0 || qn2.a(bArr, N02, N02 + i10)) {
                        unsafe.putObject(t, j2, new String(bArr, N02, i10, ka3.f2038a));
                        N02 += i10;
                    } else {
                        throw ma3.g();
                    }
                    unsafe.putInt(t, j3, i5);
                    return N02;
                }
                break;
            case 60:
                if (i6 == 2) {
                    int e2 = gj1.e2(P(i9), bArr, i2, i3, v83);
                    Object object = unsafe.getInt(t, j3) == i5 ? unsafe.getObject(t, j2) : null;
                    if (object == null) {
                        unsafe.putObject(t, j2, v83.c);
                    } else {
                        unsafe.putObject(t, j2, ka3.c(object, v83.c));
                    }
                    unsafe.putInt(t, j3, i5);
                    return e2;
                }
                break;
            case 61:
                if (i6 == 2) {
                    int d2 = gj1.d2(bArr, i2, v83);
                    unsafe.putObject(t, j2, v83.c);
                    unsafe.putInt(t, j3, i5);
                    return d2;
                }
                break;
            case 63:
                if (i6 == 0) {
                    int N03 = gj1.N0(bArr, i2, v83);
                    int i11 = v83.f3616a;
                    ia3 R = R(i9);
                    if (R == null || R.zza()) {
                        unsafe.putObject(t, j2, Integer.valueOf(i11));
                        unsafe.putInt(t, j3, i5);
                    } else {
                        D(t).c(i4, Long.valueOf((long) i11));
                    }
                    return N03;
                }
                break;
            case 66:
                if (i6 == 0) {
                    int N04 = gj1.N0(bArr, i2, v83);
                    unsafe.putObject(t, j2, Integer.valueOf(h93.n(v83.f3616a)));
                    unsafe.putInt(t, j3, i5);
                    return N04;
                }
                break;
            case 67:
                if (i6 == 0) {
                    int D13 = gj1.D1(bArr, i2, v83);
                    unsafe.putObject(t, j2, Long.valueOf(h93.o(v83.b)));
                    unsafe.putInt(t, j3, i5);
                    return D13;
                }
                break;
            case 68:
                if (i6 == 3) {
                    int f2 = gj1.f2(P(i9), bArr, i2, i3, (i4 & -8) | 4, v83);
                    Object object2 = unsafe.getInt(t, j3) == i5 ? unsafe.getObject(t, j2) : null;
                    if (object2 == null) {
                        unsafe.putObject(t, j2, v83.c);
                    } else {
                        unsafe.putObject(t, j2, ka3.c(object2, v83.c));
                    }
                    unsafe.putInt(t, j3, i5);
                    return f2;
                }
                break;
        }
        return i2;
    }

    public final mm2 P(int i2) {
        int i3 = i2 / 3;
        int i4 = i3 + i3;
        Object[] objArr = this.b;
        mm2 mm2 = (mm2) objArr[i4];
        if (mm2 != null) {
            return mm2;
        }
        mm2<T> a2 = im2.c.a((Class) objArr[i4 + 1]);
        this.b[i4] = a2;
        return a2;
    }

    public final Object Q(int i2) {
        int i3 = i2 / 3;
        return this.b[i3 + i3];
    }

    public final ia3 R(int i2) {
        int i3 = i2 / 3;
        return (ia3) this.b[i3 + i3 + 1];
    }

    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0270, code lost:
        if (r0 != r10) goto L_0x02b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x02af, code lost:
        if (r0 != r10) goto L_0x02b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x02b1, code lost:
        r4 = r4;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int S(T r33, byte[] r34, int r35, int r36, defpackage.v83 r37) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 784
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.dm2.S(java.lang.Object, byte[], int, int, v83):int");
    }

    @Override // defpackage.mm2
    public final int a(T t) {
        int i2;
        int i3;
        int length = this.f857a.length;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5 += 3) {
            int l2 = l(i5);
            int i6 = this.f857a[i5];
            long j2 = (long) (1048575 & l2);
            int i7 = 37;
            switch ((l2 >>> 20) & Constants.MAX_HOST_LENGTH) {
                case 0:
                    i3 = i4 * 53;
                    i2 = ka3.a(Double.doubleToLongBits(ln2.r(t, j2)));
                    i4 = i2 + i3;
                    break;
                case 1:
                    i3 = i4 * 53;
                    i2 = Float.floatToIntBits(ln2.p(t, j2));
                    i4 = i2 + i3;
                    break;
                case 2:
                    i3 = i4 * 53;
                    i2 = ka3.a(ln2.l(t, j2));
                    i4 = i2 + i3;
                    break;
                case 3:
                    i3 = i4 * 53;
                    i2 = ka3.a(ln2.l(t, j2));
                    i4 = i2 + i3;
                    break;
                case 4:
                    i3 = i4 * 53;
                    i2 = ln2.j(t, j2);
                    i4 = i2 + i3;
                    break;
                case 5:
                    i3 = i4 * 53;
                    i2 = ka3.a(ln2.l(t, j2));
                    i4 = i2 + i3;
                    break;
                case 6:
                    i3 = i4 * 53;
                    i2 = ln2.j(t, j2);
                    i4 = i2 + i3;
                    break;
                case 7:
                    i3 = i4 * 53;
                    i2 = ka3.b(ln2.n(t, j2));
                    i4 = i2 + i3;
                    break;
                case 8:
                    i3 = i4 * 53;
                    i2 = ((String) ln2.t(t, j2)).hashCode();
                    i4 = i2 + i3;
                    break;
                case 9:
                    Object t2 = ln2.t(t, j2);
                    if (t2 != null) {
                        i7 = t2.hashCode();
                    }
                    i4 = (i4 * 53) + i7;
                    break;
                case 10:
                    i3 = i4 * 53;
                    i2 = ln2.t(t, j2).hashCode();
                    i4 = i2 + i3;
                    break;
                case 11:
                    i3 = i4 * 53;
                    i2 = ln2.j(t, j2);
                    i4 = i2 + i3;
                    break;
                case 12:
                    i3 = i4 * 53;
                    i2 = ln2.j(t, j2);
                    i4 = i2 + i3;
                    break;
                case 13:
                    i3 = i4 * 53;
                    i2 = ln2.j(t, j2);
                    i4 = i2 + i3;
                    break;
                case 14:
                    i3 = i4 * 53;
                    i2 = ka3.a(ln2.l(t, j2));
                    i4 = i2 + i3;
                    break;
                case 15:
                    i3 = i4 * 53;
                    i2 = ln2.j(t, j2);
                    i4 = i2 + i3;
                    break;
                case 16:
                    i3 = i4 * 53;
                    i2 = ka3.a(ln2.l(t, j2));
                    i4 = i2 + i3;
                    break;
                case 17:
                    Object t3 = ln2.t(t, j2);
                    if (t3 != null) {
                        i7 = t3.hashCode();
                    }
                    i4 = (i4 * 53) + i7;
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
                    i3 = i4 * 53;
                    i2 = ln2.t(t, j2).hashCode();
                    i4 = i2 + i3;
                    break;
                case 50:
                    i3 = i4 * 53;
                    i2 = ln2.t(t, j2).hashCode();
                    i4 = i2 + i3;
                    break;
                case 51:
                    if (x(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = ka3.a(Double.doubleToLongBits(o(t, j2)));
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (x(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = Float.floatToIntBits(p(t, j2));
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (x(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = ka3.a(r(t, j2));
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (x(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = ka3.a(r(t, j2));
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (x(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = q(t, j2);
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (x(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = ka3.a(r(t, j2));
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (x(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = q(t, j2);
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (x(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = ka3.b(s(t, j2));
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (x(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = ((String) ln2.t(t, j2)).hashCode();
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (x(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = ln2.t(t, j2).hashCode();
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (x(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = ln2.t(t, j2).hashCode();
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (x(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = q(t, j2);
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (x(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = q(t, j2);
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (x(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = q(t, j2);
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (x(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = ka3.a(r(t, j2));
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (x(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = q(t, j2);
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (x(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = ka3.a(r(t, j2));
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (x(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = ln2.t(t, j2).hashCode();
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = this.m.j(t).hashCode() + (i4 * 53);
        if (!this.f) {
            return hashCode;
        }
        this.n.b(t);
        throw null;
    }

    @Override // defpackage.mm2
    public final boolean b(T t, T t2) {
        boolean z;
        int length = this.f857a.length;
        for (int i2 = 0; i2 < length; i2 += 3) {
            int l2 = l(i2);
            long j2 = (long) (l2 & 1048575);
            switch ((l2 >>> 20) & Constants.MAX_HOST_LENGTH) {
                case 0:
                    if (t(t, t2, i2) && Double.doubleToLongBits(ln2.r(t, j2)) == Double.doubleToLongBits(ln2.r(t2, j2))) {
                        continue;
                    }
                    return false;
                case 1:
                    if (t(t, t2, i2) && Float.floatToIntBits(ln2.p(t, j2)) == Float.floatToIntBits(ln2.p(t2, j2))) {
                        continue;
                    }
                    return false;
                case 2:
                    if (t(t, t2, i2) && ln2.l(t, j2) == ln2.l(t2, j2)) {
                        continue;
                    }
                    return false;
                case 3:
                    if (t(t, t2, i2) && ln2.l(t, j2) == ln2.l(t2, j2)) {
                        continue;
                    }
                    return false;
                case 4:
                    if (t(t, t2, i2) && ln2.j(t, j2) == ln2.j(t2, j2)) {
                        continue;
                    }
                    return false;
                case 5:
                    if (t(t, t2, i2) && ln2.l(t, j2) == ln2.l(t2, j2)) {
                        continue;
                    }
                    return false;
                case 6:
                    if (t(t, t2, i2) && ln2.j(t, j2) == ln2.j(t2, j2)) {
                        continue;
                    }
                    return false;
                case 7:
                    if (t(t, t2, i2) && ln2.n(t, j2) == ln2.n(t2, j2)) {
                        continue;
                    }
                    return false;
                case 8:
                    if (t(t, t2, i2) && om2.a(ln2.t(t, j2), ln2.t(t2, j2))) {
                        continue;
                    }
                    return false;
                case 9:
                    if (t(t, t2, i2) && om2.a(ln2.t(t, j2), ln2.t(t2, j2))) {
                        continue;
                    }
                    return false;
                case 10:
                    if (t(t, t2, i2) && om2.a(ln2.t(t, j2), ln2.t(t2, j2))) {
                        continue;
                    }
                    return false;
                case 11:
                    if (t(t, t2, i2) && ln2.j(t, j2) == ln2.j(t2, j2)) {
                        continue;
                    }
                    return false;
                case 12:
                    if (t(t, t2, i2) && ln2.j(t, j2) == ln2.j(t2, j2)) {
                        continue;
                    }
                    return false;
                case 13:
                    if (t(t, t2, i2) && ln2.j(t, j2) == ln2.j(t2, j2)) {
                        continue;
                    }
                    return false;
                case 14:
                    if (t(t, t2, i2) && ln2.l(t, j2) == ln2.l(t2, j2)) {
                        continue;
                    }
                    return false;
                case 15:
                    if (t(t, t2, i2) && ln2.j(t, j2) == ln2.j(t2, j2)) {
                        continue;
                    }
                    return false;
                case 16:
                    if (t(t, t2, i2) && ln2.l(t, j2) == ln2.l(t2, j2)) {
                        continue;
                    }
                    return false;
                case 17:
                    if (t(t, t2, i2) && om2.a(ln2.t(t, j2), ln2.t(t2, j2))) {
                        continue;
                    }
                    return false;
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
                    z = om2.a(ln2.t(t, j2), ln2.t(t2, j2));
                    break;
                case 50:
                    z = om2.a(ln2.t(t, j2), ln2.t(t2, j2));
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
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long m2 = (long) (m(i2) & 1048575);
                    if (ln2.j(t, m2) == ln2.j(t2, m2) && om2.a(ln2.t(t, j2), ln2.t(t2, j2))) {
                        continue;
                    }
                    return false;
                default:
            }
            if (!z) {
                return false;
            }
        }
        if (!this.m.j(t).equals(this.m.j(t2))) {
            return false;
        }
        if (!this.f) {
            return true;
        }
        this.n.b(t);
        this.n.b(t2);
        throw null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: mm2 */
    /* JADX DEBUG: Multi-variable search result rejected for r1v11, resolved type: mm2 */
    /* JADX DEBUG: Multi-variable search result rejected for r0v18, resolved type: mm2 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.mm2
    public final boolean c(T t) {
        int i2;
        int i3;
        int i4 = 1048575;
        int i5 = 0;
        int i6 = 0;
        while (i6 < this.j) {
            int i7 = this.i[i6];
            int i8 = this.f857a[i7];
            int l2 = l(i7);
            int i9 = this.f857a[i7 + 2];
            int i10 = i9 & 1048575;
            int i11 = 1 << (i9 >>> 20);
            if (i10 != i4) {
                if (i10 != 1048575) {
                    i5 = q.getInt(t, (long) i10);
                }
                i2 = i5;
                i3 = i10;
            } else {
                i3 = i4;
                i2 = i5;
            }
            if (!((268435456 & l2) == 0 || u(t, i7, i3, i2, i11))) {
                return false;
            }
            int i12 = (l2 >>> 20) & Constants.MAX_HOST_LENGTH;
            if (i12 != 9 && i12 != 17) {
                if (i12 != 27) {
                    if (i12 == 60 || i12 == 68) {
                        if (x(t, i8, i7) && !P(i7).c(ln2.t(t, (long) (l2 & 1048575)))) {
                            return false;
                        }
                    } else if (i12 != 49) {
                        if (i12 == 50 && !((wl2) ln2.t(t, (long) (l2 & 1048575))).isEmpty()) {
                            vl2 vl2 = (vl2) Q(i7);
                            throw null;
                        }
                    }
                }
                List list = (List) ln2.t(t, (long) (l2 & 1048575));
                if (!list.isEmpty()) {
                    mm2 P = P(i7);
                    for (int i13 = 0; i13 < list.size(); i13++) {
                        if (!P.c(list.get(i13))) {
                            return false;
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            } else if (u(t, i7, i3, i2, i11) && !P(i7).c(ln2.t(t, (long) (l2 & 1048575)))) {
                return false;
            }
            i6++;
            i4 = i3;
            i5 = i2;
        }
        if (!this.f) {
            return true;
        }
        this.n.b(t);
        throw null;
    }

    @Override // defpackage.mm2
    public final void d(T t) {
        int i2;
        int i3 = this.j;
        while (true) {
            i2 = this.k;
            if (i3 >= i2) {
                break;
            }
            long l2 = (long) (l(this.i[i3]) & 1048575);
            Object t2 = ln2.t(t, l2);
            if (t2 != null) {
                ((wl2) t2).f = false;
                ln2.e.o(t, l2, t2);
            }
            i3++;
        }
        int length = this.i.length;
        while (i2 < length) {
            this.l.b(t, (long) this.i[i2]);
            i2++;
        }
        this.m.m(t);
        if (this.f) {
            this.n.d(t);
        }
    }

    /* JADX WARN: Incorrect args count in method signature: <UT:Ljava/lang/Object;UB:Ljava/lang/Object;>(Ljava/lang/Object;ITUB;Lzm2<TUT;TUB;>;)TUB; */
    public final Object e(Object obj, int i2, Object obj2) {
        int[] iArr = this.f857a;
        int i3 = iArr[i2];
        Object t = ln2.t(obj, (long) (iArr[i2 + 1] & 1048575));
        if (t == null || R(i2) == null) {
            return obj2;
        }
        wl2 wl2 = (wl2) t;
        vl2 vl2 = (vl2) Q(i2);
        throw null;
    }

    @Override // defpackage.mm2
    public final int f(T t) {
        return this.h ? L(t) : K(t);
    }

    @Override // defpackage.mm2
    public final void g(T t, byte[] bArr, int i2, int i3, v83 v83) throws IOException {
        if (this.h) {
            S(t, bArr, i2, i3, v83);
        } else {
            E(t, bArr, i2, i3, 0, v83);
        }
    }

    @Override // defpackage.mm2
    public final void h(T t, T t2) {
        Objects.requireNonNull(t2);
        for (int i2 = 0; i2 < this.f857a.length; i2 += 3) {
            int l2 = l(i2);
            long j2 = (long) (1048575 & l2);
            int i3 = this.f857a[i2];
            switch ((l2 >>> 20) & Constants.MAX_HOST_LENGTH) {
                case 0:
                    if (v(t2, i2)) {
                        ln2.s(t, j2, ln2.r(t2, j2));
                        w(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (v(t2, i2)) {
                        ln2.e.f(t, j2, ln2.p(t2, j2));
                        w(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (v(t2, i2)) {
                        ln2.m(t, j2, ln2.l(t2, j2));
                        w(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (v(t2, i2)) {
                        ln2.m(t, j2, ln2.l(t2, j2));
                        w(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (v(t2, i2)) {
                        ln2.e.k(t, j2, ln2.j(t2, j2));
                        w(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (v(t2, i2)) {
                        ln2.m(t, j2, ln2.l(t2, j2));
                        w(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (v(t2, i2)) {
                        ln2.e.k(t, j2, ln2.j(t2, j2));
                        w(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (v(t2, i2)) {
                        ln2.e.d(t, j2, ln2.n(t2, j2));
                        w(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (v(t2, i2)) {
                        ln2.e.o(t, j2, ln2.t(t2, j2));
                        w(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    I(t, t2, i2);
                    break;
                case 10:
                    if (v(t2, i2)) {
                        ln2.e.o(t, j2, ln2.t(t2, j2));
                        w(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (v(t2, i2)) {
                        ln2.e.k(t, j2, ln2.j(t2, j2));
                        w(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (v(t2, i2)) {
                        ln2.e.k(t, j2, ln2.j(t2, j2));
                        w(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (v(t2, i2)) {
                        ln2.e.k(t, j2, ln2.j(t2, j2));
                        w(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (v(t2, i2)) {
                        ln2.m(t, j2, ln2.l(t2, j2));
                        w(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (v(t2, i2)) {
                        ln2.e.k(t, j2, ln2.j(t2, j2));
                        w(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (v(t2, i2)) {
                        ln2.m(t, j2, ln2.l(t2, j2));
                        w(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    I(t, t2, i2);
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
                    this.l.c(t, t2, j2);
                    break;
                case 50:
                    Class<?> cls = om2.f2710a;
                    ln2.e.o(t, j2, xl2.c(ln2.t(t, j2), ln2.t(t2, j2)));
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
                    if (x(t2, i3, i2)) {
                        ln2.e.o(t, j2, ln2.t(t2, j2));
                        y(t, i3, i2);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    J(t, t2, i2);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (x(t2, i3, i2)) {
                        ln2.e.o(t, j2, ln2.t(t2, j2));
                        y(t, i3, i2);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    J(t, t2, i2);
                    break;
            }
        }
        zm2<?, ?> zm2 = this.m;
        Class<?> cls2 = om2.f2710a;
        zm2.i(t, zm2.o(zm2.j(t), zm2.j(t2)));
        if (this.f) {
            this.n.b(t2);
            throw null;
        }
    }

    @Override // defpackage.mm2
    public final void i(T t, o93 o93) throws IOException {
        if (!this.h) {
            B(t, o93);
        } else if (!this.f) {
            int length = this.f857a.length;
            for (int i2 = 0; i2 < length; i2 += 3) {
                int l2 = l(i2);
                int[] iArr = this.f857a;
                int i3 = iArr[i2];
                switch ((l2 >>> 20) & Constants.MAX_HOST_LENGTH) {
                    case 0:
                        if (v(t, i2)) {
                            o93.b(i3, ln2.r(t, (long) (l2 & 1048575)));
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (v(t, i2)) {
                            o93.a(i3, ln2.p(t, (long) (l2 & 1048575)));
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (v(t, i2)) {
                            o93.f2666a.o(i3, ln2.l(t, (long) (l2 & 1048575)));
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (v(t, i2)) {
                            o93.f2666a.o(i3, ln2.l(t, (long) (l2 & 1048575)));
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (v(t, i2)) {
                            o93.f2666a.l(i3, ln2.j(t, (long) (l2 & 1048575)));
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (v(t, i2)) {
                            o93.f2666a.q(i3, ln2.l(t, (long) (l2 & 1048575)));
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (v(t, i2)) {
                            o93.f2666a.n(i3, ln2.j(t, (long) (l2 & 1048575)));
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (v(t, i2)) {
                            o93.f2666a.r(i3, ln2.n(t, (long) (l2 & 1048575)));
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (v(t, i2)) {
                            C(i3, ln2.t(t, (long) (l2 & 1048575)), o93);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        if (v(t, i2)) {
                            o93.e(i3, ln2.t(t, (long) (l2 & 1048575)), P(i2));
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (v(t, i2)) {
                            o93.f2666a.t(i3, (g93) ln2.t(t, (long) (l2 & 1048575)));
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (v(t, i2)) {
                            o93.f2666a.m(i3, ln2.j(t, (long) (l2 & 1048575)));
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        if (v(t, i2)) {
                            o93.f2666a.l(i3, ln2.j(t, (long) (l2 & 1048575)));
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (v(t, i2)) {
                            o93.f2666a.n(i3, ln2.j(t, (long) (l2 & 1048575)));
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if (v(t, i2)) {
                            o93.f2666a.q(i3, ln2.l(t, (long) (l2 & 1048575)));
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if (v(t, i2)) {
                            o93.c(i3, ln2.j(t, (long) (l2 & 1048575)));
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (v(t, i2)) {
                            o93.d(i3, ln2.l(t, (long) (l2 & 1048575)));
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        if (v(t, i2)) {
                            o93.f(i3, ln2.t(t, (long) (l2 & 1048575)), P(i2));
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        om2.d(iArr[i2], (List) ln2.t(t, (long) (l2 & 1048575)), o93, false);
                        break;
                    case 19:
                        om2.e(iArr[i2], (List) ln2.t(t, (long) (l2 & 1048575)), o93, false);
                        break;
                    case 20:
                        om2.f(iArr[i2], (List) ln2.t(t, (long) (l2 & 1048575)), o93, false);
                        break;
                    case 21:
                        om2.g(iArr[i2], (List) ln2.t(t, (long) (l2 & 1048575)), o93, false);
                        break;
                    case 22:
                        om2.k(iArr[i2], (List) ln2.t(t, (long) (l2 & 1048575)), o93, false);
                        break;
                    case 23:
                        om2.i(iArr[i2], (List) ln2.t(t, (long) (l2 & 1048575)), o93, false);
                        break;
                    case 24:
                        om2.n(iArr[i2], (List) ln2.t(t, (long) (l2 & 1048575)), o93, false);
                        break;
                    case 25:
                        om2.q(iArr[i2], (List) ln2.t(t, (long) (l2 & 1048575)), o93, false);
                        break;
                    case 26:
                        om2.r(iArr[i2], (List) ln2.t(t, (long) (l2 & 1048575)), o93);
                        break;
                    case 27:
                        om2.t(iArr[i2], (List) ln2.t(t, (long) (l2 & 1048575)), o93, P(i2));
                        break;
                    case 28:
                        om2.s(iArr[i2], (List) ln2.t(t, (long) (l2 & 1048575)), o93);
                        break;
                    case 29:
                        om2.l(iArr[i2], (List) ln2.t(t, (long) (l2 & 1048575)), o93, false);
                        break;
                    case 30:
                        om2.p(iArr[i2], (List) ln2.t(t, (long) (l2 & 1048575)), o93, false);
                        break;
                    case 31:
                        om2.o(iArr[i2], (List) ln2.t(t, (long) (l2 & 1048575)), o93, false);
                        break;
                    case 32:
                        om2.j(iArr[i2], (List) ln2.t(t, (long) (l2 & 1048575)), o93, false);
                        break;
                    case 33:
                        om2.m(iArr[i2], (List) ln2.t(t, (long) (l2 & 1048575)), o93, false);
                        break;
                    case 34:
                        om2.h(iArr[i2], (List) ln2.t(t, (long) (l2 & 1048575)), o93, false);
                        break;
                    case 35:
                        om2.d(iArr[i2], (List) ln2.t(t, (long) (l2 & 1048575)), o93, true);
                        break;
                    case 36:
                        om2.e(iArr[i2], (List) ln2.t(t, (long) (l2 & 1048575)), o93, true);
                        break;
                    case 37:
                        om2.f(iArr[i2], (List) ln2.t(t, (long) (l2 & 1048575)), o93, true);
                        break;
                    case 38:
                        om2.g(iArr[i2], (List) ln2.t(t, (long) (l2 & 1048575)), o93, true);
                        break;
                    case 39:
                        om2.k(iArr[i2], (List) ln2.t(t, (long) (l2 & 1048575)), o93, true);
                        break;
                    case 40:
                        om2.i(iArr[i2], (List) ln2.t(t, (long) (l2 & 1048575)), o93, true);
                        break;
                    case 41:
                        om2.n(iArr[i2], (List) ln2.t(t, (long) (l2 & 1048575)), o93, true);
                        break;
                    case 42:
                        om2.q(iArr[i2], (List) ln2.t(t, (long) (l2 & 1048575)), o93, true);
                        break;
                    case 43:
                        om2.l(iArr[i2], (List) ln2.t(t, (long) (l2 & 1048575)), o93, true);
                        break;
                    case 44:
                        om2.p(iArr[i2], (List) ln2.t(t, (long) (l2 & 1048575)), o93, true);
                        break;
                    case 45:
                        om2.o(iArr[i2], (List) ln2.t(t, (long) (l2 & 1048575)), o93, true);
                        break;
                    case 46:
                        om2.j(iArr[i2], (List) ln2.t(t, (long) (l2 & 1048575)), o93, true);
                        break;
                    case 47:
                        om2.m(iArr[i2], (List) ln2.t(t, (long) (l2 & 1048575)), o93, true);
                        break;
                    case 48:
                        om2.h(iArr[i2], (List) ln2.t(t, (long) (l2 & 1048575)), o93, true);
                        break;
                    case 49:
                        om2.u(iArr[i2], (List) ln2.t(t, (long) (l2 & 1048575)), o93, P(i2));
                        break;
                    case 50:
                        if (ln2.t(t, (long) (l2 & 1048575)) == null) {
                            break;
                        } else {
                            vl2 vl2 = (vl2) Q(i2);
                            throw null;
                        }
                    case 51:
                        if (x(t, i3, i2)) {
                            o93.b(i3, o(t, (long) (l2 & 1048575)));
                            break;
                        } else {
                            break;
                        }
                    case 52:
                        if (x(t, i3, i2)) {
                            o93.a(i3, p(t, (long) (l2 & 1048575)));
                            break;
                        } else {
                            break;
                        }
                    case 53:
                        if (x(t, i3, i2)) {
                            o93.f2666a.o(i3, r(t, (long) (l2 & 1048575)));
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        if (x(t, i3, i2)) {
                            o93.f2666a.o(i3, r(t, (long) (l2 & 1048575)));
                            break;
                        } else {
                            break;
                        }
                    case 55:
                        if (x(t, i3, i2)) {
                            o93.f2666a.l(i3, q(t, (long) (l2 & 1048575)));
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (x(t, i3, i2)) {
                            o93.f2666a.q(i3, r(t, (long) (l2 & 1048575)));
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (x(t, i3, i2)) {
                            o93.f2666a.n(i3, q(t, (long) (l2 & 1048575)));
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (x(t, i3, i2)) {
                            o93.f2666a.r(i3, s(t, (long) (l2 & 1048575)));
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (x(t, i3, i2)) {
                            C(i3, ln2.t(t, (long) (l2 & 1048575)), o93);
                            break;
                        } else {
                            break;
                        }
                    case 60:
                        if (x(t, i3, i2)) {
                            o93.e(i3, ln2.t(t, (long) (l2 & 1048575)), P(i2));
                            break;
                        } else {
                            break;
                        }
                    case 61:
                        if (x(t, i3, i2)) {
                            o93.f2666a.t(i3, (g93) ln2.t(t, (long) (l2 & 1048575)));
                            break;
                        } else {
                            break;
                        }
                    case 62:
                        if (x(t, i3, i2)) {
                            o93.f2666a.m(i3, q(t, (long) (l2 & 1048575)));
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (x(t, i3, i2)) {
                            o93.f2666a.l(i3, q(t, (long) (l2 & 1048575)));
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (x(t, i3, i2)) {
                            o93.f2666a.n(i3, q(t, (long) (l2 & 1048575)));
                            break;
                        } else {
                            break;
                        }
                    case 65:
                        if (x(t, i3, i2)) {
                            o93.f2666a.q(i3, r(t, (long) (l2 & 1048575)));
                            break;
                        } else {
                            break;
                        }
                    case 66:
                        if (x(t, i3, i2)) {
                            o93.c(i3, q(t, (long) (l2 & 1048575)));
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (x(t, i3, i2)) {
                            o93.d(i3, r(t, (long) (l2 & 1048575)));
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (x(t, i3, i2)) {
                            o93.f(i3, ln2.t(t, (long) (l2 & 1048575)), P(i2));
                            break;
                        } else {
                            break;
                        }
                }
            }
            zm2<?, ?> zm2 = this.m;
            zm2.r(zm2.j(t), o93);
        } else {
            this.n.b(t);
            throw null;
        }
    }

    @Override // defpackage.mm2
    public final void j(T t, i93 i93, s93 s93) throws IOException {
        Objects.requireNonNull(s93);
        zm2<?, ?> zm2 = this.m;
        t93<?> t93 = this.n;
        x93<?> x93 = null;
        Object obj = null;
        while (true) {
            try {
                int v = i93.v();
                int z = z(v);
                if (z >= 0) {
                    int l2 = l(z);
                    switch ((l2 >>> 20) & Constants.MAX_HOST_LENGTH) {
                        case 0:
                            i93.p(1);
                            ln2.s(t, (long) (l2 & 1048575), Double.longBitsToDouble(i93.f1496a.i()));
                            w(t, z);
                            break;
                        case 1:
                            i93.p(5);
                            ln2.q(t, (long) (l2 & 1048575), Float.intBitsToFloat(i93.f1496a.h()));
                            w(t, z);
                            break;
                        case 2:
                            ln2.m(t, (long) (l2 & 1048575), i93.A());
                            w(t, z);
                            break;
                        case 3:
                            i93.p(0);
                            ln2.m(t, (long) (l2 & 1048575), i93.f1496a.f());
                            w(t, z);
                            break;
                        case 4:
                            i93.p(0);
                            ln2.k(t, (long) (l2 & 1048575), i93.f1496a.e());
                            w(t, z);
                            break;
                        case 5:
                            ln2.m(t, (long) (l2 & 1048575), i93.C());
                            w(t, z);
                            break;
                        case 6:
                            ln2.k(t, (long) (l2 & 1048575), i93.D());
                            w(t, z);
                            break;
                        case 7:
                            i93.p(0);
                            ln2.o(t, (long) (l2 & 1048575), i93.f1496a.d());
                            w(t, z);
                            break;
                        case 8:
                            k(t, l2, i93);
                            w(t, z);
                            break;
                        case 9:
                            if (v(t, z)) {
                                long j2 = (long) (l2 & 1048575);
                                ln2.u(t, j2, ka3.c(ln2.t(t, j2), i93.H(P(z), s93)));
                                break;
                            } else {
                                ln2.u(t, (long) (l2 & 1048575), i93.H(P(z), s93));
                                w(t, z);
                                break;
                            }
                        case 10:
                            ln2.u(t, (long) (l2 & 1048575), i93.J());
                            w(t, z);
                            break;
                        case 11:
                            ln2.k(t, (long) (l2 & 1048575), i93.K());
                            w(t, z);
                            break;
                        case 12:
                            i93.p(0);
                            int e2 = i93.f1496a.e();
                            ia3 R = R(z);
                            if (R != null) {
                                if (!R.zza()) {
                                    obj = om2.c(v, e2, obj, zm2);
                                    break;
                                }
                            }
                            ln2.k(t, (long) (l2 & 1048575), e2);
                            w(t, z);
                            break;
                        case 13:
                            ln2.k(t, (long) (l2 & 1048575), i93.M());
                            w(t, z);
                            break;
                        case 14:
                            ln2.m(t, (long) (l2 & 1048575), i93.N());
                            w(t, z);
                            break;
                        case 15:
                            ln2.k(t, (long) (l2 & 1048575), i93.O());
                            w(t, z);
                            break;
                        case 16:
                            ln2.m(t, (long) (l2 & 1048575), i93.P());
                            w(t, z);
                            break;
                        case 17:
                            if (v(t, z)) {
                                long j3 = (long) (l2 & 1048575);
                                ln2.u(t, j3, ka3.c(ln2.t(t, j3), i93.I(P(z), s93)));
                                break;
                            } else {
                                ln2.u(t, (long) (l2 & 1048575), i93.I(P(z), s93));
                                w(t, z);
                                break;
                            }
                        case 18:
                            i93.Q(this.l.a(t, (long) (l2 & 1048575)));
                            break;
                        case 19:
                            i93.R(this.l.a(t, (long) (l2 & 1048575)));
                            break;
                        case 20:
                            i93.a(this.l.a(t, (long) (l2 & 1048575)));
                            break;
                        case 21:
                            i93.S(this.l.a(t, (long) (l2 & 1048575)));
                            break;
                        case 22:
                            i93.b(this.l.a(t, (long) (l2 & 1048575)));
                            break;
                        case 23:
                            i93.c(this.l.a(t, (long) (l2 & 1048575)));
                            break;
                        case 24:
                            i93.d(this.l.a(t, (long) (l2 & 1048575)));
                            break;
                        case 25:
                            i93.e(this.l.a(t, (long) (l2 & 1048575)));
                            break;
                        case 26:
                            if (n(l2)) {
                                i93.f(this.l.a(t, (long) (l2 & 1048575)), true);
                                break;
                            } else {
                                i93.f(this.l.a(t, (long) (l2 & 1048575)), false);
                                break;
                            }
                        case 27:
                            i93.g(this.l.a(t, (long) (l2 & 1048575)), P(z), s93);
                            break;
                        case 28:
                            i93.i(this.l.a(t, (long) (l2 & 1048575)));
                            break;
                        case 29:
                            i93.j(this.l.a(t, (long) (l2 & 1048575)));
                            break;
                        case 30:
                            List<Integer> a2 = this.l.a(t, (long) (l2 & 1048575));
                            i93.k(a2);
                            obj = om2.b(v, a2, R(z), obj, zm2);
                            break;
                        case 31:
                            i93.l(this.l.a(t, (long) (l2 & 1048575)));
                            break;
                        case 32:
                            i93.m(this.l.a(t, (long) (l2 & 1048575)));
                            break;
                        case 33:
                            i93.n(this.l.a(t, (long) (l2 & 1048575)));
                            break;
                        case 34:
                            i93.o(this.l.a(t, (long) (l2 & 1048575)));
                            break;
                        case 35:
                            i93.Q(this.l.a(t, (long) (l2 & 1048575)));
                            break;
                        case 36:
                            i93.R(this.l.a(t, (long) (l2 & 1048575)));
                            break;
                        case 37:
                            i93.a(this.l.a(t, (long) (l2 & 1048575)));
                            break;
                        case 38:
                            i93.S(this.l.a(t, (long) (l2 & 1048575)));
                            break;
                        case 39:
                            i93.b(this.l.a(t, (long) (l2 & 1048575)));
                            break;
                        case 40:
                            i93.c(this.l.a(t, (long) (l2 & 1048575)));
                            break;
                        case 41:
                            i93.d(this.l.a(t, (long) (l2 & 1048575)));
                            break;
                        case 42:
                            i93.e(this.l.a(t, (long) (l2 & 1048575)));
                            break;
                        case 43:
                            i93.j(this.l.a(t, (long) (l2 & 1048575)));
                            break;
                        case 44:
                            List<Integer> a3 = this.l.a(t, (long) (l2 & 1048575));
                            i93.k(a3);
                            obj = om2.b(v, a3, R(z), obj, zm2);
                            break;
                        case 45:
                            i93.l(this.l.a(t, (long) (l2 & 1048575)));
                            break;
                        case 46:
                            i93.m(this.l.a(t, (long) (l2 & 1048575)));
                            break;
                        case 47:
                            i93.n(this.l.a(t, (long) (l2 & 1048575)));
                            break;
                        case 48:
                            i93.o(this.l.a(t, (long) (l2 & 1048575)));
                            break;
                        case 49:
                            i93.h(this.l.a(t, (long) (l2 & 1048575)), P(z), s93);
                            break;
                        case 50:
                            Object Q = Q(z);
                            long l3 = (long) (l(z) & 1048575);
                            Object t2 = ln2.t(t, l3);
                            if (t2 == null) {
                                t2 = wl2.g.b();
                                ln2.u(t, l3, t2);
                            } else if (xl2.b(t2)) {
                                Object b2 = wl2.a().b();
                                xl2.c(b2, t2);
                                ln2.u(t, l3, b2);
                                t2 = b2;
                            }
                            wl2 wl2 = (wl2) t2;
                            vl2 vl2 = (vl2) Q;
                            throw null;
                        case 51:
                            ln2.u(t, (long) (l2 & 1048575), Double.valueOf(i93.x()));
                            y(t, v, z);
                            break;
                        case 52:
                            ln2.u(t, (long) (l2 & 1048575), Float.valueOf(i93.y()));
                            y(t, v, z);
                            break;
                        case 53:
                            ln2.u(t, (long) (l2 & 1048575), Long.valueOf(i93.A()));
                            y(t, v, z);
                            break;
                        case 54:
                            ln2.u(t, (long) (l2 & 1048575), Long.valueOf(i93.z()));
                            y(t, v, z);
                            break;
                        case 55:
                            ln2.u(t, (long) (l2 & 1048575), Integer.valueOf(i93.B()));
                            y(t, v, z);
                            break;
                        case 56:
                            ln2.u(t, (long) (l2 & 1048575), Long.valueOf(i93.C()));
                            y(t, v, z);
                            break;
                        case 57:
                            ln2.u(t, (long) (l2 & 1048575), Integer.valueOf(i93.D()));
                            y(t, v, z);
                            break;
                        case 58:
                            ln2.u(t, (long) (l2 & 1048575), Boolean.valueOf(i93.E()));
                            y(t, v, z);
                            break;
                        case 59:
                            k(t, l2, i93);
                            y(t, v, z);
                            break;
                        case 60:
                            if (x(t, v, z)) {
                                long j4 = (long) (l2 & 1048575);
                                ln2.u(t, j4, ka3.c(ln2.t(t, j4), i93.H(P(z), s93)));
                            } else {
                                ln2.u(t, (long) (l2 & 1048575), i93.H(P(z), s93));
                                w(t, z);
                            }
                            y(t, v, z);
                            break;
                        case 61:
                            ln2.u(t, (long) (l2 & 1048575), i93.J());
                            y(t, v, z);
                            break;
                        case 62:
                            ln2.u(t, (long) (l2 & 1048575), Integer.valueOf(i93.K()));
                            y(t, v, z);
                            break;
                        case 63:
                            int L = i93.L();
                            ia3 R2 = R(z);
                            if (R2 != null) {
                                if (!R2.zza()) {
                                    obj = om2.c(v, L, obj, zm2);
                                    break;
                                }
                            }
                            ln2.u(t, (long) (l2 & 1048575), Integer.valueOf(L));
                            y(t, v, z);
                            break;
                        case 64:
                            ln2.u(t, (long) (l2 & 1048575), Integer.valueOf(i93.M()));
                            y(t, v, z);
                            break;
                        case 65:
                            ln2.u(t, (long) (l2 & 1048575), Long.valueOf(i93.N()));
                            y(t, v, z);
                            break;
                        case 66:
                            ln2.u(t, (long) (l2 & 1048575), Integer.valueOf(i93.O()));
                            y(t, v, z);
                            break;
                        case 67:
                            ln2.u(t, (long) (l2 & 1048575), Long.valueOf(i93.P()));
                            y(t, v, z);
                            break;
                        case 68:
                            ln2.u(t, (long) (l2 & 1048575), i93.I(P(z), s93));
                            y(t, v, z);
                            break;
                        default:
                            if (obj == null) {
                                try {
                                    obj = zm2.g();
                                } catch (la3 unused) {
                                    zm2.a(i93);
                                    if (obj == null) {
                                        obj = zm2.k(t);
                                    }
                                    if (zm2.n(obj, i93)) {
                                        break;
                                    } else {
                                        for (int i2 = this.j; i2 < this.k; i2++) {
                                            e(t, this.i[i2], obj);
                                        }
                                        if (obj != null) {
                                            zm2.l(t, obj);
                                            return;
                                        }
                                        return;
                                    }
                                }
                            }
                            if (zm2.n(obj, i93)) {
                                break;
                            } else {
                                for (int i3 = this.j; i3 < this.k; i3++) {
                                    e(t, this.i[i3], obj);
                                }
                                if (obj != null) {
                                    zm2.l(t, obj);
                                    return;
                                }
                                return;
                            }
                    }
                } else if (v == Integer.MAX_VALUE) {
                    for (int i4 = this.j; i4 < this.k; i4++) {
                        e(t, this.i[i4], obj);
                    }
                    if (obj != null) {
                        zm2.l(t, obj);
                        return;
                    }
                    return;
                } else {
                    Object f2 = !this.f ? null : t93.f(s93, this.e, v);
                    if (f2 != null) {
                        if (x93 == null) {
                            x93 = t93.c(t);
                        }
                        obj = t93.e(i93, f2, s93, x93, obj, zm2);
                        x93 = x93;
                    } else {
                        zm2.a(i93);
                        if (obj == null) {
                            obj = zm2.k(t);
                        }
                        if (!zm2.n(obj, i93)) {
                            for (int i5 = this.j; i5 < this.k; i5++) {
                                e(t, this.i[i5], obj);
                            }
                            if (obj != null) {
                                zm2.l(t, obj);
                                return;
                            }
                            return;
                        }
                    }
                }
            } catch (Throwable th) {
                for (int i6 = this.j; i6 < this.k; i6++) {
                    e(t, this.i[i6], obj);
                }
                if (obj != null) {
                    zm2.l(t, obj);
                }
                throw th;
            }
        }
    }

    public final void k(Object obj, int i2, i93 i93) throws IOException {
        if ((536870912 & i2) != 0) {
            ln2.e.o(obj, (long) (i2 & 1048575), i93.G());
        } else if (this.g) {
            ln2.e.o(obj, (long) (i2 & 1048575), i93.F());
        } else {
            ln2.e.o(obj, (long) (i2 & 1048575), i93.J());
        }
    }

    public final int l(int i2) {
        return this.f857a[i2 + 1];
    }

    public final int m(int i2) {
        return this.f857a[i2 + 2];
    }

    public final boolean t(T t, T t2, int i2) {
        return v(t, i2) == v(t2, i2);
    }

    public final boolean u(T t, int i2, int i3, int i4, int i5) {
        if (i3 == 1048575) {
            return v(t, i2);
        }
        return (i4 & i5) != 0;
    }

    public final boolean v(T t, int i2) {
        int[] iArr = this.f857a;
        int i3 = iArr[i2 + 2];
        long j2 = (long) (i3 & 1048575);
        if (j2 != 1048575) {
            return (ln2.j(t, j2) & (1 << (i3 >>> 20))) != 0;
        }
        int i4 = iArr[i2 + 1];
        long j3 = (long) (i4 & 1048575);
        switch ((i4 >>> 20) & Constants.MAX_HOST_LENGTH) {
            case 0:
                return ln2.r(t, j3) != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            case 1:
                return ln2.p(t, j3) != 0.0f;
            case 2:
                return ln2.l(t, j3) != 0;
            case 3:
                return ln2.l(t, j3) != 0;
            case 4:
                return ln2.j(t, j3) != 0;
            case 5:
                return ln2.l(t, j3) != 0;
            case 6:
                return ln2.j(t, j3) != 0;
            case 7:
                return ln2.n(t, j3);
            case 8:
                Object t2 = ln2.t(t, j3);
                if (t2 instanceof String) {
                    return !((String) t2).isEmpty();
                }
                if (t2 instanceof g93) {
                    return !g93.g.equals(t2);
                }
                throw new IllegalArgumentException();
            case 9:
                return ln2.t(t, j3) != null;
            case 10:
                return !g93.g.equals(ln2.t(t, j3));
            case 11:
                return ln2.j(t, j3) != 0;
            case 12:
                return ln2.j(t, j3) != 0;
            case 13:
                return ln2.j(t, j3) != 0;
            case 14:
                return ln2.l(t, j3) != 0;
            case 15:
                return ln2.j(t, j3) != 0;
            case 16:
                return ln2.l(t, j3) != 0;
            case 17:
                return ln2.t(t, j3) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    public final void w(T t, int i2) {
        int i3 = this.f857a[i2 + 2];
        long j2 = (long) (1048575 & i3);
        if (j2 != 1048575) {
            ln2.e.k(t, j2, (1 << (i3 >>> 20)) | ln2.j(t, j2));
        }
    }

    public final boolean x(T t, int i2, int i3) {
        return ln2.j(t, (long) (this.f857a[i3 + 2] & 1048575)) == i2;
    }

    public final void y(T t, int i2, int i3) {
        ln2.e.k(t, (long) (this.f857a[i3 + 2] & 1048575), i2);
    }

    public final int z(int i2) {
        if (i2 < this.c || i2 > this.d) {
            return -1;
        }
        return A(i2, 0);
    }

    @Override // defpackage.mm2
    public final T zza() {
        return (T) ((ea3) this.e).i(4, null, null);
    }
}
