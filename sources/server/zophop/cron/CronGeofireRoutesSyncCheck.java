package server.zophop.cron;

import app.zophop.models.mTicketing.ProductDiscountsObject;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import server.zophop.CS;
import server.zophop.Constants;
import server.zophop.TaskCategory;
import server.zophop.TaskType;
import server.zophop.dataLayer.Firebase.FirebaseUtils;
import server.zophop.logging.LoggingConstants;
import server.zophop.logicLayer.CsLogic;
import server.zophop.logicLayer.DataContainer;
import server.zophop.models.SimpleLogger;
import server.zophop.queue.BasicTask;
import server.zophop.queue.RabbitMQ;

public class CronGeofireRoutesSyncCheck {
    private static final String CITY = "CHANDIGARH";
    private static Firebase _gpsVehicles;
    private static RabbitMQ _rabbitMQ;
    private Firebase _base;
    private int _bugCount = 0;
    private DataContainer _container;
    private CsLogic _csLogic;
    private int _duplicateCount = 0;
    private Firebase _eta;
    private int _etaCount = 0;
    private Firebase _geofire;
    private int _routeCount = 0;
    private Firebase _routes;
    private Firebase _sessions;
    private int _totalCount = 0;
    private CS cs = new CS();
    private HashMap<String, String> vehicleToStreamMap;
    private HashMap<String, Long> vehicleToTimeStamp;

    public CronGeofireRoutesSyncCheck(Firebase firebase2) {
        CS.ENVIRONMENT.valueOf("production");
        this._base = firebase2;
        this._sessions = firebase2.child(LoggingConstants.SESSION);
        this._geofire = this._base.child("geofire").child(CITY);
        this._eta = this._base.child("eta").child(CITY);
        this._routes = this._base.child(ProductDiscountsObject.KEY_ROUTES).child(CITY);
        this._container = DataContainer.getDataContainer();
        this._csLogic = new CsLogic();
        _gpsVehicles = this._base.child(Constants.GPS_DISPATCH);
        RabbitMQ rabbitMQ = new RabbitMQ(1, Constants.getExchange(), TaskCategory.APPLICATION);
        _rabbitMQ = rabbitMQ;
        rabbitMQ.init();
    }

    private boolean compareConsistency(DataSnapshot dataSnapshot) {
        try {
            JSONObject jSONObject = new JSONObject(dataSnapshot.getKey());
            String string = jSONObject.getString("_streamId");
            String string2 = jSONObject.getString("_routeId");
            Map geofireData = getGeofireData(dataSnapshot);
            System.out.println(string);
            System.out.println(" time :" + geofireData.get("time") + " eta : " + geofireData.get("nextStopEta") + " stop : " + geofireData.get("nextStopId"));
            Map etaData = getEtaData((String) geofireData.get("nextStopId"), string2, string);
            if (etaData != null) {
                long longValue = ((Long) etaData.get("_eta")).longValue();
                long longValue2 = ((Long) etaData.get("_timeStamp")).longValue();
                System.out.println(" time :" + longValue2 + " eta : " + longValue);
            } else {
                this._etaCount++;
            }
            DataSnapshot routeData = getRouteData(string2, string);
            if (routeData != null) {
                JSONObject jSONObject2 = new JSONObject(routeData.getValue().toString());
                int i = jSONObject2.getInt("_eta");
                jSONObject2.getString("_stopId");
                long j = jSONObject2.getLong("_time");
                System.out.println(" time :" + j + " eta : " + i);
            } else {
                this._routeCount++;
            }
            System.out.println();
            System.out.println();
            return false;
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
            return false;
        }
    }

    private Map getEtaData(String str, String str2, String str3) {
        return (Map) FirebaseUtils.getSynchronizedDataSnapshot(this._eta.child(str).child(str2).child(str3)).getValue();
    }

    private Map getGeofireData(DataSnapshot dataSnapshot) {
        return (Map) ((Map) FirebaseUtils.getSynchronizedDataSnapshot(this._geofire.child(dataSnapshot.getKey())).getValue()).get("data");
    }

    private DataSnapshot getRouteData(String str, String str2) {
        System.out.println(System.currentTimeMillis());
        return FirebaseUtils.getSynchronizedDataSnapshot(this._routes.child(str).child(str2));
    }

    private Map getStremaData(String str) {
        return (Map) FirebaseUtils.getSynchronizedDataSnapshot(this._sessions.child(str)).getValue();
    }

    public static void main(String[] strArr) {
        new CronGeofireRoutesSyncCheck(new Firebase("https://dazzling-fire-3689.firebaseio.com/").child("production")).execute();
    }

    private void procesQuery() {
        for (DataSnapshot dataSnapshot : FirebaseUtils.getSynchronizedDataSnapshot(this._geofire).getChildren()) {
            if (compareConsistency(dataSnapshot)) {
                System.out.println(dataSnapshot.toString());
            }
        }
    }

    public void execute() {
        SimpleLogger.info("status check job executed");
        procesQuery();
        StringBuilder i0 = hj1.i0("total count :");
        i0.append(this._totalCount);
        SimpleLogger.info(i0.toString());
        SimpleLogger.info("closed count :" + this._etaCount);
        SimpleLogger.info("expiry count :" + this._routeCount);
        SimpleLogger.info("bug count :" + this._bugCount);
        SimpleLogger.info("duplicate count :" + this._duplicateCount);
        logDuplicateCount();
        this._etaCount = 0;
        this._bugCount = 0;
        this._routeCount = 0;
        this._totalCount = 0;
    }

    public void logDuplicateCount() {
        HashMap hashMap = new HashMap();
        hashMap.put("duplicateCount", Integer.valueOf(this._duplicateCount));
        hashMap.put("expiryCount", Integer.valueOf(this._routeCount));
        hashMap.put("bugCount", Integer.valueOf(this._bugCount));
        hashMap.put("totalCount", Integer.valueOf(this._totalCount));
        hashMap.put("type", "cronSessionStat");
        hashMap.put("timeStamp", Long.valueOf(System.currentTimeMillis()));
        BasicTask basicTask = new BasicTask("geofire", TaskType.GEOFIRE_CRON, hashMap);
        System.out.println(hashMap.toString());
        _rabbitMQ.addTask(TaskCategory.LOGGING, basicTask);
    }
}
