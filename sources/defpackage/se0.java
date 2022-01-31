package defpackage;

import app.zophop.ui.activities.NearbyStopsActivity;
import com.google.firebase.database.DataSnapshot;
import java.util.HashMap;

/* renamed from: se0  reason: default package */
/* compiled from: NearbyStopsActivity */
public class se0 implements Runnable {
    public final /* synthetic */ NearbyStopsActivity f;

    public se0(NearbyStopsActivity nearbyStopsActivity) {
        this.f = nearbyStopsActivity;
    }

    public void run() {
        DataSnapshot dataSnapshot = this.f.Q;
        if (dataSnapshot != null) {
            Iterable<DataSnapshot> children = dataSnapshot.getChildren();
            HashMap hashMap = new HashMap();
            for (DataSnapshot dataSnapshot2 : children) {
                j10 e = ii1.e(dataSnapshot2);
                if (e.a() < 7200) {
                    hashMap.put(dataSnapshot2.getKey(), e.c().get(0));
                } else if (e.b().size() != 0) {
                    hashMap.put(dataSnapshot2.getKey(), e.b().get(0));
                }
            }
            jz5.b().g(hashMap);
        }
        NearbyStopsActivity nearbyStopsActivity = this.f;
        nearbyStopsActivity.A.postDelayed(nearbyStopsActivity.P, 1000);
    }
}
