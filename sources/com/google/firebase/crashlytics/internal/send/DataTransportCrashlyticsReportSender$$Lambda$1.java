package com.google.firebase.crashlytics.internal.send;

import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;

/* compiled from: DataTransportCrashlyticsReportSender */
public final /* synthetic */ class DataTransportCrashlyticsReportSender$$Lambda$1 implements fu1 {
    private final zi4 arg$1;
    private final CrashlyticsReportWithSessionId arg$2;

    private DataTransportCrashlyticsReportSender$$Lambda$1(zi4 zi4, CrashlyticsReportWithSessionId crashlyticsReportWithSessionId) {
        this.arg$1 = zi4;
        this.arg$2 = crashlyticsReportWithSessionId;
    }

    public static fu1 lambdaFactory$(zi4 zi4, CrashlyticsReportWithSessionId crashlyticsReportWithSessionId) {
        return new DataTransportCrashlyticsReportSender$$Lambda$1(zi4, crashlyticsReportWithSessionId);
    }

    @Override // defpackage.fu1
    public void onSchedule(Exception exc) {
        DataTransportCrashlyticsReportSender.lambda$sendReport$1(this.arg$1, this.arg$2, exc);
    }
}
