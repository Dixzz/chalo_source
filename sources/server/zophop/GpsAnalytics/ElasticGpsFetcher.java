package server.zophop.GpsAnalytics;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.razorpay.AnalyticsConstants;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import server.zophop.models.Point;

public class ElasticGpsFetcher implements Fetch<JSONObject, List<Point>> {
    @Override // server.zophop.GpsAnalytics.Fetch
    public JSONObject fetch(String str, String str2, String str3, String str4, ConfigSettings configSettings) throws UnirestException {
        PrintStream printStream = System.out;
        printStream.println(" Key " + str4);
        String query = query(str, str2, str3, str4, configSettings);
        System.out.println(query);
        return new JSONObject((String) Unirest.post(url(str2)).header("authorization", "Basic Y2hhbG86Q2hhbG9AMTIz").header("content-type", "application/json").body(query).asString().getBody());
    }

    @Override // server.zophop.GpsAnalytics.Fetch
    public String query(String str, String str2, String str3, String str4, ConfigSettings configSettings) {
        long endTime = configSettings.getEndTime();
        long startTime = configSettings.getStartTime();
        return new JSONObject("{'size':0,'query':{'bool':{'must':[{'match_all':{}},{'match_phrase':{'vehicleNo.keyword':{'query':'" + str4 + "'}}},{'range':{'point.timeStamp':{'gte':" + startTime + ",'lte':" + endTime + ",'format':'epoch_millis'}}}],'must_not':[]}},'_source':{'excludes':[]},'aggs':{'2':{'terms':{'field':'point.timeStamp','size':60000,'order':{'_term':'asc'}},'aggs':{'1':{'min':{'field':'point.latitude'}},'3':{'min':{'field':'point.longitude'}},'4':{'avg':{'field':'point.pointSpeed'}}}}}}").toString();
    }

    @Override // server.zophop.GpsAnalytics.Fetch
    public String url(String str) {
        return hj1.T("http://13.232.94.4:9200/gps_", str, "/_search");
    }

    public List<Point> parse(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        if (!jSONObject.has("aggregations")) {
            return arrayList;
        }
        JSONArray jSONArray = jSONObject.getJSONObject("aggregations").getJSONObject("2").getJSONArray("buckets");
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            arrayList.add(new Point(jSONObject2.getJSONObject("1").getDouble(FirebaseAnalytics.Param.VALUE), jSONObject2.getJSONObject("3").getDouble(FirebaseAnalytics.Param.VALUE), jSONObject2.getLong(AnalyticsConstants.KEY), jSONObject2.getJSONObject("4").getDouble(FirebaseAnalytics.Param.VALUE), FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
        }
        return arrayList;
    }
}
