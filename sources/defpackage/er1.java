package defpackage;

import android.graphics.Bitmap;
import java.io.IOException;

/* renamed from: er1  reason: default package */
/* compiled from: GifFrameResourceDecoder */
public final class er1 implements gm1<sl1, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    public final zn1 f1018a;

    public er1(zn1 zn1) {
        this.f1018a = zn1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, fm1] */
    @Override // defpackage.gm1
    public /* bridge */ /* synthetic */ boolean a(sl1 sl1, fm1 fm1) throws IOException {
        return true;
    }

    /* Return type fixed from 'rn1' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int, fm1] */
    @Override // defpackage.gm1
    public rn1<Bitmap> b(sl1 sl1, int i, int i2, fm1 fm1) throws IOException {
        return dq1.d(sl1.a(), this.f1018a);
    }
}
