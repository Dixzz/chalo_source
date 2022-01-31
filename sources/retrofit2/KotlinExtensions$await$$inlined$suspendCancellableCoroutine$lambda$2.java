package retrofit2;

/* compiled from: KotlinExtensions.kt */
public final class KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$2 extends o86 implements s76<Throwable, s56> {
    public final /* synthetic */ Call $this_await$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$2(Call call) {
        super(1);
        this.$this_await$inlined = call;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.s76
    public /* bridge */ /* synthetic */ s56 invoke(Throwable th) {
        invoke(th);
        return s56.f3190a;
    }

    public final void invoke(Throwable th) {
        this.$this_await$inlined.cancel();
    }
}
