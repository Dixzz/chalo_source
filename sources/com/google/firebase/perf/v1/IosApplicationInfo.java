package com.google.firebase.perf.v1;

import com.google.firebase.perf.v1.NetworkConnectionInfo;
import defpackage.q05;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class IosApplicationInfo extends q05<IosApplicationInfo, Builder> implements IosApplicationInfoOrBuilder {
    public static final int BUNDLE_SHORT_VERSION_FIELD_NUMBER = 3;
    private static final IosApplicationInfo DEFAULT_INSTANCE;
    public static final int MCC_MNC_FIELD_NUMBER = 4;
    public static final int NETWORK_CONNECTION_INFO_FIELD_NUMBER = 5;
    private static volatile q15<IosApplicationInfo> PARSER = null;
    public static final int SDK_VERSION_FIELD_NUMBER = 2;
    private int bitField0_;
    private String bundleShortVersion_ = "";
    private String mccMnc_ = "";
    private NetworkConnectionInfo networkConnectionInfo_;
    private String sdkVersion_ = "";

    /* renamed from: com.google.firebase.perf.v1.IosApplicationInfo$1  reason: invalid class name */
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
                com.google.firebase.perf.v1.IosApplicationInfo.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = r1
                r2 = 1
                r3 = 3
                q05$f r4 = defpackage.q05.f.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x000e }
                r1[r3] = r2     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                r1 = 2
                r4 = 4
                int[] r5 = com.google.firebase.perf.v1.IosApplicationInfo.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0016 }
                q05$f r6 = defpackage.q05.f.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x0016 }
                r5[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                int[] r5 = com.google.firebase.perf.v1.IosApplicationInfo.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x001c }
                q05$f r6 = defpackage.q05.f.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x001c }
                r5[r1] = r3     // Catch:{ NoSuchFieldError -> 0x001c }
            L_0x001c:
                r1 = 5
                int[] r3 = com.google.firebase.perf.v1.IosApplicationInfo.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0023 }
                q05$f r5 = defpackage.q05.f.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0023 }
                r3[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0023 }
            L_0x0023:
                r3 = 6
                int[] r4 = com.google.firebase.perf.v1.IosApplicationInfo.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x002a }
                q05$f r5 = defpackage.q05.f.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x002a }
                r4[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r1 = com.google.firebase.perf.v1.IosApplicationInfo.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0031 }
                q05$f r4 = defpackage.q05.f.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0031 }
                r4 = 0
                r1[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0031 }
            L_0x0031:
                int[] r1 = com.google.firebase.perf.v1.IosApplicationInfo.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0037 }
                q05$f r3 = defpackage.q05.f.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0037 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0037 }
            L_0x0037:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.v1.IosApplicationInfo.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class Builder extends q05.a<IosApplicationInfo, Builder> implements IosApplicationInfoOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        public Builder clearBundleShortVersion() {
            copyOnWrite();
            ((IosApplicationInfo) this.instance).clearBundleShortVersion();
            return this;
        }

        public Builder clearMccMnc() {
            copyOnWrite();
            ((IosApplicationInfo) this.instance).clearMccMnc();
            return this;
        }

        public Builder clearNetworkConnectionInfo() {
            copyOnWrite();
            ((IosApplicationInfo) this.instance).clearNetworkConnectionInfo();
            return this;
        }

        public Builder clearSdkVersion() {
            copyOnWrite();
            ((IosApplicationInfo) this.instance).clearSdkVersion();
            return this;
        }

        @Override // com.google.firebase.perf.v1.IosApplicationInfoOrBuilder
        public String getBundleShortVersion() {
            return ((IosApplicationInfo) this.instance).getBundleShortVersion();
        }

        @Override // com.google.firebase.perf.v1.IosApplicationInfoOrBuilder
        public a05 getBundleShortVersionBytes() {
            return ((IosApplicationInfo) this.instance).getBundleShortVersionBytes();
        }

        @Override // com.google.firebase.perf.v1.IosApplicationInfoOrBuilder
        public String getMccMnc() {
            return ((IosApplicationInfo) this.instance).getMccMnc();
        }

        @Override // com.google.firebase.perf.v1.IosApplicationInfoOrBuilder
        public a05 getMccMncBytes() {
            return ((IosApplicationInfo) this.instance).getMccMncBytes();
        }

        @Override // com.google.firebase.perf.v1.IosApplicationInfoOrBuilder
        public NetworkConnectionInfo getNetworkConnectionInfo() {
            return ((IosApplicationInfo) this.instance).getNetworkConnectionInfo();
        }

        @Override // com.google.firebase.perf.v1.IosApplicationInfoOrBuilder
        public String getSdkVersion() {
            return ((IosApplicationInfo) this.instance).getSdkVersion();
        }

        @Override // com.google.firebase.perf.v1.IosApplicationInfoOrBuilder
        public a05 getSdkVersionBytes() {
            return ((IosApplicationInfo) this.instance).getSdkVersionBytes();
        }

        @Override // com.google.firebase.perf.v1.IosApplicationInfoOrBuilder
        public boolean hasBundleShortVersion() {
            return ((IosApplicationInfo) this.instance).hasBundleShortVersion();
        }

        @Override // com.google.firebase.perf.v1.IosApplicationInfoOrBuilder
        public boolean hasMccMnc() {
            return ((IosApplicationInfo) this.instance).hasMccMnc();
        }

        @Override // com.google.firebase.perf.v1.IosApplicationInfoOrBuilder
        public boolean hasNetworkConnectionInfo() {
            return ((IosApplicationInfo) this.instance).hasNetworkConnectionInfo();
        }

        @Override // com.google.firebase.perf.v1.IosApplicationInfoOrBuilder
        public boolean hasSdkVersion() {
            return ((IosApplicationInfo) this.instance).hasSdkVersion();
        }

        public Builder mergeNetworkConnectionInfo(NetworkConnectionInfo networkConnectionInfo) {
            copyOnWrite();
            ((IosApplicationInfo) this.instance).mergeNetworkConnectionInfo(networkConnectionInfo);
            return this;
        }

        public Builder setBundleShortVersion(String str) {
            copyOnWrite();
            ((IosApplicationInfo) this.instance).setBundleShortVersion(str);
            return this;
        }

        public Builder setBundleShortVersionBytes(a05 a05) {
            copyOnWrite();
            ((IosApplicationInfo) this.instance).setBundleShortVersionBytes(a05);
            return this;
        }

        public Builder setMccMnc(String str) {
            copyOnWrite();
            ((IosApplicationInfo) this.instance).setMccMnc(str);
            return this;
        }

        public Builder setMccMncBytes(a05 a05) {
            copyOnWrite();
            ((IosApplicationInfo) this.instance).setMccMncBytes(a05);
            return this;
        }

        public Builder setNetworkConnectionInfo(NetworkConnectionInfo networkConnectionInfo) {
            copyOnWrite();
            ((IosApplicationInfo) this.instance).setNetworkConnectionInfo(networkConnectionInfo);
            return this;
        }

        public Builder setSdkVersion(String str) {
            copyOnWrite();
            ((IosApplicationInfo) this.instance).setSdkVersion(str);
            return this;
        }

        public Builder setSdkVersionBytes(a05 a05) {
            copyOnWrite();
            ((IosApplicationInfo) this.instance).setSdkVersionBytes(a05);
            return this;
        }

        private Builder() {
            super(IosApplicationInfo.DEFAULT_INSTANCE);
        }

        public Builder setNetworkConnectionInfo(NetworkConnectionInfo.Builder builder) {
            copyOnWrite();
            ((IosApplicationInfo) this.instance).setNetworkConnectionInfo((NetworkConnectionInfo) builder.build());
            return this;
        }
    }

    static {
        IosApplicationInfo iosApplicationInfo = new IosApplicationInfo();
        DEFAULT_INSTANCE = iosApplicationInfo;
        q05.registerDefaultInstance(IosApplicationInfo.class, iosApplicationInfo);
    }

    private IosApplicationInfo() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearBundleShortVersion() {
        this.bitField0_ &= -3;
        this.bundleShortVersion_ = getDefaultInstance().getBundleShortVersion();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearMccMnc() {
        this.bitField0_ &= -5;
        this.mccMnc_ = getDefaultInstance().getMccMnc();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearNetworkConnectionInfo() {
        this.networkConnectionInfo_ = null;
        this.bitField0_ &= -9;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearSdkVersion() {
        this.bitField0_ &= -2;
        this.sdkVersion_ = getDefaultInstance().getSdkVersion();
    }

    public static IosApplicationInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void mergeNetworkConnectionInfo(NetworkConnectionInfo networkConnectionInfo) {
        networkConnectionInfo.getClass();
        NetworkConnectionInfo networkConnectionInfo2 = this.networkConnectionInfo_;
        if (networkConnectionInfo2 == null || networkConnectionInfo2 == NetworkConnectionInfo.getDefaultInstance()) {
            this.networkConnectionInfo_ = networkConnectionInfo;
        } else {
            this.networkConnectionInfo_ = (NetworkConnectionInfo) ((NetworkConnectionInfo.Builder) NetworkConnectionInfo.newBuilder(this.networkConnectionInfo_).mergeFrom((q05) networkConnectionInfo)).buildPartial();
        }
        this.bitField0_ |= 8;
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static IosApplicationInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (IosApplicationInfo) q05.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static IosApplicationInfo parseFrom(ByteBuffer byteBuffer) throws t05 {
        return (IosApplicationInfo) q05.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static q15<IosApplicationInfo> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setBundleShortVersion(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.bundleShortVersion_ = str;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setBundleShortVersionBytes(a05 a05) {
        this.bundleShortVersion_ = a05.B();
        this.bitField0_ |= 2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setMccMnc(String str) {
        str.getClass();
        this.bitField0_ |= 4;
        this.mccMnc_ = str;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setMccMncBytes(a05 a05) {
        this.mccMnc_ = a05.B();
        this.bitField0_ |= 4;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setNetworkConnectionInfo(NetworkConnectionInfo networkConnectionInfo) {
        networkConnectionInfo.getClass();
        this.networkConnectionInfo_ = networkConnectionInfo;
        this.bitField0_ |= 8;
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

    @Override // defpackage.q05
    public final Object dynamicMethod(q05.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return q05.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0002\u0005\u0004\u0000\u0000\u0000\u0002\b\u0000\u0003\b\u0001\u0004\b\u0002\u0005\t\u0003", new Object[]{"bitField0_", "sdkVersion_", "bundleShortVersion_", "mccMnc_", "networkConnectionInfo_"});
            case 3:
                return new IosApplicationInfo();
            case 4:
                return new Builder(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                q15<IosApplicationInfo> q15 = PARSER;
                if (q15 == null) {
                    synchronized (IosApplicationInfo.class) {
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

    @Override // com.google.firebase.perf.v1.IosApplicationInfoOrBuilder
    public String getBundleShortVersion() {
        return this.bundleShortVersion_;
    }

    @Override // com.google.firebase.perf.v1.IosApplicationInfoOrBuilder
    public a05 getBundleShortVersionBytes() {
        return a05.k(this.bundleShortVersion_);
    }

    @Override // com.google.firebase.perf.v1.IosApplicationInfoOrBuilder
    public String getMccMnc() {
        return this.mccMnc_;
    }

    @Override // com.google.firebase.perf.v1.IosApplicationInfoOrBuilder
    public a05 getMccMncBytes() {
        return a05.k(this.mccMnc_);
    }

    @Override // com.google.firebase.perf.v1.IosApplicationInfoOrBuilder
    public NetworkConnectionInfo getNetworkConnectionInfo() {
        NetworkConnectionInfo networkConnectionInfo = this.networkConnectionInfo_;
        return networkConnectionInfo == null ? NetworkConnectionInfo.getDefaultInstance() : networkConnectionInfo;
    }

    @Override // com.google.firebase.perf.v1.IosApplicationInfoOrBuilder
    public String getSdkVersion() {
        return this.sdkVersion_;
    }

    @Override // com.google.firebase.perf.v1.IosApplicationInfoOrBuilder
    public a05 getSdkVersionBytes() {
        return a05.k(this.sdkVersion_);
    }

    @Override // com.google.firebase.perf.v1.IosApplicationInfoOrBuilder
    public boolean hasBundleShortVersion() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // com.google.firebase.perf.v1.IosApplicationInfoOrBuilder
    public boolean hasMccMnc() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // com.google.firebase.perf.v1.IosApplicationInfoOrBuilder
    public boolean hasNetworkConnectionInfo() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // com.google.firebase.perf.v1.IosApplicationInfoOrBuilder
    public boolean hasSdkVersion() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(IosApplicationInfo iosApplicationInfo) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(iosApplicationInfo);
    }

    public static IosApplicationInfo parseDelimitedFrom(InputStream inputStream, i05 i05) throws IOException {
        return (IosApplicationInfo) q05.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, i05);
    }

    public static IosApplicationInfo parseFrom(ByteBuffer byteBuffer, i05 i05) throws t05 {
        return (IosApplicationInfo) q05.parseFrom(DEFAULT_INSTANCE, byteBuffer, i05);
    }

    public static IosApplicationInfo parseFrom(a05 a05) throws t05 {
        return (IosApplicationInfo) q05.parseFrom(DEFAULT_INSTANCE, a05);
    }

    public static IosApplicationInfo parseFrom(a05 a05, i05 i05) throws t05 {
        return (IosApplicationInfo) q05.parseFrom(DEFAULT_INSTANCE, a05, i05);
    }

    public static IosApplicationInfo parseFrom(byte[] bArr) throws t05 {
        return (IosApplicationInfo) q05.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static IosApplicationInfo parseFrom(byte[] bArr, i05 i05) throws t05 {
        return (IosApplicationInfo) q05.parseFrom(DEFAULT_INSTANCE, bArr, i05);
    }

    public static IosApplicationInfo parseFrom(InputStream inputStream) throws IOException {
        return (IosApplicationInfo) q05.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static IosApplicationInfo parseFrom(InputStream inputStream, i05 i05) throws IOException {
        return (IosApplicationInfo) q05.parseFrom(DEFAULT_INSTANCE, inputStream, i05);
    }

    public static IosApplicationInfo parseFrom(b05 b05) throws IOException {
        return (IosApplicationInfo) q05.parseFrom(DEFAULT_INSTANCE, b05);
    }

    public static IosApplicationInfo parseFrom(b05 b05, i05 i05) throws IOException {
        return (IosApplicationInfo) q05.parseFrom(DEFAULT_INSTANCE, b05, i05);
    }
}
