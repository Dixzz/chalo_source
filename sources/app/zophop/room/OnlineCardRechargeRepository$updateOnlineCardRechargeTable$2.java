package app.zophop.room;

import app.zophop.models.mTicketing.cardRecharge.CardRechargeJsonParser;
import app.zophop.models.mTicketing.cardRecharge.OnlineCardRecharge;
import java.util.List;
import org.json.JSONArray;

@y66(c = "app.zophop.room.OnlineCardRechargeRepository$updateOnlineCardRechargeTable$2", f = "OnlineCardRechargeRepository.kt", l = {59, 60}, m = "invokeSuspend")
/* compiled from: OnlineCardRechargeRepository.kt */
public final class OnlineCardRechargeRepository$updateOnlineCardRechargeTable$2 extends b76 implements w76<mb6, k66<? super s56>, Object> {
    public final /* synthetic */ JSONArray $lCardsArray;
    public Object L$0;
    public int label;
    public final /* synthetic */ OnlineCardRechargeRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OnlineCardRechargeRepository$updateOnlineCardRechargeTable$2(JSONArray jSONArray, OnlineCardRechargeRepository onlineCardRechargeRepository, k66<? super OnlineCardRechargeRepository$updateOnlineCardRechargeTable$2> k66) {
        super(2, k66);
        this.$lCardsArray = jSONArray;
        this.this$0 = onlineCardRechargeRepository;
    }

    @Override // defpackage.u66
    public final k66<s56> create(Object obj, k66<?> k66) {
        return new OnlineCardRechargeRepository$updateOnlineCardRechargeTable$2(this.$lCardsArray, this.this$0, k66);
    }

    public final Object invoke(mb6 mb6, k66<? super s56> k66) {
        return ((OnlineCardRechargeRepository$updateOnlineCardRechargeTable$2) create(mb6, k66)).invokeSuspend(s56.f3190a);
    }

    @Override // defpackage.u66
    public final Object invokeSuspend(Object obj) {
        List<OnlineCardRecharge> list;
        p66 p66 = p66.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i == 0) {
            hd3.Y2(obj);
            list = CardRechargeJsonParser.INSTANCE.parseCardsArray(this.$lCardsArray);
            OnlineCardRechargeDao onlineCardRechargeDao = this.this$0.getOnlineCardRechargeDao();
            String str = this.this$0.getCity();
            this.L$0 = list;
            this.label = 1;
            if (onlineCardRechargeDao.deleteAllOnlineCardRechargesForCity(str, this) == p66) {
                return p66;
            }
        } else if (i == 1) {
            list = (List) this.L$0;
            hd3.Y2(obj);
        } else if (i == 2) {
            hd3.Y2(obj);
            return s56.f3190a;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        OnlineCardRechargeDao onlineCardRechargeDao2 = this.this$0.getOnlineCardRechargeDao();
        this.L$0 = null;
        this.label = 2;
        if (onlineCardRechargeDao2.insertOnlineCardRechargeList(list, this) == p66) {
            return p66;
        }
        return s56.f3190a;
    }
}
