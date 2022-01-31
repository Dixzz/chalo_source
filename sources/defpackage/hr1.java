package defpackage;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

/* renamed from: hr1  reason: default package */
/* compiled from: BitmapDrawableTranscoder */
public class hr1 implements jr1<Bitmap, BitmapDrawable> {

    /* renamed from: a  reason: collision with root package name */
    public final Resources f1416a;
    public final zn1 b;

    public hr1(Resources resources, zn1 zn1) {
        this.f1416a = resources;
        this.b = zn1;
    }

    @Override // defpackage.jr1
    public rn1<BitmapDrawable> a(rn1<Bitmap> rn1) {
        return new nq1(this.f1416a, this.b, rn1.get());
    }
}
