package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import java.security.MessageDigest;

/* renamed from: cr1  reason: default package */
/* compiled from: GifDrawableTransformation */
public class cr1 implements im1<zq1> {
    public final im1<Bitmap> b;

    public cr1(im1<Bitmap> im1) {
        this.b = im1;
    }

    @Override // defpackage.dm1
    public void a(MessageDigest messageDigest) {
        this.b.a(messageDigest);
    }

    @Override // defpackage.im1
    public rn1<zq1> b(Context context, rn1<zq1> rn1, int i, int i2) {
        zq1 zq1 = rn1.get();
        dq1 dq1 = new dq1(zq1.f.b.l, gl1.b(context).f);
        rn1<Bitmap> b2 = this.b.b(context, dq1, i, i2);
        if (!dq1.equals(b2)) {
            dq1.a();
        }
        im1<Bitmap> im1 = this.b;
        zq1.f.b.c(im1, b2.get());
        return rn1;
    }

    @Override // defpackage.dm1, defpackage.im1
    public boolean equals(Object obj) {
        if (obj instanceof cr1) {
            return this.b.equals(((cr1) obj).b);
        }
        return false;
    }

    @Override // defpackage.dm1, defpackage.im1
    public int hashCode() {
        return this.b.hashCode();
    }
}
