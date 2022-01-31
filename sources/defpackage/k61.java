package defpackage;

import android.view.ViewTreeObserver;
import app.zophop.R;
import app.zophop.ui.utils.FrequencyRouteHelper;

/* renamed from: k61  reason: default package */
/* compiled from: FrequencyRouteHelper */
public class k61 implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ FrequencyRouteHelper f;

    /* renamed from: k61$a */
    /* compiled from: FrequencyRouteHelper */
    public class a implements Runnable {
        public a() {
        }

        public void run() {
            k61.this.f.b(true);
            FrequencyRouteHelper frequencyRouteHelper = k61.this.f;
            int dimensionPixelOffset = frequencyRouteHelper.h.getResources().getDimensionPixelOffset(R.dimen.route_subscribe_button_height);
            if (frequencyRouteHelper._towardsContainer.getMeasuredHeight() != 0) {
                dimensionPixelOffset = frequencyRouteHelper._towardsContainer.getMeasuredHeight();
            }
            frequencyRouteHelper._panelLayout.setPanelHeight(dimensionPixelOffset);
            FrequencyRouteHelper frequencyRouteHelper2 = k61.this.f;
            if (frequencyRouteHelper2.g == null) {
                frequencyRouteHelper2._panelLayout.setScrollableView(frequencyRouteHelper2._routeViewPager.findViewById(R.id.route_list));
            } else {
                frequencyRouteHelper2._panelLayout.setScrollableView(frequencyRouteHelper2._routeViewPager.findViewById(R.id.trip_legs_list));
            }
        }
    }

    public k61(FrequencyRouteHelper frequencyRouteHelper) {
        this.f = frequencyRouteHelper;
    }

    public void onGlobalLayout() {
        this.f._panelLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.f._panelLayout.postDelayed(new a(), 500);
    }
}
