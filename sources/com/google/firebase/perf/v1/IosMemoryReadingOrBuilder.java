package com.google.firebase.perf.v1;

public interface IosMemoryReadingOrBuilder extends k15 {
    long getClientTimeUs();

    @Override // defpackage.k15
    /* synthetic */ j15 getDefaultInstanceForType();

    int getFreeAppHeapMemoryKb();

    int getUsedAppHeapMemoryKb();

    boolean hasClientTimeUs();

    boolean hasFreeAppHeapMemoryKb();

    boolean hasUsedAppHeapMemoryKb();

    @Override // defpackage.k15
    /* synthetic */ boolean isInitialized();
}
