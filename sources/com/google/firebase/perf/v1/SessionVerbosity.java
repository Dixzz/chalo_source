package com.google.firebase.perf.v1;

import defpackage.s05;

public enum SessionVerbosity implements s05.c {
    SESSION_VERBOSITY_NONE(0),
    GAUGES_AND_SYSTEM_EVENTS(1);
    
    public static final int GAUGES_AND_SYSTEM_EVENTS_VALUE = 1;
    public static final int SESSION_VERBOSITY_NONE_VALUE = 0;
    private static final s05.d<SessionVerbosity> internalValueMap = new s05.d<SessionVerbosity>() {
        /* class com.google.firebase.perf.v1.SessionVerbosity.AnonymousClass1 */

        @Override // defpackage.s05.d
        public SessionVerbosity findValueByNumber(int i) {
            return SessionVerbosity.forNumber(i);
        }
    };
    private final int value;

    public static final class SessionVerbosityVerifier implements s05.e {
        public static final s05.e INSTANCE = new SessionVerbosityVerifier();

        private SessionVerbosityVerifier() {
        }

        @Override // defpackage.s05.e
        public boolean isInRange(int i) {
            return SessionVerbosity.forNumber(i) != null;
        }
    }

    private SessionVerbosity(int i) {
        this.value = i;
    }

    public static SessionVerbosity forNumber(int i) {
        if (i == 0) {
            return SESSION_VERBOSITY_NONE;
        }
        if (i != 1) {
            return null;
        }
        return GAUGES_AND_SYSTEM_EVENTS;
    }

    public static s05.d<SessionVerbosity> internalGetValueMap() {
        return internalValueMap;
    }

    public static s05.e internalGetVerifier() {
        return SessionVerbosityVerifier.INSTANCE;
    }

    @Override // defpackage.s05.c
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static SessionVerbosity valueOf(int i) {
        return forNumber(i);
    }
}
