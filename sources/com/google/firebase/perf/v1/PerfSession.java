package com.google.firebase.perf.v1;

import defpackage.q05;
import defpackage.s05;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class PerfSession extends q05<PerfSession, Builder> implements PerfSessionOrBuilder {
    private static final PerfSession DEFAULT_INSTANCE;
    private static volatile q15<PerfSession> PARSER = null;
    public static final int SESSION_ID_FIELD_NUMBER = 1;
    public static final int SESSION_VERBOSITY_FIELD_NUMBER = 2;
    private static final s05.h.a<Integer, SessionVerbosity> sessionVerbosity_converter_ = new s05.h.a<Integer, SessionVerbosity>() {
        /* class com.google.firebase.perf.v1.PerfSession.AnonymousClass1 */

        public SessionVerbosity convert(Integer num) {
            SessionVerbosity forNumber = SessionVerbosity.forNumber(num.intValue());
            return forNumber == null ? SessionVerbosity.SESSION_VERBOSITY_NONE : forNumber;
        }
    };
    private int bitField0_;
    private String sessionId_ = "";
    private s05.g sessionVerbosity_ = q05.emptyIntList();

    /* renamed from: com.google.firebase.perf.v1.PerfSession$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
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
                com.google.firebase.perf.v1.PerfSession.AnonymousClass2.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = r1
                r2 = 1
                r3 = 3
                q05$f r4 = defpackage.q05.f.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x000e }
                r1[r3] = r2     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                r1 = 2
                r4 = 4
                int[] r5 = com.google.firebase.perf.v1.PerfSession.AnonymousClass2.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0016 }
                q05$f r6 = defpackage.q05.f.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x0016 }
                r5[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                int[] r5 = com.google.firebase.perf.v1.PerfSession.AnonymousClass2.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x001c }
                q05$f r6 = defpackage.q05.f.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x001c }
                r5[r1] = r3     // Catch:{ NoSuchFieldError -> 0x001c }
            L_0x001c:
                r1 = 5
                int[] r3 = com.google.firebase.perf.v1.PerfSession.AnonymousClass2.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0023 }
                q05$f r5 = defpackage.q05.f.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0023 }
                r3[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0023 }
            L_0x0023:
                r3 = 6
                int[] r4 = com.google.firebase.perf.v1.PerfSession.AnonymousClass2.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x002a }
                q05$f r5 = defpackage.q05.f.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x002a }
                r4[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r1 = com.google.firebase.perf.v1.PerfSession.AnonymousClass2.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0031 }
                q05$f r4 = defpackage.q05.f.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0031 }
                r4 = 0
                r1[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0031 }
            L_0x0031:
                int[] r1 = com.google.firebase.perf.v1.PerfSession.AnonymousClass2.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0037 }
                q05$f r3 = defpackage.q05.f.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0037 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0037 }
            L_0x0037:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.v1.PerfSession.AnonymousClass2.<clinit>():void");
        }
    }

    public static final class Builder extends q05.a<PerfSession, Builder> implements PerfSessionOrBuilder {
        public Builder addAllSessionVerbosity(Iterable<? extends SessionVerbosity> iterable) {
            copyOnWrite();
            ((PerfSession) this.instance).addAllSessionVerbosity(iterable);
            return this;
        }

        public Builder addSessionVerbosity(SessionVerbosity sessionVerbosity) {
            copyOnWrite();
            ((PerfSession) this.instance).addSessionVerbosity(sessionVerbosity);
            return this;
        }

        public Builder clearSessionId() {
            copyOnWrite();
            ((PerfSession) this.instance).clearSessionId();
            return this;
        }

        public Builder clearSessionVerbosity() {
            copyOnWrite();
            ((PerfSession) this.instance).clearSessionVerbosity();
            return this;
        }

        @Override // com.google.firebase.perf.v1.PerfSessionOrBuilder
        public String getSessionId() {
            return ((PerfSession) this.instance).getSessionId();
        }

        @Override // com.google.firebase.perf.v1.PerfSessionOrBuilder
        public a05 getSessionIdBytes() {
            return ((PerfSession) this.instance).getSessionIdBytes();
        }

        @Override // com.google.firebase.perf.v1.PerfSessionOrBuilder
        public SessionVerbosity getSessionVerbosity(int i) {
            return ((PerfSession) this.instance).getSessionVerbosity(i);
        }

        @Override // com.google.firebase.perf.v1.PerfSessionOrBuilder
        public int getSessionVerbosityCount() {
            return ((PerfSession) this.instance).getSessionVerbosityCount();
        }

        @Override // com.google.firebase.perf.v1.PerfSessionOrBuilder
        public List<SessionVerbosity> getSessionVerbosityList() {
            return ((PerfSession) this.instance).getSessionVerbosityList();
        }

        @Override // com.google.firebase.perf.v1.PerfSessionOrBuilder
        public boolean hasSessionId() {
            return ((PerfSession) this.instance).hasSessionId();
        }

        public Builder setSessionId(String str) {
            copyOnWrite();
            ((PerfSession) this.instance).setSessionId(str);
            return this;
        }

        public Builder setSessionIdBytes(a05 a05) {
            copyOnWrite();
            ((PerfSession) this.instance).setSessionIdBytes(a05);
            return this;
        }

        public Builder setSessionVerbosity(int i, SessionVerbosity sessionVerbosity) {
            copyOnWrite();
            ((PerfSession) this.instance).setSessionVerbosity(i, sessionVerbosity);
            return this;
        }

        private Builder() {
            super(PerfSession.DEFAULT_INSTANCE);
        }
    }

    static {
        PerfSession perfSession = new PerfSession();
        DEFAULT_INSTANCE = perfSession;
        q05.registerDefaultInstance(PerfSession.class, perfSession);
    }

    private PerfSession() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addAllSessionVerbosity(Iterable<? extends SessionVerbosity> iterable) {
        ensureSessionVerbosityIsMutable();
        for (SessionVerbosity sessionVerbosity : iterable) {
            ((r05) this.sessionVerbosity_).d(sessionVerbosity.getNumber());
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addSessionVerbosity(SessionVerbosity sessionVerbosity) {
        sessionVerbosity.getClass();
        ensureSessionVerbosityIsMutable();
        ((r05) this.sessionVerbosity_).d(sessionVerbosity.getNumber());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearSessionId() {
        this.bitField0_ &= -2;
        this.sessionId_ = getDefaultInstance().getSessionId();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearSessionVerbosity() {
        this.sessionVerbosity_ = q05.emptyIntList();
    }

    private void ensureSessionVerbosityIsMutable() {
        s05.g gVar = this.sessionVerbosity_;
        if (!((tz4) gVar).f) {
            this.sessionVerbosity_ = q05.mutableCopy(gVar);
        }
    }

    public static PerfSession getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static PerfSession parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (PerfSession) q05.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PerfSession parseFrom(ByteBuffer byteBuffer) throws t05 {
        return (PerfSession) q05.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static q15<PerfSession> parser() {
        return DEFAULT_INSTANCE.getParserForType();
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

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setSessionVerbosity(int i, SessionVerbosity sessionVerbosity) {
        sessionVerbosity.getClass();
        ensureSessionVerbosityIsMutable();
        s05.g gVar = this.sessionVerbosity_;
        int number = sessionVerbosity.getNumber();
        r05 r05 = (r05) gVar;
        r05.b();
        r05.e(i);
        int[] iArr = r05.g;
        int i2 = iArr[i];
        iArr[i] = number;
    }

    @Override // defpackage.q05
    public final Object dynamicMethod(q05.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return q05.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\b\u0000\u0002\u001e", new Object[]{"bitField0_", "sessionId_", "sessionVerbosity_", SessionVerbosity.internalGetVerifier()});
            case 3:
                return new PerfSession();
            case 4:
                return new Builder();
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                q15<PerfSession> q15 = PARSER;
                if (q15 == null) {
                    synchronized (PerfSession.class) {
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

    @Override // com.google.firebase.perf.v1.PerfSessionOrBuilder
    public String getSessionId() {
        return this.sessionId_;
    }

    @Override // com.google.firebase.perf.v1.PerfSessionOrBuilder
    public a05 getSessionIdBytes() {
        return a05.k(this.sessionId_);
    }

    @Override // com.google.firebase.perf.v1.PerfSessionOrBuilder
    public SessionVerbosity getSessionVerbosity(int i) {
        s05.h.a<Integer, SessionVerbosity> aVar = sessionVerbosity_converter_;
        r05 r05 = (r05) this.sessionVerbosity_;
        r05.e(i);
        return aVar.convert(Integer.valueOf(r05.g[i]));
    }

    @Override // com.google.firebase.perf.v1.PerfSessionOrBuilder
    public int getSessionVerbosityCount() {
        return ((r05) this.sessionVerbosity_).size();
    }

    @Override // com.google.firebase.perf.v1.PerfSessionOrBuilder
    public List<SessionVerbosity> getSessionVerbosityList() {
        return new s05.h(this.sessionVerbosity_, sessionVerbosity_converter_);
    }

    @Override // com.google.firebase.perf.v1.PerfSessionOrBuilder
    public boolean hasSessionId() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(PerfSession perfSession) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(perfSession);
    }

    public static PerfSession parseDelimitedFrom(InputStream inputStream, i05 i05) throws IOException {
        return (PerfSession) q05.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, i05);
    }

    public static PerfSession parseFrom(ByteBuffer byteBuffer, i05 i05) throws t05 {
        return (PerfSession) q05.parseFrom(DEFAULT_INSTANCE, byteBuffer, i05);
    }

    public static PerfSession parseFrom(a05 a05) throws t05 {
        return (PerfSession) q05.parseFrom(DEFAULT_INSTANCE, a05);
    }

    public static PerfSession parseFrom(a05 a05, i05 i05) throws t05 {
        return (PerfSession) q05.parseFrom(DEFAULT_INSTANCE, a05, i05);
    }

    public static PerfSession parseFrom(byte[] bArr) throws t05 {
        return (PerfSession) q05.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PerfSession parseFrom(byte[] bArr, i05 i05) throws t05 {
        return (PerfSession) q05.parseFrom(DEFAULT_INSTANCE, bArr, i05);
    }

    public static PerfSession parseFrom(InputStream inputStream) throws IOException {
        return (PerfSession) q05.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PerfSession parseFrom(InputStream inputStream, i05 i05) throws IOException {
        return (PerfSession) q05.parseFrom(DEFAULT_INSTANCE, inputStream, i05);
    }

    public static PerfSession parseFrom(b05 b05) throws IOException {
        return (PerfSession) q05.parseFrom(DEFAULT_INSTANCE, b05);
    }

    public static PerfSession parseFrom(b05 b05, i05 i05) throws IOException {
        return (PerfSession) q05.parseFrom(DEFAULT_INSTANCE, b05, i05);
    }
}
