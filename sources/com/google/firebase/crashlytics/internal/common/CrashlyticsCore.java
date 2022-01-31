package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import com.google.firebase.FirebaseApp;
import com.google.firebase.crashlytics.BuildConfig;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbSource;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.persistence.FileStoreImpl;
import com.google.firebase.crashlytics.internal.settings.SettingsDataProvider;
import com.google.firebase.crashlytics.internal.settings.model.Settings;
import com.google.firebase.crashlytics.internal.unity.ResourceUnityVersionProvider;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CrashlyticsCore {
    private static final float CLS_DEFAULT_PROCESS_DELAY = 1.0f;
    public static final String CRASHLYTICS_REQUIRE_BUILD_ID = "com.crashlytics.RequireBuildId";
    public static final boolean CRASHLYTICS_REQUIRE_BUILD_ID_DEFAULT = true;
    public static final String CRASH_MARKER_FILE_NAME = "crash_marker";
    public static final int DEFAULT_MAIN_HANDLER_TIMEOUT_SEC = 4;
    private static final String INITIALIZATION_MARKER_FILE_NAME = "initialization_marker";
    private static final String MISSING_BUILD_ID_MSG = "The Crashlytics build ID is missing. This occurs when Crashlytics tooling is absent from your app's build configuration. Please review Crashlytics onboarding instructions and ensure you have a valid Crashlytics account.";
    private final AnalyticsEventLogger analyticsEventLogger;

    /* renamed from: app  reason: collision with root package name */
    private final FirebaseApp f652app;
    private CrashlyticsBackgroundWorker backgroundWorker;
    private final BreadcrumbSource breadcrumbSource;
    private final Context context;
    private CrashlyticsController controller;
    private ExecutorService crashHandlerExecutor;
    private CrashlyticsFileMarker crashMarker;
    private final DataCollectionArbiter dataCollectionArbiter;
    private boolean didCrashOnPreviousExecution;
    private final IdManager idManager;
    private CrashlyticsFileMarker initializationMarker;
    private CrashlyticsNativeComponent nativeComponent;
    private final long startTime = System.currentTimeMillis();

    public CrashlyticsCore(FirebaseApp firebaseApp, IdManager idManager2, CrashlyticsNativeComponent crashlyticsNativeComponent, DataCollectionArbiter dataCollectionArbiter2, BreadcrumbSource breadcrumbSource2, AnalyticsEventLogger analyticsEventLogger2, ExecutorService executorService) {
        this.f652app = firebaseApp;
        this.dataCollectionArbiter = dataCollectionArbiter2;
        this.context = firebaseApp.getApplicationContext();
        this.idManager = idManager2;
        this.nativeComponent = crashlyticsNativeComponent;
        this.breadcrumbSource = breadcrumbSource2;
        this.analyticsEventLogger = analyticsEventLogger2;
        this.crashHandlerExecutor = executorService;
        this.backgroundWorker = new CrashlyticsBackgroundWorker(executorService);
    }

    private void checkForPreviousCrash() {
        try {
            this.didCrashOnPreviousExecution = Boolean.TRUE.equals((Boolean) Utils.awaitEvenIfOnMainThread(this.backgroundWorker.submit(new Callable<Boolean>() {
                /* class com.google.firebase.crashlytics.internal.common.CrashlyticsCore.AnonymousClass4 */

                @Override // java.util.concurrent.Callable
                public Boolean call() throws Exception {
                    return Boolean.valueOf(CrashlyticsCore.this.controller.didCrashOnPreviousExecution());
                }
            })));
        } catch (Exception unused) {
            this.didCrashOnPreviousExecution = false;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private yi4<Void> doBackgroundInitialization(SettingsDataProvider settingsDataProvider) {
        markInitializationStarted();
        this.controller.cleanInvalidTempFiles();
        try {
            this.breadcrumbSource.registerBreadcrumbHandler(CrashlyticsCore$$Lambda$1.lambdaFactory$(this));
            Settings settings = settingsDataProvider.getSettings();
            if (!settings.getFeaturesData().collectReports) {
                Logger.getLogger().d("Collection of crash reports disabled in Crashlytics settings.");
                return hd3.V0(new RuntimeException("Collection of crash reports disabled in Crashlytics settings."));
            }
            if (!this.controller.finalizeSessions(settings.getSessionData().maxCustomExceptionEvents)) {
                Logger.getLogger().d("Could not finalize previous sessions.");
            }
            yi4<Void> submitAllReports = this.controller.submitAllReports(1.0f, settingsDataProvider.getAppSettings());
            markInitializationComplete();
            return submitAllReports;
        } catch (Exception e) {
            Logger.getLogger().e("Crashlytics encountered a problem during asynchronous initialization.", e);
            return hd3.V0(e);
        } finally {
            markInitializationComplete();
        }
    }

    private void finishInitSynchronously(final SettingsDataProvider settingsDataProvider) {
        Future<?> submit = this.crashHandlerExecutor.submit(new Runnable() {
            /* class com.google.firebase.crashlytics.internal.common.CrashlyticsCore.AnonymousClass2 */

            public void run() {
                CrashlyticsCore.this.doBackgroundInitialization(settingsDataProvider);
            }
        });
        Logger.getLogger().d("Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try {
            submit.get(4, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Logger.getLogger().e("Crashlytics was interrupted during initialization.", e);
        } catch (ExecutionException e2) {
            Logger.getLogger().e("Problem encountered during Crashlytics initialization.", e2);
        } catch (TimeoutException e3) {
            Logger.getLogger().e("Crashlytics timed out during initialization.", e3);
        }
    }

    public static String getVersion() {
        return BuildConfig.VERSION_NAME;
    }

    public static boolean isBuildIdValid(String str, boolean z) {
        if (!z) {
            Logger.getLogger().d("Configured not to require a build ID.");
            return true;
        } else if (!CommonUtils.isNullOrEmpty(str)) {
            return true;
        } else {
            return false;
        }
    }

    public yi4<Boolean> checkForUnsentReports() {
        return this.controller.checkForUnsentReports();
    }

    public yi4<Void> deleteUnsentReports() {
        return this.controller.deleteUnsentReports();
    }

    public boolean didCrashOnPreviousExecution() {
        return this.didCrashOnPreviousExecution;
    }

    public boolean didPreviousInitializationFail() {
        return this.initializationMarker.isPresent();
    }

    public yi4<Void> doBackgroundInitializationAsync(final SettingsDataProvider settingsDataProvider) {
        return Utils.callTask(this.crashHandlerExecutor, new Callable<yi4<Void>>() {
            /* class com.google.firebase.crashlytics.internal.common.CrashlyticsCore.AnonymousClass1 */

            @Override // java.util.concurrent.Callable
            public yi4<Void> call() throws Exception {
                return CrashlyticsCore.this.doBackgroundInitialization(settingsDataProvider);
            }
        });
    }

    public CrashlyticsController getController() {
        return this.controller;
    }

    public void log(String str) {
        this.controller.writeToLog(System.currentTimeMillis() - this.startTime, str);
    }

    public void logException(Throwable th) {
        this.controller.writeNonFatalException(Thread.currentThread(), th);
    }

    public void markInitializationComplete() {
        this.backgroundWorker.submit(new Callable<Boolean>() {
            /* class com.google.firebase.crashlytics.internal.common.CrashlyticsCore.AnonymousClass3 */

            @Override // java.util.concurrent.Callable
            public Boolean call() throws Exception {
                try {
                    boolean remove = CrashlyticsCore.this.initializationMarker.remove();
                    Logger logger = Logger.getLogger();
                    logger.d("Initialization marker file removed: " + remove);
                    return Boolean.valueOf(remove);
                } catch (Exception e) {
                    Logger.getLogger().e("Problem encountered deleting Crashlytics initialization marker.", e);
                    return Boolean.FALSE;
                }
            }
        });
    }

    public void markInitializationStarted() {
        this.backgroundWorker.checkRunningOnThread();
        this.initializationMarker.create();
        Logger.getLogger().d("Initialization marker file created.");
    }

    public boolean onPreExecute(SettingsDataProvider settingsDataProvider) {
        String mappingFileId = CommonUtils.getMappingFileId(this.context);
        Logger logger = Logger.getLogger();
        logger.d("Mapping file ID is: " + mappingFileId);
        if (isBuildIdValid(mappingFileId, CommonUtils.getBooleanResourceValue(this.context, "com.crashlytics.RequireBuildId", true))) {
            String applicationId = this.f652app.getOptions().getApplicationId();
            try {
                Logger logger2 = Logger.getLogger();
                logger2.i("Initializing Crashlytics " + getVersion());
                FileStoreImpl fileStoreImpl = new FileStoreImpl(this.context);
                this.crashMarker = new CrashlyticsFileMarker("crash_marker", fileStoreImpl);
                this.initializationMarker = new CrashlyticsFileMarker(INITIALIZATION_MARKER_FILE_NAME, fileStoreImpl);
                HttpRequestFactory httpRequestFactory = new HttpRequestFactory();
                AppData create = AppData.create(this.context, this.idManager, applicationId, mappingFileId, new ResourceUnityVersionProvider(this.context));
                Logger logger3 = Logger.getLogger();
                logger3.d("Installer package name is: " + create.installerPackageName);
                this.controller = new CrashlyticsController(this.context, this.backgroundWorker, httpRequestFactory, this.idManager, this.dataCollectionArbiter, fileStoreImpl, this.crashMarker, create, null, null, this.nativeComponent, this.analyticsEventLogger, settingsDataProvider);
                boolean didPreviousInitializationFail = didPreviousInitializationFail();
                checkForPreviousCrash();
                this.controller.enableExceptionHandling(Thread.getDefaultUncaughtExceptionHandler(), settingsDataProvider);
                if (!didPreviousInitializationFail || !CommonUtils.canTryConnection(this.context)) {
                    Logger.getLogger().d("Exception handling initialization successful");
                    return true;
                }
                Logger.getLogger().d("Crashlytics did not finish previous background initialization. Initializing synchronously.");
                finishInitSynchronously(settingsDataProvider);
                return false;
            } catch (Exception e) {
                Logger.getLogger().e("Crashlytics was not started due to an exception during initialization", e);
                this.controller = null;
                return false;
            }
        } else {
            throw new IllegalStateException(MISSING_BUILD_ID_MSG);
        }
    }

    public yi4<Void> sendUnsentReports() {
        return this.controller.sendUnsentReports();
    }

    public void setCrashlyticsCollectionEnabled(Boolean bool) {
        this.dataCollectionArbiter.setCrashlyticsDataCollectionEnabled(bool);
    }

    public void setCustomKey(String str, String str2) {
        this.controller.setCustomKey(str, str2);
    }

    public void setUserId(String str) {
        this.controller.setUserId(str);
    }
}
