package com.google.firebase.database;

import android.text.TextUtils;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.Logger;
import com.google.firebase.database.annotations.Nullable;
import com.google.firebase.database.core.DatabaseConfig;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.Repo;
import com.google.firebase.database.core.RepoInfo;
import com.google.firebase.database.core.RepoManager;
import com.google.firebase.database.core.utilities.ParsedUrl;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.utilities.Validation;
import com.google.firebase.emulators.EmulatedServiceSettings;
import java.util.Objects;

public class FirebaseDatabase {
    private static final String SDK_VERSION = "19.5.1";

    /* renamed from: app  reason: collision with root package name */
    private final FirebaseApp f657app;
    private final DatabaseConfig config;
    @Nullable
    private EmulatedServiceSettings emulatorSettings;
    private Repo repo;
    private final RepoInfo repoInfo;

    public FirebaseDatabase(FirebaseApp firebaseApp, RepoInfo repoInfo2, DatabaseConfig databaseConfig) {
        this.f657app = firebaseApp;
        this.repoInfo = repoInfo2;
        this.config = databaseConfig;
    }

    private void assertUnfrozen(String str) {
        if (this.repo != null) {
            throw new DatabaseException(hj1.T("Calls to ", str, "() must be made before any other usage of FirebaseDatabase instance."));
        }
    }

    public static FirebaseDatabase createForTests(FirebaseApp firebaseApp, RepoInfo repoInfo2, DatabaseConfig databaseConfig) {
        FirebaseDatabase firebaseDatabase = new FirebaseDatabase(firebaseApp, repoInfo2, databaseConfig);
        firebaseDatabase.ensureRepo();
        return firebaseDatabase;
    }

    private synchronized void ensureRepo() {
        if (this.repo == null) {
            this.repoInfo.applyEmulatorSettings(this.emulatorSettings);
            this.repo = RepoManager.createRepo(this.config, this.repoInfo, this);
        }
    }

    public static FirebaseDatabase getInstance() {
        FirebaseApp instance = FirebaseApp.getInstance();
        if (instance != null) {
            return getInstance(instance);
        }
        throw new DatabaseException("You must call FirebaseApp.initialize() first.");
    }

    public static String getSdkVersion() {
        return "19.5.1";
    }

    public FirebaseApp getApp() {
        return this.f657app;
    }

    public DatabaseConfig getConfig() {
        return this.config;
    }

    public DatabaseReference getReference() {
        ensureRepo();
        return new DatabaseReference(this.repo, Path.getEmptyPath());
    }

    public DatabaseReference getReferenceFromUrl(String str) {
        ensureRepo();
        Objects.requireNonNull(str, "Can't pass null for argument 'url' in FirebaseDatabase.getReferenceFromUrl()");
        ParsedUrl parseUrl = Utilities.parseUrl(str);
        parseUrl.repoInfo.applyEmulatorSettings(this.emulatorSettings);
        if (parseUrl.repoInfo.host.equals(this.repo.getRepoInfo().host)) {
            return new DatabaseReference(this.repo, parseUrl.path);
        }
        StringBuilder l0 = hj1.l0("Invalid URL (", str, ") passed to getReference().  URL was expected to match configured Database URL: ");
        l0.append(getReference().toString());
        throw new DatabaseException(l0.toString());
    }

    public void goOffline() {
        ensureRepo();
        RepoManager.interrupt(this.repo);
    }

    public void goOnline() {
        ensureRepo();
        RepoManager.resume(this.repo);
    }

    public void purgeOutstandingWrites() {
        ensureRepo();
        this.repo.scheduleNow(new Runnable() {
            /* class com.google.firebase.database.FirebaseDatabase.AnonymousClass1 */

            public void run() {
                FirebaseDatabase.this.repo.purgeOutstandingWrites();
            }
        });
    }

    public synchronized void setLogLevel(Logger.Level level) {
        assertUnfrozen("setLogLevel");
        this.config.setLogLevel(level);
    }

    public synchronized void setPersistenceCacheSizeBytes(long j) {
        assertUnfrozen("setPersistenceCacheSizeBytes");
        this.config.setPersistenceCacheSizeBytes(j);
    }

    public synchronized void setPersistenceEnabled(boolean z) {
        assertUnfrozen("setPersistenceEnabled");
        this.config.setPersistenceEnabled(z);
    }

    public void useEmulator(String str, int i) {
        if (this.repo == null) {
            this.emulatorSettings = new EmulatedServiceSettings(str, i);
            return;
        }
        throw new IllegalStateException("Cannot call useEmulator() after instance has already been initialized.");
    }

    public DatabaseReference getReference(String str) {
        ensureRepo();
        Objects.requireNonNull(str, "Can't pass null for argument 'pathString' in FirebaseDatabase.getReference()");
        Validation.validateRootPathString(str);
        return new DatabaseReference(this.repo, new Path(str));
    }

    public static FirebaseDatabase getInstance(String str) {
        FirebaseApp instance = FirebaseApp.getInstance();
        if (instance != null) {
            return getInstance(instance, str);
        }
        throw new DatabaseException("You must call FirebaseApp.initialize() first.");
    }

    public static FirebaseDatabase getInstance(FirebaseApp firebaseApp) {
        String databaseUrl = firebaseApp.getOptions().getDatabaseUrl();
        if (databaseUrl == null) {
            if (firebaseApp.getOptions().getProjectId() != null) {
                StringBuilder i0 = hj1.i0("https://");
                i0.append(firebaseApp.getOptions().getProjectId());
                i0.append("-default-rtdb.firebaseio.com");
                databaseUrl = i0.toString();
            } else {
                throw new DatabaseException("Failed to get FirebaseDatabase instance: Can't determine Firebase Database URL. Be sure to include a Project ID in your configuration.");
            }
        }
        return getInstance(firebaseApp, databaseUrl);
    }

    public static synchronized FirebaseDatabase getInstance(FirebaseApp firebaseApp, String str) {
        FirebaseDatabase firebaseDatabase;
        synchronized (FirebaseDatabase.class) {
            if (!TextUtils.isEmpty(str)) {
                gj1.l(firebaseApp, "Provided FirebaseApp must not be null.");
                FirebaseDatabaseComponent firebaseDatabaseComponent = (FirebaseDatabaseComponent) firebaseApp.get(FirebaseDatabaseComponent.class);
                gj1.l(firebaseDatabaseComponent, "Firebase Database component is not present.");
                ParsedUrl parseUrl = Utilities.parseUrl(str);
                if (parseUrl.path.isEmpty()) {
                    firebaseDatabase = firebaseDatabaseComponent.get(parseUrl.repoInfo);
                } else {
                    throw new DatabaseException("Specified Database URL '" + str + "' is invalid. It should point to the root of a Firebase Database but it includes a path: " + parseUrl.path.toString());
                }
            } else {
                throw new DatabaseException("Failed to get FirebaseDatabase instance: Specify DatabaseURL within FirebaseApp or from your getInstance() call.");
            }
        }
        return firebaseDatabase;
    }
}
