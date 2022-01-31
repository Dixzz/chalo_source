package defpackage;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import app.zophop.models.LocationTripRequest;
import app.zophop.models.StopTripRequest;
import app.zophop.models.TripRequest;
import app.zophop.ui.fragments.ResultFragment;
import java.util.List;

/* renamed from: ck0  reason: default package */
/* compiled from: ResultsPageAdapter */
public class ck0 extends ag1 {
    public final Context f;
    public final List<l90> g;
    public final TripRequest h;

    public ck0(FragmentManager fragmentManager, Context context, List<l90> list, TripRequest tripRequest) {
        super(fragmentManager);
        this.f = context;
        this.g = list;
        this.h = tripRequest;
    }

    @Override // defpackage.xf1
    public int a(int i, boolean z) {
        return 0;
    }

    @Override // defpackage.ro
    public int d() {
        return this.g.size();
    }

    @Override // defpackage.ro
    public CharSequence e(int i) {
        return this.f.getString(this.g.get(i).get_resId()).toUpperCase();
    }

    @Override // defpackage.ag1
    public Fragment l(int i) {
        Fragment fragment;
        l90 l90 = this.g.get(i);
        TripRequest tripRequest = this.h;
        int i2 = ResultFragment.q;
        Bundle bundle = new Bundle();
        if (l90.equals(l90.ALL_TRANSIT)) {
            fragment = new dt0();
        } else if (l90.equals(l90.RECOMMENDED)) {
            fragment = new zv0();
        } else if (l90.equals(l90.CAB)) {
            fragment = new vt0();
        } else if (l90.equals(l90.CAB_AUTO)) {
            fragment = new vt0();
        } else if (l90.equals(l90.OTHER)) {
            fragment = new zv0();
        } else if (l90.equals(l90.DIRECT_BUSES) || l90.equals(l90.CONNECTING)) {
            fragment = new rw0();
        } else {
            fragment = new ResultFragment();
        }
        bundle.putString("extra:tabItem", l90.name());
        bundle.putString("extra:request", tripRequest.toJson());
        if (tripRequest instanceof LocationTripRequest) {
            bundle.putString("extra:requestType", "extra:locationTripRequest");
        } else if (tripRequest instanceof StopTripRequest) {
            bundle.putString("extra:requestType", "extra:stopTripRequest");
        }
        fragment.setArguments(bundle);
        return fragment;
    }
}
