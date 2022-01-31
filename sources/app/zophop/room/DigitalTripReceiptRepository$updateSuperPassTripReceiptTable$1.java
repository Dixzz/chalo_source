package app.zophop.room;

import app.zophop.models.mTicketing.digitalTripReceipt.DigitalTripReceiptParser;
import app.zophop.models.mTicketing.digitalTripReceipt.SuperPassTripReceipt;
import java.util.List;
import org.json.JSONObject;

@y66(c = "app.zophop.room.DigitalTripReceiptRepository$updateSuperPassTripReceiptTable$1", f = "DigitalTripReceiptRepository.kt", l = {81, 82}, m = "invokeSuspend")
/* compiled from: DigitalTripReceiptRepository.kt */
public final class DigitalTripReceiptRepository$updateSuperPassTripReceiptTable$1 extends b76 implements w76<mb6, k66<? super s56>, Object> {
    public final /* synthetic */ JSONObject $lSuperPassTripHistoryObject;
    public Object L$0;
    public int label;
    public final /* synthetic */ DigitalTripReceiptRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DigitalTripReceiptRepository$updateSuperPassTripReceiptTable$1(JSONObject jSONObject, DigitalTripReceiptRepository digitalTripReceiptRepository, k66<? super DigitalTripReceiptRepository$updateSuperPassTripReceiptTable$1> k66) {
        super(2, k66);
        this.$lSuperPassTripHistoryObject = jSONObject;
        this.this$0 = digitalTripReceiptRepository;
    }

    @Override // defpackage.u66
    public final k66<s56> create(Object obj, k66<?> k66) {
        return new DigitalTripReceiptRepository$updateSuperPassTripReceiptTable$1(this.$lSuperPassTripHistoryObject, this.this$0, k66);
    }

    public final Object invoke(mb6 mb6, k66<? super s56> k66) {
        return ((DigitalTripReceiptRepository$updateSuperPassTripReceiptTable$1) create(mb6, k66)).invokeSuspend(s56.f3190a);
    }

    @Override // defpackage.u66
    public final Object invokeSuspend(Object obj) {
        List<SuperPassTripReceipt> list;
        s56 s56 = s56.f3190a;
        p66 p66 = p66.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i == 0) {
            hd3.Y2(obj);
            list = DigitalTripReceiptParser.INSTANCE.parseSuperPassTripReceiptsHistoryObject(this.$lSuperPassTripHistoryObject);
            if (list == null) {
                return s56;
            }
            String string = this.$lSuperPassTripHistoryObject.getString("passId");
            DigitalTripReceiptDao digitalTripReceiptDao = this.this$0.getDigitalRideReceiptDao();
            n86.d(string, "lPassId");
            this.L$0 = list;
            this.label = 1;
            if (digitalTripReceiptDao.deleteSelectSuperPassTripReceipts(string, this) == p66) {
                return p66;
            }
        } else if (i == 1) {
            list = (List) this.L$0;
            hd3.Y2(obj);
        } else if (i == 2) {
            hd3.Y2(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        DigitalTripReceiptDao digitalTripReceiptDao2 = this.this$0.getDigitalRideReceiptDao();
        this.L$0 = null;
        this.label = 2;
        return digitalTripReceiptDao2.insertSuperPassTripReceiptsList(list, this) == p66 ? p66 : s56;
    }
}
