package com.google.firebase.installations;

import android.text.TextUtils;
import com.google.firebase.FirebaseApp;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsException;
import com.google.firebase.installations.internal.FidListener;
import com.google.firebase.installations.internal.FidListenerHandle;
import com.google.firebase.installations.local.IidStore;
import com.google.firebase.installations.local.PersistedInstallation;
import com.google.firebase.installations.local.PersistedInstallationEntry;
import com.google.firebase.installations.remote.FirebaseInstallationServiceClient;
import com.google.firebase.installations.remote.InstallationResponse;
import com.google.firebase.installations.remote.TokenResult;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class FirebaseInstallations implements FirebaseInstallationsApi {
    private static final String API_KEY_VALIDATION_MSG = "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.";
    private static final String APP_ID_VALIDATION_MSG = "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.";
    private static final String AUTH_ERROR_MSG = "Installation ID could not be validated with the Firebase servers (maybe it was deleted). Firebase Installations will need to create a new Installation ID and auth token. Please retry your last request.";
    private static final String CHIME_FIREBASE_APP_NAME = "CHIME_ANDROID_SDK";
    private static final int CORE_POOL_SIZE = 0;
    private static final long KEEP_ALIVE_TIME_IN_SECONDS = 30;
    private static final String LOCKFILE_NAME_GENERATE_FID = "generatefid.lock";
    private static final int MAXIMUM_POOL_SIZE = 1;
    private static final String PROJECT_ID_VALIDATION_MSG = "Please set your Project ID. A valid Firebase Project ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.";
    private static final ThreadFactory THREAD_FACTORY = new ThreadFactory() {
        /* class com.google.firebase.installations.FirebaseInstallations.AnonymousClass1 */
        private final AtomicInteger mCount = new AtomicInteger(1);

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, String.format("firebase-installations-executor-%d", Integer.valueOf(this.mCount.getAndIncrement())));
        }
    };
    private static final Object lockGenerateFid = new Object();
    private final ExecutorService backgroundExecutor;
    private String cachedFid;
    private final RandomFidGenerator fidGenerator;
    private Set<FidListener> fidListeners;
    private final FirebaseApp firebaseApp;
    private final IidStore iidStore;
    private final List<StateListener> listeners;
    private final Object lock;
    private final ExecutorService networkExecutor;
    private final PersistedInstallation persistedInstallation;
    private final FirebaseInstallationServiceClient serviceClient;
    private final Utils utils;

    /* renamed from: com.google.firebase.installations.FirebaseInstallations$3  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$firebase$installations$remote$InstallationResponse$ResponseCode;
        public static final /* synthetic */ int[] $SwitchMap$com$google$firebase$installations$remote$TokenResult$ResponseCode;

        /* JADX WARNING: Can't wrap try/catch for region: R(13:0|(2:1|2)|3|5|6|7|8|9|11|12|13|14|16) */
        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|5|6|7|8|9|11|12|13|14|16) */
        /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0026 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0015 */
        static {
            /*
                com.google.firebase.installations.remote.TokenResult.ResponseCode.values()
                r0 = 3
                int[] r1 = new int[r0]
                com.google.firebase.installations.FirebaseInstallations.AnonymousClass3.$SwitchMap$com$google$firebase$installations$remote$TokenResult$ResponseCode = r1
                r2 = 0
                r3 = 1
                com.google.firebase.installations.remote.TokenResult$ResponseCode r4 = com.google.firebase.installations.remote.TokenResult.ResponseCode.OK     // Catch:{ NoSuchFieldError -> 0x000e }
                r1[r2] = r3     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                r1 = 2
                int[] r4 = com.google.firebase.installations.FirebaseInstallations.AnonymousClass3.$SwitchMap$com$google$firebase$installations$remote$TokenResult$ResponseCode     // Catch:{ NoSuchFieldError -> 0x0015 }
                com.google.firebase.installations.remote.TokenResult$ResponseCode r5 = com.google.firebase.installations.remote.TokenResult.ResponseCode.BAD_CONFIG     // Catch:{ NoSuchFieldError -> 0x0015 }
                r4[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0015 }
            L_0x0015:
                int[] r4 = com.google.firebase.installations.FirebaseInstallations.AnonymousClass3.$SwitchMap$com$google$firebase$installations$remote$TokenResult$ResponseCode     // Catch:{ NoSuchFieldError -> 0x001b }
                com.google.firebase.installations.remote.TokenResult$ResponseCode r5 = com.google.firebase.installations.remote.TokenResult.ResponseCode.AUTH_ERROR     // Catch:{ NoSuchFieldError -> 0x001b }
                r4[r1] = r0     // Catch:{ NoSuchFieldError -> 0x001b }
            L_0x001b:
                com.google.firebase.installations.remote.InstallationResponse.ResponseCode.values()
                int[] r0 = new int[r1]
                com.google.firebase.installations.FirebaseInstallations.AnonymousClass3.$SwitchMap$com$google$firebase$installations$remote$InstallationResponse$ResponseCode = r0
                com.google.firebase.installations.remote.InstallationResponse$ResponseCode r4 = com.google.firebase.installations.remote.InstallationResponse.ResponseCode.OK     // Catch:{ NoSuchFieldError -> 0x0026 }
                r0[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0026 }
            L_0x0026:
                int[] r0 = com.google.firebase.installations.FirebaseInstallations.AnonymousClass3.$SwitchMap$com$google$firebase$installations$remote$InstallationResponse$ResponseCode     // Catch:{ NoSuchFieldError -> 0x002c }
                com.google.firebase.installations.remote.InstallationResponse$ResponseCode r2 = com.google.firebase.installations.remote.InstallationResponse.ResponseCode.BAD_CONFIG     // Catch:{ NoSuchFieldError -> 0x002c }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002c }
            L_0x002c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.FirebaseInstallations.AnonymousClass3.<clinit>():void");
        }
    }

    public FirebaseInstallations(FirebaseApp firebaseApp2, Provider<UserAgentPublisher> provider, Provider<HeartBeatInfo> provider2) {
        this(new ThreadPoolExecutor(0, 1, (long) KEEP_ALIVE_TIME_IN_SECONDS, TimeUnit.SECONDS, new LinkedBlockingQueue(), THREAD_FACTORY), firebaseApp2, new FirebaseInstallationServiceClient(firebaseApp2.getApplicationContext(), provider, provider2), new PersistedInstallation(firebaseApp2), Utils.getInstance(), new IidStore(firebaseApp2), new RandomFidGenerator());
    }

    private yi4<InstallationTokenResult> addGetAuthTokenListener() {
        zi4 zi4 = new zi4();
        addStateListeners(new GetAuthTokenListener(this.utils, zi4));
        return zi4.f4178a;
    }

    private yi4<String> addGetIdListener() {
        zi4 zi4 = new zi4();
        addStateListeners(new GetIdListener(zi4));
        return zi4.f4178a;
    }

    private void addStateListeners(StateListener stateListener) {
        synchronized (this.lock) {
            this.listeners.add(stateListener);
        }
    }

    /* access modifiers changed from: private */
    public Void deleteFirebaseInstallationId() throws FirebaseInstallationsException {
        updateCacheFid(null);
        PersistedInstallationEntry multiProcessSafePrefs = getMultiProcessSafePrefs();
        if (multiProcessSafePrefs.isRegistered()) {
            this.serviceClient.deleteFirebaseInstallation(getApiKey(), multiProcessSafePrefs.getFirebaseInstallationId(), getProjectIdentifier(), multiProcessSafePrefs.getRefreshToken());
        }
        insertOrUpdatePrefs(multiProcessSafePrefs.withNoGeneratedFid());
        return null;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004a  */
    /* renamed from: doNetworkCallIfNecessary */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(boolean r3) {
        /*
            r2 = this;
            com.google.firebase.installations.local.PersistedInstallationEntry r0 = r2.getMultiProcessSafePrefs()
            boolean r1 = r0.isErrored()     // Catch:{ FirebaseInstallationsException -> 0x005f }
            if (r1 != 0) goto L_0x0022
            boolean r1 = r0.isUnregistered()     // Catch:{ FirebaseInstallationsException -> 0x005f }
            if (r1 == 0) goto L_0x0011
            goto L_0x0022
        L_0x0011:
            if (r3 != 0) goto L_0x001d
            com.google.firebase.installations.Utils r3 = r2.utils     // Catch:{ FirebaseInstallationsException -> 0x005f }
            boolean r3 = r3.isAuthTokenExpired(r0)     // Catch:{ FirebaseInstallationsException -> 0x005f }
            if (r3 == 0) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            return
        L_0x001d:
            com.google.firebase.installations.local.PersistedInstallationEntry r3 = r2.fetchAuthTokenFromServer(r0)     // Catch:{ FirebaseInstallationsException -> 0x005f }
            goto L_0x0026
        L_0x0022:
            com.google.firebase.installations.local.PersistedInstallationEntry r3 = r2.registerFidWithServer(r0)     // Catch:{ FirebaseInstallationsException -> 0x005f }
        L_0x0026:
            r2.insertOrUpdatePrefs(r3)
            r2.updateFidListener(r0, r3)
            boolean r0 = r3.isRegistered()
            if (r0 == 0) goto L_0x0039
            java.lang.String r0 = r3.getFirebaseInstallationId()
            r2.updateCacheFid(r0)
        L_0x0039:
            boolean r0 = r3.isErrored()
            if (r0 == 0) goto L_0x004a
            com.google.firebase.installations.FirebaseInstallationsException r3 = new com.google.firebase.installations.FirebaseInstallationsException
            com.google.firebase.installations.FirebaseInstallationsException$Status r0 = com.google.firebase.installations.FirebaseInstallationsException.Status.BAD_CONFIG
            r3.<init>(r0)
            r2.triggerOnException(r3)
            goto L_0x005e
        L_0x004a:
            boolean r0 = r3.isNotGenerated()
            if (r0 == 0) goto L_0x005b
            java.io.IOException r3 = new java.io.IOException
            java.lang.String r0 = "Installation ID could not be validated with the Firebase servers (maybe it was deleted). Firebase Installations will need to create a new Installation ID and auth token. Please retry your last request."
            r3.<init>(r0)
            r2.triggerOnException(r3)
            goto L_0x005e
        L_0x005b:
            r2.triggerOnStateReached(r3)
        L_0x005e:
            return
        L_0x005f:
            r3 = move-exception
            r2.triggerOnException(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.FirebaseInstallations.a(boolean):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: doRegistrationOrRefresh */
    public final void c(boolean z) {
        PersistedInstallationEntry prefsWithGeneratedIdMultiProcessSafe = getPrefsWithGeneratedIdMultiProcessSafe();
        if (z) {
            prefsWithGeneratedIdMultiProcessSafe = prefsWithGeneratedIdMultiProcessSafe.withClearedAuthToken();
        }
        triggerOnStateReached(prefsWithGeneratedIdMultiProcessSafe);
        this.networkExecutor.execute(new jz4(this, z));
    }

    private PersistedInstallationEntry fetchAuthTokenFromServer(PersistedInstallationEntry persistedInstallationEntry) throws FirebaseInstallationsException {
        TokenResult generateAuthToken = this.serviceClient.generateAuthToken(getApiKey(), persistedInstallationEntry.getFirebaseInstallationId(), getProjectIdentifier(), persistedInstallationEntry.getRefreshToken());
        int ordinal = generateAuthToken.getResponseCode().ordinal();
        if (ordinal == 0) {
            return persistedInstallationEntry.withAuthToken(generateAuthToken.getToken(), generateAuthToken.getTokenExpirationTimestamp(), this.utils.currentTimeInSecs());
        }
        if (ordinal == 1) {
            return persistedInstallationEntry.withFisError("BAD CONFIG");
        }
        if (ordinal == 2) {
            updateCacheFid(null);
            return persistedInstallationEntry.withNoGeneratedFid();
        }
        throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
    }

    private synchronized String getCacheFid() {
        return this.cachedFid;
    }

    public static FirebaseInstallations getInstance() {
        return getInstance(FirebaseApp.getInstance());
    }

    private PersistedInstallationEntry getMultiProcessSafePrefs() {
        PersistedInstallationEntry readPersistedInstallationEntryValue;
        synchronized (lockGenerateFid) {
            CrossProcessLock acquire = CrossProcessLock.acquire(this.firebaseApp.getApplicationContext(), LOCKFILE_NAME_GENERATE_FID);
            try {
                readPersistedInstallationEntryValue = this.persistedInstallation.readPersistedInstallationEntryValue();
            } finally {
                if (acquire != null) {
                    acquire.releaseAndClose();
                }
            }
        }
        return readPersistedInstallationEntryValue;
    }

    private PersistedInstallationEntry getPrefsWithGeneratedIdMultiProcessSafe() {
        PersistedInstallationEntry readPersistedInstallationEntryValue;
        synchronized (lockGenerateFid) {
            CrossProcessLock acquire = CrossProcessLock.acquire(this.firebaseApp.getApplicationContext(), LOCKFILE_NAME_GENERATE_FID);
            try {
                readPersistedInstallationEntryValue = this.persistedInstallation.readPersistedInstallationEntryValue();
                if (readPersistedInstallationEntryValue.isNotGenerated()) {
                    readPersistedInstallationEntryValue = this.persistedInstallation.insertOrUpdatePersistedInstallationEntry(readPersistedInstallationEntryValue.withUnregisteredFid(readExistingIidOrCreateFid(readPersistedInstallationEntryValue)));
                }
            } finally {
                if (acquire != null) {
                    acquire.releaseAndClose();
                }
            }
        }
        return readPersistedInstallationEntryValue;
    }

    private void insertOrUpdatePrefs(PersistedInstallationEntry persistedInstallationEntry) {
        synchronized (lockGenerateFid) {
            CrossProcessLock acquire = CrossProcessLock.acquire(this.firebaseApp.getApplicationContext(), LOCKFILE_NAME_GENERATE_FID);
            try {
                this.persistedInstallation.insertOrUpdatePersistedInstallationEntry(persistedInstallationEntry);
            } finally {
                if (acquire != null) {
                    acquire.releaseAndClose();
                }
            }
        }
    }

    private void preConditionChecks() {
        gj1.i(getApplicationId(), APP_ID_VALIDATION_MSG);
        gj1.i(getProjectIdentifier(), PROJECT_ID_VALIDATION_MSG);
        gj1.i(getApiKey(), API_KEY_VALIDATION_MSG);
        gj1.c(Utils.isValidAppIdFormat(getApplicationId()), APP_ID_VALIDATION_MSG);
        gj1.c(Utils.isValidApiKeyFormat(getApiKey()), API_KEY_VALIDATION_MSG);
    }

    private String readExistingIidOrCreateFid(PersistedInstallationEntry persistedInstallationEntry) {
        if ((!this.firebaseApp.getName().equals(CHIME_FIREBASE_APP_NAME) && !this.firebaseApp.isDefaultApp()) || !persistedInstallationEntry.shouldAttemptMigration()) {
            return this.fidGenerator.createRandomFid();
        }
        String readIid = this.iidStore.readIid();
        return TextUtils.isEmpty(readIid) ? this.fidGenerator.createRandomFid() : readIid;
    }

    private PersistedInstallationEntry registerFidWithServer(PersistedInstallationEntry persistedInstallationEntry) throws FirebaseInstallationsException {
        InstallationResponse createFirebaseInstallation = this.serviceClient.createFirebaseInstallation(getApiKey(), persistedInstallationEntry.getFirebaseInstallationId(), getProjectIdentifier(), getApplicationId(), (persistedInstallationEntry.getFirebaseInstallationId() == null || persistedInstallationEntry.getFirebaseInstallationId().length() != 11) ? null : this.iidStore.readToken());
        int ordinal = createFirebaseInstallation.getResponseCode().ordinal();
        if (ordinal == 0) {
            return persistedInstallationEntry.withRegisteredFid(createFirebaseInstallation.getFid(), createFirebaseInstallation.getRefreshToken(), this.utils.currentTimeInSecs(), createFirebaseInstallation.getAuthToken().getToken(), createFirebaseInstallation.getAuthToken().getTokenExpirationTimestamp());
        }
        if (ordinal == 1) {
            return persistedInstallationEntry.withFisError("BAD CONFIG");
        }
        throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
    }

    private void triggerOnException(Exception exc) {
        synchronized (this.lock) {
            Iterator<StateListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                if (it.next().onException(exc)) {
                    it.remove();
                }
            }
        }
    }

    private void triggerOnStateReached(PersistedInstallationEntry persistedInstallationEntry) {
        synchronized (this.lock) {
            Iterator<StateListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                if (it.next().onStateReached(persistedInstallationEntry)) {
                    it.remove();
                }
            }
        }
    }

    private synchronized void updateCacheFid(String str) {
        this.cachedFid = str;
    }

    private synchronized void updateFidListener(PersistedInstallationEntry persistedInstallationEntry, PersistedInstallationEntry persistedInstallationEntry2) {
        if (this.fidListeners.size() != 0 && !persistedInstallationEntry.getFirebaseInstallationId().equals(persistedInstallationEntry2.getFirebaseInstallationId())) {
            for (FidListener fidListener : this.fidListeners) {
                fidListener.onFidChanged(persistedInstallationEntry2.getFirebaseInstallationId());
            }
        }
    }

    public /* synthetic */ void b() {
        c(false);
    }

    @Override // com.google.firebase.installations.FirebaseInstallationsApi
    public yi4<Void> delete() {
        return hd3.A(this.backgroundExecutor, new mz4(this));
    }

    public String getApiKey() {
        return this.firebaseApp.getOptions().getApiKey();
    }

    public String getApplicationId() {
        return this.firebaseApp.getOptions().getApplicationId();
    }

    @Override // com.google.firebase.installations.FirebaseInstallationsApi
    public yi4<String> getId() {
        preConditionChecks();
        String cacheFid = getCacheFid();
        if (cacheFid != null) {
            return hd3.W0(cacheFid);
        }
        yi4<String> addGetIdListener = addGetIdListener();
        this.backgroundExecutor.execute(new kz4(this));
        return addGetIdListener;
    }

    public String getName() {
        return this.firebaseApp.getName();
    }

    public String getProjectIdentifier() {
        return this.firebaseApp.getOptions().getProjectId();
    }

    @Override // com.google.firebase.installations.FirebaseInstallationsApi
    public yi4<InstallationTokenResult> getToken(boolean z) {
        preConditionChecks();
        yi4<InstallationTokenResult> addGetAuthTokenListener = addGetAuthTokenListener();
        this.backgroundExecutor.execute(new lz4(this, z));
        return addGetAuthTokenListener;
    }

    @Override // com.google.firebase.installations.FirebaseInstallationsApi
    public synchronized FidListenerHandle registerFidListener(final FidListener fidListener) {
        this.fidListeners.add(fidListener);
        return new FidListenerHandle() {
            /* class com.google.firebase.installations.FirebaseInstallations.AnonymousClass2 */

            @Override // com.google.firebase.installations.internal.FidListenerHandle
            public void unregister() {
                synchronized (FirebaseInstallations.this) {
                    FirebaseInstallations.this.fidListeners.remove(fidListener);
                }
            }
        };
    }

    public static FirebaseInstallations getInstance(FirebaseApp firebaseApp2) {
        gj1.c(firebaseApp2 != null, "Null is not a valid value of FirebaseApp.");
        return (FirebaseInstallations) firebaseApp2.get(FirebaseInstallationsApi.class);
    }

    public FirebaseInstallations(ExecutorService executorService, FirebaseApp firebaseApp2, FirebaseInstallationServiceClient firebaseInstallationServiceClient, PersistedInstallation persistedInstallation2, Utils utils2, IidStore iidStore2, RandomFidGenerator randomFidGenerator) {
        this.lock = new Object();
        this.fidListeners = new HashSet();
        this.listeners = new ArrayList();
        this.firebaseApp = firebaseApp2;
        this.serviceClient = firebaseInstallationServiceClient;
        this.persistedInstallation = persistedInstallation2;
        this.utils = utils2;
        this.iidStore = iidStore2;
        this.fidGenerator = randomFidGenerator;
        this.backgroundExecutor = executorService;
        this.networkExecutor = new ThreadPoolExecutor(0, 1, (long) KEEP_ALIVE_TIME_IN_SECONDS, TimeUnit.SECONDS, new LinkedBlockingQueue(), THREAD_FACTORY);
    }
}
