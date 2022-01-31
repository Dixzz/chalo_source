package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.appcompat.R;

/* renamed from: y0  reason: default package */
/* compiled from: DrawerArrowDrawable */
public class y0 extends Drawable {
    public static final float l = ((float) Math.toRadians(45.0d));

    /* renamed from: a  reason: collision with root package name */
    public final Paint f3985a;
    public float b;
    public float c;
    public float d;
    public float e;
    public boolean f;
    public final Path g = new Path();
    public final int h;
    public float i;
    public float j;
    public int k = 2;

    public y0(Context context) {
        Paint paint = new Paint();
        this.f3985a = paint;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.MITER);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, R.styleable.DrawerArrowToggle, R.attr.drawerArrowStyle, R.style.Base_Widget_AppCompat_DrawerArrowToggle);
        int color = obtainStyledAttributes.getColor(R.styleable.DrawerArrowToggle_color, 0);
        if (color != paint.getColor()) {
            paint.setColor(color);
            invalidateSelf();
        }
        float dimension = obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_thickness, 0.0f);
        if (paint.getStrokeWidth() != dimension) {
            paint.setStrokeWidth(dimension);
            this.j = (float) (Math.cos((double) l) * ((double) (dimension / 2.0f)));
            invalidateSelf();
        }
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.DrawerArrowToggle_spinBars, true);
        if (this.f != z) {
            this.f = z;
            invalidateSelf();
        }
        float round = (float) Math.round(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_gapBetweenBars, 0.0f));
        if (round != this.e) {
            this.e = round;
            invalidateSelf();
        }
        this.h = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DrawerArrowToggle_drawableSize, 0);
        this.c = (float) Math.round(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_barLength, 0.0f));
        this.b = (float) Math.round(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_arrowHeadLength, 0.0f));
        this.d = obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_arrowShaftLength, 0.0f);
        obtainStyledAttributes.recycle();
    }

    public static float a(float f2, float f3, float f4) {
        return hj1.a(f3, f2, f4, f2);
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int i2 = this.k;
        boolean z = i2 != 0 && (i2 == 1 || (i2 == 3 ? h.M(this) == 0 : h.M(this) == 1));
        float f2 = this.b;
        float a2 = a(this.c, (float) Math.sqrt((double) (f2 * f2 * 2.0f)), this.i);
        float a3 = a(this.c, this.d, this.i);
        float round = (float) Math.round(a(0.0f, this.j, this.i));
        float a4 = a(0.0f, l, this.i);
        float a5 = a(z ? 0.0f : -180.0f, z ? 180.0f : 0.0f, this.i);
        double d2 = (double) a2;
        double d3 = (double) a4;
        float round2 = (float) Math.round(Math.cos(d3) * d2);
        float round3 = (float) Math.round(Math.sin(d3) * d2);
        this.g.rewind();
        float a6 = a(this.f3985a.getStrokeWidth() + this.e, -this.j, this.i);
        float f3 = (-a3) / 2.0f;
        this.g.moveTo(f3 + round, 0.0f);
        this.g.rLineTo(a3 - (round * 2.0f), 0.0f);
        this.g.moveTo(f3, a6);
        this.g.rLineTo(round2, round3);
        this.g.moveTo(f3, -a6);
        this.g.rLineTo(round2, -round3);
        this.g.close();
        canvas.save();
        float strokeWidth = this.f3985a.getStrokeWidth();
        float height = ((float) bounds.height()) - (3.0f * strokeWidth);
        float f4 = this.e;
        canvas.translate((float) bounds.centerX(), (strokeWidth * 1.5f) + f4 + ((float) ((((int) (height - (2.0f * f4))) / 4) * 2)));
        if (this.f) {
            canvas.rotate(a5 * ((float) (false ^ z ? -1 : 1)));
        } else if (z) {
            canvas.rotate(180.0f);
        }
        canvas.drawPath(this.g, this.f3985a);
        canvas.restore();
    }

    public int getIntrinsicHeight() {
        return this.h;
    }

    public int getIntrinsicWidth() {
        return this.h;
    }

    public int getOpacity() {
        return -3;
    }

    public void setAlpha(int i2) {
        if (i2 != this.f3985a.getAlpha()) {
            this.f3985a.setAlpha(i2);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f3985a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setProgress(float f2) {
        if (this.i != f2) {
            this.i = f2;
            invalidateSelf();
        }
    }
}
