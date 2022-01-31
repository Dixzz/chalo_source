package defpackage;

import defpackage.cn1;
import defpackage.ip1;
import defpackage.km1;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: sn1  reason: default package */
/* compiled from: ResourceCacheGenerator */
public class sn1 implements cn1, km1.a<Object> {
    public final cn1.a f;
    public final dn1<?> g;
    public int h = 0;
    public int i = -1;
    public dm1 j;
    public List<ip1<File, ?>> k;
    public int l;
    public volatile ip1.a<?> m;
    public File n;
    public tn1 o;

    public sn1(dn1<?> dn1, cn1.a aVar) {
        this.g = dn1;
        this.f = aVar;
    }

    @Override // defpackage.cn1
    public boolean b() {
        List<Class<?>> orDefault;
        List<Class<?>> c;
        List<dm1> a2 = this.g.a();
        if (a2.isEmpty()) {
            return false;
        }
        dn1<?> dn1 = this.g;
        ll1 ll1 = dn1.c.b;
        Class<?> cls = dn1.d.getClass();
        Class<?> cls2 = dn1.g;
        Class<Transcode> cls3 = dn1.k;
        ks1 ks1 = ll1.h;
        qt1 andSet = ks1.f2114a.getAndSet(null);
        if (andSet == null) {
            andSet = new qt1(cls, cls2);
        } else {
            andSet.f2988a = cls;
            andSet.b = cls2;
            andSet.c = null;
        }
        synchronized (ks1.b) {
            orDefault = ks1.b.getOrDefault(andSet, null);
        }
        ks1.f2114a.set(andSet);
        ArrayList arrayList = orDefault;
        if (orDefault == null) {
            ArrayList arrayList2 = new ArrayList();
            kp1 kp1 = ll1.f2233a;
            synchronized (kp1) {
                c = kp1.f2097a.c(cls);
            }
            Iterator it = ((ArrayList) c).iterator();
            while (it.hasNext()) {
                Iterator it2 = ((ArrayList) ll1.c.a((Class) it.next(), cls2)).iterator();
                while (it2.hasNext()) {
                    Class cls4 = (Class) it2.next();
                    if (!((ArrayList) ll1.f.a(cls4, cls3)).isEmpty() && !arrayList2.contains(cls4)) {
                        arrayList2.add(cls4);
                    }
                }
            }
            ks1 ks12 = ll1.h;
            List<Class<?>> unmodifiableList = Collections.unmodifiableList(arrayList2);
            synchronized (ks12.b) {
                ks12.b.put(new qt1(cls, cls2), unmodifiableList);
            }
            arrayList = arrayList2;
        }
        while (true) {
            List<ip1<File, ?>> list = this.k;
            if (list != null) {
                if (this.l < list.size()) {
                    this.m = null;
                    boolean z = false;
                    while (!z) {
                        if (!(this.l < this.k.size())) {
                            break;
                        }
                        List<ip1<File, ?>> list2 = this.k;
                        int i2 = this.l;
                        this.l = i2 + 1;
                        File file = this.n;
                        dn1<?> dn12 = this.g;
                        this.m = list2.get(i2).b(file, dn12.e, dn12.f, dn12.i);
                        if (this.m != null && this.g.g(this.m.c.a())) {
                            this.m.c.e(this.g.o, this);
                            z = true;
                        }
                    }
                    return z;
                }
            }
            int i3 = this.i + 1;
            this.i = i3;
            if (i3 >= arrayList.size()) {
                int i4 = this.h + 1;
                this.h = i4;
                if (i4 >= a2.size()) {
                    return false;
                }
                this.i = 0;
            }
            dm1 dm1 = a2.get(this.h);
            Class<?> cls5 = arrayList.get(this.i);
            im1<Z> f2 = this.g.f(cls5);
            dn1<?> dn13 = this.g;
            this.o = new tn1(dm1, dn13.n, dn13.e, dn13.f, f2, cls5, dn13.i);
            File b = dn13.b().b(this.o);
            this.n = b;
            if (b != null) {
                this.j = dm1;
                this.k = this.g.c.b.d(b);
                this.l = 0;
            }
        }
    }

    @Override // defpackage.km1.a
    public void c(Exception exc) {
        this.f.a(this.o, exc, this.m.c, xl1.RESOURCE_DISK_CACHE);
    }

    @Override // defpackage.cn1
    public void cancel() {
        ip1.a<?> aVar = this.m;
        if (aVar != null) {
            aVar.c.cancel();
        }
    }

    @Override // defpackage.km1.a
    public void g(Object obj) {
        this.f.h(this.j, obj, this.m.c, xl1.RESOURCE_DISK_CACHE, this.o);
    }
}
