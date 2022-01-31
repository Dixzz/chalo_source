package com.freshchat.consumer.sdk.beans.config;

public class ConversationConfig {
    private double activeConvFetchBackoffRatio;
    private long activeConvWindow;
    private boolean launchDeeplinkFromNotification;

    public enum AgentAvatarType {
        NONE,
        APP_ICON,
        REAL_AGENT_AVATAR
    }

    public double getActiveConvFetchBackoffRatio() {
        return this.activeConvFetchBackoffRatio;
    }

    public long getActiveConvWindow() {
        return this.activeConvWindow;
    }

    public void setActiveConvFetchBackoffRatio(double d) {
        this.activeConvFetchBackoffRatio = d;
    }

    public void setActiveConvWindow(long j) {
        this.activeConvWindow = j;
    }

    public void setLaunchDeeplinkFromNotification(boolean z) {
        this.launchDeeplinkFromNotification = z;
    }

    public boolean shouldLaunchDeeplinkFromNotification() {
        return this.launchDeeplinkFromNotification;
    }
}
