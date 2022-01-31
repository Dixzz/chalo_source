package defpackage;

@y66(c = "app.zophop.utils.ExtensionUtils$launchPeriodicAsyncEagerly$1", f = "ExtensionUtils.kt", l = {104}, m = "invokeSuspend")
/* renamed from: rh1  reason: default package */
/* compiled from: ExtensionUtils.kt */
public final class rh1 extends b76 implements w76<mb6, k66<? super s56>, Object> {
    public int f;
    public /* synthetic */ Object g;
    public final /* synthetic */ long h;
    public final /* synthetic */ h76<s56> i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public rh1(long j, h76<s56> h76, k66<? super rh1> k66) {
        super(2, k66);
        this.h = j;
        this.i = h76;
    }

    @Override // defpackage.u66
    public final k66<s56> create(Object obj, k66<?> k66) {
        rh1 rh1 = new rh1(this.h, this.i, k66);
        rh1.g = obj;
        return rh1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.w76
    public Object invoke(mb6 mb6, k66<? super s56> k66) {
        rh1 rh1 = new rh1(this.h, this.i, k66);
        rh1.g = mb6;
        return rh1.invokeSuspend(s56.f3190a);
    }

    @Override // defpackage.u66
    public final Object invokeSuspend(Object obj) {
        mb6 mb6;
        p66 p66 = p66.COROUTINE_SUSPENDED;
        int i2 = this.f;
        if (i2 == 0) {
            hd3.Y2(obj);
            mb6 mb62 = (mb6) this.g;
            if (this.h > 0) {
                mb6 = mb62;
            } else {
                this.i.invoke();
                return s56.f3190a;
            }
        } else if (i2 == 1) {
            mb6 = (mb6) this.g;
            hd3.Y2(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        while (hd3.C1(mb6)) {
            this.i.invoke();
            long j = this.h;
            this.g = mb6;
            this.f = 1;
            if (hd3.C0(j, this) == p66) {
                return p66;
            }
        }
        return s56.f3190a;
    }
}
