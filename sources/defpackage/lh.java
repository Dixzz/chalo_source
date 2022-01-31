package defpackage;

import com.razorpay.AnalyticsConstants;

/* renamed from: lh  reason: default package */
/* compiled from: CoroutineLiveData.kt */
public final class lh<T> implements kh<T> {

    /* renamed from: a  reason: collision with root package name */
    public final m66 f2219a;
    public rg<T> b;

    @y66(c = "androidx.lifecycle.LiveDataScopeImpl$emit$2", f = "CoroutineLiveData.kt", l = {98}, m = "invokeSuspend")
    /* renamed from: lh$a */
    /* compiled from: CoroutineLiveData.kt */
    public static final class a extends b76 implements w76<mb6, k66<? super s56>, Object> {
        public int f;
        public final /* synthetic */ lh g;
        public final /* synthetic */ Object h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(lh lhVar, Object obj, k66 k66) {
            super(2, k66);
            this.g = lhVar;
            this.h = obj;
        }

        @Override // defpackage.u66
        public final k66<s56> create(Object obj, k66<?> k66) {
            n86.e(k66, "completion");
            return new a(this.g, this.h, k66);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // defpackage.w76
        public final Object invoke(mb6 mb6, k66<? super s56> k66) {
            k66<? super s56> k662 = k66;
            n86.e(k662, "completion");
            return new a(this.g, this.h, k662).invokeSuspend(s56.f3190a);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v2, resolved type: rg<T> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // defpackage.u66
        public final Object invokeSuspend(Object obj) {
            p66 p66 = p66.COROUTINE_SUSPENDED;
            int i = this.f;
            if (i == 0) {
                hd3.Y2(obj);
                rg<T> rgVar = this.g.b;
                this.f = 1;
                if (rgVar.n(this) == p66) {
                    return p66;
                }
            } else if (i == 1) {
                hd3.Y2(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this.g.b.l(this.h);
            return s56.f3190a;
        }
    }

    public lh(rg<T> rgVar, m66 m66) {
        n86.e(rgVar, "target");
        n86.e(m66, AnalyticsConstants.CONTEXT);
        this.b = rgVar;
        xb6 xb6 = xb6.f3911a;
        this.f2219a = m66.plus(xf6.c.A());
    }

    @Override // defpackage.kh
    public Object a(T t, k66<? super s56> k66) {
        Object j3 = hd3.j3(this.f2219a, new a(this, t, null), k66);
        if (j3 == p66.COROUTINE_SUSPENDED) {
            return j3;
        }
        return s56.f3190a;
    }
}
