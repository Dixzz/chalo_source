package defpackage;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/* renamed from: li2  reason: default package */
public final class li2<E> extends of2<E> {
    public static final li2<Object> h;
    public final List<E> g;

    static {
        li2<Object> li2 = new li2<>();
        h = li2;
        li2.f = false;
    }

    public li2() {
        this.g = new ArrayList(10);
    }

    public li2(List<E> list) {
        this.g = list;
    }

    @Override // java.util.List, java.util.AbstractList, j$.util.List
    public final void add(int i, E e) {
        b();
        this.g.add(i, e);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.List, java.util.AbstractList, j$.util.List
    public final E get(int i) {
        return this.g.get(i);
    }

    @Override // java.util.List, java.util.AbstractList, j$.util.List
    public final E remove(int i) {
        b();
        E remove = this.g.remove(i);
        ((AbstractList) this).modCount++;
        return remove;
    }

    @Override // java.util.List, java.util.AbstractList, j$.util.List
    public final E set(int i, E e) {
        b();
        E e2 = this.g.set(i, e);
        ((AbstractList) this).modCount++;
        return e2;
    }

    @Override // j$.util.Collection, j$.util.List
    public final int size() {
        return this.g.size();
    }

    @Override // defpackage.zg2
    public final /* synthetic */ zg2 y0(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.g);
            return new li2(arrayList);
        }
        throw new IllegalArgumentException();
    }
}
