package com.google.firebase.perf.util;

import android.os.Bundle;
import com.google.firebase.perf.logging.AndroidLogger;

public final class ImmutableBundle {
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private final Bundle bundle;

    public ImmutableBundle() {
        this(new Bundle());
    }

    private Optional<Integer> getInt(String str) {
        if (!containsKey(str)) {
            return Optional.empty();
        }
        try {
            return Optional.ofNullable((Integer) this.bundle.get(str));
        } catch (ClassCastException e) {
            logger.debug(String.format("Metadata key %s contains type other than int: %s", str, e.getMessage()), new Object[0]);
            return Optional.empty();
        }
    }

    public boolean containsKey(String str) {
        return str != null && this.bundle.containsKey(str);
    }

    public Optional<Boolean> getBoolean(String str) {
        if (!containsKey(str)) {
            return Optional.empty();
        }
        try {
            return Optional.ofNullable((Boolean) this.bundle.get(str));
        } catch (ClassCastException e) {
            logger.debug(String.format("Metadata key %s contains type other than boolean: %s", str, e.getMessage()), new Object[0]);
            return Optional.empty();
        }
    }

    public Optional<Float> getFloat(String str) {
        if (!containsKey(str)) {
            return Optional.empty();
        }
        try {
            return Optional.ofNullable((Float) this.bundle.get(str));
        } catch (ClassCastException e) {
            logger.debug(String.format("Metadata key %s contains type other than float: %s", str, e.getMessage()), new Object[0]);
            return Optional.empty();
        }
    }

    public Optional<Long> getLong(String str) {
        Optional<Integer> optional = getInt(str);
        if (optional.isPresent()) {
            return Optional.of(Long.valueOf((long) optional.get().intValue()));
        }
        return Optional.empty();
    }

    public ImmutableBundle(Bundle bundle2) {
        this.bundle = (Bundle) bundle2.clone();
    }
}
