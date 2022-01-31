package com.crashlytics.android.core;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class InvalidSessionReport implements Report {
    private final Map<String, String> customHeaders = new HashMap(ReportUploader.HEADER_INVALID_CLS_FILE);
    private final File[] files;
    private final String identifier;

    public InvalidSessionReport(String str, File[] fileArr) {
        this.files = fileArr;
        this.identifier = str;
    }

    @Override // com.crashlytics.android.core.Report
    public Map<String, String> getCustomHeaders() {
        return Collections.unmodifiableMap(this.customHeaders);
    }

    @Override // com.crashlytics.android.core.Report
    public File getFile() {
        return this.files[0];
    }

    @Override // com.crashlytics.android.core.Report
    public String getFileName() {
        return this.files[0].getName();
    }

    @Override // com.crashlytics.android.core.Report
    public File[] getFiles() {
        return this.files;
    }

    @Override // com.crashlytics.android.core.Report
    public String getIdentifier() {
        return this.identifier;
    }

    @Override // com.crashlytics.android.core.Report
    public void remove() {
        File[] fileArr = this.files;
        for (File file : fileArr) {
            file.getPath();
            file.delete();
        }
    }
}
