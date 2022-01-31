package j$.time.chrono;

import j$.time.temporal.c;
import j$.time.temporal.d;
import j$.time.temporal.e;
import j$.time.temporal.f;
import j$.time.temporal.g;
import j$.time.temporal.h;
import j$.time.temporal.i;
import j$.time.temporal.k;
import j$.time.temporal.l;
import j$.time.temporal.m;
import j$.time.temporal.n;
import j$.time.temporal.p;
import j$.time.temporal.q;
import j$.util.Collection;
import j$.util.Comparator;
import j$.util.List;
import j$.util.Map;
import j$.util.Optional;
import j$.util.Set;
import j$.util.Spliterator;
import j$.util.concurrent.a;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Consumer;
import j$.util.function.Function;
import j$.util.o;
import j$.util.r;
import j$.util.stream.A2;
import j$.util.u;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentMap;

public final /* synthetic */ class b {
    public static Object A(Map map, Object obj, Object obj2) {
        if (map instanceof j$.util.Map) {
            return ((j$.util.Map) map).getOrDefault(obj, obj2);
        }
        if (!(map instanceof ConcurrentMap)) {
            return Map.CC.$default$getOrDefault(map, obj, obj2);
        }
        Object obj3 = ((ConcurrentMap) map).get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    public static Object B(java.util.Map map, Object obj, Object obj2, BiFunction biFunction) {
        if (map instanceof j$.util.Map) {
            return ((j$.util.Map) map).merge(obj, obj2, biFunction);
        }
        if (!(map instanceof ConcurrentMap)) {
            return Map.CC.$default$merge(map, obj, obj2, biFunction);
        }
        ConcurrentMap concurrentMap = (ConcurrentMap) map;
        Objects.requireNonNull(biFunction);
        Objects.requireNonNull(obj2);
        while (true) {
            Object obj3 = concurrentMap.get(obj);
            while (obj3 == null) {
                obj3 = concurrentMap.putIfAbsent(obj, obj2);
                if (obj3 == null) {
                    return obj2;
                }
            }
            Object apply = biFunction.apply(obj3, obj2);
            if (apply != null) {
                if (concurrentMap.replace(obj, obj3, apply)) {
                    return apply;
                }
            } else if (concurrentMap.remove(obj, obj3)) {
                return null;
            }
        }
    }

    public static /* synthetic */ Object C(java.util.Map map, Object obj, Object obj2) {
        return map instanceof j$.util.Map ? ((j$.util.Map) map).putIfAbsent(obj, obj2) : Map.CC.$default$putIfAbsent(map, obj, obj2);
    }

    public static /* synthetic */ boolean D(java.util.Map map, Object obj, Object obj2) {
        return map instanceof j$.util.Map ? ((j$.util.Map) map).remove(obj, obj2) : Map.CC.$default$remove(map, obj, obj2);
    }

    public static /* synthetic */ Object E(java.util.Map map, Object obj, Object obj2) {
        return map instanceof j$.util.Map ? ((j$.util.Map) map).replace(obj, obj2) : Map.CC.$default$replace(map, obj, obj2);
    }

    public static /* synthetic */ boolean F(java.util.Map map, Object obj, Object obj2, Object obj3) {
        return map instanceof j$.util.Map ? ((j$.util.Map) map).replace(obj, obj2, obj3) : Map.CC.$default$replace(map, obj, obj2, obj3);
    }

    public static void G(java.util.Map map, BiFunction biFunction) {
        if (map instanceof j$.util.Map) {
            ((j$.util.Map) map).replaceAll(biFunction);
        } else if (map instanceof ConcurrentMap) {
            ConcurrentMap concurrentMap = (ConcurrentMap) map;
            Objects.requireNonNull(biFunction);
            a aVar = new a(concurrentMap, biFunction);
            if (concurrentMap instanceof j$.util.concurrent.b) {
                ((j$.util.concurrent.b) concurrentMap).forEach(aVar);
            } else {
                e(concurrentMap, aVar);
            }
        } else {
            Map.CC.$default$replaceAll(map, biFunction);
        }
    }

    public static /* synthetic */ void H(List list, Comparator comparator) {
        if (list instanceof j$.util.List) {
            ((j$.util.List) list).sort(comparator);
        } else {
            List.CC.$default$sort(list, comparator);
        }
    }

    public static Spliterator I(Collection collection) {
        if (collection instanceof j$.util.Collection) {
            return ((j$.util.Collection) collection).spliterator();
        }
        if (collection instanceof LinkedHashSet) {
            return u.m((LinkedHashSet) collection, 17);
        }
        if (collection instanceof SortedSet) {
            return r.d((SortedSet) collection);
        }
        if (collection instanceof java.util.List) {
            return List.CC.$default$spliterator((java.util.List) collection);
        }
        return collection instanceof Set ? Set.CC.$default$spliterator((java.util.Set) collection) : Collection.CC.$default$spliterator(collection);
    }

    public static /* synthetic */ Comparator J(Comparator comparator, Comparator comparator2) {
        return comparator instanceof j$.util.Comparator ? ((j$.util.Comparator) comparator).thenComparing(comparator2) : Comparator.CC.$default$thenComparing(comparator, comparator2);
    }

    public static void a(A2 a2) {
        throw new IllegalStateException("called wrong accept method");
    }

    public static void b(A2 a2) {
        throw new IllegalStateException("called wrong accept method");
    }

    public static void c(A2 a2) {
        throw new IllegalStateException("called wrong accept method");
    }

    public static int d(d dVar, d dVar2) {
        int s = dVar.c().s(dVar2.c());
        if (s != 0) {
            return s;
        }
        int t = dVar.b().compareTo(dVar2.b());
        return t == 0 ? dVar.a().e(dVar2.a()) : t;
    }

    public static void e(ConcurrentMap concurrentMap, BiConsumer biConsumer) {
        Objects.requireNonNull(biConsumer);
        for (Map.Entry entry : concurrentMap.entrySet()) {
            try {
                biConsumer.accept(entry.getKey(), entry.getValue());
            } catch (IllegalStateException unused) {
            }
        }
    }

    public static int f(k kVar, l lVar) {
        q j = kVar.j(lVar);
        if (j.g()) {
            long l = kVar.l(lVar);
            if (j.h(l)) {
                return (int) l;
            }
            throw new j$.time.b("Invalid value for " + lVar + " (valid values " + j + "): " + l);
        }
        throw new p("Invalid field " + lVar + " for get() method, use getLong() instead");
    }

    public static long g(Spliterator spliterator) {
        if ((spliterator.characteristics() & 64) == 0) {
            return -1;
        }
        return spliterator.estimateSize();
    }

    public static boolean h(Spliterator spliterator, int i) {
        return (spliterator.characteristics() & i) == i;
    }

    public static Object i(d dVar, n nVar) {
        int i = m.f1638a;
        if (nVar == d.f1629a || nVar == g.f1632a || nVar == c.f1628a) {
            return null;
        }
        return nVar == f.f1631a ? dVar.b() : nVar == j$.time.temporal.b.f1627a ? dVar.a() : nVar == e.f1630a ? i.NANOS : nVar.a(dVar);
    }

    public static Object j(k kVar, n nVar) {
        int i = m.f1638a;
        if (nVar == d.f1629a || nVar == j$.time.temporal.b.f1627a || nVar == e.f1630a) {
            return null;
        }
        return nVar.a(kVar);
    }

    public static q k(k kVar, l lVar) {
        if (!(lVar instanceof h)) {
            Objects.requireNonNull(lVar, "field");
            return lVar.t(kVar);
        } else if (kVar.d(lVar)) {
            return lVar.h();
        } else {
            throw new p("Unsupported field: " + lVar);
        }
    }

    public static long l(d dVar, j$.time.h hVar) {
        Objects.requireNonNull(hVar, "offset");
        return ((dVar.c().m() * 86400) + ((long) dVar.b().C())) - ((long) hVar.x());
    }

    public static Object m(java.util.Map map, Object obj, BiFunction biFunction) {
        Object apply;
        if (map instanceof j$.util.Map) {
            return ((j$.util.Map) map).compute(obj, biFunction);
        }
        if (!(map instanceof ConcurrentMap)) {
            return Map.CC.$default$compute(map, obj, biFunction);
        }
        ConcurrentMap concurrentMap = (ConcurrentMap) map;
        Objects.requireNonNull(biFunction);
        loop0:
        while (true) {
            Object obj2 = concurrentMap.get(obj);
            while (true) {
                apply = biFunction.apply(obj, obj2);
                if (apply != null) {
                    if (obj2 == null) {
                        obj2 = concurrentMap.putIfAbsent(obj, apply);
                        if (obj2 == null) {
                            break loop0;
                        }
                    } else if (concurrentMap.replace(obj, obj2, apply)) {
                        break;
                    }
                } else {
                    apply = null;
                    if ((obj2 == null && !concurrentMap.containsKey(obj)) || concurrentMap.remove(obj, obj2)) {
                        break;
                    }
                }
            }
        }
        return apply;
    }

    public static Object n(java.util.Map map, Object obj, Function function) {
        Object apply;
        if (map instanceof j$.util.Map) {
            return ((j$.util.Map) map).computeIfAbsent(obj, function);
        }
        if (!(map instanceof ConcurrentMap)) {
            return Map.CC.$default$computeIfAbsent(map, obj, function);
        }
        ConcurrentMap concurrentMap = (ConcurrentMap) map;
        Objects.requireNonNull(function);
        Object obj2 = concurrentMap.get(obj);
        if (obj2 != null || (apply = function.apply(obj)) == null) {
            return obj2;
        }
        Object putIfAbsent = concurrentMap.putIfAbsent(obj, apply);
        return putIfAbsent == null ? apply : putIfAbsent;
    }

    public static Object o(java.util.Map map, Object obj, BiFunction biFunction) {
        if (map instanceof j$.util.Map) {
            return ((j$.util.Map) map).computeIfPresent(obj, biFunction);
        }
        if (!(map instanceof ConcurrentMap)) {
            return Map.CC.$default$computeIfPresent(map, obj, biFunction);
        }
        ConcurrentMap concurrentMap = (ConcurrentMap) map;
        Objects.requireNonNull(biFunction);
        while (true) {
            Object obj2 = concurrentMap.get(obj);
            if (obj2 == null) {
                return obj2;
            }
            Object apply = biFunction.apply(obj, obj2);
            if (apply != null) {
                if (concurrentMap.replace(obj, obj2, apply)) {
                    return apply;
                }
            } else if (concurrentMap.remove(obj, obj2)) {
                return null;
            }
        }
    }

    public static Optional p(java.util.Optional optional) {
        if (optional == null) {
            return null;
        }
        return optional.isPresent() ? Optional.d(optional.get()) : Optional.a();
    }

    public static o q(OptionalDouble optionalDouble) {
        if (optionalDouble == null) {
            return null;
        }
        return optionalDouble.isPresent() ? o.d(optionalDouble.getAsDouble()) : o.a();
    }

    public static j$.util.p r(OptionalInt optionalInt) {
        if (optionalInt == null) {
            return null;
        }
        return optionalInt.isPresent() ? j$.util.p.d(optionalInt.getAsInt()) : j$.util.p.a();
    }

    public static j$.util.q s(OptionalLong optionalLong) {
        if (optionalLong == null) {
            return null;
        }
        return optionalLong.isPresent() ? j$.util.q.d(optionalLong.getAsLong()) : j$.util.q.a();
    }

    public static java.util.Optional t(Optional optional) {
        if (optional == null) {
            return null;
        }
        return optional.c() ? java.util.Optional.of(optional.b()) : java.util.Optional.empty();
    }

    public static OptionalDouble u(o oVar) {
        if (oVar == null) {
            return null;
        }
        return oVar.c() ? OptionalDouble.of(oVar.b()) : OptionalDouble.empty();
    }

    public static OptionalInt v(j$.util.p pVar) {
        if (pVar == null) {
            return null;
        }
        return pVar.c() ? OptionalInt.of(pVar.b()) : OptionalInt.empty();
    }

    public static OptionalLong w(j$.util.q qVar) {
        if (qVar == null) {
            return null;
        }
        return qVar.c() ? OptionalLong.of(qVar.b()) : OptionalLong.empty();
    }

    public static boolean x(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static void y(java.util.Collection collection, Consumer consumer) {
        if (collection instanceof j$.util.Collection) {
            ((j$.util.Collection) collection).forEach(consumer);
            return;
        }
        Objects.requireNonNull(consumer);
        for (Object obj : collection) {
            consumer.accept(obj);
        }
    }

    public static /* synthetic */ void z(java.util.Map map, BiConsumer biConsumer) {
        if (map instanceof j$.util.Map) {
            ((j$.util.Map) map).forEach(biConsumer);
        } else if (map instanceof ConcurrentMap) {
            e((ConcurrentMap) map, biConsumer);
        } else {
            Map.CC.$default$forEach(map, biConsumer);
        }
    }
}
