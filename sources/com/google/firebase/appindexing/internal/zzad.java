package com.google.firebase.appindexing.internal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class zzad {
    @GuardedBy("itself")
    private static final DateFormat zzfz = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US);

    public static String zza(Calendar calendar) {
        String format;
        DateFormat dateFormat = zzfz;
        synchronized (dateFormat) {
            dateFormat.setTimeZone(calendar.getTimeZone());
            format = dateFormat.format(calendar.getTime());
        }
        return format;
    }
}
