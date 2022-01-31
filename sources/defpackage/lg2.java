package defpackage;

import defpackage.og2;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/* renamed from: lg2  reason: default package */
public final class lg2<FieldDescriptorType extends og2<FieldDescriptorType>> {
    public static final lg2 d = new lg2(true);

    /* renamed from: a  reason: collision with root package name */
    public final si2<FieldDescriptorType, Object> f2212a;
    public boolean b;
    public boolean c = false;

    public lg2() {
        int i = si2.l;
        this.f2212a = new ti2(16);
    }

    public static int d(rj2 rj2, int i, Object obj) {
        int X = bg2.X(i);
        if (rj2 == rj2.GROUP) {
            zh2 zh2 = (zh2) obj;
            Charset charset = wg2.f3775a;
            X <<= 1;
        }
        return h(rj2, obj) + X;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0028, code lost:
        if ((r3 instanceof defpackage.xg2) == false) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0031, code lost:
        if ((r3 instanceof byte[]) == false) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001d, code lost:
        if ((r3 instanceof defpackage.dh2) == false) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0020, code lost:
        r0 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0048 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0049  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void f(defpackage.rj2 r2, java.lang.Object r3) {
        /*
        // Method dump skipped, instructions count: 104
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.lg2.f(rj2, java.lang.Object):void");
    }

    public static int g(og2<?> og2, Object obj) {
        rj2 L = og2.L();
        int zzc = og2.zzc();
        if (!og2.G()) {
            return d(L, zzc, obj);
        }
        int i = 0;
        List<Object> list = (List) obj;
        if (og2.v()) {
            for (Object obj2 : list) {
                i += h(L, obj2);
            }
            return bg2.X(zzc) + i + bg2.Z(i);
        }
        for (Object obj3 : list) {
            i += d(L, zzc, obj3);
        }
        return i;
    }

    public static int h(rj2 rj2, Object obj) {
        int a2;
        int Z;
        switch (mg2.b[rj2.ordinal()]) {
            case 1:
                ((Double) obj).doubleValue();
                Logger logger = bg2.b;
                return 8;
            case 2:
                ((Float) obj).floatValue();
                Logger logger2 = bg2.b;
                return 4;
            case 3:
                return bg2.H(((Long) obj).longValue());
            case 4:
                return bg2.H(((Long) obj).longValue());
            case 5:
                return bg2.Y(((Integer) obj).intValue());
            case 6:
            case 15:
                ((Long) obj).longValue();
                Logger logger3 = bg2.b;
                return 8;
            case 7:
            case 14:
                ((Integer) obj).intValue();
                Logger logger22 = bg2.b;
                return 4;
            case 8:
                ((Boolean) obj).booleanValue();
                Logger logger4 = bg2.b;
                return 1;
            case 9:
                Logger logger5 = bg2.b;
                return ((zh2) obj).e();
            case 10:
                if (!(obj instanceof dh2)) {
                    return bg2.z((zh2) obj);
                }
                Logger logger6 = bg2.b;
                a2 = ((dh2) obj).a();
                Z = bg2.Z(a2);
                return Z + a2;
            case 11:
                return obj instanceof uf2 ? bg2.n((uf2) obj) : bg2.O((String) obj);
            case 12:
                if (obj instanceof uf2) {
                    return bg2.n((uf2) obj);
                }
                Logger logger7 = bg2.b;
                a2 = ((byte[]) obj).length;
                Z = bg2.Z(a2);
                return Z + a2;
            case 13:
                return bg2.Z(((Integer) obj).intValue());
            case 16:
                return bg2.a0(((Integer) obj).intValue());
            case 17:
                return bg2.L(((Long) obj).longValue());
            case 18:
                if (obj instanceof xg2) {
                    return bg2.Y(((xg2) obj).zzc());
                }
                return bg2.Y(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static boolean i(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        if (key.z() == wj2.MESSAGE) {
            boolean G = key.G();
            Object value = entry.getValue();
            if (G) {
                for (zh2 zh2 : (List) value) {
                    if (!zh2.isInitialized()) {
                        return false;
                    }
                }
            } else if (value instanceof zh2) {
                if (!((zh2) value).isInitialized()) {
                    return false;
                }
            } else if (value instanceof dh2) {
                return true;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        }
        return true;
    }

    public static int k(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (key.z() != wj2.MESSAGE || key.G() || key.v()) {
            return g(key, value);
        }
        boolean z = value instanceof dh2;
        int zzc = entry.getKey().zzc();
        if (z) {
            int N = bg2.N(2, zzc) + (bg2.X(1) << 1);
            int X = bg2.X(3);
            int a2 = ((dh2) value).a();
            return bg2.Z(a2) + a2 + X + N;
        }
        return bg2.x(3, (zh2) value) + bg2.N(2, zzc) + (bg2.X(1) << 1);
    }

    public static Object l(Object obj) {
        if (obj instanceof ei2) {
            return ((ei2) obj).A0();
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
        return this.f2212a.isEmpty();
    }

    public final boolean b() {
        for (int i = 0; i < this.f2212a.e(); i++) {
            if (!i(this.f2212a.c(i))) {
                return false;
            }
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.f2212a.f()) {
            if (!i(entry)) {
                return false;
            }
        }
        return true;
    }

    public final Iterator<Map.Entry<FieldDescriptorType, Object>> c() {
        return this.c ? new gh2(this.f2212a.entrySet().iterator()) : this.f2212a.entrySet().iterator();
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        lg2 lg2 = new lg2();
        for (int i = 0; i < this.f2212a.e(); i++) {
            Map.Entry<FieldDescriptorType, Object> c2 = this.f2212a.c(i);
            lg2.e(c2.getKey(), c2.getValue());
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.f2212a.f()) {
            lg2.e(entry.getKey(), entry.getValue());
        }
        lg2.c = this.c;
        return lg2;
    }

    public final void e(FieldDescriptorType fielddescriptortype, Object obj) {
        if (!fielddescriptortype.G()) {
            f(fielddescriptortype.L(), obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList.get(i);
                i++;
                f(fielddescriptortype.L(), obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof dh2) {
            this.c = true;
        }
        this.f2212a.put(fielddescriptortype, obj);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof lg2)) {
            return false;
        }
        return this.f2212a.equals(((lg2) obj).f2212a);
    }

    public final int hashCode() {
        return this.f2212a.hashCode();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:35:0x00b3 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v12, types: [ug2, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v15, types: [ei2] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void j(java.util.Map.Entry<FieldDescriptorType, java.lang.Object> r6) {
        /*
        // Method dump skipped, instructions count: 219
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.lg2.j(java.util.Map$Entry):void");
    }

    public lg2(boolean z) {
        int i = si2.l;
        ti2 ti2 = new ti2(0);
        this.f2212a = ti2;
        if (!this.b) {
            ti2.i();
            this.b = true;
        }
    }
}
