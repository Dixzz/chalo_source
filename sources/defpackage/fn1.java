package defpackage;

import android.util.Log;
import defpackage.en1;
import defpackage.ip1;
import defpackage.ll1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* renamed from: fn1  reason: default package */
/* compiled from: DecodePath */
public class fn1<DataType, ResourceType, Transcode> {

    /* renamed from: a  reason: collision with root package name */
    public final Class<DataType> f1146a;
    public final List<? extends gm1<DataType, ResourceType>> b;
    public final jr1<ResourceType, Transcode> c;
    public final v7<List<Exception>> d;
    public final String e;

    /* renamed from: fn1$a */
    /* compiled from: DecodePath */
    public interface a<ResourceType> {
    }

    public fn1(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends gm1<DataType, ResourceType>> list, jr1<ResourceType, Transcode> jr1, v7<List<Exception>> v7Var) {
        this.f1146a = cls;
        this.b = list;
        this.c = jr1;
        this.d = v7Var;
        StringBuilder i0 = hj1.i0("Failed DecodePath{");
        i0.append(cls.getSimpleName());
        i0.append("->");
        i0.append(cls2.getSimpleName());
        i0.append("->");
        i0.append(cls3.getSimpleName());
        i0.append("}");
        this.e = i0.toString();
    }

    /* JADX INFO: finally extract failed */
    public rn1<Transcode> a(lm1<DataType> lm1, int i, int i2, fm1 fm1, a<ResourceType> aVar) throws nn1 {
        qn1<Z> qn1;
        im1<Z> im1;
        zl1 zl1;
        boolean z;
        dm1 dm1;
        List<Exception> b2 = this.d.b();
        try {
            rn1<ResourceType> b3 = b(lm1, i, i2, fm1, b2);
            this.d.a(b2);
            en1.b bVar = (en1.b) aVar;
            Objects.requireNonNull(bVar);
            Class<?> cls = b3.get().getClass();
            hm1<Z> hm1 = null;
            if (bVar.f1001a != xl1.RESOURCE_DISK_CACHE) {
                im1<Z> f = en1.this.f.f(cls);
                en1 en1 = en1.this;
                qn1 = f.b(en1.m, b3, en1.q, en1.r);
                im1 = f;
            } else {
                qn1 = (rn1<Z>) b3;
                im1 = null;
            }
            if (!b3.equals(qn1)) {
                b3.a();
            }
            if (en1.this.f.c.b.d.a(qn1.c()) != null) {
                hm1 = en1.this.f.c.b.d.a(qn1.c());
                if (hm1 != null) {
                    zl1 = hm1.b(en1.this.t);
                } else {
                    throw new ll1.d(qn1.c());
                }
            } else {
                zl1 = zl1.NONE;
            }
            en1 en12 = en1.this;
            dn1<R> dn1 = en12.f;
            dm1 dm12 = en12.B;
            List<ip1.a<?>> c2 = dn1.c();
            int size = c2.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    z = false;
                    break;
                } else if (c2.get(i3).f1550a.equals(dm12)) {
                    z = true;
                    break;
                } else {
                    i3++;
                }
            }
            if (en1.this.s.d(!z, bVar.f1001a, zl1)) {
                if (hm1 != null) {
                    if (zl1 == zl1.SOURCE) {
                        en1 en13 = en1.this;
                        dm1 = new an1(en13.B, en13.n);
                    } else if (zl1 == zl1.TRANSFORMED) {
                        en1 en14 = en1.this;
                        dm1 = new tn1(en14.B, en14.n, en14.q, en14.r, im1, cls, en14.t);
                    } else {
                        throw new IllegalArgumentException("Unknown strategy: " + zl1);
                    }
                    qn1<Z> qn12 = (qn1<Z>) qn1.j.b();
                    qn12.i = false;
                    qn12.h = true;
                    qn12.g = qn1;
                    en1.c<?> cVar = en1.this.k;
                    cVar.f1002a = dm1;
                    cVar.b = hm1;
                    cVar.c = qn12;
                    qn1 = qn12;
                } else {
                    throw new ll1.d(qn1.get().getClass());
                }
            }
            return this.c.a(qn1);
        } catch (Throwable th) {
            this.d.a(b2);
            throw th;
        }
    }

    public final rn1<ResourceType> b(lm1<DataType> lm1, int i, int i2, fm1 fm1, List<Exception> list) throws nn1 {
        int size = this.b.size();
        rn1<ResourceType> rn1 = null;
        for (int i3 = 0; i3 < size; i3++) {
            gm1 gm1 = (gm1) this.b.get(i3);
            try {
                if (gm1.a(lm1.a(), fm1)) {
                    rn1 = gm1.b(lm1.a(), i, i2, fm1);
                }
            } catch (IOException e2) {
                if (Log.isLoggable("DecodePath", 2)) {
                    String str = "Failed to decode data for " + gm1;
                }
                list.add(e2);
            }
            if (rn1 != null) {
                break;
            }
        }
        if (rn1 != null) {
            return rn1;
        }
        throw new nn1(this.e, new ArrayList(list));
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("DecodePath{ dataClass=");
        i0.append(this.f1146a);
        i0.append(", decoders=");
        i0.append(this.b);
        i0.append(", transcoder=");
        i0.append(this.c);
        i0.append('}');
        return i0.toString();
    }
}
