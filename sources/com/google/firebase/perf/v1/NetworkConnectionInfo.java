package com.google.firebase.perf.v1;

import defpackage.q05;
import defpackage.s05;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class NetworkConnectionInfo extends q05<NetworkConnectionInfo, Builder> implements NetworkConnectionInfoOrBuilder {
    private static final NetworkConnectionInfo DEFAULT_INSTANCE;
    public static final int MOBILE_SUBTYPE_FIELD_NUMBER = 2;
    public static final int NETWORK_TYPE_FIELD_NUMBER = 1;
    private static volatile q15<NetworkConnectionInfo> PARSER;
    private int bitField0_;
    private int mobileSubtype_;
    private int networkType_ = -1;

    /* renamed from: com.google.firebase.perf.v1.NetworkConnectionInfo$1  reason: invalid class name */
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
                com.google.firebase.perf.v1.NetworkConnectionInfo.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = r1
                r2 = 1
                r3 = 3
                q05$f r4 = defpackage.q05.f.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x000e }
                r1[r3] = r2     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                r1 = 2
                r4 = 4
                int[] r5 = com.google.firebase.perf.v1.NetworkConnectionInfo.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0016 }
                q05$f r6 = defpackage.q05.f.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x0016 }
                r5[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                int[] r5 = com.google.firebase.perf.v1.NetworkConnectionInfo.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x001c }
                q05$f r6 = defpackage.q05.f.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x001c }
                r5[r1] = r3     // Catch:{ NoSuchFieldError -> 0x001c }
            L_0x001c:
                r1 = 5
                int[] r3 = com.google.firebase.perf.v1.NetworkConnectionInfo.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0023 }
                q05$f r5 = defpackage.q05.f.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0023 }
                r3[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0023 }
            L_0x0023:
                r3 = 6
                int[] r4 = com.google.firebase.perf.v1.NetworkConnectionInfo.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x002a }
                q05$f r5 = defpackage.q05.f.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x002a }
                r4[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r1 = com.google.firebase.perf.v1.NetworkConnectionInfo.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0031 }
                q05$f r4 = defpackage.q05.f.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0031 }
                r4 = 0
                r1[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0031 }
            L_0x0031:
                int[] r1 = com.google.firebase.perf.v1.NetworkConnectionInfo.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0037 }
                q05$f r3 = defpackage.q05.f.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0037 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0037 }
            L_0x0037:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.v1.NetworkConnectionInfo.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class Builder extends q05.a<NetworkConnectionInfo, Builder> implements NetworkConnectionInfoOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        public Builder clearMobileSubtype() {
            copyOnWrite();
            ((NetworkConnectionInfo) this.instance).clearMobileSubtype();
            return this;
        }

        public Builder clearNetworkType() {
            copyOnWrite();
            ((NetworkConnectionInfo) this.instance).clearNetworkType();
            return this;
        }

        @Override // com.google.firebase.perf.v1.NetworkConnectionInfoOrBuilder
        public MobileSubtype getMobileSubtype() {
            return ((NetworkConnectionInfo) this.instance).getMobileSubtype();
        }

        @Override // com.google.firebase.perf.v1.NetworkConnectionInfoOrBuilder
        public NetworkType getNetworkType() {
            return ((NetworkConnectionInfo) this.instance).getNetworkType();
        }

        @Override // com.google.firebase.perf.v1.NetworkConnectionInfoOrBuilder
        public boolean hasMobileSubtype() {
            return ((NetworkConnectionInfo) this.instance).hasMobileSubtype();
        }

        @Override // com.google.firebase.perf.v1.NetworkConnectionInfoOrBuilder
        public boolean hasNetworkType() {
            return ((NetworkConnectionInfo) this.instance).hasNetworkType();
        }

        public Builder setMobileSubtype(MobileSubtype mobileSubtype) {
            copyOnWrite();
            ((NetworkConnectionInfo) this.instance).setMobileSubtype(mobileSubtype);
            return this;
        }

        public Builder setNetworkType(NetworkType networkType) {
            copyOnWrite();
            ((NetworkConnectionInfo) this.instance).setNetworkType(networkType);
            return this;
        }

        private Builder() {
            super(NetworkConnectionInfo.DEFAULT_INSTANCE);
        }
    }

    public enum MobileSubtype implements s05.c {
        UNKNOWN_MOBILE_SUBTYPE(0),
        GPRS(1),
        EDGE(2),
        UMTS(3),
        CDMA(4),
        EVDO_0(5),
        EVDO_A(6),
        RTT(7),
        HSDPA(8),
        HSUPA(9),
        HSPA(10),
        IDEN(11),
        EVDO_B(12),
        LTE(13),
        EHRPD(14),
        HSPAP(15),
        GSM(16),
        TD_SCDMA(17),
        IWLAN(18),
        LTE_CA(19),
        COMBINED(100);
        
        public static final int CDMA_VALUE = 4;
        public static final int COMBINED_VALUE = 100;
        public static final int EDGE_VALUE = 2;
        public static final int EHRPD_VALUE = 14;
        public static final int EVDO_0_VALUE = 5;
        public static final int EVDO_A_VALUE = 6;
        public static final int EVDO_B_VALUE = 12;
        public static final int GPRS_VALUE = 1;
        public static final int GSM_VALUE = 16;
        public static final int HSDPA_VALUE = 8;
        public static final int HSPAP_VALUE = 15;
        public static final int HSPA_VALUE = 10;
        public static final int HSUPA_VALUE = 9;
        public static final int IDEN_VALUE = 11;
        public static final int IWLAN_VALUE = 18;
        public static final int LTE_CA_VALUE = 19;
        public static final int LTE_VALUE = 13;
        public static final int RTT_VALUE = 7;
        public static final int TD_SCDMA_VALUE = 17;
        public static final int UMTS_VALUE = 3;
        public static final int UNKNOWN_MOBILE_SUBTYPE_VALUE = 0;
        private static final s05.d<MobileSubtype> internalValueMap = new s05.d<MobileSubtype>() {
            /* class com.google.firebase.perf.v1.NetworkConnectionInfo.MobileSubtype.AnonymousClass1 */

            @Override // defpackage.s05.d
            public MobileSubtype findValueByNumber(int i) {
                return MobileSubtype.forNumber(i);
            }
        };
        private final int value;

        public static final class MobileSubtypeVerifier implements s05.e {
            public static final s05.e INSTANCE = new MobileSubtypeVerifier();

            private MobileSubtypeVerifier() {
            }

            @Override // defpackage.s05.e
            public boolean isInRange(int i) {
                return MobileSubtype.forNumber(i) != null;
            }
        }

        private MobileSubtype(int i) {
            this.value = i;
        }

        public static MobileSubtype forNumber(int i) {
            if (i == 100) {
                return COMBINED;
            }
            switch (i) {
                case 0:
                    return UNKNOWN_MOBILE_SUBTYPE;
                case 1:
                    return GPRS;
                case 2:
                    return EDGE;
                case 3:
                    return UMTS;
                case 4:
                    return CDMA;
                case 5:
                    return EVDO_0;
                case 6:
                    return EVDO_A;
                case 7:
                    return RTT;
                case 8:
                    return HSDPA;
                case 9:
                    return HSUPA;
                case 10:
                    return HSPA;
                case 11:
                    return IDEN;
                case 12:
                    return EVDO_B;
                case 13:
                    return LTE;
                case 14:
                    return EHRPD;
                case 15:
                    return HSPAP;
                case 16:
                    return GSM;
                case 17:
                    return TD_SCDMA;
                case 18:
                    return IWLAN;
                case 19:
                    return LTE_CA;
                default:
                    return null;
            }
        }

        public static s05.d<MobileSubtype> internalGetValueMap() {
            return internalValueMap;
        }

        public static s05.e internalGetVerifier() {
            return MobileSubtypeVerifier.INSTANCE;
        }

        @Override // defpackage.s05.c
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static MobileSubtype valueOf(int i) {
            return forNumber(i);
        }
    }

    public enum NetworkType implements s05.c {
        NONE(-1),
        MOBILE(0),
        WIFI(1),
        MOBILE_MMS(2),
        MOBILE_SUPL(3),
        MOBILE_DUN(4),
        MOBILE_HIPRI(5),
        WIMAX(6),
        BLUETOOTH(7),
        DUMMY(8),
        ETHERNET(9),
        MOBILE_FOTA(10),
        MOBILE_IMS(11),
        MOBILE_CBS(12),
        WIFI_P2P(13),
        MOBILE_IA(14),
        MOBILE_EMERGENCY(15),
        PROXY(16),
        VPN(17);
        
        public static final int BLUETOOTH_VALUE = 7;
        public static final int DUMMY_VALUE = 8;
        public static final int ETHERNET_VALUE = 9;
        public static final int MOBILE_CBS_VALUE = 12;
        public static final int MOBILE_DUN_VALUE = 4;
        public static final int MOBILE_EMERGENCY_VALUE = 15;
        public static final int MOBILE_FOTA_VALUE = 10;
        public static final int MOBILE_HIPRI_VALUE = 5;
        public static final int MOBILE_IA_VALUE = 14;
        public static final int MOBILE_IMS_VALUE = 11;
        public static final int MOBILE_MMS_VALUE = 2;
        public static final int MOBILE_SUPL_VALUE = 3;
        public static final int MOBILE_VALUE = 0;
        public static final int NONE_VALUE = -1;
        public static final int PROXY_VALUE = 16;
        public static final int VPN_VALUE = 17;
        public static final int WIFI_P2P_VALUE = 13;
        public static final int WIFI_VALUE = 1;
        public static final int WIMAX_VALUE = 6;
        private static final s05.d<NetworkType> internalValueMap = new s05.d<NetworkType>() {
            /* class com.google.firebase.perf.v1.NetworkConnectionInfo.NetworkType.AnonymousClass1 */

            @Override // defpackage.s05.d
            public NetworkType findValueByNumber(int i) {
                return NetworkType.forNumber(i);
            }
        };
        private final int value;

        public static final class NetworkTypeVerifier implements s05.e {
            public static final s05.e INSTANCE = new NetworkTypeVerifier();

            private NetworkTypeVerifier() {
            }

            @Override // defpackage.s05.e
            public boolean isInRange(int i) {
                return NetworkType.forNumber(i) != null;
            }
        }

        private NetworkType(int i) {
            this.value = i;
        }

        public static NetworkType forNumber(int i) {
            switch (i) {
                case -1:
                    return NONE;
                case 0:
                    return MOBILE;
                case 1:
                    return WIFI;
                case 2:
                    return MOBILE_MMS;
                case 3:
                    return MOBILE_SUPL;
                case 4:
                    return MOBILE_DUN;
                case 5:
                    return MOBILE_HIPRI;
                case 6:
                    return WIMAX;
                case 7:
                    return BLUETOOTH;
                case 8:
                    return DUMMY;
                case 9:
                    return ETHERNET;
                case 10:
                    return MOBILE_FOTA;
                case 11:
                    return MOBILE_IMS;
                case 12:
                    return MOBILE_CBS;
                case 13:
                    return WIFI_P2P;
                case 14:
                    return MOBILE_IA;
                case 15:
                    return MOBILE_EMERGENCY;
                case 16:
                    return PROXY;
                case 17:
                    return VPN;
                default:
                    return null;
            }
        }

        public static s05.d<NetworkType> internalGetValueMap() {
            return internalValueMap;
        }

        public static s05.e internalGetVerifier() {
            return NetworkTypeVerifier.INSTANCE;
        }

        @Override // defpackage.s05.c
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static NetworkType valueOf(int i) {
            return forNumber(i);
        }
    }

    static {
        NetworkConnectionInfo networkConnectionInfo = new NetworkConnectionInfo();
        DEFAULT_INSTANCE = networkConnectionInfo;
        q05.registerDefaultInstance(NetworkConnectionInfo.class, networkConnectionInfo);
    }

    private NetworkConnectionInfo() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearMobileSubtype() {
        this.bitField0_ &= -3;
        this.mobileSubtype_ = 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearNetworkType() {
        this.bitField0_ &= -2;
        this.networkType_ = -1;
    }

    public static NetworkConnectionInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static NetworkConnectionInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (NetworkConnectionInfo) q05.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NetworkConnectionInfo parseFrom(ByteBuffer byteBuffer) throws t05 {
        return (NetworkConnectionInfo) q05.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static q15<NetworkConnectionInfo> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setMobileSubtype(MobileSubtype mobileSubtype) {
        this.mobileSubtype_ = mobileSubtype.getNumber();
        this.bitField0_ |= 2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setNetworkType(NetworkType networkType) {
        this.networkType_ = networkType.getNumber();
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
                return q05.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0000\u0002\f\u0001", new Object[]{"bitField0_", "networkType_", NetworkType.internalGetVerifier(), "mobileSubtype_", MobileSubtype.internalGetVerifier()});
            case 3:
                return new NetworkConnectionInfo();
            case 4:
                return new Builder(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                q15<NetworkConnectionInfo> q15 = PARSER;
                if (q15 == null) {
                    synchronized (NetworkConnectionInfo.class) {
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

    @Override // com.google.firebase.perf.v1.NetworkConnectionInfoOrBuilder
    public MobileSubtype getMobileSubtype() {
        MobileSubtype forNumber = MobileSubtype.forNumber(this.mobileSubtype_);
        return forNumber == null ? MobileSubtype.UNKNOWN_MOBILE_SUBTYPE : forNumber;
    }

    @Override // com.google.firebase.perf.v1.NetworkConnectionInfoOrBuilder
    public NetworkType getNetworkType() {
        NetworkType forNumber = NetworkType.forNumber(this.networkType_);
        return forNumber == null ? NetworkType.NONE : forNumber;
    }

    @Override // com.google.firebase.perf.v1.NetworkConnectionInfoOrBuilder
    public boolean hasMobileSubtype() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // com.google.firebase.perf.v1.NetworkConnectionInfoOrBuilder
    public boolean hasNetworkType() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(NetworkConnectionInfo networkConnectionInfo) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(networkConnectionInfo);
    }

    public static NetworkConnectionInfo parseDelimitedFrom(InputStream inputStream, i05 i05) throws IOException {
        return (NetworkConnectionInfo) q05.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, i05);
    }

    public static NetworkConnectionInfo parseFrom(ByteBuffer byteBuffer, i05 i05) throws t05 {
        return (NetworkConnectionInfo) q05.parseFrom(DEFAULT_INSTANCE, byteBuffer, i05);
    }

    public static NetworkConnectionInfo parseFrom(a05 a05) throws t05 {
        return (NetworkConnectionInfo) q05.parseFrom(DEFAULT_INSTANCE, a05);
    }

    public static NetworkConnectionInfo parseFrom(a05 a05, i05 i05) throws t05 {
        return (NetworkConnectionInfo) q05.parseFrom(DEFAULT_INSTANCE, a05, i05);
    }

    public static NetworkConnectionInfo parseFrom(byte[] bArr) throws t05 {
        return (NetworkConnectionInfo) q05.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static NetworkConnectionInfo parseFrom(byte[] bArr, i05 i05) throws t05 {
        return (NetworkConnectionInfo) q05.parseFrom(DEFAULT_INSTANCE, bArr, i05);
    }

    public static NetworkConnectionInfo parseFrom(InputStream inputStream) throws IOException {
        return (NetworkConnectionInfo) q05.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NetworkConnectionInfo parseFrom(InputStream inputStream, i05 i05) throws IOException {
        return (NetworkConnectionInfo) q05.parseFrom(DEFAULT_INSTANCE, inputStream, i05);
    }

    public static NetworkConnectionInfo parseFrom(b05 b05) throws IOException {
        return (NetworkConnectionInfo) q05.parseFrom(DEFAULT_INSTANCE, b05);
    }

    public static NetworkConnectionInfo parseFrom(b05 b05, i05 i05) throws IOException {
        return (NetworkConnectionInfo) q05.parseFrom(DEFAULT_INSTANCE, b05, i05);
    }
}
