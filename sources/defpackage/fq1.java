package defpackage;

import android.graphics.Bitmap;
import defpackage.kt1;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Objects;

/* renamed from: fq1  reason: default package */
/* compiled from: ByteBufferBitmapDecoder */
public class fq1 implements gm1<ByteBuffer, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    public final kq1 f1158a;

    public fq1(kq1 kq1) {
        this.f1158a = kq1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, fm1] */
    @Override // defpackage.gm1
    public boolean a(ByteBuffer byteBuffer, fm1 fm1) throws IOException {
        Objects.requireNonNull(this.f1158a);
        return true;
    }

    /* Return type fixed from 'rn1' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int, fm1] */
    @Override // defpackage.gm1
    public rn1<Bitmap> b(ByteBuffer byteBuffer, int i, int i2, fm1 fm1) throws IOException {
        int i3 = kt1.f2117a;
        return this.f1158a.a(new kt1.a(byteBuffer), i, i2, fm1, kq1.k);
    }
}
