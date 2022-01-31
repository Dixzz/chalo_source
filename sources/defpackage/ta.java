package defpackage;

import defpackage.be6;
import defpackage.rc6;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: ta  reason: default package */
/* compiled from: SimpleActor.kt */
public final class ta<T> {

    /* renamed from: a  reason: collision with root package name */
    public final mb6 f3325a;
    public final w76<T, k66<? super s56>, Object> b;
    public final zd6<T> c = ec6.a(Integer.MAX_VALUE, null, null, 6);
    public final AtomicInteger d = new AtomicInteger(0);

    /* renamed from: ta$a */
    /* compiled from: SimpleActor.kt */
    public static final class a extends o86 implements s76<Throwable, s56> {
        public final /* synthetic */ s76<Throwable, s56> f;
        public final /* synthetic */ ta<T> g;
        public final /* synthetic */ w76<T, Throwable, s56> h;

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: s76<? super java.lang.Throwable, s56> */
        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: w76<? super T, ? super java.lang.Throwable, s56> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(s76<? super Throwable, s56> s76, ta<T> taVar, w76<? super T, ? super Throwable, s56> w76) {
            super(1);
            this.f = s76;
            this.g = taVar;
            this.h = w76;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: w76<T, java.lang.Throwable, s56> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // defpackage.s76
        public s56 invoke(Throwable th) {
            s56 s56;
            s56 s562 = s56.f3190a;
            Throwable th2 = th;
            this.f.invoke(th2);
            this.g.c.e(th2);
            do {
                Object a2 = this.g.c.a();
                s56 = null;
                if (a2 instanceof be6.c) {
                    a2 = null;
                }
                if (a2 != null) {
                    this.h.invoke(a2, th2);
                    s56 = s562;
                    continue;
                }
            } while (s56 != null);
            return s562;
        }
    }

    @y66(c = "androidx.datastore.core.SimpleActor$offer$2", f = "SimpleActor.kt", l = {122, 122}, m = "invokeSuspend")
    /* renamed from: ta$b */
    /* compiled from: SimpleActor.kt */
    public static final class b extends b76 implements w76<mb6, k66<? super s56>, Object> {
        public Object f;
        public int g;
        public final /* synthetic */ ta<T> h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(ta<T> taVar, k66<? super b> k66) {
            super(2, k66);
            this.h = taVar;
        }

        @Override // defpackage.u66
        public final k66<s56> create(Object obj, k66<?> k66) {
            return new b(this.h, k66);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // defpackage.w76
        public Object invoke(mb6 mb6, k66<? super s56> k66) {
            return new b(this.h, k66).invokeSuspend(s56.f3190a);
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:57)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:15)
            */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0052 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x005e A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0069  */
        @Override // defpackage.u66
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
            // Method dump skipped, instructions count: 120
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.ta.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: w76<? super T, ? super k66<? super s56>, ? extends java.lang.Object> */
    /* JADX WARN: Multi-variable type inference failed */
    public ta(mb6 mb6, s76<? super Throwable, s56> s76, w76<? super T, ? super Throwable, s56> w76, w76<? super T, ? super k66<? super s56>, ? extends Object> w762) {
        n86.e(mb6, "scope");
        n86.e(s76, "onComplete");
        n86.e(w76, "onUndeliveredElement");
        n86.e(w762, "consumeMessage");
        this.f3325a = mb6;
        this.b = w762;
        m66 n = mb6.n();
        int i = rc6.e;
        rc6 rc6 = (rc6) n.get(rc6.a.f);
        if (rc6 != null) {
            rc6.o(new a(s76, this, w76));
        }
    }

    public final void a(T t) {
        Object f = this.c.f(t);
        boolean z = f instanceof be6.a;
        Throwable th = null;
        if (z) {
            be6.a aVar = z ? (be6.a) f : null;
            if (aVar != null) {
                th = aVar.f420a;
            }
            if (th == null) {
                throw new ee6("Channel was closed normally");
            }
            throw th;
        } else if (!(!(f instanceof be6.c))) {
            throw new IllegalStateException("Check failed.".toString());
        } else if (this.d.getAndIncrement() == 0) {
            hd3.Y1(this.f3325a, null, null, new b(this, null), 3, null);
        }
    }
}
