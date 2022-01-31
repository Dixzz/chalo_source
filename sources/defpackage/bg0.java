package defpackage;

import android.os.RemoteException;
import android.view.View;
import app.zophop.R;
import app.zophop.ui.activities.TripDetailsActivity;
import app.zophop.ui.views.MapCustomMyLocation;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import zophop.models.Leg;
import zophop.models.Stop;
import zophop.models.StopSequence;

/* renamed from: bg0  reason: default package */
/* compiled from: TripDetailsActivity */
public class bg0 implements g44 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TripDetailsActivity f426a;

    /* renamed from: bg0$a */
    /* compiled from: TripDetailsActivity */
    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            TripDetailsActivity tripDetailsActivity = bg0.this.f426a;
            int i = TripDetailsActivity.v;
            Objects.requireNonNull(tripDetailsActivity);
            if (q5.a(tripDetailsActivity, "android.permission.ACCESS_FINE_LOCATION") != 0) {
                tripDetailsActivity.requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 123);
            }
        }
    }

    public bg0(TripDetailsActivity tripDetailsActivity) {
        this.f426a = tripDetailsActivity;
    }

    @Override // defpackage.g44
    public void a(e44 e44) {
        TripDetailsActivity tripDetailsActivity;
        TripDetailsActivity tripDetailsActivity2;
        int i;
        int i2;
        MapFragment mapFragment = (MapFragment) this.f426a.getFragmentManager().findFragmentById(R.id.map);
        this.f426a.l = e44;
        e44.f().d(false);
        this.f426a.l.f().b(false);
        TripDetailsActivity tripDetailsActivity3 = this.f426a;
        tripDetailsActivity3.l.h(tripDetailsActivity3.t);
        this.f426a.l.f().a(false);
        this.f426a.l.f().c(false);
        TripDetailsActivity tripDetailsActivity4 = this.f426a;
        Leg leg = tripDetailsActivity4.k.legs.get(0);
        LatLng latLng = new LatLng(leg.from_lat, leg.from_lon);
        ArrayList<Leg> arrayList = tripDetailsActivity4.k.legs;
        Leg leg2 = arrayList.get(arrayList.size() - 1);
        LatLng latLng2 = new LatLng(leg2.to_lat, leg2.to_lon);
        tripDetailsActivity4.l.a(new MarkerOptions().position(latLng).title(leg.start_place_name).icon(BitmapDescriptorFactory.fromResource(R.drawable.start)));
        tripDetailsActivity4.l.a(new MarkerOptions().position(latLng2).title(leg2.end_place_name).icon(BitmapDescriptorFactory.fromResource(R.drawable.end)));
        tripDetailsActivity4.l.g(hd3.k2(xt.f3961a.k().d().getCenter(), 10.0f));
        ArrayList arrayList2 = new ArrayList();
        Iterator<Leg> it = this.f426a.k.legs.iterator();
        while (it.hasNext()) {
            Leg next = it.next();
            boolean z = this.f426a.k.legs.indexOf(next) != 0;
            TripDetailsActivity tripDetailsActivity5 = this.f426a;
            PolylineOptions polylineOptions = new PolylineOptions();
            polylineOptions.color(tripDetailsActivity5.getResources().getColor(R.color.black));
            polylineOptions.width((float) ((int) tripDetailsActivity5.getResources().getDimension(R.dimen.polyline_width)));
            if (z) {
                e44 e442 = tripDetailsActivity5.l;
                MarkerOptions position = new MarkerOptions().position(new LatLng(next.from_lat, next.from_lon));
                int ordinal = next.mode.ordinal();
                e442.a(position.icon(BitmapDescriptorFactory.fromResource(ordinal != 0 ? ordinal != 1 ? ordinal != 2 ? ordinal != 3 ? ordinal != 4 ? ordinal != 6 ? ordinal != 7 ? R.drawable.train_nearby : R.drawable.ferry_modes : R.drawable.bus_nearby : R.drawable.walk_nearby : R.drawable.cab_nearby : R.drawable.auto_nearby : R.drawable.metro_nearby : R.drawable.monorail_nearby)).title(next.start_place_name));
            }
            String str = next.polyline;
            if (str != null) {
                ArrayList arrayList3 = new ArrayList();
                int length = str.length();
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                while (i3 < length) {
                    int i6 = 0;
                    int i7 = 0;
                    while (true) {
                        i = i3 + 1;
                        int charAt = str.charAt(i3) - '?';
                        i7 |= (charAt & 31) << i6;
                        i6 += 5;
                        if (charAt < 32) {
                            break;
                        }
                        i3 = i;
                    }
                    int i8 = ((i7 & 1) != 0 ? ~(i7 >> 1) : i7 >> 1) + i4;
                    int i9 = i;
                    int i10 = 0;
                    int i11 = 0;
                    while (true) {
                        i2 = i9 + 1;
                        int charAt2 = str.charAt(i9) - '?';
                        i11 |= (charAt2 & 31) << i10;
                        i10 += 5;
                        if (charAt2 < 32) {
                            break;
                        }
                        i9 = i2;
                    }
                    int i12 = i11 >> 1;
                    if ((i11 & 1) != 0) {
                        i12 = ~i12;
                    }
                    i5 += i12;
                    arrayList3.add(new LatLng(((double) i8) / 100000.0d, ((double) i5) / 100000.0d));
                    i4 = i8;
                    i3 = i2;
                    tripDetailsActivity5 = tripDetailsActivity5;
                }
                tripDetailsActivity2 = tripDetailsActivity5;
                Iterator it2 = arrayList3.iterator();
                while (it2.hasNext()) {
                    polylineOptions.add((LatLng) it2.next());
                }
            } else {
                tripDetailsActivity2 = tripDetailsActivity5;
                ArrayList<StopSequence> arrayList4 = next.intermediateStops;
                if (arrayList4 != null) {
                    Iterator<StopSequence> it3 = arrayList4.iterator();
                    while (it3.hasNext()) {
                        StopSequence next2 = it3.next();
                        int indexOf = next.intermediateStops.indexOf(next2);
                        Stop stop = next2.getStop();
                        LatLng latLng3 = new LatLng(stop.getStop_lat(), stop.getStop_lon());
                        polylineOptions.add(latLng3);
                        if (!(indexOf == 0 || indexOf == next.intermediateStops.size() - 1)) {
                            tripDetailsActivity2.l.a(new MarkerOptions().position(latLng3).title(stop.getStop_name()).icon(BitmapDescriptorFactory.fromResource(tripDetailsActivity2.i0())));
                        }
                    }
                } else {
                    tripDetailsActivity = tripDetailsActivity2;
                    polylineOptions.add(new LatLng(next.from_lat, next.from_lon));
                    polylineOptions.add(new LatLng(next.to_lat, next.to_lon));
                    e44 e443 = tripDetailsActivity.l;
                    Objects.requireNonNull(e443);
                    new Polyline(e443.f924a.U2(polylineOptions)).setVisible(true);
                    arrayList2.add(new LatLng(next.from_lat, next.from_lon));
                    arrayList2.add(new LatLng(next.to_lat, next.to_lon));
                }
            }
            tripDetailsActivity = tripDetailsActivity2;
            e44 e4432 = tripDetailsActivity.l;
            Objects.requireNonNull(e4432);
            try {
                new Polyline(e4432.f924a.U2(polylineOptions)).setVisible(true);
                arrayList2.add(new LatLng(next.from_lat, next.from_lon));
                arrayList2.add(new LatLng(next.to_lat, next.to_lon));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        TripDetailsActivity tripDetailsActivity6 = this.f426a;
        e44 e444 = tripDetailsActivity6.l;
        if (e444 != null) {
            int dimension = (int) tripDetailsActivity6.getResources().getDimension(R.dimen.detail_map_padding);
            if (arrayList2.size() != 0) {
                e444.j(new ch1(arrayList2, e444, dimension));
            }
        }
        e44 e445 = this.f426a.l;
        if (e445 != null) {
            vn.V0(e445);
        }
        MapCustomMyLocation mapCustomMyLocation = (MapCustomMyLocation) this.f426a.findViewById(R.id.home_map_custom_my_loc);
        mapCustomMyLocation.setMap(this.f426a.l);
        mapCustomMyLocation.setOnClickListener(new a());
    }
}
