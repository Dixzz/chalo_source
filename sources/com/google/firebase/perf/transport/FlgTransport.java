package com.google.firebase.perf.transport;

import com.google.firebase.inject.Provider;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.v1.PerfMetric;

public final class FlgTransport {
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private du1<PerfMetric> flgTransport;
    private final Provider<eu1> flgTransportFactoryProvider;
    private final String logSourceName;

    public FlgTransport(Provider<eu1> provider, String str) {
        this.logSourceName = str;
        this.flgTransportFactoryProvider = provider;
    }

    private boolean initializeFlgTransportClient() {
        if (this.flgTransport == null) {
            eu1 eu1 = this.flgTransportFactoryProvider.get();
            if (eu1 != null) {
                this.flgTransport = eu1.a(this.logSourceName, PerfMetric.class, new zt1("proto"), FlgTransport$$Lambda$1.lambdaFactory$());
            } else {
                logger.warn("Flg TransportFactory is not available at the moment", new Object[0]);
            }
        }
        if (this.flgTransport != null) {
            return true;
        }
        return false;
    }

    public void log(PerfMetric perfMetric) {
        if (!initializeFlgTransportClient()) {
            logger.warn("Unable to dispatch event because Flg Transport is not available", new Object[0]);
            return;
        }
        ((lv1) this.flgTransport).a(new yt1(null, perfMetric, bu1.DEFAULT), av1.f335a);
        logger.info("Event is dispatched via Flg Transport", new Object[0]);
    }
}
