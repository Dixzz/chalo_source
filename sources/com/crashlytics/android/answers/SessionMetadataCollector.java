package com.crashlytics.android.answers;

import android.content.Context;

public class SessionMetadataCollector {
    private final Context context;
    private final o06 idManager;
    private final String versionCode;
    private final String versionName;

    public SessionMetadataCollector(Context context2, o06 o06, String str, String str2) {
        this.context = context2;
        this.versionCode = str;
        this.versionName = str2;
    }

    public SessionEventMetadata getMetadata() {
        throw null;
    }
}
