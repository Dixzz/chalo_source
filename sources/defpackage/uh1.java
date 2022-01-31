package defpackage;

@y66(c = "app.zophop.utils.ExtensionUtils$setOnMainThread$2", f = "ExtensionUtils.kt", l = {}, m = "invokeSuspend")
/* renamed from: uh1  reason: default package */
/* compiled from: ExtensionUtils.kt */
public final class uh1 extends b76 implements w76<mb6, k66<? super s56>, Object> {
    public final /* synthetic */ wh f;
    public final /* synthetic */ String g;
    public final /* synthetic */ Object h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public uh1(wh whVar, String str, Object obj, k66<? super uh1> k66) {
        super(2, k66);
        this.f = whVar;
        this.g = str;
        this.h = obj;
    }

    @Override // defpackage.u66
    public final k66<s56> create(Object obj, k66<?> k66) {
        return new uh1(this.f, this.g, this.h, k66);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.w76
    public Object invoke(mb6 mb6, k66<? super s56> k66) {
        uh1 uh1 = new uh1(this.f, this.g, this.h, k66);
        s56 s56 = s56.f3190a;
        p66 p66 = p66.COROUTINE_SUSPENDED;
        hd3.Y2(s56);
        uh1.f.b(uh1.g, uh1.h);
        return s56;
    }

    @Override // defpackage.u66
    public final Object invokeSuspend(Object obj) {
        p66 p66 = p66.COROUTINE_SUSPENDED;
        hd3.Y2(obj);
        this.f.b(this.g, this.h);
        return s56.f3190a;
    }
}
