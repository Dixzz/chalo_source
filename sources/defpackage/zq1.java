package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import defpackage.dr1;

/* renamed from: zq1  reason: default package */
/* compiled from: GifDrawable */
public class zq1 extends Drawable implements dr1.b, Animatable {
    public final a f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j = true;
    public int k;
    public int l = -1;
    public boolean m;
    public Paint n;
    public Rect o;

    /* renamed from: zq1$a */
    /* compiled from: GifDrawable */
    public static class a extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        public final zn1 f4201a;
        public final dr1 b;

        public a(zn1 zn1, dr1 dr1) {
            this.f4201a = zn1;
            this.b = dr1;
        }

        public int getChangingConfigurations() {
            return 0;
        }

        public Drawable newDrawable() {
            return new zq1(this);
        }

        public Drawable newDrawable(Resources resources) {
            return new zq1(this);
        }
    }

    public zq1(Context context, sl1 sl1, zn1 zn1, im1<Bitmap> im1, int i2, int i3, Bitmap bitmap) {
        a aVar = new a(zn1, new dr1(gl1.b(context), sl1, i2, i3, im1, bitmap));
        this.f = aVar;
    }

    @Override // defpackage.dr1.b
    public void a() {
        if (getCallback() == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        dr1 dr1 = this.f.b;
        dr1.a aVar = dr1.i;
        if ((aVar != null ? aVar.j : -1) == dr1.f881a.c() - 1) {
            this.k++;
        }
        int i2 = this.l;
        if (i2 != -1 && this.k >= i2) {
            stop();
        }
    }

    public final Paint b() {
        if (this.n == null) {
            this.n = new Paint(2);
        }
        return this.n;
    }

    public final void c() {
        gj1.d(!this.i, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.f.b.f881a.c() == 1) {
            invalidateSelf();
        } else if (!this.g) {
            this.g = true;
            dr1 dr1 = this.f.b;
            if (!dr1.j) {
                boolean isEmpty = dr1.c.isEmpty();
                if (!dr1.c.contains(this)) {
                    dr1.c.add(this);
                    if (isEmpty && !dr1.f) {
                        dr1.f = true;
                        dr1.j = false;
                        dr1.b();
                    }
                    invalidateSelf();
                    return;
                }
                throw new IllegalStateException("Cannot subscribe twice in a row");
            }
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        }
    }

    public final void d() {
        this.g = false;
        dr1 dr1 = this.f.b;
        dr1.c.remove(this);
        if (dr1.c.isEmpty()) {
            dr1.f = false;
        }
    }

    public void draw(Canvas canvas) {
        if (!this.i) {
            if (this.m) {
                int intrinsicWidth = getIntrinsicWidth();
                int intrinsicHeight = getIntrinsicHeight();
                Rect bounds = getBounds();
                if (this.o == null) {
                    this.o = new Rect();
                }
                Gravity.apply(119, intrinsicWidth, intrinsicHeight, bounds, this.o);
                this.m = false;
            }
            Bitmap a2 = this.f.b.a();
            if (this.o == null) {
                this.o = new Rect();
            }
            canvas.drawBitmap(a2, (Rect) null, this.o, b());
        }
    }

    public Drawable.ConstantState getConstantState() {
        return this.f;
    }

    public int getIntrinsicHeight() {
        return this.f.b.a().getHeight();
    }

    public int getIntrinsicWidth() {
        return this.f.b.a().getWidth();
    }

    public int getOpacity() {
        return -2;
    }

    public boolean isRunning() {
        return this.g;
    }

    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.m = true;
    }

    public void setAlpha(int i2) {
        b().setAlpha(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        b().setColorFilter(colorFilter);
    }

    public boolean setVisible(boolean z, boolean z2) {
        gj1.d(!this.i, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.j = z;
        if (!z) {
            d();
        } else if (this.h) {
            c();
        }
        return super.setVisible(z, z2);
    }

    public void start() {
        this.h = true;
        this.k = 0;
        if (this.j) {
            c();
        }
    }

    public void stop() {
        this.h = false;
        d();
    }

    public zq1(a aVar) {
        this.f = aVar;
    }
}
