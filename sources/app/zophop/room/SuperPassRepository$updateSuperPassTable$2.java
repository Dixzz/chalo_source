package app.zophop.room;

import org.json.JSONArray;

@y66(c = "app.zophop.room.SuperPassRepository$updateSuperPassTable$2", f = "SuperPassRepository.kt", l = {111, 112, 113, 114, 115}, m = "invokeSuspend")
/* compiled from: SuperPassRepository.kt */
public final class SuperPassRepository$updateSuperPassTable$2 extends b76 implements w76<mb6, k66<? super s56>, Object> {
    public final /* synthetic */ JSONArray $lPassesArray;
    public Object L$0;
    public int label;
    public final /* synthetic */ SuperPassRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuperPassRepository$updateSuperPassTable$2(JSONArray jSONArray, SuperPassRepository superPassRepository, k66<? super SuperPassRepository$updateSuperPassTable$2> k66) {
        super(2, k66);
        this.$lPassesArray = jSONArray;
        this.this$0 = superPassRepository;
    }

    @Override // defpackage.u66
    public final k66<s56> create(Object obj, k66<?> k66) {
        return new SuperPassRepository$updateSuperPassTable$2(this.$lPassesArray, this.this$0, k66);
    }

    public final Object invoke(mb6 mb6, k66<? super s56> k66) {
        return ((SuperPassRepository$updateSuperPassTable$2) create(mb6, k66)).invokeSuspend(s56.f3190a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x007e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0093 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a9 A[RETURN] */
    @Override // defpackage.u66
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
        // Method dump skipped, instructions count: 173
        */
        throw new UnsupportedOperationException("Method not decompiled: app.zophop.room.SuperPassRepository$updateSuperPassTable$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
