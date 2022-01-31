package defpackage;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.google.firebase.perf.util.Constants;
import defpackage.kn4;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* renamed from: ml4  reason: default package */
/* compiled from: ChipDrawable */
public class ml4 extends ho4 implements l6, Drawable.Callback, kn4.b {
    public static final int[] M0 = {16842910};
    public static final ShapeDrawable N0 = new ShapeDrawable(new OvalShape());
    public ColorFilter A0;
    public PorterDuffColorFilter B0;
    public ColorStateList C0;
    public ColorStateList D;
    public PorterDuff.Mode D0 = PorterDuff.Mode.SRC_IN;
    public ColorStateList E;
    public int[] E0;
    public float F;
    public boolean F0;
    public float G = -1.0f;
    public ColorStateList G0;
    public ColorStateList H;
    public WeakReference<a> H0 = new WeakReference<>(null);
    public float I;
    public TextUtils.TruncateAt I0;
    public ColorStateList J;
    public boolean J0;
    public CharSequence K;
    public int K0;
    public boolean L;
    public boolean L0;
    public Drawable M;
    public ColorStateList N;
    public float O;
    public boolean P;
    public boolean Q;
    public Drawable R;
    public Drawable S;
    public ColorStateList T;
    public float U;
    public CharSequence V;
    public boolean W;
    public boolean X;
    public Drawable Y;
    public ColorStateList Z;
    public fk4 a0;
    public fk4 b0;
    public float c0;
    public float d0;
    public float e0;
    public float f0;
    public float g0;
    public float h0;
    public float i0;
    public float j0;
    public final Context k0;
    public final Paint l0 = new Paint(1);
    public final Paint.FontMetrics m0 = new Paint.FontMetrics();
    public final RectF n0 = new RectF();
    public final PointF o0 = new PointF();
    public final Path p0 = new Path();
    public final kn4 q0;
    public int r0;
    public int s0;
    public int t0;
    public int u0;
    public int v0;
    public int w0;
    public boolean x0;
    public int y0;
    public int z0 = Constants.MAX_HOST_LENGTH;

    /* renamed from: ml4$a */
    /* compiled from: ChipDrawable */
    public interface a {
        void a();
    }

    public ml4(Context context, AttributeSet attributeSet, int i, int i2) {
        super(ko4.b(context, attributeSet, i, i2).a());
        this.f.b = new tm4(context);
        y();
        this.k0 = context;
        kn4 kn4 = new kn4(this);
        this.q0 = kn4;
        this.K = "";
        kn4.f2086a.density = context.getResources().getDisplayMetrics().density;
        int[] iArr = M0;
        setState(iArr);
        f0(iArr);
        this.J0 = true;
        int[] iArr2 = yn4.f4071a;
        N0.setTint(-1);
    }

    public static boolean I(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    public static boolean J(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    public final void A(Rect rect, RectF rectF) {
        float f;
        rectF.setEmpty();
        if (q0() || p0()) {
            float f2 = this.c0 + this.d0;
            float H2 = H();
            if (h.M(this) == 0) {
                float f3 = ((float) rect.left) + f2;
                rectF.left = f3;
                rectF.right = f3 + H2;
            } else {
                float f4 = ((float) rect.right) - f2;
                rectF.right = f4;
                rectF.left = f4 - H2;
            }
            Drawable drawable = this.x0 ? this.Y : this.M;
            float f5 = this.O;
            if (f5 <= 0.0f && drawable != null) {
                f5 = (float) Math.ceil((double) hd3.K0(this.k0, 24));
                if (((float) drawable.getIntrinsicHeight()) <= f5) {
                    f = (float) drawable.getIntrinsicHeight();
                    float exactCenterY = rect.exactCenterY() - (f / 2.0f);
                    rectF.top = exactCenterY;
                    rectF.bottom = exactCenterY + f;
                }
            }
            f = f5;
            float exactCenterY2 = rect.exactCenterY() - (f / 2.0f);
            rectF.top = exactCenterY2;
            rectF.bottom = exactCenterY2 + f;
        }
    }

    public float B() {
        if (!q0() && !p0()) {
            return 0.0f;
        }
        return H() + this.d0 + this.e0;
    }

    public final void C(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (r0()) {
            float f = this.j0 + this.i0;
            if (h.M(this) == 0) {
                float f2 = ((float) rect.right) - f;
                rectF.right = f2;
                rectF.left = f2 - this.U;
            } else {
                float f3 = ((float) rect.left) + f;
                rectF.left = f3;
                rectF.right = f3 + this.U;
            }
            float exactCenterY = rect.exactCenterY();
            float f4 = this.U;
            float f5 = exactCenterY - (f4 / 2.0f);
            rectF.top = f5;
            rectF.bottom = f5 + f4;
        }
    }

    public final void D(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (r0()) {
            float f = this.j0 + this.i0 + this.U + this.h0 + this.g0;
            if (h.M(this) == 0) {
                float f2 = (float) rect.right;
                rectF.right = f2;
                rectF.left = f2 - f;
            } else {
                int i = rect.left;
                rectF.left = (float) i;
                rectF.right = ((float) i) + f;
            }
            rectF.top = (float) rect.top;
            rectF.bottom = (float) rect.bottom;
        }
    }

    public float E() {
        if (r0()) {
            return this.h0 + this.U + this.i0;
        }
        return 0.0f;
    }

    public float F() {
        return this.L0 ? l() : this.G;
    }

    public Drawable G() {
        Drawable drawable = this.R;
        if (drawable != null) {
            return h.E0(drawable);
        }
        return null;
    }

    public final float H() {
        Drawable drawable = this.x0 ? this.Y : this.M;
        float f = this.O;
        return (f > 0.0f || drawable == null) ? f : (float) drawable.getIntrinsicWidth();
    }

    public void K() {
        a aVar = this.H0.get();
        if (aVar != null) {
            aVar.a();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x014d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean L(int[] r9, int[] r10) {
        /*
        // Method dump skipped, instructions count: 337
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ml4.L(int[], int[]):boolean");
    }

    public void M(boolean z) {
        if (this.W != z) {
            this.W = z;
            float B = B();
            if (!z && this.x0) {
                this.x0 = false;
            }
            float B2 = B();
            invalidateSelf();
            if (B != B2) {
                K();
            }
        }
    }

    public void N(Drawable drawable) {
        if (this.Y != drawable) {
            float B = B();
            this.Y = drawable;
            float B2 = B();
            s0(this.Y);
            z(this.Y);
            invalidateSelf();
            if (B != B2) {
                K();
            }
        }
    }

    public void O(ColorStateList colorStateList) {
        if (this.Z != colorStateList) {
            this.Z = colorStateList;
            if (this.X && this.Y != null && this.W) {
                this.Y.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void P(boolean z) {
        if (this.X != z) {
            boolean p02 = p0();
            this.X = z;
            boolean p03 = p0();
            if (p02 != p03) {
                if (p03) {
                    z(this.Y);
                } else {
                    s0(this.Y);
                }
                invalidateSelf();
                K();
            }
        }
    }

    public void Q(ColorStateList colorStateList) {
        if (this.E != colorStateList) {
            this.E = colorStateList;
            onStateChange(getState());
        }
    }

    @Deprecated
    public void R(float f) {
        if (this.G != f) {
            this.G = f;
            this.f.f1403a = this.f.f1403a.e(f);
            invalidateSelf();
        }
    }

    public void S(float f) {
        if (this.j0 != f) {
            this.j0 = f;
            invalidateSelf();
            K();
        }
    }

    public void T(Drawable drawable) {
        Drawable drawable2 = this.M;
        Drawable drawable3 = null;
        Drawable E02 = drawable2 != null ? h.E0(drawable2) : null;
        if (E02 != drawable) {
            float B = B();
            if (drawable != null) {
                drawable3 = h.H0(drawable).mutate();
            }
            this.M = drawable3;
            float B2 = B();
            s0(E02);
            if (q0()) {
                z(this.M);
            }
            invalidateSelf();
            if (B != B2) {
                K();
            }
        }
    }

    public void U(float f) {
        if (this.O != f) {
            float B = B();
            this.O = f;
            float B2 = B();
            invalidateSelf();
            if (B != B2) {
                K();
            }
        }
    }

    public void V(ColorStateList colorStateList) {
        this.P = true;
        if (this.N != colorStateList) {
            this.N = colorStateList;
            if (q0()) {
                this.M.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void W(boolean z) {
        if (this.L != z) {
            boolean q02 = q0();
            this.L = z;
            boolean q03 = q0();
            if (q02 != q03) {
                if (q03) {
                    z(this.M);
                } else {
                    s0(this.M);
                }
                invalidateSelf();
                K();
            }
        }
    }

    public void X(float f) {
        if (this.F != f) {
            this.F = f;
            invalidateSelf();
            K();
        }
    }

    public void Y(float f) {
        if (this.c0 != f) {
            this.c0 = f;
            invalidateSelf();
            K();
        }
    }

    public void Z(ColorStateList colorStateList) {
        if (this.H != colorStateList) {
            this.H = colorStateList;
            if (this.L0) {
                v(colorStateList);
            }
            onStateChange(getState());
        }
    }

    @Override // defpackage.kn4.b
    public void a() {
        K();
        invalidateSelf();
    }

    public void a0(float f) {
        if (this.I != f) {
            this.I = f;
            this.l0.setStrokeWidth(f);
            if (this.L0) {
                this.f.l = f;
                invalidateSelf();
            }
            invalidateSelf();
        }
    }

    public void b0(Drawable drawable) {
        Drawable G2 = G();
        if (G2 != drawable) {
            float E2 = E();
            this.R = drawable != null ? h.H0(drawable).mutate() : null;
            int[] iArr = yn4.f4071a;
            this.S = new RippleDrawable(yn4.b(this.J), this.R, N0);
            float E3 = E();
            s0(G2);
            if (r0()) {
                z(this.R);
            }
            invalidateSelf();
            if (E2 != E3) {
                K();
            }
        }
    }

    public void c0(float f) {
        if (this.i0 != f) {
            this.i0 = f;
            invalidateSelf();
            if (r0()) {
                K();
            }
        }
    }

    public void d0(float f) {
        if (this.U != f) {
            this.U = f;
            invalidateSelf();
            if (r0()) {
                K();
            }
        }
    }

    @Override // defpackage.ho4
    public void draw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        Rect bounds = getBounds();
        if (!bounds.isEmpty() && (i = this.z0) != 0) {
            if (i < 255) {
                float f = (float) bounds.left;
                float f2 = (float) bounds.top;
                float f3 = (float) bounds.right;
                float f4 = (float) bounds.bottom;
                if (Build.VERSION.SDK_INT > 21) {
                    i8 = canvas.saveLayerAlpha(f, f2, f3, f4, i);
                } else {
                    i8 = canvas.saveLayerAlpha(f, f2, f3, f4, i, 31);
                }
                i2 = i8;
            } else {
                i2 = 0;
            }
            if (!this.L0) {
                this.l0.setColor(this.r0);
                this.l0.setStyle(Paint.Style.FILL);
                this.n0.set(bounds);
                canvas.drawRoundRect(this.n0, F(), F(), this.l0);
            }
            if (!this.L0) {
                this.l0.setColor(this.s0);
                this.l0.setStyle(Paint.Style.FILL);
                Paint paint = this.l0;
                ColorFilter colorFilter = this.A0;
                if (colorFilter == null) {
                    colorFilter = this.B0;
                }
                paint.setColorFilter(colorFilter);
                this.n0.set(bounds);
                canvas.drawRoundRect(this.n0, F(), F(), this.l0);
            }
            if (this.L0) {
                super.draw(canvas);
            }
            if (this.I > 0.0f && !this.L0) {
                this.l0.setColor(this.u0);
                this.l0.setStyle(Paint.Style.STROKE);
                if (!this.L0) {
                    Paint paint2 = this.l0;
                    ColorFilter colorFilter2 = this.A0;
                    if (colorFilter2 == null) {
                        colorFilter2 = this.B0;
                    }
                    paint2.setColorFilter(colorFilter2);
                }
                RectF rectF = this.n0;
                float f5 = this.I / 2.0f;
                rectF.set(((float) bounds.left) + f5, ((float) bounds.top) + f5, ((float) bounds.right) - f5, ((float) bounds.bottom) - f5);
                float f6 = this.G - (this.I / 2.0f);
                canvas.drawRoundRect(this.n0, f6, f6, this.l0);
            }
            this.l0.setColor(this.v0);
            this.l0.setStyle(Paint.Style.FILL);
            this.n0.set(bounds);
            if (!this.L0) {
                canvas.drawRoundRect(this.n0, F(), F(), this.l0);
                i3 = 0;
            } else {
                c(new RectF(bounds), this.p0);
                i3 = 0;
                g(canvas, this.l0, this.p0, this.f.f1403a, h());
            }
            if (q0()) {
                A(bounds, this.n0);
                RectF rectF2 = this.n0;
                float f7 = rectF2.left;
                float f8 = rectF2.top;
                canvas.translate(f7, f8);
                this.M.setBounds(i3, i3, (int) this.n0.width(), (int) this.n0.height());
                this.M.draw(canvas);
                canvas.translate(-f7, -f8);
            }
            if (p0()) {
                A(bounds, this.n0);
                RectF rectF3 = this.n0;
                float f9 = rectF3.left;
                float f10 = rectF3.top;
                canvas.translate(f9, f10);
                this.Y.setBounds(i3, i3, (int) this.n0.width(), (int) this.n0.height());
                this.Y.draw(canvas);
                canvas.translate(-f9, -f10);
            }
            if (!this.J0 || this.K == null) {
                i6 = i2;
                i5 = Constants.MAX_HOST_LENGTH;
                i4 = 0;
            } else {
                PointF pointF = this.o0;
                pointF.set(0.0f, 0.0f);
                Paint.Align align = Paint.Align.LEFT;
                if (this.K != null) {
                    float B = B() + this.c0 + this.f0;
                    if (h.M(this) == 0) {
                        pointF.x = ((float) bounds.left) + B;
                        align = Paint.Align.LEFT;
                    } else {
                        pointF.x = ((float) bounds.right) - B;
                        align = Paint.Align.RIGHT;
                    }
                    this.q0.f2086a.getFontMetrics(this.m0);
                    Paint.FontMetrics fontMetrics = this.m0;
                    pointF.y = ((float) bounds.centerY()) - ((fontMetrics.descent + fontMetrics.ascent) / 2.0f);
                }
                RectF rectF4 = this.n0;
                rectF4.setEmpty();
                if (this.K != null) {
                    float B2 = B() + this.c0 + this.f0;
                    float E2 = E() + this.j0 + this.g0;
                    if (h.M(this) == 0) {
                        rectF4.left = ((float) bounds.left) + B2;
                        rectF4.right = ((float) bounds.right) - E2;
                    } else {
                        rectF4.left = ((float) bounds.left) + E2;
                        rectF4.right = ((float) bounds.right) - B2;
                    }
                    rectF4.top = (float) bounds.top;
                    rectF4.bottom = (float) bounds.bottom;
                }
                kn4 kn4 = this.q0;
                if (kn4.f != null) {
                    kn4.f2086a.drawableState = getState();
                    kn4 kn42 = this.q0;
                    kn42.f.c(this.k0, kn42.f2086a, kn42.b);
                }
                this.q0.f2086a.setTextAlign(align);
                boolean z = Math.round(this.q0.a(this.K.toString())) > Math.round(this.n0.width());
                if (z) {
                    i7 = canvas.save();
                    canvas.clipRect(this.n0);
                } else {
                    i7 = 0;
                }
                CharSequence charSequence = this.K;
                if (z && this.I0 != null) {
                    charSequence = TextUtils.ellipsize(charSequence, this.q0.f2086a, this.n0.width(), this.I0);
                }
                int length = charSequence.length();
                PointF pointF2 = this.o0;
                float f11 = pointF2.x;
                float f12 = pointF2.y;
                TextPaint textPaint = this.q0.f2086a;
                i4 = 0;
                i5 = Constants.MAX_HOST_LENGTH;
                i6 = i2;
                canvas.drawText(charSequence, 0, length, f11, f12, textPaint);
                if (z) {
                    canvas.restoreToCount(i7);
                }
            }
            if (r0()) {
                C(bounds, this.n0);
                RectF rectF5 = this.n0;
                float f13 = rectF5.left;
                float f14 = rectF5.top;
                canvas.translate(f13, f14);
                this.R.setBounds(i4, i4, (int) this.n0.width(), (int) this.n0.height());
                int[] iArr = yn4.f4071a;
                this.S.setBounds(this.R.getBounds());
                this.S.jumpToCurrentState();
                this.S.draw(canvas);
                canvas.translate(-f13, -f14);
            }
            if (this.z0 < i5) {
                canvas.restoreToCount(i6);
            }
        }
    }

    public void e0(float f) {
        if (this.h0 != f) {
            this.h0 = f;
            invalidateSelf();
            if (r0()) {
                K();
            }
        }
    }

    public boolean f0(int[] iArr) {
        if (Arrays.equals(this.E0, iArr)) {
            return false;
        }
        this.E0 = iArr;
        if (r0()) {
            return L(getState(), iArr);
        }
        return false;
    }

    public void g0(ColorStateList colorStateList) {
        if (this.T != colorStateList) {
            this.T = colorStateList;
            if (r0()) {
                this.R.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public int getAlpha() {
        return this.z0;
    }

    public ColorFilter getColorFilter() {
        return this.A0;
    }

    public int getIntrinsicHeight() {
        return (int) this.F;
    }

    public int getIntrinsicWidth() {
        return Math.min(Math.round(E() + this.q0.a(this.K.toString()) + B() + this.c0 + this.f0 + this.g0 + this.j0), this.K0);
    }

    @Override // defpackage.ho4
    public int getOpacity() {
        return -3;
    }

    @Override // defpackage.ho4
    @TargetApi(21)
    public void getOutline(Outline outline) {
        if (this.L0) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (!bounds.isEmpty()) {
            outline.setRoundRect(bounds, this.G);
        } else {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), (int) this.F, this.G);
        }
        outline.setAlpha(((float) this.z0) / 255.0f);
    }

    public void h0(boolean z) {
        if (this.Q != z) {
            boolean r02 = r0();
            this.Q = z;
            boolean r03 = r0();
            if (r02 != r03) {
                if (r03) {
                    z(this.R);
                } else {
                    s0(this.R);
                }
                invalidateSelf();
                K();
            }
        }
    }

    public void i0(float f) {
        if (this.e0 != f) {
            float B = B();
            this.e0 = f;
            float B2 = B();
            invalidateSelf();
            if (B != B2) {
                K();
            }
        }
    }

    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // defpackage.ho4
    public boolean isStateful() {
        ColorStateList colorStateList;
        if (I(this.D) || I(this.E) || I(this.H)) {
            return true;
        }
        if (this.F0 && I(this.G0)) {
            return true;
        }
        vn4 vn4 = this.q0.f;
        if ((vn4 == null || (colorStateList = vn4.f3665a) == null || !colorStateList.isStateful()) ? false : true) {
            return true;
        }
        if ((this.X && this.Y != null && this.W) || J(this.M) || J(this.Y) || I(this.C0)) {
            return true;
        }
        return false;
    }

    public void j0(float f) {
        if (this.d0 != f) {
            float B = B();
            this.d0 = f;
            float B2 = B();
            invalidateSelf();
            if (B != B2) {
                K();
            }
        }
    }

    public void k0(ColorStateList colorStateList) {
        if (this.J != colorStateList) {
            this.J = colorStateList;
            this.G0 = this.F0 ? yn4.b(colorStateList) : null;
            onStateChange(getState());
        }
    }

    public void l0(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (!TextUtils.equals(this.K, charSequence)) {
            this.K = charSequence;
            this.q0.d = true;
            invalidateSelf();
            K();
        }
    }

    public void m0(float f) {
        if (this.g0 != f) {
            this.g0 = f;
            invalidateSelf();
            K();
        }
    }

    public void n0(float f) {
        if (this.f0 != f) {
            this.f0 = f;
            invalidateSelf();
            K();
        }
    }

    public void o0(boolean z) {
        if (this.F0 != z) {
            this.F0 = z;
            this.G0 = z ? yn4.b(this.J) : null;
            onStateChange(getState());
        }
    }

    public boolean onLayoutDirectionChanged(int i) {
        boolean onLayoutDirectionChanged = super.onLayoutDirectionChanged(i);
        if (q0()) {
            onLayoutDirectionChanged |= h.s0(this.M, i);
        }
        if (p0()) {
            onLayoutDirectionChanged |= h.s0(this.Y, i);
        }
        if (r0()) {
            onLayoutDirectionChanged |= h.s0(this.R, i);
        }
        if (!onLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    public boolean onLevelChange(int i) {
        boolean onLevelChange = super.onLevelChange(i);
        if (q0()) {
            onLevelChange |= this.M.setLevel(i);
        }
        if (p0()) {
            onLevelChange |= this.Y.setLevel(i);
        }
        if (r0()) {
            onLevelChange |= this.R.setLevel(i);
        }
        if (onLevelChange) {
            invalidateSelf();
        }
        return onLevelChange;
    }

    @Override // defpackage.kn4.b, defpackage.ho4
    public boolean onStateChange(int[] iArr) {
        if (this.L0) {
            super.onStateChange(iArr);
        }
        return L(iArr, this.E0);
    }

    public final boolean p0() {
        return this.X && this.Y != null && this.x0;
    }

    public final boolean q0() {
        return this.L && this.M != null;
    }

    public final boolean r0() {
        return this.Q && this.R != null;
    }

    public final void s0(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    @Override // defpackage.ho4
    public void setAlpha(int i) {
        if (this.z0 != i) {
            this.z0 = i;
            invalidateSelf();
        }
    }

    @Override // defpackage.ho4
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.A0 != colorFilter) {
            this.A0 = colorFilter;
            invalidateSelf();
        }
    }

    @Override // defpackage.ho4
    public void setTintList(ColorStateList colorStateList) {
        if (this.C0 != colorStateList) {
            this.C0 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // defpackage.ho4
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.D0 != mode) {
            this.D0 = mode;
            this.B0 = hd3.f3(this, this.C0, mode);
            invalidateSelf();
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (q0()) {
            visible |= this.M.setVisible(z, z2);
        }
        if (p0()) {
            visible |= this.Y.setVisible(z, z2);
        }
        if (r0()) {
            visible |= this.R.setVisible(z, z2);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public final void z(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(this);
            h.s0(drawable, h.M(this));
            drawable.setLevel(getLevel());
            drawable.setVisible(isVisible(), false);
            if (drawable == this.R) {
                if (drawable.isStateful()) {
                    drawable.setState(this.E0);
                }
                drawable.setTintList(this.T);
                return;
            }
            if (drawable.isStateful()) {
                drawable.setState(getState());
            }
            Drawable drawable2 = this.M;
            if (drawable == drawable2 && this.P) {
                drawable2.setTintList(this.N);
            }
        }
    }
}
