package server.zophop.cron;

import app.zophop.models.mTicketing.digitalTripReceipt.DigitalTripReceiptJsonKeys;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.razorpay.AnalyticsConstants;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONObject;
import server.zophop.Constants;
import server.zophop.GpsAnalytics.Agency;
import server.zophop.GpsAnalytics.ConfigSettings;
import server.zophop.TaskCategory;
import server.zophop.TaskType;
import server.zophop.dataLayer.Firebase.FirebaseUtils;
import server.zophop.logging.ElasticHandler;
import server.zophop.logging.LoggingConstants;
import server.zophop.models.FirebaseRef;
import server.zophop.queue.BasicTask;
import server.zophop.queue.RabbitMQ;
import server.zophop.utils.DistanceUtils;

public class GpsBasedDistance {
    public static final long INTERVAL = 24;
    private static final double SPEED = 100.0d;
    private RabbitMQ _rabbitMQLogger;

    public GpsBasedDistance() {
        RabbitMQ rabbitMQ = new RabbitMQ(5, Constants.getExchange(), TaskCategory.LOGGING);
        this._rabbitMQLogger = rabbitMQ;
        rabbitMQ.init();
    }

    private static void execute() throws Exception {
        GpsBasedDistance gpsBasedDistance = new GpsBasedDistance();
        ElasticHandler elasticHandler = new ElasticHandler();
        ConfigSettings configSettings = new ConfigSettings();
        for (Agency agency : Arrays.asList(Agency.values())) {
            ArrayList<String> vehiclesList = getVehiclesList(agency);
            for (int i = 0; i < vehiclesList.size(); i++) {
                String str = vehiclesList.get(i);
                PrintStream printStream = System.out;
                printStream.println(" Key " + str);
                try {
                    gpsBasedDistance.forwardDataToElastic(elasticHandler, agency, new JSONObject(((String) getElasticQuery(agency, str, configSettings).getBody()).toString()), str);
                } catch (Exception e) {
                    PrintStream printStream2 = System.out;
                    StringBuilder i0 = hj1.i0("  json issue");
                    i0.append(e.getMessage());
                    printStream2.println(i0.toString());
                }
            }
        }
    }

    public static HttpResponse<String> getElasticQuery(Agency agency, String str, ConfigSettings configSettings) throws UnirestException {
        String gpsBasedDistanceQuery = getGpsBasedDistanceQuery(str, configSettings);
        System.out.println(getUrl(agency));
        return Unirest.post(getUrl(agency)).header("authorization", "Basic Y2hhbG86Q2hhbG9AMTIz").header("content-type", "application/json").body(gpsBasedDistanceQuery).asString();
    }

    public static String getGpsBasedDistanceQuery(String str, ConfigSettings configSettings) {
        long endTime = configSettings.getEndTime();
        long startTime = configSettings.getStartTime();
        return new JSONObject("{'size':0,'query':{'bool':{'must':[{'query_string':{'query':'*','analyze_wildcard':true}},{'match_phrase':{'vehicleNo.keyword':{'query': " + str + "}}},{'range':{'point.timeStamp':{'gte': " + startTime + ",'lte': " + endTime + ",'format':'epoch_millis'}}}],'must_not':[]}},'_source':{'excludes':[]},'aggs':{'2':{'date_histogram':{'field':'point.timeStamp','interval':'1h','time_zone':'Asia/Kolkata','min_doc_count':10},'aggs':{'3':{'terms':{'field':'point.timeStamp','size':100000,'order':{'_term':'asc'}},'aggs':{'7':{'max':{'field':'point.pointSpeed'}},'5':{'max':{'field':'point.latitude'}},'6':{'max':{'field':'point.longitude'}}}}}}}}").toString();
    }

    public static Map getJsonObject(Agency agency, String str, double d, long j, double d2, int i, long j2, int i2, int i3, double d3, double d4, double d5, double d6) {
        HashMap hashMap = new HashMap();
        hashMap.put(LoggingConstants.DISTANCE, Double.valueOf(d / 1000.0d));
        hashMap.put("time", Long.valueOf(j / 1000));
        hashMap.put("totalPoints", Integer.valueOf(i2));
        hashMap.put("uniquePoints", Integer.valueOf(i3));
        hashMap.put("firstLat", Double.valueOf(d3));
        hashMap.put("firstLon", Double.valueOf(d4));
        hashMap.put("secondLat", Double.valueOf(d5));
        hashMap.put("secondLon", Double.valueOf(d6));
        hashMap.put("timestamp", Long.valueOf(j2));
        hashMap.put(DigitalTripReceiptJsonKeys.KEY_VEHICLE_NO, str);
        hashMap.put("errorPoint", Integer.valueOf(i));
        hashMap.put("agency", agency.getAgency());
        hashMap.put("city", agency.getCity());
        hashMap.put("maxSpeed(mtr/sec)", Double.valueOf(d2));
        if (j > 0) {
            hashMap.put("avgSpeed", Double.valueOf(d / ((double) j)));
        } else {
            hashMap.put("avgSpeed", 0);
        }
        return hashMap;
    }

    public static String getUrl(Agency agency) {
        StringBuilder i0 = hj1.i0("http://13.232.94.4:9200/gps_");
        i0.append(agency.getAgency());
        i0.append("/_search");
        return i0.toString();
    }

    private static ArrayList<String> getVehiclesList(Agency agency) {
        Firebase vehiclesRef = new FirebaseRef().getVehiclesRef(agency.getCity());
        ArrayList<String> arrayList = new ArrayList<>();
        for (DataSnapshot dataSnapshot : FirebaseUtils.getSynchronizedDataSnapshot(vehiclesRef.child(agency.getCity().toLowerCase()).child("bus").child(agency.getAgency().toLowerCase()).child("locations")).getChildren()) {
            arrayList.add(dataSnapshot.getKey());
        }
        return arrayList;
    }

    public static void main(String[] strArr) {
        try {
            execute();
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void forwardDataToElastic(ElasticHandler elasticHandler, Agency agency, JSONObject jSONObject, String str) throws Exception {
        Double d;
        if (jSONObject.has("aggregations")) {
            String str2 = "buckets";
            JSONArray jSONArray = jSONObject.getJSONObject("aggregations").getJSONObject("2").getJSONArray(str2);
            int i = 0;
            while (i < jSONArray.length()) {
                long j = 0;
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                long j2 = jSONObject2.getLong(AnalyticsConstants.KEY);
                int i2 = jSONObject2.getInt("doc_count");
                JSONArray jSONArray2 = jSONObject2.getJSONObject("3").getJSONArray(str2);
                int length = jSONArray2.length();
                int i3 = 0;
                int i4 = 0;
                boolean z = false;
                double d2 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                double d3 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                int i5 = 0;
                while (i4 < jSONArray2.length() - 1) {
                    double d4 = jSONArray2.getJSONObject(i4).getJSONObject("7").getDouble(FirebaseAnalytics.Param.VALUE);
                    if (d4 > d3) {
                        d3 = d4;
                    }
                    double d5 = jSONArray2.getJSONObject(i4).getJSONObject("5").getDouble(FirebaseAnalytics.Param.VALUE);
                    double d6 = jSONArray2.getJSONObject(i4).getJSONObject("6").getDouble(FirebaseAnalytics.Param.VALUE);
                    int i6 = i4 + 1;
                    double d7 = jSONArray2.getJSONObject(i6).getJSONObject("5").getDouble(FirebaseAnalytics.Param.VALUE);
                    double d8 = jSONArray2.getJSONObject(i6).getJSONObject("6").getDouble(FirebaseAnalytics.Param.VALUE);
                    long j3 = jSONArray2.getJSONObject(i6).getLong(AnalyticsConstants.KEY);
                    long j4 = jSONArray2.getJSONObject(i4).getLong(AnalyticsConstants.KEY);
                    if (d5 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || d6 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || d8 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || d7 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                        i5++;
                        d = Double.valueOf((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                    } else {
                        d = Double.valueOf(DistanceUtils.straightDistance(d5, d6, d7, d8));
                    }
                    long j5 = j3 - j4;
                    if (!d.isNaN()) {
                        d2 += d.doubleValue();
                        if (d.doubleValue() < 1.0d && !z) {
                            i3 = (int) (((long) i3) + j5);
                            z = true;
                        } else if (d.doubleValue() < 2.0d && z) {
                            i3 = (int) (((long) i3) + j5);
                        } else if (d.doubleValue() <= 1.0d || z) {
                            if (i3 <= 600000) {
                                j += (long) i3;
                            }
                            i3 = 0;
                            z = false;
                        } else {
                            j += j5;
                        }
                    }
                    jSONArray = jSONArray;
                    i4 = i6;
                    str2 = str2;
                    j2 = j2;
                }
                final Map jsonObject = getJsonObject(agency, str, d2, j, d3, i5, j2, i2, length, jSONArray2.getJSONObject(0).getJSONObject("5").getDouble(FirebaseAnalytics.Param.VALUE), jSONArray2.getJSONObject(0).getJSONObject("6").getDouble(FirebaseAnalytics.Param.VALUE), jSONArray2.getJSONObject(jSONArray2.length() - 1).getJSONObject("5").getDouble(FirebaseAnalytics.Param.VALUE), jSONArray2.getJSONObject(jSONArray2.length() - 1).getJSONObject("6").getDouble(FirebaseAnalytics.Param.VALUE));
                PrintStream printStream = System.out;
                printStream.println(j2 + " " + j + "   " + d2);
                System.out.println(jsonObject.toString());
                ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(2);
                newFixedThreadPool.submit(new Callable() {
                    /* class server.zophop.cron.GpsBasedDistance.AnonymousClass1 */

                    @Override // java.util.concurrent.Callable
                    public Object call() throws Exception {
                        GpsBasedDistance.this._rabbitMQLogger.addTask(new BasicTask("1234", TaskType.GPS_DISTANCE, jsonObject));
                        return null;
                    }
                });
                newFixedThreadPool.shutdown();
                i++;
                jSONArray = jSONArray;
                str2 = str2;
            }
        }
    }
}
