package app.zophop.room;

/* compiled from: OnlineCardRechargeRepository.kt */
public final class OnlineCardRechargeRepository$onlineCardRechargeDao$2 extends o86 implements h76<OnlineCardRechargeDao> {
    public final /* synthetic */ OnlineCardRechargeRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OnlineCardRechargeRepository$onlineCardRechargeDao$2(OnlineCardRechargeRepository onlineCardRechargeRepository) {
        super(0);
        this.this$0 = onlineCardRechargeRepository;
    }

    @Override // defpackage.h76
    public final OnlineCardRechargeDao invoke() {
        return AppDatabase.getDatabase(this.this$0.getContext()).getOnlineCardRechargeDao();
    }
}
