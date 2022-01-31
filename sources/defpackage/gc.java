package defpackage;

import defpackage.dd;
import defpackage.gc.a;
import defpackage.kc;
import defpackage.mc;
import defpackage.pc;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/* renamed from: gc  reason: default package */
/* compiled from: FieldSet */
public final class gc<T extends a<T>> {
    public static final gc d = new gc(true);

    /* renamed from: a  reason: collision with root package name */
    public final vd<T, Object> f1237a = new ud(16);
    public boolean b;
    public boolean c;

    /* renamed from: gc$a */
    /* compiled from: FieldSet */
    public interface a<T extends a<T>> extends Comparable<T> {
        dd.a R(dd.a aVar, dd ddVar);

        boolean b();

        fe d();

        int getNumber();

        boolean isPacked();

        ge s();
    }

    public gc(boolean z) {
        int i = vd.m;
        l();
        l();
    }

    public static Object b(Object obj) {
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public static int c(fe feVar, int i, Object obj) {
        int x = xb.x(i);
        if (feVar == fe.GROUP) {
            x *= 2;
        }
        return d(feVar, obj) + x;
    }

    public static int d(fe feVar, Object obj) {
        switch (feVar.ordinal()) {
            case 0:
                ((Double) obj).doubleValue();
                Logger logger = xb.b;
                return 8;
            case 1:
                ((Float) obj).floatValue();
                Logger logger2 = xb.b;
                return 4;
            case 2:
                return xb.B(((Long) obj).longValue());
            case 3:
                return xb.B(((Long) obj).longValue());
            case 4:
                return xb.l(((Integer) obj).intValue());
            case 5:
                ((Long) obj).longValue();
                Logger logger3 = xb.b;
                return 8;
            case 6:
                ((Integer) obj).intValue();
                Logger logger4 = xb.b;
                return 4;
            case 7:
                ((Boolean) obj).booleanValue();
                Logger logger5 = xb.b;
                return 1;
            case 8:
                if (obj instanceof ub) {
                    return xb.d((ub) obj);
                }
                return xb.w((String) obj);
            case 9:
                Logger logger6 = xb.b;
                return ((dd) obj).getSerializedSize();
            case 10:
                if (obj instanceof pc) {
                    return xb.n((pc) obj);
                }
                Logger logger7 = xb.b;
                return xb.o(((dd) obj).getSerializedSize());
            case 11:
                if (obj instanceof ub) {
                    return xb.d((ub) obj);
                }
                Logger logger8 = xb.b;
                return xb.o(((byte[]) obj).length);
            case 12:
                return xb.z(((Integer) obj).intValue());
            case 13:
                if (obj instanceof mc.a) {
                    return xb.l(((mc.a) obj).getNumber());
                }
                return xb.l(((Integer) obj).intValue());
            case 14:
                ((Integer) obj).intValue();
                Logger logger9 = xb.b;
                return 4;
            case 15:
                ((Long) obj).longValue();
                Logger logger10 = xb.b;
                return 8;
            case 16:
                return xb.s(((Integer) obj).intValue());
            case 17:
                return xb.u(((Long) obj).longValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int e(a<?> aVar, Object obj) {
        fe d2 = aVar.d();
        int number = aVar.getNumber();
        if (!aVar.b()) {
            return c(d2, number, obj);
        }
        int i = 0;
        if (aVar.isPacked()) {
            for (Object obj2 : (List) obj) {
                i += d(d2, obj2);
            }
            return xb.x(number) + i + xb.z(i);
        }
        for (Object obj3 : (List) obj) {
            i += c(d2, number, obj3);
        }
        return i;
    }

    public static <T extends a<T>> boolean j(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.s() == ge.MESSAGE) {
            if (key.b()) {
                for (dd ddVar : (List) entry.getValue()) {
                    if (!ddVar.isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof dd) {
                    if (!((dd) value).isInitialized()) {
                        return false;
                    }
                } else if (value instanceof pc) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public static void p(xb xbVar, fe feVar, int i, Object obj) throws IOException {
        if (feVar == fe.GROUP) {
            xbVar.W(i, 3);
            ((dd) obj).a(xbVar);
            xbVar.W(i, 4);
            return;
        }
        xbVar.W(i, feVar.getWireType());
        switch (feVar.ordinal()) {
            case 0:
                xbVar.N(Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                return;
            case 1:
                xbVar.L(Float.floatToRawIntBits(((Float) obj).floatValue()));
                return;
            case 2:
                xbVar.a0(((Long) obj).longValue());
                return;
            case 3:
                xbVar.a0(((Long) obj).longValue());
                return;
            case 4:
                xbVar.P(((Integer) obj).intValue());
                return;
            case 5:
                xbVar.N(((Long) obj).longValue());
                return;
            case 6:
                xbVar.L(((Integer) obj).intValue());
                return;
            case 7:
                xbVar.F(((Boolean) obj).booleanValue() ? (byte) 1 : 0);
                return;
            case 8:
                if (obj instanceof ub) {
                    xbVar.J((ub) obj);
                    return;
                } else {
                    xbVar.V((String) obj);
                    return;
                }
            case 9:
                ((dd) obj).a(xbVar);
                return;
            case 10:
                xbVar.R((dd) obj);
                return;
            case 11:
                if (obj instanceof ub) {
                    xbVar.J((ub) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                xbVar.H(bArr, 0, bArr.length);
                return;
            case 12:
                xbVar.Y(((Integer) obj).intValue());
                return;
            case 13:
                if (obj instanceof mc.a) {
                    xbVar.P(((mc.a) obj).getNumber());
                    return;
                } else {
                    xbVar.P(((Integer) obj).intValue());
                    return;
                }
            case 14:
                xbVar.L(((Integer) obj).intValue());
                return;
            case 15:
                xbVar.N(((Long) obj).longValue());
                return;
            case 16:
                xbVar.Y(xb.C(((Integer) obj).intValue()));
                return;
            case 17:
                xbVar.a0(xb.D(((Long) obj).longValue()));
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    public gc<T> clone() {
        gc<T> gcVar = new gc<>();
        for (int i = 0; i < this.f1237a.d(); i++) {
            Map.Entry<T, Object> c2 = this.f1237a.c(i);
            gcVar.n(c2.getKey(), c2.getValue());
        }
        for (Map.Entry<T, Object> entry : this.f1237a.e()) {
            gcVar.n(entry.getKey(), entry.getValue());
        }
        gcVar.c = this.c;
        return gcVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof gc)) {
            return false;
        }
        return this.f1237a.equals(((gc) obj).f1237a);
    }

    public Object f(T t) {
        Object obj = this.f1237a.get(t);
        return obj instanceof pc ? ((pc) obj).c() : obj;
    }

    public final int g(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.s() != ge.MESSAGE || key.b() || key.isPacked()) {
            return e(key, value);
        }
        if (value instanceof pc) {
            return xb.n((pc) value) + xb.x(3) + xb.y(2, entry.getKey().getNumber()) + (xb.x(1) * 2);
        }
        return xb.o(((dd) value).getSerializedSize()) + xb.x(3) + xb.y(2, entry.getKey().getNumber()) + (xb.x(1) * 2);
    }

    public boolean h() {
        return this.f1237a.isEmpty();
    }

    public int hashCode() {
        return this.f1237a.hashCode();
    }

    public boolean i() {
        for (int i = 0; i < this.f1237a.d(); i++) {
            if (!j(this.f1237a.c(i))) {
                return false;
            }
        }
        for (Map.Entry<T, Object> entry : this.f1237a.e()) {
            if (!j(entry)) {
                return false;
            }
        }
        return true;
    }

    public Iterator<Map.Entry<T, Object>> k() {
        if (this.c) {
            return new pc.c(this.f1237a.entrySet().iterator());
        }
        return this.f1237a.entrySet().iterator();
    }

    public void l() {
        if (!this.b) {
            this.f1237a.g();
            this.b = true;
        }
    }

    public final void m(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof pc) {
            value = ((pc) value).c();
        }
        if (key.b()) {
            Object f = f(key);
            if (f == null) {
                f = new ArrayList();
            }
            for (Object obj : (List) value) {
                ((List) f).add(b(obj));
            }
            this.f1237a.put(key, f);
        } else if (key.s() == ge.MESSAGE) {
            Object f2 = f(key);
            if (f2 == null) {
                this.f1237a.put(key, b(value));
                return;
            }
            this.f1237a.put(key, ((kc.a) key.R(((dd) f2).toBuilder(), (dd) value)).b());
        } else {
            this.f1237a.put(key, b(value));
        }
    }

    public void n(T t, Object obj) {
        if (!t.b()) {
            o(t.d(), obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                o(t.d(), it.next());
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof pc) {
            this.c = true;
        }
        this.f1237a.put(t, obj);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002b, code lost:
        if ((r4 instanceof byte[]) == false) goto L_0x002e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0019, code lost:
        if ((r4 instanceof defpackage.pc) == false) goto L_0x002e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0022, code lost:
        if ((r4 instanceof defpackage.mc.a) == false) goto L_0x002e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void o(defpackage.fe r3, java.lang.Object r4) {
        /*
            r2 = this;
            java.nio.charset.Charset r0 = defpackage.mc.f2352a
            java.util.Objects.requireNonNull(r4)
            ge r3 = r3.getJavaType()
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
            boolean r3 = r4 instanceof defpackage.dd
            if (r3 != 0) goto L_0x002f
            boolean r3 = r4 instanceof defpackage.pc
            if (r3 == 0) goto L_0x002e
            goto L_0x002f
        L_0x001c:
            boolean r3 = r4 instanceof java.lang.Integer
            if (r3 != 0) goto L_0x002f
            boolean r3 = r4 instanceof defpackage.mc.a
            if (r3 == 0) goto L_0x002e
            goto L_0x002f
        L_0x0025:
            boolean r3 = r4 instanceof defpackage.ub
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
        throw new UnsupportedOperationException("Method not decompiled: defpackage.gc.o(fe, java.lang.Object):void");
    }

    public gc() {
        int i = vd.m;
    }
}
