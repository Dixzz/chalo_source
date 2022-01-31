package defpackage;

import defpackage.en1;
import defpackage.hn1;
import defpackage.hs1;
import defpackage.ip1;
import defpackage.kr1;
import defpackage.ll1;
import defpackage.ls1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: dn1  reason: default package */
/* compiled from: DecodeHelper */
public final class dn1<Transcode> {

    /* renamed from: a  reason: collision with root package name */
    public final List<ip1.a<?>> f859a = new ArrayList();
    public final List<dm1> b = new ArrayList();
    public il1 c;
    public Object d;
    public int e;
    public int f;
    public Class<?> g;
    public en1.d h;
    public fm1 i;
    public Map<Class<?>, im1<?>> j;
    public Class<Transcode> k;
    public boolean l;
    public boolean m;
    public dm1 n;
    public kl1 o;
    public gn1 p;
    public boolean q;
    public boolean r;

    public List<dm1> a() {
        if (!this.m) {
            this.m = true;
            this.b.clear();
            List<ip1.a<?>> c2 = c();
            int size = c2.size();
            for (int i2 = 0; i2 < size; i2++) {
                ip1.a<?> aVar = c2.get(i2);
                if (!this.b.contains(aVar.f1550a)) {
                    this.b.add(aVar.f1550a);
                }
                for (int i3 = 0; i3 < aVar.b.size(); i3++) {
                    if (!this.b.contains(aVar.b.get(i3))) {
                        this.b.add(aVar.b.get(i3));
                    }
                }
            }
        }
        return this.b;
    }

    public jo1 b() {
        return ((hn1.c) this.h).a();
    }

    public List<ip1.a<?>> c() {
        if (!this.l) {
            this.l = true;
            this.f859a.clear();
            ArrayList arrayList = (ArrayList) this.c.b.d(this.d);
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                ip1.a<?> b2 = ((ip1) arrayList.get(i2)).b(this.d, this.e, this.f, this.i);
                if (b2 != null) {
                    this.f859a.add(b2);
                }
            }
        }
        return this.f859a;
    }

    public <Data> pn1<Data, ?, Transcode> d(Class<Data> cls) {
        pn1<Data, ?, Transcode> pn1;
        boolean z;
        pn1<Data, ?, Transcode> pn12;
        ArrayList arrayList;
        jr1 jr1;
        ll1 ll1 = this.c.b;
        Class<?> cls2 = this.g;
        Class<Transcode> cls3 = this.k;
        js1 js1 = ll1.i;
        qt1 a2 = js1.a(cls, cls2, cls3);
        synchronized (js1.f1976a) {
            pn1 = (pn1<Data, ?, Transcode>) js1.f1976a.getOrDefault(a2, null);
        }
        js1.b.set(a2);
        if (pn1 != null) {
            return pn1;
        }
        js1 js12 = ll1.i;
        qt1 a3 = js12.a(cls, cls2, cls3);
        synchronized (js12.f1976a) {
            z = js12.f1976a.e(a3) >= 0;
        }
        js12.b.set(a3);
        if (z) {
            return pn1;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = ((ArrayList) ll1.c.a(cls, cls2)).iterator();
        while (it.hasNext()) {
            Class<?> cls4 = (Class) it.next();
            Iterator it2 = ((ArrayList) ll1.f.a(cls4, cls3)).iterator();
            while (true) {
                if (it2.hasNext()) {
                    Class<?> cls5 = (Class) it2.next();
                    ls1 ls1 = ll1.c;
                    synchronized (ls1) {
                        arrayList = new ArrayList();
                        for (ls1.a<?, ?> aVar : ls1.f2262a) {
                            if (aVar.a(cls, cls4)) {
                                arrayList.add(aVar.c);
                            }
                        }
                    }
                    kr1 kr1 = ll1.f;
                    synchronized (kr1) {
                        if (cls5.isAssignableFrom(cls4)) {
                            jr1 = lr1.f2259a;
                        } else {
                            for (kr1.a<?, ?> aVar2 : kr1.f2108a) {
                                if (aVar2.a(cls4, cls5)) {
                                    jr1 = aVar2.c;
                                }
                            }
                            throw new IllegalArgumentException("No transcoder registered to transcode from " + cls4 + " to " + cls5);
                        }
                    }
                    arrayList2.add(new fn1(cls, cls4, cls5, arrayList, jr1, ll1.j));
                }
            }
        }
        if (arrayList2.isEmpty()) {
            pn12 = null;
        } else {
            pn12 = new pn1<>(cls, cls2, cls3, arrayList2, ll1.j);
        }
        ll1.i.b(cls, cls2, cls3, pn12);
        return pn12;
    }

    public <X> am1<X> e(X x) throws ll1.e {
        Object obj;
        hs1 hs1 = this.c.b.b;
        Class<?> cls = x.getClass();
        synchronized (hs1) {
            Iterator<hs1.a<?>> it = hs1.f1419a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = (am1<X>) null;
                    break;
                }
                hs1.a<?> next = it.next();
                if (next.f1420a.isAssignableFrom(cls)) {
                    obj = (am1<T>) next.b;
                    break;
                }
            }
        }
        if (obj != null) {
            return (am1<X>) obj;
        }
        throw new ll1.e(x.getClass());
    }

    public <Z> im1<Z> f(Class<Z> cls) {
        im1<Z> im1 = (im1<Z>) this.j.get(cls);
        if (im1 != null) {
            return im1;
        }
        if (!this.j.isEmpty() || !this.q) {
            return (yp1) yp1.b;
        }
        throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Class<?> */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean g(Class<?> cls) {
        return d(cls) != null;
    }
}
