package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;

/* renamed from: af  reason: default package */
/* compiled from: FragmentAnim */
public class af extends AnimationSet implements Runnable {
    public final ViewGroup f;
    public final View g;
    public boolean h;
    public boolean i;
    public boolean j = true;

    public af(Animation animation, ViewGroup viewGroup, View view) {
        super(false);
        this.f = viewGroup;
        this.g = view;
        addAnimation(animation);
        viewGroup.post(this);
    }

    public boolean getTransformation(long j2, Transformation transformation) {
        this.j = true;
        if (this.h) {
            return !this.i;
        }
        if (!super.getTransformation(j2, transformation)) {
            this.h = true;
            p8.a(this.f, this);
        }
        return true;
    }

    public void run() {
        if (this.h || !this.j) {
            this.f.endViewTransition(this.g);
            this.i = true;
            return;
        }
        this.j = false;
        this.f.post(this);
    }

    public boolean getTransformation(long j2, Transformation transformation, float f2) {
        this.j = true;
        if (this.h) {
            return !this.i;
        }
        if (!super.getTransformation(j2, transformation, f2)) {
            this.h = true;
            p8.a(this.f, this);
        }
        return true;
    }
}
