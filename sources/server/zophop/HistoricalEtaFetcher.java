package server.zophop;

import j$.util.DesugarTimeZone;
import java.util.Calendar;
import java.util.Date;
import server.zophop.logicLayer.DataContainer;

public class HistoricalEtaFetcher {
    private static DataContainer dc;

    public HistoricalEtaFetcher() {
        dc = DataContainer.getDataContainer();
    }

    private static String fetchDay(long j) {
        Calendar instance = Calendar.getInstance(DesugarTimeZone.getTimeZone("IST"));
        instance.setTime(new Date(j));
        return String.valueOf(instance.get(5));
    }

    public static long fetchEta(String str, String str2, String str3, String str4, String str5, long j) {
        String generateId = generateId(str4, str5);
        String fetchHour = fetchHour(j);
        String fetchDay = fetchDay(j);
        DataContainer dataContainer = DataContainer.getDataContainer();
        dc = dataContainer;
        dataContainer.fetchEtaForAllRoute(str, str2);
        return dc.fetchEtaData(str, str2, str3, fetchDay, fetchHour, generateId);
    }

    private static String fetchHour(long j) {
        Calendar instance = Calendar.getInstance(DesugarTimeZone.getTimeZone("IST"));
        instance.setTime(new Date(j));
        return String.valueOf(instance.get(11));
    }

    private static String generateId(String str, String str2) {
        return hj1.T(str, "-", str2);
    }

    public static void main(String[] strArr) {
        System.out.println(fetchEta("bhopal", "bus", "LzmIVilj", "a", "a", System.currentTimeMillis() - 21600000));
        System.out.println(fetchEta("bhopal", "bus", "LzmIVilj", "OQaHTteh", "OYEiAYud", System.currentTimeMillis() - 21600000));
    }
}
