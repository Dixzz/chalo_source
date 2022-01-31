package defpackage;

import app.zophop.ui.activities.TripsSchedulesDirectionActivity;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: ah0  reason: default package */
/* compiled from: TripsSchedulesDirectionActivity */
public class ah0 implements ji1<Object, String> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TripsSchedulesDirectionActivity f163a;

    public ah0(TripsSchedulesDirectionActivity tripsSchedulesDirectionActivity) {
        this.f163a = tripsSchedulesDirectionActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.ji1
    public void a(String str) {
        b00 b00 = b00.f358a;
        hj1.Q0(str, b00.a());
    }

    @Override // defpackage.ji1
    public void onSuccess(Object obj) {
        Map map = (Map) obj;
        this.f163a.F = new HashMap();
        this.f163a.F.clear();
        for (String str : map.keySet()) {
            j10 g = ii1.g((List) map.get(str));
            if (g.a() < 7200) {
                this.f163a.F.put(str, g);
            } else if (g.b().size() != 0) {
                this.f163a.F.put(str, g);
            }
        }
        TripsSchedulesDirectionActivity tripsSchedulesDirectionActivity = this.f163a;
        if (tripsSchedulesDirectionActivity.H) {
            tripsSchedulesDirectionActivity.H = false;
            tripsSchedulesDirectionActivity.l0(tripsSchedulesDirectionActivity.n, tripsSchedulesDirectionActivity.m);
        }
    }
}
