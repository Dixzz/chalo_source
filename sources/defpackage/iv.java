package defpackage;

import app.zophop.models.AutoCabAggregatorInfo;
import app.zophop.models.AutoCabInfo;
import app.zophop.models.AutoCabResponse;
import app.zophop.models.VehicleType;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: iv  reason: default package */
/* compiled from: AutoCabResponseConverter */
public class iv {
    public AutoCabResponse a(JSONObject jSONObject) throws Exception {
        jSONObject.toString();
        JSONArray jSONArray = jSONObject.getJSONArray("autoCabs");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            String string = jSONObject2.getString("aggregatorName");
            VehicleType valueOf = VehicleType.valueOf(jSONObject2.get("vehicleType").toString());
            valueOf.toString();
            ArrayList arrayList2 = new ArrayList();
            if (jSONObject2.has("autoCabs")) {
                JSONArray jSONArray2 = jSONObject2.getJSONArray("autoCabs");
                jSONArray2.toString();
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    JSONObject jSONObject3 = jSONArray2.getJSONObject(i2);
                    AutoCabInfo autoCabInfo = new AutoCabInfo(jSONObject3.getString("name"), jSONObject3.getInt("eta_time_in_minutes"), jSONObject3.getInt("min_journey_time_in_minutes"), jSONObject3.getInt("max_journey_time_in_minutes"), jSONObject3.getString("currency_type"), jSONObject3.getInt("lower_fare_amount_bound"), jSONObject3.getInt("upper_fare_amount_bound"), jSONObject3.getInt("distance_in_meters"), jSONObject3.getString("id"));
                    arrayList2.add(autoCabInfo);
                    autoCabInfo.toString();
                }
            }
            if (arrayList2.size() > 0) {
                arrayList.add(new AutoCabAggregatorInfo(string, valueOf, arrayList2));
            }
        }
        return new AutoCabResponse(arrayList);
    }
}
