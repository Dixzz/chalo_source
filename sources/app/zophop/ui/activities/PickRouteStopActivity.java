package app.zophop.ui.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.models.TransitMode;
import app.zophop.pubsub.eventbus.events.RouteDetailsEvent;
import defpackage.k90;
import defpackage.xt;
import java.util.List;

public class PickRouteStopActivity extends PickStopActivity {
    public static final /* synthetic */ int y = 0;

    @Override // defpackage.vf1, app.zophop.ui.activities.PickStopActivity, defpackage.tf1
    public void e(Bundle bundle) {
        super.e(bundle);
        s0();
    }

    @Override // defpackage.vf1, app.zophop.ui.activities.PickStopActivity
    public ListAdapter h0() {
        return new gk0(this, this.t, this.s, new de0(this));
    }

    @Override // defpackage.vf1, app.zophop.ui.activities.PickStopActivity
    public ListAdapter i0() {
        gk0 gk0 = new gk0(this, this.t, this.s, new de0(this));
        gk0.g = (List<T>) this.s;
        return gk0;
    }

    @Override // app.zophop.ui.activities.PickStopActivity
    public void onEventMainThread(RouteDetailsEvent routeDetailsEvent) {
        String str = this.w;
        if (str != null && str.equals(routeDetailsEvent.getRouteId())) {
            if (routeDetailsEvent.getResponseType().equals(ad1.SUCCESS)) {
                this.s = routeDetailsEvent.getRoute().getStopSequence();
                this.o.setVisibility(8);
                ((mk0) this.k.getAdapter()).g = (List<T>) this.s;
                if (k0() != null && k0().length() != 0) {
                    o0(k0());
                    return;
                }
                return;
            }
            this.s = null;
            q0(k90.a.QUERY_FAILED);
        }
    }

    @Override // app.zophop.ui.activities.PickStopActivity, defpackage.ee0
    public void q0(k90.a aVar) {
        if (!vn.K0(this)) {
            super.q0(k90.a.NETWORK_ERROR);
        } else if (this.u.equals(k90.a.QUERY_FAILED)) {
            this.u = aVar;
            t0(aVar);
        } else if (this.u.equals(k90.a.FETCHING)) {
            this.u = aVar;
            t0(aVar);
        } else {
            super.q0(aVar);
        }
    }

    @Override // app.zophop.ui.activities.PickStopActivity
    public boolean r0() {
        return this.s != null;
    }

    public final void s0() {
        this.k.getEmptyView().setVisibility(8);
        if (vn.K0(this)) {
            q0(k90.a.FETCHING);
            xt.t1 t1Var = xt.f3961a;
            t1Var.U().c(this.w, TransitMode.bus, t1Var.k().d().getName());
            return;
        }
        q0(k90.a.NETWORK_ERROR);
    }

    public void t0(k90.a aVar) {
        View emptyView = this.k.getEmptyView();
        int ordinal = aVar.ordinal();
        if (ordinal == 0) {
            this.o.setVisibility(8);
            emptyView.setVisibility(0);
            emptyView.findViewById(R.id.retry).setVisibility(0);
            emptyView.findViewById(R.id.retry).setOnClickListener(new df0(this));
        } else if (ordinal == 3) {
            this.o.setVisibility(0);
            this.o.setBackgroundResource(R.color.action_bar_color);
            this.o.setEnabled(false);
            ((TextView) this.o.findViewById(R.id.settings_not_available_description)).setText("Fetching stop details..");
        }
    }
}
