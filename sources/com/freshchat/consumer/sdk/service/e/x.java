package com.freshchat.consumer.sdk.service.e;

public class x implements j {
    private long channelId;
    private long conversationId;
    private long readUpto;

    public x(long j, long j2) {
        this.channelId = j;
        this.conversationId = j2;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getConversationId() {
        return this.conversationId;
    }

    public long getReadUpto() {
        return this.readUpto;
    }
}
