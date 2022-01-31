package app.zophop.ui.activities;

import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import app.zophop.R;
import butterknife.ButterKnife;

public class SubscriptionActivity$$ViewInjector {
    public static void inject(ButterKnife.Finder finder, SubscriptionActivity subscriptionActivity, Object obj) {
        subscriptionActivity._confirmButton = (TextView) finder.findRequiredView(obj, R.id.done, "field '_confirmButton'");
        subscriptionActivity._toolbar = (Toolbar) finder.findRequiredView(obj, R.id.tool_bar, "field '_toolbar'");
        subscriptionActivity._removeButton = (TextView) finder.findRequiredView(obj, R.id.remove, "field '_removeButton'");
        subscriptionActivity._stopView = finder.findRequiredView(obj, R.id.stop_view, "field '_stopView'");
        subscriptionActivity._timeView = finder.findRequiredView(obj, R.id.time_view, "field '_timeView'");
    }

    public static void reset(SubscriptionActivity subscriptionActivity) {
        subscriptionActivity._confirmButton = null;
        subscriptionActivity._toolbar = null;
        subscriptionActivity._removeButton = null;
        subscriptionActivity._stopView = null;
        subscriptionActivity._timeView = null;
    }
}
