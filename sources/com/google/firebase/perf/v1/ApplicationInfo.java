package com.google.firebase.perf.v1;

import com.google.firebase.perf.v1.AndroidApplicationInfo;
import com.google.firebase.perf.v1.IosApplicationInfo;
import com.google.firebase.perf.v1.WebApplicationInfo;
import defpackage.q05;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;

public final class ApplicationInfo extends q05<ApplicationInfo, Builder> implements ApplicationInfoOrBuilder {
    public static final int ANDROID_APP_INFO_FIELD_NUMBER = 3;
    public static final int APPLICATION_PROCESS_STATE_FIELD_NUMBER = 5;
    public static final int APP_INSTANCE_ID_FIELD_NUMBER = 2;
    public static final int CUSTOM_ATTRIBUTES_FIELD_NUMBER = 6;
    private static final ApplicationInfo DEFAULT_INSTANCE;
    public static final int GOOGLE_APP_ID_FIELD_NUMBER = 1;
    public static final int IOS_APP_INFO_FIELD_NUMBER = 4;
    private static volatile q15<ApplicationInfo> PARSER = null;
    public static final int WEB_APP_INFO_FIELD_NUMBER = 7;
    private AndroidApplicationInfo androidAppInfo_;
    private String appInstanceId_ = "";
    private int applicationProcessState_;
    private int bitField0_;
    private d15<String, String> customAttributes_ = d15.g;
    private String googleAppId_ = "";
    private IosApplicationInfo iosAppInfo_;
    private WebApplicationInfo webAppInfo_;

    /* renamed from: com.google.firebase.perf.v1.ApplicationInfo$1  reason: invalid class name */
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
                com.google.firebase.perf.v1.ApplicationInfo.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = r1
                r2 = 1
                r3 = 3
                q05$f r4 = defpackage.q05.f.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x000e }
                r1[r3] = r2     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                r1 = 2
                r4 = 4
                int[] r5 = com.google.firebase.perf.v1.ApplicationInfo.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0016 }
                q05$f r6 = defpackage.q05.f.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x0016 }
                r5[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                int[] r5 = com.google.firebase.perf.v1.ApplicationInfo.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x001c }
                q05$f r6 = defpackage.q05.f.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x001c }
                r5[r1] = r3     // Catch:{ NoSuchFieldError -> 0x001c }
            L_0x001c:
                r1 = 5
                int[] r3 = com.google.firebase.perf.v1.ApplicationInfo.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0023 }
                q05$f r5 = defpackage.q05.f.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0023 }
                r3[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0023 }
            L_0x0023:
                r3 = 6
                int[] r4 = com.google.firebase.perf.v1.ApplicationInfo.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x002a }
                q05$f r5 = defpackage.q05.f.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x002a }
                r4[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r1 = com.google.firebase.perf.v1.ApplicationInfo.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0031 }
                q05$f r4 = defpackage.q05.f.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0031 }
                r4 = 0
                r1[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0031 }
            L_0x0031:
                int[] r1 = com.google.firebase.perf.v1.ApplicationInfo.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0037 }
                q05$f r3 = defpackage.q05.f.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0037 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0037 }
            L_0x0037:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.v1.ApplicationInfo.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class Builder extends q05.a<ApplicationInfo, Builder> implements ApplicationInfoOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        public Builder clearAndroidAppInfo() {
            copyOnWrite();
            ((ApplicationInfo) this.instance).clearAndroidAppInfo();
            return this;
        }

        public Builder clearAppInstanceId() {
            copyOnWrite();
            ((ApplicationInfo) this.instance).clearAppInstanceId();
            return this;
        }

        public Builder clearApplicationProcessState() {
            copyOnWrite();
            ((ApplicationInfo) this.instance).clearApplicationProcessState();
            return this;
        }

        public Builder clearCustomAttributes() {
            copyOnWrite();
            ((ApplicationInfo) this.instance).getMutableCustomAttributesMap().clear();
            return this;
        }

        public Builder clearGoogleAppId() {
            copyOnWrite();
            ((ApplicationInfo) this.instance).clearGoogleAppId();
            return this;
        }

        public Builder clearIosAppInfo() {
            copyOnWrite();
            ((ApplicationInfo) this.instance).clearIosAppInfo();
            return this;
        }

        public Builder clearWebAppInfo() {
            copyOnWrite();
            ((ApplicationInfo) this.instance).clearWebAppInfo();
            return this;
        }

        @Override // com.google.firebase.perf.v1.ApplicationInfoOrBuilder
        public boolean containsCustomAttributes(String str) {
            str.getClass();
            return ((ApplicationInfo) this.instance).getCustomAttributesMap().containsKey(str);
        }

        @Override // com.google.firebase.perf.v1.ApplicationInfoOrBuilder
        public AndroidApplicationInfo getAndroidAppInfo() {
            return ((ApplicationInfo) this.instance).getAndroidAppInfo();
        }

        @Override // com.google.firebase.perf.v1.ApplicationInfoOrBuilder
        public String getAppInstanceId() {
            return ((ApplicationInfo) this.instance).getAppInstanceId();
        }

        @Override // com.google.firebase.perf.v1.ApplicationInfoOrBuilder
        public a05 getAppInstanceIdBytes() {
            return ((ApplicationInfo) this.instance).getAppInstanceIdBytes();
        }

        @Override // com.google.firebase.perf.v1.ApplicationInfoOrBuilder
        public ApplicationProcessState getApplicationProcessState() {
            return ((ApplicationInfo) this.instance).getApplicationProcessState();
        }

        @Override // com.google.firebase.perf.v1.ApplicationInfoOrBuilder
        @Deprecated
        public Map<String, String> getCustomAttributes() {
            return getCustomAttributesMap();
        }

        @Override // com.google.firebase.perf.v1.ApplicationInfoOrBuilder
        public int getCustomAttributesCount() {
            return ((ApplicationInfo) this.instance).getCustomAttributesMap().size();
        }

        @Override // com.google.firebase.perf.v1.ApplicationInfoOrBuilder
        public Map<String, String> getCustomAttributesMap() {
            return Collections.unmodifiableMap(((ApplicationInfo) this.instance).getCustomAttributesMap());
        }

        @Override // com.google.firebase.perf.v1.ApplicationInfoOrBuilder
        public String getCustomAttributesOrDefault(String str, String str2) {
            str.getClass();
            Map<String, String> customAttributesMap = ((ApplicationInfo) this.instance).getCustomAttributesMap();
            return customAttributesMap.containsKey(str) ? customAttributesMap.get(str) : str2;
        }

        @Override // com.google.firebase.perf.v1.ApplicationInfoOrBuilder
        public String getCustomAttributesOrThrow(String str) {
            str.getClass();
            Map<String, String> customAttributesMap = ((ApplicationInfo) this.instance).getCustomAttributesMap();
            if (customAttributesMap.containsKey(str)) {
                return customAttributesMap.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // com.google.firebase.perf.v1.ApplicationInfoOrBuilder
        public String getGoogleAppId() {
            return ((ApplicationInfo) this.instance).getGoogleAppId();
        }

        @Override // com.google.firebase.perf.v1.ApplicationInfoOrBuilder
        public a05 getGoogleAppIdBytes() {
            return ((ApplicationInfo) this.instance).getGoogleAppIdBytes();
        }

        @Override // com.google.firebase.perf.v1.ApplicationInfoOrBuilder
        public IosApplicationInfo getIosAppInfo() {
            return ((ApplicationInfo) this.instance).getIosAppInfo();
        }

        @Override // com.google.firebase.perf.v1.ApplicationInfoOrBuilder
        public WebApplicationInfo getWebAppInfo() {
            return ((ApplicationInfo) this.instance).getWebAppInfo();
        }

        @Override // com.google.firebase.perf.v1.ApplicationInfoOrBuilder
        public boolean hasAndroidAppInfo() {
            return ((ApplicationInfo) this.instance).hasAndroidAppInfo();
        }

        @Override // com.google.firebase.perf.v1.ApplicationInfoOrBuilder
        public boolean hasAppInstanceId() {
            return ((ApplicationInfo) this.instance).hasAppInstanceId();
        }

        @Override // com.google.firebase.perf.v1.ApplicationInfoOrBuilder
        public boolean hasApplicationProcessState() {
            return ((ApplicationInfo) this.instance).hasApplicationProcessState();
        }

        @Override // com.google.firebase.perf.v1.ApplicationInfoOrBuilder
        public boolean hasGoogleAppId() {
            return ((ApplicationInfo) this.instance).hasGoogleAppId();
        }

        @Override // com.google.firebase.perf.v1.ApplicationInfoOrBuilder
        public boolean hasIosAppInfo() {
            return ((ApplicationInfo) this.instance).hasIosAppInfo();
        }

        @Override // com.google.firebase.perf.v1.ApplicationInfoOrBuilder
        public boolean hasWebAppInfo() {
            return ((ApplicationInfo) this.instance).hasWebAppInfo();
        }

        public Builder mergeAndroidAppInfo(AndroidApplicationInfo androidApplicationInfo) {
            copyOnWrite();
            ((ApplicationInfo) this.instance).mergeAndroidAppInfo(androidApplicationInfo);
            return this;
        }

        public Builder mergeIosAppInfo(IosApplicationInfo iosApplicationInfo) {
            copyOnWrite();
            ((ApplicationInfo) this.instance).mergeIosAppInfo(iosApplicationInfo);
            return this;
        }

        public Builder mergeWebAppInfo(WebApplicationInfo webApplicationInfo) {
            copyOnWrite();
            ((ApplicationInfo) this.instance).mergeWebAppInfo(webApplicationInfo);
            return this;
        }

        public Builder putAllCustomAttributes(Map<String, String> map) {
            copyOnWrite();
            ((ApplicationInfo) this.instance).getMutableCustomAttributesMap().putAll(map);
            return this;
        }

        public Builder putCustomAttributes(String str, String str2) {
            str.getClass();
            str2.getClass();
            copyOnWrite();
            ((ApplicationInfo) this.instance).getMutableCustomAttributesMap().put(str, str2);
            return this;
        }

        public Builder removeCustomAttributes(String str) {
            str.getClass();
            copyOnWrite();
            ((ApplicationInfo) this.instance).getMutableCustomAttributesMap().remove(str);
            return this;
        }

        public Builder setAndroidAppInfo(AndroidApplicationInfo androidApplicationInfo) {
            copyOnWrite();
            ((ApplicationInfo) this.instance).setAndroidAppInfo(androidApplicationInfo);
            return this;
        }

        public Builder setAppInstanceId(String str) {
            copyOnWrite();
            ((ApplicationInfo) this.instance).setAppInstanceId(str);
            return this;
        }

        public Builder setAppInstanceIdBytes(a05 a05) {
            copyOnWrite();
            ((ApplicationInfo) this.instance).setAppInstanceIdBytes(a05);
            return this;
        }

        public Builder setApplicationProcessState(ApplicationProcessState applicationProcessState) {
            copyOnWrite();
            ((ApplicationInfo) this.instance).setApplicationProcessState(applicationProcessState);
            return this;
        }

        public Builder setGoogleAppId(String str) {
            copyOnWrite();
            ((ApplicationInfo) this.instance).setGoogleAppId(str);
            return this;
        }

        public Builder setGoogleAppIdBytes(a05 a05) {
            copyOnWrite();
            ((ApplicationInfo) this.instance).setGoogleAppIdBytes(a05);
            return this;
        }

        public Builder setIosAppInfo(IosApplicationInfo iosApplicationInfo) {
            copyOnWrite();
            ((ApplicationInfo) this.instance).setIosAppInfo(iosApplicationInfo);
            return this;
        }

        public Builder setWebAppInfo(WebApplicationInfo webApplicationInfo) {
            copyOnWrite();
            ((ApplicationInfo) this.instance).setWebAppInfo(webApplicationInfo);
            return this;
        }

        private Builder() {
            super(ApplicationInfo.DEFAULT_INSTANCE);
        }

        public Builder setAndroidAppInfo(AndroidApplicationInfo.Builder builder) {
            copyOnWrite();
            ((ApplicationInfo) this.instance).setAndroidAppInfo((AndroidApplicationInfo) builder.build());
            return this;
        }

        public Builder setIosAppInfo(IosApplicationInfo.Builder builder) {
            copyOnWrite();
            ((ApplicationInfo) this.instance).setIosAppInfo((IosApplicationInfo) builder.build());
            return this;
        }

        public Builder setWebAppInfo(WebApplicationInfo.Builder builder) {
            copyOnWrite();
            ((ApplicationInfo) this.instance).setWebAppInfo((WebApplicationInfo) builder.build());
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

    static {
        ApplicationInfo applicationInfo = new ApplicationInfo();
        DEFAULT_INSTANCE = applicationInfo;
        q05.registerDefaultInstance(ApplicationInfo.class, applicationInfo);
    }

    private ApplicationInfo() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearAndroidAppInfo() {
        this.androidAppInfo_ = null;
        this.bitField0_ &= -5;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearAppInstanceId() {
        this.bitField0_ &= -3;
        this.appInstanceId_ = getDefaultInstance().getAppInstanceId();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearApplicationProcessState() {
        this.bitField0_ &= -33;
        this.applicationProcessState_ = 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearGoogleAppId() {
        this.bitField0_ &= -2;
        this.googleAppId_ = getDefaultInstance().getGoogleAppId();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearIosAppInfo() {
        this.iosAppInfo_ = null;
        this.bitField0_ &= -9;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearWebAppInfo() {
        this.webAppInfo_ = null;
        this.bitField0_ &= -17;
    }

    public static ApplicationInfo getDefaultInstance() {
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

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void mergeAndroidAppInfo(AndroidApplicationInfo androidApplicationInfo) {
        androidApplicationInfo.getClass();
        AndroidApplicationInfo androidApplicationInfo2 = this.androidAppInfo_;
        if (androidApplicationInfo2 == null || androidApplicationInfo2 == AndroidApplicationInfo.getDefaultInstance()) {
            this.androidAppInfo_ = androidApplicationInfo;
        } else {
            this.androidAppInfo_ = (AndroidApplicationInfo) ((AndroidApplicationInfo.Builder) AndroidApplicationInfo.newBuilder(this.androidAppInfo_).mergeFrom((q05) androidApplicationInfo)).buildPartial();
        }
        this.bitField0_ |= 4;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void mergeIosAppInfo(IosApplicationInfo iosApplicationInfo) {
        iosApplicationInfo.getClass();
        IosApplicationInfo iosApplicationInfo2 = this.iosAppInfo_;
        if (iosApplicationInfo2 == null || iosApplicationInfo2 == IosApplicationInfo.getDefaultInstance()) {
            this.iosAppInfo_ = iosApplicationInfo;
        } else {
            this.iosAppInfo_ = (IosApplicationInfo) ((IosApplicationInfo.Builder) IosApplicationInfo.newBuilder(this.iosAppInfo_).mergeFrom((q05) iosApplicationInfo)).buildPartial();
        }
        this.bitField0_ |= 8;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void mergeWebAppInfo(WebApplicationInfo webApplicationInfo) {
        webApplicationInfo.getClass();
        WebApplicationInfo webApplicationInfo2 = this.webAppInfo_;
        if (webApplicationInfo2 == null || webApplicationInfo2 == WebApplicationInfo.getDefaultInstance()) {
            this.webAppInfo_ = webApplicationInfo;
        } else {
            this.webAppInfo_ = (WebApplicationInfo) ((WebApplicationInfo.Builder) WebApplicationInfo.newBuilder(this.webAppInfo_).mergeFrom((q05) webApplicationInfo)).buildPartial();
        }
        this.bitField0_ |= 16;
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static ApplicationInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ApplicationInfo) q05.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ApplicationInfo parseFrom(ByteBuffer byteBuffer) throws t05 {
        return (ApplicationInfo) q05.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static q15<ApplicationInfo> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setAndroidAppInfo(AndroidApplicationInfo androidApplicationInfo) {
        androidApplicationInfo.getClass();
        this.androidAppInfo_ = androidApplicationInfo;
        this.bitField0_ |= 4;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setAppInstanceId(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.appInstanceId_ = str;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setAppInstanceIdBytes(a05 a05) {
        this.appInstanceId_ = a05.B();
        this.bitField0_ |= 2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setApplicationProcessState(ApplicationProcessState applicationProcessState) {
        this.applicationProcessState_ = applicationProcessState.getNumber();
        this.bitField0_ |= 32;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setGoogleAppId(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.googleAppId_ = str;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setGoogleAppIdBytes(a05 a05) {
        this.googleAppId_ = a05.B();
        this.bitField0_ |= 1;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setIosAppInfo(IosApplicationInfo iosApplicationInfo) {
        iosApplicationInfo.getClass();
        this.iosAppInfo_ = iosApplicationInfo;
        this.bitField0_ |= 8;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setWebAppInfo(WebApplicationInfo webApplicationInfo) {
        webApplicationInfo.getClass();
        this.webAppInfo_ = webApplicationInfo;
        this.bitField0_ |= 16;
    }

    @Override // com.google.firebase.perf.v1.ApplicationInfoOrBuilder
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
                return q05.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0001\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\t\u0002\u0004\t\u0003\u0005\f\u0005\u00062\u0007\t\u0004", new Object[]{"bitField0_", "googleAppId_", "appInstanceId_", "androidAppInfo_", "iosAppInfo_", "applicationProcessState_", ApplicationProcessState.internalGetVerifier(), "customAttributes_", CustomAttributesDefaultEntryHolder.defaultEntry, "webAppInfo_"});
            case 3:
                return new ApplicationInfo();
            case 4:
                return new Builder(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                q15<ApplicationInfo> q15 = PARSER;
                if (q15 == null) {
                    synchronized (ApplicationInfo.class) {
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

    @Override // com.google.firebase.perf.v1.ApplicationInfoOrBuilder
    public AndroidApplicationInfo getAndroidAppInfo() {
        AndroidApplicationInfo androidApplicationInfo = this.androidAppInfo_;
        return androidApplicationInfo == null ? AndroidApplicationInfo.getDefaultInstance() : androidApplicationInfo;
    }

    @Override // com.google.firebase.perf.v1.ApplicationInfoOrBuilder
    public String getAppInstanceId() {
        return this.appInstanceId_;
    }

    @Override // com.google.firebase.perf.v1.ApplicationInfoOrBuilder
    public a05 getAppInstanceIdBytes() {
        return a05.k(this.appInstanceId_);
    }

    @Override // com.google.firebase.perf.v1.ApplicationInfoOrBuilder
    public ApplicationProcessState getApplicationProcessState() {
        ApplicationProcessState forNumber = ApplicationProcessState.forNumber(this.applicationProcessState_);
        return forNumber == null ? ApplicationProcessState.APPLICATION_PROCESS_STATE_UNKNOWN : forNumber;
    }

    @Override // com.google.firebase.perf.v1.ApplicationInfoOrBuilder
    @Deprecated
    public Map<String, String> getCustomAttributes() {
        return getCustomAttributesMap();
    }

    @Override // com.google.firebase.perf.v1.ApplicationInfoOrBuilder
    public int getCustomAttributesCount() {
        return internalGetCustomAttributes().size();
    }

    @Override // com.google.firebase.perf.v1.ApplicationInfoOrBuilder
    public Map<String, String> getCustomAttributesMap() {
        return Collections.unmodifiableMap(internalGetCustomAttributes());
    }

    @Override // com.google.firebase.perf.v1.ApplicationInfoOrBuilder
    public String getCustomAttributesOrDefault(String str, String str2) {
        str.getClass();
        d15<String, String> internalGetCustomAttributes = internalGetCustomAttributes();
        return internalGetCustomAttributes.containsKey(str) ? internalGetCustomAttributes.get(str) : str2;
    }

    @Override // com.google.firebase.perf.v1.ApplicationInfoOrBuilder
    public String getCustomAttributesOrThrow(String str) {
        str.getClass();
        d15<String, String> internalGetCustomAttributes = internalGetCustomAttributes();
        if (internalGetCustomAttributes.containsKey(str)) {
            return internalGetCustomAttributes.get(str);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.firebase.perf.v1.ApplicationInfoOrBuilder
    public String getGoogleAppId() {
        return this.googleAppId_;
    }

    @Override // com.google.firebase.perf.v1.ApplicationInfoOrBuilder
    public a05 getGoogleAppIdBytes() {
        return a05.k(this.googleAppId_);
    }

    @Override // com.google.firebase.perf.v1.ApplicationInfoOrBuilder
    public IosApplicationInfo getIosAppInfo() {
        IosApplicationInfo iosApplicationInfo = this.iosAppInfo_;
        return iosApplicationInfo == null ? IosApplicationInfo.getDefaultInstance() : iosApplicationInfo;
    }

    @Override // com.google.firebase.perf.v1.ApplicationInfoOrBuilder
    public WebApplicationInfo getWebAppInfo() {
        WebApplicationInfo webApplicationInfo = this.webAppInfo_;
        return webApplicationInfo == null ? WebApplicationInfo.getDefaultInstance() : webApplicationInfo;
    }

    @Override // com.google.firebase.perf.v1.ApplicationInfoOrBuilder
    public boolean hasAndroidAppInfo() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // com.google.firebase.perf.v1.ApplicationInfoOrBuilder
    public boolean hasAppInstanceId() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // com.google.firebase.perf.v1.ApplicationInfoOrBuilder
    public boolean hasApplicationProcessState() {
        return (this.bitField0_ & 32) != 0;
    }

    @Override // com.google.firebase.perf.v1.ApplicationInfoOrBuilder
    public boolean hasGoogleAppId() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.google.firebase.perf.v1.ApplicationInfoOrBuilder
    public boolean hasIosAppInfo() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // com.google.firebase.perf.v1.ApplicationInfoOrBuilder
    public boolean hasWebAppInfo() {
        return (this.bitField0_ & 16) != 0;
    }

    public static Builder newBuilder(ApplicationInfo applicationInfo) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(applicationInfo);
    }

    public static ApplicationInfo parseDelimitedFrom(InputStream inputStream, i05 i05) throws IOException {
        return (ApplicationInfo) q05.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, i05);
    }

    public static ApplicationInfo parseFrom(ByteBuffer byteBuffer, i05 i05) throws t05 {
        return (ApplicationInfo) q05.parseFrom(DEFAULT_INSTANCE, byteBuffer, i05);
    }

    public static ApplicationInfo parseFrom(a05 a05) throws t05 {
        return (ApplicationInfo) q05.parseFrom(DEFAULT_INSTANCE, a05);
    }

    public static ApplicationInfo parseFrom(a05 a05, i05 i05) throws t05 {
        return (ApplicationInfo) q05.parseFrom(DEFAULT_INSTANCE, a05, i05);
    }

    public static ApplicationInfo parseFrom(byte[] bArr) throws t05 {
        return (ApplicationInfo) q05.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ApplicationInfo parseFrom(byte[] bArr, i05 i05) throws t05 {
        return (ApplicationInfo) q05.parseFrom(DEFAULT_INSTANCE, bArr, i05);
    }

    public static ApplicationInfo parseFrom(InputStream inputStream) throws IOException {
        return (ApplicationInfo) q05.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ApplicationInfo parseFrom(InputStream inputStream, i05 i05) throws IOException {
        return (ApplicationInfo) q05.parseFrom(DEFAULT_INSTANCE, inputStream, i05);
    }

    public static ApplicationInfo parseFrom(b05 b05) throws IOException {
        return (ApplicationInfo) q05.parseFrom(DEFAULT_INSTANCE, b05);
    }

    public static ApplicationInfo parseFrom(b05 b05, i05 i05) throws IOException {
        return (ApplicationInfo) q05.parseFrom(DEFAULT_INSTANCE, b05, i05);
    }
}
