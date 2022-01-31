package defpackage;

import android.graphics.Bitmap;
import android.graphics.Paint;
import java.security.MessageDigest;

/* renamed from: hq1  reason: default package */
/* compiled from: CenterInside */
public class hq1 extends eq1 {
    public static final byte[] b = "com.bumptech.glide.load.resource.bitmap.CenterInside".getBytes(dm1.f856a);

    @Override // defpackage.dm1
    public void a(MessageDigest messageDigest) {
        messageDigest.update(b);
    }

    @Override // defpackage.eq1
    public Bitmap c(zn1 zn1, Bitmap bitmap, int i, int i2) {
        Paint paint = qq1.f2978a;
        return (bitmap.getWidth() > i || bitmap.getHeight() > i2) ? qq1.b(zn1, bitmap, i, i2) : bitmap;
    }

    @Override // defpackage.dm1, defpackage.im1
    public boolean equals(Object obj) {
        return obj instanceof hq1;
    }

    @Override // defpackage.dm1, defpackage.im1
    public int hashCode() {
        return -670243078;
    }
}
