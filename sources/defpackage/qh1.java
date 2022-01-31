package defpackage;

@y66(c = "app.zophop.utils.ExtensionUtils$launchOnSpecifiedDispatcher$1", f = "ExtensionUtils.kt", l = {138}, m = "invokeSuspend")
/* renamed from: qh1  reason: default package */
/* compiled from: ExtensionUtils.kt */
public final class qh1 extends b76 implements w76<mb6, k66<? super s56>, Object> {
    public int f;
    public final /* synthetic */ s76<k66<? super s56>, Object> g;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: s76<? super k66<? super s56>, ? extends java.lang.Object> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public qh1(s76<? super k66<? super s56>, ? extends Object> s76, k66<? super qh1> k66) {
        super(2, k66);
        this.g = s76;
    }

    @Override // defpackage.u66
    public final k66<s56> create(Object obj, k66<?> k66) {
        return new qh1(this.g, k66);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.w76
    public Object invoke(mb6 mb6, k66<? super s56> k66) {
        return new qh1(this.g, k66).invokeSuspend(s56.f3190a);
    }

    @Override // defpackage.u66
    public final Object invokeSuspend(Object obj) {
        p66 p66 = p66.COROUTINE_SUSPENDED;
        int i = this.f;
        if (i == 0) {
            hd3.Y2(obj);
            s76<k66<? super s56>, Object> s76 = this.g;
            this.f = 1;
            if (s76.invoke(this) == p66) {
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
