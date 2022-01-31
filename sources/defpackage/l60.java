package defpackage;

import app.zophop.pubsub.eventbus.events.CardValidityCheckEvent;
import defpackage.yj1;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: l60  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class l60 implements yj1.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f2179a;

    public /* synthetic */ l60(String str) {
        this.f2179a = str;
    }

    @Override // defpackage.yj1.b
    public final void a(Object obj) {
        String str = this.f2179a;
        String str2 = (String) obj;
        n86.e(str, "$lRequestId");
        try {
            JSONObject jSONObject = new JSONObject(str2);
            String string = jSONObject.getString("status");
            String optString = jSONObject.optString("message", "");
            long optLong = jSONObject.optLong("rechargeLimit", -1);
            jz5 b = jz5.b();
            n86.d(string, "lStatus");
            n86.d(optString, "lMessage");
            b.i(new CardValidityCheckEvent(str, string, optString, optLong));
        } catch (JSONException e) {
            jz5.b().i(new CardValidityCheckEvent(str, CardValidityCheckEvent.VALIDITY_CHECK_ERROR, "", 0, 8, null));
            e.printStackTrace();
            b00 b00 = b00.f358a;
            b00.a().b(e);
        }
    }
}
