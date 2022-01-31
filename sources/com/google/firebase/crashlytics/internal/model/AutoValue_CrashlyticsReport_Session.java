package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.encoders.annotations.Encodable;
import java.util.Objects;

public final class AutoValue_CrashlyticsReport_Session extends CrashlyticsReport.Session {

    /* renamed from: app  reason: collision with root package name */
    private final CrashlyticsReport.Session.Application f653app;
    private final boolean crashed;
    private final CrashlyticsReport.Session.Device device;
    private final Long endedAt;
    private final ImmutableList<CrashlyticsReport.Session.Event> events;
    private final String generator;
    private final int generatorType;
    private final String identifier;
    private final CrashlyticsReport.Session.OperatingSystem os;
    private final long startedAt;
    private final CrashlyticsReport.Session.User user;

    public static final class Builder extends CrashlyticsReport.Session.Builder {

        /* renamed from: app  reason: collision with root package name */
        private CrashlyticsReport.Session.Application f654app;
        private Boolean crashed;
        private CrashlyticsReport.Session.Device device;
        private Long endedAt;
        private ImmutableList<CrashlyticsReport.Session.Event> events;
        private String generator;
        private Integer generatorType;
        private String identifier;
        private CrashlyticsReport.Session.OperatingSystem os;
        private Long startedAt;
        private CrashlyticsReport.Session.User user;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session build() {
            String str = this.generator == null ? " generator" : "";
            if (this.identifier == null) {
                str = hj1.S(str, " identifier");
            }
            if (this.startedAt == null) {
                str = hj1.S(str, " startedAt");
            }
            if (this.crashed == null) {
                str = hj1.S(str, " crashed");
            }
            if (this.f654app == null) {
                str = hj1.S(str, " app");
            }
            if (this.generatorType == null) {
                str = hj1.S(str, " generatorType");
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session(this.generator, this.identifier, this.startedAt.longValue(), this.endedAt, this.crashed.booleanValue(), this.f654app, this.user, this.os, this.device, this.events, this.generatorType.intValue());
            }
            throw new IllegalStateException(hj1.S("Missing required properties:", str));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder setApp(CrashlyticsReport.Session.Application application) {
            Objects.requireNonNull(application, "Null app");
            this.f654app = application;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder setCrashed(boolean z) {
            this.crashed = Boolean.valueOf(z);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder setDevice(CrashlyticsReport.Session.Device device2) {
            this.device = device2;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder setEndedAt(Long l) {
            this.endedAt = l;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder setEvents(ImmutableList<CrashlyticsReport.Session.Event> immutableList) {
            this.events = immutableList;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder setGenerator(String str) {
            Objects.requireNonNull(str, "Null generator");
            this.generator = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder setGeneratorType(int i) {
            this.generatorType = Integer.valueOf(i);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder setIdentifier(String str) {
            Objects.requireNonNull(str, "Null identifier");
            this.identifier = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder setOs(CrashlyticsReport.Session.OperatingSystem operatingSystem) {
            this.os = operatingSystem;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder setStartedAt(long j) {
            this.startedAt = Long.valueOf(j);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder setUser(CrashlyticsReport.Session.User user2) {
            this.user = user2;
            return this;
        }

        public Builder() {
        }

        private Builder(CrashlyticsReport.Session session) {
            this.generator = session.getGenerator();
            this.identifier = session.getIdentifier();
            this.startedAt = Long.valueOf(session.getStartedAt());
            this.endedAt = session.getEndedAt();
            this.crashed = Boolean.valueOf(session.isCrashed());
            this.f654app = session.getApp();
            this.user = session.getUser();
            this.os = session.getOs();
            this.device = session.getDevice();
            this.events = session.getEvents();
            this.generatorType = Integer.valueOf(session.getGeneratorType());
        }
    }

    public boolean equals(Object obj) {
        Long l;
        CrashlyticsReport.Session.User user2;
        CrashlyticsReport.Session.OperatingSystem operatingSystem;
        CrashlyticsReport.Session.Device device2;
        ImmutableList<CrashlyticsReport.Session.Event> immutableList;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session)) {
            return false;
        }
        CrashlyticsReport.Session session = (CrashlyticsReport.Session) obj;
        if (!this.generator.equals(session.getGenerator()) || !this.identifier.equals(session.getIdentifier()) || this.startedAt != session.getStartedAt() || ((l = this.endedAt) != null ? !l.equals(session.getEndedAt()) : session.getEndedAt() != null) || this.crashed != session.isCrashed() || !this.f653app.equals(session.getApp()) || ((user2 = this.user) != null ? !user2.equals(session.getUser()) : session.getUser() != null) || ((operatingSystem = this.os) != null ? !operatingSystem.equals(session.getOs()) : session.getOs() != null) || ((device2 = this.device) != null ? !device2.equals(session.getDevice()) : session.getDevice() != null) || ((immutableList = this.events) != null ? !immutableList.equals(session.getEvents()) : session.getEvents() != null) || this.generatorType != session.getGeneratorType()) {
            return false;
        }
        return true;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public CrashlyticsReport.Session.Application getApp() {
        return this.f653app;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public CrashlyticsReport.Session.Device getDevice() {
        return this.device;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public Long getEndedAt() {
        return this.endedAt;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public ImmutableList<CrashlyticsReport.Session.Event> getEvents() {
        return this.events;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public String getGenerator() {
        return this.generator;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public int getGeneratorType() {
        return this.generatorType;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    @Encodable.Ignore
    public String getIdentifier() {
        return this.identifier;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public CrashlyticsReport.Session.OperatingSystem getOs() {
        return this.os;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public long getStartedAt() {
        return this.startedAt;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public CrashlyticsReport.Session.User getUser() {
        return this.user;
    }

    public int hashCode() {
        long j = this.startedAt;
        int hashCode = (((((this.generator.hashCode() ^ 1000003) * 1000003) ^ this.identifier.hashCode()) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        Long l = this.endedAt;
        int i = 0;
        int hashCode2 = (((((hashCode ^ (l == null ? 0 : l.hashCode())) * 1000003) ^ (this.crashed ? 1231 : 1237)) * 1000003) ^ this.f653app.hashCode()) * 1000003;
        CrashlyticsReport.Session.User user2 = this.user;
        int hashCode3 = (hashCode2 ^ (user2 == null ? 0 : user2.hashCode())) * 1000003;
        CrashlyticsReport.Session.OperatingSystem operatingSystem = this.os;
        int hashCode4 = (hashCode3 ^ (operatingSystem == null ? 0 : operatingSystem.hashCode())) * 1000003;
        CrashlyticsReport.Session.Device device2 = this.device;
        int hashCode5 = (hashCode4 ^ (device2 == null ? 0 : device2.hashCode())) * 1000003;
        ImmutableList<CrashlyticsReport.Session.Event> immutableList = this.events;
        if (immutableList != null) {
            i = immutableList.hashCode();
        }
        return ((hashCode5 ^ i) * 1000003) ^ this.generatorType;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public boolean isCrashed() {
        return this.crashed;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public CrashlyticsReport.Session.Builder toBuilder() {
        return new Builder(this);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("Session{generator=");
        i0.append(this.generator);
        i0.append(", identifier=");
        i0.append(this.identifier);
        i0.append(", startedAt=");
        i0.append(this.startedAt);
        i0.append(", endedAt=");
        i0.append(this.endedAt);
        i0.append(", crashed=");
        i0.append(this.crashed);
        i0.append(", app=");
        i0.append(this.f653app);
        i0.append(", user=");
        i0.append(this.user);
        i0.append(", os=");
        i0.append(this.os);
        i0.append(", device=");
        i0.append(this.device);
        i0.append(", events=");
        i0.append(this.events);
        i0.append(", generatorType=");
        return hj1.X(i0, this.generatorType, "}");
    }

    private AutoValue_CrashlyticsReport_Session(String str, String str2, long j, Long l, boolean z, CrashlyticsReport.Session.Application application, CrashlyticsReport.Session.User user2, CrashlyticsReport.Session.OperatingSystem operatingSystem, CrashlyticsReport.Session.Device device2, ImmutableList<CrashlyticsReport.Session.Event> immutableList, int i) {
        this.generator = str;
        this.identifier = str2;
        this.startedAt = j;
        this.endedAt = l;
        this.crashed = z;
        this.f653app = application;
        this.user = user2;
        this.os = operatingSystem;
        this.device = device2;
        this.events = immutableList;
        this.generatorType = i;
    }
}
