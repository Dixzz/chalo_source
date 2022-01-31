package defpackage;

import defpackage.j15;
import defpackage.m05.a;
import defpackage.q05;
import defpackage.s05;
import defpackage.v05;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/* renamed from: m05  reason: default package */
/* compiled from: FieldSet */
public final class m05<T extends a<T>> {
    public static final m05 d = new m05(true);

    /* renamed from: a  reason: collision with root package name */
    public final b25<T, Object> f2304a = new a25(16);
    public boolean b;
    public boolean c;

    /* renamed from: m05$a */
    /* compiled from: FieldSet */
    public interface a<T extends a<T>> extends Comparable<T> {
        boolean b();

        l25 d();

        int getNumber();

        boolean isPacked();

        m25 s();

        j15.a y(j15.a aVar, j15 j15);
    }

    public m05(boolean z) {
        int i = b25.m;
        m();
        m();
    }

    public static Object c(Object obj) {
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public static int d(l25 l25, int i, Object obj) {
        int x = d05.x(i);
        if (l25 == l25.GROUP) {
            x *= 2;
        }
        return e(l25, obj) + x;
    }

    public static int e(l25 l25, Object obj) {
        switch (l25.ordinal()) {
            case 0:
                ((Double) obj).doubleValue();
                Logger logger = d05.b;
                return 8;
            case 1:
                ((Float) obj).floatValue();
                Logger logger2 = d05.b;
                return 4;
            case 2:
                return d05.B(((Long) obj).longValue());
            case 3:
                return d05.B(((Long) obj).longValue());
            case 4:
                return d05.l(((Integer) obj).intValue());
            case 5:
                ((Long) obj).longValue();
                Logger logger3 = d05.b;
                return 8;
            case 6:
                ((Integer) obj).intValue();
                Logger logger4 = d05.b;
                return 4;
            case 7:
                ((Boolean) obj).booleanValue();
                Logger logger5 = d05.b;
                return 1;
            case 8:
                if (obj instanceof a05) {
                    return d05.d((a05) obj);
                }
                return d05.w((String) obj);
            case 9:
                Logger logger6 = d05.b;
                return ((j15) obj).getSerializedSize();
            case 10:
                if (obj instanceof v05) {
                    return d05.n((v05) obj);
                }
                Logger logger7 = d05.b;
                return d05.o(((j15) obj).getSerializedSize());
            case 11:
                if (obj instanceof a05) {
                    return d05.d((a05) obj);
                }
                Logger logger8 = d05.b;
                return d05.o(((byte[]) obj).length);
            case 12:
                return d05.z(((Integer) obj).intValue());
            case 13:
                if (obj instanceof s05.c) {
                    return d05.l(((s05.c) obj).getNumber());
                }
                return d05.l(((Integer) obj).intValue());
            case 14:
                ((Integer) obj).intValue();
                Logger logger9 = d05.b;
                return 4;
            case 15:
                ((Long) obj).longValue();
                Logger logger10 = d05.b;
                return 8;
            case 16:
                return d05.s(((Integer) obj).intValue());
            case 17:
                return d05.u(((Long) obj).longValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int f(a<?> aVar, Object obj) {
        l25 d2 = aVar.d();
        int number = aVar.getNumber();
        if (!aVar.b()) {
            return d(d2, number, obj);
        }
        int i = 0;
        if (aVar.isPacked()) {
            for (Object obj2 : (List) obj) {
                i += e(d2, obj2);
            }
            return d05.x(number) + i + d05.z(i);
        }
        for (Object obj3 : (List) obj) {
            i += d(d2, number, obj3);
        }
        return i;
    }

    public static <T extends a<T>> boolean k(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.s() == m25.MESSAGE) {
            if (key.b()) {
                for (j15 j15 : (List) entry.getValue()) {
                    if (!j15.isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof j15) {
                    if (!((j15) value).isInitialized()) {
                        return false;
                    }
                } else if (value instanceof v05) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public static void q(d05 d05, l25 l25, int i, Object obj) throws IOException {
        if (l25 == l25.GROUP) {
            d05.W(i, 3);
            ((j15) obj).writeTo(d05);
            d05.W(i, 4);
            return;
        }
        d05.W(i, l25.getWireType());
        switch (l25.ordinal()) {
            case 0:
                d05.N(Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                return;
            case 1:
                d05.L(Float.floatToRawIntBits(((Float) obj).floatValue()));
                return;
            case 2:
                d05.a0(((Long) obj).longValue());
                return;
            case 3:
                d05.a0(((Long) obj).longValue());
                return;
            case 4:
                d05.P(((Integer) obj).intValue());
                return;
            case 5:
                d05.N(((Long) obj).longValue());
                return;
            case 6:
                d05.L(((Integer) obj).intValue());
                return;
            case 7:
                d05.F(((Boolean) obj).booleanValue() ? (byte) 1 : 0);
                return;
            case 8:
                if (obj instanceof a05) {
                    d05.J((a05) obj);
                    return;
                } else {
                    d05.V((String) obj);
                    return;
                }
            case 9:
                ((j15) obj).writeTo(d05);
                return;
            case 10:
                d05.R((j15) obj);
                return;
            case 11:
                if (obj instanceof a05) {
                    d05.J((a05) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                d05.H(bArr, 0, bArr.length);
                return;
            case 12:
                d05.Y(((Integer) obj).intValue());
                return;
            case 13:
                if (obj instanceof s05.c) {
                    d05.P(((s05.c) obj).getNumber());
                    return;
                } else {
                    d05.P(((Integer) obj).intValue());
                    return;
                }
            case 14:
                d05.L(((Integer) obj).intValue());
                return;
            case 15:
                d05.N(((Long) obj).longValue());
                return;
            case 16:
                d05.Y(d05.C(((Integer) obj).intValue()));
                return;
            case 17:
                d05.a0(d05.D(((Long) obj).longValue()));
                return;
            default:
                return;
        }
    }

    public void a(T t, Object obj) {
        List list;
        if (((q05.d) t).i) {
            p(((q05.d) t).h, obj);
            Object g = g(t);
            if (g == null) {
                list = new ArrayList();
                this.f2304a.put(t, list);
            } else {
                list = (List) g;
            }
            list.add(obj);
            return;
        }
        throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }

    /* renamed from: b */
    public m05<T> clone() {
        m05<T> m05 = new m05<>();
        for (int i = 0; i < this.f2304a.d(); i++) {
            Map.Entry<T, Object> c2 = this.f2304a.c(i);
            m05.o(c2.getKey(), c2.getValue());
        }
        for (Map.Entry<T, Object> entry : this.f2304a.e()) {
            m05.o(entry.getKey(), entry.getValue());
        }
        m05.c = this.c;
        return m05;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m05)) {
            return false;
        }
        return this.f2304a.equals(((m05) obj).f2304a);
    }

    public Object g(T t) {
        Object obj = this.f2304a.get(t);
        return obj instanceof v05 ? ((v05) obj).c() : obj;
    }

    public final int h(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.s() != m25.MESSAGE || key.b() || key.isPacked()) {
            return f(key, value);
        }
        if (value instanceof v05) {
            return d05.n((v05) value) + d05.x(3) + d05.y(2, entry.getKey().getNumber()) + (d05.x(1) * 2);
        }
        return d05.o(((j15) value).getSerializedSize()) + d05.x(3) + d05.y(2, entry.getKey().getNumber()) + (d05.x(1) * 2);
    }

    public int hashCode() {
        return this.f2304a.hashCode();
    }

    public boolean i() {
        return this.f2304a.isEmpty();
    }

    public boolean j() {
        for (int i = 0; i < this.f2304a.d(); i++) {
            if (!k(this.f2304a.c(i))) {
                return false;
            }
        }
        for (Map.Entry<T, Object> entry : this.f2304a.e()) {
            if (!k(entry)) {
                return false;
            }
        }
        return true;
    }

    public Iterator<Map.Entry<T, Object>> l() {
        if (this.c) {
            return new v05.c(this.f2304a.entrySet().iterator());
        }
        return this.f2304a.entrySet().iterator();
    }

    public void m() {
        if (!this.b) {
            this.f2304a.g();
            this.b = true;
        }
    }

    public final void n(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof v05) {
            value = ((v05) value).c();
        }
        if (key.b()) {
            Object g = g(key);
            if (g == null) {
                g = new ArrayList();
            }
            for (Object obj : (List) value) {
                ((List) g).add(c(obj));
            }
            this.f2304a.put(key, g);
        } else if (key.s() == m25.MESSAGE) {
            Object g2 = g(key);
            if (g2 == null) {
                this.f2304a.put(key, c(value));
                return;
            }
            this.f2304a.put(key, key.y(((j15) g2).toBuilder(), (j15) value).build());
        } else {
            this.f2304a.put(key, c(value));
        }
    }

    public void o(T t, Object obj) {
        if (!t.b()) {
            p(t.d(), obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                p(t.d(), it.next());
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof v05) {
            this.c = true;
        }
        this.f2304a.put(t, obj);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002b, code lost:
        if ((r4 instanceof byte[]) == false) goto L_0x002e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0019, code lost:
        if ((r4 instanceof defpackage.v05) == false) goto L_0x002e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0022, code lost:
        if ((r4 instanceof defpackage.s05.c) == false) goto L_0x002e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void p(defpackage.l25 r3, java.lang.Object r4) {
        /*
            r2 = this;
            java.nio.charset.Charset r0 = defpackage.s05.f3160a
            java.util.Objects.requireNonNull(r4)
            m25 r3 = r3.getJavaType()
            int r3 = r3.ordinal()
            r0 = 1
            r1 = 0
            switch(r3) {
                case 0: goto L_0x0040;
                case 1: goto L_0x003d;
                case 2: goto L_0x003a;
                case 3: goto L_0x0037;
                case 4: goto L_0x0034;
                case 5: goto L_0x0031;
                case 6: goto L_0x0025;
                case 7: goto L_0x001c;
                case 8: goto L_0x0013;
                default: goto L_0x0012;
            }
        L_0x0012:
            goto L_0x0042
        L_0x0013:
            boolean r3 = r4 instanceof defpackage.j15
            if (r3 != 0) goto L_0x002f
            boolean r3 = r4 instanceof defpackage.v05
            if (r3 == 0) goto L_0x002e
            goto L_0x002f
        L_0x001c:
            boolean r3 = r4 instanceof java.lang.Integer
            if (r3 != 0) goto L_0x002f
            boolean r3 = r4 instanceof defpackage.s05.c
            if (r3 == 0) goto L_0x002e
            goto L_0x002f
        L_0x0025:
            boolean r3 = r4 instanceof defpackage.a05
            if (r3 != 0) goto L_0x002f
            boolean r3 = r4 instanceof byte[]
            if (r3 == 0) goto L_0x002e
            goto L_0x002f
        L_0x002e:
            r0 = 0
        L_0x002f:
            r1 = r0
            goto L_0x0042
        L_0x0031:
            boolean r1 = r4 instanceof java.lang.String
            goto L_0x0042
        L_0x0034:
            boolean r1 = r4 instanceof java.lang.Boolean
            goto L_0x0042
        L_0x0037:
            boolean r1 = r4 instanceof java.lang.Double
            goto L_0x0042
        L_0x003a:
            boolean r1 = r4 instanceof java.lang.Float
            goto L_0x0042
        L_0x003d:
            boolean r1 = r4 instanceof java.lang.Long
            goto L_0x0042
        L_0x0040:
            boolean r1 = r4 instanceof java.lang.Integer
        L_0x0042:
            if (r1 == 0) goto L_0x0045
            return
        L_0x0045:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.String r4 = "Wrong object type used with protocol message reflection."
            r3.<init>(r4)
            throw r3
            switch-data {0->0x0040, 1->0x003d, 2->0x003a, 3->0x0037, 4->0x0034, 5->0x0031, 6->0x0025, 7->0x001c, 8->0x0013, }
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.m05.p(l25, java.lang.Object):void");
    }

    public m05() {
        int i = b25.m;
    }
}
