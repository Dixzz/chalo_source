package com.freshchat.consumer.sdk.j;

import android.content.Context;
import com.freshchat.consumer.sdk.Event;
import com.freshchat.consumer.sdk.beans.Channel;
import com.freshchat.consumer.sdk.beans.Conversation;
import com.freshchat.consumer.sdk.j.bg;

public final class bw implements bg.b {
    public final /* synthetic */ long fk;
    public final /* synthetic */ Context iI;
    public final /* synthetic */ boolean kJ;
    public final /* synthetic */ int nW;
    public final /* synthetic */ String nX;

    public bw(Context context, long j, boolean z, int i, String str) {
        this.iI = context;
        this.fk = j;
        this.kJ = z;
        this.nW = i;
        this.nX = str;
    }

    @Override // com.freshchat.consumer.sdk.j.bg.b
    public Event gy() {
        bg.a aVar = bg.a(Event.EventName.FCEventCsatSubmit);
        Channel channel = bg.j(this.iI, this.fk);
        if (channel != null) {
            bg.a unused = aVar.a(Event.Property.FCPropertyChannelID, channel.getChannelAlias()).a(Event.Property.FCPropertyChannelName, channel.getName());
            Conversation conversation = bg.c(this.iI, channel.getId());
            if (conversation != null) {
                bg.a unused2 = aVar.a(Event.Property.FCPropertyConversationID, Long.valueOf(conversation.getConversationId())).a(Event.Property.FCPropertyResolutionStatus, Boolean.valueOf(this.kJ));
            }
        }
        int i = this.nW;
        if (i > 0) {
            bg.a unused3 = aVar.a(Event.Property.FCPropertyRating, Integer.valueOf(i));
        }
        if (as.a(this.nX)) {
            bg.a unused4 = aVar.a(Event.Property.FCPropertyComment, this.nX);
        }
        return aVar.gz();
    }
}
