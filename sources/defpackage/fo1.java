package defpackage;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* renamed from: fo1  reason: default package */
/* compiled from: LruBitmapPool */
public class fo1 implements zn1 {
    public static final Bitmap.Config j = Bitmap.Config.ARGB_8888;

    /* renamed from: a  reason: collision with root package name */
    public final go1 f1151a;
    public final Set<Bitmap.Config> b;
    public final a c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;

    /* renamed from: fo1$a */
    /* compiled from: LruBitmapPool */
    public interface a {
    }

    /* renamed from: fo1$b */
    /* compiled from: LruBitmapPool */
    public static class b implements a {
    }

    public fo1(int i2) {
        io1 io1 = new io1();
        HashSet hashSet = new HashSet();
        hashSet.addAll(Arrays.asList(Bitmap.Config.values()));
        int i3 = Build.VERSION.SDK_INT;
        hashSet.add(null);
        if (i3 >= 26) {
            hashSet.remove(Bitmap.Config.HARDWARE);
        }
        Set<Bitmap.Config> unmodifiableSet = Collections.unmodifiableSet(hashSet);
        this.d = i2;
        this.f1151a = io1;
        this.b = unmodifiableSet;
        this.c = new b();
    }

    @Override // defpackage.zn1
    @SuppressLint({"InlinedApi"})
    public void a(int i2) {
        Log.isLoggable("LruBitmapPool", 3);
        if (i2 >= 40) {
            i(0);
        } else if (i2 >= 20) {
            i(this.d / 2);
        }
    }

    @Override // defpackage.zn1
    public void b() {
        Log.isLoggable("LruBitmapPool", 3);
        i(0);
    }

    @Override // defpackage.zn1
    public Bitmap c(int i2, int i3, Bitmap.Config config) {
        Bitmap h2 = h(i2, i3, config);
        return h2 == null ? Bitmap.createBitmap(i2, i3, config) : h2;
    }

    @Override // defpackage.zn1
    public synchronized void d(Bitmap bitmap) {
        if (bitmap == null) {
            throw new NullPointerException("Bitmap must not be null");
        } else if (!bitmap.isRecycled()) {
            if (bitmap.isMutable()) {
                Objects.requireNonNull((io1) this.f1151a);
                if (rt1.d(bitmap) <= this.d) {
                    if (this.b.contains(bitmap.getConfig())) {
                        Objects.requireNonNull((io1) this.f1151a);
                        int d2 = rt1.d(bitmap);
                        ((io1) this.f1151a).f(bitmap);
                        Objects.requireNonNull((b) this.c);
                        this.h++;
                        this.e += d2;
                        if (Log.isLoggable("LruBitmapPool", 2)) {
                            ((io1) this.f1151a).e(bitmap);
                        }
                        f();
                        i(this.d);
                        return;
                    }
                }
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                ((io1) this.f1151a).e(bitmap);
                bitmap.isMutable();
                this.b.contains(bitmap.getConfig());
            }
            bitmap.recycle();
        } else {
            throw new IllegalStateException("Cannot pool recycled bitmap");
        }
    }

    @Override // defpackage.zn1
    public Bitmap e(int i2, int i3, Bitmap.Config config) {
        Bitmap h2 = h(i2, i3, config);
        if (h2 == null) {
            return Bitmap.createBitmap(i2, i3, config);
        }
        h2.eraseColor(0);
        return h2;
    }

    public final void f() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            g();
        }
    }

    public final void g() {
        StringBuilder i0 = hj1.i0("Hits=");
        i0.append(this.f);
        i0.append(", misses=");
        i0.append(this.g);
        i0.append(", puts=");
        i0.append(this.h);
        i0.append(", evictions=");
        i0.append(this.i);
        i0.append(", currentSize=");
        i0.append(this.e);
        i0.append(", maxSize=");
        i0.append(this.d);
        i0.append("\nStrategy=");
        i0.append(this.f1151a);
        i0.toString();
    }

    public final synchronized Bitmap h(int i2, int i3, Bitmap.Config config) {
        Bitmap b2;
        if (Build.VERSION.SDK_INT >= 26) {
            if (config == Bitmap.Config.HARDWARE) {
                throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
            }
        }
        b2 = ((io1) this.f1151a).b(i2, i3, config != null ? config : j);
        if (b2 == null) {
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Objects.requireNonNull((io1) this.f1151a);
                io1.c(rt1.c(i2, i3, config), config);
            }
            this.g++;
        } else {
            this.f++;
            int i4 = this.e;
            Objects.requireNonNull((io1) this.f1151a);
            this.e = i4 - rt1.d(b2);
            Objects.requireNonNull((b) this.c);
            b2.setHasAlpha(true);
            b2.setPremultiplied(true);
        }
        if (Log.isLoggable("LruBitmapPool", 2)) {
            Objects.requireNonNull((io1) this.f1151a);
            io1.c(rt1.c(i2, i3, config), config);
        }
        f();
        return b2;
    }

    public final synchronized void i(int i2) {
        while (this.e > i2) {
            io1 io1 = (io1) this.f1151a;
            Bitmap c2 = io1.b.c();
            if (c2 != null) {
                io1.a(Integer.valueOf(rt1.d(c2)), c2);
            }
            if (c2 == null) {
                if (Log.isLoggable("LruBitmapPool", 5)) {
                    g();
                }
                this.e = 0;
                return;
            }
            Objects.requireNonNull((b) this.c);
            int i3 = this.e;
            Objects.requireNonNull((io1) this.f1151a);
            this.e = i3 - rt1.d(c2);
            this.i++;
            if (Log.isLoggable("LruBitmapPool", 3)) {
                ((io1) this.f1151a).e(c2);
            }
            f();
            c2.recycle();
        }
    }
}
