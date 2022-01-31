package com.crashlytics.android.answers;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Looper;
import com.crashlytics.android.answers.BackgroundManager;
import com.crashlytics.android.answers.SessionEvent;
import defpackage.vz5;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicLong;

public class SessionAnalyticsManager implements BackgroundManager.Listener {
    public static final String EXECUTOR_SERVICE = "Answers Events Handler";
    public static final String ON_CRASH_ERROR_MSG = "onCrash called from main thread!!!";
    public final BackgroundManager backgroundManager;
    public final AnswersEventsHandler eventsHandler;
    private final long installedAt;
    public final vz5 lifecycleManager;
    public final AnswersPreferenceManager preferenceManager;

    public SessionAnalyticsManager(AnswersEventsHandler answersEventsHandler, vz5 vz5, BackgroundManager backgroundManager2, AnswersPreferenceManager answersPreferenceManager, long j) {
        this.eventsHandler = answersEventsHandler;
        this.lifecycleManager = vz5;
        this.backgroundManager = backgroundManager2;
        this.preferenceManager = answersPreferenceManager;
        this.installedAt = j;
    }

    public static SessionAnalyticsManager build(c06 c06, Context context, o06 o06, String str, String str2, long j) {
        SessionMetadataCollector sessionMetadataCollector = new SessionMetadataCollector(context, o06, str, str2);
        AnswersFilesManagerProvider answersFilesManagerProvider = new AnswersFilesManagerProvider(context, new v16(c06));
        o16 o16 = new o16(xz5.f3984a);
        vz5 vz5 = new vz5(context);
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(new m06(EXECUTOR_SERVICE, new AtomicLong(1)));
        hd3.k(EXECUTOR_SERVICE, newSingleThreadScheduledExecutor);
        return new SessionAnalyticsManager(new AnswersEventsHandler(c06, context, answersFilesManagerProvider, sessionMetadataCollector, o16, newSingleThreadScheduledExecutor), vz5, new BackgroundManager(newSingleThreadScheduledExecutor), AnswersPreferenceManager.build(context), j);
    }

    public void disable() {
        vz5.a aVar = this.lifecycleManager.b;
        if (aVar != null) {
            for (Application.ActivityLifecycleCallbacks activityLifecycleCallbacks : aVar.f3699a) {
                aVar.b.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
            }
        }
        this.eventsHandler.disable();
    }

    public void enable() {
        this.eventsHandler.enable();
        this.lifecycleManager.a(new AnswersLifecycleCallbacks(this, this.backgroundManager));
        this.backgroundManager.registerListener(this);
        if (isFirstLaunch()) {
            onInstall(this.installedAt);
            this.preferenceManager.setAnalyticsLaunched();
        }
    }

    public boolean isFirstLaunch() {
        return !this.preferenceManager.hasAnalyticsLaunched();
    }

    @Override // com.crashlytics.android.answers.BackgroundManager.Listener
    public void onBackground() {
        this.eventsHandler.flushEvents();
    }

    public void onCrash(String str, String str2) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.eventsHandler.processEventSync(SessionEvent.crashEventBuilder(str, str2));
            return;
        }
        throw new IllegalStateException(ON_CRASH_ERROR_MSG);
    }

    public void onCustom(CustomEvent customEvent) {
        String str = "Logged custom event: " + customEvent;
        this.eventsHandler.processEventAsync(SessionEvent.customEventBuilder(customEvent));
    }

    public void onError(String str) {
    }

    public void onInstall(long j) {
        this.eventsHandler.processEventAsyncAndFlush(SessionEvent.installEventBuilder(j));
    }

    public void onLifecycle(Activity activity, SessionEvent.Type type) {
        type.name();
        this.eventsHandler.processEventAsync(SessionEvent.lifecycleEventBuilder(type, activity));
    }

    public void onPredefined(PredefinedEvent predefinedEvent) {
        String str = "Logged predefined event: " + predefinedEvent;
        this.eventsHandler.processEventAsync(SessionEvent.predefinedEventBuilder(predefinedEvent));
    }

    public void setAnalyticsSettingsData(y16 y16, String str) {
        throw null;
    }
}
