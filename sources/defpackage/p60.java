package defpackage;

import app.zophop.pubsub.eventbus.events.SuperPassOrderCreationEvent;
import defpackage.yj1;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: p60  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class p60 implements yj1.b {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ p60 f2771a = new p60();

    @Override // defpackage.yj1.b
    public final void a(Object obj) {
        try {
            JSONObject jSONObject = new JSONObject((String) obj);
            if (jSONObject.getBoolean("status")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("responseData");
                n86.d(jSONObject2, "lResponseData");
                y60.k(jSONObject2);
                return;
            }
            String optString = jSONObject.optString("message", new String());
            jz5 b = jz5.b();
            ad1 ad1 = ad1.FAILED;
            n86.d(optString, "lMessage");
            b.i(new SuperPassOrderCreationEvent(ad1, optString, null));
        } catch (JSONException e) {
            jz5 b2 = jz5.b();
            ad1 ad12 = ad1.FAILED;
            String message = e.getMessage();
            if (message == null) {
                message = new String();
            }
            b2.i(new SuperPassOrderCreationEvent(ad12, message, null));
            e.printStackTrace();
            b00 b00 = b00.f358a;
            b00.a().b(e);
        }
    }
}
