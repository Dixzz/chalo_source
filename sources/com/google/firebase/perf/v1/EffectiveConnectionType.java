package com.google.firebase.perf.v1;

import defpackage.s05;

public enum EffectiveConnectionType implements s05.c {
    EFFECTIVE_CONNECTION_TYPE_UNKNOWN(0),
    EFFECTIVE_CONNECTION_TYPE_SLOW_2G(1),
    EFFECTIVE_CONNECTION_TYPE_2G(2),
    EFFECTIVE_CONNECTION_TYPE_3G(3),
    EFFECTIVE_CONNECTION_TYPE_4G(4);
    
    public static final int EFFECTIVE_CONNECTION_TYPE_2G_VALUE = 2;
    public static final int EFFECTIVE_CONNECTION_TYPE_3G_VALUE = 3;
    public static final int EFFECTIVE_CONNECTION_TYPE_4G_VALUE = 4;
    public static final int EFFECTIVE_CONNECTION_TYPE_SLOW_2G_VALUE = 1;
    public static final int EFFECTIVE_CONNECTION_TYPE_UNKNOWN_VALUE = 0;
    private static final s05.d<EffectiveConnectionType> internalValueMap = new s05.d<EffectiveConnectionType>() {
        /* class com.google.firebase.perf.v1.EffectiveConnectionType.AnonymousClass1 */

        @Override // defpackage.s05.d
        public EffectiveConnectionType findValueByNumber(int i) {
            return EffectiveConnectionType.forNumber(i);
        }
    };
    private final int value;

    public static final class EffectiveConnectionTypeVerifier implements s05.e {
        public static final s05.e INSTANCE = new EffectiveConnectionTypeVerifier();

        private EffectiveConnectionTypeVerifier() {
        }

        @Override // defpackage.s05.e
        public boolean isInRange(int i) {
            return EffectiveConnectionType.forNumber(i) != null;
        }
    }

    private EffectiveConnectionType(int i) {
        this.value = i;
    }

    public static EffectiveConnectionType forNumber(int i) {
        if (i == 0) {
            return EFFECTIVE_CONNECTION_TYPE_UNKNOWN;
        }
        if (i == 1) {
            return EFFECTIVE_CONNECTION_TYPE_SLOW_2G;
        }
        if (i == 2) {
            return EFFECTIVE_CONNECTION_TYPE_2G;
        }
        if (i == 3) {
            return EFFECTIVE_CONNECTION_TYPE_3G;
        }
        if (i != 4) {
            return null;
        }
        return EFFECTIVE_CONNECTION_TYPE_4G;
    }

    public static s05.d<EffectiveConnectionType> internalGetValueMap() {
        return internalValueMap;
    }

    public static s05.e internalGetVerifier() {
        return EffectiveConnectionTypeVerifier.INSTANCE;
    }

    @Override // defpackage.s05.c
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static EffectiveConnectionType valueOf(int i) {
        return forNumber(i);
    }
}
