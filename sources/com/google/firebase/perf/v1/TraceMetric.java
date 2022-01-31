package com.google.firebase.perf.v1;

import com.google.firebase.perf.v1.PerfSession;
import defpackage.q05;
import defpackage.s05;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class TraceMetric extends q05<TraceMetric, Builder> implements TraceMetricOrBuilder {
    public static final int CLIENT_START_TIME_US_FIELD_NUMBER = 4;
    public static final int COUNTERS_FIELD_NUMBER = 6;
    public static final int CUSTOM_ATTRIBUTES_FIELD_NUMBER = 8;
    private static final TraceMetric DEFAULT_INSTANCE;
    public static final int DURATION_US_FIELD_NUMBER = 5;
    public static final int IS_AUTO_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile q15<TraceMetric> PARSER = null;
    public static final int PERF_SESSIONS_FIELD_NUMBER = 9;
    public static final int SUBTRACES_FIELD_NUMBER = 7;
    private int bitField0_;
    private long clientStartTimeUs_;
    private d15<String, Long> counters_;
    private d15<String, String> customAttributes_;
    private long durationUs_;
    private boolean isAuto_;
    private String name_ = "";
    private s05.j<PerfSession> perfSessions_ = q05.emptyProtobufList();
    private s05.j<TraceMetric> subtraces_ = q05.emptyProtobufList();

    /* renamed from: com.google.firebase.perf.v1.TraceMetric$1  reason: invalid class name */
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
                com.google.firebase.perf.v1.TraceMetric.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = r1
                r2 = 1
                r3 = 3
                q05$f r4 = defpackage.q05.f.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x000e }
                r1[r3] = r2     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                r1 = 2
                r4 = 4
                int[] r5 = com.google.firebase.perf.v1.TraceMetric.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0016 }
                q05$f r6 = defpackage.q05.f.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x0016 }
                r5[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                int[] r5 = com.google.firebase.perf.v1.TraceMetric.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x001c }
                q05$f r6 = defpackage.q05.f.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x001c }
                r5[r1] = r3     // Catch:{ NoSuchFieldError -> 0x001c }
            L_0x001c:
                r1 = 5
                int[] r3 = com.google.firebase.perf.v1.TraceMetric.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0023 }
                q05$f r5 = defpackage.q05.f.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0023 }
                r3[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0023 }
            L_0x0023:
                r3 = 6
                int[] r4 = com.google.firebase.perf.v1.TraceMetric.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x002a }
                q05$f r5 = defpackage.q05.f.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x002a }
                r4[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r1 = com.google.firebase.perf.v1.TraceMetric.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0031 }
                q05$f r4 = defpackage.q05.f.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0031 }
                r4 = 0
                r1[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0031 }
            L_0x0031:
                int[] r1 = com.google.firebase.perf.v1.TraceMetric.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0037 }
                q05$f r3 = defpackage.q05.f.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0037 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0037 }
            L_0x0037:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.v1.TraceMetric.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class Builder extends q05.a<TraceMetric, Builder> implements TraceMetricOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        public Builder addAllPerfSessions(Iterable<? extends PerfSession> iterable) {
            copyOnWrite();
            ((TraceMetric) this.instance).addAllPerfSessions(iterable);
            return this;
        }

        public Builder addAllSubtraces(Iterable<? extends TraceMetric> iterable) {
            copyOnWrite();
            ((TraceMetric) this.instance).addAllSubtraces(iterable);
            return this;
        }

        public Builder addPerfSessions(PerfSession perfSession) {
            copyOnWrite();
            ((TraceMetric) this.instance).addPerfSessions(perfSession);
            return this;
        }

        public Builder addSubtraces(TraceMetric traceMetric) {
            copyOnWrite();
            ((TraceMetric) this.instance).addSubtraces(traceMetric);
            return this;
        }

        public Builder clearClientStartTimeUs() {
            copyOnWrite();
            ((TraceMetric) this.instance).clearClientStartTimeUs();
            return this;
        }

        public Builder clearCounters() {
            copyOnWrite();
            ((TraceMetric) this.instance).getMutableCountersMap().clear();
            return this;
        }

        public Builder clearCustomAttributes() {
            copyOnWrite();
            ((TraceMetric) this.instance).getMutableCustomAttributesMap().clear();
            return this;
        }

        public Builder clearDurationUs() {
            copyOnWrite();
            ((TraceMetric) this.instance).clearDurationUs();
            return this;
        }

        public Builder clearIsAuto() {
            copyOnWrite();
            ((TraceMetric) this.instance).clearIsAuto();
            return this;
        }

        public Builder clearName() {
            copyOnWrite();
            ((TraceMetric) this.instance).clearName();
            return this;
        }

        public Builder clearPerfSessions() {
            copyOnWrite();
            ((TraceMetric) this.instance).clearPerfSessions();
            return this;
        }

        public Builder clearSubtraces() {
            copyOnWrite();
            ((TraceMetric) this.instance).clearSubtraces();
            return this;
        }

        @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
        public boolean containsCounters(String str) {
            str.getClass();
            return ((TraceMetric) this.instance).getCountersMap().containsKey(str);
        }

        @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
        public boolean containsCustomAttributes(String str) {
            str.getClass();
            return ((TraceMetric) this.instance).getCustomAttributesMap().containsKey(str);
        }

        @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
        public long getClientStartTimeUs() {
            return ((TraceMetric) this.instance).getClientStartTimeUs();
        }

        @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
        @Deprecated
        public Map<String, Long> getCounters() {
            return getCountersMap();
        }

        @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
        public int getCountersCount() {
            return ((TraceMetric) this.instance).getCountersMap().size();
        }

        @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
        public Map<String, Long> getCountersMap() {
            return Collections.unmodifiableMap(((TraceMetric) this.instance).getCountersMap());
        }

        @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
        public long getCountersOrDefault(String str, long j) {
            str.getClass();
            Map<String, Long> countersMap = ((TraceMetric) this.instance).getCountersMap();
            return countersMap.containsKey(str) ? countersMap.get(str).longValue() : j;
        }

        @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
        public long getCountersOrThrow(String str) {
            str.getClass();
            Map<String, Long> countersMap = ((TraceMetric) this.instance).getCountersMap();
            if (countersMap.containsKey(str)) {
                return countersMap.get(str).longValue();
            }
            throw new IllegalArgumentException();
        }

        @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
        @Deprecated
        public Map<String, String> getCustomAttributes() {
            return getCustomAttributesMap();
        }

        @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
        public int getCustomAttributesCount() {
            return ((TraceMetric) this.instance).getCustomAttributesMap().size();
        }

        @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
        public Map<String, String> getCustomAttributesMap() {
            return Collections.unmodifiableMap(((TraceMetric) this.instance).getCustomAttributesMap());
        }

        @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
        public String getCustomAttributesOrDefault(String str, String str2) {
            str.getClass();
            Map<String, String> customAttributesMap = ((TraceMetric) this.instance).getCustomAttributesMap();
            return customAttributesMap.containsKey(str) ? customAttributesMap.get(str) : str2;
        }

        @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
        public String getCustomAttributesOrThrow(String str) {
            str.getClass();
            Map<String, String> customAttributesMap = ((TraceMetric) this.instance).getCustomAttributesMap();
            if (customAttributesMap.containsKey(str)) {
                return customAttributesMap.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
        public long getDurationUs() {
            return ((TraceMetric) this.instance).getDurationUs();
        }

        @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
        public boolean getIsAuto() {
            return ((TraceMetric) this.instance).getIsAuto();
        }

        @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
        public String getName() {
            return ((TraceMetric) this.instance).getName();
        }

        @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
        public a05 getNameBytes() {
            return ((TraceMetric) this.instance).getNameBytes();
        }

        @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
        public PerfSession getPerfSessions(int i) {
            return ((TraceMetric) this.instance).getPerfSessions(i);
        }

        @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
        public int getPerfSessionsCount() {
            return ((TraceMetric) this.instance).getPerfSessionsCount();
        }

        @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
        public List<PerfSession> getPerfSessionsList() {
            return Collections.unmodifiableList(((TraceMetric) this.instance).getPerfSessionsList());
        }

        @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
        public TraceMetric getSubtraces(int i) {
            return ((TraceMetric) this.instance).getSubtraces(i);
        }

        @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
        public int getSubtracesCount() {
            return ((TraceMetric) this.instance).getSubtracesCount();
        }

        @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
        public List<TraceMetric> getSubtracesList() {
            return Collections.unmodifiableList(((TraceMetric) this.instance).getSubtracesList());
        }

        @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
        public boolean hasClientStartTimeUs() {
            return ((TraceMetric) this.instance).hasClientStartTimeUs();
        }

        @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
        public boolean hasDurationUs() {
            return ((TraceMetric) this.instance).hasDurationUs();
        }

        @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
        public boolean hasIsAuto() {
            return ((TraceMetric) this.instance).hasIsAuto();
        }

        @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
        public boolean hasName() {
            return ((TraceMetric) this.instance).hasName();
        }

        public Builder putAllCounters(Map<String, Long> map) {
            copyOnWrite();
            ((TraceMetric) this.instance).getMutableCountersMap().putAll(map);
            return this;
        }

        public Builder putAllCustomAttributes(Map<String, String> map) {
            copyOnWrite();
            ((TraceMetric) this.instance).getMutableCustomAttributesMap().putAll(map);
            return this;
        }

        public Builder putCounters(String str, long j) {
            str.getClass();
            copyOnWrite();
            ((TraceMetric) this.instance).getMutableCountersMap().put(str, Long.valueOf(j));
            return this;
        }

        public Builder putCustomAttributes(String str, String str2) {
            str.getClass();
            str2.getClass();
            copyOnWrite();
            ((TraceMetric) this.instance).getMutableCustomAttributesMap().put(str, str2);
            return this;
        }

        public Builder removeCounters(String str) {
            str.getClass();
            copyOnWrite();
            ((TraceMetric) this.instance).getMutableCountersMap().remove(str);
            return this;
        }

        public Builder removeCustomAttributes(String str) {
            str.getClass();
            copyOnWrite();
            ((TraceMetric) this.instance).getMutableCustomAttributesMap().remove(str);
            return this;
        }

        public Builder removePerfSessions(int i) {
            copyOnWrite();
            ((TraceMetric) this.instance).removePerfSessions(i);
            return this;
        }

        public Builder removeSubtraces(int i) {
            copyOnWrite();
            ((TraceMetric) this.instance).removeSubtraces(i);
            return this;
        }

        public Builder setClientStartTimeUs(long j) {
            copyOnWrite();
            ((TraceMetric) this.instance).setClientStartTimeUs(j);
            return this;
        }

        public Builder setDurationUs(long j) {
            copyOnWrite();
            ((TraceMetric) this.instance).setDurationUs(j);
            return this;
        }

        public Builder setIsAuto(boolean z) {
            copyOnWrite();
            ((TraceMetric) this.instance).setIsAuto(z);
            return this;
        }

        public Builder setName(String str) {
            copyOnWrite();
            ((TraceMetric) this.instance).setName(str);
            return this;
        }

        public Builder setNameBytes(a05 a05) {
            copyOnWrite();
            ((TraceMetric) this.instance).setNameBytes(a05);
            return this;
        }

        public Builder setPerfSessions(int i, PerfSession perfSession) {
            copyOnWrite();
            ((TraceMetric) this.instance).setPerfSessions(i, perfSession);
            return this;
        }

        public Builder setSubtraces(int i, TraceMetric traceMetric) {
            copyOnWrite();
            ((TraceMetric) this.instance).setSubtraces(i, traceMetric);
            return this;
        }

        private Builder() {
            super(TraceMetric.DEFAULT_INSTANCE);
        }

        public Builder addPerfSessions(int i, PerfSession perfSession) {
            copyOnWrite();
            ((TraceMetric) this.instance).addPerfSessions(i, perfSession);
            return this;
        }

        public Builder addSubtraces(int i, TraceMetric traceMetric) {
            copyOnWrite();
            ((TraceMetric) this.instance).addSubtraces(i, traceMetric);
            return this;
        }

        public Builder setPerfSessions(int i, PerfSession.Builder builder) {
            copyOnWrite();
            ((TraceMetric) this.instance).setPerfSessions(i, (PerfSession) builder.build());
            return this;
        }

        public Builder setSubtraces(int i, Builder builder) {
            copyOnWrite();
            ((TraceMetric) this.instance).setSubtraces(i, (TraceMetric) builder.build());
            return this;
        }

        public Builder addPerfSessions(PerfSession.Builder builder) {
            copyOnWrite();
            ((TraceMetric) this.instance).addPerfSessions((PerfSession) builder.build());
            return this;
        }

        public Builder addSubtraces(Builder builder) {
            copyOnWrite();
            ((TraceMetric) this.instance).addSubtraces((TraceMetric) builder.build());
            return this;
        }

        public Builder addPerfSessions(int i, PerfSession.Builder builder) {
            copyOnWrite();
            ((TraceMetric) this.instance).addPerfSessions(i, (PerfSession) builder.build());
            return this;
        }

        public Builder addSubtraces(int i, Builder builder) {
            copyOnWrite();
            ((TraceMetric) this.instance).addSubtraces(i, (TraceMetric) builder.build());
            return this;
        }
    }

    public static final class CountersDefaultEntryHolder {
        public static final c15<String, Long> defaultEntry = new c15<>(l25.STRING, "", l25.INT64, 0L);

        private CountersDefaultEntryHolder() {
        }
    }

    public static final class CustomAttributesDefaultEntryHolder {
        public static final c15<String, String> defaultEntry;

        static {
            l25 l25 = l25.STRING;
            defaultEntry = new c15<>(l25, "", l25, "");
        }

        private CustomAttributesDefaultEntryHolder() {
        }
    }

    static {
        TraceMetric traceMetric = new TraceMetric();
        DEFAULT_INSTANCE = traceMetric;
        q05.registerDefaultInstance(TraceMetric.class, traceMetric);
    }

    private TraceMetric() {
        d15 d15 = d15.g;
        this.counters_ = d15;
        this.customAttributes_ = d15;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addAllPerfSessions(Iterable<? extends PerfSession> iterable) {
        ensurePerfSessionsIsMutable();
        rz4.addAll((Iterable) iterable, (List) this.perfSessions_);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addAllSubtraces(Iterable<? extends TraceMetric> iterable) {
        ensureSubtracesIsMutable();
        rz4.addAll((Iterable) iterable, (List) this.subtraces_);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addPerfSessions(PerfSession perfSession) {
        perfSession.getClass();
        ensurePerfSessionsIsMutable();
        this.perfSessions_.add(perfSession);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addSubtraces(TraceMetric traceMetric) {
        traceMetric.getClass();
        ensureSubtracesIsMutable();
        this.subtraces_.add(traceMetric);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearClientStartTimeUs() {
        this.bitField0_ &= -5;
        this.clientStartTimeUs_ = 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearDurationUs() {
        this.bitField0_ &= -9;
        this.durationUs_ = 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearIsAuto() {
        this.bitField0_ &= -3;
        this.isAuto_ = false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearName() {
        this.bitField0_ &= -2;
        this.name_ = getDefaultInstance().getName();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearPerfSessions() {
        this.perfSessions_ = q05.emptyProtobufList();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearSubtraces() {
        this.subtraces_ = q05.emptyProtobufList();
    }

    private void ensurePerfSessionsIsMutable() {
        if (!this.perfSessions_.t()) {
            this.perfSessions_ = q05.mutableCopy(this.perfSessions_);
        }
    }

    private void ensureSubtracesIsMutable() {
        if (!this.subtraces_.t()) {
            this.subtraces_ = q05.mutableCopy(this.subtraces_);
        }
    }

    public static TraceMetric getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Map<String, Long> getMutableCountersMap() {
        return internalGetMutableCounters();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Map<String, String> getMutableCustomAttributesMap() {
        return internalGetMutableCustomAttributes();
    }

    private d15<String, Long> internalGetCounters() {
        return this.counters_;
    }

    private d15<String, String> internalGetCustomAttributes() {
        return this.customAttributes_;
    }

    private d15<String, Long> internalGetMutableCounters() {
        d15<String, Long> d15 = this.counters_;
        if (!d15.f) {
            this.counters_ = d15.c();
        }
        return this.counters_;
    }

    private d15<String, String> internalGetMutableCustomAttributes() {
        d15<String, String> d15 = this.customAttributes_;
        if (!d15.f) {
            this.customAttributes_ = d15.c();
        }
        return this.customAttributes_;
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static TraceMetric parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (TraceMetric) q05.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TraceMetric parseFrom(ByteBuffer byteBuffer) throws t05 {
        return (TraceMetric) q05.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static q15<TraceMetric> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void removePerfSessions(int i) {
        ensurePerfSessionsIsMutable();
        this.perfSessions_.remove(i);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void removeSubtraces(int i) {
        ensureSubtracesIsMutable();
        this.subtraces_.remove(i);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setClientStartTimeUs(long j) {
        this.bitField0_ |= 4;
        this.clientStartTimeUs_ = j;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setDurationUs(long j) {
        this.bitField0_ |= 8;
        this.durationUs_ = j;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setIsAuto(boolean z) {
        this.bitField0_ |= 2;
        this.isAuto_ = z;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setName(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.name_ = str;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setNameBytes(a05 a05) {
        this.name_ = a05.B();
        this.bitField0_ |= 1;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setPerfSessions(int i, PerfSession perfSession) {
        perfSession.getClass();
        ensurePerfSessionsIsMutable();
        this.perfSessions_.set(i, perfSession);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setSubtraces(int i, TraceMetric traceMetric) {
        traceMetric.getClass();
        ensureSubtracesIsMutable();
        this.subtraces_.set(i, traceMetric);
    }

    @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
    public boolean containsCounters(String str) {
        str.getClass();
        return internalGetCounters().containsKey(str);
    }

    @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
    public boolean containsCustomAttributes(String str) {
        str.getClass();
        return internalGetCustomAttributes().containsKey(str);
    }

    @Override // defpackage.q05
    public final Object dynamicMethod(q05.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return q05.newMessageInfo(DEFAULT_INSTANCE, "\u0001\b\u0000\u0001\u0001\t\b\u0002\u0002\u0000\u0001\b\u0000\u0002\u0007\u0001\u0004\u0002\u0002\u0005\u0002\u0003\u00062\u0007\u001b\b2\t\u001b", new Object[]{"bitField0_", "name_", "isAuto_", "clientStartTimeUs_", "durationUs_", "counters_", CountersDefaultEntryHolder.defaultEntry, "subtraces_", TraceMetric.class, "customAttributes_", CustomAttributesDefaultEntryHolder.defaultEntry, "perfSessions_", PerfSession.class});
            case 3:
                return new TraceMetric();
            case 4:
                return new Builder(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                q15<TraceMetric> q15 = PARSER;
                if (q15 == null) {
                    synchronized (TraceMetric.class) {
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

    @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
    public long getClientStartTimeUs() {
        return this.clientStartTimeUs_;
    }

    @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
    @Deprecated
    public Map<String, Long> getCounters() {
        return getCountersMap();
    }

    @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
    public int getCountersCount() {
        return internalGetCounters().size();
    }

    @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
    public Map<String, Long> getCountersMap() {
        return Collections.unmodifiableMap(internalGetCounters());
    }

    @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
    public long getCountersOrDefault(String str, long j) {
        str.getClass();
        d15<String, Long> internalGetCounters = internalGetCounters();
        return internalGetCounters.containsKey(str) ? internalGetCounters.get(str).longValue() : j;
    }

    @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
    public long getCountersOrThrow(String str) {
        str.getClass();
        d15<String, Long> internalGetCounters = internalGetCounters();
        if (internalGetCounters.containsKey(str)) {
            return internalGetCounters.get(str).longValue();
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
    @Deprecated
    public Map<String, String> getCustomAttributes() {
        return getCustomAttributesMap();
    }

    @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
    public int getCustomAttributesCount() {
        return internalGetCustomAttributes().size();
    }

    @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
    public Map<String, String> getCustomAttributesMap() {
        return Collections.unmodifiableMap(internalGetCustomAttributes());
    }

    @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
    public String getCustomAttributesOrDefault(String str, String str2) {
        str.getClass();
        d15<String, String> internalGetCustomAttributes = internalGetCustomAttributes();
        return internalGetCustomAttributes.containsKey(str) ? internalGetCustomAttributes.get(str) : str2;
    }

    @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
    public String getCustomAttributesOrThrow(String str) {
        str.getClass();
        d15<String, String> internalGetCustomAttributes = internalGetCustomAttributes();
        if (internalGetCustomAttributes.containsKey(str)) {
            return internalGetCustomAttributes.get(str);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
    public long getDurationUs() {
        return this.durationUs_;
    }

    @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
    public boolean getIsAuto() {
        return this.isAuto_;
    }

    @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
    public String getName() {
        return this.name_;
    }

    @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
    public a05 getNameBytes() {
        return a05.k(this.name_);
    }

    @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
    public PerfSession getPerfSessions(int i) {
        return this.perfSessions_.get(i);
    }

    @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
    public int getPerfSessionsCount() {
        return this.perfSessions_.size();
    }

    @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
    public List<PerfSession> getPerfSessionsList() {
        return this.perfSessions_;
    }

    public PerfSessionOrBuilder getPerfSessionsOrBuilder(int i) {
        return this.perfSessions_.get(i);
    }

    public List<? extends PerfSessionOrBuilder> getPerfSessionsOrBuilderList() {
        return this.perfSessions_;
    }

    @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
    public TraceMetric getSubtraces(int i) {
        return this.subtraces_.get(i);
    }

    @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
    public int getSubtracesCount() {
        return this.subtraces_.size();
    }

    @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
    public List<TraceMetric> getSubtracesList() {
        return this.subtraces_;
    }

    public TraceMetricOrBuilder getSubtracesOrBuilder(int i) {
        return this.subtraces_.get(i);
    }

    public List<? extends TraceMetricOrBuilder> getSubtracesOrBuilderList() {
        return this.subtraces_;
    }

    @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
    public boolean hasClientStartTimeUs() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
    public boolean hasDurationUs() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
    public boolean hasIsAuto() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
    public boolean hasName() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(TraceMetric traceMetric) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(traceMetric);
    }

    public static TraceMetric parseDelimitedFrom(InputStream inputStream, i05 i05) throws IOException {
        return (TraceMetric) q05.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, i05);
    }

    public static TraceMetric parseFrom(ByteBuffer byteBuffer, i05 i05) throws t05 {
        return (TraceMetric) q05.parseFrom(DEFAULT_INSTANCE, byteBuffer, i05);
    }

    public static TraceMetric parseFrom(a05 a05) throws t05 {
        return (TraceMetric) q05.parseFrom(DEFAULT_INSTANCE, a05);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addPerfSessions(int i, PerfSession perfSession) {
        perfSession.getClass();
        ensurePerfSessionsIsMutable();
        this.perfSessions_.add(i, perfSession);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addSubtraces(int i, TraceMetric traceMetric) {
        traceMetric.getClass();
        ensureSubtracesIsMutable();
        this.subtraces_.add(i, traceMetric);
    }

    public static TraceMetric parseFrom(a05 a05, i05 i05) throws t05 {
        return (TraceMetric) q05.parseFrom(DEFAULT_INSTANCE, a05, i05);
    }

    public static TraceMetric parseFrom(byte[] bArr) throws t05 {
        return (TraceMetric) q05.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static TraceMetric parseFrom(byte[] bArr, i05 i05) throws t05 {
        return (TraceMetric) q05.parseFrom(DEFAULT_INSTANCE, bArr, i05);
    }

    public static TraceMetric parseFrom(InputStream inputStream) throws IOException {
        return (TraceMetric) q05.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TraceMetric parseFrom(InputStream inputStream, i05 i05) throws IOException {
        return (TraceMetric) q05.parseFrom(DEFAULT_INSTANCE, inputStream, i05);
    }

    public static TraceMetric parseFrom(b05 b05) throws IOException {
        return (TraceMetric) q05.parseFrom(DEFAULT_INSTANCE, b05);
    }

    public static TraceMetric parseFrom(b05 b05, i05 i05) throws IOException {
        return (TraceMetric) q05.parseFrom(DEFAULT_INSTANCE, b05, i05);
    }
}
