package com.google.firebase.perf.v1;

import defpackage.q05;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class GaugeMetadata extends q05<GaugeMetadata, Builder> implements GaugeMetadataOrBuilder {
    public static final int CPU_CLOCK_RATE_KHZ_FIELD_NUMBER = 2;
    public static final int CPU_PROCESSOR_COUNT_FIELD_NUMBER = 6;
    private static final GaugeMetadata DEFAULT_INSTANCE;
    public static final int DEVICE_RAM_SIZE_KB_FIELD_NUMBER = 3;
    public static final int MAX_APP_JAVA_HEAP_MEMORY_KB_FIELD_NUMBER = 4;
    public static final int MAX_ENCOURAGED_APP_JAVA_HEAP_MEMORY_KB_FIELD_NUMBER = 5;
    private static volatile q15<GaugeMetadata> PARSER = null;
    public static final int PROCESS_NAME_FIELD_NUMBER = 1;
    private int bitField0_;
    private int cpuClockRateKhz_;
    private int cpuProcessorCount_;
    private int deviceRamSizeKb_;
    private int maxAppJavaHeapMemoryKb_;
    private int maxEncouragedAppJavaHeapMemoryKb_;
    private String processName_ = "";

    /* renamed from: com.google.firebase.perf.v1.GaugeMetadata$1  reason: invalid class name */
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
                com.google.firebase.perf.v1.GaugeMetadata.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = r1
                r2 = 1
                r3 = 3
                q05$f r4 = defpackage.q05.f.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x000e }
                r1[r3] = r2     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                r1 = 2
                r4 = 4
                int[] r5 = com.google.firebase.perf.v1.GaugeMetadata.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0016 }
                q05$f r6 = defpackage.q05.f.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x0016 }
                r5[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                int[] r5 = com.google.firebase.perf.v1.GaugeMetadata.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x001c }
                q05$f r6 = defpackage.q05.f.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x001c }
                r5[r1] = r3     // Catch:{ NoSuchFieldError -> 0x001c }
            L_0x001c:
                r1 = 5
                int[] r3 = com.google.firebase.perf.v1.GaugeMetadata.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0023 }
                q05$f r5 = defpackage.q05.f.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0023 }
                r3[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0023 }
            L_0x0023:
                r3 = 6
                int[] r4 = com.google.firebase.perf.v1.GaugeMetadata.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x002a }
                q05$f r5 = defpackage.q05.f.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x002a }
                r4[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r1 = com.google.firebase.perf.v1.GaugeMetadata.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0031 }
                q05$f r4 = defpackage.q05.f.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0031 }
                r4 = 0
                r1[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0031 }
            L_0x0031:
                int[] r1 = com.google.firebase.perf.v1.GaugeMetadata.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0037 }
                q05$f r3 = defpackage.q05.f.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0037 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0037 }
            L_0x0037:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.v1.GaugeMetadata.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class Builder extends q05.a<GaugeMetadata, Builder> implements GaugeMetadataOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        public Builder clearCpuClockRateKhz() {
            copyOnWrite();
            ((GaugeMetadata) this.instance).clearCpuClockRateKhz();
            return this;
        }

        public Builder clearCpuProcessorCount() {
            copyOnWrite();
            ((GaugeMetadata) this.instance).clearCpuProcessorCount();
            return this;
        }

        public Builder clearDeviceRamSizeKb() {
            copyOnWrite();
            ((GaugeMetadata) this.instance).clearDeviceRamSizeKb();
            return this;
        }

        public Builder clearMaxAppJavaHeapMemoryKb() {
            copyOnWrite();
            ((GaugeMetadata) this.instance).clearMaxAppJavaHeapMemoryKb();
            return this;
        }

        public Builder clearMaxEncouragedAppJavaHeapMemoryKb() {
            copyOnWrite();
            ((GaugeMetadata) this.instance).clearMaxEncouragedAppJavaHeapMemoryKb();
            return this;
        }

        public Builder clearProcessName() {
            copyOnWrite();
            ((GaugeMetadata) this.instance).clearProcessName();
            return this;
        }

        @Override // com.google.firebase.perf.v1.GaugeMetadataOrBuilder
        public int getCpuClockRateKhz() {
            return ((GaugeMetadata) this.instance).getCpuClockRateKhz();
        }

        @Override // com.google.firebase.perf.v1.GaugeMetadataOrBuilder
        public int getCpuProcessorCount() {
            return ((GaugeMetadata) this.instance).getCpuProcessorCount();
        }

        @Override // com.google.firebase.perf.v1.GaugeMetadataOrBuilder
        public int getDeviceRamSizeKb() {
            return ((GaugeMetadata) this.instance).getDeviceRamSizeKb();
        }

        @Override // com.google.firebase.perf.v1.GaugeMetadataOrBuilder
        public int getMaxAppJavaHeapMemoryKb() {
            return ((GaugeMetadata) this.instance).getMaxAppJavaHeapMemoryKb();
        }

        @Override // com.google.firebase.perf.v1.GaugeMetadataOrBuilder
        public int getMaxEncouragedAppJavaHeapMemoryKb() {
            return ((GaugeMetadata) this.instance).getMaxEncouragedAppJavaHeapMemoryKb();
        }

        @Override // com.google.firebase.perf.v1.GaugeMetadataOrBuilder
        public String getProcessName() {
            return ((GaugeMetadata) this.instance).getProcessName();
        }

        @Override // com.google.firebase.perf.v1.GaugeMetadataOrBuilder
        public a05 getProcessNameBytes() {
            return ((GaugeMetadata) this.instance).getProcessNameBytes();
        }

        @Override // com.google.firebase.perf.v1.GaugeMetadataOrBuilder
        public boolean hasCpuClockRateKhz() {
            return ((GaugeMetadata) this.instance).hasCpuClockRateKhz();
        }

        @Override // com.google.firebase.perf.v1.GaugeMetadataOrBuilder
        public boolean hasCpuProcessorCount() {
            return ((GaugeMetadata) this.instance).hasCpuProcessorCount();
        }

        @Override // com.google.firebase.perf.v1.GaugeMetadataOrBuilder
        public boolean hasDeviceRamSizeKb() {
            return ((GaugeMetadata) this.instance).hasDeviceRamSizeKb();
        }

        @Override // com.google.firebase.perf.v1.GaugeMetadataOrBuilder
        public boolean hasMaxAppJavaHeapMemoryKb() {
            return ((GaugeMetadata) this.instance).hasMaxAppJavaHeapMemoryKb();
        }

        @Override // com.google.firebase.perf.v1.GaugeMetadataOrBuilder
        public boolean hasMaxEncouragedAppJavaHeapMemoryKb() {
            return ((GaugeMetadata) this.instance).hasMaxEncouragedAppJavaHeapMemoryKb();
        }

        @Override // com.google.firebase.perf.v1.GaugeMetadataOrBuilder
        public boolean hasProcessName() {
            return ((GaugeMetadata) this.instance).hasProcessName();
        }

        public Builder setCpuClockRateKhz(int i) {
            copyOnWrite();
            ((GaugeMetadata) this.instance).setCpuClockRateKhz(i);
            return this;
        }

        public Builder setCpuProcessorCount(int i) {
            copyOnWrite();
            ((GaugeMetadata) this.instance).setCpuProcessorCount(i);
            return this;
        }

        public Builder setDeviceRamSizeKb(int i) {
            copyOnWrite();
            ((GaugeMetadata) this.instance).setDeviceRamSizeKb(i);
            return this;
        }

        public Builder setMaxAppJavaHeapMemoryKb(int i) {
            copyOnWrite();
            ((GaugeMetadata) this.instance).setMaxAppJavaHeapMemoryKb(i);
            return this;
        }

        public Builder setMaxEncouragedAppJavaHeapMemoryKb(int i) {
            copyOnWrite();
            ((GaugeMetadata) this.instance).setMaxEncouragedAppJavaHeapMemoryKb(i);
            return this;
        }

        public Builder setProcessName(String str) {
            copyOnWrite();
            ((GaugeMetadata) this.instance).setProcessName(str);
            return this;
        }

        public Builder setProcessNameBytes(a05 a05) {
            copyOnWrite();
            ((GaugeMetadata) this.instance).setProcessNameBytes(a05);
            return this;
        }

        private Builder() {
            super(GaugeMetadata.DEFAULT_INSTANCE);
        }
    }

    static {
        GaugeMetadata gaugeMetadata = new GaugeMetadata();
        DEFAULT_INSTANCE = gaugeMetadata;
        q05.registerDefaultInstance(GaugeMetadata.class, gaugeMetadata);
    }

    private GaugeMetadata() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearCpuClockRateKhz() {
        this.bitField0_ &= -3;
        this.cpuClockRateKhz_ = 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearCpuProcessorCount() {
        this.bitField0_ &= -5;
        this.cpuProcessorCount_ = 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearDeviceRamSizeKb() {
        this.bitField0_ &= -9;
        this.deviceRamSizeKb_ = 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearMaxAppJavaHeapMemoryKb() {
        this.bitField0_ &= -17;
        this.maxAppJavaHeapMemoryKb_ = 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearMaxEncouragedAppJavaHeapMemoryKb() {
        this.bitField0_ &= -33;
        this.maxEncouragedAppJavaHeapMemoryKb_ = 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearProcessName() {
        this.bitField0_ &= -2;
        this.processName_ = getDefaultInstance().getProcessName();
    }

    public static GaugeMetadata getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static GaugeMetadata parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (GaugeMetadata) q05.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GaugeMetadata parseFrom(ByteBuffer byteBuffer) throws t05 {
        return (GaugeMetadata) q05.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static q15<GaugeMetadata> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setCpuClockRateKhz(int i) {
        this.bitField0_ |= 2;
        this.cpuClockRateKhz_ = i;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setCpuProcessorCount(int i) {
        this.bitField0_ |= 4;
        this.cpuProcessorCount_ = i;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setDeviceRamSizeKb(int i) {
        this.bitField0_ |= 8;
        this.deviceRamSizeKb_ = i;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setMaxAppJavaHeapMemoryKb(int i) {
        this.bitField0_ |= 16;
        this.maxAppJavaHeapMemoryKb_ = i;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setMaxEncouragedAppJavaHeapMemoryKb(int i) {
        this.bitField0_ |= 32;
        this.maxEncouragedAppJavaHeapMemoryKb_ = i;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setProcessName(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.processName_ = str;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setProcessNameBytes(a05 a05) {
        this.processName_ = a05.B();
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
                return q05.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\b\u0000\u0002\u0004\u0001\u0003\u0004\u0003\u0004\u0004\u0004\u0005\u0004\u0005\u0006\u0004\u0002", new Object[]{"bitField0_", "processName_", "cpuClockRateKhz_", "deviceRamSizeKb_", "maxAppJavaHeapMemoryKb_", "maxEncouragedAppJavaHeapMemoryKb_", "cpuProcessorCount_"});
            case 3:
                return new GaugeMetadata();
            case 4:
                return new Builder(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                q15<GaugeMetadata> q15 = PARSER;
                if (q15 == null) {
                    synchronized (GaugeMetadata.class) {
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

    @Override // com.google.firebase.perf.v1.GaugeMetadataOrBuilder
    public int getCpuClockRateKhz() {
        return this.cpuClockRateKhz_;
    }

    @Override // com.google.firebase.perf.v1.GaugeMetadataOrBuilder
    public int getCpuProcessorCount() {
        return this.cpuProcessorCount_;
    }

    @Override // com.google.firebase.perf.v1.GaugeMetadataOrBuilder
    public int getDeviceRamSizeKb() {
        return this.deviceRamSizeKb_;
    }

    @Override // com.google.firebase.perf.v1.GaugeMetadataOrBuilder
    public int getMaxAppJavaHeapMemoryKb() {
        return this.maxAppJavaHeapMemoryKb_;
    }

    @Override // com.google.firebase.perf.v1.GaugeMetadataOrBuilder
    public int getMaxEncouragedAppJavaHeapMemoryKb() {
        return this.maxEncouragedAppJavaHeapMemoryKb_;
    }

    @Override // com.google.firebase.perf.v1.GaugeMetadataOrBuilder
    public String getProcessName() {
        return this.processName_;
    }

    @Override // com.google.firebase.perf.v1.GaugeMetadataOrBuilder
    public a05 getProcessNameBytes() {
        return a05.k(this.processName_);
    }

    @Override // com.google.firebase.perf.v1.GaugeMetadataOrBuilder
    public boolean hasCpuClockRateKhz() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // com.google.firebase.perf.v1.GaugeMetadataOrBuilder
    public boolean hasCpuProcessorCount() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // com.google.firebase.perf.v1.GaugeMetadataOrBuilder
    public boolean hasDeviceRamSizeKb() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // com.google.firebase.perf.v1.GaugeMetadataOrBuilder
    public boolean hasMaxAppJavaHeapMemoryKb() {
        return (this.bitField0_ & 16) != 0;
    }

    @Override // com.google.firebase.perf.v1.GaugeMetadataOrBuilder
    public boolean hasMaxEncouragedAppJavaHeapMemoryKb() {
        return (this.bitField0_ & 32) != 0;
    }

    @Override // com.google.firebase.perf.v1.GaugeMetadataOrBuilder
    public boolean hasProcessName() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(GaugeMetadata gaugeMetadata) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(gaugeMetadata);
    }

    public static GaugeMetadata parseDelimitedFrom(InputStream inputStream, i05 i05) throws IOException {
        return (GaugeMetadata) q05.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, i05);
    }

    public static GaugeMetadata parseFrom(ByteBuffer byteBuffer, i05 i05) throws t05 {
        return (GaugeMetadata) q05.parseFrom(DEFAULT_INSTANCE, byteBuffer, i05);
    }

    public static GaugeMetadata parseFrom(a05 a05) throws t05 {
        return (GaugeMetadata) q05.parseFrom(DEFAULT_INSTANCE, a05);
    }

    public static GaugeMetadata parseFrom(a05 a05, i05 i05) throws t05 {
        return (GaugeMetadata) q05.parseFrom(DEFAULT_INSTANCE, a05, i05);
    }

    public static GaugeMetadata parseFrom(byte[] bArr) throws t05 {
        return (GaugeMetadata) q05.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GaugeMetadata parseFrom(byte[] bArr, i05 i05) throws t05 {
        return (GaugeMetadata) q05.parseFrom(DEFAULT_INSTANCE, bArr, i05);
    }

    public static GaugeMetadata parseFrom(InputStream inputStream) throws IOException {
        return (GaugeMetadata) q05.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GaugeMetadata parseFrom(InputStream inputStream, i05 i05) throws IOException {
        return (GaugeMetadata) q05.parseFrom(DEFAULT_INSTANCE, inputStream, i05);
    }

    public static GaugeMetadata parseFrom(b05 b05) throws IOException {
        return (GaugeMetadata) q05.parseFrom(DEFAULT_INSTANCE, b05);
    }

    public static GaugeMetadata parseFrom(b05 b05, i05 i05) throws IOException {
        return (GaugeMetadata) q05.parseFrom(DEFAULT_INSTANCE, b05, i05);
    }
}
