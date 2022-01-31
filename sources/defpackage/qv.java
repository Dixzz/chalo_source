package defpackage;

import app.zophop.models.ReportProblemCollection;
import app.zophop.models.ReportProblemFeatureCategory;
import app.zophop.models.ReportProblemFeatureProblem;
import app.zophop.models.mTicketing.ProductPromotionsObject;
import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: qv  reason: default package */
/* compiled from: ReportProblemResponseConverter.kt */
public final class qv {
    public final Map<String, ReportProblemCollection> a(JSONObject jSONObject) {
        Iterator<String> keys;
        ReportProblemCollection reportProblemCollection;
        int length;
        Iterator<String> keys2;
        ReportProblemFeatureCategory reportProblemFeatureCategory;
        int length2;
        Iterator<String> keys3;
        Iterator<String> it;
        JSONObject jSONObject2;
        ReportProblemFeatureProblem reportProblemFeatureProblem;
        int length3;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        JSONObject optJSONObject = jSONObject.optJSONObject("problemPool");
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        if (!(optJSONObject == null || (keys3 = optJSONObject.keys()) == null)) {
            while (keys3.hasNext()) {
                String next = keys3.next();
                JSONObject optJSONObject2 = optJSONObject.optJSONObject(next);
                if (optJSONObject2 == null) {
                    jSONObject2 = optJSONObject;
                    it = keys3;
                    reportProblemFeatureProblem = null;
                } else {
                    String optString = optJSONObject2.optString("problemText", "");
                    String optString2 = optJSONObject2.optString("ctaType", "");
                    JSONArray optJSONArray = optJSONObject2.optJSONArray("ctaTagList");
                    String optString3 = optJSONObject2.optString("chatGroupTag");
                    ArrayList arrayList = new ArrayList();
                    if (optJSONArray == null || (length3 = optJSONArray.length()) <= 0) {
                        jSONObject2 = optJSONObject;
                        it = keys3;
                    } else {
                        jSONObject2 = optJSONObject;
                        int i = 0;
                        while (true) {
                            it = keys3;
                            int i2 = i + 1;
                            String string = optJSONArray.getString(i);
                            n86.d(string, "ctaTagJsonArray.getString(i)");
                            arrayList.add(string);
                            if (i2 >= length3) {
                                break;
                            }
                            i = i2;
                            keys3 = it;
                            optJSONArray = optJSONArray;
                        }
                    }
                    n86.d(optString, "problemText");
                    n86.d(optString3, "chatGroupTag");
                    n86.d(optString2, "ctaType");
                    reportProblemFeatureProblem = new ReportProblemFeatureProblem(next, optString, arrayList, optString3, optString2);
                }
                if (reportProblemFeatureProblem != null) {
                    linkedHashMap2.put(next, reportProblemFeatureProblem);
                }
                optJSONObject = jSONObject2;
                keys3 = it;
            }
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("categoryPool");
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        if (!(optJSONObject3 == null || (keys2 = optJSONObject3.keys()) == null)) {
            while (keys2.hasNext()) {
                String next2 = keys2.next();
                JSONObject optJSONObject4 = optJSONObject3.optJSONObject(next2);
                if (optJSONObject4 == null) {
                    reportProblemFeatureCategory = null;
                } else {
                    String optString4 = optJSONObject4.optString(SuperPassJsonKeys.CATEGORY_NAME, "");
                    JSONArray optJSONArray2 = optJSONObject4.optJSONArray("problemList");
                    ArrayList arrayList2 = new ArrayList();
                    if (optJSONArray2 != null && (length2 = optJSONArray2.length()) > 0) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3 + 1;
                            String string2 = optJSONArray2.getString(i3);
                            n86.d(string2, "problemJsonArray.getString(i)");
                            ReportProblemFeatureProblem reportProblemFeatureProblem2 = (ReportProblemFeatureProblem) linkedHashMap2.get(string2);
                            if (reportProblemFeatureProblem2 != null) {
                                arrayList2.add(reportProblemFeatureProblem2);
                            }
                            if (i4 >= length2) {
                                break;
                            }
                            i3 = i4;
                        }
                    }
                    n86.d(optString4, SuperPassJsonKeys.CATEGORY_NAME);
                    reportProblemFeatureCategory = new ReportProblemFeatureCategory(next2, optString4, arrayList2);
                }
                if (reportProblemFeatureCategory != null) {
                    linkedHashMap3.put(next2, reportProblemFeatureCategory);
                }
            }
        }
        JSONObject optJSONObject5 = jSONObject.optJSONObject("problemCollectionMap");
        if (!(optJSONObject5 == null || (keys = optJSONObject5.keys()) == null)) {
            while (keys.hasNext()) {
                String next3 = keys.next();
                JSONObject optJSONObject6 = optJSONObject5.optJSONObject(next3);
                if (optJSONObject6 == null) {
                    reportProblemCollection = null;
                } else {
                    String optString5 = optJSONObject6.optString(ProductPromotionsObject.KEY_TITLE, "Help and Support");
                    JSONArray optJSONArray3 = optJSONObject6.optJSONArray("categoryList");
                    ArrayList arrayList3 = new ArrayList();
                    if (optJSONArray3 != null && (length = optJSONArray3.length()) > 0) {
                        int i5 = 0;
                        while (true) {
                            int i6 = i5 + 1;
                            String string3 = optJSONArray3.getString(i5);
                            n86.d(string3, "categoryJsonArray.getString(i)");
                            ReportProblemFeatureCategory reportProblemFeatureCategory2 = (ReportProblemFeatureCategory) linkedHashMap3.get(string3);
                            if (reportProblemFeatureCategory2 != null) {
                                arrayList3.add(reportProblemFeatureCategory2);
                            }
                            if (i6 >= length) {
                                break;
                            }
                            i5 = i6;
                        }
                    }
                    n86.d(optString5, ProductPromotionsObject.KEY_TITLE);
                    reportProblemCollection = new ReportProblemCollection(next3, optString5, arrayList3);
                }
                if (reportProblemCollection != null) {
                    linkedHashMap.put(next3, reportProblemCollection);
                }
            }
        }
        return linkedHashMap;
    }
}
