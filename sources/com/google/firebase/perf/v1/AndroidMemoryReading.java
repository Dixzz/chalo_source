package com.google.firebase.perf.v1;

import defpackage.q05;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class AndroidMemoryReading extends q05<AndroidMemoryReading, Builder> implements AndroidMemoryReadingOrBuilder {
    public static final int CLIENT_TIME_US_FIELD_NUMBER = 1;
    private static final AndroidMemoryReading DEFAULT_INSTANCE;
    private static volatile q15<AndroidMemoryReading> PARSER = null;
    public static final int USED_APP_JAVA_HEAP_MEMORY_KB_FIELD_NUMBER = 2;
    private int bitField0_;
    private long clientTimeUs_;
    private int usedAppJavaHeapMemoryKb_;

    /* renamed from: com.google.firebase.perf.v1.AndroidMemoryReading$1  reason: invalid class name */
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
                com.google.firebase.perf.v1.AndroidMemoryReading.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = r1
                r2 = 1
                r3 = 3
                q05$f r4 = defpackage.q05.f.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x000e }
                r1[r3] = r2     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                r1 = 2
                r4 = 4
                int[] r5 = com.google.firebase.perf.v1.AndroidMemoryReading.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0016 }
                q05$f r6 = defpackage.q05.f.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x0016 }
                r5[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                int[] r5 = com.google.firebase.perf.v1.AndroidMemoryReading.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x001c }
                q05$f r6 = defpackage.q05.f.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x001c }
                r5[r1] = r3     // Catch:{ NoSuchFieldError -> 0x001c }
            L_0x001c:
                r1 = 5
                int[] r3 = com.google.firebase.perf.v1.AndroidMemoryReading.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0023 }
                q05$f r5 = defpackage.q05.f.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0023 }
                r3[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0023 }
            L_0x0023:
                r3 = 6
                int[] r4 = com.google.firebase.perf.v1.AndroidMemoryReading.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x002a }
                q05$f r5 = defpackage.q05.f.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x002a }
                r4[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r1 = com.google.firebase.perf.v1.AndroidMemoryReading.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0031 }
                q05$f r4 = defpackage.q05.f.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0031 }
                r4 = 0
                r1[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0031 }
            L_0x0031:
                int[] r1 = com.google.firebase.perf.v1.AndroidMemoryReading.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0037 }
                q05$f r3 = defpackage.q05.f.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0037 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0037 }
            L_0x0037:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.v1.AndroidMemoryReading.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class Builder extends q05.a<AndroidMemoryReading, Builder> implements AndroidMemoryReadingOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        public Builder clearClientTimeUs() {
            copyOnWrite();
            ((AndroidMemoryReading) this.instance).clearClientTimeUs();
            return this;
        }

        public Builder clearUsedAppJavaHeapMemoryKb() {
            copyOnWrite();
            ((AndroidMemoryReading) this.instance).clearUsedAppJavaHeapMemoryKb();
            return this;
        }

        @Override // com.google.firebase.perf.v1.AndroidMemoryReadingOrBuilder
        public long getClientTimeUs() {
            return ((AndroidMemoryReading) this.instance).getClientTimeUs();
        }

        @Override // com.google.firebase.perf.v1.AndroidMemoryReadingOrBuilder
        public int getUsedAppJavaHeapMemoryKb() {
            return ((AndroidMemoryReading) this.instance).getUsedAppJavaHeapMemoryKb();
        }

        @Override // com.google.firebase.perf.v1.AndroidMemoryReadingOrBuilder
        public boolean hasClientTimeUs() {
            return ((AndroidMemoryReading) this.instance).hasClientTimeUs();
        }

        @Override // com.google.firebase.perf.v1.AndroidMemoryReadingOrBuilder
        public boolean hasUsedAppJavaHeapMemoryKb() {
            return ((AndroidMemoryReading) this.instance).hasUsedAppJavaHeapMemoryKb();
        }

        public Builder setClientTimeUs(long j) {
            copyOnWrite();
            ((AndroidMemoryReading) this.instance).setClientTimeUs(j);
            return this;
        }

        public Builder setUsedAppJavaHeapMemoryKb(int i) {
            copyOnWrite();
            ((AndroidMemoryReading) this.instance).setUsedAppJavaHeapMemoryKb(i);
            return this;
        }

        private Builder() {
            super(AndroidMemoryReading.DEFAULT_INSTANCE);
        }
    }

    static {
        AndroidMemoryReading androidMemoryReading = new AndroidMemoryReading();
        DEFAULT_INSTANCE = androidMemoryReading;
        q05.registerDefaultInstance(AndroidMemoryReading.class, androidMemoryReading);
    }

    private AndroidMemoryReading() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearClientTimeUs() {
        this.bitField0_ &= -2;
        this.clientTimeUs_ = 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearUsedAppJavaHeapMemoryKb() {
        this.bitField0_ &= -3;
        this.usedAppJavaHeapMemoryKb_ = 0;
    }

    public static AndroidMemoryReading getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static AndroidMemoryReading parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (AndroidMemoryReading) q05.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AndroidMemoryReading parseFrom(ByteBuffer byteBuffer) throws t05 {
        return (AndroidMemoryReading) q05.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static q15<AndroidMemoryReading> parser() {
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
    private void setUsedAppJavaHeapMemoryKb(int i) {
        this.bitField0_ |= 2;
        this.usedAppJavaHeapMemoryKb_ = i;
    }

    @Override // defpackage.q05
    public final Object dynamicMethod(q05.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return q05.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0000\u0002\u0004\u0001", new Object[]{"bitField0_", "clientTimeUs_", "usedAppJavaHeapMemoryKb_"});
            case 3:
                return new AndroidMemoryReading();
            case 4:
                return new Builder(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                q15<AndroidMemoryReading> q15 = PARSER;
                if (q15 == null) {
                    synchronized (AndroidMemoryReading.class) {
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

    @Override // com.google.firebase.perf.v1.AndroidMemoryReadingOrBuilder
    public long getClientTimeUs() {
        return this.clientTimeUs_;
    }

    @Override // com.google.firebase.perf.v1.AndroidMemoryReadingOrBuilder
    public int getUsedAppJavaHeapMemoryKb() {
        return this.usedAppJavaHeapMemoryKb_;
    }

    @Override // com.google.firebase.perf.v1.AndroidMemoryReadingOrBuilder
    public boolean hasClientTimeUs() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.google.firebase.perf.v1.AndroidMemoryReadingOrBuilder
    public boolean hasUsedAppJavaHeapMemoryKb() {
        return (this.bitField0_ & 2) != 0;
    }

    public static Builder newBuilder(AndroidMemoryReading androidMemoryReading) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(androidMemoryReading);
    }

    public static AndroidMemoryReading parseDelimitedFrom(InputStream inputStream, i05 i05) throws IOException {
        return (AndroidMemoryReading) q05.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, i05);
    }

    public static AndroidMemoryReading parseFrom(ByteBuffer byteBuffer, i05 i05) throws t05 {
        return (AndroidMemoryReading) q05.parseFrom(DEFAULT_INSTANCE, byteBuffer, i05);
    }

    public static AndroidMemoryReading parseFrom(a05 a05) throws t05 {
        return (AndroidMemoryReading) q05.parseFrom(DEFAULT_INSTANCE, a05);
    }

    public static AndroidMemoryReading parseFrom(a05 a05, i05 i05) throws t05 {
        return (AndroidMemoryReading) q05.parseFrom(DEFAULT_INSTANCE, a05, i05);
    }

    public static AndroidMemoryReading parseFrom(byte[] bArr) throws t05 {
        return (AndroidMemoryReading) q05.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AndroidMemoryReading parseFrom(byte[] bArr, i05 i05) throws t05 {
        return (AndroidMemoryReading) q05.parseFrom(DEFAULT_INSTANCE, bArr, i05);
    }

    public static AndroidMemoryReading parseFrom(InputStream inputStream) throws IOException {
        return (AndroidMemoryReading) q05.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AndroidMemoryReading parseFrom(InputStream inputStream, i05 i05) throws IOException {
        return (AndroidMemoryReading) q05.parseFrom(DEFAULT_INSTANCE, inputStream, i05);
    }

    public static AndroidMemoryReading parseFrom(b05 b05) throws IOException {
        return (AndroidMemoryReading) q05.parseFrom(DEFAULT_INSTANCE, b05);
    }

    public static AndroidMemoryReading parseFrom(b05 b05, i05 i05) throws IOException {
        return (AndroidMemoryReading) q05.parseFrom(DEFAULT_INSTANCE, b05, i05);
    }
}
