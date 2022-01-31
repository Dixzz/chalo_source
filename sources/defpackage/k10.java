package defpackage;

import android.content.Context;
import app.zophop.pubsub.eventbus.events.UserProfileEvent;
import com.freshchat.consumer.sdk.Freshchat;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import defpackage.xt;
import defpackage.yj1;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: k10  reason: default package */
/* compiled from: FCMTokenFeature */
public class k10 {
    public static final String b = ut.i.concat("notificationdetails/update");

    /* renamed from: a  reason: collision with root package name */
    public String f2009a;

    /* renamed from: k10$a */
    /* compiled from: FCMTokenFeature */
    public class a implements ti4<InstanceIdResult> {
        public final /* synthetic */ Context f;

        public a(Context context) {
            this.f = context;
        }

        @Override // defpackage.ti4
        public void onComplete(yi4<InstanceIdResult> yi4) {
            if (yi4.q()) {
                k10.this.f2009a = yi4.m().getToken();
                Freshchat.getInstance(this.f).setPushRegistrationToken(k10.this.f2009a);
                if (k10.this.f2009a != null) {
                    jz5.b().g(new xe1(k10.this.f2009a, "fcmTokenFeature"));
                }
            }
        }
    }

    /* renamed from: k10$b */
    /* compiled from: FCMTokenFeature */
    public class b implements yj1.b<String> {
        public b(k10 k10) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.yj1.b
        public void a(String str) {
            try {
                if (new JSONObject(str).getString("status").equalsIgnoreCase("true")) {
                    xt.f3961a.l().put("fcmTokenSet", String.valueOf(true));
                }
            } catch (JSONException e) {
                b00 b00 = b00.f358a;
                b00.a().b(e);
            }
        }
    }

    /* renamed from: k10$c */
    /* compiled from: FCMTokenFeature */
    public class c implements yj1.a {
        public c(k10 k10) {
        }

        @Override // defpackage.yj1.a
        public void a(dk1 dk1) {
            dk1.getLocalizedMessage();
            dk1.printStackTrace();
        }
    }

    public k10(Context context) {
        jz5 b2 = jz5.b();
        b2.k(this, b2.e, true, 0);
        FirebaseInstanceId.getInstance().getInstanceId().b(new a(context));
    }

    public final void a() {
        String str;
        if (this.f2009a != null) {
            String str2 = b;
            b bVar = new b(this);
            c cVar = new c(this);
            try {
                JSONObject jSONObject = new JSONObject();
                xt.t1 t1Var = xt.f3961a;
                jSONObject.put("deviceId", t1Var.n().a());
                jSONObject.put("fcmRegistrationToken", this.f2009a);
                if (t1Var.L().f()) {
                    jSONObject.put("userId", t1Var.L().getUserId());
                } else {
                    jSONObject.put("userId", "");
                }
                str = jSONObject.toString();
            } catch (JSONException e) {
                e.printStackTrace();
                b00 b00 = b00.f358a;
                b00.a().b(e);
                str = "exception on client";
            }
            e70 e70 = new e70(str2, bVar, cVar, str);
            e70.n = false;
            e70.q = new nj1(5000, 10, 1.0f);
            xt.f3961a.S().a(e70);
        }
    }

    public void onEvent(we1 we1) {
        this.f2009a = we1.f3766a;
        a();
    }

    public void onEvent(UserProfileEvent userProfileEvent) {
        if (userProfileEvent.getUserProfileEventType().equals(UserProfileEvent.TYPE.LOGOUT)) {
            xt.f3961a.l().remove("fcmTokenSet");
        } else if (!xt.f3961a.l().h.has("fcmTokenSet")) {
            a();
        }
    }
}
