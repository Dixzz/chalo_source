package defpackage;

import android.content.res.TypedArray;
import android.graphics.RectF;
import com.facebook.shimmer.R;

/* renamed from: wt1  reason: default package */
/* compiled from: Shimmer */
public class wt1 {

    /* renamed from: a  reason: collision with root package name */
    public final float[] f3835a = new float[4];
    public final int[] b = new int[4];
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public float i;
    public float j;
    public float k;
    public float l;
    public float m;
    public boolean n;
    public boolean o;
    public boolean p;
    public int q;
    public int r;
    public long s;
    public long t;

    /* renamed from: wt1$a */
    /* compiled from: Shimmer */
    public static class a extends b<a> {
        public a() {
            this.f3836a.p = true;
        }

        /* Return type fixed from 'wt1$b' to match base method */
        @Override // defpackage.wt1.b
        public a c() {
            return this;
        }
    }

    /* renamed from: wt1$b */
    /* compiled from: Shimmer */
    public static abstract class b<T extends b<T>> {

        /* renamed from: a  reason: collision with root package name */
        public final wt1 f3836a = new wt1();

        public wt1 a() {
            wt1 wt1 = this.f3836a;
            int i = wt1.f;
            if (i != 1) {
                int[] iArr = wt1.b;
                int i2 = wt1.e;
                iArr[0] = i2;
                int i3 = wt1.d;
                iArr[1] = i3;
                iArr[2] = i3;
                iArr[3] = i2;
            } else {
                int[] iArr2 = wt1.b;
                int i4 = wt1.d;
                iArr2[0] = i4;
                iArr2[1] = i4;
                int i5 = wt1.e;
                iArr2[2] = i5;
                iArr2[3] = i5;
            }
            if (i != 1) {
                wt1.f3835a[0] = Math.max(((1.0f - wt1.k) - wt1.l) / 2.0f, 0.0f);
                wt1.f3835a[1] = Math.max(((1.0f - wt1.k) - 0.001f) / 2.0f, 0.0f);
                wt1.f3835a[2] = Math.min(((wt1.k + 1.0f) + 0.001f) / 2.0f, 1.0f);
                wt1.f3835a[3] = Math.min(((wt1.k + 1.0f) + wt1.l) / 2.0f, 1.0f);
            } else {
                float[] fArr = wt1.f3835a;
                fArr[0] = 0.0f;
                fArr[1] = Math.min(wt1.k, 1.0f);
                wt1.f3835a[2] = Math.min(wt1.k + wt1.l, 1.0f);
                wt1.f3835a[3] = 1.0f;
            }
            return this.f3836a;
        }

        public T b(TypedArray typedArray) {
            int i = R.styleable.ShimmerFrameLayout_shimmer_clip_to_children;
            if (typedArray.hasValue(i)) {
                this.f3836a.n = typedArray.getBoolean(i, this.f3836a.n);
                c();
            }
            int i2 = R.styleable.ShimmerFrameLayout_shimmer_auto_start;
            if (typedArray.hasValue(i2)) {
                this.f3836a.o = typedArray.getBoolean(i2, this.f3836a.o);
                c();
            }
            int i3 = R.styleable.ShimmerFrameLayout_shimmer_base_alpha;
            if (typedArray.hasValue(i3)) {
                wt1 wt1 = this.f3836a;
                wt1.e = (((int) (Math.min(1.0f, Math.max(0.0f, typedArray.getFloat(i3, 0.3f))) * 255.0f)) << 24) | (wt1.e & 16777215);
                c();
            }
            int i4 = R.styleable.ShimmerFrameLayout_shimmer_highlight_alpha;
            if (typedArray.hasValue(i4)) {
                wt1 wt12 = this.f3836a;
                wt12.d = (((int) (Math.min(1.0f, Math.max(0.0f, typedArray.getFloat(i4, 1.0f))) * 255.0f)) << 24) | (16777215 & wt12.d);
                c();
            }
            int i5 = R.styleable.ShimmerFrameLayout_shimmer_duration;
            if (typedArray.hasValue(i5)) {
                long j = (long) typedArray.getInt(i5, (int) this.f3836a.s);
                if (j >= 0) {
                    this.f3836a.s = j;
                    c();
                } else {
                    throw new IllegalArgumentException(hj1.M("Given a negative duration: ", j));
                }
            }
            int i6 = R.styleable.ShimmerFrameLayout_shimmer_repeat_count;
            if (typedArray.hasValue(i6)) {
                this.f3836a.q = typedArray.getInt(i6, this.f3836a.q);
                c();
            }
            int i7 = R.styleable.ShimmerFrameLayout_shimmer_repeat_delay;
            if (typedArray.hasValue(i7)) {
                long j2 = (long) typedArray.getInt(i7, (int) this.f3836a.t);
                if (j2 >= 0) {
                    this.f3836a.t = j2;
                    c();
                } else {
                    throw new IllegalArgumentException(hj1.M("Given a negative repeat delay: ", j2));
                }
            }
            int i8 = R.styleable.ShimmerFrameLayout_shimmer_repeat_mode;
            if (typedArray.hasValue(i8)) {
                this.f3836a.r = typedArray.getInt(i8, this.f3836a.r);
                c();
            }
            int i9 = R.styleable.ShimmerFrameLayout_shimmer_direction;
            if (typedArray.hasValue(i9)) {
                int i10 = typedArray.getInt(i9, this.f3836a.c);
                if (i10 == 1) {
                    d(1);
                } else if (i10 == 2) {
                    d(2);
                } else if (i10 != 3) {
                    d(0);
                } else {
                    d(3);
                }
            }
            int i11 = R.styleable.ShimmerFrameLayout_shimmer_shape;
            if (typedArray.hasValue(i11)) {
                if (typedArray.getInt(i11, this.f3836a.f) != 1) {
                    this.f3836a.f = 0;
                    c();
                } else {
                    this.f3836a.f = 1;
                    c();
                }
            }
            int i12 = R.styleable.ShimmerFrameLayout_shimmer_dropoff;
            if (typedArray.hasValue(i12)) {
                float f = typedArray.getFloat(i12, this.f3836a.l);
                if (f >= 0.0f) {
                    this.f3836a.l = f;
                    c();
                } else {
                    throw new IllegalArgumentException("Given invalid dropoff value: " + f);
                }
            }
            int i13 = R.styleable.ShimmerFrameLayout_shimmer_fixed_width;
            if (typedArray.hasValue(i13)) {
                int dimensionPixelSize = typedArray.getDimensionPixelSize(i13, this.f3836a.g);
                if (dimensionPixelSize >= 0) {
                    this.f3836a.g = dimensionPixelSize;
                    c();
                } else {
                    throw new IllegalArgumentException(hj1.I("Given invalid width: ", dimensionPixelSize));
                }
            }
            int i14 = R.styleable.ShimmerFrameLayout_shimmer_fixed_height;
            if (typedArray.hasValue(i14)) {
                int dimensionPixelSize2 = typedArray.getDimensionPixelSize(i14, this.f3836a.h);
                if (dimensionPixelSize2 >= 0) {
                    this.f3836a.h = dimensionPixelSize2;
                    c();
                } else {
                    throw new IllegalArgumentException(hj1.I("Given invalid height: ", dimensionPixelSize2));
                }
            }
            int i15 = R.styleable.ShimmerFrameLayout_shimmer_intensity;
            if (typedArray.hasValue(i15)) {
                float f2 = typedArray.getFloat(i15, this.f3836a.k);
                if (f2 >= 0.0f) {
                    this.f3836a.k = f2;
                    c();
                } else {
                    throw new IllegalArgumentException("Given invalid intensity value: " + f2);
                }
            }
            int i16 = R.styleable.ShimmerFrameLayout_shimmer_width_ratio;
            if (typedArray.hasValue(i16)) {
                float f3 = typedArray.getFloat(i16, this.f3836a.i);
                if (f3 >= 0.0f) {
                    this.f3836a.i = f3;
                    c();
                } else {
                    throw new IllegalArgumentException("Given invalid width ratio: " + f3);
                }
            }
            int i17 = R.styleable.ShimmerFrameLayout_shimmer_height_ratio;
            if (typedArray.hasValue(i17)) {
                float f4 = typedArray.getFloat(i17, this.f3836a.j);
                if (f4 >= 0.0f) {
                    this.f3836a.j = f4;
                    c();
                } else {
                    throw new IllegalArgumentException("Given invalid height ratio: " + f4);
                }
            }
            int i18 = R.styleable.ShimmerFrameLayout_shimmer_tilt;
            if (typedArray.hasValue(i18)) {
                this.f3836a.m = typedArray.getFloat(i18, this.f3836a.m);
                c();
            }
            return c();
        }

        public abstract T c();

        public T d(int i) {
            this.f3836a.c = i;
            return c();
        }
    }

    /* renamed from: wt1$c */
    /* compiled from: Shimmer */
    public static class c extends b<c> {
        public c() {
            this.f3836a.p = false;
        }

        /* Return type fixed from 'wt1$b' to match base method */
        @Override // defpackage.wt1.b
        public c b(TypedArray typedArray) {
            super.b(typedArray);
            int i = R.styleable.ShimmerFrameLayout_shimmer_base_color;
            if (typedArray.hasValue(i)) {
                int color = typedArray.getColor(i, this.f3836a.e);
                wt1 wt1 = this.f3836a;
                wt1.e = (color & 16777215) | (wt1.e & -16777216);
            }
            int i2 = R.styleable.ShimmerFrameLayout_shimmer_highlight_color;
            if (typedArray.hasValue(i2)) {
                this.f3836a.d = typedArray.getColor(i2, this.f3836a.d);
            }
            return this;
        }

        /* Return type fixed from 'wt1$b' to match base method */
        @Override // defpackage.wt1.b
        public c c() {
            return this;
        }
    }

    public wt1() {
        new RectF();
        this.c = 0;
        this.d = -1;
        this.e = 1291845631;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 1.0f;
        this.j = 1.0f;
        this.k = 0.0f;
        this.l = 0.5f;
        this.m = 20.0f;
        this.n = true;
        this.o = true;
        this.p = true;
        this.q = -1;
        this.r = 1;
        this.s = 1000;
    }
}
