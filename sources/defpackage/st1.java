package defpackage;

import android.util.Log;
import defpackage.vt1;

/* renamed from: st1  reason: default package */
/* compiled from: FactoryPools */
public final class st1 {

    /* renamed from: a  reason: collision with root package name */
    public static final e<Object> f3253a = new a();

    /* renamed from: st1$a */
    /* compiled from: FactoryPools */
    public static class a implements e<Object> {
        @Override // defpackage.st1.e
        public void a(Object obj) {
        }
    }

    /* renamed from: st1$b */
    /* compiled from: FactoryPools */
    public interface b<T> {
        T a();
    }

    /* renamed from: st1$c */
    /* compiled from: FactoryPools */
    public static final class c<T> implements v7<T> {

        /* renamed from: a  reason: collision with root package name */
        public final b<T> f3254a;
        public final e<T> b;
        public final v7<T> c;

        public c(v7<T> v7Var, b<T> bVar, e<T> eVar) {
            this.c = v7Var;
            this.f3254a = bVar;
            this.b = eVar;
        }

        @Override // defpackage.v7
        public boolean a(T t) {
            if (t instanceof d) {
                ((vt1.b) t.g()).f3681a = true;
            }
            this.b.a(t);
            return this.c.a(t);
        }

        @Override // defpackage.v7
        public T b() {
            T b2 = this.c.b();
            if (b2 == null) {
                b2 = this.f3254a.a();
                if (Log.isLoggable("FactoryPools", 2)) {
                    StringBuilder i0 = hj1.i0("Created new ");
                    i0.append(b2.getClass());
                    i0.toString();
                }
            }
            if (b2 instanceof d) {
                ((vt1.b) b2.g()).f3681a = false;
            }
            return b2;
        }
    }

    /* renamed from: st1$d */
    /* compiled from: FactoryPools */
    public interface d {
        vt1 g();
    }

    /* renamed from: st1$e */
    /* compiled from: FactoryPools */
    public interface e<T> {
        void a(T t);
    }

    public static <T extends d> v7<T> a(int i, b<T> bVar) {
        return new c(new w7(i), bVar, f3253a);
    }
}
