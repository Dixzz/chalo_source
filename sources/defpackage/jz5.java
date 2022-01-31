package defpackage;

import android.os.Looper;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: jz5  reason: default package */
/* compiled from: EventBus */
public class jz5 {
    public static ExecutorService k = Executors.newCachedThreadPool();
    public static String l = "Event";
    public static volatile jz5 m;
    public static final Map<Class<?>, List<Class<?>>> n = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    public final Map<Class<?>, CopyOnWriteArrayList<sz5>> f2002a = new HashMap();
    public final Map<Object, List<Class<?>>> b = new HashMap();
    public final Map<Class<?>, Object> c = new ConcurrentHashMap();
    public final ThreadLocal<b> d = new a(this);
    public String e = "onEvent";
    public final lz5 f = new lz5(this, Looper.getMainLooper(), 10);
    public final iz5 g = new iz5(this);
    public final hz5 h = new hz5(this);
    public final rz5 i = new rz5();
    public boolean j = true;

    /* renamed from: jz5$a */
    /* compiled from: EventBus */
    public class a extends ThreadLocal<b> {
        public a(jz5 jz5) {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.lang.ThreadLocal
        public b initialValue() {
            return new b();
        }
    }

    /* renamed from: jz5$b */
    /* compiled from: EventBus */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public List<Object> f2003a = new ArrayList();
        public boolean b;
        public boolean c;
        public Object d;
    }

    public static void a(List<Class<?>> list, Class<?>[] clsArr) {
        for (Class<?> cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                a(list, cls.getInterfaces());
            }
        }
    }

    public static jz5 b() {
        if (m == null) {
            synchronized (jz5.class) {
                if (m == null) {
                    m = new jz5();
                }
            }
        }
        return m;
    }

    public <T> T c(Class<T> cls) {
        T cast;
        synchronized (this.c) {
            cast = cls.cast(this.c.get(cls));
        }
        return cast;
    }

    public void d(nz5 nz5) {
        Object obj = nz5.f2626a;
        sz5 sz5 = nz5.b;
        nz5.f2626a = null;
        nz5.b = null;
        nz5.c = null;
        List<nz5> list = nz5.d;
        synchronized (list) {
            if (list.size() < 10000) {
                list.add(nz5);
            }
        }
        if (sz5.d) {
            e(sz5, obj);
        }
    }

    public void e(sz5 sz5, Object obj) throws Error {
        try {
            sz5.b.f3016a.invoke(sz5.f3283a, obj);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (obj instanceof pz5) {
                StringBuilder i0 = hj1.i0("SubscriberExceptionEvent subscriber ");
                i0.append(sz5.f3283a.getClass());
                i0.append(" threw an exception");
                i0.toString();
                pz5 pz5 = (pz5) obj;
                StringBuilder i02 = hj1.i0("Initial event ");
                i02.append(pz5.b);
                i02.append(" caused exception in ");
                i02.append(pz5.c);
                i02.toString();
                return;
            }
            if (this.j) {
                StringBuilder i03 = hj1.i0("Could not dispatch event: ");
                i03.append(obj.getClass());
                i03.append(" to subscribing class ");
                i03.append(sz5.f3283a.getClass());
                i03.toString();
            }
            g(new pz5(this, cause, obj, sz5.f3283a));
        } catch (IllegalAccessException e3) {
            throw new IllegalStateException("Unexpected exception", e3);
        }
    }

    public synchronized boolean f(Object obj) {
        return this.b.containsKey(obj);
    }

    public void g(Object obj) {
        b bVar = this.d.get();
        List<Object> list = bVar.f2003a;
        list.add(obj);
        if (!bVar.b) {
            bVar.c = Looper.getMainLooper() == Looper.myLooper();
            bVar.b = true;
            while (!list.isEmpty()) {
                try {
                    h(list.remove(0), bVar);
                } finally {
                    bVar.b = false;
                    bVar.c = false;
                }
            }
        }
    }

    public final void h(Object obj, b bVar) throws Error {
        ArrayList arrayList;
        CopyOnWriteArrayList<sz5> copyOnWriteArrayList;
        Class<?> cls = obj.getClass();
        Map<Class<?>, List<Class<?>>> map = n;
        synchronized (map) {
            List<Class<?>> list = map.get(cls);
            arrayList = list;
            if (list == null) {
                ArrayList arrayList2 = new ArrayList();
                for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                    arrayList2.add(cls2);
                    a(arrayList2, cls2.getInterfaces());
                }
                n.put(cls, arrayList2);
                arrayList = arrayList2;
            }
        }
        int size = arrayList.size();
        boolean z = false;
        for (int i2 = 0; i2 < size; i2++) {
            Class<?> cls3 = arrayList.get(i2);
            synchronized (this) {
                copyOnWriteArrayList = this.f2002a.get(cls3);
            }
            if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                Iterator<sz5> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    sz5 next = it.next();
                    bVar.d = obj;
                    j(next, obj, bVar.c);
                }
                z = true;
            }
        }
        if (!z) {
            String str = "No subscribers registered for event " + cls;
            if (!(cls == mz5.class || cls == pz5.class)) {
                g(new mz5(this, obj));
            }
        }
    }

    public void i(Object obj) {
        synchronized (this.c) {
            this.c.put(obj.getClass(), obj);
        }
        g(obj);
    }

    public final void j(sz5 sz5, Object obj, boolean z) {
        int ordinal = sz5.b.b.ordinal();
        if (ordinal == 0) {
            e(sz5, obj);
        } else if (ordinal != 1) {
            if (ordinal != 2) {
                if (ordinal == 3) {
                    hz5 hz5 = this.h;
                    Objects.requireNonNull(hz5);
                    hz5.f.a(nz5.a(sz5, obj));
                    k.execute(hz5);
                    return;
                }
                StringBuilder i0 = hj1.i0("Unknown thread mode: ");
                i0.append(sz5.b.b);
                throw new IllegalStateException(i0.toString());
            } else if (z) {
                iz5 iz5 = this.g;
                Objects.requireNonNull(iz5);
                nz5 a2 = nz5.a(sz5, obj);
                synchronized (iz5) {
                    iz5.f.a(a2);
                    if (!iz5.g) {
                        iz5.g = true;
                        k.execute(iz5);
                    }
                }
            } else {
                e(sz5, obj);
            }
        } else if (z) {
            e(sz5, obj);
        } else {
            lz5 lz5 = this.f;
            Objects.requireNonNull(lz5);
            nz5 a3 = nz5.a(sz5, obj);
            synchronized (lz5) {
                lz5.f2299a.a(a3);
                if (!lz5.d) {
                    lz5.d = true;
                    if (!lz5.sendMessage(lz5.obtainMessage())) {
                        throw new kz5("Could not send handler message");
                    }
                }
            }
        }
    }

    public final synchronized void k(Object obj, String str, boolean z, int i2) {
        for (qz5 qz5 : this.i.a(obj.getClass(), str)) {
            n(obj, qz5, z, i2);
        }
    }

    public <T> T l(Class<T> cls) {
        T cast;
        synchronized (this.c) {
            cast = cls.cast(this.c.remove(cls));
        }
        return cast;
    }

    public boolean m(Object obj) {
        synchronized (this.c) {
            Class<?> cls = obj.getClass();
            if (!obj.equals(this.c.get(cls))) {
                return false;
            }
            this.c.remove(cls);
            return true;
        }
    }

    public final void n(Object obj, qz5 qz5, boolean z, int i2) {
        Object obj2;
        Class<?> cls = qz5.c;
        CopyOnWriteArrayList<sz5> copyOnWriteArrayList = this.f2002a.get(cls);
        sz5 sz5 = new sz5(obj, qz5, i2);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.f2002a.put(cls, copyOnWriteArrayList);
        } else {
            Iterator<sz5> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                if (it.next().equals(sz5)) {
                    StringBuilder i0 = hj1.i0("Subscriber ");
                    i0.append(obj.getClass());
                    i0.append(" already registered to event ");
                    i0.append(cls);
                    throw new kz5(i0.toString());
                }
            }
        }
        int size = copyOnWriteArrayList.size();
        boolean z2 = false;
        int i3 = 0;
        while (true) {
            if (i3 > size) {
                break;
            } else if (i3 == size || sz5.c > copyOnWriteArrayList.get(i3).c) {
                copyOnWriteArrayList.add(i3, sz5);
            } else {
                i3++;
            }
        }
        copyOnWriteArrayList.add(i3, sz5);
        List<Class<?>> list = this.b.get(obj);
        if (list == null) {
            list = new ArrayList<>();
            this.b.put(obj, list);
        }
        list.add(cls);
        if (z) {
            synchronized (this.c) {
                obj2 = this.c.get(cls);
            }
            if (obj2 != null) {
                if (Looper.getMainLooper() == Looper.myLooper()) {
                    z2 = true;
                }
                j(sz5, obj2, z2);
            }
        }
    }

    public synchronized void o(Object obj) {
        List<Class<?>> list = this.b.get(obj);
        if (list != null) {
            for (Class<?> cls : list) {
                CopyOnWriteArrayList<sz5> copyOnWriteArrayList = this.f2002a.get(cls);
                if (copyOnWriteArrayList != null) {
                    int size = copyOnWriteArrayList.size();
                    int i2 = 0;
                    while (i2 < size) {
                        sz5 sz5 = copyOnWriteArrayList.get(i2);
                        if (sz5.f3283a == obj) {
                            sz5.d = false;
                            copyOnWriteArrayList.remove(i2);
                            i2--;
                            size--;
                        }
                        i2++;
                    }
                }
            }
            this.b.remove(obj);
        } else {
            String str = "Subscriber to unregister was not registered before: " + obj.getClass();
        }
    }
}
