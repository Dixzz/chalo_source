package com.google.firebase.appindexing.builders;

/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public class StopwatchLapBuilder extends IndexableBuilder<StopwatchLapBuilder> {
    public StopwatchLapBuilder() {
        super("StopwatchLap");
    }

    public StopwatchLapBuilder setAccumulatedTime(long j) {
        return (StopwatchLapBuilder) put("accumulatedTime", j);
    }

    public StopwatchLapBuilder setElapsedTime(long j) {
        return (StopwatchLapBuilder) put("elapsedTime", j);
    }
}
