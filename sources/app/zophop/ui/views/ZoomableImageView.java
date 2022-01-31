package app.zophop.ui.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;

public class ZoomableImageView extends ImageView {
    public Matrix f = new Matrix();
    public int g = 0;
    public PointF h = new PointF();
    public PointF i = new PointF();
    public float j = 1.0f;
    public float k = 3.0f;
    public float[] l;
    public float m;
    public float n;
    public float o;
    public float p;
    public float q = 1.0f;
    public float r;
    public float s;
    public float t;
    public float u;
    public float v;
    public float w;
    public ScaleGestureDetector x;

    public class a extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        public a(xb1 xb1) {
        }

        /* JADX WARNING: Removed duplicated region for block: B:27:0x00cb  */
        /* JADX WARNING: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onScale(android.view.ScaleGestureDetector r12) {
            /*
            // Method dump skipped, instructions count: 294
            */
            throw new UnsupportedOperationException("Method not decompiled: app.zophop.ui.views.ZoomableImageView.a.onScale(android.view.ScaleGestureDetector):boolean");
        }

        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            ZoomableImageView.this.g = 2;
            return true;
        }
    }

    public ZoomableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setClickable(true);
        this.x = new ScaleGestureDetector(context, new a(null));
        this.f.setTranslate(1.0f, 1.0f);
        this.l = new float[9];
        setImageMatrix(this.f);
        setScaleType(ImageView.ScaleType.MATRIX);
        setOnTouchListener(new xb1(this));
    }

    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.o = (float) View.MeasureSpec.getSize(i2);
        float size = (float) View.MeasureSpec.getSize(i3);
        this.p = size;
        float min = Math.min(this.o / this.v, size / this.w);
        this.f.setScale(min, min);
        setImageMatrix(this.f);
        this.q = 1.0f;
        float f2 = this.p - (this.w * min);
        this.n = f2;
        float f3 = this.o - (min * this.v);
        this.m = f3;
        float f4 = f2 / 2.0f;
        this.n = f4;
        float f5 = f3 / 2.0f;
        this.m = f5;
        this.f.postTranslate(f5, f4);
        float f6 = this.o;
        float f7 = this.m;
        this.t = f6 - (f7 * 2.0f);
        float f8 = this.p;
        float f9 = this.n;
        this.u = f8 - (f9 * 2.0f);
        float f10 = this.q;
        this.r = ((f6 * f10) - f6) - ((f7 * 2.0f) * f10);
        this.s = ((f8 * f10) - f8) - ((f9 * 2.0f) * f10);
        setImageMatrix(this.f);
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (bitmap != null) {
            this.v = (float) bitmap.getWidth();
            this.w = (float) bitmap.getHeight();
        }
    }

    public void setMaxZoom(float f2) {
        this.k = f2;
    }
}
