package server.zophop.utils;

import app.zophop.models.mTicketing.ProductDiscountsObject;
import j$.util.DesugarTimeZone;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import server.zophop.Constants;
import server.zophop.models.Point;
import server.zophop.models.Stream;

public class TimeStampUtils {
    private static long getTime(String str, String str2) throws ParseException {
        Date parse = new SimpleDateFormat(str2).parse(str);
        PrintStream printStream = System.out;
        printStream.println(parse.getTime() + " ");
        return parse.getTime();
    }

    public static boolean isInTimeRange(String str, String str2, long j) throws ParseException {
        long time = getTime(str2, "hh:mm aa") + 19800;
        Calendar instance = Calendar.getInstance();
        instance.setTimeZone(DesugarTimeZone.getTimeZone("IST"));
        instance.setTimeInMillis(j);
        int i = instance.get(11);
        int i2 = instance.get(13);
        instance.get(12);
        String str3 = "" + i + ProductDiscountsObject.KEY_DELIMITER + i2;
        System.out.println(str3);
        long time2 = getTime(str3, "HH:mm");
        PrintStream printStream = System.out;
        StringBuilder i0 = hj1.i0("start_Time < mid_time ");
        int i3 = ((getTime(str, "hh:mm aa") + 19800) > time2 ? 1 : ((getTime(str, "hh:mm aa") + 19800) == time2 ? 0 : -1));
        i0.append(i3 < 0);
        printStream.println(i0.toString());
        PrintStream printStream2 = System.out;
        StringBuilder i02 = hj1.i0("mid_time < end_Time : ");
        int i4 = (time2 > time ? 1 : (time2 == time ? 0 : -1));
        i02.append(i4 < 0);
        printStream2.println(i02.toString());
        PrintStream printStream3 = System.out;
        StringBuilder i03 = hj1.i0("start_Time < mid_time && mid_time < end_Time : ");
        i03.append(i3 < 0 && i4 < 0);
        printStream3.println(i03.toString());
        if (i3 >= 0 || i4 >= 0) {
            return false;
        }
        return true;
    }

    public static boolean isPointExpired(Stream stream, Point point) {
        return stream.getLastUpdated() > point.getTime() + Constants.THRESHOLD_TIMESTAMP;
    }
}
