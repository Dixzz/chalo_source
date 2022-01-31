package com.google.firebase;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.UserManager;
import android.text.TextUtils;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentDiscovery;
import com.google.firebase.components.ComponentDiscoveryService;
import com.google.firebase.components.ComponentRuntime;
import com.google.firebase.components.Lazy;
import com.google.firebase.events.Publisher;
import com.google.firebase.internal.DataCollectionConfigStorage;
import defpackage.k32;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.concurrent.GuardedBy;

public class FirebaseApp {
    public static final String DEFAULT_APP_NAME = "[DEFAULT]";
    private static final String FIREBASE_ANDROID = "fire-android";
    private static final String FIREBASE_COMMON = "fire-core";
    @GuardedBy("LOCK")
    public static final Map<String, FirebaseApp> INSTANCES = new n2();
    private static final String KOTLIN = "kotlin";
    private static final Object LOCK = new Object();
    private static final String LOG_TAG = "FirebaseApp";
    private static final Executor UI_EXECUTOR = new UiExecutor();
    private final Context applicationContext;
    private final AtomicBoolean automaticResourceManagementEnabled = new AtomicBoolean(false);
    private final List<BackgroundStateChangeListener> backgroundStateChangeListeners = new CopyOnWriteArrayList();
    private final ComponentRuntime componentRuntime;
    private final Lazy<DataCollectionConfigStorage> dataCollectionConfigStorage;
    private final AtomicBoolean deleted = new AtomicBoolean();
    private final List<FirebaseAppLifecycleListener> lifecycleListeners = new CopyOnWriteArrayList();
    private final String name;
    private final FirebaseOptions options;

    public interface BackgroundStateChangeListener {
        void onBackgroundStateChanged(boolean z);
    }

    @TargetApi(14)
    public static class GlobalBackgroundStateListener implements k32.a {
        private static AtomicReference<GlobalBackgroundStateListener> INSTANCE = new AtomicReference<>();

        private GlobalBackgroundStateListener() {
        }

        /* access modifiers changed from: private */
        public static void ensureBackgroundStateListenerRegistered(Context context) {
            if (context.getApplicationContext() instanceof Application) {
                Application application = (Application) context.getApplicationContext();
                if (INSTANCE.get() == null) {
                    GlobalBackgroundStateListener globalBackgroundStateListener = new GlobalBackgroundStateListener();
                    if (INSTANCE.compareAndSet(null, globalBackgroundStateListener)) {
                        k32.b(application);
                        k32.j.a(globalBackgroundStateListener);
                    }
                }
            }
        }

        @Override // defpackage.k32.a
        public void onBackgroundStateChanged(boolean z) {
            synchronized (FirebaseApp.LOCK) {
                Iterator it = new ArrayList(FirebaseApp.INSTANCES.values()).iterator();
                while (it.hasNext()) {
                    FirebaseApp firebaseApp = (FirebaseApp) it.next();
                    if (firebaseApp.automaticResourceManagementEnabled.get()) {
                        firebaseApp.notifyBackgroundStateChangeListeners(z);
                    }
                }
            }
        }
    }

    public static class UiExecutor implements Executor {
        private static final Handler HANDLER = new Handler(Looper.getMainLooper());

        private UiExecutor() {
        }

        public void execute(Runnable runnable) {
            HANDLER.post(runnable);
        }
    }

    @TargetApi(24)
    public static class UserUnlockReceiver extends BroadcastReceiver {
        private static AtomicReference<UserUnlockReceiver> INSTANCE = new AtomicReference<>();
        private final Context applicationContext;

        public UserUnlockReceiver(Context context) {
            this.applicationContext = context;
        }

        /* access modifiers changed from: private */
        public static void ensureReceiverRegistered(Context context) {
            if (INSTANCE.get() == null) {
                UserUnlockReceiver userUnlockReceiver = new UserUnlockReceiver(context);
                if (INSTANCE.compareAndSet(null, userUnlockReceiver)) {
                    context.registerReceiver(userUnlockReceiver, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                }
            }
        }

        public void onReceive(Context context, Intent intent) {
            synchronized (FirebaseApp.LOCK) {
                for (FirebaseApp firebaseApp : FirebaseApp.INSTANCES.values()) {
                    firebaseApp.initializeAllApis();
                }
            }
            unregister();
        }

        public void unregister() {
            this.applicationContext.unregisterReceiver(this);
        }
    }

    public FirebaseApp(Context context, String str, FirebaseOptions firebaseOptions) {
        Objects.requireNonNull(context, "null reference");
        this.applicationContext = context;
        gj1.j(str);
        this.name = str;
        Objects.requireNonNull(firebaseOptions, "null reference");
        this.options = firebaseOptions;
        this.componentRuntime = ComponentRuntime.builder(UI_EXECUTOR).addLazyComponentRegistrars(ComponentDiscovery.forContext(context, ComponentDiscoveryService.class).discoverLazy()).addComponentRegistrar(new FirebaseCommonRegistrar()).addComponent(Component.of(context, Context.class, new Class[0])).addComponent(Component.of(this, FirebaseApp.class, new Class[0])).addComponent(Component.of(firebaseOptions, FirebaseOptions.class, new Class[0])).build();
        this.dataCollectionConfigStorage = new Lazy<>(new hy4(this, context));
    }

    private void checkNotDeleted() {
        gj1.o(!this.deleted.get(), "FirebaseApp was deleted");
    }

    public static void clearInstancesForTest() {
        synchronized (LOCK) {
            INSTANCES.clear();
        }
    }

    private static List<String> getAllAppNames() {
        ArrayList arrayList = new ArrayList();
        synchronized (LOCK) {
            for (FirebaseApp firebaseApp : INSTANCES.values()) {
                arrayList.add(firebaseApp.getName());
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public static List<FirebaseApp> getApps(Context context) {
        ArrayList arrayList;
        synchronized (LOCK) {
            arrayList = new ArrayList(INSTANCES.values());
        }
        return arrayList;
    }

    public static FirebaseApp getInstance() {
        FirebaseApp firebaseApp;
        synchronized (LOCK) {
            firebaseApp = INSTANCES.get(DEFAULT_APP_NAME);
            if (firebaseApp == null) {
                throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + gb2.a() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
            }
        }
        return firebaseApp;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void initializeAllApis() {
        if (!(Build.VERSION.SDK_INT >= 24 ? ((UserManager) this.applicationContext.getSystemService(UserManager.class)).isUserUnlocked() : true)) {
            getName();
            UserUnlockReceiver.ensureReceiverRegistered(this.applicationContext);
            return;
        }
        getName();
        this.componentRuntime.initializeEagerComponents(isDefaultApp());
    }

    public static FirebaseApp initializeApp(Context context) {
        synchronized (LOCK) {
            if (INSTANCES.containsKey(DEFAULT_APP_NAME)) {
                return getInstance();
            }
            FirebaseOptions fromResource = FirebaseOptions.fromResource(context);
            if (fromResource == null) {
                return null;
            }
            return initializeApp(context, fromResource);
        }
    }

    private static String normalize(String str) {
        return str.trim();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void notifyBackgroundStateChangeListeners(boolean z) {
        for (BackgroundStateChangeListener backgroundStateChangeListener : this.backgroundStateChangeListeners) {
            backgroundStateChangeListener.onBackgroundStateChanged(z);
        }
    }

    private void notifyOnAppDeleted() {
        for (FirebaseAppLifecycleListener firebaseAppLifecycleListener : this.lifecycleListeners) {
            firebaseAppLifecycleListener.onDeleted(this.name, this.options);
        }
    }

    public /* synthetic */ DataCollectionConfigStorage a(Context context) {
        return new DataCollectionConfigStorage(context, getPersistenceKey(), (Publisher) this.componentRuntime.get(Publisher.class));
    }

    public void addBackgroundStateChangeListener(BackgroundStateChangeListener backgroundStateChangeListener) {
        checkNotDeleted();
        if (this.automaticResourceManagementEnabled.get() && k32.j.c()) {
            backgroundStateChangeListener.onBackgroundStateChanged(true);
        }
        this.backgroundStateChangeListeners.add(backgroundStateChangeListener);
    }

    public void addLifecycleEventListener(FirebaseAppLifecycleListener firebaseAppLifecycleListener) {
        checkNotDeleted();
        Objects.requireNonNull(firebaseAppLifecycleListener, "null reference");
        this.lifecycleListeners.add(firebaseAppLifecycleListener);
    }

    public void delete() {
        if (this.deleted.compareAndSet(false, true)) {
            synchronized (LOCK) {
                INSTANCES.remove(this.name);
            }
            notifyOnAppDeleted();
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FirebaseApp)) {
            return false;
        }
        return this.name.equals(((FirebaseApp) obj).getName());
    }

    public <T> T get(Class<T> cls) {
        checkNotDeleted();
        return (T) this.componentRuntime.get(cls);
    }

    public Context getApplicationContext() {
        checkNotDeleted();
        return this.applicationContext;
    }

    public String getName() {
        checkNotDeleted();
        return this.name;
    }

    public FirebaseOptions getOptions() {
        checkNotDeleted();
        return this.options;
    }

    public String getPersistenceKey() {
        return gj1.E(getName().getBytes(Charset.defaultCharset())) + "+" + gj1.E(getOptions().getApplicationId().getBytes(Charset.defaultCharset()));
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public void initializeAllComponents() {
        this.componentRuntime.initializeAllComponentsForTests();
    }

    public boolean isDataCollectionDefaultEnabled() {
        checkNotDeleted();
        return this.dataCollectionConfigStorage.get().isEnabled();
    }

    public boolean isDefaultApp() {
        return DEFAULT_APP_NAME.equals(getName());
    }

    public void removeBackgroundStateChangeListener(BackgroundStateChangeListener backgroundStateChangeListener) {
        checkNotDeleted();
        this.backgroundStateChangeListeners.remove(backgroundStateChangeListener);
    }

    public void removeLifecycleEventListener(FirebaseAppLifecycleListener firebaseAppLifecycleListener) {
        checkNotDeleted();
        Objects.requireNonNull(firebaseAppLifecycleListener, "null reference");
        this.lifecycleListeners.remove(firebaseAppLifecycleListener);
    }

    public void setAutomaticResourceManagementEnabled(boolean z) {
        checkNotDeleted();
        if (this.automaticResourceManagementEnabled.compareAndSet(!z, z)) {
            boolean c = k32.j.c();
            if (z && c) {
                notifyBackgroundStateChangeListeners(true);
            } else if (!z && c) {
                notifyBackgroundStateChangeListeners(false);
            }
        }
    }

    public void setDataCollectionDefaultEnabled(Boolean bool) {
        checkNotDeleted();
        this.dataCollectionConfigStorage.get().setEnabled(bool);
    }

    public String toString() {
        g82 g82 = new g82(this);
        g82.a("name", this.name);
        g82.a("options", this.options);
        return g82.toString();
    }

    @Deprecated
    public void setDataCollectionDefaultEnabled(boolean z) {
        setDataCollectionDefaultEnabled(Boolean.valueOf(z));
    }

    public static String getPersistenceKey(String str, FirebaseOptions firebaseOptions) {
        return gj1.E(str.getBytes(Charset.defaultCharset())) + "+" + gj1.E(firebaseOptions.getApplicationId().getBytes(Charset.defaultCharset()));
    }

    public static FirebaseApp getInstance(String str) {
        FirebaseApp firebaseApp;
        String str2;
        synchronized (LOCK) {
            firebaseApp = INSTANCES.get(normalize(str));
            if (firebaseApp == null) {
                List<String> allAppNames = getAllAppNames();
                if (allAppNames.isEmpty()) {
                    str2 = "";
                } else {
                    str2 = "Available app names: " + TextUtils.join(", ", allAppNames);
                }
                throw new IllegalStateException(String.format("FirebaseApp with name %s doesn't exist. %s", str, str2));
            }
        }
        return firebaseApp;
    }

    public static FirebaseApp initializeApp(Context context, FirebaseOptions firebaseOptions) {
        return initializeApp(context, firebaseOptions, DEFAULT_APP_NAME);
    }

    public static FirebaseApp initializeApp(Context context, FirebaseOptions firebaseOptions, String str) {
        FirebaseApp firebaseApp;
        GlobalBackgroundStateListener.ensureBackgroundStateListenerRegistered(context);
        String normalize = normalize(str);
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (LOCK) {
            Map<String, FirebaseApp> map = INSTANCES;
            boolean z = !map.containsKey(normalize);
            gj1.o(z, "FirebaseApp name " + normalize + " already exists!");
            gj1.l(context, "Application context cannot be null.");
            firebaseApp = new FirebaseApp(context, normalize, firebaseOptions);
            map.put(normalize, firebaseApp);
        }
        firebaseApp.initializeAllApis();
        return firebaseApp;
    }
}
