package defpackage;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import defpackage.a05;
import defpackage.c15;
import defpackage.d05;
import defpackage.s05;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* renamed from: l15  reason: default package */
/* compiled from: MessageSchema */
public final class l15<T> implements x15<T> {
    public static final int[] r = new int[0];
    public static final Unsafe s = i25.q();

    /* renamed from: a  reason: collision with root package name */
    public final int[] f2153a;
    public final Object[] b;
    public final int c;
    public final int d;
    public final j15 e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final int[] j;
    public final int k;
    public final int l;
    public final n15 m;
    public final z05 n;
    public final e25<?, ?> o;
    public final j05<?> p;
    public final e15 q;

    public l15(int[] iArr, Object[] objArr, int i2, int i3, j15 j15, boolean z, boolean z2, int[] iArr2, int i4, int i5, n15 n15, z05 z05, e25<?, ?> e25, j05<?> j05, e15 e15) {
        this.f2153a = iArr;
        this.b = objArr;
        this.c = i2;
        this.d = i3;
        this.g = j15 instanceof q05;
        this.h = z;
        this.f = j05 != null && j05.e(j15);
        this.i = z2;
        this.j = iArr2;
        this.k = i4;
        this.l = i5;
        this.m = n15;
        this.n = z05;
        this.o = e25;
        this.p = j05;
        this.e = j15;
        this.q = e15;
    }

    /* JADX WARN: Incorrect args count in method signature: <T:Ljava/lang/Object;>(Ljava/lang/Class<TT;>;Lh15;Ln15;Lz05;Le25<**>;Lj05<*>;Le15;)Ll15<TT;>; */
    public static l15 B(h15 h15, n15 n15, z05 z05, e25 e25, j05 j05, e15 e15) {
        if (h15 instanceof v15) {
            return C((v15) h15, n15, z05, e25, j05, e15);
        }
        c25 c25 = (c25) h15;
        s15 s15 = s15.PROTO3;
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:126:0x028e  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0291  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x02a8  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x02ab  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x035a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> defpackage.l15<T> C(defpackage.v15 r36, defpackage.n15 r37, defpackage.z05 r38, defpackage.e25<?, ?> r39, defpackage.j05<?> r40, defpackage.e15 r41) {
        /*
        // Method dump skipped, instructions count: 1054
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.l15.C(v15, n15, z05, e25, j05, e15):l15");
    }

    public static long D(int i2) {
        return (long) (i2 & 1048575);
    }

    public static <T> boolean E(T t, long j2) {
        return ((Boolean) i25.p(t, j2)).booleanValue();
    }

    public static <T> double F(T t, long j2) {
        return ((Double) i25.p(t, j2)).doubleValue();
    }

    public static <T> float G(T t, long j2) {
        return ((Float) i25.p(t, j2)).floatValue();
    }

    public static <T> int H(T t, long j2) {
        return ((Integer) i25.p(t, j2)).intValue();
    }

    public static <T> long I(T t, long j2) {
        return ((Long) i25.p(t, j2)).longValue();
    }

    public static Field T(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            StringBuilder l0 = hj1.l0("Field ", str, " for ");
            l0.append(cls.getName());
            l0.append(" not found. Known fields are ");
            l0.append(Arrays.toString(declaredFields));
            throw new RuntimeException(l0.toString());
        }
    }

    public static int X(int i2) {
        return (i2 & 267386880) >>> 20;
    }

    public static f25 q(Object obj) {
        q05 q05 = (q05) obj;
        f25 f25 = q05.unknownFields;
        if (f25 != f25.f) {
            return f25;
        }
        f25 e2 = f25.e();
        q05.unknownFields = e2;
        return e2;
    }

    public static List<?> w(Object obj, long j2) {
        return (List) i25.p(obj, j2);
    }

    public final void A(T t, T t2, int i2) {
        int[] iArr = this.f2153a;
        int i3 = iArr[i2 + 1];
        int i4 = iArr[i2];
        long D = D(i3);
        if (v(t2, i4, i2)) {
            Object p2 = i25.p(t, D);
            Object p3 = i25.p(t2, D);
            if (p2 != null && p3 != null) {
                i25.f.s(t, D, s05.c(p2, p3));
                V(t, i4, i2);
            } else if (p3 != null) {
                i25.f.s(t, D, p3);
                V(t, i4, i2);
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:30:0x0054 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:34:0x0054 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r6v2. Raw type applied. Possible types: ? */
    /* JADX WARN: Type inference failed for: r1v12, types: [int] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <K, V> int J(T r17, byte[] r18, int r19, int r20, int r21, long r22, defpackage.vz4 r24) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 193
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.l15.J(java.lang.Object, byte[], int, int, int, long, vz4):int");
    }

    public final int K(T t, byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j2, int i9, vz4 vz4) throws IOException {
        Unsafe unsafe = s;
        long j3 = (long) (this.f2153a[i9 + 2] & 1048575);
        switch (i8) {
            case 51:
                if (i6 == 1) {
                    unsafe.putObject(t, j2, Double.valueOf(Double.longBitsToDouble(hd3.i0(bArr, i2))));
                    int i10 = i2 + 8;
                    unsafe.putInt(t, j3, i5);
                    return i10;
                }
                break;
            case 52:
                if (i6 == 5) {
                    unsafe.putObject(t, j2, Float.valueOf(Float.intBitsToFloat(hd3.h0(bArr, i2))));
                    int i11 = i2 + 4;
                    unsafe.putInt(t, j3, i5);
                    return i11;
                }
                break;
            case 53:
            case 54:
                if (i6 == 0) {
                    int B0 = hd3.B0(bArr, i2, vz4);
                    unsafe.putObject(t, j2, Long.valueOf(vz4.b));
                    unsafe.putInt(t, j3, i5);
                    return B0;
                }
                break;
            case 55:
            case 62:
                if (i6 == 0) {
                    int z0 = hd3.z0(bArr, i2, vz4);
                    unsafe.putObject(t, j2, Integer.valueOf(vz4.f3697a));
                    unsafe.putInt(t, j3, i5);
                    return z0;
                }
                break;
            case 56:
            case 65:
                if (i6 == 1) {
                    unsafe.putObject(t, j2, Long.valueOf(hd3.i0(bArr, i2)));
                    int i12 = i2 + 8;
                    unsafe.putInt(t, j3, i5);
                    return i12;
                }
                break;
            case 57:
            case 64:
                if (i6 == 5) {
                    unsafe.putObject(t, j2, Integer.valueOf(hd3.h0(bArr, i2)));
                    int i13 = i2 + 4;
                    unsafe.putInt(t, j3, i5);
                    return i13;
                }
                break;
            case 58:
                if (i6 == 0) {
                    int B02 = hd3.B0(bArr, i2, vz4);
                    unsafe.putObject(t, j2, Boolean.valueOf(vz4.b != 0));
                    unsafe.putInt(t, j3, i5);
                    return B02;
                }
                break;
            case 59:
                if (i6 == 2) {
                    int z02 = hd3.z0(bArr, i2, vz4);
                    int i14 = vz4.f3697a;
                    if (i14 == 0) {
                        unsafe.putObject(t, j2, "");
                    } else if ((i7 & 536870912) == 0 || j25.h(bArr, z02, z02 + i14)) {
                        unsafe.putObject(t, j2, new String(bArr, z02, i14, s05.f3160a));
                        z02 += i14;
                    } else {
                        throw t05.c();
                    }
                    unsafe.putInt(t, j3, i5);
                    return z02;
                }
                break;
            case 60:
                if (i6 == 2) {
                    int k0 = hd3.k0(p(i9), bArr, i2, i3, vz4);
                    Object object = unsafe.getInt(t, j3) == i5 ? unsafe.getObject(t, j2) : null;
                    if (object == null) {
                        unsafe.putObject(t, j2, vz4.c);
                    } else {
                        unsafe.putObject(t, j2, s05.c(object, vz4.c));
                    }
                    unsafe.putInt(t, j3, i5);
                    return k0;
                }
                break;
            case 61:
                if (i6 == 2) {
                    int f0 = hd3.f0(bArr, i2, vz4);
                    unsafe.putObject(t, j2, vz4.c);
                    unsafe.putInt(t, j3, i5);
                    return f0;
                }
                break;
            case 63:
                if (i6 == 0) {
                    int z03 = hd3.z0(bArr, i2, vz4);
                    int i15 = vz4.f3697a;
                    s05.e eVar = (s05.e) this.b[((i9 / 3) * 2) + 1];
                    if (eVar == null || eVar.isInRange(i15)) {
                        unsafe.putObject(t, j2, Integer.valueOf(i15));
                        unsafe.putInt(t, j3, i5);
                    } else {
                        q(t).f(i4, Long.valueOf((long) i15));
                    }
                    return z03;
                }
                break;
            case 66:
                if (i6 == 0) {
                    int z04 = hd3.z0(bArr, i2, vz4);
                    unsafe.putObject(t, j2, Integer.valueOf(b05.b(vz4.f3697a)));
                    unsafe.putInt(t, j3, i5);
                    return z04;
                }
                break;
            case 67:
                if (i6 == 0) {
                    int B03 = hd3.B0(bArr, i2, vz4);
                    unsafe.putObject(t, j2, Long.valueOf(b05.c(vz4.b)));
                    unsafe.putInt(t, j3, i5);
                    return B03;
                }
                break;
            case 68:
                if (i6 == 3) {
                    int j0 = hd3.j0(p(i9), bArr, i2, i3, (i4 & -8) | 4, vz4);
                    Object object2 = unsafe.getInt(t, j3) == i5 ? unsafe.getObject(t, j2) : null;
                    if (object2 == null) {
                        unsafe.putObject(t, j2, vz4.c);
                    } else {
                        unsafe.putObject(t, j2, s05.c(object2, vz4.c));
                    }
                    unsafe.putInt(t, j3, i5);
                    return j0;
                }
                break;
        }
        return i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:118:0x035c, code lost:
        if (r0 != r6) goto L_0x03b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x038f, code lost:
        if (r0 != r15) goto L_0x03b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x03b0, code lost:
        if (r0 != r15) goto L_0x03b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x03c6, code lost:
        r8 = r33;
        r2 = r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x03cd A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x03e2  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x042d  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0059  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int L(T r29, byte[] r30, int r31, int r32, int r33, defpackage.vz4 r34) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 1218
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.l15.L(java.lang.Object, byte[], int, int, int, vz4):int");
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:113:0x024e */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x022c, code lost:
        if (r1 != r10) goto L_0x022e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0230, code lost:
        r16 = r1;
        r4 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01ea, code lost:
        if (r1 != r10) goto L_0x022e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0207, code lost:
        if (r1 != r10) goto L_0x022e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int M(T r30, byte[] r31, int r32, int r33, defpackage.vz4 r34) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 640
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.l15.M(java.lang.Object, byte[], int, int, vz4):int");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:57)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:15)
        */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x020f  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x037e A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x037d A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x037d A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01bf  */
    public final int N(T r17, byte[] r18, int r19, int r20, int r21, int r22, int r23, int r24, long r25, int r27, long r28, defpackage.vz4 r30) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 964
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.l15.N(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, vz4):int");
    }

    public final int O(int i2) {
        if (i2 < this.c || i2 > this.d) {
            return -1;
        }
        return W(i2, 0);
    }

    public final <E> void P(Object obj, long j2, w15 w15, x15<E> x15, i05 i05) throws IOException {
        w15.J(this.n.c(obj, j2), x15, i05);
    }

    public final <E> void Q(Object obj, int i2, w15 w15, x15<E> x15, i05 i05) throws IOException {
        w15.L(this.n.c(obj, D(i2)), x15, i05);
    }

    public final void R(Object obj, int i2, w15 w15) throws IOException {
        if ((536870912 & i2) != 0) {
            i25.f.s(obj, D(i2), w15.H());
        } else if (this.g) {
            i25.f.s(obj, D(i2), w15.v());
        } else {
            i25.f.s(obj, D(i2), w15.z());
        }
    }

    public final void S(Object obj, int i2, w15 w15) throws IOException {
        if ((536870912 & i2) != 0) {
            w15.y(this.n.c(obj, D(i2)));
        } else {
            w15.x(this.n.c(obj, D(i2)));
        }
    }

    public final void U(T t, int i2) {
        if (!this.h) {
            int i3 = this.f2153a[i2 + 2];
            long j2 = (long) (i3 & 1048575);
            i25.f.q(t, j2, i25.n(t, j2) | (1 << (i3 >>> 20)));
        }
    }

    public final void V(T t, int i2, int i3) {
        i25.f.q(t, (long) (this.f2153a[i3 + 2] & 1048575), i2);
    }

    public final int W(int i2, int i3) {
        int length = (this.f2153a.length / 3) - 1;
        while (i3 <= length) {
            int i4 = (length + i3) >>> 1;
            int i5 = i4 * 3;
            int i6 = this.f2153a[i5];
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

    public final int Y(int i2) {
        return this.f2153a[i2 + 1];
    }

    /* JADX WARNING: Removed duplicated region for block: B:171:0x0534  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Z(T r18, defpackage.n25 r19) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 1506
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.l15.Z(java.lang.Object, n25):void");
    }

    @Override // defpackage.x15
    public void a(T t, T t2) {
        Objects.requireNonNull(t2);
        int i2 = 0;
        while (true) {
            int[] iArr = this.f2153a;
            if (i2 < iArr.length) {
                int i3 = iArr[i2 + 1];
                long D = D(i3);
                int i4 = this.f2153a[i2];
                switch (X(i3)) {
                    case 0:
                        if (!t(t2, i2)) {
                            break;
                        } else {
                            i25.v(t, D, i25.l(t2, D));
                            U(t, i2);
                            break;
                        }
                    case 1:
                        if (!t(t2, i2)) {
                            break;
                        } else {
                            i25.f.p(t, D, i25.m(t2, D));
                            U(t, i2);
                            break;
                        }
                    case 2:
                        if (!t(t2, i2)) {
                            break;
                        } else {
                            i25.y(t, D, i25.o(t2, D));
                            U(t, i2);
                            break;
                        }
                    case 3:
                        if (!t(t2, i2)) {
                            break;
                        } else {
                            i25.y(t, D, i25.o(t2, D));
                            U(t, i2);
                            break;
                        }
                    case 4:
                        if (!t(t2, i2)) {
                            break;
                        } else {
                            i25.f.q(t, D, i25.n(t2, D));
                            U(t, i2);
                            break;
                        }
                    case 5:
                        if (!t(t2, i2)) {
                            break;
                        } else {
                            i25.y(t, D, i25.o(t2, D));
                            U(t, i2);
                            break;
                        }
                    case 6:
                        if (!t(t2, i2)) {
                            break;
                        } else {
                            i25.f.q(t, D, i25.n(t2, D));
                            U(t, i2);
                            break;
                        }
                    case 7:
                        if (!t(t2, i2)) {
                            break;
                        } else {
                            i25.f.m(t, D, i25.g(t2, D));
                            U(t, i2);
                            break;
                        }
                    case 8:
                        if (!t(t2, i2)) {
                            break;
                        } else {
                            i25.f.s(t, D, i25.p(t2, D));
                            U(t, i2);
                            break;
                        }
                    case 9:
                        z(t, t2, i2);
                        break;
                    case 10:
                        if (!t(t2, i2)) {
                            break;
                        } else {
                            i25.f.s(t, D, i25.p(t2, D));
                            U(t, i2);
                            break;
                        }
                    case 11:
                        if (!t(t2, i2)) {
                            break;
                        } else {
                            i25.f.q(t, D, i25.n(t2, D));
                            U(t, i2);
                            break;
                        }
                    case 12:
                        if (!t(t2, i2)) {
                            break;
                        } else {
                            i25.f.q(t, D, i25.n(t2, D));
                            U(t, i2);
                            break;
                        }
                    case 13:
                        if (!t(t2, i2)) {
                            break;
                        } else {
                            i25.f.q(t, D, i25.n(t2, D));
                            U(t, i2);
                            break;
                        }
                    case 14:
                        if (!t(t2, i2)) {
                            break;
                        } else {
                            i25.y(t, D, i25.o(t2, D));
                            U(t, i2);
                            break;
                        }
                    case 15:
                        if (!t(t2, i2)) {
                            break;
                        } else {
                            i25.f.q(t, D, i25.n(t2, D));
                            U(t, i2);
                            break;
                        }
                    case 16:
                        if (!t(t2, i2)) {
                            break;
                        } else {
                            i25.y(t, D, i25.o(t2, D));
                            U(t, i2);
                            break;
                        }
                    case 17:
                        z(t, t2, i2);
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
                        this.n.b(t, t2, D);
                        break;
                    case 50:
                        e15 e15 = this.q;
                        Class<?> cls = z15.f4109a;
                        i25.f.s(t, D, e15.a(i25.p(t, D), i25.p(t2, D)));
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
                        if (!v(t2, i4, i2)) {
                            break;
                        } else {
                            i25.f.s(t, D, i25.p(t2, D));
                            V(t, i4, i2);
                            break;
                        }
                    case 60:
                        A(t, t2, i2);
                        break;
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                        if (!v(t2, i4, i2)) {
                            break;
                        } else {
                            i25.f.s(t, D, i25.p(t2, D));
                            V(t, i4, i2);
                            break;
                        }
                    case 68:
                        A(t, t2, i2);
                        break;
                }
                i2 += 3;
            } else {
                e25<?, ?> e25 = this.o;
                Class<?> cls2 = z15.f4109a;
                e25.o(t, e25.k(e25.g(t), e25.g(t2)));
                if (this.f) {
                    z15.B(this.p, t, t2);
                    return;
                }
                return;
            }
        }
    }

    public final <K, V> void a0(n25 n25, int i2, Object obj, int i3) throws IOException {
        if (obj != null) {
            c15.a<?, ?> c2 = this.q.c(this.b[(i3 / 3) * 2]);
            Map<?, ?> h2 = this.q.h(obj);
            e05 e05 = (e05) n25;
            Objects.requireNonNull(e05.f912a);
            for (Map.Entry<?, ?> entry : h2.entrySet()) {
                e05.f912a.W(i2, 2);
                e05.f912a.Y(c15.a(c2, entry.getKey(), entry.getValue()));
                d05 d05 = e05.f912a;
                Object key = entry.getKey();
                Object value = entry.getValue();
                m05.q(d05, c2.f504a, 1, key);
                m05.q(d05, c2.c, 2, value);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0041, code lost:
        if (defpackage.z15.C(defpackage.i25.p(r10, r5), defpackage.i25.p(r11, r5)) != false) goto L_0x01cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0073, code lost:
        if (defpackage.z15.C(defpackage.i25.p(r10, r5), defpackage.i25.p(r11, r5)) != false) goto L_0x01cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0087, code lost:
        if (defpackage.i25.o(r10, r5) == defpackage.i25.o(r11, r5)) goto L_0x01cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0099, code lost:
        if (defpackage.i25.n(r10, r5) == defpackage.i25.n(r11, r5)) goto L_0x01cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00ad, code lost:
        if (defpackage.i25.o(r10, r5) == defpackage.i25.o(r11, r5)) goto L_0x01cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00bf, code lost:
        if (defpackage.i25.n(r10, r5) == defpackage.i25.n(r11, r5)) goto L_0x01cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00d1, code lost:
        if (defpackage.i25.n(r10, r5) == defpackage.i25.n(r11, r5)) goto L_0x01cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00e3, code lost:
        if (defpackage.i25.n(r10, r5) == defpackage.i25.n(r11, r5)) goto L_0x01cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00f9, code lost:
        if (defpackage.z15.C(defpackage.i25.p(r10, r5), defpackage.i25.p(r11, r5)) != false) goto L_0x01cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x010f, code lost:
        if (defpackage.z15.C(defpackage.i25.p(r10, r5), defpackage.i25.p(r11, r5)) != false) goto L_0x01cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0125, code lost:
        if (defpackage.z15.C(defpackage.i25.p(r10, r5), defpackage.i25.p(r11, r5)) != false) goto L_0x01cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0137, code lost:
        if (defpackage.i25.g(r10, r5) == defpackage.i25.g(r11, r5)) goto L_0x01cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0149, code lost:
        if (defpackage.i25.n(r10, r5) == defpackage.i25.n(r11, r5)) goto L_0x01cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x015d, code lost:
        if (defpackage.i25.o(r10, r5) == defpackage.i25.o(r11, r5)) goto L_0x01cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x016f, code lost:
        if (defpackage.i25.n(r10, r5) == defpackage.i25.n(r11, r5)) goto L_0x01cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0182, code lost:
        if (defpackage.i25.o(r10, r5) == defpackage.i25.o(r11, r5)) goto L_0x01cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0195, code lost:
        if (defpackage.i25.o(r10, r5) == defpackage.i25.o(r11, r5)) goto L_0x01cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01ae, code lost:
        if (java.lang.Float.floatToIntBits(defpackage.i25.m(r10, r5)) == java.lang.Float.floatToIntBits(defpackage.i25.m(r11, r5))) goto L_0x01cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01c9, code lost:
        if (java.lang.Double.doubleToLongBits(defpackage.i25.l(r10, r5)) == java.lang.Double.doubleToLongBits(defpackage.i25.l(r11, r5))) goto L_0x01cd;
     */
    @Override // defpackage.x15
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean b(T r10, T r11) {
        /*
        // Method dump skipped, instructions count: 652
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.l15.b(java.lang.Object, java.lang.Object):boolean");
    }

    public final void b0(int i2, Object obj, n25 n25) throws IOException {
        if (obj instanceof String) {
            ((e05) n25).f912a.U(i2, (String) obj);
            return;
        }
        ((e05) n25).f912a.I(i2, (a05) obj);
    }

    @Override // defpackage.x15
    public int c(T t) {
        int i2;
        int i3;
        int length = this.f2153a.length;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5 += 3) {
            int Y = Y(i5);
            int i6 = this.f2153a[i5];
            long D = D(Y);
            int i7 = 37;
            switch (X(Y)) {
                case 0:
                    i3 = i4 * 53;
                    i2 = s05.b(Double.doubleToLongBits(i25.l(t, D)));
                    i4 = i2 + i3;
                    break;
                case 1:
                    i3 = i4 * 53;
                    i2 = Float.floatToIntBits(i25.m(t, D));
                    i4 = i2 + i3;
                    break;
                case 2:
                    i3 = i4 * 53;
                    i2 = s05.b(i25.o(t, D));
                    i4 = i2 + i3;
                    break;
                case 3:
                    i3 = i4 * 53;
                    i2 = s05.b(i25.o(t, D));
                    i4 = i2 + i3;
                    break;
                case 4:
                    i3 = i4 * 53;
                    i2 = i25.n(t, D);
                    i4 = i2 + i3;
                    break;
                case 5:
                    i3 = i4 * 53;
                    i2 = s05.b(i25.o(t, D));
                    i4 = i2 + i3;
                    break;
                case 6:
                    i3 = i4 * 53;
                    i2 = i25.n(t, D);
                    i4 = i2 + i3;
                    break;
                case 7:
                    i3 = i4 * 53;
                    i2 = s05.a(i25.g(t, D));
                    i4 = i2 + i3;
                    break;
                case 8:
                    i3 = i4 * 53;
                    i2 = ((String) i25.p(t, D)).hashCode();
                    i4 = i2 + i3;
                    break;
                case 9:
                    Object p2 = i25.p(t, D);
                    if (p2 != null) {
                        i7 = p2.hashCode();
                    }
                    i4 = (i4 * 53) + i7;
                    break;
                case 10:
                    i3 = i4 * 53;
                    i2 = i25.p(t, D).hashCode();
                    i4 = i2 + i3;
                    break;
                case 11:
                    i3 = i4 * 53;
                    i2 = i25.n(t, D);
                    i4 = i2 + i3;
                    break;
                case 12:
                    i3 = i4 * 53;
                    i2 = i25.n(t, D);
                    i4 = i2 + i3;
                    break;
                case 13:
                    i3 = i4 * 53;
                    i2 = i25.n(t, D);
                    i4 = i2 + i3;
                    break;
                case 14:
                    i3 = i4 * 53;
                    i2 = s05.b(i25.o(t, D));
                    i4 = i2 + i3;
                    break;
                case 15:
                    i3 = i4 * 53;
                    i2 = i25.n(t, D);
                    i4 = i2 + i3;
                    break;
                case 16:
                    i3 = i4 * 53;
                    i2 = s05.b(i25.o(t, D));
                    i4 = i2 + i3;
                    break;
                case 17:
                    Object p3 = i25.p(t, D);
                    if (p3 != null) {
                        i7 = p3.hashCode();
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
                    i2 = i25.p(t, D).hashCode();
                    i4 = i2 + i3;
                    break;
                case 50:
                    i3 = i4 * 53;
                    i2 = i25.p(t, D).hashCode();
                    i4 = i2 + i3;
                    break;
                case 51:
                    if (v(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = s05.b(Double.doubleToLongBits(F(t, D)));
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (v(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = Float.floatToIntBits(G(t, D));
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (v(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = s05.b(I(t, D));
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (v(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = s05.b(I(t, D));
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (v(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = H(t, D);
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (v(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = s05.b(I(t, D));
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (v(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = H(t, D);
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (v(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = s05.a(E(t, D));
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (v(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = ((String) i25.p(t, D)).hashCode();
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (v(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = i25.p(t, D).hashCode();
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (v(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = i25.p(t, D).hashCode();
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (v(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = H(t, D);
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (v(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = H(t, D);
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (v(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = H(t, D);
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (v(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = s05.b(I(t, D));
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (v(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = H(t, D);
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (v(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = s05.b(I(t, D));
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (v(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = i25.p(t, D).hashCode();
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = this.o.g(t).hashCode() + (i4 * 53);
        return this.f ? (hashCode * 53) + this.p.c(t).hashCode() : hashCode;
    }

    @Override // defpackage.x15
    public T d() {
        return (T) this.m.a(this.e);
    }

    @Override // defpackage.x15
    public void e(T t) {
        int i2;
        int i3 = this.k;
        while (true) {
            i2 = this.l;
            if (i3 >= i2) {
                break;
            }
            long D = D(Y(this.j[i3]));
            Object p2 = i25.p(t, D);
            if (p2 != null) {
                i25.f.s(t, D, this.q.b(p2));
            }
            i3++;
        }
        int length = this.j.length;
        while (i2 < length) {
            this.n.a(t, (long) this.j[i2]);
            i2++;
        }
        this.o.j(t);
        if (this.f) {
            this.p.f(t);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3, types: [x15] */
    /* JADX WARN: Type inference failed for: r4v5, types: [x15] */
    /* JADX WARN: Type inference failed for: r4v6, types: [x15] */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v16, types: [x15] */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARNING: Unknown variable types count: 3 */
    @Override // defpackage.x15
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean f(T r13) {
        /*
        // Method dump skipped, instructions count: 307
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.l15.f(java.lang.Object):boolean");
    }

    @Override // defpackage.x15
    public int g(T t) {
        return this.h ? s(t) : r(t);
    }

    /* JADX WARNING: Removed duplicated region for block: B:187:0x0631  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:340:0x0bc0  */
    /* JADX WARNING: Removed duplicated region for block: B:347:0x05f3 A[SYNTHETIC] */
    @Override // defpackage.x15
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void h(T r13, defpackage.n25 r14) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 3328
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.l15.h(java.lang.Object, n25):void");
    }

    @Override // defpackage.x15
    public void i(T t, w15 w15, i05 i05) throws IOException {
        Objects.requireNonNull(i05);
        x((e25<UT, UB>) this.o, (j05<ET>) this.p, t, w15, i05);
    }

    @Override // defpackage.x15
    public void j(T t, byte[] bArr, int i2, int i3, vz4 vz4) throws IOException {
        if (this.h) {
            M(t, bArr, i2, i3, vz4);
        } else {
            L(t, bArr, i2, i3, 0, vz4);
        }
    }

    public final boolean k(T t, T t2, int i2) {
        return t(t, i2) == t(t2, i2);
    }

    public final int l(byte[] bArr, int i2, int i3, l25 l25, Class<?> cls, vz4 vz4) throws IOException {
        switch (l25.ordinal()) {
            case 0:
                vz4.c = Double.valueOf(Double.longBitsToDouble(hd3.i0(bArr, i2)));
                return i2 + 8;
            case 1:
                vz4.c = Float.valueOf(Float.intBitsToFloat(hd3.h0(bArr, i2)));
                return i2 + 4;
            case 2:
            case 3:
                int B0 = hd3.B0(bArr, i2, vz4);
                vz4.c = Long.valueOf(vz4.b);
                return B0;
            case 4:
            case 12:
            case 13:
                int z0 = hd3.z0(bArr, i2, vz4);
                vz4.c = Integer.valueOf(vz4.f3697a);
                return z0;
            case 5:
            case 15:
                vz4.c = Long.valueOf(hd3.i0(bArr, i2));
                return i2 + 8;
            case 6:
            case 14:
                vz4.c = Integer.valueOf(hd3.h0(bArr, i2));
                return i2 + 4;
            case 7:
                int B02 = hd3.B0(bArr, i2, vz4);
                vz4.c = Boolean.valueOf(vz4.b != 0);
                return B02;
            case 8:
                return hd3.w0(bArr, i2, vz4);
            case 9:
            default:
                throw new RuntimeException("unsupported field type.");
            case 10:
                return hd3.k0(t15.c.a(cls), bArr, i2, i3, vz4);
            case 11:
                return hd3.f0(bArr, i2, vz4);
            case 16:
                int z02 = hd3.z0(bArr, i2, vz4);
                vz4.c = Integer.valueOf(b05.b(vz4.f3697a));
                return z02;
            case 17:
                int B03 = hd3.B0(bArr, i2, vz4);
                vz4.c = Long.valueOf(b05.c(vz4.b));
                return B03;
        }
    }

    public final <UT, UB> UB m(Object obj, int i2, UB ub, e25<UT, UB> e25) {
        int[] iArr = this.f2153a;
        int i3 = iArr[i2];
        Object p2 = i25.p(obj, D(iArr[i2 + 1]));
        if (p2 == null) {
            return ub;
        }
        int i4 = (i2 / 3) * 2;
        s05.e eVar = (s05.e) this.b[i4 + 1];
        if (eVar == null) {
            return ub;
        }
        Map<?, ?> d2 = this.q.d(p2);
        c15.a<?, ?> c2 = this.q.c(this.b[i4]);
        Iterator<Map.Entry<?, ?>> it = d2.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<?, ?> next = it.next();
            if (!eVar.isInRange(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = e25.m();
                }
                int a2 = c15.a(c2, next.getKey(), next.getValue());
                byte[] bArr = new byte[a2];
                Logger logger = d05.b;
                d05.c cVar = new d05.c(bArr, 0, a2);
                try {
                    Object key = next.getKey();
                    Object value = next.getValue();
                    m05.q(cVar, c2.f504a, 1, key);
                    m05.q(cVar, c2.c, 2, value);
                    if (cVar.b0() == 0) {
                        e25.d(ub, i3, new a05.f(bArr));
                        it.remove();
                    } else {
                        throw new IllegalStateException("Did not write as much data as expected.");
                    }
                } catch (IOException e2) {
                    throw new RuntimeException(e2);
                }
            }
        }
        return ub;
    }

    public final s05.e n(int i2) {
        return (s05.e) this.b[((i2 / 3) * 2) + 1];
    }

    public final Object o(int i2) {
        return this.b[(i2 / 3) * 2];
    }

    public final x15 p(int i2) {
        int i3 = (i2 / 3) * 2;
        Object[] objArr = this.b;
        x15 x15 = (x15) objArr[i3];
        if (x15 != null) {
            return x15;
        }
        x15<T> a2 = t15.c.a((Class) objArr[i3 + 1]);
        this.b[i3] = a2;
        return a2;
    }

    public final int r(T t) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        Unsafe unsafe = s;
        int i9 = -1;
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < this.f2153a.length; i12 += 3) {
            int Y = Y(i12);
            int i13 = this.f2153a[i12];
            int X = X(Y);
            if (X <= 17) {
                i3 = this.f2153a[i12 + 2];
                int i14 = 1048575 & i3;
                i2 = 1 << (i3 >>> 20);
                if (i14 != i9) {
                    i11 = unsafe.getInt(t, (long) i14);
                    i9 = i14;
                }
            } else {
                i3 = (!this.i || X < n05.DOUBLE_LIST_PACKED.id() || X > n05.SINT64_LIST_PACKED.id()) ? 0 : this.f2153a[i12 + 2] & 1048575;
                i2 = 0;
            }
            long D = D(Y);
            switch (X) {
                case 0:
                    if ((i11 & i2) != 0) {
                        i4 = d05.e(i13, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if ((i11 & i2) != 0) {
                        i4 = d05.i(i13, 0.0f);
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if ((i11 & i2) != 0) {
                        i4 = d05.m(i13, unsafe.getLong(t, D));
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if ((i11 & i2) != 0) {
                        i4 = d05.A(i13, unsafe.getLong(t, D));
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if ((i11 & i2) != 0) {
                        i4 = d05.k(i13, unsafe.getInt(t, D));
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if ((i11 & i2) != 0) {
                        i4 = d05.h(i13, 0);
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if ((i11 & i2) != 0) {
                        i4 = d05.g(i13, 0);
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if ((i11 & i2) != 0) {
                        i4 = d05.b(i13, true);
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if ((i11 & i2) != 0) {
                        Object object = unsafe.getObject(t, D);
                        if (object instanceof a05) {
                            i5 = d05.c(i13, (a05) object);
                        } else {
                            i5 = d05.v(i13, (String) object);
                        }
                        i10 += i5;
                        break;
                    } else {
                        break;
                    }
                case 9:
                    if ((i11 & i2) != 0) {
                        i4 = z15.n(i13, unsafe.getObject(t, D), p(i12));
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if ((i11 & i2) != 0) {
                        i4 = d05.c(i13, (a05) unsafe.getObject(t, D));
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if ((i11 & i2) != 0) {
                        i4 = d05.y(i13, unsafe.getInt(t, D));
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if ((i11 & i2) != 0) {
                        i4 = d05.f(i13, unsafe.getInt(t, D));
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if ((i11 & i2) != 0) {
                        i4 = d05.p(i13, 0);
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if ((i11 & i2) != 0) {
                        i4 = d05.q(i13, 0);
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if ((i11 & i2) != 0) {
                        i4 = d05.r(i13, unsafe.getInt(t, D));
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if ((i11 & i2) != 0) {
                        i4 = d05.t(i13, unsafe.getLong(t, D));
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if ((i11 & i2) != 0) {
                        i4 = d05.j(i13, (j15) unsafe.getObject(t, D), p(i12));
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 18:
                    i4 = z15.g(i13, (List) unsafe.getObject(t, D), false);
                    i10 += i4;
                    break;
                case 19:
                    i4 = z15.e(i13, (List) unsafe.getObject(t, D), false);
                    i10 += i4;
                    break;
                case 20:
                    i4 = z15.l(i13, (List) unsafe.getObject(t, D), false);
                    i10 += i4;
                    break;
                case 21:
                    i4 = z15.w(i13, (List) unsafe.getObject(t, D), false);
                    i10 += i4;
                    break;
                case 22:
                    i4 = z15.j(i13, (List) unsafe.getObject(t, D), false);
                    i10 += i4;
                    break;
                case 23:
                    i4 = z15.g(i13, (List) unsafe.getObject(t, D), false);
                    i10 += i4;
                    break;
                case 24:
                    i4 = z15.e(i13, (List) unsafe.getObject(t, D), false);
                    i10 += i4;
                    break;
                case 25:
                    i4 = z15.a(i13, (List) unsafe.getObject(t, D), false);
                    i10 += i4;
                    break;
                case 26:
                    i4 = z15.t(i13, (List) unsafe.getObject(t, D));
                    i10 += i4;
                    break;
                case 27:
                    i4 = z15.o(i13, (List) unsafe.getObject(t, D), p(i12));
                    i10 += i4;
                    break;
                case 28:
                    i4 = z15.b(i13, (List) unsafe.getObject(t, D));
                    i10 += i4;
                    break;
                case 29:
                    i4 = z15.u(i13, (List) unsafe.getObject(t, D), false);
                    i10 += i4;
                    break;
                case 30:
                    i4 = z15.c(i13, (List) unsafe.getObject(t, D), false);
                    i10 += i4;
                    break;
                case 31:
                    i4 = z15.e(i13, (List) unsafe.getObject(t, D), false);
                    i10 += i4;
                    break;
                case 32:
                    i4 = z15.g(i13, (List) unsafe.getObject(t, D), false);
                    i10 += i4;
                    break;
                case 33:
                    i4 = z15.p(i13, (List) unsafe.getObject(t, D), false);
                    i10 += i4;
                    break;
                case 34:
                    i4 = z15.r(i13, (List) unsafe.getObject(t, D), false);
                    i10 += i4;
                    break;
                case 35:
                    i8 = z15.h((List) unsafe.getObject(t, D));
                    if (i8 <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(t, (long) i3, i8);
                        }
                        i7 = d05.x(i13);
                        i6 = d05.z(i8);
                        i10 += i6 + i7 + i8;
                        break;
                    }
                case 36:
                    i8 = z15.f((List) unsafe.getObject(t, D));
                    if (i8 <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(t, (long) i3, i8);
                        }
                        i7 = d05.x(i13);
                        i6 = d05.z(i8);
                        i10 += i6 + i7 + i8;
                        break;
                    }
                case 37:
                    i8 = z15.m((List) unsafe.getObject(t, D));
                    if (i8 <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(t, (long) i3, i8);
                        }
                        i7 = d05.x(i13);
                        i6 = d05.z(i8);
                        i10 += i6 + i7 + i8;
                        break;
                    }
                case 38:
                    i8 = z15.x((List) unsafe.getObject(t, D));
                    if (i8 <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(t, (long) i3, i8);
                        }
                        i7 = d05.x(i13);
                        i6 = d05.z(i8);
                        i10 += i6 + i7 + i8;
                        break;
                    }
                case 39:
                    i8 = z15.k((List) unsafe.getObject(t, D));
                    if (i8 <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(t, (long) i3, i8);
                        }
                        i7 = d05.x(i13);
                        i6 = d05.z(i8);
                        i10 += i6 + i7 + i8;
                        break;
                    }
                case 40:
                    i8 = z15.h((List) unsafe.getObject(t, D));
                    if (i8 <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(t, (long) i3, i8);
                        }
                        i7 = d05.x(i13);
                        i6 = d05.z(i8);
                        i10 += i6 + i7 + i8;
                        break;
                    }
                case 41:
                    i8 = z15.f((List) unsafe.getObject(t, D));
                    if (i8 <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(t, (long) i3, i8);
                        }
                        i7 = d05.x(i13);
                        i6 = d05.z(i8);
                        i10 += i6 + i7 + i8;
                        break;
                    }
                case 42:
                    Class<?> cls = z15.f4109a;
                    i8 = ((List) unsafe.getObject(t, D)).size();
                    if (i8 <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(t, (long) i3, i8);
                        }
                        i7 = d05.x(i13);
                        i6 = d05.z(i8);
                        i10 += i6 + i7 + i8;
                        break;
                    }
                case 43:
                    i8 = z15.v((List) unsafe.getObject(t, D));
                    if (i8 <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(t, (long) i3, i8);
                        }
                        i7 = d05.x(i13);
                        i6 = d05.z(i8);
                        i10 += i6 + i7 + i8;
                        break;
                    }
                case 44:
                    i8 = z15.d((List) unsafe.getObject(t, D));
                    if (i8 <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(t, (long) i3, i8);
                        }
                        i7 = d05.x(i13);
                        i6 = d05.z(i8);
                        i10 += i6 + i7 + i8;
                        break;
                    }
                case 45:
                    i8 = z15.f((List) unsafe.getObject(t, D));
                    if (i8 <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(t, (long) i3, i8);
                        }
                        i7 = d05.x(i13);
                        i6 = d05.z(i8);
                        i10 += i6 + i7 + i8;
                        break;
                    }
                case 46:
                    i8 = z15.h((List) unsafe.getObject(t, D));
                    if (i8 <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(t, (long) i3, i8);
                        }
                        i7 = d05.x(i13);
                        i6 = d05.z(i8);
                        i10 += i6 + i7 + i8;
                        break;
                    }
                case 47:
                    i8 = z15.q((List) unsafe.getObject(t, D));
                    if (i8 <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(t, (long) i3, i8);
                        }
                        i7 = d05.x(i13);
                        i6 = d05.z(i8);
                        i10 += i6 + i7 + i8;
                        break;
                    }
                case 48:
                    i8 = z15.s((List) unsafe.getObject(t, D));
                    if (i8 <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(t, (long) i3, i8);
                        }
                        i7 = d05.x(i13);
                        i6 = d05.z(i8);
                        i10 += i6 + i7 + i8;
                        break;
                    }
                case 49:
                    i4 = z15.i(i13, (List) unsafe.getObject(t, D), p(i12));
                    i10 += i4;
                    break;
                case 50:
                    i4 = this.q.f(i13, unsafe.getObject(t, D), o(i12));
                    i10 += i4;
                    break;
                case 51:
                    if (v(t, i13, i12)) {
                        i4 = d05.e(i13, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (v(t, i13, i12)) {
                        i4 = d05.i(i13, 0.0f);
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (v(t, i13, i12)) {
                        i4 = d05.m(i13, I(t, D));
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (v(t, i13, i12)) {
                        i4 = d05.A(i13, I(t, D));
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (v(t, i13, i12)) {
                        i4 = d05.k(i13, H(t, D));
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (v(t, i13, i12)) {
                        i4 = d05.h(i13, 0);
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (v(t, i13, i12)) {
                        i4 = d05.g(i13, 0);
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (v(t, i13, i12)) {
                        i4 = d05.b(i13, true);
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (v(t, i13, i12)) {
                        Object object2 = unsafe.getObject(t, D);
                        if (object2 instanceof a05) {
                            i5 = d05.c(i13, (a05) object2);
                        } else {
                            i5 = d05.v(i13, (String) object2);
                        }
                        i10 += i5;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (v(t, i13, i12)) {
                        i4 = z15.n(i13, unsafe.getObject(t, D), p(i12));
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (v(t, i13, i12)) {
                        i4 = d05.c(i13, (a05) unsafe.getObject(t, D));
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (v(t, i13, i12)) {
                        i4 = d05.y(i13, H(t, D));
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (v(t, i13, i12)) {
                        i4 = d05.f(i13, H(t, D));
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (v(t, i13, i12)) {
                        i4 = d05.p(i13, 0);
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (v(t, i13, i12)) {
                        i4 = d05.q(i13, 0);
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (v(t, i13, i12)) {
                        i4 = d05.r(i13, H(t, D));
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (v(t, i13, i12)) {
                        i4 = d05.t(i13, I(t, D));
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (v(t, i13, i12)) {
                        i4 = d05.j(i13, (j15) unsafe.getObject(t, D), p(i12));
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int i15 = 0;
        e25<?, ?> e25 = this.o;
        int h2 = e25.h(e25.g(t)) + i10;
        if (!this.f) {
            return h2;
        }
        m05<?> c2 = this.p.c(t);
        for (int i16 = 0; i16 < c2.f2304a.d(); i16++) {
            Map.Entry<T, Object> c3 = c2.f2304a.c(i16);
            i15 += m05.f(c3.getKey(), c3.getValue());
        }
        for (Map.Entry<T, Object> entry : c2.f2304a.e()) {
            i15 += m05.f(entry.getKey(), entry.getValue());
        }
        return h2 + i15;
    }

    public final int s(T t) {
        int i2;
        int i3;
        int i4;
        int i5;
        Unsafe unsafe = s;
        int i6 = 0;
        for (int i7 = 0; i7 < this.f2153a.length; i7 += 3) {
            int Y = Y(i7);
            int X = X(Y);
            int i8 = this.f2153a[i7];
            long D = D(Y);
            int i9 = (X < n05.DOUBLE_LIST_PACKED.id() || X > n05.SINT64_LIST_PACKED.id()) ? 0 : this.f2153a[i7 + 2] & 1048575;
            switch (X) {
                case 0:
                    if (t(t, i7)) {
                        i2 = d05.e(i8, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (t(t, i7)) {
                        i2 = d05.i(i8, 0.0f);
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (t(t, i7)) {
                        i2 = d05.m(i8, i25.o(t, D));
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (t(t, i7)) {
                        i2 = d05.A(i8, i25.o(t, D));
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (t(t, i7)) {
                        i2 = d05.k(i8, i25.n(t, D));
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (t(t, i7)) {
                        i2 = d05.h(i8, 0);
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (t(t, i7)) {
                        i2 = d05.g(i8, 0);
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (t(t, i7)) {
                        i2 = d05.b(i8, true);
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (t(t, i7)) {
                        Object p2 = i25.p(t, D);
                        if (p2 instanceof a05) {
                            i2 = d05.c(i8, (a05) p2);
                        } else {
                            i2 = d05.v(i8, (String) p2);
                        }
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 9:
                    if (t(t, i7)) {
                        i2 = z15.n(i8, i25.p(t, D), p(i7));
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (t(t, i7)) {
                        i2 = d05.c(i8, (a05) i25.p(t, D));
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (t(t, i7)) {
                        i2 = d05.y(i8, i25.n(t, D));
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (t(t, i7)) {
                        i2 = d05.f(i8, i25.n(t, D));
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (t(t, i7)) {
                        i2 = d05.p(i8, 0);
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (t(t, i7)) {
                        i2 = d05.q(i8, 0);
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (t(t, i7)) {
                        i2 = d05.r(i8, i25.n(t, D));
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (t(t, i7)) {
                        i2 = d05.t(i8, i25.o(t, D));
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (t(t, i7)) {
                        i2 = d05.j(i8, (j15) i25.p(t, D), p(i7));
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 18:
                    i2 = z15.g(i8, w(t, D), false);
                    i6 += i2;
                    break;
                case 19:
                    i2 = z15.e(i8, w(t, D), false);
                    i6 += i2;
                    break;
                case 20:
                    i2 = z15.l(i8, w(t, D), false);
                    i6 += i2;
                    break;
                case 21:
                    i2 = z15.w(i8, w(t, D), false);
                    i6 += i2;
                    break;
                case 22:
                    i2 = z15.j(i8, w(t, D), false);
                    i6 += i2;
                    break;
                case 23:
                    i2 = z15.g(i8, w(t, D), false);
                    i6 += i2;
                    break;
                case 24:
                    i2 = z15.e(i8, w(t, D), false);
                    i6 += i2;
                    break;
                case 25:
                    i2 = z15.a(i8, w(t, D), false);
                    i6 += i2;
                    break;
                case 26:
                    i2 = z15.t(i8, w(t, D));
                    i6 += i2;
                    break;
                case 27:
                    i2 = z15.o(i8, w(t, D), p(i7));
                    i6 += i2;
                    break;
                case 28:
                    i2 = z15.b(i8, w(t, D));
                    i6 += i2;
                    break;
                case 29:
                    i2 = z15.u(i8, w(t, D), false);
                    i6 += i2;
                    break;
                case 30:
                    i2 = z15.c(i8, w(t, D), false);
                    i6 += i2;
                    break;
                case 31:
                    i2 = z15.e(i8, w(t, D), false);
                    i6 += i2;
                    break;
                case 32:
                    i2 = z15.g(i8, w(t, D), false);
                    i6 += i2;
                    break;
                case 33:
                    i2 = z15.p(i8, w(t, D), false);
                    i6 += i2;
                    break;
                case 34:
                    i2 = z15.r(i8, w(t, D), false);
                    i6 += i2;
                    break;
                case 35:
                    i4 = z15.h((List) unsafe.getObject(t, D));
                    if (i4 <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(t, (long) i9, i4);
                        }
                        i5 = d05.x(i8);
                        i3 = d05.z(i4);
                        i6 = i3 + i5 + i4 + i6;
                        break;
                    }
                case 36:
                    i4 = z15.f((List) unsafe.getObject(t, D));
                    if (i4 <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(t, (long) i9, i4);
                        }
                        i5 = d05.x(i8);
                        i3 = d05.z(i4);
                        i6 = i3 + i5 + i4 + i6;
                        break;
                    }
                case 37:
                    i4 = z15.m((List) unsafe.getObject(t, D));
                    if (i4 <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(t, (long) i9, i4);
                        }
                        i5 = d05.x(i8);
                        i3 = d05.z(i4);
                        i6 = i3 + i5 + i4 + i6;
                        break;
                    }
                case 38:
                    i4 = z15.x((List) unsafe.getObject(t, D));
                    if (i4 <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(t, (long) i9, i4);
                        }
                        i5 = d05.x(i8);
                        i3 = d05.z(i4);
                        i6 = i3 + i5 + i4 + i6;
                        break;
                    }
                case 39:
                    i4 = z15.k((List) unsafe.getObject(t, D));
                    if (i4 <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(t, (long) i9, i4);
                        }
                        i5 = d05.x(i8);
                        i3 = d05.z(i4);
                        i6 = i3 + i5 + i4 + i6;
                        break;
                    }
                case 40:
                    i4 = z15.h((List) unsafe.getObject(t, D));
                    if (i4 <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(t, (long) i9, i4);
                        }
                        i5 = d05.x(i8);
                        i3 = d05.z(i4);
                        i6 = i3 + i5 + i4 + i6;
                        break;
                    }
                case 41:
                    i4 = z15.f((List) unsafe.getObject(t, D));
                    if (i4 <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(t, (long) i9, i4);
                        }
                        i5 = d05.x(i8);
                        i3 = d05.z(i4);
                        i6 = i3 + i5 + i4 + i6;
                        break;
                    }
                case 42:
                    Class<?> cls = z15.f4109a;
                    i4 = ((List) unsafe.getObject(t, D)).size();
                    if (i4 <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(t, (long) i9, i4);
                        }
                        i5 = d05.x(i8);
                        i3 = d05.z(i4);
                        i6 = i3 + i5 + i4 + i6;
                        break;
                    }
                case 43:
                    i4 = z15.v((List) unsafe.getObject(t, D));
                    if (i4 <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(t, (long) i9, i4);
                        }
                        i5 = d05.x(i8);
                        i3 = d05.z(i4);
                        i6 = i3 + i5 + i4 + i6;
                        break;
                    }
                case 44:
                    i4 = z15.d((List) unsafe.getObject(t, D));
                    if (i4 <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(t, (long) i9, i4);
                        }
                        i5 = d05.x(i8);
                        i3 = d05.z(i4);
                        i6 = i3 + i5 + i4 + i6;
                        break;
                    }
                case 45:
                    i4 = z15.f((List) unsafe.getObject(t, D));
                    if (i4 <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(t, (long) i9, i4);
                        }
                        i5 = d05.x(i8);
                        i3 = d05.z(i4);
                        i6 = i3 + i5 + i4 + i6;
                        break;
                    }
                case 46:
                    i4 = z15.h((List) unsafe.getObject(t, D));
                    if (i4 <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(t, (long) i9, i4);
                        }
                        i5 = d05.x(i8);
                        i3 = d05.z(i4);
                        i6 = i3 + i5 + i4 + i6;
                        break;
                    }
                case 47:
                    i4 = z15.q((List) unsafe.getObject(t, D));
                    if (i4 <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(t, (long) i9, i4);
                        }
                        i5 = d05.x(i8);
                        i3 = d05.z(i4);
                        i6 = i3 + i5 + i4 + i6;
                        break;
                    }
                case 48:
                    i4 = z15.s((List) unsafe.getObject(t, D));
                    if (i4 <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(t, (long) i9, i4);
                        }
                        i5 = d05.x(i8);
                        i3 = d05.z(i4);
                        i6 = i3 + i5 + i4 + i6;
                        break;
                    }
                case 49:
                    i2 = z15.i(i8, w(t, D), p(i7));
                    i6 += i2;
                    break;
                case 50:
                    i2 = this.q.f(i8, i25.p(t, D), o(i7));
                    i6 += i2;
                    break;
                case 51:
                    if (v(t, i8, i7)) {
                        i2 = d05.e(i8, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (v(t, i8, i7)) {
                        i2 = d05.i(i8, 0.0f);
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (v(t, i8, i7)) {
                        i2 = d05.m(i8, I(t, D));
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (v(t, i8, i7)) {
                        i2 = d05.A(i8, I(t, D));
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (v(t, i8, i7)) {
                        i2 = d05.k(i8, H(t, D));
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (v(t, i8, i7)) {
                        i2 = d05.h(i8, 0);
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (v(t, i8, i7)) {
                        i2 = d05.g(i8, 0);
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (v(t, i8, i7)) {
                        i2 = d05.b(i8, true);
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (v(t, i8, i7)) {
                        Object p3 = i25.p(t, D);
                        if (p3 instanceof a05) {
                            i2 = d05.c(i8, (a05) p3);
                        } else {
                            i2 = d05.v(i8, (String) p3);
                        }
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (v(t, i8, i7)) {
                        i2 = z15.n(i8, i25.p(t, D), p(i7));
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (v(t, i8, i7)) {
                        i2 = d05.c(i8, (a05) i25.p(t, D));
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (v(t, i8, i7)) {
                        i2 = d05.y(i8, H(t, D));
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (v(t, i8, i7)) {
                        i2 = d05.f(i8, H(t, D));
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (v(t, i8, i7)) {
                        i2 = d05.p(i8, 0);
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (v(t, i8, i7)) {
                        i2 = d05.q(i8, 0);
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (v(t, i8, i7)) {
                        i2 = d05.r(i8, H(t, D));
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (v(t, i8, i7)) {
                        i2 = d05.t(i8, I(t, D));
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (v(t, i8, i7)) {
                        i2 = d05.j(i8, (j15) i25.p(t, D), p(i7));
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
            }
        }
        e25<?, ?> e25 = this.o;
        return e25.h(e25.g(t)) + i6;
    }

    public final boolean t(T t, int i2) {
        if (this.h) {
            int i3 = this.f2153a[i2 + 1];
            long D = D(i3);
            switch (X(i3)) {
                case 0:
                    if (i25.l(t, D) != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                        return true;
                    }
                    return false;
                case 1:
                    if (i25.m(t, D) != 0.0f) {
                        return true;
                    }
                    return false;
                case 2:
                    if (i25.o(t, D) != 0) {
                        return true;
                    }
                    return false;
                case 3:
                    if (i25.o(t, D) != 0) {
                        return true;
                    }
                    return false;
                case 4:
                    if (i25.n(t, D) != 0) {
                        return true;
                    }
                    return false;
                case 5:
                    if (i25.o(t, D) != 0) {
                        return true;
                    }
                    return false;
                case 6:
                    if (i25.n(t, D) != 0) {
                        return true;
                    }
                    return false;
                case 7:
                    return i25.g(t, D);
                case 8:
                    Object p2 = i25.p(t, D);
                    if (p2 instanceof String) {
                        return !((String) p2).isEmpty();
                    }
                    if (p2 instanceof a05) {
                        return !a05.g.equals(p2);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    if (i25.p(t, D) != null) {
                        return true;
                    }
                    return false;
                case 10:
                    return !a05.g.equals(i25.p(t, D));
                case 11:
                    if (i25.n(t, D) != 0) {
                        return true;
                    }
                    return false;
                case 12:
                    if (i25.n(t, D) != 0) {
                        return true;
                    }
                    return false;
                case 13:
                    if (i25.n(t, D) != 0) {
                        return true;
                    }
                    return false;
                case 14:
                    if (i25.o(t, D) != 0) {
                        return true;
                    }
                    return false;
                case 15:
                    if (i25.n(t, D) != 0) {
                        return true;
                    }
                    return false;
                case 16:
                    if (i25.o(t, D) != 0) {
                        return true;
                    }
                    return false;
                case 17:
                    if (i25.p(t, D) != null) {
                        return true;
                    }
                    return false;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            int i4 = this.f2153a[i2 + 2];
            if ((i25.n(t, (long) (i4 & 1048575)) & (1 << (i4 >>> 20))) != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean u(T t, int i2, int i3, int i4) {
        if (this.h) {
            return t(t, i2);
        }
        return (i3 & i4) != 0;
    }

    public final boolean v(T t, int i2, int i3) {
        return i25.n(t, (long) (this.f2153a[i3 + 2] & 1048575)) == i2;
    }

    /*  JADX ERROR: StackOverflowError in pass: MarkFinallyVisitor
        java.lang.StackOverflowError
        	at jadx.core.dex.nodes.InsnNode.isSame(InsnNode.java:303)
        	at jadx.core.dex.instructions.IndexInsnNode.isSame(IndexInsnNode.java:36)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.sameInsns(MarkFinallyVisitor.java:451)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.compareBlocks(MarkFinallyVisitor.java:436)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:408)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:411)
        */
    public final <UT, UB, ET extends defpackage.m05.a<ET>> void x(defpackage.e25<UT, UB> r17, defpackage.j05<ET> r18, T r19, defpackage.w15 r20, defpackage.i05 r21) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 1720
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.l15.x(e25, j05, java.lang.Object, w15, i05):void");
    }

    public final <K, V> void y(Object obj, int i2, Object obj2, i05 i05, w15 w15) throws IOException {
        long D = D(this.f2153a[i2 + 1]);
        Object p2 = i25.p(obj, D);
        if (p2 == null) {
            p2 = this.q.e(obj2);
            i25.f.s(obj, D, p2);
        } else if (this.q.g(p2)) {
            Object e2 = this.q.e(obj2);
            this.q.a(e2, p2);
            i25.f.s(obj, D, e2);
            p2 = e2;
        }
        w15.P(this.q.d(p2), this.q.c(obj2), i05);
    }

    public final void z(T t, T t2, int i2) {
        long D = D(this.f2153a[i2 + 1]);
        if (t(t2, i2)) {
            Object p2 = i25.p(t, D);
            Object p3 = i25.p(t2, D);
            if (p2 != null && p3 != null) {
                i25.f.s(t, D, s05.c(p2, p3));
                U(t, i2);
            } else if (p3 != null) {
                i25.f.s(t, D, p3);
                U(t, i2);
            }
        }
    }
}
