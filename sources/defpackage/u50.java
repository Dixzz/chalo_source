package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import app.zophop.models.InAppUpdateRules;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import app.zophop.pubsub.eventbus.events.UpdateEvent;
import com.crashlytics.android.answers.SessionEventTransform;
import defpackage.xt;
import defpackage.yj1;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: u50  reason: default package */
/* compiled from: UpdateFeature */
public class u50 implements d30 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f3454a;

    /* renamed from: u50$a */
    /* compiled from: UpdateFeature */
    public class a implements yj1.b<JSONObject> {
        public a(u50 u50) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.yj1.b
        public void a(JSONObject jSONObject) {
            JSONObject jSONObject2 = jSONObject;
            UpdateEvent updateEvent = new UpdateEvent();
            try {
                boolean z = jSONObject2.getBoolean("forceUpdate");
                boolean z2 = jSONObject2.getBoolean("recommendedUpdate");
                updateEvent.setStatus(ad1.SUCCESS);
                updateEvent.setForceUpdate(z);
                updateEvent.setRecommendedUpdate(z2);
            } catch (JSONException e) {
                updateEvent.setStatus(ad1.FAILED);
                updateEvent.setReason(e.getMessage());
            }
            jz5.b().i(updateEvent);
        }
    }

    /* renamed from: u50$b */
    /* compiled from: UpdateFeature */
    public class b implements yj1.a {
        public b(u50 u50) {
        }

        @Override // defpackage.yj1.a
        public void a(dk1 dk1) {
            UpdateEvent updateEvent = new UpdateEvent();
            updateEvent.setStatus(ad1.FAILED);
            updateEvent.setReason(dk1.getMessage());
            jz5.b().i(updateEvent);
        }
    }

    public u50(Context context) {
        this.f3454a = context;
        xt.t1 t1Var = xt.f3961a;
        if (t1Var.l().h.has("lang_info_shown")) {
            int f = f(context);
            if (!t1Var.l().h.has("versionCode")) {
                t1Var.l().put("fresh_install", String.valueOf(false));
            } else if (f > Integer.valueOf(t1Var.l().h.optString("versionCode", null)).intValue()) {
                t1Var.l().put("fresh_install", String.valueOf(false));
            }
            t1Var.l().put("versionCode", String.valueOf(f));
            return;
        }
        int f2 = f(context);
        t1Var.l().put("fresh_install", String.valueOf(true));
        t1Var.l().put("versionCode", String.valueOf(f2));
    }

    public static int f(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override // defpackage.d30
    public String a() {
        return xt.f3961a.t().f("affectedVersions");
    }

    @Override // defpackage.d30
    public int b() {
        return (int) xt.f3961a.t().c("appUpdateVersionCode");
    }

    @Override // defpackage.d30
    public List<InAppUpdateRules> c() {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(xt.f3961a.t().f("inappUpdate"));
            for (int i = 0; i < jSONArray.length(); i++) {
                String[] split = jSONArray.getString(i).split(ProductDiscountsObject.KEY_DELIMITER);
                arrayList.add(new InAppUpdateRules(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), split[3]));
            }
            return arrayList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // defpackage.d30
    public void d() {
        xj1 S = xt.f3961a.S();
        Uri.Builder builder = new Uri.Builder();
        Uri.Builder appendEncodedPath = builder.encodedPath(ut.l).appendEncodedPath("v1").appendEncodedPath("appVersionCheck");
        Context context = this.f3454a;
        int i = 0;
        try {
            i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        appendEncodedPath.appendQueryParameter(SessionEventTransform.APP_VERSION_CODE_KEY, String.valueOf(i)).appendQueryParameter("userId", xt.f3961a.D());
        S.a(new lk1(builder.build().toString(), null, new a(this), new b(this)));
    }

    @Override // defpackage.d30
    public int e() {
        return (int) xt.f3961a.t().c(SessionEventTransform.APP_VERSION_CODE_KEY);
    }
}
