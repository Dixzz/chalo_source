package server.zophop.cron;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.PrintStream;
import org.json.JSONArray;
import server.zophop.logicLayer.DataContainer;

public class RouteGpsAnalysis {
    private DataContainer _container = DataContainer.getDataContainer();

    public static void main(String[] strArr) {
    }

    public static void process(JSONArray jSONArray) {
        for (int i = 0; i < jSONArray.length(); i++) {
            double d = jSONArray.getJSONObject(i).getJSONObject("5").getDouble(FirebaseAnalytics.Param.VALUE);
            double d2 = jSONArray.getJSONObject(i).getJSONObject("6").getDouble(FirebaseAnalytics.Param.VALUE);
            PrintStream printStream = System.out;
            printStream.println("\"" + d + "\",\"" + d2 + "\"");
        }
    }
}
