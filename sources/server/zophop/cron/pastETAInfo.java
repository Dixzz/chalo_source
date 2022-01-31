package server.zophop.cron;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import server.zophop.CS;
import server.zophop.Constants;
import server.zophop.dataLayer.Firebase.StaticData;
import server.zophop.logging.ElasticHandler;
import server.zophop.logging.LoggingConstants;
import server.zophop.models.SimpleLogger;
import server.zophop.utils.DistanceUtils;

public class pastETAInfo implements Job {
    private String _city;
    private HashMap<String, HashMap> cityData;
    private ElasticHandler el;

    public pastETAInfo(String str) {
        this.cityData = null;
        this.el = new ElasticHandler();
        this.cityData = null;
        this._city = str;
    }

    private JSONObject getPointAddedQuery(String str, String str2, String str3, long j, long j2) {
        return new JSONObject("{size:10000,sort: [{'point.timeStamp':'desc'}],query:{   bool:{       must:[           {match_all:{}},           {match_phrase:{agency: {query: '" + str + "'}}},           {match_phrase:{'meta.routeId': {query: '" + str2 + "'}}},           {match_phrase:{'meta.previousStopId': {query: '" + str3 + "'}}},           {range: {'point.timeStamp':{gte:'" + j + "', lte: '" + j2 + "', format: 'epoch_millis'}}}       ]   }}}");
    }

    private JSONObject getSessionDataQuery(String str, String str2, long j, long j2) {
        return new JSONObject("{size:10000,sort: [{'sessionStartTime':'desc'}],query:{   bool:{       must:[           {match_all:{}},           {match_phrase:{agency: {query: '" + str + "'}}},           {match_phrase:{'routeId': {query: '" + str2 + "'}}},           {range: {'sessionStartTime':{gte:'" + j + "', lte: '" + j2 + "', format: 'epoch_millis'}}}       ]   }}}");
    }

    private HashMap<String, Object> mergeHaltTimesAndSpeeds(HashMap<String, HashMap> hashMap, HashMap<String, HashMap> hashMap2) {
        HashMap<String, Object> hashMap3 = new HashMap<>();
        for (String str : hashMap.keySet()) {
            if (hashMap3.get(str) == null) {
                hashMap3.put(str, new HashMap());
            }
            HashMap hashMap4 = hashMap.get(str);
            HashMap hashMap5 = (HashMap) hashMap3.get(str);
            for (String str2 : hashMap4.keySet()) {
                HashMap hashMap6 = (HashMap) hashMap4.get(str2);
                if (hashMap5.get(str2) == null) {
                    hashMap5.put(str2, new HashMap());
                }
                ((HashMap) hashMap5.get(str2)).put("h", hashMap6.get("h"));
            }
        }
        for (String str3 : hashMap2.keySet()) {
            if (hashMap3.get(str3) == null) {
                hashMap3.put(str3, new HashMap());
            }
            HashMap hashMap7 = hashMap2.get(str3);
            HashMap hashMap8 = (HashMap) hashMap3.get(str3);
            for (String str4 : hashMap7.keySet()) {
                HashMap hashMap9 = (HashMap) hashMap7.get(str4);
                if (hashMap8.get(str4) == null) {
                    hashMap8.put(str4, new HashMap());
                }
                ((HashMap) hashMap8.get(str4)).put("s", hashMap9.get("s"));
            }
        }
        return hashMap3;
    }

    public HashMap<String, HashMap<String, Long>> calculateAverageDuration(ArrayList<JSONObject> arrayList, String str, HashMap hashMap) {
        double doubleValue = ((Double) ((HashMap) hashMap.get(str)).get("lat")).doubleValue();
        double doubleValue2 = ((Double) ((HashMap) hashMap.get(str)).get("lon")).doubleValue();
        HashMap hashMap2 = new HashMap();
        Iterator<JSONObject> it = arrayList.iterator();
        while (it.hasNext()) {
            JSONObject jSONObject = (JSONObject) it.next().get("_source");
            String str2 = (String) jSONObject.get("streamId");
            if (hashMap2.get(str2) == null) {
                hashMap2.put(str2, new ArrayList());
            }
            double doubleValue3 = ((Double) ((JSONObject) jSONObject.get("point")).get(Constants.LATITUDE)).doubleValue();
            double doubleValue4 = ((Double) ((JSONObject) jSONObject.get("point")).get(Constants.LONGITUDE)).doubleValue();
            long longValue = ((Long) ((JSONObject) jSONObject.get("point")).get("timeStamp")).longValue();
            if (DistanceUtils.straightDistance(doubleValue3, doubleValue4, doubleValue, doubleValue2) < 100.0d) {
                ((ArrayList) hashMap2.get(str2)).add(Long.valueOf(longValue));
            }
        }
        HashMap<String, HashMap<String, Long>> hashMap3 = new HashMap<>();
        HashMap hashMap4 = new HashMap();
        HashMap hashMap5 = new HashMap();
        for (String str3 : hashMap2.keySet()) {
            ArrayList arrayList2 = (ArrayList) hashMap2.get(str3);
            if (arrayList2.size() != 0) {
                Collections.sort(arrayList2);
                Long valueOf = Long.valueOf(((Long) arrayList2.get(arrayList2.size() - 1)).longValue() - ((Long) arrayList2.get(0)).longValue());
                int hourByTimestamp = getHourByTimestamp(((Long) arrayList2.get(0)).longValue());
                if (hashMap4.get(Integer.valueOf(hourByTimestamp)) == null) {
                    hashMap4.put(Integer.valueOf(hourByTimestamp), valueOf);
                } else {
                    hashMap4.put(Integer.valueOf(hourByTimestamp), Long.valueOf(valueOf.longValue() + ((Long) hashMap4.get(Integer.valueOf(hourByTimestamp))).longValue()));
                }
                if (hashMap5.get(Integer.valueOf(hourByTimestamp)) == null) {
                    hashMap5.put(Integer.valueOf(hourByTimestamp), 1);
                } else {
                    hashMap5.put(Integer.valueOf(hourByTimestamp), Integer.valueOf(((Integer) hashMap5.get(Integer.valueOf(hourByTimestamp))).intValue() + 1));
                }
            }
        }
        for (Integer num : hashMap5.keySet()) {
            int intValue = num.intValue();
            HashMap<String, Long> hashMap6 = new HashMap<>();
            hashMap6.put("h", Long.valueOf((((Long) hashMap4.get(Integer.valueOf(intValue))).longValue() / ((long) ((Integer) hashMap5.get(Integer.valueOf(intValue))).intValue())) / 1000));
            hashMap3.put("" + intValue, hashMap6);
        }
        return hashMap3;
    }

    public HashMap<String, HashMap<String, Double>> calculateAvgSpeed(ArrayList<JSONObject> arrayList) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        Iterator<JSONObject> it = arrayList.iterator();
        while (it.hasNext()) {
            JSONObject jSONObject = (JSONObject) it.next().get("_source");
            StringBuilder i0 = hj1.i0("");
            i0.append(jSONObject.get(LoggingConstants.SPEED));
            double doubleValue = Double.valueOf(i0.toString()).doubleValue();
            long longValue = ((Long) jSONObject.get(LoggingConstants.SESSION_START_TIME)).longValue();
            if (doubleValue > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && doubleValue < 50.0d) {
                int hourByTimestamp = getHourByTimestamp(longValue);
                if (hashMap.get(Integer.valueOf(hourByTimestamp)) == null) {
                    hashMap.put(Integer.valueOf(hourByTimestamp), Double.valueOf(doubleValue));
                } else {
                    hashMap.put(Integer.valueOf(hourByTimestamp), Double.valueOf(((Double) hashMap.get(Integer.valueOf(hourByTimestamp))).doubleValue() + doubleValue));
                }
                if (hashMap2.get(Integer.valueOf(hourByTimestamp)) == null) {
                    hashMap2.put(Integer.valueOf(hourByTimestamp), 1);
                } else {
                    hashMap2.put(Integer.valueOf(hourByTimestamp), Integer.valueOf(((Integer) hashMap2.get(Integer.valueOf(hourByTimestamp))).intValue() + 1));
                }
            }
        }
        HashMap<String, HashMap<String, Double>> hashMap3 = new HashMap<>();
        for (Integer num : hashMap2.keySet()) {
            int intValue = num.intValue();
            HashMap<String, Double> hashMap4 = new HashMap<>();
            hashMap4.put("s", Double.valueOf(((Double) hashMap.get(Integer.valueOf(intValue))).doubleValue() / ((double) ((Integer) hashMap2.get(Integer.valueOf(intValue))).intValue())));
            hashMap3.put("" + intValue, hashMap4);
        }
        return hashMap3;
    }

    public void calculateHaltTimesAndSpeeds() {
        HashMap hashMap = (HashMap) this.cityData.get(Constants.ROUTES).get("BUS");
        HashMap hashMap2 = (HashMap) this.cityData.get(Constants.STOPS).get("BUS");
        HashMap<String, HashMap> hashMap3 = new HashMap<>();
        HashMap<String, HashMap> hashMap4 = new HashMap<>();
        System.out.println(new Date());
        for (String str : hashMap.keySet()) {
            HashMap hashMap5 = (HashMap) hashMap.get(str);
            ArrayList arrayList = (ArrayList) hashMap5.get("seq");
            String str2 = (String) hashMap5.get("ag");
            String str3 = (String) arrayList.get(0);
            PrintStream printStream = System.out;
            StringBuilder k0 = hj1.k0(str2, " ");
            k0.append((String) arrayList.get(arrayList.size() - 1));
            printStream.println(k0.toString());
            long currentTimeMillis = System.currentTimeMillis();
            long j = currentTimeMillis - 604800000;
            JSONObject pointAddedQuery = getPointAddedQuery(str2, str, str3, j, currentTimeMillis);
            JSONObject sessionDataQuery = getSessionDataQuery(str2, str, j, currentTimeMillis);
            try {
                hashMap3.put(str, calculateAverageDuration(this.el.getPointAddedData(pointAddedQuery), str3, hashMap2));
                hashMap4.put(str, calculateAvgSpeed(this.el.getSessionsData(sessionDataQuery)));
            } catch (Exception e) {
                SimpleLogger.logException(e);
                e.printStackTrace();
            }
            hashMap = hashMap;
        }
        HashMap hashMap6 = new HashMap();
        hashMap6.put(hj1.a0(hj1.i0("/cityDataTemp/"), this._city, "/info"), mergeHaltTimesAndSpeeds(hashMap3, hashMap4));
        StaticData.storeStaticData(hashMap6);
        System.out.println(new Date());
    }

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        CS.ENVIRONMENT.valueOf("production");
        new pastETAInfo("indore").execute();
    }

    public int getHourByTimestamp(long j) {
        Date date = new Date(j);
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        return instance.get(11);
    }

    public void execute() {
        calculateHaltTimesAndSpeeds();
    }
}
