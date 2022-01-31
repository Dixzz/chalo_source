package defpackage;

import java.util.Map;

/* renamed from: o2  reason: default package */
/* compiled from: ArraySet */
public class o2 extends t2<E, E> {
    public final /* synthetic */ p2 d;

    public o2(p2 p2Var) {
        this.d = p2Var;
    }

    @Override // defpackage.t2
    public void a() {
        this.d.clear();
    }

    @Override // defpackage.t2
    public Object b(int i, int i2) {
        return this.d.g[i];
    }

    @Override // defpackage.t2
    public Map<E, E> c() {
        throw new UnsupportedOperationException("not a map");
    }

    @Override // defpackage.t2
    public int d() {
        return this.d.h;
    }

    @Override // defpackage.t2
    public int e(Object obj) {
        return this.d.indexOf(obj);
    }

    @Override // defpackage.t2
    public int f(Object obj) {
        return this.d.indexOf(obj);
    }

    @Override // defpackage.t2
    public void g(E e, E e2) {
        this.d.add(e);
    }

    @Override // defpackage.t2
    public void h(int i) {
        this.d.n(i);
    }

    @Override // defpackage.t2
    public E i(int i, E e) {
        throw new UnsupportedOperationException("not a map");
    }
}
