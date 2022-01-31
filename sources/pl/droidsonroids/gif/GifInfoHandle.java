package pl.droidsonroids.gif;

import android.content.Context;
import android.graphics.Bitmap;
import java.io.FileDescriptor;

public final class GifInfoHandle {
    public static final /* synthetic */ int b = 0;

    /* renamed from: a  reason: collision with root package name */
    public volatile long f2819a;

    static {
        try {
            System.loadLibrary("pl_droidsonroids_gif");
        } catch (UnsatisfiedLinkError unused) {
            if (ec6.f957a == null) {
                try {
                    ec6.f957a = (Context) Class.forName("android.app.ActivityThread").getDeclaredMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);
                } catch (Exception e) {
                    throw new IllegalStateException("LibraryLoader not initialized. Call LibraryLoader.initialize() before using library classes.", e);
                }
            }
            new io6().c(ec6.f957a, "pl_droidsonroids_gif", null, null);
        }
    }

    public GifInfoHandle(String str) throws GifIOException {
        this.f2819a = openFile(str);
    }

    public static native int createTempNativeFileDescriptor() throws GifIOException;

    public static native int extractNativeFileDescriptor(FileDescriptor fileDescriptor, boolean z) throws GifIOException;

    public static native void free(long j);

    public static native int getCurrentFrameIndex(long j);

    public static native int getCurrentLoop(long j);

    public static native int getCurrentPosition(long j);

    public static native int getDuration(long j);

    public static native int getHeight(long j);

    public static native int getLoopCount(long j);

    public static native int getNativeErrorCode(long j);

    public static native int getNumberOfFrames(long j);

    public static native long[] getSavedState(long j);

    public static native int getWidth(long j);

    public static native boolean isOpaque(long j);

    public static native long openFile(String str) throws GifIOException;

    public static native long openNativeFileDescriptor(int i, long j) throws GifIOException;

    public static native long renderFrame(long j, Bitmap bitmap);

    public static native boolean reset(long j);

    public static native long restoreRemainder(long j);

    public static native int restoreSavedState(long j, long[] jArr, Bitmap bitmap);

    public static native void saveRemainder(long j);

    public static native void seekToTime(long j, int i, Bitmap bitmap);

    public static native void setLoopCount(long j, char c);

    public synchronized int a() {
        return getHeight(this.f2819a);
    }

    public synchronized int b() {
        return getNumberOfFrames(this.f2819a);
    }

    public synchronized int c() {
        return getWidth(this.f2819a);
    }

    public synchronized boolean d() {
        return this.f2819a == 0;
    }

    public void finalize() throws Throwable {
        try {
            synchronized (this) {
                free(this.f2819a);
                this.f2819a = 0;
            }
        } finally {
            super.finalize();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002a, code lost:
        throw new pl.droidsonroids.gif.GifIOException(defpackage.xn6.OPEN_FAILED.errorCode, r0.getMessage());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GifInfoHandle(android.content.res.AssetFileDescriptor r7) throws java.io.IOException {
        /*
            r6 = this;
            r6.<init>()
            java.io.FileDescriptor r0 = r7.getFileDescriptor()     // Catch:{ all -> 0x002b }
            long r1 = r7.getStartOffset()     // Catch:{ all -> 0x002b }
            r3 = 0
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x002b }
            r5 = 27
            if (r4 <= r5) goto L_0x002d
            int r3 = createTempNativeFileDescriptor()     // Catch:{ all -> 0x001a }
            android.system.Os.dup2(r0, r3)     // Catch:{ all -> 0x001a }
            goto L_0x0031
        L_0x001a:
            r0 = move-exception
            throw r0     // Catch:{ Exception -> 0x001c }
        L_0x001c:
            r0 = move-exception
            pl.droidsonroids.gif.GifIOException r1 = new pl.droidsonroids.gif.GifIOException
            xn6 r2 = defpackage.xn6.OPEN_FAILED
            int r2 = r2.errorCode
            java.lang.String r0 = r0.getMessage()
            r1.<init>(r2, r0)
            throw r1
        L_0x002b:
            r0 = move-exception
            goto L_0x003b
        L_0x002d:
            int r3 = extractNativeFileDescriptor(r0, r3)
        L_0x0031:
            long r0 = openNativeFileDescriptor(r3, r1)
            r6.f2819a = r0
            r7.close()     // Catch:{ IOException -> 0x003a }
        L_0x003a:
            return
        L_0x003b:
            r7.close()     // Catch:{ IOException -> 0x003e }
        L_0x003e:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.droidsonroids.gif.GifInfoHandle.<init>(android.content.res.AssetFileDescriptor):void");
    }
}
