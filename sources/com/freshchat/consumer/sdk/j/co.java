package com.freshchat.consumer.sdk.j;

import com.google.firebase.appindexing.Indexable;
import java.util.Calendar;
import java.util.TimeZone;

public class co {
    public static Calendar a(TimeZone timeZone, long j) {
        Calendar instance = Calendar.getInstance();
        if (timeZone != null) {
            instance.setTimeZone(timeZone);
        }
        instance.setTimeInMillis(j);
        return instance;
    }

    public static void a(Calendar calendar, int i) {
        if (calendar != null) {
            calendar.setTimeInMillis(calendar.getTimeInMillis() + ((long) (i * Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL)));
        }
    }
}
