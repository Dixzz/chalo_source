package defpackage;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import defpackage.mc;
import defpackage.ub;
import defpackage.wc;
import defpackage.xb;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* renamed from: fd  reason: default package */
/* compiled from: MessageSchema */
public final class fd<T> implements rd<T> {
    public static final int[] r = new int[0];
    public static final Unsafe s = ce.o();

    /* renamed from: a  reason: collision with root package name */
    public final int[] f1115a;
    public final Object[] b;
    public final int c;
    public final int d;
    public final dd e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final int[] j;
    public final int k;
    public final int l;
    public final hd m;
    public final tc n;
    public final yd<?, ?> o;
    public final dc<?> p;
    public final yc q;

    public fd(int[] iArr, Object[] objArr, int i2, int i3, dd ddVar, boolean z, boolean z2, int[] iArr2, int i4, int i5, hd hdVar, tc tcVar, yd<?, ?> ydVar, dc<?> dcVar, yc ycVar) {
        this.f1115a = iArr;
        this.b = objArr;
        this.c = i2;
        this.d = i3;
        this.g = ddVar instanceof kc;
        this.h = z;
        this.f = dcVar != null && dcVar.e(ddVar);
        this.i = z2;
        this.j = iArr2;
        this.k = i4;
        this.l = i5;
        this.m = hdVar;
        this.n = tcVar;
        this.o = ydVar;
        this.p = dcVar;
        this.e = ddVar;
        this.q = ycVar;
    }

    public static long A(int i2) {
        return (long) (i2 & 1048575);
    }

    public static <T> boolean B(T t, long j2) {
        return ((Boolean) ce.n(t, j2)).booleanValue();
    }

    public static <T> double C(T t, long j2) {
        return ((Double) ce.n(t, j2)).doubleValue();
    }

    public static <T> float D(T t, long j2) {
        return ((Float) ce.n(t, j2)).floatValue();
    }

    public static <T> int E(T t, long j2) {
        return ((Integer) ce.n(t, j2)).intValue();
    }

    public static <T> long F(T t, long j2) {
        return ((Long) ce.n(t, j2)).longValue();
    }

    public static Field L(Class<?> cls, String str) {
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

    public static int O(int i2) {
        return (i2 & 267386880) >>> 20;
    }

    public static List<?> t(Object obj, long j2) {
        return (List) ce.n(obj, j2);
    }

    /* JADX WARN: Incorrect args count in method signature: <T:Ljava/lang/Object;>(Ljava/lang/Class<TT;>;Lbd;Lhd;Ltc;Lyd<**>;Ldc<*>;Lyc;)Lfd<TT;>; */
    public static fd y(bd bdVar, hd hdVar, tc tcVar, yd ydVar, dc dcVar, yc ycVar) {
        if (bdVar instanceof pd) {
            return z((pd) bdVar, hdVar, tcVar, ydVar, dcVar, ycVar);
        }
        wd wdVar = (wd) bdVar;
        md mdVar = md.PROTO3;
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:126:0x028e  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0291  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x02a8  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x02ab  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x035a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> defpackage.fd<T> z(defpackage.pd r36, defpackage.hd r37, defpackage.tc r38, defpackage.yd<?, ?> r39, defpackage.dc<?> r40, defpackage.yc r41) {
        /*
        // Method dump skipped, instructions count: 1054
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.fd.z(pd, hd, tc, yd, dc, yc):fd");
    }

    public final int G(int i2) {
        if (i2 < this.c || i2 > this.d) {
            return -1;
        }
        int i3 = 0;
        int length = (this.f1115a.length / 3) - 1;
        while (i3 <= length) {
            int i4 = (length + i3) >>> 1;
            int i5 = i4 * 3;
            int i6 = this.f1115a[i5];
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

    public final <E> void H(Object obj, long j2, qd qdVar, rd<E> rdVar, cc ccVar) throws IOException {
        qdVar.L(this.n.c(obj, j2), rdVar, ccVar);
    }

    public final <E> void I(Object obj, int i2, qd qdVar, rd<E> rdVar, cc ccVar) throws IOException {
        qdVar.M(this.n.c(obj, A(i2)), rdVar, ccVar);
    }

    public final void J(Object obj, int i2, qd qdVar) throws IOException {
        if ((536870912 & i2) != 0) {
            ce.f.q(obj, A(i2), qdVar.H());
        } else if (this.g) {
            ce.f.q(obj, A(i2), qdVar.v());
        } else {
            ce.f.q(obj, A(i2), qdVar.z());
        }
    }

    public final void K(Object obj, int i2, qd qdVar) throws IOException {
        if ((536870912 & i2) != 0) {
            qdVar.y(this.n.c(obj, A(i2)));
        } else {
            qdVar.x(this.n.c(obj, A(i2)));
        }
    }

    public final void M(T t, int i2) {
        if (!this.h) {
            int i3 = this.f1115a[i2 + 2];
            long j2 = (long) (i3 & 1048575);
            ce.f.o(t, j2, ce.l(t, j2) | (1 << (i3 >>> 20)));
        }
    }

    public final void N(T t, int i2, int i3) {
        ce.f.o(t, (long) (this.f1115a[i3 + 2] & 1048575), i2);
    }

    public final int P(int i2) {
        return this.f1115a[i2 + 1];
    }

    /* JADX WARNING: Removed duplicated region for block: B:171:0x0534  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Q(T r18, defpackage.he r19) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 1506
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.fd.Q(java.lang.Object, he):void");
    }

    public final <K, V> void R(he heVar, int i2, Object obj, int i3) throws IOException {
        if (obj != null) {
            wc.a<?, ?> c2 = this.q.c(this.b[(i3 / 3) * 2]);
            Map<?, ?> h2 = this.q.h(obj);
            yb ybVar = (yb) heVar;
            Objects.requireNonNull(ybVar.f4026a);
            for (Map.Entry<?, ?> entry : h2.entrySet()) {
                ybVar.f4026a.W(i2, 2);
                ybVar.f4026a.Y(wc.a(c2, entry.getKey(), entry.getValue()));
                wc.b(ybVar.f4026a, c2, entry.getKey(), entry.getValue());
            }
        }
    }

    public final void S(int i2, Object obj, he heVar) throws IOException {
        if (obj instanceof String) {
            ((yb) heVar).f4026a.U(i2, (String) obj);
            return;
        }
        ((yb) heVar).f4026a.I(i2, (ub) obj);
    }

    @Override // defpackage.rd
    public void a(T t, T t2) {
        Objects.requireNonNull(t2);
        int i2 = 0;
        while (true) {
            int[] iArr = this.f1115a;
            if (i2 < iArr.length) {
                int i3 = iArr[i2 + 1];
                long A = A(i3);
                int i4 = this.f1115a[i2];
                switch (O(i3)) {
                    case 0:
                        if (!q(t2, i2)) {
                            break;
                        } else {
                            ce.f.m(t, A, ce.j(t2, A));
                            M(t, i2);
                            break;
                        }
                    case 1:
                        if (!q(t2, i2)) {
                            break;
                        } else {
                            ce.f.n(t, A, ce.k(t2, A));
                            M(t, i2);
                            break;
                        }
                    case 2:
                        if (!q(t2, i2)) {
                            break;
                        } else {
                            ce.w(t, A, ce.m(t2, A));
                            M(t, i2);
                            break;
                        }
                    case 3:
                        if (!q(t2, i2)) {
                            break;
                        } else {
                            ce.w(t, A, ce.m(t2, A));
                            M(t, i2);
                            break;
                        }
                    case 4:
                        if (!q(t2, i2)) {
                            break;
                        } else {
                            ce.f.o(t, A, ce.l(t2, A));
                            M(t, i2);
                            break;
                        }
                    case 5:
                        if (!q(t2, i2)) {
                            break;
                        } else {
                            ce.w(t, A, ce.m(t2, A));
                            M(t, i2);
                            break;
                        }
                    case 6:
                        if (!q(t2, i2)) {
                            break;
                        } else {
                            ce.f.o(t, A, ce.l(t2, A));
                            M(t, i2);
                            break;
                        }
                    case 7:
                        if (!q(t2, i2)) {
                            break;
                        } else {
                            ce.f.k(t, A, ce.f(t2, A));
                            M(t, i2);
                            break;
                        }
                    case 8:
                        if (!q(t2, i2)) {
                            break;
                        } else {
                            ce.f.q(t, A, ce.n(t2, A));
                            M(t, i2);
                            break;
                        }
                    case 9:
                        w(t, t2, i2);
                        break;
                    case 10:
                        if (!q(t2, i2)) {
                            break;
                        } else {
                            ce.f.q(t, A, ce.n(t2, A));
                            M(t, i2);
                            break;
                        }
                    case 11:
                        if (!q(t2, i2)) {
                            break;
                        } else {
                            ce.f.o(t, A, ce.l(t2, A));
                            M(t, i2);
                            break;
                        }
                    case 12:
                        if (!q(t2, i2)) {
                            break;
                        } else {
                            ce.f.o(t, A, ce.l(t2, A));
                            M(t, i2);
                            break;
                        }
                    case 13:
                        if (!q(t2, i2)) {
                            break;
                        } else {
                            ce.f.o(t, A, ce.l(t2, A));
                            M(t, i2);
                            break;
                        }
                    case 14:
                        if (!q(t2, i2)) {
                            break;
                        } else {
                            ce.w(t, A, ce.m(t2, A));
                            M(t, i2);
                            break;
                        }
                    case 15:
                        if (!q(t2, i2)) {
                            break;
                        } else {
                            ce.f.o(t, A, ce.l(t2, A));
                            M(t, i2);
                            break;
                        }
                    case 16:
                        if (!q(t2, i2)) {
                            break;
                        } else {
                            ce.w(t, A, ce.m(t2, A));
                            M(t, i2);
                            break;
                        }
                    case 17:
                        w(t, t2, i2);
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
                        this.n.b(t, t2, A);
                        break;
                    case 50:
                        yc ycVar = this.q;
                        Class<?> cls = td.f3335a;
                        ce.f.q(t, A, ycVar.a(ce.n(t, A), ce.n(t2, A)));
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
                        if (!s(t2, i4, i2)) {
                            break;
                        } else {
                            ce.f.q(t, A, ce.n(t2, A));
                            N(t, i4, i2);
                            break;
                        }
                    case 60:
                        x(t, t2, i2);
                        break;
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                        if (!s(t2, i4, i2)) {
                            break;
                        } else {
                            ce.f.q(t, A, ce.n(t2, A));
                            N(t, i4, i2);
                            break;
                        }
                    case 68:
                        x(t, t2, i2);
                        break;
                }
                i2 += 3;
            } else if (!this.h) {
                yd<?, ?> ydVar = this.o;
                Class<?> cls2 = td.f3335a;
                ydVar.o(t, ydVar.k(ydVar.g(t), ydVar.g(t2)));
                if (this.f) {
                    td.A(this.p, t, t2);
                    return;
                }
                return;
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0041, code lost:
        if (defpackage.td.B(defpackage.ce.n(r10, r5), defpackage.ce.n(r11, r5)) != false) goto L_0x01cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0073, code lost:
        if (defpackage.td.B(defpackage.ce.n(r10, r5), defpackage.ce.n(r11, r5)) != false) goto L_0x01cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0087, code lost:
        if (defpackage.ce.m(r10, r5) == defpackage.ce.m(r11, r5)) goto L_0x01cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0099, code lost:
        if (defpackage.ce.l(r10, r5) == defpackage.ce.l(r11, r5)) goto L_0x01cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00ad, code lost:
        if (defpackage.ce.m(r10, r5) == defpackage.ce.m(r11, r5)) goto L_0x01cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00bf, code lost:
        if (defpackage.ce.l(r10, r5) == defpackage.ce.l(r11, r5)) goto L_0x01cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00d1, code lost:
        if (defpackage.ce.l(r10, r5) == defpackage.ce.l(r11, r5)) goto L_0x01cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00e3, code lost:
        if (defpackage.ce.l(r10, r5) == defpackage.ce.l(r11, r5)) goto L_0x01cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00f9, code lost:
        if (defpackage.td.B(defpackage.ce.n(r10, r5), defpackage.ce.n(r11, r5)) != false) goto L_0x01cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x010f, code lost:
        if (defpackage.td.B(defpackage.ce.n(r10, r5), defpackage.ce.n(r11, r5)) != false) goto L_0x01cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0125, code lost:
        if (defpackage.td.B(defpackage.ce.n(r10, r5), defpackage.ce.n(r11, r5)) != false) goto L_0x01cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0137, code lost:
        if (defpackage.ce.f(r10, r5) == defpackage.ce.f(r11, r5)) goto L_0x01cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0149, code lost:
        if (defpackage.ce.l(r10, r5) == defpackage.ce.l(r11, r5)) goto L_0x01cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x015d, code lost:
        if (defpackage.ce.m(r10, r5) == defpackage.ce.m(r11, r5)) goto L_0x01cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x016f, code lost:
        if (defpackage.ce.l(r10, r5) == defpackage.ce.l(r11, r5)) goto L_0x01cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0182, code lost:
        if (defpackage.ce.m(r10, r5) == defpackage.ce.m(r11, r5)) goto L_0x01cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0195, code lost:
        if (defpackage.ce.m(r10, r5) == defpackage.ce.m(r11, r5)) goto L_0x01cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01ae, code lost:
        if (java.lang.Float.floatToIntBits(defpackage.ce.k(r10, r5)) == java.lang.Float.floatToIntBits(defpackage.ce.k(r11, r5))) goto L_0x01cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01c9, code lost:
        if (java.lang.Double.doubleToLongBits(defpackage.ce.j(r10, r5)) == java.lang.Double.doubleToLongBits(defpackage.ce.j(r11, r5))) goto L_0x01cd;
     */
    @Override // defpackage.rd
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean b(T r10, T r11) {
        /*
        // Method dump skipped, instructions count: 652
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.fd.b(java.lang.Object, java.lang.Object):boolean");
    }

    @Override // defpackage.rd
    public int c(T t) {
        int i2;
        int i3;
        int length = this.f1115a.length;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5 += 3) {
            int P = P(i5);
            int i6 = this.f1115a[i5];
            long A = A(P);
            int i7 = 37;
            switch (O(P)) {
                case 0:
                    i3 = i4 * 53;
                    i2 = mc.b(Double.doubleToLongBits(ce.j(t, A)));
                    i4 = i2 + i3;
                    break;
                case 1:
                    i3 = i4 * 53;
                    i2 = Float.floatToIntBits(ce.k(t, A));
                    i4 = i2 + i3;
                    break;
                case 2:
                    i3 = i4 * 53;
                    i2 = mc.b(ce.m(t, A));
                    i4 = i2 + i3;
                    break;
                case 3:
                    i3 = i4 * 53;
                    i2 = mc.b(ce.m(t, A));
                    i4 = i2 + i3;
                    break;
                case 4:
                    i3 = i4 * 53;
                    i2 = ce.l(t, A);
                    i4 = i2 + i3;
                    break;
                case 5:
                    i3 = i4 * 53;
                    i2 = mc.b(ce.m(t, A));
                    i4 = i2 + i3;
                    break;
                case 6:
                    i3 = i4 * 53;
                    i2 = ce.l(t, A);
                    i4 = i2 + i3;
                    break;
                case 7:
                    i3 = i4 * 53;
                    i2 = mc.a(ce.f(t, A));
                    i4 = i2 + i3;
                    break;
                case 8:
                    i3 = i4 * 53;
                    i2 = ((String) ce.n(t, A)).hashCode();
                    i4 = i2 + i3;
                    break;
                case 9:
                    Object n2 = ce.n(t, A);
                    if (n2 != null) {
                        i7 = n2.hashCode();
                    }
                    i4 = (i4 * 53) + i7;
                    break;
                case 10:
                    i3 = i4 * 53;
                    i2 = ce.n(t, A).hashCode();
                    i4 = i2 + i3;
                    break;
                case 11:
                    i3 = i4 * 53;
                    i2 = ce.l(t, A);
                    i4 = i2 + i3;
                    break;
                case 12:
                    i3 = i4 * 53;
                    i2 = ce.l(t, A);
                    i4 = i2 + i3;
                    break;
                case 13:
                    i3 = i4 * 53;
                    i2 = ce.l(t, A);
                    i4 = i2 + i3;
                    break;
                case 14:
                    i3 = i4 * 53;
                    i2 = mc.b(ce.m(t, A));
                    i4 = i2 + i3;
                    break;
                case 15:
                    i3 = i4 * 53;
                    i2 = ce.l(t, A);
                    i4 = i2 + i3;
                    break;
                case 16:
                    i3 = i4 * 53;
                    i2 = mc.b(ce.m(t, A));
                    i4 = i2 + i3;
                    break;
                case 17:
                    Object n3 = ce.n(t, A);
                    if (n3 != null) {
                        i7 = n3.hashCode();
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
                    i2 = ce.n(t, A).hashCode();
                    i4 = i2 + i3;
                    break;
                case 50:
                    i3 = i4 * 53;
                    i2 = ce.n(t, A).hashCode();
                    i4 = i2 + i3;
                    break;
                case 51:
                    if (s(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = mc.b(Double.doubleToLongBits(C(t, A)));
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (s(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = Float.floatToIntBits(D(t, A));
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (s(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = mc.b(F(t, A));
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (s(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = mc.b(F(t, A));
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (s(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = E(t, A);
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (s(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = mc.b(F(t, A));
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (s(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = E(t, A);
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (s(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = mc.a(B(t, A));
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (s(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = ((String) ce.n(t, A)).hashCode();
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (s(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = ce.n(t, A).hashCode();
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (s(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = ce.n(t, A).hashCode();
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (s(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = E(t, A);
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (s(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = E(t, A);
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (s(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = E(t, A);
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (s(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = mc.b(F(t, A));
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (s(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = E(t, A);
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (s(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = mc.b(F(t, A));
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (s(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = ce.n(t, A).hashCode();
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

    @Override // defpackage.rd
    public T d() {
        return (T) this.m.a(this.e);
    }

    @Override // defpackage.rd
    public void e(T t) {
        int i2;
        int i3 = this.k;
        while (true) {
            i2 = this.l;
            if (i3 >= i2) {
                break;
            }
            long A = A(P(this.j[i3]));
            Object n2 = ce.n(t, A);
            if (n2 != null) {
                ce.f.q(t, A, this.q.b(n2));
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
    /* JADX WARN: Type inference failed for: r4v3, types: [rd] */
    /* JADX WARN: Type inference failed for: r4v5, types: [rd] */
    /* JADX WARN: Type inference failed for: r4v6, types: [rd] */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v16, types: [rd] */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARNING: Unknown variable types count: 3 */
    @Override // defpackage.rd
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean f(T r13) {
        /*
        // Method dump skipped, instructions count: 307
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.fd.f(java.lang.Object):boolean");
    }

    @Override // defpackage.rd
    public int g(T t) {
        return this.h ? p(t) : o(t);
    }

    @Override // defpackage.rd
    public void h(T t, qd qdVar, cc ccVar) throws IOException {
        Objects.requireNonNull(ccVar);
        u((yd<UT, UB>) this.o, (dc<ET>) this.p, t, qdVar, ccVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:187:0x0631  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:340:0x0bc0  */
    /* JADX WARNING: Removed duplicated region for block: B:347:0x05f3 A[SYNTHETIC] */
    @Override // defpackage.rd
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void i(T r13, defpackage.he r14) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 3328
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.fd.i(java.lang.Object, he):void");
    }

    public final boolean j(T t, T t2, int i2) {
        return q(t, i2) == q(t2, i2);
    }

    public final <UT, UB> UB k(Object obj, int i2, UB ub, yd<UT, UB> ydVar) {
        int[] iArr = this.f1115a;
        int i3 = iArr[i2];
        Object n2 = ce.n(obj, A(iArr[i2 + 1]));
        if (n2 == null) {
            return ub;
        }
        int i4 = (i2 / 3) * 2;
        mc.b bVar = (mc.b) this.b[i4 + 1];
        if (bVar == null) {
            return ub;
        }
        Map<?, ?> d2 = this.q.d(n2);
        wc.a<?, ?> c2 = this.q.c(this.b[i4]);
        Iterator<Map.Entry<?, ?>> it = d2.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<?, ?> next = it.next();
            if (!bVar.isInRange(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = ydVar.m();
                }
                int a2 = wc.a(c2, next.getKey(), next.getValue());
                byte[] bArr = new byte[a2];
                Logger logger = xb.b;
                xb.c cVar = new xb.c(bArr, 0, a2);
                try {
                    Object key = next.getKey();
                    Object value = next.getValue();
                    gc.p(cVar, c2.f3759a, 1, key);
                    gc.p(cVar, c2.c, 2, value);
                    if (cVar.b0() == 0) {
                        ydVar.d(ub, i3, new ub.e(bArr));
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

    public final mc.b l(int i2) {
        return (mc.b) this.b[((i2 / 3) * 2) + 1];
    }

    public final Object m(int i2) {
        return this.b[(i2 / 3) * 2];
    }

    public final rd n(int i2) {
        int i3 = (i2 / 3) * 2;
        Object[] objArr = this.b;
        rd rdVar = (rd) objArr[i3];
        if (rdVar != null) {
            return rdVar;
        }
        rd<T> a2 = nd.c.a((Class) objArr[i3 + 1]);
        this.b[i3] = a2;
        return a2;
    }

    public final int o(T t) {
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
        for (int i12 = 0; i12 < this.f1115a.length; i12 += 3) {
            int P = P(i12);
            int i13 = this.f1115a[i12];
            int O = O(P);
            if (O <= 17) {
                i3 = this.f1115a[i12 + 2];
                int i14 = 1048575 & i3;
                i2 = 1 << (i3 >>> 20);
                if (i14 != i9) {
                    i11 = unsafe.getInt(t, (long) i14);
                    i9 = i14;
                }
            } else {
                i3 = (!this.i || O < hc.DOUBLE_LIST_PACKED.id() || O > hc.SINT64_LIST_PACKED.id()) ? 0 : this.f1115a[i12 + 2] & 1048575;
                i2 = 0;
            }
            long A = A(P);
            switch (O) {
                case 0:
                    if ((i11 & i2) != 0) {
                        i4 = xb.e(i13, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if ((i11 & i2) != 0) {
                        i4 = xb.i(i13, 0.0f);
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if ((i11 & i2) != 0) {
                        i4 = xb.m(i13, unsafe.getLong(t, A));
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if ((i11 & i2) != 0) {
                        i4 = xb.A(i13, unsafe.getLong(t, A));
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if ((i11 & i2) != 0) {
                        i4 = xb.k(i13, unsafe.getInt(t, A));
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if ((i11 & i2) != 0) {
                        i4 = xb.h(i13, 0);
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if ((i11 & i2) != 0) {
                        i4 = xb.g(i13, 0);
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if ((i11 & i2) != 0) {
                        i4 = xb.b(i13, true);
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if ((i11 & i2) != 0) {
                        Object object = unsafe.getObject(t, A);
                        if (object instanceof ub) {
                            i5 = xb.c(i13, (ub) object);
                        } else {
                            i5 = xb.v(i13, (String) object);
                        }
                        i10 += i5;
                        break;
                    } else {
                        break;
                    }
                case 9:
                    if ((i11 & i2) != 0) {
                        i4 = td.n(i13, unsafe.getObject(t, A), n(i12));
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if ((i11 & i2) != 0) {
                        i4 = xb.c(i13, (ub) unsafe.getObject(t, A));
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if ((i11 & i2) != 0) {
                        i4 = xb.y(i13, unsafe.getInt(t, A));
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if ((i11 & i2) != 0) {
                        i4 = xb.f(i13, unsafe.getInt(t, A));
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if ((i11 & i2) != 0) {
                        i4 = xb.p(i13, 0);
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if ((i11 & i2) != 0) {
                        i4 = xb.q(i13, 0);
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if ((i11 & i2) != 0) {
                        i4 = xb.r(i13, unsafe.getInt(t, A));
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if ((i11 & i2) != 0) {
                        i4 = xb.t(i13, unsafe.getLong(t, A));
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if ((i11 & i2) != 0) {
                        i4 = xb.j(i13, (dd) unsafe.getObject(t, A), n(i12));
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 18:
                    i4 = td.g(i13, (List) unsafe.getObject(t, A), false);
                    i10 += i4;
                    break;
                case 19:
                    i4 = td.e(i13, (List) unsafe.getObject(t, A), false);
                    i10 += i4;
                    break;
                case 20:
                    i4 = td.l(i13, (List) unsafe.getObject(t, A), false);
                    i10 += i4;
                    break;
                case 21:
                    i4 = td.w(i13, (List) unsafe.getObject(t, A), false);
                    i10 += i4;
                    break;
                case 22:
                    i4 = td.j(i13, (List) unsafe.getObject(t, A), false);
                    i10 += i4;
                    break;
                case 23:
                    i4 = td.g(i13, (List) unsafe.getObject(t, A), false);
                    i10 += i4;
                    break;
                case 24:
                    i4 = td.e(i13, (List) unsafe.getObject(t, A), false);
                    i10 += i4;
                    break;
                case 25:
                    i4 = td.a(i13, (List) unsafe.getObject(t, A), false);
                    i10 += i4;
                    break;
                case 26:
                    i4 = td.t(i13, (List) unsafe.getObject(t, A));
                    i10 += i4;
                    break;
                case 27:
                    i4 = td.o(i13, (List) unsafe.getObject(t, A), n(i12));
                    i10 += i4;
                    break;
                case 28:
                    i4 = td.b(i13, (List) unsafe.getObject(t, A));
                    i10 += i4;
                    break;
                case 29:
                    i4 = td.u(i13, (List) unsafe.getObject(t, A), false);
                    i10 += i4;
                    break;
                case 30:
                    i4 = td.c(i13, (List) unsafe.getObject(t, A), false);
                    i10 += i4;
                    break;
                case 31:
                    i4 = td.e(i13, (List) unsafe.getObject(t, A), false);
                    i10 += i4;
                    break;
                case 32:
                    i4 = td.g(i13, (List) unsafe.getObject(t, A), false);
                    i10 += i4;
                    break;
                case 33:
                    i4 = td.p(i13, (List) unsafe.getObject(t, A), false);
                    i10 += i4;
                    break;
                case 34:
                    i4 = td.r(i13, (List) unsafe.getObject(t, A), false);
                    i10 += i4;
                    break;
                case 35:
                    i8 = td.h((List) unsafe.getObject(t, A));
                    if (i8 <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(t, (long) i3, i8);
                        }
                        i7 = xb.x(i13);
                        i6 = xb.z(i8);
                        i10 += i6 + i7 + i8;
                        break;
                    }
                case 36:
                    i8 = td.f((List) unsafe.getObject(t, A));
                    if (i8 <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(t, (long) i3, i8);
                        }
                        i7 = xb.x(i13);
                        i6 = xb.z(i8);
                        i10 += i6 + i7 + i8;
                        break;
                    }
                case 37:
                    i8 = td.m((List) unsafe.getObject(t, A));
                    if (i8 <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(t, (long) i3, i8);
                        }
                        i7 = xb.x(i13);
                        i6 = xb.z(i8);
                        i10 += i6 + i7 + i8;
                        break;
                    }
                case 38:
                    i8 = td.x((List) unsafe.getObject(t, A));
                    if (i8 <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(t, (long) i3, i8);
                        }
                        i7 = xb.x(i13);
                        i6 = xb.z(i8);
                        i10 += i6 + i7 + i8;
                        break;
                    }
                case 39:
                    i8 = td.k((List) unsafe.getObject(t, A));
                    if (i8 <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(t, (long) i3, i8);
                        }
                        i7 = xb.x(i13);
                        i6 = xb.z(i8);
                        i10 += i6 + i7 + i8;
                        break;
                    }
                case 40:
                    i8 = td.h((List) unsafe.getObject(t, A));
                    if (i8 <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(t, (long) i3, i8);
                        }
                        i7 = xb.x(i13);
                        i6 = xb.z(i8);
                        i10 += i6 + i7 + i8;
                        break;
                    }
                case 41:
                    i8 = td.f((List) unsafe.getObject(t, A));
                    if (i8 <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(t, (long) i3, i8);
                        }
                        i7 = xb.x(i13);
                        i6 = xb.z(i8);
                        i10 += i6 + i7 + i8;
                        break;
                    }
                case 42:
                    Class<?> cls = td.f3335a;
                    i8 = ((List) unsafe.getObject(t, A)).size();
                    if (i8 <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(t, (long) i3, i8);
                        }
                        i7 = xb.x(i13);
                        i6 = xb.z(i8);
                        i10 += i6 + i7 + i8;
                        break;
                    }
                case 43:
                    i8 = td.v((List) unsafe.getObject(t, A));
                    if (i8 <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(t, (long) i3, i8);
                        }
                        i7 = xb.x(i13);
                        i6 = xb.z(i8);
                        i10 += i6 + i7 + i8;
                        break;
                    }
                case 44:
                    i8 = td.d((List) unsafe.getObject(t, A));
                    if (i8 <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(t, (long) i3, i8);
                        }
                        i7 = xb.x(i13);
                        i6 = xb.z(i8);
                        i10 += i6 + i7 + i8;
                        break;
                    }
                case 45:
                    i8 = td.f((List) unsafe.getObject(t, A));
                    if (i8 <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(t, (long) i3, i8);
                        }
                        i7 = xb.x(i13);
                        i6 = xb.z(i8);
                        i10 += i6 + i7 + i8;
                        break;
                    }
                case 46:
                    i8 = td.h((List) unsafe.getObject(t, A));
                    if (i8 <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(t, (long) i3, i8);
                        }
                        i7 = xb.x(i13);
                        i6 = xb.z(i8);
                        i10 += i6 + i7 + i8;
                        break;
                    }
                case 47:
                    i8 = td.q((List) unsafe.getObject(t, A));
                    if (i8 <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(t, (long) i3, i8);
                        }
                        i7 = xb.x(i13);
                        i6 = xb.z(i8);
                        i10 += i6 + i7 + i8;
                        break;
                    }
                case 48:
                    i8 = td.s((List) unsafe.getObject(t, A));
                    if (i8 <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(t, (long) i3, i8);
                        }
                        i7 = xb.x(i13);
                        i6 = xb.z(i8);
                        i10 += i6 + i7 + i8;
                        break;
                    }
                case 49:
                    i4 = td.i(i13, (List) unsafe.getObject(t, A), n(i12));
                    i10 += i4;
                    break;
                case 50:
                    i4 = this.q.f(i13, unsafe.getObject(t, A), m(i12));
                    i10 += i4;
                    break;
                case 51:
                    if (s(t, i13, i12)) {
                        i4 = xb.e(i13, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (s(t, i13, i12)) {
                        i4 = xb.i(i13, 0.0f);
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (s(t, i13, i12)) {
                        i4 = xb.m(i13, F(t, A));
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (s(t, i13, i12)) {
                        i4 = xb.A(i13, F(t, A));
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (s(t, i13, i12)) {
                        i4 = xb.k(i13, E(t, A));
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (s(t, i13, i12)) {
                        i4 = xb.h(i13, 0);
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (s(t, i13, i12)) {
                        i4 = xb.g(i13, 0);
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (s(t, i13, i12)) {
                        i4 = xb.b(i13, true);
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (s(t, i13, i12)) {
                        Object object2 = unsafe.getObject(t, A);
                        if (object2 instanceof ub) {
                            i5 = xb.c(i13, (ub) object2);
                        } else {
                            i5 = xb.v(i13, (String) object2);
                        }
                        i10 += i5;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (s(t, i13, i12)) {
                        i4 = td.n(i13, unsafe.getObject(t, A), n(i12));
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (s(t, i13, i12)) {
                        i4 = xb.c(i13, (ub) unsafe.getObject(t, A));
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (s(t, i13, i12)) {
                        i4 = xb.y(i13, E(t, A));
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (s(t, i13, i12)) {
                        i4 = xb.f(i13, E(t, A));
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (s(t, i13, i12)) {
                        i4 = xb.p(i13, 0);
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (s(t, i13, i12)) {
                        i4 = xb.q(i13, 0);
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (s(t, i13, i12)) {
                        i4 = xb.r(i13, E(t, A));
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (s(t, i13, i12)) {
                        i4 = xb.t(i13, F(t, A));
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (s(t, i13, i12)) {
                        i4 = xb.j(i13, (dd) unsafe.getObject(t, A), n(i12));
                        i10 += i4;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int i15 = 0;
        yd<?, ?> ydVar = this.o;
        int h2 = ydVar.h(ydVar.g(t)) + i10;
        if (!this.f) {
            return h2;
        }
        gc<?> c2 = this.p.c(t);
        for (int i16 = 0; i16 < c2.f1237a.d(); i16++) {
            Map.Entry<T, Object> c3 = c2.f1237a.c(i16);
            i15 += gc.e(c3.getKey(), c3.getValue());
        }
        for (Map.Entry<T, Object> entry : c2.f1237a.e()) {
            i15 += gc.e(entry.getKey(), entry.getValue());
        }
        return h2 + i15;
    }

    public final int p(T t) {
        int i2;
        int i3;
        int i4;
        int i5;
        Unsafe unsafe = s;
        int i6 = 0;
        for (int i7 = 0; i7 < this.f1115a.length; i7 += 3) {
            int P = P(i7);
            int O = O(P);
            int i8 = this.f1115a[i7];
            long A = A(P);
            int i9 = (O < hc.DOUBLE_LIST_PACKED.id() || O > hc.SINT64_LIST_PACKED.id()) ? 0 : this.f1115a[i7 + 2] & 1048575;
            switch (O) {
                case 0:
                    if (q(t, i7)) {
                        i2 = xb.e(i8, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (q(t, i7)) {
                        i2 = xb.i(i8, 0.0f);
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (q(t, i7)) {
                        i2 = xb.m(i8, ce.m(t, A));
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (q(t, i7)) {
                        i2 = xb.A(i8, ce.m(t, A));
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (q(t, i7)) {
                        i2 = xb.k(i8, ce.l(t, A));
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (q(t, i7)) {
                        i2 = xb.h(i8, 0);
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (q(t, i7)) {
                        i2 = xb.g(i8, 0);
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (q(t, i7)) {
                        i2 = xb.b(i8, true);
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (q(t, i7)) {
                        Object n2 = ce.n(t, A);
                        if (n2 instanceof ub) {
                            i2 = xb.c(i8, (ub) n2);
                        } else {
                            i2 = xb.v(i8, (String) n2);
                        }
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 9:
                    if (q(t, i7)) {
                        i2 = td.n(i8, ce.n(t, A), n(i7));
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (q(t, i7)) {
                        i2 = xb.c(i8, (ub) ce.n(t, A));
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (q(t, i7)) {
                        i2 = xb.y(i8, ce.l(t, A));
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (q(t, i7)) {
                        i2 = xb.f(i8, ce.l(t, A));
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (q(t, i7)) {
                        i2 = xb.p(i8, 0);
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (q(t, i7)) {
                        i2 = xb.q(i8, 0);
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (q(t, i7)) {
                        i2 = xb.r(i8, ce.l(t, A));
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (q(t, i7)) {
                        i2 = xb.t(i8, ce.m(t, A));
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (q(t, i7)) {
                        i2 = xb.j(i8, (dd) ce.n(t, A), n(i7));
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 18:
                    i2 = td.g(i8, t(t, A), false);
                    i6 += i2;
                    break;
                case 19:
                    i2 = td.e(i8, t(t, A), false);
                    i6 += i2;
                    break;
                case 20:
                    i2 = td.l(i8, t(t, A), false);
                    i6 += i2;
                    break;
                case 21:
                    i2 = td.w(i8, t(t, A), false);
                    i6 += i2;
                    break;
                case 22:
                    i2 = td.j(i8, t(t, A), false);
                    i6 += i2;
                    break;
                case 23:
                    i2 = td.g(i8, t(t, A), false);
                    i6 += i2;
                    break;
                case 24:
                    i2 = td.e(i8, t(t, A), false);
                    i6 += i2;
                    break;
                case 25:
                    i2 = td.a(i8, t(t, A), false);
                    i6 += i2;
                    break;
                case 26:
                    i2 = td.t(i8, t(t, A));
                    i6 += i2;
                    break;
                case 27:
                    i2 = td.o(i8, t(t, A), n(i7));
                    i6 += i2;
                    break;
                case 28:
                    i2 = td.b(i8, t(t, A));
                    i6 += i2;
                    break;
                case 29:
                    i2 = td.u(i8, t(t, A), false);
                    i6 += i2;
                    break;
                case 30:
                    i2 = td.c(i8, t(t, A), false);
                    i6 += i2;
                    break;
                case 31:
                    i2 = td.e(i8, t(t, A), false);
                    i6 += i2;
                    break;
                case 32:
                    i2 = td.g(i8, t(t, A), false);
                    i6 += i2;
                    break;
                case 33:
                    i2 = td.p(i8, t(t, A), false);
                    i6 += i2;
                    break;
                case 34:
                    i2 = td.r(i8, t(t, A), false);
                    i6 += i2;
                    break;
                case 35:
                    i4 = td.h((List) unsafe.getObject(t, A));
                    if (i4 <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(t, (long) i9, i4);
                        }
                        i5 = xb.x(i8);
                        i3 = xb.z(i4);
                        i6 = i3 + i5 + i4 + i6;
                        break;
                    }
                case 36:
                    i4 = td.f((List) unsafe.getObject(t, A));
                    if (i4 <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(t, (long) i9, i4);
                        }
                        i5 = xb.x(i8);
                        i3 = xb.z(i4);
                        i6 = i3 + i5 + i4 + i6;
                        break;
                    }
                case 37:
                    i4 = td.m((List) unsafe.getObject(t, A));
                    if (i4 <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(t, (long) i9, i4);
                        }
                        i5 = xb.x(i8);
                        i3 = xb.z(i4);
                        i6 = i3 + i5 + i4 + i6;
                        break;
                    }
                case 38:
                    i4 = td.x((List) unsafe.getObject(t, A));
                    if (i4 <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(t, (long) i9, i4);
                        }
                        i5 = xb.x(i8);
                        i3 = xb.z(i4);
                        i6 = i3 + i5 + i4 + i6;
                        break;
                    }
                case 39:
                    i4 = td.k((List) unsafe.getObject(t, A));
                    if (i4 <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(t, (long) i9, i4);
                        }
                        i5 = xb.x(i8);
                        i3 = xb.z(i4);
                        i6 = i3 + i5 + i4 + i6;
                        break;
                    }
                case 40:
                    i4 = td.h((List) unsafe.getObject(t, A));
                    if (i4 <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(t, (long) i9, i4);
                        }
                        i5 = xb.x(i8);
                        i3 = xb.z(i4);
                        i6 = i3 + i5 + i4 + i6;
                        break;
                    }
                case 41:
                    i4 = td.f((List) unsafe.getObject(t, A));
                    if (i4 <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(t, (long) i9, i4);
                        }
                        i5 = xb.x(i8);
                        i3 = xb.z(i4);
                        i6 = i3 + i5 + i4 + i6;
                        break;
                    }
                case 42:
                    Class<?> cls = td.f3335a;
                    i4 = ((List) unsafe.getObject(t, A)).size();
                    if (i4 <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(t, (long) i9, i4);
                        }
                        i5 = xb.x(i8);
                        i3 = xb.z(i4);
                        i6 = i3 + i5 + i4 + i6;
                        break;
                    }
                case 43:
                    i4 = td.v((List) unsafe.getObject(t, A));
                    if (i4 <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(t, (long) i9, i4);
                        }
                        i5 = xb.x(i8);
                        i3 = xb.z(i4);
                        i6 = i3 + i5 + i4 + i6;
                        break;
                    }
                case 44:
                    i4 = td.d((List) unsafe.getObject(t, A));
                    if (i4 <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(t, (long) i9, i4);
                        }
                        i5 = xb.x(i8);
                        i3 = xb.z(i4);
                        i6 = i3 + i5 + i4 + i6;
                        break;
                    }
                case 45:
                    i4 = td.f((List) unsafe.getObject(t, A));
                    if (i4 <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(t, (long) i9, i4);
                        }
                        i5 = xb.x(i8);
                        i3 = xb.z(i4);
                        i6 = i3 + i5 + i4 + i6;
                        break;
                    }
                case 46:
                    i4 = td.h((List) unsafe.getObject(t, A));
                    if (i4 <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(t, (long) i9, i4);
                        }
                        i5 = xb.x(i8);
                        i3 = xb.z(i4);
                        i6 = i3 + i5 + i4 + i6;
                        break;
                    }
                case 47:
                    i4 = td.q((List) unsafe.getObject(t, A));
                    if (i4 <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(t, (long) i9, i4);
                        }
                        i5 = xb.x(i8);
                        i3 = xb.z(i4);
                        i6 = i3 + i5 + i4 + i6;
                        break;
                    }
                case 48:
                    i4 = td.s((List) unsafe.getObject(t, A));
                    if (i4 <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(t, (long) i9, i4);
                        }
                        i5 = xb.x(i8);
                        i3 = xb.z(i4);
                        i6 = i3 + i5 + i4 + i6;
                        break;
                    }
                case 49:
                    i2 = td.i(i8, t(t, A), n(i7));
                    i6 += i2;
                    break;
                case 50:
                    i2 = this.q.f(i8, ce.n(t, A), m(i7));
                    i6 += i2;
                    break;
                case 51:
                    if (s(t, i8, i7)) {
                        i2 = xb.e(i8, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (s(t, i8, i7)) {
                        i2 = xb.i(i8, 0.0f);
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (s(t, i8, i7)) {
                        i2 = xb.m(i8, F(t, A));
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (s(t, i8, i7)) {
                        i2 = xb.A(i8, F(t, A));
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (s(t, i8, i7)) {
                        i2 = xb.k(i8, E(t, A));
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (s(t, i8, i7)) {
                        i2 = xb.h(i8, 0);
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (s(t, i8, i7)) {
                        i2 = xb.g(i8, 0);
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (s(t, i8, i7)) {
                        i2 = xb.b(i8, true);
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (s(t, i8, i7)) {
                        Object n3 = ce.n(t, A);
                        if (n3 instanceof ub) {
                            i2 = xb.c(i8, (ub) n3);
                        } else {
                            i2 = xb.v(i8, (String) n3);
                        }
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (s(t, i8, i7)) {
                        i2 = td.n(i8, ce.n(t, A), n(i7));
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (s(t, i8, i7)) {
                        i2 = xb.c(i8, (ub) ce.n(t, A));
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (s(t, i8, i7)) {
                        i2 = xb.y(i8, E(t, A));
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (s(t, i8, i7)) {
                        i2 = xb.f(i8, E(t, A));
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (s(t, i8, i7)) {
                        i2 = xb.p(i8, 0);
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (s(t, i8, i7)) {
                        i2 = xb.q(i8, 0);
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (s(t, i8, i7)) {
                        i2 = xb.r(i8, E(t, A));
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (s(t, i8, i7)) {
                        i2 = xb.t(i8, F(t, A));
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (s(t, i8, i7)) {
                        i2 = xb.j(i8, (dd) ce.n(t, A), n(i7));
                        i6 += i2;
                        break;
                    } else {
                        break;
                    }
            }
        }
        yd<?, ?> ydVar = this.o;
        return ydVar.h(ydVar.g(t)) + i6;
    }

    public final boolean q(T t, int i2) {
        if (this.h) {
            int i3 = this.f1115a[i2 + 1];
            long A = A(i3);
            switch (O(i3)) {
                case 0:
                    if (ce.j(t, A) != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                        return true;
                    }
                    return false;
                case 1:
                    if (ce.k(t, A) != 0.0f) {
                        return true;
                    }
                    return false;
                case 2:
                    if (ce.m(t, A) != 0) {
                        return true;
                    }
                    return false;
                case 3:
                    if (ce.m(t, A) != 0) {
                        return true;
                    }
                    return false;
                case 4:
                    if (ce.l(t, A) != 0) {
                        return true;
                    }
                    return false;
                case 5:
                    if (ce.m(t, A) != 0) {
                        return true;
                    }
                    return false;
                case 6:
                    if (ce.l(t, A) != 0) {
                        return true;
                    }
                    return false;
                case 7:
                    return ce.f(t, A);
                case 8:
                    Object n2 = ce.n(t, A);
                    if (n2 instanceof String) {
                        return !((String) n2).isEmpty();
                    }
                    if (n2 instanceof ub) {
                        return !ub.g.equals(n2);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    if (ce.n(t, A) != null) {
                        return true;
                    }
                    return false;
                case 10:
                    return !ub.g.equals(ce.n(t, A));
                case 11:
                    if (ce.l(t, A) != 0) {
                        return true;
                    }
                    return false;
                case 12:
                    if (ce.l(t, A) != 0) {
                        return true;
                    }
                    return false;
                case 13:
                    if (ce.l(t, A) != 0) {
                        return true;
                    }
                    return false;
                case 14:
                    if (ce.m(t, A) != 0) {
                        return true;
                    }
                    return false;
                case 15:
                    if (ce.l(t, A) != 0) {
                        return true;
                    }
                    return false;
                case 16:
                    if (ce.m(t, A) != 0) {
                        return true;
                    }
                    return false;
                case 17:
                    if (ce.n(t, A) != null) {
                        return true;
                    }
                    return false;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            int i4 = this.f1115a[i2 + 2];
            if ((ce.l(t, (long) (i4 & 1048575)) & (1 << (i4 >>> 20))) != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean r(T t, int i2, int i3, int i4) {
        if (this.h) {
            return q(t, i2);
        }
        return (i3 & i4) != 0;
    }

    public final boolean s(T t, int i2, int i3) {
        return ce.l(t, (long) (this.f1115a[i3 + 2] & 1048575)) == i2;
    }

    /*  JADX ERROR: StackOverflowError in pass: MarkFinallyVisitor
        java.lang.StackOverflowError
        	at jadx.core.dex.instructions.IfNode.isSame(IfNode.java:122)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.sameInsns(MarkFinallyVisitor.java:451)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.compareBlocks(MarkFinallyVisitor.java:436)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:408)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:411)
        */
    public final <UT, UB, ET extends defpackage.gc.a<ET>> void u(defpackage.yd<UT, UB> r17, defpackage.dc<ET> r18, T r19, defpackage.qd r20, defpackage.cc r21) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 1720
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.fd.u(yd, dc, java.lang.Object, qd, cc):void");
    }

    public final <K, V> void v(Object obj, int i2, Object obj2, cc ccVar, qd qdVar) throws IOException {
        long A = A(this.f1115a[i2 + 1]);
        Object n2 = ce.n(obj, A);
        if (n2 == null) {
            n2 = this.q.e(obj2);
            ce.f.q(obj, A, n2);
        } else if (this.q.g(n2)) {
            Object e2 = this.q.e(obj2);
            this.q.a(e2, n2);
            ce.f.q(obj, A, e2);
            n2 = e2;
        }
        qdVar.K(this.q.d(n2), this.q.c(obj2), ccVar);
    }

    public final void w(T t, T t2, int i2) {
        long A = A(this.f1115a[i2 + 1]);
        if (q(t2, i2)) {
            Object n2 = ce.n(t, A);
            Object n3 = ce.n(t2, A);
            if (n2 != null && n3 != null) {
                ce.f.q(t, A, mc.c(n2, n3));
                M(t, i2);
            } else if (n3 != null) {
                ce.f.q(t, A, n3);
                M(t, i2);
            }
        }
    }

    public final void x(T t, T t2, int i2) {
        int[] iArr = this.f1115a;
        int i3 = iArr[i2 + 1];
        int i4 = iArr[i2];
        long A = A(i3);
        if (s(t2, i4, i2)) {
            Object n2 = ce.n(t, A);
            Object n3 = ce.n(t2, A);
            if (n2 != null && n3 != null) {
                ce.f.q(t, A, mc.c(n2, n3));
                N(t, i4, i2);
            } else if (n3 != null) {
                ce.f.q(t, A, n3);
                N(t, i4, i2);
            }
        }
    }
}
