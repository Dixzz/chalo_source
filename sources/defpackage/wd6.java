package defpackage;

import defpackage.be6;
import defpackage.uf6;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: wd6  reason: default package */
/* compiled from: AbstractChannel.kt */
public abstract class wd6<E> implements me6<E> {
    public static final /* synthetic */ AtomicReferenceFieldUpdater d = AtomicReferenceFieldUpdater.newUpdater(wd6.class, Object.class, "onCloseHandler");
    public final s76<E, s56> b;
    public final sf6 c = new sf6();
    private volatile /* synthetic */ Object onCloseHandler = null;

    /* renamed from: wd6$a */
    /* compiled from: AbstractChannel.kt */
    public static final class a<E> extends le6 {
        public final E i;

        public a(E e) {
            this.i = e;
        }

        @Override // defpackage.uf6
        public String toString() {
            StringBuilder i0 = hj1.i0("SendBuffered@");
            i0.append(hd3.l1(this));
            i0.append('(');
            i0.append((Object) this.i);
            i0.append(')');
            return i0.toString();
        }

        @Override // defpackage.le6
        public void v() {
        }

        @Override // defpackage.le6
        public Object w() {
            return this.i;
        }

        @Override // defpackage.le6
        public void x(ce6<?> ce6) {
        }

        @Override // defpackage.le6
        public dg6 y(uf6.b bVar) {
            return ta6.f3328a;
        }
    }

    /* renamed from: wd6$b */
    /* compiled from: LockFreeLinkedList.kt */
    public static final class b extends uf6.a {
        public final /* synthetic */ wd6 d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(uf6 uf6, wd6 wd6) {
            super(uf6);
            this.d = wd6;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.nf6
        public Object c(uf6 uf6) {
            if (this.d.n()) {
                return null;
            }
            return tf6.f3349a;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: s76<? super E, s56> */
    /* JADX WARN: Multi-variable type inference failed */
    public wd6(s76<? super E, s56> s76) {
        this.b = s76;
    }

    public static final void h(wd6 wd6, k66 k66, Object obj, ce6 ce6) {
        jg6 h;
        wd6.l(ce6);
        Throwable B = ce6.B();
        s76<E, s56> s76 = wd6.b;
        if (s76 == null || (h = ec6.h(s76, obj, null)) == null) {
            ((sa6) k66).resumeWith(hd3.Z(B));
            return;
        }
        hd3.l(h, B);
        ((sa6) k66).resumeWith(hd3.Z(h));
    }

    @Override // defpackage.me6
    public boolean e(Throwable th) {
        boolean z;
        Object obj;
        dg6 dg6;
        ce6<?> ce6 = new ce6<>(th);
        uf6 uf6 = this.c;
        while (true) {
            uf6 o = uf6.o();
            if (!(o instanceof ce6)) {
                if (o.j(ce6, uf6)) {
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        if (!z) {
            ce6 = (ce6) this.c.o();
        }
        l(ce6);
        if (z && (obj = this.onCloseHandler) != null && obj != (dg6 = vd6.f) && d.compareAndSet(this, obj, dg6)) {
            b96.b(obj, 1);
            ((s76) obj).invoke(th);
        }
        return z;
    }

    @Override // defpackage.me6
    public final Object f(E e) {
        be6.a aVar;
        Object o = o(e);
        if (o == vd6.b) {
            return s56.f3190a;
        }
        if (o == vd6.c) {
            ce6<?> k = k();
            if (k == null) {
                return be6.c;
            }
            l(k);
            aVar = new be6.a(k.B());
        } else if (o instanceof ce6) {
            ce6<?> ce6 = (ce6) o;
            l(ce6);
            aVar = new be6.a(ce6.B());
        } else {
            throw new IllegalStateException(n86.j("trySend returned ", o).toString());
        }
        return aVar;
    }

    @Override // defpackage.me6
    public final Object g(E e, k66<? super s56> k66) {
        le6 le6;
        dg6 dg6 = vd6.b;
        s56 s56 = s56.f3190a;
        if (o(e) == dg6) {
            return s56;
        }
        sa6 o1 = hd3.o1(hd3.B1(k66));
        while (true) {
            if (!(this.c.n() instanceof je6) && n()) {
                if (this.b == null) {
                    le6 = new ne6(e, o1);
                } else {
                    le6 = new oe6(e, o1, this.b);
                }
                Object i = i(le6);
                if (i == null) {
                    o1.g(new fd6(le6));
                    break;
                } else if (i instanceof ce6) {
                    h(this, o1, e, (ce6) i);
                    break;
                } else if (i != vd6.e && !(i instanceof he6)) {
                    throw new IllegalStateException(n86.j("enqueueSend returned ", i).toString());
                }
            }
            Object o = o(e);
            if (o == dg6) {
                o1.resumeWith(s56);
                break;
            } else if (o != vd6.c) {
                if (o instanceof ce6) {
                    h(this, o1, e, (ce6) o);
                } else {
                    throw new IllegalStateException(n86.j("offerInternal returned ", o).toString());
                }
            }
        }
        Object u = o1.u();
        p66 p66 = p66.COROUTINE_SUSPENDED;
        if (u == p66) {
            n86.e(k66, "frame");
        }
        if (u != p66) {
            u = s56;
        }
        return u == p66 ? u : s56;
    }

    public Object i(le6 le6) {
        boolean z;
        uf6 o;
        if (m()) {
            uf6 uf6 = this.c;
            do {
                o = uf6.o();
                if (o instanceof je6) {
                    return o;
                }
            } while (!o.j(le6, uf6));
            return null;
        }
        uf6 uf62 = this.c;
        b bVar = new b(le6, this);
        while (true) {
            uf6 o2 = uf62.o();
            if (!(o2 instanceof je6)) {
                int u = o2.u(le6, uf62, bVar);
                z = true;
                if (u != 1) {
                    if (u == 2) {
                        z = false;
                        break;
                    }
                } else {
                    break;
                }
            } else {
                return o2;
            }
        }
        if (!z) {
            return vd6.e;
        }
        return null;
    }

    public String j() {
        return "";
    }

    public final ce6<?> k() {
        uf6 o = this.c.o();
        ce6<?> ce6 = o instanceof ce6 ? (ce6) o : null;
        if (ce6 == null) {
            return null;
        }
        l(ce6);
        return ce6;
    }

    public final void l(ce6<?> ce6) {
        Object obj = null;
        while (true) {
            uf6 o = ce6.o();
            he6 he6 = o instanceof he6 ? (he6) o : null;
            if (he6 == null) {
                break;
            } else if (!he6.s()) {
                he6.p();
            } else {
                obj = ec6.u(obj, he6);
            }
        }
        if (obj != null) {
            if (!(obj instanceof ArrayList)) {
                ((he6) obj).w(ce6);
            } else {
                ArrayList arrayList = (ArrayList) obj;
                int size = arrayList.size() - 1;
                if (size >= 0) {
                    while (true) {
                        int i = size - 1;
                        ((he6) arrayList.get(size)).w(ce6);
                        if (i < 0) {
                            break;
                        }
                        size = i;
                    }
                }
            }
        }
        p();
    }

    public abstract boolean m();

    public abstract boolean n();

    public Object o(E e) {
        je6<E> q;
        do {
            q = q();
            if (q == null) {
                return vd6.c;
            }
        } while (q.i(e, null) == null);
        q.g(e);
        return q.c();
    }

    public void p() {
    }

    public je6<E> q() {
        uf6 uf6;
        uf6 t;
        sf6 sf6 = this.c;
        while (true) {
            uf6 = (uf6) sf6.m();
            if (uf6 != sf6 && (uf6 instanceof je6)) {
                if (((((je6) uf6) instanceof ce6) && !uf6.r()) || (t = uf6.t()) == null) {
                    break;
                }
                t.q();
            }
        }
        uf6 = null;
        return (je6) uf6;
    }

    public final le6 r() {
        uf6 uf6;
        uf6 t;
        sf6 sf6 = this.c;
        while (true) {
            uf6 = (uf6) sf6.m();
            if (uf6 != sf6 && (uf6 instanceof le6)) {
                if (((((le6) uf6) instanceof ce6) && !uf6.r()) || (t = uf6.t()) == null) {
                    break;
                }
                t.q();
            }
        }
        uf6 = null;
        return (le6) uf6;
    }

    public String toString() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append('@');
        sb.append(hd3.l1(this));
        sb.append('{');
        uf6 n = this.c.n();
        if (n == this.c) {
            str = "EmptyQueue";
        } else {
            if (n instanceof ce6) {
                str2 = n.toString();
            } else if (n instanceof he6) {
                str2 = "ReceiveQueued";
            } else if (n instanceof le6) {
                str2 = "SendQueued";
            } else {
                str2 = n86.j("UNEXPECTED:", n);
            }
            uf6 o = this.c.o();
            if (o != n) {
                StringBuilder k0 = hj1.k0(str2, ",queueSize=");
                sf6 sf6 = this.c;
                int i = 0;
                for (uf6 uf6 = (uf6) sf6.m(); !n86.a(uf6, sf6); uf6 = uf6.n()) {
                    if (uf6 instanceof uf6) {
                        i++;
                    }
                }
                k0.append(i);
                str = k0.toString();
                if (o instanceof ce6) {
                    str = str + ",closedForSend=" + o;
                }
            } else {
                str = str2;
            }
        }
        sb.append(str);
        sb.append('}');
        sb.append(j());
        return sb.toString();
    }
}
