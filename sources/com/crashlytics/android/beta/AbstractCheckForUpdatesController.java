package com.crashlytics.android.beta;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class AbstractCheckForUpdatesController implements UpdatesController {
    public static final long LAST_UPDATE_CHECK_DEFAULT = 0;
    public static final String LAST_UPDATE_CHECK_KEY = "last_update_check";
    private static final long MILLIS_PER_SECOND = 1000;
    private Beta beta;
    private z16 betaSettings;
    private BuildProperties buildProps;
    private Context context;
    private l06 currentTimeProvider;
    private final AtomicBoolean externallyReady;
    private r16 httpRequestFactory;
    private o06 idManager;
    private final AtomicBoolean initialized;
    private long lastCheckTimeMillis;
    private w16 preferenceStore;

    public AbstractCheckForUpdatesController() {
        this(false);
    }

    private void performUpdateCheck() {
        new h06().a(this.context);
        throw null;
    }

    @SuppressLint({"CommitPrefEdits"})
    public void checkForUpdates() {
        synchronized (this.preferenceStore) {
            if (((x16) this.preferenceStore).f3871a.contains(LAST_UPDATE_CHECK_KEY)) {
                w16 w16 = this.preferenceStore;
                SharedPreferences.Editor remove = ((x16) w16).a().remove(LAST_UPDATE_CHECK_KEY);
                Objects.requireNonNull((x16) w16);
                remove.apply();
            }
        }
        Objects.requireNonNull((q06) this.currentTimeProvider);
        System.currentTimeMillis();
        throw null;
    }

    public long getLastCheckTimeMillis() {
        return this.lastCheckTimeMillis;
    }

    @Override // com.crashlytics.android.beta.UpdatesController
    public void initialize(Context context2, Beta beta2, o06 o06, z16 z16, BuildProperties buildProperties, w16 w16, l06 l06, r16 r16) {
        this.context = context2;
        this.beta = beta2;
        this.buildProps = buildProperties;
        this.preferenceStore = w16;
        this.currentTimeProvider = l06;
        this.httpRequestFactory = r16;
        if (signalInitialized()) {
            checkForUpdates();
        }
    }

    public void setLastCheckTimeMillis(long j) {
        this.lastCheckTimeMillis = j;
    }

    public boolean signalExternallyReady() {
        this.externallyReady.set(true);
        return this.initialized.get();
    }

    public boolean signalInitialized() {
        this.initialized.set(true);
        return this.externallyReady.get();
    }

    public AbstractCheckForUpdatesController(boolean z) {
        this.initialized = new AtomicBoolean();
        this.lastCheckTimeMillis = 0;
        this.externallyReady = new AtomicBoolean(z);
    }
}
