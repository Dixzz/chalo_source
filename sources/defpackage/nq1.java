package defpackage;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import java.util.Objects;

/* renamed from: nq1  reason: default package */
/* compiled from: LazyBitmapDrawableResource */
public class nq1 implements rn1<BitmapDrawable>, on1 {
    public final Bitmap f;
    public final Resources g;
    public final zn1 h;

    public nq1(Resources resources, zn1 zn1, Bitmap bitmap) {
        Objects.requireNonNull(resources, "Argument must not be null");
        this.g = resources;
        Objects.requireNonNull(zn1, "Argument must not be null");
        this.h = zn1;
        Objects.requireNonNull(bitmap, "Argument must not be null");
        this.f = bitmap;
    }

    @Override // defpackage.rn1
    public void a() {
        this.h.d(this.f);
    }

    @Override // defpackage.rn1
    public int b() {
        return rt1.d(this.f);
    }

    @Override // defpackage.rn1
    public Class<BitmapDrawable> c() {
        return BitmapDrawable.class;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.rn1
    public BitmapDrawable get() {
        return new BitmapDrawable(this.g, this.f);
    }

    @Override // defpackage.on1
    public void initialize() {
        this.f.prepareToDraw();
    }
}
