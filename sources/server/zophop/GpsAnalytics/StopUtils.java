package server.zophop.GpsAnalytics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import server.zophop.models.Stop;
import server.zophop.utils.HttpUtils;

public class StopUtils {
    private static HashMap<String, Map<String, Stop>> _cityStops;
    private static StopUtils stopUtils;

    public StopUtils() {
        _cityStops = new HashMap<>();
    }

    public static StopUtils getInstance() {
        if (stopUtils == null) {
            stopUtils = new StopUtils();
        }
        return stopUtils;
    }

    public Map<String, Stop> fetchCityStops(String str) throws Exception {
        String streamableWithoutHeaders = HttpUtils.getStreamableWithoutHeaders(hj1.T("https://dazzling-fire-3689.firebaseio.com/production/cityData/", str, "/Stops/BUS.json"), new HashMap());
        HashMap hashMap = new HashMap();
        JSONObject jSONObject = new JSONObject(streamableWithoutHeaders);
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            JSONObject jSONObject2 = jSONObject.getJSONObject(next);
            hashMap.put(next, new Stop(next, "bus", jSONObject2.getString("name"), jSONObject2.getDouble("lat"), jSONObject2.getDouble("lon")));
        }
        return hashMap;
    }

    public Stop fetchStop(String str, String str2) throws Exception {
        if (!_cityStops.containsKey(str)) {
            _cityStops.put(str, fetchCityStops(str));
        }
        return _cityStops.get(str).get(str2);
    }

    public Map<String, Stop> fetchStops(String str) throws Exception {
        if (!_cityStops.containsKey(str)) {
            _cityStops.put(str, fetchCityStops(str));
        }
        return _cityStops.get(str);
    }

    public List<Stop> getStopSequences() throws Exception {
        String streamableWithoutHeaders = HttpUtils.getStreamableWithoutHeaders("http://production.zophop.com:8080/scheduler_v4/v4/INDORE/routedetails?route_id=aqGjaLFa&day=wednesday", new HashMap());
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = new JSONObject(streamableWithoutHeaders).getJSONObject("route").getJSONArray("stopSequenceWithDetails");
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            arrayList.add(new Stop(jSONObject.getString("stop_id"), "bus", jSONObject.getString("stop_name"), jSONObject.getDouble("stop_lat"), jSONObject.getDouble("stop_lon")));
        }
        return arrayList;
    }
}
