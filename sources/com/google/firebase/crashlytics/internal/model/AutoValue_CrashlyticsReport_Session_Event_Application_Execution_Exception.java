package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.Objects;

public final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception extends CrashlyticsReport.Session.Event.Application.Execution.Exception {
    private final CrashlyticsReport.Session.Event.Application.Execution.Exception causedBy;
    private final ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> frames;
    private final int overflowCount;
    private final String reason;
    private final String type;

    public static final class Builder extends CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder {
        private CrashlyticsReport.Session.Event.Application.Execution.Exception causedBy;
        private ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> frames;
        private Integer overflowCount;
        private String reason;
        private String type;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Exception build() {
            String str = this.type == null ? " type" : "";
            if (this.frames == null) {
                str = hj1.S(str, " frames");
            }
            if (this.overflowCount == null) {
                str = hj1.S(str, " overflowCount");
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception(this.type, this.reason, this.frames, this.causedBy, this.overflowCount.intValue());
            }
            throw new IllegalStateException(hj1.S("Missing required properties:", str));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder setCausedBy(CrashlyticsReport.Session.Event.Application.Execution.Exception exception) {
            this.causedBy = exception;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder setFrames(ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> immutableList) {
            Objects.requireNonNull(immutableList, "Null frames");
            this.frames = immutableList;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder setOverflowCount(int i) {
            this.overflowCount = Integer.valueOf(i);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder setReason(String str) {
            this.reason = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder setType(String str) {
            Objects.requireNonNull(str, "Null type");
            this.type = str;
            return this;
        }
    }

    public boolean equals(Object obj) {
        String str;
        CrashlyticsReport.Session.Event.Application.Execution.Exception exception;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Application.Execution.Exception)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Application.Execution.Exception exception2 = (CrashlyticsReport.Session.Event.Application.Execution.Exception) obj;
        if (!this.type.equals(exception2.getType()) || ((str = this.reason) != null ? !str.equals(exception2.getReason()) : exception2.getReason() != null) || !this.frames.equals(exception2.getFrames()) || ((exception = this.causedBy) != null ? !exception.equals(exception2.getCausedBy()) : exception2.getCausedBy() != null) || this.overflowCount != exception2.getOverflowCount()) {
            return false;
        }
        return true;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception
    public CrashlyticsReport.Session.Event.Application.Execution.Exception getCausedBy() {
        return this.causedBy;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception
    public ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> getFrames() {
        return this.frames;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception
    public int getOverflowCount() {
        return this.overflowCount;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception
    public String getReason() {
        return this.reason;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception
    public String getType() {
        return this.type;
    }

    public int hashCode() {
        int hashCode = (this.type.hashCode() ^ 1000003) * 1000003;
        String str = this.reason;
        int i = 0;
        int hashCode2 = (((hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.frames.hashCode()) * 1000003;
        CrashlyticsReport.Session.Event.Application.Execution.Exception exception = this.causedBy;
        if (exception != null) {
            i = exception.hashCode();
        }
        return ((hashCode2 ^ i) * 1000003) ^ this.overflowCount;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("Exception{type=");
        i0.append(this.type);
        i0.append(", reason=");
        i0.append(this.reason);
        i0.append(", frames=");
        i0.append(this.frames);
        i0.append(", causedBy=");
        i0.append(this.causedBy);
        i0.append(", overflowCount=");
        return hj1.X(i0, this.overflowCount, "}");
    }

    private AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception(String str, String str2, ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> immutableList, CrashlyticsReport.Session.Event.Application.Execution.Exception exception, int i) {
        this.type = str;
        this.reason = str2;
        this.frames = immutableList;
        this.causedBy = exception;
        this.overflowCount = i;
    }
}
