package defpackage;

import android.graphics.Bitmap;

/* renamed from: ao1  reason: default package */
/* compiled from: BitmapPoolAdapter */
public class ao1 implements zn1 {
    @Override // defpackage.zn1
    public void a(int i) {
    }

    @Override // defpackage.zn1
    public void b() {
    }

    @Override // defpackage.zn1
    public Bitmap c(int i, int i2, Bitmap.Config config) {
        return Bitmap.createBitmap(i, i2, config);
    }

    @Override // defpackage.zn1
    public void d(Bitmap bitmap) {
        bitmap.recycle();
    }

    @Override // defpackage.zn1
    public Bitmap e(int i, int i2, Bitmap.Config config) {
        return Bitmap.createBitmap(i, i2, config);
    }
}
