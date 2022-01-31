package com.google.firebase.database.logging;

import com.google.firebase.database.logging.Logger;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DefaultLogger implements Logger {
    private final Set<String> enabledComponents;
    private final Logger.Level minLevel;

    /* renamed from: com.google.firebase.database.logging.DefaultLogger$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$firebase$database$logging$Logger$Level;

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0015 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001b */
        static {
            /*
                com.google.firebase.database.logging.Logger.Level.values()
                r0 = 5
                int[] r0 = new int[r0]
                com.google.firebase.database.logging.DefaultLogger.AnonymousClass1.$SwitchMap$com$google$firebase$database$logging$Logger$Level = r0
                r1 = 1
                r2 = 3
                com.google.firebase.database.logging.Logger$Level r3 = com.google.firebase.database.logging.Logger.Level.ERROR     // Catch:{ NoSuchFieldError -> 0x000e }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                int[] r0 = com.google.firebase.database.logging.DefaultLogger.AnonymousClass1.$SwitchMap$com$google$firebase$database$logging$Logger$Level     // Catch:{ NoSuchFieldError -> 0x0015 }
                com.google.firebase.database.logging.Logger$Level r3 = com.google.firebase.database.logging.Logger.Level.WARN     // Catch:{ NoSuchFieldError -> 0x0015 }
                r3 = 2
                r0[r3] = r3     // Catch:{ NoSuchFieldError -> 0x0015 }
            L_0x0015:
                int[] r0 = com.google.firebase.database.logging.DefaultLogger.AnonymousClass1.$SwitchMap$com$google$firebase$database$logging$Logger$Level     // Catch:{ NoSuchFieldError -> 0x001b }
                com.google.firebase.database.logging.Logger$Level r3 = com.google.firebase.database.logging.Logger.Level.INFO     // Catch:{ NoSuchFieldError -> 0x001b }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001b }
            L_0x001b:
                int[] r0 = com.google.firebase.database.logging.DefaultLogger.AnonymousClass1.$SwitchMap$com$google$firebase$database$logging$Logger$Level     // Catch:{ NoSuchFieldError -> 0x0023 }
                com.google.firebase.database.logging.Logger$Level r1 = com.google.firebase.database.logging.Logger.Level.DEBUG     // Catch:{ NoSuchFieldError -> 0x0023 }
                r1 = 0
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0023 }
            L_0x0023:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.database.logging.DefaultLogger.AnonymousClass1.<clinit>():void");
        }
    }

    public DefaultLogger(Logger.Level level, List<String> list) {
        if (list != null) {
            this.enabledComponents = new HashSet(list);
        } else {
            this.enabledComponents = null;
        }
        this.minLevel = level;
    }

    public String buildLogMessage(Logger.Level level, String str, String str2, long j) {
        Date date = new Date(j);
        StringBuilder sb = new StringBuilder();
        sb.append(date.toString());
        sb.append(" [");
        sb.append(level);
        sb.append("] ");
        return hj1.b0(sb, str, ": ", str2);
    }

    public void debug(String str, String str2) {
        System.out.println(str2);
    }

    public void error(String str, String str2) {
        System.err.println(str2);
    }

    @Override // com.google.firebase.database.logging.Logger
    public Logger.Level getLogLevel() {
        return this.minLevel;
    }

    public void info(String str, String str2) {
        System.out.println(str2);
    }

    @Override // com.google.firebase.database.logging.Logger
    public void onLogMessage(Logger.Level level, String str, String str2, long j) {
        if (shouldLog(level, str)) {
            String buildLogMessage = buildLogMessage(level, str, str2, j);
            int ordinal = level.ordinal();
            if (ordinal == 0) {
                debug(str, buildLogMessage);
            } else if (ordinal == 1) {
                info(str, buildLogMessage);
            } else if (ordinal == 2) {
                warn(str, buildLogMessage);
            } else if (ordinal == 3) {
                error(str, buildLogMessage);
            } else {
                throw new RuntimeException("Should not reach here!");
            }
        }
    }

    public boolean shouldLog(Logger.Level level, String str) {
        if (level.ordinal() >= this.minLevel.ordinal()) {
            if (this.enabledComponents != null) {
                int ordinal = level.ordinal();
                Logger.Level level2 = Logger.Level.DEBUG;
                if (ordinal > 0 || this.enabledComponents.contains(str)) {
                    return true;
                }
            }
            return true;
        }
        return false;
    }

    public void warn(String str, String str2) {
        System.out.println(str2);
    }
}
