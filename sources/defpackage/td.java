package defpackage;

import defpackage.gc;
import defpackage.mc;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.logging.Logger;

/* renamed from: td  reason: default package */
/* compiled from: SchemaUtil */
public final class td {

    /* renamed from: a  reason: collision with root package name */
    public static final Class<?> f3335a;
    public static final yd<?, ?> b = z(false);
    public static final yd<?, ?> c = z(true);
    public static final yd<?, ?> d = new ae();

    static {
        Class<?> cls;
        try {
            cls = Class.forName("androidx.datastore.preferences.protobuf.GeneratedMessageV3");
        } catch (Throwable unused) {
            cls = null;
        }
        f3335a = cls;
    }

    public static <T, FT extends gc.a<FT>> void A(dc<FT> dcVar, T t, T t2) {
        gc<FT> c2 = dcVar.c(t2);
        if (!c2.h()) {
            gc<FT> d2 = dcVar.d(t);
            Objects.requireNonNull(d2);
            for (int i = 0; i < c2.f1237a.d(); i++) {
                d2.m(c2.f1237a.c(i));
            }
            for (Object obj : c2.f1237a.e()) {
                d2.m((Map.Entry) obj);
            }
        }
    }

    public static boolean B(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static <UT, UB> UB C(int i, int i2, UB ub, yd<UT, UB> ydVar) {
        if (ub == null) {
            ub = ydVar.m();
        }
        ydVar.e(ub, i, (long) i2);
        return ub;
    }

    public static void D(int i, List<Boolean> list, he heVar, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            yb ybVar = (yb) heVar;
            Objects.requireNonNull(ybVar);
            int i2 = 0;
            if (z) {
                ybVar.f4026a.W(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    list.get(i4).booleanValue();
                    Logger logger = xb.b;
                    i3++;
                }
                ybVar.f4026a.Y(i3);
                while (i2 < list.size()) {
                    ybVar.f4026a.F(list.get(i2).booleanValue() ? (byte) 1 : 0);
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                ybVar.f4026a.G(i, list.get(i2).booleanValue());
                i2++;
            }
        }
    }

    public static void E(int i, List<ub> list, he heVar) throws IOException {
        if (!(list == null || list.isEmpty())) {
            yb ybVar = (yb) heVar;
            Objects.requireNonNull(ybVar);
            for (int i2 = 0; i2 < list.size(); i2++) {
                ybVar.f4026a.I(i, list.get(i2));
            }
        }
    }

    public static void F(int i, List<Double> list, he heVar, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            yb ybVar = (yb) heVar;
            Objects.requireNonNull(ybVar);
            int i2 = 0;
            if (z) {
                ybVar.f4026a.W(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    list.get(i4).doubleValue();
                    Logger logger = xb.b;
                    i3 += 8;
                }
                ybVar.f4026a.Y(i3);
                while (i2 < list.size()) {
                    xb xbVar = ybVar.f4026a;
                    double doubleValue = list.get(i2).doubleValue();
                    Objects.requireNonNull(xbVar);
                    xbVar.N(Double.doubleToRawLongBits(doubleValue));
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                xb xbVar2 = ybVar.f4026a;
                double doubleValue2 = list.get(i2).doubleValue();
                Objects.requireNonNull(xbVar2);
                xbVar2.M(i, Double.doubleToRawLongBits(doubleValue2));
                i2++;
            }
        }
    }

    public static void G(int i, List<Integer> list, he heVar, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            yb ybVar = (yb) heVar;
            Objects.requireNonNull(ybVar);
            int i2 = 0;
            if (z) {
                ybVar.f4026a.W(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += xb.l(list.get(i4).intValue());
                }
                ybVar.f4026a.Y(i3);
                while (i2 < list.size()) {
                    ybVar.f4026a.P(list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                ybVar.f4026a.O(i, list.get(i2).intValue());
                i2++;
            }
        }
    }

    public static void H(int i, List<Integer> list, he heVar, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            yb ybVar = (yb) heVar;
            Objects.requireNonNull(ybVar);
            int i2 = 0;
            if (z) {
                ybVar.f4026a.W(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    list.get(i4).intValue();
                    Logger logger = xb.b;
                    i3 += 4;
                }
                ybVar.f4026a.Y(i3);
                while (i2 < list.size()) {
                    ybVar.f4026a.L(list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                ybVar.f4026a.K(i, list.get(i2).intValue());
                i2++;
            }
        }
    }

    public static void I(int i, List<Long> list, he heVar, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            yb ybVar = (yb) heVar;
            Objects.requireNonNull(ybVar);
            int i2 = 0;
            if (z) {
                ybVar.f4026a.W(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    list.get(i4).longValue();
                    Logger logger = xb.b;
                    i3 += 8;
                }
                ybVar.f4026a.Y(i3);
                while (i2 < list.size()) {
                    ybVar.f4026a.N(list.get(i2).longValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                ybVar.f4026a.M(i, list.get(i2).longValue());
                i2++;
            }
        }
    }

    public static void J(int i, List<Float> list, he heVar, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            yb ybVar = (yb) heVar;
            Objects.requireNonNull(ybVar);
            int i2 = 0;
            if (z) {
                ybVar.f4026a.W(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    list.get(i4).floatValue();
                    Logger logger = xb.b;
                    i3 += 4;
                }
                ybVar.f4026a.Y(i3);
                while (i2 < list.size()) {
                    xb xbVar = ybVar.f4026a;
                    float floatValue = list.get(i2).floatValue();
                    Objects.requireNonNull(xbVar);
                    xbVar.L(Float.floatToRawIntBits(floatValue));
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                xb xbVar2 = ybVar.f4026a;
                float floatValue2 = list.get(i2).floatValue();
                Objects.requireNonNull(xbVar2);
                xbVar2.K(i, Float.floatToRawIntBits(floatValue2));
                i2++;
            }
        }
    }

    public static void K(int i, List<?> list, he heVar, rd rdVar) throws IOException {
        if (!(list == null || list.isEmpty())) {
            yb ybVar = (yb) heVar;
            Objects.requireNonNull(ybVar);
            for (int i2 = 0; i2 < list.size(); i2++) {
                ybVar.c(i, list.get(i2), rdVar);
            }
        }
    }

    public static void L(int i, List<Integer> list, he heVar, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            yb ybVar = (yb) heVar;
            Objects.requireNonNull(ybVar);
            int i2 = 0;
            if (z) {
                ybVar.f4026a.W(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += xb.l(list.get(i4).intValue());
                }
                ybVar.f4026a.Y(i3);
                while (i2 < list.size()) {
                    ybVar.f4026a.P(list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                ybVar.f4026a.O(i, list.get(i2).intValue());
                i2++;
            }
        }
    }

    public static void M(int i, List<Long> list, he heVar, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            yb ybVar = (yb) heVar;
            Objects.requireNonNull(ybVar);
            int i2 = 0;
            if (z) {
                ybVar.f4026a.W(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += xb.B(list.get(i4).longValue());
                }
                ybVar.f4026a.Y(i3);
                while (i2 < list.size()) {
                    ybVar.f4026a.a0(list.get(i2).longValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                ybVar.f4026a.Z(i, list.get(i2).longValue());
                i2++;
            }
        }
    }

    public static void N(int i, List<?> list, he heVar, rd rdVar) throws IOException {
        if (!(list == null || list.isEmpty())) {
            yb ybVar = (yb) heVar;
            Objects.requireNonNull(ybVar);
            for (int i2 = 0; i2 < list.size(); i2++) {
                ybVar.f4026a.Q(i, (dd) list.get(i2), rdVar);
            }
        }
    }

    public static void O(int i, List<Integer> list, he heVar, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            yb ybVar = (yb) heVar;
            Objects.requireNonNull(ybVar);
            int i2 = 0;
            if (z) {
                ybVar.f4026a.W(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    list.get(i4).intValue();
                    Logger logger = xb.b;
                    i3 += 4;
                }
                ybVar.f4026a.Y(i3);
                while (i2 < list.size()) {
                    ybVar.f4026a.L(list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                ybVar.f4026a.K(i, list.get(i2).intValue());
                i2++;
            }
        }
    }

    public static void P(int i, List<Long> list, he heVar, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            yb ybVar = (yb) heVar;
            Objects.requireNonNull(ybVar);
            int i2 = 0;
            if (z) {
                ybVar.f4026a.W(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    list.get(i4).longValue();
                    Logger logger = xb.b;
                    i3 += 8;
                }
                ybVar.f4026a.Y(i3);
                while (i2 < list.size()) {
                    ybVar.f4026a.N(list.get(i2).longValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                ybVar.f4026a.M(i, list.get(i2).longValue());
                i2++;
            }
        }
    }

    public static void Q(int i, List<Integer> list, he heVar, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            yb ybVar = (yb) heVar;
            Objects.requireNonNull(ybVar);
            int i2 = 0;
            if (z) {
                ybVar.f4026a.W(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += xb.s(list.get(i4).intValue());
                }
                ybVar.f4026a.Y(i3);
                while (i2 < list.size()) {
                    ybVar.f4026a.Y(xb.C(list.get(i2).intValue()));
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                ybVar.f4026a.X(i, xb.C(list.get(i2).intValue()));
                i2++;
            }
        }
    }

    public static void R(int i, List<Long> list, he heVar, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            yb ybVar = (yb) heVar;
            Objects.requireNonNull(ybVar);
            int i2 = 0;
            if (z) {
                ybVar.f4026a.W(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += xb.u(list.get(i4).longValue());
                }
                ybVar.f4026a.Y(i3);
                while (i2 < list.size()) {
                    ybVar.f4026a.a0(xb.D(list.get(i2).longValue()));
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                ybVar.f4026a.Z(i, xb.D(list.get(i2).longValue()));
                i2++;
            }
        }
    }

    public static void S(int i, List<String> list, he heVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            yb ybVar = (yb) heVar;
            Objects.requireNonNull(ybVar);
            int i2 = 0;
            if (list instanceof sc) {
                sc scVar = (sc) list;
                while (i2 < list.size()) {
                    Object a2 = scVar.a(i2);
                    if (a2 instanceof String) {
                        ybVar.f4026a.U(i, (String) a2);
                    } else {
                        ybVar.f4026a.I(i, (ub) a2);
                    }
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                ybVar.f4026a.U(i, list.get(i2));
                i2++;
            }
        }
    }

    public static void T(int i, List<Integer> list, he heVar, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            yb ybVar = (yb) heVar;
            Objects.requireNonNull(ybVar);
            int i2 = 0;
            if (z) {
                ybVar.f4026a.W(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += xb.z(list.get(i4).intValue());
                }
                ybVar.f4026a.Y(i3);
                while (i2 < list.size()) {
                    ybVar.f4026a.Y(list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                ybVar.f4026a.X(i, list.get(i2).intValue());
                i2++;
            }
        }
    }

    public static void U(int i, List<Long> list, he heVar, boolean z) throws IOException {
        if (!(list == null || list.isEmpty())) {
            yb ybVar = (yb) heVar;
            Objects.requireNonNull(ybVar);
            int i2 = 0;
            if (z) {
                ybVar.f4026a.W(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += xb.B(list.get(i4).longValue());
                }
                ybVar.f4026a.Y(i3);
                while (i2 < list.size()) {
                    ybVar.f4026a.a0(list.get(i2).longValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                ybVar.f4026a.Z(i, list.get(i2).longValue());
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
            return xb.b(i, true) * size;
        }
        return xb.o(size) + xb.x(i);
    }

    public static int b(int i, List<ub> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int x = xb.x(i) * size;
        for (int i2 = 0; i2 < list.size(); i2++) {
            x += xb.d(list.get(i2));
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
            return (xb.x(i) * size) + d2;
        }
        return xb.o(d2) + xb.x(i);
    }

    public static int d(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof lc) {
            lc lcVar = (lc) list;
            i = 0;
            while (i2 < size) {
                i += xb.l(lcVar.k(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += xb.l(list.get(i2).intValue());
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
            return xb.g(i, 0) * size;
        }
        return xb.o(size * 4) + xb.x(i);
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
            return xb.h(i, 0) * size;
        }
        return xb.o(size * 8) + xb.x(i);
    }

    public static int h(List<?> list) {
        return list.size() * 8;
    }

    public static int i(int i, List<dd> list, rd rdVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += xb.j(i, list.get(i3), rdVar);
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
            return (xb.x(i) * size) + k;
        }
        return xb.o(k) + xb.x(i);
    }

    public static int k(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof lc) {
            lc lcVar = (lc) list;
            i = 0;
            while (i2 < size) {
                i += xb.l(lcVar.k(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += xb.l(list.get(i2).intValue());
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
            return xb.o(m) + xb.x(i);
        }
        return (xb.x(i) * list.size()) + m;
    }

    public static int m(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof uc) {
            uc ucVar = (uc) list;
            i = 0;
            while (i2 < size) {
                i += xb.B(ucVar.k(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += xb.B(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static int n(int i, Object obj, rd rdVar) {
        int x;
        int o;
        if (obj instanceof qc) {
            x = xb.x(i);
            o = xb.n((qc) obj);
        } else {
            x = xb.x(i);
            o = xb.o(((nb) ((dd) obj)).c(rdVar));
        }
        return o + x;
    }

    public static int o(int i, List<?> list, rd rdVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int x = xb.x(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            if (obj instanceof qc) {
                x = xb.n((qc) obj) + x;
            } else {
                x += xb.o(((nb) ((dd) obj)).c(rdVar));
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
            return (xb.x(i) * size) + q;
        }
        return xb.o(q) + xb.x(i);
    }

    public static int q(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof lc) {
            lc lcVar = (lc) list;
            i = 0;
            while (i2 < size) {
                i += xb.s(lcVar.k(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += xb.s(list.get(i2).intValue());
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
            return (xb.x(i) * size) + s;
        }
        return xb.o(s) + xb.x(i);
    }

    public static int s(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof uc) {
            uc ucVar = (uc) list;
            i = 0;
            while (i2 < size) {
                i += xb.u(ucVar.k(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += xb.u(list.get(i2).longValue());
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
        int x = xb.x(i) * size;
        if (list instanceof sc) {
            sc scVar = (sc) list;
            while (i4 < size) {
                Object a2 = scVar.a(i4);
                if (a2 instanceof ub) {
                    i3 = xb.d((ub) a2);
                } else {
                    i3 = xb.w((String) a2);
                }
                x = i3 + x;
                i4++;
            }
        } else {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof ub) {
                    i2 = xb.d((ub) obj);
                } else {
                    i2 = xb.w((String) obj);
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
            return (xb.x(i) * size) + v;
        }
        return xb.o(v) + xb.x(i);
    }

    public static int v(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof lc) {
            lc lcVar = (lc) list;
            i = 0;
            while (i2 < size) {
                i += xb.z(lcVar.k(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += xb.z(list.get(i2).intValue());
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
            return (xb.x(i) * size) + x;
        }
        return xb.o(x) + xb.x(i);
    }

    public static int x(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof uc) {
            uc ucVar = (uc) list;
            i = 0;
            while (i2 < size) {
                i += xb.B(ucVar.k(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += xb.B(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static <UT, UB> UB y(int i, List<Integer> list, mc.b bVar, UB ub, yd<UT, UB> ydVar) {
        if (bVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = list.get(i3).intValue();
                if (bVar.isInRange(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    if (ub == null) {
                        ub = ydVar.m();
                    }
                    ydVar.e(ub, i, (long) intValue);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!bVar.isInRange(intValue2)) {
                    if (ub == null) {
                        ub = ydVar.m();
                    }
                    ydVar.e(ub, i, (long) intValue2);
                    it.remove();
                }
            }
        }
        return ub;
    }

    public static yd<?, ?> z(boolean z) {
        Class<?> cls;
        try {
            cls = Class.forName("androidx.datastore.preferences.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            return (yd) cls.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused2) {
            return null;
        }
    }
}
