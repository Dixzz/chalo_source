package defpackage;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import java.lang.ref.WeakReference;
import java.util.Objects;

/* renamed from: se5  reason: default package */
/* compiled from: DeferredRequestCreator */
public class se5 implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {
    public final kf5 f;
    public final WeakReference<ImageView> g;
    public pe5 h;

    public boolean onPreDraw() {
        ImageView imageView = this.g.get();
        if (imageView == null) {
            return true;
        }
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        int width = imageView.getWidth();
        int height = imageView.getHeight();
        if (width > 0 && height > 0) {
            imageView.removeOnAttachStateChangeListener(this);
            viewTreeObserver.removeOnPreDrawListener(this);
            this.g.clear();
            kf5 kf5 = this.f;
            Objects.requireNonNull(kf5);
            kf5.b.b(width, height);
            kf5.d(imageView, this.h);
        }
        return true;
    }

    public void onViewAttachedToWindow(View view) {
        view.getViewTreeObserver().addOnPreDrawListener(this);
    }

    public void onViewDetachedFromWindow(View view) {
        view.getViewTreeObserver().removeOnPreDrawListener(this);
    }
}
