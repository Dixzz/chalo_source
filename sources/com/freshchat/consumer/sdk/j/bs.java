package com.freshchat.consumer.sdk.j;

import com.freshchat.consumer.sdk.Event;
import com.freshchat.consumer.sdk.j.bg;

public final class bs implements bg.b {
    public final /* synthetic */ String lU;
    public final /* synthetic */ int lV;
    public final /* synthetic */ boolean lW;

    public bs(String str, int i, boolean z) {
        this.lU = str;
        this.lV = i;
        this.lW = z;
    }

    @Override // com.freshchat.consumer.sdk.j.bg.b
    public Event gy() {
        return bg.a(Event.EventName.FCEventFAQSearch).a(Event.Property.FCPropertySearchKey, this.lU).a(Event.Property.FCPropertySearchFAQCount, Integer.valueOf(this.lV)).a(Event.Property.FCPropertyIsRelevant, Boolean.valueOf(this.lW)).gz();
    }
}
