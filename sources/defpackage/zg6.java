package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: zg6  reason: default package */
/* compiled from: Mutex.kt */
public final class zg6 implements yg6 {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f4171a = AtomicReferenceFieldUpdater.newUpdater(zg6.class, Object.class, "_state");
    public volatile /* synthetic */ Object _state;

    /* renamed from: zg6$a */
    /* compiled from: Mutex.kt */
    public final class a extends b {
        public final ra6<s56> j;

        /* renamed from: zg6$a$a  reason: collision with other inner class name */
        /* compiled from: Mutex.kt */
        public static final class C0070a extends o86 implements s76<Throwable, s56> {
            public final /* synthetic */ zg6 f;
            public final /* synthetic */ a g;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0070a(zg6 zg6, a aVar) {
                super(1);
                this.f = zg6;
                this.g = aVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // defpackage.s76
            public s56 invoke(Throwable th) {
                this.f.b(this.g.i);
                return s56.f3190a;
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: ra6<? super s56> */
        /* JADX WARN: Multi-variable type inference failed */
        public a(Object obj, ra6<? super s56> ra6) {
            super(zg6.this, obj);
            this.j = ra6;
        }

        @Override // defpackage.uf6
        public String toString() {
            StringBuilder i0 = hj1.i0("LockCont[");
            i0.append(this.i);
            i0.append(", ");
            i0.append(this.j);
            i0.append("] for ");
            i0.append(zg6.this);
            return i0.toString();
        }

        @Override // defpackage.zg6.b
        public void v(Object obj) {
            this.j.s(obj);
        }

        @Override // defpackage.zg6.b
        public Object w() {
            return this.j.l(s56.f3190a, null, new C0070a(zg6.this, this));
        }
    }

    /* renamed from: zg6$b */
    /* compiled from: Mutex.kt */
    public abstract class b extends uf6 implements yb6 {
        public final Object i;

        public b(zg6 zg6, Object obj) {
            this.i = obj;
        }

        @Override // defpackage.yb6
        public final void h() {
            s();
        }

        public abstract void v(Object obj);

        public abstract Object w();
    }

    /* renamed from: zg6$c */
    /* compiled from: Mutex.kt */
    public static final class c extends sf6 {
        public Object i;

        public c(Object obj) {
            this.i = obj;
        }

        @Override // defpackage.uf6
        public String toString() {
            StringBuilder i0 = hj1.i0("LockedQueue[");
            i0.append(this.i);
            i0.append(']');
            return i0.toString();
        }
    }

    /* renamed from: zg6$d */
    /* compiled from: Mutex.kt */
    public static final class d extends nf6<zg6> {
        public final c b;

        public d(c cVar) {
            this.b = cVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // defpackage.nf6
        public void b(zg6 zg6, Object obj) {
            zg6.f4171a.compareAndSet(zg6, this, obj == null ? ch6.e : this.b);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.nf6
        public Object c(zg6 zg6) {
            c cVar = this.b;
            if (cVar.m() == cVar) {
                return null;
            }
            return ch6.f566a;
        }
    }

    public zg6(boolean z) {
        this._state = z ? ch6.d : ch6.e;
    }

    @Override // defpackage.yg6
    public Object a(Object obj, k66<? super s56> k66) {
        boolean z;
        boolean z2;
        xg6 xg6 = ch6.d;
        dg6 dg6 = ch6.c;
        s56 s56 = s56.f3190a;
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof xg6) {
                if (((xg6) obj2).f3927a != dg6) {
                    break;
                } else if (f4171a.compareAndSet(this, obj2, xg6)) {
                    z = true;
                    break;
                }
            } else if (obj2 instanceof c) {
                if (!(((c) obj2).i != null)) {
                    throw new IllegalStateException(n86.j("Already locked by ", null).toString());
                }
            } else if (obj2 instanceof zf6) {
                ((zf6) obj2).a(this);
            } else {
                throw new IllegalStateException(n86.j("Illegal state ", obj2).toString());
            }
        }
        z = false;
        if (z) {
            return s56;
        }
        sa6 o1 = hd3.o1(hd3.B1(k66));
        a aVar = new a(null, o1);
        while (true) {
            Object obj3 = this._state;
            if (obj3 instanceof xg6) {
                xg6 xg62 = (xg6) obj3;
                if (xg62.f3927a != dg6) {
                    f4171a.compareAndSet(this, obj3, new c(xg62.f3927a));
                } else if (f4171a.compareAndSet(this, obj3, xg6)) {
                    o1.C(s56, o1.h, new ah6(this, null));
                    break;
                }
            } else if (obj3 instanceof c) {
                if (((c) obj3).i != null) {
                    uf6 uf6 = (uf6) obj3;
                    bh6 bh6 = new bh6(aVar, this, obj3);
                    while (true) {
                        int u = uf6.o().u(aVar, uf6, bh6);
                        if (u != 1) {
                            if (u == 2) {
                                z2 = false;
                                break;
                            }
                        } else {
                            z2 = true;
                            break;
                        }
                    }
                    if (z2) {
                        o1.g(new fd6(aVar));
                        break;
                    }
                } else {
                    throw new IllegalStateException(n86.j("Already locked by ", null).toString());
                }
            } else if (obj3 instanceof zf6) {
                ((zf6) obj3).a(this);
            } else {
                throw new IllegalStateException(n86.j("Illegal state ", obj3).toString());
            }
        }
        Object u2 = o1.u();
        p66 p66 = p66.COROUTINE_SUSPENDED;
        if (u2 == p66) {
            n86.e(k66, "frame");
        }
        if (u2 != p66) {
            u2 = s56;
        }
        return u2 == p66 ? u2 : s56;
    }

    @Override // defpackage.yg6
    public void b(Object obj) {
        uf6 uf6;
        while (true) {
            Object obj2 = this._state;
            boolean z = true;
            if (obj2 instanceof xg6) {
                if (obj == null) {
                    if (((xg6) obj2).f3927a == ch6.c) {
                        z = false;
                    }
                    if (!z) {
                        throw new IllegalStateException("Mutex is not locked".toString());
                    }
                } else {
                    xg6 xg6 = (xg6) obj2;
                    if (xg6.f3927a != obj) {
                        z = false;
                    }
                    if (!z) {
                        StringBuilder i0 = hj1.i0("Mutex is locked by ");
                        i0.append(xg6.f3927a);
                        i0.append(" but expected ");
                        i0.append(obj);
                        throw new IllegalStateException(i0.toString().toString());
                    }
                }
                if (f4171a.compareAndSet(this, obj2, ch6.e)) {
                    return;
                }
            } else if (obj2 instanceof zf6) {
                ((zf6) obj2).a(this);
            } else if (obj2 instanceof c) {
                if (obj != null) {
                    c cVar = (c) obj2;
                    if (cVar.i != obj) {
                        z = false;
                    }
                    if (!z) {
                        StringBuilder i02 = hj1.i0("Mutex is locked by ");
                        i02.append(cVar.i);
                        i02.append(" but expected ");
                        i02.append(obj);
                        throw new IllegalStateException(i02.toString().toString());
                    }
                }
                c cVar2 = (c) obj2;
                while (true) {
                    uf6 = (uf6) cVar2.m();
                    if (uf6 == cVar2) {
                        uf6 = null;
                        break;
                    } else if (uf6.s()) {
                        break;
                    } else {
                        uf6.p();
                    }
                }
                if (uf6 == null) {
                    d dVar = new d(cVar2);
                    if (f4171a.compareAndSet(this, obj2, dVar) && dVar.a(this) == null) {
                        return;
                    }
                } else {
                    b bVar = (b) uf6;
                    Object w = bVar.w();
                    if (w != null) {
                        Object obj3 = bVar.i;
                        if (obj3 == null) {
                            obj3 = ch6.b;
                        }
                        cVar2.i = obj3;
                        bVar.v(w);
                        return;
                    }
                }
            } else {
                throw new IllegalStateException(n86.j("Illegal state ", obj2).toString());
            }
        }
    }

    public String toString() {
        while (true) {
            Object obj = this._state;
            if (obj instanceof xg6) {
                StringBuilder i0 = hj1.i0("Mutex[");
                i0.append(((xg6) obj).f3927a);
                i0.append(']');
                return i0.toString();
            } else if (obj instanceof zf6) {
                ((zf6) obj).a(this);
            } else if (obj instanceof c) {
                StringBuilder i02 = hj1.i0("Mutex[");
                i02.append(((c) obj).i);
                i02.append(']');
                return i02.toString();
            } else {
                throw new IllegalStateException(n86.j("Illegal state ", obj).toString());
            }
        }
    }
}
