package defpackage;

import app.zophop.pubsub.eventbus.events.CityResponseEvent;
import defpackage.yj1;

/* renamed from: y70  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class y70 implements yj1.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b80 f4012a;
    public final /* synthetic */ long b;

    public /* synthetic */ y70(b80 b80, long j) {
        this.f4012a = b80;
        this.b = j;
    }

    @Override // defpackage.yj1.a
    public final void a(dk1 dk1) {
        b80 b80 = this.f4012a;
        n86.e(b80, "this$0");
        dk1.toString();
        if (xt.f3961a.v().f) {
            vn.e("cityMetaData volley", vn.K0(b80.f394a));
        }
        CityResponseEvent cityResponseEvent = new CityResponseEvent();
        cityResponseEvent.success = false;
        jz5.b().i(cityResponseEvent);
    }
}
