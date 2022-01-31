package defpackage;

import java.util.concurrent.Callable;

@y66(c = "androidx.room.CoroutinesRoom$Companion$execute$4$job$1", f = "CoroutinesRoom.kt", l = {}, m = "invokeSuspend")
/* renamed from: ll  reason: default package */
/* compiled from: CoroutinesRoom.kt */
public final class ll extends b76 implements w76<mb6, k66<? super s56>, Object> {
    public final /* synthetic */ Callable<R> f;
    public final /* synthetic */ ra6<R> g;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: ra6<? super R> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ll(Callable<R> callable, ra6<? super R> ra6, k66<? super ll> k66) {
        super(2, k66);
        this.f = callable;
        this.g = ra6;
    }

    @Override // defpackage.u66
    public final k66<s56> create(Object obj, k66<?> k66) {
        return new ll(this.f, this.g, k66);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.w76
    public Object invoke(mb6 mb6, k66<? super s56> k66) {
        ll llVar = new ll(this.f, this.g, k66);
        s56 s56 = s56.f3190a;
        llVar.invokeSuspend(s56);
        return s56;
    }

    @Override // defpackage.u66
    public final Object invokeSuspend(Object obj) {
        p66 p66 = p66.COROUTINE_SUSPENDED;
        hd3.Y2(obj);
        try {
            this.g.resumeWith(this.f.call());
        } catch (Throwable th) {
            this.g.resumeWith(hd3.Z(th));
        }
        return s56.f3190a;
    }
}
