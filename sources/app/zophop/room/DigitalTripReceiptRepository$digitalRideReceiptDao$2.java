package app.zophop.room;

/* compiled from: DigitalTripReceiptRepository.kt */
public final class DigitalTripReceiptRepository$digitalRideReceiptDao$2 extends o86 implements h76<DigitalTripReceiptDao> {
    public final /* synthetic */ DigitalTripReceiptRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DigitalTripReceiptRepository$digitalRideReceiptDao$2(DigitalTripReceiptRepository digitalTripReceiptRepository) {
        super(0);
        this.this$0 = digitalTripReceiptRepository;
    }

    @Override // defpackage.h76
    public final DigitalTripReceiptDao invoke() {
        return AppDatabase.getDatabase(this.this$0.getContext()).getDigitalTripReceiptDao();
    }
}
