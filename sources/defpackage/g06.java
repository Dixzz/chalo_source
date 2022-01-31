package defpackage;

import java.util.Collections;
import java.util.Map;
import java.util.regex.Pattern;

/* renamed from: g06  reason: default package */
/* compiled from: AbstractSpiCall */
public abstract class g06 {
    public static final String ACCEPT_JSON_VALUE = "application/json";
    public static final String ANDROID_CLIENT_TYPE = "android";
    public static final String CLS_ANDROID_SDK_DEVELOPER_TOKEN = "470fa2b4ae81cd56ecbcda9735803434cec591fa";
    public static final String CRASHLYTICS_USER_AGENT = "Crashlytics Android SDK/";
    public static final int DEFAULT_TIMEOUT = 10000;
    public static final String HEADER_ACCEPT = "Accept";
    public static final String HEADER_API_KEY = "X-CRASHLYTICS-API-KEY";
    public static final String HEADER_CLIENT_TYPE = "X-CRASHLYTICS-API-CLIENT-TYPE";
    public static final String HEADER_CLIENT_VERSION = "X-CRASHLYTICS-API-CLIENT-VERSION";
    public static final String HEADER_DEVELOPER_TOKEN = "X-CRASHLYTICS-DEVELOPER-TOKEN";
    public static final String HEADER_REQUEST_ID = "X-REQUEST-ID";
    public static final String HEADER_USER_AGENT = "User-Agent";
    private static final Pattern PROTOCOL_AND_HOST_PATTERN = Pattern.compile("http(s?)://[^\\/]+", 2);
    public final c06 kit;
    private final p16 method;
    private final String protocolAndHostOverride;
    private final r16 requestFactory;
    private final String url;

    public g06(c06 c06, String str, String str2, r16 r16, p16 p16) {
        if (str2 == null) {
            throw new IllegalArgumentException("url must not be null.");
        } else if (r16 != null) {
            this.kit = c06;
            this.protocolAndHostOverride = str;
            this.url = overrideProtocolAndHost(str2);
            this.requestFactory = r16;
            this.method = p16;
        } else {
            throw new IllegalArgumentException("requestFactory must not be null.");
        }
    }

    private String overrideProtocolAndHost(String str) {
        String str2 = this.protocolAndHostOverride;
        return !(str2 == null || str2.length() == 0) ? PROTOCOL_AND_HOST_PATTERN.matcher(str).replaceFirst(this.protocolAndHostOverride) : str;
    }

    public q16 getHttpRequest() {
        return getHttpRequest(Collections.emptyMap());
    }

    public String getUrl() {
        return this.url;
    }

    public q16 getHttpRequest(Map<String, String> map) {
        q16 a2 = ((o16) this.requestFactory).a(this.method, getUrl(), map);
        a2.h().setUseCaches(false);
        a2.h().setConnectTimeout(10000);
        a2.h().setRequestProperty("User-Agent", "Crashlytics Android SDK/" + this.kit.getVersion());
        a2.h().setRequestProperty("X-CRASHLYTICS-DEVELOPER-TOKEN", CLS_ANDROID_SDK_DEVELOPER_TOKEN);
        return a2;
    }
}
