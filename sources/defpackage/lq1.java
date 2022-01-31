package defpackage;

import android.graphics.Bitmap;
import java.security.MessageDigest;

/* renamed from: lq1  reason: default package */
/* compiled from: FitCenter */
public class lq1 extends eq1 {
    public static final byte[] b = "com.bumptech.glide.load.resource.bitmap.FitCenter".getBytes(dm1.f856a);

    @Override // defpackage.dm1
    public void a(MessageDigest messageDigest) {
        messageDigest.update(b);
    }

    @Override // defpackage.eq1
    public Bitmap c(zn1 zn1, Bitmap bitmap, int i, int i2) {
        return qq1.b(zn1, bitmap, i, i2);
    }

    @Override // defpackage.dm1, defpackage.im1
    public boolean equals(Object obj) {
        return obj instanceof lq1;
    }

    @Override // defpackage.dm1, defpackage.im1
    public int hashCode() {
        return 1572326941;
    }
}
