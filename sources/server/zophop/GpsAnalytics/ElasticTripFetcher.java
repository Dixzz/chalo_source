package server.zophop.GpsAnalytics;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.razorpay.AnalyticsConstants;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class ElasticTripFetcher implements Fetch<JSONObject, Map<String, List<String>>> {
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
        return new JSONObject(hj1.T("{'aggs':{'2':{'terms':{'field':'vehicleNo.keyword','size':50000,'order':{'1':'desc'}},'aggs':{'1':{'cardinality':{'field':'routeId.keyword'}},'3':{'terms':{'field':'routeId.keyword','size':500,'order':{'1':'desc'}},'aggs':{'1':{'cardinality':{'field':'routeId.keyword'}}}}}}},'size':0,'_source':{'excludes':[]},'stored_fields':['*'],'script_fields':{},'docvalue_fields':[{'field':'createdAt','format':'date_time'},{'field':'tripEndTime','format':'date_time'},{'field':'tripStartTime','format':'date_time'}],'query':{'bool':{'must':[{'query_string':{'query':'*','analyze_wildcard':true,'default_field':'*'}},{'range':{'tripStartTime':{'gte':1572546600000,'lte':1574792999999,'format':'epoch_millis'}}},{'match_phrase':{'city.keyword':{'query':'", str, "'}}}],'filter':[],'should':[],'must_not':[]}}}")).toString();
    }

    @Override // server.zophop.GpsAnalytics.Fetch
    public String url(String str) {
        return "http://13.232.94.4:9200/trip/_search";
    }

    public Map<String, List<String>> parse(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        if (!jSONObject.has("aggregations")) {
            return hashMap;
        }
        JSONArray jSONArray = jSONObject.getJSONObject("aggregations").getJSONObject("2").getJSONArray("buckets");
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            String string = jSONObject2.getString(AnalyticsConstants.KEY);
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray2 = jSONObject2.getJSONObject("3").getJSONArray("buckets");
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                arrayList.add(jSONArray2.getJSONObject(i2).getString(AnalyticsConstants.KEY));
            }
            hashMap.put(string, arrayList);
        }
        return hashMap;
    }
}
