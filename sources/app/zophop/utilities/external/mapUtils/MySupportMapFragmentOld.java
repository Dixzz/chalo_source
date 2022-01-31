package app.zophop.utilities.external.mapUtils;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.MapFragment;

public class MySupportMapFragmentOld extends MapFragment {
    public View g;
    public wd1 h;

    public View getView() {
        return this.g;
    }

    @Override // com.google.android.gms.maps.MapFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View b = this.f.b(layoutInflater, viewGroup, bundle);
        b.setClickable(true);
        this.g = b;
        wd1 wd1 = new wd1(getActivity());
        this.h = wd1;
        wd1.addView(this.g);
        return this.h;
    }
}
