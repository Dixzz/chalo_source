package com.freshchat.consumer.sdk.beans;

import java.util.ArrayList;
import java.util.List;

public class Conversation {
    private long channelId;
    private long conversationId;
    private Csat csat;
    private boolean hasPendingCsat;
    private long logId;
    private List<Message> messages = new ArrayList();
    private List<Participant> participants = new ArrayList();
    private boolean requireDebugLog;

    public Conversation(long j) {
        this.conversationId = j;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getConversationId() {
        return this.conversationId;
    }

    public Csat getCsat() {
        return this.csat;
    }

    public long getLogId() {
        return this.logId;
    }

    public List<Message> getMessages() {
        return this.messages;
    }

    public List<Participant> getParticipants() {
        return this.participants;
    }

    public boolean hasPendingCsat() {
        return this.hasPendingCsat;
    }

    public boolean isRequireDebugLog() {
        return this.requireDebugLog;
    }

    public Conversation setChannelId(long j) {
        this.channelId = j;
        return this;
    }

    public Conversation setConversationId(long j) {
        this.conversationId = j;
        return this;
    }

    public Conversation setCsat(Csat csat2) {
        this.csat = csat2;
        return this;
    }

    public Conversation setHasPendingCsat(boolean z) {
        this.hasPendingCsat = z;
        return this;
    }

    public void setLogId(long j) {
        this.logId = j;
    }

    public Conversation setMessages(List<Message> list) {
        this.messages = list;
        return this;
    }

    public void setParticipants(List<Participant> list) {
        this.participants = list;
    }

    public void setRequireDebugLog(boolean z) {
        this.requireDebugLog = z;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("Conversation{channelId='");
        i0.append(this.channelId);
        i0.append('\'');
        i0.append(", conversationId=");
        i0.append(this.conversationId);
        i0.append(", csat=");
        i0.append(this.csat);
        i0.append(", hasPendingCsat=");
        i0.append(this.hasPendingCsat);
        i0.append(", requireDebugLog=");
        i0.append(this.requireDebugLog);
        i0.append(", logId=");
        i0.append(this.logId);
        i0.append('}');
        return i0.toString();
    }
}
