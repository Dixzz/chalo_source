package app.zophop.room;

import app.zophop.models.mTicketing.cardRecharge.OnlineCardRecharge;
import java.util.List;

/* compiled from: OnlineCardRechargeDao.kt */
public interface OnlineCardRechargeDao {
    Object deleteAllOnlineCardRechargeHistory(k66<? super s56> k66);

    Object deleteAllOnlineCardRechargesForCity(String str, k66<? super s56> k66);

    qe6<List<OnlineCardRecharge>> getAllOnlineCardRechargesForCity(String str);

    qe6<List<OnlineCardRecharge>> getLatestOnlineCardRechargesForCity(String str);

    qe6<OnlineCardRecharge> getOnlineCardRecharge(String str);

    Object insertOnlineCardRecharge(OnlineCardRecharge onlineCardRecharge, k66<? super s56> k66);

    Object insertOnlineCardRechargeList(List<OnlineCardRecharge> list, k66<? super s56> k66);
}
