package defpackage;

import android.content.Context;
import android.os.Build;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.Objects;
import java.util.concurrent.Callable;

/* renamed from: am  reason: default package */
/* compiled from: SQLiteCopyOpenHelper */
public class am implements pm, ol {
    public final Context f;
    public final String g;
    public final File h;
    public final Callable<InputStream> i;
    public final int j;
    public final pm k;
    public nl l;
    public boolean m;

    @Override // defpackage.ol
    public pm a() {
        return this.k;
    }

    /* JADX INFO: finally extract failed */
    public final void c(File file, boolean z) throws IOException {
        ReadableByteChannel readableByteChannel;
        if (this.g != null) {
            readableByteChannel = Channels.newChannel(this.f.getAssets().open(this.g));
        } else if (this.h != null) {
            readableByteChannel = new FileInputStream(this.h).getChannel();
        } else {
            Callable<InputStream> callable = this.i;
            if (callable != null) {
                try {
                    readableByteChannel = Channels.newChannel(callable.call());
                } catch (Exception e) {
                    throw new IOException("inputStreamCallable exception on call", e);
                }
            } else {
                throw new IllegalStateException("copyFromAssetPath, copyFromFile and copyFromInputStream are all null!");
            }
        }
        File createTempFile = File.createTempFile("room-copy-helper", ".tmp", this.f.getCacheDir());
        createTempFile.deleteOnExit();
        FileChannel channel = new FileOutputStream(createTempFile).getChannel();
        try {
            if (Build.VERSION.SDK_INT <= 23) {
                InputStream newInputStream = Channels.newInputStream(readableByteChannel);
                OutputStream newOutputStream = Channels.newOutputStream(channel);
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = newInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    newOutputStream.write(bArr, 0, read);
                }
            } else {
                channel.transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
            }
            channel.force(false);
            readableByteChannel.close();
            channel.close();
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                StringBuilder i0 = hj1.i0("Failed to create directories for ");
                i0.append(file.getAbsolutePath());
                throw new IOException(i0.toString());
            } else if (!createTempFile.renameTo(file)) {
                StringBuilder i02 = hj1.i0("Failed to move intermediate file (");
                i02.append(createTempFile.getAbsolutePath());
                i02.append(") to destination (");
                i02.append(file.getAbsolutePath());
                i02.append(").");
                throw new IOException(i02.toString());
            }
        } catch (Throwable th) {
            readableByteChannel.close();
            channel.close();
            throw th;
        }
    }

    @Override // java.io.Closeable, defpackage.pm, java.lang.AutoCloseable
    public synchronized void close() {
        this.k.close();
        this.m = false;
    }

    public final void e(boolean z) {
        boolean z2;
        String databaseName = getDatabaseName();
        File databasePath = this.f.getDatabasePath(databaseName);
        nl nlVar = this.l;
        if (nlVar != null) {
            Objects.requireNonNull(nlVar);
            z2 = false;
        } else {
            z2 = true;
        }
        gm gmVar = new gm(databaseName, this.f.getFilesDir(), z2);
        try {
            gmVar.b.lock();
            if (gmVar.c) {
                try {
                    FileChannel channel = new FileOutputStream(gmVar.f1280a).getChannel();
                    gmVar.d = channel;
                    channel.lock();
                } catch (IOException e) {
                    throw new IllegalStateException("Unable to grab copy lock.", e);
                }
            }
            if (!databasePath.exists()) {
                try {
                    c(databasePath, z);
                } catch (IOException e2) {
                    throw new RuntimeException("Unable to copy database file.", e2);
                }
            } else if (this.l == null) {
                gmVar.a();
            } else {
                try {
                    int c = hm.c(databasePath);
                    int i2 = this.j;
                    if (c == i2) {
                        gmVar.a();
                    } else if (this.l.a(c, i2)) {
                        gmVar.a();
                    } else {
                        if (this.f.deleteDatabase(databaseName)) {
                            try {
                                c(databasePath, z);
                            } catch (IOException unused) {
                            }
                        }
                        gmVar.a();
                    }
                } catch (IOException unused2) {
                    gmVar.a();
                }
            }
        } finally {
            gmVar.a();
        }
    }

    @Override // defpackage.pm
    public String getDatabaseName() {
        return this.k.getDatabaseName();
    }

    @Override // defpackage.pm
    public synchronized om l0() {
        if (!this.m) {
            e(true);
            this.m = true;
        }
        return this.k.l0();
    }

    @Override // defpackage.pm
    public void setWriteAheadLoggingEnabled(boolean z) {
        this.k.setWriteAheadLoggingEnabled(z);
    }
}
