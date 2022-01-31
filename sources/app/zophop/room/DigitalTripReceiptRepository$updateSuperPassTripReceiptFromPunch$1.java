package app.zophop.room;

import app.zophop.models.mTicketing.digitalTripReceipt.SuperPassTripReceipt;

@y66(c = "app.zophop.room.DigitalTripReceiptRepository$updateSuperPassTripReceiptFromPunch$1", f = "DigitalTripReceiptRepository.kt", l = {64, 69}, m = "invokeSuspend")
/* compiled from: DigitalTripReceiptRepository.kt */
public final class DigitalTripReceiptRepository$updateSuperPassTripReceiptFromPunch$1 extends b76 implements w76<mb6, k66<? super s56>, Object> {
    public final /* synthetic */ SuperPassTripReceipt $lSuperPassTripReceipt;
    public int label;
    public final /* synthetic */ DigitalTripReceiptRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DigitalTripReceiptRepository$updateSuperPassTripReceiptFromPunch$1(DigitalTripReceiptRepository digitalTripReceiptRepository, SuperPassTripReceipt superPassTripReceipt, k66<? super DigitalTripReceiptRepository$updateSuperPassTripReceiptFromPunch$1> k66) {
        super(2, k66);
        this.this$0 = digitalTripReceiptRepository;
        this.$lSuperPassTripReceipt = superPassTripReceipt;
    }

    @Override // defpackage.u66
    public final k66<s56> create(Object obj, k66<?> k66) {
        return new DigitalTripReceiptRepository$updateSuperPassTripReceiptFromPunch$1(this.this$0, this.$lSuperPassTripReceipt, k66);
    }

    public final Object invoke(mb6 mb6, k66<? super s56> k66) {
        return ((DigitalTripReceiptRepository$updateSuperPassTripReceiptFromPunch$1) create(mb6, k66)).invokeSuspend(s56.f3190a);
    }

    @Override // defpackage.u66
    public final Object invokeSuspend(Object obj) {
        p66 p66 = p66.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i == 0) {
            hd3.Y2(obj);
            DigitalTripReceiptDao digitalTripReceiptDao = this.this$0.getDigitalRideReceiptDao();
            String passId = this.$lSuperPassTripReceipt.getPassId();
            long activationTimeStamp = this.$lSuperPassTripReceipt.getActivationTimeStamp();
            this.label = 1;
            if (digitalTripReceiptDao.deleteSuperPassTripReceipt(passId, activationTimeStamp, -1, this) == p66) {
                return p66;
            }
        } else if (i == 1) {
            hd3.Y2(obj);
        } else if (i == 2) {
            hd3.Y2(obj);
            return s56.f3190a;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        DigitalTripReceiptDao digitalTripReceiptDao2 = this.this$0.getDigitalRideReceiptDao();
        SuperPassTripReceipt superPassTripReceipt = this.$lSuperPassTripReceipt;
        this.label = 2;
        if (digitalTripReceiptDao2.insertSuperPassTripReceipt(superPassTripReceipt, this) == p66) {
            return p66;
        }
        return s56.f3190a;
    }
}
