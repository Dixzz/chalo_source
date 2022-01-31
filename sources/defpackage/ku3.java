package defpackage;

import defpackage.mu3;
import defpackage.ru3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/* renamed from: ku3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class ku3<T extends mu3<T>> {
    public static final ku3 d = new ku3(true);

    /* renamed from: a  reason: collision with root package name */
    public final rw3<T, Object> f2121a = new tw3(16);
    public boolean b;
    public boolean c;

    public ku3(boolean z) {
        int i = rw3.l;
        h();
        h();
    }

    public static int a(mu3<?> mu3, Object obj) {
        qx3 zzb = mu3.zzb();
        int zza = mu3.zza();
        if (!mu3.zzd()) {
            return b(zzb, zza, obj);
        }
        int i = 0;
        if (mu3.zze()) {
            for (Object obj2 : (List) obj) {
                i += g(zzb, obj2);
            }
            return bu3.D(zza) + i + bu3.L(i);
        }
        for (Object obj3 : (List) obj) {
            i += b(zzb, zza, obj3);
        }
        return i;
    }

    public static int b(qx3 qx3, int i, Object obj) {
        int D = bu3.D(i);
        if (qx3 == qx3.GROUP) {
            cw3 cw3 = (cw3) obj;
            if (cw3 instanceof jt3) {
                jt3 jt3 = (jt3) cw3;
            }
            D <<= 1;
        }
        return g(qx3, obj) + D;
    }

    public static Object d(Object obj) {
        if (obj instanceof fw3) {
            return ((fw3) obj).zza();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0027, code lost:
        if ((r3 instanceof defpackage.wu3) == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0030, code lost:
        if ((r3 instanceof byte[]) == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001e, code lost:
        if ((r3 instanceof defpackage.dv3) == false) goto L_0x0016;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void e(defpackage.qx3 r2, java.lang.Object r3) {
        /*
        // Method dump skipped, instructions count: 102
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ku3.e(qx3, java.lang.Object):void");
    }

    public static <T extends mu3<T>> boolean f(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.zzc() == xx3.MESSAGE) {
            if (key.zzd()) {
                for (cw3 cw3 : (List) entry.getValue()) {
                    if (!cw3.c()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof cw3) {
                    if (!((cw3) value).c()) {
                        return false;
                    }
                } else if (value instanceof dv3) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public static int g(qx3 qx3, Object obj) {
        int a2;
        int L;
        switch (ju3.b[qx3.ordinal()]) {
            case 1:
                ((Double) obj).doubleValue();
                Logger logger = bu3.b;
                return 8;
            case 2:
                ((Float) obj).floatValue();
                Logger logger2 = bu3.b;
                return 4;
            case 3:
                return bu3.F(((Long) obj).longValue());
            case 4:
                return bu3.F(((Long) obj).longValue());
            case 5:
                return bu3.H(((Integer) obj).intValue());
            case 6:
                ((Long) obj).longValue();
                Logger logger3 = bu3.b;
                return 8;
            case 7:
                ((Integer) obj).intValue();
                Logger logger4 = bu3.b;
                return 4;
            case 8:
                ((Boolean) obj).booleanValue();
                Logger logger5 = bu3.b;
                return 1;
            case 9:
                Logger logger6 = bu3.b;
                return ((cw3) obj).a();
            case 10:
                if (!(obj instanceof dv3)) {
                    Logger logger7 = bu3.b;
                    a2 = ((cw3) obj).a();
                    L = bu3.L(a2);
                    break;
                } else {
                    Logger logger8 = bu3.b;
                    a2 = ((dv3) obj).a();
                    L = bu3.L(a2);
                    break;
                }
            case 11:
                if (obj instanceof qt3) {
                    return bu3.p((qt3) obj);
                }
                return bu3.q((String) obj);
            case 12:
                if (!(obj instanceof qt3)) {
                    Logger logger9 = bu3.b;
                    a2 = ((byte[]) obj).length;
                    L = bu3.L(a2);
                    break;
                } else {
                    return bu3.p((qt3) obj);
                }
            case 13:
                return bu3.L(((Integer) obj).intValue());
            case 14:
                ((Integer) obj).intValue();
                Logger logger10 = bu3.b;
                return 4;
            case 15:
                ((Long) obj).longValue();
                Logger logger11 = bu3.b;
                return 8;
            case 16:
                return bu3.O(((Integer) obj).intValue());
            case 17:
                return bu3.K(((Long) obj).longValue());
            case 18:
                if (obj instanceof wu3) {
                    return bu3.H(((wu3) obj).zza());
                }
                return bu3.H(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
        return L + a2;
    }

    public static int k(Map.Entry<T, Object> entry) {
        int M;
        int L;
        int a2;
        int L2;
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.zzc() != xx3.MESSAGE || key.zzd() || key.zze()) {
            return a(key, value);
        }
        if (value instanceof dv3) {
            M = bu3.M(2, entry.getKey().zza()) + (bu3.L(8) << 1);
            L = bu3.L(24);
            a2 = ((dv3) value).a();
            L2 = bu3.L(a2);
        } else {
            M = bu3.M(2, entry.getKey().zza()) + (bu3.L(8) << 1);
            L = bu3.L(24);
            a2 = ((cw3) value).a();
            L2 = bu3.L(a2);
        }
        return L2 + a2 + L + M;
    }

    public final Object c(T t) {
        Object obj = this.f2121a.get(t);
        if (!(obj instanceof dv3)) {
            return obj;
        }
        dv3 dv3 = (dv3) obj;
        int i = dv3.c;
        throw new NoSuchMethodError();
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        ku3 ku3 = new ku3();
        for (int i = 0; i < this.f2121a.e(); i++) {
            Map.Entry<T, Object> d2 = this.f2121a.d(i);
            ku3.i(d2.getKey(), d2.getValue());
        }
        for (Map.Entry<T, Object> entry : this.f2121a.g()) {
            ku3.i(entry.getKey(), entry.getValue());
        }
        ku3.c = this.c;
        return ku3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ku3)) {
            return false;
        }
        return this.f2121a.equals(((ku3) obj).f2121a);
    }

    public final void h() {
        if (!this.b) {
            this.f2121a.c();
            this.b = true;
        }
    }

    public final int hashCode() {
        return this.f2121a.hashCode();
    }

    public final void i(T t, Object obj) {
        if (!t.zzd()) {
            e(t.zzb(), obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList.get(i);
                i++;
                e(t.zzb(), obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof dv3) {
            this.c = true;
        }
        this.f2121a.put(t, obj);
    }

    public final void j(Map.Entry<T, Object> entry) {
        cw3 cw3;
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof dv3) {
            dv3 dv3 = (dv3) value;
            int i = dv3.c;
            throw new NoSuchMethodError();
        } else if (key.zzd()) {
            Object c2 = c(key);
            if (c2 == null) {
                c2 = new ArrayList();
            }
            for (Object obj : (List) value) {
                ((List) c2).add(d(obj));
            }
            this.f2121a.put(key, c2);
        } else if (key.zzc() == xx3.MESSAGE) {
            Object c3 = c(key);
            if (c3 == null) {
                this.f2121a.put(key, d(value));
                return;
            }
            if (c3 instanceof fw3) {
                cw3 = key.Q((fw3) c3, (fw3) value);
            } else {
                cw3 = ((ru3.b) key.I(((cw3) c3).g(), (cw3) value)).k();
            }
            this.f2121a.put(key, cw3);
        } else {
            this.f2121a.put(key, d(value));
        }
    }

    public final Iterator<Map.Entry<T, Object>> l() {
        if (this.c) {
            return new iv3(this.f2121a.entrySet().iterator());
        }
        return this.f2121a.entrySet().iterator();
    }

    public final boolean m() {
        for (int i = 0; i < this.f2121a.e(); i++) {
            if (!f(this.f2121a.d(i))) {
                return false;
            }
        }
        for (Map.Entry<T, Object> entry : this.f2121a.g()) {
            if (!f(entry)) {
                return false;
            }
        }
        return true;
    }

    public ku3() {
        int i = rw3.l;
    }
}
