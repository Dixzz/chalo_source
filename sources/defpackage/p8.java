package defpackage;

import android.view.View;
import android.view.ViewTreeObserver;
import java.util.Objects;

/* renamed from: p8  reason: default package */
/* compiled from: OneShotPreDrawListener */
public final class p8 implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {
    public final View f;
    public ViewTreeObserver g;
    public final Runnable h;

    public p8(View view, Runnable runnable) {
        this.f = view;
        this.g = view.getViewTreeObserver();
        this.h = runnable;
    }

    public static p8 a(View view, Runnable runnable) {
        Objects.requireNonNull(view, "view == null");
        p8 p8Var = new p8(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(p8Var);
        view.addOnAttachStateChangeListener(p8Var);
        return p8Var;
    }

    public void b() {
        if (this.g.isAlive()) {
            this.g.removeOnPreDrawListener(this);
        } else {
            this.f.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f.removeOnAttachStateChangeListener(this);
    }

    public boolean onPreDraw() {
        b();
        this.h.run();
        return true;
    }

    public void onViewAttachedToWindow(View view) {
        this.g = view.getViewTreeObserver();
    }

    public void onViewDetachedFromWindow(View view) {
        b();
    }
}
