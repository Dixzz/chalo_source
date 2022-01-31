package com.google.firebase.appindexing.builders;

import com.google.firebase.appindexing.Action;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class AssistActionBuilder extends Action.Builder {
    private String zzeq;

    public AssistActionBuilder() {
        super("AssistAction");
    }

    @Override // com.google.firebase.appindexing.Action.Builder
    public final Action build() {
        gj1.l(this.zzeq, "setActionToken is required before calling build().");
        gj1.l(zzy(), "setActionStatus is required before calling build().");
        put("actionToken", this.zzeq);
        if (getName() == null) {
            setName("AssistAction");
        }
        if (getUrl() == null) {
            String valueOf = String.valueOf(this.zzeq);
            setUrl(valueOf.length() != 0 ? "https://developers.google.com/actions?invocation=".concat(valueOf) : new String("https://developers.google.com/actions?invocation="));
        }
        return super.build();
    }

    public final AssistActionBuilder setActionToken(String str) {
        Objects.requireNonNull(str, "null reference");
        this.zzeq = str;
        return this;
    }
}
