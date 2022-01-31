package com.freshchat.consumer.sdk.beans.config;

import com.freshchat.consumer.sdk.beans.MessageMaskingConfig;
import com.freshchat.consumer.sdk.beans.UnsupportedFragmentConfig;
import com.freshchat.consumer.sdk.beans.UserEventsConfig;
import com.google.gson.annotations.SerializedName;
import java.util.Set;

public class RemoteConfig {
    private boolean accountActive;
    private AccountConfig accountConfig;
    private ConversationConfig conversationConfig;
    @SerializedName("csatSettings")
    private CsatConfig csatConfig;
    private Set<String> enabledFeatures;
    private UserEventsConfig eventsConfig;
    private LiveTranslationConfig liveTranslationConfig;
    private MessageMaskingConfig messageMaskingConfig;
    private RefreshIntervals refreshIntervals;
    private long sessionTimeoutInterval;
    private UnsupportedFragmentConfig unsupportedFragmentConfig;
    private UserAuthConfig userAuthConfig;

    public AccountConfig getAccountConfig() {
        return this.accountConfig;
    }

    public ConversationConfig getConversationConfig() {
        return this.conversationConfig;
    }

    public CsatConfig getCsatConfig() {
        return this.csatConfig;
    }

    public Set<String> getEnabledFeatures() {
        return this.enabledFeatures;
    }

    public UserEventsConfig getEventsConfig() {
        return this.eventsConfig;
    }

    public LiveTranslationConfig getLiveTranslationConfig() {
        return this.liveTranslationConfig;
    }

    public MessageMaskingConfig getMessageMaskingConfig() {
        return this.messageMaskingConfig;
    }

    public RefreshIntervals getRefreshIntervals() {
        return this.refreshIntervals;
    }

    public long getSessionTimeoutInterval() {
        return this.sessionTimeoutInterval;
    }

    public UnsupportedFragmentConfig getUnsupportedFragmentConfig() {
        return this.unsupportedFragmentConfig;
    }

    public UserAuthConfig getUserAuthConfig() {
        return this.userAuthConfig;
    }

    public boolean isAccountActive() {
        return this.accountActive;
    }

    public void setAccountActive(boolean z) {
        this.accountActive = z;
    }

    public void setAccountConfig(AccountConfig accountConfig2) {
        this.accountConfig = accountConfig2;
    }

    public void setConversationConfig(ConversationConfig conversationConfig2) {
        this.conversationConfig = conversationConfig2;
    }

    public void setCsatConfig(CsatConfig csatConfig2) {
        this.csatConfig = csatConfig2;
    }

    public void setEnabledFeatures(Set<String> set) {
        this.enabledFeatures = set;
    }

    public void setEventsConfig(UserEventsConfig userEventsConfig) {
        this.eventsConfig = userEventsConfig;
    }

    public void setLiveTranslationConfig(LiveTranslationConfig liveTranslationConfig2) {
        this.liveTranslationConfig = liveTranslationConfig2;
    }

    public void setMessageMaskingConfig(MessageMaskingConfig messageMaskingConfig2) {
        this.messageMaskingConfig = messageMaskingConfig2;
    }

    public void setRefreshIntervals(RefreshIntervals refreshIntervals2) {
        this.refreshIntervals = refreshIntervals2;
    }

    public void setSessionTimeoutInterval(long j) {
        this.sessionTimeoutInterval = j;
    }

    public void setUnsupportedFragmentConfig(UnsupportedFragmentConfig unsupportedFragmentConfig2) {
        this.unsupportedFragmentConfig = unsupportedFragmentConfig2;
    }

    public void setUserAuthConfig(UserAuthConfig userAuthConfig2) {
        this.userAuthConfig = userAuthConfig2;
    }
}
