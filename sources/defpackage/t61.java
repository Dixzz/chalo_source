package defpackage;

import android.view.View;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

/* renamed from: t61  reason: default package */
/* compiled from: SlidingPanelWrapper */
public abstract class t61 implements SlidingUpPanelLayout.PanelSlideListener {
    @Override // com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelSlideListener
    public void b(View view, SlidingUpPanelLayout.PanelState panelState, SlidingUpPanelLayout.PanelState panelState2) {
        if (panelState2.equals(SlidingUpPanelLayout.PanelState.COLLAPSED)) {
            d(view);
        } else if (panelState2.equals(SlidingUpPanelLayout.PanelState.EXPANDED)) {
            e(view);
        } else if (panelState2.equals(SlidingUpPanelLayout.PanelState.ANCHORED)) {
            c(view);
        }
    }

    public abstract void c(View view);

    public abstract void d(View view);

    public abstract void e(View view);
}
