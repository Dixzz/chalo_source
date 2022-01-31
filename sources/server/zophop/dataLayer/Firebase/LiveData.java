package server.zophop.dataLayer.Firebase;

import com.firebase.ZophopGeofire.GeoFire;
import com.firebase.ZophopGeofire.GeoLocation;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.google.firebase.crashlytics.internal.settings.SettingsJsonConstants;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import server.zophop.CS;
import server.zophop.dataLayer.Redis.RedisUtils;
import server.zophop.models.FirebaseRef;
import server.zophop.models.GeoRealTimeInfo;
import server.zophop.models.Point;
import server.zophop.models.RealTimeRouteInfo;
import server.zophop.models.SimpleLogger;
import server.zophop.models.Stop;
import server.zophop.models.Stream;
import server.zophop.utils.DataMapCreator;
import server.zophop.utils.DataObjectCreator;

public class LiveData {
    private static DataMapCreator _dataMapCreator = new DataMapCreator();
    private static CS.ENVIRONMENT _environment;
    public static FirebaseRef _firebaseRef;
    private static RedisUtils redisUtils;

    public LiveData() {
        _firebaseRef = FirebaseRef.getInstance();
        redisUtils = new RedisUtils();
    }

    private static String getGeoFireKey(RealTimeRouteInfo realTimeRouteInfo, String str, String str2) {
        GeoRealTimeInfo geoRealTimeInfo = new GeoRealTimeInfo(validateFirebasePath(realTimeRouteInfo), str, str2);
        SimpleLogger.debug(new Gson().toJson(geoRealTimeInfo));
        return new Gson().toJson(geoRealTimeInfo);
    }

    public static List<Point> getPointsForStream(String str, String str2) {
        DataSnapshot synchronizedDataSnapshot = FirebaseUtils.getSynchronizedDataSnapshot(FirebaseRef.getPointsRef(str2).child(str));
        ArrayList arrayList = new ArrayList();
        return (synchronizedDataSnapshot == null || synchronizedDataSnapshot.getValue() == null) ? arrayList : DataObjectCreator.extractPoints(synchronizedDataSnapshot);
    }

    public static void printErrorDetails(FirebaseError firebaseError) {
        if (firebaseError != null) {
            StringBuilder i0 = hj1.i0("firebase error ");
            i0.append(firebaseError.getMessage());
            i0.append(" details ");
            i0.append(firebaseError.getDetails());
            i0.append(" \nexception ");
            i0.append(firebaseError.toException());
            SimpleLogger.severe(i0.toString());
        }
    }

    public static void putLastKnownPoint(Stream stream, RealTimeRouteInfo realTimeRouteInfo, Point point, Stop stop, int i) {
        GeoFire geoFire = new GeoFire(_firebaseRef.getGeofireRef(stream.getCity()).child(stream.getCity().toUpperCase()));
        String geoFireKey = getGeoFireKey(realTimeRouteInfo, stream.getStreamId(), stream.getUserId());
        geoFire.setLocation(geoFireKey, new GeoLocation(point.getLatitude(), point.getLongitude(), DataMapCreator.getGeoFireMap(stop.getId(), stop.getName(), (long) i, point)));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("nextStopEta", i);
        jSONObject.put("nextStopId", stop.getId());
        jSONObject.put("nextStopName", stop.getName());
        jSONObject.put("time", Long.valueOf(point.getTime()));
        jSONObject.put("lat", point.getLatitude());
        jSONObject.put("lon", point.getLongitude());
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(SettingsJsonConstants.SESSION_KEY, new JSONObject(geoFireKey));
        jSONObject2.put("parameters", jSONObject);
        redisUtils.geoAdd(stream.getCity().toLowerCase(), stream.getStreamId(), point.getLatitude(), point.getLongitude());
        redisUtils.put(stream.getStreamId(), jSONObject2.toString(), 300);
    }

    public static void removeFromRouteIndex(String str, RealTimeRouteInfo realTimeRouteInfo, String str2, String str3) {
        Firebase routesRef = _firebaseRef.getRoutesRef(str);
        Firebase geofireRef = _firebaseRef.getGeofireRef(str);
        routesRef.child(str.toUpperCase()).child(realTimeRouteInfo.getRouteId()).child(str2).removeValue(new Firebase.CompletionListener() {
            /* class server.zophop.dataLayer.Firebase.LiveData.AnonymousClass1 */

            public void onComplete(FirebaseError firebaseError, Firebase firebase2) {
                LiveData.printErrorDetails(firebaseError);
            }
        });
        new GeoFire(geofireRef.child(str.toUpperCase())).removeLocation(getGeoFireKey(realTimeRouteInfo, str2, str3));
    }

    public static void removeGeoEntry(String str, String str2, String str3) {
        new GeoFire(_firebaseRef.getGeofireRef(str).child(str.toUpperCase())).removeLocation(str3);
    }

    public static void storeLiveData(Map<String, Object> map, String str) {
        FirebaseRef.getBaseUrl(str).updateChildren(map, new Firebase.CompletionListener() {
            /* class server.zophop.dataLayer.Firebase.LiveData.AnonymousClass3 */

            public void onComplete(FirebaseError firebaseError, Firebase firebase2) {
                SimpleLogger.info("Live data update !");
                LiveData.printErrorDetails(firebaseError);
            }
        });
    }

    public static void storePoint(String str, Point point, String str2) {
        Firebase pointsRef = FirebaseRef.getPointsRef(str2);
        pointsRef.child(str).push().updateChildren(_dataMapCreator.getPointMap(point), new Firebase.CompletionListener() {
            /* class server.zophop.dataLayer.Firebase.LiveData.AnonymousClass2 */

            public void onComplete(FirebaseError firebaseError, Firebase firebase2) {
                LiveData.printErrorDetails(firebaseError);
            }
        });
    }

    private static RealTimeRouteInfo validateFirebasePath(RealTimeRouteInfo realTimeRouteInfo) {
        String validateFirebasePath = validateFirebasePath(realTimeRouteInfo.getFromName());
        String validateFirebasePath2 = validateFirebasePath(realTimeRouteInfo.getToName());
        return new RealTimeRouteInfo(realTimeRouteInfo.getRouteId(), validateFirebasePath(realTimeRouteInfo.getRouteName()), validateFirebasePath, validateFirebasePath2, realTimeRouteInfo.getMode().toUpperCase(), realTimeRouteInfo.getAgencyName(), validateFirebasePath(realTimeRouteInfo.getVehicleId()));
    }

    private static String validateFirebasePath(String str) {
        return str.replace(".", "");
    }
}
