package defpackage;

import defpackage.m05;
import defpackage.s05;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.logging.Logger;

/* renamed from: z15  reason: default package */
/* compiled from: SchemaUtil */
public final class z15 {

    /* renamed from: a  reason: collision with root package name */
    public static final Class<?> f4109a;
    public static final e25<?, ?> b = A(false);
    public static final e25<?, ?> c = A(true);
    public static final e25<?, ?> d = new g25();

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessageV3");
        } catch (Throwable unused) {
            cls = null;
        }
        f4109a = cls;
    }

    public static e25<?, ?> A(boolean z) {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            return (e25) cls.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static <T, FT extends m05.a<FT>> void B(j05<FT> j05, T t, T t2) {
        m05<FT> c2 = j05.c(t2);
        if (!c2.i()) {
            m05<FT> d2 = j05.d(t);
            Objects.requireNonNull(d2);
            for (int i = 0; i < c2.f2304a.d(); i++) {
                d2.n(c2.f2304a.c(i));
            }
            for (Object obj : c2.f2304a.e()) {
                d2.n((Map.Entry) obj);
            }
        }
    }

    public static boolean C(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static <UT, UB> UB D(int i, int i2, UB ub, e25<UT, UB> e25) {
        if (ub == null) {
            ub = e25.m();
        }
        e25.e(ub, i, (long) i2);
        return ub;
    }

    public static void E(int i, List<Boolean> list, n25 n25, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            e05 e05 = (e05) n25;
            Objects.requireNonNull(e05);
            int i2 = 0;
            if (z) {
                e05.f912a.W(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    list.get(i4).booleanValue();
                    Logger logger = d05.b;
                    i3++;
                }
                e05.f912a.Y(i3);
                while (i2 < list.size()) {
                    e05.f912a.F(list.get(i2).booleanValue() ? (byte) 1 : 0);
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                e05.f912a.G(i, list.get(i2).booleanValue());
                i2++;
            }
        }
    }

    public static void F(int i, List<a05> list, n25 n25) throws IOException {
        if (!(list == null || list.isEmpty())) {
            e05 e05 = (e05) n25;
            Objects.requireNonNull(e05);
            for (int i2 = 0; i2 < list.size(); i2++) {
                e05.f912a.I(i, list.get(i2));
            }
        }
    }

    public static void G(int i, List<Double> list, n25 n25, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            e05 e05 = (e05) n25;
            Objects.requireNonNull(e05);
            int i2 = 0;
            if (z) {
                e05.f912a.W(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    list.get(i4).doubleValue();
                    Logger logger = d05.b;
                    i3 += 8;
                }
                e05.f912a.Y(i3);
                while (i2 < list.size()) {
                    d05 d05 = e05.f912a;
                    double doubleValue = list.get(i2).doubleValue();
                    Objects.requireNonNull(d05);
                    d05.N(Double.doubleToRawLongBits(doubleValue));
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                d05 d052 = e05.f912a;
                double doubleValue2 = list.get(i2).doubleValue();
                Objects.requireNonNull(d052);
                d052.M(i, Double.doubleToRawLongBits(doubleValue2));
                i2++;
            }
        }
    }

    public static void H(int i, List<Integer> list, n25 n25, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            e05 e05 = (e05) n25;
            Objects.requireNonNull(e05);
            int i2 = 0;
            if (z) {
                e05.f912a.W(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += d05.l(list.get(i4).intValue());
                }
                e05.f912a.Y(i3);
                while (i2 < list.size()) {
                    e05.f912a.P(list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                e05.f912a.O(i, list.get(i2).intValue());
                i2++;
            }
        }
    }

    public static void I(int i, List<Integer> list, n25 n25, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            e05 e05 = (e05) n25;
            Objects.requireNonNull(e05);
            int i2 = 0;
            if (z) {
                e05.f912a.W(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    list.get(i4).intValue();
                    Logger logger = d05.b;
                    i3 += 4;
                }
                e05.f912a.Y(i3);
                while (i2 < list.size()) {
                    e05.f912a.L(list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                e05.f912a.K(i, list.get(i2).intValue());
                i2++;
            }
        }
    }

    public static void J(int i, List<Long> list, n25 n25, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            e05 e05 = (e05) n25;
            Objects.requireNonNull(e05);
            int i2 = 0;
            if (z) {
                e05.f912a.W(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    list.get(i4).longValue();
                    Logger logger = d05.b;
                    i3 += 8;
                }
                e05.f912a.Y(i3);
                while (i2 < list.size()) {
                    e05.f912a.N(list.get(i2).longValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                e05.f912a.M(i, list.get(i2).longValue());
                i2++;
            }
        }
    }

    public static void K(int i, List<Float> list, n25 n25, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            e05 e05 = (e05) n25;
            Objects.requireNonNull(e05);
            int i2 = 0;
            if (z) {
                e05.f912a.W(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    list.get(i4).floatValue();
                    Logger logger = d05.b;
                    i3 += 4;
                }
                e05.f912a.Y(i3);
                while (i2 < list.size()) {
                    d05 d05 = e05.f912a;
                    float floatValue = list.get(i2).floatValue();
                    Objects.requireNonNull(d05);
                    d05.L(Float.floatToRawIntBits(floatValue));
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                d05 d052 = e05.f912a;
                float floatValue2 = list.get(i2).floatValue();
                Objects.requireNonNull(d052);
                d052.K(i, Float.floatToRawIntBits(floatValue2));
                i2++;
            }
        }
    }

    public static void L(int i, List<?> list, n25 n25, x15 x15) throws IOException {
        if (!(list == null || list.isEmpty())) {
            e05 e05 = (e05) n25;
            Objects.requireNonNull(e05);
            for (int i2 = 0; i2 < list.size(); i2++) {
                e05.c(i, list.get(i2), x15);
            }
        }
    }

    public static void M(int i, List<Integer> list, n25 n25, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            e05 e05 = (e05) n25;
            Objects.requireNonNull(e05);
            int i2 = 0;
            if (z) {
                e05.f912a.W(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += d05.l(list.get(i4).intValue());
                }
                e05.f912a.Y(i3);
                while (i2 < list.size()) {
                    e05.f912a.P(list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                e05.f912a.O(i, list.get(i2).intValue());
                i2++;
            }
        }
    }

    public static void N(int i, List<Long> list, n25 n25, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            e05 e05 = (e05) n25;
            Objects.requireNonNull(e05);
            int i2 = 0;
            if (z) {
                e05.f912a.W(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += d05.B(list.get(i4).longValue());
                }
                e05.f912a.Y(i3);
                while (i2 < list.size()) {
                    e05.f912a.a0(list.get(i2).longValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                e05.f912a.Z(i, list.get(i2).longValue());
                i2++;
            }
        }
    }

    public static void O(int i, List<?> list, n25 n25, x15 x15) throws IOException {
        if (!(list == null || list.isEmpty())) {
            e05 e05 = (e05) n25;
            Objects.requireNonNull(e05);
            for (int i2 = 0; i2 < list.size(); i2++) {
                e05.f912a.Q(i, (j15) list.get(i2), x15);
            }
        }
    }

    public static void P(int i, List<Integer> list, n25 n25, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            e05 e05 = (e05) n25;
            Objects.requireNonNull(e05);
            int i2 = 0;
            if (z) {
                e05.f912a.W(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    list.get(i4).intValue();
                    Logger logger = d05.b;
                    i3 += 4;
                }
                e05.f912a.Y(i3);
                while (i2 < list.size()) {
                    e05.f912a.L(list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                e05.f912a.K(i, list.get(i2).intValue());
                i2++;
            }
        }
    }

    public static void Q(int i, List<Long> list, n25 n25, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            e05 e05 = (e05) n25;
            Objects.requireNonNull(e05);
            int i2 = 0;
            if (z) {
                e05.f912a.W(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    list.get(i4).longValue();
                    Logger logger = d05.b;
                    i3 += 8;
                }
                e05.f912a.Y(i3);
                while (i2 < list.size()) {
                    e05.f912a.N(list.get(i2).longValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                e05.f912a.M(i, list.get(i2).longValue());
                i2++;
            }
        }
    }

    public static void R(int i, List<Integer> list, n25 n25, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            e05 e05 = (e05) n25;
            Objects.requireNonNull(e05);
            int i2 = 0;
            if (z) {
                e05.f912a.W(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += d05.s(list.get(i4).intValue());
                }
                e05.f912a.Y(i3);
                while (i2 < list.size()) {
                    e05.f912a.Y(d05.C(list.get(i2).intValue()));
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                e05.f912a.X(i, d05.C(list.get(i2).intValue()));
                i2++;
            }
        }
    }

    public static void S(int i, List<Long> list, n25 n25, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            e05 e05 = (e05) n25;
            Objects.requireNonNull(e05);
            int i2 = 0;
            if (z) {
                e05.f912a.W(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += d05.u(list.get(i4).longValue());
                }
                e05.f912a.Y(i3);
                while (i2 < list.size()) {
                    e05.f912a.a0(d05.D(list.get(i2).longValue()));
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                e05.f912a.Z(i, d05.D(list.get(i2).longValue()));
                i2++;
            }
        }
    }

    public static void T(int i, List<String> list, n25 n25) throws IOException {
        if (list != null && !list.isEmpty()) {
            e05 e05 = (e05) n25;
            Objects.requireNonNull(e05);
            int i2 = 0;
            if (list instanceof y05) {
                y05 y05 = (y05) list;
                while (i2 < list.size()) {
                    Object a2 = y05.a(i2);
                    if (a2 instanceof String) {
                        e05.f912a.U(i, (String) a2);
                    } else {
                        e05.f912a.I(i, (a05) a2);
                    }
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                e05.f912a.U(i, list.get(i2));
                i2++;
            }
        }
    }

    public static void U(int i, List<Integer> list, n25 n25, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            e05 e05 = (e05) n25;
            Objects.requireNonNull(e05);
            int i2 = 0;
            if (z) {
                e05.f912a.W(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += d05.z(list.get(i4).intValue());
                }
                e05.f912a.Y(i3);
                while (i2 < list.size()) {
                    e05.f912a.Y(list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                e05.f912a.X(i, list.get(i2).intValue());
                i2++;
            }
        }
    }

    public static void V(int i, List<Long> list, n25 n25, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            e05 e05 = (e05) n25;
            Objects.requireNonNull(e05);
            int i2 = 0;
            if (z) {
                e05.f912a.W(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += d05.B(list.get(i4).longValue());
                }
                e05.f912a.Y(i3);
                while (i2 < list.size()) {
                    e05.f912a.a0(list.get(i2).longValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                e05.f912a.Z(i, list.get(i2).longValue());
                i2++;
            }
        }
    }

    public static int a(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (!z) {
            return d05.b(i, true) * size;
        }
        return d05.o(size) + d05.x(i);
    }

    public static int b(int i, List<a05> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int x = d05.x(i) * size;
        for (int i2 = 0; i2 < list.size(); i2++) {
            x += d05.d(list.get(i2));
        }
        return x;
    }

    public static int c(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int d2 = d(list);
        if (!z) {
            return (d05.x(i) * size) + d2;
        }
        return d05.o(d2) + d05.x(i);
    }

    public static int d(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof r05) {
            r05 r05 = (r05) list;
            i = 0;
            while (i2 < size) {
                i += d05.l(r05.k(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += d05.l(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static int e(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (!z) {
            return d05.g(i, 0) * size;
        }
        return d05.o(size * 4) + d05.x(i);
    }

    public static int f(List<?> list) {
        return list.size() * 4;
    }

    public static int g(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (!z) {
            return d05.h(i, 0) * size;
        }
        return d05.o(size * 8) + d05.x(i);
    }

    public static int h(List<?> list) {
        return list.size() * 8;
    }

    public static int i(int i, List<j15> list, x15 x15) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += d05.j(i, list.get(i3), x15);
        }
        return i2;
    }

    public static int j(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int k = k(list);
        if (!z) {
            return (d05.x(i) * size) + k;
        }
        return d05.o(k) + d05.x(i);
    }

    public static int k(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof r05) {
            r05 r05 = (r05) list;
            i = 0;
            while (i2 < size) {
                i += d05.l(r05.k(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += d05.l(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static int l(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        int m = m(list);
        if (z) {
            return d05.o(m) + d05.x(i);
        }
        return (d05.x(i) * list.size()) + m;
    }

    public static int m(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof a15) {
            a15 a15 = (a15) list;
            i = 0;
            while (i2 < size) {
                i += d05.B(a15.k(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += d05.B(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static int n(int i, Object obj, x15 x15) {
        int x;
        int o;
        if (obj instanceof w05) {
            x = d05.x(i);
            o = d05.n((w05) obj);
        } else {
            x = d05.x(i);
            o = d05.o(((rz4) ((j15) obj)).getSerializedSize(x15));
        }
        return o + x;
    }

    public static int o(int i, List<?> list, x15 x15) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int x = d05.x(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            if (obj instanceof w05) {
                x = d05.n((w05) obj) + x;
            } else {
                x += d05.o(((rz4) ((j15) obj)).getSerializedSize(x15));
            }
        }
        return x;
    }

    public static int p(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int q = q(list);
        if (!z) {
            return (d05.x(i) * size) + q;
        }
        return d05.o(q) + d05.x(i);
    }

    public static int q(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof r05) {
            r05 r05 = (r05) list;
            i = 0;
            while (i2 < size) {
                i += d05.s(r05.k(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += d05.s(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static int r(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int s = s(list);
        if (!z) {
            return (d05.x(i) * size) + s;
        }
        return d05.o(s) + d05.x(i);
    }

    public static int s(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof a15) {
            a15 a15 = (a15) list;
            i = 0;
            while (i2 < size) {
                i += d05.u(a15.k(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += d05.u(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static int t(int i, List<?> list) {
        int i2;
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        int x = d05.x(i) * size;
        if (list instanceof y05) {
            y05 y05 = (y05) list;
            while (i4 < size) {
                Object a2 = y05.a(i4);
                if (a2 instanceof a05) {
                    i3 = d05.d((a05) a2);
                } else {
                    i3 = d05.w((String) a2);
                }
                x = i3 + x;
                i4++;
            }
        } else {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof a05) {
                    i2 = d05.d((a05) obj);
                } else {
                    i2 = d05.w((String) obj);
                }
                x = i2 + x;
                i4++;
            }
        }
        return x;
    }

    public static int u(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int v = v(list);
        if (!z) {
            return (d05.x(i) * size) + v;
        }
        return d05.o(v) + d05.x(i);
    }

    public static int v(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof r05) {
            r05 r05 = (r05) list;
            i = 0;
            while (i2 < size) {
                i += d05.z(r05.k(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += d05.z(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static int w(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int x = x(list);
        if (!z) {
            return (d05.x(i) * size) + x;
        }
        return d05.o(x) + d05.x(i);
    }

    public static int x(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof a15) {
            a15 a15 = (a15) list;
            i = 0;
            while (i2 < size) {
                i += d05.B(a15.k(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += d05.B(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static <UT, UB> UB y(int i, List<Integer> list, s05.d<?> dVar, UB ub, e25<UT, UB> e25) {
        if (dVar == null) {
            return ub;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            int intValue = list.get(i3).intValue();
            if (dVar.findValueByNumber(intValue) != null) {
                if (i3 != i2) {
                    list.set(i2, Integer.valueOf(intValue));
                }
                i2++;
            } else {
                if (ub == null) {
                    ub = e25.m();
                }
                e25.e(ub, i, (long) intValue);
            }
        }
        if (i2 != size) {
            list.subList(i2, size).clear();
        }
        return ub;
    }

    public static <UT, UB> UB z(int i, List<Integer> list, s05.e eVar, UB ub, e25<UT, UB> e25) {
        if (eVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = list.get(i3).intValue();
                if (eVar.isInRange(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    if (ub == null) {
                        ub = e25.m();
                    }
                    e25.e(ub, i, (long) intValue);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!eVar.isInRange(intValue2)) {
                    if (ub == null) {
                        ub = e25.m();
                    }
                    e25.e(ub, i, (long) intValue2);
                    it.remove();
                }
            }
        }
        return ub;
    }
}
