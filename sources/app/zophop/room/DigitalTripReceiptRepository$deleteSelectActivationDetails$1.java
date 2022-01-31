package app.zophop.room;

import app.zophop.models.mTicketing.digitalTripReceipt.ProductActivationDetails;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@y66(c = "app.zophop.room.DigitalTripReceiptRepository$deleteSelectActivationDetails$1", f = "DigitalTripReceiptRepository.kt", l = {47}, m = "invokeSuspend")
/* compiled from: DigitalTripReceiptRepository.kt */
public final class DigitalTripReceiptRepository$deleteSelectActivationDetails$1 extends b76 implements w76<mb6, k66<? super s56>, Object> {
    public final /* synthetic */ List<ProductActivationDetails> $lActivationDetailsList;
    public int label;
    public final /* synthetic */ DigitalTripReceiptRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DigitalTripReceiptRepository$deleteSelectActivationDetails$1(List<ProductActivationDetails> list, DigitalTripReceiptRepository digitalTripReceiptRepository, k66<? super DigitalTripReceiptRepository$deleteSelectActivationDetails$1> k66) {
        super(2, k66);
        this.$lActivationDetailsList = list;
        this.this$0 = digitalTripReceiptRepository;
    }

    @Override // defpackage.u66
    public final k66<s56> create(Object obj, k66<?> k66) {
        return new DigitalTripReceiptRepository$deleteSelectActivationDetails$1(this.$lActivationDetailsList, this.this$0, k66);
    }

    public final Object invoke(mb6 mb6, k66<? super s56> k66) {
        return ((DigitalTripReceiptRepository$deleteSelectActivationDetails$1) create(mb6, k66)).invokeSuspend(s56.f3190a);
    }

    @Override // defpackage.u66
    public final Object invokeSuspend(Object obj) {
        p66 p66 = p66.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i == 0) {
            hd3.Y2(obj);
            List<ProductActivationDetails> list = this.$lActivationDetailsList;
            ArrayList arrayList = new ArrayList(hd3.I(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new Long(it.next().getActivationTimeStamp()));
            }
            DigitalTripReceiptDao digitalTripReceiptDao = this.this$0.getDigitalRideReceiptDao();
            this.label = 1;
            if (digitalTripReceiptDao.deleteSelectActivationDetails(arrayList, this) == p66) {
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
