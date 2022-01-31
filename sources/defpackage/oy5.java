package defpackage;

import android.graphics.ImageDecoder;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import defpackage.qy5;
import java.io.File;
import java.io.IOException;

/* renamed from: oy5  reason: default package */
/* compiled from: ImageUtils */
public final class oy5 implements qy5.c<qy5.b> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2745a;
    public final /* synthetic */ int b;

    public oy5(int i, int i2) {
        this.f2745a = i;
        this.b = i2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.qy5.c
    public qy5.b a(File file) throws IOException {
        long j;
        Drawable decodeDrawable = ImageDecoder.decodeDrawable(ImageDecoder.createSource(file), new ny5(this));
        if (decodeDrawable instanceof BitmapDrawable) {
            j = (long) ((BitmapDrawable) decodeDrawable).getBitmap().getByteCount();
        } else {
            j = file.length();
        }
        return new qy5.b(decodeDrawable, j, null);
    }
}
