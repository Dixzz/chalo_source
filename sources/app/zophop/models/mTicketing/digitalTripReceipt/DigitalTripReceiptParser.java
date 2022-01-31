package app.zophop.models.mTicketing.digitalTripReceipt;

import app.zophop.models.mTicketing.superPass.SuperPassConstants;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: DigitalTripReceiptParser.kt */
public final class DigitalTripReceiptParser {
    public static final DigitalTripReceiptParser INSTANCE = new DigitalTripReceiptParser();

    private DigitalTripReceiptParser() {
    }

    private final SuperPassTripReceipt getSuperPassTripReceipt(String str, String str2, String str3, JSONObject jSONObject) {
        List list;
        long j = jSONObject.getLong(DigitalTripReceiptJsonKeys.KEY_ACTIVATION_TIME);
        long optLong = jSONObject.optLong(DigitalTripReceiptJsonKeys.KEY_PUNCH_TIME, -1);
        String optString = jSONObject.optString(DigitalTripReceiptJsonKeys.KEY_VEHICLE_NO, "");
        String optString2 = jSONObject.optString(DigitalTripReceiptJsonKeys.KEY_CONDUCTOR_ID, "");
        String optString3 = jSONObject.optString(DigitalTripReceiptJsonKeys.KEY_START_STOP, "");
        String optString4 = jSONObject.optString(DigitalTripReceiptJsonKeys.KEY_END_STOP, "");
        String optString5 = jSONObject.optString("routeName", "");
        if (jSONObject.has("specialFeatures")) {
            list = (List) new Gson().fromJson(jSONObject.getString("specialFeatures"), new DigitalTripReceiptParser$getSuperPassTripReceipt$lSpecialFeatures$lListType$1().getType());
        } else {
            list = new ArrayList();
        }
        n86.d(optString, "lVehicleNo");
        n86.d(optString2, "lConductorId");
        n86.d(optString3, "lStartStopName");
        n86.d(optString4, "lEndStopName");
        n86.d(optString5, "lRouteName");
        n86.d(list, "lSpecialFeatures");
        return new SuperPassTripReceipt(str, str2, str3, j, optLong, optString, optString2, optString3, optString4, optString5, list);
    }

    private final boolean isValidSuperPassReceiptList(String str, String str2) {
        if (n86.a(str, SuperPassConstants.PRODUCT_TYPE_SUPER_PASS)) {
            return n86.a(str2, SuperPassConstants.SUBTYPE_RIDE_PASS) || n86.a(str2, "magicPass");
        }
        return false;
    }

    public final List<SuperPassTripReceipt> parseSuperPassTripReceiptsHistoryObject(JSONObject jSONObject) {
        n86.e(jSONObject, "lJSONObject");
        String string = jSONObject.getString("passId");
        String string2 = jSONObject.getString("productType");
        String string3 = jSONObject.getString("productSubType");
        n86.d(string2, "lProductType");
        n86.d(string3, "lProductSubType");
        if (!isValidSuperPassReceiptList(string2, string3)) {
            return null;
        }
        JSONArray jSONArray = jSONObject.getJSONArray(DigitalTripReceiptJsonKeys.KEY_TRIPS);
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int length = jSONArray.length();
        if (length > 0) {
            while (true) {
                int i2 = i + 1;
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                n86.d(string, "lPassId");
                n86.d(jSONObject2, "lTripObject");
                arrayList.add(getSuperPassTripReceipt(string, string2, string3, jSONObject2));
                if (i2 >= length) {
                    break;
                }
                i = i2;
            }
        }
        return arrayList;
    }
}
