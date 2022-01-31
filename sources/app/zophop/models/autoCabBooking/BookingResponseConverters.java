package app.zophop.models.autoCabBooking;

import android.net.Uri;
import com.google.android.gms.maps.model.LatLng;
import org.json.JSONException;
import org.json.JSONObject;

public class BookingResponseConverters {
    public BookingCode getBookingCode(JSONObject jSONObject) throws JSONException {
        return BookingCode.getBookingCode(jSONObject.get("_code").toString());
    }

    public BookingDetails getBookingDetails(JSONObject jSONObject, BookingDetails bookingDetails) throws JSONException {
        bookingDetails.setRequestId(jSONObject.getString("_requestId"));
        bookingDetails.setLastUpdatedTime(System.currentTimeMillis());
        bookingDetails.setCode(getBookingCode(jSONObject));
        if (jSONObject.has("_vehicleInfo")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("_vehicleInfo");
            bookingDetails.setVehicleInfo(new BookingVehicleInfo(jSONObject2.getString("_driverName"), jSONObject2.getString("_driverNumber"), Double.parseDouble(jSONObject2.get("_driverRating").toString()), jSONObject2.getString("_carNumber"), jSONObject2.getString("_carModel"), jSONObject2.getString("_driverImage")));
        }
        if (jSONObject.has("_currentLat") && jSONObject.has("_currentLon")) {
            bookingDetails.setCurrentLocation(new LatLng(Double.parseDouble(jSONObject.get("_currentLat").toString()), Double.parseDouble(jSONObject.get("_currentLon").toString())));
        }
        if (jSONObject.has("_bearing")) {
            bookingDetails.setBearing(Integer.parseInt(jSONObject.get("_bearing").toString()));
        }
        if (jSONObject.has("_destinationLat") && jSONObject.has("_destinationLon") && bookingDetails.getToLocation() == null) {
            bookingDetails.setToLocation(new mf1(new LatLng(Double.parseDouble(jSONObject.get("_destinationLat").toString()), Double.parseDouble(jSONObject.get("_destinationLon").toString()))));
        }
        if (jSONObject.has("_eta")) {
            bookingDetails.setEta(Integer.parseInt(jSONObject.get("_eta").toString()));
        }
        if (jSONObject.has("_href")) {
            bookingDetails.setHref(Uri.parse(jSONObject.getString("_href")).toString());
        }
        return bookingDetails;
    }

    public ad1 getResponseType(JSONObject jSONObject) throws JSONException {
        return ad1.valueOf(jSONObject.get("_responseType").toString());
    }
}
