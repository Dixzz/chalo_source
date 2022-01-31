package defpackage;

import app.zophop.models.Stop;
import defpackage.ii1;

/* renamed from: uw0  reason: default package */
/* compiled from: TripFragment */
public class uw0 implements ji1<j10, String> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Stop f3559a;
    public final /* synthetic */ tw0 b;

    public uw0(tw0 tw0, Stop stop) {
        this.b = tw0;
        this.f3559a = stop;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.ji1
    public void a(String str) {
        tw0 tw0 = this.b;
        Stop stop = this.f3559a;
        int i = tw0.z;
        tw0.a(stop);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.ji1
    public void onSuccess(j10 j10) {
        Stop stop;
        j10 j102 = j10;
        if (this.b.getActivity() != null && this.b.isAdded()) {
            tw0 tw0 = this.b;
            if (!tw0.r) {
                tw0.a(this.f3559a);
            } else if (!x61.s(j102.a()) || (stop = this.b.p) == null || !stop.equals(this.f3559a)) {
                this.b.a(this.f3559a);
            } else {
                ii1.a aVar = new ii1.a();
                aVar.f1519a = j102.a();
                aVar.d = ii1.a.EnumC0027a.SUCCESS;
                aVar.b = j102.c();
                this.b.l.a(this.f3559a, aVar);
                this.b.l.notifyDataSetChanged();
                this.b.n.setVisibility(0);
                tw0 tw02 = this.b;
                ui1.p0(tw02.k, tw02.j, tw02.p.getName(), false, "trip activity", "eta seen", String.valueOf(this.b.t.getLastSeenInfo().getLastSeen()), this.b.t.getLastSeenInfo().getVehicleNumber(), null);
                ui1.t0("realTimeEtaInfoSeen");
            }
        }
    }
}
