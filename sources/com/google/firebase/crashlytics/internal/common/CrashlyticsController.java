package com.google.firebase.crashlytics.internal.common;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import com.freshchat.consumer.sdk.beans.User;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.NativeSessionFileProvider;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.common.CrashlyticsUncaughtExceptionHandler;
import com.google.firebase.crashlytics.internal.log.LogFileManager;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.crashlytics.internal.proto.ClsFileOutputStream;
import com.google.firebase.crashlytics.internal.proto.CodedOutputStream;
import com.google.firebase.crashlytics.internal.proto.SessionProtobufHelper;
import com.google.firebase.crashlytics.internal.report.ReportManager;
import com.google.firebase.crashlytics.internal.report.ReportUploader;
import com.google.firebase.crashlytics.internal.report.model.Report;
import com.google.firebase.crashlytics.internal.report.model.SessionReport;
import com.google.firebase.crashlytics.internal.report.network.CompositeCreateReportSpiCall;
import com.google.firebase.crashlytics.internal.report.network.CreateReportSpiCall;
import com.google.firebase.crashlytics.internal.report.network.DefaultCreateReportSpiCall;
import com.google.firebase.crashlytics.internal.report.network.NativeCreateReportSpiCall;
import com.google.firebase.crashlytics.internal.settings.SettingsDataProvider;
import com.google.firebase.crashlytics.internal.settings.SettingsJsonConstants;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.Settings;
import com.google.firebase.crashlytics.internal.stacktrace.MiddleOutFallbackStrategy;
import com.google.firebase.crashlytics.internal.stacktrace.RemoveRepeatsStrategy;
import com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy;
import com.google.firebase.crashlytics.internal.stacktrace.TrimmedThrowableData;
import com.razorpay.AnalyticsConstants;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import server.zophop.logging.LoggingConstants;

public class CrashlyticsController {
    private static final int ANALYZER_VERSION = 1;
    public static final FilenameFilter APP_EXCEPTION_MARKER_FILTER = CrashlyticsController$$Lambda$1.lambdaFactory$();
    public static final String APP_EXCEPTION_MARKER_PREFIX = ".ae";
    private static final String COLLECT_CUSTOM_KEYS = "com.crashlytics.CollectCustomKeys";
    private static final String CRASHLYTICS_API_ENDPOINT = "com.crashlytics.ApiEndpoint";
    private static final String EVENT_TYPE_CRASH = "crash";
    private static final String EVENT_TYPE_LOGGED = "error";
    public static final String FATAL_SESSION_DIR = "fatal-sessions";
    public static final String FIREBASE_APPLICATION_EXCEPTION = "_ae";
    public static final String FIREBASE_CRASH_TYPE = "fatal";
    public static final int FIREBASE_CRASH_TYPE_FATAL = 1;
    public static final String FIREBASE_TIMESTAMP = "timestamp";
    private static final String GENERATOR_FORMAT = "Crashlytics Android SDK/%s";
    private static final String[] INITIAL_SESSION_PART_TAGS = {"SessionUser", "SessionApp", "SessionOS", "SessionDevice"};
    public static final Comparator<File> LARGEST_FILE_NAME_FIRST = new Object() {
        /* class com.google.firebase.crashlytics.internal.common.CrashlyticsController.AnonymousClass3 */

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
    private static final int MAX_CHAINED_EXCEPTION_DEPTH = 8;
    private static final int MAX_LOCAL_LOGGED_EXCEPTIONS = 64;
    public static final int MAX_OPEN_SESSIONS = 8;
    public static final int MAX_STACK_SIZE = 1024;
    public static final String NATIVE_SESSION_DIR = "native-sessions";
    public static final String NONFATAL_SESSION_DIR = "nonfatal-sessions";
    public static final int NUM_STACK_REPETITIONS_ALLOWED = 10;
    private static final Map<String, String> SEND_AT_CRASHTIME_HEADER = Collections.singletonMap("X-CRASHLYTICS-SEND-FLAGS", "1");
    public static final String SESSION_APP_TAG = "SessionApp";
    public static final FilenameFilter SESSION_BEGIN_FILE_FILTER = new FileNameContainsFilter("BeginSession") {
        /* class com.google.firebase.crashlytics.internal.common.CrashlyticsController.AnonymousClass1 */

        @Override // com.google.firebase.crashlytics.internal.common.CrashlyticsController.FileNameContainsFilter
        public boolean accept(File file, String str) {
            return super.accept(file, str) && str.endsWith(".cls");
        }
    };
    public static final String SESSION_BEGIN_TAG = "BeginSession";
    public static final String SESSION_DEVICE_TAG = "SessionDevice";
    public static final String SESSION_EVENT_MISSING_BINARY_IMGS_TAG = "SessionMissingBinaryImages";
    public static final String SESSION_FATAL_TAG = "SessionCrash";
    public static final FilenameFilter SESSION_FILE_FILTER = new FilenameFilter() {
        /* class com.google.firebase.crashlytics.internal.common.CrashlyticsController.AnonymousClass2 */

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
        /* class com.google.firebase.crashlytics.internal.common.CrashlyticsController.AnonymousClass4 */

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
    private final AnalyticsEventLogger analyticsEventLogger;
    private final AppData appData;
    private final CrashlyticsBackgroundWorker backgroundWorker;
    public AtomicBoolean checkForUnsentReportsCalled = new AtomicBoolean(false);
    private final Context context;
    private CrashlyticsUncaughtExceptionHandler crashHandler;
    private final CrashlyticsFileMarker crashMarker;
    private final DataCollectionArbiter dataCollectionArbiter;
    private final AtomicInteger eventCounter = new AtomicInteger(0);
    private final FileStore fileStore;
    private final ReportUploader.HandlingExceptionCheck handlingExceptionCheck;
    private final HttpRequestFactory httpRequestFactory;
    private final IdManager idManager;
    private final LogFileDirectoryProvider logFileDirectoryProvider;
    private final LogFileManager logFileManager;
    private final CrashlyticsNativeComponent nativeComponent;
    public zi4<Boolean> reportActionProvided = new zi4<>();
    private final ReportManager reportManager;
    private final ReportUploader.Provider reportUploaderProvider;
    private final SessionReportingCoordinator reportingCoordinator;
    private final StackTraceTrimmingStrategy stackTraceTrimmingStrategy;
    private final String unityVersion;
    public zi4<Boolean> unsentReportsAvailable = new zi4<>();
    public zi4<Void> unsentReportsHandled = new zi4<>();
    private final UserMetadata userMetadata;

    public static class AnySessionPartFileFilter implements FilenameFilter {
        private AnySessionPartFileFilter() {
        }

        public boolean accept(File file, String str) {
            return !CrashlyticsController.SESSION_FILE_FILTER.accept(file, str) && CrashlyticsController.SESSION_FILE_PATTERN.matcher(str).matches();
        }
    }

    public interface CodedOutputStreamWriteAction {
        void writeTo(CodedOutputStream codedOutputStream) throws Exception;
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

    public static final class LogFileDirectoryProvider implements LogFileManager.DirectoryProvider {
        private static final String LOG_FILES_DIR = "log-files";
        private final FileStore rootFileStore;

        public LogFileDirectoryProvider(FileStore fileStore) {
            this.rootFileStore = fileStore;
        }

        @Override // com.google.firebase.crashlytics.internal.log.LogFileManager.DirectoryProvider
        public File getLogFileDir() {
            File file = new File(this.rootFileStore.getFilesDir(), LOG_FILES_DIR);
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
    }

    public final class ReportUploaderFilesProvider implements ReportUploader.ReportFilesProvider {
        private ReportUploaderFilesProvider() {
        }

        @Override // com.google.firebase.crashlytics.internal.report.ReportUploader.ReportFilesProvider
        public File[] getCompleteSessionFiles() {
            return CrashlyticsController.this.listCompleteSessionFiles();
        }

        @Override // com.google.firebase.crashlytics.internal.report.ReportUploader.ReportFilesProvider
        public File[] getNativeReportFiles() {
            return CrashlyticsController.this.listNativeSessionFileDirectories();
        }
    }

    public final class ReportUploaderHandlingExceptionCheck implements ReportUploader.HandlingExceptionCheck {
        private ReportUploaderHandlingExceptionCheck() {
        }

        @Override // com.google.firebase.crashlytics.internal.report.ReportUploader.HandlingExceptionCheck
        public boolean isHandlingException() {
            return CrashlyticsController.this.isHandlingException();
        }
    }

    public static final class SendReportRunnable implements Runnable {
        private final Context context;
        private final boolean dataCollectionToken;
        private final Report report;
        private final ReportUploader reportUploader;

        public SendReportRunnable(Context context2, Report report2, ReportUploader reportUploader2, boolean z) {
            this.context = context2;
            this.report = report2;
            this.reportUploader = reportUploader2;
            this.dataCollectionToken = z;
        }

        public void run() {
            if (CommonUtils.canTryConnection(this.context)) {
                Logger.getLogger().d("Attempting to send crash report at time of crash...");
                this.reportUploader.uploadReport(this.report, this.dataCollectionToken);
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

    public CrashlyticsController(Context context2, CrashlyticsBackgroundWorker crashlyticsBackgroundWorker, HttpRequestFactory httpRequestFactory2, IdManager idManager2, DataCollectionArbiter dataCollectionArbiter2, FileStore fileStore2, CrashlyticsFileMarker crashlyticsFileMarker, AppData appData2, ReportManager reportManager2, ReportUploader.Provider provider, CrashlyticsNativeComponent crashlyticsNativeComponent, AnalyticsEventLogger analyticsEventLogger2, SettingsDataProvider settingsDataProvider) {
        this.context = context2;
        this.backgroundWorker = crashlyticsBackgroundWorker;
        this.httpRequestFactory = httpRequestFactory2;
        this.idManager = idManager2;
        this.dataCollectionArbiter = dataCollectionArbiter2;
        this.fileStore = fileStore2;
        this.crashMarker = crashlyticsFileMarker;
        this.appData = appData2;
        if (provider != null) {
            this.reportUploaderProvider = provider;
        } else {
            this.reportUploaderProvider = defaultReportUploader();
        }
        this.nativeComponent = crashlyticsNativeComponent;
        this.unityVersion = appData2.unityVersionProvider.getUnityVersion();
        this.analyticsEventLogger = analyticsEventLogger2;
        UserMetadata userMetadata2 = new UserMetadata();
        this.userMetadata = userMetadata2;
        LogFileDirectoryProvider logFileDirectoryProvider2 = new LogFileDirectoryProvider(fileStore2);
        this.logFileDirectoryProvider = logFileDirectoryProvider2;
        LogFileManager logFileManager2 = new LogFileManager(context2, logFileDirectoryProvider2);
        this.logFileManager = logFileManager2;
        this.reportManager = reportManager2 == null ? new ReportManager(new ReportUploaderFilesProvider()) : reportManager2;
        this.handlingExceptionCheck = new ReportUploaderHandlingExceptionCheck();
        MiddleOutFallbackStrategy middleOutFallbackStrategy = new MiddleOutFallbackStrategy(1024, new RemoveRepeatsStrategy(10));
        this.stackTraceTrimmingStrategy = middleOutFallbackStrategy;
        this.reportingCoordinator = SessionReportingCoordinator.create(context2, idManager2, fileStore2, appData2, logFileManager2, userMetadata2, middleOutFallbackStrategy, settingsDataProvider);
    }

    /* access modifiers changed from: private */
    public static void appendOrganizationIdToSessionFile(final String str, File file) throws Exception {
        if (str != null) {
            appendToProtoFile(file, new CodedOutputStreamWriteAction() {
                /* class com.google.firebase.crashlytics.internal.common.CrashlyticsController.AnonymousClass22 */

                @Override // com.google.firebase.crashlytics.internal.common.CrashlyticsController.CodedOutputStreamWriteAction
                public void writeTo(CodedOutputStream codedOutputStream) throws Exception {
                    SessionProtobufHelper.writeSessionAppClsId(codedOutputStream, str);
                }
            });
        }
    }

    private static void appendToProtoFile(File file, CodedOutputStreamWriteAction codedOutputStreamWriteAction) throws Exception {
        Throwable th;
        FileOutputStream fileOutputStream;
        CodedOutputStream codedOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file, true);
            try {
                codedOutputStream = CodedOutputStream.newInstance(fileOutputStream);
                codedOutputStreamWriteAction.writeTo(codedOutputStream);
                StringBuilder i0 = hj1.i0("Failed to flush to append to ");
                i0.append(file.getPath());
                CommonUtils.flushOrLog(codedOutputStream, i0.toString());
                CommonUtils.closeOrLog(fileOutputStream, "Failed to close " + file.getPath());
            } catch (Throwable th2) {
                th = th2;
                StringBuilder i02 = hj1.i0("Failed to flush to append to ");
                i02.append(file.getPath());
                CommonUtils.flushOrLog(codedOutputStream, i02.toString());
                CommonUtils.closeOrLog(fileOutputStream, "Failed to close " + file.getPath());
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            StringBuilder i022 = hj1.i0("Failed to flush to append to ");
            i022.append(file.getPath());
            CommonUtils.flushOrLog(codedOutputStream, i022.toString());
            CommonUtils.closeOrLog(fileOutputStream, "Failed to close " + file.getPath());
            throw th;
        }
    }

    private void cacheKeyData(final Map<String, String> map) {
        this.backgroundWorker.submit(new Callable<Void>() {
            /* class com.google.firebase.crashlytics.internal.common.CrashlyticsController.AnonymousClass13 */

            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                new MetaDataStore(CrashlyticsController.this.getFilesDir()).writeKeyData(CrashlyticsController.this.getCurrentSessionId(), map);
                return null;
            }
        });
    }

    private void cacheUserData(final UserMetadata userMetadata2) {
        this.backgroundWorker.submit(new Callable<Void>() {
            /* class com.google.firebase.crashlytics.internal.common.CrashlyticsController.AnonymousClass12 */

            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                String currentSessionId = CrashlyticsController.this.getCurrentSessionId();
                if (currentSessionId == null) {
                    Logger.getLogger().d("Tried to cache user data while no session was open.");
                    return null;
                }
                CrashlyticsController.this.reportingCoordinator.persistUserId(CrashlyticsController.makeFirebaseSessionIdentifier(currentSessionId));
                new MetaDataStore(CrashlyticsController.this.getFilesDir()).writeUserData(currentSessionId, userMetadata2);
                return null;
            }
        });
    }

    private void closeOpenSessions(File[] fileArr, int i, int i2) {
        Logger.getLogger().d("Closing open sessions.");
        while (i < fileArr.length) {
            File file = fileArr[i];
            String sessionIdFromSessionFile = getSessionIdFromSessionFile(file);
            Logger logger = Logger.getLogger();
            logger.d("Closing session: " + sessionIdFromSessionFile);
            writeSessionPartsToSessionFile(file, sessionIdFromSessionFile, i2);
            i++;
        }
    }

    private void closeWithoutRenamingOrLog(ClsFileOutputStream clsFileOutputStream) {
        if (clsFileOutputStream != null) {
            try {
                clsFileOutputStream.closeInProgressStream();
            } catch (IOException e) {
                Logger.getLogger().e("Error closing session file stream in the presence of an exception", e);
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

    private ReportUploader.Provider defaultReportUploader() {
        return new ReportUploader.Provider() {
            /* class com.google.firebase.crashlytics.internal.common.CrashlyticsController.AnonymousClass9 */

            @Override // com.google.firebase.crashlytics.internal.report.ReportUploader.Provider
            public ReportUploader createReportUploader(AppSettingsData appSettingsData) {
                String str = appSettingsData.reportsUrl;
                String str2 = appSettingsData.ndkReportsUrl;
                return new ReportUploader(appSettingsData.organizationId, CrashlyticsController.this.appData.googleAppId, DataTransportState.getState(appSettingsData), CrashlyticsController.this.reportManager, CrashlyticsController.this.getCreateReportSpiCall(str, str2), CrashlyticsController.this.handlingExceptionCheck);
            }
        };
    }

    /* access modifiers changed from: private */
    public static void deleteFiles(File[] fileArr) {
        if (fileArr != null) {
            for (File file : fileArr) {
                file.delete();
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void doOpenSession() throws Exception {
        long currentTimestampSeconds = getCurrentTimestampSeconds();
        String clsuuid = new CLSUUID(this.idManager).toString();
        Logger logger = Logger.getLogger();
        logger.d("Opening a new session with ID " + clsuuid);
        this.nativeComponent.openSession(clsuuid);
        writeBeginSession(clsuuid, currentTimestampSeconds);
        writeSessionApp(clsuuid);
        writeSessionOS(clsuuid);
        writeSessionDevice(clsuuid);
        this.logFileManager.setCurrentSession(clsuuid);
        this.reportingCoordinator.onBeginSession(makeFirebaseSessionIdentifier(clsuuid), currentTimestampSeconds);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void doWriteAppExceptionMarker(long j) {
        try {
            File filesDir = getFilesDir();
            new File(filesDir, APP_EXCEPTION_MARKER_PREFIX + j).createNewFile();
        } catch (IOException unused) {
            Logger.getLogger().d("Could not write app exception marker.");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void doWriteFatal(Thread thread, Throwable th, String str, long j) {
        ClsFileOutputStream clsFileOutputStream;
        Throwable th2;
        Exception e;
        CodedOutputStream codedOutputStream = null;
        try {
            clsFileOutputStream = new ClsFileOutputStream(getFilesDir(), str + "SessionCrash");
            try {
                codedOutputStream = CodedOutputStream.newInstance(clsFileOutputStream);
                writeSessionEvent(codedOutputStream, thread, th, j, EVENT_TYPE_CRASH, true);
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            clsFileOutputStream = null;
            try {
                Logger.getLogger().e("An error occurred in the fatal exception logger", e);
                CommonUtils.flushOrLog(codedOutputStream, "Failed to flush to session begin file.");
                CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close fatal exception file output stream.");
            } catch (Throwable th3) {
                th2 = th3;
                CommonUtils.flushOrLog(codedOutputStream, "Failed to flush to session begin file.");
                CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close fatal exception file output stream.");
                throw th2;
            }
        } catch (Throwable th4) {
            th2 = th4;
            clsFileOutputStream = null;
            CommonUtils.flushOrLog(codedOutputStream, "Failed to flush to session begin file.");
            CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close fatal exception file output stream.");
            throw th2;
        }
        CommonUtils.flushOrLog(codedOutputStream, "Failed to flush to session begin file.");
        CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close fatal exception file output stream.");
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void doWriteNonFatal(Thread thread, Throwable th, String str, long j) {
        ClsFileOutputStream clsFileOutputStream;
        Throwable th2;
        Exception e;
        CodedOutputStream newInstance;
        CodedOutputStream codedOutputStream = null;
        try {
            Logger.getLogger().d("Crashlytics is logging non-fatal exception \"" + th + "\" from thread " + thread.getName());
            clsFileOutputStream = new ClsFileOutputStream(getFilesDir(), str + "SessionEvent" + CommonUtils.padWithZerosToMaxIntWidth(this.eventCounter.getAndIncrement()));
            try {
                newInstance = CodedOutputStream.newInstance(clsFileOutputStream);
            } catch (Exception e2) {
                e = e2;
                try {
                    Logger.getLogger().e("An error occurred in the non-fatal exception logger", e);
                    CommonUtils.flushOrLog(codedOutputStream, "Failed to flush to non-fatal file.");
                    CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close non-fatal file output stream.");
                    trimSessionEventFiles(str, 64);
                } catch (Throwable th3) {
                    th2 = th3;
                    CommonUtils.flushOrLog(codedOutputStream, "Failed to flush to non-fatal file.");
                    CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close non-fatal file output stream.");
                    throw th2;
                }
            }
            try {
                writeSessionEvent(newInstance, thread, th, j, "error", false);
                CommonUtils.flushOrLog(newInstance, "Failed to flush to non-fatal file.");
            } catch (Exception e3) {
                e = e3;
                codedOutputStream = newInstance;
                Logger.getLogger().e("An error occurred in the non-fatal exception logger", e);
                CommonUtils.flushOrLog(codedOutputStream, "Failed to flush to non-fatal file.");
                CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close non-fatal file output stream.");
                trimSessionEventFiles(str, 64);
            } catch (Throwable th4) {
                th2 = th4;
                codedOutputStream = newInstance;
                CommonUtils.flushOrLog(codedOutputStream, "Failed to flush to non-fatal file.");
                CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close non-fatal file output stream.");
                throw th2;
            }
        } catch (Exception e4) {
            e = e4;
            clsFileOutputStream = null;
            Logger.getLogger().e("An error occurred in the non-fatal exception logger", e);
            CommonUtils.flushOrLog(codedOutputStream, "Failed to flush to non-fatal file.");
            CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close non-fatal file output stream.");
            trimSessionEventFiles(str, 64);
        } catch (Throwable th5) {
            th2 = th5;
            clsFileOutputStream = null;
            CommonUtils.flushOrLog(codedOutputStream, "Failed to flush to non-fatal file.");
            CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close non-fatal file output stream.");
            throw th2;
        }
        CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close non-fatal file output stream.");
        try {
            trimSessionEventFiles(str, 64);
        } catch (Exception e5) {
            Logger.getLogger().e("An error occurred when trimming non-fatal files.", e5);
        }
    }

    private static File[] ensureFileArrayNotNull(File[] fileArr) {
        return fileArr == null ? new File[0] : fileArr;
    }

    private void finalizePreviousNativeSession(String str) {
        Logger logger = Logger.getLogger();
        logger.d("Finalizing native report for session " + str);
        NativeSessionFileProvider sessionFileProvider = this.nativeComponent.getSessionFileProvider(str);
        File minidumpFile = sessionFileProvider.getMinidumpFile();
        if (minidumpFile == null || !minidumpFile.exists()) {
            Logger logger2 = Logger.getLogger();
            logger2.w("No minidump data found for session " + str);
            return;
        }
        long lastModified = minidumpFile.lastModified();
        LogFileManager logFileManager2 = new LogFileManager(this.context, this.logFileDirectoryProvider, str);
        File file = new File(getNativeSessionFilesDir(), str);
        if (!file.mkdirs()) {
            Logger.getLogger().d("Couldn't create native sessions directory");
            return;
        }
        doWriteAppExceptionMarker(lastModified);
        List<NativeSessionFile> nativeSessionFiles = getNativeSessionFiles(sessionFileProvider, str, getContext(), getFilesDir(), logFileManager2.getBytesForLog());
        NativeSessionFileGzipper.processNativeSessions(file, nativeSessionFiles);
        this.reportingCoordinator.finalizeSessionWithNativeEvent(makeFirebaseSessionIdentifier(str), nativeSessionFiles);
        logFileManager2.clearLog();
    }

    private static boolean firebaseCrashExists() {
        try {
            Class.forName("com.google.firebase.crash.FirebaseCrash");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private Context getContext() {
        return this.context;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private CreateReportSpiCall getCreateReportSpiCall(String str, String str2) {
        String stringsFileValue = CommonUtils.getStringsFileValue(getContext(), "com.crashlytics.ApiEndpoint");
        return new CompositeCreateReportSpiCall(new DefaultCreateReportSpiCall(stringsFileValue, str, this.httpRequestFactory, CrashlyticsCore.getVersion()), new NativeCreateReportSpiCall(stringsFileValue, str2, this.httpRequestFactory, CrashlyticsCore.getVersion()));
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

    private static long getCurrentTimestampSeconds() {
        return getTimestampSeconds(new Date());
    }

    public static List<NativeSessionFile> getNativeSessionFiles(NativeSessionFileProvider nativeSessionFileProvider, String str, Context context2, File file, byte[] bArr) {
        MetaDataStore metaDataStore = new MetaDataStore(file);
        File userDataFileForSession = metaDataStore.getUserDataFileForSession(str);
        File keysFileForSession = metaDataStore.getKeysFileForSession(str);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BytesBackedNativeSessionFile("logs_file", "logs", bArr));
        arrayList.add(new FileBackedNativeSessionFile("crash_meta_file", "metadata", nativeSessionFileProvider.getMetadataFile()));
        arrayList.add(new FileBackedNativeSessionFile("session_meta_file", SettingsJsonConstants.SESSION_KEY, nativeSessionFileProvider.getSessionFile()));
        arrayList.add(new FileBackedNativeSessionFile("app_meta_file", SettingsJsonConstants.APP_KEY, nativeSessionFileProvider.getAppFile()));
        arrayList.add(new FileBackedNativeSessionFile("device_meta_file", AnalyticsConstants.DEVICE, nativeSessionFileProvider.getDeviceFile()));
        arrayList.add(new FileBackedNativeSessionFile("os_meta_file", User.DEVICE_META_OS_NAME, nativeSessionFileProvider.getOsFile()));
        arrayList.add(new FileBackedNativeSessionFile("minidump_file", "minidump", nativeSessionFileProvider.getMinidumpFile()));
        arrayList.add(new FileBackedNativeSessionFile("user_meta_file", LoggingConstants.USER, userDataFileForSession));
        arrayList.add(new FileBackedNativeSessionFile("keys_file", "keys", keysFileForSession));
        return arrayList;
    }

    public static String getSessionIdFromSessionFile(File file) {
        return file.getName().substring(0, 35);
    }

    /* access modifiers changed from: private */
    public static long getTimestampSeconds(Date date) {
        return date.getTime() / 1000;
    }

    private File[] getTrimmedNonFatalFiles(String str, File[] fileArr, int i) {
        if (fileArr.length <= i) {
            return fileArr;
        }
        Logger.getLogger().d(String.format(Locale.US, "Trimming down to %d logged exceptions.", Integer.valueOf(i)));
        trimSessionEventFiles(str, i);
        return listFilesMatching(new FileNameContainsFilter(hj1.S(str, "SessionEvent")));
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

    private yi4<Void> logAnalyticsAppExceptionEvent(final long j) {
        if (!firebaseCrashExists()) {
            return hd3.A(new ScheduledThreadPoolExecutor(1), new Callable<Void>() {
                /* class com.google.firebase.crashlytics.internal.common.CrashlyticsController.AnonymousClass23 */

                @Override // java.util.concurrent.Callable
                public Void call() throws Exception {
                    Bundle bundle = new Bundle();
                    bundle.putInt(CrashlyticsController.FIREBASE_CRASH_TYPE, 1);
                    bundle.putLong("timestamp", j);
                    CrashlyticsController.this.analyticsEventLogger.logEvent("_ae", bundle);
                    return null;
                }
            });
        }
        Logger.getLogger().d("Skipping logging Crashlytics event to Firebase, FirebaseCrash exists");
        return hd3.W0(null);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private yi4<Void> logAnalyticsAppExceptionEvents() {
        ArrayList arrayList = new ArrayList();
        File[] listAppExceptionMarkerFiles = listAppExceptionMarkerFiles();
        for (File file : listAppExceptionMarkerFiles) {
            try {
                arrayList.add(logAnalyticsAppExceptionEvent(Long.parseLong(file.getName().substring(3))));
            } catch (NumberFormatException unused) {
                Logger logger = Logger.getLogger();
                StringBuilder i0 = hj1.i0("Could not parse timestamp from file ");
                i0.append(file.getName());
                logger.d(i0.toString());
            }
            file.delete();
        }
        return hd3.h3(arrayList);
    }

    /* access modifiers changed from: private */
    public static String makeFirebaseSessionIdentifier(String str) {
        return str.replaceAll("-", "");
    }

    private void retainSessions(File[] fileArr, Set<String> set) {
        for (File file : fileArr) {
            String name = file.getName();
            Matcher matcher = SESSION_FILE_PATTERN.matcher(name);
            if (!matcher.matches()) {
                Logger.getLogger().d("Deleting unknown file: " + name);
                file.delete();
            } else if (!set.contains(matcher.group(1))) {
                Logger.getLogger().d("Trimming session file: " + name);
                file.delete();
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void sendSessionReports(AppSettingsData appSettingsData, boolean z) throws Exception {
        Context context2 = getContext();
        ReportUploader createReportUploader = this.reportUploaderProvider.createReportUploader(appSettingsData);
        File[] listCompleteSessionFiles = listCompleteSessionFiles();
        for (File file : listCompleteSessionFiles) {
            appendOrganizationIdToSessionFile(appSettingsData.organizationId, file);
            this.backgroundWorker.submit(new SendReportRunnable(context2, new SessionReport(file, SEND_AT_CRASHTIME_HEADER), createReportUploader, z));
        }
    }

    private void synthesizeSessionFile(File file, String str, File[] fileArr, File file2) {
        Throwable th;
        ClsFileOutputStream clsFileOutputStream;
        Exception e;
        boolean z = file2 != null;
        File fatalSessionFilesDir = z ? getFatalSessionFilesDir() : getNonFatalSessionFilesDir();
        if (!fatalSessionFilesDir.exists()) {
            fatalSessionFilesDir.mkdirs();
        }
        try {
            clsFileOutputStream = new ClsFileOutputStream(fatalSessionFilesDir, str);
            try {
                CodedOutputStream newInstance = CodedOutputStream.newInstance(clsFileOutputStream);
                Logger.getLogger().d("Collecting SessionStart data for session ID " + str);
                writeToCosFromFile(newInstance, file);
                newInstance.writeUInt64(4, getCurrentTimestampSeconds());
                newInstance.writeBool(5, z);
                newInstance.writeUInt32(11, 1);
                newInstance.writeEnum(12, 3);
                writeInitialPartsTo(newInstance, str);
                writeNonFatalEventsTo(newInstance, fileArr, str);
                if (z) {
                    writeToCosFromFile(newInstance, file2);
                }
                CommonUtils.flushOrLog(newInstance, "Error flushing session file stream");
                CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close CLS file");
            } catch (Exception e2) {
                e = e2;
                try {
                    Logger.getLogger().e("Failed to write session file for session ID: " + str, e);
                    CommonUtils.flushOrLog(null, "Error flushing session file stream");
                    closeWithoutRenamingOrLog(clsFileOutputStream);
                } catch (Throwable th2) {
                    th = th2;
                    CommonUtils.flushOrLog(null, "Error flushing session file stream");
                    CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close CLS file");
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            clsFileOutputStream = null;
            Logger.getLogger().e("Failed to write session file for session ID: " + str, e);
            CommonUtils.flushOrLog(null, "Error flushing session file stream");
            closeWithoutRenamingOrLog(clsFileOutputStream);
        } catch (Throwable th3) {
            th = th3;
            clsFileOutputStream = null;
            CommonUtils.flushOrLog(null, "Error flushing session file stream");
            CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close CLS file");
            throw th;
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

    private yi4<Boolean> waitForReportAction() {
        Boolean bool = Boolean.TRUE;
        if (this.dataCollectionArbiter.isAutomaticDataCollectionEnabled()) {
            Logger.getLogger().d("Automatic data collection is enabled. Allowing upload.");
            this.unsentReportsAvailable.b(Boolean.FALSE);
            return hd3.W0(bool);
        }
        Logger.getLogger().d("Automatic data collection is disabled.");
        Logger.getLogger().d("Notifying that unsent reports are available.");
        this.unsentReportsAvailable.b(bool);
        yi4<TContinuationResult> r = this.dataCollectionArbiter.waitForAutomaticDataCollectionEnabled().r(new xi4<Void, Boolean>() {
            /* class com.google.firebase.crashlytics.internal.common.CrashlyticsController.AnonymousClass7 */

            public yi4<Boolean> then(Void r1) throws Exception {
                return hd3.W0(Boolean.TRUE);
            }
        });
        Logger.getLogger().d("Waiting for send/deleteUnsentReports to be called.");
        return Utils.race(r, this.reportActionProvided.f4178a);
    }

    private void writeBeginSession(final String str, final long j) throws Exception {
        final String format = String.format(Locale.US, GENERATOR_FORMAT, CrashlyticsCore.getVersion());
        writeSessionPartFile(str, "BeginSession", new CodedOutputStreamWriteAction() {
            /* class com.google.firebase.crashlytics.internal.common.CrashlyticsController.AnonymousClass17 */

            @Override // com.google.firebase.crashlytics.internal.common.CrashlyticsController.CodedOutputStreamWriteAction
            public void writeTo(CodedOutputStream codedOutputStream) throws Exception {
                SessionProtobufHelper.writeBeginSession(codedOutputStream, str, format, j);
            }
        });
        this.nativeComponent.writeBeginSession(str, format, j);
    }

    private void writeInitialPartsTo(CodedOutputStream codedOutputStream, String str) throws IOException {
        String[] strArr = INITIAL_SESSION_PART_TAGS;
        for (String str2 : strArr) {
            File[] listFilesMatching = listFilesMatching(new FileNameContainsFilter(hj1.T(str, str2, ".cls")));
            if (listFilesMatching.length == 0) {
                Logger.getLogger().d("Can't find " + str2 + " data for session ID " + str);
            } else {
                Logger.getLogger().d("Collecting " + str2 + " data for session ID " + str);
                writeToCosFromFile(codedOutputStream, listFilesMatching[0]);
            }
        }
    }

    private static void writeNonFatalEventsTo(CodedOutputStream codedOutputStream, File[] fileArr, String str) {
        Arrays.sort(fileArr, CommonUtils.FILE_MODIFIED_COMPARATOR);
        for (File file : fileArr) {
            try {
                Logger.getLogger().d(String.format(Locale.US, "Found Non Fatal for session ID %s in %s ", str, file.getName()));
                writeToCosFromFile(codedOutputStream, file);
            } catch (Exception e) {
                Logger.getLogger().e("Error writting non-fatal to session.", e);
            }
        }
    }

    private void writeSessionApp(String str) throws Exception {
        final String appIdentifier = this.idManager.getAppIdentifier();
        AppData appData2 = this.appData;
        final String str2 = appData2.versionCode;
        final String str3 = appData2.versionName;
        final String crashlyticsInstallId = this.idManager.getCrashlyticsInstallId();
        final int id = DeliveryMechanism.determineFrom(this.appData.installerPackageName).getId();
        writeSessionPartFile(str, "SessionApp", new CodedOutputStreamWriteAction() {
            /* class com.google.firebase.crashlytics.internal.common.CrashlyticsController.AnonymousClass18 */

            @Override // com.google.firebase.crashlytics.internal.common.CrashlyticsController.CodedOutputStreamWriteAction
            public void writeTo(CodedOutputStream codedOutputStream) throws Exception {
                SessionProtobufHelper.writeSessionApp(codedOutputStream, appIdentifier, str2, str3, crashlyticsInstallId, id, CrashlyticsController.this.unityVersion);
            }
        });
        this.nativeComponent.writeSessionApp(str, appIdentifier, str2, str3, crashlyticsInstallId, id, this.unityVersion);
    }

    private void writeSessionDevice(String str) throws Exception {
        Context context2 = getContext();
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        final int cpuArchitectureInt = CommonUtils.getCpuArchitectureInt();
        final String str2 = Build.MODEL;
        final int availableProcessors = Runtime.getRuntime().availableProcessors();
        final long totalRamInBytes = CommonUtils.getTotalRamInBytes();
        final long blockCount = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        final boolean isEmulator = CommonUtils.isEmulator(context2);
        final int deviceState = CommonUtils.getDeviceState(context2);
        final String str3 = Build.MANUFACTURER;
        final String str4 = Build.PRODUCT;
        writeSessionPartFile(str, "SessionDevice", new CodedOutputStreamWriteAction() {
            /* class com.google.firebase.crashlytics.internal.common.CrashlyticsController.AnonymousClass20 */

            @Override // com.google.firebase.crashlytics.internal.common.CrashlyticsController.CodedOutputStreamWriteAction
            public void writeTo(CodedOutputStream codedOutputStream) throws Exception {
                SessionProtobufHelper.writeSessionDevice(codedOutputStream, cpuArchitectureInt, str2, availableProcessors, totalRamInBytes, blockCount, isEmulator, deviceState, str3, str4);
            }
        });
        this.nativeComponent.writeSessionDevice(str, cpuArchitectureInt, str2, availableProcessors, totalRamInBytes, blockCount, isEmulator, deviceState, str3, str4);
    }

    private void writeSessionEvent(CodedOutputStream codedOutputStream, Thread thread, Throwable th, long j, String str, boolean z) throws Exception {
        Thread[] threadArr;
        TreeMap treeMap;
        Map<String, String> map;
        TrimmedThrowableData trimmedThrowableData = new TrimmedThrowableData(th, this.stackTraceTrimmingStrategy);
        Context context2 = getContext();
        BatteryState batteryState = BatteryState.get(context2);
        Float batteryLevel = batteryState.getBatteryLevel();
        int batteryVelocity = batteryState.getBatteryVelocity();
        boolean proximitySensorEnabled = CommonUtils.getProximitySensorEnabled(context2);
        int i = context2.getResources().getConfiguration().orientation;
        long totalRamInBytes = CommonUtils.getTotalRamInBytes() - CommonUtils.calculateFreeRamInBytes(context2);
        long calculateUsedDiskSpaceInBytes = CommonUtils.calculateUsedDiskSpaceInBytes(Environment.getDataDirectory().getPath());
        ActivityManager.RunningAppProcessInfo appProcessInfo = CommonUtils.getAppProcessInfo(context2.getPackageName(), context2);
        LinkedList linkedList = new LinkedList();
        StackTraceElement[] stackTraceElementArr = trimmedThrowableData.stacktrace;
        String str2 = this.appData.buildId;
        String appIdentifier = this.idManager.getAppIdentifier();
        int i2 = 0;
        if (z) {
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            Thread[] threadArr2 = new Thread[allStackTraces.size()];
            for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
                threadArr2[i2] = entry.getKey();
                linkedList.add(this.stackTraceTrimmingStrategy.getTrimmedStackTrace(entry.getValue()));
                i2++;
            }
            threadArr = threadArr2;
        } else {
            threadArr = new Thread[0];
        }
        if (!CommonUtils.getBooleanResourceValue(context2, "com.crashlytics.CollectCustomKeys", true)) {
            map = new TreeMap<>();
        } else {
            map = this.userMetadata.getCustomKeys();
            if (map != null && map.size() > 1) {
                treeMap = new TreeMap(map);
                SessionProtobufHelper.writeSessionEvent(codedOutputStream, j, str, trimmedThrowableData, thread, stackTraceElementArr, threadArr, linkedList, 8, treeMap, this.logFileManager.getBytesForLog(), appProcessInfo, i, appIdentifier, str2, batteryLevel, batteryVelocity, proximitySensorEnabled, totalRamInBytes, calculateUsedDiskSpaceInBytes);
                this.logFileManager.clearLog();
            }
        }
        treeMap = map;
        SessionProtobufHelper.writeSessionEvent(codedOutputStream, j, str, trimmedThrowableData, thread, stackTraceElementArr, threadArr, linkedList, 8, treeMap, this.logFileManager.getBytesForLog(), appProcessInfo, i, appIdentifier, str2, batteryLevel, batteryVelocity, proximitySensorEnabled, totalRamInBytes, calculateUsedDiskSpaceInBytes);
        this.logFileManager.clearLog();
    }

    private void writeSessionOS(String str) throws Exception {
        final String str2 = Build.VERSION.RELEASE;
        final String str3 = Build.VERSION.CODENAME;
        final boolean isRooted = CommonUtils.isRooted(getContext());
        writeSessionPartFile(str, "SessionOS", new CodedOutputStreamWriteAction() {
            /* class com.google.firebase.crashlytics.internal.common.CrashlyticsController.AnonymousClass19 */

            @Override // com.google.firebase.crashlytics.internal.common.CrashlyticsController.CodedOutputStreamWriteAction
            public void writeTo(CodedOutputStream codedOutputStream) throws Exception {
                SessionProtobufHelper.writeSessionOS(codedOutputStream, str2, str3, isRooted);
            }
        });
        this.nativeComponent.writeSessionOs(str, str2, str3, isRooted);
    }

    private void writeSessionPartFile(String str, String str2, CodedOutputStreamWriteAction codedOutputStreamWriteAction) throws Exception {
        Throwable th;
        ClsFileOutputStream clsFileOutputStream;
        CodedOutputStream codedOutputStream = null;
        try {
            clsFileOutputStream = new ClsFileOutputStream(getFilesDir(), str + str2);
            try {
                codedOutputStream = CodedOutputStream.newInstance(clsFileOutputStream);
                codedOutputStreamWriteAction.writeTo(codedOutputStream);
                CommonUtils.flushOrLog(codedOutputStream, "Failed to flush to session " + str2 + " file.");
                CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close session " + str2 + " file.");
            } catch (Throwable th2) {
                th = th2;
                CommonUtils.flushOrLog(codedOutputStream, "Failed to flush to session " + str2 + " file.");
                CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close session " + str2 + " file.");
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            clsFileOutputStream = null;
            CommonUtils.flushOrLog(codedOutputStream, "Failed to flush to session " + str2 + " file.");
            CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close session " + str2 + " file.");
            throw th;
        }
    }

    private void writeSessionPartsToSessionFile(File file, String str, int i) {
        Logger logger = Logger.getLogger();
        logger.d("Collecting session parts for ID " + str);
        File[] listFilesMatching = listFilesMatching(new FileNameContainsFilter(hj1.S(str, "SessionCrash")));
        boolean z = listFilesMatching != null && listFilesMatching.length > 0;
        Logger logger2 = Logger.getLogger();
        Locale locale = Locale.US;
        logger2.d(String.format(locale, "Session %s has fatal exception: %s", str, Boolean.valueOf(z)));
        File[] listFilesMatching2 = listFilesMatching(new FileNameContainsFilter(hj1.S(str, "SessionEvent")));
        boolean z2 = listFilesMatching2 != null && listFilesMatching2.length > 0;
        Logger.getLogger().d(String.format(locale, "Session %s has non-fatal exceptions: %s", str, Boolean.valueOf(z2)));
        if (z || z2) {
            synthesizeSessionFile(file, str, getTrimmedNonFatalFiles(str, listFilesMatching2, i), z ? listFilesMatching[0] : null);
        } else {
            Logger logger3 = Logger.getLogger();
            logger3.d("No events present for session ID " + str);
        }
        Logger logger4 = Logger.getLogger();
        logger4.d("Removing session part files for ID " + str);
        deleteFiles(listSessionPartFilesFor(str));
    }

    private void writeSessionUser(String str) throws Exception {
        final UserMetadata userMetadata2 = getUserMetadata(str);
        writeSessionPartFile(str, "SessionUser", new CodedOutputStreamWriteAction() {
            /* class com.google.firebase.crashlytics.internal.common.CrashlyticsController.AnonymousClass21 */

            @Override // com.google.firebase.crashlytics.internal.common.CrashlyticsController.CodedOutputStreamWriteAction
            public void writeTo(CodedOutputStream codedOutputStream) throws Exception {
                SessionProtobufHelper.writeSessionUser(codedOutputStream, userMetadata2.getUserId(), null, null);
            }
        });
    }

    private static void writeToCosFromFile(CodedOutputStream codedOutputStream, File file) throws IOException {
        Throwable th;
        if (!file.exists()) {
            Logger logger = Logger.getLogger();
            StringBuilder i0 = hj1.i0("Tried to include a file that doesn't exist: ");
            i0.append(file.getName());
            logger.e(i0.toString());
            return;
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                copyToCodedOutputStream(fileInputStream2, codedOutputStream, (int) file.length());
                CommonUtils.closeOrLog(fileInputStream2, "Failed to close file input stream.");
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
                CommonUtils.closeOrLog(fileInputStream, "Failed to close file input stream.");
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            CommonUtils.closeOrLog(fileInputStream, "Failed to close file input stream.");
            throw th;
        }
    }

    public yi4<Boolean> checkForUnsentReports() {
        if (this.checkForUnsentReportsCalled.compareAndSet(false, true)) {
            return this.unsentReportsAvailable.f4178a;
        }
        Logger.getLogger().d("checkForUnsentReports should only be called once per execution.");
        return hd3.W0(Boolean.FALSE);
    }

    public void cleanInvalidTempFiles() {
        this.backgroundWorker.submit(new Runnable() {
            /* class com.google.firebase.crashlytics.internal.common.CrashlyticsController.AnonymousClass15 */

            public void run() {
                CrashlyticsController crashlyticsController = CrashlyticsController.this;
                crashlyticsController.doCleanInvalidTempFiles(crashlyticsController.listFilesMatching(new InvalidPartFileFilter()));
            }
        });
    }

    public yi4<Void> deleteUnsentReports() {
        this.reportActionProvided.b(Boolean.FALSE);
        return this.unsentReportsHandled.f4178a;
    }

    public boolean didCrashOnPreviousExecution() {
        if (!this.crashMarker.isPresent()) {
            String currentSessionId = getCurrentSessionId();
            if (currentSessionId == null || !this.nativeComponent.hasCrashDataForSession(currentSessionId)) {
                return false;
            }
            return true;
        }
        Logger.getLogger().d("Found previous crash marker.");
        this.crashMarker.remove();
        return true;
    }

    public void doCleanInvalidTempFiles(File[] fileArr) {
        final HashSet hashSet = new HashSet();
        for (File file : fileArr) {
            Logger.getLogger().d("Found invalid session part file: " + file);
            hashSet.add(getSessionIdFromSessionFile(file));
        }
        if (!hashSet.isEmpty()) {
            File[] listFilesMatching = listFilesMatching(new FilenameFilter() {
                /* class com.google.firebase.crashlytics.internal.common.CrashlyticsController.AnonymousClass16 */

                public boolean accept(File file, String str) {
                    if (str.length() < 35) {
                        return false;
                    }
                    return hashSet.contains(str.substring(0, 35));
                }
            });
            for (File file2 : listFilesMatching) {
                Logger.getLogger().d("Deleting invalid session file: " + file2);
                file2.delete();
            }
        }
    }

    public void doCloseSessions(int i) throws Exception {
        doCloseSessions(i, false);
    }

    public void enableExceptionHandling(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, SettingsDataProvider settingsDataProvider) {
        openSession();
        CrashlyticsUncaughtExceptionHandler crashlyticsUncaughtExceptionHandler = new CrashlyticsUncaughtExceptionHandler(new CrashlyticsUncaughtExceptionHandler.CrashListener() {
            /* class com.google.firebase.crashlytics.internal.common.CrashlyticsController.AnonymousClass5 */

            @Override // com.google.firebase.crashlytics.internal.common.CrashlyticsUncaughtExceptionHandler.CrashListener
            public void onUncaughtException(SettingsDataProvider settingsDataProvider, Thread thread, Throwable th) {
                CrashlyticsController.this.handleUncaughtException(settingsDataProvider, thread, th);
            }
        }, settingsDataProvider, uncaughtExceptionHandler);
        this.crashHandler = crashlyticsUncaughtExceptionHandler;
        Thread.setDefaultUncaughtExceptionHandler(crashlyticsUncaughtExceptionHandler);
    }

    public boolean finalizeSessions(int i) {
        this.backgroundWorker.checkRunningOnThread();
        if (isHandlingException()) {
            Logger.getLogger().d("Skipping session finalization because a crash has already occurred.");
            return false;
        }
        Logger.getLogger().d("Finalizing previously open sessions.");
        try {
            doCloseSessions(i, true);
            Logger.getLogger().d("Closed all previously open sessions");
            return true;
        } catch (Exception e) {
            Logger.getLogger().e("Unable to finalize previously open sessions.", e);
            return false;
        }
    }

    public File getFatalSessionFilesDir() {
        return new File(getFilesDir(), FATAL_SESSION_DIR);
    }

    public File getFilesDir() {
        return this.fileStore.getFilesDir();
    }

    public File getNativeSessionFilesDir() {
        return new File(getFilesDir(), NATIVE_SESSION_DIR);
    }

    public File getNonFatalSessionFilesDir() {
        return new File(getFilesDir(), NONFATAL_SESSION_DIR);
    }

    public UserMetadata getUserMetadata() {
        return this.userMetadata;
    }

    public synchronized void handleUncaughtException(final SettingsDataProvider settingsDataProvider, final Thread thread, final Throwable th) {
        Logger logger = Logger.getLogger();
        logger.d("Crashlytics is handling uncaught exception \"" + th + "\" from thread " + thread.getName());
        final Date date = new Date();
        try {
            Utils.awaitEvenIfOnMainThread(this.backgroundWorker.submitTask(new Callable<yi4<Void>>() {
                /* class com.google.firebase.crashlytics.internal.common.CrashlyticsController.AnonymousClass6 */

                @Override // java.util.concurrent.Callable
                public yi4<Void> call() throws Exception {
                    long timestampSeconds = CrashlyticsController.getTimestampSeconds(date);
                    String currentSessionId = CrashlyticsController.this.getCurrentSessionId();
                    if (currentSessionId == null) {
                        Logger.getLogger().e("Tried to write a fatal exception while no session was open.");
                        return hd3.W0(null);
                    }
                    CrashlyticsController.this.crashMarker.create();
                    CrashlyticsController.this.reportingCoordinator.persistFatalEvent(th, thread, CrashlyticsController.makeFirebaseSessionIdentifier(currentSessionId), timestampSeconds);
                    CrashlyticsController.this.doWriteFatal(thread, th, currentSessionId, timestampSeconds);
                    CrashlyticsController.this.doWriteAppExceptionMarker(date.getTime());
                    Settings settings = settingsDataProvider.getSettings();
                    int i = settings.getSessionData().maxCustomExceptionEvents;
                    int i2 = settings.getSessionData().maxCompleteSessionsCount;
                    CrashlyticsController.this.doCloseSessions(i);
                    CrashlyticsController.this.doOpenSession();
                    CrashlyticsController.this.trimSessionFiles(i2);
                    if (!CrashlyticsController.this.dataCollectionArbiter.isAutomaticDataCollectionEnabled()) {
                        return hd3.W0(null);
                    }
                    final Executor executor = CrashlyticsController.this.backgroundWorker.getExecutor();
                    return settingsDataProvider.getAppSettings().s(executor, new xi4<AppSettingsData, Void>() {
                        /* class com.google.firebase.crashlytics.internal.common.CrashlyticsController.AnonymousClass6.AnonymousClass1 */

                        public yi4<Void> then(AppSettingsData appSettingsData) throws Exception {
                            if (appSettingsData == null) {
                                Logger.getLogger().w("Received null app settings, cannot send reports at crash time.");
                                return hd3.W0(null);
                            }
                            CrashlyticsController.this.sendSessionReports(appSettingsData, true);
                            return hd3.h3(Arrays.asList(CrashlyticsController.this.logAnalyticsAppExceptionEvents(), CrashlyticsController.this.reportingCoordinator.sendReports(executor, DataTransportState.getState(appSettingsData))));
                        }
                    });
                }
            }));
        } catch (Exception unused) {
        }
    }

    public boolean hasOpenSession() {
        return listSessionBeginFiles().length > 0;
    }

    public boolean isHandlingException() {
        CrashlyticsUncaughtExceptionHandler crashlyticsUncaughtExceptionHandler = this.crashHandler;
        return crashlyticsUncaughtExceptionHandler != null && crashlyticsUncaughtExceptionHandler.isHandlingException();
    }

    public File[] listAppExceptionMarkerFiles() {
        return listFilesMatching(APP_EXCEPTION_MARKER_FILTER);
    }

    public File[] listCompleteSessionFiles() {
        LinkedList linkedList = new LinkedList();
        File fatalSessionFilesDir = getFatalSessionFilesDir();
        FilenameFilter filenameFilter = SESSION_FILE_FILTER;
        Collections.addAll(linkedList, listFilesMatching(fatalSessionFilesDir, filenameFilter));
        Collections.addAll(linkedList, listFilesMatching(getNonFatalSessionFilesDir(), filenameFilter));
        Collections.addAll(linkedList, listFilesMatching(getFilesDir(), filenameFilter));
        return (File[]) linkedList.toArray(new File[linkedList.size()]);
    }

    public File[] listNativeSessionFileDirectories() {
        return ensureFileArrayNotNull(getNativeSessionFilesDir().listFiles());
    }

    public File[] listSessionBeginFiles() {
        return listFilesMatching(SESSION_BEGIN_FILE_FILTER);
    }

    public void openSession() {
        this.backgroundWorker.submit(new Callable<Void>() {
            /* class com.google.firebase.crashlytics.internal.common.CrashlyticsController.AnonymousClass14 */

            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                CrashlyticsController.this.doOpenSession();
                return null;
            }
        });
    }

    public yi4<Void> sendUnsentReports() {
        this.reportActionProvided.b(Boolean.TRUE);
        return this.unsentReportsHandled.f4178a;
    }

    public void setCustomKey(String str, String str2) {
        try {
            this.userMetadata.setCustomKey(str, str2);
            cacheKeyData(this.userMetadata.getCustomKeys());
        } catch (IllegalArgumentException e) {
            Context context2 = this.context;
            if (context2 == null || !CommonUtils.isAppDebuggable(context2)) {
                Logger.getLogger().e("Attempting to set custom attribute with null key, ignoring.");
                return;
            }
            throw e;
        }
    }

    public void setUserId(String str) {
        this.userMetadata.setUserId(str);
        cacheUserData(this.userMetadata);
    }

    public yi4<Void> submitAllReports(final float f, final yi4<AppSettingsData> yi4) {
        if (!this.reportManager.areReportsAvailable()) {
            Logger.getLogger().d("No reports are available.");
            this.unsentReportsAvailable.b(Boolean.FALSE);
            return hd3.W0(null);
        }
        Logger.getLogger().d("Unsent reports are available.");
        return waitForReportAction().r(new xi4<Boolean, Void>() {
            /* class com.google.firebase.crashlytics.internal.common.CrashlyticsController.AnonymousClass8 */

            public yi4<Void> then(final Boolean bool) throws Exception {
                return CrashlyticsController.this.backgroundWorker.submitTask(new Callable<yi4<Void>>() {
                    /* class com.google.firebase.crashlytics.internal.common.CrashlyticsController.AnonymousClass8.AnonymousClass1 */

                    @Override // java.util.concurrent.Callable
                    public yi4<Void> call() throws Exception {
                        final List<Report> findReports = CrashlyticsController.this.reportManager.findReports();
                        if (!bool.booleanValue()) {
                            Logger.getLogger().d("Reports are being deleted.");
                            CrashlyticsController.deleteFiles(CrashlyticsController.this.listAppExceptionMarkerFiles());
                            CrashlyticsController.this.reportManager.deleteReports(findReports);
                            CrashlyticsController.this.reportingCoordinator.removeAllReports();
                            CrashlyticsController.this.unsentReportsHandled.b(null);
                            return hd3.W0(null);
                        }
                        Logger.getLogger().d("Reports are being sent.");
                        final boolean booleanValue = bool.booleanValue();
                        CrashlyticsController.this.dataCollectionArbiter.grantDataCollectionPermission(booleanValue);
                        final Executor executor = CrashlyticsController.this.backgroundWorker.getExecutor();
                        return yi4.s(executor, new xi4<AppSettingsData, Void>() {
                            /* class com.google.firebase.crashlytics.internal.common.CrashlyticsController.AnonymousClass8.AnonymousClass1.AnonymousClass1 */

                            public yi4<Void> then(AppSettingsData appSettingsData) throws Exception {
                                if (appSettingsData == null) {
                                    Logger.getLogger().w("Received null app settings, cannot send reports during app startup.");
                                    return hd3.W0(null);
                                }
                                for (Report report : findReports) {
                                    if (report.getType() == Report.Type.JAVA) {
                                        CrashlyticsController.appendOrganizationIdToSessionFile(appSettingsData.organizationId, report.getFile());
                                    }
                                }
                                CrashlyticsController.this.logAnalyticsAppExceptionEvents();
                                CrashlyticsController.this.reportUploaderProvider.createReportUploader(appSettingsData).uploadReportsAsync(findReports, booleanValue, f);
                                CrashlyticsController.this.reportingCoordinator.sendReports(executor, DataTransportState.getState(appSettingsData));
                                CrashlyticsController.this.unsentReportsHandled.b(null);
                                return hd3.W0(null);
                            }
                        });
                    }
                });
            }
        });
    }

    public void trimSessionFiles(int i) {
        File nativeSessionFilesDir = getNativeSessionFilesDir();
        File fatalSessionFilesDir = getFatalSessionFilesDir();
        java.util.Comparator<File> comparator = SMALLEST_FILE_NAME_FIRST;
        int capSessionCount = i - Utils.capSessionCount(nativeSessionFilesDir, fatalSessionFilesDir, i, comparator);
        Utils.capFileCount(getFilesDir(), SESSION_FILE_FILTER, capSessionCount - Utils.capFileCount(getNonFatalSessionFilesDir(), capSessionCount, comparator), comparator);
    }

    public void writeNonFatalException(final Thread thread, final Throwable th) {
        final Date date = new Date();
        this.backgroundWorker.submit(new Runnable() {
            /* class com.google.firebase.crashlytics.internal.common.CrashlyticsController.AnonymousClass11 */

            public void run() {
                if (!CrashlyticsController.this.isHandlingException()) {
                    long timestampSeconds = CrashlyticsController.getTimestampSeconds(date);
                    String currentSessionId = CrashlyticsController.this.getCurrentSessionId();
                    if (currentSessionId == null) {
                        Logger.getLogger().d("Tried to write a non-fatal exception while no session was open.");
                        return;
                    }
                    CrashlyticsController.this.reportingCoordinator.persistNonFatalEvent(th, thread, CrashlyticsController.makeFirebaseSessionIdentifier(currentSessionId), timestampSeconds);
                    CrashlyticsController.this.doWriteNonFatal(thread, th, currentSessionId, timestampSeconds);
                }
            }
        });
    }

    public void writeToLog(final long j, final String str) {
        this.backgroundWorker.submit(new Callable<Void>() {
            /* class com.google.firebase.crashlytics.internal.common.CrashlyticsController.AnonymousClass10 */

            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                if (CrashlyticsController.this.isHandlingException()) {
                    return null;
                }
                CrashlyticsController.this.logFileManager.writeToLog(j, str);
                return null;
            }
        });
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    private void doCloseSessions(int i, boolean z) throws Exception {
        trimOpenSessions((z ? 1 : 0) + 8);
        File[] listSortedSessionBeginFiles = listSortedSessionBeginFiles();
        if (listSortedSessionBeginFiles.length <= z) {
            Logger.getLogger().d("No open sessions to be closed.");
            return;
        }
        String sessionIdFromSessionFile = getSessionIdFromSessionFile(listSortedSessionBeginFiles[z ? 1 : 0]);
        writeSessionUser(sessionIdFromSessionFile);
        if (this.nativeComponent.hasCrashDataForSession(sessionIdFromSessionFile)) {
            finalizePreviousNativeSession(sessionIdFromSessionFile);
            if (!this.nativeComponent.finalizeSession(sessionIdFromSessionFile)) {
                Logger logger = Logger.getLogger();
                logger.d("Could not finalize native session: " + sessionIdFromSessionFile);
            }
        }
        closeOpenSessions(listSortedSessionBeginFiles, z, i);
        String str = null;
        if (z != 0) {
            str = makeFirebaseSessionIdentifier(getSessionIdFromSessionFile(listSortedSessionBeginFiles[0]));
        }
        this.reportingCoordinator.finalizeSessions(getCurrentTimestampSeconds(), str);
    }

    private UserMetadata getUserMetadata(String str) {
        if (isHandlingException()) {
            return this.userMetadata;
        }
        return new MetaDataStore(getFilesDir()).readUserData(str);
    }

    private static File[] listFilesMatching(File file, FilenameFilter filenameFilter) {
        return ensureFileArrayNotNull(file.listFiles(filenameFilter));
    }
}
