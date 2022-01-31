package com.google.firebase.perf.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.Clock;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.v1.PerfSession;
import com.google.firebase.perf.v1.SessionVerbosity;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class PerfSession implements Parcelable {
    public static final Parcelable.Creator<PerfSession> CREATOR = new Parcelable.Creator<PerfSession>() {
        /* class com.google.firebase.perf.internal.PerfSession.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public PerfSession createFromParcel(Parcel parcel) {
            return new PerfSession(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public PerfSession[] newArray(int i) {
            return new PerfSession[i];
        }
    };
    private Timer mCreationTime;
    private boolean mGaugeAndEventCollectionEnabled;
    private String mSessionId;

    public static com.google.firebase.perf.v1.PerfSession[] buildAndSort(List<PerfSession> list) {
        if (list.isEmpty()) {
            return null;
        }
        com.google.firebase.perf.v1.PerfSession[] perfSessionArr = new com.google.firebase.perf.v1.PerfSession[list.size()];
        com.google.firebase.perf.v1.PerfSession build = list.get(0).build();
        boolean z = false;
        for (int i = 1; i < list.size(); i++) {
            com.google.firebase.perf.v1.PerfSession build2 = list.get(i).build();
            if (z || !list.get(i).isVerbose()) {
                perfSessionArr[i] = build2;
            } else {
                perfSessionArr[0] = build2;
                perfSessionArr[i] = build;
                z = true;
            }
        }
        if (!z) {
            perfSessionArr[0] = build;
        }
        return perfSessionArr;
    }

    public static PerfSession create() {
        String replaceAll = UUID.randomUUID().toString().replaceAll("\\-", "");
        PerfSession perfSession = new PerfSession(replaceAll, new Clock());
        perfSession.setGaugeAndEventCollectionEnabled(shouldCollectGaugesAndEvents());
        AndroidLogger instance = AndroidLogger.getInstance();
        Object[] objArr = new Object[2];
        objArr[0] = perfSession.isVerbose() ? "Verbose" : "Non Verbose";
        objArr[1] = replaceAll;
        instance.debug(String.format("Creating a new %s Session: %s", objArr), new Object[0]);
        return perfSession;
    }

    public static boolean shouldCollectGaugesAndEvents() {
        ConfigResolver instance = ConfigResolver.getInstance();
        return instance.isPerformanceMonitoringEnabled() && Math.random() < ((double) instance.getSessionsSamplingRate());
    }

    public com.google.firebase.perf.v1.PerfSession build() {
        PerfSession.Builder sessionId = com.google.firebase.perf.v1.PerfSession.newBuilder().setSessionId(this.mSessionId);
        if (this.mGaugeAndEventCollectionEnabled) {
            sessionId.addSessionVerbosity(SessionVerbosity.GAUGES_AND_SYSTEM_EVENTS);
        }
        return (com.google.firebase.perf.v1.PerfSession) sessionId.build();
    }

    public int describeContents() {
        return 0;
    }

    public Timer getTimer() {
        return this.mCreationTime;
    }

    public boolean isExpired() {
        return TimeUnit.MICROSECONDS.toMinutes(this.mCreationTime.getDurationMicros()) > ConfigResolver.getInstance().getSessionsMaxDurationMinutes();
    }

    public boolean isGaugeAndEventCollectionEnabled() {
        return this.mGaugeAndEventCollectionEnabled;
    }

    public boolean isVerbose() {
        return this.mGaugeAndEventCollectionEnabled;
    }

    public String sessionId() {
        return this.mSessionId;
    }

    public void setGaugeAndEventCollectionEnabled(boolean z) {
        this.mGaugeAndEventCollectionEnabled = z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mSessionId);
        parcel.writeByte(this.mGaugeAndEventCollectionEnabled ? (byte) 1 : 0);
        parcel.writeParcelable(this.mCreationTime, 0);
    }

    public PerfSession(String str, Clock clock) {
        this.mGaugeAndEventCollectionEnabled = false;
        this.mSessionId = str;
        this.mCreationTime = clock.getTime();
    }

    public static boolean isVerbose(com.google.firebase.perf.v1.PerfSession perfSession) {
        for (SessionVerbosity sessionVerbosity : perfSession.getSessionVerbosityList()) {
            if (sessionVerbosity == SessionVerbosity.GAUGES_AND_SYSTEM_EVENTS) {
                return true;
            }
        }
        return false;
    }

    private PerfSession(Parcel parcel) {
        boolean z = false;
        this.mGaugeAndEventCollectionEnabled = false;
        this.mSessionId = parcel.readString();
        this.mGaugeAndEventCollectionEnabled = parcel.readByte() != 0 ? true : z;
        this.mCreationTime = (Timer) parcel.readParcelable(Timer.class.getClassLoader());
    }
}
