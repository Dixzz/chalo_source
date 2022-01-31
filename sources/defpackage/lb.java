package defpackage;

@y66(c = "androidx.datastore.preferences.core.PreferencesKt$edit$2", f = "Preferences.kt", l = {329}, m = "invokeSuspend")
/* renamed from: lb  reason: default package */
/* compiled from: Preferences.kt */
public final class lb extends b76 implements w76<kb, k66<? super kb>, Object> {
    public int f;
    public /* synthetic */ Object g;
    public final /* synthetic */ w76<hb, k66<? super s56>, Object> h;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: w76<? super hb, ? super k66<? super s56>, ? extends java.lang.Object> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public lb(w76<? super hb, ? super k66<? super s56>, ? extends Object> w76, k66<? super lb> k66) {
        super(2, k66);
        this.h = w76;
    }

    @Override // defpackage.u66
    public final k66<s56> create(Object obj, k66<?> k66) {
        lb lbVar = new lb(this.h, k66);
        lbVar.g = obj;
        return lbVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.w76
    public Object invoke(kb kbVar, k66<? super kb> k66) {
        lb lbVar = new lb(this.h, k66);
        lbVar.g = kbVar;
        return lbVar.invokeSuspend(s56.f3190a);
    }

    @Override // defpackage.u66
    public final Object invokeSuspend(Object obj) {
        p66 p66 = p66.COROUTINE_SUSPENDED;
        int i = this.f;
        if (i == 0) {
            hd3.Y2(obj);
            hb hbVar = new hb(y56.C(((kb) this.g).a()), false);
            w76<hb, k66<? super s56>, Object> w76 = this.h;
            this.g = hbVar;
            this.f = 1;
            return w76.invoke(hbVar, this) == p66 ? p66 : hbVar;
        } else if (i == 1) {
            hb hbVar2 = (hb) this.g;
            hd3.Y2(obj);
            return hbVar2;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
