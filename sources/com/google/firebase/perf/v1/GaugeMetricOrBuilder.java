package com.google.firebase.perf.v1;

import java.util.List;

public interface GaugeMetricOrBuilder extends k15 {
    AndroidMemoryReading getAndroidMemoryReadings(int i);

    int getAndroidMemoryReadingsCount();

    List<AndroidMemoryReading> getAndroidMemoryReadingsList();

    CpuMetricReading getCpuMetricReadings(int i);

    int getCpuMetricReadingsCount();

    List<CpuMetricReading> getCpuMetricReadingsList();

    @Override // defpackage.k15
    /* synthetic */ j15 getDefaultInstanceForType();

    GaugeMetadata getGaugeMetadata();

    IosMemoryReading getIosMemoryReadings(int i);

    int getIosMemoryReadingsCount();

    List<IosMemoryReading> getIosMemoryReadingsList();

    String getSessionId();

    a05 getSessionIdBytes();

    boolean hasGaugeMetadata();

    boolean hasSessionId();

    @Override // defpackage.k15
    /* synthetic */ boolean isInitialized();
}
