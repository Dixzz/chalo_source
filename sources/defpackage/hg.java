package defpackage;

import android.view.animation.Interpolator;

/* renamed from: hg  reason: default package */
/* compiled from: LookupTableInterpolator */
public abstract class hg implements Interpolator {

    /* renamed from: a  reason: collision with root package name */
    public final float[] f1368a;
    public final float b;

    public hg(float[] fArr) {
        this.f1368a = fArr;
        this.b = 1.0f / ((float) (fArr.length - 1));
    }

    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f1368a;
        int min = Math.min((int) (((float) (fArr.length - 1)) * f), fArr.length - 2);
        float f2 = this.b;
        float f3 = (f - (((float) min) * f2)) / f2;
        float[] fArr2 = this.f1368a;
        return hj1.a(fArr2[min + 1], fArr2[min], f3, fArr2[min]);
    }
}
