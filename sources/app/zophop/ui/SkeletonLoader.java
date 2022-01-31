package app.zophop.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.LinearLayout;
import androidx.cardview.widget.CardView;
import app.zophop.R;
import com.facebook.shimmer.ShimmerFrameLayout;
import java.util.Objects;

/* compiled from: SkeletonLoader.kt */
public final class SkeletonLoader extends LinearLayout {
    public static final /* synthetic */ int j = 0;
    public Context f;
    public LinearLayout g;
    public boolean h = true;
    public String i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SkeletonLoader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        n86.e(context, "_context");
        this.f = context;
    }

    private final View getDivider() {
        View view = new View(this.f);
        if (ea6.g(this.i, "tripsSchedulesDirectionActivity", false, 2)) {
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) getResources().getDimension(R.dimen.universal_recent_divider_height)));
        } else {
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) getResources().getDimension(R.dimen.scheduler_results_divider)));
        }
        return view;
    }

    public final void a(View view) {
        ViewPropertyAnimator animate;
        ViewPropertyAnimator alpha;
        ViewPropertyAnimator duration;
        ViewPropertyAnimator withEndAction;
        if (view != null) {
            view.setAlpha(0.0f);
            view.animate().alpha(1.0f).setDuration(500).start();
        }
        LinearLayout linearLayout = this.g;
        if (linearLayout != null && (animate = linearLayout.animate()) != null && (alpha = animate.alpha(0.0f)) != null && (duration = alpha.setDuration(500)) != null && (withEndAction = duration.withEndAction(new f90(this))) != null) {
            withEndAction.start();
        }
    }

    public final int b(int i2) {
        return (int) Math.ceil((double) (this.f.getResources().getDisplayMetrics().heightPixels / i2));
    }

    public final void c(int i2, int i3) {
        if (i2 >= 0) {
            int i4 = 0;
            while (true) {
                int i5 = i4 + 1;
                View inflate = LayoutInflater.from(this.f).inflate(i3, (ViewGroup) null);
                Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
                ViewGroup viewGroup = (ViewGroup) inflate;
                xt1 xt1 = ((ShimmerFrameLayout) viewGroup.findViewById(R.id.shimmer_view_container)).g;
                ValueAnimator valueAnimator = xt1.e;
                if (!(valueAnimator == null || valueAnimator.isStarted() || xt1.getCallback() == null)) {
                    xt1.e.start();
                }
                CardView cardView = new CardView(getContext());
                if (ea6.f(this.i, "productSelectionActivity", true)) {
                    float applyDimension = TypedValue.applyDimension(1, 4.0f, getResources().getDisplayMetrics());
                    cardView.setClickable(true);
                    cardView.setUseCompatPadding(true);
                    cardView.setCardElevation(applyDimension);
                }
                cardView.addView(viewGroup);
                LinearLayout linearLayout = this.g;
                if (linearLayout != null) {
                    linearLayout.addView(getDivider());
                }
                LinearLayout linearLayout2 = this.g;
                if (linearLayout2 != null) {
                    linearLayout2.addView(cardView);
                }
                if (i4 != i2) {
                    i4 = i5;
                } else {
                    return;
                }
            }
        }
    }

    public final void d(boolean z, String str, boolean z2) {
        this.h = z2;
        this.i = str;
        if (this.g == null) {
            if (z2) {
                if (ea6.g(str, "productHistory", false, 2)) {
                    LayoutInflater.from(this.f).inflate(R.layout.skelton_shimmer_layout_background, (ViewGroup) this, true);
                } else {
                    LayoutInflater.from(this.f).inflate(R.layout.skeleton_shimmer_layout, (ViewGroup) this, true);
                }
                this.g = (LinearLayout) findViewById(R.id.skeleton_linear_layout);
            } else {
                LayoutInflater.from(this.f).inflate(R.layout.skeleton_shimmer_layout, (ViewGroup) this, true);
                this.g = (LinearLayout) findViewById(R.id.skeleton_linear_layout);
            }
        }
        if (z) {
            LinearLayout linearLayout = this.g;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            LinearLayout linearLayout2 = this.g;
            if (linearLayout2 != null) {
                linearLayout2.setAlpha(1.0f);
            }
            LinearLayout linearLayout3 = this.g;
            if (linearLayout3 != null) {
                linearLayout3.removeAllViews();
            }
            if (ea6.f("tripPlanner", this.i, true)) {
                c(b(300), R.layout.trip_summary_view_skeleton);
            } else if (ea6.f("productHistory", this.i, true)) {
                c(b(300), R.layout.product_history_view_skeleton);
            } else if (ea6.f("tripsSchedulesDirectionActivity", this.i, true)) {
                c(b(100), R.layout.recent_searches_skeleton);
            } else if (ea6.f("productSelectionActivity", this.i, true)) {
                c(4, R.layout.product_selection_activity_item_skeleton);
            }
        } else {
            LinearLayout linearLayout4 = this.g;
            if (linearLayout4 != null) {
                linearLayout4.removeAllViews();
            }
            LinearLayout linearLayout5 = this.g;
            if (linearLayout5 != null) {
                linearLayout5.setVisibility(8);
            }
        }
    }

    public final Context get_context() {
        return this.f;
    }

    public final boolean get_isOrientationVertical() {
        return this.h;
    }

    public final LinearLayout get_skeletonLayout() {
        return this.g;
    }

    public final String get_src() {
        return this.i;
    }

    public final void set_context(Context context) {
        n86.e(context, "<set-?>");
        this.f = context;
    }

    public final void set_isOrientationVertical(boolean z) {
        this.h = z;
    }

    public final void set_skeletonLayout(LinearLayout linearLayout) {
        this.g = linearLayout;
    }

    public final void set_src(String str) {
        this.i = str;
    }
}
