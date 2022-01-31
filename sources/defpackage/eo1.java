package defpackage;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Objects;
import java.util.TreeMap;

/* renamed from: eo1  reason: default package */
/* compiled from: LruArrayPool */
public final class eo1 implements xn1 {

    /* renamed from: a  reason: collision with root package name */
    public final co1<a, Object> f1012a = new co1<>();
    public final b b = new b();
    public final Map<Class<?>, NavigableMap<Integer, Integer>> c = new HashMap();
    public final Map<Class<?>, wn1<?>> d = new HashMap();
    public final int e;
    public int f;

    /* renamed from: eo1$a */
    /* compiled from: LruArrayPool */
    public static final class a implements ho1 {

        /* renamed from: a  reason: collision with root package name */
        public final b f1013a;
        public int b;
        public Class<?> c;

        public a(b bVar) {
            this.f1013a = bVar;
        }

        @Override // defpackage.ho1
        public void a() {
            this.f1013a.c(this);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.b == aVar.b && this.c == aVar.c) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i = this.b * 31;
            Class<?> cls = this.c;
            return i + (cls != null ? cls.hashCode() : 0);
        }

        public String toString() {
            StringBuilder i0 = hj1.i0("Key{size=");
            i0.append(this.b);
            i0.append("array=");
            i0.append(this.c);
            i0.append('}');
            return i0.toString();
        }
    }

    /* renamed from: eo1$b */
    /* compiled from: LruArrayPool */
    public static final class b extends yn1<a> {
        /* Return type fixed from 'ho1' to match base method */
        @Override // defpackage.yn1
        public a a() {
            return new a(this);
        }

        public a d(int i, Class<?> cls) {
            a aVar = (a) b();
            aVar.b = i;
            aVar.c = cls;
            return aVar;
        }
    }

    public eo1(int i) {
        this.e = i;
    }

    @Override // defpackage.xn1
    public synchronized void a(int i) {
        if (i >= 40) {
            synchronized (this) {
                f(0);
            }
        } else if (i >= 20) {
            f(this.e / 2);
        }
    }

    @Override // defpackage.xn1
    public synchronized void b() {
        f(0);
    }

    @Override // defpackage.xn1
    public synchronized <T> void c(T t, Class<T> cls) {
        wn1<T> g = g(cls);
        int c2 = g.c(t);
        int b2 = g.b() * c2;
        int i = 1;
        if (b2 <= this.e / 2) {
            a d2 = this.b.d(c2, cls);
            this.f1012a.b(d2, t);
            NavigableMap<Integer, Integer> h = h(cls);
            Integer num = (Integer) h.get(Integer.valueOf(d2.b));
            Integer valueOf = Integer.valueOf(d2.b);
            if (num != null) {
                i = 1 + num.intValue();
            }
            h.put(valueOf, Integer.valueOf(i));
            this.f += b2;
            f(this.e);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: java.lang.Class<T> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0052  */
    @Override // defpackage.xn1
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T d(int r8, java.lang.Class<T> r9) {
        /*
        // Method dump skipped, instructions count: 128
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.eo1.d(int, java.lang.Class):java.lang.Object");
    }

    public final void e(int i, Class<?> cls) {
        NavigableMap<Integer, Integer> h = h(cls);
        Integer num = (Integer) h.get(Integer.valueOf(i));
        if (num == null) {
            throw new NullPointerException("Tried to decrement empty size, size: " + i + ", this: " + this);
        } else if (num.intValue() == 1) {
            h.remove(Integer.valueOf(i));
        } else {
            h.put(Integer.valueOf(i), Integer.valueOf(num.intValue() - 1));
        }
    }

    public final void f(int i) {
        while (this.f > i) {
            Object c2 = this.f1012a.c();
            Objects.requireNonNull(c2, "Argument must not be null");
            wn1 g = g(c2.getClass());
            this.f -= g.b() * g.c(c2);
            e(g.c(c2), c2.getClass());
            if (Log.isLoggable(g.a(), 2)) {
                g.a();
                g.c(c2);
            }
        }
    }

    public final <T> wn1<T> g(Class<T> cls) {
        bo1 bo1 = (wn1<T>) this.d.get(cls);
        if (bo1 == null) {
            if (cls.equals(int[].class)) {
                bo1 = new do1();
            } else if (cls.equals(byte[].class)) {
                bo1 = new bo1();
            } else {
                StringBuilder i0 = hj1.i0("No array pool found for: ");
                i0.append(cls.getSimpleName());
                throw new IllegalArgumentException(i0.toString());
            }
            this.d.put(cls, bo1);
        }
        return bo1;
    }

    public final NavigableMap<Integer, Integer> h(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = this.c.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.c.put(cls, treeMap);
        return treeMap;
    }
}
