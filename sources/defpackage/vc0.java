package defpackage;

import app.zophop.models.DataInfo;
import app.zophop.models.EtaModel;
import app.zophop.models.VehicleInfo;
import app.zophop.ui.activities.BusEtaFrequencyActivity;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: vc0  reason: default package */
/* compiled from: BusEtaFrequencyActivity */
public class vc0 implements ji1<Object, String> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BusEtaFrequencyActivity f3630a;

    public vc0(BusEtaFrequencyActivity busEtaFrequencyActivity) {
        this.f3630a = busEtaFrequencyActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.ji1
    public void a(String str) {
        b00 b00 = b00.f358a;
        hj1.Q0(str, b00.a());
    }

    @Override // defpackage.ji1
    public void onSuccess(Object obj) {
        this.f3630a.v = new ArrayList();
        List<DataInfo> list = (List) obj;
        this.f3630a.v = list;
        j10 h = ii1.h(list, BusEtaFrequencyActivity.G.getFirebaseStreams(), this.f3630a.n.getLatLong());
        List<i10> c = h.c();
        Map<Integer, Long> l0 = BusEtaFrequencyActivity.l0(c, c.size());
        List<EtaModel> m0 = this.f3630a.m0(c);
        List<i10> b = h.b();
        List<VehicleInfo> k0 = BusEtaFrequencyActivity.k0(this.f3630a, m0);
        BusEtaFrequencyActivity busEtaFrequencyActivity = this.f3630a;
        if (!busEtaFrequencyActivity.z && busEtaFrequencyActivity.m.getSeatAvailability() != 0) {
            BusEtaFrequencyActivity busEtaFrequencyActivity2 = this.f3630a;
            busEtaFrequencyActivity2.B = k0;
            busEtaFrequencyActivity2.t.post(busEtaFrequencyActivity2.s);
            this.f3630a.z = true;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(b.size());
        for (int i = 0; i < b.size(); i++) {
            linkedHashMap.put(Long.valueOf(b.get(i).c), ui1.R(b.get(i).e, b.get(i).f));
        }
        if (l0.size() == 0 && linkedHashMap.size() == 0) {
            this.f3630a.u.setVisibility(0);
            this.f3630a.p.setVisibility(8);
            return;
        }
        this.f3630a.u.setVisibility(8);
        this.f3630a.p.setVisibility(0);
        yi0 yi0 = this.f3630a.q;
        yi0.g = linkedHashMap;
        yi0.h = m0;
        yi0.notifyDataSetChanged();
        this.f3630a.q.notifyDataSetChanged();
    }
}
