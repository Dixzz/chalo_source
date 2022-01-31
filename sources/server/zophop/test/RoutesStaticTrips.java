package server.zophop.test;

import app.zophop.models.mTicketing.digitalTripReceipt.DigitalTripReceiptJsonKeys;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import server.zophop.Constants;
import server.zophop.dataLayer.Firebase.FirebaseUtils;
import server.zophop.models.Point;
import server.zophop.utils.DistanceUtils;
import server.zophop.utils.HttpUtils;
import server.zophop.utils.UrlFetchUtils;

public class RoutesStaticTrips {
    public static final String URL = "http://production-scheduler-8-9-2014-1194732512.ap-southeast-1.elb.amazonaws.com:8080/scheduler_v4/v4/INDORE/routedetails";
    private static final Firebase _base;
    private static final Firebase _trips;

    static {
        Firebase child = new Firebase("https://dazzling-fire-3689.firebaseio.com/").child("production");
        _base = child;
        _trips = child.child(Constants.CITY_DATA).child("indore").child("Trips").child("BUS");
    }

    private static List<Point> getPoints(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            arrayList.add(new Point(jSONObject.getDouble("stop_lat"), jSONObject.getDouble("stop_lon"), 0, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
        }
        return arrayList;
    }

    public static JSONObject getRouteDetails(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            return new JSONObject(UrlFetchUtils.sendGet(HttpUtils.generateUrl(URL, hj1.n0("route_id", str, "day", "wednesday"))));
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
            return jSONObject;
        }
    }

    public static double getRouteDistance(JSONObject jSONObject) {
        System.out.println(jSONObject.toString());
        return DistanceUtils.getDistanceCoveredByPoints(getPoints(jSONObject.getJSONObject("route").getJSONArray("stopSequenceWithDetails")));
    }

    public static int getTotalFrequencyCount(JSONObject jSONObject) {
        JSONArray jSONArray = jSONObject.getJSONArray(DigitalTripReceiptJsonKeys.KEY_TRIPS);
        int i = 0;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
            i = jSONObject2.has("frequency_data_array") ? getTripsCount(i, jSONObject2) : i + 1;
        }
        return i;
    }

    public static int getTripsCount(int i, JSONObject jSONObject) {
        JSONArray jSONArray = jSONObject.getJSONArray("frequency_data_array");
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            i = getTripsCount(i, jSONArray, i2);
            System.out.println(i);
        }
        return i;
    }

    public static void main(String[] strArr) throws IOException {
        PrintWriter printWriter = new PrintWriter(new File("/home/chetan/Desktop/repo/18-oct/backend/aictsl_static.csv"));
        StringBuilder sb = new StringBuilder();
        sb.append("Static");
        sb.append(',');
        sb.append("Frequncy");
        sb.append(',');
        sb.append("Total");
        sb.append(',');
        sb.append('\n');
        for (DataSnapshot dataSnapshot : FirebaseUtils.getSynchronizedDataSnapshot(_trips).getChildren()) {
            JSONObject routeDetails = getRouteDetails(dataSnapshot.getKey().toString());
            double routeDistance = getRouteDistance(routeDetails);
            int totalFrequencyCount = getTotalFrequencyCount(routeDetails);
            sb.append(routeDetails.getJSONObject("route").getString("route_name"));
            sb.append(',');
            sb.append(routeDetails.getJSONObject("route").getString("route_id"));
            sb.append(',');
            sb.append(dataSnapshot.getKey().toString());
            sb.append(',');
            sb.append((int) routeDistance);
            sb.append(',');
            sb.append(totalFrequencyCount);
            sb.append(',');
            sb.append((int) (((double) totalFrequencyCount) * routeDistance));
            sb.append(',');
            sb.append('\n');
        }
        printWriter.write(sb.toString());
        printWriter.close();
        System.out.println("done!");
    }

    public static int getTripsCount(int i, JSONArray jSONArray, int i2) {
        JSONObject jSONObject = jSONArray.getJSONObject(i2);
        System.out.println(jSONObject.toString());
        int i3 = jSONObject.getInt("frequency") * 60;
        int i4 = jSONObject.getInt("end_time") - jSONObject.getInt("start_time");
        System.out.println(i4);
        System.out.println(i3);
        if (i3 == 0) {
            i3 = 1;
        }
        return (int) (Math.ceil((double) (i4 / i3)) + ((double) i));
    }
}
