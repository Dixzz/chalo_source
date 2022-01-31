package defpackage;

/* renamed from: x7  reason: default package */
/* compiled from: Pools */
public class x7<T> extends w7<T> {
    public final Object c = new Object();

    public x7(int i) {
        super(i);
    }

    @Override // defpackage.w7, defpackage.v7
    public boolean a(T t) {
        boolean a2;
        synchronized (this.c) {
            a2 = super.a(t);
        }
        return a2;
    }

    @Override // defpackage.w7, defpackage.v7
    public T b() {
        T t;
        synchronized (this.c) {
            t = (T) super.b();
        }
        return t;
    }
}
