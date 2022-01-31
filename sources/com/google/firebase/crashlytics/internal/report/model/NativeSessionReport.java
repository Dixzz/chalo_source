package com.google.firebase.crashlytics.internal.report.model;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.report.model.Report;
import java.io.File;
import java.util.Map;

public class NativeSessionReport implements Report {
    private final File reportDirectory;

    public NativeSessionReport(File file) {
        this.reportDirectory = file;
    }

    @Override // com.google.firebase.crashlytics.internal.report.model.Report
    public Map<String, String> getCustomHeaders() {
        return null;
    }

    @Override // com.google.firebase.crashlytics.internal.report.model.Report
    public File getFile() {
        return null;
    }

    @Override // com.google.firebase.crashlytics.internal.report.model.Report
    public String getFileName() {
        return null;
    }

    @Override // com.google.firebase.crashlytics.internal.report.model.Report
    public File[] getFiles() {
        return this.reportDirectory.listFiles();
    }

    @Override // com.google.firebase.crashlytics.internal.report.model.Report
    public String getIdentifier() {
        return this.reportDirectory.getName();
    }

    @Override // com.google.firebase.crashlytics.internal.report.model.Report
    public Report.Type getType() {
        return Report.Type.NATIVE;
    }

    @Override // com.google.firebase.crashlytics.internal.report.model.Report
    public void remove() {
        File[] files = getFiles();
        for (File file : files) {
            Logger logger = Logger.getLogger();
            StringBuilder i0 = hj1.i0("Removing native report file at ");
            i0.append(file.getPath());
            logger.d(i0.toString());
            file.delete();
        }
        Logger logger2 = Logger.getLogger();
        StringBuilder i02 = hj1.i0("Removing native report directory at ");
        i02.append(this.reportDirectory);
        logger2.d(i02.toString());
        this.reportDirectory.delete();
    }
}
