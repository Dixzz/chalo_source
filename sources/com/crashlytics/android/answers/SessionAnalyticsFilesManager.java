package com.crashlytics.android.answers;

import android.content.Context;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

public class SessionAnalyticsFilesManager extends h16<SessionEvent> {
    private static final String SESSION_ANALYTICS_TO_SEND_FILE_EXTENSION = ".tap";
    private static final String SESSION_ANALYTICS_TO_SEND_FILE_PREFIX = "sa";
    private y16 analyticsSettingsData;

    public SessionAnalyticsFilesManager(Context context, SessionEventTransform sessionEventTransform, l06 l06, i16 i16) throws IOException {
        super(context, sessionEventTransform, l06, i16, 100);
    }

    @Override // defpackage.h16
    public String generateUniqueRollOverFileName() {
        UUID randomUUID = UUID.randomUUID();
        StringBuilder k0 = hj1.k0(SESSION_ANALYTICS_TO_SEND_FILE_PREFIX, "_");
        k0.append(randomUUID.toString());
        k0.append("_");
        Objects.requireNonNull((q06) this.currentTimeProvider);
        k0.append(System.currentTimeMillis());
        k0.append(SESSION_ANALYTICS_TO_SEND_FILE_EXTENSION);
        return k0.toString();
    }

    @Override // defpackage.h16
    public int getMaxByteSizePerFile() {
        if (this.analyticsSettingsData == null) {
            return super.getMaxByteSizePerFile();
        }
        throw null;
    }

    @Override // defpackage.h16
    public int getMaxFilesToKeep() {
        if (this.analyticsSettingsData == null) {
            return super.getMaxFilesToKeep();
        }
        throw null;
    }

    public void setAnalyticsSettingsData(y16 y16) {
    }
}
