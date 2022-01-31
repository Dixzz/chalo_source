package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.Drawable;
import com.google.android.material.transformation.FabTransformationBehavior;

/* renamed from: jq4  reason: default package */
/* compiled from: FabTransformationBehavior */
public class jq4 extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ pl4 f1971a;
    public final /* synthetic */ Drawable b;

    public jq4(FabTransformationBehavior fabTransformationBehavior, pl4 pl4, Drawable drawable) {
        this.f1971a = pl4;
        this.b = drawable;
    }

    public void onAnimationEnd(Animator animator) {
        this.f1971a.setCircularRevealOverlayDrawable(null);
    }

    public void onAnimationStart(Animator animator) {
        this.f1971a.setCircularRevealOverlayDrawable(this.b);
    }
}
