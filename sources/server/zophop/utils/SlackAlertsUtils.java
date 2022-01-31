package server.zophop.utils;

import java.util.HashMap;
import org.json.JSONObject;

public class SlackAlertsUtils {
    private static final String _webhook = "https://hooks.slack.com/services/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";

    public static void main(String[] strArr) {
        send("test");
    }

    public static void send(String str) {
        try {
            System.out.println(HttpUtils.postWithHeaders(_webhook, new HashMap(), new JSONObject().put("text", str).toString()).code());
        } catch (Exception e) {
            System.out.println("not able to send alerts for slack channel");
            e.printStackTrace();
        }
    }
}
