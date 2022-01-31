package defpackage;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* renamed from: xs1  reason: default package */
/* compiled from: DrawableImageViewTarget */
public class xs1 extends ys1<Drawable> {
    public xs1(ImageView imageView) {
        super(imageView);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.ys1
    public void c(Drawable drawable) {
        ((ImageView) this.g).setImageDrawable(drawable);
    }
}
