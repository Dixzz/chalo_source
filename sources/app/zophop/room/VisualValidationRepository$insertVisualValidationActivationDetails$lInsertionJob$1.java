package app.zophop.room;

import app.zophop.models.mTicketing.VisualValidationActivationDetails;

@y66(c = "app.zophop.room.VisualValidationRepository$insertVisualValidationActivationDetails$lInsertionJob$1", f = "VisualValidationRepository.kt", l = {22}, m = "invokeSuspend")
/* compiled from: VisualValidationRepository.kt */
public final class VisualValidationRepository$insertVisualValidationActivationDetails$lInsertionJob$1 extends b76 implements w76<mb6, k66<? super s56>, Object> {
    public final /* synthetic */ VisualValidationActivationDetails $lVisualValidationActivationDetails;
    public int label;
    public final /* synthetic */ VisualValidationRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VisualValidationRepository$insertVisualValidationActivationDetails$lInsertionJob$1(VisualValidationRepository visualValidationRepository, VisualValidationActivationDetails visualValidationActivationDetails, k66<? super VisualValidationRepository$insertVisualValidationActivationDetails$lInsertionJob$1> k66) {
        super(2, k66);
        this.this$0 = visualValidationRepository;
        this.$lVisualValidationActivationDetails = visualValidationActivationDetails;
    }

    @Override // defpackage.u66
    public final k66<s56> create(Object obj, k66<?> k66) {
        return new VisualValidationRepository$insertVisualValidationActivationDetails$lInsertionJob$1(this.this$0, this.$lVisualValidationActivationDetails, k66);
    }

    public final Object invoke(mb6 mb6, k66<? super s56> k66) {
        return ((VisualValidationRepository$insertVisualValidationActivationDetails$lInsertionJob$1) create(mb6, k66)).invokeSuspend(s56.f3190a);
    }

    @Override // defpackage.u66
    public final Object invokeSuspend(Object obj) {
        p66 p66 = p66.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i == 0) {
            hd3.Y2(obj);
            VisualValidationDao access$getVisualValidationDao = VisualValidationRepository.access$getVisualValidationDao(this.this$0);
            VisualValidationActivationDetails visualValidationActivationDetails = this.$lVisualValidationActivationDetails;
            this.label = 1;
            if (access$getVisualValidationDao.insertActivationDetails(visualValidationActivationDetails, this) == p66) {
                return p66;
            }
        } else if (i == 1) {
            hd3.Y2(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return s56.f3190a;
    }
}
