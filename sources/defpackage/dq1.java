package defpackage;

import android.graphics.Bitmap;
import java.util.Objects;

/* renamed from: dq1  reason: default package */
/* compiled from: BitmapResource */
public class dq1 implements rn1<Bitmap>, on1 {
    public final Bitmap f;
    public final zn1 g;

    public dq1(Bitmap bitmap, zn1 zn1) {
        Objects.requireNonNull(bitmap, "Bitmap must not be null");
        this.f = bitmap;
        Objects.requireNonNull(zn1, "BitmapPool must not be null");
        this.g = zn1;
    }

    public static dq1 d(Bitmap bitmap, zn1 zn1) {
        if (bitmap == null) {
            return null;
        }
        return new dq1(bitmap, zn1);
    }

    @Override // defpackage.rn1
    public void a() {
        this.g.d(this.f);
    }

    @Override // defpackage.rn1
    public int b() {
        return rt1.d(this.f);
    }

    @Override // defpackage.rn1
    public Class<Bitmap> c() {
        return Bitmap.class;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.rn1
    public Bitmap get() {
        return this.f;
    }

    @Override // defpackage.on1
    public void initialize() {
        this.f.prepareToDraw();
    }
}
