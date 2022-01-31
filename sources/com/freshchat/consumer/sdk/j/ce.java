package com.freshchat.consumer.sdk.j;

import com.freshchat.consumer.sdk.Event;
import com.freshchat.consumer.sdk.j.bg;

public final class ce implements bg.b {
    public final /* synthetic */ Event.EventName qG;
    public final /* synthetic */ String qH;

    public ce(Event.EventName eventName, String str) {
        this.qG = eventName;
        this.qH = str;
    }

    @Override // com.freshchat.consumer.sdk.j.bg.b
    public Event gy() {
        return bg.a(this.qG).a(Event.Property.FCPropertyInviteId, this.qH).gz();
    }
}
