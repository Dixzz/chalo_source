package com.crashlytics.android.answers;

public class SearchEvent extends PredefinedEvent<SearchEvent> {
    public static final String QUERY_ATTRIBUTE = "query";
    public static final String TYPE = "search";

    @Override // com.crashlytics.android.answers.PredefinedEvent
    public String getPredefinedType() {
        return "search";
    }

    public SearchEvent putQuery(String str) {
        this.predefinedAttributes.put(QUERY_ATTRIBUTE, str);
        return this;
    }
}
