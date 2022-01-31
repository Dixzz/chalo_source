package com.google.firebase.crashlytics.internal.common;

/* compiled from: SessionReportingCoordinator */
public final /* synthetic */ class SessionReportingCoordinator$$Lambda$1 implements qi4 {
    private final SessionReportingCoordinator arg$1;

    private SessionReportingCoordinator$$Lambda$1(SessionReportingCoordinator sessionReportingCoordinator) {
        this.arg$1 = sessionReportingCoordinator;
    }

    public static qi4 lambdaFactory$(SessionReportingCoordinator sessionReportingCoordinator) {
        return new SessionReportingCoordinator$$Lambda$1(sessionReportingCoordinator);
    }

    @Override // defpackage.qi4
    public Object then(yi4 yi4) {
        return Boolean.valueOf(this.arg$1.onReportSendComplete(yi4));
    }
}
