package app.zophop.ui.activities;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import app.zophop.R;
import butterknife.ButterKnife;

public class ForceUpdateActivity$$ViewInjector {
    public static void inject(ButterKnife.Finder finder, ForceUpdateActivity forceUpdateActivity, Object obj) {
        forceUpdateActivity._icon = (ImageView) finder.findRequiredView(obj, R.id.status_icon, "field '_icon'");
        forceUpdateActivity._statusCopy = (TextView) finder.findRequiredView(obj, R.id.status_copy, "field '_statusCopy'");
        forceUpdateActivity._statusDetail = (TextView) finder.findRequiredView(obj, R.id.status_detail, "field '_statusDetail'");
        forceUpdateActivity._actionButton = (Button) finder.findRequiredView(obj, R.id.validation_success_ok_button, "field '_actionButton'");
        forceUpdateActivity._remindLater = (TextView) finder.findRequiredView(obj, R.id.remind_later, "field '_remindLater'");
    }

    public static void reset(ForceUpdateActivity forceUpdateActivity) {
        forceUpdateActivity._icon = null;
        forceUpdateActivity._statusCopy = null;
        forceUpdateActivity._statusDetail = null;
        forceUpdateActivity._actionButton = null;
        forceUpdateActivity._remindLater = null;
    }
}
