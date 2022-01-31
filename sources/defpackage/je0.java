package defpackage;

import android.view.View;
import app.zophop.R;
import app.zophop.ui.activities.MTicketSelectionActivity;

/* renamed from: je0  reason: default package */
/* compiled from: MTicketSelectionActivity */
public class je0 implements View.OnClickListener {
    public final /* synthetic */ MTicketSelectionActivity f;

    public je0(MTicketSelectionActivity mTicketSelectionActivity) {
        this.f = mTicketSelectionActivity;
    }

    public void onClick(View view) {
        if (this.f._routeStopDetailsLayout.getVisibility() == 0) {
            this.f._routeStopDetailsLayout.setVisibility(8);
            this.f._collapseRouteDetailsButton.setImageResource(R.drawable.stops_show);
            return;
        }
        this.f._routeStopDetailsLayout.setVisibility(0);
        this.f._collapseRouteDetailsButton.setImageResource(R.drawable.stops_less);
    }
}
