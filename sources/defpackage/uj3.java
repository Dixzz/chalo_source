package defpackage;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

/* renamed from: uj3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class uj3 {

    /* renamed from: a  reason: collision with root package name */
    public static final Class<?> f3513a;
    public static final gk3<?, ?> b = A(false);
    public static final gk3<?, ?> c = A(true);
    public static final gk3<?, ?> d = new ik3();

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        f3513a = cls;
    }

    public static gk3<?, ?> A(boolean z) {
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
            return (gk3) cls.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static void B(int i, List<Integer> list, al3 al3, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            jh3 jh3 = (jh3) al3;
            Objects.requireNonNull(jh3);
            int i2 = 0;
            if (z) {
                jh3.f1925a.l(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += hh3.R(list.get(i4).intValue());
                }
                jh3.f1925a.N(i3);
                while (i2 < list.size()) {
                    jh3.f1925a.M(list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                jh3.f1925a.t(i, list.get(i2).intValue());
                i2++;
            }
        }
    }

    public static int C(List<?> list) {
        return list.size() << 3;
    }

    public static void D(int i, List<Integer> list, al3 al3, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            jh3 jh3 = (jh3) al3;
            Objects.requireNonNull(jh3);
            int i2 = 0;
            if (z) {
                jh3.f1925a.l(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += hh3.S(list.get(i4).intValue());
                }
                jh3.f1925a.N(i3);
                while (i2 < list.size()) {
                    jh3.f1925a.N(list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                jh3.f1925a.w(i, list.get(i2).intValue());
                i2++;
            }
        }
    }

    public static void E(int i, List<Integer> list, al3 al3, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            jh3 jh3 = (jh3) al3;
            Objects.requireNonNull(jh3);
            int i2 = 0;
            if (z) {
                jh3.f1925a.l(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += hh3.T(list.get(i4).intValue());
                }
                jh3.f1925a.N(i3);
                while (i2 < list.size()) {
                    jh3.f1925a.N(hh3.U(list.get(i2).intValue()));
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                jh3.f1925a.w(i, hh3.U(list.get(i2).intValue()));
                i2++;
            }
        }
    }

    public static void F(int i, List<Integer> list, al3 al3, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            jh3 jh3 = (jh3) al3;
            Objects.requireNonNull(jh3);
            int i2 = 0;
            if (z) {
                jh3.f1925a.l(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    list.get(i4).intValue();
                    Logger logger = hh3.b;
                    i3 += 4;
                }
                jh3.f1925a.N(i3);
                while (i2 < list.size()) {
                    jh3.f1925a.P(list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                jh3.f1925a.B(i, list.get(i2).intValue());
                i2++;
            }
        }
    }

    public static void G(int i, List<Integer> list, al3 al3, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            jh3 jh3 = (jh3) al3;
            Objects.requireNonNull(jh3);
            int i2 = 0;
            if (z) {
                jh3.f1925a.l(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    list.get(i4).intValue();
                    Logger logger = hh3.b;
                    i3 += 4;
                }
                jh3.f1925a.N(i3);
                while (i2 < list.size()) {
                    jh3.f1925a.P(list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                jh3.f1925a.B(i, list.get(i2).intValue());
                i2++;
            }
        }
    }

    public static void H(int i, List<Integer> list, al3 al3, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            jh3 jh3 = (jh3) al3;
            Objects.requireNonNull(jh3);
            int i2 = 0;
            if (z) {
                jh3.f1925a.l(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += hh3.R(list.get(i4).intValue());
                }
                jh3.f1925a.N(i3);
                while (i2 < list.size()) {
                    jh3.f1925a.M(list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                jh3.f1925a.t(i, list.get(i2).intValue());
                i2++;
            }
        }
    }

    public static void I(int i, List<Boolean> list, al3 al3, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            jh3 jh3 = (jh3) al3;
            Objects.requireNonNull(jh3);
            int i2 = 0;
            if (z) {
                jh3.f1925a.l(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    list.get(i4).booleanValue();
                    Logger logger = hh3.b;
                    i3++;
                }
                jh3.f1925a.N(i3);
                while (i2 < list.size()) {
                    jh3.f1925a.s(list.get(i2).booleanValue() ? (byte) 1 : 0);
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                jh3.f1925a.g(i, list.get(i2).booleanValue());
                i2++;
            }
        }
    }

    /* JADX WARN: Incorrect args count in method signature: (ILjava/util/List<Ljava/lang/Long;>;Z)I */
    public static int J(int i, List list) {
        if (list.size() == 0) {
            return 0;
        }
        return (hh3.Q(i) * list.size()) + a(list);
    }

    /* JADX WARN: Incorrect args count in method signature: (ILjava/util/List<Ljava/lang/Long;>;Z)I */
    public static int K(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (hh3.Q(i) * size) + f(list);
    }

    /* JADX WARN: Incorrect args count in method signature: (ILjava/util/List<Ljava/lang/Long;>;Z)I */
    public static int L(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (hh3.Q(i) * size) + m(list);
    }

    /* JADX WARN: Incorrect args count in method signature: (ILjava/util/List<Ljava/lang/Integer;>;Z)I */
    public static int M(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (hh3.Q(i) * size) + q(list);
    }

    /* JADX WARN: Incorrect args count in method signature: (ILjava/util/List<Ljava/lang/Integer;>;Z)I */
    public static int N(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (hh3.Q(i) * size) + t(list);
    }

    /* JADX WARN: Incorrect args count in method signature: (ILjava/util/List<Ljava/lang/Integer;>;Z)I */
    public static int O(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (hh3.Q(i) * size) + v(list);
    }

    /* JADX WARN: Incorrect args count in method signature: (ILjava/util/List<Ljava/lang/Integer;>;Z)I */
    public static int P(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (hh3.Q(i) * size) + x(list);
    }

    /* JADX WARN: Incorrect args count in method signature: (ILjava/util/List<*>;Z)I */
    public static int Q(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return hh3.I(i) * size;
    }

    /* JADX WARN: Incorrect args count in method signature: (ILjava/util/List<*>;Z)I */
    public static int R(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return hh3.C(i) * size;
    }

    public static int a(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof ti3) {
            ti3 ti3 = (ti3) list;
            i = 0;
            while (i2 < size) {
                i += hh3.A(ti3.d(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += hh3.A(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static void b(int i, List<String> list, al3 al3) throws IOException {
        if (list != null && !list.isEmpty()) {
            jh3 jh3 = (jh3) al3;
            Objects.requireNonNull(jh3);
            int i2 = 0;
            if (list instanceof mi3) {
                mi3 mi3 = (mi3) list;
                while (i2 < list.size()) {
                    Object w = mi3.w(i2);
                    if (w instanceof String) {
                        jh3.f1925a.f(i, (String) w);
                    } else {
                        jh3.f1925a.c(i, (xg3) w);
                    }
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                jh3.f1925a.f(i, list.get(i2));
                i2++;
            }
        }
    }

    public static void c(int i, List<?> list, al3 al3, sj3 sj3) throws IOException {
        if (!(list == null || list.isEmpty())) {
            jh3 jh3 = (jh3) al3;
            Objects.requireNonNull(jh3);
            for (int i2 = 0; i2 < list.size(); i2++) {
                jh3.f1925a.e(i, (gj3) list.get(i2), sj3);
            }
        }
    }

    public static void d(int i, List<Double> list, al3 al3, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            jh3 jh3 = (jh3) al3;
            Objects.requireNonNull(jh3);
            int i2 = 0;
            if (z) {
                jh3.f1925a.l(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    list.get(i4).doubleValue();
                    Logger logger = hh3.b;
                    i3 += 8;
                }
                jh3.f1925a.N(i3);
                while (i2 < list.size()) {
                    hh3 hh3 = jh3.f1925a;
                    double doubleValue = list.get(i2).doubleValue();
                    Objects.requireNonNull(hh3);
                    hh3.x(Double.doubleToRawLongBits(doubleValue));
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                hh3 hh32 = jh3.f1925a;
                double doubleValue2 = list.get(i2).doubleValue();
                Objects.requireNonNull(hh32);
                hh32.u(i, Double.doubleToRawLongBits(doubleValue2));
                i2++;
            }
        }
    }

    public static <T, FT extends rh3<FT>> void e(kh3<FT> kh3, T t, T t2) {
        ph3<FT> c2 = kh3.c(t2);
        if (!c2.f2805a.isEmpty()) {
            ph3<FT> d2 = kh3.d(t);
            Objects.requireNonNull(d2);
            for (int i = 0; i < c2.f2805a.f(); i++) {
                d2.k(c2.f2805a.d(i));
            }
            for (Object obj : c2.f2805a.g()) {
                d2.k((Map.Entry) obj);
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
        if (list instanceof ti3) {
            ti3 ti3 = (ti3) list;
            i = 0;
            while (i2 < size) {
                i += hh3.A(ti3.d(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += hh3.A(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static void g(int i, List<xg3> list, al3 al3) throws IOException {
        if (!(list == null || list.isEmpty())) {
            jh3 jh3 = (jh3) al3;
            Objects.requireNonNull(jh3);
            for (int i2 = 0; i2 < list.size(); i2++) {
                jh3.f1925a.c(i, list.get(i2));
            }
        }
    }

    public static void h(int i, List<?> list, al3 al3, sj3 sj3) throws IOException {
        if (!(list == null || list.isEmpty())) {
            jh3 jh3 = (jh3) al3;
            Objects.requireNonNull(jh3);
            for (int i2 = 0; i2 < list.size(); i2++) {
                jh3.f(i, list.get(i2), sj3);
            }
        }
    }

    public static void i(int i, List<Float> list, al3 al3, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            jh3 jh3 = (jh3) al3;
            Objects.requireNonNull(jh3);
            int i2 = 0;
            if (z) {
                jh3.f1925a.l(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    list.get(i4).floatValue();
                    Logger logger = hh3.b;
                    i3 += 4;
                }
                jh3.f1925a.N(i3);
                while (i2 < list.size()) {
                    hh3 hh3 = jh3.f1925a;
                    float floatValue = list.get(i2).floatValue();
                    Objects.requireNonNull(hh3);
                    hh3.P(Float.floatToRawIntBits(floatValue));
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                hh3 hh32 = jh3.f1925a;
                float floatValue2 = list.get(i2).floatValue();
                Objects.requireNonNull(hh32);
                hh32.B(i, Float.floatToRawIntBits(floatValue2));
                i2++;
            }
        }
    }

    public static int j(int i, Object obj, sj3 sj3) {
        if (obj instanceof ki3) {
            int Q = hh3.Q(i);
            int b2 = ((ki3) obj).b();
            return hh3.S(b2) + b2 + Q;
        }
        return hh3.a((gj3) obj, sj3) + hh3.Q(i);
    }

    public static int k(int i, List<?> list) {
        int i2;
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        int Q = hh3.Q(i) * size;
        if (list instanceof mi3) {
            mi3 mi3 = (mi3) list;
            while (i4 < size) {
                Object w = mi3.w(i4);
                if (w instanceof xg3) {
                    i3 = hh3.k((xg3) w);
                } else {
                    i3 = hh3.O((String) w);
                }
                Q = i3 + Q;
                i4++;
            }
        } else {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof xg3) {
                    i2 = hh3.k((xg3) obj);
                } else {
                    i2 = hh3.O((String) obj);
                }
                Q = i2 + Q;
                i4++;
            }
        }
        return Q;
    }

    public static int l(int i, List<?> list, sj3 sj3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int Q = hh3.Q(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            if (obj instanceof ki3) {
                int b2 = ((ki3) obj).b();
                Q += hh3.S(b2) + b2;
            } else {
                Q = hh3.a((gj3) obj, sj3) + Q;
            }
        }
        return Q;
    }

    public static int m(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof ti3) {
            ti3 ti3 = (ti3) list;
            i = 0;
            while (i2 < size) {
                i += hh3.E(ti3.d(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += hh3.E(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static void n(int i, List<Long> list, al3 al3, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            jh3 jh3 = (jh3) al3;
            Objects.requireNonNull(jh3);
            int i2 = 0;
            if (z) {
                jh3.f1925a.l(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += hh3.A(list.get(i4).longValue());
                }
                jh3.f1925a.N(i3);
                while (i2 < list.size()) {
                    jh3.f1925a.n(list.get(i2).longValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                jh3.f1925a.b(i, list.get(i2).longValue());
                i2++;
            }
        }
    }

    public static int o(int i, List<xg3> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int Q = hh3.Q(i) * size;
        for (int i2 = 0; i2 < list.size(); i2++) {
            Q += hh3.k(list.get(i2));
        }
        return Q;
    }

    public static int p(int i, List<gj3> list, sj3 sj3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += hh3.r(i, list.get(i3), sj3);
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
        if (list instanceof wh3) {
            wh3 wh3 = (wh3) list;
            i = 0;
            while (i2 < size) {
                i += hh3.R(wh3.d(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += hh3.R(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static void r(int i, List<Long> list, al3 al3, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            jh3 jh3 = (jh3) al3;
            Objects.requireNonNull(jh3);
            int i2 = 0;
            if (z) {
                jh3.f1925a.l(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += hh3.A(list.get(i4).longValue());
                }
                jh3.f1925a.N(i3);
                while (i2 < list.size()) {
                    jh3.f1925a.n(list.get(i2).longValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                jh3.f1925a.b(i, list.get(i2).longValue());
                i2++;
            }
        }
    }

    public static boolean s(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int t(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof wh3) {
            wh3 wh3 = (wh3) list;
            i = 0;
            while (i2 < size) {
                i += hh3.R(wh3.d(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += hh3.R(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static void u(int i, List<Long> list, al3 al3, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            jh3 jh3 = (jh3) al3;
            Objects.requireNonNull(jh3);
            int i2 = 0;
            if (z) {
                jh3.f1925a.l(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += hh3.E(list.get(i4).longValue());
                }
                jh3.f1925a.N(i3);
                while (i2 < list.size()) {
                    jh3.f1925a.n(hh3.J(list.get(i2).longValue()));
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                jh3.f1925a.b(i, hh3.J(list.get(i2).longValue()));
                i2++;
            }
        }
    }

    public static int v(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof wh3) {
            wh3 wh3 = (wh3) list;
            i = 0;
            while (i2 < size) {
                i += hh3.S(wh3.d(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += hh3.S(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static void w(int i, List<Long> list, al3 al3, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            jh3 jh3 = (jh3) al3;
            Objects.requireNonNull(jh3);
            int i2 = 0;
            if (z) {
                jh3.f1925a.l(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    list.get(i4).longValue();
                    Logger logger = hh3.b;
                    i3 += 8;
                }
                jh3.f1925a.N(i3);
                while (i2 < list.size()) {
                    jh3.f1925a.x(list.get(i2).longValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                jh3.f1925a.u(i, list.get(i2).longValue());
                i2++;
            }
        }
    }

    public static int x(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof wh3) {
            wh3 wh3 = (wh3) list;
            i = 0;
            while (i2 < size) {
                i += hh3.T(wh3.d(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += hh3.T(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static void y(int i, List<Long> list, al3 al3, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            jh3 jh3 = (jh3) al3;
            Objects.requireNonNull(jh3);
            int i2 = 0;
            if (z) {
                jh3.f1925a.l(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    list.get(i4).longValue();
                    Logger logger = hh3.b;
                    i3 += 8;
                }
                jh3.f1925a.N(i3);
                while (i2 < list.size()) {
                    jh3.f1925a.x(list.get(i2).longValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                jh3.f1925a.u(i, list.get(i2).longValue());
                i2++;
            }
        }
    }

    public static int z(List<?> list) {
        return list.size() << 2;
    }
}
