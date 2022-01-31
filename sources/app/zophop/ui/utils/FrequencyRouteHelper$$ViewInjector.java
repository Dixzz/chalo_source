package app.zophop.ui.utils;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import app.zophop.R;
import butterknife.ButterKnife;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

public class FrequencyRouteHelper$$ViewInjector {
    public static void inject(ButterKnife.Finder finder, FrequencyRouteHelper frequencyRouteHelper, Object obj) {
        frequencyRouteHelper._panelLayout = (SlidingUpPanelLayout) finder.findRequiredView(obj, R.id.sliding_layout, "field '_panelLayout'");
        frequencyRouteHelper._routeInfoContainer = (RelativeLayout) finder.findRequiredView(obj, R.id.route_lists_container, "field '_routeInfoContainer'");
        frequencyRouteHelper._towardsContainer = finder.findRequiredView(obj, R.id.towards_container, "field '_towardsContainer'");
        frequencyRouteHelper._routeViewPager = finder.findRequiredView(obj, R.id.bus_route_viewpager, "field '_routeViewPager'");
        ImageView imageView = (ImageView) finder.findRequiredView(obj, R.id.route_screen_back, "field '_backButton'");
        frequencyRouteHelper._backButtonV19 = (ImageView) finder.findRequiredView(obj, R.id.route_screen_back_v19, "field '_backButtonV19'");
        frequencyRouteHelper._backButtonCard = (CardView) finder.findRequiredView(obj, R.id.back_button_card, "field '_backButtonCard'");
        frequencyRouteHelper._optionsMenu = finder.findRequiredView(obj, R.id.route_screen_options_container, "field '_optionsMenu'");
        frequencyRouteHelper._headerBackView = finder.findRequiredView(obj, R.id.route_header_back, "field '_headerBackView'");
        frequencyRouteHelper._route_info = (TextView) finder.findRequiredView(obj, R.id.txtRouteInfo, "field '_route_info'");
        frequencyRouteHelper._productDiscountCard = (CardView) finder.findRequiredView(obj, R.id.product_discount_card, "field '_productDiscountCard'");
    }

    public static void reset(FrequencyRouteHelper frequencyRouteHelper) {
        frequencyRouteHelper._panelLayout = null;
        frequencyRouteHelper._routeInfoContainer = null;
        frequencyRouteHelper._towardsContainer = null;
        frequencyRouteHelper._routeViewPager = null;
        frequencyRouteHelper._backButtonV19 = null;
        frequencyRouteHelper._backButtonCard = null;
        frequencyRouteHelper._optionsMenu = null;
        frequencyRouteHelper._headerBackView = null;
        frequencyRouteHelper._route_info = null;
        frequencyRouteHelper._productDiscountCard = null;
    }
}
