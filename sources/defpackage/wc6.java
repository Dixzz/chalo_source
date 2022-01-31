package defpackage;

import defpackage.m66;
import defpackage.rc6;
import defpackage.uf6;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: wc6  reason: default package */
/* compiled from: JobSupport.kt */
public class wc6 implements rc6, ya6, ed6 {
    public static final /* synthetic */ AtomicReferenceFieldUpdater f = AtomicReferenceFieldUpdater.newUpdater(wc6.class, Object.class, "_state");
    private volatile /* synthetic */ Object _parentHandle;
    private volatile /* synthetic */ Object _state;

    /* renamed from: wc6$a */
    /* compiled from: JobSupport.kt */
    public static final class a<T> extends sa6<T> {
        public final wc6 n;

        public a(k66<? super T> k66, wc6 wc6) {
            super(k66, 1);
            this.n = wc6;
        }

        @Override // defpackage.sa6
        public Throwable t(rc6 rc6) {
            Throwable e;
            Object J = this.n.J();
            if ((J instanceof c) && (e = ((c) J).e()) != null) {
                return e;
            }
            if (J instanceof eb6) {
                return ((eb6) J).f955a;
            }
            return ((wc6) rc6).j();
        }

        @Override // defpackage.sa6
        public String z() {
            return "AwaitContinuation";
        }
    }

    /* renamed from: wc6$b */
    /* compiled from: JobSupport.kt */
    public static final class b extends vc6 {
        public final wc6 j;
        public final c k;
        public final xa6 l;
        public final Object m;

        public b(wc6 wc6, c cVar, xa6 xa6, Object obj) {
            this.j = wc6;
            this.k = cVar;
            this.l = xa6;
            this.m = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.s76
        public /* bridge */ /* synthetic */ s56 invoke(Throwable th) {
            v(th);
            return s56.f3190a;
        }

        @Override // defpackage.gb6
        public void v(Throwable th) {
            wc6 wc6 = this.j;
            c cVar = this.k;
            xa6 xa6 = this.l;
            Object obj = this.m;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = wc6.f;
            xa6 R = wc6.R(xa6);
            if (R == null || !wc6.b0(cVar, R, obj)) {
                wc6.u(wc6.E(cVar, obj));
            }
        }
    }

    /* renamed from: wc6$c */
    /* compiled from: JobSupport.kt */
    public static final class c implements mc6 {
        private volatile /* synthetic */ Object _exceptionsHolder = null;
        private volatile /* synthetic */ int _isCompleting;
        private volatile /* synthetic */ Object _rootCause;
        public final bd6 f;

        public c(bd6 bd6, boolean z, Throwable th) {
            this.f = bd6;
            this._isCompleting = z ? 1 : 0;
            this._rootCause = th;
        }

        @Override // defpackage.mc6
        public boolean a() {
            return ((Throwable) this._rootCause) == null;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void b(java.lang.Throwable r3) {
            /*
                r2 = this;
                java.lang.Object r0 = r2._rootCause
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                if (r0 != 0) goto L_0x0009
                r2._rootCause = r3
                return
            L_0x0009:
                if (r3 != r0) goto L_0x000c
                return
            L_0x000c:
                java.lang.Object r0 = r2._exceptionsHolder
                if (r0 != 0) goto L_0x0013
                r2._exceptionsHolder = r3
                goto L_0x0030
            L_0x0013:
                boolean r1 = r0 instanceof java.lang.Throwable
                if (r1 == 0) goto L_0x0027
                if (r3 != r0) goto L_0x001a
                return
            L_0x001a:
                java.util.ArrayList r1 = r2.c()
                r1.add(r0)
                r1.add(r3)
                r2._exceptionsHolder = r1
                goto L_0x0030
            L_0x0027:
                boolean r1 = r0 instanceof java.util.ArrayList
                if (r1 == 0) goto L_0x0031
                java.util.ArrayList r0 = (java.util.ArrayList) r0
                r0.add(r3)
            L_0x0030:
                return
            L_0x0031:
                java.lang.String r3 = "State is "
                java.lang.String r3 = defpackage.n86.j(r3, r0)
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r3 = r3.toString()
                r0.<init>(r3)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.wc6.c.b(java.lang.Throwable):void");
        }

        public final ArrayList<Throwable> c() {
            return new ArrayList<>(4);
        }

        @Override // defpackage.mc6
        public bd6 d() {
            return this.f;
        }

        public final Throwable e() {
            return (Throwable) this._rootCause;
        }

        public final boolean f() {
            return ((Throwable) this._rootCause) != null;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean g() {
            /*
                r1 = this;
                int r0 = r1._isCompleting
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.wc6.c.g():boolean");
        }

        public final boolean h() {
            return this._exceptionsHolder == xc6.e;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.util.List<java.lang.Throwable> i(java.lang.Throwable r4) {
            /*
                r3 = this;
                java.lang.Object r0 = r3._exceptionsHolder
                if (r0 != 0) goto L_0x0009
                java.util.ArrayList r0 = r3.c()
                goto L_0x001c
            L_0x0009:
                boolean r1 = r0 instanceof java.lang.Throwable
                if (r1 == 0) goto L_0x0016
                java.util.ArrayList r1 = r3.c()
                r1.add(r0)
                r0 = r1
                goto L_0x001c
            L_0x0016:
                boolean r1 = r0 instanceof java.util.ArrayList
                if (r1 == 0) goto L_0x0037
                java.util.ArrayList r0 = (java.util.ArrayList) r0
            L_0x001c:
                java.lang.Object r1 = r3._rootCause
                java.lang.Throwable r1 = (java.lang.Throwable) r1
                if (r1 != 0) goto L_0x0023
                goto L_0x0027
            L_0x0023:
                r2 = 0
                r0.add(r2, r1)
            L_0x0027:
                if (r4 == 0) goto L_0x0032
                boolean r1 = defpackage.n86.a(r4, r1)
                if (r1 != 0) goto L_0x0032
                r0.add(r4)
            L_0x0032:
                dg6 r4 = defpackage.xc6.e
                r3._exceptionsHolder = r4
                return r0
            L_0x0037:
                java.lang.String r4 = "State is "
                java.lang.String r4 = defpackage.n86.j(r4, r0)
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r4 = r4.toString()
                r0.<init>(r4)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.wc6.c.i(java.lang.Throwable):java.util.List");
        }

        public final void j(boolean z) {
            this._isCompleting = z ? 1 : 0;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: java.lang.StringBuilder */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v2, types: [boolean, int] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String toString() {
            /*
                r2 = this;
                java.lang.String r0 = "Finishing[cancelling="
                java.lang.StringBuilder r0 = defpackage.hj1.i0(r0)
                boolean r1 = r2.f()
                r0.append(r1)
                java.lang.String r1 = ", completing="
                r0.append(r1)
                int r1 = r2._isCompleting
                r0.append(r1)
                java.lang.String r1 = ", rootCause="
                r0.append(r1)
                java.lang.Object r1 = r2._rootCause
                java.lang.Throwable r1 = (java.lang.Throwable) r1
                r0.append(r1)
                java.lang.String r1 = ", exceptions="
                r0.append(r1)
                java.lang.Object r1 = r2._exceptionsHolder
                r0.append(r1)
                java.lang.String r1 = ", list="
                r0.append(r1)
                bd6 r1 = r2.f
                r0.append(r1)
                r1 = 93
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.wc6.c.toString():java.lang.String");
        }
    }

    /* renamed from: wc6$d */
    /* compiled from: LockFreeLinkedList.kt */
    public static final class d extends uf6.a {
        public final /* synthetic */ wc6 d;
        public final /* synthetic */ Object e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(uf6 uf6, wc6 wc6, Object obj) {
            super(uf6);
            this.d = wc6;
            this.e = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.nf6
        public Object c(uf6 uf6) {
            if (this.d.J() == this.e) {
                return null;
            }
            return tf6.f3349a;
        }
    }

    public wc6(boolean z) {
        this._state = z ? xc6.g : xc6.f;
        this._parentHandle = null;
    }

    public String A() {
        return "Job was cancelled";
    }

    public boolean B(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        if (!y(th) || !F()) {
            return false;
        }
        return true;
    }

    public final void C(mc6 mc6, Object obj) {
        hb6 hb6;
        wa6 wa6 = (wa6) this._parentHandle;
        if (wa6 != null) {
            wa6.h();
            this._parentHandle = cd6.f;
        }
        eb6 eb6 = obj instanceof eb6 ? (eb6) obj : null;
        Throwable th = eb6 == null ? null : eb6.f955a;
        if (mc6 instanceof vc6) {
            try {
                ((vc6) mc6).v(th);
            } catch (Throwable th2) {
                L(new hb6("Exception in completion handler " + mc6 + " for " + this, th2));
            }
        } else {
            bd6 d2 = mc6.d();
            if (d2 != null) {
                hb6 hb62 = null;
                for (uf6 uf6 = (uf6) d2.m(); !n86.a(uf6, d2); uf6 = uf6.n()) {
                    if (uf6 instanceof vc6) {
                        vc6 vc6 = (vc6) uf6;
                        try {
                            vc6.v(th);
                        } catch (Throwable th3) {
                            if (hb62 == null) {
                                hb6 = null;
                            } else {
                                hd3.l(hb62, th3);
                                hb6 = hb62;
                            }
                            if (hb6 == null) {
                                hb62 = new hb6("Exception in completion handler " + vc6 + " for " + this, th3);
                            }
                        }
                    }
                }
                if (hb62 != null) {
                    L(hb62);
                }
            }
        }
    }

    public final Throwable D(Object obj) {
        if (obj == null ? true : obj instanceof Throwable) {
            Throwable th = (Throwable) obj;
            if (th == null) {
                return new sc6(A(), null, this);
            }
            return th;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((ed6) obj).t();
    }

    public final Object E(c cVar, Object obj) {
        boolean f2;
        Throwable th = null;
        eb6 eb6 = obj instanceof eb6 ? (eb6) obj : null;
        Throwable th2 = eb6 == null ? null : eb6.f955a;
        synchronized (cVar) {
            f2 = cVar.f();
            List<Throwable> i = cVar.i(th2);
            if (!i.isEmpty()) {
                Iterator<T> it = i.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    T next = it.next();
                    if (!(next instanceof CancellationException)) {
                        th = next;
                        break;
                    }
                }
                th = th;
                if (th == null) {
                    th = i.get(0);
                }
            } else if (cVar.f()) {
                th = new sc6(A(), null, this);
            }
            if (th != null) {
                if (i.size() > 1) {
                    Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap(i.size()));
                    for (Throwable th3 : i) {
                        if (th3 != th && th3 != th && !(th3 instanceof CancellationException) && newSetFromMap.add(th3)) {
                            hd3.l(th, th3);
                        }
                    }
                }
            }
        }
        if (!(th == null || th == th2)) {
            obj = new eb6(th, false, 2);
        }
        if (th != null) {
            if (z(th) || K(th)) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                eb6.b.compareAndSet((eb6) obj, 0, 1);
            }
        }
        if (!f2) {
            T();
        }
        U(obj);
        f.compareAndSet(this, cVar, obj instanceof mc6 ? new nc6((mc6) obj) : obj);
        C(cVar, obj);
        return obj;
    }

    public boolean F() {
        return true;
    }

    public boolean G() {
        return false;
    }

    public final bd6 H(mc6 mc6) {
        bd6 d2 = mc6.d();
        if (d2 != null) {
            return d2;
        }
        if (mc6 instanceof ac6) {
            return new bd6();
        }
        if (mc6 instanceof vc6) {
            W((vc6) mc6);
            return null;
        }
        throw new IllegalStateException(n86.j("State should have list: ", mc6).toString());
    }

    public final wa6 I() {
        return (wa6) this._parentHandle;
    }

    public final Object J() {
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof zf6)) {
                return obj;
            }
            ((zf6) obj).a(this);
        }
    }

    public boolean K(Throwable th) {
        return false;
    }

    public void L(Throwable th) {
        throw th;
    }

    public final void M(rc6 rc6) {
        cd6 cd6 = cd6.f;
        if (rc6 == null) {
            this._parentHandle = cd6;
            return;
        }
        rc6.start();
        wa6 x = rc6.x(this);
        this._parentHandle = x;
        if (!(J() instanceof mc6)) {
            x.h();
            this._parentHandle = cd6;
        }
    }

    public boolean N() {
        return false;
    }

    public final boolean O(Object obj) {
        Object a0;
        do {
            a0 = a0(J(), obj);
            if (a0 == xc6.f3914a) {
                return false;
            }
            if (a0 == xc6.b) {
                return true;
            }
        } while (a0 == xc6.c);
        return true;
    }

    public final Object P(Object obj) {
        Object a0;
        do {
            a0 = a0(J(), obj);
            if (a0 == xc6.f3914a) {
                String str = "Job " + this + " is already complete or completing, but is being completed with " + obj;
                Throwable th = null;
                eb6 eb6 = obj instanceof eb6 ? (eb6) obj : null;
                if (eb6 != null) {
                    th = eb6.f955a;
                }
                throw new IllegalStateException(str, th);
            }
        } while (a0 == xc6.c);
        return a0;
    }

    public String Q() {
        return getClass().getSimpleName();
    }

    public final xa6 R(uf6 uf6) {
        while (uf6.r()) {
            uf6 = uf6.o();
        }
        while (true) {
            uf6 = uf6.n();
            if (!uf6.r()) {
                if (uf6 instanceof xa6) {
                    return (xa6) uf6;
                }
                if (uf6 instanceof bd6) {
                    return null;
                }
            }
        }
    }

    public final void S(bd6 bd6, Throwable th) {
        hb6 hb6;
        T();
        hb6 hb62 = null;
        for (uf6 uf6 = (uf6) bd6.m(); !n86.a(uf6, bd6); uf6 = uf6.n()) {
            if (uf6 instanceof tc6) {
                vc6 vc6 = (vc6) uf6;
                try {
                    vc6.v(th);
                } catch (Throwable th2) {
                    if (hb62 == null) {
                        hb6 = null;
                    } else {
                        hd3.l(hb62, th2);
                        hb6 = hb62;
                    }
                    if (hb6 == null) {
                        hb62 = new hb6("Exception in completion handler " + vc6 + " for " + this, th2);
                    }
                }
            }
        }
        if (hb62 != null) {
            L(hb62);
        }
        z(th);
    }

    public void T() {
    }

    public void U(Object obj) {
    }

    public void V() {
    }

    public final void W(vc6 vc6) {
        bd6 bd6 = new bd6();
        uf6.g.lazySet(bd6, vc6);
        uf6.f.lazySet(bd6, vc6);
        while (true) {
            if (vc6.m() == vc6) {
                if (uf6.f.compareAndSet(vc6, vc6, bd6)) {
                    bd6.l(vc6);
                    break;
                }
            } else {
                break;
            }
        }
        f.compareAndSet(this, vc6, vc6.n());
    }

    public final int X(Object obj) {
        if (obj instanceof ac6) {
            if (((ac6) obj).f) {
                return 0;
            }
            if (!f.compareAndSet(this, obj, xc6.g)) {
                return -1;
            }
            V();
            return 1;
        } else if (!(obj instanceof lc6)) {
            return 0;
        } else {
            if (!f.compareAndSet(this, obj, ((lc6) obj).f)) {
                return -1;
            }
            V();
            return 1;
        }
    }

    public final String Y(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (cVar.f()) {
                return "Cancelling";
            }
            if (cVar.g()) {
                return "Completing";
            }
            return "Active";
        } else if (!(obj instanceof mc6)) {
            return obj instanceof eb6 ? "Cancelled" : "Completed";
        } else {
            if (((mc6) obj).a()) {
                return "Active";
            }
            return "New";
        }
    }

    public final CancellationException Z(Throwable th, String str) {
        CancellationException cancellationException = th instanceof CancellationException ? (CancellationException) th : null;
        if (cancellationException == null) {
            if (str == null) {
                str = A();
            }
            cancellationException = new sc6(str, th, this);
        }
        return cancellationException;
    }

    @Override // defpackage.rc6
    public boolean a() {
        Object J = J();
        return (J instanceof mc6) && ((mc6) J).a();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0096, code lost:
        if (r1 != null) goto L_0x0099;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0099, code lost:
        S(r2, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x009e, code lost:
        if ((r8 instanceof defpackage.xa6) == false) goto L_0x00a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00a0, code lost:
        r0 = (defpackage.xa6) r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00a4, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00a5, code lost:
        if (r0 != null) goto L_0x00b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00a7, code lost:
        r8 = r8.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00ab, code lost:
        if (r8 != null) goto L_0x00ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00ae, code lost:
        r6 = R(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00b3, code lost:
        r6 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00b4, code lost:
        if (r6 == null) goto L_0x00bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00ba, code lost:
        if (b0(r5, r6, r9) == false) goto L_0x00bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:?, code lost:
        return E(r5, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
        return defpackage.xc6.b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a0(java.lang.Object r8, java.lang.Object r9) {
        /*
        // Method dump skipped, instructions count: 199
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.wc6.a0(java.lang.Object, java.lang.Object):java.lang.Object");
    }

    public final boolean b(Object obj, bd6 bd6, vc6 vc6) {
        int u;
        d dVar = new d(vc6, this, obj);
        do {
            u = bd6.o().u(vc6, bd6, dVar);
            if (u == 1) {
                return true;
            }
        } while (u != 2);
        return false;
    }

    public final boolean b0(c cVar, xa6 xa6, Object obj) {
        while (ec6.r(xa6.j, false, false, new b(this, cVar, xa6, obj), 1, null) == cd6.f) {
            xa6 = R(xa6);
            if (xa6 == null) {
                return false;
            }
        }
        return true;
    }

    @Override // defpackage.rc6
    public void c(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new sc6(A(), null, this);
        }
        y(cancellationException);
    }

    @Override // defpackage.m66
    public <R> R fold(R r, w76<? super R, ? super m66.a, ? extends R> w76) {
        return (R) m66.a.C0044a.a(this, r, w76);
    }

    @Override // defpackage.m66.a, defpackage.m66
    public <E extends m66.a> E get(m66.b<E> bVar) {
        return (E) m66.a.C0044a.b(this, bVar);
    }

    @Override // defpackage.m66.a
    public final m66.b<?> getKey() {
        return rc6.a.f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v9, types: [lc6] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // defpackage.rc6
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final defpackage.yb6 i(boolean r8, boolean r9, defpackage.s76<? super java.lang.Throwable, defpackage.s56> r10) {
        /*
        // Method dump skipped, instructions count: 199
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.wc6.i(boolean, boolean, s76):yb6");
    }

    @Override // defpackage.rc6
    public final CancellationException j() {
        Object J = J();
        if (J instanceof c) {
            Throwable e = ((c) J).e();
            if (e != null) {
                return Z(e, n86.j(getClass().getSimpleName(), " is cancelling"));
            }
            throw new IllegalStateException(n86.j("Job is still new or active: ", this).toString());
        } else if (J instanceof mc6) {
            throw new IllegalStateException(n86.j("Job is still new or active: ", this).toString());
        } else if (J instanceof eb6) {
            return Z(((eb6) J).f955a, null);
        } else {
            return new sc6(n86.j(getClass().getSimpleName(), " has completed normally"), null, this);
        }
    }

    @Override // defpackage.ya6
    public final void k(ed6 ed6) {
        y(ed6);
    }

    @Override // defpackage.m66
    public m66 minusKey(m66.b<?> bVar) {
        return m66.a.C0044a.c(this, bVar);
    }

    @Override // defpackage.rc6
    public final yb6 o(s76<? super Throwable, s56> s76) {
        return i(false, true, s76);
    }

    @Override // defpackage.m66
    public m66 plus(m66 m66) {
        return m66.a.C0044a.d(this, m66);
    }

    @Override // defpackage.rc6
    public final boolean start() {
        int X;
        do {
            X = X(J());
            if (X == 0) {
                return false;
            }
        } while (X != 1);
        return true;
    }

    @Override // defpackage.ed6
    public CancellationException t() {
        Throwable th;
        Object J = J();
        CancellationException cancellationException = null;
        if (J instanceof c) {
            th = ((c) J).e();
        } else if (J instanceof eb6) {
            th = ((eb6) J).f955a;
        } else if (!(J instanceof mc6)) {
            th = null;
        } else {
            throw new IllegalStateException(n86.j("Cannot be cancelling child in this state: ", J).toString());
        }
        if (th instanceof CancellationException) {
            cancellationException = (CancellationException) th;
        }
        return cancellationException == null ? new sc6(n86.j("Parent job is ", Y(J)), th, this) : cancellationException;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Q() + '{' + Y(J()) + '}');
        sb.append('@');
        sb.append(hd3.l1(this));
        return sb.toString();
    }

    public void u(Object obj) {
    }

    public final Object v(k66<Object> k66) {
        Object J;
        do {
            J = J();
            if (!(J instanceof mc6)) {
                if (!(J instanceof eb6)) {
                    return xc6.a(J);
                }
                throw ((eb6) J).f955a;
            }
        } while (X(J) < 0);
        a aVar = new a(hd3.B1(k66), this);
        aVar.v();
        aVar.g(new zb6(i(false, true, new gd6(aVar))));
        Object u = aVar.u();
        if (u == p66.COROUTINE_SUSPENDED) {
            n86.e(k66, "frame");
        }
        return u;
    }

    @Override // defpackage.rc6
    public final wa6 x(ya6 ya6) {
        return (wa6) ec6.r(this, true, false, new xa6(ya6), 2, null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00d8, code lost:
        r4 = r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00b5 A[EDGE_INSN: B:73:0x00b5->B:52:0x00b5 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0040 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean y(java.lang.Object r14) {
        /*
        // Method dump skipped, instructions count: 232
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.wc6.y(java.lang.Object):boolean");
    }

    public final boolean z(Throwable th) {
        if (N()) {
            return true;
        }
        boolean z = th instanceof CancellationException;
        wa6 wa6 = (wa6) this._parentHandle;
        if (wa6 == null || wa6 == cd6.f) {
            return z;
        }
        if (wa6.f(th) || z) {
            return true;
        }
        return false;
    }
}
