package defpackage;

import android.content.Context;
import android.text.TextUtils;
import app.zophop.R;
import app.zophop.pubsub.eventbus.events.ReferralTrackingFailureEvent;
import app.zophop.pubsub.eventbus.events.ReferralTrackingSuccessEvent;
import defpackage.yj1;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: j40  reason: default package */
/* compiled from: ReferralTrackingFeature */
public class j40 implements w20 {
    public static final String c = hj1.a0(new StringBuilder(), ut.i, "v1/account/");

    /* renamed from: a  reason: collision with root package name */
    public final Context f1870a;
    public final xj1 b;

    /* renamed from: j40$a */
    /* compiled from: ReferralTrackingFeature */
    public class a implements yj1.b<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f1871a;

        public a(String str) {
            this.f1871a = str;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.yj1.b
        public void a(String str) {
            String str2 = str;
            try {
                if (!TextUtils.isEmpty(str2)) {
                    JSONObject jSONObject = new JSONObject(str2);
                    if (jSONObject.getString("status").equals("1")) {
                        jz5.b().i(new ReferralTrackingSuccessEvent(this.f1871a));
                    } else if (jSONObject.getString("status").equals("0")) {
                        jz5.b().i(new ReferralTrackingFailureEvent(this.f1871a, jSONObject.getString("errorCode"), jSONObject.getString("errorMessage")));
                    }
                }
            } catch (JSONException e) {
                jz5.b().i(new ReferralTrackingFailureEvent(this.f1871a, "-1", j40.this.f1870a.getString(R.string.referral_error)));
                e.printStackTrace();
            }
        }
    }

    /* renamed from: j40$b */
    /* compiled from: ReferralTrackingFeature */
    public class b implements yj1.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f1872a;

        public b(j40 j40, String str) {
            this.f1872a = str;
        }

        @Override // defpackage.yj1.a
        public void a(dk1 dk1) {
            jz5.b().i(new ReferralTrackingFailureEvent(this.f1872a, null, "Server Error"));
        }
    }

    public j40(Context context, xj1 xj1) {
        this.f1870a = context;
        this.b = xj1;
    }

    @Override // defpackage.w20
    public void a(String str, String str2, String str3) {
        String a0 = hj1.a0(new StringBuilder(), c, "referral");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("userId", str);
            jSONObject.put("deviceId", xt.f3961a.n().a());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("referralCode", str3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        e70 e70 = new e70(1, a0, jSONObject, new a(str3), new b(this, str3), jSONObject2.toString());
        e70.n = false;
        this.b.a(e70);
    }
}
