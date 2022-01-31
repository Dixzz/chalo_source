package defpackage;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Paint;
import java.security.MessageDigest;

/* renamed from: gq1  reason: default package */
/* compiled from: CenterCrop */
public class gq1 extends eq1 {
    public static final byte[] b = "com.bumptech.glide.load.resource.bitmap.CenterCrop".getBytes(dm1.f856a);

    @Override // defpackage.dm1
    public void a(MessageDigest messageDigest) {
        messageDigest.update(b);
    }

    @Override // defpackage.eq1
    public Bitmap c(zn1 zn1, Bitmap bitmap, int i, int i2) {
        float f;
        float f2;
        Paint paint = qq1.f2978a;
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        float f3 = 0.0f;
        if (bitmap.getWidth() * i2 > bitmap.getHeight() * i) {
            f2 = ((float) i2) / ((float) bitmap.getHeight());
            f3 = (((float) i) - (((float) bitmap.getWidth()) * f2)) * 0.5f;
            f = 0.0f;
        } else {
            f2 = ((float) i) / ((float) bitmap.getWidth());
            f = (((float) i2) - (((float) bitmap.getHeight()) * f2)) * 0.5f;
        }
        matrix.setScale(f2, f2);
        matrix.postTranslate((float) ((int) (f3 + 0.5f)), (float) ((int) (f + 0.5f)));
        Bitmap e = zn1.e(i, i2, qq1.c(bitmap));
        e.setHasAlpha(bitmap.hasAlpha());
        qq1.a(bitmap, e, matrix);
        return e;
    }

    @Override // defpackage.dm1, defpackage.im1
    public boolean equals(Object obj) {
        return obj instanceof gq1;
    }

    @Override // defpackage.dm1, defpackage.im1
    public int hashCode() {
        return -599754482;
    }
}
