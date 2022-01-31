package com.google.firebase.database;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.database.android.AndroidAuthTokenProvider;
import com.google.firebase.database.core.AuthTokenProvider;
import com.google.firebase.database.core.DatabaseConfig;
import com.google.firebase.database.core.RepoInfo;
import java.util.HashMap;
import java.util.Map;

public class FirebaseDatabaseComponent {

    /* renamed from: app  reason: collision with root package name */
    private final FirebaseApp f658app;
    private final AuthTokenProvider authProvider;
    private final Map<RepoInfo, FirebaseDatabase> instances = new HashMap();

    public FirebaseDatabaseComponent(FirebaseApp firebaseApp, InternalAuthProvider internalAuthProvider) {
        this.f658app = firebaseApp;
        if (internalAuthProvider != null) {
            this.authProvider = AndroidAuthTokenProvider.forAuthenticatedAccess(internalAuthProvider);
        } else {
            this.authProvider = AndroidAuthTokenProvider.forUnauthenticatedAccess();
        }
    }

    public synchronized FirebaseDatabase get(RepoInfo repoInfo) {
        FirebaseDatabase firebaseDatabase;
        firebaseDatabase = this.instances.get(repoInfo);
        if (firebaseDatabase == null) {
            DatabaseConfig databaseConfig = new DatabaseConfig();
            if (!this.f658app.isDefaultApp()) {
                databaseConfig.setSessionPersistenceKey(this.f658app.getName());
            }
            databaseConfig.setFirebaseApp(this.f658app);
            databaseConfig.setAuthTokenProvider(this.authProvider);
            FirebaseDatabase firebaseDatabase2 = new FirebaseDatabase(this.f658app, repoInfo, databaseConfig);
            this.instances.put(repoInfo, firebaseDatabase2);
            firebaseDatabase = firebaseDatabase2;
        }
        return firebaseDatabase;
    }
}
