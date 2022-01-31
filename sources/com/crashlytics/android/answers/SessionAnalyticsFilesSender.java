package com.crashlytics.android.answers;

import java.io.File;
import java.util.List;

public class SessionAnalyticsFilesSender extends g06 implements l16 {
    public static final String FILE_CONTENT_TYPE = "application/vnd.crashlytics.android.events";
    public static final String FILE_PARAM_NAME = "session_analytics_file_";
    private final String apiKey;

    public SessionAnalyticsFilesSender(c06 c06, String str, String str2, r16 r16, String str3) {
        super(c06, str, str2, r16, p16.POST);
        this.apiKey = str3;
    }

    @Override // defpackage.l16
    public boolean send(List<File> list) {
        q16 httpRequest = getHttpRequest();
        httpRequest.h().setRequestProperty("X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        httpRequest.h().setRequestProperty("X-CRASHLYTICS-API-CLIENT-VERSION", this.kit.getVersion());
        httpRequest.h().setRequestProperty(g06.HEADER_API_KEY, this.apiKey);
        int i = 0;
        for (File file : list) {
            httpRequest.m(hj1.I(FILE_PARAM_NAME, i), file.getName(), FILE_CONTENT_TYPE, file);
            i++;
        }
        list.size();
        getUrl();
        if (hd3.p2(httpRequest.e()) == 0) {
            return true;
        }
        return false;
    }
}
