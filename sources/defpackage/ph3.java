package defpackage;

import defpackage.rh3;
import defpackage.uh3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/* renamed from: ph3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class ph3<T extends rh3<T>> {
    public static final ph3 d = new ph3(true);

    /* renamed from: a  reason: collision with root package name */
    public final xj3<T, Object> f2805a = new wj3(16);
    public boolean b;
    public boolean c;

    public ph3(boolean z) {
        int i = xj3.l;
        g();
        g();
    }

    public static int c(uk3 uk3, int i, Object obj) {
        int Q = hh3.Q(i);
        if (uk3 == uk3.GROUP) {
            gj3 gj3 = (gj3) obj;
            if (gj3 instanceof rg3) {
                rg3 rg3 = (rg3) gj3;
            }
            Q <<= 1;
        }
        return i(uk3, obj) + Q;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0027, code lost:
        if ((r3 instanceof defpackage.ai3) == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0030, code lost:
        if ((r3 instanceof byte[]) == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001e, code lost:
        if ((r3 instanceof defpackage.gi3) == false) goto L_0x0016;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void f(defpackage.uk3 r2, java.lang.Object r3) {
        /*
        // Method dump skipped, instructions count: 102
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ph3.f(uk3, java.lang.Object):void");
    }

    public static int h(rh3<?> rh3, Object obj) {
        uk3 O = rh3.O();
        int n = rh3.n();
        if (!rh3.H()) {
            return c(O, n, obj);
        }
        int i = 0;
        if (rh3.e()) {
            for (Object obj2 : (List) obj) {
                i += i(O, obj2);
            }
            return hh3.Q(n) + i + hh3.S(i);
        }
        for (Object obj3 : (List) obj) {
            i += c(O, n, obj3);
        }
        return i;
    }

    public static int i(uk3 uk3, Object obj) {
        int r;
        int S;
        switch (oh3.b[uk3.ordinal()]) {
            case 1:
                ((Double) obj).doubleValue();
                Logger logger = hh3.b;
                return 8;
            case 2:
                ((Float) obj).floatValue();
                Logger logger2 = hh3.b;
                return 4;
            case 3:
                return hh3.A(((Long) obj).longValue());
            case 4:
                return hh3.A(((Long) obj).longValue());
            case 5:
                return hh3.R(((Integer) obj).intValue());
            case 6:
                ((Long) obj).longValue();
                Logger logger3 = hh3.b;
                return 8;
            case 7:
                ((Integer) obj).intValue();
                Logger logger4 = hh3.b;
                return 4;
            case 8:
                ((Boolean) obj).booleanValue();
                Logger logger5 = hh3.b;
                return 1;
            case 9:
                Logger logger6 = hh3.b;
                return ((gj3) obj).r();
            case 10:
                if (!(obj instanceof gi3)) {
                    Logger logger7 = hh3.b;
                    r = ((gj3) obj).r();
                    S = hh3.S(r);
                    break;
                } else {
                    Logger logger8 = hh3.b;
                    r = ((gi3) obj).b();
                    S = hh3.S(r);
                    break;
                }
            case 11:
                if (obj instanceof xg3) {
                    return hh3.k((xg3) obj);
                }
                return hh3.O((String) obj);
            case 12:
                if (!(obj instanceof xg3)) {
                    Logger logger9 = hh3.b;
                    r = ((byte[]) obj).length;
                    S = hh3.S(r);
                    break;
                } else {
                    return hh3.k((xg3) obj);
                }
            case 13:
                return hh3.S(((Integer) obj).intValue());
            case 14:
                ((Integer) obj).intValue();
                Logger logger10 = hh3.b;
                return 4;
            case 15:
                ((Long) obj).longValue();
                Logger logger11 = hh3.b;
                return 8;
            case 16:
                return hh3.T(((Integer) obj).intValue());
            case 17:
                return hh3.E(((Long) obj).longValue());
            case 18:
                if (obj instanceof ai3) {
                    return hh3.R(((ai3) obj).n());
                }
                return hh3.R(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
        return S + r;
    }

    public static <T extends rh3<T>> boolean j(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.B() == bl3.MESSAGE) {
            if (key.H()) {
                for (gj3 gj3 : (List) entry.getValue()) {
                    if (!gj3.isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof gj3) {
                    if (!((gj3) value).isInitialized()) {
                        return false;
                    }
                } else if (value instanceof gi3) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public static int l(Map.Entry<T, Object> entry) {
        int G;
        int Q;
        int r;
        int S;
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.B() != bl3.MESSAGE || key.H() || key.e()) {
            return h(key, value);
        }
        if (value instanceof gi3) {
            G = hh3.G(2, entry.getKey().n()) + (hh3.Q(1) << 1);
            Q = hh3.Q(3);
            r = ((gi3) value).b();
            S = hh3.S(r);
        } else {
            G = hh3.G(2, entry.getKey().n()) + (hh3.Q(1) << 1);
            Q = hh3.Q(3);
            r = ((gj3) value).r();
            S = hh3.S(r);
        }
        return S + r + Q + G;
    }

    public static Object m(Object obj) {
        if (obj instanceof lj3) {
            return ((lj3) obj).n();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public final boolean a() {
        for (int i = 0; i < this.f2805a.f(); i++) {
            if (!j(this.f2805a.d(i))) {
                return false;
            }
        }
        for (Map.Entry<T, Object> entry : this.f2805a.g()) {
            if (!j(entry)) {
                return false;
            }
        }
        return true;
    }

    public final Iterator<Map.Entry<T, Object>> b() {
        if (this.c) {
            return new li3(this.f2805a.entrySet().iterator());
        }
        return this.f2805a.entrySet().iterator();
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        ph3 ph3 = new ph3();
        for (int i = 0; i < this.f2805a.f(); i++) {
            Map.Entry<T, Object> d2 = this.f2805a.d(i);
            ph3.e(d2.getKey(), d2.getValue());
        }
        for (Map.Entry<T, Object> entry : this.f2805a.g()) {
            ph3.e(entry.getKey(), entry.getValue());
        }
        ph3.c = this.c;
        return ph3;
    }

    public final Object d(T t) {
        Object obj = this.f2805a.get(t);
        if (!(obj instanceof gi3)) {
            return obj;
        }
        gi3 gi3 = (gi3) obj;
        int i = gi3.c;
        throw new NoSuchMethodError();
    }

    public final void e(T t, Object obj) {
        if (!t.H()) {
            f(t.O(), obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList.get(i);
                i++;
                f(t.O(), obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof gi3) {
            this.c = true;
        }
        this.f2805a.put(t, obj);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ph3)) {
            return false;
        }
        return this.f2805a.equals(((ph3) obj).f2805a);
    }

    public final void g() {
        if (!this.b) {
            this.f2805a.c();
            this.b = true;
        }
    }

    public final int hashCode() {
        return this.f2805a.hashCode();
    }

    public final void k(Map.Entry<T, Object> entry) {
        gj3 gj3;
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof gi3) {
            gi3 gi3 = (gi3) value;
            int i = gi3.c;
            throw new NoSuchMethodError();
        } else if (key.H()) {
            Object d2 = d(key);
            if (d2 == null) {
                d2 = new ArrayList();
            }
            for (Object obj : (List) value) {
                ((List) d2).add(m(obj));
            }
            this.f2805a.put(key, d2);
        } else if (key.B() == bl3.MESSAGE) {
            Object d3 = d(key);
            if (d3 == null) {
                this.f2805a.put(key, m(value));
                return;
            }
            if (d3 instanceof lj3) {
                gj3 = key.C((lj3) d3, (lj3) value);
            } else {
                gj3 = ((uh3.b) key.F(((gj3) d3).s(), (gj3) value)).f();
            }
            this.f2805a.put(key, gj3);
        } else {
            this.f2805a.put(key, m(value));
        }
    }

    public ph3() {
        int i = xj3.l;
    }
}
