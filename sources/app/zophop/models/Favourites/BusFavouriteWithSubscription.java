package app.zophop.models.Favourites;

import app.zophop.models.Stop;
import java.util.List;

public class BusFavouriteWithSubscription extends BusFavourite {
    private final int _alarmCode;
    private final Stop _subscribedStop;
    private final int _subscribedTime;

    public BusFavouriteWithSubscription(String str, String str2, String str3, String str4, String str5, long j, RouteStoreType routeStoreType, Stop stop, int i, int i2, String str6, List<String> list, boolean z) {
        super(str, str2, str3, str4, str5, j, routeStoreType, str6, list, z);
        this._subscribedStop = stop;
        this._subscribedTime = i;
        this._alarmCode = i2;
    }

    public int getAlarmCode() {
        return this._alarmCode;
    }

    public int getSubscribedHour() {
        return this._subscribedTime / 60;
    }

    public int getSubscribedMinute() {
        return this._subscribedTime % 60;
    }

    public Stop getSubscribedStop() {
        return this._subscribedStop;
    }

    public int getSubscriptionTime() {
        return this._subscribedTime;
    }
}
