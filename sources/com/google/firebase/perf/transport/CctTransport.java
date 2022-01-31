package com.google.firebase.perf.transport;

import android.content.Context;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.v1.PerfMetric;
import defpackage.i12;
import java.util.Objects;

public final class CctTransport {
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private i12 cctLogger;
    private final Context context;
    private final String logSourceName;

    public CctTransport(Context context2, String str) {
        this(context2, str, null);
    }

    private boolean initializeCctTransportClient() {
        if (this.cctLogger == null) {
            try {
                Context context2 = this.context;
                this.cctLogger = new i12(context2, this.logSourceName, null, true, new ji2(context2), db2.f817a, new al2(context2));
            } catch (Exception e) {
                logger.warn("Init Cct Logger failed with exception: %s", e.getMessage());
            }
        }
        if (this.cctLogger != null) {
            return true;
        }
        return false;
    }

    public void log(PerfMetric perfMetric) {
        if (!initializeCctTransportClient()) {
            logger.warn("Unable to dispatch event because Cct Logger is not available", new Object[0]);
            return;
        }
        try {
            i12 i12 = this.cctLogger;
            byte[] byteArray = perfMetric.toByteArray();
            Objects.requireNonNull(i12);
            new i12.a(byteArray, null).a();
            logger.info("Event is dispatched via Cct Transport", new Object[0]);
        } catch (Exception e) {
            logger.warn("Dispatch with Cct Logger failed with exception: %s", e.getMessage());
        }
    }

    public CctTransport(Context context2, String str, i12 i12) {
        this.context = context2;
        this.logSourceName = str;
        this.cctLogger = i12;
    }
}
