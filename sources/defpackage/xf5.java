package defpackage;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import com.theartofdev.edmodo.cropper.CropOverlayView;

/* renamed from: xf5  reason: default package */
/* compiled from: CropImageAnimation */
public final class xf5 extends Animation implements Animation.AnimationListener {
    public final ImageView f;
    public final CropOverlayView g;
    public final float[] h = new float[8];
    public final float[] i = new float[8];
    public final RectF j = new RectF();
    public final RectF k = new RectF();
    public final float[] l = new float[9];
    public final float[] m = new float[9];
    public final RectF n = new RectF();
    public final float[] o = new float[8];
    public final float[] p = new float[9];

    public xf5(ImageView imageView, CropOverlayView cropOverlayView) {
        this.f = imageView;
        this.g = cropOverlayView;
        setDuration(300);
        setFillAfter(true);
        setInterpolator(new AccelerateDecelerateInterpolator());
        setAnimationListener(this);
    }

    public void applyTransformation(float f2, Transformation transformation) {
        float[] fArr;
        RectF rectF = this.n;
        RectF rectF2 = this.j;
        float f3 = rectF2.left;
        RectF rectF3 = this.k;
        rectF.left = hj1.a(rectF3.left, f3, f2, f3);
        float f4 = rectF2.top;
        rectF.top = hj1.a(rectF3.top, f4, f2, f4);
        float f5 = rectF2.right;
        rectF.right = hj1.a(rectF3.right, f5, f2, f5);
        float f6 = rectF2.bottom;
        rectF.bottom = hj1.a(rectF3.bottom, f6, f2, f6);
        this.g.setCropWindowRect(rectF);
        int i2 = 0;
        int i3 = 0;
        while (true) {
            fArr = this.o;
            if (i3 >= fArr.length) {
                break;
            }
            float[] fArr2 = this.h;
            fArr[i3] = hj1.a(this.i[i3], fArr2[i3], f2, fArr2[i3]);
            i3++;
        }
        this.g.i(fArr, this.f.getWidth(), this.f.getHeight());
        while (true) {
            float[] fArr3 = this.p;
            if (i2 < fArr3.length) {
                float[] fArr4 = this.l;
                fArr3[i2] = hj1.a(this.m[i2], fArr4[i2], f2, fArr4[i2]);
                i2++;
            } else {
                Matrix imageMatrix = this.f.getImageMatrix();
                imageMatrix.setValues(this.p);
                this.f.setImageMatrix(imageMatrix);
                this.f.invalidate();
                this.g.invalidate();
                return;
            }
        }
    }

    public void onAnimationEnd(Animation animation) {
        this.f.clearAnimation();
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
