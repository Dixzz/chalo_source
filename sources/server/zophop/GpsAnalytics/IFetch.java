package server.zophop.GpsAnalytics;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

public interface IFetch<T, U> {
    JSONObject fetch(String str, String str2, String str3, String str4, ConfigSettings configSettings) throws UnirestException;

    U parse(T t);

    String query(String str, String str2, String str3, String str4, ConfigSettings configSettings);

    String url(String str);
}
