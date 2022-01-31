package defpackage;

import app.zophop.R;
import app.zophop.ui.activities.TripPlanningActivity;
import com.google.android.gms.maps.MapFragment;

/* renamed from: eg0  reason: default package */
/* compiled from: TripPlanningActivity */
public class eg0 implements g44 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TripPlanningActivity f968a;

    public eg0(TripPlanningActivity tripPlanningActivity) {
        this.f968a = tripPlanningActivity;
    }

    @Override // defpackage.g44
    public void a(e44 e44) {
        MapFragment mapFragment = (MapFragment) this.f968a.getFragmentManager().findFragmentById(R.id.map);
        this.f968a.q = e44;
        e44.f().d(false);
        this.f968a.q.f().b(false);
        this.f968a.q.g(hd3.k2(xt.f3961a.k().d().getCenter(), 10.0f));
        this.f968a.s0();
        e44 e442 = this.f968a.q;
        if (e442 != null) {
            vn.V0(e442);
        }
    }
}
