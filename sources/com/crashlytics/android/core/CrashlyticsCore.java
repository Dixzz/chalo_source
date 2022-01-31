package com.crashlytics.android.core;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.core.CrashPromptDialog;
import com.crashlytics.android.core.internal.CrashEventDataProvider;
import com.crashlytics.android.core.internal.models.SessionEventData;
import com.rabbitmq.client.ConnectionFactory;
import defpackage.c26;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.net.URL;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import javax.net.ssl.HttpsURLConnection;

@u06({CrashEventDataProvider.class})
public class CrashlyticsCore extends c06<Void> {
    public static final float CLS_DEFAULT_PROCESS_DELAY = 1.0f;
    public static final String COLLECT_CUSTOM_KEYS = "com.crashlytics.CollectCustomKeys";
    public static final String COLLECT_CUSTOM_LOGS = "com.crashlytics.CollectCustomLogs";
    public static final String CRASHLYTICS_API_ENDPOINT = "com.crashlytics.ApiEndpoint";
    public static final String CRASHLYTICS_REQUIRE_BUILD_ID = "com.crashlytics.RequireBuildId";
    public static final boolean CRASHLYTICS_REQUIRE_BUILD_ID_DEFAULT = true;
    public static final String CRASH_MARKER_FILE_NAME = "crash_marker";
    public static final int DEFAULT_MAIN_HANDLER_TIMEOUT_SEC = 4;
    private static final String INITIALIZATION_MARKER_FILE_NAME = "initialization_marker";
    public static final int MAX_ATTRIBUTES = 64;
    public static final int MAX_ATTRIBUTE_SIZE = 1024;
    private static final String MISSING_BUILD_ID_MSG = "This app relies on Crashlytics. Please sign up for access at https://fabric.io/sign_up,\ninstall an Android build tool and ask a team member to invite you to this app's organization.";
    private static final String PREF_ALWAYS_SEND_REPORTS_KEY = "always_send_reports_opt_in";
    private static final boolean SHOULD_PROMPT_BEFORE_SENDING_REPORTS_DEFAULT = false;
    public static final String TAG = "CrashlyticsCore";
    private String apiKey;
    private final ConcurrentHashMap<String, String> attributes;
    private String buildId;
    private CrashlyticsFileMarker crashMarker;
    private float delay;
    private boolean disabled;
    private CrashlyticsExecutorServiceWrapper executorServiceWrapper;
    private CrashEventDataProvider externalCrashEventDataProvider;
    private u16 fileStore;
    private CrashlyticsUncaughtExceptionHandler handler;
    private r16 httpRequestFactory;
    private CrashlyticsFileMarker initializationMarker;
    private String installerPackageName;
    private CrashlyticsListener listener;
    private String packageName;
    private final PinningInfoProvider pinningInfo;
    private File sdkDir;
    private final long startTime;
    private String userEmail;
    private String userId;
    private String userName;
    private String versionCode;
    private String versionName;

    public static class Builder {
        private float delay = -1.0f;
        private boolean disabled = false;
        private CrashlyticsListener listener;
        private PinningInfoProvider pinningInfoProvider;

        public CrashlyticsCore build() {
            if (this.delay < 0.0f) {
                this.delay = 1.0f;
            }
            return new CrashlyticsCore(this.delay, this.listener, this.pinningInfoProvider, this.disabled);
        }

        public Builder delay(float f) {
            if (f <= 0.0f) {
                throw new IllegalArgumentException("delay must be greater than 0");
            } else if (this.delay <= 0.0f) {
                this.delay = f;
                return this;
            } else {
                throw new IllegalStateException("delay already set.");
            }
        }

        public Builder disabled(boolean z) {
            this.disabled = z;
            return this;
        }

        public Builder listener(CrashlyticsListener crashlyticsListener) {
            if (crashlyticsListener == null) {
                throw new IllegalArgumentException("listener must not be null.");
            } else if (this.listener == null) {
                this.listener = crashlyticsListener;
                return this;
            } else {
                throw new IllegalStateException("listener already set.");
            }
        }

        @Deprecated
        public Builder pinningInfo(PinningInfoProvider pinningInfoProvider2) {
            if (pinningInfoProvider2 == null) {
                throw new IllegalArgumentException("pinningInfoProvider must not be null.");
            } else if (this.pinningInfoProvider == null) {
                this.pinningInfoProvider = pinningInfoProvider2;
                return this;
            } else {
                throw new IllegalStateException("pinningInfoProvider already set.");
            }
        }
    }

    public static final class CrashMarkerCheck implements Callable<Boolean> {
        private final CrashlyticsFileMarker crashMarker;

        public CrashMarkerCheck(CrashlyticsFileMarker crashlyticsFileMarker) {
            this.crashMarker = crashlyticsFileMarker;
        }

        @Override // java.util.concurrent.Callable
        public Boolean call() throws Exception {
            if (!this.crashMarker.isPresent()) {
                return Boolean.FALSE;
            }
            this.crashMarker.remove();
            return Boolean.TRUE;
        }
    }

    public static final class NoOpListener implements CrashlyticsListener {
        private NoOpListener() {
        }

        @Override // com.crashlytics.android.core.CrashlyticsListener
        public void crashlyticsDidDetectCrashDuringPreviousExecution() {
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CrashlyticsCore(float r10, com.crashlytics.android.core.CrashlyticsListener r11, com.crashlytics.android.core.PinningInfoProvider r12, boolean r13) {
        /*
            r9 = this;
            java.util.concurrent.atomic.AtomicLong r0 = new java.util.concurrent.atomic.AtomicLong
            r1 = 1
            r0.<init>(r1)
            m06 r1 = new m06
            java.lang.String r2 = "Crashlytics Exception Handler"
            r1.<init>(r2, r0)
            java.util.concurrent.ExecutorService r8 = java.util.concurrent.Executors.newSingleThreadExecutor(r1)
            defpackage.hd3.k(r2, r8)
            r3 = r9
            r4 = r10
            r5 = r11
            r6 = r12
            r7 = r13
            r3.<init>(r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crashlytics.android.core.CrashlyticsCore.<init>(float, com.crashlytics.android.core.CrashlyticsListener, com.crashlytics.android.core.PinningInfoProvider, boolean):void");
    }

    private void checkForPreviousCrash() {
        if (Boolean.TRUE.equals((Boolean) this.executorServiceWrapper.executeSyncLoggingException(new CrashMarkerCheck(this.crashMarker)))) {
            try {
                this.listener.crashlyticsDidDetectCrashDuringPreviousExecution();
            } catch (Exception unused) {
            }
        }
    }

    private void doLog(int i, String str, String str2) {
        if (!this.disabled && ensureFabricWithCalled("prior to logging messages.")) {
            this.handler.writeToLog(System.currentTimeMillis() - this.startTime, formatLogMessage(i, str, str2));
        }
    }

    private static boolean ensureFabricWithCalled(String str) {
        CrashlyticsCore instance = getInstance();
        return (instance == null || instance.handler == null) ? false : true;
    }

    private void finishInitSynchronously() {
        AnonymousClass1 r0 = new x06<Void>() {
            /* class com.crashlytics.android.core.CrashlyticsCore.AnonymousClass1 */

            @Override // defpackage.z06, defpackage.y06
            public v06 getPriority() {
                return v06.IMMEDIATE;
            }

            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                return CrashlyticsCore.this.doInBackground();
            }
        };
        for (a16 a16 : getDependencies()) {
            r0.addDependency(a16);
        }
        getFabric();
        throw null;
    }

    private static String formatLogMessage(int i, String str, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder();
        switch (i) {
            case 2:
                str3 = "V";
                break;
            case 3:
                str3 = "D";
                break;
            case 4:
                str3 = "I";
                break;
            case 5:
                str3 = "W";
                break;
            case 6:
                str3 = "E";
                break;
            case 7:
                str3 = "A";
                break;
            default:
                str3 = "?";
                break;
        }
        hj1.V0(sb, str3, ConnectionFactory.DEFAULT_VHOST, str, " ");
        sb.append(str2);
        return sb.toString();
    }

    public static CrashlyticsCore getInstance() {
        xz5.a(CrashlyticsCore.class);
        throw null;
    }

    /* access modifiers changed from: private */
    public boolean getSendDecisionFromUser(Activity activity, a26 a26) {
        final CrashPromptDialog create = CrashPromptDialog.create(activity, a26, new CrashPromptDialog.AlwaysSendCallback() {
            /* class com.crashlytics.android.core.CrashlyticsCore.AnonymousClass7 */

            @Override // com.crashlytics.android.core.CrashPromptDialog.AlwaysSendCallback
            public void sendUserReportsWithoutPrompting(boolean z) {
                CrashlyticsCore.this.setShouldSendUserReportsWithoutPrompting(z);
            }
        });
        activity.runOnUiThread(new Runnable() {
            /* class com.crashlytics.android.core.CrashlyticsCore.AnonymousClass8 */

            public void run() {
                create.show();
            }
        });
        create.await();
        return create.getOptIn();
    }

    public static b26 getSessionSettingsData() {
        c26.b.f510a.a();
        return null;
    }

    private boolean installExceptionHandler(UnityVersionProvider unityVersionProvider) {
        try {
            CrashlyticsUncaughtExceptionHandler crashlyticsUncaughtExceptionHandler = new CrashlyticsUncaughtExceptionHandler(Thread.getDefaultUncaughtExceptionHandler(), this.executorServiceWrapper, getIdManager(), unityVersionProvider, this.fileStore, this);
            this.handler = crashlyticsUncaughtExceptionHandler;
            crashlyticsUncaughtExceptionHandler.openSession();
            Thread.setDefaultUncaughtExceptionHandler(this.handler);
            return true;
        } catch (Exception unused) {
            this.handler = null;
            return false;
        }
    }

    public static boolean isBuildIdValid(String str, boolean z) {
        if (!z) {
            return true;
        }
        return !(str == null || str.length() == 0);
    }

    public static void recordFatalExceptionEvent(String str, String str2) {
        xz5.a(Answers.class);
        throw null;
    }

    public static void recordLoggedExceptionEvent(String str, String str2) {
        xz5.a(Answers.class);
        throw null;
    }

    private static String sanitizeAttribute(String str) {
        if (str == null) {
            return str;
        }
        String trim = str.trim();
        return trim.length() > 1024 ? trim.substring(0, 1024) : trim;
    }

    private void setAndValidateKitProperties(Context context) throws PackageManager.NameNotFoundException {
        PinningInfoProvider pinningInfoProvider = this.pinningInfo;
        CrashlyticsPinningInfoProvider crashlyticsPinningInfoProvider = pinningInfoProvider != null ? new CrashlyticsPinningInfoProvider(pinningInfoProvider) : null;
        o16 o16 = new o16(xz5.f3984a);
        this.httpRequestFactory = o16;
        o16 o162 = o16;
        if (o162.f2633a != crashlyticsPinningInfoProvider) {
            o162.f2633a = crashlyticsPinningInfoProvider;
            synchronized (o162) {
                o162.c = false;
                o162.b = null;
            }
        }
        this.packageName = context.getPackageName();
        getIdManager();
        throw null;
    }

    public boolean canSendWithUserApproval() {
        c26 c26 = c26.b.f510a;
        AnonymousClass6 r1 = new c26.c<Boolean>() {
            /* class com.crashlytics.android.core.CrashlyticsCore.AnonymousClass6 */

            @Override // defpackage.c26.c
            public Boolean usingSettings(d26 d26) {
                CrashlyticsCore.this.getFabric();
                throw null;
            }
        };
        Object obj = Boolean.TRUE;
        d26 d26 = c26.f509a.get();
        if (d26 != null) {
            obj = r1.usingSettings(d26);
        }
        return ((Boolean) obj).booleanValue();
    }

    public void crash() {
        new CrashTest().indexOutOfBounds();
    }

    public void createCrashMarker() {
        this.crashMarker.create();
    }

    public boolean didPreviousInitializationFail() {
        return ((Boolean) this.executorServiceWrapper.executeSyncLoggingException(new Callable<Boolean>() {
            /* class com.crashlytics.android.core.CrashlyticsCore.AnonymousClass4 */

            @Override // java.util.concurrent.Callable
            public Boolean call() throws Exception {
                return Boolean.valueOf(CrashlyticsCore.this.initializationMarker.isPresent());
            }
        })).booleanValue();
    }

    public String getApiKey() {
        return this.apiKey;
    }

    public Map<String, String> getAttributes() {
        return Collections.unmodifiableMap(this.attributes);
    }

    public String getBuildId() {
        return this.buildId;
    }

    public CreateReportSpiCall getCreateReportSpiCall(d26 d26) {
        if (d26 == null) {
            return null;
        }
        getOverridenSpiEndpoint();
        throw null;
    }

    public SessionEventData getExternalCrashEventData() {
        CrashEventDataProvider crashEventDataProvider = this.externalCrashEventDataProvider;
        if (crashEventDataProvider != null) {
            return crashEventDataProvider.getCrashEventData();
        }
        return null;
    }

    public CrashlyticsUncaughtExceptionHandler getHandler() {
        return this.handler;
    }

    @Override // defpackage.c06
    public String getIdentifier() {
        return "com.crashlytics.sdk.android.crashlytics-core";
    }

    public String getInstallerPackageName() {
        return this.installerPackageName;
    }

    public String getOverridenSpiEndpoint() {
        return j06.g(getContext(), "com.crashlytics.ApiEndpoint");
    }

    public String getPackageName() {
        return this.packageName;
    }

    public PinningInfoProvider getPinningInfoProvider() {
        if (!this.disabled) {
            return this.pinningInfo;
        }
        return null;
    }

    public File getSdkDirectory() {
        if (this.sdkDir == null) {
            if (getContext() != null) {
                Context context = getContext();
                getPath();
                context.getPackageName();
                File filesDir = context.getFilesDir();
                if (filesDir == null || (!filesDir.exists() && !filesDir.mkdirs())) {
                    filesDir = null;
                }
                this.sdkDir = filesDir;
            } else {
                throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
            }
        }
        return this.sdkDir;
    }

    public String getUserEmail() {
        getIdManager();
        throw null;
    }

    public String getUserIdentifier() {
        getIdManager();
        throw null;
    }

    public String getUserName() {
        getIdManager();
        throw null;
    }

    @Override // defpackage.c06
    public String getVersion() {
        return "2.3.14.151";
    }

    public String getVersionCode() {
        return this.versionCode;
    }

    public String getVersionName() {
        return this.versionName;
    }

    public boolean internalVerifyPinning(URL url) {
        if (getPinningInfoProvider() == null) {
            return false;
        }
        r16 r16 = this.httpRequestFactory;
        p16 p16 = p16.GET;
        String url2 = url.toString();
        o16 o16 = (o16) r16;
        Objects.requireNonNull(o16);
        q16 a2 = o16.a(p16, url2, Collections.emptyMap());
        ((HttpsURLConnection) a2.h()).setInstanceFollowRedirects(false);
        a2.e();
        return true;
    }

    public void log(String str) {
        doLog(3, TAG, str);
    }

    public void logException(Throwable th) {
        if (this.disabled || !ensureFabricWithCalled("prior to logging exceptions.")) {
            return;
        }
        if (th != null) {
            this.handler.writeNonFatalException(Thread.currentThread(), th);
        } else if (xz5.f3984a.a(5)) {
            Log.println(5, TAG, "Crashlytics is ignoring a request to log a null exception.");
        }
    }

    public void markInitializationComplete() {
        this.executorServiceWrapper.executeAsync(new Callable<Boolean>() {
            /* class com.crashlytics.android.core.CrashlyticsCore.AnonymousClass3 */

            @Override // java.util.concurrent.Callable
            public Boolean call() throws Exception {
                try {
                    return Boolean.valueOf(CrashlyticsCore.this.initializationMarker.remove());
                } catch (Exception unused) {
                    return Boolean.FALSE;
                }
            }
        });
    }

    public void markInitializationStarted() {
        this.executorServiceWrapper.executeSyncLoggingException(new Callable<Void>() {
            /* class com.crashlytics.android.core.CrashlyticsCore.AnonymousClass2 */

            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                CrashlyticsCore.this.initializationMarker.create();
                return null;
            }
        });
    }

    @Override // defpackage.c06
    public boolean onPreExecute() {
        return onPreExecute(super.getContext());
    }

    public void setBool(String str, boolean z) {
        setString(str, Boolean.toString(z));
    }

    public void setDouble(String str, double d) {
        setString(str, Double.toString(d));
    }

    public void setExternalCrashEventDataProvider(CrashEventDataProvider crashEventDataProvider) {
        this.externalCrashEventDataProvider = crashEventDataProvider;
    }

    public void setFloat(String str, float f) {
        setString(str, Float.toString(f));
    }

    public void setInt(String str, int i) {
        setString(str, Integer.toString(i));
    }

    @Deprecated
    public synchronized void setListener(CrashlyticsListener crashlyticsListener) {
        if (crashlyticsListener != null) {
            this.listener = crashlyticsListener;
        } else {
            throw new IllegalArgumentException("listener must not be null.");
        }
    }

    public void setLong(String str, long j) {
        setString(str, Long.toString(j));
    }

    @SuppressLint({"CommitPrefEdits"})
    public void setShouldSendUserReportsWithoutPrompting(boolean z) {
        Context context = getContext();
        String name = getClass().getName();
        if (context != null) {
            context.getSharedPreferences(name, 0).edit().putBoolean(PREF_ALWAYS_SEND_REPORTS_KEY, z).apply();
            return;
        }
        throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
    }

    public void setString(String str, String str2) {
        String str3;
        if (this.disabled || !ensureFabricWithCalled("prior to setting keys.")) {
            return;
        }
        if (str == null) {
            Context context = getContext();
            if (context != null) {
                if ((context.getApplicationInfo().flags & 2) != 0) {
                    throw new IllegalArgumentException("Custom attribute key must not be null.");
                }
                return;
            }
            return;
        }
        String sanitizeAttribute = sanitizeAttribute(str);
        if (this.attributes.size() < 64 || this.attributes.containsKey(sanitizeAttribute)) {
            if (str2 == null) {
                str3 = "";
            } else {
                str3 = sanitizeAttribute(str2);
            }
            this.attributes.put(sanitizeAttribute, str3);
            this.handler.cacheKeyData(this.attributes);
        }
    }

    public void setUserEmail(String str) {
        if (!this.disabled && ensureFabricWithCalled("prior to setting user data.")) {
            String sanitizeAttribute = sanitizeAttribute(str);
            this.userEmail = sanitizeAttribute;
            this.handler.cacheUserData(this.userId, this.userName, sanitizeAttribute);
        }
    }

    public void setUserIdentifier(String str) {
        if (!this.disabled && ensureFabricWithCalled("prior to setting user data.")) {
            String sanitizeAttribute = sanitizeAttribute(str);
            this.userId = sanitizeAttribute;
            this.handler.cacheUserData(sanitizeAttribute, this.userName, this.userEmail);
        }
    }

    public void setUserName(String str) {
        if (!this.disabled && ensureFabricWithCalled("prior to setting user data.")) {
            String sanitizeAttribute = sanitizeAttribute(str);
            this.userName = sanitizeAttribute;
            this.handler.cacheUserData(this.userId, sanitizeAttribute, this.userEmail);
        }
    }

    public boolean shouldPromptUserBeforeSendingCrashReports() {
        c26 c26 = c26.b.f510a;
        AnonymousClass5 r1 = new c26.c<Boolean>() {
            /* class com.crashlytics.android.core.CrashlyticsCore.AnonymousClass5 */

            @Override // defpackage.c26.c
            public Boolean usingSettings(d26 d26) {
                Objects.requireNonNull(d26);
                throw null;
            }
        };
        Object obj = Boolean.FALSE;
        d26 d26 = c26.f509a.get();
        if (d26 != null) {
            obj = r1.usingSettings(d26);
        }
        return ((Boolean) obj).booleanValue();
    }

    public boolean shouldSendReportsWithoutPrompting() {
        Context context = getContext();
        String name = getClass().getName();
        if (context != null) {
            return context.getSharedPreferences(name, 0).getBoolean(PREF_ALWAYS_SEND_REPORTS_KEY, false);
        }
        throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
    }

    public boolean verifyPinning(URL url) {
        try {
            return internalVerifyPinning(url);
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // defpackage.c06
    public Void doInBackground() {
        markInitializationStarted();
        SessionEventData externalCrashEventData = getExternalCrashEventData();
        if (externalCrashEventData != null) {
            this.handler.writeExternalCrashEvent(externalCrashEventData);
        }
        this.handler.cleanInvalidTempFiles();
        try {
            if (c26.b.f510a.a() == null) {
                return null;
            }
            throw null;
        } catch (Exception unused) {
            return null;
        } finally {
            markInitializationComplete();
        }
    }

    public void log(int i, String str, String str2) {
        doLog(i, str, str2);
        String S = hj1.S("", str);
        Log.println(i, S, "" + str2);
    }

    public boolean onPreExecute(Context context) {
        if (this.disabled) {
            return false;
        }
        String a2 = new h06().a(context);
        this.apiKey = a2;
        if (a2 == null) {
            return false;
        }
        this.buildId = j06.m(context);
        if (isBuildIdValid(this.buildId, j06.e(context, "com.crashlytics.RequireBuildId", true))) {
            getVersion();
            v16 v16 = new v16(this);
            this.fileStore = v16;
            this.crashMarker = new CrashlyticsFileMarker("crash_marker", v16);
            this.initializationMarker = new CrashlyticsFileMarker(INITIALIZATION_MARKER_FILE_NAME, this.fileStore);
            try {
                setAndValidateKitProperties(context);
                ManifestUnityVersionProvider manifestUnityVersionProvider = new ManifestUnityVersionProvider(context, getPackageName());
                boolean didPreviousInitializationFail = didPreviousInitializationFail();
                checkForPreviousCrash();
                if (!installExceptionHandler(manifestUnityVersionProvider)) {
                    return false;
                }
                if (!didPreviousInitializationFail || !j06.a(context)) {
                    return true;
                }
                finishInitSynchronously();
                return false;
            } catch (Exception unused) {
                return false;
            }
        } else {
            throw new b16(MISSING_BUILD_ID_MSG);
        }
    }

    public CrashlyticsCore() {
        this(1.0f, null, null, false);
    }

    public CrashlyticsCore(float f, CrashlyticsListener crashlyticsListener, PinningInfoProvider pinningInfoProvider, boolean z, ExecutorService executorService) {
        this.userId = null;
        this.userEmail = null;
        this.userName = null;
        this.delay = f;
        this.listener = crashlyticsListener == null ? new NoOpListener() : crashlyticsListener;
        this.pinningInfo = pinningInfoProvider;
        this.disabled = z;
        this.executorServiceWrapper = new CrashlyticsExecutorServiceWrapper(executorService);
        this.attributes = new ConcurrentHashMap<>();
        this.startTime = System.currentTimeMillis();
    }
}
