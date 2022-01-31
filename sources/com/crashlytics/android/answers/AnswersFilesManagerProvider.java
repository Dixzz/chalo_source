package com.crashlytics.android.answers;

import android.content.Context;
import android.os.Looper;
import java.io.IOException;

public class AnswersFilesManagerProvider {
    public static final String SESSION_ANALYTICS_FILE_NAME = "session_analytics.tap";
    public static final String SESSION_ANALYTICS_TO_SEND_DIR = "session_analytics_to_send";
    public final Context context;
    public final u16 fileStore;

    public AnswersFilesManagerProvider(Context context2, u16 u16) {
        this.context = context2;
        this.fileStore = u16;
    }

    public SessionAnalyticsFilesManager getAnalyticsFilesManager() throws IOException {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return new SessionAnalyticsFilesManager(this.context, new SessionEventTransform(), new q06(), new m16(this.context, ((v16) this.fileStore).a(), SESSION_ANALYTICS_FILE_NAME, SESSION_ANALYTICS_TO_SEND_DIR));
        }
        throw new IllegalStateException("AnswersFilesManagerProvider cannot be called on the main thread");
    }
}
