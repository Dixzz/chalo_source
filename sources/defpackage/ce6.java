package defpackage;

import defpackage.uf6;

/* renamed from: ce6  reason: default package */
/* compiled from: AbstractChannel.kt */
public final class ce6<E> extends le6 implements je6<E> {
    public final Throwable i;

    public ce6(Throwable th) {
        this.i = th;
    }

    public final Throwable A() {
        Throwable th = this.i;
        return th == null ? new de6("Channel was closed") : th;
    }

    public final Throwable B() {
        Throwable th = this.i;
        return th == null ? new ee6("Channel was closed") : th;
    }

    @Override // defpackage.je6
    public Object c() {
        return this;
    }

    @Override // defpackage.je6
    public void g(E e) {
    }

    @Override // defpackage.je6
    public dg6 i(E e, uf6.b bVar) {
        return ta6.f3328a;
    }

    @Override // defpackage.uf6
    public String toString() {
        StringBuilder i0 = hj1.i0("Closed@");
        i0.append(hd3.l1(this));
        i0.append('[');
        i0.append(this.i);
        i0.append(']');
        return i0.toString();
    }

    @Override // defpackage.le6
    public void v() {
    }

    @Override // defpackage.le6
    public Object w() {
        return this;
    }

    @Override // defpackage.le6
    public void x(ce6<?> ce6) {
    }

    @Override // defpackage.le6
    public dg6 y(uf6.b bVar) {
        return ta6.f3328a;
    }
}
