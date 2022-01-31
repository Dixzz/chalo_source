package com.google.firebase.perf.v1;

public interface GaugeMetadataOrBuilder extends k15 {
    int getCpuClockRateKhz();

    int getCpuProcessorCount();

    @Override // defpackage.k15
    /* synthetic */ j15 getDefaultInstanceForType();

    int getDeviceRamSizeKb();

    int getMaxAppJavaHeapMemoryKb();

    int getMaxEncouragedAppJavaHeapMemoryKb();

    String getProcessName();

    a05 getProcessNameBytes();

    boolean hasCpuClockRateKhz();

    boolean hasCpuProcessorCount();

    boolean hasDeviceRamSizeKb();

    boolean hasMaxAppJavaHeapMemoryKb();

    boolean hasMaxEncouragedAppJavaHeapMemoryKb();

    boolean hasProcessName();

    @Override // defpackage.k15
    /* synthetic */ boolean isInitialized();
}
