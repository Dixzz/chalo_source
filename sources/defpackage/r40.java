package defpackage;

import app.zophop.pubsub.eventbus.events.LiveRouteDetailsListEvent;
import defpackage.n00;

/* renamed from: r40  reason: default package */
/* compiled from: RouteFeature */
public class r40 implements n00.z0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f3037a;

    public r40(v40 v40, String str) {
        this.f3037a = str;
    }

    @Override // defpackage.n00.z0
    public void a(dk1 dk1) {
        jz5.b().i(new LiveRouteDetailsListEvent(this.f3037a, ad1.FAILED, null));
    }
}
