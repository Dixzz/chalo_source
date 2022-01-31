package app.zophop.pubsub.eventbus.events;

import defpackage.h30;

public class UpdateLanguageEvent {
    private final h30.a language;

    public UpdateLanguageEvent(h30.a aVar) {
        this.language = aVar;
        xt.f3961a.t().d(getLocale());
    }

    public String getLocale() {
        return this.language.getLocale();
    }
}
