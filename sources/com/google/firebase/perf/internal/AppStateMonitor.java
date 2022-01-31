package com.google.firebase.perf.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.SparseIntArray;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.metrics.Trace;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Clock;
import com.google.firebase.perf.util.Constants;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.util.Utils;
import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.TraceMetric;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class AppStateMonitor implements Application.ActivityLifecycleCallbacks {
    private static final String FRAME_METRICS_AGGREGATOR_CLASSNAME = "androidx.core.app.FrameMetricsAggregator";
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private static volatile AppStateMonitor sInstance;
    private boolean hasFrameMetricsAggregator = false;
    private final WeakHashMap<Activity, Trace> mActivity2ScreenTrace = new WeakHashMap<>();
    private Set<WeakReference<AppStateCallback>> mClients = new HashSet();
    private final Clock mClock;
    private ConfigResolver mConfigResolver;
    private ApplicationProcessState mCurrentState = ApplicationProcessState.BACKGROUND;
    private z4 mFrameMetricsAggregator;
    private boolean mIsColdStart = true;
    private final Map<String, Long> mMetrics = new HashMap();
    private boolean mRegistered = false;
    private Timer mResumeTime;
    private final WeakHashMap<Activity, Boolean> mResumed = new WeakHashMap<>();
    private Timer mStopTime;
    private AtomicInteger mTsnsCount = new AtomicInteger(0);
    private final TransportManager transportManager;

    public interface AppStateCallback {
        void onUpdateAppState(ApplicationProcessState applicationProcessState);
    }

    public AppStateMonitor(TransportManager transportManager2, Clock clock) {
        this.transportManager = transportManager2;
        this.mClock = clock;
        this.mConfigResolver = ConfigResolver.getInstance();
        boolean hasFrameMetricsAggregatorClass = hasFrameMetricsAggregatorClass();
        this.hasFrameMetricsAggregator = hasFrameMetricsAggregatorClass;
        if (hasFrameMetricsAggregatorClass) {
            this.mFrameMetricsAggregator = new z4();
        }
    }

    public static AppStateMonitor getInstance() {
        if (sInstance == null) {
            synchronized (AppStateMonitor.class) {
                if (sInstance == null) {
                    sInstance = new AppStateMonitor(TransportManager.getInstance(), new Clock());
                }
            }
        }
        return sInstance;
    }

    public static String getScreenTraceName(Activity activity) {
        StringBuilder i0 = hj1.i0(Constants.SCREEN_TRACE_PREFIX);
        i0.append(activity.getClass().getSimpleName());
        return i0.toString();
    }

    private boolean hasFrameMetricsAggregatorClass() {
        try {
            Class.forName("z4");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private boolean isScreenTraceSupported(Activity activity) {
        return (!this.hasFrameMetricsAggregator || activity.getWindow() == null || (activity.getWindow().getAttributes().flags & 16777216) == 0) ? false : true;
    }

    private void sendScreenTrace(Activity activity) {
        Trace trace;
        int i;
        int i2;
        int i3;
        SparseIntArray sparseIntArray;
        if (this.mActivity2ScreenTrace.containsKey(activity) && (trace = this.mActivity2ScreenTrace.get(activity)) != null) {
            this.mActivity2ScreenTrace.remove(activity);
            SparseIntArray[] b = this.mFrameMetricsAggregator.f4121a.b(activity);
            if (b == null || (sparseIntArray = b[0]) == null) {
                i3 = 0;
                i2 = 0;
                i = 0;
            } else {
                i3 = 0;
                i2 = 0;
                i = 0;
                for (int i4 = 0; i4 < sparseIntArray.size(); i4++) {
                    int keyAt = sparseIntArray.keyAt(i4);
                    int valueAt = sparseIntArray.valueAt(i4);
                    i3 += valueAt;
                    if (keyAt > 700) {
                        i += valueAt;
                    }
                    if (keyAt > 16) {
                        i2 += valueAt;
                    }
                }
            }
            if (i3 > 0) {
                trace.putMetric(Constants.CounterNames.FRAMES_TOTAL.toString(), (long) i3);
            }
            if (i2 > 0) {
                trace.putMetric(Constants.CounterNames.FRAMES_SLOW.toString(), (long) i2);
            }
            if (i > 0) {
                trace.putMetric(Constants.CounterNames.FRAMES_FROZEN.toString(), (long) i);
            }
            if (Utils.isDebugLoggingEnabled(activity.getApplicationContext())) {
                AndroidLogger androidLogger = logger;
                StringBuilder i0 = hj1.i0("sendScreenTrace name:");
                i0.append(getScreenTraceName(activity));
                i0.append(" _fr_tot:");
                i0.append(i3);
                i0.append(" _fr_slo:");
                i0.append(i2);
                i0.append(" _fr_fzn:");
                i0.append(i);
                androidLogger.debug(i0.toString(), new Object[0]);
            }
            trace.stop();
        }
    }

    private void sendSessionLog(String str, Timer timer, Timer timer2) {
        if (this.mConfigResolver.isPerformanceMonitoringEnabled()) {
            TraceMetric.Builder addPerfSessions = TraceMetric.newBuilder().setName(str).setClientStartTimeUs(timer.getMicros()).setDurationUs(timer.getDurationMicros(timer2)).addPerfSessions(SessionManager.getInstance().perfSession().build());
            int andSet = this.mTsnsCount.getAndSet(0);
            synchronized (this.mMetrics) {
                addPerfSessions.putAllCounters(this.mMetrics);
                if (andSet != 0) {
                    addPerfSessions.putCounters(Constants.CounterNames.TRACE_STARTED_NOT_STOPPED.toString(), (long) andSet);
                }
                this.mMetrics.clear();
            }
            this.transportManager.log((TraceMetric) addPerfSessions.build(), ApplicationProcessState.FOREGROUND_BACKGROUND);
        }
    }

    private void updateAppState(ApplicationProcessState applicationProcessState) {
        this.mCurrentState = applicationProcessState;
        synchronized (this.mClients) {
            Iterator<WeakReference<AppStateCallback>> it = this.mClients.iterator();
            while (it.hasNext()) {
                AppStateCallback appStateCallback = it.next().get();
                if (appStateCallback != null) {
                    appStateCallback.onUpdateAppState(this.mCurrentState);
                } else {
                    it.remove();
                }
            }
        }
    }

    public WeakHashMap<Activity, Trace> getActivity2ScreenTrace() {
        return this.mActivity2ScreenTrace;
    }

    public ApplicationProcessState getAppState() {
        return this.mCurrentState;
    }

    public Timer getPauseTime() {
        return this.mStopTime;
    }

    public Timer getResumeTime() {
        return this.mResumeTime;
    }

    public WeakHashMap<Activity, Boolean> getResumed() {
        return this.mResumed;
    }

    public void incrementCount(String str, long j) {
        synchronized (this.mMetrics) {
            Long l = this.mMetrics.get(str);
            if (l == null) {
                this.mMetrics.put(str, Long.valueOf(j));
            } else {
                this.mMetrics.put(str, Long.valueOf(l.longValue() + j));
            }
        }
    }

    public void incrementTsnsCount(int i) {
        this.mTsnsCount.addAndGet(i);
    }

    public boolean isColdStart() {
        return this.mIsColdStart;
    }

    public boolean isForeground() {
        return this.mCurrentState == ApplicationProcessState.FOREGROUND;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public synchronized void onActivityResumed(Activity activity) {
        Boolean bool = Boolean.TRUE;
        synchronized (this) {
            if (this.mResumed.isEmpty()) {
                this.mResumeTime = this.mClock.getTime();
                this.mResumed.put(activity, bool);
                updateAppState(ApplicationProcessState.FOREGROUND);
                if (this.mIsColdStart) {
                    this.mIsColdStart = false;
                } else {
                    sendSessionLog(Constants.TraceNames.BACKGROUND_TRACE_NAME.toString(), this.mStopTime, this.mResumeTime);
                }
            } else {
                this.mResumed.put(activity, bool);
            }
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public synchronized void onActivityStarted(Activity activity) {
        if (isScreenTraceSupported(activity) && this.mConfigResolver.isPerformanceMonitoringEnabled()) {
            this.mFrameMetricsAggregator.f4121a.a(activity);
            Trace trace = new Trace(getScreenTraceName(activity), this.transportManager, this.mClock, this);
            trace.start();
            this.mActivity2ScreenTrace.put(activity, trace);
        }
    }

    public synchronized void onActivityStopped(Activity activity) {
        if (isScreenTraceSupported(activity)) {
            sendScreenTrace(activity);
        }
        if (this.mResumed.containsKey(activity)) {
            this.mResumed.remove(activity);
            if (this.mResumed.isEmpty()) {
                this.mStopTime = this.mClock.getTime();
                updateAppState(ApplicationProcessState.BACKGROUND);
                sendSessionLog(Constants.TraceNames.FOREGROUND_TRACE_NAME.toString(), this.mResumeTime, this.mStopTime);
            }
        }
    }

    public synchronized void registerActivityLifecycleCallbacks(Context context) {
        if (!this.mRegistered) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext instanceof Application) {
                ((Application) applicationContext).registerActivityLifecycleCallbacks(this);
                this.mRegistered = true;
            }
        }
    }

    public void registerForAppState(WeakReference<AppStateCallback> weakReference) {
        synchronized (this.mClients) {
            this.mClients.add(weakReference);
        }
    }

    public void setIsColdStart(boolean z) {
        this.mIsColdStart = z;
    }

    public synchronized void unregisterActivityLifecycleCallbacks(Context context) {
        if (this.mRegistered) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext instanceof Application) {
                ((Application) applicationContext).unregisterActivityLifecycleCallbacks(this);
                this.mRegistered = false;
            }
        }
    }

    public void unregisterForAppState(WeakReference<AppStateCallback> weakReference) {
        synchronized (this.mClients) {
            this.mClients.remove(weakReference);
        }
    }
}
