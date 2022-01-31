package defpackage;

import app.zophop.models.autoCabBooking.BookingDetails;
import app.zophop.pubsub.eventbus.events.CabDestinationUpdatedEvent;
import com.razorpay.AnalyticsConstants;
import defpackage.n00;

/* renamed from: w00  reason: default package */
/* compiled from: CabsFeature */
public class w00 implements n00.z0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BookingDetails f3701a;
    public final /* synthetic */ mf1 b;
    public final /* synthetic */ CabDestinationUpdatedEvent.CabDestinationStatus c;
    public final /* synthetic */ u00 d;

    public w00(u00 u00, BookingDetails bookingDetails, mf1 mf1, CabDestinationUpdatedEvent.CabDestinationStatus cabDestinationStatus) {
        this.d = u00;
        this.f3701a = bookingDetails;
        this.b = mf1;
        this.c = cabDestinationStatus;
    }

    @Override // defpackage.n00.z0
    public void a(dk1 dk1) {
        u00.d(this.d, AnalyticsConstants.FAILURE, "network error", this.f3701a, this.b.b);
        xt.f3961a.f().c = false;
        this.d.m(this.b.b);
        this.d.o(ad1.FAILED, this.b, this.c);
    }
}
