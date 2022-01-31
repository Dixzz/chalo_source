package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/* renamed from: qi  reason: default package */
/* compiled from: MultiDexExtractor */
public final class qi implements Closeable {
    public final File f;
    public final long g;
    public final File h;
    public final RandomAccessFile i;
    public final FileChannel j;
    public final FileLock k;

    /* renamed from: qi$a */
    /* compiled from: MultiDexExtractor */
    public static class a extends File {
        public long f = -1;

        public a(File file, String str) {
            super(file, str);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0041, code lost:
        r3 = e;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0041 A[ExcHandler: Error | RuntimeException (e java.lang.Throwable), Splitter:B:1:0x0023] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public qi(java.io.File r3, java.io.File r4) throws java.io.IOException {
        /*
            r2 = this;
            r2.<init>()
            r3.getPath()
            r4.getPath()
            r2.f = r3
            r2.h = r4
            long r0 = e(r3)
            r2.g = r0
            java.io.File r3 = new java.io.File
            java.lang.String r0 = "MultiDex.lock"
            r3.<init>(r4, r0)
            java.io.RandomAccessFile r4 = new java.io.RandomAccessFile
            java.lang.String r0 = "rw"
            r4.<init>(r3, r0)
            r2.i = r4
            java.nio.channels.FileChannel r4 = r4.getChannel()     // Catch:{ IOException -> 0x0045, RuntimeException -> 0x0043, Error -> 0x0041 }
            r2.j = r4     // Catch:{ IOException -> 0x0045, RuntimeException -> 0x0043, Error -> 0x0041 }
            r3.getPath()     // Catch:{ IOException -> 0x003a, RuntimeException -> 0x0038, Error -> 0x0036 }
            java.nio.channels.FileLock r4 = r4.lock()     // Catch:{ IOException -> 0x003a, RuntimeException -> 0x0038, Error -> 0x0036 }
            r2.k = r4     // Catch:{ IOException -> 0x003a, RuntimeException -> 0x0038, Error -> 0x0036 }
            r3.getPath()
            return
        L_0x0036:
            r3 = move-exception
            goto L_0x003b
        L_0x0038:
            r3 = move-exception
            goto L_0x003b
        L_0x003a:
            r3 = move-exception
        L_0x003b:
            java.nio.channels.FileChannel r4 = r2.j
            r4.close()     // Catch:{ IOException -> 0x0040, RuntimeException -> 0x0043, Error -> 0x0041 }
        L_0x0040:
            throw r3
        L_0x0041:
            r3 = move-exception
            goto L_0x0046
        L_0x0043:
            r3 = move-exception
            goto L_0x0046
        L_0x0045:
            r3 = move-exception
        L_0x0046:
            java.io.RandomAccessFile r4 = r2.i
            r4.close()     // Catch:{ IOException -> 0x004b }
        L_0x004b:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.qi.<init>(java.io.File, java.io.File):void");
    }

    /* JADX INFO: finally extract failed */
    public static void a(ZipFile zipFile, ZipEntry zipEntry, File file, String str) throws IOException, FileNotFoundException {
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        File createTempFile = File.createTempFile(hj1.S("tmp-", str), ".zip", file.getParentFile());
        createTempFile.getPath();
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(createTempFile)));
            try {
                ZipEntry zipEntry2 = new ZipEntry("classes.dex");
                zipEntry2.setTime(zipEntry.getTime());
                zipOutputStream.putNextEntry(zipEntry2);
                byte[] bArr = new byte[16384];
                for (int read = inputStream.read(bArr); read != -1; read = inputStream.read(bArr)) {
                    zipOutputStream.write(bArr, 0, read);
                }
                zipOutputStream.closeEntry();
                zipOutputStream.close();
                if (createTempFile.setReadOnly()) {
                    file.getPath();
                    if (!createTempFile.renameTo(file)) {
                        throw new IOException("Failed to rename \"" + createTempFile.getAbsolutePath() + "\" to \"" + file.getAbsolutePath() + "\"");
                    }
                    return;
                }
                throw new IOException("Failed to mark readonly \"" + createTempFile.getAbsolutePath() + "\" (tmp of \"" + file.getAbsolutePath() + "\")");
            } catch (Throwable th) {
                zipOutputStream.close();
                throw th;
            }
        } finally {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
            createTempFile.delete();
        }
    }

    public static long c(File file) {
        long lastModified = file.lastModified();
        return lastModified == -1 ? lastModified - 1 : lastModified;
    }

    /* JADX INFO: finally extract failed */
    public static long e(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        try {
            ri F = h.F(randomAccessFile);
            CRC32 crc32 = new CRC32();
            long j2 = F.b;
            randomAccessFile.seek(F.f3083a);
            byte[] bArr = new byte[16384];
            int read = randomAccessFile.read(bArr, 0, (int) Math.min(16384L, j2));
            while (true) {
                if (read == -1) {
                    break;
                }
                crc32.update(bArr, 0, read);
                j2 -= (long) read;
                if (j2 == 0) {
                    break;
                }
                read = randomAccessFile.read(bArr, 0, (int) Math.min(16384L, j2));
            }
            long value = crc32.getValue();
            randomAccessFile.close();
            return value == -1 ? value - 1 : value;
        } catch (Throwable th) {
            randomAccessFile.close();
            throw th;
        }
    }

    public static void i(Context context, String str, long j2, long j3, List<a> list) {
        SharedPreferences.Editor edit = context.getSharedPreferences("multidex.version", 4).edit();
        edit.putLong(str + "timestamp", j2);
        edit.putLong(hj1.a0(new StringBuilder(), str, "crc"), j3);
        edit.putInt(str + "dex.number", list.size() + 1);
        int i2 = 2;
        for (a aVar : list) {
            edit.putLong(str + "dex.crc." + i2, aVar.f);
            edit.putLong(str + "dex.time." + i2, aVar.lastModified());
            i2++;
        }
        edit.commit();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.k.release();
        this.j.close();
        this.i.close();
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x005c A[SYNTHETIC, Splitter:B:10:0x005c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<? extends java.io.File> f(android.content.Context r15, java.lang.String r16, boolean r17) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 150
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.qi.f(android.content.Context, java.lang.String, boolean):java.util.List");
    }

    public final List<a> g(Context context, String str) throws IOException {
        String str2 = this.f.getName() + ".classes";
        SharedPreferences sharedPreferences = context.getSharedPreferences("multidex.version", 4);
        int i2 = sharedPreferences.getInt(str + "dex.number", 1);
        ArrayList arrayList = new ArrayList(i2 + -1);
        int i3 = 2;
        while (i3 <= i2) {
            a aVar = new a(this.h, hj1.J(str2, i3, ".zip"));
            if (aVar.isFile()) {
                aVar.f = e(aVar);
                long j2 = sharedPreferences.getLong(str + "dex.crc." + i3, -1);
                long j3 = sharedPreferences.getLong(str + "dex.time." + i3, -1);
                long lastModified = aVar.lastModified();
                if (j3 == lastModified && j2 == aVar.f) {
                    arrayList.add(aVar);
                    i3++;
                    sharedPreferences = sharedPreferences;
                    str2 = str2;
                } else {
                    throw new IOException("Invalid extracted dex: " + aVar + " (key \"" + str + "\"), expected modification time: " + j3 + ", modification time: " + lastModified + ", expected crc: " + j2 + ", file crc: " + aVar.f);
                }
            } else {
                StringBuilder i0 = hj1.i0("Missing extracted secondary dex file '");
                i0.append(aVar.getPath());
                i0.append("'");
                throw new IOException(i0.toString());
            }
        }
        return arrayList;
    }

    public final List<a> h() throws IOException {
        String str = this.f.getName() + ".classes";
        File[] listFiles = this.h.listFiles(new pi(this));
        if (listFiles == null) {
            this.h.getPath();
        } else {
            for (File file : listFiles) {
                file.getPath();
                file.length();
                if (!file.delete()) {
                    file.getPath();
                } else {
                    file.getPath();
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(this.f);
        int i2 = 2;
        try {
            ZipEntry entry = zipFile.getEntry("classes2.dex");
            while (entry != null) {
                a aVar = new a(this.h, str + i2 + ".zip");
                arrayList.add(aVar);
                String str2 = "Extraction is needed for file " + aVar;
                int i3 = 0;
                boolean z = false;
                while (i3 < 3 && !z) {
                    i3++;
                    a(zipFile, entry, aVar, str);
                    try {
                        aVar.f = e(aVar);
                        z = true;
                    } catch (IOException unused) {
                        aVar.getAbsolutePath();
                        z = false;
                    }
                    aVar.getAbsolutePath();
                    aVar.length();
                    if (!z) {
                        aVar.delete();
                        if (aVar.exists()) {
                            aVar.getPath();
                        }
                    }
                }
                if (z) {
                    i2++;
                    entry = zipFile.getEntry("classes" + i2 + ".dex");
                } else {
                    throw new IOException("Could not create zip file " + aVar.getAbsolutePath() + " for secondary dex (" + i2 + ")");
                }
            }
            return arrayList;
        } finally {
            try {
                zipFile.close();
            } catch (IOException unused2) {
            }
        }
    }
}
