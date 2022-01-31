package defpackage;

import defpackage.ul;
import java.util.Set;
import java.util.concurrent.Callable;

@y66(c = "androidx.room.CoroutinesRoom$Companion$createFlow$1", f = "CoroutinesRoom.kt", l = {110}, m = "invokeSuspend")
/* renamed from: il  reason: default package */
/* compiled from: CoroutinesRoom.kt */
public final class il extends b76 implements w76<re6<? super R>, k66<? super s56>, Object> {
    public int f;
    public /* synthetic */ Object g;
    public final /* synthetic */ boolean h;
    public final /* synthetic */ wl i;
    public final /* synthetic */ String[] j;
    public final /* synthetic */ Callable<R> k;

    @y66(c = "androidx.room.CoroutinesRoom$Companion$createFlow$1$1", f = "CoroutinesRoom.kt", l = {136}, m = "invokeSuspend")
    /* renamed from: il$a */
    /* compiled from: CoroutinesRoom.kt */
    public static final class a extends b76 implements w76<mb6, k66<? super s56>, Object> {
        public int f;
        public /* synthetic */ Object g;
        public final /* synthetic */ boolean h;
        public final /* synthetic */ wl i;
        public final /* synthetic */ re6<R> j;
        public final /* synthetic */ String[] k;
        public final /* synthetic */ Callable<R> l;

        @y66(c = "androidx.room.CoroutinesRoom$Companion$createFlow$1$1$1", f = "CoroutinesRoom.kt", l = {127, 129}, m = "invokeSuspend")
        /* renamed from: il$a$a  reason: collision with other inner class name */
        /* compiled from: CoroutinesRoom.kt */
        public static final class C0028a extends b76 implements w76<mb6, k66<? super s56>, Object> {
            public Object f;
            public int g;
            public final /* synthetic */ wl h;
            public final /* synthetic */ b i;
            public final /* synthetic */ zd6<s56> j;
            public final /* synthetic */ Callable<R> k;
            public final /* synthetic */ zd6<R> l;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0028a(wl wlVar, b bVar, zd6<s56> zd6, Callable<R> callable, zd6<R> zd62, k66<? super C0028a> k66) {
                super(2, k66);
                this.h = wlVar;
                this.i = bVar;
                this.j = zd6;
                this.k = callable;
                this.l = zd62;
            }

            @Override // defpackage.u66
            public final k66<s56> create(Object obj, k66<?> k66) {
                return new C0028a(this.h, this.i, this.j, this.k, this.l, k66);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // defpackage.w76
            public Object invoke(mb6 mb6, k66<? super s56> k66) {
                return new C0028a(this.h, this.i, this.j, this.k, this.l, k66).invokeSuspend(s56.f3190a);
            }

            /* JADX WARNING: Removed duplicated region for block: B:17:0x0047 A[Catch:{ all -> 0x0078 }] */
            /* JADX WARNING: Removed duplicated region for block: B:20:0x0052 A[Catch:{ all -> 0x0078 }] */
            @Override // defpackage.u66
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object invokeSuspend(java.lang.Object r8) {
                /*
                // Method dump skipped, instructions count: 136
                */
                throw new UnsupportedOperationException("Method not decompiled: defpackage.il.a.C0028a.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* renamed from: il$a$b */
        /* compiled from: CoroutinesRoom.kt */
        public static final class b extends ul.c {
            public final /* synthetic */ zd6<s56> b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(zd6<s56> zd6, String[] strArr) {
                super(strArr);
                this.b = zd6;
            }

            @Override // defpackage.ul.c
            public void a(Set<String> set) {
                n86.e(set, "tables");
                this.b.f(s56.f3190a);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: re6<? super R> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(boolean z, wl wlVar, re6<? super R> re6, String[] strArr, Callable<R> callable, k66<? super a> k66) {
            super(2, k66);
            this.h = z;
            this.i = wlVar;
            this.j = re6;
            this.k = strArr;
            this.l = callable;
        }

        @Override // defpackage.u66
        public final k66<s56> create(Object obj, k66<?> k66) {
            a aVar = new a(this.h, this.i, this.j, this.k, this.l, k66);
            aVar.g = obj;
            return aVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // defpackage.w76
        public Object invoke(mb6 mb6, k66<? super s56> k66) {
            return ((a) create(mb6, k66)).invokeSuspend(s56.f3190a);
        }

        @Override // defpackage.u66
        public final Object invokeSuspend(Object obj) {
            s56 s56 = s56.f3190a;
            p66 p66 = p66.COROUTINE_SUSPENDED;
            int i2 = this.f;
            if (i2 == 0) {
                hd3.Y2(obj);
                mb6 mb6 = (mb6) this.g;
                zd6 a2 = ec6.a(-1, null, null, 6);
                b bVar = new b(a2, this.k);
                ((wd6) a2).f(s56);
                cm cmVar = (cm) mb6.n().get(cm.f);
                kb6 Y = this.h ? h.Y(this.i) : h.V(this.i);
                zd6 a3 = ec6.a(0, null, null, 7);
                hd3.Y1(mb6, Y, null, new C0028a(this.i, bVar, a2, this.l, a3, null), 2, null);
                re6<R> re6 = this.j;
                this.f = 1;
                Object a4 = se6.a(re6, a3, true, this);
                if (a4 != p66) {
                    a4 = s56;
                }
                if (a4 == p66) {
                    return p66;
                }
            } else if (i2 == 1) {
                hd3.Y2(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s56;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public il(boolean z, wl wlVar, String[] strArr, Callable<R> callable, k66<? super il> k66) {
        super(2, k66);
        this.h = z;
        this.i = wlVar;
        this.j = strArr;
        this.k = callable;
    }

    @Override // defpackage.u66
    public final k66<s56> create(Object obj, k66<?> k66) {
        il ilVar = new il(this.h, this.i, this.j, this.k, k66);
        ilVar.g = obj;
        return ilVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.w76
    public Object invoke(Object obj, k66<? super s56> k66) {
        il ilVar = new il(this.h, this.i, this.j, this.k, k66);
        ilVar.g = (re6) obj;
        return ilVar.invokeSuspend(s56.f3190a);
    }

    @Override // defpackage.u66
    public final Object invokeSuspend(Object obj) {
        p66 p66 = p66.COROUTINE_SUSPENDED;
        int i2 = this.f;
        if (i2 == 0) {
            hd3.Y2(obj);
            a aVar = new a(this.h, this.i, (re6) this.g, this.j, this.k, null);
            this.f = 1;
            bg6 bg6 = new bg6(getContext(), this);
            Object C = ec6.C(bg6, bg6, aVar);
            if (C == p66) {
                n86.e(this, "frame");
            }
            if (C == p66) {
                return p66;
            }
        } else if (i2 == 1) {
            hd3.Y2(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return s56.f3190a;
    }
}
