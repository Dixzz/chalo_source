package defpackage;

import defpackage.ip1;
import defpackage.ll1;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* renamed from: mp1  reason: default package */
/* compiled from: MultiModelLoaderFactory */
public class mp1 {
    public static final c e = new c();
    public static final ip1<Object, Object> f = new a();

    /* renamed from: a  reason: collision with root package name */
    public final List<b<?, ?>> f2424a = new ArrayList();
    public final c b;
    public final Set<b<?, ?>> c = new HashSet();
    public final v7<List<Exception>> d;

    /* renamed from: mp1$a */
    /* compiled from: MultiModelLoaderFactory */
    public static class a implements ip1<Object, Object> {
        @Override // defpackage.ip1
        public boolean a(Object obj) {
            return false;
        }

        @Override // defpackage.ip1
        public ip1.a<Object> b(Object obj, int i, int i2, fm1 fm1) {
            return null;
        }
    }

    /* renamed from: mp1$b */
    /* compiled from: MultiModelLoaderFactory */
    public static class b<Model, Data> {

        /* renamed from: a  reason: collision with root package name */
        public final Class<Model> f2425a;
        public final Class<Data> b;
        public final jp1<Model, Data> c;

        public b(Class<Model> cls, Class<Data> cls2, jp1<Model, Data> jp1) {
            this.f2425a = cls;
            this.b = cls2;
            this.c = jp1;
        }
    }

    /* renamed from: mp1$c */
    /* compiled from: MultiModelLoaderFactory */
    public static class c {
    }

    public mp1(v7<List<Exception>> v7Var) {
        c cVar = e;
        this.d = v7Var;
        this.b = cVar;
    }

    public final <Model, Data> ip1<Model, Data> a(b<?, ?> bVar) {
        ip1<Model, Data> b2 = bVar.c.b(this);
        Objects.requireNonNull(b2, "Argument must not be null");
        return b2;
    }

    public synchronized <Model, Data> ip1<Model, Data> b(Class<Model> cls, Class<Data> cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (b<?, ?> bVar : this.f2424a) {
                if (this.c.contains(bVar)) {
                    z = true;
                } else if (bVar.f2425a.isAssignableFrom(cls) && bVar.b.isAssignableFrom(cls2)) {
                    this.c.add(bVar);
                    arrayList.add(a(bVar));
                    this.c.remove(bVar);
                }
            }
            if (arrayList.size() > 1) {
                c cVar = this.b;
                v7<List<Exception>> v7Var = this.d;
                Objects.requireNonNull(cVar);
                return new lp1(arrayList, v7Var);
            } else if (arrayList.size() == 1) {
                return (ip1) arrayList.get(0);
            } else if (z) {
                return (ip1<Model, Data>) f;
            } else {
                throw new ll1.c(cls, cls2);
            }
        } catch (Throwable th) {
            this.c.clear();
            throw th;
        }
    }

    public synchronized List<Class<?>> c(Class<?> cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (b<?, ?> bVar : this.f2424a) {
            if (!arrayList.contains(bVar.b) && bVar.f2425a.isAssignableFrom(cls)) {
                arrayList.add(bVar.b);
            }
        }
        return arrayList;
    }
}
