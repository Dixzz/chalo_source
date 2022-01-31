package defpackage;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import app.zophop.models.LiveRouteData;
import app.zophop.models.LocationUpdateInfo;
import app.zophop.models.Stop;
import app.zophop.models.StreamInfo;
import app.zophop.models.TransitMode;
import app.zophop.utilities.external.mapUtils.MySupportMapFragmentOld;
import com.freshchat.consumer.sdk.beans.config.DefaultRefreshIntervals;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.R;
import com.google.maps.android.ui.RotationLayout;
import defpackage.e44;
import defpackage.gj1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import server.zophop.models.Point;

/* renamed from: ev0  reason: default package */
/* compiled from: LineMapFragment */
public abstract class ev0 extends MySupportMapFragmentOld implements e44.b, e44.f, e44.e {
    public static final /* synthetic */ int v = 0;
    public Map<Marker, Integer> i;
    public Map<String, Marker> j;
    public Map<String, Point> k;
    public fi1<String> l;
    public String m;
    public final List<Marker> n = new ArrayList();
    public e44 o;
    public HashSet<MarkerOptions> p;
    public HashMap<Marker, StreamInfo> q;
    public boolean r = false;
    public LiveRouteData s;
    public Marker t = null;
    public int u;

    public final double f(double d, double d2, double d3, double d4) {
        double radians = Math.toRadians(d);
        double radians2 = Math.toRadians(d2);
        double radians3 = Math.toRadians(d3);
        double radians4 = Math.toRadians(d4) - radians2;
        return (Math.toDegrees(Math.atan2(Math.cos(radians3) * Math.sin(radians4), (Math.sin(radians3) * Math.cos(radians)) - (Math.cos(radians4) * (Math.cos(radians3) * Math.sin(radians))))) + 360.0d) % 360.0d;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:24:0x0040 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r10v3, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r10v4, types: [java.util.List] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.maps.model.LatLng g(com.google.android.gms.maps.model.LatLng r9, java.lang.String r10) {
        /*
        // Method dump skipped, instructions count: 129
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ev0.g(com.google.android.gms.maps.model.LatLng, java.lang.String):com.google.android.gms.maps.model.LatLng");
    }

    public abstract int h();

    public final Marker i(String str, Point point, StreamInfo streamInfo) {
        int i2;
        int i3;
        boolean z = false;
        Stop stop = null;
        if (!this.l.b.containsKey(str)) {
            LatLng g = g(new LatLng(point.getLatitude(), point.getLongitude()), k());
            if (streamInfo != null) {
                stop = n(streamInfo.getNextStopId());
            }
            if (g == null) {
                g = stop != null ? stop.getLatLong() : m(h() - 1).getLatLong();
            }
            float f = (float) f(point.getLatitude(), point.getLongitude(), g.latitude, g.longitude);
            if (streamInfo == null) {
                i3 = 0;
            } else {
                i3 = (int) ((System.currentTimeMillis() - streamInfo.getTimeStamp()) / DefaultRefreshIntervals.ACTIVE_CONV_MAX_FETCH_INTERVAL);
            }
            if (streamInfo != null && streamInfo.isHalted()) {
                z = true;
            }
            MarkerOptions zIndex = new MarkerOptions().icon(BitmapDescriptorFactory.fromBitmap(vn.F(getActivity(), f, i3, z))).position(new LatLng(point.getLatitude(), point.getLongitude())).zIndex(1.0f);
            if (((int) Math.floor((double) i3)) >= ui1.x(xt.f3961a.k().d().getName()) || z) {
                zIndex.anchor(0.15f, 0.7f);
            } else {
                zIndex.anchor(0.5f, 0.5f);
            }
            fi1<String> fi1 = this.l;
            fi1.b.put(str, fi1.f1127a.a(zIndex));
            return this.l.b.get(str);
        }
        Marker marker = this.l.b.get(str);
        LatLng g2 = g(new LatLng(point.getLatitude(), point.getLongitude()), k());
        if (streamInfo != null) {
            stop = n(streamInfo.getNextStopId());
        }
        if (g2 == null) {
            g2 = stop != null ? stop.getLatLong() : m(h() - 1).getLatLong();
        }
        float f2 = (float) f(point.getLatitude(), point.getLongitude(), g2.latitude, g2.longitude);
        if (streamInfo == null) {
            i2 = 0;
        } else {
            i2 = (int) ((System.currentTimeMillis() - streamInfo.getTimeStamp()) / DefaultRefreshIntervals.ACTIVE_CONV_MAX_FETCH_INTERVAL);
        }
        if (streamInfo != null && streamInfo.isHalted()) {
            z = true;
        }
        marker.setIcon(BitmapDescriptorFactory.fromBitmap(vn.F(getActivity(), f2, i2, z)));
        return marker;
    }

    public abstract TransitMode j();

    public abstract String k();

    public int l(Marker marker) {
        if (this.i.containsKey(marker)) {
            return this.i.get(marker).intValue();
        }
        return -1;
    }

    public abstract Stop m(int i2);

    public abstract Stop n(String str);

    public abstract void o(Bundle bundle);

    @Override // com.google.android.gms.maps.MapFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.i = new HashMap();
        this.j = new HashMap();
        this.q = new HashMap<>();
        this.p = new HashSet<>();
        Activity activity = getActivity();
        qz4 qz4 = new qz4(activity.getResources());
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(activity).inflate(R.layout.text_bubble, (ViewGroup) null);
        TextView textView = (TextView) ((RotationLayout) viewGroup.getChildAt(0)).findViewById(R.id.text);
        qz4.c = -1;
        viewGroup.setBackgroundDrawable(qz4);
        Rect rect = new Rect();
        qz4.getPadding(rect);
        viewGroup.setPadding(rect.left, rect.top, rect.right, rect.bottom);
        int i2 = R.style.Bubble_TextAppearance_Dark;
        if (textView != null) {
            textView.setTextAppearance(activity, i2);
        }
        o(getArguments());
        this.k = new HashMap();
    }

    @Override // app.zophop.utilities.external.mapUtils.MySupportMapFragmentOld, com.google.android.gms.maps.MapFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        e(new dv0(this));
        return onCreateView;
    }

    public void onEventMainThread(LiveRouteData liveRouteData) {
        jz5.b().m(this);
        if (this.m.equals(liveRouteData.getRoute().getRouteId())) {
            HashMap hashMap = new HashMap();
            if (liveRouteData.isLiveFeedProvider()) {
                List<LocationUpdateInfo> liveFeedLocationsList = liveRouteData.getLiveFeedLocationsList();
                for (Marker marker : this.n) {
                    marker.remove();
                }
                for (LocationUpdateInfo locationUpdateInfo : liveFeedLocationsList) {
                    LatLng latLng = locationUpdateInfo.getLatLng();
                    vn.Z(j(), getString(app.zophop.R.string.marker_live), getActivity());
                    MarkerOptions position = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(app.zophop.R.drawable.live_bus2)).position(latLng);
                    e44 e44 = this.o;
                    if (e44 != null) {
                        this.n.add(e44.a(position));
                    } else {
                        this.p.add(position);
                    }
                }
            }
            for (StreamInfo streamInfo : liveRouteData.getFirebaseStreams()) {
                hashMap.put(streamInfo.getStreamId(), streamInfo.getPoint());
            }
            Map<String, Point> map = this.k;
            if (this.o != null) {
                for (String str : map.keySet()) {
                    if (!hashMap.containsKey(str) && this.l.b.containsKey(str)) {
                        Marker i2 = i(str, map.get(str), liveRouteData.getLiveStream(str));
                        this.q.remove(i2);
                        i2.remove();
                        fi1<String> fi1 = this.l;
                        if (fi1.b.containsKey(str)) {
                            fi1.b.get(str).remove();
                            fi1.b.remove(str);
                        }
                    }
                }
            }
            this.k = hashMap;
            this.s = liveRouteData;
            p(liveRouteData);
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 123 && iArr.length > 0 && iArr[0] == 0) {
            this.r = true;
            e44 e44 = this.o;
            if (e44 != null) {
                e44.h(true);
            }
        }
    }

    @Override // com.google.android.gms.maps.MapFragment
    public void onResume() {
        super.onResume();
        boolean T = ui1.T(getActivity(), "android.permission.ACCESS_FINE_LOCATION");
        this.r = T;
        e44 e44 = this.o;
        if (e44 != null) {
            e44.h(T);
        }
    }

    @Override // com.google.android.gms.maps.MapFragment
    public void onStart() {
        super.onStart();
        jz5 b = jz5.b();
        b.k(this, b.e, true, 0);
    }

    @Override // com.google.android.gms.maps.MapFragment
    public void onStop() {
        super.onStop();
        jz5.b().o(this);
    }

    public final void p(LiveRouteData liveRouteData) {
        if (this.o != null) {
            for (String str : this.k.keySet()) {
                Point point = this.k.get(str);
                Marker i2 = i(str, point, liveRouteData.getLiveStream(str));
                this.q.put(i2, liveRouteData.getLiveStream(str));
                gj1.a(i2, new LatLng(point.getLatitude(), point.getLongitude()), gj1.a.LINEAR, 20.0f);
            }
        }
    }
}
