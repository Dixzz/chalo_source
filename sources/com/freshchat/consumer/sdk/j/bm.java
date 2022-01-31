package com.freshchat.consumer.sdk.j;

import com.freshchat.consumer.sdk.Event;
import com.freshchat.consumer.sdk.beans.fragment.QuickReplyButtonFragment;
import com.freshchat.consumer.sdk.j.ab;
import com.freshchat.consumer.sdk.j.bg;

public final class bm implements bg.b {
    public final /* synthetic */ QuickReplyButtonFragment nR;

    public bm(QuickReplyButtonFragment quickReplyButtonFragment) {
        this.nR = quickReplyButtonFragment;
    }

    @Override // com.freshchat.consumer.sdk.j.bg.b
    public Event gy() {
        String json = new ab(new ab.d()).toJson(this.nR);
        bg.a aVar = bg.a(Event.EventName.FCEventDropDownOptionSelect);
        if (as.a(json)) {
            bg.a unused = aVar.a(Event.Property.FCPropertyOption, json);
        }
        return aVar.gz();
    }
}
