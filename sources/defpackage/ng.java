package defpackage;

@y66(c = "androidx.lifecycle.BlockRunner$maybeRun$1", f = "CoroutineLiveData.kt", l = {176}, m = "invokeSuspend")
/* renamed from: ng  reason: default package */
/* compiled from: CoroutineLiveData.kt */
public final class ng extends b76 implements w76<mb6, k66<? super s56>, Object> {
    public /* synthetic */ Object f;
    public int g;
    public final /* synthetic */ og h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ng(og ogVar, k66 k66) {
        super(2, k66);
        this.h = ogVar;
    }

    @Override // defpackage.u66
    public final k66<s56> create(Object obj, k66<?> k66) {
        n86.e(k66, "completion");
        ng ngVar = new ng(this.h, k66);
        ngVar.f = obj;
        return ngVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.w76
    public final Object invoke(mb6 mb6, k66<? super s56> k66) {
        k66<? super s56> k662 = k66;
        n86.e(k662, "completion");
        ng ngVar = new ng(this.h, k662);
        ngVar.f = mb6;
        return ngVar.invokeSuspend(s56.f3190a);
    }

    @Override // defpackage.u66
    public final Object invokeSuspend(Object obj) {
        p66 p66 = p66.COROUTINE_SUSPENDED;
        int i = this.g;
        if (i == 0) {
            hd3.Y2(obj);
            lh lhVar = new lh(this.h.c, ((mb6) this.f).n());
            w76<kh<T>, k66<? super s56>, Object> w76 = this.h.d;
            this.g = 1;
            if (w76.invoke(lhVar, this) == p66) {
                return p66;
            }
        } else if (i == 1) {
            hd3.Y2(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.h.g.invoke();
        return s56.f3190a;
    }
}
