package app.zophop.ui.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import app.zophop.R;
import app.zophop.models.Route;
import app.zophop.models.RouteInfo;
import app.zophop.models.TransitMode;
import app.zophop.pubsub.eventbus.events.DatabaseSyncEvent;
import app.zophop.pubsub.eventbus.events.FerryTripEvent;
import app.zophop.pubsub.eventbus.events.MetroTripEvent;
import app.zophop.utilities.external.loader_view.LoadingSpinnerView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class SchedulerInputTripDetailsFragment extends Fragment {
    @InjectView(R.id.scheduler_cards)
    public RelativeLayout _infoLayout;
    @InjectView(R.id.loading_spinner)
    public LoadingSpinnerView _loaderView;
    @InjectView(R.id.trip_list)
    public ListView _tripList;
    public ArrayList<Route> f;
    public TransitMode g;
    public jk0 h;

    public static void b(TransitMode transitMode) {
        List<RouteInfo> list = xt.f3961a.A().g;
        ArrayList arrayList = new ArrayList();
        for (RouteInfo routeInfo : list) {
            if (routeInfo.getTransitMode() == transitMode) {
                arrayList.add(routeInfo);
            }
        }
        v40 U = xt.f3961a.U();
        Objects.requireNonNull(U);
        ArrayList arrayList2 = new ArrayList();
        HandlerThread handlerThread = new HandlerThread("route fetcher" + transitMode);
        handlerThread.start();
        new Handler(handlerThread.getLooper()).post(new q40(U, transitMode, arrayList, arrayList2));
    }

    public final ArrayList<Route> a() {
        ArrayList<Route> arrayList = new ArrayList<>();
        Iterator<Route> it = this.f.iterator();
        while (it.hasNext()) {
            Route next = it.next();
            if (next.getMode() == this.g) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.scheduler_input_trip_details, (ViewGroup) null);
        ButterKnife.inject(this, inflate);
        jz5 b = jz5.b();
        b.k(this, b.e, false, 0);
        this.g = TransitMode.getTransitMode(getArguments().getString("extra_mode"));
        this.f = new ArrayList<>();
        jk0 jk0 = new jk0(this.f, getActivity(), this.g);
        this.h = jk0;
        this._tripList.setAdapter((ListAdapter) jk0);
        if (xt.f3961a.A().j()) {
            this._infoLayout.setVisibility(0);
            this._loaderView.setVisibility(8);
            b(this.g);
        } else {
            this._loaderView.h.start();
        }
        return inflate;
    }

    public void onDestroy() {
        super.onDestroy();
        jz5.b().o(this);
    }

    public void onEventMainThread(MetroTripEvent metroTripEvent) {
        this.f = metroTripEvent.getRouteTripList();
        ArrayList<Route> a2 = a();
        jk0 jk0 = this.h;
        if (jk0 != null && this.g == TransitMode.metro) {
            jk0.f = a2;
            jk0.notifyDataSetChanged();
        }
    }

    public void onStart() {
        super.onStart();
    }

    public void onEventMainThread(FerryTripEvent ferryTripEvent) {
        this.f = ferryTripEvent.getRouteTripList();
        ArrayList<Route> a2 = a();
        jk0 jk0 = this.h;
        if (jk0 != null && this.g == TransitMode.ferry) {
            jk0.f = a2;
            jk0.notifyDataSetChanged();
        }
    }

    public void onEventMainThread(DatabaseSyncEvent databaseSyncEvent) {
        if (databaseSyncEvent.getStatus().equals(DatabaseSyncEvent.STATUS.DONE) && databaseSyncEvent.getCityName().equalsIgnoreCase(xt.f3961a.k().d().getName())) {
            this._infoLayout.setVisibility(0);
            this._loaderView.setVisibility(8);
            b(this.g);
        }
    }
}
