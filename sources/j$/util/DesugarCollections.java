package j$.util;

import a.C0118x;
import a.C0122z;
import a.U;
import j$.time.chrono.b;
import j$.util.Collection;
import j$.util.List;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Consumer;
import j$.util.function.Function;
import j$.util.function.Predicate;
import j$.util.function.UnaryOperator;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class DesugarCollections {

    /* renamed from: a  reason: collision with root package name */
    public static final Class f1644a;
    static final Class b = Collections.synchronizedList(new LinkedList()).getClass();
    private static final Field c;
    private static final Field d;
    private static final Constructor e;
    private static final Constructor f;

    /* access modifiers changed from: private */
    public static class a<K, V> implements Map<K, V>, Serializable, Map {

        /* renamed from: a  reason: collision with root package name */
        private final Map f1645a;
        final Object b = this;
        private transient Set c;
        private transient Set d;
        private transient Collection e;

        a(Map map) {
            Objects.requireNonNull(map);
            this.f1645a = map;
        }

        private Set a(Set set, Object obj) {
            if (DesugarCollections.f == null) {
                return Collections.synchronizedSet(set);
            }
            try {
                return (Set) DesugarCollections.f.newInstance(set, obj);
            } catch (IllegalAccessException | InstantiationException | InvocationTargetException e2) {
                throw new Error("Unable to instantiate a synchronized list.", e2);
            }
        }

        @Override // j$.util.Map
        public void clear() {
            synchronized (this.b) {
                this.f1645a.clear();
            }
        }

        @Override // j$.util.Map
        public Object compute(Object obj, BiFunction biFunction) {
            Object m;
            synchronized (this.b) {
                m = b.m(this.f1645a, obj, biFunction);
            }
            return m;
        }

        @Override // java.util.Map
        public Object compute(Object obj, java.util.function.BiFunction biFunction) {
            Object m;
            BiFunction b2 = C0122z.b(biFunction);
            synchronized (this.b) {
                m = b.m(this.f1645a, obj, b2);
            }
            return m;
        }

        @Override // j$.util.Map
        public Object computeIfAbsent(Object obj, Function function) {
            Object n;
            synchronized (this.b) {
                n = b.n(this.f1645a, obj, function);
            }
            return n;
        }

        @Override // java.util.Map
        public Object computeIfAbsent(Object obj, java.util.function.Function function) {
            Object n;
            Function c2 = U.c(function);
            synchronized (this.b) {
                n = b.n(this.f1645a, obj, c2);
            }
            return n;
        }

        @Override // j$.util.Map
        public Object computeIfPresent(Object obj, BiFunction biFunction) {
            Object o;
            synchronized (this.b) {
                o = b.o(this.f1645a, obj, biFunction);
            }
            return o;
        }

        @Override // java.util.Map
        public Object computeIfPresent(Object obj, java.util.function.BiFunction biFunction) {
            Object o;
            BiFunction b2 = C0122z.b(biFunction);
            synchronized (this.b) {
                o = b.o(this.f1645a, obj, b2);
            }
            return o;
        }

        @Override // j$.util.Map
        public boolean containsKey(Object obj) {
            boolean containsKey;
            synchronized (this.b) {
                containsKey = this.f1645a.containsKey(obj);
            }
            return containsKey;
        }

        @Override // j$.util.Map
        public boolean containsValue(Object obj) {
            boolean containsValue;
            synchronized (this.b) {
                containsValue = this.f1645a.containsValue(obj);
            }
            return containsValue;
        }

        @Override // java.util.Map, j$.util.Map
        public Set entrySet() {
            Set set;
            synchronized (this.b) {
                if (this.d == null) {
                    this.d = a(this.f1645a.entrySet(), this.b);
                }
                set = this.d;
            }
            return set;
        }

        @Override // j$.util.Map
        public boolean equals(Object obj) {
            boolean equals;
            if (this == obj) {
                return true;
            }
            synchronized (this.b) {
                equals = this.f1645a.equals(obj);
            }
            return equals;
        }

        @Override // j$.util.Map
        public void forEach(BiConsumer biConsumer) {
            synchronized (this.b) {
                b.z(this.f1645a, biConsumer);
            }
        }

        @Override // java.util.Map
        public void forEach(java.util.function.BiConsumer biConsumer) {
            BiConsumer b2 = C0118x.b(biConsumer);
            synchronized (this.b) {
                b.z(this.f1645a, b2);
            }
        }

        @Override // java.util.Map, j$.util.Map
        public Object get(Object obj) {
            Object obj2;
            synchronized (this.b) {
                obj2 = this.f1645a.get(obj);
            }
            return obj2;
        }

        @Override // java.util.Map, j$.util.Map
        public Object getOrDefault(Object obj, Object obj2) {
            Object A;
            synchronized (this.b) {
                A = b.A(this.f1645a, obj, obj2);
            }
            return A;
        }

        @Override // j$.util.Map
        public int hashCode() {
            int hashCode;
            synchronized (this.b) {
                hashCode = this.f1645a.hashCode();
            }
            return hashCode;
        }

        @Override // j$.util.Map
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.b) {
                isEmpty = this.f1645a.isEmpty();
            }
            return isEmpty;
        }

        @Override // java.util.Map, j$.util.Map
        public Set keySet() {
            Set set;
            synchronized (this.b) {
                if (this.c == null) {
                    this.c = a(this.f1645a.keySet(), this.b);
                }
                set = this.c;
            }
            return set;
        }

        @Override // j$.util.Map
        public Object merge(Object obj, Object obj2, BiFunction biFunction) {
            Object B;
            synchronized (this.b) {
                B = b.B(this.f1645a, obj, obj2, biFunction);
            }
            return B;
        }

        @Override // java.util.Map
        public Object merge(Object obj, Object obj2, java.util.function.BiFunction biFunction) {
            Object B;
            BiFunction b2 = C0122z.b(biFunction);
            synchronized (this.b) {
                B = b.B(this.f1645a, obj, obj2, b2);
            }
            return B;
        }

        @Override // java.util.Map, j$.util.Map
        public Object put(Object obj, Object obj2) {
            Object put;
            synchronized (this.b) {
                put = this.f1645a.put(obj, obj2);
            }
            return put;
        }

        @Override // java.util.Map, j$.util.Map
        public void putAll(Map map) {
            synchronized (this.b) {
                this.f1645a.putAll(map);
            }
        }

        @Override // java.util.Map, j$.util.Map
        public Object putIfAbsent(Object obj, Object obj2) {
            Object C;
            synchronized (this.b) {
                C = b.C(this.f1645a, obj, obj2);
            }
            return C;
        }

        @Override // java.util.Map, j$.util.Map
        public Object remove(Object obj) {
            Object remove;
            synchronized (this.b) {
                remove = this.f1645a.remove(obj);
            }
            return remove;
        }

        @Override // j$.util.Map
        public boolean remove(Object obj, Object obj2) {
            boolean D;
            synchronized (this.b) {
                D = b.D(this.f1645a, obj, obj2);
            }
            return D;
        }

        @Override // java.util.Map, j$.util.Map
        public Object replace(Object obj, Object obj2) {
            Object E;
            synchronized (this.b) {
                E = b.E(this.f1645a, obj, obj2);
            }
            return E;
        }

        @Override // java.util.Map, j$.util.Map
        public boolean replace(Object obj, Object obj2, Object obj3) {
            boolean F;
            synchronized (this.b) {
                F = b.F(this.f1645a, obj, obj2, obj3);
            }
            return F;
        }

        @Override // j$.util.Map
        public void replaceAll(BiFunction biFunction) {
            synchronized (this.b) {
                b.G(this.f1645a, biFunction);
            }
        }

        @Override // java.util.Map
        public void replaceAll(java.util.function.BiFunction biFunction) {
            BiFunction b2 = C0122z.b(biFunction);
            synchronized (this.b) {
                b.G(this.f1645a, b2);
            }
        }

        @Override // j$.util.Map
        public int size() {
            int size;
            synchronized (this.b) {
                size = this.f1645a.size();
            }
            return size;
        }

        public String toString() {
            String obj;
            synchronized (this.b) {
                obj = this.f1645a.toString();
            }
            return obj;
        }

        @Override // java.util.Map, j$.util.Map
        public Collection values() {
            Collection collection;
            Collection collection2;
            synchronized (this.b) {
                if (this.e == null) {
                    Collection<V> values = this.f1645a.values();
                    Object obj = this.b;
                    if (DesugarCollections.e == null) {
                        collection2 = Collections.synchronizedCollection(values);
                    } else {
                        try {
                            collection2 = (Collection) DesugarCollections.e.newInstance(values, obj);
                        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e2) {
                            throw new Error("Unable to instantiate a synchronized list.", e2);
                        }
                    }
                    this.e = collection2;
                }
                collection = this.e;
            }
            return collection;
        }
    }

    static {
        Field field;
        Field field2;
        Constructor<?> constructor;
        Class<?> cls = Collections.synchronizedCollection(new ArrayList()).getClass();
        f1644a = cls;
        Constructor<?> constructor2 = null;
        try {
            field = cls.getDeclaredField("mutex");
        } catch (NoSuchFieldException unused) {
            field = null;
        }
        c = field;
        if (field != null) {
            field.setAccessible(true);
        }
        try {
            field2 = cls.getDeclaredField("c");
        } catch (NoSuchFieldException unused2) {
            field2 = null;
        }
        d = field2;
        if (field2 != null) {
            field2.setAccessible(true);
        }
        try {
            constructor = Collections.synchronizedSet(new HashSet()).getClass().getDeclaredConstructor(Set.class, Object.class);
        } catch (NoSuchMethodException unused3) {
            constructor = null;
        }
        f = constructor;
        if (constructor != null) {
            constructor.setAccessible(true);
        }
        try {
            constructor2 = cls.getDeclaredConstructor(Collection.class, Object.class);
        } catch (NoSuchMethodException unused4) {
        }
        e = constructor2;
        if (constructor2 != null) {
            constructor2.setAccessible(true);
        }
    }

    private DesugarCollections() {
    }

    public static void c(Iterable iterable, Consumer consumer) {
        Field field = c;
        if (field == null) {
            try {
                b.y((Collection) d.get(iterable), consumer);
            } catch (IllegalAccessException e2) {
                throw new Error("Runtime illegal access in synchronized collection forEach fall-back.", e2);
            }
        } else {
            try {
                synchronized (field.get(iterable)) {
                    b.y((Collection) d.get(iterable), consumer);
                }
            } catch (IllegalAccessException e3) {
                throw new Error("Runtime illegal access in synchronized collection forEach.", e3);
            }
        }
    }

    static boolean d(Collection collection, Predicate predicate) {
        boolean removeIf;
        Field field = c;
        if (field == null) {
            try {
                Collection collection2 = (Collection) d.get(collection);
                return collection2 instanceof Collection ? ((Collection) collection2).removeIf(predicate) : Collection.CC.$default$removeIf(collection2, predicate);
            } catch (IllegalAccessException e2) {
                throw new Error("Runtime illegal access in synchronized collection removeIf fall-back.", e2);
            }
        } else {
            try {
                synchronized (field.get(collection)) {
                    java.util.Collection collection3 = (java.util.Collection) d.get(collection);
                    removeIf = collection3 instanceof Collection ? ((Collection) collection3).removeIf(predicate) : Collection.CC.$default$removeIf(collection3, predicate);
                }
                return removeIf;
            } catch (IllegalAccessException e3) {
                throw new Error("Runtime illegal access in synchronized collection removeIf.", e3);
            }
        }
    }

    static void e(List list, UnaryOperator unaryOperator) {
        Field field = c;
        if (field == null) {
            try {
                List list2 = (List) d.get(list);
                if (list2 instanceof List) {
                    ((List) list2).replaceAll(unaryOperator);
                } else {
                    List.CC.$default$replaceAll(list2, unaryOperator);
                }
            } catch (IllegalAccessException e2) {
                throw new Error("Runtime illegal access in synchronized list replaceAll fall-back.", e2);
            }
        } else {
            try {
                synchronized (field.get(list)) {
                    java.util.List list3 = (java.util.List) d.get(list);
                    if (list3 instanceof List) {
                        ((List) list3).replaceAll(unaryOperator);
                    } else {
                        List.CC.$default$replaceAll(list3, unaryOperator);
                    }
                }
            } catch (IllegalAccessException e3) {
                throw new Error("Runtime illegal access in synchronized list replaceAll.", e3);
            }
        }
    }

    static void f(java.util.List list, Comparator comparator) {
        Field field = c;
        if (field == null) {
            try {
                b.H((java.util.List) d.get(list), comparator);
            } catch (IllegalAccessException e2) {
                throw new Error("Runtime illegal access in synchronized collection sort fall-back.", e2);
            }
        } else {
            try {
                synchronized (field.get(list)) {
                    b.H((java.util.List) d.get(list), comparator);
                }
            } catch (IllegalAccessException e3) {
                throw new Error("Runtime illegal access in synchronized list sort.", e3);
            }
        }
    }

    public static Map synchronizedMap(Map map) {
        return new a(map);
    }
}
