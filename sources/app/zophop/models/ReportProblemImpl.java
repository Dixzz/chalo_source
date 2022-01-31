package app.zophop.models;

import android.content.Context;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import app.zophop.models.mTicketing.ProductPromotionsObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ReportProblemImpl implements x20 {
    private static final String KEY_REPORT_PROBLEM_TYPE_METADATA = "reportProblemMetadata";
    public static final String PROBLEM_TYPE_ACTIVATION_SCREEN_TICKETING_PROBLEMS = "activationScreenTicketingProblems";
    public static final String PROBLEM_TYPE_GENERAL_PROBLEMS = "generalProblems";
    public static final String PROBLEM_TYPE_QRCODE_TICKETING_PROBLEMS = "qrCodeScreenTicketingProblems";
    public static final String PROBLEM_TYPE_STOP_ETA = "stopEta";
    public static final String PROBLEM_TYPE_TICKETING_PROBLEMS = "otherTicketingProblems";

    public ReportProblemImpl(Context context) {
    }

    private ReportProblemMetadata getReportProblemMetaFromJson(String str, String str2, String str3) throws JSONException {
        JSONObject jSONObject;
        if (!(str == null || str2 == null)) {
            JSONObject jSONObject2 = new JSONObject(str);
            String string = jSONObject2.getString("tags");
            HashMap hashMap = new HashMap();
            try {
                JSONObject jSONObject3 = new JSONObject(string);
                Iterator<String> keys = jSONObject3.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject3.getString(next));
                }
            } catch (JSONException e) {
                b00 b00 = b00.f358a;
                hj1.W0(e);
            }
            JSONObject jSONObject4 = jSONObject2.getJSONObject(KEY_REPORT_PROBLEM_TYPE_METADATA);
            if (jSONObject4.has(str2)) {
                JSONObject jSONObject5 = jSONObject4.getJSONObject(str2);
                if (str3 == null || !jSONObject5.has(str3.toLowerCase())) {
                    jSONObject = jSONObject5.has(ProductDiscountsObject.KEY_PRODUCT_TYPE_DEFAULT) ? jSONObject5.getJSONObject(ProductDiscountsObject.KEY_PRODUCT_TYPE_DEFAULT) : null;
                } else {
                    jSONObject = jSONObject5.getJSONObject(str3.toLowerCase());
                }
                if (jSONObject != null) {
                    ReportProblemMetadata reportProblemMetadata = new ReportProblemMetadata();
                    reportProblemMetadata.setTitle(jSONObject.getString(ProductPromotionsObject.KEY_TITLE));
                    reportProblemMetadata.setHint(jSONObject.optString("hint", null));
                    JSONArray jSONArray = jSONObject.getJSONArray("tags");
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        arrayList.add(jSONArray.getString(i));
                    }
                    reportProblemMetadata.setTagList(arrayList);
                    reportProblemMetadata.setTagDetailsMap(hashMap);
                    return reportProblemMetadata;
                }
            }
        }
        return null;
    }

    @Override // defpackage.x20
    public ReportProblemMetadata getReportProblemMetadata(String str, String str2) {
        String f = xt.f3961a.t().f(ut.F);
        if (f == null) {
            return null;
        }
        try {
            return getReportProblemMetaFromJson(f, str, str2);
        } catch (Exception e) {
            e.getMessage();
            b00 b00 = b00.f358a;
            b00.a().b(e);
            return null;
        }
    }
}
