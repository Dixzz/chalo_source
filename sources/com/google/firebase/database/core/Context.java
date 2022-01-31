package com.google.firebase.database.core;

import app.zophop.models.mTicketing.ProductDiscountsObject;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.android.AndroidPlatform;
import com.google.firebase.database.connection.ConnectionAuthTokenProvider;
import com.google.firebase.database.connection.ConnectionContext;
import com.google.firebase.database.connection.HostInfo;
import com.google.firebase.database.connection.PersistentConnection;
import com.google.firebase.database.core.persistence.NoopPersistenceManager;
import com.google.firebase.database.core.persistence.PersistenceManager;
import com.google.firebase.database.core.utilities.DefaultRunLoop;
import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.logging.Logger;
import com.rabbitmq.client.ConnectionFactory;
import java.io.File;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

public class Context {
    private static final long DEFAULT_CACHE_SIZE = 10485760;
    public AuthTokenProvider authTokenProvider;
    public long cacheSize = DEFAULT_CACHE_SIZE;
    public EventTarget eventTarget;
    public FirebaseApp firebaseApp;
    private PersistenceManager forcedPersistenceManager;
    private boolean frozen = false;
    public Logger.Level logLevel = Logger.Level.INFO;
    public List<String> loggedComponents;
    public Logger logger;
    public boolean persistenceEnabled;
    public String persistenceKey;
    private Platform platform;
    public RunLoop runLoop;
    private boolean stopped = false;
    public String userAgent;

    private String buildUserAgent(String str) {
        StringBuilder l0 = hj1.l0("Firebase/", "5", ConnectionFactory.DEFAULT_VHOST);
        l0.append(FirebaseDatabase.getSdkVersion());
        l0.append(ConnectionFactory.DEFAULT_VHOST);
        l0.append(str);
        return l0.toString();
    }

    private void ensureAuthTokenProvider() {
        gj1.l(this.authTokenProvider, "You must register an authTokenProvider before initializing Context.");
    }

    private void ensureEventTarget() {
        if (this.eventTarget == null) {
            this.eventTarget = getPlatform().newEventTarget(this);
        }
    }

    private void ensureLogger() {
        if (this.logger == null) {
            this.logger = getPlatform().newLogger(this, this.logLevel, this.loggedComponents);
        }
    }

    private void ensureRunLoop() {
        if (this.runLoop == null) {
            this.runLoop = this.platform.newRunLoop(this);
        }
    }

    private void ensureSessionIdentifier() {
        if (this.persistenceKey == null) {
            this.persistenceKey = ProductDiscountsObject.KEY_PRODUCT_TYPE_DEFAULT;
        }
    }

    private void ensureUserAgent() {
        if (this.userAgent == null) {
            this.userAgent = buildUserAgent(getPlatform().getUserAgent(this));
        }
    }

    private ScheduledExecutorService getExecutorService() {
        RunLoop runLoop2 = getRunLoop();
        if (runLoop2 instanceof DefaultRunLoop) {
            return ((DefaultRunLoop) runLoop2).getExecutorService();
        }
        throw new RuntimeException("Custom run loops are not supported!");
    }

    private Platform getPlatform() {
        if (this.platform == null) {
            initializeAndroidPlatform();
        }
        return this.platform;
    }

    private void initServices() {
        ensureLogger();
        getPlatform();
        ensureUserAgent();
        ensureEventTarget();
        ensureRunLoop();
        ensureSessionIdentifier();
        ensureAuthTokenProvider();
    }

    private synchronized void initializeAndroidPlatform() {
        this.platform = new AndroidPlatform(this.firebaseApp);
    }

    private void restartServices() {
        this.eventTarget.restart();
        this.runLoop.restart();
    }

    private static ConnectionAuthTokenProvider wrapAuthTokenProvider(AuthTokenProvider authTokenProvider2, ScheduledExecutorService scheduledExecutorService) {
        return Context$$Lambda$1.lambdaFactory$(authTokenProvider2, scheduledExecutorService);
    }

    public void assertUnfrozen() {
        if (isFrozen()) {
            throw new DatabaseException("Modifications to DatabaseConfig objects must occur before they are in use");
        }
    }

    public void forcePersistenceManager(PersistenceManager persistenceManager) {
        this.forcedPersistenceManager = persistenceManager;
    }

    public synchronized void freeze() {
        if (!this.frozen) {
            this.frozen = true;
            initServices();
        }
    }

    public AuthTokenProvider getAuthTokenProvider() {
        return this.authTokenProvider;
    }

    public ConnectionContext getConnectionContext() {
        return new ConnectionContext(getLogger(), wrapAuthTokenProvider(getAuthTokenProvider(), getExecutorService()), getExecutorService(), isPersistenceEnabled(), FirebaseDatabase.getSdkVersion(), getUserAgent(), this.firebaseApp.getOptions().getApplicationId(), getSSLCacheDirectory().getAbsolutePath());
    }

    public EventTarget getEventTarget() {
        return this.eventTarget;
    }

    public Logger.Level getLogLevel() {
        return this.logLevel;
    }

    public Logger getLogger() {
        return this.logger;
    }

    public List<String> getOptDebugLogComponents() {
        return this.loggedComponents;
    }

    public long getPersistenceCacheSizeBytes() {
        return this.cacheSize;
    }

    public PersistenceManager getPersistenceManager(String str) {
        PersistenceManager persistenceManager = this.forcedPersistenceManager;
        if (persistenceManager != null) {
            return persistenceManager;
        }
        if (!this.persistenceEnabled) {
            return new NoopPersistenceManager();
        }
        PersistenceManager createPersistenceManager = this.platform.createPersistenceManager(this, str);
        if (createPersistenceManager != null) {
            return createPersistenceManager;
        }
        throw new IllegalArgumentException("You have enabled persistence, but persistence is not supported on this platform.");
    }

    public String getPlatformVersion() {
        return getPlatform().getPlatformVersion();
    }

    public RunLoop getRunLoop() {
        return this.runLoop;
    }

    public File getSSLCacheDirectory() {
        return getPlatform().getSSLCacheDirectory();
    }

    public String getSessionPersistenceKey() {
        return this.persistenceKey;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public boolean isFrozen() {
        return this.frozen;
    }

    public boolean isPersistenceEnabled() {
        return this.persistenceEnabled;
    }

    public boolean isStopped() {
        return this.stopped;
    }

    public PersistentConnection newPersistentConnection(HostInfo hostInfo, PersistentConnection.Delegate delegate) {
        return getPlatform().newPersistentConnection(this, getConnectionContext(), hostInfo, delegate);
    }

    public void requireStarted() {
        if (this.stopped) {
            restartServices();
            this.stopped = false;
        }
    }

    public void stop() {
        this.stopped = true;
        this.eventTarget.shutdown();
        this.runLoop.shutdown();
    }

    public LogWrapper getLogger(String str) {
        return new LogWrapper(this.logger, str);
    }

    public LogWrapper getLogger(String str, String str2) {
        return new LogWrapper(this.logger, str, str2);
    }
}
