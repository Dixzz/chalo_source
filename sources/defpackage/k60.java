package defpackage;

import app.zophop.models.mTicketing.ProductConfigurationMap;
import app.zophop.pubsub.eventbus.events.CardRechargeTransactionsFetchedEvent;
import defpackage.yj1;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: k60  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class k60 implements yj1.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f2028a;

    public /* synthetic */ k60(String str) {
        this.f2028a = str;
    }

    @Override // defpackage.yj1.b
    public final void a(Object obj) {
        ProductConfigurationMap productConfigurationMap;
        String str = this.f2028a;
        String str2 = (String) obj;
        n86.e(str, "$lRequestId");
        try {
            JSONObject jSONObject = new JSONObject(str2);
            JSONArray jSONArray = jSONObject.getJSONArray("cardConfig");
            JSONArray jSONArray2 = jSONObject.getJSONArray("cards");
            if (jSONArray != null) {
                ProductConfigurationMap productConfigurationMap2 = new ProductConfigurationMap();
                int i = 0;
                try {
                    int length = jSONArray.length();
                    if (length > 0) {
                        while (true) {
                            int i2 = i + 1;
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            String string = jSONObject2.getString("agency");
                            n86.d(jSONObject2, "lCardConfigObject");
                            productConfigurationMap2.addConfiguration(string, kv.a(jSONObject2));
                            if (i2 >= length) {
                                break;
                            }
                            i = i2;
                        }
                    }
                    productConfigurationMap = productConfigurationMap2;
                } catch (JSONException e) {
                    b00 b00 = b00.f358a;
                    b00.a().b(e);
                    e.printStackTrace();
                }
                xt.f3961a.K().updateOnlineCardRechargeTable(jSONArray2);
                jz5.b().i(new CardRechargeTransactionsFetchedEvent(str, ad1.SUCCESS, "", productConfigurationMap, jSONArray2));
            }
            productConfigurationMap = null;
            xt.f3961a.K().updateOnlineCardRechargeTable(jSONArray2);
            jz5.b().i(new CardRechargeTransactionsFetchedEvent(str, ad1.SUCCESS, "", productConfigurationMap, jSONArray2));
        } catch (JSONException e2) {
            jz5.b().i(new CardRechargeTransactionsFetchedEvent(str, ad1.FAILED, "", null, null));
            e2.printStackTrace();
            b00 b002 = b00.f358a;
            b00.a().b(e2);
        }
    }
}
