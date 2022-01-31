package defpackage;

import android.os.Handler;
import android.os.Looper;

/* renamed from: rd6  reason: default package */
/* compiled from: HandlerDispatcher.kt */
public final class rd6 extends sd6 implements tb6 {
    private volatile rd6 _immediate;
    public final Handler g;
    public final String h;
    public final boolean i;
    public final rd6 j;

    /* renamed from: rd6$a */
    /* compiled from: Runnable.kt */
    public static final class a implements Runnable {
        public final /* synthetic */ ra6 f;
        public final /* synthetic */ rd6 g;

        public a(ra6 ra6, rd6 rd6) {
            this.f = ra6;
            this.g = rd6;
        }

        public final void run() {
            this.f.m(this.g, s56.f3190a);
        }
    }

    /* renamed from: rd6$b */
    /* compiled from: HandlerDispatcher.kt */
    public static final class b extends o86 implements s76<Throwable, s56> {
        public final /* synthetic */ rd6 f;
        public final /* synthetic */ Runnable g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(rd6 rd6, Runnable runnable) {
            super(1);
            this.f = rd6;
            this.g = runnable;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.s76
        public s56 invoke(Throwable th) {
            this.f.g.removeCallbacks(this.g);
            return s56.f3190a;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public rd6(Handler handler, String str, boolean z) {
        super(null);
        rd6 rd6 = null;
        this.g = handler;
        this.h = str;
        this.i = z;
        this._immediate = z ? this : rd6;
        rd6 rd62 = this._immediate;
        if (rd62 == null) {
            rd62 = new rd6(handler, str, true);
            this._immediate = rd62;
        }
        this.j = rd62;
    }

    @Override // defpackage.ad6
    public ad6 A() {
        return this.j;
    }

    public boolean equals(Object obj) {
        return (obj instanceof rd6) && ((rd6) obj).g == this.g;
    }

    @Override // defpackage.tb6
    public void g(long j2, ra6<? super s56> ra6) {
        a aVar = new a(ra6, this);
        Handler handler = this.g;
        if (j2 > 4611686018427387903L) {
            j2 = 4611686018427387903L;
        }
        handler.postDelayed(aVar, j2);
        ((sa6) ra6).g(new b(this, aVar));
    }

    public int hashCode() {
        return System.identityHashCode(this.g);
    }

    @Override // defpackage.kb6
    public void m(m66 m66, Runnable runnable) {
        this.g.post(runnable);
    }

    @Override // defpackage.kb6
    public boolean n(m66 m66) {
        return !this.i || !n86.a(Looper.myLooper(), this.g.getLooper());
    }

    @Override // defpackage.ad6, defpackage.kb6
    public String toString() {
        String D = D();
        if (D != null) {
            return D;
        }
        String str = this.h;
        if (str == null) {
            str = this.g.toString();
        }
        return this.i ? n86.j(str, ".immediate") : str;
    }
}
