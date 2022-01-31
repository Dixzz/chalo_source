package defpackage;

import app.zophop.pubsub.eventbus.events.LiveRouteDetailsEvent;
import defpackage.n00;

/* renamed from: t40  reason: default package */
/* compiled from: RouteFeature */
public class t40 implements n00.z0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f3306a;

    public t40(v40 v40, String str) {
        this.f3306a = str;
    }

    @Override // defpackage.n00.z0
    public void a(dk1 dk1) {
        jz5.b().i(new LiveRouteDetailsEvent(ad1.FAILED, this.f3306a, null));
    }
}
