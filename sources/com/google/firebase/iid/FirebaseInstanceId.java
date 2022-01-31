package com.google.firebase.iid;

import android.os.Build;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.Keep;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import com.google.firebase.FirebaseApp;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.iid.Store;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.messaging.Constants;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import javax.annotation.concurrent.GuardedBy;

@Deprecated
/* compiled from: com.google.firebase:firebase-iid@@21.1.0 */
public class FirebaseInstanceId {
    private static final Pattern API_KEY_FORMAT = Pattern.compile("\\AA[\\w-]{38}\\z");
    private static final long MAX_DELAY_SEC = TimeUnit.HOURS.toSeconds(8);
    private static Store store;
    @GuardedBy("FirebaseInstanceId.class")
    public static ScheduledExecutorService syncExecutor;

    /* renamed from: app  reason: collision with root package name */
    private final FirebaseApp f661app;
    public final Executor fileIoExecutor;
    private final FirebaseInstallationsApi firebaseInstallations;
    private final Metadata metadata;
    private final List<FirebaseInstanceIdInternal.NewTokenListener> newTokenListeners;
    private final RequestDeduplicator requestDeduplicator;
    private final GmsRpc rpc;
    @GuardedBy("this")
    private boolean syncScheduledOrRunning;

    public FirebaseInstanceId(FirebaseApp firebaseApp, Metadata metadata2, Executor executor, Executor executor2, Provider<UserAgentPublisher> provider, Provider<HeartBeatInfo> provider2, FirebaseInstallationsApi firebaseInstallationsApi) {
        this.syncScheduledOrRunning = false;
        this.newTokenListeners = new ArrayList();
        if (Metadata.getDefaultSenderId(firebaseApp) != null) {
            synchronized (FirebaseInstanceId.class) {
                if (store == null) {
                    store = new Store(firebaseApp.getApplicationContext());
                }
            }
            this.f661app = firebaseApp;
            this.metadata = metadata2;
            this.rpc = new GmsRpc(firebaseApp, metadata2, provider, provider2, firebaseInstallationsApi);
            this.fileIoExecutor = executor2;
            this.requestDeduplicator = new RequestDeduplicator(executor);
            this.firebaseInstallations = firebaseInstallationsApi;
            return;
        }
        throw new IllegalStateException("FirebaseInstanceId failed to initialize, FirebaseApp is missing project ID");
    }

    private <T> T awaitTask(yi4<T> yi4) throws IOException {
        try {
            return (T) hd3.v(yi4, 30000, TimeUnit.MILLISECONDS);
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof IOException) {
                if ("INSTANCE_ID_RESET".equals(cause.getMessage())) {
                    resetStorage();
                }
                throw ((IOException) cause);
            } else if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else {
                throw new IOException(e);
            }
        } catch (InterruptedException | TimeoutException unused) {
            throw new IOException(GmsRpc.ERROR_SERVICE_NOT_AVAILABLE);
        }
    }

    private static <T> T awaitTaskAllowOnMainThread(yi4<T> yi4) throws InterruptedException {
        gj1.l(yi4, "Task must not be null");
        CountDownLatch countDownLatch = new CountDownLatch(1);
        yi4.c(FirebaseInstanceId$$Lambda$1.$instance, new FirebaseInstanceId$$Lambda$2(countDownLatch));
        countDownLatch.await(30000, TimeUnit.MILLISECONDS);
        return (T) getResultOrThrowException(yi4);
    }

    private static void checkRequiredFirebaseOptions(FirebaseApp firebaseApp) {
        gj1.i(firebaseApp.getOptions().getProjectId(), "Please set your project ID. A valid Firebase project ID is required to communicate with Firebase server APIs: It identifies your project with Google.");
        gj1.i(firebaseApp.getOptions().getApplicationId(), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.");
        gj1.i(firebaseApp.getOptions().getApiKey(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.");
        gj1.c(isValidAppIdFormat(firebaseApp.getOptions().getApplicationId()), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        gj1.c(isValidApiKeyFormat(firebaseApp.getOptions().getApiKey()), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
    }

    public static synchronized void clearInstancesForTest() {
        synchronized (FirebaseInstanceId.class) {
            ScheduledExecutorService scheduledExecutorService = syncExecutor;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
            syncExecutor = null;
            store = null;
        }
    }

    public static FirebaseInstanceId getInstance() {
        return getInstance(FirebaseApp.getInstance());
    }

    private static <T> T getResultOrThrowException(yi4<T> yi4) {
        if (yi4.q()) {
            return yi4.m();
        }
        if (yi4.o()) {
            throw new CancellationException("Task is already canceled");
        } else if (yi4.p()) {
            throw new IllegalStateException(yi4.l());
        } else {
            throw new IllegalThreadStateException("Firebase Installations getId Task has timed out.");
        }
    }

    private String getSubtype() {
        if (FirebaseApp.DEFAULT_APP_NAME.equals(this.f661app.getName())) {
            return "";
        }
        return this.f661app.getPersistenceKey();
    }

    public static boolean isDebugLogEnabled() {
        if (Log.isLoggable("FirebaseInstanceId", 3) || (Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseInstanceId", 3))) {
            return true;
        }
        return false;
    }

    public static boolean isValidApiKeyFormat(@Nonnull String str) {
        return API_KEY_FORMAT.matcher(str).matches();
    }

    public static boolean isValidAppIdFormat(@Nonnull String str) {
        return str.contains(ProductDiscountsObject.KEY_DELIMITER);
    }

    private static String rationaliseScope(String str) {
        return (str.isEmpty() || str.equalsIgnoreCase(Constants.ScionAnalytics.ORIGIN_FCM) || str.equalsIgnoreCase(Constants.MessageTypes.MESSAGE)) ? "*" : str;
    }

    private void startSyncIfNecessary() {
        if (tokenNeedsRefresh(getTokenWithoutTriggeringSync())) {
            startSync();
        }
    }

    public void addNewTokenListener(FirebaseInstanceIdInternal.NewTokenListener newTokenListener) {
        this.newTokenListeners.add(newTokenListener);
    }

    public String blockingGetMasterToken() throws IOException {
        return getToken(Metadata.getDefaultSenderId(this.f661app), "*");
    }

    @Deprecated
    public void deleteInstanceId() throws IOException {
        checkRequiredFirebaseOptions(this.f661app);
        if (Looper.getMainLooper() != Looper.myLooper()) {
            awaitTask(this.firebaseInstallations.delete());
            resetStorage();
            return;
        }
        throw new IOException("MAIN_THREAD");
    }

    @Deprecated
    public void deleteToken(String str, String str2) throws IOException {
        checkRequiredFirebaseOptions(this.f661app);
        if (Looper.getMainLooper() != Looper.myLooper()) {
            String rationaliseScope = rationaliseScope(str2);
            awaitTask(this.rpc.deleteToken(getIdWithoutTriggeringSync(), str, rationaliseScope));
            store.deleteToken(getSubtype(), str, rationaliseScope);
            return;
        }
        throw new IOException("MAIN_THREAD");
    }

    public void enqueueTaskWithDelaySeconds(Runnable runnable, long j) {
        synchronized (FirebaseInstanceId.class) {
            if (syncExecutor == null) {
                syncExecutor = new ScheduledThreadPoolExecutor(1, new jb2("FirebaseInstanceId"));
            }
            syncExecutor.schedule(runnable, j, TimeUnit.SECONDS);
        }
    }

    public FirebaseApp getApp() {
        return this.f661app;
    }

    public long getCreationTime() {
        return store.getCreationTime(this.f661app.getPersistenceKey());
    }

    @Deprecated
    public String getId() {
        checkRequiredFirebaseOptions(this.f661app);
        startSyncIfNecessary();
        return getIdWithoutTriggeringSync();
    }

    public String getIdWithoutTriggeringSync() {
        try {
            store.setCreationTime(this.f661app.getPersistenceKey());
            return (String) awaitTaskAllowOnMainThread(this.firebaseInstallations.getId());
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

    @Deprecated
    public yi4<InstanceIdResult> getInstanceId() {
        checkRequiredFirebaseOptions(this.f661app);
        return getInstanceId(Metadata.getDefaultSenderId(this.f661app), "*");
    }

    @Deprecated
    public String getToken() {
        checkRequiredFirebaseOptions(this.f661app);
        Store.Token tokenWithoutTriggeringSync = getTokenWithoutTriggeringSync();
        if (tokenNeedsRefresh(tokenWithoutTriggeringSync)) {
            startSync();
        }
        return Store.Token.getTokenOrNull(tokenWithoutTriggeringSync);
    }

    public Store.Token getTokenWithoutTriggeringSync() {
        return getTokenWithoutTriggeringSync(Metadata.getDefaultSenderId(this.f661app), "*");
    }

    public boolean isFcmAutoInitEnabled() {
        throw new IllegalStateException("FirebaseMessaging version not supported. Update to latest version.");
    }

    public boolean isGmsCorePresent() {
        return this.metadata.isGmscorePresent();
    }

    public final /* synthetic */ yi4 lambda$getInstanceId$0$FirebaseInstanceId(String str, String str2, String str3, String str4) throws Exception {
        store.saveToken(getSubtype(), str, str2, str4, this.metadata.getAppVersionCode());
        return hd3.W0(new InstanceIdResultImpl(str3, str4));
    }

    public final /* synthetic */ void lambda$getInstanceId$1$FirebaseInstanceId(Store.Token token, InstanceIdResult instanceIdResult) {
        String token2 = instanceIdResult.getToken();
        if (token == null || !token2.equals(token.token)) {
            for (FirebaseInstanceIdInternal.NewTokenListener newTokenListener : this.newTokenListeners) {
                newTokenListener.onNewToken(token2);
            }
        }
    }

    public final /* synthetic */ yi4 lambda$getInstanceId$2$FirebaseInstanceId(String str, String str2, String str3, Store.Token token) {
        return this.rpc.getToken(str, str2, str3).s(this.fileIoExecutor, new FirebaseInstanceId$$Lambda$4(this, str2, str3, str)).g(FirebaseInstanceId$$Lambda$5.$instance, new FirebaseInstanceId$$Lambda$6(this, token));
    }

    public final /* synthetic */ yi4 lambda$getInstanceId$3$FirebaseInstanceId(String str, String str2, yi4 yi4) throws Exception {
        String idWithoutTriggeringSync = getIdWithoutTriggeringSync();
        Store.Token tokenWithoutTriggeringSync = getTokenWithoutTriggeringSync(str, str2);
        if (!tokenNeedsRefresh(tokenWithoutTriggeringSync)) {
            return hd3.W0(new InstanceIdResultImpl(idWithoutTriggeringSync, tokenWithoutTriggeringSync.token));
        }
        return this.requestDeduplicator.getOrStartGetTokenRequest(str, str2, new FirebaseInstanceId$$Lambda$3(this, idWithoutTriggeringSync, str, str2, tokenWithoutTriggeringSync));
    }

    public synchronized void resetStorage() {
        store.deleteAll();
    }

    public void setFcmAutoInitEnabled(boolean z) {
        throw new IllegalStateException("FirebaseMessaging version not supported. Update to latest version.");
    }

    public synchronized void setSyncScheduledOrRunning(boolean z) {
        this.syncScheduledOrRunning = z;
    }

    public synchronized void startSync() {
        if (!this.syncScheduledOrRunning) {
            syncWithDelaySecondsInternal(0);
        }
    }

    public synchronized void syncWithDelaySecondsInternal(long j) {
        enqueueTaskWithDelaySeconds(new SyncTask(this, Math.min(Math.max(30L, j + j), MAX_DELAY_SEC)), j);
        this.syncScheduledOrRunning = true;
    }

    public boolean tokenNeedsRefresh(Store.Token token) {
        return token == null || token.needsRefresh(this.metadata.getAppVersionCode());
    }

    @Keep
    public static FirebaseInstanceId getInstance(FirebaseApp firebaseApp) {
        checkRequiredFirebaseOptions(firebaseApp);
        FirebaseInstanceId firebaseInstanceId = (FirebaseInstanceId) firebaseApp.get(FirebaseInstanceId.class);
        gj1.l(firebaseInstanceId, "Firebase Instance ID component is not present");
        return firebaseInstanceId;
    }

    public Store.Token getTokenWithoutTriggeringSync(String str, String str2) {
        return store.getToken(getSubtype(), str, str2);
    }

    private yi4<InstanceIdResult> getInstanceId(String str, String str2) {
        return hd3.W0(null).k(this.fileIoExecutor, new FirebaseInstanceId$$Lambda$0(this, str, rationaliseScope(str2)));
    }

    @Deprecated
    public String getToken(String str, String str2) throws IOException {
        checkRequiredFirebaseOptions(this.f661app);
        if (Looper.getMainLooper() != Looper.myLooper()) {
            return ((InstanceIdResult) awaitTask(getInstanceId(str, str2))).getToken();
        }
        throw new IOException("MAIN_THREAD");
    }

    public FirebaseInstanceId(FirebaseApp firebaseApp, Provider<UserAgentPublisher> provider, Provider<HeartBeatInfo> provider2, FirebaseInstallationsApi firebaseInstallationsApi) {
        this(firebaseApp, new Metadata(firebaseApp.getApplicationContext()), FirebaseIidExecutors.newCachedSingleThreadExecutor(), FirebaseIidExecutors.newCachedSingleThreadExecutor(), provider, provider2, firebaseInstallationsApi);
    }
}
