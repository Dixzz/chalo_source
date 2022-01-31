package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import java.security.MessageDigest;
import java.util.Objects;

/* renamed from: bq1  reason: default package */
/* compiled from: BitmapDrawableTransformation */
public class bq1 implements im1<BitmapDrawable> {
    public final im1<Bitmap> b;

    public bq1(im1<Bitmap> im1) {
        Objects.requireNonNull(im1, "Argument must not be null");
        this.b = im1;
    }

    @Override // defpackage.dm1
    public void a(MessageDigest messageDigest) {
        this.b.a(messageDigest);
    }

    @Override // defpackage.im1
    public rn1<BitmapDrawable> b(Context context, rn1<BitmapDrawable> rn1, int i, int i2) {
        dq1 d = dq1.d(rn1.get().getBitmap(), gl1.b(context).f);
        rn1<Bitmap> b2 = this.b.b(context, d, i, i2);
        if (b2.equals(d)) {
            return rn1;
        }
        return new nq1(context.getResources(), gl1.b(context).f, b2.get());
    }

    @Override // defpackage.dm1, defpackage.im1
    public boolean equals(Object obj) {
        if (obj instanceof bq1) {
            return this.b.equals(((bq1) obj).b);
        }
        return false;
    }

    @Override // defpackage.dm1, defpackage.im1
    public int hashCode() {
        return this.b.hashCode();
    }
}
