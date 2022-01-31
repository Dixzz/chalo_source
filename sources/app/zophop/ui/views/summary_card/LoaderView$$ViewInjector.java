package app.zophop.ui.views.summary_card;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import app.zophop.R;
import butterknife.ButterKnife;

public class LoaderView$$ViewInjector {
    public static void inject(ButterKnife.Finder finder, LoaderView loaderView, Object obj) {
        loaderView._loadingSpinner = finder.findRequiredView(obj, R.id.loading_spinner, "field '_loadingSpinner'");
        TextView textView = (TextView) finder.findRequiredView(obj, R.id.empty_view_text, "field '_failureText'");
        loaderView._alertIcon = (ImageView) finder.findRequiredView(obj, R.id.alert_icon, "field '_alertIcon'");
        loaderView._retry = finder.findRequiredView(obj, R.id.retry, "field '_retry'");
        loaderView._connection_error_layout = (LinearLayout) finder.findRequiredView(obj, R.id.connection_error_layout, "field '_connection_error_layout'");
    }

    public static void reset(LoaderView loaderView) {
        loaderView._loadingSpinner = null;
        loaderView._alertIcon = null;
        loaderView._retry = null;
        loaderView._connection_error_layout = null;
    }
}
