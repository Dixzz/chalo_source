package com.google.firebase.perf.v1;

public interface CpuMetricReadingOrBuilder extends k15 {
    long getClientTimeUs();

    @Override // defpackage.k15
    /* synthetic */ j15 getDefaultInstanceForType();

    long getSystemTimeUs();

    long getUserTimeUs();

    boolean hasClientTimeUs();

    boolean hasSystemTimeUs();

    boolean hasUserTimeUs();

    @Override // defpackage.k15
    /* synthetic */ boolean isInitialized();
}
