package com.freshchat.consumer.sdk.beans.config;

public class DefaultUserAuthConfig extends UserAuthConfig {
    private static final long DEFAULT_AUTH_TIMEOUT_INTERVAL = 30000;
    private static final boolean JWT_AUTH_ENABLED = false;
    private static final boolean STRICT_MODE_ENABLED = false;

    public DefaultUserAuthConfig() {
        setJwtAuthEnabled(false);
        setStrictModeEnabled(false);
        setAuthTimeOutInterval(DEFAULT_AUTH_TIMEOUT_INTERVAL);
    }
}
