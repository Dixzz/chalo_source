package defpackage;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.TypedValue;
import android.widget.MediaController;
import defpackage.yn6;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import pl.droidsonroids.gif.GifInfoHandle;

/* renamed from: wn6  reason: default package */
/* compiled from: GifDrawable */
public class wn6 extends Drawable implements Animatable, MediaController.MediaPlayerControl {
    public static final /* synthetic */ int x = 0;
    public final ScheduledThreadPoolExecutor f;
    public volatile boolean g;
    public long h;
    public final Rect i;
    public final Paint j;
    public final Bitmap k;
    public final GifInfoHandle l;
    public final ConcurrentLinkedQueue<un6> m;
    public ColorStateList n;
    public PorterDuffColorFilter o;
    public PorterDuff.Mode p;
    public final boolean q;
    public final ao6 r;
    public final bo6 s;
    public final Rect t;
    public ScheduledFuture<?> u;
    public int v;
    public int w;

    /* renamed from: wn6$a */
    /* compiled from: GifDrawable */
    public class a extends co6 {
        public final /* synthetic */ int g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(wn6 wn6, int i) {
            super(wn6);
            this.g = i;
        }

        @Override // defpackage.co6
        public void a() {
            wn6 wn6 = wn6.this;
            GifInfoHandle gifInfoHandle = wn6.l;
            int i = this.g;
            Bitmap bitmap = wn6.k;
            synchronized (gifInfoHandle) {
                GifInfoHandle.seekToTime(gifInfoHandle.f2819a, i, bitmap);
            }
            this.f.r.sendEmptyMessageAtTime(-1, 0);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public wn6(android.content.ContentResolver r3, android.net.Uri r4) throws java.io.IOException {
        /*
            r2 = this;
            int r0 = pl.droidsonroids.gif.GifInfoHandle.b
            java.lang.String r0 = r4.getScheme()
            java.lang.String r1 = "file"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0018
            pl.droidsonroids.gif.GifInfoHandle r3 = new pl.droidsonroids.gif.GifInfoHandle
            java.lang.String r4 = r4.getPath()
            r3.<init>(r4)
            goto L_0x0026
        L_0x0018:
            java.lang.String r0 = "r"
            android.content.res.AssetFileDescriptor r3 = r3.openAssetFileDescriptor(r4, r0)
            if (r3 == 0) goto L_0x002c
            pl.droidsonroids.gif.GifInfoHandle r4 = new pl.droidsonroids.gif.GifInfoHandle
            r4.<init>(r3)
            r3 = r4
        L_0x0026:
            r4 = 1
            r0 = 0
            r2.<init>(r3, r0, r0, r4)
            return
        L_0x002c:
            java.io.IOException r3 = new java.io.IOException
            java.lang.String r0 = "Could not open AssetFileDescriptor for "
            java.lang.String r4 = defpackage.hj1.N(r0, r4)
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.wn6.<init>(android.content.ContentResolver, android.net.Uri):void");
    }

    public void a(long j2) {
        if (this.q) {
            this.h = 0;
            this.r.sendEmptyMessageAtTime(-1, 0);
            return;
        }
        ScheduledFuture<?> scheduledFuture = this.u;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.r.removeMessages(-1);
        this.u = this.f.schedule(this.s, Math.max(j2, 0L), TimeUnit.MILLISECONDS);
    }

    public final PorterDuffColorFilter b(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public boolean canPause() {
        return true;
    }

    public boolean canSeekBackward() {
        return this.l.b() > 1;
    }

    public boolean canSeekForward() {
        return this.l.b() > 1;
    }

    public void draw(Canvas canvas) {
        boolean z;
        if (this.o == null || this.j.getColorFilter() != null) {
            z = false;
        } else {
            this.j.setColorFilter(this.o);
            z = true;
        }
        canvas.drawBitmap(this.k, this.t, this.i, this.j);
        if (z) {
            this.j.setColorFilter(null);
        }
    }

    public int getAlpha() {
        return this.j.getAlpha();
    }

    public int getAudioSessionId() {
        return 0;
    }

    public int getBufferPercentage() {
        return 100;
    }

    public ColorFilter getColorFilter() {
        return this.j.getColorFilter();
    }

    public int getCurrentPosition() {
        int currentPosition;
        GifInfoHandle gifInfoHandle = this.l;
        synchronized (gifInfoHandle) {
            currentPosition = GifInfoHandle.getCurrentPosition(gifInfoHandle.f2819a);
        }
        return currentPosition;
    }

    public int getDuration() {
        int duration;
        GifInfoHandle gifInfoHandle = this.l;
        synchronized (gifInfoHandle) {
            duration = GifInfoHandle.getDuration(gifInfoHandle.f2819a);
        }
        return duration;
    }

    public int getIntrinsicHeight() {
        return this.w;
    }

    public int getIntrinsicWidth() {
        return this.v;
    }

    public int getOpacity() {
        boolean isOpaque;
        GifInfoHandle gifInfoHandle = this.l;
        synchronized (gifInfoHandle) {
            isOpaque = GifInfoHandle.isOpaque(gifInfoHandle.f2819a);
        }
        return (!isOpaque || this.j.getAlpha() < 255) ? -2 : -1;
    }

    public void invalidateSelf() {
        super.invalidateSelf();
        if (this.q && this.g) {
            long j2 = this.h;
            if (j2 != Long.MIN_VALUE) {
                long max = Math.max(0L, j2 - SystemClock.uptimeMillis());
                this.h = Long.MIN_VALUE;
                this.f.remove(this.s);
                this.u = this.f.schedule(this.s, max, TimeUnit.MILLISECONDS);
            }
        }
    }

    public boolean isPlaying() {
        return this.g;
    }

    public boolean isRunning() {
        return this.g;
    }

    public boolean isStateful() {
        ColorStateList colorStateList;
        return super.isStateful() || ((colorStateList = this.n) != null && colorStateList.isStateful());
    }

    public void onBoundsChange(Rect rect) {
        this.i.set(rect);
    }

    public boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.n;
        if (colorStateList == null || (mode = this.p) == null) {
            return false;
        }
        this.o = b(colorStateList, mode);
        return true;
    }

    public void pause() {
        stop();
    }

    public void seekTo(int i2) {
        if (i2 >= 0) {
            this.f.execute(new a(this, i2));
            return;
        }
        throw new IllegalArgumentException("Position is not positive");
    }

    public void setAlpha(int i2) {
        this.j.setAlpha(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.j.setColorFilter(colorFilter);
    }

    @Deprecated
    public void setDither(boolean z) {
        this.j.setDither(z);
        invalidateSelf();
    }

    public void setFilterBitmap(boolean z) {
        this.j.setFilterBitmap(z);
        invalidateSelf();
    }

    public void setTintList(ColorStateList colorStateList) {
        this.n = colorStateList;
        this.o = b(colorStateList, this.p);
        invalidateSelf();
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.p = mode;
        this.o = b(this.n, mode);
        invalidateSelf();
    }

    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (!this.q) {
            if (z) {
                if (z2) {
                    this.f.execute(new vn6(this, this));
                }
                if (visible) {
                    start();
                }
            } else if (visible) {
                stop();
            }
        }
        return visible;
    }

    public void start() {
        long restoreRemainder;
        synchronized (this) {
            if (!this.g) {
                this.g = true;
                GifInfoHandle gifInfoHandle = this.l;
                synchronized (gifInfoHandle) {
                    restoreRemainder = GifInfoHandle.restoreRemainder(gifInfoHandle.f2819a);
                }
                a(restoreRemainder);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x000f, code lost:
        r1.cancel(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0012, code lost:
        r3.r.removeMessages(-1);
        r0 = r3.l;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001a, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        pl.droidsonroids.gif.GifInfoHandle.saveRemainder(r0.f2819a);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0020, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0021, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000b, code lost:
        r1 = r3.u;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000d, code lost:
        if (r1 == null) goto L_0x0012;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void stop() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.g     // Catch:{ all -> 0x0025 }
            if (r0 != 0) goto L_0x0007
            monitor-exit(r3)     // Catch:{ all -> 0x0025 }
            return
        L_0x0007:
            r0 = 0
            r3.g = r0     // Catch:{ all -> 0x0025 }
            monitor-exit(r3)     // Catch:{ all -> 0x0025 }
            java.util.concurrent.ScheduledFuture<?> r1 = r3.u
            if (r1 == 0) goto L_0x0012
            r1.cancel(r0)
        L_0x0012:
            ao6 r0 = r3.r
            r1 = -1
            r0.removeMessages(r1)
            pl.droidsonroids.gif.GifInfoHandle r0 = r3.l
            monitor-enter(r0)
            long r1 = r0.f2819a     // Catch:{ all -> 0x0022 }
            pl.droidsonroids.gif.GifInfoHandle.saveRemainder(r1)     // Catch:{ all -> 0x0022 }
            monitor-exit(r0)
            return
        L_0x0022:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        L_0x0025:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.wn6.stop():void");
    }

    public String toString() {
        int nativeErrorCode;
        Locale locale = Locale.ENGLISH;
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(this.l.c());
        objArr[1] = Integer.valueOf(this.l.a());
        objArr[2] = Integer.valueOf(this.l.b());
        GifInfoHandle gifInfoHandle = this.l;
        synchronized (gifInfoHandle) {
            nativeErrorCode = GifInfoHandle.getNativeErrorCode(gifInfoHandle.f2819a);
        }
        objArr[3] = Integer.valueOf(nativeErrorCode);
        return String.format(locale, "GIF: size: %dx%d, frames: %d, error: %d", objArr);
    }

    public wn6(Resources resources, int i2) throws Resources.NotFoundException, IOException {
        this(new GifInfoHandle(resources.openRawResourceFd(i2)), null, null, true);
        List<String> list = zn6.f4192a;
        TypedValue typedValue = new TypedValue();
        resources.getValue(i2, typedValue, true);
        int i3 = typedValue.density;
        if (i3 == 0) {
            i3 = 160;
        } else if (i3 == 65535) {
            i3 = 0;
        }
        int i4 = resources.getDisplayMetrics().densityDpi;
        float f2 = (i3 <= 0 || i4 <= 0) ? 1.0f : ((float) i4) / ((float) i3);
        this.w = (int) (((float) this.l.a()) * f2);
        this.v = (int) (((float) this.l.c()) * f2);
    }

    public wn6(GifInfoHandle gifInfoHandle, wn6 wn6, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, boolean z) {
        boolean isOpaque;
        this.g = true;
        this.h = Long.MIN_VALUE;
        this.i = new Rect();
        this.j = new Paint(6);
        this.m = new ConcurrentLinkedQueue<>();
        bo6 bo6 = new bo6(this);
        this.s = bo6;
        this.q = z;
        int i2 = yn6.f;
        this.f = yn6.b.f4074a;
        this.l = gifInfoHandle;
        Bitmap createBitmap = Bitmap.createBitmap(gifInfoHandle.c(), gifInfoHandle.a(), Bitmap.Config.ARGB_8888);
        this.k = createBitmap;
        synchronized (gifInfoHandle) {
            isOpaque = GifInfoHandle.isOpaque(gifInfoHandle.f2819a);
        }
        createBitmap.setHasAlpha(true ^ isOpaque);
        this.t = new Rect(0, 0, gifInfoHandle.c(), gifInfoHandle.a());
        this.r = new ao6(this);
        bo6.a();
        this.v = gifInfoHandle.c();
        this.w = gifInfoHandle.a();
    }
}
