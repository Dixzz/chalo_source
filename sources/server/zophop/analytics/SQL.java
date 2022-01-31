package server.zophop.analytics;

import app.zophop.models.mTicketing.digitalTripReceipt.DigitalTripReceiptJsonKeys;
import j$.util.DesugarTimeZone;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONObject;
import server.zophop.logging.LoggingConstants;

public class SQL {
    private static final SimpleDateFormat FORMATTER;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        FORMATTER = simpleDateFormat;
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("IST"));
    }

    public static String fetchEtaAccuracyData(JSONObject jSONObject) {
        long j = jSONObject.getLong("arrivalTime");
        StringBuilder i0 = hj1.i0("select * from eta_accuracy where vehicle_no like '");
        i0.append(jSONObject.getString(DigitalTripReceiptJsonKeys.KEY_VEHICLE_NO));
        i0.append("' and route_id like '");
        i0.append(jSONObject.getString(LoggingConstants.ROUTE_ID));
        i0.append("' and stop_id like '");
        i0.append(jSONObject.getString("stopId"));
        i0.append("' and predicted_arrival_time >'");
        SimpleDateFormat simpleDateFormat = FORMATTER;
        i0.append(simpleDateFormat.format(new Date(j - 900000)));
        i0.append("' and predicted_arrival_time <'");
        i0.append(simpleDateFormat.format(new Date(j + 900000)));
        i0.append("';");
        return i0.toString();
    }

    public static String getETAQuery(HashMap hashMap) {
        StringBuilder i0 = hj1.i0("insert into eta values('");
        i0.append(hashMap.get("city"));
        i0.append("','");
        i0.append(hashMap.get("agency"));
        i0.append("','");
        i0.append(hashMap.get("mode"));
        i0.append("','");
        i0.append(hashMap.get(DigitalTripReceiptJsonKeys.KEY_VEHICLE_NO));
        i0.append("','");
        i0.append(hashMap.get(LoggingConstants.ROUTE_ID));
        i0.append("','");
        i0.append(hashMap.get("routeName"));
        i0.append("','");
        i0.append(hashMap.get("stopA"));
        i0.append("','");
        i0.append(hashMap.get("stopB"));
        i0.append("','");
        i0.append(hashMap.get("stopAId"));
        i0.append("','");
        i0.append(hashMap.get("stopBId"));
        i0.append("','");
        i0.append(hashMap.get("id"));
        i0.append("',");
        i0.append(hashMap.get("eta"));
        i0.append(",'");
        SimpleDateFormat simpleDateFormat = FORMATTER;
        i0.append(simpleDateFormat.format(new Date(((Long) hashMap.get("stopAtime")).longValue())));
        i0.append("','");
        i0.append(simpleDateFormat.format(new Date(((Long) hashMap.get("createdAt")).longValue())));
        i0.append("','");
        i0.append(simpleDateFormat.format(new Date(((Long) hashMap.get("lastUpdatedAt")).longValue())));
        i0.append("','");
        i0.append(hashMap.get("streamId"));
        i0.append("','");
        i0.append(new Timestamp(((Long) hashMap.get("stopBtime")).longValue()));
        i0.append("')");
        return i0.toString();
    }

    public static String getEtaAccuracyQuery(HashMap hashMap) {
        StringBuilder i0 = hj1.i0("insert into eta_accuracy values('");
        i0.append(hashMap.get("city"));
        i0.append("','");
        i0.append(hashMap.get("agency"));
        i0.append("','");
        i0.append(hashMap.get("mode"));
        i0.append("','");
        i0.append(hashMap.get(DigitalTripReceiptJsonKeys.KEY_VEHICLE_NO));
        i0.append("','");
        i0.append(hashMap.get(LoggingConstants.ROUTE_ID));
        i0.append("','");
        i0.append(hashMap.get("routeName"));
        i0.append("','");
        i0.append(hashMap.get("stopB"));
        i0.append("','");
        i0.append(hashMap.get("stopBId"));
        i0.append("',");
        i0.append(hashMap.get("eta"));
        i0.append(",'");
        SimpleDateFormat simpleDateFormat = FORMATTER;
        i0.append(simpleDateFormat.format(new Date(((Long) hashMap.get("createdAt")).longValue())));
        i0.append("','");
        i0.append(simpleDateFormat.format(new Date(((Long) hashMap.get("lastUpdatedAt")).longValue())));
        i0.append("','");
        i0.append(simpleDateFormat.format(new Date(((Long) hashMap.get("stopBtime")).longValue())));
        i0.append("','");
        i0.append(hashMap.get("streamId"));
        i0.append("',null,");
        i0.append(hashMap.get(LoggingConstants.DISTANCE));
        i0.append(")");
        return i0.toString();
    }

    public static String getStopArrivalQuery(HashMap hashMap) {
        StringBuilder i0 = hj1.i0("insert into arrivaltime values('");
        i0.append(hashMap.get("busNumber"));
        i0.append("','");
        i0.append(hashMap.get("streamId"));
        i0.append("','");
        i0.append(hashMap.get(LoggingConstants.ROUTE_ID));
        i0.append("','");
        i0.append(hashMap.get("routeName"));
        i0.append("','");
        i0.append(hashMap.get("agency"));
        i0.append("','");
        i0.append(hashMap.get("city"));
        i0.append("','");
        i0.append(hashMap.get("stopId"));
        i0.append("','");
        i0.append(hashMap.get("stopName"));
        i0.append("',");
        i0.append(hashMap.get("stopLatitude"));
        i0.append(",");
        i0.append(hashMap.get("stopLongitude"));
        i0.append(",");
        i0.append(hashMap.get("stopIndex"));
        i0.append(",'");
        i0.append(new Timestamp(((Long) hashMap.get("arrivalTime")).longValue()));
        i0.append("')");
        return i0.toString();
    }

    public static String updateEtaAccuracyData(JSONObject jSONObject, String str) {
        StringBuilder i0 = hj1.i0("update eta_accuracy set stop_arrival_time = '");
        i0.append(FORMATTER.format(new Date(((Long) jSONObject.get("arrivalTime")).longValue())));
        i0.append("' where stop_id like '");
        i0.append((String) jSONObject.get("stopId"));
        return hj1.b0(i0, "' and stream_id like '", str, "'");
    }
}
