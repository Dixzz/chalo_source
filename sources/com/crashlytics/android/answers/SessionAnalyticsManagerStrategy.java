package com.crashlytics.android.answers;

import com.crashlytics.android.answers.SessionEvent;
import java.io.IOException;

public interface SessionAnalyticsManagerStrategy extends k16 {
    @Override // defpackage.k16
    /* synthetic */ void cancelTimeBasedFileRollOver();

    void deleteAllEvents();

    void processEvent(SessionEvent.Builder builder);

    @Override // defpackage.k16
    /* synthetic */ boolean rollFileOver() throws IOException;

    /* synthetic */ void scheduleTimeBasedRollOverIfNeeded();

    void sendEvents();

    void setAnalyticsSettingsData(y16 y16, String str);
}
