package defpackage;

import android.util.Pair;
import app.zophop.models.CtaAction;
import app.zophop.models.NpsSurvey;
import app.zophop.models.NpsSurveyQuestion;
import app.zophop.models.NpsSurveyRatingQuestion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: pv  reason: default package */
/* compiled from: NpsSurveyResponseConverter */
public class pv {
    public Map<String, NpsSurvey> a(JSONObject jSONObject) {
        NpsSurveyQuestion b;
        HashMap hashMap = new HashMap();
        if (jSONObject == null) {
            return hashMap;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                long optLong = jSONObject2.optLong("idleTimeout", 100000000);
                String optString = jSONObject2.optString("startingQuestion", null);
                JSONObject jSONObject3 = jSONObject2.getJSONObject("questionMap");
                HashMap hashMap2 = new HashMap();
                Iterator<String> keys2 = jSONObject3.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    try {
                        JSONObject optJSONObject = jSONObject3.optJSONObject(next2);
                        if (!(optJSONObject == null || (b = b(next2, optJSONObject)) == null)) {
                            hashMap2.put(next2, b);
                        }
                    } catch (JSONException unused) {
                        q30.g("NPS response converter event", "NPS response converter parsing error");
                    }
                }
                NpsSurvey npsSurvey = new NpsSurvey(next, optLong, optString);
                npsSurvey.setNpsSurveyQuestionMap(hashMap2);
                JSONArray optJSONArray = jSONObject2.optJSONArray("screenList");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        hashMap.put(optJSONArray.getString(i), npsSurvey);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return hashMap;
    }

    public final NpsSurveyQuestion b(String str, JSONObject jSONObject) throws JSONException {
        String optString = jSONObject.optString("qType");
        JSONObject optJSONObject = jSONObject.optJSONObject("qTypeInfo");
        if (optJSONObject == null) {
            return null;
        }
        if ("RATING".equalsIgnoreCase(optString)) {
            NpsSurveyRatingQuestion npsSurveyRatingQuestion = new NpsSurveyRatingQuestion(str, "RATING", optJSONObject.optString("qText"), optJSONObject.optString("lowRangeText", null), optJSONObject.optString("highRangeText", null));
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("threshold");
            HashMap hashMap = new HashMap();
            if (optJSONObject2 != null) {
                Iterator<String> keys = optJSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    try {
                        JSONObject jSONObject2 = optJSONObject2.getJSONObject(next);
                        if (jSONObject2 != null) {
                            JSONObject optJSONObject3 = jSONObject2.optJSONObject("action");
                            hashMap.put(next, new Pair(c(optJSONObject3.optJSONObject("positiveCta")), c(optJSONObject3.optJSONObject("negativeCta"))));
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        q30.g("NPS response converter event", "NPS response converter parsing error");
                    }
                }
            }
            npsSurveyRatingQuestion.setTresholdActionMapping(hashMap);
            return npsSurveyRatingQuestion;
        } else if (!"TEXT".equalsIgnoreCase(optString) && !"THANK_YOU".equalsIgnoreCase(optString)) {
            return null;
        } else {
            String optString2 = optJSONObject.optString("qText");
            String optString3 = optJSONObject.optString("qHint");
            String optString4 = optJSONObject.optString("qTitle", null);
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("action");
            NpsSurveyQuestion npsSurveyQuestion = new NpsSurveyQuestion(str, optString, optString2);
            npsSurveyQuestion.setQuestionText(optString2);
            npsSurveyQuestion.setQuestionHint(optString3);
            npsSurveyQuestion.setQuestionTitle(optString4);
            if (optJSONObject4 != null) {
                JSONObject optJSONObject5 = optJSONObject4.optJSONObject("positiveCta");
                JSONObject optJSONObject6 = optJSONObject4.optJSONObject("negativeCta");
                npsSurveyQuestion.setPositiveCtaAction(c(optJSONObject5));
                npsSurveyQuestion.setNegativeCtaAction(c(optJSONObject6));
            }
            JSONArray optJSONArray = optJSONObject.optJSONArray("tags");
            ArrayList arrayList = new ArrayList();
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    arrayList.add(optJSONArray.getString(i));
                }
            }
            npsSurveyQuestion.setSuggestedTagsList(arrayList);
            return npsSurveyQuestion;
        }
    }

    public final CtaAction c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new CtaAction(jSONObject.optString("ctaType", "DISMISS"), jSONObject.optString("ctaText", "OK"), jSONObject.optString("ctaAction", null));
    }
}
