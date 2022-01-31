package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.Objects;

public final class AutoValue_CrashlyticsReportWithSessionId extends CrashlyticsReportWithSessionId {
    private final CrashlyticsReport report;
    private final String sessionId;

    public AutoValue_CrashlyticsReportWithSessionId(CrashlyticsReport crashlyticsReport, String str) {
        Objects.requireNonNull(crashlyticsReport, "Null report");
        this.report = crashlyticsReport;
        Objects.requireNonNull(str, "Null sessionId");
        this.sessionId = str;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReportWithSessionId)) {
            return false;
        }
        CrashlyticsReportWithSessionId crashlyticsReportWithSessionId = (CrashlyticsReportWithSessionId) obj;
        if (!this.report.equals(crashlyticsReportWithSessionId.getReport()) || !this.sessionId.equals(crashlyticsReportWithSessionId.getSessionId())) {
            return false;
        }
        return true;
    }

    @Override // com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId
    public CrashlyticsReport getReport() {
        return this.report;
    }

    @Override // com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId
    public String getSessionId() {
        return this.sessionId;
    }

    public int hashCode() {
        return ((this.report.hashCode() ^ 1000003) * 1000003) ^ this.sessionId.hashCode();
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("CrashlyticsReportWithSessionId{report=");
        i0.append(this.report);
        i0.append(", sessionId=");
        return hj1.a0(i0, this.sessionId, "}");
    }
}
