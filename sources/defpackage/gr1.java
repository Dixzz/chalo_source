package defpackage;

import android.graphics.Bitmap;
import java.io.ByteArrayOutputStream;

/* renamed from: gr1  reason: default package */
/* compiled from: BitmapBytesTranscoder */
public class gr1 implements jr1<Bitmap, byte[]> {

    /* renamed from: a  reason: collision with root package name */
    public final Bitmap.CompressFormat f1296a = Bitmap.CompressFormat.JPEG;
    public final int b = 100;

    @Override // defpackage.jr1
    public rn1<byte[]> a(rn1<Bitmap> rn1) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        rn1.get().compress(this.f1296a, this.b, byteArrayOutputStream);
        rn1.a();
        return new tq1(byteArrayOutputStream.toByteArray());
    }
}
