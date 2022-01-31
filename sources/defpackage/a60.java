package defpackage;

import android.content.Context;
import android.net.Uri;
import com.crashlytics.android.answers.SessionEventTransform;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.analytics.FirebaseAnalytics;
import defpackage.yj1;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: a60  reason: default package */
/* compiled from: ZophopLocationsProvider */
public class a60 extends le1 {
    public final xj1 f;

    /* renamed from: a60$a */
    /* compiled from: ZophopLocationsProvider */
    public class a implements yj1.b<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ md1 f124a;
        public final /* synthetic */ String b;

        public a(md1 md1, String str) {
            this.f124a = md1;
            this.b = str;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.yj1.b
        public void a(JSONObject jSONObject) {
            JSONObject jSONObject2 = jSONObject;
            try {
                JSONObject jSONObject3 = jSONObject2.getJSONObject("result").getJSONObject("geometry").getJSONObject(FirebaseAnalytics.Param.LOCATION);
                LatLng latLng = new LatLng(jSONObject3.getDouble("lat"), jSONObject3.getDouble("lng"));
                latLng.toString();
                a60.this.k(this.f124a.f2356a, latLng, ad1.SUCCESS, true, this.b);
            } catch (JSONException e) {
                e.toString();
                jSONObject2.toString();
                a60.this.k(this.f124a.f2356a, null, ad1.FAILED, true, this.b);
            }
        }
    }

    /* renamed from: a60$b */
    /* compiled from: ZophopLocationsProvider */
    public class b implements yj1.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ md1 f125a;
        public final /* synthetic */ String b;

        public b(md1 md1, String str) {
            this.f125a = md1;
            this.b = str;
        }

        @Override // defpackage.yj1.a
        public void a(dk1 dk1) {
            a60.this.k(this.f125a.f2356a, null, ad1.FAILED, true, this.b);
        }
    }

    public a60(Context context, xj1 xj1, String str) {
        super(context, xj1, str);
        this.f = xj1;
    }

    @Override // defpackage.je1
    public String e(md1 md1) {
        Uri.Builder builder = new Uri.Builder();
        String uuid = UUID.randomUUID().toString();
        builder.encodedPath(ut.d).appendPath("place").appendPath(SessionEventTransform.DETAILS_KEY);
        builder.appendQueryParameter("placeid", md1.b);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("deviceId", xt.f3961a.m0());
        } catch (JSONException unused) {
            jSONObject = null;
        }
        builder.appendQueryParameter("meta", jSONObject.toString());
        this.f.a(new lk1(builder.build().toString(), null, new a(md1, uuid), new b(md1, uuid)));
        return uuid;
    }
}
