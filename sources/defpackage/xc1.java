package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.ui.views.summary_card.RouteListCardItem;

/* renamed from: xc1  reason: default package */
/* compiled from: RouteInfoWindowCardItem */
public class xc1 extends RouteListCardItem {
    public xc1(Context context) {
        super(context);
    }

    @Override // app.zophop.ui.views.summary_card.CardItem, app.zophop.ui.views.summary_card.RouteListCardItem
    public void a(Context context) {
        LayoutInflater.from(getContext()).inflate(R.layout.route_infowindow_card_item, (ViewGroup) this, true);
        setBackgroundResource(R.drawable.drawer_item_selector);
    }

    public TextView getLastUpdatedView() {
        return (TextView) findViewById(R.id.live_updated_status);
    }
}
