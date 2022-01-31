package com.freshchat.consumer.sdk.beans.config;

public class DefaultLiveTranslationConfig extends LiveTranslationConfig {
    private static final boolean LIVE_TRANSLATION_ENABLED = false;

    public DefaultLiveTranslationConfig() {
        setEnabled(false);
    }
}
