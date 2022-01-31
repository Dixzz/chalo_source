package com.google.firebase.appindexing.builders;

import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import com.google.firebase.appindexing.internal.zzad;
import java.util.Calendar;

/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class StopwatchBuilder extends IndexableBuilder<StopwatchBuilder> {
    public static final String PAUSED = "Paused";
    public static final String STARTED = "Started";
    public static final String UNKNOWN = "Unknown";

    public StopwatchBuilder() {
        super("Stopwatch");
    }

    public final StopwatchBuilder setElapsedTime(long j) {
        return (StopwatchBuilder) put("elapsedTime", j);
    }

    public final StopwatchBuilder setLaps(StopwatchLapBuilder... stopwatchLapBuilderArr) {
        return (StopwatchBuilder) put("laps", stopwatchLapBuilderArr);
    }

    public final StopwatchBuilder setStartTime(Calendar calendar) {
        return (StopwatchBuilder) put(SuperPassJsonKeys.START_TIME, zzad.zza(calendar));
    }

    public final StopwatchBuilder setStopwatchStatus(String str) {
        if ("Started".equals(str) || "Paused".equals(str) || "Unknown".equals(str)) {
            return (StopwatchBuilder) put("stopwatchStatus", str);
        }
        String valueOf = String.valueOf(str);
        throw new IllegalArgumentException(valueOf.length() != 0 ? "Invalid stopwatch status ".concat(valueOf) : new String("Invalid stopwatch status "));
    }
}
