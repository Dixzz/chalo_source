package com.freshchat.consumer.sdk.j;

import com.freshchat.consumer.sdk.Event;
import com.freshchat.consumer.sdk.j.bg;
import java.util.Arrays;

public final class br implements bg.b {
    public final /* synthetic */ String[] lS;

    public br(String[] strArr) {
        this.lS = strArr;
    }

    @Override // com.freshchat.consumer.sdk.j.bg.b
    public Event gy() {
        bg.a aVar = bg.a(Event.EventName.FCEventFAQCategoryListOpen);
        if (as.f(this.lS)) {
            bg.a unused = aVar.a(Event.Property.FCPropertyInputTags, Arrays.toString(this.lS));
        }
        return aVar.gz();
    }
}
