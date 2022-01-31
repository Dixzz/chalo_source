package app.zophop.room;

import androidx.appcompat.widget.RtlSpacingHelper;

@y66(c = "app.zophop.room.SuperPassRepository", f = "SuperPassRepository.kt", l = {198, 201}, m = "getSuperPassCount")
/* compiled from: SuperPassRepository.kt */
public final class SuperPassRepository$getSuperPassCount$1 extends w66 {
    public int I$0;
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ SuperPassRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuperPassRepository$getSuperPassCount$1(SuperPassRepository superPassRepository, k66<? super SuperPassRepository$getSuperPassCount$1> k66) {
        super(k66);
        this.this$0 = superPassRepository;
    }

    @Override // defpackage.u66
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= RtlSpacingHelper.UNDEFINED;
        return this.this$0.getSuperPassCount(this);
    }
}
