package server.zophop.analytics;

import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.json.JSONObject;

public class Utils {
    public static String matchEtaPredictionAndStopArrival(JSONObject jSONObject, ResultSet resultSet) {
        try {
            if (resultSet.next()) {
                return resultSet.getString("stream_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PrintStream printStream = System.out;
        StringBuilder i0 = hj1.i0(" ..................!");
        i0.append(resultSet.toString());
        printStream.println(i0.toString());
        return null;
    }
}
