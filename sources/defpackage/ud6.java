package defpackage;

import androidx.appcompat.widget.RtlSpacingHelper;
import defpackage.be6;
import defpackage.uf6;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.CancellationException;

/* renamed from: ud6  reason: default package */
/* compiled from: AbstractChannel.kt */
public abstract class ud6<E> extends wd6<E> implements zd6<E> {
    public static final /* synthetic */ int e = 0;

    /* renamed from: ud6$a */
    /* compiled from: AbstractChannel.kt */
    public static final class a<E> implements ae6<E> {

        /* renamed from: a  reason: collision with root package name */
        public final ud6<E> f3487a;
        public Object b = vd6.d;

        public a(ud6<E> ud6) {
            this.f3487a = ud6;
        }

        @Override // defpackage.ae6
        public Object a(k66<? super Boolean> k66) {
            yf6 yf6;
            dg6 dg6 = vd6.d;
            Object obj = this.b;
            if (obj != dg6) {
                return Boolean.valueOf(b(obj));
            }
            Object y = this.f3487a.y();
            this.b = y;
            if (y != dg6) {
                return Boolean.valueOf(b(y));
            }
            sa6 o1 = hd3.o1(hd3.B1(k66));
            d dVar = new d(this, o1);
            while (true) {
                ud6<E> ud6 = this.f3487a;
                int i = ud6.e;
                if (ud6.s(dVar)) {
                    ud6<E> ud62 = this.f3487a;
                    Objects.requireNonNull(ud62);
                    o1.g(new e(dVar));
                    break;
                }
                Object y2 = this.f3487a.y();
                this.b = y2;
                if (y2 instanceof ce6) {
                    ce6 ce6 = (ce6) y2;
                    if (ce6.i == null) {
                        o1.resumeWith(Boolean.FALSE);
                    } else {
                        o1.resumeWith(hd3.Z(ce6.A()));
                    }
                } else if (y2 != dg6) {
                    Boolean bool = Boolean.TRUE;
                    s76<E, s56> s76 = this.f3487a.b;
                    if (s76 == null) {
                        yf6 = null;
                    } else {
                        yf6 = new yf6(s76, y2, o1.j);
                    }
                    o1.C(bool, o1.h, yf6);
                }
            }
            Object u = o1.u();
            if (u == p66.COROUTINE_SUSPENDED) {
                n86.e(k66, "frame");
            }
            return u;
        }

        public final boolean b(Object obj) {
            if (!(obj instanceof ce6)) {
                return true;
            }
            ce6 ce6 = (ce6) obj;
            if (ce6.i == null) {
                return false;
            }
            Throwable A = ce6.A();
            String str = cg6.f563a;
            throw A;
        }

        @Override // defpackage.ae6
        public E next() {
            E e = (E) this.b;
            if (!(e instanceof ce6)) {
                dg6 dg6 = vd6.d;
                if (e != dg6) {
                    this.b = dg6;
                    return e;
                }
                throw new IllegalStateException("'hasNext' should be called prior to 'next' invocation");
            }
            Throwable A = e.A();
            String str = cg6.f563a;
            throw A;
        }
    }

    /* renamed from: ud6$b */
    /* compiled from: AbstractChannel.kt */
    public static class b<E> extends he6<E> {
        public final ra6<Object> i;
        public final int j;

        public b(ra6<Object> ra6, int i2) {
            this.i = ra6;
            this.j = i2;
        }

        @Override // defpackage.je6
        public void g(E e) {
            this.i.s(ta6.f3328a);
        }

        @Override // defpackage.je6
        public dg6 i(E e, uf6.b bVar) {
            if (this.i.l(this.j == 1 ? new be6(e) : e, null, v(e)) == null) {
                return null;
            }
            return ta6.f3328a;
        }

        @Override // defpackage.uf6
        public String toString() {
            StringBuilder i0 = hj1.i0("ReceiveElement@");
            i0.append(hd3.l1(this));
            i0.append("[receiveMode=");
            return hj1.W(i0, this.j, ']');
        }

        @Override // defpackage.he6
        public void w(ce6<?> ce6) {
            if (this.j == 1) {
                this.i.resumeWith(new be6(new be6.a(ce6.i)));
            } else {
                this.i.resumeWith(hd3.Z(ce6.A()));
            }
        }
    }

    /* renamed from: ud6$c */
    /* compiled from: AbstractChannel.kt */
    public static final class c<E> extends b<E> {
        public final s76<E, s56> k;

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: s76<? super E, s56> */
        /* JADX WARN: Multi-variable type inference failed */
        public c(ra6<Object> ra6, int i, s76<? super E, s56> s76) {
            super(ra6, i);
            this.k = s76;
        }

        @Override // defpackage.he6
        public s76<Throwable, s56> v(E e) {
            return new yf6(this.k, e, this.i.getContext());
        }
    }

    /* renamed from: ud6$d */
    /* compiled from: AbstractChannel.kt */
    public static class d<E> extends he6<E> {
        public final a<E> i;
        public final ra6<Boolean> j;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: ra6<? super java.lang.Boolean> */
        /* JADX WARN: Multi-variable type inference failed */
        public d(a<E> aVar, ra6<? super Boolean> ra6) {
            this.i = aVar;
            this.j = ra6;
        }

        @Override // defpackage.je6
        public void g(E e) {
            this.i.b = e;
            this.j.s(ta6.f3328a);
        }

        @Override // defpackage.je6
        public dg6 i(E e, uf6.b bVar) {
            if (this.j.l(Boolean.TRUE, null, v(e)) == null) {
                return null;
            }
            return ta6.f3328a;
        }

        @Override // defpackage.uf6
        public String toString() {
            return n86.j("ReceiveHasNext@", hd3.l1(this));
        }

        @Override // defpackage.he6
        public s76<Throwable, s56> v(E e) {
            s76<E, s56> s76 = this.i.f3487a.b;
            if (s76 == null) {
                return null;
            }
            return new yf6(s76, e, this.j.getContext());
        }

        @Override // defpackage.he6
        public void w(ce6<?> ce6) {
            Object obj;
            if (ce6.i == null) {
                obj = this.j.d(Boolean.FALSE, null);
            } else {
                obj = this.j.h(ce6.A());
            }
            if (obj != null) {
                this.i.b = ce6;
                this.j.s(obj);
            }
        }
    }

    /* renamed from: ud6$e */
    /* compiled from: AbstractChannel.kt */
    public final class e extends ma6 {
        public final he6<?> f;

        public e(he6<?> he6) {
            this.f = he6;
        }

        @Override // defpackage.qa6
        public void a(Throwable th) {
            if (this.f.s()) {
                Objects.requireNonNull(ud6.this);
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.s76
        public s56 invoke(Throwable th) {
            if (this.f.s()) {
                Objects.requireNonNull(ud6.this);
            }
            return s56.f3190a;
        }

        public String toString() {
            StringBuilder i0 = hj1.i0("RemoveReceiveOnCancel[");
            i0.append(this.f);
            i0.append(']');
            return i0.toString();
        }
    }

    /* renamed from: ud6$f */
    /* compiled from: LockFreeLinkedList.kt */
    public static final class f extends uf6.a {
        public final /* synthetic */ ud6 d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(uf6 uf6, ud6 ud6) {
            super(uf6);
            this.d = ud6;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.nf6
        public Object c(uf6 uf6) {
            if (this.d.u()) {
                return null;
            }
            return tf6.f3349a;
        }
    }

    @y66(c = "kotlinx.coroutines.channels.AbstractChannel", f = "AbstractChannel.kt", l = {632}, m = "receiveCatching-JP2dKIU")
    /* renamed from: ud6$g */
    /* compiled from: AbstractChannel.kt */
    public static final class g extends w66 {
        public /* synthetic */ Object f;
        public final /* synthetic */ ud6<E> g;
        public int h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(ud6<E> ud6, k66<? super g> k66) {
            super(k66);
            this.g = ud6;
        }

        @Override // defpackage.u66
        public final Object invokeSuspend(Object obj) {
            this.f = obj;
            this.h |= RtlSpacingHelper.UNDEFINED;
            Object b = this.g.b(this);
            if (b == p66.COROUTINE_SUSPENDED) {
                return b;
            }
            return new be6(b);
        }
    }

    public ud6(s76<? super E, s56> s76) {
        super(s76);
    }

    @Override // defpackage.ie6
    public final Object a() {
        Object y = y();
        if (y == vd6.d) {
            return be6.c;
        }
        return y instanceof ce6 ? new be6.a(((ce6) y).i) : y;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    @Override // defpackage.ie6
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(defpackage.k66<? super defpackage.be6<? extends E>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof defpackage.ud6.g
            if (r0 == 0) goto L_0x0013
            r0 = r5
            ud6$g r0 = (defpackage.ud6.g) r0
            int r1 = r0.h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.h = r1
            goto L_0x0018
        L_0x0013:
            ud6$g r0 = new ud6$g
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.f
            p66 r1 = defpackage.p66.COROUTINE_SUSPENDED
            int r2 = r0.h
            r3 = 1
            if (r2 == 0) goto L_0x002f
            if (r2 != r3) goto L_0x0027
            defpackage.hd3.Y2(r5)
            goto L_0x0052
        L_0x0027:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x002f:
            defpackage.hd3.Y2(r5)
            java.lang.Object r5 = r4.y()
            dg6 r2 = defpackage.vd6.d
            if (r5 == r2) goto L_0x0049
            boolean r0 = r5 instanceof defpackage.ce6
            if (r0 == 0) goto L_0x0048
            ce6 r5 = (defpackage.ce6) r5
            java.lang.Throwable r5 = r5.i
            be6$a r0 = new be6$a
            r0.<init>(r5)
            r5 = r0
        L_0x0048:
            return r5
        L_0x0049:
            r0.h = r3
            java.lang.Object r5 = r4.z(r3, r0)
            if (r5 != r1) goto L_0x0052
            return r1
        L_0x0052:
            be6 r5 = (defpackage.be6) r5
            java.lang.Object r5 = r5.f419a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ud6.b(k66):java.lang.Object");
    }

    @Override // defpackage.ie6
    public final void c(CancellationException cancellationException) {
        if (!v()) {
            if (cancellationException == null) {
                cancellationException = new CancellationException(n86.j(getClass().getSimpleName(), " was cancelled"));
            }
            w(e(cancellationException));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: k66<? super E> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.ie6
    public final Object d(k66<? super E> k66) {
        Object y = y();
        if (y == vd6.d || (y instanceof ce6)) {
            return z(0, k66);
        }
        return y;
    }

    @Override // defpackage.ie6
    public final ae6<E> iterator() {
        return new a(this);
    }

    @Override // defpackage.wd6
    public je6<E> q() {
        je6<E> q = super.q();
        if (q != null) {
            boolean z = q instanceof ce6;
        }
        return q;
    }

    public boolean s(he6<? super E> he6) {
        int u;
        uf6 o;
        if (!t()) {
            uf6 uf6 = this.c;
            f fVar = new f(he6, this);
            do {
                uf6 o2 = uf6.o();
                if (!(!(o2 instanceof le6))) {
                    break;
                }
                u = o2.u(he6, uf6, fVar);
                if (u == 1) {
                    return true;
                }
            } while (u != 2);
        } else {
            uf6 uf62 = this.c;
            do {
                o = uf62.o();
                if (!(!(o instanceof le6))) {
                }
            } while (!o.j(he6, uf62));
            return true;
        }
        return false;
    }

    public abstract boolean t();

    public abstract boolean u();

    public boolean v() {
        uf6 n = this.c.n();
        ce6<?> ce6 = null;
        ce6<?> ce62 = n instanceof ce6 ? (ce6) n : null;
        if (ce62 != null) {
            l(ce62);
            ce6 = ce62;
        }
        return ce6 != null && u();
    }

    public void w(boolean z) {
        ce6<?> k = k();
        if (k != null) {
            Object obj = null;
            while (true) {
                uf6 o = k.o();
                if (o instanceof sf6) {
                    x(obj, k);
                    return;
                } else if (!o.s()) {
                    o.p();
                } else {
                    obj = ec6.u(obj, (le6) o);
                }
            }
        } else {
            throw new IllegalStateException("Cannot happen".toString());
        }
    }

    public void x(Object obj, ce6<?> ce6) {
        if (obj != null) {
            if (!(obj instanceof ArrayList)) {
                ((le6) obj).x(ce6);
                return;
            }
            ArrayList arrayList = (ArrayList) obj;
            int size = arrayList.size() - 1;
            if (size >= 0) {
                while (true) {
                    int i = size - 1;
                    ((le6) arrayList.get(size)).x(ce6);
                    if (i >= 0) {
                        size = i;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public Object y() {
        while (true) {
            le6 r = r();
            if (r == null) {
                return vd6.d;
            }
            if (r.y(null) != null) {
                r.v();
                return r.w();
            }
            r.z();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [ud6<E>, ud6, wd6] */
    /* JADX WARN: Type inference failed for: r1v4, types: [ud6$b] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <R> java.lang.Object z(int r5, defpackage.k66<? super R> r6) {
        /*
            r4 = this;
            k66 r0 = defpackage.hd3.B1(r6)
            sa6 r0 = defpackage.hd3.o1(r0)
            s76<E, s56> r1 = r4.b
            if (r1 != 0) goto L_0x0012
            ud6$b r1 = new ud6$b
            r1.<init>(r0, r5)
            goto L_0x0019
        L_0x0012:
            ud6$c r1 = new ud6$c
            s76<E, s56> r2 = r4.b
            r1.<init>(r0, r5, r2)
        L_0x0019:
            boolean r5 = r4.s(r1)
            if (r5 == 0) goto L_0x0028
            ud6$e r5 = new ud6$e
            r5.<init>(r1)
            r0.g(r5)
            goto L_0x004f
        L_0x0028:
            java.lang.Object r5 = r4.y()
            boolean r2 = r5 instanceof defpackage.ce6
            if (r2 == 0) goto L_0x0036
            ce6 r5 = (defpackage.ce6) r5
            r1.w(r5)
            goto L_0x004f
        L_0x0036:
            dg6 r2 = defpackage.vd6.d
            if (r5 == r2) goto L_0x0019
            int r2 = r1.j
            r3 = 1
            if (r2 != r3) goto L_0x0045
            be6 r2 = new be6
            r2.<init>(r5)
            goto L_0x0046
        L_0x0045:
            r2 = r5
        L_0x0046:
            s76 r5 = r1.v(r5)
            int r1 = r0.h
            r0.C(r2, r1, r5)
        L_0x004f:
            java.lang.Object r5 = r0.u()
            p66 r0 = defpackage.p66.COROUTINE_SUSPENDED
            if (r5 != r0) goto L_0x005c
            java.lang.String r0 = "frame"
            defpackage.n86.e(r6, r0)
        L_0x005c:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ud6.z(int, k66):java.lang.Object");
    }
}
