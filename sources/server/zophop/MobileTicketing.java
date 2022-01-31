package server.zophop;

import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import org.json.JSONObject;

public class MobileTicketing {
    public boolean postData(Map map, String str) throws Exception {
        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection()));
        JSONObject jSONObject = new JSONObject(map);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestMethod(FirebasePerformance.HttpMethod.POST);
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty("Content-Length", String.valueOf(jSONObject.toString().length()));
        httpURLConnection.getOutputStream().write(jSONObject.toString().getBytes());
        if (httpURLConnection.getResponseCode() == 200 || httpURLConnection.getResponseCode() == 202) {
            httpURLConnection.disconnect();
            return true;
        }
        httpURLConnection.disconnect();
        return false;
    }
}
