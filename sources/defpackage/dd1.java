package defpackage;

import com.crashlytics.android.answers.InviteEvent;
import java.util.HashMap;
import java.util.Map;

/* renamed from: dd1  reason: default package */
/* compiled from: AnalyticsEventCosts */
public class dd1 {

    /* renamed from: a  reason: collision with root package name */
    public Map<String, Integer> f822a;

    public dd1() {
        HashMap hashMap = new HashMap();
        this.f822a = hashMap;
        hashMap.put("app open", 1);
        this.f822a.put("schedule requested", 2);
        this.f822a.put("nearby stops card clicked", 2);
        this.f822a.put("nearby stops marker click", 2);
        this.f822a.put("nearby live trips clicked", 2);
        this.f822a.put("home screen cab cab result clicked", 2);
        this.f822a.put("cab activity cab result clicked", 2);
        this.f822a.put("cab activity cab result clicked", 2);
        this.f822a.put("trip planner used", 4);
        this.f822a.put("chat screen", 4);
        this.f822a.put("home screen live vehicles click", 4);
        this.f822a.put("stop eta seen", 6);
        this.f822a.put("stop eta seen - multiple routes", 6);
        this.f822a.put(InviteEvent.TYPE, 6);
        this.f822a.put("alert share", 6);
        this.f822a.put("checkin shared", 6);
        this.f822a.put("live cab ride share", 6);
        this.f822a.put("share option clicked in trip details", 6);
        this.f822a.put("checked in route share", 6);
        this.f822a.put("checkin done clicked", 9);
        this.f822a.put("route subscribed", 9);
        this.f822a.put("cab booked", 10);
        this.f822a.put("pass booked", 10);
    }
}
