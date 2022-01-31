package com.freshchat.consumer.sdk.beans;

import com.google.gson.annotations.SerializedName;

public class ChannelResponseTime {
    private long channelId;
    @SerializedName("customRespMsg")
    private String customResponseTimeMessage;
    private long responseTime;
    private ResponseTimeType responseTimeType;

    public enum ResponseTimeType {
        CURRENT_AVG,
        LAST_WEEK_AVG,
        CUSTOM_RESPONSE,
        ALL_MEMBERS_AWAY_RESPONSE
    }

    public ChannelResponseTime(long j, long j2) {
        this.channelId = j;
        this.responseTime = j2;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public String getCustomResponseTimeMessage() {
        return this.customResponseTimeMessage;
    }

    public long getResponseTime() {
        return this.responseTime;
    }

    public ResponseTimeType getResponseTimeType() {
        return this.responseTimeType;
    }

    public void setChannelId(long j) {
        this.channelId = j;
    }

    public void setCustomResponseTimeMessage(String str) {
        this.customResponseTimeMessage = str;
    }

    public void setResponseTime(long j) {
        this.responseTime = j;
    }

    public void setResponseTimeType(ResponseTimeType responseTimeType2) {
        this.responseTimeType = responseTimeType2;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("ChannelResponseTime{channelId=");
        i0.append(this.channelId);
        i0.append(", responseTime=");
        i0.append(this.responseTime);
        i0.append(", customResponseTimeMessage=");
        return hj1.Z(i0, this.customResponseTimeMessage, '}');
    }
}
