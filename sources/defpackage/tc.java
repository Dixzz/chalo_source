package defpackage;

import defpackage.mc;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: tc  reason: default package */
/* compiled from: ListFieldSchema */
public abstract class tc {

    /* renamed from: a  reason: collision with root package name */
    public static final tc f3330a = new b(null);
    public static final tc b = new c(null);

    /* renamed from: tc$b */
    /* compiled from: ListFieldSchema */
    public static final class b extends tc {
        public static final Class<?> c = Collections.unmodifiableList(Collections.emptyList()).getClass();

        public b(a aVar) {
            super(null);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v10, resolved type: java.util.ArrayList */
        /* JADX WARN: Multi-variable type inference failed */
        public static <L> List<L> d(Object obj, long j, int i) {
            rc rcVar;
            List<L> list;
            List<L> list2 = (List) ce.n(obj, j);
            if (list2.isEmpty()) {
                if (list2 instanceof sc) {
                    list = new rc(i);
                } else if (!(list2 instanceof ld) || !(list2 instanceof mc.c)) {
                    list = new ArrayList<>(i);
                } else {
                    list = ((mc.c) list2).f(i);
                }
                ce.f.q(obj, j, list);
                return list;
            }
            if (c.isAssignableFrom(list2.getClass())) {
                ArrayList arrayList = new ArrayList(list2.size() + i);
                arrayList.addAll(list2);
                ce.f.q(obj, j, arrayList);
                rcVar = arrayList;
            } else if (list2 instanceof be) {
                rc rcVar2 = new rc(list2.size() + i);
                rcVar2.addAll(rcVar2.size(), (be) list2);
                ce.f.q(obj, j, rcVar2);
                rcVar = rcVar2;
            } else if (!(list2 instanceof ld) || !(list2 instanceof mc.c)) {
                return list2;
            } else {
                mc.c cVar = (mc.c) list2;
                if (cVar.t()) {
                    return list2;
                }
                mc.c f = cVar.f(list2.size() + i);
                ce.f.q(obj, j, f);
                return f;
            }
            return rcVar;
        }

        @Override // defpackage.tc
        public void a(Object obj, long j) {
            Object obj2;
            List list = (List) ce.n(obj, j);
            if (list instanceof sc) {
                obj2 = ((sc) list).q();
            } else if (!c.isAssignableFrom(list.getClass())) {
                if (!(list instanceof ld) || !(list instanceof mc.c)) {
                    obj2 = Collections.unmodifiableList(list);
                } else {
                    mc.c cVar = (mc.c) list;
                    if (cVar.t()) {
                        cVar.c();
                        return;
                    }
                    return;
                }
            } else {
                return;
            }
            ce.f.q(obj, j, obj2);
        }

        @Override // defpackage.tc
        public <E> void b(Object obj, Object obj2, long j) {
            List list = (List) ce.n(obj2, j);
            List d = d(obj, j, list.size());
            int size = d.size();
            int size2 = list.size();
            if (size > 0 && size2 > 0) {
                d.addAll(list);
            }
            if (size > 0) {
                list = d;
            }
            ce.f.q(obj, j, list);
        }

        @Override // defpackage.tc
        public <L> List<L> c(Object obj, long j) {
            return d(obj, j, 10);
        }
    }

    /* renamed from: tc$c */
    /* compiled from: ListFieldSchema */
    public static final class c extends tc {
        public c(a aVar) {
            super(null);
        }

        public static <E> mc.c<E> d(Object obj, long j) {
            return (mc.c) ce.n(obj, j);
        }

        @Override // defpackage.tc
        public void a(Object obj, long j) {
            d(obj, j).c();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v3, types: [java.util.List] */
        @Override // defpackage.tc
        public <E> void b(Object obj, Object obj2, long j) {
            mc.c<E> d = d(obj, j);
            mc.c<E> d2 = d(obj2, j);
            int size = d.size();
            int size2 = d2.size();
            mc.c<E> cVar = d;
            cVar = d;
            if (size > 0 && size2 > 0) {
                boolean t = d.t();
                mc.c<E> cVar2 = d;
                if (!t) {
                    cVar2 = d.f(size2 + size);
                }
                cVar2.addAll(d2);
                cVar = cVar2;
            }
            if (size > 0) {
                d2 = cVar;
            }
            ce.f.q(obj, j, d2);
        }

        @Override // defpackage.tc
        public <L> List<L> c(Object obj, long j) {
            mc.c d = d(obj, j);
            if (d.t()) {
                return d;
            }
            int size = d.size();
            mc.c f = d.f(size == 0 ? 10 : size * 2);
            ce.f.q(obj, j, f);
            return f;
        }
    }

    public tc(a aVar) {
    }

    public abstract void a(Object obj, long j);

    public abstract <L> void b(Object obj, Object obj2, long j);

    public abstract <L> List<L> c(Object obj, long j);
}
