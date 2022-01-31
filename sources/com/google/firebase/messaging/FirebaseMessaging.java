package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.crashlytics.internal.settings.SettingsJsonConstants;
import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.events.Subscriber;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.messaging.Store;
import com.google.firebase.platforminfo.UserAgentPublisher;
import com.razorpay.AnalyticsConstants;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
public class FirebaseMessaging {
    @Deprecated
    public static final String INSTANCE_ID_SCOPE = "FCM";
    private static final long MAX_DELAY_SEC = TimeUnit.HOURS.toSeconds(8);
    @SuppressLint({"StaticFieldLeak"})
    private static Store store;
    @GuardedBy("FirebaseMessaging.class")
    public static ScheduledExecutorService syncExecutor;
    @SuppressLint({"FirebaseUnknownNullness"})
    public static eu1 transportFactory;
    private final AutoInit autoInit;
    private final Context context;
    private final Executor fileIoExecutor;
    private final FirebaseApp firebaseApp;
    private final FirebaseInstallationsApi fis;
    private final GmsRpc gmsRpc;
    private final FirebaseInstanceIdInternal iid;
    private final Application.ActivityLifecycleCallbacks lifecycleCallbacks;
    private final Metadata metadata;
    private final RequestDeduplicator requestDeduplicator;
    @GuardedBy("this")
    private boolean syncScheduledOrRunning;
    private final Executor taskExecutor;
    private final yi4<TopicsSubscriber> topicsSubscriberTask;

    /* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
    public class AutoInit {
        @GuardedBy("this")
        private Boolean autoInitEnabled;
        @GuardedBy("this")
        private EventHandler<DataCollectionDefaultChange> dataCollectionDefaultChangeEventHandler;
        @GuardedBy("this")
        private boolean initialized;
        private final Subscriber subscriber;

        public AutoInit(Subscriber subscriber2) {
            this.subscriber = subscriber2;
        }

        private Boolean readEnabled() {
            ApplicationInfo applicationInfo;
            Bundle bundle;
            Context applicationContext = FirebaseMessaging.this.firebaseApp.getApplicationContext();
            SharedPreferences sharedPreferences = applicationContext.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains("auto_init")) {
                return Boolean.valueOf(sharedPreferences.getBoolean("auto_init", false));
            }
            try {
                PackageManager packageManager = applicationContext.getPackageManager();
                if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(applicationContext.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_messaging_auto_init_enabled")) {
                    return null;
                }
                return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled"));
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }

        public synchronized void initialize() {
            if (!this.initialized) {
                Boolean readEnabled = readEnabled();
                this.autoInitEnabled = readEnabled;
                if (readEnabled == null) {
                    FirebaseMessaging$AutoInit$$Lambda$0 firebaseMessaging$AutoInit$$Lambda$0 = new FirebaseMessaging$AutoInit$$Lambda$0(this);
                    this.dataCollectionDefaultChangeEventHandler = firebaseMessaging$AutoInit$$Lambda$0;
                    this.subscriber.subscribe(DataCollectionDefaultChange.class, firebaseMessaging$AutoInit$$Lambda$0);
                }
                this.initialized = true;
            }
        }

        public synchronized boolean isEnabled() {
            boolean z;
            initialize();
            Boolean bool = this.autoInitEnabled;
            if (bool != null) {
                z = bool.booleanValue();
            } else {
                z = FirebaseMessaging.this.firebaseApp.isDataCollectionDefaultEnabled();
            }
            return z;
        }

        public final /* synthetic */ void lambda$initialize$0$FirebaseMessaging$AutoInit(Event event) {
            if (isEnabled()) {
                FirebaseMessaging.this.startSyncIfNecessary();
            }
        }

        public synchronized void setEnabled(boolean z) {
            initialize();
            EventHandler<DataCollectionDefaultChange> eventHandler = this.dataCollectionDefaultChangeEventHandler;
            if (eventHandler != null) {
                this.subscriber.unsubscribe(DataCollectionDefaultChange.class, eventHandler);
                this.dataCollectionDefaultChangeEventHandler = null;
            }
            SharedPreferences.Editor edit = FirebaseMessaging.this.firebaseApp.getApplicationContext().getSharedPreferences("com.google.firebase.messaging", 0).edit();
            edit.putBoolean("auto_init", z);
            edit.apply();
            if (z) {
                FirebaseMessaging.this.startSyncIfNecessary();
            }
            this.autoInitEnabled = Boolean.valueOf(z);
        }
    }

    public FirebaseMessaging(FirebaseApp firebaseApp2, FirebaseInstanceIdInternal firebaseInstanceIdInternal, Provider<UserAgentPublisher> provider, Provider<HeartBeatInfo> provider2, FirebaseInstallationsApi firebaseInstallationsApi, eu1 eu1, Subscriber subscriber) {
        this(firebaseApp2, firebaseInstanceIdInternal, provider, provider2, firebaseInstallationsApi, eu1, subscriber, new Metadata(firebaseApp2.getApplicationContext()));
    }

    public static synchronized FirebaseMessaging getInstance() {
        FirebaseMessaging instance;
        synchronized (FirebaseMessaging.class) {
            instance = getInstance(FirebaseApp.getInstance());
        }
        return instance;
    }

    private String getSubtype() {
        if (FirebaseApp.DEFAULT_APP_NAME.equals(this.firebaseApp.getName())) {
            return "";
        }
        return this.firebaseApp.getPersistenceKey();
    }

    public static eu1 getTransportFactory() {
        return transportFactory;
    }

    /* access modifiers changed from: private */
    /* renamed from: invokeOnTokenRefresh */
    public void bridge$lambda$0$FirebaseMessaging(String str) {
        if (FirebaseApp.DEFAULT_APP_NAME.equals(this.firebaseApp.getName())) {
            if (Log.isLoggable(Constants.TAG, 3)) {
                String valueOf = String.valueOf(this.firebaseApp.getName());
                if (valueOf.length() != 0) {
                    "Invoking onNewToken for app: ".concat(valueOf);
                } else {
                    new String("Invoking onNewToken for app: ");
                }
            }
            Intent intent = new Intent("com.google.firebase.messaging.NEW_TOKEN");
            intent.putExtra(AnalyticsConstants.TOKEN, str);
            new FcmBroadcastProcessor(this.context).process(intent);
        }
    }

    private synchronized void startSync() {
        if (!this.syncScheduledOrRunning) {
            syncWithDelaySecondsInternal(0);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void startSyncIfNecessary() {
        FirebaseInstanceIdInternal firebaseInstanceIdInternal = this.iid;
        if (firebaseInstanceIdInternal != null) {
            firebaseInstanceIdInternal.getToken();
        } else if (tokenNeedsRefresh(getTokenWithoutTriggeringSync())) {
            startSync();
        }
    }

    public String blockingGetToken() throws IOException {
        FirebaseInstanceIdInternal firebaseInstanceIdInternal = this.iid;
        if (firebaseInstanceIdInternal != null) {
            try {
                return (String) hd3.u(firebaseInstanceIdInternal.getTokenTask());
            } catch (InterruptedException | ExecutionException e) {
                throw new IOException(e);
            }
        } else {
            Store.Token tokenWithoutTriggeringSync = getTokenWithoutTriggeringSync();
            if (!tokenNeedsRefresh(tokenWithoutTriggeringSync)) {
                return tokenWithoutTriggeringSync.token;
            }
            String defaultSenderId = Metadata.getDefaultSenderId(this.firebaseApp);
            try {
                String str = (String) hd3.u(this.fis.getId().k(FcmExecutors.newNetworkIOExecutor(), new FirebaseMessaging$$Lambda$8(this, defaultSenderId)));
                store.saveToken(getSubtype(), defaultSenderId, str, this.metadata.getAppVersionCode());
                if (tokenWithoutTriggeringSync == null || !str.equals(tokenWithoutTriggeringSync.token)) {
                    bridge$lambda$0$FirebaseMessaging(str);
                }
                return str;
            } catch (InterruptedException | ExecutionException e2) {
                throw new IOException(e2);
            }
        }
    }

    public yi4<Void> deleteToken() {
        if (this.iid != null) {
            zi4 zi4 = new zi4();
            this.fileIoExecutor.execute(new FirebaseMessaging$$Lambda$4(this, zi4));
            return zi4.f4178a;
        } else if (getTokenWithoutTriggeringSync() == null) {
            return hd3.W0(null);
        } else {
            ExecutorService newNetworkIOExecutor = FcmExecutors.newNetworkIOExecutor();
            return this.fis.getId().k(newNetworkIOExecutor, new FirebaseMessaging$$Lambda$5(this, newNetworkIOExecutor));
        }
    }

    public boolean deliveryMetricsExportToBigQueryEnabled() {
        return MessagingAnalytics.deliveryMetricsExportToBigQueryEnabled();
    }

    public void enqueueTaskWithDelaySeconds(Runnable runnable, long j) {
        synchronized (FirebaseMessaging.class) {
            if (syncExecutor == null) {
                syncExecutor = new ScheduledThreadPoolExecutor(1, new jb2("TAG"));
            }
            syncExecutor.schedule(runnable, j, TimeUnit.SECONDS);
        }
    }

    public Context getApplicationContext() {
        return this.context;
    }

    public yi4<String> getToken() {
        FirebaseInstanceIdInternal firebaseInstanceIdInternal = this.iid;
        if (firebaseInstanceIdInternal != null) {
            return firebaseInstanceIdInternal.getTokenTask();
        }
        zi4 zi4 = new zi4();
        this.fileIoExecutor.execute(new FirebaseMessaging$$Lambda$3(this, zi4));
        return zi4.f4178a;
    }

    public Store.Token getTokenWithoutTriggeringSync() {
        return store.getToken(getSubtype(), Metadata.getDefaultSenderId(this.firebaseApp));
    }

    public boolean isAutoInitEnabled() {
        return this.autoInit.isEnabled();
    }

    public boolean isGmsCorePresent() {
        return this.metadata.isGmscorePresent();
    }

    public final /* synthetic */ yi4 lambda$blockingGetToken$8$FirebaseMessaging(yi4 yi4) {
        return this.gmsRpc.getToken((String) yi4.m());
    }

    public final /* synthetic */ yi4 lambda$blockingGetToken$9$FirebaseMessaging(String str, yi4 yi4) throws Exception {
        return this.requestDeduplicator.getOrStartGetTokenRequest(str, new FirebaseMessaging$$Lambda$9(this, yi4));
    }

    public final void lambda$deleteToken$3$FirebaseMessaging(zi4 zi4) {
        try {
            this.iid.deleteToken(Metadata.getDefaultSenderId(this.firebaseApp), INSTANCE_ID_SCOPE);
            zi4.f4178a.t(null);
        } catch (Exception e) {
            zi4.f4178a.u(e);
        }
    }

    public final /* synthetic */ Void lambda$deleteToken$4$FirebaseMessaging(yi4 yi4) throws Exception {
        store.deleteToken(getSubtype(), Metadata.getDefaultSenderId(this.firebaseApp));
        return null;
    }

    public final /* synthetic */ yi4 lambda$deleteToken$5$FirebaseMessaging(ExecutorService executorService, yi4 yi4) throws Exception {
        return this.gmsRpc.deleteToken((String) yi4.m()).i(executorService, new FirebaseMessaging$$Lambda$10(this));
    }

    public final void lambda$getToken$2$FirebaseMessaging(zi4 zi4) {
        try {
            zi4.f4178a.t(blockingGetToken());
        } catch (Exception e) {
            zi4.f4178a.u(e);
        }
    }

    public final /* synthetic */ void lambda$new$0$FirebaseMessaging() {
        if (isAutoInitEnabled()) {
            startSyncIfNecessary();
        }
    }

    public final /* synthetic */ void lambda$new$1$FirebaseMessaging(TopicsSubscriber topicsSubscriber) {
        if (isAutoInitEnabled()) {
            topicsSubscriber.startTopicsSyncIfNecessary();
        }
    }

    public void send(RemoteMessage remoteMessage) {
        if (!TextUtils.isEmpty(remoteMessage.getTo())) {
            Intent intent = new Intent("com.google.android.gcm.intent.SEND");
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            intent.putExtra(SettingsJsonConstants.APP_KEY, PendingIntent.getBroadcast(this.context, 0, intent2, Build.VERSION.SDK_INT >= 23 ? 67108864 : 0));
            intent.setPackage("com.google.android.gms");
            remoteMessage.populateSendMessageIntent(intent);
            this.context.sendOrderedBroadcast(intent, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
            return;
        }
        throw new IllegalArgumentException("Missing 'to'");
    }

    public void setAutoInitEnabled(boolean z) {
        this.autoInit.setEnabled(z);
    }

    public void setDeliveryMetricsExportToBigQuery(boolean z) {
        MessagingAnalytics.setDeliveryMetricsExportToBigQuery(z);
    }

    public synchronized void setSyncScheduledOrRunning(boolean z) {
        this.syncScheduledOrRunning = z;
    }

    public yi4<Void> subscribeToTopic(String str) {
        return this.topicsSubscriberTask.r(new FirebaseMessaging$$Lambda$6(str));
    }

    public synchronized void syncWithDelaySecondsInternal(long j) {
        enqueueTaskWithDelaySeconds(new SyncTask(this, Math.min(Math.max(30L, j + j), MAX_DELAY_SEC)), j);
        this.syncScheduledOrRunning = true;
    }

    public boolean tokenNeedsRefresh(Store.Token token) {
        return token == null || token.needsRefresh(this.metadata.getAppVersionCode());
    }

    public yi4<Void> unsubscribeFromTopic(String str) {
        return this.topicsSubscriberTask.r(new FirebaseMessaging$$Lambda$7(str));
    }

    @Keep
    public static synchronized FirebaseMessaging getInstance(FirebaseApp firebaseApp2) {
        FirebaseMessaging firebaseMessaging;
        synchronized (FirebaseMessaging.class) {
            firebaseMessaging = (FirebaseMessaging) firebaseApp2.get(FirebaseMessaging.class);
            gj1.l(firebaseMessaging, "Firebase Messaging component is not present");
        }
        return firebaseMessaging;
    }

    public FirebaseMessaging(FirebaseApp firebaseApp2, FirebaseInstanceIdInternal firebaseInstanceIdInternal, Provider<UserAgentPublisher> provider, Provider<HeartBeatInfo> provider2, FirebaseInstallationsApi firebaseInstallationsApi, eu1 eu1, Subscriber subscriber, Metadata metadata2) {
        this(firebaseApp2, firebaseInstanceIdInternal, firebaseInstallationsApi, eu1, subscriber, metadata2, new GmsRpc(firebaseApp2, metadata2, provider, provider2, firebaseInstallationsApi), FcmExecutors.newTaskExecutor(), FcmExecutors.newInitExecutor());
    }

    public FirebaseMessaging(FirebaseApp firebaseApp2, FirebaseInstanceIdInternal firebaseInstanceIdInternal, FirebaseInstallationsApi firebaseInstallationsApi, eu1 eu1, Subscriber subscriber, Metadata metadata2, GmsRpc gmsRpc2, Executor executor, Executor executor2) {
        this.syncScheduledOrRunning = false;
        transportFactory = eu1;
        this.firebaseApp = firebaseApp2;
        this.iid = firebaseInstanceIdInternal;
        this.fis = firebaseInstallationsApi;
        this.autoInit = new AutoInit(subscriber);
        Context applicationContext = firebaseApp2.getApplicationContext();
        this.context = applicationContext;
        FcmLifecycleCallbacks fcmLifecycleCallbacks = new FcmLifecycleCallbacks();
        this.lifecycleCallbacks = fcmLifecycleCallbacks;
        this.metadata = metadata2;
        this.taskExecutor = executor;
        this.gmsRpc = gmsRpc2;
        this.requestDeduplicator = new RequestDeduplicator(executor);
        this.fileIoExecutor = executor2;
        Context applicationContext2 = firebaseApp2.getApplicationContext();
        if (applicationContext2 instanceof Application) {
            ((Application) applicationContext2).registerActivityLifecycleCallbacks(fcmLifecycleCallbacks);
        } else {
            String.valueOf(applicationContext2).length();
        }
        if (firebaseInstanceIdInternal != null) {
            firebaseInstanceIdInternal.addNewTokenListener(new FirebaseMessaging$$Lambda$0(this));
        }
        synchronized (FirebaseMessaging.class) {
            if (store == null) {
                store = new Store(applicationContext);
            }
        }
        executor2.execute(new FirebaseMessaging$$Lambda$1(this));
        yi4<TopicsSubscriber> createInstance = TopicsSubscriber.createInstance(this, firebaseInstallationsApi, metadata2, gmsRpc2, applicationContext, FcmExecutors.newTopicsSyncExecutor());
        this.topicsSubscriberTask = createInstance;
        createInstance.g(FcmExecutors.newTopicsSyncTriggerExecutor(), new FirebaseMessaging$$Lambda$2(this));
    }
}
