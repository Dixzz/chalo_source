package defpackage;

import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import app.zophop.pubsub.eventbus.events.CashPaymentInfoFetchedEvent;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.razorpay.AnalyticsConstants;
import defpackage.yj1;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: q60  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class q60 implements yj1.b {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ q60 f2902a = new q60();

    @Override // defpackage.yj1.b
    public final void a(Object obj) {
        try {
            JSONObject jSONObject = new JSONObject((String) obj);
            String string = jSONObject.getString("userId");
            String string2 = jSONObject.getString(SuperPassJsonKeys.REFERENCE_ID);
            double d = jSONObject.getDouble(AnalyticsConstants.AMOUNT);
            n86.d(string, "lUserIdResponse");
            n86.d(string2, "lReferenceId");
            jz5.b().g(new CashPaymentInfoFetchedEvent(string, string2, d, ad1.SUCCESS, null, 16, null));
        } catch (JSONException e) {
            jz5.b().g(new CashPaymentInfoFetchedEvent(null, null, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, ad1.FAILED, null, 23, null));
            b00 b00 = b00.f358a;
            b00.a().b(e);
        }
    }
}
