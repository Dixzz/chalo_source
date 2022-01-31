package com.google.firebase.perf.transport;

import android.content.Context;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.internal.ResourceType;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.Clock;
import com.google.firebase.perf.util.Constants;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.util.Utils;
import com.google.firebase.perf.v1.PerfMetric;
import com.google.firebase.perf.v1.PerfSession;
import com.google.firebase.perf.v1.SessionVerbosity;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public final class RateLimiter {
    private final ConfigResolver configResolver;
    private boolean isLogcatEnabled;
    private RateLimiterImpl mNetworkLimiter;
    private RateLimiterImpl mTraceLimiter;
    private final float samplingBucketId;

    public static class RateLimiterImpl {
        private static final long MICROS_IN_A_SECOND = TimeUnit.SECONDS.toMicros(1);
        private static final AndroidLogger logger = AndroidLogger.getInstance();
        private final boolean isLogcatEnabled;
        private long mBackgroundCapacity;
        private double mBackgroundRate;
        private long mCapacity;
        private final Clock mClock;
        private long mForegroundCapacity;
        private double mForegroundRate;
        private Timer mLastTimeTokenConsumed;
        private double mRate;
        private long mTokenCount;

        public RateLimiterImpl(double d, long j, Clock clock, ConfigResolver configResolver, @ResourceType String str, boolean z) {
            this.mClock = clock;
            this.mCapacity = j;
            this.mRate = d;
            this.mTokenCount = j;
            this.mLastTimeTokenConsumed = clock.getTime();
            setRateByReadingRemoteConfigValues(configResolver, str, z);
            this.isLogcatEnabled = z;
        }

        private static long getBlimitEvents(ConfigResolver configResolver, @ResourceType String str) {
            if (str == ResourceType.TRACE) {
                return configResolver.getTraceEventCountBackground();
            }
            return configResolver.getNetworkEventCountBackground();
        }

        private static long getBlimitSec(ConfigResolver configResolver, @ResourceType String str) {
            if (str == ResourceType.TRACE) {
                return configResolver.getRateLimitSec();
            }
            return configResolver.getRateLimitSec();
        }

        private static long getFlimitEvents(ConfigResolver configResolver, @ResourceType String str) {
            if (str == ResourceType.TRACE) {
                return configResolver.getTraceEventCountForeground();
            }
            return configResolver.getNetworkEventCountForeground();
        }

        private static long getFlimitSec(ConfigResolver configResolver, @ResourceType String str) {
            if (str == ResourceType.TRACE) {
                return configResolver.getRateLimitSec();
            }
            return configResolver.getRateLimitSec();
        }

        private void setRateByReadingRemoteConfigValues(ConfigResolver configResolver, @ResourceType String str, boolean z) {
            long flimitSec = getFlimitSec(configResolver, str);
            long flimitEvents = getFlimitEvents(configResolver, str);
            double d = ((double) flimitEvents) / ((double) flimitSec);
            this.mForegroundRate = d;
            this.mForegroundCapacity = flimitEvents;
            if (z) {
                logger.debug(String.format(Locale.ENGLISH, "Foreground %s logging rate:%f, burst capacity:%d", str, Double.valueOf(d), Long.valueOf(this.mForegroundCapacity)), new Object[0]);
            }
            long blimitSec = getBlimitSec(configResolver, str);
            long blimitEvents = getBlimitEvents(configResolver, str);
            double d2 = ((double) blimitEvents) / ((double) blimitSec);
            this.mBackgroundRate = d2;
            this.mBackgroundCapacity = blimitEvents;
            if (z) {
                logger.debug(String.format(Locale.ENGLISH, "Background %s logging rate:%f, capacity:%d", str, Double.valueOf(d2), Long.valueOf(this.mBackgroundCapacity)), new Object[0]);
            }
        }

        public synchronized void changeRate(boolean z) {
            this.mRate = z ? this.mForegroundRate : this.mBackgroundRate;
            this.mCapacity = z ? this.mForegroundCapacity : this.mBackgroundCapacity;
        }

        public synchronized boolean check(PerfMetric perfMetric) {
            Timer time = this.mClock.getTime();
            long min = Math.min(this.mTokenCount + Math.max(0L, (long) ((((double) this.mLastTimeTokenConsumed.getDurationMicros(time)) * this.mRate) / ((double) MICROS_IN_A_SECOND))), this.mCapacity);
            this.mTokenCount = min;
            if (min > 0) {
                this.mTokenCount = min - 1;
                this.mLastTimeTokenConsumed = time;
                return true;
            }
            if (this.isLogcatEnabled) {
                logger.warn("Exceeded log rate limit, dropping the log.", new Object[0]);
            }
            return false;
        }

        public long getBackgroundCapacity() {
            return this.mBackgroundCapacity;
        }

        public double getBackgroundRate() {
            return this.mBackgroundRate;
        }

        public long getForegroundCapacity() {
            return this.mForegroundCapacity;
        }

        public double getForegroundRate() {
            return this.mForegroundRate;
        }

        public double getRate() {
            return this.mRate;
        }

        public void setRate(double d) {
            this.mRate = d;
        }
    }

    public RateLimiter(Context context, double d, long j) {
        this(d, j, new Clock(), getSamplingBucketId(), ConfigResolver.getInstance());
        this.isLogcatEnabled = Utils.isDebugLoggingEnabled(context);
    }

    public static float getSamplingBucketId() {
        return new Random().nextFloat();
    }

    private boolean hasVerboseSessions(List<PerfSession> list) {
        if (list.size() <= 0 || list.get(0).getSessionVerbosityCount() <= 0 || list.get(0).getSessionVerbosity(0) != SessionVerbosity.GAUGES_AND_SYSTEM_EVENTS) {
            return false;
        }
        return true;
    }

    private boolean isDeviceAllowedToSendNetworkEvents() {
        return this.samplingBucketId < this.configResolver.getNetworkRequestSamplingRate();
    }

    private boolean isDeviceAllowedToSendTraces() {
        return this.samplingBucketId < this.configResolver.getTraceSamplingRate();
    }

    public void changeRate(boolean z) {
        this.mTraceLimiter.changeRate(z);
        this.mNetworkLimiter.changeRate(z);
    }

    public boolean check(PerfMetric perfMetric) {
        if (perfMetric.hasTraceMetric() && !isDeviceAllowedToSendTraces() && !hasVerboseSessions(perfMetric.getTraceMetric().getPerfSessionsList())) {
            return false;
        }
        if (perfMetric.hasNetworkRequestMetric() && !isDeviceAllowedToSendNetworkEvents() && !hasVerboseSessions(perfMetric.getNetworkRequestMetric().getPerfSessionsList())) {
            return false;
        }
        if (!isRateLimited(perfMetric)) {
            return true;
        }
        if (perfMetric.hasNetworkRequestMetric()) {
            return this.mNetworkLimiter.check(perfMetric);
        }
        if (perfMetric.hasTraceMetric()) {
            return this.mTraceLimiter.check(perfMetric);
        }
        return false;
    }

    public boolean getIsDeviceAllowedToSendNetworkEvents() {
        return isDeviceAllowedToSendNetworkEvents();
    }

    public boolean getIsDeviceAllowedToSendTraces() {
        return isDeviceAllowedToSendTraces();
    }

    public boolean isRateLimited(PerfMetric perfMetric) {
        if ((!perfMetric.hasTraceMetric() || ((!perfMetric.getTraceMetric().getName().equals(Constants.TraceNames.FOREGROUND_TRACE_NAME.toString()) && !perfMetric.getTraceMetric().getName().equals(Constants.TraceNames.BACKGROUND_TRACE_NAME.toString())) || perfMetric.getTraceMetric().getCountersCount() <= 0)) && !perfMetric.hasGaugeMetric()) {
            return true;
        }
        return false;
    }

    public RateLimiter(double d, long j, Clock clock, float f, ConfigResolver configResolver2) {
        boolean z = false;
        this.isLogcatEnabled = false;
        this.mTraceLimiter = null;
        this.mNetworkLimiter = null;
        if (0.0f <= f && f < 1.0f) {
            z = true;
        }
        Utils.checkArgument(z, "Sampling bucket ID should be in range [0.0f, 1.0f).");
        this.samplingBucketId = f;
        this.configResolver = configResolver2;
        this.mTraceLimiter = new RateLimiterImpl(d, j, clock, configResolver2, ResourceType.TRACE, this.isLogcatEnabled);
        this.mNetworkLimiter = new RateLimiterImpl(d, j, clock, configResolver2, ResourceType.NETWORK, this.isLogcatEnabled);
    }
}
