package com.crashlytics.android.core;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ReportUploader {
    private static final String CLS_FILE_EXT = ".cls";
    public static final Map<String, String> HEADER_INVALID_CLS_FILE = Collections.singletonMap("X-CRASHLYTICS-INVALID-SESSION", "1");
    private static final short[] RETRY_INTERVALS = {10, 20, 30, 60, 120, 300};
    private static final FilenameFilter crashFileFilter = new FilenameFilter() {
        /* class com.crashlytics.android.core.ReportUploader.AnonymousClass1 */

        public boolean accept(File file, String str) {
            return str.endsWith(".cls") && !str.contains("Session");
        }
    };
    private final String apiKey;
    private final CreateReportSpiCall createReportCall;
    private final Object fileAccessLock = new Object();
    private Thread uploadThread;

    public class Worker extends i06 {
        private final float delay;

        public Worker(float f) {
            this.delay = f;
        }

        private void attemptUploadWithRetry() {
            float f = this.delay;
            if (f > 0.0f) {
                try {
                    Thread.sleep((long) (f * 1000.0f));
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            CrashlyticsCore instance = CrashlyticsCore.getInstance();
            CrashlyticsUncaughtExceptionHandler handler = instance.getHandler();
            List<Report> findReports = ReportUploader.this.findReports();
            if (!handler.isHandlingException()) {
                if (findReports.isEmpty() || instance.canSendWithUserApproval()) {
                    int i = 0;
                    while (!findReports.isEmpty() && !CrashlyticsCore.getInstance().getHandler().isHandlingException()) {
                        findReports.size();
                        for (Report report : findReports) {
                            ReportUploader.this.forceUpload(report);
                        }
                        findReports = ReportUploader.this.findReports();
                        if (!findReports.isEmpty()) {
                            int i2 = i + 1;
                            try {
                                Thread.sleep(((long) ReportUploader.RETRY_INTERVALS[Math.min(i, ReportUploader.RETRY_INTERVALS.length - 1)]) * 1000);
                                i = i2;
                            } catch (InterruptedException unused2) {
                                Thread.currentThread().interrupt();
                                return;
                            }
                        }
                    }
                    return;
                }
                findReports.size();
                for (Report report2 : findReports) {
                    report2.remove();
                }
            }
        }

        @Override // defpackage.i06
        public void onRun() {
            try {
                attemptUploadWithRetry();
            } catch (Exception unused) {
            }
            ReportUploader.this.uploadThread = null;
        }
    }

    public ReportUploader(String str, CreateReportSpiCall createReportSpiCall) {
        if (createReportSpiCall != null) {
            this.createReportCall = createReportSpiCall;
            this.apiKey = str;
            return;
        }
        throw new IllegalArgumentException("createReportCall must not be null.");
    }

    public List<Report> findReports() {
        File[] listFiles;
        File[] listFiles2;
        CrashlyticsCore instance = CrashlyticsCore.getInstance();
        CrashlyticsUncaughtExceptionHandler handler = instance.getHandler();
        synchronized (this.fileAccessLock) {
            listFiles = instance.getSdkDirectory().listFiles(crashFileFilter);
            listFiles2 = handler.getInvalidFilesDir().listFiles();
        }
        LinkedList linkedList = new LinkedList();
        for (File file : listFiles) {
            file.getPath();
            linkedList.add(new SessionReport(file));
        }
        HashMap hashMap = new HashMap();
        if (listFiles2 != null) {
            for (File file2 : listFiles2) {
                String sessionIdFromSessionFile = CrashlyticsUncaughtExceptionHandler.getSessionIdFromSessionFile(file2);
                if (!hashMap.containsKey(sessionIdFromSessionFile)) {
                    hashMap.put(sessionIdFromSessionFile, new LinkedList());
                }
                ((List) hashMap.get(sessionIdFromSessionFile)).add(file2);
            }
        }
        for (String str : hashMap.keySet()) {
            List list = (List) hashMap.get(str);
            linkedList.add(new InvalidSessionReport(str, (File[]) list.toArray(new File[list.size()])));
        }
        linkedList.isEmpty();
        return linkedList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        r0 = "Error occurred sending report " + r4;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x001c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean forceUpload(com.crashlytics.android.core.Report r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.fileAccessLock
            monitor-enter(r0)
            com.crashlytics.android.core.CreateReportRequest r1 = new com.crashlytics.android.core.CreateReportRequest     // Catch:{ Exception -> 0x001c }
            java.lang.String r2 = r3.apiKey     // Catch:{ Exception -> 0x001c }
            r1.<init>(r2, r4)     // Catch:{ Exception -> 0x001c }
            com.crashlytics.android.core.CreateReportSpiCall r2 = r3.createReportCall     // Catch:{ Exception -> 0x001c }
            boolean r1 = r2.invoke(r1)     // Catch:{ Exception -> 0x001c }
            r4.getIdentifier()     // Catch:{ Exception -> 0x001c }
            if (r1 == 0) goto L_0x002c
            r4.remove()     // Catch:{ Exception -> 0x001c }
            r4 = 1
            goto L_0x002d
        L_0x001a:
            r4 = move-exception
            goto L_0x002f
        L_0x001c:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x001a }
            r1.<init>()     // Catch:{ all -> 0x001a }
            java.lang.String r2 = "Error occurred sending report "
            r1.append(r2)     // Catch:{ all -> 0x001a }
            r1.append(r4)     // Catch:{ all -> 0x001a }
            r1.toString()     // Catch:{ all -> 0x001a }
        L_0x002c:
            r4 = 0
        L_0x002d:
            monitor-exit(r0)     // Catch:{ all -> 0x001a }
            return r4
        L_0x002f:
            monitor-exit(r0)     // Catch:{ all -> 0x001a }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crashlytics.android.core.ReportUploader.forceUpload(com.crashlytics.android.core.Report):boolean");
    }

    public boolean isUploading() {
        return this.uploadThread != null;
    }

    public void uploadReports() {
        uploadReports(0.0f);
    }

    public synchronized void uploadReports(float f) {
        if (this.uploadThread == null) {
            Thread thread = new Thread(new Worker(f), "Crashlytics Report Uploader");
            this.uploadThread = thread;
            thread.start();
        }
    }
}
