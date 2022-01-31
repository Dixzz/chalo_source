package com.freshchat.consumer.sdk.g;

import android.content.Context;
import com.freshchat.consumer.sdk.beans.Message;
import com.freshchat.consumer.sdk.beans.Participant;
import com.freshchat.consumer.sdk.c.g;
import com.freshchat.consumer.sdk.c.h;
import com.freshchat.consumer.sdk.j.ap;
import java.util.List;

public class i extends c<Message> {
    private boolean aO = false;
    private final g av;
    private final long channelId;
    private final h eW;
    private final long eX;
    private List<Participant> participants;

    public i(Context context, long j) {
        super(context);
        this.channelId = j;
        this.av = new g(context);
        this.eW = new h(context);
        this.eX = ap.bD(context).getConversationConfig().getActiveConvWindow();
    }

    @Override // com.freshchat.consumer.sdk.g.c
    public List<Message> dd() {
        List<Message> k = this.av.k(this.channelId);
        this.participants = this.eW.cH();
        this.aO = this.av.a(this.channelId, this.eX);
        return k;
    }

    public boolean di() {
        return this.aO;
    }

    public List<Participant> getParticipants() {
        return this.participants;
    }
}
