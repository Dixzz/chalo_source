package defpackage;

import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;

/* renamed from: ye5  reason: default package */
/* compiled from: ImageViewAction */
public class ye5 extends le5<ImageView> {
    public pe5 m;

    public ye5(Picasso picasso, ImageView imageView, jf5 jf5, int i, int i2, int i3, Drawable drawable, String str, Object obj, pe5 pe5, boolean z) {
        super(picasso, imageView, jf5, i, i2, i3, null, str, null, z);
        this.m = pe5;
    }

    @Override // defpackage.le5
    public void a() {
        this.l = true;
        if (this.m != null) {
            this.m = null;
        }
    }

    @Override // defpackage.le5
    public void b(Bitmap bitmap, Picasso.d dVar) {
        T t = this.c.get();
        if (t != null) {
            Picasso picasso = this.f2204a;
            hf5.b(t, picasso.e, bitmap, dVar, this.d, picasso.m);
            pe5 pe5 = this.m;
            if (pe5 != null) {
                pe5.b();
            }
        }
    }

    @Override // defpackage.le5
    public void c(Exception exc) {
        T t = this.c.get();
        if (t != null) {
            Drawable drawable = t.getDrawable();
            if (drawable instanceof Animatable) {
                ((Animatable) drawable).stop();
            }
            int i = this.g;
            if (i != 0) {
                t.setImageResource(i);
            } else {
                Drawable drawable2 = this.h;
                if (drawable2 != null) {
                    t.setImageDrawable(drawable2);
                }
            }
            pe5 pe5 = this.m;
            if (pe5 != null) {
                pe5.a(exc);
            }
        }
    }
}
