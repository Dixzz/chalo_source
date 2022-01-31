package com.crashlytics.android.answers;

public class KeepAllEventFilter implements EventFilter {
    @Override // com.crashlytics.android.answers.EventFilter
    public boolean skipEvent(SessionEvent sessionEvent) {
        return false;
    }
}
