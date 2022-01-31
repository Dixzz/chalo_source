package defpackage;

import android.content.Context;
import android.graphics.Bitmap;

/* renamed from: eq1  reason: default package */
/* compiled from: BitmapTransformation */
public abstract class eq1 implements im1<Bitmap> {
    @Override // defpackage.im1
    public final rn1<Bitmap> b(Context context, rn1<Bitmap> rn1, int i, int i2) {
        if (rt1.i(i, i2)) {
            zn1 zn1 = gl1.b(context).f;
            Bitmap bitmap = rn1.get();
            if (i == Integer.MIN_VALUE) {
                i = bitmap.getWidth();
            }
            if (i2 == Integer.MIN_VALUE) {
                i2 = bitmap.getHeight();
            }
            Bitmap c = c(zn1, bitmap, i, i2);
            return bitmap.equals(c) ? rn1 : dq1.d(c, zn1);
        }
        throw new IllegalArgumentException("Cannot apply transformation on width: " + i + " or height: " + i2 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
    }

    public abstract Bitmap c(zn1 zn1, Bitmap bitmap, int i, int i2);
}
