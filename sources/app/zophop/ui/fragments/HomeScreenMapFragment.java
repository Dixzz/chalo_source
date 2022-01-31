package app.zophop.ui.fragments;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import app.zophop.R;
import app.zophop.models.City;
import app.zophop.models.LiveTripInfo;
import app.zophop.models.Stop;
import app.zophop.models.StreamInfo;
import app.zophop.models.TransitMode;
import app.zophop.models.http_response.SummaryResponse;
import app.zophop.pubsub.eventbus.events.BusSummaryResponseEvent;
import app.zophop.pubsub.eventbus.events.GeoFireEvent;
import com.firebase.geofire.GeoLocation;
import com.freshchat.consumer.sdk.beans.config.DefaultRefreshIntervals;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.razorpay.AnalyticsConstants;
import defpackage.gj1;
import defpackage.ut;
import defpackage.xt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import server.zophop.Constants;
import server.zophop.logging.LoggingConstants;
import server.zophop.models.GeoRealTimeInfo;
import server.zophop.models.Point;

/* compiled from: HomeScreenMapFragment.kt */
public final class HomeScreenMapFragment extends iv0 {
    public static final /* synthetic */ int U = 0;
    public boolean A;
    public String B;
    public List<LiveTripInfo> C;
    public Map<String, Marker> D;
    public Map<String, Bitmap> E;
    public BitmapDescriptor F;
    public Map<Marker, StreamInfo> G;
    public Map<Marker, Stop> H;
    public ib1 I;
    public float J;
    public Map<Marker, GeoRealTimeInfo> K;
    public boolean L;
    public boolean M;
    public long N;
    public boolean O;
    public long P;
    public long Q;
    public String R;
    public float S;
    public int T = -1;
    public final fd5<Boolean> i = nc5.d("showStopMarkerHomeScreen", xt.f3961a.t().b("showStopHomeScreen"));
    public final int j = 1;
    public final int k = 2;
    public final int l = 3;
    public final int m = 4;
    public final int n = 5;
    public final int o = 6;
    public final int p = 7;
    public final long q = 300;
    public final long r = Constants.THRESHOLD_TIMESTAMP;
    public final long s = 300;
    public final long t = DefaultRefreshIntervals.ACTIVE_CONV_MIN_FETCH_INTERVAL;
    public e80 u;
    public e44 v;
    public je1 w;
    public Handler x;
    public LatLng y;
    public double z;

    /* compiled from: HomeScreenMapFragment.kt */
    public enum a {
        BUS,
        STOP,
        FERRY
    }

    public final void e(String str, TransitMode transitMode, GeoRealTimeInfo geoRealTimeInfo) {
        Bitmap bitmap;
        if (transitMode == TransitMode.metro || transitMode == TransitMode.train || transitMode == TransitMode.monorail) {
            bitmap = vn.Z(transitMode, geoRealTimeInfo.getFromName() + " - " + ((Object) geoRealTimeInfo.getToName()), c());
        } else if (!ui1.Y() && !ui1.X()) {
            bitmap = vn.Z(transitMode, geoRealTimeInfo.getRouteName(), c());
        } else if (transitMode == TransitMode.bus) {
            bitmap = ut.a() ? vn.Z(transitMode, geoRealTimeInfo.getVehicleId(), c()) : BitmapFactory.decodeResource(getResources(), R.drawable.live_bg_bus_icon);
        } else {
            bitmap = transitMode == TransitMode.ferry ? BitmapFactory.decodeResource(getResources(), R.drawable.live_bg_ferry) : null;
        }
        Map<String, Bitmap> map = this.E;
        n86.c(map);
        map.put(str, bitmap);
    }

    public final void f() {
        Map<Marker, Stop> map = this.H;
        n86.c(map);
        for (Marker marker : map.keySet()) {
            marker.remove();
        }
        Map<Marker, Stop> map2 = this.H;
        n86.c(map2);
        map2.clear();
    }

    public final LatLng g() {
        je1 je1 = this.w;
        n86.c(je1);
        LatLng h = je1.h();
        e80 e80 = this.u;
        n86.c(e80);
        City d = e80.d();
        if (h != null) {
            n86.c(d);
            if (d.containsLocation(h)) {
                return h;
            }
        }
        n86.c(d);
        LatLng center = d.getCenter();
        n86.d(center, "{\n            currentCity!!.center\n        }");
        return center;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0021, code lost:
        if (r3 == false) goto L_0x0023;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void h() {
        /*
        // Method dump skipped, instructions count: 135
        */
        throw new UnsupportedOperationException("Method not decompiled: app.zophop.ui.fragments.HomeScreenMapFragment.h():void");
    }

    public final void i(String str) {
        Map<String, Marker> map = this.D;
        n86.c(map);
        if (map.containsKey(str)) {
            Map<String, Marker> map2 = this.D;
            n86.c(map2);
            Marker remove = map2.remove(str);
            Map<Marker, StreamInfo> map3 = this.G;
            n86.c(map3);
            map3.remove(remove);
            n86.c(remove);
            remove.remove();
        }
    }

    public final void j(GeoRealTimeInfo geoRealTimeInfo) {
        n86.c(geoRealTimeInfo);
        String routeName = geoRealTimeInfo.getRouteName();
        TransitMode transitMode = TransitMode.getTransitMode(geoRealTimeInfo.getMode());
        ed1 ed1 = new ed1("home screen live vehicles click", Long.MIN_VALUE);
        ed1.a("mode", transitMode.name());
        ed1.a("routeName", routeName);
        ed1.a("agency", geoRealTimeInfo.getAgencyName());
        ed1.a("hourOfEvent", n86.j("", Integer.valueOf(jh1.j(System.currentTimeMillis()))));
        xt.t1 t1Var = xt.f3961a;
        hj1.K0(ed1, "geoSpatialSrc", xt.y0 ? "geofire" : Constants.ELASTIC_SEARCH_BASIC_AUTH_USERNAME, ed1);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void k(com.google.android.gms.maps.model.LatLng r14, boolean r15) {
        /*
        // Method dump skipped, instructions count: 193
        */
        throw new UnsupportedOperationException("Method not decompiled: app.zophop.ui.fragments.HomeScreenMapFragment.k(com.google.android.gms.maps.model.LatLng, boolean):void");
    }

    @Override // defpackage.i44, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.A = false;
        this.S = y10.f;
        this.E = new HashMap();
        this.K = new HashMap();
        this.D = new HashMap();
        this.H = new HashMap();
        this.C = new ArrayList();
        xt.t1 t1Var = xt.f3961a;
        this.u = t1Var.k();
        this.w = t1Var.B();
        this.G = new HashMap();
        this.J = -1.0f;
        this.x = new Handler(new ir0(this));
        this.L = false;
        this.M = false;
        this.N = System.currentTimeMillis();
        Handler handler = this.x;
        n86.c(handler);
        handler.sendEmptyMessageDelayed(this.m, this.r);
        Handler handler2 = this.x;
        n86.c(handler2);
        handler2.sendEmptyMessageDelayed(this.o, this.r);
        Handler handler3 = this.x;
        n86.c(handler3);
        handler3.sendEmptyMessageDelayed(this.p, this.t);
    }

    @Override // defpackage.iv0, defpackage.i44, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        n86.e(layoutInflater, "inflater");
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.I = new ib1(c());
        wd1 wd1 = this.h;
        n86.c(wd1);
        wd1.addView(this.I);
        d(new jr0(this));
        return this.h;
    }

    public final void onEvent(BusSummaryResponseEvent busSummaryResponseEvent) {
        n86.e(busSummaryResponseEvent, "summaryResponseEvent");
        if (n86.a(busSummaryResponseEvent.getRequestId(), this.R)) {
            List<SummaryResponse> summaryResponseList = busSummaryResponseEvent.getSummaryResponseList();
            if (summaryResponseList != null) {
                f();
                for (SummaryResponse summaryResponse : summaryResponseList) {
                    Stop stop = summaryResponse.getStop();
                    LatLng latLong = stop.getLatLong();
                    e44 e44 = this.v;
                    if (!(e44 == null || vn.G(e44) == null)) {
                        n86.d(latLong, "latLng");
                        if (oo6.a(latLong.latitude, latLong.longitude, vn.G(this.v).latitude, vn.G(this.v).longitude) < y10.d) {
                            n86.d(stop, "stop");
                            if (this.F == null) {
                                this.F = BitmapDescriptorFactory.fromResource(R.drawable.bus_stop_home);
                            }
                            e44 e442 = this.v;
                            n86.c(e442);
                            Marker a2 = e442.a(new MarkerOptions().icon(this.F).position(stop.getLatLong()));
                            n86.d(a2, "_map!!.addMarker(MarkerO… .position(stop.latLong))");
                            a2.setTag(a.STOP);
                            Map<Marker, Stop> map = this.H;
                            n86.c(map);
                            map.put(a2, stop);
                            if (!this.M) {
                                this.Q = System.currentTimeMillis() - this.N;
                                this.M = true;
                            }
                            ed1 ed1 = new ed1("home screen stops shown on map", 3600000);
                            ed1.a("hourOfEvent", jh1.j(System.currentTimeMillis()) + "");
                            ed1.a("firstLoadTimeMillis", n86.j("", Long.valueOf(this.Q)));
                            xt.t1 t1Var = xt.f3961a;
                            hj1.K0(ed1, "geoSpatialSrc", xt.y0 ? "geofire" : Constants.ELASTIC_SEARCH_BASIC_AUTH_USERNAME, ed1);
                        }
                    }
                }
            }
            jz5.b().m(busSummaryResponseEvent);
        }
    }

    @Override // defpackage.i44, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        jz5 b = jz5.b();
        b.k(this, b.e, true, 0);
        if (this.v != null) {
            k(null, true);
        }
        e44 e44 = this.v;
        if (e44 != null) {
            c();
            vn.V0(e44);
        }
    }

    @Override // defpackage.i44, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        Handler handler = this.x;
        n86.c(handler);
        handler.removeCallbacksAndMessages(null);
        jz5.b().o(this);
        this.T = 0;
        if (this.B != null) {
            xt.f3961a.x().a(this.B);
            this.B = null;
        }
    }

    public final void onEvent(GeoFireEvent geoFireEvent) {
        String str;
        String str2;
        Marker marker;
        Bitmap bitmap;
        n86.e(geoFireEvent, "geoFireEvent");
        if (this.v != null && (str = this.B) != null && n86.a(str, geoFireEvent.getRequestId())) {
            LiveTripInfo cardInfo = geoFireEvent.getCardInfo();
            String id = cardInfo.getId();
            GeoLocation geoLocation = cardInfo.getGeoLocation();
            boolean z2 = geoFireEvent.getType() == GeoFireEvent.Type.EXITED;
            n86.d(cardInfo, "cardInfo");
            n86.d(id, AnalyticsConstants.KEY);
            n86.d(geoLocation, "geoLocation");
            List<LiveTripInfo> list = this.C;
            n86.c(list);
            Iterator<LiveTripInfo> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (n86.a(it.next().getId(), cardInfo.getId())) {
                        it.remove();
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!z2) {
                GeoLocation geoLocation2 = cardInfo.getGeoLocation();
                if (!vn.R0(Long.parseLong(String.valueOf(geoLocation2.map.get("time"))), Integer.parseInt(String.valueOf(geoLocation2.map.get("nextStopEta"))), true)) {
                    List<LiveTripInfo> list2 = this.C;
                    n86.c(list2);
                    list2.add(cardInfo);
                    Map<String, Marker> map = this.D;
                    n86.c(map);
                    if (!map.containsKey(id)) {
                        if (this.v != null) {
                            GeoRealTimeInfo geoRealTimeInfo = (GeoRealTimeInfo) hj1.s(id, GeoRealTimeInfo.class);
                            TransitMode transitMode = TransitMode.getTransitMode(geoRealTimeInfo.getMode());
                            String routeId = geoRealTimeInfo.getRouteId();
                            if (!ui1.Y() && !ui1.X() && vt.f3680a == ut.a.PRODUCTION) {
                                Map<String, Bitmap> map2 = this.E;
                                n86.c(map2);
                                if (!map2.containsKey(routeId)) {
                                    n86.d(routeId, LoggingConstants.ROUTE_ID);
                                    n86.d(transitMode, "mode");
                                    n86.d(geoRealTimeInfo, "realTimeInfo");
                                    e(routeId, transitMode, geoRealTimeInfo);
                                }
                                Map<String, Bitmap> map3 = this.E;
                                n86.c(map3);
                                bitmap = map3.get(routeId);
                            } else if (ut.a()) {
                                n86.d(routeId, LoggingConstants.ROUTE_ID);
                                n86.d(transitMode, "mode");
                                n86.d(geoRealTimeInfo, "realTimeInfo");
                                e(routeId, transitMode, geoRealTimeInfo);
                                Map<String, Bitmap> map4 = this.E;
                                n86.c(map4);
                                bitmap = map4.get(routeId);
                            } else if (transitMode == TransitMode.bus) {
                                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.live_bg_bus_icon);
                            } else {
                                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.live_bg_ferry);
                            }
                            MarkerOptions icon = new MarkerOptions().position(new LatLng(geoLocation.latitude, geoLocation.longitude)).icon(BitmapDescriptorFactory.fromBitmap(bitmap));
                            e44 e44 = this.v;
                            n86.c(e44);
                            marker = e44.a(icon);
                            if (transitMode == TransitMode.ferry) {
                                marker.setTag(a.FERRY);
                            } else if (transitMode == TransitMode.bus) {
                                marker.setTag(a.BUS);
                            }
                            Map<Marker, StreamInfo> map5 = this.G;
                            n86.c(map5);
                            String streamId = geoRealTimeInfo.getStreamId();
                            Map map6 = geoLocation.map;
                            long parseLong = Long.parseLong(map6.get("time").toString());
                            str2 = id;
                            StreamInfo streamInfo = new StreamInfo(streamId, Integer.parseInt(map6.get("nextStopEta").toString()), map6.get("nextStopId").toString(), new Point(geoLocation.latitude, geoLocation.longitude, parseLong, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE), parseLong);
                            if (map6.get("isHalted") != null) {
                                streamInfo.setHaltedStatus(Boolean.parseBoolean(map6.get("isHalted").toString()));
                            }
                            n86.d(streamInfo, "getStreamInfo(realTimeInfo.streamId, geoLocation)");
                            map5.put(marker, streamInfo);
                            Map<Marker, GeoRealTimeInfo> map7 = this.K;
                            n86.c(map7);
                            n86.d(marker, "marker");
                            n86.d(geoRealTimeInfo, "realTimeInfo");
                            map7.put(marker, geoRealTimeInfo);
                            if (!this.L) {
                                long currentTimeMillis = System.currentTimeMillis() - this.N;
                                this.P = currentTimeMillis;
                                this.L = true;
                                ed1 ed1 = new ed1("home screen live marker shown", Long.MIN_VALUE);
                                ed1.a("hourOfEvent", n86.j("", Integer.valueOf(jh1.j(System.currentTimeMillis()))));
                                ed1.a("firstLoadTimeMillis", n86.j("", Long.valueOf(currentTimeMillis)));
                                xt.t1 t1Var = xt.f3961a;
                                hj1.K0(ed1, "geoSpatialSrc", xt.y0 ? "geofire" : Constants.ELASTIC_SEARCH_BASIC_AUTH_USERNAME, ed1);
                            }
                        } else {
                            str2 = id;
                            marker = null;
                        }
                        if (marker != null) {
                            Map<String, Marker> map8 = this.D;
                            n86.c(map8);
                            map8.put(str2, marker);
                        }
                    } else {
                        Map<String, Marker> map9 = this.D;
                        n86.c(map9);
                        gj1.a(map9.get(id), new LatLng(geoLocation.latitude, geoLocation.longitude), gj1.a.LINEAR, 20.0f);
                    }
                    this.O = true;
                    return;
                }
            }
            i(id);
        }
    }
}
