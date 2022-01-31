package com.google.firebase.perf.internal;

import com.google.firebase.perf.internal.AppStateMonitor;
import com.google.firebase.perf.v1.ApplicationProcessState;
import java.lang.ref.WeakReference;

public abstract class AppStateUpdateHandler implements AppStateMonitor.AppStateCallback {
    private AppStateMonitor mAppStateMonitor;
    private boolean mIsRegisteredForAppState;
    private ApplicationProcessState mState;
    private WeakReference<AppStateMonitor.AppStateCallback> mWeakRef;

    public AppStateUpdateHandler() {
        this(AppStateMonitor.getInstance());
    }

    public ApplicationProcessState getAppState() {
        return this.mState;
    }

    public void incrementTsnsCount(int i) {
        this.mAppStateMonitor.incrementTsnsCount(i);
    }

    @Override // com.google.firebase.perf.internal.AppStateMonitor.AppStateCallback
    public void onUpdateAppState(ApplicationProcessState applicationProcessState) {
        ApplicationProcessState applicationProcessState2 = this.mState;
        ApplicationProcessState applicationProcessState3 = ApplicationProcessState.APPLICATION_PROCESS_STATE_UNKNOWN;
        if (applicationProcessState2 == applicationProcessState3) {
            this.mState = applicationProcessState;
        } else if (applicationProcessState2 != applicationProcessState && applicationProcessState != applicationProcessState3) {
            this.mState = ApplicationProcessState.FOREGROUND_BACKGROUND;
        }
    }

    public void registerForAppState() {
        if (!this.mIsRegisteredForAppState) {
            this.mState = this.mAppStateMonitor.getAppState();
            this.mAppStateMonitor.registerForAppState(this.mWeakRef);
            this.mIsRegisteredForAppState = true;
        }
    }

    public void unregisterForAppState() {
        if (this.mIsRegisteredForAppState) {
            this.mAppStateMonitor.unregisterForAppState(this.mWeakRef);
            this.mIsRegisteredForAppState = false;
        }
    }

    public AppStateUpdateHandler(AppStateMonitor appStateMonitor) {
        this.mState = ApplicationProcessState.APPLICATION_PROCESS_STATE_UNKNOWN;
        this.mIsRegisteredForAppState = false;
        this.mAppStateMonitor = appStateMonitor;
        this.mWeakRef = new WeakReference<>(this);
    }
}
