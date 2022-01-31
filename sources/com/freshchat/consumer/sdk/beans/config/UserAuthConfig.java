package com.freshchat.consumer.sdk.beans.config;

public class UserAuthConfig {
    private long authTimeOutInterval;
    private boolean jwtAuthEnabled;
    private boolean strictModeEnabled;

    public long getAuthTimeOutInterval() {
        return this.authTimeOutInterval;
    }

    public boolean isJwtAuthEnabled() {
        return this.jwtAuthEnabled;
    }

    public boolean isStrictModeEnabled() {
        return this.strictModeEnabled;
    }

    public void setAuthTimeOutInterval(long j) {
        this.authTimeOutInterval = j;
    }

    public void setJwtAuthEnabled(boolean z) {
        this.jwtAuthEnabled = z;
    }

    public void setStrictModeEnabled(boolean z) {
        this.strictModeEnabled = z;
    }
}
