package defpackage;

import app.zophop.ui.activities.NearbyStopsActivity;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

/* renamed from: we0  reason: default package */
/* compiled from: NearbyStopsActivity */
public class we0 implements Runnable {
    public final /* synthetic */ NearbyStopsActivity f;

    public we0(NearbyStopsActivity nearbyStopsActivity) {
        this.f = nearbyStopsActivity;
    }

    public void run() {
        this.f.s.invalidate();
        this.f.q.invalidate();
        this.f.r.invalidate();
        this.f.q.setVisibility(0);
        this.f.q.setBackgroundColor(0);
        NearbyStopsActivity nearbyStopsActivity = this.f;
        nearbyStopsActivity.X = true;
        nearbyStopsActivity.s.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);
    }
}
