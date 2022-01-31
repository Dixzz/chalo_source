package server.zophop.GpsAnalytics;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.razorpay.AnalyticsConstants;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class ElasticDispatchFetcher implements Fetch<JSONObject, List<String>> {
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
        return new JSONObject("{'size':0,'query':{'bool':{'must':[{'match_all':{}},{'match_phrase':{'agency.keyword':{'query':'" + str2 + "'}}},{'match_phrase':{'userId.keyword':{'query':'" + str4 + "'}}},{'range':{'sessionStartTime':{'gte':" + configSettings.getStartTime() + ",'lte':" + configSettings.getEndTime() + ",'format':'epoch_millis'}}}],'must_not':[]}},'_source':{'excludes':[]},'aggs':{'2':{'terms':{'field':'routeId.keyword','size':500,'order':{'_count':'desc'}}}}}").toString();
    }

    @Override // server.zophop.GpsAnalytics.Fetch
    public String url(String str) {
        return "http://13.232.94.4:9200/sessions/_search";
    }

    public List<String> parse(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        if (!jSONObject.has("aggregations")) {
            return arrayList;
        }
        JSONArray jSONArray = jSONObject.getJSONObject("aggregations").getJSONObject("2").getJSONArray("buckets");
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getJSONObject(i).getString(AnalyticsConstants.KEY));
        }
        return arrayList;
    }
}
