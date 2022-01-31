package app.zophop.room;

import org.json.JSONArray;

@y66(c = "app.zophop.room.SuperPassRepository$updatePendingSuperPassTable$2", f = "SuperPassRepository.kt", l = {70, 74, 75}, m = "invokeSuspend")
/* compiled from: SuperPassRepository.kt */
public final class SuperPassRepository$updatePendingSuperPassTable$2 extends b76 implements w76<mb6, k66<? super s56>, Object> {
    public final /* synthetic */ JSONArray $lRecentTransactionsArray;
    public Object L$0;
    public int label;
    public final /* synthetic */ SuperPassRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuperPassRepository$updatePendingSuperPassTable$2(SuperPassRepository superPassRepository, JSONArray jSONArray, k66<? super SuperPassRepository$updatePendingSuperPassTable$2> k66) {
        super(2, k66);
        this.this$0 = superPassRepository;
        this.$lRecentTransactionsArray = jSONArray;
    }

    @Override // defpackage.u66
    public final k66<s56> create(Object obj, k66<?> k66) {
        return new SuperPassRepository$updatePendingSuperPassTable$2(this.this$0, this.$lRecentTransactionsArray, k66);
    }

    public final Object invoke(mb6 mb6, k66<? super s56> k66) {
        return ((SuperPassRepository$updatePendingSuperPassTable$2) create(mb6, k66)).invokeSuspend(s56.f3190a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0074 A[RETURN] */
    @Override // defpackage.u66
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
        // Method dump skipped, instructions count: 120
        */
        throw new UnsupportedOperationException("Method not decompiled: app.zophop.room.SuperPassRepository$updatePendingSuperPassTable$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
