package defpackage;

import defpackage.ru3;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* renamed from: gw3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class gw3<T> implements qw3<T> {

    /* renamed from: a  reason: collision with root package name */
    public final cw3 f1308a;
    public final ex3<?, ?> b;
    public final boolean c;
    public final gu3<?> d;

    public gw3(ex3<?, ?> ex3, gu3<?> gu3, cw3 cw3) {
        this.b = ex3;
        this.c = gu3.e(cw3);
        this.d = gu3;
        this.f1308a = cw3;
    }

    @Override // defpackage.qw3
    public final void a(T t) {
        this.b.h(t);
        this.d.g(t);
    }

    @Override // defpackage.qw3
    public final void b(T t, T t2) {
        ex3<?, ?> ex3 = this.b;
        Class<?> cls = sw3.f3265a;
        ex3.d(t, ex3.g(ex3.e(t), ex3.e(t2)));
        if (this.c) {
            sw3.i(this.d, t, t2);
        }
    }

    @Override // defpackage.qw3
    public final int c(T t) {
        ex3<?, ?> ex3 = this.b;
        int i = ex3.i(ex3.e(t)) + 0;
        if (!this.c) {
            return i;
        }
        ku3<?> b2 = this.d.b(t);
        int i2 = 0;
        for (int i3 = 0; i3 < b2.f2121a.e(); i3++) {
            i2 += ku3.k(b2.f2121a.d(i3));
        }
        for (Map.Entry<T, Object> entry : b2.f2121a.g()) {
            i2 += ku3.k(entry);
        }
        return i + i2;
    }

    @Override // defpackage.qw3
    public final int d(T t) {
        int hashCode = this.b.e(t).hashCode();
        return this.c ? (hashCode * 53) + this.d.b(t).hashCode() : hashCode;
    }

    @Override // defpackage.qw3
    public final void e(T t, wx3 wx3) throws IOException {
        Iterator<Map.Entry<?, Object>> l = this.d.b(t).l();
        while (l.hasNext()) {
            Map.Entry<?, Object> next = l.next();
            mu3 mu3 = (mu3) next.getKey();
            if (mu3.zzc() != xx3.MESSAGE || mu3.zzd() || mu3.zze()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof fv3) {
                ((du3) wx3).c(mu3.zza(), ((fv3) next).f.getValue().c());
            } else {
                ((du3) wx3).c(mu3.zza(), next.getValue());
            }
        }
        ex3<?, ?> ex3 = this.b;
        ex3.f(ex3.e(t), wx3);
    }

    @Override // defpackage.qw3
    public final void f(T t, byte[] bArr, int i, int i2, pt3 pt3) throws IOException {
        T t2 = t;
        dx3 dx3 = t2.zzb;
        if (dx3 == dx3.f) {
            dx3 = dx3.c();
            t2.zzb = dx3;
        }
        t.t();
        ru3.f fVar = null;
        while (i < i2) {
            int t3 = hd3.t3(bArr, i, pt3);
            int i3 = pt3.f2847a;
            if (i3 == 11) {
                int i4 = 0;
                qt3 qt3 = null;
                while (t3 < i2) {
                    t3 = hd3.t3(bArr, t3, pt3);
                    int i5 = pt3.f2847a;
                    int i6 = i5 >>> 3;
                    int i7 = i5 & 7;
                    if (i6 != 2) {
                        if (i6 == 3) {
                            if (fVar != null) {
                                nw3 nw3 = nw3.c;
                                throw new NoSuchMethodError();
                            } else if (i7 == 2) {
                                t3 = hd3.c4(bArr, t3, pt3);
                                qt3 = (qt3) pt3.c;
                            }
                        }
                    } else if (i7 == 0) {
                        t3 = hd3.t3(bArr, t3, pt3);
                        i4 = pt3.f2847a;
                        fVar = (ru3.f) this.d.c(pt3.d, this.f1308a, i4);
                    }
                    if (i5 == 12) {
                        break;
                    }
                    t3 = hd3.l3(i5, bArr, t3, i2, pt3);
                }
                if (qt3 != null) {
                    dx3.a((i4 << 3) | 2, qt3);
                }
                i = t3;
            } else if ((i3 & 7) == 2) {
                fVar = (ru3.f) this.d.c(pt3.d, this.f1308a, i3 >>> 3);
                if (fVar == null) {
                    i = hd3.n3(i3, bArr, t3, i2, dx3, pt3);
                } else {
                    nw3 nw32 = nw3.c;
                    throw new NoSuchMethodError();
                }
            } else {
                i = hd3.l3(i3, bArr, t3, i2, pt3);
            }
        }
        if (i != i2) {
            throw cv3.d();
        }
    }

    @Override // defpackage.qw3
    public final boolean g(T t) {
        return this.d.b(t).m();
    }

    @Override // defpackage.qw3
    public final boolean h(T t, T t2) {
        if (!this.b.e(t).equals(this.b.e(t2))) {
            return false;
        }
        if (this.c) {
            return this.d.b(t).equals(this.d.b(t2));
        }
        return true;
    }

    @Override // defpackage.qw3
    public final T zza() {
        return (T) ((ru3.b) this.f1308a.r()).j();
    }
}
