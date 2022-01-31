package com.freshchat.consumer.sdk.j;

import com.freshchat.consumer.sdk.Event;
import com.freshchat.consumer.sdk.j.bg;

public final class bp implements bg.b {
    public final /* synthetic */ boolean qF;

    public bp(boolean z) {
        this.qF = z;
    }

    @Override // com.freshchat.consumer.sdk.j.bg.b
    public Event gy() {
        return bg.a(this.qF ? Event.EventName.FCEventShowOriginalClick : Event.EventName.FCEventHideOriginalClick).gz();
    }
}
