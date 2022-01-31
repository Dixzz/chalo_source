package defpackage;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.RandomAccess;

/* renamed from: om2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class om2 {

    /* renamed from: a  reason: collision with root package name */
    public static final Class<?> f2710a;
    public static final zm2<?, ?> b = v(false);
    public static final zm2<?, ?> c = v(true);
    public static final zm2<?, ?> d = new bn2();

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        f2710a = cls;
    }

    public static int A(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof rl2) {
            rl2 rl2 = (rl2) list;
            i = 0;
            while (i2 < size) {
                i += n93.c(n93.h(rl2.d(i2)));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += n93.c(n93.h(list.get(i2).longValue()));
                i2++;
            }
        }
        return i;
    }

    public static int B(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (n93.B(i) * size) + A(list);
    }

    public static int C(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof fa3) {
            fa3 fa3 = (fa3) list;
            i = 0;
            while (i2 < size) {
                i += n93.C(fa3.d(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += n93.C(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static int D(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (n93.B(i) * size) + C(list);
    }

    public static int E(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof fa3) {
            fa3 fa3 = (fa3) list;
            i = 0;
            while (i2 < size) {
                i += n93.C(fa3.d(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += n93.C(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static int F(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (n93.B(i) * size) + E(list);
    }

    public static int G(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof fa3) {
            fa3 fa3 = (fa3) list;
            i = 0;
            while (i2 < size) {
                i += n93.b(fa3.d(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += n93.b(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static int H(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (n93.B(i) * size) + G(list);
    }

    public static int I(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof fa3) {
            fa3 fa3 = (fa3) list;
            i = 0;
            while (i2 < size) {
                i += n93.b(n93.g(fa3.d(i2)));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += n93.b(n93.g(list.get(i2).intValue()));
                i2++;
            }
        }
        return i;
    }

    public static int J(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (n93.B(i) * size) + I(list);
    }

    public static int K(List<?> list) {
        return list.size() * 4;
    }

    /* JADX WARN: Incorrect args count in method signature: (ILjava/util/List<*>;Z)I */
    public static int L(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (n93.B(i) + 4) * size;
    }

    public static int M(List<?> list) {
        return list.size() * 8;
    }

    /* JADX WARN: Incorrect args count in method signature: (ILjava/util/List<*>;Z)I */
    public static int N(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (n93.B(i) + 8) * size;
    }

    public static int O(int i, List<?> list) {
        int i2;
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        int B = n93.B(i) * size;
        if (list instanceof nl2) {
            nl2 nl2 = (nl2) list;
            while (i4 < size) {
                Object Z0 = nl2.Z0(i4);
                if (Z0 instanceof g93) {
                    i3 = n93.e((g93) Z0);
                } else {
                    i3 = n93.d((String) Z0);
                }
                B = i3 + B;
                i4++;
            }
        } else {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof g93) {
                    i2 = n93.e((g93) obj);
                } else {
                    i2 = n93.d((String) obj);
                }
                B = i2 + B;
                i4++;
            }
        }
        return B;
    }

    public static int P(int i, Object obj, mm2 mm2) {
        if (obj instanceof oa3) {
            int B = n93.B(i);
            int a2 = ((oa3) obj).a();
            return n93.b(a2) + a2 + B;
        }
        return n93.f((bm2) obj, mm2) + n93.B(i);
    }

    public static int Q(int i, List<?> list, mm2 mm2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int B = n93.B(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            if (obj instanceof oa3) {
                int a2 = ((oa3) obj).a();
                B += n93.b(a2) + a2;
            } else {
                B = n93.f((bm2) obj, mm2) + B;
            }
        }
        return B;
    }

    public static int R(int i, List<g93> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int B = n93.B(i) * size;
        for (int i2 = 0; i2 < list.size(); i2++) {
            B += n93.e(list.get(i2));
        }
        return B;
    }

    public static int S(int i, List<bm2> list, mm2 mm2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += n93.j(i, list.get(i3), mm2);
        }
        return i2;
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static <UT, UB> UB b(int i, List<Integer> list, ia3 ia3, UB ub, zm2<UT, UB> zm2) {
        if (ia3 == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = list.get(i3).intValue();
                if (ia3.zza()) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    if (ub == null) {
                        ub = zm2.g();
                    }
                    zm2.b(ub, i, (long) intValue);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
                return ub;
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!ia3.zza()) {
                    if (ub == null) {
                        ub = zm2.g();
                    }
                    zm2.b(ub, i, (long) intValue2);
                    it.remove();
                }
            }
        }
        return ub;
    }

    public static <UT, UB> UB c(int i, int i2, UB ub, zm2<UT, UB> zm2) {
        if (ub == null) {
            ub = zm2.g();
        }
        zm2.b(ub, i, (long) i2);
        return ub;
    }

    public static void d(int i, List<Double> list, o93 o93, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            Objects.requireNonNull(o93);
            int i2 = 0;
            if (z) {
                o93.f2666a.k(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    list.get(i4).doubleValue();
                    i3 += 8;
                }
                o93.f2666a.x(i3);
                while (i2 < list.size()) {
                    o93.f2666a.A(Double.doubleToRawLongBits(list.get(i2).doubleValue()));
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                o93.f2666a.q(i, Double.doubleToRawLongBits(list.get(i2).doubleValue()));
                i2++;
            }
        }
    }

    public static void e(int i, List<Float> list, o93 o93, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            Objects.requireNonNull(o93);
            int i2 = 0;
            if (z) {
                o93.f2666a.k(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    list.get(i4).floatValue();
                    i3 += 4;
                }
                o93.f2666a.x(i3);
                while (i2 < list.size()) {
                    o93.f2666a.y(Float.floatToRawIntBits(list.get(i2).floatValue()));
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                o93.f2666a.n(i, Float.floatToRawIntBits(list.get(i2).floatValue()));
                i2++;
            }
        }
    }

    public static void f(int i, List<Long> list, o93 o93, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            Objects.requireNonNull(o93);
            int i2 = 0;
            if (z) {
                o93.f2666a.k(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += n93.c(list.get(i4).longValue());
                }
                o93.f2666a.x(i3);
                while (i2 < list.size()) {
                    o93.f2666a.z(list.get(i2).longValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                o93.f2666a.o(i, list.get(i2).longValue());
                i2++;
            }
        }
    }

    public static void g(int i, List<Long> list, o93 o93, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            Objects.requireNonNull(o93);
            int i2 = 0;
            if (z) {
                o93.f2666a.k(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += n93.c(list.get(i4).longValue());
                }
                o93.f2666a.x(i3);
                while (i2 < list.size()) {
                    o93.f2666a.z(list.get(i2).longValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                o93.f2666a.o(i, list.get(i2).longValue());
                i2++;
            }
        }
    }

    public static void h(int i, List<Long> list, o93 o93, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            Objects.requireNonNull(o93);
            int i2 = 0;
            if (z) {
                o93.f2666a.k(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += n93.c(n93.h(list.get(i4).longValue()));
                }
                o93.f2666a.x(i3);
                while (i2 < list.size()) {
                    o93.f2666a.z(n93.h(list.get(i2).longValue()));
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                o93.f2666a.o(i, n93.h(list.get(i2).longValue()));
                i2++;
            }
        }
    }

    public static void i(int i, List<Long> list, o93 o93, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            Objects.requireNonNull(o93);
            int i2 = 0;
            if (z) {
                o93.f2666a.k(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    list.get(i4).longValue();
                    i3 += 8;
                }
                o93.f2666a.x(i3);
                while (i2 < list.size()) {
                    o93.f2666a.A(list.get(i2).longValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                o93.f2666a.q(i, list.get(i2).longValue());
                i2++;
            }
        }
    }

    public static void j(int i, List<Long> list, o93 o93, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            Objects.requireNonNull(o93);
            int i2 = 0;
            if (z) {
                o93.f2666a.k(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    list.get(i4).longValue();
                    i3 += 8;
                }
                o93.f2666a.x(i3);
                while (i2 < list.size()) {
                    o93.f2666a.A(list.get(i2).longValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                o93.f2666a.q(i, list.get(i2).longValue());
                i2++;
            }
        }
    }

    public static void k(int i, List<Integer> list, o93 o93, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            Objects.requireNonNull(o93);
            int i2 = 0;
            if (z) {
                o93.f2666a.k(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += n93.C(list.get(i4).intValue());
                }
                o93.f2666a.x(i3);
                while (i2 < list.size()) {
                    o93.f2666a.w(list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                o93.f2666a.l(i, list.get(i2).intValue());
                i2++;
            }
        }
    }

    public static void l(int i, List<Integer> list, o93 o93, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            Objects.requireNonNull(o93);
            int i2 = 0;
            if (z) {
                o93.f2666a.k(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += n93.b(list.get(i4).intValue());
                }
                o93.f2666a.x(i3);
                while (i2 < list.size()) {
                    o93.f2666a.x(list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                o93.f2666a.m(i, list.get(i2).intValue());
                i2++;
            }
        }
    }

    public static void m(int i, List<Integer> list, o93 o93, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            Objects.requireNonNull(o93);
            int i2 = 0;
            if (z) {
                o93.f2666a.k(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += n93.b(n93.g(list.get(i4).intValue()));
                }
                o93.f2666a.x(i3);
                while (i2 < list.size()) {
                    o93.f2666a.x(n93.g(list.get(i2).intValue()));
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                o93.f2666a.m(i, n93.g(list.get(i2).intValue()));
                i2++;
            }
        }
    }

    public static void n(int i, List<Integer> list, o93 o93, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            Objects.requireNonNull(o93);
            int i2 = 0;
            if (z) {
                o93.f2666a.k(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    list.get(i4).intValue();
                    i3 += 4;
                }
                o93.f2666a.x(i3);
                while (i2 < list.size()) {
                    o93.f2666a.y(list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                o93.f2666a.n(i, list.get(i2).intValue());
                i2++;
            }
        }
    }

    public static void o(int i, List<Integer> list, o93 o93, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            Objects.requireNonNull(o93);
            int i2 = 0;
            if (z) {
                o93.f2666a.k(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    list.get(i4).intValue();
                    i3 += 4;
                }
                o93.f2666a.x(i3);
                while (i2 < list.size()) {
                    o93.f2666a.y(list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                o93.f2666a.n(i, list.get(i2).intValue());
                i2++;
            }
        }
    }

    public static void p(int i, List<Integer> list, o93 o93, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            Objects.requireNonNull(o93);
            int i2 = 0;
            if (z) {
                o93.f2666a.k(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += n93.C(list.get(i4).intValue());
                }
                o93.f2666a.x(i3);
                while (i2 < list.size()) {
                    o93.f2666a.w(list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                o93.f2666a.l(i, list.get(i2).intValue());
                i2++;
            }
        }
    }

    public static void q(int i, List<Boolean> list, o93 o93, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            Objects.requireNonNull(o93);
            int i2 = 0;
            if (z) {
                o93.f2666a.k(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    list.get(i4).booleanValue();
                    i3++;
                }
                o93.f2666a.x(i3);
                while (i2 < list.size()) {
                    o93.f2666a.v(list.get(i2).booleanValue() ? (byte) 1 : 0);
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                o93.f2666a.r(i, list.get(i2).booleanValue());
                i2++;
            }
        }
    }

    public static void r(int i, List<String> list, o93 o93) throws IOException {
        if (list != null && !list.isEmpty()) {
            Objects.requireNonNull(o93);
            int i2 = 0;
            if (list instanceof nl2) {
                nl2 nl2 = (nl2) list;
                while (i2 < list.size()) {
                    Object Z0 = nl2.Z0(i2);
                    if (Z0 instanceof String) {
                        o93.f2666a.s(i, (String) Z0);
                    } else {
                        o93.f2666a.t(i, (g93) Z0);
                    }
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                o93.f2666a.s(i, list.get(i2));
                i2++;
            }
        }
    }

    public static void s(int i, List<g93> list, o93 o93) throws IOException {
        if (!(list == null || list.isEmpty())) {
            Objects.requireNonNull(o93);
            for (int i2 = 0; i2 < list.size(); i2++) {
                o93.f2666a.t(i, list.get(i2));
            }
        }
    }

    public static void t(int i, List<?> list, o93 o93, mm2 mm2) throws IOException {
        if (!(list == null || list.isEmpty())) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                o93.f2666a.u(i, (bm2) list.get(i2), mm2);
            }
        }
    }

    public static void u(int i, List<?> list, o93 o93, mm2 mm2) throws IOException {
        if (!(list == null || list.isEmpty())) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                o93.f(i, list.get(i2), mm2);
            }
        }
    }

    public static zm2<?, ?> v(boolean z) {
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
            return (zm2) cls.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static int w(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof rl2) {
            rl2 rl2 = (rl2) list;
            i = 0;
            while (i2 < size) {
                i += n93.c(rl2.d(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += n93.c(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX WARN: Incorrect args count in method signature: (ILjava/util/List<Ljava/lang/Long;>;Z)I */
    public static int x(int i, List list) {
        if (list.size() == 0) {
            return 0;
        }
        return (n93.B(i) * list.size()) + w(list);
    }

    public static int y(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof rl2) {
            rl2 rl2 = (rl2) list;
            i = 0;
            while (i2 < size) {
                i += n93.c(rl2.d(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += n93.c(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static int z(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (n93.B(i) * size) + y(list);
    }
}
