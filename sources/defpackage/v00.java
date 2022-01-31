package defpackage;

import app.zophop.models.autoCabBooking.BookingDetails;
import app.zophop.pubsub.eventbus.events.CabDestinationUpdatedEvent;
import com.razorpay.AnalyticsConstants;
import defpackage.xt;
import defpackage.yj1;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: v00  reason: default package */
/* compiled from: CabsFeature */
public class v00 implements yj1.b<JSONObject> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BookingDetails f3580a;
    public final /* synthetic */ mf1 b;
    public final /* synthetic */ CabDestinationUpdatedEvent.CabDestinationStatus c;
    public final /* synthetic */ u00 d;

    public v00(u00 u00, BookingDetails bookingDetails, mf1 mf1, CabDestinationUpdatedEvent.CabDestinationStatus cabDestinationStatus) {
        this.d = u00;
        this.f3580a = bookingDetails;
        this.b = mf1;
        this.c = cabDestinationStatus;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.yj1.b
    public void a(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        xt.t1 t1Var = xt.f3961a;
        t1Var.f().c = false;
        hj1.S0("response success ", jSONObject2);
        try {
            ad1 responseType = this.d.d.getResponseType(jSONObject2);
            ad1 ad1 = ad1.SUCCESS;
            if (responseType.equals(ad1)) {
                BookingDetails bookingDetails = this.f3580a;
                if (bookingDetails != null) {
                    bookingDetails.setToLocation(this.b);
                    t1Var.f().f(this.f3580a);
                    this.d.o(ad1, this.b, this.c);
                    u00.d(this.d, "success", "", this.f3580a, this.b.b);
                    return;
                }
                return;
            }
            u00.d(this.d, AnalyticsConstants.FAILURE, "server failure", this.f3580a, this.b.b);
            this.d.m(this.b.b);
            this.d.o(ad1.FAILED, this.b, this.c);
        } catch (JSONException e) {
            u00.d(this.d, AnalyticsConstants.FAILURE, "json error", this.f3580a, this.b.b);
            b00 b00 = b00.f358a;
            b00.a().b(e);
            this.d.m(this.b.b);
            this.d.o(ad1.FAILED, this.b, this.c);
        }
    }
}
