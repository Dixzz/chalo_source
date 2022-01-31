package com.crashlytics.android.core;

import java.io.File;
import java.io.IOException;

public class CrashlyticsFileMarker {
    private final u16 fileStore;
    private final String markerName;

    public CrashlyticsFileMarker(String str, u16 u16) {
        this.markerName = str;
        this.fileStore = u16;
    }

    private File getMarkerFile() {
        return new File(((v16) this.fileStore).a(), this.markerName);
    }

    public boolean create() {
        try {
            return getMarkerFile().createNewFile();
        } catch (IOException unused) {
            return false;
        }
    }

    public boolean isPresent() {
        return getMarkerFile().exists();
    }

    public boolean remove() {
        return getMarkerFile().delete();
    }
}
