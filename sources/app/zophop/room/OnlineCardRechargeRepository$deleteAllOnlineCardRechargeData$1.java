package app.zophop.room;

@y66(c = "app.zophop.room.OnlineCardRechargeRepository$deleteAllOnlineCardRechargeData$1", f = "OnlineCardRechargeRepository.kt", l = {24}, m = "invokeSuspend")
/* compiled from: OnlineCardRechargeRepository.kt */
public final class OnlineCardRechargeRepository$deleteAllOnlineCardRechargeData$1 extends b76 implements w76<mb6, k66<? super s56>, Object> {
    public int label;
    public final /* synthetic */ OnlineCardRechargeRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OnlineCardRechargeRepository$deleteAllOnlineCardRechargeData$1(OnlineCardRechargeRepository onlineCardRechargeRepository, k66<? super OnlineCardRechargeRepository$deleteAllOnlineCardRechargeData$1> k66) {
        super(2, k66);
        this.this$0 = onlineCardRechargeRepository;
    }

    @Override // defpackage.u66
    public final k66<s56> create(Object obj, k66<?> k66) {
        return new OnlineCardRechargeRepository$deleteAllOnlineCardRechargeData$1(this.this$0, k66);
    }

    public final Object invoke(mb6 mb6, k66<? super s56> k66) {
        return ((OnlineCardRechargeRepository$deleteAllOnlineCardRechargeData$1) create(mb6, k66)).invokeSuspend(s56.f3190a);
    }

    @Override // defpackage.u66
    public final Object invokeSuspend(Object obj) {
        p66 p66 = p66.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i == 0) {
            hd3.Y2(obj);
            OnlineCardRechargeDao onlineCardRechargeDao = this.this$0.getOnlineCardRechargeDao();
            this.label = 1;
            if (onlineCardRechargeDao.deleteAllOnlineCardRechargeHistory(this) == p66) {
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
