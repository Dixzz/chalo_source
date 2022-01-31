package com.google.firebase.perf.internal;

import com.google.firebase.perf.v1.ApplicationProcessState;

/* compiled from: GaugeManager */
public final /* synthetic */ class GaugeManager$$Lambda$1 implements Runnable {
    private final GaugeManager arg$1;
    private final String arg$2;
    private final ApplicationProcessState arg$3;

    private GaugeManager$$Lambda$1(GaugeManager gaugeManager, String str, ApplicationProcessState applicationProcessState) {
        this.arg$1 = gaugeManager;
        this.arg$2 = str;
        this.arg$3 = applicationProcessState;
    }

    public static Runnable lambdaFactory$(GaugeManager gaugeManager, String str, ApplicationProcessState applicationProcessState) {
        return new GaugeManager$$Lambda$1(gaugeManager, str, applicationProcessState);
    }

    public void run() {
        this.arg$1.syncFlush(this.arg$2, this.arg$3);
    }
}
