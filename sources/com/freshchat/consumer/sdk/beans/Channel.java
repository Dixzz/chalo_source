package com.freshchat.consumer.sdk.beans;

public class Channel {
    public static final String CHANNEL_TYPE_AGENT_ONLY = "AGENT_ONLY";
    public static final String CHANNEL_TYPE_BOTH = "BOTH";
    public static final String CHANNEL_TYPE_USER_ONLY = "USER_ONLY";
    private String channelAlias;
    private String channelType;
    private boolean hidden;
    private String iconUrl;
    private long id;
    private boolean isDefault;
    private boolean isRestricted;
    private Message latestOrWelcomeMessage;
    private String name;
    private int position;
    private long updatedAt;

    public String getChannelAlias() {
        return this.channelAlias;
    }

    public String getChannelType() {
        return this.channelType;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public long getId() {
        return this.id;
    }

    public Message getLatestOrWelcomeMessage() {
        return this.latestOrWelcomeMessage;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public long getUpdatedAt() {
        return this.updatedAt;
    }

    public boolean isDefault() {
        return this.isDefault;
    }

    public boolean isHidden() {
        return this.hidden;
    }

    public boolean isRestricted() {
        return this.isRestricted;
    }

    public Channel setChannelAlias(String str) {
        this.channelAlias = str;
        return this;
    }

    public Channel setChannelType(String str) {
        this.channelType = str;
        return this;
    }

    public Channel setDefault(boolean z) {
        this.isDefault = z;
        return this;
    }

    public Channel setHidden(boolean z) {
        this.hidden = z;
        return this;
    }

    public Channel setIconUrl(String str) {
        this.iconUrl = str;
        return this;
    }

    public Channel setId(long j) {
        this.id = j;
        return this;
    }

    public Channel setLatestOrWelcomeMessage(Message message) {
        this.latestOrWelcomeMessage = message;
        return this;
    }

    public Channel setName(String str) {
        this.name = str;
        return this;
    }

    public Channel setPosition(int i) {
        this.position = i;
        return this;
    }

    public Channel setRestricted(boolean z) {
        this.isRestricted = z;
        return this;
    }

    public Channel setUpdatedAt(long j) {
        this.updatedAt = j;
        return this;
    }
}
