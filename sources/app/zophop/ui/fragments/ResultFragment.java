package app.zophop.ui.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.cardview.widget.CardView;
import app.zophop.R;
import app.zophop.models.LocationTripRequest;
import app.zophop.models.Stop;
import app.zophop.models.StopTripRequest;
import app.zophop.models.TripOptions;
import app.zophop.models.TripRequest;
import app.zophop.models.VehicleInfo;
import app.zophop.pubsub.eventbus.events.TripPlannerEvent;
import app.zophop.pubsub.eventbus.events.TripPlannerInputLocationChangedEvent;
import app.zophop.ui.SkeletonLoader;
import app.zophop.ui.views.SummaryView;
import app.zophop.ui.views.summary_card.LoaderView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.google.gson.Gson;
import com.razorpay.AnalyticsConstants;
import defpackage.nn0;
import defpackage.sm0;
import defpackage.wb1;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import zophop.models.Itinerary;
import zophop.models.TripPlannerResponse;

public class ResultFragment extends Fragment {
    public static final /* synthetic */ int q = 0;
    @InjectView(R.id.loader)
    public LoaderView _loader;
    @InjectView(R.id.result_container)
    public View _resultContainer;
    @InjectView(R.id.results)
    public LinearLayout _results;
    public TripPlannerResponse f;
    public l90 g;
    public String h;
    public TripRequest i;
    public boolean j;
    public int k;
    public String l;
    public boolean m;
    public TripOptions n;
    public List<SummaryView.a> o;
    public SkeletonLoader p;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            ResultFragment.this.i(null);
            ResultFragment.this.l();
        }
    }

    public void a(View view, List<Itinerary> list, String str, String str2, boolean z, boolean z2) {
        wb1.r = 0;
        for (Itinerary itinerary : list) {
            SummaryView d = d(itinerary, z, z2);
            SummaryView.a tripSummaryRenderer = d.getTripSummaryRenderer();
            d.setOnClickListener(new aw0(this, str2, str, tripSummaryRenderer, itinerary));
            this.o.add(tripSummaryRenderer);
            CardView cardView = new CardView(getActivity());
            cardView.addView(d);
            LinearLayout linearLayout = (LinearLayout) view;
            linearLayout.addView(cardView);
            linearLayout.addView(c());
        }
    }

    public void b(View view, Itinerary itinerary, String str, String str2, boolean z, boolean z2, Map<String, VehicleInfo> map) {
        SummaryView e = e(itinerary, z, z2, map);
        SummaryView.a tripSummaryRenderer = e.getTripSummaryRenderer();
        e.setOnClickListener(new aw0(this, str2, str, tripSummaryRenderer, itinerary));
        this.o.add(tripSummaryRenderer);
        CardView cardView = new CardView(getActivity());
        cardView.addView(e);
        LinearLayout linearLayout = (LinearLayout) view;
        linearLayout.addView(cardView);
        linearLayout.addView(c());
    }

    public final View c() {
        View view = new View(getActivity());
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) getResources().getDimension(R.dimen.scheduler_results_divider)));
        return view;
    }

    public SummaryView d(Itinerary itinerary, boolean z, boolean z2) {
        SummaryView summaryView = new SummaryView(getActivity());
        wb1 wb1 = new wb1(itinerary, getActivity().getApplicationContext(), wb1.b.TRIPPLANNER);
        wb1.e = z;
        wb1.f = z2;
        summaryView.a(wb1);
        wb1.c = null;
        return summaryView;
    }

    /* JADX WARN: Incorrect args count in method signature: (Lzophop/models/Itinerary;Ljava/lang/String;ZZLjava/util/Map<Ljava/lang/String;Lapp/zophop/models/VehicleInfo;>;)Lapp/zophop/ui/views/SummaryView; */
    public SummaryView e(Itinerary itinerary, boolean z, boolean z2, Map map) {
        SummaryView summaryView = new SummaryView(getActivity());
        wb1 wb1 = new wb1(itinerary, getActivity().getApplicationContext(), wb1.b.TRIPPLANNER);
        wb1.e = z;
        wb1.f = z2;
        wb1.s = map;
        summaryView.a(wb1);
        wb1.c = null;
        return summaryView;
    }

    public void f() {
        this.j = false;
    }

    public void g() {
        this.i = null;
        this.h = null;
        this.j = true;
        this.f = null;
    }

    public TripOptions h() {
        TripOptions tripOptions = new TripOptions(this.g);
        sf1 sf1 = new sf1(getActivity().getSharedPreferences("tripPlannerPreferences", 0), AnalyticsConstants.PREFERENCES);
        tripOptions._maxWalkDistance = vn.W(sf1);
        tripOptions._maxAutoCabDistance = vn.V(sf1);
        tripOptions._nonAc = vn.j0(sf1);
        tripOptions._ac = vn.i0(sf1);
        return tripOptions;
    }

    public void i(TripOptions tripOptions) {
        if (tripOptions == null) {
            this.n = h();
        } else {
            this.n = tripOptions;
        }
        this.h = xt.f3961a.h0().a(this.i, this.n);
        this.j = true;
    }

    public final void j() {
        if (!jz5.b().f(this)) {
            jz5 b = jz5.b();
            b.k(this, b.e, true, 0);
        }
    }

    public void k() {
        List<SummaryView.a> list = this.o;
        if (list != null && list.size() > 0) {
            for (int i2 = 0; i2 < this.o.size(); i2++) {
                this.o.get(i2).b();
            }
        }
    }

    public void l() {
        if (this.j) {
            o();
            return;
        }
        TripPlannerResponse tripPlannerResponse = this.f;
        if (tripPlannerResponse == null) {
            n();
        } else if (tripPlannerResponse.itineraries.size() == 0) {
            m();
        } else {
            q();
        }
    }

    public void m() {
        this._resultContainer.setVisibility(8);
        this._loader.b(R.drawable.alert_scheduler, getString(R.string.no_route_available));
        this._loader.c(true);
        this.p.a(null);
    }

    public void n() {
        this._resultContainer.setVisibility(8);
        this._loader.a();
        this.p.a(null);
        this._loader.c(false);
        this.n = null;
    }

    public void o() {
        this._resultContainer.setVisibility(8);
        this.p.d(true, "tripPlanner", true);
        this._loader.setVisibility(8);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.g = l90.valueOf(getArguments().getString("extra:tabItem"));
        if (!ui1.e0()) {
            this.i = (TripRequest) new Gson().fromJson(getArguments().getString("extra:request"), LocationTripRequest.class);
        } else if (getArguments().getString("extra:requestType") != null) {
            if ("extra:stopTripRequest".equalsIgnoreCase(getArguments().getString("extra:requestType"))) {
                this.i = (TripRequest) new Gson().fromJson(getArguments().getString("extra:request"), StopTripRequest.class);
            } else if ("extra:locationTripRequest".equalsIgnoreCase(getArguments().getString("extra:requestType"))) {
                this.i = (TripRequest) new Gson().fromJson(getArguments().getString("extra:request"), LocationTripRequest.class);
            }
        }
        this.f = null;
        this.j = false;
        this.o = new ArrayList();
        i(null);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.k = (int) getResources().getDimension(R.dimen.scheduler_card_margin);
        View inflate = layoutInflater.inflate(R.layout.trip_planner_result_tab, (ViewGroup) null, true);
        StringBuilder i0 = hj1.i0("ResultFragmentTag");
        i0.append(this.g.name());
        inflate.setTag(i0.toString());
        ButterKnife.inject(this, inflate);
        this.p = (SkeletonLoader) inflate.findViewById(R.id.skeleton_loader);
        this._loader.setRetryHandler(new a());
        l();
        j();
        return inflate;
    }

    public void onDestroy() {
        jz5.b().o(this);
        k();
        super.onDestroy();
    }

    public void onDetach() {
        jz5.b().o(this);
        super.onDetach();
    }

    public void onEvent(nn0.a aVar) {
        if (aVar != null) {
            int i2 = aVar.f2577a;
            int i3 = aVar.b;
            jz5.b().g(hj1.l("get route clicked", Long.MIN_VALUE, "source", "trip planner results"));
            int i4 = ((i2 * 60) + i3) * 60;
            if (i4 == -1) {
                i4 = ui1.N();
            }
            TripRequest tripRequest = this.i;
            if (tripRequest != null && tripRequest.getTime() != i4) {
                TripRequest tripRequest2 = this.i;
                if (tripRequest2 instanceof StopTripRequest) {
                    this.i = new StopTripRequest((Stop) ((StopTripRequest) tripRequest2).getFrom(), (Stop) ((StopTripRequest) this.i).getTo(), this.i.getTime());
                } else {
                    this.i = new LocationTripRequest((mf1) tripRequest2.getFrom(), (mf1) this.i.getTo(), i4);
                }
                i(null);
                l();
            }
        }
    }

    public void onPause() {
        super.onPause();
        k();
    }

    public void onStart() {
        super.onStart();
        j();
    }

    public void onStop() {
        super.onStop();
        if (!this.g.equals(l90.RECOMMENDED)) {
            jz5.b().o(this);
        }
    }

    public void p() {
        this._results.removeAllViews();
        a(this._results, this.f.itineraries, null, this.g.name(), false, false);
    }

    public void q() {
        this._resultContainer.setVisibility(0);
        this.p.a(this._resultContainer);
        this._loader.setVisibility(8);
        p();
    }

    public void onEvent(TripPlannerEvent tripPlannerEvent) {
        String str;
        tripPlannerEvent.getResponseType();
        String requestId = tripPlannerEvent.getRequestId();
        if (this.j && (str = this.h) != null && str.equals(requestId)) {
            k();
            this.j = false;
            tripPlannerEvent.getRawResponse();
            this.f = tripPlannerEvent.getResponse();
            l();
            jz5.b().m(tripPlannerEvent);
        }
    }

    public void onEvent(sm0.b bVar) {
        TripOptions h2 = h();
        if (this.i != null) {
            TripOptions tripOptions = this.n;
            if (tripOptions == null || !tripOptions.equals(h2)) {
                i(h2);
                l();
            }
        }
    }

    public void onEvent(TripPlannerInputLocationChangedEvent tripPlannerInputLocationChangedEvent) {
        int ordinal = tripPlannerInputLocationChangedEvent.gerResponse().ordinal();
        if (ordinal != 0) {
            boolean z = true;
            if (ordinal == 1) {
                TripRequest tripRequest = tripPlannerInputLocationChangedEvent.getTripRequest();
                TripRequest tripRequest2 = this.i;
                if (tripRequest2 != null && tripRequest2.equals(tripRequest)) {
                    z = false;
                }
                if (z) {
                    this.i = tripRequest;
                    i(null);
                    l();
                }
            } else if (ordinal == 2) {
                f();
                l();
                this._loader.c(true);
            }
        } else {
            g();
            l();
        }
    }
}
