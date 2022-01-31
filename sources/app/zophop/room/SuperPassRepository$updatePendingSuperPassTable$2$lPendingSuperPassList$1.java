package app.zophop.room;

import app.zophop.models.mTicketing.superPass.SuperPassJsonParser;
import app.zophop.models.mTicketing.superPass.pendingSuperPass.PendingSuperPass;
import java.util.List;
import org.json.JSONArray;

@y66(c = "app.zophop.room.SuperPassRepository$updatePendingSuperPassTable$2$lPendingSuperPassList$1", f = "SuperPassRepository.kt", l = {}, m = "invokeSuspend")
/* compiled from: SuperPassRepository.kt */
public final class SuperPassRepository$updatePendingSuperPassTable$2$lPendingSuperPassList$1 extends b76 implements w76<mb6, k66<? super List<? extends PendingSuperPass>>, Object> {
    public final /* synthetic */ JSONArray $lRecentTransactionsArray;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuperPassRepository$updatePendingSuperPassTable$2$lPendingSuperPassList$1(JSONArray jSONArray, k66<? super SuperPassRepository$updatePendingSuperPassTable$2$lPendingSuperPassList$1> k66) {
        super(2, k66);
        this.$lRecentTransactionsArray = jSONArray;
    }

    @Override // defpackage.u66
    public final k66<s56> create(Object obj, k66<?> k66) {
        return new SuperPassRepository$updatePendingSuperPassTable$2$lPendingSuperPassList$1(this.$lRecentTransactionsArray, k66);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.w76
    public /* bridge */ /* synthetic */ Object invoke(mb6 mb6, k66<? super List<? extends PendingSuperPass>> k66) {
        return invoke(mb6, (k66<? super List<PendingSuperPass>>) k66);
    }

    public final Object invoke(mb6 mb6, k66<? super List<PendingSuperPass>> k66) {
        return ((SuperPassRepository$updatePendingSuperPassTable$2$lPendingSuperPassList$1) create(mb6, k66)).invokeSuspend(s56.f3190a);
    }

    @Override // defpackage.u66
    public final Object invokeSuspend(Object obj) {
        p66 p66 = p66.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            hd3.Y2(obj);
            return SuperPassJsonParser.INSTANCE.parseRecentTransactionsArray(this.$lRecentTransactionsArray);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
