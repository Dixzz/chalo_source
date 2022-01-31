package defpackage;

import android.graphics.ImageDecoder;
import defpackage.qy5;

/* renamed from: ny5  reason: default package */
/* compiled from: ImageUtils */
public class ny5 implements ImageDecoder.OnHeaderDecodedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ oy5 f2622a;

    public ny5(oy5 oy5) {
        this.f2622a = oy5;
    }

    public void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
        int width = imageInfo.getSize().getWidth();
        int height = imageInfo.getSize().getHeight();
        oy5 oy5 = this.f2622a;
        qy5.d b = qy5.b(width, height, oy5.f2745a, oy5.b);
        imageDecoder.setTargetSize(b.f3011a, b.b);
        imageDecoder.setTargetSampleSize(qy5.a(width, height, b.f3011a, b.b));
    }
}
