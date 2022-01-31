package com.crashlytics.android.answers;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Objects;
import java.util.Random;

public class RandomBackoff implements c16 {
    public final c16 backoff;
    public final double jitterPercent;
    public final Random random;

    public RandomBackoff(c16 c16, double d) {
        this(c16, d, new Random());
    }

    @Override // defpackage.c16
    public long getDelayMillis(int i) {
        return (long) (randomJitter() * ((double) this.backoff.getDelayMillis(i)));
    }

    public double randomJitter() {
        double d = this.jitterPercent;
        double d2 = 1.0d - d;
        return (((d + 1.0d) - d2) * this.random.nextDouble()) + d2;
    }

    public RandomBackoff(c16 c16, double d, Random random2) {
        if (d < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || d > 1.0d) {
            throw new IllegalArgumentException("jitterPercent must be between 0.0 and 1.0");
        }
        Objects.requireNonNull(c16, "backoff must not be null");
        Objects.requireNonNull(random2, "random must not be null");
        this.backoff = c16;
        this.jitterPercent = d;
        this.random = random2;
    }
}
