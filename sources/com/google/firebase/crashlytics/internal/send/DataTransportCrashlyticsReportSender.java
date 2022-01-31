package com.google.firebase.crashlytics.internal.send;

import android.content.Context;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;

public class DataTransportCrashlyticsReportSender {
    private static final String CRASHLYTICS_API_KEY = mergeStrings("AzSBpY4F0rHiHFdinTvM", "IayrSTFL9eJ69YeSUO2");
    private static final String CRASHLYTICS_ENDPOINT = mergeStrings("hts/cahyiseot-agolai.o/1frlglgc/aclg", "tp:/rsltcrprsp.ogepscmv/ieo/eaybtho");
    private static final String CRASHLYTICS_TRANSPORT_NAME = "FIREBASE_CRASHLYTICS_REPORT";
    private static final cu1<CrashlyticsReport, byte[]> DEFAULT_TRANSFORM = DataTransportCrashlyticsReportSender$$Lambda$2.lambdaFactory$();
    private static final CrashlyticsReportJsonTransform TRANSFORM = new CrashlyticsReportJsonTransform();
    private final du1<CrashlyticsReport> transport;
    private final cu1<CrashlyticsReport, byte[]> transportTransform;

    public DataTransportCrashlyticsReportSender(du1<CrashlyticsReport> du1, cu1<CrashlyticsReport, byte[]> cu1) {
        this.transport = du1;
        this.transportTransform = cu1;
    }

    public static DataTransportCrashlyticsReportSender create(Context context) {
        nv1.b(context);
        eu1 c = nv1.a().c(new iu1(CRASHLYTICS_ENDPOINT, CRASHLYTICS_API_KEY));
        zt1 zt1 = new zt1("json");
        cu1<CrashlyticsReport, byte[]> cu1 = DEFAULT_TRANSFORM;
        return new DataTransportCrashlyticsReportSender(((kv1) c).a(CRASHLYTICS_TRANSPORT_NAME, CrashlyticsReport.class, zt1, cu1), cu1);
    }

    public static /* synthetic */ void lambda$sendReport$1(zi4 zi4, CrashlyticsReportWithSessionId crashlyticsReportWithSessionId, Exception exc) {
        if (exc != null) {
            zi4.a(exc);
        } else {
            zi4.b(crashlyticsReportWithSessionId);
        }
    }

    private static String mergeStrings(String str, String str2) {
        int length = str.length() - str2.length();
        if (length < 0 || length > 1) {
            throw new IllegalArgumentException("Invalid input received");
        }
        StringBuilder sb = new StringBuilder(str2.length() + str.length());
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            if (str2.length() > i) {
                sb.append(str2.charAt(i));
            }
        }
        return sb.toString();
    }

    public yi4<CrashlyticsReportWithSessionId> sendReport(CrashlyticsReportWithSessionId crashlyticsReportWithSessionId) {
        CrashlyticsReport report = crashlyticsReportWithSessionId.getReport();
        zi4 zi4 = new zi4();
        ((lv1) this.transport).a(new yt1(null, report, bu1.HIGHEST), DataTransportCrashlyticsReportSender$$Lambda$1.lambdaFactory$(zi4, crashlyticsReportWithSessionId));
        return zi4.f4178a;
    }
}
