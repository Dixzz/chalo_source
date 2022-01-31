package defpackage;

import app.zophop.models.EtaModel;
import app.zophop.models.Stop;
import app.zophop.models.VehicleInfo;
import app.zophop.ui.activities.BusEtaFrequencyActivity;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: yc0  reason: default package */
/* compiled from: BusEtaFrequencyActivity */
public class yc0 implements Runnable {
    public final /* synthetic */ Stop f;
    public final /* synthetic */ BusEtaFrequencyActivity g;

    /* renamed from: yc0$a */
    /* compiled from: BusEtaFrequencyActivity */
    public class a implements ji1<j10, String> {
        public a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.ji1
        public void a(String str) {
            yc0.this.g.u.setVisibility(0);
            yc0.this.g.p.setVisibility(8);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.ji1
        public void onSuccess(j10 j10) {
            j10 j102 = j10;
            List<i10> c = j102.c();
            Map<Integer, Long> l0 = BusEtaFrequencyActivity.l0(c, c.size());
            List<EtaModel> m0 = yc0.this.g.m0(c);
            List<i10> b = j102.b();
            List<VehicleInfo> k0 = BusEtaFrequencyActivity.k0(yc0.this.g, m0);
            LinkedHashMap linkedHashMap = new LinkedHashMap(b.size());
            BusEtaFrequencyActivity busEtaFrequencyActivity = yc0.this.g;
            if (!busEtaFrequencyActivity.z && busEtaFrequencyActivity.m.getSeatAvailability() != 0) {
                BusEtaFrequencyActivity busEtaFrequencyActivity2 = yc0.this.g;
                busEtaFrequencyActivity2.B = k0;
                busEtaFrequencyActivity2.t.post(busEtaFrequencyActivity2.s);
                yc0.this.g.z = true;
            }
            for (int i = 0; i < b.size(); i++) {
                linkedHashMap.put(Long.valueOf(b.get(i).c), ui1.R(b.get(i).e, b.get(i).f));
            }
            if (l0.size() == 0 && linkedHashMap.size() == 0) {
                yc0.this.g.u.setVisibility(0);
                yc0.this.g.p.setVisibility(8);
                return;
            }
            String.valueOf(true);
            yc0.this.g.u.setVisibility(8);
            yc0.this.g.p.setVisibility(0);
            yi0 yi0 = yc0.this.g.q;
            yi0.g = linkedHashMap;
            yi0.h = m0;
            yi0.notifyDataSetChanged();
            yc0.this.g.q.notifyDataSetChanged();
        }
    }

    public yc0(BusEtaFrequencyActivity busEtaFrequencyActivity, Stop stop) {
        this.g = busEtaFrequencyActivity;
        this.f = stop;
    }

    public void run() {
        if (this.f != null && BusEtaFrequencyActivity.G != null) {
            xt.f3961a.N().c(this.f, this.g.m.getRouteId(), BusEtaFrequencyActivity.G.getFirebaseStreams(), new a());
            BusEtaFrequencyActivity busEtaFrequencyActivity = this.g;
            busEtaFrequencyActivity.t.postDelayed(busEtaFrequencyActivity.r, 5000);
        }
    }
}
