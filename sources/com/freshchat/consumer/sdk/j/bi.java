package com.freshchat.consumer.sdk.j;

import android.content.Context;
import com.freshchat.consumer.sdk.Event;
import com.freshchat.consumer.sdk.beans.Channel;
import com.freshchat.consumer.sdk.j.bg;

public final class bi implements bg.b {
    public final /* synthetic */ long fk;
    public final /* synthetic */ Context iI;
    public final /* synthetic */ long nQ;

    public bi(long j, Context context, long j2) {
        this.nQ = j;
        this.iI = context;
        this.fk = j2;
    }

    @Override // com.freshchat.consumer.sdk.j.bg.b
    public Event gy() {
        bg.a aVar = bg.a(Event.EventName.FCEventNotificationReceive).a(Event.Property.FCPropertyConversationID, Long.valueOf(this.nQ));
        Channel channel = bg.j(this.iI, this.fk);
        if (channel != null) {
            bg.a unused = aVar.a(Event.Property.FCPropertyChannelID, channel.getChannelAlias()).a(Event.Property.FCPropertyChannelName, channel.getName());
        }
        return aVar.gz();
    }
}
