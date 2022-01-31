package defpackage;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import defpackage.cm1;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.locks.Lock;

/* renamed from: kq1  reason: default package */
/* compiled from: Downsampler */
public final class kq1 {
    public static final em1<yl1> f = em1.a("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", yl1.DEFAULT);
    public static final em1<jq1> g = em1.a("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", jq1.c);
    public static final em1<Boolean> h = em1.a("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", Boolean.FALSE);
    public static final em1<Boolean> i = em1.a("com.bumtpech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", null);
    public static final Set<String> j = Collections.unmodifiableSet(new HashSet(Arrays.asList("image/vnd.wap.wbmp", "image/x-ico")));
    public static final b k = new a();
    public static final Set<cm1.a> l = Collections.unmodifiableSet(EnumSet.of(cm1.a.JPEG, cm1.a.PNG_A, cm1.a.PNG));
    public static final Queue<BitmapFactory.Options> m = new ArrayDeque(0);

    /* renamed from: a  reason: collision with root package name */
    public final zn1 f2104a;
    public final DisplayMetrics b;
    public final xn1 c;
    public final List<cm1> d;
    public final mq1 e;

    /* renamed from: kq1$a */
    /* compiled from: Downsampler */
    public static class a implements b {
        @Override // defpackage.kq1.b
        public void a(zn1 zn1, Bitmap bitmap) throws IOException {
        }

        @Override // defpackage.kq1.b
        public void b() {
        }
    }

    /* renamed from: kq1$b */
    /* compiled from: Downsampler */
    public interface b {
        void a(zn1 zn1, Bitmap bitmap) throws IOException;

        void b();
    }

    static {
        char[] cArr = rt1.f3126a;
    }

    public kq1(List<cm1> list, DisplayMetrics displayMetrics, zn1 zn1, xn1 xn1) {
        if (mq1.d == null) {
            synchronized (mq1.class) {
                if (mq1.d == null) {
                    mq1.d = new mq1();
                }
            }
        }
        this.e = mq1.d;
        this.d = list;
        Objects.requireNonNull(displayMetrics, "Argument must not be null");
        this.b = displayMetrics;
        Objects.requireNonNull(zn1, "Argument must not be null");
        this.f2104a = zn1;
        Objects.requireNonNull(xn1, "Argument must not be null");
        this.c = xn1;
    }

    public static Bitmap c(InputStream inputStream, BitmapFactory.Options options, b bVar, zn1 zn1) throws IOException {
        if (options.inJustDecodeBounds) {
            inputStream.mark(5242880);
        } else {
            bVar.b();
        }
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        String str = options.outMimeType;
        Lock lock = qq1.d;
        lock.lock();
        try {
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
            lock.unlock();
            if (options.inJustDecodeBounds) {
                inputStream.reset();
            }
            return decodeStream;
        } catch (IllegalArgumentException e2) {
            IOException e3 = e(e2, i2, i3, str, options);
            if (options.inBitmap != null) {
                try {
                    inputStream.reset();
                    zn1.d(options.inBitmap);
                    options.inBitmap = null;
                    Bitmap c2 = c(inputStream, options, bVar, zn1);
                    qq1.d.unlock();
                    return c2;
                } catch (IOException unused) {
                    throw e3;
                }
            } else {
                throw e3;
            }
        } catch (Throwable th) {
            qq1.d.unlock();
            throw th;
        }
    }

    @TargetApi(19)
    public static String d(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        StringBuilder i0 = hj1.i0(" (");
        i0.append(bitmap.getAllocationByteCount());
        i0.append(")");
        String sb = i0.toString();
        StringBuilder i02 = hj1.i0("[");
        i02.append(bitmap.getWidth());
        i02.append("x");
        i02.append(bitmap.getHeight());
        i02.append("] ");
        i02.append(bitmap.getConfig());
        i02.append(sb);
        return i02.toString();
    }

    public static IOException e(IllegalArgumentException illegalArgumentException, int i2, int i3, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i2 + ", outHeight: " + i3 + ", outMimeType: " + str + ", inBitmap: " + d(options.inBitmap), illegalArgumentException);
    }

    public static void f(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    public rn1<Bitmap> a(InputStream inputStream, int i2, int i3, fm1 fm1, b bVar) throws IOException {
        Queue<BitmapFactory.Options> queue;
        BitmapFactory.Options poll;
        gj1.d(inputStream.markSupported(), "You must provide an InputStream that supports mark()");
        byte[] bArr = (byte[]) this.c.d(65536, byte[].class);
        synchronized (kq1.class) {
            queue = m;
            synchronized (queue) {
                poll = queue.poll();
            }
            if (poll == null) {
                poll = new BitmapFactory.Options();
                f(poll);
            }
        }
        poll.inTempStorage = bArr;
        yl1 yl1 = (yl1) fm1.c(f);
        jq1 jq1 = (jq1) fm1.c(g);
        boolean booleanValue = ((Boolean) fm1.c(h)).booleanValue();
        em1<Boolean> em1 = i;
        try {
            dq1 d2 = dq1.d(b(inputStream, poll, jq1, yl1, yl1 == yl1.PREFER_ARGB_8888_DISALLOW_HARDWARE ? false : fm1.c(em1) != null && ((Boolean) fm1.c(em1)).booleanValue(), i2, i3, booleanValue, bVar), this.f2104a);
            f(poll);
            synchronized (queue) {
                queue.offer(poll);
            }
            this.c.c(bArr, byte[].class);
            return d2;
        } catch (Throwable th) {
            f(poll);
            Queue<BitmapFactory.Options> queue2 = m;
            synchronized (queue2) {
                queue2.offer(poll);
                this.c.c(bArr, byte[].class);
                throw th;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x01b1  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0214  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0226  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0156  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.Bitmap b(java.io.InputStream r19, android.graphics.BitmapFactory.Options r20, defpackage.jq1 r21, defpackage.yl1 r22, boolean r23, int r24, int r25, boolean r26, defpackage.kq1.b r27) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 768
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.kq1.b(java.io.InputStream, android.graphics.BitmapFactory$Options, jq1, yl1, boolean, int, int, boolean, kq1$b):android.graphics.Bitmap");
    }
}
