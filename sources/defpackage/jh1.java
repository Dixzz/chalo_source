package defpackage;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import j$.util.DesugarTimeZone;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/* renamed from: jh1  reason: default package */
/* compiled from: TimeUtil */
public class jh1 {
    public static long a(int i) {
        return ((long) i) * 24 * 60 * 60 * 1000;
    }

    public static Date b(long j) {
        Calendar instance = Calendar.getInstance(DesugarTimeZone.getTimeZone("Asia/Calcutta"));
        instance.setTimeInMillis(j);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd:MM:yy");
        try {
            return simpleDateFormat.parse(simpleDateFormat.format(instance.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String c(long j) {
        return new SimpleDateFormat("dd/MM/yyyy").format(new Date(j));
    }

    public static String d(long j) {
        TimeZone.setDefault(DesugarTimeZone.getTimeZone("Asia/Calcutta"));
        return new SimpleDateFormat("dd MMM yyyy").format(new Date(j));
    }

    public static String e(Long l) {
        if (l == null) {
            return "";
        }
        TimeZone.setDefault(DesugarTimeZone.getTimeZone("Asia/Calcutta"));
        return new SimpleDateFormat("dd MMM yyyy").format(new Date(l.longValue()));
    }

    public static String f(long j) {
        TimeZone.setDefault(DesugarTimeZone.getTimeZone("Asia/Calcutta"));
        return new SimpleDateFormat("hh:mm a , dd MMM yyyy").format(new Date(j)).replace("am", "AM").replace("pm", "PM");
    }

    public static String g(long j) {
        TimeZone.setDefault(DesugarTimeZone.getTimeZone("IST"));
        return new SimpleDateFormat("hh:mm a").format(new Date(j * 1000)).replace("am", "AM").replace("pm", "PM");
    }

    public static String h(long j) {
        TimeZone.setDefault(DesugarTimeZone.getTimeZone("Asia/Calcutta"));
        return new SimpleDateFormat("hh:mm a").format(new Date(j * 1000)).replace("am", "AM").replace("pm", "PM");
    }

    public static String i(long j) {
        TimeZone.setDefault(DesugarTimeZone.getTimeZone("Asia/Calcutta"));
        return new SimpleDateFormat("HH:mm:ss").format(new Date(j));
    }

    public static int j(long j) {
        Calendar instance = Calendar.getInstance(DesugarTimeZone.getTimeZone("Asia/Calcutta"));
        instance.setTimeInMillis(j);
        return instance.get(11);
    }

    public static String k(long j) {
        long j2 = j / 1000;
        int i = (int) j2;
        int i2 = (int) (j2 / 60);
        if (i2 == 0) {
            return i + " sec";
        } else if (i2 > 60) {
            int i3 = i2 / 60;
            int i4 = i2 % 60;
            if (i4 == 0) {
                return i3 + "hr ";
            }
            return i3 + "hr " + i4 + "min";
        } else {
            int round = (int) Math.round(((((double) j) * 1.0d) / 1000.0d) / 60.0d);
            return round + " min";
        }
    }

    public static CharSequence l(String str, Context context) {
        String upperCase = str.toUpperCase();
        SpannableStringBuilder f = hj1.f(upperCase);
        f.setSpan(vn.N(context, wg1.NOTOSANS_MEDIUM), 0, f.length(), 17);
        int i = -1;
        while (true) {
            i = upperCase.indexOf("AM", i + 1);
            if (i == -1) {
                break;
            }
            int i2 = i + 2;
            f.setSpan(vn.N(context, wg1.NOTOSANS_MEDIUM), i, i2, 17);
            f.setSpan(new AbsoluteSizeSpan(14, true), i, i2, 17);
        }
        int i3 = -1;
        while (true) {
            i3 = upperCase.indexOf("PM", i3 + 1);
            if (i3 == -1) {
                return f;
            }
            int i4 = i3 + 2;
            f.setSpan(vn.N(context, wg1.NOTOSANS_MEDIUM), i3, i4, 17);
            f.setSpan(new AbsoluteSizeSpan(14, true), i3, i4, 17);
        }
    }

    public static String m(long j) {
        if (!b(System.currentTimeMillis()).equals(b(j))) {
            return new SimpleDateFormat("dd/MM/yyyy").format(Long.valueOf(j));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm a");
        simpleDateFormat.setCalendar(Calendar.getInstance(DesugarTimeZone.getTimeZone("Asia/Calcutta")));
        return simpleDateFormat.format(Long.valueOf(j)).replace("AM", "am").replace("PM", "pm");
    }
}
