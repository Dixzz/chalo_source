package com.google.firebase.perf.v1;

import defpackage.q05;
import defpackage.s05;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class TransportInfo extends q05<TransportInfo, Builder> implements TransportInfoOrBuilder {
    private static final TransportInfo DEFAULT_INSTANCE;
    public static final int DISPATCH_DESTINATION_FIELD_NUMBER = 1;
    private static volatile q15<TransportInfo> PARSER;
    private int bitField0_;
    private int dispatchDestination_;

    /* renamed from: com.google.firebase.perf.v1.TransportInfo$1  reason: invalid class name */
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
                com.google.firebase.perf.v1.TransportInfo.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = r1
                r2 = 1
                r3 = 3
                q05$f r4 = defpackage.q05.f.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x000e }
                r1[r3] = r2     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                r1 = 2
                r4 = 4
                int[] r5 = com.google.firebase.perf.v1.TransportInfo.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0016 }
                q05$f r6 = defpackage.q05.f.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x0016 }
                r5[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                int[] r5 = com.google.firebase.perf.v1.TransportInfo.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x001c }
                q05$f r6 = defpackage.q05.f.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x001c }
                r5[r1] = r3     // Catch:{ NoSuchFieldError -> 0x001c }
            L_0x001c:
                r1 = 5
                int[] r3 = com.google.firebase.perf.v1.TransportInfo.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0023 }
                q05$f r5 = defpackage.q05.f.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0023 }
                r3[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0023 }
            L_0x0023:
                r3 = 6
                int[] r4 = com.google.firebase.perf.v1.TransportInfo.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x002a }
                q05$f r5 = defpackage.q05.f.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x002a }
                r4[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r1 = com.google.firebase.perf.v1.TransportInfo.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0031 }
                q05$f r4 = defpackage.q05.f.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0031 }
                r4 = 0
                r1[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0031 }
            L_0x0031:
                int[] r1 = com.google.firebase.perf.v1.TransportInfo.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0037 }
                q05$f r3 = defpackage.q05.f.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0037 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0037 }
            L_0x0037:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.v1.TransportInfo.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class Builder extends q05.a<TransportInfo, Builder> implements TransportInfoOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        public Builder clearDispatchDestination() {
            copyOnWrite();
            ((TransportInfo) this.instance).clearDispatchDestination();
            return this;
        }

        @Override // com.google.firebase.perf.v1.TransportInfoOrBuilder
        public DispatchDestination getDispatchDestination() {
            return ((TransportInfo) this.instance).getDispatchDestination();
        }

        @Override // com.google.firebase.perf.v1.TransportInfoOrBuilder
        public boolean hasDispatchDestination() {
            return ((TransportInfo) this.instance).hasDispatchDestination();
        }

        public Builder setDispatchDestination(DispatchDestination dispatchDestination) {
            copyOnWrite();
            ((TransportInfo) this.instance).setDispatchDestination(dispatchDestination);
            return this;
        }

        private Builder() {
            super(TransportInfo.DEFAULT_INSTANCE);
        }
    }

    public enum DispatchDestination implements s05.c {
        SOURCE_UNKNOWN(0),
        FL_LEGACY_V1(1);
        
        public static final int FL_LEGACY_V1_VALUE = 1;
        public static final int SOURCE_UNKNOWN_VALUE = 0;
        private static final s05.d<DispatchDestination> internalValueMap = new s05.d<DispatchDestination>() {
            /* class com.google.firebase.perf.v1.TransportInfo.DispatchDestination.AnonymousClass1 */

            @Override // defpackage.s05.d
            public DispatchDestination findValueByNumber(int i) {
                return DispatchDestination.forNumber(i);
            }
        };
        private final int value;

        public static final class DispatchDestinationVerifier implements s05.e {
            public static final s05.e INSTANCE = new DispatchDestinationVerifier();

            private DispatchDestinationVerifier() {
            }

            @Override // defpackage.s05.e
            public boolean isInRange(int i) {
                return DispatchDestination.forNumber(i) != null;
            }
        }

        private DispatchDestination(int i) {
            this.value = i;
        }

        public static DispatchDestination forNumber(int i) {
            if (i == 0) {
                return SOURCE_UNKNOWN;
            }
            if (i != 1) {
                return null;
            }
            return FL_LEGACY_V1;
        }

        public static s05.d<DispatchDestination> internalGetValueMap() {
            return internalValueMap;
        }

        public static s05.e internalGetVerifier() {
            return DispatchDestinationVerifier.INSTANCE;
        }

        @Override // defpackage.s05.c
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static DispatchDestination valueOf(int i) {
            return forNumber(i);
        }
    }

    static {
        TransportInfo transportInfo = new TransportInfo();
        DEFAULT_INSTANCE = transportInfo;
        q05.registerDefaultInstance(TransportInfo.class, transportInfo);
    }

    private TransportInfo() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearDispatchDestination() {
        this.bitField0_ &= -2;
        this.dispatchDestination_ = 0;
    }

    public static TransportInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static TransportInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (TransportInfo) q05.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TransportInfo parseFrom(ByteBuffer byteBuffer) throws t05 {
        return (TransportInfo) q05.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static q15<TransportInfo> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setDispatchDestination(DispatchDestination dispatchDestination) {
        this.dispatchDestination_ = dispatchDestination.getNumber();
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
                return q05.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f\u0000", new Object[]{"bitField0_", "dispatchDestination_", DispatchDestination.internalGetVerifier()});
            case 3:
                return new TransportInfo();
            case 4:
                return new Builder(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                q15<TransportInfo> q15 = PARSER;
                if (q15 == null) {
                    synchronized (TransportInfo.class) {
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

    @Override // com.google.firebase.perf.v1.TransportInfoOrBuilder
    public DispatchDestination getDispatchDestination() {
        DispatchDestination forNumber = DispatchDestination.forNumber(this.dispatchDestination_);
        return forNumber == null ? DispatchDestination.SOURCE_UNKNOWN : forNumber;
    }

    @Override // com.google.firebase.perf.v1.TransportInfoOrBuilder
    public boolean hasDispatchDestination() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(TransportInfo transportInfo) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(transportInfo);
    }

    public static TransportInfo parseDelimitedFrom(InputStream inputStream, i05 i05) throws IOException {
        return (TransportInfo) q05.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, i05);
    }

    public static TransportInfo parseFrom(ByteBuffer byteBuffer, i05 i05) throws t05 {
        return (TransportInfo) q05.parseFrom(DEFAULT_INSTANCE, byteBuffer, i05);
    }

    public static TransportInfo parseFrom(a05 a05) throws t05 {
        return (TransportInfo) q05.parseFrom(DEFAULT_INSTANCE, a05);
    }

    public static TransportInfo parseFrom(a05 a05, i05 i05) throws t05 {
        return (TransportInfo) q05.parseFrom(DEFAULT_INSTANCE, a05, i05);
    }

    public static TransportInfo parseFrom(byte[] bArr) throws t05 {
        return (TransportInfo) q05.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static TransportInfo parseFrom(byte[] bArr, i05 i05) throws t05 {
        return (TransportInfo) q05.parseFrom(DEFAULT_INSTANCE, bArr, i05);
    }

    public static TransportInfo parseFrom(InputStream inputStream) throws IOException {
        return (TransportInfo) q05.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TransportInfo parseFrom(InputStream inputStream, i05 i05) throws IOException {
        return (TransportInfo) q05.parseFrom(DEFAULT_INSTANCE, inputStream, i05);
    }

    public static TransportInfo parseFrom(b05 b05) throws IOException {
        return (TransportInfo) q05.parseFrom(DEFAULT_INSTANCE, b05);
    }

    public static TransportInfo parseFrom(b05 b05, i05 i05) throws IOException {
        return (TransportInfo) q05.parseFrom(DEFAULT_INSTANCE, b05, i05);
    }
}
