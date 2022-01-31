package defpackage;

import app.zophop.pubsub.eventbus.events.FirebaseEtaUpdateEvent;
import app.zophop.pubsub.eventbus.events.FirebaseRouteUpdateEvent;
import defpackage.n00;

/* renamed from: r10  reason: default package */
/* compiled from: FirebasePollingRequestHandler */
public class r10 implements n00.z0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f3024a;
    public final /* synthetic */ t10 b;

    public r10(t10 t10, String str) {
        this.b = t10;
        this.f3024a = str;
    }

    @Override // defpackage.n00.z0
    public void a(dk1 dk1) {
        t10 t10 = this.b;
        ad1 ad1 = ad1.FAILED;
        t10.a(t10, ad1, t10.e, this.f3024a);
        if (this.b.e.equalsIgnoreCase("route")) {
            FirebaseRouteUpdateEvent firebaseRouteUpdateEvent = new FirebaseRouteUpdateEvent();
            firebaseRouteUpdateEvent.set_responseType(ad1);
            jz5.b().g(firebaseRouteUpdateEvent);
        } else if (this.b.e.equalsIgnoreCase("eta")) {
            FirebaseEtaUpdateEvent firebaseEtaUpdateEvent = new FirebaseEtaUpdateEvent();
            firebaseEtaUpdateEvent.set_responseType(ad1);
            jz5.b().g(firebaseEtaUpdateEvent);
        }
        t10 t102 = this.b;
        if (t102.g) {
            t102.d.removeCallbacks(t102.b);
        }
    }
}
