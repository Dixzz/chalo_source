package com.crashlytics.android.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;

public class ClsFileOutputStream extends FileOutputStream {
    public static final String IN_PROGRESS_SESSION_FILE_EXTENSION = ".cls_temp";
    public static final String SESSION_FILE_EXTENSION = ".cls";
    public static final FilenameFilter TEMP_FILENAME_FILTER = new FilenameFilter() {
        /* class com.crashlytics.android.core.ClsFileOutputStream.AnonymousClass1 */

        public boolean accept(File file, String str) {
            return str.endsWith(".cls_temp");
        }
    };
    private boolean closed;
    private File complete;
    private File inProgress;
    private final String root;

    public ClsFileOutputStream(String str, String str2) throws FileNotFoundException {
        this(new File(str), str2);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.io.FileOutputStream, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (!this.closed) {
            this.closed = true;
            super.flush();
            super.close();
            File file = new File(this.root + ".cls");
            if (this.inProgress.renameTo(file)) {
                this.inProgress = null;
                this.complete = file;
                return;
            }
            String str = "";
            if (file.exists()) {
                str = " (target already exists)";
            } else if (!this.inProgress.exists()) {
                str = " (source does not exist)";
            }
            throw new IOException("Could not rename temp file: " + this.inProgress + " -> " + file + str);
        }
    }

    public void closeInProgressStream() throws IOException {
        if (!this.closed) {
            this.closed = true;
            super.flush();
            super.close();
        }
    }

    public File getCompleteFile() {
        return this.complete;
    }

    public File getInProgressFile() {
        return this.inProgress;
    }

    public ClsFileOutputStream(File file, String str) throws FileNotFoundException {
        super(new File(file, hj1.S(str, ".cls_temp")));
        this.closed = false;
        StringBuilder sb = new StringBuilder();
        sb.append(file);
        String a0 = hj1.a0(sb, File.separator, str);
        this.root = a0;
        this.inProgress = new File(hj1.S(a0, ".cls_temp"));
    }
}
