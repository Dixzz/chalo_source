package defpackage;

import app.zophop.models.DataInfo;
import app.zophop.models.LiveRouteData;
import app.zophop.ui.activities.RouteDetailsActivity;
import defpackage.mt0;
import java.util.List;

/* renamed from: nf0  reason: default package */
/* compiled from: RouteDetailsActivity */
public class nf0 implements ji1<Object, String> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RouteDetailsActivity f2545a;

    public nf0(RouteDetailsActivity routeDetailsActivity) {
        this.f2545a = routeDetailsActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.ji1
    public void a(String str) {
        String str2 = str;
        LiveRouteData liveRouteData = this.f2545a.I;
        if (liveRouteData != null) {
            liveRouteData.setFirebaseResponse(mt0.h.FAILED);
            jz5.b().i(this.f2545a.I);
        }
        b00 b00 = b00.f358a;
        hj1.Q0(str2, b00.a());
    }

    @Override // defpackage.ji1
    public void onSuccess(Object obj) {
        RouteDetailsActivity routeDetailsActivity = this.f2545a;
        List<DataInfo> list = (List) obj;
        routeDetailsActivity.Y = list;
        if (routeDetailsActivity.I != null) {
            routeDetailsActivity.z0(list);
        }
    }
}
