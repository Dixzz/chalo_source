package defpackage;

import defpackage.hs1;
import defpackage.kr1;
import defpackage.lm1;
import defpackage.ls1;
import defpackage.mp1;
import defpackage.ms1;
import defpackage.st1;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ll1  reason: default package */
/* compiled from: Registry */
public class ll1 {

    /* renamed from: a  reason: collision with root package name */
    public final kp1 f2233a;
    public final hs1 b;
    public final ls1 c;
    public final ms1 d;
    public final mm1 e;
    public final kr1 f;
    public final is1 g;
    public final ks1 h = new ks1();
    public final js1 i = new js1();
    public final v7<List<Exception>> j;

    /* renamed from: ll1$a */
    /* compiled from: Registry */
    public static class a extends RuntimeException {
        public a(String str) {
            super(str);
        }
    }

    /* renamed from: ll1$b */
    /* compiled from: Registry */
    public static final class b extends a {
        public b() {
            super("Failed to find image header parser.");
        }
    }

    /* renamed from: ll1$c */
    /* compiled from: Registry */
    public static class c extends a {
        public c(Object obj) {
            super("Failed to find any ModelLoaders for model: " + obj);
        }

        public c(Class<?> cls, Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }
    }

    /* renamed from: ll1$d */
    /* compiled from: Registry */
    public static class d extends a {
        public d(Class<?> cls) {
            super("Failed to find result encoder for resource class: " + cls);
        }
    }

    /* renamed from: ll1$e */
    /* compiled from: Registry */
    public static class e extends a {
        public e(Class<?> cls) {
            super("Failed to find source encoder for data class: " + cls);
        }
    }

    public ll1() {
        st1.c cVar = new st1.c(new x7(20), new tt1(), new ut1());
        this.j = cVar;
        this.f2233a = new kp1(cVar);
        this.b = new hs1();
        this.c = new ls1();
        this.d = new ms1();
        this.e = new mm1();
        this.f = new kr1();
        this.g = new is1();
    }

    public <Data, TResource> ll1 a(Class<Data> cls, Class<TResource> cls2, gm1<Data, TResource> gm1) {
        ls1 ls1 = this.c;
        synchronized (ls1) {
            ls1.f2262a.add(new ls1.a<>(cls, cls2, gm1));
        }
        return this;
    }

    public <Model, Data> ll1 b(Class<Model> cls, Class<Data> cls2, jp1<Model, Data> jp1) {
        kp1 kp1 = this.f2233a;
        synchronized (kp1) {
            mp1 mp1 = kp1.f2097a;
            synchronized (mp1) {
                mp1.b<?, ?> bVar = new mp1.b<>(cls, cls2, jp1);
                List<mp1.b<?, ?>> list = mp1.f2424a;
                list.add(list.size(), bVar);
            }
            kp1.b.f2098a.clear();
        }
        return this;
    }

    public List<cm1> c() {
        List<cm1> list;
        is1 is1 = this.g;
        synchronized (is1) {
            list = is1.f1567a;
        }
        if (!list.isEmpty()) {
            return list;
        }
        throw new b();
    }

    public <Model> List<ip1<Model, ?>> d(Model model) {
        ArrayList arrayList;
        kp1 kp1 = this.f2233a;
        synchronized (kp1) {
            List a2 = kp1.a(model.getClass());
            int size = a2.size();
            arrayList = new ArrayList(size);
            for (int i2 = 0; i2 < size; i2++) {
                ip1 ip1 = (ip1) a2.get(i2);
                if (ip1.a(model)) {
                    arrayList.add(ip1);
                }
            }
        }
        if (!arrayList.isEmpty()) {
            return arrayList;
        }
        throw new c(model);
    }

    public <Data, TResource> ll1 e(Class<Data> cls, Class<TResource> cls2, gm1<Data, TResource> gm1) {
        ls1 ls1 = this.c;
        synchronized (ls1) {
            ls1.f2262a.add(0, new ls1.a<>(cls, cls2, gm1));
        }
        return this;
    }

    public ll1 f(lm1.a aVar) {
        mm1 mm1 = this.e;
        synchronized (mm1) {
            mm1.f2397a.put(aVar.a(), aVar);
        }
        return this;
    }

    public <Data> ll1 g(Class<Data> cls, am1<Data> am1) {
        hs1 hs1 = this.b;
        synchronized (hs1) {
            hs1.f1419a.add(new hs1.a<>(cls, am1));
        }
        return this;
    }

    public <TResource> ll1 h(Class<TResource> cls, hm1<TResource> hm1) {
        ms1 ms1 = this.d;
        synchronized (ms1) {
            ms1.f2431a.add(new ms1.a<>(cls, hm1));
        }
        return this;
    }

    public <TResource, Transcode> ll1 i(Class<TResource> cls, Class<Transcode> cls2, jr1<TResource, Transcode> jr1) {
        kr1 kr1 = this.f;
        synchronized (kr1) {
            kr1.f2108a.add(new kr1.a<>(cls, cls2, jr1));
        }
        return this;
    }
}
