package defpackage;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: kt1  reason: default package */
/* compiled from: ByteBufferUtil */
public final class kt1 {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int f2117a = 0;

    /* renamed from: kt1$b */
    /* compiled from: ByteBufferUtil */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f2118a;
        public final int b;
        public final byte[] c;

        public b(byte[] bArr, int i, int i2) {
            this.c = bArr;
            this.f2118a = i;
            this.b = i2;
        }
    }

    static {
        new AtomicReference();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:5|6|7|8|9|10|11) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0027 */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0039 A[SYNTHETIC, Splitter:B:19:0x0039] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0040 A[SYNTHETIC, Splitter:B:23:0x0040] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.nio.ByteBuffer a(java.io.File r8) throws java.io.IOException {
        /*
            r0 = 0
            long r5 = r8.length()     // Catch:{ all -> 0x0035 }
            r1 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r3 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r3 > 0) goto L_0x002d
            java.io.RandomAccessFile r7 = new java.io.RandomAccessFile     // Catch:{ all -> 0x0035 }
            java.lang.String r1 = "r"
            r7.<init>(r8, r1)     // Catch:{ all -> 0x0035 }
            java.nio.channels.FileChannel r0 = r7.getChannel()     // Catch:{ all -> 0x002b }
            java.nio.channels.FileChannel$MapMode r2 = java.nio.channels.FileChannel.MapMode.READ_ONLY     // Catch:{ all -> 0x002b }
            r3 = 0
            r1 = r0
            java.nio.MappedByteBuffer r8 = r1.map(r2, r3, r5)     // Catch:{ all -> 0x002b }
            java.nio.MappedByteBuffer r8 = r8.load()     // Catch:{ all -> 0x002b }
            r0.close()     // Catch:{ IOException -> 0x0027 }
        L_0x0027:
            r7.close()     // Catch:{ IOException -> 0x002a }
        L_0x002a:
            return r8
        L_0x002b:
            r8 = move-exception
            goto L_0x0037
        L_0x002d:
            java.io.IOException r8 = new java.io.IOException
            java.lang.String r1 = "File too large to map into memory"
            r8.<init>(r1)
            throw r8
        L_0x0035:
            r8 = move-exception
            r7 = r0
        L_0x0037:
            if (r0 == 0) goto L_0x003e
            r0.close()     // Catch:{ IOException -> 0x003d }
            goto L_0x003e
        L_0x003d:
        L_0x003e:
            if (r7 == 0) goto L_0x0043
            r7.close()     // Catch:{ IOException -> 0x0043 }
        L_0x0043:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.kt1.a(java.io.File):java.nio.ByteBuffer");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:3|4|5|6|7|8|22) */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001f */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0029 A[SYNTHETIC, Splitter:B:14:0x0029] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0030 A[SYNTHETIC, Splitter:B:18:0x0030] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(java.nio.ByteBuffer r4, java.io.File r5) throws java.io.IOException {
        /*
            r0 = 0
            r4.position(r0)
            r1 = 0
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile     // Catch:{ all -> 0x0025 }
            java.lang.String r3 = "rw"
            r2.<init>(r5, r3)     // Catch:{ all -> 0x0025 }
            java.nio.channels.FileChannel r1 = r2.getChannel()     // Catch:{ all -> 0x0023 }
            r1.write(r4)     // Catch:{ all -> 0x0023 }
            r1.force(r0)     // Catch:{ all -> 0x0023 }
            r1.close()     // Catch:{ all -> 0x0023 }
            r2.close()     // Catch:{ all -> 0x0023 }
            r1.close()     // Catch:{ IOException -> 0x001f }
        L_0x001f:
            r2.close()     // Catch:{ IOException -> 0x0022 }
        L_0x0022:
            return
        L_0x0023:
            r4 = move-exception
            goto L_0x0027
        L_0x0025:
            r4 = move-exception
            r2 = r1
        L_0x0027:
            if (r1 == 0) goto L_0x002e
            r1.close()     // Catch:{ IOException -> 0x002d }
            goto L_0x002e
        L_0x002d:
        L_0x002e:
            if (r2 == 0) goto L_0x0033
            r2.close()     // Catch:{ IOException -> 0x0033 }
        L_0x0033:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.kt1.b(java.nio.ByteBuffer, java.io.File):void");
    }

    /* renamed from: kt1$a */
    /* compiled from: ByteBufferUtil */
    public static class a extends InputStream {
        public final ByteBuffer f;
        public int g = -1;

        public a(ByteBuffer byteBuffer) {
            this.f = byteBuffer;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return this.f.remaining();
        }

        public synchronized void mark(int i) {
            this.g = this.f.position();
        }

        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (!this.f.hasRemaining()) {
                return -1;
            }
            return this.f.get();
        }

        @Override // java.io.InputStream
        public synchronized void reset() throws IOException {
            int i = this.g;
            if (i != -1) {
                this.f.position(i);
            } else {
                throw new IOException("Cannot reset to unset mark position");
            }
        }

        @Override // java.io.InputStream
        public long skip(long j) throws IOException {
            if (!this.f.hasRemaining()) {
                return -1;
            }
            long min = Math.min(j, (long) available());
            ByteBuffer byteBuffer = this.f;
            byteBuffer.position((int) (((long) byteBuffer.position()) + min));
            return min;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            if (!this.f.hasRemaining()) {
                return -1;
            }
            int min = Math.min(i2, available());
            this.f.get(bArr, i, min);
            return min;
        }
    }
}
