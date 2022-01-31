package defpackage;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

/* renamed from: ri2  reason: default package */
public final class ri2 {

    /* renamed from: a  reason: collision with root package name */
    public static final Class<?> f3084a;
    public static final dj2<?, ?> b = r(false);
    public static final dj2<?, ?> c = r(true);
    public static final dj2<?, ?> d = new fj2();

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        f3084a = cls;
    }

    public static int A(List<?> list) {
        return list.size() << 2;
    }

    public static void B(int i, List<Integer> list, xj2 xj2, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            dg2 dg2 = (dg2) xj2;
            Objects.requireNonNull(dg2);
            int i2 = 0;
            if (z) {
                dg2.f832a.p(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += bg2.Y(list.get(i4).intValue());
                }
                dg2.f832a.V(i3);
                while (i2 < list.size()) {
                    dg2.f832a.U(list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                dg2.f832a.A(i, list.get(i2).intValue());
                i2++;
            }
        }
    }

    public static int C(List<?> list) {
        return list.size() << 3;
    }

    public static void D(int i, List<Integer> list, xj2 xj2, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            dg2 dg2 = (dg2) xj2;
            Objects.requireNonNull(dg2);
            int i2 = 0;
            if (z) {
                dg2.f832a.p(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += bg2.Z(list.get(i4).intValue());
                }
                dg2.f832a.V(i3);
                while (i2 < list.size()) {
                    dg2.f832a.V(list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                dg2.f832a.D(i, list.get(i2).intValue());
                i2++;
            }
        }
    }

    public static void E(int i, List<Integer> list, xj2 xj2, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            dg2 dg2 = (dg2) xj2;
            Objects.requireNonNull(dg2);
            int i2 = 0;
            if (z) {
                dg2.f832a.p(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += bg2.a0(list.get(i4).intValue());
                }
                dg2.f832a.V(i3);
                while (i2 < list.size()) {
                    dg2.f832a.V(bg2.b0(list.get(i2).intValue()));
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                dg2.f832a.D(i, bg2.b0(list.get(i2).intValue()));
                i2++;
            }
        }
    }

    public static void F(int i, List<Integer> list, xj2 xj2, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            dg2 dg2 = (dg2) xj2;
            Objects.requireNonNull(dg2);
            int i2 = 0;
            if (z) {
                dg2.f832a.p(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    list.get(i4).intValue();
                    Logger logger = bg2.b;
                    i3 += 4;
                }
                dg2.f832a.V(i3);
                while (i2 < list.size()) {
                    dg2.f832a.W(list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                dg2.f832a.I(i, list.get(i2).intValue());
                i2++;
            }
        }
    }

    public static void G(int i, List<Integer> list, xj2 xj2, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            dg2 dg2 = (dg2) xj2;
            Objects.requireNonNull(dg2);
            int i2 = 0;
            if (z) {
                dg2.f832a.p(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    list.get(i4).intValue();
                    Logger logger = bg2.b;
                    i3 += 4;
                }
                dg2.f832a.V(i3);
                while (i2 < list.size()) {
                    dg2.f832a.W(list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                dg2.f832a.I(i, list.get(i2).intValue());
                i2++;
            }
        }
    }

    public static void H(int i, List<Integer> list, xj2 xj2, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            dg2 dg2 = (dg2) xj2;
            Objects.requireNonNull(dg2);
            int i2 = 0;
            if (z) {
                dg2.f832a.p(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += bg2.Y(list.get(i4).intValue());
                }
                dg2.f832a.V(i3);
                while (i2 < list.size()) {
                    dg2.f832a.U(list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                dg2.f832a.A(i, list.get(i2).intValue());
                i2++;
            }
        }
    }

    public static void I(int i, List<Boolean> list, xj2 xj2, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            dg2 dg2 = (dg2) xj2;
            Objects.requireNonNull(dg2);
            int i2 = 0;
            if (z) {
                dg2.f832a.p(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    list.get(i4).booleanValue();
                    Logger logger = bg2.b;
                    i3++;
                }
                dg2.f832a.V(i3);
                while (i2 < list.size()) {
                    dg2.f832a.d(list.get(i2).booleanValue() ? (byte) 1 : 0);
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                dg2.f832a.s(i, list.get(i2).booleanValue());
                i2++;
            }
        }
    }

    /* JADX WARN: Incorrect args count in method signature: (ILjava/util/List<Ljava/lang/Long;>;Z)I */
    public static int J(int i, List list) {
        if (list.size() == 0) {
            return 0;
        }
        return (bg2.X(i) * list.size()) + a(list);
    }

    /* JADX WARN: Incorrect args count in method signature: (ILjava/util/List<Ljava/lang/Long;>;Z)I */
    public static int K(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (bg2.X(i) * size) + f(list);
    }

    /* JADX WARN: Incorrect args count in method signature: (ILjava/util/List<Ljava/lang/Long;>;Z)I */
    public static int L(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (bg2.X(i) * size) + m(list);
    }

    /* JADX WARN: Incorrect args count in method signature: (ILjava/util/List<Ljava/lang/Integer;>;Z)I */
    public static int M(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (bg2.X(i) * size) + q(list);
    }

    /* JADX WARN: Incorrect args count in method signature: (ILjava/util/List<Ljava/lang/Integer;>;Z)I */
    public static int N(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (bg2.X(i) * size) + u(list);
    }

    /* JADX WARN: Incorrect args count in method signature: (ILjava/util/List<Ljava/lang/Integer;>;Z)I */
    public static int O(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (bg2.X(i) * size) + w(list);
    }

    /* JADX WARN: Incorrect args count in method signature: (ILjava/util/List<Ljava/lang/Integer;>;Z)I */
    public static int P(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (bg2.X(i) * size) + y(list);
    }

    /* JADX WARN: Incorrect args count in method signature: (ILjava/util/List<*>;Z)I */
    public static int Q(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return bg2.Q(i) * size;
    }

    /* JADX WARN: Incorrect args count in method signature: (ILjava/util/List<*>;Z)I */
    public static int R(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return bg2.J(i) * size;
    }

    public static int a(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof oh2) {
            oh2 oh2 = (oh2) list;
            i = 0;
            while (i2 < size) {
                i += bg2.H(oh2.d(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += bg2.H(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static void b(int i, List<String> list, xj2 xj2) throws IOException {
        if (list != null && !list.isEmpty()) {
            dg2 dg2 = (dg2) xj2;
            Objects.requireNonNull(dg2);
            int i2 = 0;
            if (list instanceof jh2) {
                jh2 jh2 = (jh2) list;
                while (i2 < list.size()) {
                    Object a2 = jh2.a(i2);
                    if (a2 instanceof String) {
                        dg2.f832a.i(i, (String) a2);
                    } else {
                        dg2.f832a.f(i, (uf2) a2);
                    }
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                dg2.f832a.i(i, list.get(i2));
                i2++;
            }
        }
    }

    public static void c(int i, List<?> list, xj2 xj2, pi2 pi2) throws IOException {
        if (!(list == null || list.isEmpty())) {
            dg2 dg2 = (dg2) xj2;
            Objects.requireNonNull(dg2);
            for (int i2 = 0; i2 < list.size(); i2++) {
                dg2.f832a.h(i, (zh2) list.get(i2), pi2);
            }
        }
    }

    public static void d(int i, List<Double> list, xj2 xj2, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            dg2 dg2 = (dg2) xj2;
            Objects.requireNonNull(dg2);
            int i2 = 0;
            if (z) {
                dg2.f832a.p(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    list.get(i4).doubleValue();
                    Logger logger = bg2.b;
                    i3 += 8;
                }
                dg2.f832a.V(i3);
                while (i2 < list.size()) {
                    bg2 bg2 = dg2.f832a;
                    double doubleValue = list.get(i2).doubleValue();
                    Objects.requireNonNull(bg2);
                    bg2.E(Double.doubleToRawLongBits(doubleValue));
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                bg2 bg22 = dg2.f832a;
                double doubleValue2 = list.get(i2).doubleValue();
                Objects.requireNonNull(bg22);
                bg22.B(i, Double.doubleToRawLongBits(doubleValue2));
                i2++;
            }
        }
    }

    public static <T, FT extends og2<FT>> void e(hg2<FT> hg2, T t, T t2) {
        lg2<FT> b2 = hg2.b(t2);
        if (!b2.a()) {
            lg2<FT> d2 = hg2.d(t);
            Objects.requireNonNull(d2);
            for (int i = 0; i < b2.f2212a.e(); i++) {
                d2.j(b2.f2212a.c(i));
            }
            for (Object obj : b2.f2212a.f()) {
                d2.j((Map.Entry) obj);
            }
        }
    }

    public static int f(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof oh2) {
            oh2 oh2 = (oh2) list;
            i = 0;
            while (i2 < size) {
                i += bg2.H(oh2.d(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += bg2.H(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static void g(int i, List<uf2> list, xj2 xj2) throws IOException {
        if (!(list == null || list.isEmpty())) {
            dg2 dg2 = (dg2) xj2;
            Objects.requireNonNull(dg2);
            for (int i2 = 0; i2 < list.size(); i2++) {
                dg2.f832a.f(i, list.get(i2));
            }
        }
    }

    public static void h(int i, List<?> list, xj2 xj2, pi2 pi2) throws IOException {
        if (!(list == null || list.isEmpty())) {
            dg2 dg2 = (dg2) xj2;
            Objects.requireNonNull(dg2);
            for (int i2 = 0; i2 < list.size(); i2++) {
                dg2.f(i, list.get(i2), pi2);
            }
        }
    }

    public static void i(int i, List<Float> list, xj2 xj2, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            dg2 dg2 = (dg2) xj2;
            Objects.requireNonNull(dg2);
            int i2 = 0;
            if (z) {
                dg2.f832a.p(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    list.get(i4).floatValue();
                    Logger logger = bg2.b;
                    i3 += 4;
                }
                dg2.f832a.V(i3);
                while (i2 < list.size()) {
                    bg2 bg2 = dg2.f832a;
                    float floatValue = list.get(i2).floatValue();
                    Objects.requireNonNull(bg2);
                    bg2.W(Float.floatToRawIntBits(floatValue));
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                bg2 bg22 = dg2.f832a;
                float floatValue2 = list.get(i2).floatValue();
                Objects.requireNonNull(bg22);
                bg22.I(i, Float.floatToRawIntBits(floatValue2));
                i2++;
            }
        }
    }

    public static int j(int i, Object obj, pi2 pi2) {
        if (obj instanceof hh2) {
            int X = bg2.X(i);
            int a2 = ((hh2) obj).a();
            return bg2.Z(a2) + a2 + X;
        }
        return bg2.o((zh2) obj, pi2) + bg2.X(i);
    }

    public static int k(int i, List<?> list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int X = bg2.X(i) * size;
        if (list instanceof jh2) {
            jh2 jh2 = (jh2) list;
            while (i2 < size) {
                Object a2 = jh2.a(i2);
                X = (a2 instanceof uf2 ? bg2.n((uf2) a2) : bg2.O((String) a2)) + X;
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                X = (obj instanceof uf2 ? bg2.n((uf2) obj) : bg2.O((String) obj)) + X;
                i2++;
            }
        }
        return X;
    }

    public static int l(int i, List<?> list, pi2 pi2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int X = bg2.X(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            if (obj instanceof hh2) {
                int a2 = ((hh2) obj).a();
                X += bg2.Z(a2) + a2;
            } else {
                X = bg2.o((zh2) obj, pi2) + X;
            }
        }
        return X;
    }

    public static int m(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof oh2) {
            oh2 oh2 = (oh2) list;
            i = 0;
            while (i2 < size) {
                i += bg2.L(oh2.d(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += bg2.L(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static void n(int i, List<Long> list, xj2 xj2, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            dg2 dg2 = (dg2) xj2;
            Objects.requireNonNull(dg2);
            int i2 = 0;
            if (z) {
                dg2.f832a.p(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += bg2.H(list.get(i4).longValue());
                }
                dg2.f832a.V(i3);
                while (i2 < list.size()) {
                    dg2.f832a.t(list.get(i2).longValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                dg2.f832a.e(i, list.get(i2).longValue());
                i2++;
            }
        }
    }

    public static int o(int i, List<uf2> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int X = bg2.X(i) * size;
        for (int i2 = 0; i2 < list.size(); i2++) {
            X += bg2.n(list.get(i2));
        }
        return X;
    }

    public static int p(int i, List<zh2> list, pi2 pi2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += bg2.y(i, list.get(i3), pi2);
        }
        return i2;
    }

    public static int q(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof vg2) {
            vg2 vg2 = (vg2) list;
            i = 0;
            while (i2 < size) {
                i += bg2.Y(vg2.d(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += bg2.Y(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static dj2<?, ?> r(boolean z) {
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
            return (dj2) cls.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static void s(int i, List<Long> list, xj2 xj2, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            dg2 dg2 = (dg2) xj2;
            Objects.requireNonNull(dg2);
            int i2 = 0;
            if (z) {
                dg2.f832a.p(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += bg2.H(list.get(i4).longValue());
                }
                dg2.f832a.V(i3);
                while (i2 < list.size()) {
                    dg2.f832a.t(list.get(i2).longValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                dg2.f832a.e(i, list.get(i2).longValue());
                i2++;
            }
        }
    }

    public static boolean t(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int u(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof vg2) {
            vg2 vg2 = (vg2) list;
            i = 0;
            while (i2 < size) {
                i += bg2.Y(vg2.d(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += bg2.Y(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static void v(int i, List<Long> list, xj2 xj2, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            dg2 dg2 = (dg2) xj2;
            Objects.requireNonNull(dg2);
            int i2 = 0;
            if (z) {
                dg2.f832a.p(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += bg2.L(list.get(i4).longValue());
                }
                dg2.f832a.V(i3);
                while (i2 < list.size()) {
                    dg2.f832a.t(bg2.R(list.get(i2).longValue()));
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                dg2.f832a.e(i, bg2.R(list.get(i2).longValue()));
                i2++;
            }
        }
    }

    public static int w(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof vg2) {
            vg2 vg2 = (vg2) list;
            i = 0;
            while (i2 < size) {
                i += bg2.Z(vg2.d(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += bg2.Z(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static void x(int i, List<Long> list, xj2 xj2, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            dg2 dg2 = (dg2) xj2;
            Objects.requireNonNull(dg2);
            int i2 = 0;
            if (z) {
                dg2.f832a.p(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    list.get(i4).longValue();
                    Logger logger = bg2.b;
                    i3 += 8;
                }
                dg2.f832a.V(i3);
                while (i2 < list.size()) {
                    dg2.f832a.E(list.get(i2).longValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                dg2.f832a.B(i, list.get(i2).longValue());
                i2++;
            }
        }
    }

    public static int y(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof vg2) {
            vg2 vg2 = (vg2) list;
            i = 0;
            while (i2 < size) {
                i += bg2.a0(vg2.d(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += bg2.a0(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static void z(int i, List<Long> list, xj2 xj2, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            dg2 dg2 = (dg2) xj2;
            Objects.requireNonNull(dg2);
            int i2 = 0;
            if (z) {
                dg2.f832a.p(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    list.get(i4).longValue();
                    Logger logger = bg2.b;
                    i3 += 8;
                }
                dg2.f832a.V(i3);
                while (i2 < list.size()) {
                    dg2.f832a.E(list.get(i2).longValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                dg2.f832a.B(i, list.get(i2).longValue());
                i2++;
            }
        }
    }
}
