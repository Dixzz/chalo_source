package com.google.firebase.crashlytics.internal.report;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.BackgroundPriorityRunnable;
import com.google.firebase.crashlytics.internal.common.DataTransportState;
import com.google.firebase.crashlytics.internal.report.model.Report;
import com.google.firebase.crashlytics.internal.report.network.CreateReportSpiCall;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ReportUploader {
    private static final short[] RETRY_INTERVALS = {10, 20, 30, 60, 120, 300};
    private final CreateReportSpiCall createReportCall;
    private final DataTransportState dataTransportState;
    private final String googleAppId;
    private final HandlingExceptionCheck handlingExceptionCheck;
    private final String organizationId;
    private final ReportManager reportManager;
    private Thread uploadThread;

    public interface HandlingExceptionCheck {
        boolean isHandlingException();
    }

    public interface Provider {
        ReportUploader createReportUploader(AppSettingsData appSettingsData);
    }

    public interface ReportFilesProvider {
        File[] getCompleteSessionFiles();

        File[] getNativeReportFiles();
    }

    public class Worker extends BackgroundPriorityRunnable {
        private final boolean dataCollectionToken;
        private final float delay;
        private final List<Report> reports;

        public Worker(List<Report> list, boolean z, float f) {
            this.reports = list;
            this.dataCollectionToken = z;
            this.delay = f;
        }

        private void attemptUploadWithRetry(List<Report> list, boolean z) {
            Logger logger = Logger.getLogger();
            StringBuilder i0 = hj1.i0("Starting report processing in ");
            i0.append(this.delay);
            i0.append(" second(s)...");
            logger.d(i0.toString());
            float f = this.delay;
            if (f > 0.0f) {
                try {
                    Thread.sleep((long) (f * 1000.0f));
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            if (!ReportUploader.this.handlingExceptionCheck.isHandlingException()) {
                int i = 0;
                while (list.size() > 0 && !ReportUploader.this.handlingExceptionCheck.isHandlingException()) {
                    Logger logger2 = Logger.getLogger();
                    StringBuilder i02 = hj1.i0("Attempting to send ");
                    i02.append(list.size());
                    i02.append(" report(s)");
                    logger2.d(i02.toString());
                    ArrayList arrayList = new ArrayList();
                    for (Report report : list) {
                        if (!ReportUploader.this.uploadReport(report, z)) {
                            arrayList.add(report);
                        }
                    }
                    if (arrayList.size() > 0) {
                        int i2 = i + 1;
                        long j = (long) ReportUploader.RETRY_INTERVALS[Math.min(i, ReportUploader.RETRY_INTERVALS.length - 1)];
                        Logger logger3 = Logger.getLogger();
                        logger3.d("Report submission: scheduling delayed retry in " + j + " seconds");
                        try {
                            Thread.sleep(j * 1000);
                            i = i2;
                        } catch (InterruptedException unused2) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    list = arrayList;
                }
            }
        }

        @Override // com.google.firebase.crashlytics.internal.common.BackgroundPriorityRunnable
        public void onRun() {
            try {
                attemptUploadWithRetry(this.reports, this.dataCollectionToken);
            } catch (Exception e) {
                Logger.getLogger().e("An unexpected error occurred while attempting to upload crash reports.", e);
            }
            ReportUploader.this.uploadThread = null;
        }
    }

    public ReportUploader(String str, String str2, DataTransportState dataTransportState2, ReportManager reportManager2, CreateReportSpiCall createReportSpiCall, HandlingExceptionCheck handlingExceptionCheck2) {
        if (createReportSpiCall != null) {
            this.createReportCall = createReportSpiCall;
            this.organizationId = str;
            this.googleAppId = str2;
            this.dataTransportState = dataTransportState2;
            this.reportManager = reportManager2;
            this.handlingExceptionCheck = handlingExceptionCheck2;
            return;
        }
        throw new IllegalArgumentException("createReportCall must not be null.");
    }

    public boolean isUploading() {
        return this.uploadThread != null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean uploadReport(com.google.firebase.crashlytics.internal.report.model.Report r7, boolean r8) {
        /*
        // Method dump skipped, instructions count: 127
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.report.ReportUploader.uploadReport(com.google.firebase.crashlytics.internal.report.model.Report, boolean):boolean");
    }

    public synchronized void uploadReportsAsync(List<Report> list, boolean z, float f) {
        if (this.uploadThread != null) {
            Logger.getLogger().d("Report upload has already been started.");
            return;
        }
        Thread thread = new Thread(new Worker(list, z, f), "Crashlytics Report Uploader");
        this.uploadThread = thread;
        thread.start();
    }
}
