package defpackage;

import app.zophop.models.TransitMode;
import app.zophop.ui.activities.NearbyStopsActivity;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

/* renamed from: ve0  reason: default package */
/* compiled from: NearbyStopsActivity */
public class ve0 implements ci1<TransitMode> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NearbyStopsActivity f3639a;

    public ve0(NearbyStopsActivity nearbyStopsActivity) {
        this.f3639a = nearbyStopsActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.ci1
    public void a(TransitMode transitMode) {
        TransitMode transitMode2 = transitMode;
        NearbyStopsActivity nearbyStopsActivity = this.f3639a;
        if (nearbyStopsActivity.l != null) {
            nearbyStopsActivity.X = false;
            if (nearbyStopsActivity.J) {
                nearbyStopsActivity.s.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
            }
            if (this.f3639a.o.get(transitMode2).b == null) {
                NearbyStopsActivity nearbyStopsActivity2 = this.f3639a;
                nearbyStopsActivity2.o0(transitMode2, NearbyStopsActivity.h0(nearbyStopsActivity2));
            }
            this.f3639a.r0(true, null);
        }
    }
}
