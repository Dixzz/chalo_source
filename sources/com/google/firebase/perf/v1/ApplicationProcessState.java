package com.google.firebase.perf.v1;

import defpackage.s05;

public enum ApplicationProcessState implements s05.c {
    APPLICATION_PROCESS_STATE_UNKNOWN(0),
    FOREGROUND(1),
    BACKGROUND(2),
    FOREGROUND_BACKGROUND(3);
    
    public static final int APPLICATION_PROCESS_STATE_UNKNOWN_VALUE = 0;
    public static final int BACKGROUND_VALUE = 2;
    public static final int FOREGROUND_BACKGROUND_VALUE = 3;
    public static final int FOREGROUND_VALUE = 1;
    private static final s05.d<ApplicationProcessState> internalValueMap = new s05.d<ApplicationProcessState>() {
        /* class com.google.firebase.perf.v1.ApplicationProcessState.AnonymousClass1 */

        @Override // defpackage.s05.d
        public ApplicationProcessState findValueByNumber(int i) {
            return ApplicationProcessState.forNumber(i);
        }
    };
    private final int value;

    public static final class ApplicationProcessStateVerifier implements s05.e {
        public static final s05.e INSTANCE = new ApplicationProcessStateVerifier();

        private ApplicationProcessStateVerifier() {
        }

        @Override // defpackage.s05.e
        public boolean isInRange(int i) {
            return ApplicationProcessState.forNumber(i) != null;
        }
    }

    private ApplicationProcessState(int i) {
        this.value = i;
    }

    public static ApplicationProcessState forNumber(int i) {
        if (i == 0) {
            return APPLICATION_PROCESS_STATE_UNKNOWN;
        }
        if (i == 1) {
            return FOREGROUND;
        }
        if (i == 2) {
            return BACKGROUND;
        }
        if (i != 3) {
            return null;
        }
        return FOREGROUND_BACKGROUND;
    }

    public static s05.d<ApplicationProcessState> internalGetValueMap() {
        return internalValueMap;
    }

    public static s05.e internalGetVerifier() {
        return ApplicationProcessStateVerifier.INSTANCE;
    }

    @Override // defpackage.s05.c
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static ApplicationProcessState valueOf(int i) {
        return forNumber(i);
    }
}
