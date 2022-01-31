package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.animation.Animation;
import android.widget.ImageView;
import androidx.swiperefreshlayout.R;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: ym  reason: default package */
/* compiled from: CircleImageView */
public class ym extends ImageView {
    public Animation.AnimationListener f;
    public int g;
    public int h;

    public ym(Context context) {
        super(context);
        float f2 = getContext().getResources().getDisplayMetrics().density;
        this.g = (int) (3.5f * f2);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(R.styleable.SwipeRefreshLayout);
        this.h = obtainStyledAttributes.getColor(R.styleable.SwipeRefreshLayout_swipeRefreshLayoutProgressSpinnerBackgroundColor, -328966);
        obtainStyledAttributes.recycle();
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        AtomicInteger atomicInteger = r8.f3055a;
        setElevation(f2 * 4.0f);
        shapeDrawable.getPaint().setColor(this.h);
        setBackground(shapeDrawable);
    }

    public void onAnimationEnd() {
        super.onAnimationEnd();
        Animation.AnimationListener animationListener = this.f;
        if (animationListener != null) {
            animationListener.onAnimationEnd(getAnimation());
        }
    }

    public void onAnimationStart() {
        super.onAnimationStart();
        Animation.AnimationListener animationListener = this.f;
        if (animationListener != null) {
            animationListener.onAnimationStart(getAnimation());
        }
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void setBackgroundColor(int i) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i);
            this.h = i;
        }
    }
}
