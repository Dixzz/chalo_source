package com.google.firebase.crashlytics.internal.report.network;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import com.google.firebase.crashlytics.internal.common.ResponseParser;
import com.google.firebase.crashlytics.internal.network.HttpMethod;
import com.google.firebase.crashlytics.internal.network.HttpRequest;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.network.HttpResponse;
import com.google.firebase.crashlytics.internal.report.model.CreateReportRequest;
import com.google.firebase.crashlytics.internal.report.model.Report;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class DefaultCreateReportSpiCall extends AbstractSpiCall implements CreateReportSpiCall {
    public static final String FILE_CONTENT_TYPE = "application/octet-stream";
    public static final String FILE_PARAM = "report[file]";
    public static final String IDENTIFIER_PARAM = "report[identifier]";
    public static final String MULTI_FILE_PARAM = "report[file";
    private final String version;

    public DefaultCreateReportSpiCall(String str, String str2, HttpRequestFactory httpRequestFactory, String str3) {
        this(str, str2, httpRequestFactory, HttpMethod.POST, str3);
    }

    private HttpRequest applyHeadersTo(HttpRequest httpRequest, CreateReportRequest createReportRequest) {
        HttpRequest header = httpRequest.header(AbstractSpiCall.HEADER_GOOGLE_APP_ID, createReportRequest.googleAppId).header("X-CRASHLYTICS-API-CLIENT-TYPE", "android").header("X-CRASHLYTICS-API-CLIENT-VERSION", this.version);
        for (Map.Entry<String, String> entry : createReportRequest.report.getCustomHeaders().entrySet()) {
            header = header.header(entry);
        }
        return header;
    }

    private HttpRequest applyMultipartDataTo(HttpRequest httpRequest, Report report) {
        HttpRequest part = httpRequest.part("report[identifier]", report.getIdentifier());
        if (report.getFiles().length == 1) {
            Logger logger = Logger.getLogger();
            StringBuilder i0 = hj1.i0("Adding single file ");
            i0.append(report.getFileName());
            i0.append(" to report ");
            i0.append(report.getIdentifier());
            logger.d(i0.toString());
            return part.part("report[file]", report.getFileName(), "application/octet-stream", report.getFile());
        }
        File[] files = report.getFiles();
        int i = 0;
        for (File file : files) {
            Logger logger2 = Logger.getLogger();
            StringBuilder i02 = hj1.i0("Adding file ");
            i02.append(file.getName());
            i02.append(" to report ");
            i02.append(report.getIdentifier());
            logger2.d(i02.toString());
            part = part.part("report[file" + i + "]", file.getName(), "application/octet-stream", file);
            i++;
        }
        return part;
    }

    @Override // com.google.firebase.crashlytics.internal.report.network.CreateReportSpiCall
    public boolean invoke(CreateReportRequest createReportRequest, boolean z) {
        if (z) {
            HttpRequest applyMultipartDataTo = applyMultipartDataTo(applyHeadersTo(getHttpRequest(), createReportRequest), createReportRequest.report);
            Logger logger = Logger.getLogger();
            StringBuilder i0 = hj1.i0("Sending report to: ");
            i0.append(getUrl());
            logger.d(i0.toString());
            try {
                HttpResponse execute = applyMultipartDataTo.execute();
                int code = execute.code();
                Logger logger2 = Logger.getLogger();
                logger2.d("Create report request ID: " + execute.header("X-REQUEST-ID"));
                Logger logger3 = Logger.getLogger();
                logger3.d("Result was: " + code);
                return ResponseParser.parse(code) == 0;
            } catch (IOException e) {
                Logger.getLogger().e("Create report HTTP request failed.", e);
                throw new RuntimeException(e);
            }
        } else {
            throw new RuntimeException("An invalid data collection token was used.");
        }
    }

    public DefaultCreateReportSpiCall(String str, String str2, HttpRequestFactory httpRequestFactory, HttpMethod httpMethod, String str3) {
        super(str, str2, httpRequestFactory, httpMethod);
        this.version = str3;
    }
}
