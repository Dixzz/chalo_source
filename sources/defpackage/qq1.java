package defpackage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.util.Log;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: qq1  reason: default package */
/* compiled from: TransformationUtils */
public final class qq1 {

    /* renamed from: a  reason: collision with root package name */
    public static final Paint f2978a = new Paint(6);
    public static final Paint b;
    public static final List<String> c;
    public static final Lock d;

    /* renamed from: qq1$a */
    /* compiled from: TransformationUtils */
    public static final class a implements Lock {
        public void lock() {
        }

        @Override // java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
        }

        public Condition newCondition() {
            throw new UnsupportedOperationException("Should not be called");
        }

        public boolean tryLock() {
            return true;
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock(long j, TimeUnit timeUnit) throws InterruptedException {
            return true;
        }

        public void unlock() {
        }
    }

    static {
        new Paint(7);
        List<String> asList = Arrays.asList("XT1097", "XT1085");
        c = asList;
        d = (!asList.contains(Build.MODEL) || Build.VERSION.SDK_INT != 22) ? new a() : new ReentrantLock();
        Paint paint = new Paint(7);
        b = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    public static void a(Bitmap bitmap, Bitmap bitmap2, Matrix matrix) {
        Lock lock = d;
        lock.lock();
        try {
            Canvas canvas = new Canvas(bitmap2);
            canvas.drawBitmap(bitmap, matrix, f2978a);
            canvas.setBitmap(null);
            lock.unlock();
        } catch (Throwable th) {
            d.unlock();
            throw th;
        }
    }

    public static Bitmap b(zn1 zn1, Bitmap bitmap, int i, int i2) {
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            return bitmap;
        }
        float min = Math.min(((float) i) / ((float) bitmap.getWidth()), ((float) i2) / ((float) bitmap.getHeight()));
        int width = (int) (((float) bitmap.getWidth()) * min);
        int height = (int) (((float) bitmap.getHeight()) * min);
        if (bitmap.getWidth() == width && bitmap.getHeight() == height) {
            return bitmap;
        }
        Bitmap e = zn1.e(width, height, c(bitmap));
        e.setHasAlpha(bitmap.hasAlpha());
        if (Log.isLoggable("TransformationUtils", 2)) {
            bitmap.getWidth();
            bitmap.getHeight();
            e.getWidth();
            e.getHeight();
        }
        Matrix matrix = new Matrix();
        matrix.setScale(min, min);
        a(bitmap, e, matrix);
        return e;
    }

    public static Bitmap.Config c(Bitmap bitmap) {
        return bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888;
    }
}
