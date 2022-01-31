package defpackage;

import android.view.View;
import app.zophop.ui.activities.TripDetailsActivity;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

/* renamed from: cg0  reason: default package */
/* compiled from: TripDetailsActivity */
public class cg0 implements View.OnClickListener {
    public final /* synthetic */ TripDetailsActivity f;

    public cg0(TripDetailsActivity tripDetailsActivity) {
        this.f = tripDetailsActivity;
    }

    public void onClick(View view) {
        SlidingUpPanelLayout.PanelState panelState = this.f._panelLayout.getPanelState();
        SlidingUpPanelLayout.PanelState panelState2 = SlidingUpPanelLayout.PanelState.EXPANDED;
        if (panelState.equals(panelState2)) {
            this.f._panelLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
        } else {
            this.f._panelLayout.setPanelState(panelState2);
        }
    }
}
