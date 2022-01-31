package defpackage;

import j$.util.DesugarTimeZone;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* renamed from: ly5  reason: default package */
/* compiled from: DateUtils */
public class ly5 {

    /* renamed from: a  reason: collision with root package name */
    public static final SimpleDateFormat f2296a;
    public static final SimpleDateFormat b;
    public static final Object c = new Object();

    static {
        Locale locale = Locale.US;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", locale);
        f2296a = simpleDateFormat;
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale);
        b = simpleDateFormat2;
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        simpleDateFormat2.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
    }

    public static String a(long j) {
        String format;
        synchronized (c) {
            format = f2296a.format(new Date(j));
        }
        return format;
    }

    public static long b(String str) throws ParseException {
        long time;
        if (str != null) {
            try {
                synchronized (c) {
                    try {
                        time = f2296a.parse(str).getTime();
                    } catch (ParseException unused) {
                        return b.parse(str).getTime();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return time;
            } catch (Exception e) {
                StringBuilder l0 = hj1.l0("Unexpected issue when attempting to parse ", str, " - ");
                l0.append(e.getMessage());
                throw new ParseException(l0.toString(), -1);
            }
        } else {
            throw new ParseException("Unable to parse null timestamp", -1);
        }
    }

    public static long c(String str, long j) {
        try {
            return b(str);
        } catch (ParseException unused) {
            return j;
        }
    }
}
