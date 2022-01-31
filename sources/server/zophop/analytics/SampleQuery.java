package server.zophop.analytics;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.json.JSONObject;

public class SampleQuery {
    public static void main(String[] strArr) throws SQLException {
        PostgresHandler postgresHandler = new PostgresHandler();
        JSONObject jSONObject = new JSONObject("{\"departureTime\":1554950901000,\"agency\":\"bcll\",\"city\":\"bhopal\",\"seqNum\":53,\"stopId\":\"vkRvpHne\",\"tripId\":\"7848ffa4-20d9-4951-8b38-f25d24717d06\",\"deviceId\":\"\",\"routeName\":\"TR1\",\"mode\":\"bus\",\"vehicleNo\":\"MP 04 PA 1003\",\"createdAt\":1555324853563,\"routeId\":\"liVDcjdJ\",\"stopWaitTime\":480000,\"arrivalTime\":1554950901000,\"stopName\":\"Chiraiyu Hospital\"}");
        String fetchEtaAccuracyData = SQL.fetchEtaAccuracyData(jSONObject);
        System.out.println(fetchEtaAccuracyData);
        ResultSet fetcher = postgresHandler.fetcher(fetchEtaAccuracyData);
        String string = fetcher.next() ? fetcher.getString("stream_id") : null;
        System.out.println(string);
        String updateEtaAccuracyData = SQL.updateEtaAccuracyData(jSONObject, string);
        System.out.println(updateEtaAccuracyData);
        System.out.println(postgresHandler.updateEtaAccuracyData(updateEtaAccuracyData));
    }
}
