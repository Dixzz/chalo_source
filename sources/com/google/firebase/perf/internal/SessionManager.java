package com.google.firebase.perf.internal;

import android.annotation.SuppressLint;
import androidx.annotation.Keep;
import com.google.firebase.perf.v1.ApplicationProcessState;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Keep
public class SessionManager extends AppStateUpdateHandler {
    @SuppressLint({"StaticFieldLeak"})
    private static final SessionManager ourInstance = new SessionManager();
    private final AppStateMonitor appStateMonitor;
    private final Set<WeakReference<SessionAwareObject>> clients;
    private final GaugeManager gaugeManager;
    private PerfSession perfSession;

    private SessionManager() {
        this(GaugeManager.getInstance(), PerfSession.create(), AppStateMonitor.getInstance());
    }

    public static SessionManager getInstance() {
        return ourInstance;
    }

    private void logGaugeMetadataIfCollectionEnabled(ApplicationProcessState applicationProcessState) {
        if (this.perfSession.isGaugeAndEventCollectionEnabled()) {
            this.gaugeManager.logGaugeMetadata(this.perfSession.sessionId(), applicationProcessState);
        }
    }

    private void startOrStopCollectingGauges(ApplicationProcessState applicationProcessState) {
        if (this.perfSession.isGaugeAndEventCollectionEnabled()) {
            this.gaugeManager.startCollectingGauges(this.perfSession, applicationProcessState);
        } else {
            this.gaugeManager.stopCollectingGauges();
        }
    }

    @Override // com.google.firebase.perf.internal.AppStateMonitor.AppStateCallback, com.google.firebase.perf.internal.AppStateUpdateHandler
    public void onUpdateAppState(ApplicationProcessState applicationProcessState) {
        super.onUpdateAppState(applicationProcessState);
        if (!this.appStateMonitor.isColdStart()) {
            if (applicationProcessState == ApplicationProcessState.FOREGROUND) {
                updatePerfSession(applicationProcessState);
            } else if (!updatePerfSessionIfExpired()) {
                startOrStopCollectingGauges(applicationProcessState);
            }
        }
    }

    public final PerfSession perfSession() {
        return this.perfSession;
    }

    public void registerForSessionUpdates(WeakReference<SessionAwareObject> weakReference) {
        synchronized (this.clients) {
            this.clients.add(weakReference);
        }
    }

    public void setPerfSession(PerfSession perfSession2) {
        this.perfSession = perfSession2;
    }

    public void unregisterForSessionUpdates(WeakReference<SessionAwareObject> weakReference) {
        synchronized (this.clients) {
            this.clients.remove(weakReference);
        }
    }

    public void updatePerfSession(ApplicationProcessState applicationProcessState) {
        synchronized (this.clients) {
            this.perfSession = PerfSession.create();
            Iterator<WeakReference<SessionAwareObject>> it = this.clients.iterator();
            while (it.hasNext()) {
                SessionAwareObject sessionAwareObject = it.next().get();
                if (sessionAwareObject != null) {
                    sessionAwareObject.updateSession(this.perfSession);
                } else {
                    it.remove();
                }
            }
        }
        logGaugeMetadataIfCollectionEnabled(applicationProcessState);
        startOrStopCollectingGauges(applicationProcessState);
    }

    public boolean updatePerfSessionIfExpired() {
        if (!this.perfSession.isExpired()) {
            return false;
        }
        updatePerfSession(this.appStateMonitor.getAppState());
        return true;
    }

    public SessionManager(GaugeManager gaugeManager2, PerfSession perfSession2, AppStateMonitor appStateMonitor2) {
        this.clients = new HashSet();
        this.gaugeManager = gaugeManager2;
        this.perfSession = perfSession2;
        this.appStateMonitor = appStateMonitor2;
        registerForAppState();
    }
}
