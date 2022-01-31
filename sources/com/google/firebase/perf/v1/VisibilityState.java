package com.google.firebase.perf.v1;

import defpackage.s05;

public enum VisibilityState implements s05.c {
    VISIBILITY_STATE_UNKNOWN(0),
    VISIBLE(1),
    HIDDEN(2),
    PRERENDER(3),
    UNLOADED(4);
    
    public static final int HIDDEN_VALUE = 2;
    public static final int PRERENDER_VALUE = 3;
    public static final int UNLOADED_VALUE = 4;
    public static final int VISIBILITY_STATE_UNKNOWN_VALUE = 0;
    public static final int VISIBLE_VALUE = 1;
    private static final s05.d<VisibilityState> internalValueMap = new s05.d<VisibilityState>() {
        /* class com.google.firebase.perf.v1.VisibilityState.AnonymousClass1 */

        @Override // defpackage.s05.d
        public VisibilityState findValueByNumber(int i) {
            return VisibilityState.forNumber(i);
        }
    };
    private final int value;

    public static final class VisibilityStateVerifier implements s05.e {
        public static final s05.e INSTANCE = new VisibilityStateVerifier();

        private VisibilityStateVerifier() {
        }

        @Override // defpackage.s05.e
        public boolean isInRange(int i) {
            return VisibilityState.forNumber(i) != null;
        }
    }

    private VisibilityState(int i) {
        this.value = i;
    }

    public static VisibilityState forNumber(int i) {
        if (i == 0) {
            return VISIBILITY_STATE_UNKNOWN;
        }
        if (i == 1) {
            return VISIBLE;
        }
        if (i == 2) {
            return HIDDEN;
        }
        if (i == 3) {
            return PRERENDER;
        }
        if (i != 4) {
            return null;
        }
        return UNLOADED;
    }

    public static s05.d<VisibilityState> internalGetValueMap() {
        return internalValueMap;
    }

    public static s05.e internalGetVerifier() {
        return VisibilityStateVerifier.INSTANCE;
    }

    @Override // defpackage.s05.c
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static VisibilityState valueOf(int i) {
        return forNumber(i);
    }
}
