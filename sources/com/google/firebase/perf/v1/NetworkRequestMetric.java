package com.google.firebase.perf.v1;

import com.google.firebase.perf.v1.PerfSession;
import defpackage.q05;
import defpackage.s05;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class NetworkRequestMetric extends q05<NetworkRequestMetric, Builder> implements NetworkRequestMetricOrBuilder {
    public static final int CLIENT_START_TIME_US_FIELD_NUMBER = 7;
    public static final int CUSTOM_ATTRIBUTES_FIELD_NUMBER = 12;
    private static final NetworkRequestMetric DEFAULT_INSTANCE;
    public static final int HTTP_METHOD_FIELD_NUMBER = 2;
    public static final int HTTP_RESPONSE_CODE_FIELD_NUMBER = 5;
    public static final int NETWORK_CLIENT_ERROR_REASON_FIELD_NUMBER = 11;
    private static volatile q15<NetworkRequestMetric> PARSER = null;
    public static final int PERF_SESSIONS_FIELD_NUMBER = 13;
    public static final int REQUEST_PAYLOAD_BYTES_FIELD_NUMBER = 3;
    public static final int RESPONSE_CONTENT_TYPE_FIELD_NUMBER = 6;
    public static final int RESPONSE_PAYLOAD_BYTES_FIELD_NUMBER = 4;
    public static final int TIME_TO_REQUEST_COMPLETED_US_FIELD_NUMBER = 8;
    public static final int TIME_TO_RESPONSE_COMPLETED_US_FIELD_NUMBER = 10;
    public static final int TIME_TO_RESPONSE_INITIATED_US_FIELD_NUMBER = 9;
    public static final int URL_FIELD_NUMBER = 1;
    private int bitField0_;
    private long clientStartTimeUs_;
    private d15<String, String> customAttributes_ = d15.g;
    private int httpMethod_;
    private int httpResponseCode_;
    private int networkClientErrorReason_;
    private s05.j<PerfSession> perfSessions_ = q05.emptyProtobufList();
    private long requestPayloadBytes_;
    private String responseContentType_ = "";
    private long responsePayloadBytes_;
    private long timeToRequestCompletedUs_;
    private long timeToResponseCompletedUs_;
    private long timeToResponseInitiatedUs_;
    private String url_ = "";

    /* renamed from: com.google.firebase.perf.v1.NetworkRequestMetric$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        /* JADX WARNING: Can't wrap try/catch for region: R(15:0|(2:1|2)|3|5|6|7|8|9|(2:11|12)|13|15|16|17|18|(3:19|20|22)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|(2:1|2)|3|5|6|7|8|9|11|12|13|15|16|17|18|(3:19|20|22)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0031 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0016 */
        static {
            /*
                defpackage.q05.f.values()
                r0 = 7
                int[] r1 = new int[r0]
                com.google.firebase.perf.v1.NetworkRequestMetric.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = r1
                r2 = 1
                r3 = 3
                q05$f r4 = defpackage.q05.f.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x000e }
                r1[r3] = r2     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                r1 = 2
                r4 = 4
                int[] r5 = com.google.firebase.perf.v1.NetworkRequestMetric.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0016 }
                q05$f r6 = defpackage.q05.f.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x0016 }
                r5[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                int[] r5 = com.google.firebase.perf.v1.NetworkRequestMetric.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x001c }
                q05$f r6 = defpackage.q05.f.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x001c }
                r5[r1] = r3     // Catch:{ NoSuchFieldError -> 0x001c }
            L_0x001c:
                r1 = 5
                int[] r3 = com.google.firebase.perf.v1.NetworkRequestMetric.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0023 }
                q05$f r5 = defpackage.q05.f.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0023 }
                r3[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0023 }
            L_0x0023:
                r3 = 6
                int[] r4 = com.google.firebase.perf.v1.NetworkRequestMetric.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x002a }
                q05$f r5 = defpackage.q05.f.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x002a }
                r4[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r1 = com.google.firebase.perf.v1.NetworkRequestMetric.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0031 }
                q05$f r4 = defpackage.q05.f.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0031 }
                r4 = 0
                r1[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0031 }
            L_0x0031:
                int[] r1 = com.google.firebase.perf.v1.NetworkRequestMetric.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0037 }
                q05$f r3 = defpackage.q05.f.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0037 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0037 }
            L_0x0037:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.v1.NetworkRequestMetric.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class Builder extends q05.a<NetworkRequestMetric, Builder> implements NetworkRequestMetricOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        public Builder addAllPerfSessions(Iterable<? extends PerfSession> iterable) {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).addAllPerfSessions(iterable);
            return this;
        }

        public Builder addPerfSessions(PerfSession perfSession) {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).addPerfSessions(perfSession);
            return this;
        }

        public Builder clearClientStartTimeUs() {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).clearClientStartTimeUs();
            return this;
        }

        public Builder clearCustomAttributes() {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).getMutableCustomAttributesMap().clear();
            return this;
        }

        public Builder clearHttpMethod() {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).clearHttpMethod();
            return this;
        }

        public Builder clearHttpResponseCode() {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).clearHttpResponseCode();
            return this;
        }

        public Builder clearNetworkClientErrorReason() {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).clearNetworkClientErrorReason();
            return this;
        }

        public Builder clearPerfSessions() {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).clearPerfSessions();
            return this;
        }

        public Builder clearRequestPayloadBytes() {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).clearRequestPayloadBytes();
            return this;
        }

        public Builder clearResponseContentType() {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).clearResponseContentType();
            return this;
        }

        public Builder clearResponsePayloadBytes() {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).clearResponsePayloadBytes();
            return this;
        }

        public Builder clearTimeToRequestCompletedUs() {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).clearTimeToRequestCompletedUs();
            return this;
        }

        public Builder clearTimeToResponseCompletedUs() {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).clearTimeToResponseCompletedUs();
            return this;
        }

        public Builder clearTimeToResponseInitiatedUs() {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).clearTimeToResponseInitiatedUs();
            return this;
        }

        public Builder clearUrl() {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).clearUrl();
            return this;
        }

        @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
        public boolean containsCustomAttributes(String str) {
            str.getClass();
            return ((NetworkRequestMetric) this.instance).getCustomAttributesMap().containsKey(str);
        }

        @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
        public long getClientStartTimeUs() {
            return ((NetworkRequestMetric) this.instance).getClientStartTimeUs();
        }

        @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
        @Deprecated
        public Map<String, String> getCustomAttributes() {
            return getCustomAttributesMap();
        }

        @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
        public int getCustomAttributesCount() {
            return ((NetworkRequestMetric) this.instance).getCustomAttributesMap().size();
        }

        @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
        public Map<String, String> getCustomAttributesMap() {
            return Collections.unmodifiableMap(((NetworkRequestMetric) this.instance).getCustomAttributesMap());
        }

        @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
        public String getCustomAttributesOrDefault(String str, String str2) {
            str.getClass();
            Map<String, String> customAttributesMap = ((NetworkRequestMetric) this.instance).getCustomAttributesMap();
            return customAttributesMap.containsKey(str) ? customAttributesMap.get(str) : str2;
        }

        @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
        public String getCustomAttributesOrThrow(String str) {
            str.getClass();
            Map<String, String> customAttributesMap = ((NetworkRequestMetric) this.instance).getCustomAttributesMap();
            if (customAttributesMap.containsKey(str)) {
                return customAttributesMap.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
        public HttpMethod getHttpMethod() {
            return ((NetworkRequestMetric) this.instance).getHttpMethod();
        }

        @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
        public int getHttpResponseCode() {
            return ((NetworkRequestMetric) this.instance).getHttpResponseCode();
        }

        @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
        public NetworkClientErrorReason getNetworkClientErrorReason() {
            return ((NetworkRequestMetric) this.instance).getNetworkClientErrorReason();
        }

        @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
        public PerfSession getPerfSessions(int i) {
            return ((NetworkRequestMetric) this.instance).getPerfSessions(i);
        }

        @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
        public int getPerfSessionsCount() {
            return ((NetworkRequestMetric) this.instance).getPerfSessionsCount();
        }

        @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
        public List<PerfSession> getPerfSessionsList() {
            return Collections.unmodifiableList(((NetworkRequestMetric) this.instance).getPerfSessionsList());
        }

        @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
        public long getRequestPayloadBytes() {
            return ((NetworkRequestMetric) this.instance).getRequestPayloadBytes();
        }

        @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
        public String getResponseContentType() {
            return ((NetworkRequestMetric) this.instance).getResponseContentType();
        }

        @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
        public a05 getResponseContentTypeBytes() {
            return ((NetworkRequestMetric) this.instance).getResponseContentTypeBytes();
        }

        @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
        public long getResponsePayloadBytes() {
            return ((NetworkRequestMetric) this.instance).getResponsePayloadBytes();
        }

        @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
        public long getTimeToRequestCompletedUs() {
            return ((NetworkRequestMetric) this.instance).getTimeToRequestCompletedUs();
        }

        @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
        public long getTimeToResponseCompletedUs() {
            return ((NetworkRequestMetric) this.instance).getTimeToResponseCompletedUs();
        }

        @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
        public long getTimeToResponseInitiatedUs() {
            return ((NetworkRequestMetric) this.instance).getTimeToResponseInitiatedUs();
        }

        @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
        public String getUrl() {
            return ((NetworkRequestMetric) this.instance).getUrl();
        }

        @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
        public a05 getUrlBytes() {
            return ((NetworkRequestMetric) this.instance).getUrlBytes();
        }

        @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
        public boolean hasClientStartTimeUs() {
            return ((NetworkRequestMetric) this.instance).hasClientStartTimeUs();
        }

        @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
        public boolean hasHttpMethod() {
            return ((NetworkRequestMetric) this.instance).hasHttpMethod();
        }

        @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
        public boolean hasHttpResponseCode() {
            return ((NetworkRequestMetric) this.instance).hasHttpResponseCode();
        }

        @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
        public boolean hasNetworkClientErrorReason() {
            return ((NetworkRequestMetric) this.instance).hasNetworkClientErrorReason();
        }

        @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
        public boolean hasRequestPayloadBytes() {
            return ((NetworkRequestMetric) this.instance).hasRequestPayloadBytes();
        }

        @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
        public boolean hasResponseContentType() {
            return ((NetworkRequestMetric) this.instance).hasResponseContentType();
        }

        @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
        public boolean hasResponsePayloadBytes() {
            return ((NetworkRequestMetric) this.instance).hasResponsePayloadBytes();
        }

        @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
        public boolean hasTimeToRequestCompletedUs() {
            return ((NetworkRequestMetric) this.instance).hasTimeToRequestCompletedUs();
        }

        @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
        public boolean hasTimeToResponseCompletedUs() {
            return ((NetworkRequestMetric) this.instance).hasTimeToResponseCompletedUs();
        }

        @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
        public boolean hasTimeToResponseInitiatedUs() {
            return ((NetworkRequestMetric) this.instance).hasTimeToResponseInitiatedUs();
        }

        @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
        public boolean hasUrl() {
            return ((NetworkRequestMetric) this.instance).hasUrl();
        }

        public Builder putAllCustomAttributes(Map<String, String> map) {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).getMutableCustomAttributesMap().putAll(map);
            return this;
        }

        public Builder putCustomAttributes(String str, String str2) {
            str.getClass();
            str2.getClass();
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).getMutableCustomAttributesMap().put(str, str2);
            return this;
        }

        public Builder removeCustomAttributes(String str) {
            str.getClass();
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).getMutableCustomAttributesMap().remove(str);
            return this;
        }

        public Builder removePerfSessions(int i) {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).removePerfSessions(i);
            return this;
        }

        public Builder setClientStartTimeUs(long j) {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).setClientStartTimeUs(j);
            return this;
        }

        public Builder setHttpMethod(HttpMethod httpMethod) {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).setHttpMethod(httpMethod);
            return this;
        }

        public Builder setHttpResponseCode(int i) {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).setHttpResponseCode(i);
            return this;
        }

        public Builder setNetworkClientErrorReason(NetworkClientErrorReason networkClientErrorReason) {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).setNetworkClientErrorReason(networkClientErrorReason);
            return this;
        }

        public Builder setPerfSessions(int i, PerfSession perfSession) {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).setPerfSessions(i, perfSession);
            return this;
        }

        public Builder setRequestPayloadBytes(long j) {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).setRequestPayloadBytes(j);
            return this;
        }

        public Builder setResponseContentType(String str) {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).setResponseContentType(str);
            return this;
        }

        public Builder setResponseContentTypeBytes(a05 a05) {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).setResponseContentTypeBytes(a05);
            return this;
        }

        public Builder setResponsePayloadBytes(long j) {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).setResponsePayloadBytes(j);
            return this;
        }

        public Builder setTimeToRequestCompletedUs(long j) {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).setTimeToRequestCompletedUs(j);
            return this;
        }

        public Builder setTimeToResponseCompletedUs(long j) {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).setTimeToResponseCompletedUs(j);
            return this;
        }

        public Builder setTimeToResponseInitiatedUs(long j) {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).setTimeToResponseInitiatedUs(j);
            return this;
        }

        public Builder setUrl(String str) {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).setUrl(str);
            return this;
        }

        public Builder setUrlBytes(a05 a05) {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).setUrlBytes(a05);
            return this;
        }

        private Builder() {
            super(NetworkRequestMetric.DEFAULT_INSTANCE);
        }

        public Builder addPerfSessions(int i, PerfSession perfSession) {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).addPerfSessions(i, perfSession);
            return this;
        }

        public Builder setPerfSessions(int i, PerfSession.Builder builder) {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).setPerfSessions(i, (PerfSession) builder.build());
            return this;
        }

        public Builder addPerfSessions(PerfSession.Builder builder) {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).addPerfSessions((PerfSession) builder.build());
            return this;
        }

        public Builder addPerfSessions(int i, PerfSession.Builder builder) {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).addPerfSessions(i, (PerfSession) builder.build());
            return this;
        }
    }

    public static final class CustomAttributesDefaultEntryHolder {
        public static final c15<String, String> defaultEntry;

        static {
            l25 l25 = l25.STRING;
            defaultEntry = new c15<>(l25, "", l25, "");
        }

        private CustomAttributesDefaultEntryHolder() {
        }
    }

    public enum HttpMethod implements s05.c {
        HTTP_METHOD_UNKNOWN(0),
        GET(1),
        PUT(2),
        POST(3),
        DELETE(4),
        HEAD(5),
        PATCH(6),
        OPTIONS(7),
        TRACE(8),
        CONNECT(9);
        
        public static final int CONNECT_VALUE = 9;
        public static final int DELETE_VALUE = 4;
        public static final int GET_VALUE = 1;
        public static final int HEAD_VALUE = 5;
        public static final int HTTP_METHOD_UNKNOWN_VALUE = 0;
        public static final int OPTIONS_VALUE = 7;
        public static final int PATCH_VALUE = 6;
        public static final int POST_VALUE = 3;
        public static final int PUT_VALUE = 2;
        public static final int TRACE_VALUE = 8;
        private static final s05.d<HttpMethod> internalValueMap = new s05.d<HttpMethod>() {
            /* class com.google.firebase.perf.v1.NetworkRequestMetric.HttpMethod.AnonymousClass1 */

            @Override // defpackage.s05.d
            public HttpMethod findValueByNumber(int i) {
                return HttpMethod.forNumber(i);
            }
        };
        private final int value;

        public static final class HttpMethodVerifier implements s05.e {
            public static final s05.e INSTANCE = new HttpMethodVerifier();

            private HttpMethodVerifier() {
            }

            @Override // defpackage.s05.e
            public boolean isInRange(int i) {
                return HttpMethod.forNumber(i) != null;
            }
        }

        private HttpMethod(int i) {
            this.value = i;
        }

        public static HttpMethod forNumber(int i) {
            switch (i) {
                case 0:
                    return HTTP_METHOD_UNKNOWN;
                case 1:
                    return GET;
                case 2:
                    return PUT;
                case 3:
                    return POST;
                case 4:
                    return DELETE;
                case 5:
                    return HEAD;
                case 6:
                    return PATCH;
                case 7:
                    return OPTIONS;
                case 8:
                    return TRACE;
                case 9:
                    return CONNECT;
                default:
                    return null;
            }
        }

        public static s05.d<HttpMethod> internalGetValueMap() {
            return internalValueMap;
        }

        public static s05.e internalGetVerifier() {
            return HttpMethodVerifier.INSTANCE;
        }

        @Override // defpackage.s05.c
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static HttpMethod valueOf(int i) {
            return forNumber(i);
        }
    }

    public enum NetworkClientErrorReason implements s05.c {
        NETWORK_CLIENT_ERROR_REASON_UNKNOWN(0),
        GENERIC_CLIENT_ERROR(1);
        
        public static final int GENERIC_CLIENT_ERROR_VALUE = 1;
        public static final int NETWORK_CLIENT_ERROR_REASON_UNKNOWN_VALUE = 0;
        private static final s05.d<NetworkClientErrorReason> internalValueMap = new s05.d<NetworkClientErrorReason>() {
            /* class com.google.firebase.perf.v1.NetworkRequestMetric.NetworkClientErrorReason.AnonymousClass1 */

            @Override // defpackage.s05.d
            public NetworkClientErrorReason findValueByNumber(int i) {
                return NetworkClientErrorReason.forNumber(i);
            }
        };
        private final int value;

        public static final class NetworkClientErrorReasonVerifier implements s05.e {
            public static final s05.e INSTANCE = new NetworkClientErrorReasonVerifier();

            private NetworkClientErrorReasonVerifier() {
            }

            @Override // defpackage.s05.e
            public boolean isInRange(int i) {
                return NetworkClientErrorReason.forNumber(i) != null;
            }
        }

        private NetworkClientErrorReason(int i) {
            this.value = i;
        }

        public static NetworkClientErrorReason forNumber(int i) {
            if (i == 0) {
                return NETWORK_CLIENT_ERROR_REASON_UNKNOWN;
            }
            if (i != 1) {
                return null;
            }
            return GENERIC_CLIENT_ERROR;
        }

        public static s05.d<NetworkClientErrorReason> internalGetValueMap() {
            return internalValueMap;
        }

        public static s05.e internalGetVerifier() {
            return NetworkClientErrorReasonVerifier.INSTANCE;
        }

        @Override // defpackage.s05.c
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static NetworkClientErrorReason valueOf(int i) {
            return forNumber(i);
        }
    }

    static {
        NetworkRequestMetric networkRequestMetric = new NetworkRequestMetric();
        DEFAULT_INSTANCE = networkRequestMetric;
        q05.registerDefaultInstance(NetworkRequestMetric.class, networkRequestMetric);
    }

    private NetworkRequestMetric() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addAllPerfSessions(Iterable<? extends PerfSession> iterable) {
        ensurePerfSessionsIsMutable();
        rz4.addAll((Iterable) iterable, (List) this.perfSessions_);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addPerfSessions(PerfSession perfSession) {
        perfSession.getClass();
        ensurePerfSessionsIsMutable();
        this.perfSessions_.add(perfSession);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearClientStartTimeUs() {
        this.bitField0_ &= -129;
        this.clientStartTimeUs_ = 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearHttpMethod() {
        this.bitField0_ &= -3;
        this.httpMethod_ = 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearHttpResponseCode() {
        this.bitField0_ &= -33;
        this.httpResponseCode_ = 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearNetworkClientErrorReason() {
        this.bitField0_ &= -17;
        this.networkClientErrorReason_ = 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearPerfSessions() {
        this.perfSessions_ = q05.emptyProtobufList();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearRequestPayloadBytes() {
        this.bitField0_ &= -5;
        this.requestPayloadBytes_ = 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearResponseContentType() {
        this.bitField0_ &= -65;
        this.responseContentType_ = getDefaultInstance().getResponseContentType();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearResponsePayloadBytes() {
        this.bitField0_ &= -9;
        this.responsePayloadBytes_ = 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearTimeToRequestCompletedUs() {
        this.bitField0_ &= -257;
        this.timeToRequestCompletedUs_ = 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearTimeToResponseCompletedUs() {
        this.bitField0_ &= -1025;
        this.timeToResponseCompletedUs_ = 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearTimeToResponseInitiatedUs() {
        this.bitField0_ &= -513;
        this.timeToResponseInitiatedUs_ = 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearUrl() {
        this.bitField0_ &= -2;
        this.url_ = getDefaultInstance().getUrl();
    }

    private void ensurePerfSessionsIsMutable() {
        if (!this.perfSessions_.t()) {
            this.perfSessions_ = q05.mutableCopy(this.perfSessions_);
        }
    }

    public static NetworkRequestMetric getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Map<String, String> getMutableCustomAttributesMap() {
        return internalGetMutableCustomAttributes();
    }

    private d15<String, String> internalGetCustomAttributes() {
        return this.customAttributes_;
    }

    private d15<String, String> internalGetMutableCustomAttributes() {
        d15<String, String> d15 = this.customAttributes_;
        if (!d15.f) {
            this.customAttributes_ = d15.c();
        }
        return this.customAttributes_;
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static NetworkRequestMetric parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (NetworkRequestMetric) q05.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NetworkRequestMetric parseFrom(ByteBuffer byteBuffer) throws t05 {
        return (NetworkRequestMetric) q05.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static q15<NetworkRequestMetric> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void removePerfSessions(int i) {
        ensurePerfSessionsIsMutable();
        this.perfSessions_.remove(i);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setClientStartTimeUs(long j) {
        this.bitField0_ |= 128;
        this.clientStartTimeUs_ = j;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setHttpMethod(HttpMethod httpMethod) {
        this.httpMethod_ = httpMethod.getNumber();
        this.bitField0_ |= 2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setHttpResponseCode(int i) {
        this.bitField0_ |= 32;
        this.httpResponseCode_ = i;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setNetworkClientErrorReason(NetworkClientErrorReason networkClientErrorReason) {
        this.networkClientErrorReason_ = networkClientErrorReason.getNumber();
        this.bitField0_ |= 16;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setPerfSessions(int i, PerfSession perfSession) {
        perfSession.getClass();
        ensurePerfSessionsIsMutable();
        this.perfSessions_.set(i, perfSession);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setRequestPayloadBytes(long j) {
        this.bitField0_ |= 4;
        this.requestPayloadBytes_ = j;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setResponseContentType(String str) {
        str.getClass();
        this.bitField0_ |= 64;
        this.responseContentType_ = str;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setResponseContentTypeBytes(a05 a05) {
        this.responseContentType_ = a05.B();
        this.bitField0_ |= 64;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setResponsePayloadBytes(long j) {
        this.bitField0_ |= 8;
        this.responsePayloadBytes_ = j;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setTimeToRequestCompletedUs(long j) {
        this.bitField0_ |= 256;
        this.timeToRequestCompletedUs_ = j;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setTimeToResponseCompletedUs(long j) {
        this.bitField0_ |= 1024;
        this.timeToResponseCompletedUs_ = j;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setTimeToResponseInitiatedUs(long j) {
        this.bitField0_ |= 512;
        this.timeToResponseInitiatedUs_ = j;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setUrl(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.url_ = str;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setUrlBytes(a05 a05) {
        this.url_ = a05.B();
        this.bitField0_ |= 1;
    }

    @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
    public boolean containsCustomAttributes(String str) {
        str.getClass();
        return internalGetCustomAttributes().containsKey(str);
    }

    @Override // defpackage.q05
    public final Object dynamicMethod(q05.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return q05.newMessageInfo(DEFAULT_INSTANCE, "\u0001\r\u0000\u0001\u0001\r\r\u0001\u0001\u0000\u0001\b\u0000\u0002\f\u0001\u0003\u0002\u0002\u0004\u0002\u0003\u0005\u0004\u0005\u0006\b\u0006\u0007\u0002\u0007\b\u0002\b\t\u0002\t\n\u0002\n\u000b\f\u0004\f2\r\u001b", new Object[]{"bitField0_", "url_", "httpMethod_", HttpMethod.internalGetVerifier(), "requestPayloadBytes_", "responsePayloadBytes_", "httpResponseCode_", "responseContentType_", "clientStartTimeUs_", "timeToRequestCompletedUs_", "timeToResponseInitiatedUs_", "timeToResponseCompletedUs_", "networkClientErrorReason_", NetworkClientErrorReason.internalGetVerifier(), "customAttributes_", CustomAttributesDefaultEntryHolder.defaultEntry, "perfSessions_", PerfSession.class});
            case 3:
                return new NetworkRequestMetric();
            case 4:
                return new Builder(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                q15<NetworkRequestMetric> q15 = PARSER;
                if (q15 == null) {
                    synchronized (NetworkRequestMetric.class) {
                        q15 = PARSER;
                        if (q15 == null) {
                            q15 = new q05.b<>(DEFAULT_INSTANCE);
                            PARSER = q15;
                        }
                    }
                }
                return q15;
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
    public long getClientStartTimeUs() {
        return this.clientStartTimeUs_;
    }

    @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
    @Deprecated
    public Map<String, String> getCustomAttributes() {
        return getCustomAttributesMap();
    }

    @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
    public int getCustomAttributesCount() {
        return internalGetCustomAttributes().size();
    }

    @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
    public Map<String, String> getCustomAttributesMap() {
        return Collections.unmodifiableMap(internalGetCustomAttributes());
    }

    @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
    public String getCustomAttributesOrDefault(String str, String str2) {
        str.getClass();
        d15<String, String> internalGetCustomAttributes = internalGetCustomAttributes();
        return internalGetCustomAttributes.containsKey(str) ? internalGetCustomAttributes.get(str) : str2;
    }

    @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
    public String getCustomAttributesOrThrow(String str) {
        str.getClass();
        d15<String, String> internalGetCustomAttributes = internalGetCustomAttributes();
        if (internalGetCustomAttributes.containsKey(str)) {
            return internalGetCustomAttributes.get(str);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
    public HttpMethod getHttpMethod() {
        HttpMethod forNumber = HttpMethod.forNumber(this.httpMethod_);
        return forNumber == null ? HttpMethod.HTTP_METHOD_UNKNOWN : forNumber;
    }

    @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
    public int getHttpResponseCode() {
        return this.httpResponseCode_;
    }

    @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
    public NetworkClientErrorReason getNetworkClientErrorReason() {
        NetworkClientErrorReason forNumber = NetworkClientErrorReason.forNumber(this.networkClientErrorReason_);
        return forNumber == null ? NetworkClientErrorReason.NETWORK_CLIENT_ERROR_REASON_UNKNOWN : forNumber;
    }

    @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
    public PerfSession getPerfSessions(int i) {
        return this.perfSessions_.get(i);
    }

    @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
    public int getPerfSessionsCount() {
        return this.perfSessions_.size();
    }

    @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
    public List<PerfSession> getPerfSessionsList() {
        return this.perfSessions_;
    }

    public PerfSessionOrBuilder getPerfSessionsOrBuilder(int i) {
        return this.perfSessions_.get(i);
    }

    public List<? extends PerfSessionOrBuilder> getPerfSessionsOrBuilderList() {
        return this.perfSessions_;
    }

    @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
    public long getRequestPayloadBytes() {
        return this.requestPayloadBytes_;
    }

    @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
    public String getResponseContentType() {
        return this.responseContentType_;
    }

    @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
    public a05 getResponseContentTypeBytes() {
        return a05.k(this.responseContentType_);
    }

    @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
    public long getResponsePayloadBytes() {
        return this.responsePayloadBytes_;
    }

    @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
    public long getTimeToRequestCompletedUs() {
        return this.timeToRequestCompletedUs_;
    }

    @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
    public long getTimeToResponseCompletedUs() {
        return this.timeToResponseCompletedUs_;
    }

    @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
    public long getTimeToResponseInitiatedUs() {
        return this.timeToResponseInitiatedUs_;
    }

    @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
    public String getUrl() {
        return this.url_;
    }

    @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
    public a05 getUrlBytes() {
        return a05.k(this.url_);
    }

    @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
    public boolean hasClientStartTimeUs() {
        return (this.bitField0_ & 128) != 0;
    }

    @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
    public boolean hasHttpMethod() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
    public boolean hasHttpResponseCode() {
        return (this.bitField0_ & 32) != 0;
    }

    @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
    public boolean hasNetworkClientErrorReason() {
        return (this.bitField0_ & 16) != 0;
    }

    @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
    public boolean hasRequestPayloadBytes() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
    public boolean hasResponseContentType() {
        return (this.bitField0_ & 64) != 0;
    }

    @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
    public boolean hasResponsePayloadBytes() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
    public boolean hasTimeToRequestCompletedUs() {
        return (this.bitField0_ & 256) != 0;
    }

    @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
    public boolean hasTimeToResponseCompletedUs() {
        return (this.bitField0_ & 1024) != 0;
    }

    @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
    public boolean hasTimeToResponseInitiatedUs() {
        return (this.bitField0_ & 512) != 0;
    }

    @Override // com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder
    public boolean hasUrl() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(NetworkRequestMetric networkRequestMetric) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(networkRequestMetric);
    }

    public static NetworkRequestMetric parseDelimitedFrom(InputStream inputStream, i05 i05) throws IOException {
        return (NetworkRequestMetric) q05.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, i05);
    }

    public static NetworkRequestMetric parseFrom(ByteBuffer byteBuffer, i05 i05) throws t05 {
        return (NetworkRequestMetric) q05.parseFrom(DEFAULT_INSTANCE, byteBuffer, i05);
    }

    public static NetworkRequestMetric parseFrom(a05 a05) throws t05 {
        return (NetworkRequestMetric) q05.parseFrom(DEFAULT_INSTANCE, a05);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addPerfSessions(int i, PerfSession perfSession) {
        perfSession.getClass();
        ensurePerfSessionsIsMutable();
        this.perfSessions_.add(i, perfSession);
    }

    public static NetworkRequestMetric parseFrom(a05 a05, i05 i05) throws t05 {
        return (NetworkRequestMetric) q05.parseFrom(DEFAULT_INSTANCE, a05, i05);
    }

    public static NetworkRequestMetric parseFrom(byte[] bArr) throws t05 {
        return (NetworkRequestMetric) q05.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static NetworkRequestMetric parseFrom(byte[] bArr, i05 i05) throws t05 {
        return (NetworkRequestMetric) q05.parseFrom(DEFAULT_INSTANCE, bArr, i05);
    }

    public static NetworkRequestMetric parseFrom(InputStream inputStream) throws IOException {
        return (NetworkRequestMetric) q05.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NetworkRequestMetric parseFrom(InputStream inputStream, i05 i05) throws IOException {
        return (NetworkRequestMetric) q05.parseFrom(DEFAULT_INSTANCE, inputStream, i05);
    }

    public static NetworkRequestMetric parseFrom(b05 b05) throws IOException {
        return (NetworkRequestMetric) q05.parseFrom(DEFAULT_INSTANCE, b05);
    }

    public static NetworkRequestMetric parseFrom(b05 b05, i05 i05) throws IOException {
        return (NetworkRequestMetric) q05.parseFrom(DEFAULT_INSTANCE, b05, i05);
    }
}
