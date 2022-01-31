package com.google.firebase.perf.metrics;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.google.firebase.perf.internal.SessionManager;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.provider.FirebasePerfProvider;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Clock;
import com.google.firebase.perf.util.Constants;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.TraceMetric;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class AppStartTrace implements Application.ActivityLifecycleCallbacks {
    private static final long MAX_LATENCY_BEFORE_UI_INIT = TimeUnit.MINUTES.toMicros(1);
    private static volatile AppStartTrace sInstance;
    private Context mAppContext;
    private WeakReference<Activity> mAppStartActivity;
    private final Clock mClock;
    private boolean mIsStartFromBackground = false;
    private WeakReference<Activity> mLaunchActivity;
    private Timer mOnCreateTime = null;
    private Timer mOnResumeTime = null;
    private Timer mOnStartTime = null;
    private boolean mRegistered = false;
    private boolean mTooLateToInitUI = false;
    private final TransportManager transportManager;

    public static class StartFromBackgroundRunnable implements Runnable {
        private final AppStartTrace mTrace;

        public StartFromBackgroundRunnable(AppStartTrace appStartTrace) {
            this.mTrace = appStartTrace;
        }

        public void run() {
            if (this.mTrace.mOnCreateTime == null) {
                this.mTrace.mIsStartFromBackground = true;
            }
        }
    }

    public AppStartTrace(TransportManager transportManager2, Clock clock) {
        this.transportManager = transportManager2;
        this.mClock = clock;
    }

    public static AppStartTrace getInstance() {
        return sInstance != null ? sInstance : getInstance(TransportManager.getInstance(), new Clock());
    }

    @Keep
    public static void setLauncherActivityOnCreateTime(String str) {
    }

    @Keep
    public static void setLauncherActivityOnResumeTime(String str) {
    }

    @Keep
    public static void setLauncherActivityOnStartTime(String str) {
    }

    public Activity getAppStartActivity() {
        return this.mAppStartActivity.get();
    }

    public Activity getLaunchActivity() {
        return this.mLaunchActivity.get();
    }

    public Timer getOnCreateTime() {
        return this.mOnCreateTime;
    }

    public Timer getOnResumeTime() {
        return this.mOnResumeTime;
    }

    public Timer getOnStartTime() {
        return this.mOnStartTime;
    }

    public synchronized void onActivityCreated(Activity activity, Bundle bundle) {
        if (!this.mIsStartFromBackground) {
            if (this.mOnCreateTime == null) {
                this.mLaunchActivity = new WeakReference<>(activity);
                this.mOnCreateTime = this.mClock.getTime();
                if (FirebasePerfProvider.getAppStartTime().getDurationMicros(this.mOnCreateTime) > MAX_LATENCY_BEFORE_UI_INIT) {
                    this.mTooLateToInitUI = true;
                }
            }
        }
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public synchronized void onActivityResumed(Activity activity) {
        if (!this.mIsStartFromBackground && this.mOnResumeTime == null) {
            if (!this.mTooLateToInitUI) {
                this.mAppStartActivity = new WeakReference<>(activity);
                this.mOnResumeTime = this.mClock.getTime();
                Timer appStartTime = FirebasePerfProvider.getAppStartTime();
                AndroidLogger instance = AndroidLogger.getInstance();
                instance.debug("onResume(): " + activity.getClass().getName() + ": " + appStartTime.getDurationMicros(this.mOnResumeTime) + " microseconds", new Object[0]);
                TraceMetric.Builder durationUs = TraceMetric.newBuilder().setName(Constants.TraceNames.APP_START_TRACE_NAME.toString()).setClientStartTimeUs(appStartTime.getMicros()).setDurationUs(appStartTime.getDurationMicros(this.mOnResumeTime));
                ArrayList arrayList = new ArrayList(3);
                arrayList.add((TraceMetric) TraceMetric.newBuilder().setName(Constants.TraceNames.ON_CREATE_TRACE_NAME.toString()).setClientStartTimeUs(appStartTime.getMicros()).setDurationUs(appStartTime.getDurationMicros(this.mOnCreateTime)).build());
                TraceMetric.Builder newBuilder = TraceMetric.newBuilder();
                newBuilder.setName(Constants.TraceNames.ON_START_TRACE_NAME.toString()).setClientStartTimeUs(this.mOnCreateTime.getMicros()).setDurationUs(this.mOnCreateTime.getDurationMicros(this.mOnStartTime));
                arrayList.add((TraceMetric) newBuilder.build());
                TraceMetric.Builder newBuilder2 = TraceMetric.newBuilder();
                newBuilder2.setName(Constants.TraceNames.ON_RESUME_TRACE_NAME.toString()).setClientStartTimeUs(this.mOnStartTime.getMicros()).setDurationUs(this.mOnStartTime.getDurationMicros(this.mOnResumeTime));
                arrayList.add((TraceMetric) newBuilder2.build());
                durationUs.addAllSubtraces(arrayList).addPerfSessions(SessionManager.getInstance().perfSession().build());
                this.transportManager.log((TraceMetric) durationUs.build(), ApplicationProcessState.FOREGROUND_BACKGROUND);
                if (this.mRegistered) {
                    unregisterActivityLifecycleCallbacks();
                }
            }
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public synchronized void onActivityStarted(Activity activity) {
        if (!this.mIsStartFromBackground && this.mOnStartTime == null) {
            if (!this.mTooLateToInitUI) {
                this.mOnStartTime = this.mClock.getTime();
            }
        }
    }

    public synchronized void onActivityStopped(Activity activity) {
    }

    public synchronized void registerActivityLifecycleCallbacks(Context context) {
        if (!this.mRegistered) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext instanceof Application) {
                ((Application) applicationContext).registerActivityLifecycleCallbacks(this);
                this.mRegistered = true;
                this.mAppContext = applicationContext;
            }
        }
    }

    public void setIsStartFromBackground() {
        this.mIsStartFromBackground = true;
    }

    public synchronized void unregisterActivityLifecycleCallbacks() {
        if (this.mRegistered) {
            ((Application) this.mAppContext).unregisterActivityLifecycleCallbacks(this);
            this.mRegistered = false;
        }
    }

    public static AppStartTrace getInstance(TransportManager transportManager2, Clock clock) {
        if (sInstance == null) {
            synchronized (AppStartTrace.class) {
                if (sInstance == null) {
                    sInstance = new AppStartTrace(transportManager2, clock);
                }
            }
        }
        return sInstance;
    }
}
