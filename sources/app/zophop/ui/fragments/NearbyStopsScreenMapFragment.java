package app.zophop.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import app.zophop.utilities.external.mapUtils.MySupportMapFragmentOld;

public class NearbyStopsScreenMapFragment extends MySupportMapFragmentOld {
    public ib1 i;
    public hb1 j;

    @Override // app.zophop.utilities.external.mapUtils.MySupportMapFragmentOld, com.google.android.gms.maps.MapFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.i = new ib1(getActivity());
        this.j = new hb1(getActivity());
        this.h.addView(this.i);
        this.h.addView(this.j);
        e(new jv0(this));
        return this.h;
    }
}
