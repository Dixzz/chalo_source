package server.zophop.cron;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.razorpay.AnalyticsConstants;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import server.zophop.logging.ElasticHandler;
import server.zophop.models.SimpleLogger;

public class GpsAnalysisCron implements Job {
    public static ArrayList<String> addAgenciesForCron() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("upsrtc");
        arrayList.add("ibus");
        arrayList.add("bcll");
        arrayList.add("c-type");
        arrayList.add("kmrl");
        arrayList.add("lnt");
        arrayList.add("nmpl");
        arrayList.add("bmtc");
        arrayList.add("aictsl");
        arrayList.add("cstc");
        arrayList.add("cstc1");
        arrayList.add("jcbs");
        arrayList.add("jctsl");
        arrayList.add("uctsl");
        return arrayList;
    }

    public static void forwardDataToElastic(ElasticHandler elasticHandler, String str, JSONObject jSONObject) throws Exception {
        if (jSONObject.has("aggregations")) {
            JSONArray jSONArray = jSONObject.getJSONObject("aggregations").getJSONObject("8").getJSONArray("buckets").getJSONObject(0).getJSONObject("9").getJSONArray("buckets");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jsonObject = getJsonObject(str, jSONArray, i);
                elasticHandler.execute(jsonObject, "gpsSummary", "type");
                System.out.println(jsonObject.toString());
            }
        }
    }

    public static String getElasticGpsQuery() {
        return new JSONObject("{'size': 0,'query': {'bool': { 'must': [{'match_all': {}}],'must_not': []}}, '_source': {  'excludes': []},'aggs': {'8': {'date_range': {'field': 'point.timeStamp', 'time_zone': 'Asia/Kolkata', 'ranges': [ { 'from': 'now/d-1d', 'to': 'now/d' }]},'aggs': {'9': { 'terms': { 'field': 'vehicleNo.keyword','size': 5000, 'order': { '_count': 'desc' } }, 'aggs': {'1': { 'cardinality': {'field': 'point.timeStamp' } }, '2': { 'avg_bucket': {'buckets_path': '4-bucket>1-metric' } },'3': { 'avg': {'field': 'point.delayInTimeStamp' } }, '4': { 'min': {'field': 'point.timeStamp' } },'5': { 'max': {'field': 'point.timeStamp' } },'4-bucket': { 'date_histogram': {'field': 'point.timeStamp','interval': '30m','time_zone': 'Asia/Kolkata','min_doc_count': 1}, 'aggs': {'1-metric': { 'cardinality': { 'field': 'point.timeStamp' }  }          } } } }}}}}").toString();
    }

    public static JSONObject getJsonObject(String str, JSONArray jSONArray, int i) {
        long j = jSONArray.getJSONObject(i).getJSONObject("1").getLong(FirebaseAnalytics.Param.VALUE);
        String string = jSONArray.getJSONObject(i).getString(AnalyticsConstants.KEY);
        long j2 = jSONArray.getJSONObject(i).getJSONObject("2").getLong(FirebaseAnalytics.Param.VALUE);
        long j3 = jSONArray.getJSONObject(i).getJSONObject("3").isNull(FirebaseAnalytics.Param.VALUE) ? 0 : jSONArray.getJSONObject(i).getJSONObject("3").getLong(FirebaseAnalytics.Param.VALUE);
        long j4 = jSONArray.getJSONObject(i).getJSONObject("4").getLong(FirebaseAnalytics.Param.VALUE);
        long j5 = jSONArray.getJSONObject(i).getJSONObject("5").getLong(FirebaseAnalytics.Param.VALUE);
        long j6 = jSONArray.getJSONObject(i).getLong("doc_count");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(AnalyticsConstants.KEY, string);
        jSONObject.put("count", j6);
        jSONObject.put("uniqueCount", j);
        jSONObject.put("30minCount", j2);
        jSONObject.put("frequency", 1800 / j2);
        jSONObject.put("delay", j3 / 1000);
        jSONObject.put("minTimeStamp", j4);
        jSONObject.put("maxTimeStamp", j5);
        jSONObject.put("agency", str);
        return jSONObject;
    }

    public static String getUrl(String str) {
        return hj1.T("http://7d9aafd3346df8230b699e0373dafb4d.us-east-1.aws.found.io:9200/", str, "/_search");
    }

    public static void main(String[] strArr) throws Exception {
        ElasticHandler elasticHandler = new ElasticHandler();
        Iterator<String> it = addAgenciesForCron().iterator();
        while (it.hasNext()) {
            String next = it.next();
            System.out.println(next);
            JSONObject jSONObject = new JSONObject(((String) makeElasticQuery(next).getBody()).toString());
            System.out.println(jSONObject.toString());
            forwardDataToElastic(elasticHandler, next, jSONObject);
        }
    }

    public static HttpResponse<String> makeElasticQuery(String str) throws UnirestException {
        return Unirest.post(getUrl(str)).header("authorization", "Basic Y2hhbG86Q2hhbG9AMTIz").header("content-type", "application/json").body(getElasticGpsQuery()).asString();
    }

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
            new GpsAnalysisCron().execute();
        } catch (Exception e) {
            SimpleLogger.logException(e);
        }
    }

    private void execute() throws Exception {
        ElasticHandler elasticHandler = new ElasticHandler();
        Iterator<String> it = addAgenciesForCron().iterator();
        while (it.hasNext()) {
            String next = it.next();
            JSONObject jSONObject = new JSONObject(((String) makeElasticQuery(next).getBody()).toString());
            System.out.println(jSONObject.toString());
            forwardDataToElastic(elasticHandler, next, jSONObject);
        }
    }
}
