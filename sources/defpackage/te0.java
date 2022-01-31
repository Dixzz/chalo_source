package defpackage;

import android.view.View;
import app.zophop.ui.activities.NearbyStopsActivity;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

/* renamed from: te0  reason: default package */
/* compiled from: NearbyStopsActivity */
public class te0 implements SlidingUpPanelLayout.PanelSlideListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NearbyStopsActivity f3338a;

    public te0(NearbyStopsActivity nearbyStopsActivity) {
        this.f3338a = nearbyStopsActivity;
    }

    @Override // com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelSlideListener
    public void a(View view, float f) {
    }

    @Override // com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelSlideListener
    public void b(View view, SlidingUpPanelLayout.PanelState panelState, SlidingUpPanelLayout.PanelState panelState2) {
        if (panelState2 == null) {
            return;
        }
        if (panelState2.equals(SlidingUpPanelLayout.PanelState.COLLAPSED)) {
            this.f3338a.X = false;
        } else if (panelState2.equals(SlidingUpPanelLayout.PanelState.EXPANDED)) {
            this.f3338a.X = true;
        }
    }
}
