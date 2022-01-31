package com.crashlytics.android.answers;

public class InviteEvent extends PredefinedEvent<InviteEvent> {
    public static final String METHOD_ATTRIBUTE = "method";
    public static final String TYPE = "invite";

    @Override // com.crashlytics.android.answers.PredefinedEvent
    public String getPredefinedType() {
        return TYPE;
    }

    public InviteEvent putMethod(String str) {
        this.predefinedAttributes.put("method", str);
        return this;
    }
}
