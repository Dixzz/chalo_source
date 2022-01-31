package app.zophop.room;

import androidx.appcompat.widget.RtlSpacingHelper;

@y66(c = "app.zophop.room.DigitalTripReceiptRepository", f = "DigitalTripReceiptRepository.kt", l = {28}, m = "insertProductActivationDetails")
/* compiled from: DigitalTripReceiptRepository.kt */
public final class DigitalTripReceiptRepository$insertProductActivationDetails$1 extends w66 {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ DigitalTripReceiptRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DigitalTripReceiptRepository$insertProductActivationDetails$1(DigitalTripReceiptRepository digitalTripReceiptRepository, k66<? super DigitalTripReceiptRepository$insertProductActivationDetails$1> k66) {
        super(k66);
        this.this$0 = digitalTripReceiptRepository;
    }

    @Override // defpackage.u66
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= RtlSpacingHelper.UNDEFINED;
        return this.this$0.insertProductActivationDetails(null, this);
    }
}
