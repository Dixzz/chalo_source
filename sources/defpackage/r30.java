package defpackage;

import android.content.Context;
import app.zophop.models.OAuthDetails;
import app.zophop.models.autoCabBooking.BookingCode;
import app.zophop.pubsub.eventbus.events.OauthEvent;
import app.zophop.ui.activities.WebViewInterceptActivity;
import defpackage.n00;
import defpackage.p20;
import defpackage.yj1;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: r30  reason: default package */
/* compiled from: OAuthFeature */
public class r30 implements p20 {

    /* renamed from: a  reason: collision with root package name */
    public final rf1 f3030a;
    public final HashSet<String> b = new HashSet<>();
    public Map<String, hi1> c;

    /* renamed from: r30$a */
    /* compiled from: OAuthFeature */
    public class a implements yj1.b<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f3031a;
        public final /* synthetic */ p20.a b;

        public a(String str, p20.a aVar) {
            this.f3031a = str;
            this.b = aVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.yj1.b
        public void a(JSONObject jSONObject) {
            JSONObject jSONObject2 = jSONObject;
            r30.this.b.remove(this.f3031a);
            r30 r30 = r30.this;
            String str = this.f3031a;
            p20.a aVar = this.b;
            Objects.requireNonNull(r30);
            try {
                if (ad1.valueOf(jSONObject2.getString("_responseType")).equals(ad1.SUCCESS)) {
                    String string = jSONObject2.getString("access_token");
                    String string2 = jSONObject2.getString("refresh_token");
                    r30.b(str, string, string2, jSONObject2.getLong("expires_in") * 1000);
                    if (aVar != null) {
                        aVar.a(str, string, string2);
                        return;
                    }
                    return;
                }
                if (System.currentTimeMillis() > r30.h(str).getAbsoluteExpiryTimeMillis()) {
                    r30.f3030a.k(str.toLowerCase());
                }
                if (aVar != null) {
                    xt.f3961a.H().d(str);
                    u00.b(u00.this, str, BookingCode.INVALID_TOKEN);
                }
            } catch (JSONException e) {
                b00 b00 = b00.f358a;
                hj1.W0(e);
            }
        }
    }

    /* renamed from: r30$b */
    /* compiled from: OAuthFeature */
    public class b implements n00.z0 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f3032a;

        public b(String str) {
            this.f3032a = str;
        }

        @Override // defpackage.n00.z0
        public void a(dk1 dk1) {
            dk1.getMessage();
            r30.this.b.remove(this.f3032a);
        }
    }

    public r30(Context context) {
        rf1 rf1 = new rf1(context, "oauth_store");
        this.f3030a = rf1;
        HashMap hashMap = new HashMap();
        this.c = hashMap;
        hashMap.put("uber", new oi1());
        for (String str : rf1.b().keySet()) {
            OAuthDetails h = h(str);
            long validityDurationMillis = h.getValidityDurationMillis();
            long absoluteExpiryTimeMillis = h.getAbsoluteExpiryTimeMillis() - System.currentTimeMillis();
            boolean z = true;
            if (absoluteExpiryTimeMillis >= 0 && ((double) absoluteExpiryTimeMillis) >= (((double) validityDurationMillis) * 1.0d) / 2.0d) {
                z = false;
            }
            if (z) {
                a(str, null);
            }
        }
    }

    @Override // defpackage.p20
    public void a(String str, p20.a aVar) {
        if (!this.b.contains(str)) {
            this.b.add(str);
            d70 d70 = new d70(this.c.get(str.toLowerCase()).b(h(str).getRefreshToken()), null, new a(str, aVar), new b(str));
            d70.q = new nj1(2500, 5, 1.0f);
            d70.n = false;
            xt.f3961a.T().a(d70);
        }
    }

    @Override // defpackage.p20
    public void b(String str, String str2, String str3, long j) {
        String lowerCase = str.toLowerCase();
        try {
            this.f3030a.j(lowerCase, g(new OAuthDetails(str2, str3, System.currentTimeMillis() + j, j)));
            jz5.b().i(new OauthEvent(ad1.SUCCESS, lowerCase));
        } catch (JSONException e) {
            b00 b00 = b00.f358a;
            b00.a().b(e);
            jz5.b().i(new OauthEvent(ad1.FAILED, lowerCase));
        }
    }

    @Override // defpackage.p20
    public void c(String str, Context context) {
        hi1 hi1 = this.c.get(str.toLowerCase());
        WebViewInterceptActivity.l0(context, hi1.c(), str, false, true, hi1.a(), 69);
    }

    @Override // defpackage.p20
    public void d(String str) {
        this.f3030a.k(str.toLowerCase());
    }

    @Override // defpackage.p20
    public boolean e(String str) {
        return h(str) != null;
    }

    @Override // defpackage.p20
    public String f(String str) {
        if (h(str) != null) {
            return h(str).getAccessToken();
        }
        return null;
    }

    public final String g(OAuthDetails oAuthDetails) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("access_token", oAuthDetails.getAccessToken());
        jSONObject.put("refresh_token", oAuthDetails.getRefreshToken());
        jSONObject.put("expiry_time", Long.valueOf(oAuthDetails.getAbsoluteExpiryTimeMillis()).toString());
        jSONObject.put("validity_duration", Long.valueOf(oAuthDetails.getValidityDurationMillis()).toString());
        return jSONObject.toString();
    }

    public final OAuthDetails h(String str) {
        String f = this.f3030a.f(str.toLowerCase(), null);
        if (f == null) {
            return null;
        }
        try {
            return i(f);
        } catch (JSONException e) {
            e.printStackTrace();
            b00 b00 = b00.f358a;
            b00.a().b(e);
            return null;
        }
    }

    public final OAuthDetails i(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        return new OAuthDetails(jSONObject.getString("access_token"), jSONObject.getString("refresh_token"), Long.valueOf(jSONObject.getString("expiry_time")).longValue(), Long.valueOf(jSONObject.getString("validity_duration")).longValue());
    }
}
