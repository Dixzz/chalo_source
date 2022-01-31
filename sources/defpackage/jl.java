package defpackage;

import java.util.concurrent.Callable;

@y66(c = "androidx.room.CoroutinesRoom$Companion$execute$2", f = "CoroutinesRoom.kt", l = {}, m = "invokeSuspend")
/* renamed from: jl  reason: default package */
/* compiled from: CoroutinesRoom.kt */
public final class jl extends b76 implements w76<mb6, k66<? super R>, Object> {
    public final /* synthetic */ Callable<R> f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public jl(Callable<R> callable, k66<? super jl> k66) {
        super(2, k66);
        this.f = callable;
    }

    @Override // defpackage.u66
    public final k66<s56> create(Object obj, k66<?> k66) {
        return new jl(this.f, k66);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.w76
    public Object invoke(mb6 mb6, Object obj) {
        jl jlVar = new jl(this.f, (k66) obj);
        s56 s56 = s56.f3190a;
        p66 p66 = p66.COROUTINE_SUSPENDED;
        hd3.Y2(s56);
        return jlVar.f.call();
    }

    @Override // defpackage.u66
    public final Object invokeSuspend(Object obj) {
        p66 p66 = p66.COROUTINE_SUSPENDED;
        hd3.Y2(obj);
        return this.f.call();
    }
}
