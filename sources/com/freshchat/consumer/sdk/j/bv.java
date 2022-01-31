package com.freshchat.consumer.sdk.j;

import android.content.Context;
import com.freshchat.consumer.sdk.Event;
import com.freshchat.consumer.sdk.beans.Channel;
import com.freshchat.consumer.sdk.j.bg;

public final class bv implements bg.b {
    public final /* synthetic */ long fk;
    public final /* synthetic */ Context iI;
    public final /* synthetic */ long nV;

    public bv(long j, Context context, long j2) {
        this.nV = j;
        this.iI = context;
        this.fk = j2;
    }

    @Override // com.freshchat.consumer.sdk.j.bg.b
    public Event gy() {
        bg.a aVar = bg.a(Event.EventName.FCEventCsatExpiry).a(Event.Property.FCPropertyConversationID, Long.valueOf(this.nV));
        Channel channel = bg.j(this.iI, this.fk);
        if (channel != null) {
            bg.a unused = aVar.a(Event.Property.FCPropertyChannelID, channel.getChannelAlias()).a(Event.Property.FCPropertyChannelName, channel.getName());
        }
        return aVar.gz();
    }
}
