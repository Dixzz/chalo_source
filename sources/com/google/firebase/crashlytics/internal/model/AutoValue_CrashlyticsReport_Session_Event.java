package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.Objects;

public final class AutoValue_CrashlyticsReport_Session_Event extends CrashlyticsReport.Session.Event {

    /* renamed from: app  reason: collision with root package name */
    private final CrashlyticsReport.Session.Event.Application f655app;
    private final CrashlyticsReport.Session.Event.Device device;
    private final CrashlyticsReport.Session.Event.Log log;
    private final long timestamp;
    private final String type;

    public static final class Builder extends CrashlyticsReport.Session.Event.Builder {

        /* renamed from: app  reason: collision with root package name */
        private CrashlyticsReport.Session.Event.Application f656app;
        private CrashlyticsReport.Session.Event.Device device;
        private CrashlyticsReport.Session.Event.Log log;
        private Long timestamp;
        private String type;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Builder
        public CrashlyticsReport.Session.Event build() {
            String str = this.timestamp == null ? " timestamp" : "";
            if (this.type == null) {
                str = hj1.S(str, " type");
            }
            if (this.f656app == null) {
                str = hj1.S(str, " app");
            }
            if (this.device == null) {
                str = hj1.S(str, " device");
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_Event(this.timestamp.longValue(), this.type, this.f656app, this.device, this.log);
            }
            throw new IllegalStateException(hj1.S("Missing required properties:", str));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Builder
        public CrashlyticsReport.Session.Event.Builder setApp(CrashlyticsReport.Session.Event.Application application) {
            Objects.requireNonNull(application, "Null app");
            this.f656app = application;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Builder
        public CrashlyticsReport.Session.Event.Builder setDevice(CrashlyticsReport.Session.Event.Device device2) {
            Objects.requireNonNull(device2, "Null device");
            this.device = device2;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Builder
        public CrashlyticsReport.Session.Event.Builder setLog(CrashlyticsReport.Session.Event.Log log2) {
            this.log = log2;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Builder
        public CrashlyticsReport.Session.Event.Builder setTimestamp(long j) {
            this.timestamp = Long.valueOf(j);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Builder
        public CrashlyticsReport.Session.Event.Builder setType(String str) {
            Objects.requireNonNull(str, "Null type");
            this.type = str;
            return this;
        }

        public Builder() {
        }

        private Builder(CrashlyticsReport.Session.Event event) {
            this.timestamp = Long.valueOf(event.getTimestamp());
            this.type = event.getType();
            this.f656app = event.getApp();
            this.device = event.getDevice();
            this.log = event.getLog();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event)) {
            return false;
        }
        CrashlyticsReport.Session.Event event = (CrashlyticsReport.Session.Event) obj;
        if (this.timestamp == event.getTimestamp() && this.type.equals(event.getType()) && this.f655app.equals(event.getApp()) && this.device.equals(event.getDevice())) {
            CrashlyticsReport.Session.Event.Log log2 = this.log;
            if (log2 == null) {
                if (event.getLog() == null) {
                    return true;
                }
            } else if (log2.equals(event.getLog())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event
    public CrashlyticsReport.Session.Event.Application getApp() {
        return this.f655app;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event
    public CrashlyticsReport.Session.Event.Device getDevice() {
        return this.device;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event
    public CrashlyticsReport.Session.Event.Log getLog() {
        return this.log;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event
    public long getTimestamp() {
        return this.timestamp;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event
    public String getType() {
        return this.type;
    }

    public int hashCode() {
        long j = this.timestamp;
        int hashCode = (((((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.type.hashCode()) * 1000003) ^ this.f655app.hashCode()) * 1000003) ^ this.device.hashCode()) * 1000003;
        CrashlyticsReport.Session.Event.Log log2 = this.log;
        return (log2 == null ? 0 : log2.hashCode()) ^ hashCode;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event
    public CrashlyticsReport.Session.Event.Builder toBuilder() {
        return new Builder(this);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("Event{timestamp=");
        i0.append(this.timestamp);
        i0.append(", type=");
        i0.append(this.type);
        i0.append(", app=");
        i0.append(this.f655app);
        i0.append(", device=");
        i0.append(this.device);
        i0.append(", log=");
        i0.append(this.log);
        i0.append("}");
        return i0.toString();
    }

    private AutoValue_CrashlyticsReport_Session_Event(long j, String str, CrashlyticsReport.Session.Event.Application application, CrashlyticsReport.Session.Event.Device device2, CrashlyticsReport.Session.Event.Log log2) {
        this.timestamp = j;
        this.type = str;
        this.f655app = application;
        this.device = device2;
        this.log = log2;
    }
}
