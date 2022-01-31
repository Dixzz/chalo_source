package com.freshchat.consumer.sdk.j;

import com.freshchat.consumer.sdk.Event;
import com.freshchat.consumer.sdk.j.bg;

public final class cr implements bg.b {
    public final /* synthetic */ Event.EventName qI;

    public cr(Event.EventName eventName) {
        this.qI = eventName;
    }

    @Override // com.freshchat.consumer.sdk.j.bg.b
    public Event gy() {
        return bg.a(this.qI).gz();
    }
}
