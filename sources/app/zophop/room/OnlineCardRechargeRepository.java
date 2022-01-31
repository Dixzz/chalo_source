package app.zophop.room;

import android.content.Context;
import app.zophop.ZophopApplication;
import app.zophop.models.City;
import app.zophop.models.mTicketing.cardRecharge.OnlineCardRecharge;
import com.razorpay.AnalyticsConstants;
import java.util.List;
import org.json.JSONArray;

/* compiled from: OnlineCardRechargeRepository.kt */
public final class OnlineCardRechargeRepository {
    private final j56 applicationContext$delegate = hd3.a2(new OnlineCardRechargeRepository$applicationContext$2(this));
    private final Context context;
    private final j56 onlineCardRechargeDao$delegate = hd3.a2(new OnlineCardRechargeRepository$onlineCardRechargeDao$2(this));

    public OnlineCardRechargeRepository(Context context2) {
        n86.e(context2, AnalyticsConstants.CONTEXT);
        this.context = context2;
    }

    private final ZophopApplication getApplicationContext() {
        return (ZophopApplication) this.applicationContext$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final String getCity() {
        City d = xt.f3961a.k().d();
        n86.c(d);
        String name = d.getName();
        n86.d(name, "DependencyFactory.cityProvider.currentCity!!.name");
        String lowerCase = name.toLowerCase();
        n86.d(lowerCase, "(this as java.lang.String).toLowerCase()");
        return lowerCase;
    }

    /* access modifiers changed from: private */
    public final OnlineCardRechargeDao getOnlineCardRechargeDao() {
        return (OnlineCardRechargeDao) this.onlineCardRechargeDao$delegate.getValue();
    }

    public final void deleteAllOnlineCardRechargeData() {
        hd3.Y1(getApplicationContext(), null, null, new OnlineCardRechargeRepository$deleteAllOnlineCardRechargeData$1(this, null), 3, null);
    }

    public final qe6<List<OnlineCardRecharge>> getAllOnlineCardRechargesForCity() {
        return new ue6(getOnlineCardRechargeDao().getAllOnlineCardRechargesForCity(getCity()));
    }

    public final Context getContext() {
        return this.context;
    }

    public final qe6<OnlineCardRecharge> getOnlineCardRecharge(String str) {
        n86.e(str, "lTransactionId");
        return new ue6(getOnlineCardRechargeDao().getOnlineCardRecharge(str));
    }

    public final qe6<List<OnlineCardRecharge>> getRecentOnlineCardRecharges() {
        return new ue6(getOnlineCardRechargeDao().getLatestOnlineCardRechargesForCity(getCity()));
    }

    public final void insertOnlineCardRecharge(OnlineCardRecharge onlineCardRecharge) {
        n86.e(onlineCardRecharge, "lOnlineCardRecharge");
        hd3.Y1(getApplicationContext(), null, null, new OnlineCardRechargeRepository$insertOnlineCardRecharge$1(this, onlineCardRecharge, null), 3, null);
    }

    public final void updateOnlineCardRechargeTable(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            hd3.Y1(getApplicationContext(), null, null, new OnlineCardRechargeRepository$updateOnlineCardRechargeTable$1(this, null), 3, null);
        } else {
            hd3.Y1(getApplicationContext(), null, null, new OnlineCardRechargeRepository$updateOnlineCardRechargeTable$2(jSONArray, this, null), 3, null);
        }
    }
}
