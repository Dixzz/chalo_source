package defpackage;

import app.zophop.alarm.SubscriberService;
import defpackage.yj1;

/* renamed from: fv  reason: default package */
/* compiled from: SubscriberService */
public class fv implements yj1.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SubscriberService f1173a;

    public fv(SubscriberService subscriberService) {
        this.f1173a = subscriberService;
    }

    @Override // defpackage.yj1.a
    public void a(dk1 dk1) {
        SubscriberService subscriberService = this.f1173a;
        int i = SubscriberService.q;
        subscriberService.k("DatabaseError-Streams");
        this.f1173a.i(false);
    }
}
