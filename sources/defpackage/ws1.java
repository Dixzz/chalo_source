package defpackage;

import android.graphics.Bitmap;
import android.widget.ImageView;

/* renamed from: ws1  reason: default package */
/* compiled from: BitmapImageViewTarget */
public class ws1 extends ys1<Bitmap> {
    public ws1(ImageView imageView) {
        super(imageView);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.ys1
    public void c(Bitmap bitmap) {
        ((ImageView) this.g).setImageBitmap(bitmap);
    }
}
