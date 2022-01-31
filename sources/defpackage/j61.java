package defpackage;

import android.app.Fragment;
import android.app.FragmentManager;
import android.view.View;
import android.view.ViewGroup;
import app.zophop.R;
import app.zophop.ui.utils.FrequencyRouteHelper;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;
import java.util.Objects;

/* renamed from: j61  reason: default package */
/* compiled from: FrequencyRouteHelper */
public class j61 extends t61 {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1882a = true;
    public float b = -1.0f;
    public final /* synthetic */ int c;
    public final /* synthetic */ FrequencyRouteHelper d;

    public j61(FrequencyRouteHelper frequencyRouteHelper, int i) {
        this.d = frequencyRouteHelper;
        this.c = i;
    }

    @Override // com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelSlideListener
    public void a(View view, float f) {
        this.b = f;
        FragmentManager fragmentManager = this.d.h.getFragmentManager();
        fragmentManager.beginTransaction();
        Fragment findFragmentByTag = fragmentManager.findFragmentByTag("bus route fragment");
        if (findFragmentByTag instanceof FrequencyRouteHelper.c) {
            Objects.requireNonNull((mt0) findFragmentByTag);
        }
        f(false);
        FrequencyRouteHelper frequencyRouteHelper = this.d;
        int i = this.c;
        float f2 = FrequencyRouteHelper.B;
        float f3 = ((f - f2) / (1.0f - f2)) * 100.0f;
        if (f < f2) {
            f3 = 0.0f;
        }
        int i2 = (int) ((f3 * ((float) i)) / 100.0f);
        ViewGroup.LayoutParams layoutParams = frequencyRouteHelper._headerBackView.getLayoutParams();
        layoutParams.width = Math.max(i2, frequencyRouteHelper.h.getResources().getDimensionPixelSize(R.dimen.route_back_arrow_initial_size));
        layoutParams.height = i2;
        frequencyRouteHelper._headerBackView.setLayoutParams(layoutParams);
        frequencyRouteHelper._headerBackView.invalidate();
        frequencyRouteHelper._headerBackView.requestLayout();
        if (Float.compare(FrequencyRouteHelper.B, 1.0f) != 0) {
            float f4 = FrequencyRouteHelper.B;
            float f5 = (f - f4) / (1.0f - f4);
            if (f5 > 0.8f) {
                frequencyRouteHelper._backButtonCard.setCardElevation(((1.0f - f5) / 0.2f) * ((float) frequencyRouteHelper.h.getResources().getDimensionPixelOffset(R.dimen.back_button_elevation)));
            } else {
                frequencyRouteHelper._backButtonCard.setCardElevation((float) frequencyRouteHelper.h.getResources().getDimensionPixelOffset(R.dimen.back_button_elevation));
            }
            frequencyRouteHelper._backButtonCard.invalidate();
            frequencyRouteHelper._backButtonCard.requestLayout();
        }
        this.d.a(false);
    }

    @Override // com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelSlideListener, defpackage.t61
    public void b(View view, SlidingUpPanelLayout.PanelState panelState, SlidingUpPanelLayout.PanelState panelState2) {
        if (!panelState2.equals(SlidingUpPanelLayout.PanelState.COLLAPSED)) {
            if (panelState2.equals(SlidingUpPanelLayout.PanelState.EXPANDED)) {
                f(false);
            } else if (panelState2.equals(SlidingUpPanelLayout.PanelState.ANCHORED)) {
                c(view);
            }
        }
    }

    @Override // defpackage.t61
    public void c(View view) {
        this.d.a(true);
        if (Float.compare(this.b, FrequencyRouteHelper.B) <= 0) {
            f(true);
        }
        this.d._routeInfoContainer.getMeasuredHeight();
    }

    @Override // defpackage.t61
    public void d(View view) {
    }

    @Override // defpackage.t61
    public void e(View view) {
        f(false);
    }

    public final void f(boolean z) {
        if (this.f1882a != z) {
            this.d.b(z);
            this.f1882a = z;
        }
    }
}
