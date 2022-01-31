package defpackage;

import defpackage.s05;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: z05  reason: default package */
/* compiled from: ListFieldSchema */
public abstract class z05 {

    /* renamed from: a  reason: collision with root package name */
    public static final z05 f4107a = new b(null);
    public static final z05 b = new c(null);

    /* renamed from: z05$b */
    /* compiled from: ListFieldSchema */
    public static final class b extends z05 {
        public static final Class<?> c = Collections.unmodifiableList(Collections.emptyList()).getClass();

        public b(a aVar) {
            super(null);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v10, resolved type: java.util.ArrayList */
        /* JADX WARN: Multi-variable type inference failed */
        public static <L> List<L> d(Object obj, long j, int i) {
            x05 x05;
            List<L> list;
            List<L> list2 = (List) i25.p(obj, j);
            if (list2.isEmpty()) {
                if (list2 instanceof y05) {
                    list = new x05(i);
                } else if (!(list2 instanceof r15) || !(list2 instanceof s05.j)) {
                    list = new ArrayList<>(i);
                } else {
                    list = ((s05.j) list2).f(i);
                }
                i25.f.s(obj, j, list);
                return list;
            }
            if (c.isAssignableFrom(list2.getClass())) {
                ArrayList arrayList = new ArrayList(list2.size() + i);
                arrayList.addAll(list2);
                i25.f.s(obj, j, arrayList);
                x05 = arrayList;
            } else if (list2 instanceof h25) {
                x05 x052 = new x05(list2.size() + i);
                x052.addAll(x052.size(), (h25) list2);
                i25.f.s(obj, j, x052);
                x05 = x052;
            } else if (!(list2 instanceof r15) || !(list2 instanceof s05.j)) {
                return list2;
            } else {
                s05.j jVar = (s05.j) list2;
                if (jVar.t()) {
                    return list2;
                }
                s05.j f = jVar.f(list2.size() + i);
                i25.f.s(obj, j, f);
                return f;
            }
            return x05;
        }

        @Override // defpackage.z05
        public void a(Object obj, long j) {
            Object obj2;
            List list = (List) i25.p(obj, j);
            if (list instanceof y05) {
                obj2 = ((y05) list).q();
            } else if (!c.isAssignableFrom(list.getClass())) {
                if (!(list instanceof r15) || !(list instanceof s05.j)) {
                    obj2 = Collections.unmodifiableList(list);
                } else {
                    s05.j jVar = (s05.j) list;
                    if (jVar.t()) {
                        jVar.c();
                        return;
                    }
                    return;
                }
            } else {
                return;
            }
            i25.f.s(obj, j, obj2);
        }

        @Override // defpackage.z05
        public <E> void b(Object obj, Object obj2, long j) {
            List list = (List) i25.p(obj2, j);
            List d = d(obj, j, list.size());
            int size = d.size();
            int size2 = list.size();
            if (size > 0 && size2 > 0) {
                d.addAll(list);
            }
            if (size > 0) {
                list = d;
            }
            i25.f.s(obj, j, list);
        }

        @Override // defpackage.z05
        public <L> List<L> c(Object obj, long j) {
            return d(obj, j, 10);
        }
    }

    /* renamed from: z05$c */
    /* compiled from: ListFieldSchema */
    public static final class c extends z05 {
        public c(a aVar) {
            super(null);
        }

        public static <E> s05.j<E> d(Object obj, long j) {
            return (s05.j) i25.p(obj, j);
        }

        @Override // defpackage.z05
        public void a(Object obj, long j) {
            d(obj, j).c();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v3, types: [java.util.List] */
        @Override // defpackage.z05
        public <E> void b(Object obj, Object obj2, long j) {
            s05.j<E> d = d(obj, j);
            s05.j<E> d2 = d(obj2, j);
            int size = d.size();
            int size2 = d2.size();
            s05.j<E> jVar = d;
            jVar = d;
            if (size > 0 && size2 > 0) {
                boolean t = d.t();
                s05.j<E> jVar2 = d;
                if (!t) {
                    jVar2 = d.f(size2 + size);
                }
                jVar2.addAll(d2);
                jVar = jVar2;
            }
            if (size > 0) {
                d2 = jVar;
            }
            i25.f.s(obj, j, d2);
        }

        @Override // defpackage.z05
        public <L> List<L> c(Object obj, long j) {
            s05.j d = d(obj, j);
            if (d.t()) {
                return d;
            }
            int size = d.size();
            s05.j f = d.f(size == 0 ? 10 : size * 2);
            i25.f.s(obj, j, f);
            return f;
        }
    }

    public z05(a aVar) {
    }

    public abstract void a(Object obj, long j);

    public abstract <L> void b(Object obj, Object obj2, long j);

    public abstract <L> List<L> c(Object obj, long j);
}
