package defpackage;

import android.os.CancellationSignal;

/* renamed from: kl  reason: default package */
/* compiled from: CoroutinesRoom.kt */
public final class kl extends o86 implements s76<Throwable, s56> {
    public final /* synthetic */ CancellationSignal f;
    public final /* synthetic */ rc6 g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public kl(CancellationSignal cancellationSignal, rc6 rc6) {
        super(1);
        this.f = cancellationSignal;
        this.g = rc6;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.s76
    public s56 invoke(Throwable th) {
        this.f.cancel();
        ec6.j(this.g, null, 1, null);
        return s56.f3190a;
    }
}
