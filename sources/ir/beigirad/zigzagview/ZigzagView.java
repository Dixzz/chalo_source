package ir.beigirad.zigzagview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.razorpay.AnalyticsConstants;

/* compiled from: ZigzagView.kt */
public final class ZigzagView extends FrameLayout {
    public float f;
    public float g;
    public float h;
    public int i = -1;
    public float j;
    public float k;
    public float l;
    public float m;
    public float n;
    public int o;
    public float p;
    public final Path q = new Path();
    public final j56 r = hd3.a2(f.h);
    public final j56 s = hd3.a2(f.g);
    public Bitmap t;
    public Rect u = new Rect();
    public RectF v = new RectF();
    public RectF w = new RectF();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ZigzagView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        n86.e(context, AnalyticsConstants.CONTEXT);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ZigzagView);
        this.g = obtainStyledAttributes.getDimension(R.styleable.ZigzagView_zigzagElevation, 0.0f);
        this.f = obtainStyledAttributes.getDimension(R.styleable.ZigzagView_zigzagHeight, 0.0f);
        this.h = obtainStyledAttributes.getDimension(R.styleable.ZigzagView_zigzagPaddingContent, 0.0f);
        setZigzagBackgroundColor(obtainStyledAttributes.getColor(R.styleable.ZigzagView_zigzagBackgroundColor, this.i));
        float dimension = obtainStyledAttributes.getDimension(R.styleable.ZigzagView_zigzagPadding, this.g);
        this.j = dimension;
        this.k = obtainStyledAttributes.getDimension(R.styleable.ZigzagView_zigzagPaddingLeft, dimension);
        this.l = obtainStyledAttributes.getDimension(R.styleable.ZigzagView_zigzagPaddingRight, this.j);
        this.m = obtainStyledAttributes.getDimension(R.styleable.ZigzagView_zigzagPaddingTop, this.j);
        this.n = obtainStyledAttributes.getDimension(R.styleable.ZigzagView_zigzagPaddingBottom, this.j);
        this.o = obtainStyledAttributes.getInt(R.styleable.ZigzagView_zigzagSides, 2);
        this.p = obtainStyledAttributes.getFloat(R.styleable.ZigzagView_zigzagShadowAlpha, 0.5f);
        obtainStyledAttributes.recycle();
        this.g = l96.a(this.g, 0.0f, 25.0f);
        this.p = l96.a(this.p, 0.0f, 1.0f);
        getPaintShadow().setAlpha((int) (this.p * ((float) 100)));
        setLayerType(1, null);
        setWillNotDraw(false);
    }

    private final Paint getPaintShadow() {
        return (Paint) this.s.getValue();
    }

    private final Paint getPaintZigzag() {
        return (Paint) this.r.getValue();
    }

    public final boolean a(int i2, int i3) {
        return (i3 | i2) == i2;
    }

    public final void b(Path path, float f2, float f3, float f4, boolean z) {
        float f5 = this.f;
        float f6 = (float) 2;
        float f7 = f6 * f5;
        float f8 = f4 - f2;
        int i2 = (int) (f8 / f7);
        float f9 = (f8 - (((float) i2) * f7)) / f6;
        float f10 = f7 / f6;
        float f11 = z ? f5 + f3 : f3 - f5;
        if (z) {
            while (i2 >= 1) {
                float f12 = (((float) i2) * f7) + f9 + ((float) ((int) f2));
                float f13 = f12 - f7;
                if (i2 == 1) {
                    f13 -= f9;
                }
                path.lineTo(f12 - f10, f11);
                path.lineTo(f13, f3);
                i2--;
            }
            return;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            float f14 = (float) ((int) f2);
            float f15 = (((float) i3) * f7) + f9 + f14;
            float f16 = f15 + f7;
            if (i3 == 0) {
                f15 = f14 + f9;
            } else if (i3 == i2 - 1) {
                f16 += f9;
            }
            path.lineTo(f15 + f10, f11);
            path.lineTo(f16, f3);
        }
    }

    public final void c(Path path, float f2, float f3, float f4, boolean z) {
        float f5 = this.f;
        float f6 = (float) 2;
        float f7 = f6 * f5;
        float f8 = f4 - f2;
        int i2 = (int) (f8 / f7);
        float f9 = (f8 - (((float) i2) * f7)) / f6;
        float f10 = f7 / f6;
        float f11 = z ? f5 + f3 : f3 - f5;
        if (!z) {
            while (i2 >= 1) {
                float f12 = (((float) i2) * f7) + f9 + ((float) ((int) f2));
                float f13 = f12 - f7;
                if (i2 == 1) {
                    f13 -= f9;
                }
                path.lineTo(f11, f12 - f10);
                path.lineTo(f3, f13);
                i2--;
            }
            return;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            float f14 = (float) ((int) f2);
            float f15 = (((float) i3) * f7) + f9 + f14;
            float f16 = f15 + f7;
            if (i3 == 0) {
                f15 = f14 + f9;
            } else if (i3 == i2 - 1) {
                f16 += f9;
            }
            path.lineTo(f11, f15 + f10);
            path.lineTo(f3, f16);
        }
    }

    public final int getZigzagBackgroundColor() {
        return this.i;
    }

    public void onDraw(Canvas canvas) {
        n86.e(canvas, "canvas");
        super.onDraw(canvas);
        RectF rectF = this.v;
        float f2 = rectF.left;
        float f3 = rectF.right;
        float f4 = rectF.top;
        float f5 = rectF.bottom;
        this.q.moveTo(f3, f5);
        if (!a(this.o, 4) || this.f <= ((float) 0)) {
            this.q.lineTo(f3, f4);
        } else {
            c(this.q, f4, f3, f5, false);
        }
        if (!a(this.o, 1) || this.f <= ((float) 0)) {
            this.q.lineTo(f2, f4);
        } else {
            b(this.q, f2, f4, f3, true);
        }
        if (!a(this.o, 8) || this.f <= ((float) 0)) {
            this.q.lineTo(f2, f5);
        } else {
            c(this.q, f4, f2, f5, true);
        }
        if (!a(this.o, 2) || this.f <= ((float) 0)) {
            this.q.lineTo(f3, f5);
        } else {
            b(this.q, f2, f5, f3, false);
        }
        if (this.g > ((float) 0) && !isInEditMode()) {
            Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ALPHA_8);
            this.t = createBitmap;
            n86.c(createBitmap);
            createBitmap.eraseColor(0);
            Bitmap bitmap = this.t;
            n86.c(bitmap);
            new Canvas(bitmap).drawPath(this.q, getPaintShadow());
            RenderScript create = RenderScript.create(getContext());
            ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8(create));
            Allocation createFromBitmap = Allocation.createFromBitmap(create, this.t);
            n86.d(createFromBitmap, "input");
            Allocation createTyped = Allocation.createTyped(create, createFromBitmap.getType());
            create2.setRadius(this.g);
            create2.setInput(createFromBitmap);
            create2.forEach(createTyped);
            createTyped.copyTo(this.t);
            createFromBitmap.destroy();
            createTyped.destroy();
            Bitmap bitmap2 = this.t;
            n86.c(bitmap2);
            canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
        }
        canvas.drawPath(this.q, getPaintZigzag());
    }

    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.u.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        RectF rectF = this.v;
        Rect rect = this.u;
        rectF.set(((float) rect.left) + this.k, ((float) rect.top) + this.m, ((float) rect.right) - this.l, ((float) rect.bottom) - this.n);
        RectF rectF2 = this.w;
        float f2 = 0.0f;
        float f3 = this.v.left + this.h + (a(this.o, 8) ? this.f : 0.0f);
        float f4 = this.v.top + this.h + (a(this.o, 1) ? this.f : 0.0f);
        float f5 = (this.v.right - this.h) - (a(this.o, 4) ? this.f : 0.0f);
        float f6 = this.v.bottom - this.h;
        if (a(this.o, 2)) {
            f2 = this.f;
        }
        rectF2.set(f3, f4, f5, f6 - f2);
        RectF rectF3 = this.w;
        Rect rect2 = this.u;
        setPadding((int) rectF3.left, (int) rectF3.top, (int) (((float) rect2.right) - rectF3.right), (int) (((float) rect2.bottom) - rectF3.bottom));
    }

    public final void setZigzagBackgroundColor(int i2) {
        this.i = i2;
        getPaintZigzag().setColor(i2);
        invalidate();
    }
}
