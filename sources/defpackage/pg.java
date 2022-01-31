package defpackage;

import defpackage.zg;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* renamed from: pg  reason: default package */
/* compiled from: ClassesInfoCache */
public final class pg {
    public static pg c = new pg();

    /* renamed from: a  reason: collision with root package name */
    public final Map<Class<?>, a> f2799a = new HashMap();
    public final Map<Class<?>, Boolean> b = new HashMap();

    /* renamed from: pg$a */
    /* compiled from: ClassesInfoCache */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final Map<zg.a, List<b>> f2800a = new HashMap();
        public final Map<b, zg.a> b;

        public a(Map<b, zg.a> map) {
            this.b = map;
            for (Map.Entry<b, zg.a> entry : map.entrySet()) {
                zg.a value = entry.getValue();
                List<b> list = this.f2800a.get(value);
                if (list == null) {
                    list = new ArrayList<>();
                    this.f2800a.put(value, list);
                }
                list.add(entry.getKey());
            }
        }

        public static void a(List<b> list, fh fhVar, zg.a aVar, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    b bVar = list.get(size);
                    Objects.requireNonNull(bVar);
                    try {
                        int i = bVar.f2801a;
                        if (i == 0) {
                            bVar.b.invoke(obj, new Object[0]);
                        } else if (i == 1) {
                            bVar.b.invoke(obj, fhVar);
                        } else if (i == 2) {
                            bVar.b.invoke(obj, fhVar, aVar);
                        }
                    } catch (InvocationTargetException e) {
                        throw new RuntimeException("Failed to call observer method", e.getCause());
                    } catch (IllegalAccessException e2) {
                        throw new RuntimeException(e2);
                    }
                }
            }
        }
    }

    /* renamed from: pg$b */
    /* compiled from: ClassesInfoCache */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f2801a;
        public final Method b;

        public b(int i, Method method) {
            this.f2801a = i;
            this.b = method;
            method.setAccessible(true);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f2801a != bVar.f2801a || !this.b.getName().equals(bVar.b.getName())) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.b.getName().hashCode() + (this.f2801a * 31);
        }
    }

    public final a a(Class<?> cls, Method[] methodArr) {
        int i;
        a b2;
        Class<?> superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (!(superclass == null || (b2 = b(superclass)) == null)) {
            hashMap.putAll(b2.b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry<b, zg.a> entry : b(cls2).b.entrySet()) {
                c(hashMap, entry.getKey(), entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            try {
                methodArr = cls.getDeclaredMethods();
            } catch (NoClassDefFoundError e) {
                throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
            }
        }
        boolean z = false;
        for (Method method : methodArr) {
            qh qhVar = (qh) method.getAnnotation(qh.class);
            if (qhVar != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else if (parameterTypes[0].isAssignableFrom(fh.class)) {
                    i = 1;
                } else {
                    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                }
                zg.a value = qhVar.value();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(zg.a.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    } else if (value == zg.a.ON_ANY) {
                        i = 2;
                    } else {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                }
                if (parameterTypes.length <= 2) {
                    c(hashMap, new b(i, method), value, cls);
                    z = true;
                } else {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
            }
        }
        a aVar = new a(hashMap);
        this.f2799a.put(cls, aVar);
        this.b.put(cls, Boolean.valueOf(z));
        return aVar;
    }

    public a b(Class<?> cls) {
        a aVar = this.f2799a.get(cls);
        if (aVar != null) {
            return aVar;
        }
        return a(cls, null);
    }

    public final void c(Map<b, zg.a> map, b bVar, zg.a aVar, Class<?> cls) {
        zg.a aVar2 = map.get(bVar);
        if (aVar2 != null && aVar != aVar2) {
            Method method = bVar.b;
            StringBuilder i0 = hj1.i0("Method ");
            i0.append(method.getName());
            i0.append(" in ");
            i0.append(cls.getName());
            i0.append(" already declared with different @OnLifecycleEvent value: previous value ");
            i0.append(aVar2);
            i0.append(", new value ");
            i0.append(aVar);
            throw new IllegalArgumentException(i0.toString());
        } else if (aVar2 == null) {
            map.put(bVar, aVar);
        }
    }
}
