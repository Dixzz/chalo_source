package app.zophop.ui.activities;

import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import app.zophop.R;
import butterknife.ButterKnife;

public class ZophopSosActivity$$ViewInjector {
    public static void inject(ButterKnife.Finder finder, ZophopSosActivity zophopSosActivity, Object obj) {
        zophopSosActivity._toolbar = (Toolbar) finder.findRequiredView(obj, R.id.toolbar, "field '_toolbar'");
        zophopSosActivity._editMessageButton = (TextView) finder.findRequiredView(obj, R.id.edit_message, "field '_editMessageButton'");
        zophopSosActivity._contactsLayout = (LinearLayout) finder.findRequiredView(obj, R.id.contacts_list, "field '_contactsLayout'");
        zophopSosActivity._addContactButton = finder.findRequiredView(obj, R.id.add_contacts, "field '_addContactButton'");
        zophopSosActivity._sosMessageView = (TextView) finder.findRequiredView(obj, R.id.sos_message, "field '_sosMessageView'");
        zophopSosActivity._sendAlertsView = (TextView) finder.findRequiredView(obj, R.id.send_alerts, "field '_sendAlertsView'");
    }

    public static void reset(ZophopSosActivity zophopSosActivity) {
        zophopSosActivity._toolbar = null;
        zophopSosActivity._editMessageButton = null;
        zophopSosActivity._contactsLayout = null;
        zophopSosActivity._addContactButton = null;
        zophopSosActivity._sosMessageView = null;
        zophopSosActivity._sendAlertsView = null;
    }
}
