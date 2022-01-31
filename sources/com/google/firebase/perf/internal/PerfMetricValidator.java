package com.google.firebase.perf.internal;

import android.content.Context;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.Constants;
import com.google.firebase.perf.v1.PerfMetric;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public abstract class PerfMetricValidator {
    private static List<PerfMetricValidator> getValidators(PerfMetric perfMetric, Context context) {
        ArrayList arrayList = new ArrayList();
        if (perfMetric.hasTraceMetric()) {
            arrayList.add(new FirebasePerfTraceValidator(perfMetric.getTraceMetric()));
        }
        if (perfMetric.hasNetworkRequestMetric()) {
            arrayList.add(new FirebasePerfNetworkValidator(perfMetric.getNetworkRequestMetric(), context));
        }
        if (perfMetric.hasApplicationInfo()) {
            arrayList.add(new FirebasePerfApplicationInfoValidator(perfMetric.getApplicationInfo()));
        }
        if (perfMetric.hasGaugeMetric()) {
            arrayList.add(new FirebasePerfGaugeMetricValidator(perfMetric.getGaugeMetric()));
        }
        return arrayList;
    }

    public static boolean isValid(PerfMetric perfMetric, Context context) {
        List<PerfMetricValidator> validators = getValidators(perfMetric, context);
        if (validators.isEmpty()) {
            AndroidLogger.getInstance().debug("No validators found for PerfMetric.", new Object[0]);
            return false;
        }
        for (PerfMetricValidator perfMetricValidator : validators) {
            if (!perfMetricValidator.isValidPerfMetric()) {
                return false;
            }
        }
        return true;
    }

    public static String validateAttribute(Map.Entry<String, String> entry) {
        String key = entry.getKey();
        String value = entry.getValue();
        if (key == null) {
            return "Attribute key must not be null";
        }
        if (value == null) {
            return "Attribute value must not be null";
        }
        if (key.length() > 40) {
            return String.format(Locale.US, "Attribute key length must not exceed %d characters", 40);
        } else if (value.length() > 100) {
            return String.format(Locale.US, "Attribute value length must not exceed %d characters", 100);
        } else if (!key.matches("^(?!(firebase_|google_|ga_))[A-Za-z][A-Za-z_0-9]*")) {
            return "Attribute key must start with letter, must only contain alphanumeric characters and underscore and must not start with \"firebase_\", \"google_\" and \"ga_";
        } else {
            return null;
        }
    }

    public static String validateMetricName(String str) {
        if (str == null) {
            return "Metric name must not be null";
        }
        if (str.length() > 100) {
            return String.format(Locale.US, "Metric name must not exceed %d characters", 100);
        } else if (!str.startsWith("_")) {
            return null;
        } else {
            Constants.CounterNames[] values = Constants.CounterNames.values();
            for (int i = 0; i < 6; i++) {
                if (values[i].toString().equals(str)) {
                    return null;
                }
            }
            return "Metric name must not start with '_'";
        }
    }

    public static String validateTraceName(String str) {
        if (str == null) {
            return "Trace name must not be null";
        }
        if (str.length() > 100) {
            return String.format(Locale.US, "Trace name must not exceed %d characters", 100);
        } else if (!str.startsWith("_")) {
            return null;
        } else {
            Constants.TraceNames[] values = Constants.TraceNames.values();
            for (int i = 0; i < 6; i++) {
                if (values[i].toString().equals(str)) {
                    return null;
                }
            }
            if (str.startsWith(Constants.SCREEN_TRACE_PREFIX)) {
                return null;
            }
            return "Trace name must not start with '_'";
        }
    }

    public abstract boolean isValidPerfMetric();
}
