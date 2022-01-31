package defpackage;

/* renamed from: ah  reason: default package */
/* compiled from: Lifecycle.kt */
public abstract class ah implements mb6 {

    @y66(c = "androidx.lifecycle.LifecycleCoroutineScope$launchWhenStarted$1", f = "Lifecycle.kt", l = {87}, m = "invokeSuspend")
    /* renamed from: ah$a */
    /* compiled from: Lifecycle.kt */
    public static final class a extends b76 implements w76<mb6, k66<? super s56>, Object> {
        public int f;
        public final /* synthetic */ ah g;
        public final /* synthetic */ w76 h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ah ahVar, w76 w76, k66 k66) {
            super(2, k66);
            this.g = ahVar;
            this.h = w76;
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

        @Override // defpackage.u66
        public final Object invokeSuspend(Object obj) {
            p66 p66 = p66.COROUTINE_SUSPENDED;
            int i = this.f;
            if (i == 0) {
                hd3.Y2(obj);
                zg h2 = this.g.h();
                w76 w76 = this.h;
                this.f = 1;
                if (h.F0(h2, w76, this) == p66) {
                    return p66;
                }
            } else if (i == 1) {
                hd3.Y2(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s56.f3190a;
        }
    }

    public abstract zg h();

    public final rc6 i(w76<? super mb6, ? super k66<? super s56>, ? extends Object> w76) {
        n86.e(w76, "block");
        return hd3.Y1(this, null, null, new a(this, w76, null), 3, null);
    }
}
