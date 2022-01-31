package defpackage;

import android.annotation.TargetApi;
import android.icu.text.DateFormat;
import android.icu.util.TimeZone;
import j$.util.DesugarTimeZone;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: pm4  reason: default package */
/* compiled from: UtcDates */
public class pm4 {

    /* renamed from: a  reason: collision with root package name */
    public static AtomicReference<om4> f2830a = new AtomicReference<>();

    public static long a(long j) {
        Calendar g = g();
        g.setTimeInMillis(j);
        return d(g).getTimeInMillis();
    }

    public static int b(String str, String str2, int i, int i2) {
        while (i2 >= 0 && i2 < str.length() && str2.indexOf(str.charAt(i2)) == -1) {
            if (str.charAt(i2) == '\'') {
                do {
                    i2 += i;
                    if (i2 < 0 || i2 >= str.length()) {
                        break;
                    }
                } while (str.charAt(i2) != '\'');
            }
            i2 += i;
        }
        return i2;
    }

    @TargetApi(24)
    public static DateFormat c(String str, Locale locale) {
        DateFormat instanceForSkeleton = DateFormat.getInstanceForSkeleton(str, locale);
        instanceForSkeleton.setTimeZone(TimeZone.getTimeZone("UTC"));
        return instanceForSkeleton;
    }

    public static Calendar d(Calendar calendar) {
        Calendar h = h(calendar);
        Calendar g = g();
        g.set(h.get(1), h.get(2), h.get(5));
        return g;
    }

    public static java.util.TimeZone e() {
        return DesugarTimeZone.getTimeZone("UTC");
    }

    public static Calendar f() {
        om4 om4 = f2830a.get();
        if (om4 == null) {
            om4 = om4.c;
        }
        java.util.TimeZone timeZone = om4.b;
        Calendar instance = timeZone == null ? Calendar.getInstance() : Calendar.getInstance(timeZone);
        Long l = om4.f2711a;
        if (l != null) {
            instance.setTimeInMillis(l.longValue());
        }
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        instance.setTimeZone(e());
        return instance;
    }

    public static Calendar g() {
        return h(null);
    }

    public static Calendar h(Calendar calendar) {
        Calendar instance = Calendar.getInstance(e());
        if (calendar == null) {
            instance.clear();
        } else {
            instance.setTimeInMillis(calendar.getTimeInMillis());
        }
        return instance;
    }
}
