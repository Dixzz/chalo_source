package com.google.firebase.database.connection;

import com.google.firebase.database.logging.Logger;
import java.util.concurrent.ScheduledExecutorService;

public class ConnectionContext {
    private final String applicationId;
    private final ConnectionAuthTokenProvider authTokenProvider;
    private final String clientSdkVersion;
    private final ScheduledExecutorService executorService;
    private final Logger logger;
    private final boolean persistenceEnabled;
    private final String sslCacheDirectory;
    private final String userAgent;

    public ConnectionContext(Logger logger2, ConnectionAuthTokenProvider connectionAuthTokenProvider, ScheduledExecutorService scheduledExecutorService, boolean z, String str, String str2, String str3, String str4) {
        this.logger = logger2;
        this.authTokenProvider = connectionAuthTokenProvider;
        this.executorService = scheduledExecutorService;
        this.persistenceEnabled = z;
        this.clientSdkVersion = str;
        this.userAgent = str2;
        this.applicationId = str3;
        this.sslCacheDirectory = str4;
    }

    public String getApplicationId() {
        return this.applicationId;
    }

    public ConnectionAuthTokenProvider getAuthTokenProvider() {
        return this.authTokenProvider;
    }

    public String getClientSdkVersion() {
        return this.clientSdkVersion;
    }

    public ScheduledExecutorService getExecutorService() {
        return this.executorService;
    }

    public Logger getLogger() {
        return this.logger;
    }

    public String getSslCacheDirectory() {
        return this.sslCacheDirectory;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public boolean isPersistenceEnabled() {
        return this.persistenceEnabled;
    }
}
