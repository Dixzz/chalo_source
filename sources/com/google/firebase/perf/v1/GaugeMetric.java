package com.google.firebase.perf.v1;

import com.google.firebase.perf.v1.AndroidMemoryReading;
import com.google.firebase.perf.v1.CpuMetricReading;
import com.google.firebase.perf.v1.GaugeMetadata;
import com.google.firebase.perf.v1.IosMemoryReading;
import defpackage.q05;
import defpackage.s05;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class GaugeMetric extends q05<GaugeMetric, Builder> implements GaugeMetricOrBuilder {
    public static final int ANDROID_MEMORY_READINGS_FIELD_NUMBER = 4;
    public static final int CPU_METRIC_READINGS_FIELD_NUMBER = 2;
    private static final GaugeMetric DEFAULT_INSTANCE;
    public static final int GAUGE_METADATA_FIELD_NUMBER = 3;
    public static final int IOS_MEMORY_READINGS_FIELD_NUMBER = 5;
    private static volatile q15<GaugeMetric> PARSER = null;
    public static final int SESSION_ID_FIELD_NUMBER = 1;
    private s05.j<AndroidMemoryReading> androidMemoryReadings_ = q05.emptyProtobufList();
    private int bitField0_;
    private s05.j<CpuMetricReading> cpuMetricReadings_ = q05.emptyProtobufList();
    private GaugeMetadata gaugeMetadata_;
    private s05.j<IosMemoryReading> iosMemoryReadings_ = q05.emptyProtobufList();
    private String sessionId_ = "";

    /* renamed from: com.google.firebase.perf.v1.GaugeMetric$1  reason: invalid class name */
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
                com.google.firebase.perf.v1.GaugeMetric.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = r1
                r2 = 1
                r3 = 3
                q05$f r4 = defpackage.q05.f.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x000e }
                r1[r3] = r2     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                r1 = 2
                r4 = 4
                int[] r5 = com.google.firebase.perf.v1.GaugeMetric.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0016 }
                q05$f r6 = defpackage.q05.f.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x0016 }
                r5[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                int[] r5 = com.google.firebase.perf.v1.GaugeMetric.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x001c }
                q05$f r6 = defpackage.q05.f.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x001c }
                r5[r1] = r3     // Catch:{ NoSuchFieldError -> 0x001c }
            L_0x001c:
                r1 = 5
                int[] r3 = com.google.firebase.perf.v1.GaugeMetric.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0023 }
                q05$f r5 = defpackage.q05.f.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0023 }
                r3[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0023 }
            L_0x0023:
                r3 = 6
                int[] r4 = com.google.firebase.perf.v1.GaugeMetric.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x002a }
                q05$f r5 = defpackage.q05.f.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x002a }
                r4[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r1 = com.google.firebase.perf.v1.GaugeMetric.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0031 }
                q05$f r4 = defpackage.q05.f.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0031 }
                r4 = 0
                r1[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0031 }
            L_0x0031:
                int[] r1 = com.google.firebase.perf.v1.GaugeMetric.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0037 }
                q05$f r3 = defpackage.q05.f.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0037 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0037 }
            L_0x0037:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.v1.GaugeMetric.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class Builder extends q05.a<GaugeMetric, Builder> implements GaugeMetricOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        public Builder addAllAndroidMemoryReadings(Iterable<? extends AndroidMemoryReading> iterable) {
            copyOnWrite();
            ((GaugeMetric) this.instance).addAllAndroidMemoryReadings(iterable);
            return this;
        }

        public Builder addAllCpuMetricReadings(Iterable<? extends CpuMetricReading> iterable) {
            copyOnWrite();
            ((GaugeMetric) this.instance).addAllCpuMetricReadings(iterable);
            return this;
        }

        public Builder addAllIosMemoryReadings(Iterable<? extends IosMemoryReading> iterable) {
            copyOnWrite();
            ((GaugeMetric) this.instance).addAllIosMemoryReadings(iterable);
            return this;
        }

        public Builder addAndroidMemoryReadings(AndroidMemoryReading androidMemoryReading) {
            copyOnWrite();
            ((GaugeMetric) this.instance).addAndroidMemoryReadings(androidMemoryReading);
            return this;
        }

        public Builder addCpuMetricReadings(CpuMetricReading cpuMetricReading) {
            copyOnWrite();
            ((GaugeMetric) this.instance).addCpuMetricReadings(cpuMetricReading);
            return this;
        }

        public Builder addIosMemoryReadings(IosMemoryReading iosMemoryReading) {
            copyOnWrite();
            ((GaugeMetric) this.instance).addIosMemoryReadings(iosMemoryReading);
            return this;
        }

        public Builder clearAndroidMemoryReadings() {
            copyOnWrite();
            ((GaugeMetric) this.instance).clearAndroidMemoryReadings();
            return this;
        }

        public Builder clearCpuMetricReadings() {
            copyOnWrite();
            ((GaugeMetric) this.instance).clearCpuMetricReadings();
            return this;
        }

        public Builder clearGaugeMetadata() {
            copyOnWrite();
            ((GaugeMetric) this.instance).clearGaugeMetadata();
            return this;
        }

        public Builder clearIosMemoryReadings() {
            copyOnWrite();
            ((GaugeMetric) this.instance).clearIosMemoryReadings();
            return this;
        }

        public Builder clearSessionId() {
            copyOnWrite();
            ((GaugeMetric) this.instance).clearSessionId();
            return this;
        }

        @Override // com.google.firebase.perf.v1.GaugeMetricOrBuilder
        public AndroidMemoryReading getAndroidMemoryReadings(int i) {
            return ((GaugeMetric) this.instance).getAndroidMemoryReadings(i);
        }

        @Override // com.google.firebase.perf.v1.GaugeMetricOrBuilder
        public int getAndroidMemoryReadingsCount() {
            return ((GaugeMetric) this.instance).getAndroidMemoryReadingsCount();
        }

        @Override // com.google.firebase.perf.v1.GaugeMetricOrBuilder
        public List<AndroidMemoryReading> getAndroidMemoryReadingsList() {
            return Collections.unmodifiableList(((GaugeMetric) this.instance).getAndroidMemoryReadingsList());
        }

        @Override // com.google.firebase.perf.v1.GaugeMetricOrBuilder
        public CpuMetricReading getCpuMetricReadings(int i) {
            return ((GaugeMetric) this.instance).getCpuMetricReadings(i);
        }

        @Override // com.google.firebase.perf.v1.GaugeMetricOrBuilder
        public int getCpuMetricReadingsCount() {
            return ((GaugeMetric) this.instance).getCpuMetricReadingsCount();
        }

        @Override // com.google.firebase.perf.v1.GaugeMetricOrBuilder
        public List<CpuMetricReading> getCpuMetricReadingsList() {
            return Collections.unmodifiableList(((GaugeMetric) this.instance).getCpuMetricReadingsList());
        }

        @Override // com.google.firebase.perf.v1.GaugeMetricOrBuilder
        public GaugeMetadata getGaugeMetadata() {
            return ((GaugeMetric) this.instance).getGaugeMetadata();
        }

        @Override // com.google.firebase.perf.v1.GaugeMetricOrBuilder
        public IosMemoryReading getIosMemoryReadings(int i) {
            return ((GaugeMetric) this.instance).getIosMemoryReadings(i);
        }

        @Override // com.google.firebase.perf.v1.GaugeMetricOrBuilder
        public int getIosMemoryReadingsCount() {
            return ((GaugeMetric) this.instance).getIosMemoryReadingsCount();
        }

        @Override // com.google.firebase.perf.v1.GaugeMetricOrBuilder
        public List<IosMemoryReading> getIosMemoryReadingsList() {
            return Collections.unmodifiableList(((GaugeMetric) this.instance).getIosMemoryReadingsList());
        }

        @Override // com.google.firebase.perf.v1.GaugeMetricOrBuilder
        public String getSessionId() {
            return ((GaugeMetric) this.instance).getSessionId();
        }

        @Override // com.google.firebase.perf.v1.GaugeMetricOrBuilder
        public a05 getSessionIdBytes() {
            return ((GaugeMetric) this.instance).getSessionIdBytes();
        }

        @Override // com.google.firebase.perf.v1.GaugeMetricOrBuilder
        public boolean hasGaugeMetadata() {
            return ((GaugeMetric) this.instance).hasGaugeMetadata();
        }

        @Override // com.google.firebase.perf.v1.GaugeMetricOrBuilder
        public boolean hasSessionId() {
            return ((GaugeMetric) this.instance).hasSessionId();
        }

        public Builder mergeGaugeMetadata(GaugeMetadata gaugeMetadata) {
            copyOnWrite();
            ((GaugeMetric) this.instance).mergeGaugeMetadata(gaugeMetadata);
            return this;
        }

        public Builder removeAndroidMemoryReadings(int i) {
            copyOnWrite();
            ((GaugeMetric) this.instance).removeAndroidMemoryReadings(i);
            return this;
        }

        public Builder removeCpuMetricReadings(int i) {
            copyOnWrite();
            ((GaugeMetric) this.instance).removeCpuMetricReadings(i);
            return this;
        }

        public Builder removeIosMemoryReadings(int i) {
            copyOnWrite();
            ((GaugeMetric) this.instance).removeIosMemoryReadings(i);
            return this;
        }

        public Builder setAndroidMemoryReadings(int i, AndroidMemoryReading androidMemoryReading) {
            copyOnWrite();
            ((GaugeMetric) this.instance).setAndroidMemoryReadings(i, androidMemoryReading);
            return this;
        }

        public Builder setCpuMetricReadings(int i, CpuMetricReading cpuMetricReading) {
            copyOnWrite();
            ((GaugeMetric) this.instance).setCpuMetricReadings(i, cpuMetricReading);
            return this;
        }

        public Builder setGaugeMetadata(GaugeMetadata gaugeMetadata) {
            copyOnWrite();
            ((GaugeMetric) this.instance).setGaugeMetadata(gaugeMetadata);
            return this;
        }

        public Builder setIosMemoryReadings(int i, IosMemoryReading iosMemoryReading) {
            copyOnWrite();
            ((GaugeMetric) this.instance).setIosMemoryReadings(i, iosMemoryReading);
            return this;
        }

        public Builder setSessionId(String str) {
            copyOnWrite();
            ((GaugeMetric) this.instance).setSessionId(str);
            return this;
        }

        public Builder setSessionIdBytes(a05 a05) {
            copyOnWrite();
            ((GaugeMetric) this.instance).setSessionIdBytes(a05);
            return this;
        }

        private Builder() {
            super(GaugeMetric.DEFAULT_INSTANCE);
        }

        public Builder addAndroidMemoryReadings(int i, AndroidMemoryReading androidMemoryReading) {
            copyOnWrite();
            ((GaugeMetric) this.instance).addAndroidMemoryReadings(i, androidMemoryReading);
            return this;
        }

        public Builder addCpuMetricReadings(int i, CpuMetricReading cpuMetricReading) {
            copyOnWrite();
            ((GaugeMetric) this.instance).addCpuMetricReadings(i, cpuMetricReading);
            return this;
        }

        public Builder addIosMemoryReadings(int i, IosMemoryReading iosMemoryReading) {
            copyOnWrite();
            ((GaugeMetric) this.instance).addIosMemoryReadings(i, iosMemoryReading);
            return this;
        }

        public Builder setAndroidMemoryReadings(int i, AndroidMemoryReading.Builder builder) {
            copyOnWrite();
            ((GaugeMetric) this.instance).setAndroidMemoryReadings(i, (AndroidMemoryReading) builder.build());
            return this;
        }

        public Builder setCpuMetricReadings(int i, CpuMetricReading.Builder builder) {
            copyOnWrite();
            ((GaugeMetric) this.instance).setCpuMetricReadings(i, (CpuMetricReading) builder.build());
            return this;
        }

        public Builder setGaugeMetadata(GaugeMetadata.Builder builder) {
            copyOnWrite();
            ((GaugeMetric) this.instance).setGaugeMetadata((GaugeMetadata) builder.build());
            return this;
        }

        public Builder setIosMemoryReadings(int i, IosMemoryReading.Builder builder) {
            copyOnWrite();
            ((GaugeMetric) this.instance).setIosMemoryReadings(i, (IosMemoryReading) builder.build());
            return this;
        }

        public Builder addAndroidMemoryReadings(AndroidMemoryReading.Builder builder) {
            copyOnWrite();
            ((GaugeMetric) this.instance).addAndroidMemoryReadings((AndroidMemoryReading) builder.build());
            return this;
        }

        public Builder addCpuMetricReadings(CpuMetricReading.Builder builder) {
            copyOnWrite();
            ((GaugeMetric) this.instance).addCpuMetricReadings((CpuMetricReading) builder.build());
            return this;
        }

        public Builder addIosMemoryReadings(IosMemoryReading.Builder builder) {
            copyOnWrite();
            ((GaugeMetric) this.instance).addIosMemoryReadings((IosMemoryReading) builder.build());
            return this;
        }

        public Builder addAndroidMemoryReadings(int i, AndroidMemoryReading.Builder builder) {
            copyOnWrite();
            ((GaugeMetric) this.instance).addAndroidMemoryReadings(i, (AndroidMemoryReading) builder.build());
            return this;
        }

        public Builder addCpuMetricReadings(int i, CpuMetricReading.Builder builder) {
            copyOnWrite();
            ((GaugeMetric) this.instance).addCpuMetricReadings(i, (CpuMetricReading) builder.build());
            return this;
        }

        public Builder addIosMemoryReadings(int i, IosMemoryReading.Builder builder) {
            copyOnWrite();
            ((GaugeMetric) this.instance).addIosMemoryReadings(i, (IosMemoryReading) builder.build());
            return this;
        }
    }

    static {
        GaugeMetric gaugeMetric = new GaugeMetric();
        DEFAULT_INSTANCE = gaugeMetric;
        q05.registerDefaultInstance(GaugeMetric.class, gaugeMetric);
    }

    private GaugeMetric() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addAllAndroidMemoryReadings(Iterable<? extends AndroidMemoryReading> iterable) {
        ensureAndroidMemoryReadingsIsMutable();
        rz4.addAll((Iterable) iterable, (List) this.androidMemoryReadings_);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addAllCpuMetricReadings(Iterable<? extends CpuMetricReading> iterable) {
        ensureCpuMetricReadingsIsMutable();
        rz4.addAll((Iterable) iterable, (List) this.cpuMetricReadings_);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addAllIosMemoryReadings(Iterable<? extends IosMemoryReading> iterable) {
        ensureIosMemoryReadingsIsMutable();
        rz4.addAll((Iterable) iterable, (List) this.iosMemoryReadings_);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addAndroidMemoryReadings(AndroidMemoryReading androidMemoryReading) {
        androidMemoryReading.getClass();
        ensureAndroidMemoryReadingsIsMutable();
        this.androidMemoryReadings_.add(androidMemoryReading);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addCpuMetricReadings(CpuMetricReading cpuMetricReading) {
        cpuMetricReading.getClass();
        ensureCpuMetricReadingsIsMutable();
        this.cpuMetricReadings_.add(cpuMetricReading);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addIosMemoryReadings(IosMemoryReading iosMemoryReading) {
        iosMemoryReading.getClass();
        ensureIosMemoryReadingsIsMutable();
        this.iosMemoryReadings_.add(iosMemoryReading);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearAndroidMemoryReadings() {
        this.androidMemoryReadings_ = q05.emptyProtobufList();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearCpuMetricReadings() {
        this.cpuMetricReadings_ = q05.emptyProtobufList();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearGaugeMetadata() {
        this.gaugeMetadata_ = null;
        this.bitField0_ &= -3;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearIosMemoryReadings() {
        this.iosMemoryReadings_ = q05.emptyProtobufList();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearSessionId() {
        this.bitField0_ &= -2;
        this.sessionId_ = getDefaultInstance().getSessionId();
    }

    private void ensureAndroidMemoryReadingsIsMutable() {
        if (!this.androidMemoryReadings_.t()) {
            this.androidMemoryReadings_ = q05.mutableCopy(this.androidMemoryReadings_);
        }
    }

    private void ensureCpuMetricReadingsIsMutable() {
        if (!this.cpuMetricReadings_.t()) {
            this.cpuMetricReadings_ = q05.mutableCopy(this.cpuMetricReadings_);
        }
    }

    private void ensureIosMemoryReadingsIsMutable() {
        if (!this.iosMemoryReadings_.t()) {
            this.iosMemoryReadings_ = q05.mutableCopy(this.iosMemoryReadings_);
        }
    }

    public static GaugeMetric getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void mergeGaugeMetadata(GaugeMetadata gaugeMetadata) {
        gaugeMetadata.getClass();
        GaugeMetadata gaugeMetadata2 = this.gaugeMetadata_;
        if (gaugeMetadata2 == null || gaugeMetadata2 == GaugeMetadata.getDefaultInstance()) {
            this.gaugeMetadata_ = gaugeMetadata;
        } else {
            this.gaugeMetadata_ = (GaugeMetadata) ((GaugeMetadata.Builder) GaugeMetadata.newBuilder(this.gaugeMetadata_).mergeFrom((q05) gaugeMetadata)).buildPartial();
        }
        this.bitField0_ |= 2;
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static GaugeMetric parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (GaugeMetric) q05.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GaugeMetric parseFrom(ByteBuffer byteBuffer) throws t05 {
        return (GaugeMetric) q05.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static q15<GaugeMetric> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void removeAndroidMemoryReadings(int i) {
        ensureAndroidMemoryReadingsIsMutable();
        this.androidMemoryReadings_.remove(i);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void removeCpuMetricReadings(int i) {
        ensureCpuMetricReadingsIsMutable();
        this.cpuMetricReadings_.remove(i);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void removeIosMemoryReadings(int i) {
        ensureIosMemoryReadingsIsMutable();
        this.iosMemoryReadings_.remove(i);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setAndroidMemoryReadings(int i, AndroidMemoryReading androidMemoryReading) {
        androidMemoryReading.getClass();
        ensureAndroidMemoryReadingsIsMutable();
        this.androidMemoryReadings_.set(i, androidMemoryReading);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setCpuMetricReadings(int i, CpuMetricReading cpuMetricReading) {
        cpuMetricReading.getClass();
        ensureCpuMetricReadingsIsMutable();
        this.cpuMetricReadings_.set(i, cpuMetricReading);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setGaugeMetadata(GaugeMetadata gaugeMetadata) {
        gaugeMetadata.getClass();
        this.gaugeMetadata_ = gaugeMetadata;
        this.bitField0_ |= 2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setIosMemoryReadings(int i, IosMemoryReading iosMemoryReading) {
        iosMemoryReading.getClass();
        ensureIosMemoryReadingsIsMutable();
        this.iosMemoryReadings_.set(i, iosMemoryReading);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setSessionId(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.sessionId_ = str;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setSessionIdBytes(a05 a05) {
        this.sessionId_ = a05.B();
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
                return q05.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0003\u0000\u0001\b\u0000\u0002\u001b\u0003\t\u0001\u0004\u001b\u0005\u001b", new Object[]{"bitField0_", "sessionId_", "cpuMetricReadings_", CpuMetricReading.class, "gaugeMetadata_", "androidMemoryReadings_", AndroidMemoryReading.class, "iosMemoryReadings_", IosMemoryReading.class});
            case 3:
                return new GaugeMetric();
            case 4:
                return new Builder(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                q15<GaugeMetric> q15 = PARSER;
                if (q15 == null) {
                    synchronized (GaugeMetric.class) {
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

    @Override // com.google.firebase.perf.v1.GaugeMetricOrBuilder
    public AndroidMemoryReading getAndroidMemoryReadings(int i) {
        return this.androidMemoryReadings_.get(i);
    }

    @Override // com.google.firebase.perf.v1.GaugeMetricOrBuilder
    public int getAndroidMemoryReadingsCount() {
        return this.androidMemoryReadings_.size();
    }

    @Override // com.google.firebase.perf.v1.GaugeMetricOrBuilder
    public List<AndroidMemoryReading> getAndroidMemoryReadingsList() {
        return this.androidMemoryReadings_;
    }

    public AndroidMemoryReadingOrBuilder getAndroidMemoryReadingsOrBuilder(int i) {
        return this.androidMemoryReadings_.get(i);
    }

    public List<? extends AndroidMemoryReadingOrBuilder> getAndroidMemoryReadingsOrBuilderList() {
        return this.androidMemoryReadings_;
    }

    @Override // com.google.firebase.perf.v1.GaugeMetricOrBuilder
    public CpuMetricReading getCpuMetricReadings(int i) {
        return this.cpuMetricReadings_.get(i);
    }

    @Override // com.google.firebase.perf.v1.GaugeMetricOrBuilder
    public int getCpuMetricReadingsCount() {
        return this.cpuMetricReadings_.size();
    }

    @Override // com.google.firebase.perf.v1.GaugeMetricOrBuilder
    public List<CpuMetricReading> getCpuMetricReadingsList() {
        return this.cpuMetricReadings_;
    }

    public CpuMetricReadingOrBuilder getCpuMetricReadingsOrBuilder(int i) {
        return this.cpuMetricReadings_.get(i);
    }

    public List<? extends CpuMetricReadingOrBuilder> getCpuMetricReadingsOrBuilderList() {
        return this.cpuMetricReadings_;
    }

    @Override // com.google.firebase.perf.v1.GaugeMetricOrBuilder
    public GaugeMetadata getGaugeMetadata() {
        GaugeMetadata gaugeMetadata = this.gaugeMetadata_;
        return gaugeMetadata == null ? GaugeMetadata.getDefaultInstance() : gaugeMetadata;
    }

    @Override // com.google.firebase.perf.v1.GaugeMetricOrBuilder
    public IosMemoryReading getIosMemoryReadings(int i) {
        return this.iosMemoryReadings_.get(i);
    }

    @Override // com.google.firebase.perf.v1.GaugeMetricOrBuilder
    public int getIosMemoryReadingsCount() {
        return this.iosMemoryReadings_.size();
    }

    @Override // com.google.firebase.perf.v1.GaugeMetricOrBuilder
    public List<IosMemoryReading> getIosMemoryReadingsList() {
        return this.iosMemoryReadings_;
    }

    public IosMemoryReadingOrBuilder getIosMemoryReadingsOrBuilder(int i) {
        return this.iosMemoryReadings_.get(i);
    }

    public List<? extends IosMemoryReadingOrBuilder> getIosMemoryReadingsOrBuilderList() {
        return this.iosMemoryReadings_;
    }

    @Override // com.google.firebase.perf.v1.GaugeMetricOrBuilder
    public String getSessionId() {
        return this.sessionId_;
    }

    @Override // com.google.firebase.perf.v1.GaugeMetricOrBuilder
    public a05 getSessionIdBytes() {
        return a05.k(this.sessionId_);
    }

    @Override // com.google.firebase.perf.v1.GaugeMetricOrBuilder
    public boolean hasGaugeMetadata() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // com.google.firebase.perf.v1.GaugeMetricOrBuilder
    public boolean hasSessionId() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(GaugeMetric gaugeMetric) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(gaugeMetric);
    }

    public static GaugeMetric parseDelimitedFrom(InputStream inputStream, i05 i05) throws IOException {
        return (GaugeMetric) q05.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, i05);
    }

    public static GaugeMetric parseFrom(ByteBuffer byteBuffer, i05 i05) throws t05 {
        return (GaugeMetric) q05.parseFrom(DEFAULT_INSTANCE, byteBuffer, i05);
    }

    public static GaugeMetric parseFrom(a05 a05) throws t05 {
        return (GaugeMetric) q05.parseFrom(DEFAULT_INSTANCE, a05);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addAndroidMemoryReadings(int i, AndroidMemoryReading androidMemoryReading) {
        androidMemoryReading.getClass();
        ensureAndroidMemoryReadingsIsMutable();
        this.androidMemoryReadings_.add(i, androidMemoryReading);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addCpuMetricReadings(int i, CpuMetricReading cpuMetricReading) {
        cpuMetricReading.getClass();
        ensureCpuMetricReadingsIsMutable();
        this.cpuMetricReadings_.add(i, cpuMetricReading);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addIosMemoryReadings(int i, IosMemoryReading iosMemoryReading) {
        iosMemoryReading.getClass();
        ensureIosMemoryReadingsIsMutable();
        this.iosMemoryReadings_.add(i, iosMemoryReading);
    }

    public static GaugeMetric parseFrom(a05 a05, i05 i05) throws t05 {
        return (GaugeMetric) q05.parseFrom(DEFAULT_INSTANCE, a05, i05);
    }

    public static GaugeMetric parseFrom(byte[] bArr) throws t05 {
        return (GaugeMetric) q05.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GaugeMetric parseFrom(byte[] bArr, i05 i05) throws t05 {
        return (GaugeMetric) q05.parseFrom(DEFAULT_INSTANCE, bArr, i05);
    }

    public static GaugeMetric parseFrom(InputStream inputStream) throws IOException {
        return (GaugeMetric) q05.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GaugeMetric parseFrom(InputStream inputStream, i05 i05) throws IOException {
        return (GaugeMetric) q05.parseFrom(DEFAULT_INSTANCE, inputStream, i05);
    }

    public static GaugeMetric parseFrom(b05 b05) throws IOException {
        return (GaugeMetric) q05.parseFrom(DEFAULT_INSTANCE, b05);
    }

    public static GaugeMetric parseFrom(b05 b05, i05 i05) throws IOException {
        return (GaugeMetric) q05.parseFrom(DEFAULT_INSTANCE, b05, i05);
    }
}
