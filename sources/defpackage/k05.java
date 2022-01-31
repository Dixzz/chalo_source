package defpackage;

import defpackage.i05;
import defpackage.q05;
import defpackage.wz4;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: k05  reason: default package */
/* compiled from: ExtensionSchemaLite */
public final class k05 extends j05<q05.d> {
    @Override // defpackage.j05
    public int a(Map.Entry<?, ?> entry) {
        return ((q05.d) entry.getKey()).g;
    }

    @Override // defpackage.j05
    public Object b(i05 i05, j15 j15, int i) {
        return i05.f1458a.get(new i05.a(j15, i));
    }

    @Override // defpackage.j05
    public m05<q05.d> c(Object obj) {
        return ((q05.c) obj).extensions;
    }

    @Override // defpackage.j05
    public m05<q05.d> d(Object obj) {
        return ((q05.c) obj).a();
    }

    @Override // defpackage.j05
    public boolean e(j15 j15) {
        return j15 instanceof q05.c;
    }

    @Override // defpackage.j05
    public void f(Object obj) {
        ((q05.c) obj).extensions.m();
    }

    @Override // defpackage.j05
    public <UT, UB> UB g(w15 w15, Object obj, i05 i05, m05<q05.d> m05, UB ub, e25<UT, UB> e25) throws IOException {
        Object g;
        ArrayList arrayList;
        q05.e eVar = (q05.e) obj;
        q05.d dVar = eVar.d;
        int i = dVar.g;
        if (!dVar.i || !dVar.j) {
            Object obj2 = null;
            l25 l25 = dVar.h;
            if (l25 != l25.ENUM) {
                switch (l25.ordinal()) {
                    case 0:
                        obj2 = Double.valueOf(w15.readDouble());
                        break;
                    case 1:
                        obj2 = Float.valueOf(w15.readFloat());
                        break;
                    case 2:
                        obj2 = Long.valueOf(w15.G());
                        break;
                    case 3:
                        obj2 = Long.valueOf(w15.c());
                        break;
                    case 4:
                        obj2 = Integer.valueOf(w15.B());
                        break;
                    case 5:
                        obj2 = Long.valueOf(w15.d());
                        break;
                    case 6:
                        obj2 = Integer.valueOf(w15.h());
                        break;
                    case 7:
                        obj2 = Boolean.valueOf(w15.i());
                        break;
                    case 8:
                        obj2 = w15.v();
                        break;
                    case 9:
                        obj2 = w15.N(eVar.c.getClass(), i05);
                        break;
                    case 10:
                        obj2 = w15.K(eVar.c.getClass(), i05);
                        break;
                    case 11:
                        obj2 = w15.z();
                        break;
                    case 12:
                        obj2 = Integer.valueOf(w15.l());
                        break;
                    case 13:
                        throw new IllegalStateException("Shouldn't reach here.");
                    case 14:
                        obj2 = Integer.valueOf(w15.D());
                        break;
                    case 15:
                        obj2 = Long.valueOf(w15.j());
                        break;
                    case 16:
                        obj2 = Integer.valueOf(w15.s());
                        break;
                    case 17:
                        obj2 = Long.valueOf(w15.t());
                        break;
                }
            } else {
                int B = w15.B();
                if (eVar.d.f.findValueByNumber(B) == null) {
                    Class<?> cls = z15.f4109a;
                    if (ub == null) {
                        ub = e25.m();
                    }
                    e25.e(ub, i, (long) B);
                    return ub;
                }
                obj2 = Integer.valueOf(B);
            }
            q05.d dVar2 = eVar.d;
            if (dVar2.i) {
                m05.a(dVar2, obj2);
            } else {
                int ordinal = dVar2.h.ordinal();
                if ((ordinal == 9 || ordinal == 10) && (g = m05.g(eVar.d)) != null) {
                    obj2 = s05.c(g, obj2);
                }
                m05.o(eVar.d, obj2);
            }
        } else {
            switch (dVar.h.ordinal()) {
                case 0:
                    arrayList = new ArrayList();
                    w15.F(arrayList);
                    break;
                case 1:
                    arrayList = new ArrayList();
                    w15.A(arrayList);
                    break;
                case 2:
                    arrayList = new ArrayList();
                    w15.m(arrayList);
                    break;
                case 3:
                    arrayList = new ArrayList();
                    w15.k(arrayList);
                    break;
                case 4:
                    arrayList = new ArrayList();
                    w15.o(arrayList);
                    break;
                case 5:
                    arrayList = new ArrayList();
                    w15.I(arrayList);
                    break;
                case 6:
                    arrayList = new ArrayList();
                    w15.r(arrayList);
                    break;
                case 7:
                    arrayList = new ArrayList();
                    w15.u(arrayList);
                    break;
                case 8:
                case 9:
                case 10:
                case 11:
                default:
                    StringBuilder i0 = hj1.i0("Type cannot be packed: ");
                    i0.append(eVar.d.h);
                    throw new IllegalStateException(i0.toString());
                case 12:
                    arrayList = new ArrayList();
                    w15.g(arrayList);
                    break;
                case 13:
                    arrayList = new ArrayList();
                    w15.p(arrayList);
                    ub = (UB) z15.y(i, arrayList, eVar.d.f, ub, e25);
                    break;
                case 14:
                    arrayList = new ArrayList();
                    w15.e(arrayList);
                    break;
                case 15:
                    arrayList = new ArrayList();
                    w15.n(arrayList);
                    break;
                case 16:
                    arrayList = new ArrayList();
                    w15.b(arrayList);
                    break;
                case 17:
                    arrayList = new ArrayList();
                    w15.f(arrayList);
                    break;
            }
            m05.o(eVar.d, arrayList);
        }
        return ub;
    }

    @Override // defpackage.j05
    public void h(w15 w15, Object obj, i05 i05, m05<q05.d> m05) throws IOException {
        q05.e eVar = (q05.e) obj;
        m05.o(eVar.d, w15.K(eVar.c.getClass(), i05));
    }

    @Override // defpackage.j05
    public void i(a05 a05, Object obj, i05 i05, m05<q05.d> m05) throws IOException {
        byte[] bArr;
        q05.e eVar = (q05.e) obj;
        j15 buildPartial = eVar.c.newBuilderForType().buildPartial();
        int size = a05.size();
        if (size == 0) {
            bArr = s05.b;
        } else {
            byte[] bArr2 = new byte[size];
            a05.n(bArr2, 0, 0, size);
            bArr = bArr2;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        if (wrap.hasArray()) {
            wz4.b bVar = new wz4.b(wrap, true);
            t15.c.b(buildPartial).i(buildPartial, bVar, i05);
            m05.o(eVar.d, buildPartial);
            if (bVar.w() != Integer.MAX_VALUE) {
                throw t05.a();
            }
            return;
        }
        throw new IllegalArgumentException("Direct buffers not yet supported");
    }

    @Override // defpackage.j05
    public void j(n25 n25, Map.Entry<?, ?> entry) throws IOException {
        q05.d dVar = (q05.d) entry.getKey();
        if (dVar.i) {
            switch (dVar.h.ordinal()) {
                case 0:
                    z15.G(dVar.g, (List) entry.getValue(), n25, dVar.j);
                    return;
                case 1:
                    z15.K(dVar.g, (List) entry.getValue(), n25, dVar.j);
                    return;
                case 2:
                    z15.N(dVar.g, (List) entry.getValue(), n25, dVar.j);
                    return;
                case 3:
                    z15.V(dVar.g, (List) entry.getValue(), n25, dVar.j);
                    return;
                case 4:
                    z15.M(dVar.g, (List) entry.getValue(), n25, dVar.j);
                    return;
                case 5:
                    z15.J(dVar.g, (List) entry.getValue(), n25, dVar.j);
                    return;
                case 6:
                    z15.I(dVar.g, (List) entry.getValue(), n25, dVar.j);
                    return;
                case 7:
                    z15.E(dVar.g, (List) entry.getValue(), n25, dVar.j);
                    return;
                case 8:
                    z15.T(dVar.g, (List) entry.getValue(), n25);
                    return;
                case 9:
                    List list = (List) entry.getValue();
                    if (list != null && !list.isEmpty()) {
                        z15.L(dVar.g, (List) entry.getValue(), n25, t15.c.a(list.get(0).getClass()));
                        return;
                    }
                    return;
                case 10:
                    List list2 = (List) entry.getValue();
                    if (list2 != null && !list2.isEmpty()) {
                        z15.O(dVar.g, (List) entry.getValue(), n25, t15.c.a(list2.get(0).getClass()));
                        return;
                    }
                    return;
                case 11:
                    z15.F(dVar.g, (List) entry.getValue(), n25);
                    return;
                case 12:
                    z15.U(dVar.g, (List) entry.getValue(), n25, dVar.j);
                    return;
                case 13:
                    z15.M(dVar.g, (List) entry.getValue(), n25, dVar.j);
                    return;
                case 14:
                    z15.P(dVar.g, (List) entry.getValue(), n25, dVar.j);
                    return;
                case 15:
                    z15.Q(dVar.g, (List) entry.getValue(), n25, dVar.j);
                    return;
                case 16:
                    z15.R(dVar.g, (List) entry.getValue(), n25, dVar.j);
                    return;
                case 17:
                    z15.S(dVar.g, (List) entry.getValue(), n25, dVar.j);
                    return;
                default:
                    return;
            }
        } else {
            switch (dVar.h.ordinal()) {
                case 0:
                    ((e05) n25).a(dVar.g, ((Double) entry.getValue()).doubleValue());
                    return;
                case 1:
                    ((e05) n25).b(dVar.g, ((Float) entry.getValue()).floatValue());
                    return;
                case 2:
                    ((e05) n25).f912a.Z(dVar.g, ((Long) entry.getValue()).longValue());
                    return;
                case 3:
                    ((e05) n25).f912a.Z(dVar.g, ((Long) entry.getValue()).longValue());
                    return;
                case 4:
                    ((e05) n25).f912a.O(dVar.g, ((Integer) entry.getValue()).intValue());
                    return;
                case 5:
                    ((e05) n25).f912a.M(dVar.g, ((Long) entry.getValue()).longValue());
                    return;
                case 6:
                    ((e05) n25).f912a.K(dVar.g, ((Integer) entry.getValue()).intValue());
                    return;
                case 7:
                    ((e05) n25).f912a.G(dVar.g, ((Boolean) entry.getValue()).booleanValue());
                    return;
                case 8:
                    ((e05) n25).f912a.U(dVar.g, (String) entry.getValue());
                    return;
                case 9:
                    ((e05) n25).c(dVar.g, entry.getValue(), t15.c.a(entry.getValue().getClass()));
                    return;
                case 10:
                    ((e05) n25).d(dVar.g, entry.getValue(), t15.c.a(entry.getValue().getClass()));
                    return;
                case 11:
                    ((e05) n25).f912a.I(dVar.g, (a05) entry.getValue());
                    return;
                case 12:
                    ((e05) n25).f912a.X(dVar.g, ((Integer) entry.getValue()).intValue());
                    return;
                case 13:
                    ((e05) n25).f912a.O(dVar.g, ((Integer) entry.getValue()).intValue());
                    return;
                case 14:
                    ((e05) n25).f912a.K(dVar.g, ((Integer) entry.getValue()).intValue());
                    return;
                case 15:
                    ((e05) n25).f912a.M(dVar.g, ((Long) entry.getValue()).longValue());
                    return;
                case 16:
                    ((e05) n25).f(dVar.g, ((Integer) entry.getValue()).intValue());
                    return;
                case 17:
                    ((e05) n25).g(dVar.g, ((Long) entry.getValue()).longValue());
                    return;
                default:
                    return;
            }
        }
    }
}
