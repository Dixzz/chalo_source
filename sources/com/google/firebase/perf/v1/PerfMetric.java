package com.google.firebase.perf.v1;

import com.google.firebase.perf.v1.ApplicationInfo;
import com.google.firebase.perf.v1.GaugeMetric;
import com.google.firebase.perf.v1.NetworkRequestMetric;
import com.google.firebase.perf.v1.TraceMetric;
import com.google.firebase.perf.v1.TransportInfo;
import defpackage.q05;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class PerfMetric extends q05<PerfMetric, Builder> implements PerfMetricOrBuilder {
    public static final int APPLICATION_INFO_FIELD_NUMBER = 1;
    private static final PerfMetric DEFAULT_INSTANCE;
    public static final int GAUGE_METRIC_FIELD_NUMBER = 4;
    public static final int NETWORK_REQUEST_METRIC_FIELD_NUMBER = 3;
    private static volatile q15<PerfMetric> PARSER = null;
    public static final int TRACE_METRIC_FIELD_NUMBER = 2;
    public static final int TRANSPORT_INFO_FIELD_NUMBER = 5;
    private ApplicationInfo applicationInfo_;
    private int bitField0_;
    private GaugeMetric gaugeMetric_;
    private NetworkRequestMetric networkRequestMetric_;
    private TraceMetric traceMetric_;
    private TransportInfo transportInfo_;

    /* renamed from: com.google.firebase.perf.v1.PerfMetric$1  reason: invalid class name */
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
                com.google.firebase.perf.v1.PerfMetric.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = r1
                r2 = 1
                r3 = 3
                q05$f r4 = defpackage.q05.f.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x000e }
                r1[r3] = r2     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                r1 = 2
                r4 = 4
                int[] r5 = com.google.firebase.perf.v1.PerfMetric.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0016 }
                q05$f r6 = defpackage.q05.f.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x0016 }
                r5[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                int[] r5 = com.google.firebase.perf.v1.PerfMetric.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x001c }
                q05$f r6 = defpackage.q05.f.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x001c }
                r5[r1] = r3     // Catch:{ NoSuchFieldError -> 0x001c }
            L_0x001c:
                r1 = 5
                int[] r3 = com.google.firebase.perf.v1.PerfMetric.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0023 }
                q05$f r5 = defpackage.q05.f.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0023 }
                r3[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0023 }
            L_0x0023:
                r3 = 6
                int[] r4 = com.google.firebase.perf.v1.PerfMetric.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x002a }
                q05$f r5 = defpackage.q05.f.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x002a }
                r4[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r1 = com.google.firebase.perf.v1.PerfMetric.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0031 }
                q05$f r4 = defpackage.q05.f.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0031 }
                r4 = 0
                r1[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0031 }
            L_0x0031:
                int[] r1 = com.google.firebase.perf.v1.PerfMetric.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0037 }
                q05$f r3 = defpackage.q05.f.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0037 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0037 }
            L_0x0037:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.v1.PerfMetric.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class Builder extends q05.a<PerfMetric, Builder> implements PerfMetricOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        public Builder clearApplicationInfo() {
            copyOnWrite();
            ((PerfMetric) this.instance).clearApplicationInfo();
            return this;
        }

        public Builder clearGaugeMetric() {
            copyOnWrite();
            ((PerfMetric) this.instance).clearGaugeMetric();
            return this;
        }

        public Builder clearNetworkRequestMetric() {
            copyOnWrite();
            ((PerfMetric) this.instance).clearNetworkRequestMetric();
            return this;
        }

        public Builder clearTraceMetric() {
            copyOnWrite();
            ((PerfMetric) this.instance).clearTraceMetric();
            return this;
        }

        public Builder clearTransportInfo() {
            copyOnWrite();
            ((PerfMetric) this.instance).clearTransportInfo();
            return this;
        }

        @Override // com.google.firebase.perf.v1.PerfMetricOrBuilder
        public ApplicationInfo getApplicationInfo() {
            return ((PerfMetric) this.instance).getApplicationInfo();
        }

        @Override // com.google.firebase.perf.v1.PerfMetricOrBuilder
        public GaugeMetric getGaugeMetric() {
            return ((PerfMetric) this.instance).getGaugeMetric();
        }

        @Override // com.google.firebase.perf.v1.PerfMetricOrBuilder
        public NetworkRequestMetric getNetworkRequestMetric() {
            return ((PerfMetric) this.instance).getNetworkRequestMetric();
        }

        @Override // com.google.firebase.perf.v1.PerfMetricOrBuilder
        public TraceMetric getTraceMetric() {
            return ((PerfMetric) this.instance).getTraceMetric();
        }

        @Override // com.google.firebase.perf.v1.PerfMetricOrBuilder
        public TransportInfo getTransportInfo() {
            return ((PerfMetric) this.instance).getTransportInfo();
        }

        @Override // com.google.firebase.perf.v1.PerfMetricOrBuilder
        public boolean hasApplicationInfo() {
            return ((PerfMetric) this.instance).hasApplicationInfo();
        }

        @Override // com.google.firebase.perf.v1.PerfMetricOrBuilder
        public boolean hasGaugeMetric() {
            return ((PerfMetric) this.instance).hasGaugeMetric();
        }

        @Override // com.google.firebase.perf.v1.PerfMetricOrBuilder
        public boolean hasNetworkRequestMetric() {
            return ((PerfMetric) this.instance).hasNetworkRequestMetric();
        }

        @Override // com.google.firebase.perf.v1.PerfMetricOrBuilder
        public boolean hasTraceMetric() {
            return ((PerfMetric) this.instance).hasTraceMetric();
        }

        @Override // com.google.firebase.perf.v1.PerfMetricOrBuilder
        public boolean hasTransportInfo() {
            return ((PerfMetric) this.instance).hasTransportInfo();
        }

        public Builder mergeApplicationInfo(ApplicationInfo applicationInfo) {
            copyOnWrite();
            ((PerfMetric) this.instance).mergeApplicationInfo(applicationInfo);
            return this;
        }

        public Builder mergeGaugeMetric(GaugeMetric gaugeMetric) {
            copyOnWrite();
            ((PerfMetric) this.instance).mergeGaugeMetric(gaugeMetric);
            return this;
        }

        public Builder mergeNetworkRequestMetric(NetworkRequestMetric networkRequestMetric) {
            copyOnWrite();
            ((PerfMetric) this.instance).mergeNetworkRequestMetric(networkRequestMetric);
            return this;
        }

        public Builder mergeTraceMetric(TraceMetric traceMetric) {
            copyOnWrite();
            ((PerfMetric) this.instance).mergeTraceMetric(traceMetric);
            return this;
        }

        public Builder mergeTransportInfo(TransportInfo transportInfo) {
            copyOnWrite();
            ((PerfMetric) this.instance).mergeTransportInfo(transportInfo);
            return this;
        }

        public Builder setApplicationInfo(ApplicationInfo applicationInfo) {
            copyOnWrite();
            ((PerfMetric) this.instance).setApplicationInfo(applicationInfo);
            return this;
        }

        public Builder setGaugeMetric(GaugeMetric gaugeMetric) {
            copyOnWrite();
            ((PerfMetric) this.instance).setGaugeMetric(gaugeMetric);
            return this;
        }

        public Builder setNetworkRequestMetric(NetworkRequestMetric networkRequestMetric) {
            copyOnWrite();
            ((PerfMetric) this.instance).setNetworkRequestMetric(networkRequestMetric);
            return this;
        }

        public Builder setTraceMetric(TraceMetric traceMetric) {
            copyOnWrite();
            ((PerfMetric) this.instance).setTraceMetric(traceMetric);
            return this;
        }

        public Builder setTransportInfo(TransportInfo transportInfo) {
            copyOnWrite();
            ((PerfMetric) this.instance).setTransportInfo(transportInfo);
            return this;
        }

        private Builder() {
            super(PerfMetric.DEFAULT_INSTANCE);
        }

        public Builder setApplicationInfo(ApplicationInfo.Builder builder) {
            copyOnWrite();
            ((PerfMetric) this.instance).setApplicationInfo((ApplicationInfo) builder.build());
            return this;
        }

        public Builder setGaugeMetric(GaugeMetric.Builder builder) {
            copyOnWrite();
            ((PerfMetric) this.instance).setGaugeMetric((GaugeMetric) builder.build());
            return this;
        }

        public Builder setNetworkRequestMetric(NetworkRequestMetric.Builder builder) {
            copyOnWrite();
            ((PerfMetric) this.instance).setNetworkRequestMetric((NetworkRequestMetric) builder.build());
            return this;
        }

        public Builder setTraceMetric(TraceMetric.Builder builder) {
            copyOnWrite();
            ((PerfMetric) this.instance).setTraceMetric((TraceMetric) builder.build());
            return this;
        }

        public Builder setTransportInfo(TransportInfo.Builder builder) {
            copyOnWrite();
            ((PerfMetric) this.instance).setTransportInfo((TransportInfo) builder.build());
            return this;
        }
    }

    static {
        PerfMetric perfMetric = new PerfMetric();
        DEFAULT_INSTANCE = perfMetric;
        q05.registerDefaultInstance(PerfMetric.class, perfMetric);
    }

    private PerfMetric() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearApplicationInfo() {
        this.applicationInfo_ = null;
        this.bitField0_ &= -2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearGaugeMetric() {
        this.gaugeMetric_ = null;
        this.bitField0_ &= -9;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearNetworkRequestMetric() {
        this.networkRequestMetric_ = null;
        this.bitField0_ &= -5;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearTraceMetric() {
        this.traceMetric_ = null;
        this.bitField0_ &= -3;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearTransportInfo() {
        this.transportInfo_ = null;
        this.bitField0_ &= -17;
    }

    public static PerfMetric getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void mergeApplicationInfo(ApplicationInfo applicationInfo) {
        applicationInfo.getClass();
        ApplicationInfo applicationInfo2 = this.applicationInfo_;
        if (applicationInfo2 == null || applicationInfo2 == ApplicationInfo.getDefaultInstance()) {
            this.applicationInfo_ = applicationInfo;
        } else {
            this.applicationInfo_ = (ApplicationInfo) ((ApplicationInfo.Builder) ApplicationInfo.newBuilder(this.applicationInfo_).mergeFrom((q05) applicationInfo)).buildPartial();
        }
        this.bitField0_ |= 1;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void mergeGaugeMetric(GaugeMetric gaugeMetric) {
        gaugeMetric.getClass();
        GaugeMetric gaugeMetric2 = this.gaugeMetric_;
        if (gaugeMetric2 == null || gaugeMetric2 == GaugeMetric.getDefaultInstance()) {
            this.gaugeMetric_ = gaugeMetric;
        } else {
            this.gaugeMetric_ = (GaugeMetric) ((GaugeMetric.Builder) GaugeMetric.newBuilder(this.gaugeMetric_).mergeFrom((q05) gaugeMetric)).buildPartial();
        }
        this.bitField0_ |= 8;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void mergeNetworkRequestMetric(NetworkRequestMetric networkRequestMetric) {
        networkRequestMetric.getClass();
        NetworkRequestMetric networkRequestMetric2 = this.networkRequestMetric_;
        if (networkRequestMetric2 == null || networkRequestMetric2 == NetworkRequestMetric.getDefaultInstance()) {
            this.networkRequestMetric_ = networkRequestMetric;
        } else {
            this.networkRequestMetric_ = (NetworkRequestMetric) ((NetworkRequestMetric.Builder) NetworkRequestMetric.newBuilder(this.networkRequestMetric_).mergeFrom((q05) networkRequestMetric)).buildPartial();
        }
        this.bitField0_ |= 4;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void mergeTraceMetric(TraceMetric traceMetric) {
        traceMetric.getClass();
        TraceMetric traceMetric2 = this.traceMetric_;
        if (traceMetric2 == null || traceMetric2 == TraceMetric.getDefaultInstance()) {
            this.traceMetric_ = traceMetric;
        } else {
            this.traceMetric_ = (TraceMetric) ((TraceMetric.Builder) TraceMetric.newBuilder(this.traceMetric_).mergeFrom((q05) traceMetric)).buildPartial();
        }
        this.bitField0_ |= 2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void mergeTransportInfo(TransportInfo transportInfo) {
        transportInfo.getClass();
        TransportInfo transportInfo2 = this.transportInfo_;
        if (transportInfo2 == null || transportInfo2 == TransportInfo.getDefaultInstance()) {
            this.transportInfo_ = transportInfo;
        } else {
            this.transportInfo_ = (TransportInfo) ((TransportInfo.Builder) TransportInfo.newBuilder(this.transportInfo_).mergeFrom((q05) transportInfo)).buildPartial();
        }
        this.bitField0_ |= 16;
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static PerfMetric parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (PerfMetric) q05.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PerfMetric parseFrom(ByteBuffer byteBuffer) throws t05 {
        return (PerfMetric) q05.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static q15<PerfMetric> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setApplicationInfo(ApplicationInfo applicationInfo) {
        applicationInfo.getClass();
        this.applicationInfo_ = applicationInfo;
        this.bitField0_ |= 1;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setGaugeMetric(GaugeMetric gaugeMetric) {
        gaugeMetric.getClass();
        this.gaugeMetric_ = gaugeMetric;
        this.bitField0_ |= 8;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setNetworkRequestMetric(NetworkRequestMetric networkRequestMetric) {
        networkRequestMetric.getClass();
        this.networkRequestMetric_ = networkRequestMetric;
        this.bitField0_ |= 4;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setTraceMetric(TraceMetric traceMetric) {
        traceMetric.getClass();
        this.traceMetric_ = traceMetric;
        this.bitField0_ |= 2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setTransportInfo(TransportInfo transportInfo) {
        transportInfo.getClass();
        this.transportInfo_ = transportInfo;
        this.bitField0_ |= 16;
    }

    @Override // defpackage.q05
    public final Object dynamicMethod(q05.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return q05.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\t\u0000\u0002\t\u0001\u0003\t\u0002\u0004\t\u0003\u0005\t\u0004", new Object[]{"bitField0_", "applicationInfo_", "traceMetric_", "networkRequestMetric_", "gaugeMetric_", "transportInfo_"});
            case 3:
                return new PerfMetric();
            case 4:
                return new Builder(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                q15<PerfMetric> q15 = PARSER;
                if (q15 == null) {
                    synchronized (PerfMetric.class) {
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

    @Override // com.google.firebase.perf.v1.PerfMetricOrBuilder
    public ApplicationInfo getApplicationInfo() {
        ApplicationInfo applicationInfo = this.applicationInfo_;
        return applicationInfo == null ? ApplicationInfo.getDefaultInstance() : applicationInfo;
    }

    @Override // com.google.firebase.perf.v1.PerfMetricOrBuilder
    public GaugeMetric getGaugeMetric() {
        GaugeMetric gaugeMetric = this.gaugeMetric_;
        return gaugeMetric == null ? GaugeMetric.getDefaultInstance() : gaugeMetric;
    }

    @Override // com.google.firebase.perf.v1.PerfMetricOrBuilder
    public NetworkRequestMetric getNetworkRequestMetric() {
        NetworkRequestMetric networkRequestMetric = this.networkRequestMetric_;
        return networkRequestMetric == null ? NetworkRequestMetric.getDefaultInstance() : networkRequestMetric;
    }

    @Override // com.google.firebase.perf.v1.PerfMetricOrBuilder
    public TraceMetric getTraceMetric() {
        TraceMetric traceMetric = this.traceMetric_;
        return traceMetric == null ? TraceMetric.getDefaultInstance() : traceMetric;
    }

    @Override // com.google.firebase.perf.v1.PerfMetricOrBuilder
    public TransportInfo getTransportInfo() {
        TransportInfo transportInfo = this.transportInfo_;
        return transportInfo == null ? TransportInfo.getDefaultInstance() : transportInfo;
    }

    @Override // com.google.firebase.perf.v1.PerfMetricOrBuilder
    public boolean hasApplicationInfo() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.google.firebase.perf.v1.PerfMetricOrBuilder
    public boolean hasGaugeMetric() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // com.google.firebase.perf.v1.PerfMetricOrBuilder
    public boolean hasNetworkRequestMetric() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // com.google.firebase.perf.v1.PerfMetricOrBuilder
    public boolean hasTraceMetric() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // com.google.firebase.perf.v1.PerfMetricOrBuilder
    public boolean hasTransportInfo() {
        return (this.bitField0_ & 16) != 0;
    }

    public static Builder newBuilder(PerfMetric perfMetric) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(perfMetric);
    }

    public static PerfMetric parseDelimitedFrom(InputStream inputStream, i05 i05) throws IOException {
        return (PerfMetric) q05.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, i05);
    }

    public static PerfMetric parseFrom(ByteBuffer byteBuffer, i05 i05) throws t05 {
        return (PerfMetric) q05.parseFrom(DEFAULT_INSTANCE, byteBuffer, i05);
    }

    public static PerfMetric parseFrom(a05 a05) throws t05 {
        return (PerfMetric) q05.parseFrom(DEFAULT_INSTANCE, a05);
    }

    public static PerfMetric parseFrom(a05 a05, i05 i05) throws t05 {
        return (PerfMetric) q05.parseFrom(DEFAULT_INSTANCE, a05, i05);
    }

    public static PerfMetric parseFrom(byte[] bArr) throws t05 {
        return (PerfMetric) q05.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PerfMetric parseFrom(byte[] bArr, i05 i05) throws t05 {
        return (PerfMetric) q05.parseFrom(DEFAULT_INSTANCE, bArr, i05);
    }

    public static PerfMetric parseFrom(InputStream inputStream) throws IOException {
        return (PerfMetric) q05.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PerfMetric parseFrom(InputStream inputStream, i05 i05) throws IOException {
        return (PerfMetric) q05.parseFrom(DEFAULT_INSTANCE, inputStream, i05);
    }

    public static PerfMetric parseFrom(b05 b05) throws IOException {
        return (PerfMetric) q05.parseFrom(DEFAULT_INSTANCE, b05);
    }

    public static PerfMetric parseFrom(b05 b05, i05 i05) throws IOException {
        return (PerfMetric) q05.parseFrom(DEFAULT_INSTANCE, b05, i05);
    }
}
