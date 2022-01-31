package com.crashlytics.android.core;

import android.content.Context;
import java.io.File;
import java.util.Set;

public class LogFileManager {
    private static final String DIRECTORY_NAME = "log-files";
    private static final String LOGFILE_EXT = ".temp";
    private static final String LOGFILE_PREFIX = "crashlytics-userlog-";
    public static final int MAX_LOG_SIZE = 65536;
    private static final NoopLogStore NOOP_LOG_STORE = new NoopLogStore();
    private final Context context;
    private FileLogStore currentLog;
    private final u16 fileStore;

    public static final class NoopLogStore implements FileLogStore {
        private NoopLogStore() {
        }

        @Override // com.crashlytics.android.core.FileLogStore
        public void closeLogFile() {
        }

        @Override // com.crashlytics.android.core.FileLogStore
        public void deleteLogFile() {
        }

        @Override // com.crashlytics.android.core.FileLogStore
        public ByteString getLogAsByteString() {
            return null;
        }

        @Override // com.crashlytics.android.core.FileLogStore
        public void writeToLog(long j, String str) {
        }
    }

    public LogFileManager(Context context2, u16 u16) {
        this(context2, u16, null);
    }

    private File getLogFileDir() {
        File file = new File(((v16) this.fileStore).a(), DIRECTORY_NAME);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private String getSessionIdForFile(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(LOGFILE_EXT);
        if (lastIndexOf == -1) {
            return name;
        }
        return name.substring(20, lastIndexOf);
    }

    private File getWorkingFileForSession(String str) {
        return new File(getLogFileDir(), hj1.T(LOGFILE_PREFIX, str, LOGFILE_EXT));
    }

    private boolean isLoggingEnabled() {
        return j06.e(this.context, CrashlyticsCore.COLLECT_CUSTOM_LOGS, true);
    }

    public void clearLog() {
        this.currentLog.deleteLogFile();
    }

    public void discardOldLogFiles(Set<String> set) {
        File[] listFiles = getLogFileDir().listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (!set.contains(getSessionIdForFile(file))) {
                    file.delete();
                }
            }
        }
    }

    public ByteString getByteStringForLog() {
        return this.currentLog.getLogAsByteString();
    }

    public final void setCurrentSession(String str) {
        this.currentLog.closeLogFile();
        this.currentLog = NOOP_LOG_STORE;
        if (str != null && isLoggingEnabled()) {
            setLogFile(getWorkingFileForSession(str), 65536);
        }
    }

    public void setLogFile(File file, int i) {
        this.currentLog = new QueueFileLogStore(file, i);
    }

    public void writeToLog(long j, String str) {
        this.currentLog.writeToLog(j, str);
    }

    public LogFileManager(Context context2, u16 u16, String str) {
        this.context = context2;
        this.fileStore = u16;
        this.currentLog = NOOP_LOG_STORE;
        setCurrentSession(str);
    }
}
