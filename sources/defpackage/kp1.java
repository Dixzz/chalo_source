package defpackage;

import defpackage.mp1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* renamed from: kp1  reason: default package */
/* compiled from: ModelLoaderRegistry */
public class kp1 {

    /* renamed from: a  reason: collision with root package name */
    public final mp1 f2097a;
    public final a b = new a();

    /* renamed from: kp1$a */
    /* compiled from: ModelLoaderRegistry */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final Map<Class<?>, C0041a<?>> f2098a = new HashMap();

        /* renamed from: kp1$a$a  reason: collision with other inner class name */
        /* compiled from: ModelLoaderRegistry */
        public static class C0041a<Model> {

            /* renamed from: a  reason: collision with root package name */
            public final List<ip1<Model, ?>> f2099a;

            public C0041a(List<ip1<Model, ?>> list) {
                this.f2099a = list;
            }
        }
    }

    public kp1(v7<List<Exception>> v7Var) {
        mp1 mp1 = new mp1(v7Var);
        this.f2097a = mp1;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:4:0x0010 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r0v9. Raw type applied. Possible types: java.util.List<ip1<Model, ?>> */
    public final <A> List<ip1<A, ?>> a(Class<A> cls) {
        ArrayList arrayList;
        a.C0041a<?> aVar = this.b.f2098a.get(cls);
        List list = aVar == null ? (List<ip1<A, ?>>) false : (List<ip1<Model, ?>>) aVar.f2099a;
        if (list == null) {
            mp1 mp1 = this.f2097a;
            synchronized (mp1) {
                try {
                    arrayList = new ArrayList();
                    for (mp1.b<?, ?> bVar : mp1.f2424a) {
                        if (!mp1.c.contains(bVar)) {
                            if (bVar.f2425a.isAssignableFrom(cls)) {
                                mp1.c.add(bVar);
                                ip1<Model, Data> b2 = bVar.c.b(mp1);
                                Objects.requireNonNull(b2, "Argument must not be null");
                                arrayList.add(b2);
                                mp1.c.remove(bVar);
                            }
                        }
                    }
                } catch (Throwable th) {
                    mp1.c.clear();
                    throw th;
                }
            }
            list = (List<ip1<A, ?>>) Collections.unmodifiableList(arrayList);
            if (this.b.f2098a.put(cls, new a.C0041a<>(list)) != null) {
                throw new IllegalStateException("Already cached loaders for model: " + cls);
            }
        }
        return (List<ip1<A, ?>>) list;
    }
}
