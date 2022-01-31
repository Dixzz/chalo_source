package defpackage;

import android.animation.LayoutTransition;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import app.zophop.R;
import app.zophop.models.LiveRouteData;
import app.zophop.models.RouteWithoutTimings;
import app.zophop.models.Stop;
import app.zophop.models.StreamInfo;
import app.zophop.models.Trip;
import app.zophop.models.TripLeg;
import app.zophop.pubsub.eventbus.events.ResultActivityToFragment;
import app.zophop.pubsub.eventbus.events.StopSearchedEvent;
import app.zophop.ui.activities.PickStopActivity;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import defpackage.ii1;
import defpackage.xt;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* renamed from: tw0  reason: default package */
/* compiled from: TripFragment */
public class tw0 extends Fragment {
    public static final /* synthetic */ int z = 0;
    public ListView f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public nk0 l;
    public Trip m;
    public TextView n;
    public Handler o;
    public Stop p;
    public Runnable q;
    public boolean r;
    public String s;
    public LiveRouteData t;
    public final ci1<Stop> u = new a();
    public String v;
    public ValueEventListener w;
    public DatabaseReference x;
    public long y = 0;

    /* renamed from: tw0$a */
    /* compiled from: TripFragment */
    public class a implements ci1<Stop> {
        public a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.ci1
        public void a(Stop stop) {
            Stop stop2 = stop;
            tw0 tw0 = tw0.this;
            if (!tw0.r) {
                tw0.p = stop2;
                tw0.a(stop2);
                return;
            }
            Stop stop3 = tw0.p;
            if (stop3 == null || !stop3.equals(stop2)) {
                tw0 tw02 = tw0.this;
                tw02.p = stop2;
                Runnable runnable = tw02.q;
                if (runnable != null) {
                    tw02.o.removeCallbacks(runnable);
                }
                if (tw02.r) {
                    vw0 vw0 = new vw0(tw02, tw02.m.get_routeId(), stop2);
                    tw02.q = vw0;
                    tw02.o.post(vw0);
                    return;
                }
                tw02.a(stop2);
            }
        }
    }

    public final void a(Stop stop) {
        Stop stop2;
        if (getActivity() != null && isAdded() && (stop2 = this.p) != null && stop2.equals(stop)) {
            ii1.a aVar = new ii1.a();
            aVar.d = ii1.a.EnumC0027a.FAILURE;
            this.l.a(stop, aVar);
            this.l.notifyDataSetChanged();
            getClass().getSimpleName();
            stop.getName();
        }
    }

    public final void b(boolean z2) {
        xt.t1 t1Var = xt.f3961a;
        if (!xt.p) {
            z30 N = t1Var.N();
            Trip trip = this.m;
            Objects.requireNonNull(N);
            if (!xt.p) {
                String str = trip.get_routeId();
                for (TripLeg tripLeg : trip.getTripLegs()) {
                    N.d(tripLeg.getStop().getId()).child(str).keepSynced(z2);
                }
            }
            this.x.keepSynced(z2);
        }
    }

    public final void c() {
        ui1.w0(getActivity(), this.n, ui1.A(this.y, getActivity()), R.color.eta_blue);
        this.n.setVisibility(0);
        this.r = true;
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        int indexOf;
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == 1010 && (indexOf = ((ArrayList) ui1.K(this.m.getTripLegs())).indexOf((Stop) hj1.s(intent.getStringExtra("result_picked_stop"), Stop.class))) >= 0) {
            this.l.e(indexOf);
            this.f.setSelection(indexOf);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Trip trip = (Trip) new Gson().fromJson(getArguments().getString("extra_trip"), Trip.class);
        this.m = trip;
        this.g = trip.getTripId();
        this.h = getArguments().getString("stop_id");
        this.i = getArguments().getString("end_stop_id");
        this.v = getArguments().getString("routeid");
        this.k = getArguments().getString("route_name");
        this.j = this.m.getTransitMode().toString();
        getArguments().getString("trigger_origin");
        this.o = new Handler();
        this.r = true;
        this.w = new ww0(this);
        this.x = xt.f3961a.N().f(this.v);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menu.findItem(R.id.share).setVisible(true);
        menu.findItem(R.id.menu_search_stop).setVisible(true);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_trip, viewGroup, false);
        setHasOptionsMenu(true);
        ListView listView = (ListView) inflate.findViewById(R.id.trip_legs_list);
        this.f = listView;
        listView.setEmptyView(inflate.findViewById(R.id.empty_view));
        TextView textView = (TextView) inflate.findViewById(R.id.live_updated_status);
        this.n = textView;
        LayoutTransition layoutTransition = new LayoutTransition();
        layoutTransition.enableTransitionType(2);
        layoutTransition.setDuration(250);
        ((LinearLayout) textView.getParent()).setLayoutTransition(layoutTransition);
        Trip trip = this.m;
        if (trip.getTripLegs() != null) {
            List<TripLeg> tripLegs = trip.getTripLegs();
            LatLng h2 = xt.f3961a.B().h();
            if (h2 != null) {
                double L = vn.L(tripLegs.get(0).getStop().getLatLong(), h2);
                for (TripLeg tripLeg : tripLegs) {
                    double L2 = vn.L(tripLeg.getStop().getLatLong(), h2);
                    if (L2 <= L) {
                        this.s = tripLeg.getStop().getId();
                        L = L2;
                    }
                }
            }
            nk0 nk0 = new nk0(getActivity(), trip.getTripLegs(), this.h, this.i, this.s);
            this.l = nk0;
            nk0.k = this.u;
            this.f.setAdapter((ListAdapter) nk0);
            this.f.setSelection(this.l.b());
            ci1<Stop> ci1 = this.u;
            nk0 nk02 = this.l;
            ci1.a(nk02.g.get(nk02.b()).getStop());
            b(true);
        }
        return inflate;
    }

    public void onDestroyView() {
        if (this.m != null) {
            b(false);
        }
        super.onDestroyView();
    }

    public void onEvent(LiveRouteData liveRouteData) {
        if (this.m.get_routeId().equals(liveRouteData.getRoute().getRouteId())) {
            this.t = liveRouteData;
            List<StreamInfo> firebaseStreams = liveRouteData.getFirebaseStreams();
            boolean z2 = this.p == null;
            if (!z2) {
                String str = this.m.get_routeId();
                Stop stop = this.p;
                if (stop != null) {
                    xt.f3961a.N().e(stop, str, new uw0(this, stop));
                }
            }
            if (firebaseStreams.size() <= 0 || !vn.K0(getActivity())) {
                a(this.p);
                nk0 nk0 = this.l;
                Objects.requireNonNull(nk0);
                nk0.m = new ArrayList();
                nk0.n = new ArrayList();
                nk0.notifyDataSetChanged();
                return;
            }
            this.l.f(firebaseStreams, z2);
            this.l.notifyDataSetChanged();
            firebaseStreams.size();
            c();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.menu_search_stop) {
            Intent intent = new Intent(getActivity(), PickStopActivity.class);
            intent.putExtra("extra_mode", this.m.getTransitMode().toString());
            intent.putExtra("extra:search_copy", getString(R.string.type_station_name));
            intent.putExtra("stop_list_extra", new Gson().toJson(ui1.K(this.m.getTripLegs())));
            startActivityForResult(intent, 1010);
        } else if (menuItem.getItemId() == R.id.share) {
            new j90().a(getActivity(), this.m.get_routeId(), "", this.m.getTripLegs().get(0).getStop().getName(), this.m.getTripLegs().get(this.m.getTripLegs().size() - 1).getStop().getName(), this.m.getTransitMode());
            ui1.A0(this.k, this.m.getTransitMode());
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void onStart() {
        super.onStart();
        Runnable runnable = this.q;
        if (runnable != null) {
            this.o.post(runnable);
        }
        this.x.addValueEventListener(this.w);
    }

    public void onStop() {
        Runnable runnable = this.q;
        if (runnable != null) {
            this.o.removeCallbacks(runnable);
        }
        this.x.removeEventListener(this.w);
        super.onStop();
    }

    public void onEvent(StopSearchedEvent stopSearchedEvent) {
        int indexOf;
        if (this.m != null && stopSearchedEvent.getRouteId().equals(this.m.get_routeId()) && (indexOf = ((ArrayList) ui1.K(this.m.getTripLegs())).indexOf(stopSearchedEvent.getStop())) >= 0) {
            this.l.e(indexOf);
            this.f.setSelection(indexOf);
            jz5.b().m(stopSearchedEvent);
        }
    }

    public void onEvent(ResultActivityToFragment resultActivityToFragment) {
        Stop stop;
        Stop stop2;
        if (!(resultActivityToFragment.getResultCode() == -1 && resultActivityToFragment.getRequestCode() == 99)) {
            return;
        }
        if (ui1.V(getActivity())) {
            List<TripLeg> tripLegs = this.m.getTripLegs();
            ArrayList arrayList = new ArrayList();
            for (TripLeg tripLeg : tripLegs) {
                arrayList.add(tripLeg.getStop());
            }
            int b = this.l.b();
            if (b != -1) {
                stop = (Stop) arrayList.get(b);
            } else {
                stop = ui1.E(xt.f3961a.B().h(), arrayList);
                if (stop == null) {
                    stop = (Stop) arrayList.get(0);
                }
            }
            int i2 = this.l.i;
            if (i2 != -1) {
                stop2 = (Stop) arrayList.get(i2);
            } else {
                stop2 = (Stop) arrayList.get(arrayList.size() - 1);
            }
            ui1.k0(getActivity(), new RouteWithoutTimings(this.v, this.k, stop.getMode(), arrayList), stop, stop2);
            String str = this.j;
            String str2 = this.v;
            ed1 l2 = hj1.l("checkin initiated", Long.MIN_VALUE, "source", "trip details screen");
            if (str != null) {
                l2.a("mode", str);
            }
            if (str2 != null) {
                l2.a("route", str2);
            }
            jz5.b().g(l2);
        } else if (!vn.K0(getActivity())) {
            Toast.makeText(getActivity(), getString(R.string.check_in_activity_failure_query_failed), 1).show();
        } else {
            vn.J0(getActivity());
        }
    }
}
