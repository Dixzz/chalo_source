package com.crashlytics.android.answers;

import com.crashlytics.android.answers.SessionEvent;
import java.io.IOException;

public class DisabledSessionAnalyticsManagerStrategy implements SessionAnalyticsManagerStrategy {
    @Override // defpackage.k16, com.crashlytics.android.answers.SessionAnalyticsManagerStrategy
    public void cancelTimeBasedFileRollOver() {
    }

    @Override // com.crashlytics.android.answers.SessionAnalyticsManagerStrategy
    public void deleteAllEvents() {
    }

    @Override // com.crashlytics.android.answers.SessionAnalyticsManagerStrategy
    public void processEvent(SessionEvent.Builder builder) {
    }

    @Override // defpackage.k16, com.crashlytics.android.answers.SessionAnalyticsManagerStrategy
    public boolean rollFileOver() throws IOException {
        return false;
    }

    @Override // com.crashlytics.android.answers.SessionAnalyticsManagerStrategy
    public void scheduleTimeBasedRollOverIfNeeded() {
    }

    @Override // com.crashlytics.android.answers.SessionAnalyticsManagerStrategy
    public void sendEvents() {
    }

    @Override // com.crashlytics.android.answers.SessionAnalyticsManagerStrategy
    public void setAnalyticsSettingsData(y16 y16, String str) {
    }
}
