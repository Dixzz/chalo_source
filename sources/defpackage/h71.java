package defpackage;

import app.zophop.models.City;
import com.google.android.gms.maps.model.LatLng;
import defpackage.xt;

/* renamed from: h71  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class h71 implements Runnable {
    public final /* synthetic */ d81 f;

    public /* synthetic */ h71(d81 d81) {
        this.f = d81;
    }

    public final void run() {
        d81 d81 = this.f;
        n86.e(d81, "this$0");
        xt.t1 t1Var = xt.f3961a;
        LatLng h = t1Var.B().h();
        if (d81.o(h)) {
            City d = t1Var.k().d();
            n86.c(d);
            h = d.getCenter();
        }
        n86.c(h);
        d81.q(h);
    }
}
