package app.zophop.room;

import app.zophop.models.mTicketing.digitalTripReceipt.ProductActivationDetails;

@y66(c = "app.zophop.room.DigitalTripReceiptRepository$insertProductActivationDetails$lInsertionJob$1", f = "DigitalTripReceiptRepository.kt", l = {26}, m = "invokeSuspend")
/* compiled from: DigitalTripReceiptRepository.kt */
public final class DigitalTripReceiptRepository$insertProductActivationDetails$lInsertionJob$1 extends b76 implements w76<mb6, k66<? super s56>, Object> {
    public final /* synthetic */ ProductActivationDetails $lProductActivationDetails;
    public int label;
    public final /* synthetic */ DigitalTripReceiptRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DigitalTripReceiptRepository$insertProductActivationDetails$lInsertionJob$1(DigitalTripReceiptRepository digitalTripReceiptRepository, ProductActivationDetails productActivationDetails, k66<? super DigitalTripReceiptRepository$insertProductActivationDetails$lInsertionJob$1> k66) {
        super(2, k66);
        this.this$0 = digitalTripReceiptRepository;
        this.$lProductActivationDetails = productActivationDetails;
    }

    @Override // defpackage.u66
    public final k66<s56> create(Object obj, k66<?> k66) {
        return new DigitalTripReceiptRepository$insertProductActivationDetails$lInsertionJob$1(this.this$0, this.$lProductActivationDetails, k66);
    }

    public final Object invoke(mb6 mb6, k66<? super s56> k66) {
        return ((DigitalTripReceiptRepository$insertProductActivationDetails$lInsertionJob$1) create(mb6, k66)).invokeSuspend(s56.f3190a);
    }

    @Override // defpackage.u66
    public final Object invokeSuspend(Object obj) {
        p66 p66 = p66.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i == 0) {
            hd3.Y2(obj);
            DigitalTripReceiptDao digitalTripReceiptDao = this.this$0.getDigitalRideReceiptDao();
            ProductActivationDetails productActivationDetails = this.$lProductActivationDetails;
            this.label = 1;
            if (digitalTripReceiptDao.insertActivationDetails(productActivationDetails, this) == p66) {
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
