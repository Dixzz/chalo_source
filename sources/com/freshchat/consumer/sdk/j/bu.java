package com.freshchat.consumer.sdk.j;

import android.content.Context;
import com.freshchat.consumer.sdk.Event;
import com.freshchat.consumer.sdk.beans.Channel;
import com.freshchat.consumer.sdk.beans.Conversation;
import com.freshchat.consumer.sdk.j.bg;
import java.util.Arrays;

public final class bu implements bg.b {
    public final /* synthetic */ long fk;
    public final /* synthetic */ Context iI;
    public final /* synthetic */ String[] lS;

    public bu(Context context, long j, String[] strArr) {
        this.iI = context;
        this.fk = j;
        this.lS = strArr;
    }

    @Override // com.freshchat.consumer.sdk.j.bg.b
    public Event gy() {
        bg.a aVar = bg.a(Event.EventName.FCEventConversationOpen);
        Channel channel = bg.j(this.iI, this.fk);
        if (channel != null) {
            bg.a unused = aVar.a(Event.Property.FCPropertyChannelID, channel.getChannelAlias()).a(Event.Property.FCPropertyChannelName, channel.getName());
            Conversation conversation = bg.c(this.iI, channel.getId());
            if (conversation != null) {
                bg.a unused2 = aVar.a(Event.Property.FCPropertyConversationID, Long.valueOf(conversation.getConversationId()));
            }
        }
        if (as.f(this.lS)) {
            bg.a unused3 = aVar.a(Event.Property.FCPropertyInputTags, Arrays.toString(this.lS));
        }
        return aVar.gz();
    }
}
