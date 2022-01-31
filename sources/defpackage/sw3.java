package defpackage;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

/* renamed from: sw3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class sw3 {

    /* renamed from: a  reason: collision with root package name */
    public static final Class<?> f3265a;
    public static final ex3<?, ?> b = e(false);
    public static final ex3<?, ?> c = e(true);
    public static final ex3<?, ?> d = new gx3();

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        f3265a = cls;
    }

    public static void A(int i, List<Long> list, wx3 wx3, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            du3 du3 = (du3) wx3;
            Objects.requireNonNull(du3);
            int i2 = 0;
            if (z) {
                du3.f889a.f(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += bu3.K(list.get(i4).longValue());
                }
                du3.f889a.r(i3);
                while (i2 < list.size()) {
                    du3.f889a.m(bu3.R(list.get(i2).longValue()));
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                du3.f889a.g(i, bu3.R(list.get(i2).longValue()));
                i2++;
            }
        }
    }

    /* JADX WARN: Incorrect args count in method signature: (ILjava/util/List<Ljava/lang/Integer;>;Z)I */
    public static int B(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (bu3.D(i) * size) + C(list);
    }

    public static int C(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof uu3) {
            uu3 uu3 = (uu3) list;
            i = 0;
            while (i2 < size) {
                i += bu3.L(uu3.e(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += bu3.L(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static void D(int i, List<Long> list, wx3 wx3, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            du3 du3 = (du3) wx3;
            Objects.requireNonNull(du3);
            int i2 = 0;
            if (z) {
                du3.f889a.f(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    list.get(i4).longValue();
                    Logger logger = bu3.b;
                    i3 += 8;
                }
                du3.f889a.r(i3);
                while (i2 < list.size()) {
                    du3.f889a.A(list.get(i2).longValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                du3.f889a.z(i, list.get(i2).longValue());
                i2++;
            }
        }
    }

    /* JADX WARN: Incorrect args count in method signature: (ILjava/util/List<Ljava/lang/Integer;>;Z)I */
    public static int E(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (bu3.D(i) * size) + F(list);
    }

    public static int F(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof uu3) {
            uu3 uu3 = (uu3) list;
            i = 0;
            while (i2 < size) {
                i += bu3.O(uu3.e(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += bu3.O(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static void G(int i, List<Long> list, wx3 wx3, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            du3 du3 = (du3) wx3;
            Objects.requireNonNull(du3);
            int i2 = 0;
            if (z) {
                du3.f889a.f(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    list.get(i4).longValue();
                    Logger logger = bu3.b;
                    i3 += 8;
                }
                du3.f889a.r(i3);
                while (i2 < list.size()) {
                    du3.f889a.A(list.get(i2).longValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                du3.f889a.z(i, list.get(i2).longValue());
                i2++;
            }
        }
    }

    /* JADX WARN: Incorrect args count in method signature: (ILjava/util/List<*>;Z)I */
    public static int H(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return bu3.S(i) * size;
    }

    public static int I(List<?> list) {
        return list.size() << 2;
    }

    public static void J(int i, List<Integer> list, wx3 wx3, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            du3 du3 = (du3) wx3;
            Objects.requireNonNull(du3);
            int i2 = 0;
            if (z) {
                du3.f889a.f(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += bu3.H(list.get(i4).intValue());
                }
                du3.f889a.r(i3);
                while (i2 < list.size()) {
                    du3.f889a.e(list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                du3.f889a.s(i, list.get(i2).intValue());
                i2++;
            }
        }
    }

    /* JADX WARN: Incorrect args count in method signature: (ILjava/util/List<*>;Z)I */
    public static int K(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return bu3.N(i) * size;
    }

    public static int L(List<?> list) {
        return list.size() << 3;
    }

    public static void M(int i, List<Integer> list, wx3 wx3, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            du3 du3 = (du3) wx3;
            Objects.requireNonNull(du3);
            int i2 = 0;
            if (z) {
                du3.f889a.f(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += bu3.L(list.get(i4).intValue());
                }
                du3.f889a.r(i3);
                while (i2 < list.size()) {
                    du3.f889a.r(list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                du3.f889a.y(i, list.get(i2).intValue());
                i2++;
            }
        }
    }

    public static void N(int i, List<Integer> list, wx3 wx3, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            du3 du3 = (du3) wx3;
            Objects.requireNonNull(du3);
            int i2 = 0;
            if (z) {
                du3.f889a.f(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += bu3.O(list.get(i4).intValue());
                }
                du3.f889a.r(i3);
                while (i2 < list.size()) {
                    du3.f889a.r(bu3.V(list.get(i2).intValue()));
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                du3.f889a.y(i, bu3.V(list.get(i2).intValue()));
                i2++;
            }
        }
    }

    public static void O(int i, List<Integer> list, wx3 wx3, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            du3 du3 = (du3) wx3;
            Objects.requireNonNull(du3);
            int i2 = 0;
            if (z) {
                du3.f889a.f(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    list.get(i4).intValue();
                    Logger logger = bu3.b;
                    i3 += 4;
                }
                du3.f889a.r(i3);
                while (i2 < list.size()) {
                    du3.f889a.C(list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                du3.f889a.G(i, list.get(i2).intValue());
                i2++;
            }
        }
    }

    public static void P(int i, List<Integer> list, wx3 wx3, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            du3 du3 = (du3) wx3;
            Objects.requireNonNull(du3);
            int i2 = 0;
            if (z) {
                du3.f889a.f(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    list.get(i4).intValue();
                    Logger logger = bu3.b;
                    i3 += 4;
                }
                du3.f889a.r(i3);
                while (i2 < list.size()) {
                    du3.f889a.C(list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                du3.f889a.G(i, list.get(i2).intValue());
                i2++;
            }
        }
    }

    public static void Q(int i, List<Integer> list, wx3 wx3, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            du3 du3 = (du3) wx3;
            Objects.requireNonNull(du3);
            int i2 = 0;
            if (z) {
                du3.f889a.f(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += bu3.H(list.get(i4).intValue());
                }
                du3.f889a.r(i3);
                while (i2 < list.size()) {
                    du3.f889a.e(list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                du3.f889a.s(i, list.get(i2).intValue());
                i2++;
            }
        }
    }

    public static void R(int i, List<Boolean> list, wx3 wx3, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            du3 du3 = (du3) wx3;
            Objects.requireNonNull(du3);
            int i2 = 0;
            if (z) {
                du3.f889a.f(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    list.get(i4).booleanValue();
                    Logger logger = bu3.b;
                    i3++;
                }
                du3.f889a.r(i3);
                while (i2 < list.size()) {
                    du3.f889a.d(list.get(i2).booleanValue() ? (byte) 1 : 0);
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                du3.f889a.l(i, list.get(i2).booleanValue());
                i2++;
            }
        }
    }

    public static int a(int i, Object obj, qw3 qw3) {
        if (obj instanceof hv3) {
            int L = bu3.L(i << 3);
            int a2 = ((hv3) obj).a();
            return bu3.L(a2) + a2 + L;
        }
        return bu3.c((cw3) obj, qw3) + bu3.L(i << 3);
    }

    public static int b(int i, List<?> list) {
        int i2;
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        int D = bu3.D(i) * size;
        if (list instanceof jv3) {
            jv3 jv3 = (jv3) list;
            while (i4 < size) {
                Object l = jv3.l(i4);
                if (l instanceof qt3) {
                    i3 = bu3.p((qt3) l);
                } else {
                    i3 = bu3.q((String) l);
                }
                D = i3 + D;
                i4++;
            }
        } else {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof qt3) {
                    i2 = bu3.p((qt3) obj);
                } else {
                    i2 = bu3.q((String) obj);
                }
                D = i2 + D;
                i4++;
            }
        }
        return D;
    }

    public static int c(int i, List<?> list, qw3 qw3) {
        int i2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int D = bu3.D(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof hv3) {
                i2 = bu3.b((hv3) obj);
            } else {
                i2 = bu3.c((cw3) obj, qw3);
            }
            D += i2;
        }
        return D;
    }

    public static int d(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof qv3) {
            qv3 qv3 = (qv3) list;
            i = 0;
            while (i2 < size) {
                i += bu3.F(qv3.e(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += bu3.F(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static ex3<?, ?> e(boolean z) {
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
            return (ex3) cls.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static void f(int i, List<String> list, wx3 wx3) throws IOException {
        if (list != null && !list.isEmpty()) {
            du3 du3 = (du3) wx3;
            Objects.requireNonNull(du3);
            int i2 = 0;
            if (list instanceof jv3) {
                jv3 jv3 = (jv3) list;
                while (i2 < list.size()) {
                    Object l = jv3.l(i2);
                    if (l instanceof String) {
                        du3.f889a.k(i, (String) l);
                    } else {
                        du3.f889a.h(i, (qt3) l);
                    }
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                du3.f889a.k(i, list.get(i2));
                i2++;
            }
        }
    }

    public static void g(int i, List<?> list, wx3 wx3, qw3 qw3) throws IOException {
        if (!(list == null || list.isEmpty())) {
            du3 du3 = (du3) wx3;
            Objects.requireNonNull(du3);
            for (int i2 = 0; i2 < list.size(); i2++) {
                du3.f889a.j(i, (cw3) list.get(i2), qw3);
            }
        }
    }

    public static void h(int i, List<Double> list, wx3 wx3, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            du3 du3 = (du3) wx3;
            Objects.requireNonNull(du3);
            int i2 = 0;
            if (z) {
                du3.f889a.f(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    list.get(i4).doubleValue();
                    Logger logger = bu3.b;
                    i3 += 8;
                }
                du3.f889a.r(i3);
                while (i2 < list.size()) {
                    bu3 bu3 = du3.f889a;
                    double doubleValue = list.get(i2).doubleValue();
                    Objects.requireNonNull(bu3);
                    bu3.A(Double.doubleToRawLongBits(doubleValue));
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                bu3 bu32 = du3.f889a;
                double doubleValue2 = list.get(i2).doubleValue();
                Objects.requireNonNull(bu32);
                bu32.z(i, Double.doubleToRawLongBits(doubleValue2));
                i2++;
            }
        }
    }

    public static <T, FT extends mu3<FT>> void i(gu3<FT> gu3, T t, T t2) {
        ku3<FT> b2 = gu3.b(t2);
        if (!b2.f2121a.isEmpty()) {
            ku3<FT> f = gu3.f(t);
            Objects.requireNonNull(f);
            for (int i = 0; i < b2.f2121a.e(); i++) {
                f.j(b2.f2121a.d(i));
            }
            for (Object obj : b2.f2121a.g()) {
                f.j((Map.Entry) obj);
            }
        }
    }

    public static boolean j(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    /* JADX WARN: Incorrect args count in method signature: (ILjava/util/List<Ljava/lang/Long;>;Z)I */
    public static int k(int i, List list) {
        if (list.size() == 0) {
            return 0;
        }
        return (bu3.D(i) * list.size()) + d(list);
    }

    public static int l(int i, List<qt3> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int D = bu3.D(i) * size;
        for (int i2 = 0; i2 < list.size(); i2++) {
            D += bu3.p(list.get(i2));
        }
        return D;
    }

    public static int m(int i, List<cw3> list, qw3 qw3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += bu3.x(i, list.get(i3), qw3);
        }
        return i2;
    }

    public static int n(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof qv3) {
            qv3 qv3 = (qv3) list;
            i = 0;
            while (i2 < size) {
                i += bu3.F(qv3.e(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += bu3.F(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static void o(int i, List<qt3> list, wx3 wx3) throws IOException {
        if (!(list == null || list.isEmpty())) {
            du3 du3 = (du3) wx3;
            Objects.requireNonNull(du3);
            for (int i2 = 0; i2 < list.size(); i2++) {
                du3.f889a.h(i, list.get(i2));
            }
        }
    }

    public static void p(int i, List<?> list, wx3 wx3, qw3 qw3) throws IOException {
        if (!(list == null || list.isEmpty())) {
            du3 du3 = (du3) wx3;
            Objects.requireNonNull(du3);
            for (int i2 = 0; i2 < list.size(); i2++) {
                du3.e(i, list.get(i2), qw3);
            }
        }
    }

    public static void q(int i, List<Float> list, wx3 wx3, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            du3 du3 = (du3) wx3;
            Objects.requireNonNull(du3);
            int i2 = 0;
            if (z) {
                du3.f889a.f(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    list.get(i4).floatValue();
                    Logger logger = bu3.b;
                    i3 += 4;
                }
                du3.f889a.r(i3);
                while (i2 < list.size()) {
                    bu3 bu3 = du3.f889a;
                    float floatValue = list.get(i2).floatValue();
                    Objects.requireNonNull(bu3);
                    bu3.C(Float.floatToRawIntBits(floatValue));
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                bu3 bu32 = du3.f889a;
                float floatValue2 = list.get(i2).floatValue();
                Objects.requireNonNull(bu32);
                bu32.G(i, Float.floatToRawIntBits(floatValue2));
                i2++;
            }
        }
    }

    /* JADX WARN: Incorrect args count in method signature: (ILjava/util/List<Ljava/lang/Long;>;Z)I */
    public static int r(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (bu3.D(i) * size) + n(list);
    }

    /* JADX WARN: Incorrect args count in method signature: (ILjava/util/List<Ljava/lang/Long;>;Z)I */
    public static int s(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (bu3.D(i) * size) + t(list);
    }

    public static int t(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof qv3) {
            qv3 qv3 = (qv3) list;
            i = 0;
            while (i2 < size) {
                i += bu3.K(qv3.e(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += bu3.K(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static void u(int i, List<Long> list, wx3 wx3, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            du3 du3 = (du3) wx3;
            Objects.requireNonNull(du3);
            int i2 = 0;
            if (z) {
                du3.f889a.f(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += bu3.F(list.get(i4).longValue());
                }
                du3.f889a.r(i3);
                while (i2 < list.size()) {
                    du3.f889a.m(list.get(i2).longValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                du3.f889a.g(i, list.get(i2).longValue());
                i2++;
            }
        }
    }

    /* JADX WARN: Incorrect args count in method signature: (ILjava/util/List<Ljava/lang/Integer;>;Z)I */
    public static int v(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (bu3.D(i) * size) + w(list);
    }

    public static int w(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof uu3) {
            uu3 uu3 = (uu3) list;
            i = 0;
            while (i2 < size) {
                i += bu3.H(uu3.e(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += bu3.H(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static void x(int i, List<Long> list, wx3 wx3, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            du3 du3 = (du3) wx3;
            Objects.requireNonNull(du3);
            int i2 = 0;
            if (z) {
                du3.f889a.f(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += bu3.F(list.get(i4).longValue());
                }
                du3.f889a.r(i3);
                while (i2 < list.size()) {
                    du3.f889a.m(list.get(i2).longValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                du3.f889a.g(i, list.get(i2).longValue());
                i2++;
            }
        }
    }

    /* JADX WARN: Incorrect args count in method signature: (ILjava/util/List<Ljava/lang/Integer;>;Z)I */
    public static int y(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (bu3.D(i) * size) + z(list);
    }

    public static int z(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof uu3) {
            uu3 uu3 = (uu3) list;
            i = 0;
            while (i2 < size) {
                i += bu3.H(uu3.e(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += bu3.H(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }
}
