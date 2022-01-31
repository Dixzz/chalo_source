package defpackage;

import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import app.zophop.pubsub.eventbus.events.SuperPassApplicationSubmissionEvent;
import defpackage.yj1;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: o60  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class o60 implements yj1.b {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ o60 f2653a = new o60();

    @Override // defpackage.yj1.b
    public final void a(Object obj) {
        try {
            JSONObject jSONObject = new JSONObject((String) obj);
            if (!n86.a(jSONObject.getString("status"), "true")) {
                String optString = jSONObject.optString("message", new String());
                jz5 b = jz5.b();
                ad1 ad1 = ad1.FAILED;
                n86.d(optString, "lMessage");
                b.g(new SuperPassApplicationSubmissionEvent(ad1, optString));
            } else if (jSONObject.has(SuperPassJsonKeys.USER_PROFILE)) {
                jz5.b().g(new SuperPassApplicationSubmissionEvent(ad1.SUCCESS, null, 2, null));
            } else {
                String optString2 = jSONObject.optString("message", new String());
                jz5 b2 = jz5.b();
                ad1 ad12 = ad1.FAILED;
                n86.d(optString2, "lMessage");
                b2.g(new SuperPassApplicationSubmissionEvent(ad12, optString2));
            }
        } catch (JSONException e) {
            jz5.b().g(new SuperPassApplicationSubmissionEvent(ad1.FAILED, null, 2, null));
            e.printStackTrace();
            b00 b00 = b00.f358a;
            b00.a().b(e);
        }
    }
}
