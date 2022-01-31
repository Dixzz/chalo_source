package com.crashlytics.android.core;

import android.content.Context;
import com.crashlytics.android.core.internal.models.SessionEventData;
import defpackage.c26;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.Thread;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrashlyticsUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    private static final int ANALYZER_VERSION = 1;
    public static final FilenameFilter ANY_SESSION_FILENAME_FILTER = new FilenameFilter() {
        /* class com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler.AnonymousClass4 */

        public boolean accept(File file, String str) {
            return CrashlyticsUncaughtExceptionHandler.SESSION_FILE_PATTERN.matcher(str).matches();
        }
    };
    private static final String EVENT_TYPE_CRASH = "crash";
    private static final String EVENT_TYPE_LOGGED = "error";
    private static final String GENERATOR_FORMAT = "Crashlytics Android SDK/%s";
    private static final String[] INITIAL_SESSION_PART_TAGS = {"SessionUser", "SessionApp", "SessionOS", "SessionDevice"};
    public static final String INVALID_CLS_CACHE_DIR = "invalidClsFiles";
    public static final Comparator<File> LARGEST_FILE_NAME_FIRST = new Object() {
        /* class com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler.AnonymousClass2 */

        /* Return type fixed from 'java.util.Comparator' to match base method */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ Comparator<File> reversed() {
            return Comparator.CC.$default$reversed(this);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function) {
            return Comparator.CC.$default$thenComparing(this, function);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, function, comparator);
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.Comparator] */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ java.util.Comparator<File> thenComparing(java.util.Comparator<? super File> comparator) {
            return Comparator.CC.$default$thenComparing(this, comparator);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
            return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
            return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
            return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
        }

        public int compare(File file, File file2) {
            return file2.getName().compareTo(file.getName());
        }
    };
    private static final int MAX_COMPLETE_SESSIONS_COUNT = 4;
    public static final int MAX_INVALID_SESSIONS = 4;
    private static final int MAX_LOCAL_LOGGED_EXCEPTIONS = 64;
    public static final int MAX_OPEN_SESSIONS = 8;
    public static final int MAX_STACK_SIZE = 1024;
    public static final int NUM_STACK_REPETITIONS_ALLOWED = 10;
    private static final Map<String, String> SEND_AT_CRASHTIME_HEADER = Collections.singletonMap("X-CRASHLYTICS-SEND-FLAGS", "1");
    public static final String SESSION_APP_TAG = "SessionApp";
    public static final String SESSION_BEGIN_TAG = "BeginSession";
    public static final String SESSION_DEVICE_TAG = "SessionDevice";
    public static final String SESSION_EVENT_MISSING_BINARY_IMGS_TAG = "SessionMissingBinaryImages";
    public static final String SESSION_FATAL_TAG = "SessionCrash";
    public static final FilenameFilter SESSION_FILE_FILTER = new FilenameFilter() {
        /* class com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler.AnonymousClass1 */

        public boolean accept(File file, String str) {
            return str.length() == 39 && str.endsWith(".cls");
        }
    };
    private static final Pattern SESSION_FILE_PATTERN = Pattern.compile("([\\d|A-Z|a-z]{12}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{12}).+");
    private static final int SESSION_ID_LENGTH = 35;
    public static final String SESSION_NON_FATAL_TAG = "SessionEvent";
    public static final String SESSION_OS_TAG = "SessionOS";
    public static final String SESSION_USER_TAG = "SessionUser";
    public static final java.util.Comparator<File> SMALLEST_FILE_NAME_FIRST = new Object() {
        /* class com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler.AnonymousClass3 */

        /* Return type fixed from 'java.util.Comparator' to match base method */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ java.util.Comparator<File> reversed() {
            return Comparator.CC.$default$reversed(this);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function) {
            return Comparator.CC.$default$thenComparing(this, function);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, function, comparator);
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.Comparator] */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ java.util.Comparator<File> thenComparing(java.util.Comparator<? super File> comparator) {
            return Comparator.CC.$default$thenComparing(this, comparator);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
            return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
            return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
            return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
        }

        public int compare(File file, File file2) {
            return file.getName().compareTo(file2.getName());
        }
    };
    private final CrashlyticsCore crashlyticsCore;
    private final Thread.UncaughtExceptionHandler defaultHandler;
    private final DevicePowerStateListener devicePowerStateListener;
    private final AtomicInteger eventCounter = new AtomicInteger(0);
    private final CrashlyticsExecutorServiceWrapper executorServiceWrapper;
    private final u16 fileStore;
    private final o06 idManager;
    private final AtomicBoolean isHandlingException;
    private final LogFileManager logFileManager;
    private final StackTraceTrimmingStrategy stackTraceTrimmingStrategy;
    private final String unityVersion;

    public static class AnySessionPartFileFilter implements FilenameFilter {
        private AnySessionPartFileFilter() {
        }

        public boolean accept(File file, String str) {
            return !CrashlyticsUncaughtExceptionHandler.SESSION_FILE_FILTER.accept(file, str) && CrashlyticsUncaughtExceptionHandler.SESSION_FILE_PATTERN.matcher(str).matches();
        }
    }

    public static class FileNameContainsFilter implements FilenameFilter {
        private final String string;

        public FileNameContainsFilter(String str) {
            this.string = str;
        }

        public boolean accept(File file, String str) {
            return str.contains(this.string) && !str.endsWith(".cls_temp");
        }
    }

    public static class InvalidPartFileFilter implements FilenameFilter {
        public boolean accept(File file, String str) {
            return ClsFileOutputStream.TEMP_FILENAME_FILTER.accept(file, str) || str.contains("SessionMissingBinaryImages");
        }
    }

    public static final class SendSessionRunnable implements Runnable {
        private final CrashlyticsCore crashlyticsCore;
        private final File fileToSend;

        public SendSessionRunnable(CrashlyticsCore crashlyticsCore2, File file) {
            this.crashlyticsCore = crashlyticsCore2;
            this.fileToSend = file;
        }

        public void run() {
            CreateReportSpiCall createReportSpiCall;
            if (j06.a(this.crashlyticsCore.getContext()) && (createReportSpiCall = this.crashlyticsCore.getCreateReportSpiCall(c26.b.f510a.a())) != null) {
                new ReportUploader(this.crashlyticsCore.getApiKey(), createReportSpiCall).forceUpload(new SessionReport(this.fileToSend, CrashlyticsUncaughtExceptionHandler.SEND_AT_CRASHTIME_HEADER));
            }
        }
    }

    public static class SessionPartFileFilter implements FilenameFilter {
        private final String sessionId;

        public SessionPartFileFilter(String str) {
            this.sessionId = str;
        }

        public boolean accept(File file, String str) {
            if (!str.equals(this.sessionId + ".cls") && str.contains(this.sessionId) && !str.endsWith(".cls_temp")) {
                return true;
            }
            return false;
        }
    }

    public CrashlyticsUncaughtExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, CrashlyticsExecutorServiceWrapper crashlyticsExecutorServiceWrapper, o06 o06, UnityVersionProvider unityVersionProvider, u16 u16, CrashlyticsCore crashlyticsCore2) {
        this.defaultHandler = uncaughtExceptionHandler;
        this.executorServiceWrapper = crashlyticsExecutorServiceWrapper;
        this.crashlyticsCore = crashlyticsCore2;
        this.unityVersion = unityVersionProvider.getUnityVersion();
        this.fileStore = u16;
        this.isHandlingException = new AtomicBoolean(false);
        Context context = crashlyticsCore2.getContext();
        this.logFileManager = new LogFileManager(context, u16);
        this.devicePowerStateListener = new DevicePowerStateListener(context);
        this.stackTraceTrimmingStrategy = new MiddleOutFallbackStrategy(1024, new RemoveRepeatsStrategy(10));
    }

    private void closeOpenSessions(File[] fileArr, int i, int i2) {
        while (i < fileArr.length) {
            File file = fileArr[i];
            writeSessionPartsToSessionFile(file, getSessionIdFromSessionFile(file), i2);
            i++;
        }
    }

    private void closeWithoutRenamingOrLog(ClsFileOutputStream clsFileOutputStream) {
        if (clsFileOutputStream != null) {
            try {
                clsFileOutputStream.closeInProgressStream();
            } catch (IOException unused) {
            }
        }
    }

    private static void copyToCodedOutputStream(InputStream inputStream, CodedOutputStream codedOutputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read < 0) {
                break;
            }
            i2 += read;
        }
        codedOutputStream.writeRawBytes(bArr);
    }

    private void deleteSessionPartFilesFor(String str) {
        for (File file : listSessionPartFilesFor(str)) {
            file.delete();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void doOpenSession() throws Exception {
        Date date = new Date();
        String clsuuid = new CLSUUID(this.idManager).toString();
        writeBeginSession(clsuuid, date);
        writeSessionApp(clsuuid);
        writeSessionOS(clsuuid);
        writeSessionDevice(clsuuid);
        this.logFileManager.setCurrentSession(clsuuid);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:5|(1:9)|(1:11)(1:12)|13|(3:14|15|(2:17|18))|19|20|44) */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006f */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0079 A[SYNTHETIC, Splitter:B:25:0x0079] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x007e A[SYNTHETIC, Splitter:B:29:0x007e] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0085 A[SYNTHETIC, Splitter:B:37:0x0085] */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void doWriteExternalCrashEvent(com.crashlytics.android.core.internal.models.SessionEventData r9) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 140
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler.doWriteExternalCrashEvent(com.crashlytics.android.core.internal.models.SessionEventData):void");
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0083, code lost:
        if (r3 != null) goto L_0x006a;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x006a */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0074 A[SYNTHETIC, Splitter:B:17:0x0074] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0079 A[SYNTHETIC, Splitter:B:21:0x0079] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0080 A[SYNTHETIC, Splitter:B:29:0x0080] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void doWriteNonFatal(java.util.Date r13, java.lang.Thread r14, java.lang.Throwable r15) {
        /*
        // Method dump skipped, instructions count: 140
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler.doWriteNonFatal(java.util.Date, java.lang.Thread, java.lang.Throwable):void");
    }

    private File[] ensureFileArrayNotNull(File[] fileArr) {
        return fileArr == null ? new File[0] : fileArr;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String getCurrentSessionId() {
        File[] listSortedSessionBeginFiles = listSortedSessionBeginFiles();
        if (listSortedSessionBeginFiles.length > 0) {
            return getSessionIdFromSessionFile(listSortedSessionBeginFiles[0]);
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private File getFilesDir() {
        return ((v16) this.fileStore).a();
    }

    private String getPreviousSessionId() {
        File[] listSortedSessionBeginFiles = listSortedSessionBeginFiles();
        if (listSortedSessionBeginFiles.length > 1) {
            return getSessionIdFromSessionFile(listSortedSessionBeginFiles[1]);
        }
        return null;
    }

    public static String getSessionIdFromSessionFile(File file) {
        return file.getName().substring(0, 35);
    }

    private File[] getTrimmedNonFatalFiles(String str, File[] fileArr, int i) {
        if (fileArr.length <= i) {
            return fileArr;
        }
        String.format(Locale.US, "Trimming down to %d logged exceptions.", Integer.valueOf(i));
        trimSessionEventFiles(str, i);
        return listFilesMatching(new FileNameContainsFilter(hj1.S(str, "SessionEvent")));
    }

    private UserMetaData getUserMetaData(String str) {
        return isHandlingException() ? new UserMetaData(this.crashlyticsCore.getUserIdentifier(), this.crashlyticsCore.getUserName(), this.crashlyticsCore.getUserEmail()) : new MetaDataStore(getFilesDir()).readUserData(str);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void handleUncaughtException(Date date, Thread thread, Throwable th) throws Exception {
        this.crashlyticsCore.createCrashMarker();
        writeFatal(date, thread, th);
        doCloseSessions();
        doOpenSession();
        trimSessionFiles();
        if (!this.crashlyticsCore.shouldPromptUserBeforeSendingCrashReports()) {
            sendSessionReports();
        }
    }

    private File[] listCompleteSessionFiles() {
        return listFilesMatching(SESSION_FILE_FILTER);
    }

    private File[] listFiles(File file) {
        return ensureFileArrayNotNull(file.listFiles());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private File[] listFilesMatching(FilenameFilter filenameFilter) {
        return listFilesMatching(getFilesDir(), filenameFilter);
    }

    private File[] listSessionPartFilesFor(String str) {
        return listFilesMatching(new SessionPartFileFilter(str));
    }

    private File[] listSortedSessionBeginFiles() {
        File[] listSessionBeginFiles = listSessionBeginFiles();
        Arrays.sort(listSessionBeginFiles, LARGEST_FILE_NAME_FIRST);
        return listSessionBeginFiles;
    }

    private void retainSessions(File[] fileArr, Set<String> set) {
        for (File file : fileArr) {
            Matcher matcher = SESSION_FILE_PATTERN.matcher(file.getName());
            if (!matcher.matches()) {
                file.delete();
                return;
            }
            if (!set.contains(matcher.group(1))) {
                file.delete();
            }
        }
    }

    private void sendSessionReports() {
        for (File file : listCompleteSessionFiles()) {
            this.executorServiceWrapper.executeAsync(new SendSessionRunnable(this.crashlyticsCore, file));
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0044 */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004e A[SYNTHETIC, Splitter:B:19:0x004e] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0053 A[SYNTHETIC, Splitter:B:23:0x0053] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x005a A[SYNTHETIC, Splitter:B:31:0x005a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void synthesizeSessionFile(java.io.File r9, java.lang.String r10, java.io.File[] r11, java.io.File r12) {
        /*
            r8 = this;
            r0 = 1
            if (r12 == 0) goto L_0x0005
            r1 = 1
            goto L_0x0006
        L_0x0005:
            r1 = 0
        L_0x0006:
            r2 = 0
            com.crashlytics.android.core.ClsFileOutputStream r3 = new com.crashlytics.android.core.ClsFileOutputStream     // Catch:{ Exception -> 0x0057, all -> 0x004a }
            java.io.File r4 = r8.getFilesDir()     // Catch:{ Exception -> 0x0057, all -> 0x004a }
            r3.<init>(r4, r10)     // Catch:{ Exception -> 0x0057, all -> 0x004a }
            com.crashlytics.android.core.CodedOutputStream r2 = com.crashlytics.android.core.CodedOutputStream.newInstance(r3)     // Catch:{ Exception -> 0x0058, all -> 0x0048 }
            writeToCosFromFile(r2, r9)     // Catch:{ Exception -> 0x0058, all -> 0x0048 }
            r9 = 4
            java.util.Date r4 = new java.util.Date     // Catch:{ Exception -> 0x0058, all -> 0x0048 }
            r4.<init>()     // Catch:{ Exception -> 0x0058, all -> 0x0048 }
            long r4 = r4.getTime()     // Catch:{ Exception -> 0x0058, all -> 0x0048 }
            r6 = 1000(0x3e8, double:4.94E-321)
            long r4 = r4 / r6
            r2.writeUInt64(r9, r4)     // Catch:{ Exception -> 0x0058, all -> 0x0048 }
            r9 = 5
            r2.writeBool(r9, r1)     // Catch:{ Exception -> 0x0058, all -> 0x0048 }
            r9 = 11
            r2.writeUInt32(r9, r0)     // Catch:{ Exception -> 0x0058, all -> 0x0048 }
            r9 = 12
            r0 = 3
            r2.writeEnum(r9, r0)     // Catch:{ Exception -> 0x0058, all -> 0x0048 }
            r8.writeInitialPartsTo(r2, r10)     // Catch:{ Exception -> 0x0058, all -> 0x0048 }
            writeNonFatalEventsTo(r2, r11, r10)     // Catch:{ Exception -> 0x0058, all -> 0x0048 }
            if (r1 == 0) goto L_0x0041
            writeToCosFromFile(r2, r12)     // Catch:{ Exception -> 0x0058, all -> 0x0048 }
        L_0x0041:
            r2.flush()     // Catch:{ IOException -> 0x0044 }
        L_0x0044:
            r3.close()     // Catch:{ IOException -> 0x0060 }
            goto L_0x0060
        L_0x0048:
            r9 = move-exception
            goto L_0x004c
        L_0x004a:
            r9 = move-exception
            r3 = r2
        L_0x004c:
            if (r2 == 0) goto L_0x0051
            r2.flush()     // Catch:{ IOException -> 0x0051 }
        L_0x0051:
            if (r3 == 0) goto L_0x0056
            r3.close()     // Catch:{ IOException -> 0x0056 }
        L_0x0056:
            throw r9
        L_0x0057:
            r3 = r2
        L_0x0058:
            if (r2 == 0) goto L_0x005d
            r2.flush()     // Catch:{ IOException -> 0x005d }
        L_0x005d:
            r8.closeWithoutRenamingOrLog(r3)
        L_0x0060:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler.synthesizeSessionFile(java.io.File, java.lang.String, java.io.File[], java.io.File):void");
    }

    private void trimInvalidSessionFiles() {
        File invalidFilesDir = getInvalidFilesDir();
        if (invalidFilesDir.exists()) {
            File[] listFilesMatching = listFilesMatching(invalidFilesDir, new InvalidPartFileFilter());
            Arrays.sort(listFilesMatching, Collections.reverseOrder());
            HashSet hashSet = new HashSet();
            for (int i = 0; i < listFilesMatching.length && hashSet.size() < 4; i++) {
                hashSet.add(getSessionIdFromSessionFile(listFilesMatching[i]));
            }
            retainSessions(listFiles(invalidFilesDir), hashSet);
        }
    }

    private void trimOpenSessions(int i) {
        HashSet hashSet = new HashSet();
        File[] listSortedSessionBeginFiles = listSortedSessionBeginFiles();
        int min = Math.min(i, listSortedSessionBeginFiles.length);
        for (int i2 = 0; i2 < min; i2++) {
            hashSet.add(getSessionIdFromSessionFile(listSortedSessionBeginFiles[i2]));
        }
        this.logFileManager.discardOldLogFiles(hashSet);
        retainSessions(listFilesMatching(new AnySessionPartFileFilter()), hashSet);
    }

    private void trimSessionEventFiles(String str, int i) {
        Utils.capFileCount(getFilesDir(), new FileNameContainsFilter(hj1.S(str, "SessionEvent")), i, SMALLEST_FILE_NAME_FIRST);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:1|2|3|4|(2:6|7)|8|9|23) */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0042 */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004c A[SYNTHETIC, Splitter:B:15:0x004c] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0051 A[SYNTHETIC, Splitter:B:19:0x0051] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void writeBeginSession(java.lang.String r8, java.util.Date r9) throws java.lang.Exception {
        /*
            r7 = this;
            r0 = 0
            com.crashlytics.android.core.ClsFileOutputStream r1 = new com.crashlytics.android.core.ClsFileOutputStream     // Catch:{ all -> 0x0048 }
            java.io.File r2 = r7.getFilesDir()     // Catch:{ all -> 0x0048 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0048 }
            r3.<init>()     // Catch:{ all -> 0x0048 }
            r3.append(r8)     // Catch:{ all -> 0x0048 }
            java.lang.String r4 = "BeginSession"
            r3.append(r4)     // Catch:{ all -> 0x0048 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0048 }
            r1.<init>(r2, r3)     // Catch:{ all -> 0x0048 }
            com.crashlytics.android.core.CodedOutputStream r0 = com.crashlytics.android.core.CodedOutputStream.newInstance(r1)     // Catch:{ all -> 0x0046 }
            java.util.Locale r2 = java.util.Locale.US     // Catch:{ all -> 0x0046 }
            java.lang.String r3 = "Crashlytics Android SDK/%s"
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x0046 }
            r5 = 0
            com.crashlytics.android.core.CrashlyticsCore r6 = r7.crashlyticsCore     // Catch:{ all -> 0x0046 }
            java.lang.String r6 = r6.getVersion()     // Catch:{ all -> 0x0046 }
            r4[r5] = r6     // Catch:{ all -> 0x0046 }
            java.lang.String r2 = java.lang.String.format(r2, r3, r4)     // Catch:{ all -> 0x0046 }
            long r3 = r9.getTime()     // Catch:{ all -> 0x0046 }
            r5 = 1000(0x3e8, double:4.94E-321)
            long r3 = r3 / r5
            com.crashlytics.android.core.SessionProtobufHelper.writeBeginSession(r0, r8, r2, r3)     // Catch:{ all -> 0x0046 }
            if (r0 == 0) goto L_0x0042
            r0.flush()     // Catch:{ IOException -> 0x0042 }
        L_0x0042:
            r1.close()     // Catch:{ IOException -> 0x0045 }
        L_0x0045:
            return
        L_0x0046:
            r8 = move-exception
            goto L_0x004a
        L_0x0048:
            r8 = move-exception
            r1 = r0
        L_0x004a:
            if (r0 == 0) goto L_0x004f
            r0.flush()     // Catch:{ IOException -> 0x004f }
        L_0x004f:
            if (r1 == 0) goto L_0x0054
            r1.close()     // Catch:{ IOException -> 0x0054 }
        L_0x0054:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler.writeBeginSession(java.lang.String, java.util.Date):void");
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0041 */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004b A[SYNTHETIC, Splitter:B:17:0x004b] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0050 A[SYNTHETIC, Splitter:B:21:0x0050] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0057 A[SYNTHETIC, Splitter:B:29:0x0057] */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void writeFatal(java.util.Date r12, java.lang.Thread r13, java.lang.Throwable r14) {
        /*
            r11 = this;
            r0 = 0
            java.lang.String r1 = r11.getCurrentSessionId()     // Catch:{ Exception -> 0x0054, all -> 0x0047 }
            if (r1 != 0) goto L_0x0008
            return
        L_0x0008:
            java.lang.Class r2 = r14.getClass()     // Catch:{ Exception -> 0x0054, all -> 0x0047 }
            java.lang.String r2 = r2.getName()     // Catch:{ Exception -> 0x0054, all -> 0x0047 }
            com.crashlytics.android.core.CrashlyticsCore.recordFatalExceptionEvent(r1, r2)     // Catch:{ Exception -> 0x0054, all -> 0x0047 }
            com.crashlytics.android.core.ClsFileOutputStream r2 = new com.crashlytics.android.core.ClsFileOutputStream     // Catch:{ Exception -> 0x0054, all -> 0x0047 }
            java.io.File r3 = r11.getFilesDir()     // Catch:{ Exception -> 0x0054, all -> 0x0047 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0054, all -> 0x0047 }
            r4.<init>()     // Catch:{ Exception -> 0x0054, all -> 0x0047 }
            r4.append(r1)     // Catch:{ Exception -> 0x0054, all -> 0x0047 }
            java.lang.String r1 = "SessionCrash"
            r4.append(r1)     // Catch:{ Exception -> 0x0054, all -> 0x0047 }
            java.lang.String r1 = r4.toString()     // Catch:{ Exception -> 0x0054, all -> 0x0047 }
            r2.<init>(r3, r1)     // Catch:{ Exception -> 0x0054, all -> 0x0047 }
            com.crashlytics.android.core.CodedOutputStream r0 = com.crashlytics.android.core.CodedOutputStream.newInstance(r2)     // Catch:{ Exception -> 0x0055, all -> 0x0045 }
            java.lang.String r9 = "crash"
            r10 = 1
            r4 = r11
            r5 = r0
            r6 = r12
            r7 = r13
            r8 = r14
            r4.writeSessionEvent(r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0055, all -> 0x0045 }
            if (r0 == 0) goto L_0x0041
            r0.flush()     // Catch:{ IOException -> 0x0041 }
        L_0x0041:
            r2.close()     // Catch:{ IOException -> 0x005d }
            goto L_0x005d
        L_0x0045:
            r12 = move-exception
            goto L_0x0049
        L_0x0047:
            r12 = move-exception
            r2 = r0
        L_0x0049:
            if (r0 == 0) goto L_0x004e
            r0.flush()     // Catch:{ IOException -> 0x004e }
        L_0x004e:
            if (r2 == 0) goto L_0x0053
            r2.close()     // Catch:{ IOException -> 0x0053 }
        L_0x0053:
            throw r12
        L_0x0054:
            r2 = r0
        L_0x0055:
            if (r0 == 0) goto L_0x005a
            r0.flush()     // Catch:{ IOException -> 0x005a }
        L_0x005a:
            if (r2 == 0) goto L_0x005d
            goto L_0x0041
        L_0x005d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler.writeFatal(java.util.Date, java.lang.Thread, java.lang.Throwable):void");
    }

    private void writeInitialPartsTo(CodedOutputStream codedOutputStream, String str) throws IOException {
        for (String str2 : INITIAL_SESSION_PART_TAGS) {
            File[] listFilesMatching = listFilesMatching(new FileNameContainsFilter(hj1.S(str, str2)));
            if (listFilesMatching.length != 0) {
                writeToCosFromFile(codedOutputStream, listFilesMatching[0]);
            }
        }
    }

    private static void writeNonFatalEventsTo(CodedOutputStream codedOutputStream, File[] fileArr, String str) {
        Arrays.sort(fileArr, j06.d);
        for (File file : fileArr) {
            try {
                String.format(Locale.US, "Found Non Fatal for session ID %s in %s ", str, file.getName());
                writeToCosFromFile(codedOutputStream, file);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002d A[SYNTHETIC, Splitter:B:13:0x002d] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0032 A[SYNTHETIC, Splitter:B:17:0x0032] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void writeSessionApp(java.lang.String r6) throws java.lang.Exception {
        /*
            r5 = this;
            r0 = 0
            com.crashlytics.android.core.ClsFileOutputStream r1 = new com.crashlytics.android.core.ClsFileOutputStream     // Catch:{ all -> 0x0027 }
            java.io.File r2 = r5.getFilesDir()     // Catch:{ all -> 0x0027 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0027 }
            r3.<init>()     // Catch:{ all -> 0x0027 }
            r3.append(r6)     // Catch:{ all -> 0x0027 }
            java.lang.String r6 = "SessionApp"
            r3.append(r6)     // Catch:{ all -> 0x0027 }
            java.lang.String r6 = r3.toString()     // Catch:{ all -> 0x0027 }
            r1.<init>(r2, r6)     // Catch:{ all -> 0x0027 }
            com.crashlytics.android.core.CodedOutputStream r6 = com.crashlytics.android.core.CodedOutputStream.newInstance(r1)     // Catch:{ all -> 0x0022 }
            throw r0     // Catch:{ all -> 0x0020 }
        L_0x0020:
            r0 = move-exception
            goto L_0x002b
        L_0x0022:
            r6 = move-exception
            r4 = r0
            r0 = r6
            r6 = r4
            goto L_0x002b
        L_0x0027:
            r6 = move-exception
            r1 = r0
            r0 = r6
            r6 = r1
        L_0x002b:
            if (r6 == 0) goto L_0x0030
            r6.flush()     // Catch:{ IOException -> 0x0030 }
        L_0x0030:
            if (r1 == 0) goto L_0x0035
            r1.close()     // Catch:{ IOException -> 0x0035 }
        L_0x0035:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler.writeSessionApp(java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003f A[SYNTHETIC, Splitter:B:14:0x003f] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0044 A[SYNTHETIC, Splitter:B:18:0x0044] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void writeSessionDevice(java.lang.String r6) throws java.lang.Exception {
        /*
            r5 = this;
            r0 = 0
            com.crashlytics.android.core.ClsFileOutputStream r1 = new com.crashlytics.android.core.ClsFileOutputStream     // Catch:{ all -> 0x0039 }
            java.io.File r2 = r5.getFilesDir()     // Catch:{ all -> 0x0039 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0039 }
            r3.<init>()     // Catch:{ all -> 0x0039 }
            r3.append(r6)     // Catch:{ all -> 0x0039 }
            java.lang.String r6 = "SessionDevice"
            r3.append(r6)     // Catch:{ all -> 0x0039 }
            java.lang.String r6 = r3.toString()     // Catch:{ all -> 0x0039 }
            r1.<init>(r2, r6)     // Catch:{ all -> 0x0039 }
            com.crashlytics.android.core.CodedOutputStream r6 = com.crashlytics.android.core.CodedOutputStream.newInstance(r1)     // Catch:{ all -> 0x0034 }
            com.crashlytics.android.core.CrashlyticsCore r2 = r5.crashlyticsCore     // Catch:{ all -> 0x0032 }
            r2.getContext()     // Catch:{ all -> 0x0032 }
            android.os.StatFs r2 = new android.os.StatFs     // Catch:{ all -> 0x0032 }
            java.io.File r3 = android.os.Environment.getDataDirectory()     // Catch:{ all -> 0x0032 }
            java.lang.String r3 = r3.getPath()     // Catch:{ all -> 0x0032 }
            r2.<init>(r3)     // Catch:{ all -> 0x0032 }
            throw r0     // Catch:{ all -> 0x0032 }
        L_0x0032:
            r0 = move-exception
            goto L_0x003d
        L_0x0034:
            r6 = move-exception
            r4 = r0
            r0 = r6
            r6 = r4
            goto L_0x003d
        L_0x0039:
            r6 = move-exception
            r1 = r0
            r0 = r6
            r6 = r1
        L_0x003d:
            if (r6 == 0) goto L_0x0042
            r6.flush()     // Catch:{ IOException -> 0x0042 }
        L_0x0042:
            if (r1 == 0) goto L_0x0047
            r1.close()     // Catch:{ IOException -> 0x0047 }
        L_0x0047:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler.writeSessionDevice(java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x009e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void writeSessionEvent(com.crashlytics.android.core.CodedOutputStream r3, java.util.Date r4, java.lang.Thread r5, java.lang.Throwable r6, java.lang.String r7, boolean r8) throws java.lang.Exception {
        /*
        // Method dump skipped, instructions count: 185
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler.writeSessionEvent(com.crashlytics.android.core.CodedOutputStream, java.util.Date, java.lang.Thread, java.lang.Throwable, java.lang.String, boolean):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:1|2|3|4|(2:6|7)|8|9|23) */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0031 */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003b A[SYNTHETIC, Splitter:B:15:0x003b] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0040 A[SYNTHETIC, Splitter:B:19:0x0040] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void writeSessionOS(java.lang.String r5) throws java.lang.Exception {
        /*
            r4 = this;
            r0 = 0
            com.crashlytics.android.core.ClsFileOutputStream r1 = new com.crashlytics.android.core.ClsFileOutputStream     // Catch:{ all -> 0x0037 }
            java.io.File r2 = r4.getFilesDir()     // Catch:{ all -> 0x0037 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0037 }
            r3.<init>()     // Catch:{ all -> 0x0037 }
            r3.append(r5)     // Catch:{ all -> 0x0037 }
            java.lang.String r5 = "SessionOS"
            r3.append(r5)     // Catch:{ all -> 0x0037 }
            java.lang.String r5 = r3.toString()     // Catch:{ all -> 0x0037 }
            r1.<init>(r2, r5)     // Catch:{ all -> 0x0037 }
            com.crashlytics.android.core.CodedOutputStream r0 = com.crashlytics.android.core.CodedOutputStream.newInstance(r1)     // Catch:{ all -> 0x0035 }
            com.crashlytics.android.core.CrashlyticsCore r5 = r4.crashlyticsCore     // Catch:{ all -> 0x0035 }
            android.content.Context r5 = r5.getContext()     // Catch:{ all -> 0x0035 }
            boolean r5 = defpackage.j06.k(r5)     // Catch:{ all -> 0x0035 }
            com.crashlytics.android.core.SessionProtobufHelper.writeSessionOS(r0, r5)     // Catch:{ all -> 0x0035 }
            if (r0 == 0) goto L_0x0031
            r0.flush()     // Catch:{ IOException -> 0x0031 }
        L_0x0031:
            r1.close()     // Catch:{ IOException -> 0x0034 }
        L_0x0034:
            return
        L_0x0035:
            r5 = move-exception
            goto L_0x0039
        L_0x0037:
            r5 = move-exception
            r1 = r0
        L_0x0039:
            if (r0 == 0) goto L_0x003e
            r0.flush()     // Catch:{ IOException -> 0x003e }
        L_0x003e:
            if (r1 == 0) goto L_0x0043
            r1.close()     // Catch:{ IOException -> 0x0043 }
        L_0x0043:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler.writeSessionOS(java.lang.String):void");
    }

    private void writeSessionPartsToSessionFile(File file, String str, int i) {
        File[] listFilesMatching = listFilesMatching(new FileNameContainsFilter(hj1.S(str, "SessionCrash")));
        boolean z = listFilesMatching != null && listFilesMatching.length > 0;
        Locale locale = Locale.US;
        String.format(locale, "Session %s has fatal exception: %s", str, Boolean.valueOf(z));
        File[] listFilesMatching2 = listFilesMatching(new FileNameContainsFilter(hj1.S(str, "SessionEvent")));
        boolean z2 = listFilesMatching2 != null && listFilesMatching2.length > 0;
        String.format(locale, "Session %s has non-fatal exceptions: %s", str, Boolean.valueOf(z2));
        if (z || z2) {
            synthesizeSessionFile(file, str, getTrimmedNonFatalFiles(str, listFilesMatching2, i), z ? listFilesMatching[0] : null);
        }
        deleteSessionPartFilesFor(str);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:(2:7|8)|9|10|31) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:12|(2:14|15)|16|17|33) */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0040 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002e */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004a A[SYNTHETIC, Splitter:B:23:0x004a] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x004f A[SYNTHETIC, Splitter:B:27:0x004f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void writeSessionUser(java.lang.String r6) throws java.lang.Exception {
        /*
            r5 = this;
            r0 = 0
            com.crashlytics.android.core.ClsFileOutputStream r1 = new com.crashlytics.android.core.ClsFileOutputStream     // Catch:{ all -> 0x0046 }
            java.io.File r2 = r5.getFilesDir()     // Catch:{ all -> 0x0046 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0046 }
            r3.<init>()     // Catch:{ all -> 0x0046 }
            r3.append(r6)     // Catch:{ all -> 0x0046 }
            java.lang.String r4 = "SessionUser"
            r3.append(r4)     // Catch:{ all -> 0x0046 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0046 }
            r1.<init>(r2, r3)     // Catch:{ all -> 0x0046 }
            com.crashlytics.android.core.CodedOutputStream r0 = com.crashlytics.android.core.CodedOutputStream.newInstance(r1)     // Catch:{ all -> 0x0044 }
            com.crashlytics.android.core.UserMetaData r6 = r5.getUserMetaData(r6)     // Catch:{ all -> 0x0044 }
            boolean r2 = r6.isEmpty()     // Catch:{ all -> 0x0044 }
            if (r2 == 0) goto L_0x0032
            if (r0 == 0) goto L_0x002e
            r0.flush()     // Catch:{ IOException -> 0x002e }
        L_0x002e:
            r1.close()     // Catch:{ IOException -> 0x0031 }
        L_0x0031:
            return
        L_0x0032:
            java.lang.String r2 = r6.id
            java.lang.String r3 = r6.name
            java.lang.String r6 = r6.email
            com.crashlytics.android.core.SessionProtobufHelper.writeSessionUser(r0, r2, r3, r6)
            if (r0 == 0) goto L_0x0040
            r0.flush()     // Catch:{ IOException -> 0x0040 }
        L_0x0040:
            r1.close()     // Catch:{ IOException -> 0x0043 }
        L_0x0043:
            return
        L_0x0044:
            r6 = move-exception
            goto L_0x0048
        L_0x0046:
            r6 = move-exception
            r1 = r0
        L_0x0048:
            if (r0 == 0) goto L_0x004d
            r0.flush()     // Catch:{ IOException -> 0x004d }
        L_0x004d:
            if (r1 == 0) goto L_0x0052
            r1.close()     // Catch:{ IOException -> 0x0052 }
        L_0x0052:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler.writeSessionUser(java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0022 A[SYNTHETIC, Splitter:B:16:0x0022] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void writeToCosFromFile(com.crashlytics.android.core.CodedOutputStream r4, java.io.File r5) throws java.io.IOException {
        /*
            boolean r0 = r5.exists()
            if (r0 != 0) goto L_0x000a
            r5.getName()
            return
        L_0x000a:
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ all -> 0x001f }
            r1.<init>(r5)     // Catch:{ all -> 0x001f }
            long r2 = r5.length()     // Catch:{ all -> 0x001c }
            int r5 = (int) r2     // Catch:{ all -> 0x001c }
            copyToCodedOutputStream(r1, r4, r5)     // Catch:{ all -> 0x001c }
            r1.close()     // Catch:{ IOException -> 0x001b }
        L_0x001b:
            return
        L_0x001c:
            r4 = move-exception
            r0 = r1
            goto L_0x0020
        L_0x001f:
            r4 = move-exception
        L_0x0020:
            if (r0 == 0) goto L_0x0025
            r0.close()     // Catch:{ IOException -> 0x0025 }
        L_0x0025:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler.writeToCosFromFile(com.crashlytics.android.core.CodedOutputStream, java.io.File):void");
    }

    public void cacheKeyData(final Map<String, String> map) {
        this.executorServiceWrapper.executeAsync(new Callable<Void>() {
            /* class com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler.AnonymousClass9 */

            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                new MetaDataStore(CrashlyticsUncaughtExceptionHandler.this.getFilesDir()).writeKeyData(CrashlyticsUncaughtExceptionHandler.this.getCurrentSessionId(), map);
                return null;
            }
        });
    }

    public void cacheUserData(final String str, final String str2, final String str3) {
        this.executorServiceWrapper.executeAsync(new Callable<Void>() {
            /* class com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler.AnonymousClass8 */

            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                new MetaDataStore(CrashlyticsUncaughtExceptionHandler.this.getFilesDir()).writeUserData(CrashlyticsUncaughtExceptionHandler.this.getCurrentSessionId(), new UserMetaData(str, str2, str3));
                return null;
            }
        });
    }

    public void cleanInvalidTempFiles() {
        this.executorServiceWrapper.executeAsync(new Runnable() {
            /* class com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler.AnonymousClass12 */

            public void run() {
                CrashlyticsUncaughtExceptionHandler crashlyticsUncaughtExceptionHandler = CrashlyticsUncaughtExceptionHandler.this;
                crashlyticsUncaughtExceptionHandler.doCleanInvalidTempFiles(crashlyticsUncaughtExceptionHandler.listFilesMatching(new InvalidPartFileFilter()));
            }
        });
    }

    public void doCleanInvalidTempFiles(File[] fileArr) {
        final HashSet hashSet = new HashSet();
        for (File file : fileArr) {
            String str = "Found invalid session part file: " + file;
            hashSet.add(getSessionIdFromSessionFile(file));
        }
        if (!hashSet.isEmpty()) {
            File invalidFilesDir = getInvalidFilesDir();
            if (!invalidFilesDir.exists()) {
                invalidFilesDir.mkdir();
            }
            File[] listFilesMatching = listFilesMatching(new FilenameFilter() {
                /* class com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler.AnonymousClass13 */

                public boolean accept(File file, String str) {
                    if (str.length() < 35) {
                        return false;
                    }
                    return hashSet.contains(str.substring(0, 35));
                }
            });
            for (File file2 : listFilesMatching) {
                String str2 = "Moving session file: " + file2;
                if (!file2.renameTo(new File(invalidFilesDir, file2.getName()))) {
                    String str3 = "Could not move session file. Deleting " + file2;
                    file2.delete();
                }
            }
            trimInvalidSessionFiles();
        }
    }

    public void doCloseSessions() throws Exception {
        doCloseSessions(false);
    }

    public boolean finalizeSessions() {
        return ((Boolean) this.executorServiceWrapper.executeSyncLoggingException(new Callable<Boolean>() {
            /* class com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler.AnonymousClass11 */

            @Override // java.util.concurrent.Callable
            public Boolean call() throws Exception {
                if (CrashlyticsUncaughtExceptionHandler.this.isHandlingException.get()) {
                    return Boolean.FALSE;
                }
                CrashlyticsUncaughtExceptionHandler.this.doCloseSessions(true);
                return Boolean.TRUE;
            }
        })).booleanValue();
    }

    public File getInvalidFilesDir() {
        return new File(getFilesDir(), INVALID_CLS_CACHE_DIR);
    }

    public boolean hasOpenSession() {
        return listSessionBeginFiles().length > 0;
    }

    public boolean isHandlingException() {
        return this.isHandlingException.get();
    }

    public File[] listSessionBeginFiles() {
        return listFilesMatching(new FileNameContainsFilter("BeginSession"));
    }

    public void openSession() {
        this.executorServiceWrapper.executeAsync(new Callable<Void>() {
            /* class com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler.AnonymousClass10 */

            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                CrashlyticsUncaughtExceptionHandler.this.doOpenSession();
                return null;
            }
        });
    }

    public void trimSessionFiles() {
        Utils.capFileCount(getFilesDir(), SESSION_FILE_FILTER, 4, SMALLEST_FILE_NAME_FIRST);
    }

    public synchronized void uncaughtException(final Thread thread, final Throwable th) {
        AtomicBoolean atomicBoolean;
        this.isHandlingException.set(true);
        try {
            String str = "Crashlytics is handling uncaught exception \"" + th + "\" from thread " + thread.getName();
            this.devicePowerStateListener.dispose();
            final Date date = new Date();
            this.executorServiceWrapper.executeSyncLoggingException(new Callable<Void>() {
                /* class com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler.AnonymousClass5 */

                @Override // java.util.concurrent.Callable
                public Void call() throws Exception {
                    CrashlyticsUncaughtExceptionHandler.this.handleUncaughtException(date, thread, th);
                    return null;
                }
            });
            this.defaultHandler.uncaughtException(thread, th);
            atomicBoolean = this.isHandlingException;
        } catch (Exception unused) {
            this.defaultHandler.uncaughtException(thread, th);
            atomicBoolean = this.isHandlingException;
        } catch (Throwable th2) {
            this.defaultHandler.uncaughtException(thread, th);
            this.isHandlingException.set(false);
            throw th2;
        }
        atomicBoolean.set(false);
    }

    public void writeExternalCrashEvent(final SessionEventData sessionEventData) {
        this.executorServiceWrapper.executeAsync(new Callable<Void>() {
            /* class com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler.AnonymousClass14 */

            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                if (CrashlyticsUncaughtExceptionHandler.this.isHandlingException.get()) {
                    return null;
                }
                CrashlyticsUncaughtExceptionHandler.this.doWriteExternalCrashEvent(sessionEventData);
                return null;
            }
        });
    }

    public void writeNonFatalException(final Thread thread, final Throwable th) {
        final Date date = new Date();
        this.executorServiceWrapper.executeAsync(new Runnable() {
            /* class com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler.AnonymousClass7 */

            public void run() {
                if (!CrashlyticsUncaughtExceptionHandler.this.isHandlingException.get()) {
                    CrashlyticsUncaughtExceptionHandler.this.doWriteNonFatal(date, thread, th);
                }
            }
        });
    }

    public void writeToLog(final long j, final String str) {
        this.executorServiceWrapper.executeAsync(new Callable<Void>() {
            /* class com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler.AnonymousClass6 */

            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                if (CrashlyticsUncaughtExceptionHandler.this.isHandlingException.get()) {
                    return null;
                }
                CrashlyticsUncaughtExceptionHandler.this.logFileManager.writeToLog(j, str);
                return null;
            }
        });
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void doCloseSessions(boolean z) throws Exception {
        trimOpenSessions((z ? 1 : 0) + 8);
        File[] listSortedSessionBeginFiles = listSortedSessionBeginFiles();
        if (listSortedSessionBeginFiles.length > z) {
            writeSessionUser(getSessionIdFromSessionFile(listSortedSessionBeginFiles[z ? 1 : 0]));
            CrashlyticsCore.getSessionSettingsData();
        }
    }

    private File[] listFilesMatching(File file, FilenameFilter filenameFilter) {
        return ensureFileArrayNotNull(file.listFiles(filenameFilter));
    }
}
