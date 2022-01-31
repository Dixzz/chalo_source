package server.zophop.utils;

import java.io.IOException;
import java.util.HashMap;
import org.json.JSONObject;

public class TomTomTrafficIntegration {
    private static final String API_KEY = "WaQoVXqTfwsaiZ3gZUMg0IgQTkqF9vHB";

    public static int getSpeed(double d, double d2) {
        try {
            return new JSONObject(HttpUtils.getStreamableWithoutHeaders("https://api.tomtom.com/traffic/services/4/flowSegmentData/absolute/10/json?key=WaQoVXqTfwsaiZ3gZUMg0IgQTkqF9vHB&point=" + d + "," + d2, new HashMap())).getJSONObject("flowSegmentData").getInt("currentSpeed");
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static void main(String[] strArr) {
        new TomTomTrafficIntegration();
        getSpeed(28.67641830444336d, 77.32198333740234d);
    }
}
