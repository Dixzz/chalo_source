package com.google.firebase.perf.v1;

import defpackage.s05;

public enum ServiceWorkerStatus implements s05.c {
    SERVICE_WORKER_STATUS_UNKNOWN(0),
    UNSUPPORTED(1),
    CONTROLLED(2),
    UNCONTROLLED(3);
    
    public static final int CONTROLLED_VALUE = 2;
    public static final int SERVICE_WORKER_STATUS_UNKNOWN_VALUE = 0;
    public static final int UNCONTROLLED_VALUE = 3;
    public static final int UNSUPPORTED_VALUE = 1;
    private static final s05.d<ServiceWorkerStatus> internalValueMap = new s05.d<ServiceWorkerStatus>() {
        /* class com.google.firebase.perf.v1.ServiceWorkerStatus.AnonymousClass1 */

        @Override // defpackage.s05.d
        public ServiceWorkerStatus findValueByNumber(int i) {
            return ServiceWorkerStatus.forNumber(i);
        }
    };
    private final int value;

    public static final class ServiceWorkerStatusVerifier implements s05.e {
        public static final s05.e INSTANCE = new ServiceWorkerStatusVerifier();

        private ServiceWorkerStatusVerifier() {
        }

        @Override // defpackage.s05.e
        public boolean isInRange(int i) {
            return ServiceWorkerStatus.forNumber(i) != null;
        }
    }

    private ServiceWorkerStatus(int i) {
        this.value = i;
    }

    public static ServiceWorkerStatus forNumber(int i) {
        if (i == 0) {
            return SERVICE_WORKER_STATUS_UNKNOWN;
        }
        if (i == 1) {
            return UNSUPPORTED;
        }
        if (i == 2) {
            return CONTROLLED;
        }
        if (i != 3) {
            return null;
        }
        return UNCONTROLLED;
    }

    public static s05.d<ServiceWorkerStatus> internalGetValueMap() {
        return internalValueMap;
    }

    public static s05.e internalGetVerifier() {
        return ServiceWorkerStatusVerifier.INSTANCE;
    }

    @Override // defpackage.s05.c
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static ServiceWorkerStatus valueOf(int i) {
        return forNumber(i);
    }
}
