package com.crashlytics.android.answers;

import com.crashlytics.android.answers.PredefinedEvent;
import java.util.Map;

public abstract class PredefinedEvent<T extends PredefinedEvent> extends AnswersEvent<T> {
    public final AnswersAttributes predefinedAttributes = new AnswersAttributes(this.validator);

    public Map<String, Object> getPredefinedAttributes() {
        return this.predefinedAttributes.attributes;
    }

    public abstract String getPredefinedType();

    public String toString() {
        StringBuilder i0 = hj1.i0("{type:\"");
        i0.append(getPredefinedType());
        i0.append('\"');
        i0.append(", predefinedAttributes:");
        i0.append(this.predefinedAttributes);
        i0.append(", customAttributes:");
        i0.append(this.customAttributes);
        i0.append("}");
        return i0.toString();
    }
}
