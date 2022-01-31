package app.zophop.ui.activities;

import android.widget.ImageView;
import android.widget.ListView;
import androidx.cardview.widget.CardView;
import app.zophop.R;
import butterknife.ButterKnife;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

public class TripDetailsActivity$$ViewInjector {
    public static void inject(ButterKnife.Finder finder, TripDetailsActivity tripDetailsActivity, Object obj) {
        tripDetailsActivity._listView = (ListView) finder.findRequiredView(obj, R.id.trip_details_list, "field '_listView'");
        finder.findRequiredView(obj, R.id.trip_details_text_layer, "field '_textLayer'");
        tripDetailsActivity._panelLayout = (SlidingUpPanelLayout) finder.findRequiredView(obj, R.id.sliding_layout, "field '_panelLayout'");
        finder.findRequiredView(obj, R.id.route_screen_back, "field '_backButton'");
        tripDetailsActivity._backButtonV19 = (ImageView) finder.findRequiredView(obj, R.id.route_screen_back_v19, "field '_backButtonV19'");
        tripDetailsActivity._backButtonCard = (CardView) finder.findRequiredView(obj, R.id.back_button_card, "field '_backButtonCard'");
        tripDetailsActivity._routeHeaderBack = finder.findRequiredView(obj, R.id.route_header_back, "field '_routeHeaderBack'");
    }

    public static void reset(TripDetailsActivity tripDetailsActivity) {
        tripDetailsActivity._listView = null;
        tripDetailsActivity._panelLayout = null;
        tripDetailsActivity._backButtonV19 = null;
        tripDetailsActivity._backButtonCard = null;
        tripDetailsActivity._routeHeaderBack = null;
    }
}
