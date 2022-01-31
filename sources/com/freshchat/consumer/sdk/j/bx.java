package com.freshchat.consumer.sdk.j;

import android.content.Context;
import com.freshchat.consumer.sdk.Event;
import com.freshchat.consumer.sdk.beans.Channel;
import com.freshchat.consumer.sdk.beans.Conversation;
import com.freshchat.consumer.sdk.j.bg;

public final class bx implements bg.b {
    public final /* synthetic */ long fk;
    public final /* synthetic */ Context iI;

    public bx(Context context, long j) {
        this.iI = context;
        this.fk = j;
    }

    @Override // com.freshchat.consumer.sdk.j.bg.b
    public Event gy() {
        bg.a aVar = bg.a(Event.EventName.FCEventCsatOpen);
        Channel channel = bg.j(this.iI, this.fk);
        if (channel != null) {
            bg.a unused = aVar.a(Event.Property.FCPropertyChannelID, channel.getChannelAlias()).a(Event.Property.FCPropertyChannelName, channel.getName());
            Conversation conversation = bg.c(this.iI, this.fk);
            if (conversation != null) {
                bg.a unused2 = aVar.a(Event.Property.FCPropertyConversationID, Long.valueOf(conversation.getConversationId()));
            }
        }
        return aVar.gz();
    }
}
