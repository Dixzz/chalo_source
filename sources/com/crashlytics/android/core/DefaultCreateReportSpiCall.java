package com.crashlytics.android.core;

import defpackage.q16;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

public class DefaultCreateReportSpiCall extends g06 implements CreateReportSpiCall {
    public static final String FILE_CONTENT_TYPE = "application/octet-stream";
    public static final String FILE_PARAM = "report[file]";
    public static final String IDENTIFIER_PARAM = "report[identifier]";
    public static final String MULTI_FILE_PARAM = "report[file";

    public DefaultCreateReportSpiCall(c06 c06, String str, String str2, r16 r16) {
        super(c06, str, str2, r16, p16.POST);
    }

    private q16 applyHeadersTo(q16 q16, CreateReportRequest createReportRequest) {
        q16.h().setRequestProperty(g06.HEADER_API_KEY, createReportRequest.apiKey);
        q16.h().setRequestProperty("X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        q16.h().setRequestProperty("X-CRASHLYTICS-API-CLIENT-VERSION", this.kit.getVersion());
        for (Map.Entry<String, String> entry : createReportRequest.report.getCustomHeaders().entrySet()) {
            q16.j(entry.getKey(), entry.getValue());
        }
        return q16;
    }

    private q16 applyMultipartDataTo(q16 q16, Report report) {
        String identifier = report.getIdentifier();
        Objects.requireNonNull(q16);
        try {
            q16.o();
            q16.p("report[identifier]", null, null);
            q16.d.a(identifier);
            if (report.getFiles().length == 1) {
                report.getFileName();
                report.getIdentifier();
                q16.m("report[file]", report.getFileName(), "application/octet-stream", report.getFile());
                return q16;
            }
            File[] files = report.getFiles();
            int i = 0;
            for (File file : files) {
                file.getName();
                report.getIdentifier();
                q16.m("report[file" + i + "]", file.getName(), "application/octet-stream", file);
                i++;
            }
            return q16;
        } catch (IOException e) {
            throw new q16.c(e);
        }
    }

    @Override // com.crashlytics.android.core.CreateReportSpiCall
    public boolean invoke(CreateReportRequest createReportRequest) {
        q16 applyMultipartDataTo = applyMultipartDataTo(applyHeadersTo(getHttpRequest(), createReportRequest), createReportRequest.report);
        getUrl();
        int e = applyMultipartDataTo.e();
        applyMultipartDataTo.k("X-REQUEST-ID");
        return hd3.p2(e) == 0;
    }

    public DefaultCreateReportSpiCall(c06 c06, String str, String str2, r16 r16, p16 p16) {
        super(c06, str, str2, r16, p16);
    }
}
