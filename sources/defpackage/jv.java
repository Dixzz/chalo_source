package defpackage;

import app.zophop.models.autoCabBooking.BookingCode;
import app.zophop.models.autoCabBooking.BookingDetails;
import app.zophop.models.autoCabBooking.BookingVehicleInfo;
import com.google.android.gms.maps.model.LatLng;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: jv  reason: default package */
/* compiled from: BookingDetailsConverter */
public class jv {
    public BookingDetails a(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        String string = jSONObject.getString("req_id");
        BookingCode valueOf = BookingCode.valueOf(jSONObject.getString("code"));
        BookingVehicleInfo bookingVehicleInfo = null;
        String optString = jSONObject.optString("vehicle_info", null);
        if (optString != null) {
            JSONObject jSONObject2 = new JSONObject(optString);
            double d = jSONObject2.getDouble("rating");
            String string2 = jSONObject2.getString("car_number");
            String string3 = jSONObject2.getString("car_model");
            bookingVehicleInfo = new BookingVehicleInfo(jSONObject2.getString("driver_name"), jSONObject2.getString("driver_number"), d, string2, string3, jSONObject2.getString("image_url"));
        }
        String obj = jSONObject.get("provider").toString();
        int i = jSONObject.getInt("eta_minutes");
        BookingDetails bookingDetails = new BookingDetails(obj, mf1.a(jSONObject.getString("from_location")), null, jSONObject.getString("product_id"), jSONObject.getString("product_name"));
        if (jSONObject.has("to_location")) {
            bookingDetails.setToLocation(mf1.a(jSONObject.getString("to_location")));
        }
        if (jSONObject.has("cLat") && jSONObject.has("cLon")) {
            bookingDetails.setCurrentLocation(new LatLng(jSONObject.getDouble("cLat"), jSONObject.getDouble("cLon")));
            bookingDetails.setBearing(jSONObject.getInt("bearing"));
        }
        long j = jSONObject.getLong("updated_time");
        bookingDetails.setSurgeMultiple(jSONObject.getDouble("surge"));
        bookingDetails.setLastUpdatedTime(j);
        bookingDetails.setCode(valueOf);
        bookingDetails.setVehicleInfo(bookingVehicleInfo);
        bookingDetails.setRequestId(string);
        bookingDetails.setEta(i);
        return bookingDetails;
    }

    public String b(BookingDetails bookingDetails) throws JSONException {
        String str;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("req_id", bookingDetails.getRequestId());
        BookingVehicleInfo vehicleInfo = bookingDetails.getVehicleInfo();
        if (vehicleInfo == null) {
            str = null;
        } else {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("driver_name", vehicleInfo.getDriverName());
            jSONObject2.put("driver_number", vehicleInfo.getDriverNumber());
            jSONObject2.put("car_number", vehicleInfo.getCarNumberPlate());
            jSONObject2.put("car_model", vehicleInfo.getCarModel());
            jSONObject2.put("rating", vehicleInfo.getDriverRating());
            jSONObject2.put("image_url", vehicleInfo.getImageUrl());
            str = jSONObject2.toString();
        }
        jSONObject.put("vehicle_info", str);
        jSONObject.put("provider", bookingDetails.getProvider());
        jSONObject.put("code", bookingDetails.getCode().name());
        jSONObject.put("from_location", bookingDetails.getFromLocation().b());
        if (bookingDetails.getToLocation() != null) {
            jSONObject.put("to_location", bookingDetails.getToLocation().b());
        }
        jSONObject.put("updated_time", bookingDetails.getLastUpdatedTime());
        jSONObject.put("eta_minutes", bookingDetails.getEta());
        jSONObject.put("surge", bookingDetails.getSurgeMultiple());
        jSONObject.put("product_id", bookingDetails.getProductId());
        jSONObject.put("product_name", bookingDetails.getProductName());
        if (bookingDetails.getCurrentLocation() != null) {
            jSONObject.put("cLat", bookingDetails.getCurrentLocation().latitude);
            jSONObject.put("cLon", bookingDetails.getCurrentLocation().longitude);
            jSONObject.put("bearing", bookingDetails.getBearing());
        }
        return jSONObject.toString();
    }
}
