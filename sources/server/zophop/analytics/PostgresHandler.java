package server.zophop.analytics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import server.zophop.Constants;

public class PostgresHandler {
    private Connection con = null;
    private Statement stmt = null;

    public PostgresHandler() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://13.126.212.99/postgres", "postgres", Constants.ELASTIC_SEARCH_BASIC_AUTH_PASSWORD);
            this.con = connection;
            this.stmt = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] strArr) {
        new PostgresHandler();
    }

    public boolean addData(String str) {
        try {
            this.stmt.executeUpdate(str);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public ResultSet fetcher(String str) {
        try {
            return this.stmt.executeQuery(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int updateEtaAccuracyData(String str) {
        try {
            return this.stmt.executeUpdate(str);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
