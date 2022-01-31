package defpackage;

import app.zophop.ui.fragments.NearbyStopsScreenMapFragment;

/* renamed from: jv0  reason: default package */
/* compiled from: NearbyStopsScreenMapFragment */
public class jv0 implements g44 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NearbyStopsScreenMapFragment f1985a;

    public jv0(NearbyStopsScreenMapFragment nearbyStopsScreenMapFragment) {
        this.f1985a = nearbyStopsScreenMapFragment;
    }

    @Override // defpackage.g44
    public void a(e44 e44) {
        this.f1985a.i.setGoogleMap(e44);
        this.f1985a.i.setVisibility(0);
        this.f1985a.j.setMarkerVisibility(true);
    }
}
