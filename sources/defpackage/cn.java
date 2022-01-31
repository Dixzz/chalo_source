package defpackage;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

/* renamed from: cn  reason: default package */
/* compiled from: SwipeRefreshLayout */
public class cn extends Animation {
    public final /* synthetic */ SwipeRefreshLayout f;

    public cn(SwipeRefreshLayout swipeRefreshLayout) {
        this.f = swipeRefreshLayout;
    }

    public void applyTransformation(float f2, Transformation transformation) {
        this.f.setAnimationProgress(f2);
    }
}
