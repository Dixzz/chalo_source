package com.freshchat.consumer.sdk.beans.config;

public class DefaultCsatConfig extends CsatConfig {
    private static final int CSAT_TIME_LIMIT = 0;
    private static final boolean CSAT_TIME_LIMITED = false;

    public DefaultCsatConfig() {
        setCsatAutoExpire(false);
        setCsatExpiryInterval(0);
    }
}
