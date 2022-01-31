package com.freshchat.consumer.sdk.j;

import android.content.Context;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import com.freshchat.consumer.sdk.R;
import j$.util.DesugarTimeZone;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class n {
    private static SimpleDateFormat hA;
    private static SimpleDateFormat hB;
    private static SimpleDateFormat kH;
    private static SimpleDateFormat kI;
    private static SimpleDateFormat kX;
    private static SimpleDateFormat pR;
    private static SimpleDateFormat pS;

    private static Date C(long j) {
        return new Date(j);
    }

    public static String I(Context context, String str) {
        if (str == null) {
            return "";
        }
        try {
            return a(context, new SimpleDateFormat("yyyy-MM-dd", ah.bb(context)).parse(str));
        } catch (ParseException e) {
            q.a(e);
            return "";
        }
    }

    public static String a(Context context, long j, boolean z) {
        long fP = fP();
        SimpleDateFormat bq = bq(context);
        if (c(j, fP)) {
            bq = d(j, fP) ? bp(context) : z ? bs(context) : br(context);
        }
        bq.setTimeZone(TimeZone.getDefault());
        return bq.format(new Date(j));
    }

    private static String a(Context context, Date date) {
        if (date == null) {
            return "";
        }
        try {
            Calendar instance = Calendar.getInstance();
            instance.setTime(date);
            if (a(instance, Calendar.getInstance())) {
                return context.getString(R.string.freshchat_calendar_today);
            }
            if (b(instance)) {
                return context.getString(R.string.freshchat_calendar_tomorrow);
            }
            SimpleDateFormat cj = cj(context);
            return cj != null ? cj.format(date) : "";
        } catch (Exception e) {
            q.a(e);
            return "";
        }
    }

    public static boolean a(Calendar calendar, Calendar calendar2) {
        return calendar.get(5) == calendar2.get(5) && calendar.get(2) == calendar2.get(2) && calendar.get(1) == calendar2.get(1);
    }

    public static boolean b(Calendar calendar) {
        Calendar instance = Calendar.getInstance();
        instance.add(6, 1);
        return a(calendar, instance);
    }

    private static SimpleDateFormat bp(Context context) {
        if (kI == null) {
            try {
                kI = new SimpleDateFormat(context.getString(R.string.freshchat_chat_message_time_other_year), ah.bb(context));
            } catch (Exception unused) {
                kI = bt(context);
            }
        }
        return kI;
    }

    private static SimpleDateFormat bq(Context context) {
        if (hA == null) {
            try {
                hA = new SimpleDateFormat(context.getString(R.string.freshchat_chat_message_time_today), ah.bb(context));
            } catch (Exception unused) {
                hA = bt(context);
            }
        }
        return hA;
    }

    private static SimpleDateFormat br(Context context) {
        if (hB == null) {
            try {
                hB = new SimpleDateFormat(context.getString(R.string.freshchat_chat_message_time_this_year_short), ah.bb(context));
            } catch (Exception unused) {
                hB = bt(context);
            }
        }
        return hB;
    }

    private static SimpleDateFormat bs(Context context) {
        if (kH == null) {
            try {
                kH = new SimpleDateFormat(context.getString(R.string.freshchat_chat_message_time_this_year_long), ah.bb(context));
            } catch (Exception unused) {
                kH = bt(context);
            }
        }
        return kH;
    }

    private static SimpleDateFormat bt(Context context) {
        if (kX == null) {
            try {
                kX = new SimpleDateFormat("dd MMM yyyy',' hh:mm a", ah.bb(context));
            } catch (Exception unused) {
            }
        }
        return kX;
    }

    public static String c(Calendar calendar) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
        } catch (Exception e) {
            q.a(e);
            return null;
        }
    }

    public static boolean c(long j, long j2) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTimeInMillis(j2);
        return (instance.get(5) == instance2.get(5) && instance.get(2) == instance2.get(2) && instance.get(1) == instance2.get(1)) ? false : true;
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0016 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.text.SimpleDateFormat ci(android.content.Context r3) {
        /*
            java.text.SimpleDateFormat r0 = com.freshchat.consumer.sdk.j.n.pR
            if (r0 != 0) goto L_0x002b
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x0016 }
            int r1 = com.freshchat.consumer.sdk.R.string.freshchat_chat_calendar_timeslot_format     // Catch:{ Exception -> 0x0016 }
            java.lang.String r1 = r3.getString(r1)     // Catch:{ Exception -> 0x0016 }
            java.util.Locale r2 = com.freshchat.consumer.sdk.j.ah.bb(r3)     // Catch:{ Exception -> 0x0016 }
            r0.<init>(r1, r2)     // Catch:{ Exception -> 0x0016 }
            com.freshchat.consumer.sdk.j.n.pR = r0     // Catch:{ Exception -> 0x0016 }
            goto L_0x002b
        L_0x0016:
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x0024 }
            java.lang.String r1 = "hh:mm a"
            java.util.Locale r3 = com.freshchat.consumer.sdk.j.ah.bb(r3)     // Catch:{ Exception -> 0x0024 }
            r0.<init>(r1, r3)     // Catch:{ Exception -> 0x0024 }
            com.freshchat.consumer.sdk.j.n.pR = r0     // Catch:{ Exception -> 0x0024 }
            goto L_0x002b
        L_0x0024:
            java.lang.String r3 = "FRESHCHAT"
            java.lang.String r0 = "Error parsing default calendar time slot template format in getTimeFormatForCalendarTime()"
            com.freshchat.consumer.sdk.j.ai.e(r3, r0)
        L_0x002b:
            java.text.SimpleDateFormat r3 = com.freshchat.consumer.sdk.j.n.pR
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.j.n.ci(android.content.Context):java.text.SimpleDateFormat");
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0016 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.text.SimpleDateFormat cj(android.content.Context r3) {
        /*
            java.text.SimpleDateFormat r0 = com.freshchat.consumer.sdk.j.n.pS
            if (r0 != 0) goto L_0x002b
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x0016 }
            int r1 = com.freshchat.consumer.sdk.R.string.freshchat_chat_calendar_date_format     // Catch:{ Exception -> 0x0016 }
            java.lang.String r1 = r3.getString(r1)     // Catch:{ Exception -> 0x0016 }
            java.util.Locale r2 = com.freshchat.consumer.sdk.j.ah.bb(r3)     // Catch:{ Exception -> 0x0016 }
            r0.<init>(r1, r2)     // Catch:{ Exception -> 0x0016 }
            com.freshchat.consumer.sdk.j.n.pS = r0     // Catch:{ Exception -> 0x0016 }
            goto L_0x002b
        L_0x0016:
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x0024 }
            java.lang.String r1 = "EEEE',' dd MMM yyyy"
            java.util.Locale r3 = com.freshchat.consumer.sdk.j.ah.bb(r3)     // Catch:{ Exception -> 0x0024 }
            r0.<init>(r1, r3)     // Catch:{ Exception -> 0x0024 }
            com.freshchat.consumer.sdk.j.n.pS = r0     // Catch:{ Exception -> 0x0024 }
            goto L_0x002b
        L_0x0024:
            java.lang.String r3 = "FRESHCHAT"
            java.lang.String r0 = "Error parsing default calendar template format in getDateFormatForCalendarDay()"
            com.freshchat.consumer.sdk.j.ai.e(r3, r0)
        L_0x002b:
            java.text.SimpleDateFormat r3 = com.freshchat.consumer.sdk.j.n.pS
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.j.n.cj(android.content.Context):java.text.SimpleDateFormat");
    }

    public static boolean d(long j, long j2) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTimeInMillis(j2);
        return instance.get(1) != instance2.get(1);
    }

    public static boolean e(long j, long j2) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTimeInMillis(j2);
        return (instance.get(2) == instance2.get(2) && instance.get(1) == instance2.get(1)) ? false : true;
    }

    public static void ef() {
        kX = null;
        hA = null;
        hB = null;
        kH = null;
        kI = null;
        pS = null;
        pR = null;
    }

    public static long fP() {
        try {
            return new GregorianCalendar(DesugarTimeZone.getTimeZone("GMT")).getTimeInMillis();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String i(Context context, long j) {
        return a(context, j, true);
    }

    public static String o(Context context, long j) {
        if (context == null || j <= 0) {
            return null;
        }
        SimpleDateFormat bt = bt(context);
        bt.setTimeZone(TimeZone.getDefault());
        return bt.format(new Date(j));
    }

    public static String p(Context context, long j) {
        SimpleDateFormat ci = ci(context);
        if (ci == null) {
            return "";
        }
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        return ci.format(instance.getTime());
    }

    public static String q(Context context, long j) {
        return j > 0 ? a(context, C(j)) : "";
    }

    public static String s(int i) {
        if (i <= 0) {
            return "00:00";
        }
        int i2 = i / 60;
        int abs = Math.abs((i2 * 60) - i);
        StringBuilder sb = new StringBuilder();
        if (i2 < 10) {
            sb.append("0");
        }
        sb.append(i2);
        sb.append(ProductDiscountsObject.KEY_DELIMITER);
        if (abs < 10) {
            sb.append("0");
        }
        sb.append(abs);
        return sb.toString();
    }
}
