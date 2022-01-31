package defpackage;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* renamed from: ys1  reason: default package */
/* compiled from: ImageViewTarget */
public abstract class ys1<Z> extends dt1<ImageView, Z> {
    public Animatable i;

    public ys1(ImageView imageView) {
        super(imageView);
    }

    @Override // defpackage.ct1
    public void b(Z z, ft1<? super Z> ft1) {
        j(z);
    }

    public abstract void c(Z z);

    @Override // defpackage.ct1, defpackage.vs1
    public void e(Drawable drawable) {
        j(null);
        ((ImageView) this.g).setImageDrawable(drawable);
    }

    @Override // defpackage.ct1, defpackage.vs1
    public void f(Drawable drawable) {
        j(null);
        ((ImageView) this.g).setImageDrawable(drawable);
    }

    @Override // defpackage.ct1, defpackage.vs1
    public void h(Drawable drawable) {
        this.h.a();
        j(null);
        ((ImageView) this.g).setImageDrawable(drawable);
    }

    public final void j(Z z) {
        if (z instanceof Animatable) {
            Z z2 = z;
            this.i = z2;
            z2.start();
        } else {
            this.i = null;
        }
        c(z);
    }

    @Override // defpackage.vs1, defpackage.ur1
    public void m() {
        Animatable animatable = this.i;
        if (animatable != null) {
            animatable.stop();
        }
    }

    @Override // defpackage.vs1, defpackage.ur1
    public void n() {
        Animatable animatable = this.i;
        if (animatable != null) {
            animatable.start();
        }
    }
}
