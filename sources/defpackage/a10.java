package defpackage;

import defpackage.xt;
import defpackage.yj1;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: a10  reason: default package */
/* compiled from: ChaloConfigFeature */
public class a10 implements yj1.b<a70> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f101a;
    public final /* synthetic */ d10 b;

    public a10(d10 d10, String str) {
        this.b = d10;
        this.f101a = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.yj1.b
    public void a(a70 a70) {
        a70 a702 = a70;
        try {
            int i = a702.c;
            JSONObject jSONObject = a702.b;
            if (jSONObject != null) {
                xt.f3961a.i().put("etagChaloConfigCachedEtag", jSONObject.optString("etag"));
            }
            if (i == 304) {
                d10.l("chaloConfig status code error: ", String.valueOf(304));
                return;
            }
            try {
                JSONObject jSONObject2 = a702.f128a;
                if (!jSONObject2.optBoolean("status", true)) {
                    d10.l("chaloConfig status error etagVersion", "false");
                    return;
                }
                JSONObject jSONObject3 = jSONObject2.getJSONObject("response");
                JSONObject jSONObject4 = jSONObject3.getJSONObject("metadata");
                String optString = jSONObject4.optString("versionNumber", null);
                String optString2 = jSONObject4.optString("cacheExpiry", null);
                if (optString2 != null) {
                    xt.f3961a.i().put("cacheExpiry", optString2);
                }
                xt.t1 t1Var = xt.f3961a;
                t1Var.i().put("chaloConfigLatestVersionCode", optString);
                t1Var.i().put("chaloConfigLastUpdatedLocale", this.f101a);
                String jSONObject5 = jSONObject3.getJSONObject("data").toString();
                t1Var.h().put("chaloConfigLastUpdatedDate", jSONObject5);
                t1Var.i().put("chaloConfigFetchCallSuccessful", "true");
                d10.h(this.b, jSONObject5, this.f101a);
                HashMap hashMap = new HashMap();
                hashMap.put("time of response", String.valueOf(ui1.Q()));
                d10.m("chalo config normal fetch event etagVersion", hashMap);
                try {
                    t1Var.i().put("updateTime", String.valueOf(ui1.Q()));
                } catch (Exception unused) {
                    d10.l("chalo config event etagVersion", "time exception occurred");
                }
            } catch (JSONException unused2) {
                d10.l("chalo config normal fetch event etagVersion", "data object json response exception occurred");
            }
        } catch (Exception e) {
            d10.l("chalo config normal fetch event etagVersion", "json data and headers response exception occurred");
            e.printStackTrace();
        }
    }
}
