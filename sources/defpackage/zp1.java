package defpackage;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import java.io.IOException;

/* renamed from: zp1  reason: default package */
/* compiled from: BitmapDrawableDecoder */
public class zp1<DataType> implements gm1<DataType, BitmapDrawable> {

    /* renamed from: a  reason: collision with root package name */
    public final gm1<DataType, Bitmap> f4199a;
    public final Resources b;
    public final zn1 c;

    public zp1(Resources resources, zn1 zn1, gm1<DataType, Bitmap> gm1) {
        this.b = resources;
        this.c = zn1;
        this.f4199a = gm1;
    }

    @Override // defpackage.gm1
    public boolean a(DataType datatype, fm1 fm1) throws IOException {
        return this.f4199a.a(datatype, fm1);
    }

    @Override // defpackage.gm1
    public rn1<BitmapDrawable> b(DataType datatype, int i, int i2, fm1 fm1) throws IOException {
        rn1<Bitmap> b2 = this.f4199a.b(datatype, i, i2, fm1);
        if (b2 == null) {
            return null;
        }
        return new nq1(this.b, this.c, b2.get());
    }
}
