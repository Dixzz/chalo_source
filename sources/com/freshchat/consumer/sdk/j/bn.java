package com.freshchat.consumer.sdk.j;

import com.freshchat.consumer.sdk.Event;
import com.freshchat.consumer.sdk.beans.fragment.CarouselCardDefaultFragment;
import com.freshchat.consumer.sdk.j.ab;
import com.freshchat.consumer.sdk.j.bg;

public final class bn implements bg.b {
    public final /* synthetic */ CarouselCardDefaultFragment nS;

    public bn(CarouselCardDefaultFragment carouselCardDefaultFragment) {
        this.nS = carouselCardDefaultFragment;
    }

    @Override // com.freshchat.consumer.sdk.j.bg.b
    public Event gy() {
        String json = new ab(new ab.d()).toJson(this.nS);
        bg.a aVar = bg.a(Event.EventName.FCEventCarouselOptionSelect);
        if (as.a(json)) {
            bg.a unused = aVar.a(Event.Property.FCPropertyOption, json);
        }
        return aVar.gz();
    }
}
