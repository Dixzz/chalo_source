package com.theartofdev.edmodo.cropper;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ScaleGestureDetector;
import android.view.View;
import com.theartofdev.edmodo.cropper.CropImageView;
import java.util.Arrays;
import java.util.Objects;

public class CropOverlayView extends View {
    public int A;
    public int B;
    public float C = (((float) this.A) / ((float) this.B));
    public CropImageView.d D;
    public CropImageView.c E;
    public final Rect F = new Rect();
    public boolean G;
    public ScaleGestureDetector f;
    public boolean g;
    public final yf5 h = new yf5();
    public b i;
    public final RectF j = new RectF();
    public Paint k;
    public Paint l;
    public Paint m;
    public Paint n;
    public Path o = new Path();
    public final float[] p = new float[8];
    public final RectF q = new RectF();
    public int r;
    public int s;
    public float t;
    public float u;
    public float v;
    public float w;
    public float x;
    public zf5 y;
    public boolean z;

    public interface b {
    }

    public class c extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        public c(a aVar) {
        }

        @TargetApi(11)
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            RectF e = CropOverlayView.this.h.e();
            float focusX = scaleGestureDetector.getFocusX();
            float focusY = scaleGestureDetector.getFocusY();
            float currentSpanY = scaleGestureDetector.getCurrentSpanY() / 2.0f;
            float currentSpanX = scaleGestureDetector.getCurrentSpanX() / 2.0f;
            float f = focusY - currentSpanY;
            float f2 = focusX - currentSpanX;
            float f3 = focusX + currentSpanX;
            float f4 = focusY + currentSpanY;
            if (f2 >= f3 || f > f4 || f2 < 0.0f || f3 > CropOverlayView.this.h.b() || f < 0.0f || f4 > CropOverlayView.this.h.a()) {
                return true;
            }
            e.set(f2, f, f3, f4);
            CropOverlayView.this.h.f4044a.set(e);
            CropOverlayView.this.invalidate();
            return true;
        }
    }

    public CropOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public static Paint e(float f2, int i2) {
        if (f2 <= 0.0f) {
            return null;
        }
        Paint paint = new Paint();
        paint.setColor(i2);
        paint.setStrokeWidth(f2);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        return paint;
    }

    public final boolean a(RectF rectF) {
        float q2 = uf5.q(this.p);
        float s2 = uf5.s(this.p);
        float r2 = uf5.r(this.p);
        float l2 = uf5.l(this.p);
        if (!g()) {
            this.q.set(q2, s2, r2, l2);
            return false;
        }
        float[] fArr = this.p;
        float f2 = fArr[0];
        float f3 = fArr[1];
        float f4 = fArr[4];
        float f5 = fArr[5];
        float f6 = fArr[6];
        float f7 = fArr[7];
        if (fArr[7] < fArr[1]) {
            if (fArr[1] < fArr[3]) {
                f2 = fArr[6];
                f3 = fArr[7];
                f4 = fArr[2];
                f5 = fArr[3];
                f6 = fArr[4];
                f7 = fArr[5];
            } else {
                f2 = fArr[4];
                f3 = fArr[5];
                f4 = fArr[0];
                f5 = fArr[1];
                f6 = fArr[2];
                f7 = fArr[3];
            }
        } else if (fArr[1] > fArr[3]) {
            f2 = fArr[2];
            f3 = fArr[3];
            f4 = fArr[6];
            f5 = fArr[7];
            f6 = fArr[0];
            f7 = fArr[1];
        }
        float f8 = (f7 - f3) / (f6 - f2);
        float f9 = -1.0f / f8;
        float f10 = f3 - (f8 * f2);
        float f11 = f3 - (f2 * f9);
        float f12 = f5 - (f8 * f4);
        float f13 = f5 - (f4 * f9);
        float centerY = rectF.centerY() - rectF.top;
        float centerX = rectF.centerX();
        float f14 = rectF.left;
        float f15 = centerY / (centerX - f14);
        float f16 = -f15;
        float f17 = rectF.top;
        float f18 = f17 - (f14 * f15);
        float f19 = rectF.right;
        float f20 = f17 - (f16 * f19);
        float f21 = f8 - f15;
        float f22 = (f18 - f10) / f21;
        float max = Math.max(q2, f22 < f19 ? f22 : q2);
        float f23 = (f18 - f11) / (f9 - f15);
        if (f23 >= rectF.right) {
            f23 = max;
        }
        float max2 = Math.max(max, f23);
        float f24 = f9 - f16;
        float f25 = (f20 - f13) / f24;
        if (f25 >= rectF.right) {
            f25 = max2;
        }
        float max3 = Math.max(max2, f25);
        float f26 = (f20 - f11) / f24;
        if (f26 <= rectF.left) {
            f26 = r2;
        }
        float min = Math.min(r2, f26);
        float f27 = (f20 - f12) / (f8 - f16);
        if (f27 <= rectF.left) {
            f27 = min;
        }
        float min2 = Math.min(min, f27);
        float f28 = (f18 - f12) / f21;
        if (f28 <= rectF.left) {
            f28 = min2;
        }
        float min3 = Math.min(min2, f28);
        float max4 = Math.max(s2, Math.max((f8 * max3) + f10, (f9 * min3) + f11));
        float min4 = Math.min(l2, Math.min((f9 * max3) + f13, (f8 * min3) + f12));
        RectF rectF2 = this.q;
        rectF2.left = max3;
        rectF2.top = max4;
        rectF2.right = min3;
        rectF2.bottom = min4;
        return true;
    }

    public final void b(boolean z2) {
        try {
            b bVar = this.i;
            if (bVar != null) {
                CropImageView.a aVar = (CropImageView.a) bVar;
                CropImageView cropImageView = CropImageView.this;
                int i2 = CropImageView.R;
                cropImageView.c(z2, true);
                CropImageView cropImageView2 = CropImageView.this;
                CropImageView.g gVar = cropImageView2.B;
                if (gVar != null && !z2) {
                    gVar.a(cropImageView2.getCropRect());
                }
                CropImageView cropImageView3 = CropImageView.this;
                CropImageView.f fVar = cropImageView3.C;
                if (fVar != null && z2) {
                    fVar.a(cropImageView3.getCropRect());
                }
            }
        } catch (Exception unused) {
        }
    }

    public final void c(Canvas canvas) {
        if (this.m != null) {
            Paint paint = this.k;
            float strokeWidth = paint != null ? paint.getStrokeWidth() : 0.0f;
            RectF e = this.h.e();
            e.inset(strokeWidth, strokeWidth);
            float width = e.width() / 3.0f;
            float height = e.height() / 3.0f;
            if (this.E == CropImageView.c.OVAL) {
                float width2 = (e.width() / 2.0f) - strokeWidth;
                float height2 = (e.height() / 2.0f) - strokeWidth;
                float f2 = e.left + width;
                float f3 = e.right - width;
                float sin = (float) (Math.sin(Math.acos((double) ((width2 - width) / width2))) * ((double) height2));
                canvas.drawLine(f2, (e.top + height2) - sin, f2, (e.bottom - height2) + sin, this.m);
                canvas.drawLine(f3, (e.top + height2) - sin, f3, (e.bottom - height2) + sin, this.m);
                float f4 = e.top + height;
                float f5 = e.bottom - height;
                float cos = (float) (Math.cos(Math.asin((double) ((height2 - height) / height2))) * ((double) width2));
                canvas.drawLine((e.left + width2) - cos, f4, (e.right - width2) + cos, f4, this.m);
                canvas.drawLine((e.left + width2) - cos, f5, (e.right - width2) + cos, f5, this.m);
                return;
            }
            float f6 = e.left + width;
            float f7 = e.right - width;
            canvas.drawLine(f6, e.top, f6, e.bottom, this.m);
            canvas.drawLine(f7, e.top, f7, e.bottom, this.m);
            float f8 = e.top + height;
            float f9 = e.bottom - height;
            canvas.drawLine(e.left, f8, e.right, f8, this.m);
            canvas.drawLine(e.left, f9, e.right, f9, this.m);
        }
    }

    public final void d(RectF rectF) {
        if (rectF.width() < this.h.d()) {
            float d = (this.h.d() - rectF.width()) / 2.0f;
            rectF.left -= d;
            rectF.right += d;
        }
        if (rectF.height() < this.h.c()) {
            float c2 = (this.h.c() - rectF.height()) / 2.0f;
            rectF.top -= c2;
            rectF.bottom += c2;
        }
        if (rectF.width() > this.h.b()) {
            float width = (rectF.width() - this.h.b()) / 2.0f;
            rectF.left += width;
            rectF.right -= width;
        }
        if (rectF.height() > this.h.a()) {
            float height = (rectF.height() - this.h.a()) / 2.0f;
            rectF.top += height;
            rectF.bottom -= height;
        }
        a(rectF);
        if (this.q.width() > 0.0f && this.q.height() > 0.0f) {
            float max = Math.max(this.q.left, 0.0f);
            float max2 = Math.max(this.q.top, 0.0f);
            float min = Math.min(this.q.right, (float) getWidth());
            float min2 = Math.min(this.q.bottom, (float) getHeight());
            if (rectF.left < max) {
                rectF.left = max;
            }
            if (rectF.top < max2) {
                rectF.top = max2;
            }
            if (rectF.right > min) {
                rectF.right = min;
            }
            if (rectF.bottom > min2) {
                rectF.bottom = min2;
            }
        }
        if (this.z && ((double) Math.abs(rectF.width() - (rectF.height() * this.C))) > 0.1d) {
            if (rectF.width() > rectF.height() * this.C) {
                float abs = Math.abs((rectF.height() * this.C) - rectF.width()) / 2.0f;
                rectF.left += abs;
                rectF.right -= abs;
                return;
            }
            float abs2 = Math.abs((rectF.width() / this.C) - rectF.height()) / 2.0f;
            rectF.top += abs2;
            rectF.bottom -= abs2;
        }
    }

    public final void f() {
        float max = Math.max(uf5.q(this.p), 0.0f);
        float max2 = Math.max(uf5.s(this.p), 0.0f);
        float min = Math.min(uf5.r(this.p), (float) getWidth());
        float min2 = Math.min(uf5.l(this.p), (float) getHeight());
        if (min > max && min2 > max2) {
            RectF rectF = new RectF();
            this.G = true;
            float f2 = this.v;
            float f3 = min - max;
            float f4 = f2 * f3;
            float f5 = min2 - max2;
            float f6 = f2 * f5;
            if (this.F.width() > 0 && this.F.height() > 0) {
                Rect rect = this.F;
                yf5 yf5 = this.h;
                float f7 = (((float) rect.left) / yf5.k) + max;
                rectF.left = f7;
                rectF.top = (((float) rect.top) / yf5.l) + max2;
                rectF.right = (((float) rect.width()) / this.h.k) + f7;
                rectF.bottom = (((float) this.F.height()) / this.h.l) + rectF.top;
                rectF.left = Math.max(max, rectF.left);
                rectF.top = Math.max(max2, rectF.top);
                rectF.right = Math.min(min, rectF.right);
                rectF.bottom = Math.min(min2, rectF.bottom);
            } else if (!this.z || min <= max || min2 <= max2) {
                rectF.left = max + f4;
                rectF.top = max2 + f6;
                rectF.right = min - f4;
                rectF.bottom = min2 - f6;
            } else if (f3 / f5 > this.C) {
                rectF.top = max2 + f6;
                rectF.bottom = min2 - f6;
                float width = ((float) getWidth()) / 2.0f;
                this.C = ((float) this.A) / ((float) this.B);
                float max3 = Math.max(this.h.d(), rectF.height() * this.C) / 2.0f;
                rectF.left = width - max3;
                rectF.right = width + max3;
            } else {
                rectF.left = max + f4;
                rectF.right = min - f4;
                float height = ((float) getHeight()) / 2.0f;
                float max4 = Math.max(this.h.c(), rectF.width() / this.C) / 2.0f;
                rectF.top = height - max4;
                rectF.bottom = height + max4;
            }
            d(rectF);
            this.h.f4044a.set(rectF);
        }
    }

    public final boolean g() {
        float[] fArr = this.p;
        return (fArr[0] == fArr[6] || fArr[1] == fArr[7]) ? false : true;
    }

    public int getAspectRatioX() {
        return this.A;
    }

    public int getAspectRatioY() {
        return this.B;
    }

    public CropImageView.c getCropShape() {
        return this.E;
    }

    public RectF getCropWindowRect() {
        return this.h.e();
    }

    public CropImageView.d getGuidelines() {
        return this.D;
    }

    public Rect getInitialCropWindowRect() {
        return this.F;
    }

    public void h() {
        if (this.G) {
            setCropWindowRect(uf5.b);
            f();
            invalidate();
        }
    }

    public void i(float[] fArr, int i2, int i3) {
        if (fArr == null || !Arrays.equals(this.p, fArr)) {
            if (fArr == null) {
                Arrays.fill(this.p, 0.0f);
            } else {
                System.arraycopy(fArr, 0, this.p, 0, fArr.length);
            }
            this.r = i2;
            this.s = i3;
            RectF e = this.h.e();
            if (e.width() == 0.0f || e.height() == 0.0f) {
                f();
            }
        }
    }

    public boolean j(boolean z2) {
        if (this.g == z2) {
            return false;
        }
        this.g = z2;
        if (!z2 || this.f != null) {
            return true;
        }
        this.f = new ScaleGestureDetector(getContext(), new c(null));
        return true;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i2 = Build.VERSION.SDK_INT;
        RectF e = this.h.e();
        float f2 = 0.0f;
        float max = Math.max(uf5.q(this.p), 0.0f);
        float max2 = Math.max(uf5.s(this.p), 0.0f);
        float min = Math.min(uf5.r(this.p), (float) getWidth());
        float min2 = Math.min(uf5.l(this.p), (float) getHeight());
        CropImageView.c cVar = this.E;
        CropImageView.c cVar2 = CropImageView.c.RECTANGLE;
        if (cVar != cVar2) {
            this.o.reset();
            this.j.set(e.left, e.top, e.right, e.bottom);
            this.o.addOval(this.j, Path.Direction.CW);
            canvas.save();
            if (i2 >= 26) {
                canvas.clipOutPath(this.o);
            } else {
                canvas.clipPath(this.o, Region.Op.XOR);
            }
            canvas.drawRect(max, max2, min, min2, this.n);
            canvas.restore();
        } else if (g()) {
            this.o.reset();
            Path path = this.o;
            float[] fArr = this.p;
            path.moveTo(fArr[0], fArr[1]);
            Path path2 = this.o;
            float[] fArr2 = this.p;
            path2.lineTo(fArr2[2], fArr2[3]);
            Path path3 = this.o;
            float[] fArr3 = this.p;
            path3.lineTo(fArr3[4], fArr3[5]);
            Path path4 = this.o;
            float[] fArr4 = this.p;
            path4.lineTo(fArr4[6], fArr4[7]);
            this.o.close();
            canvas.save();
            if (i2 >= 26) {
                canvas.clipOutPath(this.o);
            } else {
                canvas.clipPath(this.o, Region.Op.INTERSECT);
            }
            canvas.clipRect(e, Region.Op.XOR);
            canvas.drawRect(max, max2, min, min2, this.n);
            canvas.restore();
        } else {
            canvas.drawRect(max, max2, min, e.top, this.n);
            canvas.drawRect(max, e.bottom, min, min2, this.n);
            canvas.drawRect(max, e.top, e.left, e.bottom, this.n);
            canvas.drawRect(e.right, e.top, min, e.bottom, this.n);
        }
        if (this.h.j()) {
            CropImageView.d dVar = this.D;
            if (dVar == CropImageView.d.ON) {
                c(canvas);
            } else if (dVar == CropImageView.d.ON_TOUCH && this.y != null) {
                c(canvas);
            }
        }
        Paint paint = this.k;
        if (paint != null) {
            float strokeWidth = paint.getStrokeWidth();
            RectF e2 = this.h.e();
            float f3 = strokeWidth / 2.0f;
            e2.inset(f3, f3);
            if (this.E == cVar2) {
                canvas.drawRect(e2, this.k);
            } else {
                canvas.drawOval(e2, this.k);
            }
        }
        if (this.l != null) {
            Paint paint2 = this.k;
            float strokeWidth2 = paint2 != null ? paint2.getStrokeWidth() : 0.0f;
            float strokeWidth3 = this.l.getStrokeWidth();
            float f4 = strokeWidth3 / 2.0f;
            if (this.E == cVar2) {
                f2 = this.t;
            }
            float f5 = f2 + f4;
            RectF e3 = this.h.e();
            e3.inset(f5, f5);
            float f6 = (strokeWidth3 - strokeWidth2) / 2.0f;
            float f7 = f4 + f6;
            float f8 = e3.left - f6;
            float f9 = e3.top;
            canvas.drawLine(f8, f9 - f7, f8, f9 + this.u, this.l);
            float f10 = e3.left;
            float f11 = e3.top - f6;
            canvas.drawLine(f10 - f7, f11, f10 + this.u, f11, this.l);
            float f12 = e3.right + f6;
            float f13 = e3.top;
            canvas.drawLine(f12, f13 - f7, f12, f13 + this.u, this.l);
            float f14 = e3.right;
            float f15 = e3.top - f6;
            canvas.drawLine(f14 + f7, f15, f14 - this.u, f15, this.l);
            float f16 = e3.left - f6;
            float f17 = e3.bottom;
            canvas.drawLine(f16, f17 + f7, f16, f17 - this.u, this.l);
            float f18 = e3.left;
            float f19 = e3.bottom + f6;
            canvas.drawLine(f18 - f7, f19, f18 + this.u, f19, this.l);
            float f20 = e3.right + f6;
            float f21 = e3.bottom;
            canvas.drawLine(f20, f21 + f7, f20, f21 - this.u, this.l);
            float f22 = e3.right;
            float f23 = e3.bottom + f6;
            canvas.drawLine(f22 + f7, f23, f22 - this.u, f23, this.l);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0086, code lost:
        if (r11 <= r14.right) goto L_0x0092;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ab, code lost:
        if (r11 <= r14.bottom) goto L_0x00b7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r22) {
        /*
        // Method dump skipped, instructions count: 1184
        */
        throw new UnsupportedOperationException("Method not decompiled: com.theartofdev.edmodo.cropper.CropOverlayView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setAspectRatioX(int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
        } else if (this.A != i2) {
            this.A = i2;
            this.C = ((float) i2) / ((float) this.B);
            if (this.G) {
                f();
                invalidate();
            }
        }
    }

    public void setAspectRatioY(int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
        } else if (this.B != i2) {
            this.B = i2;
            this.C = ((float) this.A) / ((float) i2);
            if (this.G) {
                f();
                invalidate();
            }
        }
    }

    public void setCropShape(CropImageView.c cVar) {
        if (this.E != cVar) {
            this.E = cVar;
            invalidate();
        }
    }

    public void setCropWindowChangeListener(b bVar) {
        this.i = bVar;
    }

    public void setCropWindowRect(RectF rectF) {
        this.h.f4044a.set(rectF);
    }

    public void setFixedAspectRatio(boolean z2) {
        if (this.z != z2) {
            this.z = z2;
            if (this.G) {
                f();
                invalidate();
            }
        }
    }

    public void setGuidelines(CropImageView.d dVar) {
        if (this.D != dVar) {
            this.D = dVar;
            if (this.G) {
                invalidate();
            }
        }
    }

    public void setInitialAttributeValues(CropImageOptions cropImageOptions) {
        yf5 yf5 = this.h;
        Objects.requireNonNull(yf5);
        yf5.c = (float) cropImageOptions.C;
        yf5.d = (float) cropImageOptions.D;
        yf5.g = (float) cropImageOptions.E;
        yf5.h = (float) cropImageOptions.F;
        yf5.i = (float) cropImageOptions.G;
        yf5.j = (float) cropImageOptions.H;
        setCropShape(cropImageOptions.f);
        setSnapRadius(cropImageOptions.g);
        setGuidelines(cropImageOptions.i);
        setFixedAspectRatio(cropImageOptions.q);
        setAspectRatioX(cropImageOptions.r);
        setAspectRatioY(cropImageOptions.s);
        j(cropImageOptions.n);
        this.w = cropImageOptions.h;
        this.v = cropImageOptions.p;
        this.k = e(cropImageOptions.t, cropImageOptions.u);
        this.t = cropImageOptions.w;
        this.u = cropImageOptions.x;
        this.l = e(cropImageOptions.v, cropImageOptions.y);
        this.m = e(cropImageOptions.z, cropImageOptions.A);
        int i2 = cropImageOptions.B;
        Paint paint = new Paint();
        paint.setColor(i2);
        this.n = paint;
    }

    public void setInitialCropWindowRect(Rect rect) {
        Rect rect2 = this.F;
        if (rect == null) {
            rect = uf5.f3500a;
        }
        rect2.set(rect);
        if (this.G) {
            f();
            invalidate();
            b(false);
        }
    }

    public void setSnapRadius(float f2) {
        this.x = f2;
    }
}
