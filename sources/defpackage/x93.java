package defpackage;

import defpackage.w93;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: x93  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class x93<T extends w93<T>> {
    public static final x93 d = new x93(true);

    /* renamed from: a  reason: collision with root package name */
    public final wm2<T, Object> f3905a;
    public boolean b;
    public boolean c;

    public x93() {
        this.f3905a = new pm2(16);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void b(defpackage.rn2 r1, java.lang.Object r2) {
        /*
            java.nio.charset.Charset r0 = defpackage.ka3.f2038a
            java.util.Objects.requireNonNull(r2)
            rn2 r0 = defpackage.rn2.DOUBLE
            sn2 r0 = defpackage.sn2.INT
            sn2 r1 = r1.zza()
            int r1 = r1.ordinal()
            switch(r1) {
                case 0: goto L_0x003b;
                case 1: goto L_0x0038;
                case 2: goto L_0x0035;
                case 3: goto L_0x0032;
                case 4: goto L_0x002f;
                case 5: goto L_0x002c;
                case 6: goto L_0x0023;
                case 7: goto L_0x001a;
                case 8: goto L_0x0015;
                default: goto L_0x0014;
            }
        L_0x0014:
            goto L_0x0040
        L_0x0015:
            boolean r1 = r2 instanceof defpackage.bm2
            if (r1 != 0) goto L_0x003f
            goto L_0x0040
        L_0x001a:
            boolean r1 = r2 instanceof java.lang.Integer
            if (r1 != 0) goto L_0x003f
            boolean r1 = r2 instanceof defpackage.ga3
            if (r1 == 0) goto L_0x0040
            goto L_0x003f
        L_0x0023:
            boolean r1 = r2 instanceof defpackage.g93
            if (r1 != 0) goto L_0x003f
            boolean r1 = r2 instanceof byte[]
            if (r1 == 0) goto L_0x0040
            goto L_0x003f
        L_0x002c:
            boolean r1 = r2 instanceof java.lang.String
            goto L_0x003d
        L_0x002f:
            boolean r1 = r2 instanceof java.lang.Boolean
            goto L_0x003d
        L_0x0032:
            boolean r1 = r2 instanceof java.lang.Double
            goto L_0x003d
        L_0x0035:
            boolean r1 = r2 instanceof java.lang.Float
            goto L_0x003d
        L_0x0038:
            boolean r1 = r2 instanceof java.lang.Long
            goto L_0x003d
        L_0x003b:
            boolean r1 = r2 instanceof java.lang.Integer
        L_0x003d:
            if (r1 == 0) goto L_0x0040
        L_0x003f:
            return
        L_0x0040:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Wrong object type used with protocol message reflection."
            r1.<init>(r2)
            throw r1
            switch-data {0->0x003b, 1->0x0038, 2->0x0035, 3->0x0032, 4->0x002f, 5->0x002c, 6->0x0023, 7->0x001a, 8->0x0015, }
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.x93.b(rn2, java.lang.Object):void");
    }

    public final void a(T t, Object obj) {
        if (!t.zzb()) {
            b(t.zza(), obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                b(t.zza(), arrayList.get(i));
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        this.f3905a.put(t, obj);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: x93 */
    /* JADX WARN: Multi-variable type inference failed */
    public final Object clone() throws CloneNotSupportedException {
        Iterable<Map.Entry> iterable;
        x93 x93 = new x93();
        for (int i = 0; i < this.f3905a.b(); i++) {
            Map.Entry<T, Object> c2 = this.f3905a.c(i);
            x93.a(c2.getKey(), c2.getValue());
        }
        wm2<T, Object> wm2 = this.f3905a;
        if (wm2.h.isEmpty()) {
            iterable = sm2.b;
        } else {
            iterable = wm2.h.entrySet();
        }
        for (Map.Entry entry : iterable) {
            x93.a((w93) entry.getKey(), entry.getValue());
        }
        x93.c = this.c;
        return x93;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x93)) {
            return false;
        }
        return this.f3905a.equals(((x93) obj).f3905a);
    }

    public final int hashCode() {
        return this.f3905a.hashCode();
    }

    public x93(boolean z) {
        pm2 pm2 = new pm2(0);
        this.f3905a = pm2;
        if (!this.b) {
            pm2.a();
            this.b = true;
        }
        if (!this.b) {
            pm2.a();
            this.b = true;
        }
    }
}
