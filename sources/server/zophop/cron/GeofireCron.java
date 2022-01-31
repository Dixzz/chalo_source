package server.zophop.cron;

import app.zophop.models.mTicketing.ProductDiscountsObject;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.MutableData;
import com.firebase.client.Query;
import com.firebase.client.Transaction;
import com.google.common.util.concurrent.SettableFuture;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import server.zophop.CS;
import server.zophop.Constants;
import server.zophop.TaskCategory;
import server.zophop.TaskType;
import server.zophop.dataLayer.Firebase.FirebaseUtils;
import server.zophop.dataLayer.Firebase.LiveData;
import server.zophop.dataLayer.Firebase.SessionData;
import server.zophop.dataLayer.Firebase.VehicleData;
import server.zophop.logging.LoggingConstants;
import server.zophop.logicLayer.CsLogic;
import server.zophop.logicLayer.DataContainer;
import server.zophop.models.CheckOutType;
import server.zophop.models.SimpleLogger;
import server.zophop.models.Stream;
import server.zophop.models.StreamStatus;
import server.zophop.queue.BasicTask;
import server.zophop.queue.RabbitMQ;

public class GeofireCron {
    private static Firebase _gpsVehicles;
    private static RabbitMQ _rabbitMQ;
    private Firebase _base;
    private int _bugCount = 0;
    private int _closedCount = 0;
    private DataContainer _container;
    private CsLogic _csLogic;
    private int _duplicateCount = 0;
    private Firebase _eta;
    private int _expiryCount = 0;
    private Firebase _geofire;
    private Firebase _routes;
    private Firebase _sessions;
    private int _totalCount = 0;
    private CS cs = new CS();
    private HashMap<String, String> vehicleToStreamMap;
    private HashMap<String, Long> vehicleToTimeStamp;

    public GeofireCron(Firebase firebase2) {
        CS.ENVIRONMENT.valueOf("production");
        this._base = firebase2;
        this._sessions = firebase2.child(LoggingConstants.SESSION);
        this._geofire = this._base.child("geofire");
        this._eta = this._base.child("eta");
        this._routes = this._base.child(ProductDiscountsObject.KEY_ROUTES);
        this._container = DataContainer.getDataContainer();
        this._csLogic = new CsLogic();
        _gpsVehicles = this._base.child(Constants.GPS_DISPATCH);
        RabbitMQ rabbitMQ = new RabbitMQ(1, Constants.getExchange(), TaskCategory.APPLICATION);
        _rabbitMQ = rabbitMQ;
        rabbitMQ.init();
    }

    private void checkDuplicateSession(String str, String str2, String str3, String str4, String str5, long j, String str6, String str7) {
        if (!this.vehicleToTimeStamp.containsKey(str4)) {
            this.vehicleToStreamMap.put(str4, str5);
            this.vehicleToTimeStamp.put(str4, Long.valueOf(j));
        } else if (this.vehicleToTimeStamp.get(str4).longValue() > j) {
            System.out.println("duplicate stream and vehicle :" + str5 + " : " + str4);
            checkout(str, str2, str3, str4, str5, CheckOutType.external, str6, str7);
            this._duplicateCount = this._duplicateCount + 1;
        } else {
            PrintStream printStream = System.out;
            StringBuilder i0 = hj1.i0("duplicate stream and vehicle :");
            i0.append(this.vehicleToStreamMap.get(str4));
            i0.append(" : ");
            i0.append(str4);
            printStream.println(i0.toString());
            checkout(str, str2, str3, str4, this.vehicleToStreamMap.get(str4), CheckOutType.external, str6, str7);
            this._duplicateCount++;
            this.vehicleToStreamMap.put(str4, str5);
            this.vehicleToTimeStamp.put(str4, Long.valueOf(j));
        }
    }

    public static void checkOutIfOpen(String str, String str2, String str3, String str4, String str5, CheckOutType checkOutType, Runnable runnable) {
        _gpsVehicles.child(str.toLowerCase()).child(str2.toLowerCase()).child(str3.toLowerCase()).child("dispatch").child(str4).runTransaction(getTransactionHandler(str, str5, str4, checkOutType, runnable));
    }

    private void checkStatus(DataSnapshot dataSnapshot) {
        String key = dataSnapshot.getKey();
        for (DataSnapshot dataSnapshot2 : dataSnapshot.getChildren()) {
            this._totalCount++;
            checkStream(dataSnapshot2, key);
        }
    }

    private void checkStream(DataSnapshot dataSnapshot, String str) {
        Exception e;
        JSONObject jSONObject;
        Map map;
        try {
            String key = dataSnapshot.getKey();
            System.out.println(key);
            boolean isJSONValid = isJSONValid(dataSnapshot.getKey());
            new HashMap();
            new JSONObject();
            if (!isJSONValid) {
                String str2 = (String) ((Map) dataSnapshot.getValue()).keySet().iterator().next();
                System.out.println(key);
                try {
                    map = (Map) dataSnapshot.child(str2).getValue();
                    jSONObject = new JSONObject(key + str2);
                } catch (Exception e2) {
                    e = e2;
                    SimpleLogger.severe(e.toString());
                    SimpleLogger.severe(dataSnapshot.getKey());
                }
            } else {
                map = (Map) dataSnapshot.getValue();
                jSONObject = new JSONObject(dataSnapshot.getKey());
            }
            System.out.println(jSONObject);
            String string = jSONObject.getString("_streamId");
            Stream stream = SessionData.getStream(string, str);
            String userId = stream.getUserId();
            SimpleLogger.info(string);
            SimpleLogger.info(stream.status() + " : " + stream.getCity());
            Long l = (Long) ((Map) map.get("data")).get("time");
            SimpleLogger.info(String.valueOf(l));
            long currentTimeMillis = System.currentTimeMillis();
            if (stream.status().equals(StreamStatus.CLOSED)) {
                SimpleLogger.severe("status_closed    " + userId + "  " + string + " : " + stream.getCity() + " " + stream.status());
                this._csLogic.removeStream(string, str);
                LiveData.removeGeoEntry(str, stream.getAgency(), key);
                this._closedCount = this._closedCount + 1;
            } else if (currentTimeMillis - l.longValue() > 1200000) {
                SimpleLogger.severe("timeout " + (currentTimeMillis - l.longValue()) + "   " + userId + "  " + string + " : " + stream.getCity());
                checkout(stream.getCity(), stream.getStationType(), stream.getAgency(), userId, string, CheckOutType.timeout, stream.getSource(), key);
                this._expiryCount = this._expiryCount + 1;
            } else {
                checkDuplicateSession(stream.getCity(), stream.getStationType(), stream.getAgency(), userId, string, l.longValue(), stream.getSource(), key);
            }
        } catch (Exception e3) {
            e = e3;
            SimpleLogger.severe(e.toString());
            SimpleLogger.severe(dataSnapshot.getKey());
        }
    }

    private void checkout(final String str, String str2, final String str3, final String str4, final String str5, final CheckOutType checkOutType, String str6, final String str7) {
        if (str6.equals(LoggingConstants.CONDUCTOR) || str4.length() > 15) {
            closeSession(str5, str4, checkOutType, str);
            LiveData.removeGeoEntry(str, str3, str7);
            return;
        }
        VehicleData.cronCheckOutIfOpen(str, str2, str3, str4, str5, checkOutType, new Runnable() {
            /* class server.zophop.cron.GeofireCron.AnonymousClass1 */

            public void run() {
                GeofireCron.closeSession(str5, str4, checkOutType, str);
                LiveData.removeGeoEntry(str, str3, str7);
            }
        });
    }

    /* access modifiers changed from: private */
    public static void closeSession(String str, String str2, CheckOutType checkOutType, String str3) {
        if (str != null) {
            Map removeTaskData = getRemoveTaskData(str, StreamStatus.CLOSED, checkOutType, str3);
            BasicTask basicTask = new BasicTask(str2, TaskType.STATUS_CHANGED, removeTaskData);
            System.out.println(removeTaskData.toString());
            _rabbitMQ.addTask(basicTask);
        }
    }

    private static Map getRemoveTaskData(String str, StreamStatus streamStatus, CheckOutType checkOutType, String str2) {
        HashMap n0 = hj1.n0("streamId", str, "city", str2);
        n0.put(LoggingConstants.STREAM_STATUS, streamStatus.name());
        n0.put(Constants.CHECKOUT_TYPE, checkOutType.toString());
        return n0;
    }

    private static Transaction.Handler getTransactionHandler(String str, final String str2, String str3, CheckOutType checkOutType, final Runnable runnable) {
        return new Transaction.Handler() {
            /* class server.zophop.cron.GeofireCron.AnonymousClass2 */
            public String oldStream;

            public Transaction.Result doTransaction(MutableData mutableData) {
                String str = (String) mutableData.child("streamId").getValue();
                String str2 = (String) mutableData.child(LoggingConstants.ROUTE_ID).getValue();
                this.oldStream = str;
                if (str != null && str.equals(str2)) {
                    return Transaction.success(GeofireCron.processCheckout(mutableData));
                }
                if (str != null && !str.equals(str2)) {
                    return Transaction.success(mutableData);
                }
                if (str2 != null) {
                    return Transaction.success(GeofireCron.processCheckout(mutableData));
                }
                return Transaction.success(mutableData);
            }

            public void onComplete(FirebaseError firebaseError, boolean z, DataSnapshot dataSnapshot) {
                if (firebaseError == null && z && GeofireCron.isCheckedOut(dataSnapshot, this.oldStream)) {
                    runnable.run();
                }
            }
        };
    }

    /* access modifiers changed from: private */
    public static boolean isCheckedOut(DataSnapshot dataSnapshot, String str) {
        return (dataSnapshot.hasChild("streamId") ? (String) dataSnapshot.child("streamId").getValue() : null) == null && str != null;
    }

    public static void main(String[] strArr) {
        GeofireCron geofireCron = new GeofireCron(new Firebase(Constants.LIVE_FIREBASE_SHARD2).child("production"));
        GeofireCron geofireCron2 = new GeofireCron(new Firebase("https://dazzling-fire-3689.firebaseio.com/").child("production"));
        GeofireCron geofireCron3 = new GeofireCron(new Firebase(Constants.LIVE_FIREBASE_SHARD1).child("production"));
        GeofireCron geofireCron4 = new GeofireCron(new Firebase(Constants.LIVE_FIREBASE_UP).child("production"));
        GeofireCron geofireCron5 = new GeofireCron(new Firebase(Constants.LIVE_FIREBASE_SHARD3).child("production"));
        GeofireCron geofireCron6 = new GeofireCron(new Firebase(Constants.LIVE_FIREBASE_BIHAR).child("production"));
        GeofireCron geofireCron7 = new GeofireCron(new Firebase(Constants.LIVE_FIREBASE_ASSAM).child("production"));
        GeofireCron geofireCron8 = new GeofireCron(new Firebase(Constants.LIVE_FIREBASE_VIJAYWADA).child("production"));
        GeofireCron geofireCron9 = new GeofireCron(new Firebase(Constants.LIVE_FIREBASE_MANGALORE).child("production"));
        GeofireCron geofireCron10 = new GeofireCron(new Firebase(Constants.LIVE_FIREBASE_JAIPUR).child("production"));
        GeofireCron geofireCron11 = new GeofireCron(new Firebase(Constants.LIVE_FIREBASE_BANGALORE).child("production"));
        GeofireCron geofireCron12 = new GeofireCron(new Firebase(Constants.LIVE_FIREBASE_DELHI).child("production"));
        geofireCron.execute();
        geofireCron2.execute();
        geofireCron3.execute();
        geofireCron4.execute();
        geofireCron5.execute();
        geofireCron6.execute();
        geofireCron7.execute();
        geofireCron8.execute();
        geofireCron12.execute();
        geofireCron10.execute();
        geofireCron9.execute();
        geofireCron11.execute();
    }

    private void procesQuery(Query query) {
        SettableFuture<DataSnapshot> querySnapshot = FirebaseUtils.getQuerySnapshot(query);
        try {
            this.vehicleToStreamMap = new HashMap<>();
            this.vehicleToTimeStamp = new HashMap<>();
            for (DataSnapshot dataSnapshot : ((DataSnapshot) querySnapshot.get((long) Constants.THRESHOLD_TIMESTAMP, TimeUnit.SECONDS)).getChildren()) {
                ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(2);
                newFixedThreadPool.submit(new lo6(this, dataSnapshot));
                newFixedThreadPool.shutdown();
                logDuplicateCount();
            }
        } catch (Exception e) {
            SimpleLogger.logException(e);
        }
    }

    /* access modifiers changed from: private */
    public static MutableData processCheckout(MutableData mutableData) {
        mutableData.child("streamId").setValue((Object) null);
        mutableData.child(LoggingConstants.SESSION_START_TIME).setValue((Object) null);
        mutableData.child(LoggingConstants.ROUTE_ID).setValue((Object) null);
        mutableData.child("checkedIn").setValue(Boolean.FALSE);
        return mutableData;
    }

    public /* synthetic */ Object a(DataSnapshot dataSnapshot) {
        checkStatus(dataSnapshot);
        return null;
    }

    public void execute() {
        SimpleLogger.info("status check job executed");
        procesQuery(this._geofire);
        StringBuilder i0 = hj1.i0("total count :");
        i0.append(this._totalCount);
        SimpleLogger.info(i0.toString());
        SimpleLogger.info("closed count :" + this._closedCount);
        SimpleLogger.info("expiry count :" + this._expiryCount);
        SimpleLogger.info("bug count :" + this._bugCount);
        SimpleLogger.info("duplicate count :" + this._duplicateCount);
        this._closedCount = 0;
        this._bugCount = 0;
        this._expiryCount = 0;
        this._totalCount = 0;
    }

    public boolean isJSONValid(String str) {
        try {
            new JSONObject(str);
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    public void logDuplicateCount() {
        HashMap hashMap = new HashMap();
        hashMap.put("duplicateCount", Integer.valueOf(this._duplicateCount));
        hashMap.put("expiryCount", Integer.valueOf(this._expiryCount));
        hashMap.put("bugCount", Integer.valueOf(this._bugCount));
        hashMap.put("totalCount", Integer.valueOf(this._totalCount));
        hashMap.put("type", "cronSessionStat");
        hashMap.put("timeStamp", Long.valueOf(System.currentTimeMillis()));
        BasicTask basicTask = new BasicTask("geofire", TaskType.GEOFIRE_CRON, hashMap);
        System.out.println(hashMap.toString());
        _rabbitMQ.addTask(TaskCategory.LOGGING, basicTask);
    }
}
