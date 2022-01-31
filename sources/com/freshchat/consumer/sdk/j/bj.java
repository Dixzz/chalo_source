package com.freshchat.consumer.sdk.j;

import android.net.Uri;
import com.freshchat.consumer.sdk.Event;
import com.freshchat.consumer.sdk.j.bg;

public final class bj implements bg.b {
    public final /* synthetic */ Uri iD;

    public bj(Uri uri) {
        this.iD = uri;
    }

    @Override // com.freshchat.consumer.sdk.j.bg.b
    public Event gy() {
        return bg.a(Event.EventName.FCEventLinkTap).a(Event.Property.FCPropertyURL, this.iD.toString()).gz();
    }
}
