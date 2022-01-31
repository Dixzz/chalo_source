package server.zophop.GpsAnalytics;

import com.mashape.unirest.http.exceptions.UnirestException;
import java.util.List;
import org.json.JSONObject;
import server.zophop.models.Point;

public class APIGpsFetcher implements Fetch<JSONObject, List<Point>> {
    @Override // server.zophop.GpsAnalytics.Fetch
    public JSONObject fetch(String str, String str2, String str3, String str4, ConfigSettings configSettings) throws UnirestException {
        return null;
    }

    public List<Point> parse(JSONObject jSONObject) {
        return null;
    }

    @Override // server.zophop.GpsAnalytics.Fetch
    public String query(String str, String str2, String str3, String str4, ConfigSettings configSettings) {
        return null;
    }

    @Override // server.zophop.GpsAnalytics.Fetch
    public String url(String str) {
        return null;
    }
}
