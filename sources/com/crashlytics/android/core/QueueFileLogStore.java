package com.crashlytics.android.core;

import com.rabbitmq.client.StringRpcServer;
import com.razorpay.AnalyticsConstants;
import defpackage.p06;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

public class QueueFileLogStore implements FileLogStore {
    private p06 logFile;
    private final int maxLogSize;
    private final File workingFile;

    public QueueFileLogStore(File file, int i) {
        this.workingFile = file;
        this.maxLogSize = i;
    }

    private void doWriteToLog(long j, String str) {
        if (this.logFile != null) {
            if (str == null) {
                str = AnalyticsConstants.NULL;
            }
            try {
                int i = this.maxLogSize / 4;
                if (str.length() > i) {
                    str = "..." + str.substring(str.length() - i);
                }
                this.logFile.c(String.format(Locale.US, "%d %s%n", Long.valueOf(j), str.replaceAll("\r", " ").replaceAll("\n", " ")).getBytes(StringRpcServer.STRING_ENCODING));
                while (!this.logFile.h() && this.logFile.n() > this.maxLogSize) {
                    this.logFile.k();
                }
            } catch (IOException unused) {
            }
        }
    }

    private void openLogFile() {
        if (this.logFile == null) {
            try {
                this.logFile = new p06(this.workingFile);
            } catch (IOException unused) {
                StringBuilder i0 = hj1.i0("Could not open log file: ");
                i0.append(this.workingFile);
                i0.toString();
            }
        }
    }

    @Override // com.crashlytics.android.core.FileLogStore
    public void closeLogFile() {
        p06 p06 = this.logFile;
        if (p06 != null) {
            try {
                p06.close();
            } catch (IOException unused) {
            }
        }
        this.logFile = null;
    }

    @Override // com.crashlytics.android.core.FileLogStore
    public void deleteLogFile() {
        closeLogFile();
        this.workingFile.delete();
    }

    @Override // com.crashlytics.android.core.FileLogStore
    public ByteString getLogAsByteString() {
        if (!this.workingFile.exists()) {
            return null;
        }
        openLogFile();
        p06 p06 = this.logFile;
        if (p06 == null) {
            return null;
        }
        final int[] iArr = {0};
        final byte[] bArr = new byte[p06.n()];
        try {
            this.logFile.g(new p06.d() {
                /* class com.crashlytics.android.core.QueueFileLogStore.AnonymousClass1 */

                @Override // defpackage.p06.d
                public void read(InputStream inputStream, int i) throws IOException {
                    try {
                        inputStream.read(bArr, iArr[0], i);
                        int[] iArr = iArr;
                        iArr[0] = iArr[0] + i;
                    } finally {
                        inputStream.close();
                    }
                }
            });
        } catch (IOException unused) {
        }
        return ByteString.copyFrom(bArr, 0, iArr[0]);
    }

    @Override // com.crashlytics.android.core.FileLogStore
    public void writeToLog(long j, String str) {
        openLogFile();
        doWriteToLog(j, str);
    }
}
