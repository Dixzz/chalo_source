package com.google.firebase.database.core;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.Logger;
import com.google.firebase.database.logging.Logger;
import java.util.List;

public class DatabaseConfig extends Context {

    /* renamed from: com.google.firebase.database.core.DatabaseConfig$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$firebase$database$Logger$Level;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|(2:1|2)|3|5|6|7|9|10|11|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0023 */
        static {
            /*
                com.google.firebase.database.Logger.Level.values()
                r0 = 5
                int[] r1 = new int[r0]
                com.google.firebase.database.core.DatabaseConfig.AnonymousClass1.$SwitchMap$com$google$firebase$database$Logger$Level = r1
                r2 = 1
                com.google.firebase.database.Logger$Level r3 = com.google.firebase.database.Logger.Level.DEBUG     // Catch:{ NoSuchFieldError -> 0x000e }
                r3 = 0
                r1[r3] = r2     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                r1 = 2
                int[] r3 = com.google.firebase.database.core.DatabaseConfig.AnonymousClass1.$SwitchMap$com$google$firebase$database$Logger$Level     // Catch:{ NoSuchFieldError -> 0x0015 }
                com.google.firebase.database.Logger$Level r4 = com.google.firebase.database.Logger.Level.INFO     // Catch:{ NoSuchFieldError -> 0x0015 }
                r3[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0015 }
            L_0x0015:
                r2 = 3
                int[] r3 = com.google.firebase.database.core.DatabaseConfig.AnonymousClass1.$SwitchMap$com$google$firebase$database$Logger$Level     // Catch:{ NoSuchFieldError -> 0x001c }
                com.google.firebase.database.Logger$Level r4 = com.google.firebase.database.Logger.Level.WARN     // Catch:{ NoSuchFieldError -> 0x001c }
                r3[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001c }
            L_0x001c:
                r1 = 4
                int[] r3 = com.google.firebase.database.core.DatabaseConfig.AnonymousClass1.$SwitchMap$com$google$firebase$database$Logger$Level     // Catch:{ NoSuchFieldError -> 0x0023 }
                com.google.firebase.database.Logger$Level r4 = com.google.firebase.database.Logger.Level.ERROR     // Catch:{ NoSuchFieldError -> 0x0023 }
                r3[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0023 }
            L_0x0023:
                int[] r2 = com.google.firebase.database.core.DatabaseConfig.AnonymousClass1.$SwitchMap$com$google$firebase$database$Logger$Level     // Catch:{ NoSuchFieldError -> 0x0029 }
                com.google.firebase.database.Logger$Level r3 = com.google.firebase.database.Logger.Level.NONE     // Catch:{ NoSuchFieldError -> 0x0029 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0029 }
            L_0x0029:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.database.core.DatabaseConfig.AnonymousClass1.<clinit>():void");
        }
    }

    public void setAuthTokenProvider(AuthTokenProvider authTokenProvider) {
        this.authTokenProvider = authTokenProvider;
    }

    public synchronized void setDebugLogComponents(List<String> list) {
        assertUnfrozen();
        setLogLevel(Logger.Level.DEBUG);
        this.loggedComponents = list;
    }

    public synchronized void setEventTarget(EventTarget eventTarget) {
        assertUnfrozen();
        this.eventTarget = eventTarget;
    }

    public synchronized void setFirebaseApp(FirebaseApp firebaseApp) {
        this.firebaseApp = firebaseApp;
    }

    public synchronized void setLogLevel(Logger.Level level) {
        assertUnfrozen();
        int ordinal = level.ordinal();
        if (ordinal == 0) {
            this.logLevel = Logger.Level.DEBUG;
        } else if (ordinal == 1) {
            this.logLevel = Logger.Level.INFO;
        } else if (ordinal == 2) {
            this.logLevel = Logger.Level.WARN;
        } else if (ordinal == 3) {
            this.logLevel = Logger.Level.ERROR;
        } else if (ordinal == 4) {
            this.logLevel = Logger.Level.NONE;
        } else {
            throw new IllegalArgumentException("Unknown log level: " + level);
        }
    }

    public synchronized void setLogger(com.google.firebase.database.logging.Logger logger) {
        assertUnfrozen();
        this.logger = logger;
    }

    public synchronized void setPersistenceCacheSizeBytes(long j) {
        assertUnfrozen();
        if (j < 1048576) {
            throw new DatabaseException("The minimum cache size must be at least 1MB");
        } else if (j <= 104857600) {
            this.cacheSize = j;
        } else {
            throw new DatabaseException("Firebase Database currently doesn't support a cache size larger than 100MB");
        }
    }

    public synchronized void setPersistenceEnabled(boolean z) {
        assertUnfrozen();
        this.persistenceEnabled = z;
    }

    public void setRunLoop(RunLoop runLoop) {
        this.runLoop = runLoop;
    }

    public synchronized void setSessionPersistenceKey(String str) {
        assertUnfrozen();
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Session identifier is not allowed to be empty or null!");
        }
        this.persistenceKey = str;
    }
}
