package com.google.firebase.perf.internal;

import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.v1.TraceMetric;
import java.util.Map;

public final class FirebasePerfTraceValidator extends PerfMetricValidator {
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private TraceMetric mTraceMetric;

    public FirebasePerfTraceValidator(TraceMetric traceMetric) {
        this.mTraceMetric = traceMetric;
    }

    private boolean areCountersValid(TraceMetric traceMetric) {
        return areCountersValid(traceMetric, 0);
    }

    private boolean hasCounters(TraceMetric traceMetric) {
        boolean z;
        if (traceMetric.getCountersCount() > 0) {
            return true;
        }
        for (TraceMetric traceMetric2 : traceMetric.getSubtracesList()) {
            if (traceMetric2.getCountersCount() > 0) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    private boolean hasValidAttibutes(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String validateAttribute = PerfMetricValidator.validateAttribute(entry);
            if (validateAttribute != null) {
                logger.warn(validateAttribute, new Object[0]);
                return false;
            }
        }
        return true;
    }

    private boolean isValidCounterId(String str) {
        if (str == null) {
            return false;
        }
        String trim = str.trim();
        if (trim.isEmpty()) {
            logger.warn("counterId is empty", new Object[0]);
            return false;
        } else if (trim.length() <= 100) {
            return true;
        } else {
            logger.warn("counterId exceeded max length 100", new Object[0]);
            return false;
        }
    }

    private boolean isValidCounterValue(Long l) {
        return l != null;
    }

    private boolean isValidTrace(TraceMetric traceMetric, int i) {
        if (traceMetric == null) {
            logger.warn("TraceMetric is null", new Object[0]);
            return false;
        } else if (i > 1) {
            logger.warn("Exceed MAX_SUBTRACE_DEEP:1", new Object[0]);
            return false;
        } else if (!isValidTraceId(traceMetric.getName())) {
            AndroidLogger androidLogger = logger;
            StringBuilder i0 = hj1.i0("invalid TraceId:");
            i0.append(traceMetric.getName());
            androidLogger.warn(i0.toString(), new Object[0]);
            return false;
        } else if (!isValidTraceDuration(traceMetric)) {
            AndroidLogger androidLogger2 = logger;
            StringBuilder i02 = hj1.i0("invalid TraceDuration:");
            i02.append(traceMetric.getDurationUs());
            androidLogger2.warn(i02.toString(), new Object[0]);
            return false;
        } else if (!traceMetric.hasClientStartTimeUs()) {
            logger.warn("clientStartTimeUs is null.", new Object[0]);
            return false;
        } else {
            for (TraceMetric traceMetric2 : traceMetric.getSubtracesList()) {
                if (!isValidTrace(traceMetric2, i + 1)) {
                    return false;
                }
            }
            return hasValidAttibutes(traceMetric.getCustomAttributesMap());
        }
    }

    private boolean isValidTraceDuration(TraceMetric traceMetric) {
        return traceMetric != null && traceMetric.getDurationUs() > 0;
    }

    private boolean isValidTraceId(String str) {
        if (str == null) {
            return false;
        }
        String trim = str.trim();
        if (trim.isEmpty() || trim.length() > 100) {
            return false;
        }
        return true;
    }

    @Override // com.google.firebase.perf.internal.PerfMetricValidator
    public boolean isValidPerfMetric() {
        if (!isValidTrace(this.mTraceMetric, 0)) {
            AndroidLogger androidLogger = logger;
            StringBuilder i0 = hj1.i0("Invalid Trace:");
            i0.append(this.mTraceMetric.getName());
            androidLogger.warn(i0.toString(), new Object[0]);
            return false;
        } else if (!hasCounters(this.mTraceMetric) || areCountersValid(this.mTraceMetric)) {
            return true;
        } else {
            AndroidLogger androidLogger2 = logger;
            StringBuilder i02 = hj1.i0("Invalid Counters for Trace:");
            i02.append(this.mTraceMetric.getName());
            androidLogger2.warn(i02.toString(), new Object[0]);
            return false;
        }
    }

    private boolean areCountersValid(TraceMetric traceMetric, int i) {
        if (traceMetric == null) {
            return false;
        }
        if (i > 1) {
            logger.warn("Exceed MAX_SUBTRACE_DEEP:1", new Object[0]);
            return false;
        }
        for (Map.Entry<String, Long> entry : traceMetric.getCountersMap().entrySet()) {
            if (!isValidCounterId(entry.getKey())) {
                AndroidLogger androidLogger = logger;
                StringBuilder i0 = hj1.i0("invalid CounterId:");
                i0.append(entry.getKey());
                androidLogger.warn(i0.toString(), new Object[0]);
                return false;
            } else if (!isValidCounterValue(entry.getValue())) {
                AndroidLogger androidLogger2 = logger;
                StringBuilder i02 = hj1.i0("invalid CounterValue:");
                i02.append(entry.getValue());
                androidLogger2.warn(i02.toString(), new Object[0]);
                return false;
            }
        }
        for (TraceMetric traceMetric2 : traceMetric.getSubtracesList()) {
            if (!areCountersValid(traceMetric2, i + 1)) {
                return false;
            }
        }
        return true;
    }
}
