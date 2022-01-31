package defpackage;

import defpackage.l66;

/* renamed from: ib6  reason: default package */
/* compiled from: CoroutineContext.kt */
public final class ib6 {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f1503a;

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0027, code lost:
        if (r0.equals("on") != false) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0030, code lost:
        if (r0.equals("") != false) goto L_0x0053;
     */
    static {
        /*
            java.lang.String r0 = "kotlinx.coroutines.scheduler"
            java.lang.String r0 = defpackage.ec6.E(r0)
            if (r0 == 0) goto L_0x0053
            int r1 = r0.hashCode()
            if (r1 == 0) goto L_0x002a
            r2 = 3551(0xddf, float:4.976E-42)
            if (r1 == r2) goto L_0x0021
            r2 = 109935(0x1ad6f, float:1.54052E-40)
            if (r1 != r2) goto L_0x0033
            java.lang.String r1 = "off"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0033
            r0 = 0
            goto L_0x0054
        L_0x0021:
            java.lang.String r1 = "on"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0033
            goto L_0x0053
        L_0x002a:
            java.lang.String r1 = ""
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0033
            goto L_0x0053
        L_0x0033:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "System property 'kotlinx.coroutines.scheduler' has unrecognized value '"
            r1.append(r2)
            r1.append(r0)
            r0 = 39
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x0053:
            r0 = 1
        L_0x0054:
            defpackage.ib6.f1503a = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ib6.<clinit>():void");
    }

    public static final m66 a(mb6 mb6, m66 m66) {
        m66 plus = mb6.n().plus(m66);
        xb6 xb6 = xb6.f3911a;
        kb6 kb6 = xb6.b;
        return (plus == kb6 || plus.get(l66.a.f) != null) ? plus : plus.plus(kb6);
    }

    public static final od6<?> b(k66<?> k66, m66 m66, Object obj) {
        od6<?> od6 = null;
        if (!(k66 instanceof x66)) {
            return null;
        }
        if (!(m66.get(pd6.f) != null)) {
            return null;
        }
        x66 x66 = (x66) k66;
        while (true) {
            if (!(x66 instanceof ub6) && (x66 = x66.getCallerFrame()) != null) {
                if (x66 instanceof od6) {
                    od6 = (od6) x66;
                    break;
                }
            } else {
                break;
            }
        }
        if (od6 != null) {
            od6.i = m66;
            od6.j = obj;
        }
        return od6;
    }
}
