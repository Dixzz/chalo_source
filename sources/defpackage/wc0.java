package defpackage;

import app.zophop.models.DataInfo;
import app.zophop.ui.activities.BusEtaFrequencyActivity;
import defpackage.mt0;
import java.util.ArrayList;
import java.util.List;

/* renamed from: wc0  reason: default package */
/* compiled from: BusEtaFrequencyActivity */
public class wc0 implements ji1<Object, String> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BusEtaFrequencyActivity f3760a;

    public wc0(BusEtaFrequencyActivity busEtaFrequencyActivity) {
        this.f3760a = busEtaFrequencyActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.ji1
    public void a(String str) {
        BusEtaFrequencyActivity.G.setFirebaseResponse(mt0.h.FAILED);
        b00 b00 = b00.f358a;
        hj1.Q0(str, b00.a());
    }

    @Override // defpackage.ji1
    public void onSuccess(Object obj) {
        if (BusEtaFrequencyActivity.G != null) {
            ArrayList arrayList = new ArrayList();
            BusEtaFrequencyActivity.G.clearStreams();
            for (DataInfo dataInfo : (List) obj) {
                if (this.f3760a.o0(dataInfo)) {
                    arrayList.add(dataInfo);
                    BusEtaFrequencyActivity.G.addStreamInfo(dataInfo);
                }
            }
            if (arrayList.size() <= 0 || !vn.K0(this.f3760a)) {
                BusEtaFrequencyActivity.G.setFirebaseResponse(mt0.h.FAILED);
            } else {
                BusEtaFrequencyActivity.G.setFirebaseResponse(mt0.h.SUCCESS);
            }
        }
    }
}
