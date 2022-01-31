package app.zophop.room;

import androidx.appcompat.widget.RtlSpacingHelper;

@y66(c = "app.zophop.room.VisualValidationRepository", f = "VisualValidationRepository.kt", l = {24}, m = "insertVisualValidationActivationDetails")
/* compiled from: VisualValidationRepository.kt */
public final class VisualValidationRepository$insertVisualValidationActivationDetails$1 extends w66 {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ VisualValidationRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VisualValidationRepository$insertVisualValidationActivationDetails$1(VisualValidationRepository visualValidationRepository, k66<? super VisualValidationRepository$insertVisualValidationActivationDetails$1> k66) {
        super(k66);
        this.this$0 = visualValidationRepository;
    }

    @Override // defpackage.u66
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= RtlSpacingHelper.UNDEFINED;
        return this.this$0.insertVisualValidationActivationDetails(null, this);
    }
}
