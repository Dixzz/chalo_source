package com.google.firebase.perf.v1;

import defpackage.q05;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class WebApplicationInfo extends q05<WebApplicationInfo, Builder> implements WebApplicationInfoOrBuilder {
    private static final WebApplicationInfo DEFAULT_INSTANCE;
    public static final int EFFECTIVE_CONNECTION_TYPE_FIELD_NUMBER = 5;
    public static final int PAGE_URL_FIELD_NUMBER = 2;
    private static volatile q15<WebApplicationInfo> PARSER = null;
    public static final int SDK_VERSION_FIELD_NUMBER = 1;
    public static final int SERVICE_WORKER_STATUS_FIELD_NUMBER = 3;
    public static final int VISIBILITY_STATE_FIELD_NUMBER = 4;
    private int bitField0_;
    private int effectiveConnectionType_;
    private String pageUrl_ = "";
    private String sdkVersion_ = "";
    private int serviceWorkerStatus_;
    private int visibilityState_;

    /* renamed from: com.google.firebase.perf.v1.WebApplicationInfo$1  reason: invalid class name */
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
                com.google.firebase.perf.v1.WebApplicationInfo.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = r1
                r2 = 1
                r3 = 3
                q05$f r4 = defpackage.q05.f.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x000e }
                r1[r3] = r2     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                r1 = 2
                r4 = 4
                int[] r5 = com.google.firebase.perf.v1.WebApplicationInfo.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0016 }
                q05$f r6 = defpackage.q05.f.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x0016 }
                r5[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                int[] r5 = com.google.firebase.perf.v1.WebApplicationInfo.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x001c }
                q05$f r6 = defpackage.q05.f.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x001c }
                r5[r1] = r3     // Catch:{ NoSuchFieldError -> 0x001c }
            L_0x001c:
                r1 = 5
                int[] r3 = com.google.firebase.perf.v1.WebApplicationInfo.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0023 }
                q05$f r5 = defpackage.q05.f.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0023 }
                r3[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0023 }
            L_0x0023:
                r3 = 6
                int[] r4 = com.google.firebase.perf.v1.WebApplicationInfo.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x002a }
                q05$f r5 = defpackage.q05.f.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x002a }
                r4[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r1 = com.google.firebase.perf.v1.WebApplicationInfo.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0031 }
                q05$f r4 = defpackage.q05.f.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0031 }
                r4 = 0
                r1[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0031 }
            L_0x0031:
                int[] r1 = com.google.firebase.perf.v1.WebApplicationInfo.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0037 }
                q05$f r3 = defpackage.q05.f.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0037 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0037 }
            L_0x0037:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.v1.WebApplicationInfo.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class Builder extends q05.a<WebApplicationInfo, Builder> implements WebApplicationInfoOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        public Builder clearEffectiveConnectionType() {
            copyOnWrite();
            ((WebApplicationInfo) this.instance).clearEffectiveConnectionType();
            return this;
        }

        public Builder clearPageUrl() {
            copyOnWrite();
            ((WebApplicationInfo) this.instance).clearPageUrl();
            return this;
        }

        public Builder clearSdkVersion() {
            copyOnWrite();
            ((WebApplicationInfo) this.instance).clearSdkVersion();
            return this;
        }

        public Builder clearServiceWorkerStatus() {
            copyOnWrite();
            ((WebApplicationInfo) this.instance).clearServiceWorkerStatus();
            return this;
        }

        public Builder clearVisibilityState() {
            copyOnWrite();
            ((WebApplicationInfo) this.instance).clearVisibilityState();
            return this;
        }

        @Override // com.google.firebase.perf.v1.WebApplicationInfoOrBuilder
        public EffectiveConnectionType getEffectiveConnectionType() {
            return ((WebApplicationInfo) this.instance).getEffectiveConnectionType();
        }

        @Override // com.google.firebase.perf.v1.WebApplicationInfoOrBuilder
        public String getPageUrl() {
            return ((WebApplicationInfo) this.instance).getPageUrl();
        }

        @Override // com.google.firebase.perf.v1.WebApplicationInfoOrBuilder
        public a05 getPageUrlBytes() {
            return ((WebApplicationInfo) this.instance).getPageUrlBytes();
        }

        @Override // com.google.firebase.perf.v1.WebApplicationInfoOrBuilder
        public String getSdkVersion() {
            return ((WebApplicationInfo) this.instance).getSdkVersion();
        }

        @Override // com.google.firebase.perf.v1.WebApplicationInfoOrBuilder
        public a05 getSdkVersionBytes() {
            return ((WebApplicationInfo) this.instance).getSdkVersionBytes();
        }

        @Override // com.google.firebase.perf.v1.WebApplicationInfoOrBuilder
        public ServiceWorkerStatus getServiceWorkerStatus() {
            return ((WebApplicationInfo) this.instance).getServiceWorkerStatus();
        }

        @Override // com.google.firebase.perf.v1.WebApplicationInfoOrBuilder
        public VisibilityState getVisibilityState() {
            return ((WebApplicationInfo) this.instance).getVisibilityState();
        }

        @Override // com.google.firebase.perf.v1.WebApplicationInfoOrBuilder
        public boolean hasEffectiveConnectionType() {
            return ((WebApplicationInfo) this.instance).hasEffectiveConnectionType();
        }

        @Override // com.google.firebase.perf.v1.WebApplicationInfoOrBuilder
        public boolean hasPageUrl() {
            return ((WebApplicationInfo) this.instance).hasPageUrl();
        }

        @Override // com.google.firebase.perf.v1.WebApplicationInfoOrBuilder
        public boolean hasSdkVersion() {
            return ((WebApplicationInfo) this.instance).hasSdkVersion();
        }

        @Override // com.google.firebase.perf.v1.WebApplicationInfoOrBuilder
        public boolean hasServiceWorkerStatus() {
            return ((WebApplicationInfo) this.instance).hasServiceWorkerStatus();
        }

        @Override // com.google.firebase.perf.v1.WebApplicationInfoOrBuilder
        public boolean hasVisibilityState() {
            return ((WebApplicationInfo) this.instance).hasVisibilityState();
        }

        public Builder setEffectiveConnectionType(EffectiveConnectionType effectiveConnectionType) {
            copyOnWrite();
            ((WebApplicationInfo) this.instance).setEffectiveConnectionType(effectiveConnectionType);
            return this;
        }

        public Builder setPageUrl(String str) {
            copyOnWrite();
            ((WebApplicationInfo) this.instance).setPageUrl(str);
            return this;
        }

        public Builder setPageUrlBytes(a05 a05) {
            copyOnWrite();
            ((WebApplicationInfo) this.instance).setPageUrlBytes(a05);
            return this;
        }

        public Builder setSdkVersion(String str) {
            copyOnWrite();
            ((WebApplicationInfo) this.instance).setSdkVersion(str);
            return this;
        }

        public Builder setSdkVersionBytes(a05 a05) {
            copyOnWrite();
            ((WebApplicationInfo) this.instance).setSdkVersionBytes(a05);
            return this;
        }

        public Builder setServiceWorkerStatus(ServiceWorkerStatus serviceWorkerStatus) {
            copyOnWrite();
            ((WebApplicationInfo) this.instance).setServiceWorkerStatus(serviceWorkerStatus);
            return this;
        }

        public Builder setVisibilityState(VisibilityState visibilityState) {
            copyOnWrite();
            ((WebApplicationInfo) this.instance).setVisibilityState(visibilityState);
            return this;
        }

        private Builder() {
            super(WebApplicationInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        WebApplicationInfo webApplicationInfo = new WebApplicationInfo();
        DEFAULT_INSTANCE = webApplicationInfo;
        q05.registerDefaultInstance(WebApplicationInfo.class, webApplicationInfo);
    }

    private WebApplicationInfo() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearEffectiveConnectionType() {
        this.bitField0_ &= -17;
        this.effectiveConnectionType_ = 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearPageUrl() {
        this.bitField0_ &= -3;
        this.pageUrl_ = getDefaultInstance().getPageUrl();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearSdkVersion() {
        this.bitField0_ &= -2;
        this.sdkVersion_ = getDefaultInstance().getSdkVersion();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearServiceWorkerStatus() {
        this.bitField0_ &= -5;
        this.serviceWorkerStatus_ = 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearVisibilityState() {
        this.bitField0_ &= -9;
        this.visibilityState_ = 0;
    }

    public static WebApplicationInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static WebApplicationInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (WebApplicationInfo) q05.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WebApplicationInfo parseFrom(ByteBuffer byteBuffer) throws t05 {
        return (WebApplicationInfo) q05.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static q15<WebApplicationInfo> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setEffectiveConnectionType(EffectiveConnectionType effectiveConnectionType) {
        this.effectiveConnectionType_ = effectiveConnectionType.getNumber();
        this.bitField0_ |= 16;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setPageUrl(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.pageUrl_ = str;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setPageUrlBytes(a05 a05) {
        this.pageUrl_ = a05.B();
        this.bitField0_ |= 2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setSdkVersion(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.sdkVersion_ = str;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setSdkVersionBytes(a05 a05) {
        this.sdkVersion_ = a05.B();
        this.bitField0_ |= 1;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setServiceWorkerStatus(ServiceWorkerStatus serviceWorkerStatus) {
        this.serviceWorkerStatus_ = serviceWorkerStatus.getNumber();
        this.bitField0_ |= 4;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setVisibilityState(VisibilityState visibilityState) {
        this.visibilityState_ = visibilityState.getNumber();
        this.bitField0_ |= 8;
    }

    @Override // defpackage.q05
    public final Object dynamicMethod(q05.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return q05.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\f\u0002\u0004\f\u0003\u0005\f\u0004", new Object[]{"bitField0_", "sdkVersion_", "pageUrl_", "serviceWorkerStatus_", ServiceWorkerStatus.internalGetVerifier(), "visibilityState_", VisibilityState.internalGetVerifier(), "effectiveConnectionType_", EffectiveConnectionType.internalGetVerifier()});
            case 3:
                return new WebApplicationInfo();
            case 4:
                return new Builder(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                q15<WebApplicationInfo> q15 = PARSER;
                if (q15 == null) {
                    synchronized (WebApplicationInfo.class) {
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

    @Override // com.google.firebase.perf.v1.WebApplicationInfoOrBuilder
    public EffectiveConnectionType getEffectiveConnectionType() {
        EffectiveConnectionType forNumber = EffectiveConnectionType.forNumber(this.effectiveConnectionType_);
        return forNumber == null ? EffectiveConnectionType.EFFECTIVE_CONNECTION_TYPE_UNKNOWN : forNumber;
    }

    @Override // com.google.firebase.perf.v1.WebApplicationInfoOrBuilder
    public String getPageUrl() {
        return this.pageUrl_;
    }

    @Override // com.google.firebase.perf.v1.WebApplicationInfoOrBuilder
    public a05 getPageUrlBytes() {
        return a05.k(this.pageUrl_);
    }

    @Override // com.google.firebase.perf.v1.WebApplicationInfoOrBuilder
    public String getSdkVersion() {
        return this.sdkVersion_;
    }

    @Override // com.google.firebase.perf.v1.WebApplicationInfoOrBuilder
    public a05 getSdkVersionBytes() {
        return a05.k(this.sdkVersion_);
    }

    @Override // com.google.firebase.perf.v1.WebApplicationInfoOrBuilder
    public ServiceWorkerStatus getServiceWorkerStatus() {
        ServiceWorkerStatus forNumber = ServiceWorkerStatus.forNumber(this.serviceWorkerStatus_);
        return forNumber == null ? ServiceWorkerStatus.SERVICE_WORKER_STATUS_UNKNOWN : forNumber;
    }

    @Override // com.google.firebase.perf.v1.WebApplicationInfoOrBuilder
    public VisibilityState getVisibilityState() {
        VisibilityState forNumber = VisibilityState.forNumber(this.visibilityState_);
        return forNumber == null ? VisibilityState.VISIBILITY_STATE_UNKNOWN : forNumber;
    }

    @Override // com.google.firebase.perf.v1.WebApplicationInfoOrBuilder
    public boolean hasEffectiveConnectionType() {
        return (this.bitField0_ & 16) != 0;
    }

    @Override // com.google.firebase.perf.v1.WebApplicationInfoOrBuilder
    public boolean hasPageUrl() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // com.google.firebase.perf.v1.WebApplicationInfoOrBuilder
    public boolean hasSdkVersion() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.google.firebase.perf.v1.WebApplicationInfoOrBuilder
    public boolean hasServiceWorkerStatus() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // com.google.firebase.perf.v1.WebApplicationInfoOrBuilder
    public boolean hasVisibilityState() {
        return (this.bitField0_ & 8) != 0;
    }

    public static Builder newBuilder(WebApplicationInfo webApplicationInfo) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(webApplicationInfo);
    }

    public static WebApplicationInfo parseDelimitedFrom(InputStream inputStream, i05 i05) throws IOException {
        return (WebApplicationInfo) q05.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, i05);
    }

    public static WebApplicationInfo parseFrom(ByteBuffer byteBuffer, i05 i05) throws t05 {
        return (WebApplicationInfo) q05.parseFrom(DEFAULT_INSTANCE, byteBuffer, i05);
    }

    public static WebApplicationInfo parseFrom(a05 a05) throws t05 {
        return (WebApplicationInfo) q05.parseFrom(DEFAULT_INSTANCE, a05);
    }

    public static WebApplicationInfo parseFrom(a05 a05, i05 i05) throws t05 {
        return (WebApplicationInfo) q05.parseFrom(DEFAULT_INSTANCE, a05, i05);
    }

    public static WebApplicationInfo parseFrom(byte[] bArr) throws t05 {
        return (WebApplicationInfo) q05.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static WebApplicationInfo parseFrom(byte[] bArr, i05 i05) throws t05 {
        return (WebApplicationInfo) q05.parseFrom(DEFAULT_INSTANCE, bArr, i05);
    }

    public static WebApplicationInfo parseFrom(InputStream inputStream) throws IOException {
        return (WebApplicationInfo) q05.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WebApplicationInfo parseFrom(InputStream inputStream, i05 i05) throws IOException {
        return (WebApplicationInfo) q05.parseFrom(DEFAULT_INSTANCE, inputStream, i05);
    }

    public static WebApplicationInfo parseFrom(b05 b05) throws IOException {
        return (WebApplicationInfo) q05.parseFrom(DEFAULT_INSTANCE, b05);
    }

    public static WebApplicationInfo parseFrom(b05 b05, i05 i05) throws IOException {
        return (WebApplicationInfo) q05.parseFrom(DEFAULT_INSTANCE, b05, i05);
    }
}
