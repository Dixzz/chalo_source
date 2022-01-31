package app.zophop.ui.activities;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import app.zophop.R;
import app.zophop.ui.views.collapse_on_scroll.CollapseOnScrollViewPager;
import app.zophop.utilities.ui.views.sliding_tabs.HorizontalTabScrollWithViewPager;
import butterknife.ButterKnife;
import butterknife.internal.DebouncingOnClickListener;

public class TripPlanningActivity$$ViewInjector {

    /* compiled from: TripPlanningActivity$$ViewInjector */
    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ TripPlanningActivity f;

        public a(TripPlanningActivity tripPlanningActivity) {
            this.f = tripPlanningActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            TripPlanningActivity tripPlanningActivity = this.f;
            if (!tripPlanningActivity.isFinishing()) {
                new sm0().show(tripPlanningActivity.getFragmentManager(), "");
            }
        }
    }

    public static void inject(ButterKnife.Finder finder, TripPlanningActivity tripPlanningActivity, Object obj) {
        tripPlanningActivity._pages = (ViewPager) finder.findRequiredView(obj, R.id.pages, "field '_pages'");
        tripPlanningActivity._inputForm = finder.findRequiredView(obj, R.id.header, "field '_inputForm'");
        tripPlanningActivity._tabs = (HorizontalTabScrollWithViewPager) finder.findRequiredView(obj, R.id.tabs, "field '_tabs'");
        View findRequiredView = finder.findRequiredView(obj, R.id.preference_hook, "field '_preferenceHook' and method 'clickPreferenceHook'");
        tripPlanningActivity._preferenceHook = findRequiredView;
        findRequiredView.setOnClickListener(new a(tripPlanningActivity));
        tripPlanningActivity._mapContainer = finder.findRequiredView(obj, R.id.map_container, "field '_mapContainer'");
        tripPlanningActivity._collaspeScrollView = (CollapseOnScrollViewPager) finder.findRequiredView(obj, R.id.collpase_view, "field '_collaspeScrollView'");
        tripPlanningActivity._tabsLineAbove = finder.findRequiredView(obj, R.id.tabs_line_above, "field '_tabsLineAbove'");
    }

    public static void reset(TripPlanningActivity tripPlanningActivity) {
        tripPlanningActivity._pages = null;
        tripPlanningActivity._inputForm = null;
        tripPlanningActivity._tabs = null;
        tripPlanningActivity._preferenceHook = null;
        tripPlanningActivity._mapContainer = null;
        tripPlanningActivity._collaspeScrollView = null;
        tripPlanningActivity._tabsLineAbove = null;
    }
}
