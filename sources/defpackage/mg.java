package defpackage;

@y66(c = "androidx.lifecycle.BlockRunner$cancel$1", f = "CoroutineLiveData.kt", l = {187}, m = "invokeSuspend")
/* renamed from: mg  reason: default package */
/* compiled from: CoroutineLiveData.kt */
public final class mg extends b76 implements w76<mb6, k66<? super s56>, Object> {
    public int f;
    public final /* synthetic */ og g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public mg(og ogVar, k66 k66) {
        super(2, k66);
        this.g = ogVar;
    }

    @Override // defpackage.u66
    public final k66<s56> create(Object obj, k66<?> k66) {
        n86.e(k66, "completion");
        return new mg(this.g, k66);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.w76
    public final Object invoke(mb6 mb6, k66<? super s56> k66) {
        k66<? super s56> k662 = k66;
        n86.e(k662, "completion");
        return new mg(this.g, k662).invokeSuspend(s56.f3190a);
    }

    @Override // defpackage.u66
    public final Object invokeSuspend(Object obj) {
        p66 p66 = p66.COROUTINE_SUSPENDED;
        int i = this.f;
        if (i == 0) {
            hd3.Y2(obj);
            long j = this.g.e;
            this.f = 1;
            if (hd3.C0(j, this) == p66) {
                return p66;
            }
        } else if (i == 1) {
            hd3.Y2(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (!this.g.c.e()) {
            rc6 rc6 = this.g.f2687a;
            if (rc6 != null) {
                ec6.j(rc6, null, 1, null);
            }
            this.g.f2687a = null;
        }
        return s56.f3190a;
    }
}
