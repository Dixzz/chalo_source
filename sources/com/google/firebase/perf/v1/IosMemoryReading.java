package com.google.firebase.perf.v1;

import defpackage.q05;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class IosMemoryReading extends q05<IosMemoryReading, Builder> implements IosMemoryReadingOrBuilder {
    public static final int CLIENT_TIME_US_FIELD_NUMBER = 1;
    private static final IosMemoryReading DEFAULT_INSTANCE;
    public static final int FREE_APP_HEAP_MEMORY_KB_FIELD_NUMBER = 3;
    private static volatile q15<IosMemoryReading> PARSER = null;
    public static final int USED_APP_HEAP_MEMORY_KB_FIELD_NUMBER = 2;
    private int bitField0_;
    private long clientTimeUs_;
    private int freeAppHeapMemoryKb_;
    private int usedAppHeapMemoryKb_;

    /* renamed from: com.google.firebase.perf.v1.IosMemoryReading$1  reason: invalid class name */
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
                com.google.firebase.perf.v1.IosMemoryReading.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = r1
                r2 = 1
                r3 = 3
                q05$f r4 = defpackage.q05.f.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x000e }
                r1[r3] = r2     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                r1 = 2
                r4 = 4
                int[] r5 = com.google.firebase.perf.v1.IosMemoryReading.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0016 }
                q05$f r6 = defpackage.q05.f.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x0016 }
                r5[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                int[] r5 = com.google.firebase.perf.v1.IosMemoryReading.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x001c }
                q05$f r6 = defpackage.q05.f.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x001c }
                r5[r1] = r3     // Catch:{ NoSuchFieldError -> 0x001c }
            L_0x001c:
                r1 = 5
                int[] r3 = com.google.firebase.perf.v1.IosMemoryReading.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0023 }
                q05$f r5 = defpackage.q05.f.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0023 }
                r3[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0023 }
            L_0x0023:
                r3 = 6
                int[] r4 = com.google.firebase.perf.v1.IosMemoryReading.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x002a }
                q05$f r5 = defpackage.q05.f.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x002a }
                r4[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r1 = com.google.firebase.perf.v1.IosMemoryReading.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0031 }
                q05$f r4 = defpackage.q05.f.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0031 }
                r4 = 0
                r1[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0031 }
            L_0x0031:
                int[] r1 = com.google.firebase.perf.v1.IosMemoryReading.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0037 }
                q05$f r3 = defpackage.q05.f.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0037 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0037 }
            L_0x0037:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.v1.IosMemoryReading.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class Builder extends q05.a<IosMemoryReading, Builder> implements IosMemoryReadingOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        public Builder clearClientTimeUs() {
            copyOnWrite();
            ((IosMemoryReading) this.instance).clearClientTimeUs();
            return this;
        }

        public Builder clearFreeAppHeapMemoryKb() {
            copyOnWrite();
            ((IosMemoryReading) this.instance).clearFreeAppHeapMemoryKb();
            return this;
        }

        public Builder clearUsedAppHeapMemoryKb() {
            copyOnWrite();
            ((IosMemoryReading) this.instance).clearUsedAppHeapMemoryKb();
            return this;
        }

        @Override // com.google.firebase.perf.v1.IosMemoryReadingOrBuilder
        public long getClientTimeUs() {
            return ((IosMemoryReading) this.instance).getClientTimeUs();
        }

        @Override // com.google.firebase.perf.v1.IosMemoryReadingOrBuilder
        public int getFreeAppHeapMemoryKb() {
            return ((IosMemoryReading) this.instance).getFreeAppHeapMemoryKb();
        }

        @Override // com.google.firebase.perf.v1.IosMemoryReadingOrBuilder
        public int getUsedAppHeapMemoryKb() {
            return ((IosMemoryReading) this.instance).getUsedAppHeapMemoryKb();
        }

        @Override // com.google.firebase.perf.v1.IosMemoryReadingOrBuilder
        public boolean hasClientTimeUs() {
            return ((IosMemoryReading) this.instance).hasClientTimeUs();
        }

        @Override // com.google.firebase.perf.v1.IosMemoryReadingOrBuilder
        public boolean hasFreeAppHeapMemoryKb() {
            return ((IosMemoryReading) this.instance).hasFreeAppHeapMemoryKb();
        }

        @Override // com.google.firebase.perf.v1.IosMemoryReadingOrBuilder
        public boolean hasUsedAppHeapMemoryKb() {
            return ((IosMemoryReading) this.instance).hasUsedAppHeapMemoryKb();
        }

        public Builder setClientTimeUs(long j) {
            copyOnWrite();
            ((IosMemoryReading) this.instance).setClientTimeUs(j);
            return this;
        }

        public Builder setFreeAppHeapMemoryKb(int i) {
            copyOnWrite();
            ((IosMemoryReading) this.instance).setFreeAppHeapMemoryKb(i);
            return this;
        }

        public Builder setUsedAppHeapMemoryKb(int i) {
            copyOnWrite();
            ((IosMemoryReading) this.instance).setUsedAppHeapMemoryKb(i);
            return this;
        }

        private Builder() {
            super(IosMemoryReading.DEFAULT_INSTANCE);
        }
    }

    static {
        IosMemoryReading iosMemoryReading = new IosMemoryReading();
        DEFAULT_INSTANCE = iosMemoryReading;
        q05.registerDefaultInstance(IosMemoryReading.class, iosMemoryReading);
    }

    private IosMemoryReading() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearClientTimeUs() {
        this.bitField0_ &= -2;
        this.clientTimeUs_ = 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearFreeAppHeapMemoryKb() {
        this.bitField0_ &= -5;
        this.freeAppHeapMemoryKb_ = 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearUsedAppHeapMemoryKb() {
        this.bitField0_ &= -3;
        this.usedAppHeapMemoryKb_ = 0;
    }

    public static IosMemoryReading getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static IosMemoryReading parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (IosMemoryReading) q05.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static IosMemoryReading parseFrom(ByteBuffer byteBuffer) throws t05 {
        return (IosMemoryReading) q05.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static q15<IosMemoryReading> parser() {
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
    private void setFreeAppHeapMemoryKb(int i) {
        this.bitField0_ |= 4;
        this.freeAppHeapMemoryKb_ = i;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setUsedAppHeapMemoryKb(int i) {
        this.bitField0_ |= 2;
        this.usedAppHeapMemoryKb_ = i;
    }

    @Override // defpackage.q05
    public final Object dynamicMethod(q05.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return q05.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0002\u0000\u0002\u0004\u0001\u0003\u0004\u0002", new Object[]{"bitField0_", "clientTimeUs_", "usedAppHeapMemoryKb_", "freeAppHeapMemoryKb_"});
            case 3:
                return new IosMemoryReading();
            case 4:
                return new Builder(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                q15<IosMemoryReading> q15 = PARSER;
                if (q15 == null) {
                    synchronized (IosMemoryReading.class) {
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

    @Override // com.google.firebase.perf.v1.IosMemoryReadingOrBuilder
    public long getClientTimeUs() {
        return this.clientTimeUs_;
    }

    @Override // com.google.firebase.perf.v1.IosMemoryReadingOrBuilder
    public int getFreeAppHeapMemoryKb() {
        return this.freeAppHeapMemoryKb_;
    }

    @Override // com.google.firebase.perf.v1.IosMemoryReadingOrBuilder
    public int getUsedAppHeapMemoryKb() {
        return this.usedAppHeapMemoryKb_;
    }

    @Override // com.google.firebase.perf.v1.IosMemoryReadingOrBuilder
    public boolean hasClientTimeUs() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.google.firebase.perf.v1.IosMemoryReadingOrBuilder
    public boolean hasFreeAppHeapMemoryKb() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // com.google.firebase.perf.v1.IosMemoryReadingOrBuilder
    public boolean hasUsedAppHeapMemoryKb() {
        return (this.bitField0_ & 2) != 0;
    }

    public static Builder newBuilder(IosMemoryReading iosMemoryReading) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(iosMemoryReading);
    }

    public static IosMemoryReading parseDelimitedFrom(InputStream inputStream, i05 i05) throws IOException {
        return (IosMemoryReading) q05.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, i05);
    }

    public static IosMemoryReading parseFrom(ByteBuffer byteBuffer, i05 i05) throws t05 {
        return (IosMemoryReading) q05.parseFrom(DEFAULT_INSTANCE, byteBuffer, i05);
    }

    public static IosMemoryReading parseFrom(a05 a05) throws t05 {
        return (IosMemoryReading) q05.parseFrom(DEFAULT_INSTANCE, a05);
    }

    public static IosMemoryReading parseFrom(a05 a05, i05 i05) throws t05 {
        return (IosMemoryReading) q05.parseFrom(DEFAULT_INSTANCE, a05, i05);
    }

    public static IosMemoryReading parseFrom(byte[] bArr) throws t05 {
        return (IosMemoryReading) q05.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static IosMemoryReading parseFrom(byte[] bArr, i05 i05) throws t05 {
        return (IosMemoryReading) q05.parseFrom(DEFAULT_INSTANCE, bArr, i05);
    }

    public static IosMemoryReading parseFrom(InputStream inputStream) throws IOException {
        return (IosMemoryReading) q05.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static IosMemoryReading parseFrom(InputStream inputStream, i05 i05) throws IOException {
        return (IosMemoryReading) q05.parseFrom(DEFAULT_INSTANCE, inputStream, i05);
    }

    public static IosMemoryReading parseFrom(b05 b05) throws IOException {
        return (IosMemoryReading) q05.parseFrom(DEFAULT_INSTANCE, b05);
    }

    public static IosMemoryReading parseFrom(b05 b05, i05 i05) throws IOException {
        return (IosMemoryReading) q05.parseFrom(DEFAULT_INSTANCE, b05, i05);
    }
}
