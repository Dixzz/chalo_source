package defpackage;

import android.graphics.ImageDecoder;
import defpackage.qy5;

/* renamed from: py5  reason: default package */
/* compiled from: ImageUtils */
public class py5 implements ImageDecoder.OnHeaderDecodedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ qy5.a f2870a;

    public py5(qy5.a aVar) {
        this.f2870a = aVar;
    }

    public void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
        int width = imageInfo.getSize().getWidth();
        int height = imageInfo.getSize().getHeight();
        qy5.a aVar = this.f2870a;
        qy5.d b = qy5.b(width, height, aVar.f3009a, aVar.b);
        imageDecoder.setTargetSize(b.f3011a, b.b);
        imageDecoder.setTargetSampleSize(qy5.a(width, height, b.f3011a, b.b));
    }
}
