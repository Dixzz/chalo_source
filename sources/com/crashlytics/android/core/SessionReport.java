package com.crashlytics.android.core;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SessionReport implements Report {
    private final Map<String, String> customHeaders;
    private final File file;
    private final File[] files;

    public SessionReport(File file2) {
        this(file2, Collections.emptyMap());
    }

    @Override // com.crashlytics.android.core.Report
    public Map<String, String> getCustomHeaders() {
        return Collections.unmodifiableMap(this.customHeaders);
    }

    @Override // com.crashlytics.android.core.Report
    public File getFile() {
        return this.file;
    }

    @Override // com.crashlytics.android.core.Report
    public String getFileName() {
        return getFile().getName();
    }

    @Override // com.crashlytics.android.core.Report
    public File[] getFiles() {
        return this.files;
    }

    @Override // com.crashlytics.android.core.Report
    public String getIdentifier() {
        String fileName = getFileName();
        return fileName.substring(0, fileName.lastIndexOf(46));
    }

    @Override // com.crashlytics.android.core.Report
    public void remove() {
        this.file.getPath();
        this.file.delete();
    }

    public SessionReport(File file2, Map<String, String> map) {
        this.file = file2;
        this.files = new File[]{file2};
        HashMap hashMap = new HashMap(map);
        this.customHeaders = hashMap;
        if (file2.length() == 0) {
            hashMap.putAll(ReportUploader.HEADER_INVALID_CLS_FILE);
        }
    }
}
