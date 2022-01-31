package com.crashlytics.android.answers;

import android.app.Activity;
import android.os.Bundle;
import com.crashlytics.android.answers.SessionEvent;
import defpackage.vz5;

public class AnswersLifecycleCallbacks extends vz5.b {
    private final SessionAnalyticsManager analyticsManager;
    private final BackgroundManager backgroundManager;

    public AnswersLifecycleCallbacks(SessionAnalyticsManager sessionAnalyticsManager, BackgroundManager backgroundManager2) {
        this.analyticsManager = sessionAnalyticsManager;
        this.backgroundManager = backgroundManager2;
    }

    @Override // defpackage.vz5.b
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // defpackage.vz5.b
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // defpackage.vz5.b
    public void onActivityPaused(Activity activity) {
        this.analyticsManager.onLifecycle(activity, SessionEvent.Type.PAUSE);
        this.backgroundManager.onActivityPaused();
    }

    @Override // defpackage.vz5.b
    public void onActivityResumed(Activity activity) {
        this.analyticsManager.onLifecycle(activity, SessionEvent.Type.RESUME);
        this.backgroundManager.onActivityResumed();
    }

    @Override // defpackage.vz5.b
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // defpackage.vz5.b
    public void onActivityStarted(Activity activity) {
        this.analyticsManager.onLifecycle(activity, SessionEvent.Type.START);
    }

    @Override // defpackage.vz5.b
    public void onActivityStopped(Activity activity) {
        this.analyticsManager.onLifecycle(activity, SessionEvent.Type.STOP);
    }
}
