package defpackage;

import android.content.Context;
import app.zophop.models.ReportProblemCollection;
import app.zophop.models.ReportProblemFeatureCategory;
import app.zophop.models.ReportProblemFeatureProblem;
import app.zophop.ui.activities.ReportProblemActivity;
import com.razorpay.AnalyticsConstants;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: k40  reason: default package */
/* compiled from: ReportProblemFeature.kt */
public final class k40 implements y20 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f2016a;
    public final qv b;
    public final Map<String, String> c;
    public Map<String, ReportProblemCollection> d = c66.f;

    public k40(Context context) {
        n86.e(context, "_context");
        this.f2016a = context;
        qv qvVar = new qv();
        this.b = qvVar;
        sf1 sf1 = new sf1(context.getSharedPreferences("reportProblemFeature", 0), "reportProblemFeature_properties");
        this.c = sf1;
        try {
            String optString = sf1.h.optString("keyReportProblemFeatureData", null);
            if (optString != null) {
                this.d = qvVar.a(new JSONObject(optString));
            }
        } catch (JSONException unused) {
            n86.e("Report Problem feature event", "eventName");
            if (xt.f3961a.v().f) {
                ed1 ed1 = new ed1("Report Problem feature event", Long.MIN_VALUE);
                ed1.a("Report Problem feature event description ", "Report Problem store parsing error");
                jz5.b().g(ed1);
            }
        }
    }

    @Override // defpackage.y20
    public String a() {
        return xt.f3961a.l().h.optString("keyReportProblemFeatureCachedResponseCity", null);
    }

    @Override // defpackage.y20
    public void b(Context context, String str, String str2, Map<String, String> map, boolean z) {
        n86.e(context, AnalyticsConstants.CONTEXT);
        n86.e(str, "collectionId");
        n86.e(str2, "source");
        n86.e(map, "userPropertiesMap");
        ReportProblemCollection reportProblemCollection = this.d.get(str);
        ArrayList arrayList = null;
        if (z) {
            if (str2.equals("activatePassScreen")) {
                arrayList = new ArrayList();
                ReportProblemFeatureProblem reportProblemFeatureProblem = new ReportProblemFeatureProblem("reclaimPassesProblem", "Cant find my pass after I changed/reset my mobile device.", new ArrayList(), null, "reclaimPasses", 8, null);
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(reportProblemFeatureProblem);
                arrayList.add(new ReportProblemFeatureCategory("reclaimPassesCategory", "Don't see my active pass", arrayList2));
            }
            if (reportProblemCollection == null && arrayList != null) {
                reportProblemCollection = str2.equals("activatePassScreen") ? new ReportProblemCollection("defaultCollectionIdHistoryScreen", "Help", arrayList) : new ReportProblemCollection("dummyProblemCollectionId", "Help", arrayList);
            }
        }
        if (reportProblemCollection != null) {
            if (arrayList != null) {
                ReportProblemActivity.r.a(context, reportProblemCollection, str2, map, arrayList);
            } else {
                ReportProblemActivity.r.a(context, reportProblemCollection, str2, map, b66.f);
            }
        }
    }

    @Override // defpackage.y20
    public void c(JSONObject jSONObject) {
        n86.e(jSONObject, "jsonObject");
        xt.f3961a.l().put("keyReportProblemFeatureVersionCode", jSONObject.optString("versionCode", null));
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            this.d = this.b.a(optJSONObject);
            this.c.clear();
            this.c.put("keyReportProblemFeatureData", optJSONObject.toString());
        }
    }

    @Override // defpackage.y20
    public void d(String str) {
        n86.e(str, "cityName");
        xt.f3961a.l().put("keyReportProblemFeatureCachedResponseCity", str);
    }

    @Override // defpackage.y20
    public String e() {
        return xt.f3961a.l().h.optString("keyReportProblemFeatureVersionCode", null);
    }
}
