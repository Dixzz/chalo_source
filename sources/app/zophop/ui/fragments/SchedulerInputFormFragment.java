package app.zophop.ui.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.cardview.widget.CardView;
import app.zophop.R;
import app.zophop.alarm.SubscriberAlarm;
import app.zophop.models.Agency;
import app.zophop.models.City;
import app.zophop.models.Favourites.BusFavourite;
import app.zophop.models.Favourites.FavType;
import app.zophop.models.Favourites.Favourite;
import app.zophop.models.Favourites.RailFavourite;
import app.zophop.models.Favourites.RouteStoreType;
import app.zophop.models.LineInfo;
import app.zophop.models.Stop;
import app.zophop.models.StopTripRequest;
import app.zophop.models.TransitMode;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import app.zophop.pubsub.eventbus.events.SchedulerInputEvent;
import app.zophop.pubsub.eventbus.events.TripPlannerEvent;
import app.zophop.ui.activities.PickStopActivity;
import app.zophop.ui.views.SummaryView;
import app.zophop.ui.views.summary_card.LoaderView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.crashlytics.android.answers.SearchEvent;
import com.google.firebase.messaging.Constants;
import com.google.gson.Gson;
import defpackage.nn0;
import defpackage.s30;
import defpackage.wb1;
import defpackage.xt;
import io.github.inflationx.calligraphy3.TypefaceUtils;
import j$.util.DesugarTimeZone;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.json.JSONException;
import zophop.models.ExtraTrips;
import zophop.models.Itinerary;
import zophop.models.Leg;
import zophop.models.TripPlannerResponse;

public class SchedulerInputFormFragment extends Fragment {
    public static final /* synthetic */ int v = 0;
    @InjectView(R.id.agency_list_container)
    public LinearLayout _agencyListContainer;
    @InjectView(R.id.bus_hook)
    public View _busHook;
    @InjectView(R.id.card_tutorial)
    public View _cardTutView;
    @InjectView(R.id.favorite_header)
    public View _favheader;
    @InjectView(R.id.favorite_container)
    public View _favouriteContainer;
    @InjectView(R.id.favorite_list)
    public LinearLayout _favouriteList;
    @InjectView(R.id.form)
    public View _form;
    @InjectView(R.id.highlight_trip_planner)
    public View _highlightTripPlanner;
    @InjectView(R.id.input_from)
    public View _inputFrom;
    @InjectView(R.id.input_to)
    public View _inputTo;
    @InjectView(R.id.loader)
    public LoaderView _loader;
    @InjectView(R.id.recent_list_card)
    public CardView _recentListCard;
    @InjectView(R.id.recent_list_container)
    public LinearLayout _recentListContainer;
    @InjectView(R.id.result_container)
    public LinearLayout _resultContainer;
    @InjectView(R.id.results)
    public View _results;
    @InjectView(R.id.scheduler_cards)
    public View _schedulerCardContainer;
    @InjectView(R.id.scheduler_time)
    public TextView _timeView;
    public TextView f;
    public TextView g;
    public int h = -1;
    public Stop i;
    public Stop j;
    public String k;
    public boolean l;
    public TripPlannerResponse m;
    public TransitMode n;
    public f80 o;
    public Favourite p;
    public City q;
    public List<Favourite> r;
    public final ci1<Favourite> s = new b();
    public final ci1<Favourite> t = new c();
    public final ci1<Favourite> u = new d();

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            SchedulerInputFormFragment.this.g();
        }
    }

    public class b implements ci1<Favourite> {
        public b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.ci1
        public void a(Favourite favourite) {
            Favourite favourite2 = favourite;
            Toast.makeText(SchedulerInputFormFragment.this.getActivity(), (int) R.string.fav_removed, 1).show();
            SubscriberAlarm.d(SchedulerInputFormFragment.this.getActivity(), favourite2);
            ((c80) SchedulerInputFormFragment.this.o).r(favourite2, RouteStoreType.FAVORITE);
            SchedulerInputFormFragment.this.k();
            SchedulerInputFormFragment.this.b();
            SchedulerInputFormFragment.this.a();
            SchedulerInputFormFragment.this.m();
        }
    }

    public class c implements ci1<Favourite> {
        public c() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.ci1
        public void a(Favourite favourite) {
            SchedulerInputFormFragment schedulerInputFormFragment = SchedulerInputFormFragment.this;
            int i = SchedulerInputFormFragment.v;
            schedulerInputFormFragment.k();
            SchedulerInputFormFragment.this.b();
            SchedulerInputFormFragment.this.m();
        }
    }

    public class d implements ci1<Favourite> {
        public d() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.ci1
        public void a(Favourite favourite) {
            SchedulerInputFormFragment schedulerInputFormFragment = SchedulerInputFormFragment.this;
            int i = SchedulerInputFormFragment.v;
            schedulerInputFormFragment.b();
            SchedulerInputFormFragment.this.a();
            SchedulerInputFormFragment.this.k();
            SchedulerInputFormFragment.this.m();
        }
    }

    public enum e {
        RECENT("recent"),
        FAVORITE("favorite"),
        MANUAL(SearchEvent.QUERY_ATTRIBUTE);
        
        public final String _source;

        private e(String str) {
            this._source = str;
        }

        public String toString() {
            return this._source;
        }
    }

    public static Favourite c(String str, String str2) {
        if (str == null) {
            return null;
        }
        FavType valueOf = FavType.valueOf(str);
        if (valueOf.equals(FavType.LINE)) {
            return (Favourite) hj1.s(str2, BusFavourite.class);
        }
        if (valueOf.equals(FavType.TRIP)) {
            return (Favourite) hj1.s(str2, RailFavourite.class);
        }
        return null;
    }

    public static void o(Favourite favourite, String str, String str2, Bundle bundle) {
        if (favourite != null) {
            bundle.putString("extra_mode", favourite.getMode().toString());
            bundle.putString("extra:favorite", new Gson().toJson(favourite));
            bundle.putString("extra:favoriteType", favourite.getType().name());
            bundle.putString("extra:origin", str2);
        } else if (str != null) {
            bundle.putString("extra_mode", str);
        }
    }

    public final void a() {
        f80 f80 = this.o;
        List<Favourite> j2 = ((c80) f80).j(this.n, RouteStoreType.FAVORITE);
        ((c80) f80).l(j2);
        this.r = j2;
        if (j2.isEmpty()) {
            this._favheader.setVisibility(8);
            this._favouriteList.setVisibility(8);
            return;
        }
        this._favheader.setVisibility(0);
        this._favouriteList.setVisibility(0);
        this._favouriteList.removeAllViews();
        for (int i2 = 0; i2 < this.r.size(); i2++) {
            gc1 gc1 = new gc1(getActivity());
            gc1.c(this.r.get(0));
            gc1.setClickListener(new cw0(this, "schedulerFavorite"));
            gc1.setFavoriteRemovedListener(this.s);
            this._favouriteList.addView(gc1);
            if (i2 != this.r.size() - 1) {
                this._favouriteList.addView(e());
            }
        }
    }

    public final void b() {
        this._recentListContainer.removeAllViews();
        f80 f80 = this.o;
        List<Favourite> j2 = ((c80) f80).j(this.n, RouteStoreType.RECENT);
        ((c80) f80).m(j2);
        int size = j2.size();
        if (size != 0) {
            this._recentListCard.setVisibility(0);
            this._recentListContainer.addView(d(getString(R.string.recent_searches), this._recentListContainer, true));
            for (int i2 = 0; i2 < size; i2++) {
                gc1 gc1 = new gc1(getActivity());
                gc1.c(j2.get(i2));
                gc1.setClickListener(new cw0(this, "schdeulerRecent"));
                gc1.setAddFavoriteListener(this.u);
                gc1.setRecentRemovedListener(this.t);
                this._recentListContainer.addView(e());
                this._recentListContainer.addView(gc1);
            }
            return;
        }
        this._recentListCard.setVisibility(8);
    }

    public final View d(String str, ViewGroup viewGroup, boolean z) {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.schedule_fare_header, viewGroup, false);
        inflate.setVisibility(0);
        TextView textView = (TextView) inflate.findViewById(R.id.number_of_changes);
        textView.setText(str);
        textView.setTextSize(1, 14.0f);
        textView.setVisibility(0);
        textView.setTextColor(getResources().getColor(R.color.black_60));
        textView.setTypeface(TypefaceUtils.load(getResources().getAssets(), "fonts/NotoSans-SemiBold.ttf"));
        if (z) {
            inflate.setBackgroundResource(0);
            inflate.setBackgroundColor(Color.parseColor("#ffffff"));
        }
        return inflate;
    }

    public final View e() {
        View view = new View(getActivity());
        view.setBackgroundColor(getResources().getColor(R.color.trip_detail_list_grey_color));
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) getResources().getDimension(R.dimen.home_screen_favorite_card_divider)));
        return view;
    }

    public final View.OnClickListener f(Itinerary itinerary) {
        return new fw0(this, itinerary);
    }

    public void g() {
        boolean z;
        jz5.b().i(new rd1());
        int i2 = this.h;
        if (i2 == -1) {
            i2 = ui1.N();
        }
        this.h = i2;
        if (vn.K0(getActivity().getApplicationContext())) {
            z = xt.f3961a.J().d.equals(s30.b.SUCCESSFUL);
        } else {
            z = xt.f3961a.A().l();
        }
        boolean z2 = !z;
        l(this.i.getName(), this.j.getName(), null, z2);
        if (!z2) {
            s30 J = xt.f3961a.J();
            String id = this.i.getId();
            String id2 = this.j.getId();
            TransitMode transitMode = this.n;
            Objects.requireNonNull(J);
            String str = id + ProductDiscountsObject.KEY_DELIMITER + id2 + ProductDiscountsObject.KEY_DELIMITER + i2;
            s30.c cVar = new s30.c(J, i2, id, id2, str, transitMode);
            if (J.d.equals(s30.b.SUCCESSFUL)) {
                J.c(cVar);
            } else {
                J.b();
                J.c.add(cVar);
            }
            this.k = str;
        } else {
            this.k = xt.f3961a.h0().a(new StopTripRequest(this.i, this.j, i2), null);
        }
        if (!this.i.equals(this.j)) {
            c80 r2 = xt.f3961a.r();
            Stop stop = this.i;
            Stop stop2 = this.j;
            TransitMode transitMode2 = this.n;
            Objects.requireNonNull(r2);
            boolean z3 = false;
            if (!(r2.g(stop, stop2, RouteStoreType.FAVORITE) != null)) {
                RouteStoreType routeStoreType = RouteStoreType.RECENT;
                if (r2.g(stop, stop2, routeStoreType) != null) {
                    z3 = true;
                }
                if (!z3) {
                    try {
                        RailFavourite railFavourite = new RailFavourite(stop, stop2, UUID.randomUUID().toString(), transitMode2, System.currentTimeMillis(), routeStoreType);
                        r2.c.j(r2.i(railFavourite), r2.f.e(railFavourite).toString());
                        r2.s(transitMode2);
                    } catch (JSONException e2) {
                        stop.getName();
                        stop2.getName();
                        transitMode2.toString();
                        b00 b00 = b00.f358a;
                        b00.a().b(e2);
                    }
                }
            }
        }
        this.l = true;
        i();
    }

    public final void h(int i2) {
        Intent intent = new Intent(getActivity(), PickStopActivity.class);
        intent.putExtra("extra:search_copy", getString(R.string.type_station_name));
        intent.putExtra("extra_mode", this.n.toString());
        startActivityForResult(intent, i2);
    }

    public final void i() {
        boolean z;
        if (this.l) {
            n();
            this._results.setVisibility(8);
            this._resultContainer.removeAllViews();
            this._loader.d();
            return;
        }
        TripPlannerResponse tripPlannerResponse = this.m;
        if (tripPlannerResponse == null) {
            n();
            this._results.setVisibility(8);
            this._loader.a();
            return;
        }
        if (tripPlannerResponse.itineraries.size() != 0) {
            Iterator<Itinerary> it = this.m.itineraries.iterator();
            loop0:
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                Itinerary next = it.next();
                if (next == null || next.legs.size() == 0) {
                    break;
                }
                Iterator<Leg> it2 = next.legs.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        Leg next2 = it2.next();
                        if (next2 == null) {
                            break loop0;
                        }
                        ExtraTrips extraTrips = next2.extraTrips;
                        if (extraTrips != null) {
                            if (extraTrips.extraTrips.size() == 0) {
                                break loop0;
                            }
                        } else {
                            break loop0;
                        }
                    }
                }
            }
        }
        z = true;
        if (z) {
            n();
            this._results.setVisibility(8);
            this._loader.b(R.drawable.alert_scheduler, getString(R.string.no_trip_available));
            return;
        }
        n();
        this._results.setVisibility(0);
        this._loader.setVisibility(8);
        getResources().getDimension(R.dimen.scheduler_card_margin);
        for (int i2 = 0; i2 < this.m.itineraries.size(); i2++) {
            Itinerary itinerary = this.m.itineraries.get(i2);
            getActivity().getApplicationContext();
            View.OnClickListener f2 = f(itinerary);
            SummaryView summaryView = new SummaryView(getActivity());
            wb1 wb1 = new wb1(itinerary, getActivity().getApplicationContext(), wb1.b.SCHEDULER);
            wb1.c = f2;
            summaryView.a(wb1);
            CardView cardView = new CardView(getActivity());
            cardView.addView(summaryView);
            cardView.setAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.slide_in_up_botttom));
            this._resultContainer.addView(cardView);
            LinearLayout linearLayout = this._resultContainer;
            View view = new View(getActivity());
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) getResources().getDimension(R.dimen.scheduler_results_divider)));
            linearLayout.addView(view);
        }
        if (!xt.f3961a.l().h.has("card_details_tut_shown")) {
            this._cardTutView.setVisibility(0);
            this._cardTutView.findViewById(R.id.card_tutorial_done).setOnClickListener(new ew0(this));
        }
    }

    public final void j() {
        if (this.i != null && this.j != null) {
            jz5.b().i(new SchedulerInputEvent(this.n, this.i, this.j));
            g();
        }
    }

    public final void k() {
        f80 f80 = this.o;
        List<Favourite> j2 = ((c80) f80).j(this.n, RouteStoreType.FAVORITE);
        ((c80) f80).l(j2);
        this.r = j2;
        if (!j2.isEmpty() || !this.n.equals(TransitMode.bus) || ((ArrayList) xt.f3961a.r().j(this.n, RouteStoreType.RECENT)).size() != 0 || ui1.Y()) {
            this._highlightTripPlanner.setVisibility(8);
        } else {
            this._highlightTripPlanner.setVisibility(0);
        }
    }

    public final void l(String str, String str2, String str3, boolean z) {
        ed1 ed1 = new ed1("schedule requested", Long.MIN_VALUE);
        ed1.a("mode", this.n.name());
        ed1.a(Constants.MessagePayloadKeys.FROM, str);
        ed1.a("to", str2);
        int i2 = this.h;
        long currentTimeMillis = System.currentTimeMillis();
        Calendar instance = Calendar.getInstance(DesugarTimeZone.getTimeZone("gmt"));
        instance.setTimeInMillis(currentTimeMillis + 19800000);
        int i3 = ((instance.get(11) * 60) + instance.get(12)) * 60;
        ed1.a("leave", (i2 == -1 || i2 == i3) ? "now" : i3 > i2 ? "before" : i3 < i2 ? "after" : "");
        if (str3 != null) {
            ed1.a("route", str3);
        }
        if (this.n.equals(TransitMode.bus)) {
            xt.t1 t1Var = xt.f3961a;
            boolean z2 = true;
            if (t1Var.r().h(str3, RouteStoreType.FAVORITE) != null) {
                ed1.a("source", e.FAVORITE.toString());
            } else {
                if (t1Var.r().h(str3, RouteStoreType.RECENT) == null) {
                    z2 = false;
                }
                if (z2) {
                    ed1.a("source", e.RECENT.toString());
                }
            }
        } else {
            xt.t1 t1Var2 = xt.f3961a;
            if (t1Var2.r().o(this.i, this.j, RouteStoreType.FAVORITE)) {
                ed1.a("source", e.FAVORITE.toString());
            } else if (t1Var2.r().o(this.i, this.j, RouteStoreType.RECENT)) {
                ed1.a("source", e.RECENT.toString());
            } else {
                ed1.a("source", e.MANUAL.toString());
            }
        }
        ed1.a("isOnlineQuery", String.valueOf(z));
        jz5.b().g(ed1);
        ui1.t0("schedulerUsed");
    }

    public final void m() {
        List<Favourite> j2 = ((c80) this.o).j(this.n, RouteStoreType.RECENT);
        List<Favourite> j3 = ((c80) this.o).j(this.n, RouteStoreType.FAVORITE);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this._favouriteContainer.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this._agencyListContainer.getLayoutParams();
        ArrayList arrayList = (ArrayList) j2;
        if (arrayList.size() != 0 && ((ArrayList) j3).size() != 0) {
            layoutParams.addRule(3, R.id.recent_list_card);
            layoutParams2.addRule(3, R.id.favorite_container);
        } else if (((ArrayList) j3).size() != 0) {
            layoutParams.addRule(3, 0);
            layoutParams2.addRule(3, R.id.favorite_container);
        } else if (arrayList.size() != 0) {
            layoutParams2.addRule(3, R.id.recent_list_card);
            layoutParams.addRule(3, R.id.agency_list_container);
        } else {
            layoutParams2.addRule(3, 0);
            layoutParams.addRule(3, R.id.agency_list_container);
        }
        this._favouriteContainer.setLayoutParams(layoutParams);
        this._agencyListContainer.setLayoutParams(layoutParams2);
    }

    public final void n() {
        this._schedulerCardContainer.setVisibility(8);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i3 != -1) {
            return;
        }
        if (i2 == 1) {
            Stop stop = (Stop) hj1.s(intent.getStringExtra("result_picked_stop"), Stop.class);
            this.i = stop;
            this.f.setText(stop.getName());
            j();
        } else if (i2 == 2) {
            Stop stop2 = (Stop) hj1.s(intent.getStringExtra("result_picked_stop"), Stop.class);
            this.j = stop2;
            this.g.setText(stop2.getName());
            j();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.n = TransitMode.getTransitMode(getArguments().getString("extra_mode"));
        xt.t1 t1Var = xt.f3961a;
        this.o = t1Var.r();
        this.p = c(getArguments().getString("extra:favoriteType"), getArguments().getString("extra:favorite"));
        this.q = t1Var.k().d();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.scheduler_input_fragment, (ViewGroup) null);
        ButterKnife.inject(this, inflate);
        this.f = (TextView) this._inputFrom.findViewById(R.id.header_title);
        this.g = (TextView) this._inputTo.findViewById(R.id.header_title);
        if (this.q.getModeAgencyMap() == null) {
            this._agencyListContainer.setVisibility(8);
        } else {
            this._agencyListContainer.setVisibility(0);
        }
        TransitMode transitMode = this.n;
        TransitMode transitMode2 = TransitMode.bus;
        if (transitMode.equals(transitMode2)) {
            this._form.setVisibility(8);
            this._busHook.findViewById(R.id.circle_container).setVisibility(8);
            TextView textView = (TextView) this._busHook.findViewById(R.id.header_title);
            if (ui1.Y()) {
                textView.setHint(getString(R.string.scheduler_search_kochi));
            } else {
                textView.setHint(getString(R.string.search_by_route_number));
            }
            textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.search, 0, 0, 0);
            this._busHook.findViewById(R.id.header_separator).setVisibility(8);
            this._busHook.setOnClickListener(new dw0(this));
        } else {
            this._busHook.setVisibility(8);
            this._inputFrom.findViewById(R.id.circle_bottom).setVisibility(0);
            this._inputTo.findViewById(R.id.circle_top).setVisibility(0);
            ((ImageView) this._inputTo.findViewById(R.id.circle_image)).setImageResource(R.drawable.scheduler_input_circle_to);
            this.f.setHint(getString(R.string.enter_origin));
            this.g.setHint(getString(R.string.enter_destination));
        }
        if (this.q.getModeAgencyMap() == null) {
            this._agencyListContainer.setVisibility(8);
        } else {
            this._agencyListContainer.setVisibility(0);
            this._agencyListContainer.removeAllViews();
            String string = getString(R.string.lines_routes);
            if (this.n.equals(transitMode2)) {
                string = getString(R.string.agency_covered);
            }
            if (!ui1.Y()) {
                this._agencyListContainer.addView(d(string.toUpperCase(), this._agencyListContainer, false));
            }
            int ordinal = this.n.ordinal();
            if (ordinal == 0 || ordinal == 1) {
                if (!ui1.Y()) {
                    for (Agency agency : this.q.getModeAgencyMap().get(this.n)) {
                        kc1 kc1 = new kc1(getActivity());
                        ((TextView) kc1.f.findViewById(R.id.agency_name)).setText(agency.getAgencyName());
                        this._agencyListContainer.addView(kc1);
                    }
                }
            } else if (ordinal == 2 || ordinal == 3) {
                for (LineInfo lineInfo : this.q.getModeAgencyMap().get(this.n).get(0).getLineInfoList()) {
                    kc1 kc12 = new kc1(getActivity());
                    ((TextView) kc12.f.findViewById(R.id.agency_name)).setText(lineInfo.getLineName());
                    kc12.f.findViewById(R.id.route_info).setVisibility(0);
                    ((TextView) kc12.f.findViewById(R.id.route_info)).setText(lineInfo.getDetails());
                    this._agencyListContainer.addView(kc12);
                }
            }
        }
        b();
        a();
        if (this.p != null) {
            new cw0(this, getArguments().getString("extra:origin")).a(this.p);
        }
        this._loader.setRetryHandler(new a());
        k();
        m();
        return inflate;
    }

    public void onEvent(nn0.a aVar) {
        if (aVar != null) {
            int i2 = ((aVar.f2577a * 60) + aVar.b) * 60;
            if (!(this.h == i2) || this.m == null) {
                this.h = i2;
                this._timeView.setText(jh1.g((long) i2));
                j();
            }
        }
    }

    public void onEventMainThread(TripPlannerEvent tripPlannerEvent) {
        if (this.l) {
            String requestId = tripPlannerEvent.getRequestId();
            String str = this.k;
            if (str != null && str.equals(requestId)) {
                if (tripPlannerEvent.getResponseType().equals(TripPlannerEvent.ResponseType.SUCCESS)) {
                    System.currentTimeMillis();
                    this.l = false;
                    this.m = tripPlannerEvent.getResponse();
                    i();
                    System.currentTimeMillis();
                } else {
                    n();
                    this._results.setVisibility(8);
                    this._loader.a();
                }
                jz5.b().m(tripPlannerEvent);
                this.k = null;
            }
        }
    }

    public void onResume() {
        super.onResume();
        if (this.m == null && !this.l) {
            a();
            b();
            m();
            k();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.i != null) {
            bundle.putString("save_from_stop", new Gson().toJson(this.i));
        }
        if (this.j != null) {
            bundle.putString("save_to_stop", new Gson().toJson(this.j));
        }
        bundle.putBoolean("save_progress_state", this.l);
        if (this.m != null) {
            bundle.putString("save_response", new Gson().toJson(this.m));
        }
        String str = this.k;
        if (str != null) {
            bundle.putString("save_request_id", str);
        }
    }

    public void onStart() {
        super.onStart();
        jz5 b2 = jz5.b();
        b2.k(this, b2.e, true, 0);
    }

    public void onStop() {
        super.onStop();
        jz5.b().o(this);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (bundle != null) {
            String string = bundle.getString("save_from_stop");
            Gson gson = new Gson();
            if (string != null) {
                Stop stop = (Stop) gson.fromJson(string, Stop.class);
                this.i = stop;
                this.f.setText(stop.getName());
            }
            String string2 = bundle.getString("save_to_stop");
            if (string2 != null) {
                Stop stop2 = (Stop) gson.fromJson(string2, Stop.class);
                this.j = stop2;
                this.g.setText(stop2.getName());
            }
            if (!(this.i == null || this.j == null)) {
                jz5.b().i(new SchedulerInputEvent(this.n, this.i, this.j));
            }
            boolean z = false;
            boolean z2 = bundle.getBoolean("save_progress_state", false);
            String string3 = bundle.getString("save_response");
            String string4 = bundle.getString("save_request_id");
            if (z2) {
                this.l = z2;
                this.k = string4;
                TripPlannerEvent tripPlannerEvent = (TripPlannerEvent) jz5.b().c(TripPlannerEvent.class);
                if (tripPlannerEvent != null) {
                    String requestId = tripPlannerEvent.getRequestId();
                    String str = this.k;
                    if (str != null && str.equals(requestId)) {
                        z = true;
                    }
                    if (z) {
                        onEventMainThread(tripPlannerEvent);
                        return;
                    }
                }
                g();
            } else if (!z2 && string3 != null) {
                this.l = z2;
                this.m = (TripPlannerResponse) hj1.s(string3, TripPlannerResponse.class);
                i();
            }
        }
    }
}
