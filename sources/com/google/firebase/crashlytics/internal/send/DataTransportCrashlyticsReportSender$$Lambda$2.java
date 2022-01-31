package com.google.firebase.crashlytics.internal.send;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.rabbitmq.client.StringRpcServer;
import java.nio.charset.Charset;

/* compiled from: DataTransportCrashlyticsReportSender */
public final /* synthetic */ class DataTransportCrashlyticsReportSender$$Lambda$2 implements cu1 {
    private static final DataTransportCrashlyticsReportSender$$Lambda$2 instance = new DataTransportCrashlyticsReportSender$$Lambda$2();

    private DataTransportCrashlyticsReportSender$$Lambda$2() {
    }

    public static cu1 lambdaFactory$() {
        return instance;
    }

    @Override // defpackage.cu1
    public Object apply(Object obj) {
        return DataTransportCrashlyticsReportSender.TRANSFORM.reportToJson((CrashlyticsReport) obj).getBytes(Charset.forName(StringRpcServer.STRING_ENCODING));
    }
}
