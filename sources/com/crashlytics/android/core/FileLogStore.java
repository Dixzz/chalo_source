package com.crashlytics.android.core;

public interface FileLogStore {
    void closeLogFile();

    void deleteLogFile();

    ByteString getLogAsByteString();

    void writeToLog(long j, String str);
}
