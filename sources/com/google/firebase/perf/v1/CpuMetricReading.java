package com.google.firebase.perf.v1;

import defpackage.q05;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class CpuMetricReading extends q05<CpuMetricReading, Builder> implements CpuMetricReadingOrBuilder {
    public static final int CLIENT_TIME_US_FIELD_NUMBER = 1;
    private static final CpuMetricReading DEFAULT_INSTANCE;
    private static volatile q15<CpuMetricReading> PARSER = null;
    public static final int SYSTEM_TIME_US_FIELD_NUMBER = 3;
    public static final int USER_TIME_US_FIELD_NUMBER = 2;
    private int bitField0_;
    private long clientTimeUs_;
    private long systemTimeUs_;
    private long userTimeUs_;

    /* renamed from: com.google.firebase.perf.v1.CpuMetricReading$1  reason: invalid class name */
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
                com.google.firebase.perf.v1.CpuMetricReading.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = r1
                r2 = 1
                r3 = 3
                q05$f r4 = defpackage.q05.f.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x000e }
                r1[r3] = r2     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                r1 = 2
                r4 = 4
                int[] r5 = com.google.firebase.perf.v1.CpuMetricReading.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0016 }
                q05$f r6 = defpackage.q05.f.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x0016 }
                r5[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                int[] r5 = com.google.firebase.perf.v1.CpuMetricReading.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x001c }
                q05$f r6 = defpackage.q05.f.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x001c }
                r5[r1] = r3     // Catch:{ NoSuchFieldError -> 0x001c }
            L_0x001c:
                r1 = 5
                int[] r3 = com.google.firebase.perf.v1.CpuMetricReading.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0023 }
                q05$f r5 = defpackage.q05.f.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0023 }
                r3[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0023 }
            L_0x0023:
                r3 = 6
                int[] r4 = com.google.firebase.perf.v1.CpuMetricReading.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x002a }
                q05$f r5 = defpackage.q05.f.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x002a }
                r4[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r1 = com.google.firebase.perf.v1.CpuMetricReading.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0031 }
                q05$f r4 = defpackage.q05.f.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0031 }
                r4 = 0
                r1[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0031 }
            L_0x0031:
                int[] r1 = com.google.firebase.perf.v1.CpuMetricReading.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0037 }
                q05$f r3 = defpackage.q05.f.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0037 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0037 }
            L_0x0037:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.v1.CpuMetricReading.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class Builder extends q05.a<CpuMetricReading, Builder> implements CpuMetricReadingOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        public Builder clearClientTimeUs() {
            copyOnWrite();
            ((CpuMetricReading) this.instance).clearClientTimeUs();
            return this;
        }

        public Builder clearSystemTimeUs() {
            copyOnWrite();
            ((CpuMetricReading) this.instance).clearSystemTimeUs();
            return this;
        }

        public Builder clearUserTimeUs() {
            copyOnWrite();
            ((CpuMetricReading) this.instance).clearUserTimeUs();
            return this;
        }

        @Override // com.google.firebase.perf.v1.CpuMetricReadingOrBuilder
        public long getClientTimeUs() {
            return ((CpuMetricReading) this.instance).getClientTimeUs();
        }

        @Override // com.google.firebase.perf.v1.CpuMetricReadingOrBuilder
        public long getSystemTimeUs() {
            return ((CpuMetricReading) this.instance).getSystemTimeUs();
        }

        @Override // com.google.firebase.perf.v1.CpuMetricReadingOrBuilder
        public long getUserTimeUs() {
            return ((CpuMetricReading) this.instance).getUserTimeUs();
        }

        @Override // com.google.firebase.perf.v1.CpuMetricReadingOrBuilder
        public boolean hasClientTimeUs() {
            return ((CpuMetricReading) this.instance).hasClientTimeUs();
        }

        @Override // com.google.firebase.perf.v1.CpuMetricReadingOrBuilder
        public boolean hasSystemTimeUs() {
            return ((CpuMetricReading) this.instance).hasSystemTimeUs();
        }

        @Override // com.google.firebase.perf.v1.CpuMetricReadingOrBuilder
        public boolean hasUserTimeUs() {
            return ((CpuMetricReading) this.instance).hasUserTimeUs();
        }

        public Builder setClientTimeUs(long j) {
            copyOnWrite();
            ((CpuMetricReading) this.instance).setClientTimeUs(j);
            return this;
        }

        public Builder setSystemTimeUs(long j) {
            copyOnWrite();
            ((CpuMetricReading) this.instance).setSystemTimeUs(j);
            return this;
        }

        public Builder setUserTimeUs(long j) {
            copyOnWrite();
            ((CpuMetricReading) this.instance).setUserTimeUs(j);
            return this;
        }

        private Builder() {
            super(CpuMetricReading.DEFAULT_INSTANCE);
        }
    }

    static {
        CpuMetricReading cpuMetricReading = new CpuMetricReading();
        DEFAULT_INSTANCE = cpuMetricReading;
        q05.registerDefaultInstance(CpuMetricReading.class, cpuMetricReading);
    }

    private CpuMetricReading() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearClientTimeUs() {
        this.bitField0_ &= -2;
        this.clientTimeUs_ = 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearSystemTimeUs() {
        this.bitField0_ &= -5;
        this.systemTimeUs_ = 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearUserTimeUs() {
        this.bitField0_ &= -3;
        this.userTimeUs_ = 0;
    }

    public static CpuMetricReading getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static CpuMetricReading parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (CpuMetricReading) q05.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CpuMetricReading parseFrom(ByteBuffer byteBuffer) throws t05 {
        return (CpuMetricReading) q05.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static q15<CpuMetricReading> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setClientTimeUs(long j) {
        this.bitField0_ |= 1;
        this.clientTimeUs_ = j;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setSystemTimeUs(long j) {
        this.bitField0_ |= 4;
        this.systemTimeUs_ = j;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setUserTimeUs(long j) {
        this.bitField0_ |= 2;
        this.userTimeUs_ = j;
    }

    @Override // defpackage.q05
    public final Object dynamicMethod(q05.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return q05.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0002\u0000\u0002\u0002\u0001\u0003\u0002\u0002", new Object[]{"bitField0_", "clientTimeUs_", "userTimeUs_", "systemTimeUs_"});
            case 3:
                return new CpuMetricReading();
            case 4:
                return new Builder(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                q15<CpuMetricReading> q15 = PARSER;
                if (q15 == null) {
                    synchronized (CpuMetricReading.class) {
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

    @Override // com.google.firebase.perf.v1.CpuMetricReadingOrBuilder
    public long getClientTimeUs() {
        return this.clientTimeUs_;
    }

    @Override // com.google.firebase.perf.v1.CpuMetricReadingOrBuilder
    public long getSystemTimeUs() {
        return this.systemTimeUs_;
    }

    @Override // com.google.firebase.perf.v1.CpuMetricReadingOrBuilder
    public long getUserTimeUs() {
        return this.userTimeUs_;
    }

    @Override // com.google.firebase.perf.v1.CpuMetricReadingOrBuilder
    public boolean hasClientTimeUs() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.google.firebase.perf.v1.CpuMetricReadingOrBuilder
    public boolean hasSystemTimeUs() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // com.google.firebase.perf.v1.CpuMetricReadingOrBuilder
    public boolean hasUserTimeUs() {
        return (this.bitField0_ & 2) != 0;
    }

    public static Builder newBuilder(CpuMetricReading cpuMetricReading) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(cpuMetricReading);
    }

    public static CpuMetricReading parseDelimitedFrom(InputStream inputStream, i05 i05) throws IOException {
        return (CpuMetricReading) q05.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, i05);
    }

    public static CpuMetricReading parseFrom(ByteBuffer byteBuffer, i05 i05) throws t05 {
        return (CpuMetricReading) q05.parseFrom(DEFAULT_INSTANCE, byteBuffer, i05);
    }

    public static CpuMetricReading parseFrom(a05 a05) throws t05 {
        return (CpuMetricReading) q05.parseFrom(DEFAULT_INSTANCE, a05);
    }

    public static CpuMetricReading parseFrom(a05 a05, i05 i05) throws t05 {
        return (CpuMetricReading) q05.parseFrom(DEFAULT_INSTANCE, a05, i05);
    }

    public static CpuMetricReading parseFrom(byte[] bArr) throws t05 {
        return (CpuMetricReading) q05.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static CpuMetricReading parseFrom(byte[] bArr, i05 i05) throws t05 {
        return (CpuMetricReading) q05.parseFrom(DEFAULT_INSTANCE, bArr, i05);
    }

    public static CpuMetricReading parseFrom(InputStream inputStream) throws IOException {
        return (CpuMetricReading) q05.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CpuMetricReading parseFrom(InputStream inputStream, i05 i05) throws IOException {
        return (CpuMetricReading) q05.parseFrom(DEFAULT_INSTANCE, inputStream, i05);
    }

    public static CpuMetricReading parseFrom(b05 b05) throws IOException {
        return (CpuMetricReading) q05.parseFrom(DEFAULT_INSTANCE, b05);
    }

    public static CpuMetricReading parseFrom(b05 b05, i05 i05) throws IOException {
        return (CpuMetricReading) q05.parseFrom(DEFAULT_INSTANCE, b05, i05);
    }
}
