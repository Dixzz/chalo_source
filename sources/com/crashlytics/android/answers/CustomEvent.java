package com.crashlytics.android.answers;

import java.util.Objects;

public class CustomEvent extends AnswersEvent<CustomEvent> {
    private final String eventName;

    public CustomEvent(String str) {
        Objects.requireNonNull(str, "eventName must not be null");
        this.eventName = this.validator.limitStringLength(str);
    }

    public String getCustomType() {
        return this.eventName;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("{eventName:\"");
        hj1.U0(i0, this.eventName, '\"', ", customAttributes:");
        i0.append(this.customAttributes);
        i0.append("}");
        return i0.toString();
    }
}
