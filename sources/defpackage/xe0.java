package defpackage;

import android.os.Handler;
import android.os.Message;
import app.zophop.ui.activities.NearbyStopsActivity;

/* renamed from: xe0  reason: default package */
/* compiled from: NearbyStopsActivity */
public class xe0 implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NearbyStopsActivity f3919a;

    public xe0(NearbyStopsActivity nearbyStopsActivity) {
        this.f3919a = nearbyStopsActivity;
    }

    public boolean handleMessage(Message message) {
        if (message.what != 2) {
            return false;
        }
        NearbyStopsActivity nearbyStopsActivity = this.f3919a;
        Float f = NearbyStopsActivity.Y;
        nearbyStopsActivity.s0();
        NearbyStopsActivity nearbyStopsActivity2 = this.f3919a;
        nearbyStopsActivity2.o0(nearbyStopsActivity2.l0(), vn.G(this.f3919a.l));
        return true;
    }
}
