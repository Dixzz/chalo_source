package defpackage;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: rk4  reason: default package */
/* compiled from: HeaderScrollingViewBehavior */
public abstract class rk4 extends sk4<View> {
    public final Rect c = new Rect();
    public final Rect d = new Rect();
    public int e = 0;
    public int f;

    public rk4() {
    }

    @Override // defpackage.sk4
    public void C(CoordinatorLayout coordinatorLayout, View view, int i) {
        AppBarLayout E = ((AppBarLayout.ScrollingViewBehavior) this).E(coordinatorLayout.d(view));
        if (E != null) {
            CoordinatorLayout.f fVar = (CoordinatorLayout.f) view.getLayoutParams();
            Rect rect = this.c;
            rect.set(coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, E.getBottom() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin, ((E.getBottom() + coordinatorLayout.getHeight()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
            c9 lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (lastWindowInsets != null) {
                AtomicInteger atomicInteger = r8.f3055a;
                if (coordinatorLayout.getFitsSystemWindows() && !view.getFitsSystemWindows()) {
                    rect.left = lastWindowInsets.c() + rect.left;
                    rect.right -= lastWindowInsets.d();
                }
            }
            Rect rect2 = this.d;
            int i2 = fVar.c;
            Gravity.apply(i2 == 0 ? 8388659 : i2, view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
            int D = D(E);
            view.layout(rect2.left, rect2.top - D, rect2.right, rect2.bottom - D);
            this.e = rect2.top - E.getBottom();
            return;
        }
        coordinatorLayout.l(view, i);
        this.e = 0;
    }

    public final int D(View view) {
        int i;
        if (this.f == 0) {
            return 0;
        }
        float f2 = 0.0f;
        if (view instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            int totalScrollRange = appBarLayout.getTotalScrollRange();
            int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
            CoordinatorLayout.c cVar = ((CoordinatorLayout.f) appBarLayout.getLayoutParams()).f201a;
            int D = cVar instanceof AppBarLayout.BaseBehavior ? ((AppBarLayout.BaseBehavior) cVar).D() : 0;
            if ((downNestedPreScrollRange == 0 || totalScrollRange + D > downNestedPreScrollRange) && (i = totalScrollRange - downNestedPreScrollRange) != 0) {
                f2 = 1.0f + (((float) D) / ((float) i));
            }
        }
        int i2 = this.f;
        return h.r((int) (f2 * ((float) i2)), 0, i2);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        AppBarLayout E;
        c9 lastWindowInsets;
        int i5 = view.getLayoutParams().height;
        if ((i5 != -1 && i5 != -2) || (E = ((AppBarLayout.ScrollingViewBehavior) this).E(coordinatorLayout.d(view))) == null) {
            return false;
        }
        int size = View.MeasureSpec.getSize(i3);
        if (size > 0) {
            AtomicInteger atomicInteger = r8.f3055a;
            if (E.getFitsSystemWindows() && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
                size += lastWindowInsets.b() + lastWindowInsets.e();
            }
        } else {
            size = coordinatorLayout.getHeight();
        }
        coordinatorLayout.m(view, i, i2, View.MeasureSpec.makeMeasureSpec((size + E.getTotalScrollRange()) - E.getMeasuredHeight(), i5 == -1 ? CommonUtils.BYTES_IN_A_GIGABYTE : RtlSpacingHelper.UNDEFINED), i4);
        return true;
    }

    public rk4(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
