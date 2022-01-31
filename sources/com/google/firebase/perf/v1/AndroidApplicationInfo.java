package com.google.firebase.perf.v1;

import defpackage.q05;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class AndroidApplicationInfo extends q05<AndroidApplicationInfo, Builder> implements AndroidApplicationInfoOrBuilder {
    private static final AndroidApplicationInfo DEFAULT_INSTANCE;
    public static final int PACKAGE_NAME_FIELD_NUMBER = 1;
    private static volatile q15<AndroidApplicationInfo> PARSER = null;
    public static final int SDK_VERSION_FIELD_NUMBER = 2;
    public static final int VERSION_NAME_FIELD_NUMBER = 3;
    private int bitField0_;
    private String packageName_ = "";
    private String sdkVersion_ = "";
    private String versionName_ = "";

    /* renamed from: com.google.firebase.perf.v1.AndroidApplicationInfo$1  reason: invalid class name */
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
                com.google.firebase.perf.v1.AndroidApplicationInfo.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = r1
                r2 = 1
                r3 = 3
                q05$f r4 = defpackage.q05.f.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x000e }
                r1[r3] = r2     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                r1 = 2
                r4 = 4
                int[] r5 = com.google.firebase.perf.v1.AndroidApplicationInfo.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0016 }
                q05$f r6 = defpackage.q05.f.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x0016 }
                r5[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                int[] r5 = com.google.firebase.perf.v1.AndroidApplicationInfo.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x001c }
                q05$f r6 = defpackage.q05.f.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x001c }
                r5[r1] = r3     // Catch:{ NoSuchFieldError -> 0x001c }
            L_0x001c:
                r1 = 5
                int[] r3 = com.google.firebase.perf.v1.AndroidApplicationInfo.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0023 }
                q05$f r5 = defpackage.q05.f.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0023 }
                r3[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0023 }
            L_0x0023:
                r3 = 6
                int[] r4 = com.google.firebase.perf.v1.AndroidApplicationInfo.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x002a }
                q05$f r5 = defpackage.q05.f.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x002a }
                r4[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r1 = com.google.firebase.perf.v1.AndroidApplicationInfo.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0031 }
                q05$f r4 = defpackage.q05.f.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0031 }
                r4 = 0
                r1[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0031 }
            L_0x0031:
                int[] r1 = com.google.firebase.perf.v1.AndroidApplicationInfo.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0037 }
                q05$f r3 = defpackage.q05.f.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0037 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0037 }
            L_0x0037:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.v1.AndroidApplicationInfo.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class Builder extends q05.a<AndroidApplicationInfo, Builder> implements AndroidApplicationInfoOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        public Builder clearPackageName() {
            copyOnWrite();
            ((AndroidApplicationInfo) this.instance).clearPackageName();
            return this;
        }

        public Builder clearSdkVersion() {
            copyOnWrite();
            ((AndroidApplicationInfo) this.instance).clearSdkVersion();
            return this;
        }

        public Builder clearVersionName() {
            copyOnWrite();
            ((AndroidApplicationInfo) this.instance).clearVersionName();
            return this;
        }

        @Override // com.google.firebase.perf.v1.AndroidApplicationInfoOrBuilder
        public String getPackageName() {
            return ((AndroidApplicationInfo) this.instance).getPackageName();
        }

        @Override // com.google.firebase.perf.v1.AndroidApplicationInfoOrBuilder
        public a05 getPackageNameBytes() {
            return ((AndroidApplicationInfo) this.instance).getPackageNameBytes();
        }

        @Override // com.google.firebase.perf.v1.AndroidApplicationInfoOrBuilder
        public String getSdkVersion() {
            return ((AndroidApplicationInfo) this.instance).getSdkVersion();
        }

        @Override // com.google.firebase.perf.v1.AndroidApplicationInfoOrBuilder
        public a05 getSdkVersionBytes() {
            return ((AndroidApplicationInfo) this.instance).getSdkVersionBytes();
        }

        @Override // com.google.firebase.perf.v1.AndroidApplicationInfoOrBuilder
        public String getVersionName() {
            return ((AndroidApplicationInfo) this.instance).getVersionName();
        }

        @Override // com.google.firebase.perf.v1.AndroidApplicationInfoOrBuilder
        public a05 getVersionNameBytes() {
            return ((AndroidApplicationInfo) this.instance).getVersionNameBytes();
        }

        @Override // com.google.firebase.perf.v1.AndroidApplicationInfoOrBuilder
        public boolean hasPackageName() {
            return ((AndroidApplicationInfo) this.instance).hasPackageName();
        }

        @Override // com.google.firebase.perf.v1.AndroidApplicationInfoOrBuilder
        public boolean hasSdkVersion() {
            return ((AndroidApplicationInfo) this.instance).hasSdkVersion();
        }

        @Override // com.google.firebase.perf.v1.AndroidApplicationInfoOrBuilder
        public boolean hasVersionName() {
            return ((AndroidApplicationInfo) this.instance).hasVersionName();
        }

        public Builder setPackageName(String str) {
            copyOnWrite();
            ((AndroidApplicationInfo) this.instance).setPackageName(str);
            return this;
        }

        public Builder setPackageNameBytes(a05 a05) {
            copyOnWrite();
            ((AndroidApplicationInfo) this.instance).setPackageNameBytes(a05);
            return this;
        }

        public Builder setSdkVersion(String str) {
            copyOnWrite();
            ((AndroidApplicationInfo) this.instance).setSdkVersion(str);
            return this;
        }

        public Builder setSdkVersionBytes(a05 a05) {
            copyOnWrite();
            ((AndroidApplicationInfo) this.instance).setSdkVersionBytes(a05);
            return this;
        }

        public Builder setVersionName(String str) {
            copyOnWrite();
            ((AndroidApplicationInfo) this.instance).setVersionName(str);
            return this;
        }

        public Builder setVersionNameBytes(a05 a05) {
            copyOnWrite();
            ((AndroidApplicationInfo) this.instance).setVersionNameBytes(a05);
            return this;
        }

        private Builder() {
            super(AndroidApplicationInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        AndroidApplicationInfo androidApplicationInfo = new AndroidApplicationInfo();
        DEFAULT_INSTANCE = androidApplicationInfo;
        q05.registerDefaultInstance(AndroidApplicationInfo.class, androidApplicationInfo);
    }

    private AndroidApplicationInfo() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearPackageName() {
        this.bitField0_ &= -2;
        this.packageName_ = getDefaultInstance().getPackageName();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearSdkVersion() {
        this.bitField0_ &= -3;
        this.sdkVersion_ = getDefaultInstance().getSdkVersion();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearVersionName() {
        this.bitField0_ &= -5;
        this.versionName_ = getDefaultInstance().getVersionName();
    }

    public static AndroidApplicationInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static AndroidApplicationInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (AndroidApplicationInfo) q05.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AndroidApplicationInfo parseFrom(ByteBuffer byteBuffer) throws t05 {
        return (AndroidApplicationInfo) q05.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static q15<AndroidApplicationInfo> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setPackageName(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.packageName_ = str;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setPackageNameBytes(a05 a05) {
        this.packageName_ = a05.B();
        this.bitField0_ |= 1;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setSdkVersion(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.sdkVersion_ = str;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setSdkVersionBytes(a05 a05) {
        this.sdkVersion_ = a05.B();
        this.bitField0_ |= 2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setVersionName(String str) {
        str.getClass();
        this.bitField0_ |= 4;
        this.versionName_ = str;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setVersionNameBytes(a05 a05) {
        this.versionName_ = a05.B();
        this.bitField0_ |= 4;
    }

    @Override // defpackage.q05
    public final Object dynamicMethod(q05.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return q05.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002", new Object[]{"bitField0_", "packageName_", "sdkVersion_", "versionName_"});
            case 3:
                return new AndroidApplicationInfo();
            case 4:
                return new Builder(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                q15<AndroidApplicationInfo> q15 = PARSER;
                if (q15 == null) {
                    synchronized (AndroidApplicationInfo.class) {
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

    @Override // com.google.firebase.perf.v1.AndroidApplicationInfoOrBuilder
    public String getPackageName() {
        return this.packageName_;
    }

    @Override // com.google.firebase.perf.v1.AndroidApplicationInfoOrBuilder
    public a05 getPackageNameBytes() {
        return a05.k(this.packageName_);
    }

    @Override // com.google.firebase.perf.v1.AndroidApplicationInfoOrBuilder
    public String getSdkVersion() {
        return this.sdkVersion_;
    }

    @Override // com.google.firebase.perf.v1.AndroidApplicationInfoOrBuilder
    public a05 getSdkVersionBytes() {
        return a05.k(this.sdkVersion_);
    }

    @Override // com.google.firebase.perf.v1.AndroidApplicationInfoOrBuilder
    public String getVersionName() {
        return this.versionName_;
    }

    @Override // com.google.firebase.perf.v1.AndroidApplicationInfoOrBuilder
    public a05 getVersionNameBytes() {
        return a05.k(this.versionName_);
    }

    @Override // com.google.firebase.perf.v1.AndroidApplicationInfoOrBuilder
    public boolean hasPackageName() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.google.firebase.perf.v1.AndroidApplicationInfoOrBuilder
    public boolean hasSdkVersion() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // com.google.firebase.perf.v1.AndroidApplicationInfoOrBuilder
    public boolean hasVersionName() {
        return (this.bitField0_ & 4) != 0;
    }

    public static Builder newBuilder(AndroidApplicationInfo androidApplicationInfo) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(androidApplicationInfo);
    }

    public static AndroidApplicationInfo parseDelimitedFrom(InputStream inputStream, i05 i05) throws IOException {
        return (AndroidApplicationInfo) q05.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, i05);
    }

    public static AndroidApplicationInfo parseFrom(ByteBuffer byteBuffer, i05 i05) throws t05 {
        return (AndroidApplicationInfo) q05.parseFrom(DEFAULT_INSTANCE, byteBuffer, i05);
    }

    public static AndroidApplicationInfo parseFrom(a05 a05) throws t05 {
        return (AndroidApplicationInfo) q05.parseFrom(DEFAULT_INSTANCE, a05);
    }

    public static AndroidApplicationInfo parseFrom(a05 a05, i05 i05) throws t05 {
        return (AndroidApplicationInfo) q05.parseFrom(DEFAULT_INSTANCE, a05, i05);
    }

    public static AndroidApplicationInfo parseFrom(byte[] bArr) throws t05 {
        return (AndroidApplicationInfo) q05.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AndroidApplicationInfo parseFrom(byte[] bArr, i05 i05) throws t05 {
        return (AndroidApplicationInfo) q05.parseFrom(DEFAULT_INSTANCE, bArr, i05);
    }

    public static AndroidApplicationInfo parseFrom(InputStream inputStream) throws IOException {
        return (AndroidApplicationInfo) q05.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AndroidApplicationInfo parseFrom(InputStream inputStream, i05 i05) throws IOException {
        return (AndroidApplicationInfo) q05.parseFrom(DEFAULT_INSTANCE, inputStream, i05);
    }

    public static AndroidApplicationInfo parseFrom(b05 b05) throws IOException {
        return (AndroidApplicationInfo) q05.parseFrom(DEFAULT_INSTANCE, b05);
    }

    public static AndroidApplicationInfo parseFrom(b05 b05, i05 i05) throws IOException {
        return (AndroidApplicationInfo) q05.parseFrom(DEFAULT_INSTANCE, b05, i05);
    }
}
