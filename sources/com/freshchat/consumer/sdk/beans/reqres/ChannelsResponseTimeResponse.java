package com.freshchat.consumer.sdk.beans.reqres;

import com.freshchat.consumer.sdk.beans.ChannelResponseTime;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ChannelsResponseTimeResponse {
    private List<ChannelResponseTime> channelResponseTime;
    private List<ChannelResponseTime> channelResponseTimesFor7Days;
    @SerializedName("channelCustomResponse")
    private List<ChannelResponseTime> channelsCustomResponseTimeMessage;
    private List<ChannelResponseTime> channelsWithAllMembersAway;

    public List<ChannelResponseTime> getChannelResponseTime() {
        return this.channelResponseTime;
    }

    public List<ChannelResponseTime> getChannelResponseTimesFor7Days() {
        return this.channelResponseTimesFor7Days;
    }

    public List<ChannelResponseTime> getChannelsCustomResponseTimeMessage() {
        return this.channelsCustomResponseTimeMessage;
    }

    public List<ChannelResponseTime> getChannelsWithAllMembersAway() {
        return this.channelsWithAllMembersAway;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("ChannelsResponseTimeResponse{channelResponseTime=");
        i0.append(this.channelResponseTime);
        i0.append(", channelResponseTimesFor7Days=");
        i0.append(this.channelResponseTimesFor7Days);
        i0.append(", channelsCustomResponseTimeMessage=");
        i0.append(this.channelsCustomResponseTimeMessage);
        i0.append(", channelsWithAllMembersAway=");
        i0.append(this.channelsWithAllMembersAway);
        i0.append('}');
        return i0.toString();
    }
}
