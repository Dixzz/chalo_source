package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R;
import defpackage.e9;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AppBarLayout extends LinearLayout implements CoordinatorLayout.b {
    public static final int v = R.style.Widget_Design_AppBarLayout;
    public int f;
    public int g = -1;
    public int h = -1;
    public int i = -1;
    public boolean j;
    public int k = 0;
    public c9 l;
    public List<a> m;
    public boolean n;
    public boolean o;
    public boolean p;
    public int q;
    public WeakReference<View> r;
    public ValueAnimator s;
    public int[] t;
    public Drawable u;

    public static class Behavior extends BaseBehavior<AppBarLayout> {

        public static abstract class a extends BaseBehavior.a<AppBarLayout> {
        }

        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static class ScrollingViewBehavior extends rk4 {
        public ScrollingViewBehavior() {
        }

        public AppBarLayout E(List<View> list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                View view = list.get(i);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean d(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean g(CoordinatorLayout coordinatorLayout, View view, View view2) {
            CoordinatorLayout.c cVar = ((CoordinatorLayout.f) view2.getLayoutParams()).f201a;
            if (cVar instanceof BaseBehavior) {
                r8.o(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) cVar).j) + this.e) - D(view2));
            }
            if (!(view2 instanceof AppBarLayout)) {
                return false;
            }
            AppBarLayout appBarLayout = (AppBarLayout) view2;
            if (!appBarLayout.p) {
                return false;
            }
            appBarLayout.d(appBarLayout.e(view));
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void h(CoordinatorLayout coordinatorLayout, View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                r8.s(e9.a.h.a(), coordinatorLayout);
                r8.m(coordinatorLayout, 0);
                r8.s(e9.a.i.a(), coordinatorLayout);
                r8.m(coordinatorLayout, 0);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean t(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
            AppBarLayout E = E(coordinatorLayout.d(view));
            if (E != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.c;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    E.c(false, !z, true);
                    return true;
                }
            }
            return false;
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ScrollingViewBehavior_Layout);
            this.f = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ScrollingViewBehavior_Layout_behavior_overlapTop, 0);
            obtainStyledAttributes.recycle();
        }
    }

    public interface a<T extends AppBarLayout> {
        void a(T t, int i);
    }

    public interface c extends a<AppBarLayout> {
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AppBarLayout(android.content.Context r13, android.util.AttributeSet r14) {
        /*
        // Method dump skipped, instructions count: 247
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    /* renamed from: a */
    public b generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            return new b((LinearLayout.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new b((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new b(layoutParams);
    }

    public void b(int i2) {
        this.f = i2;
        if (!willNotDraw()) {
            AtomicInteger atomicInteger = r8.f3055a;
            postInvalidateOnAnimation();
        }
        List<a> list = this.m;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                a aVar = this.m.get(i3);
                if (aVar != null) {
                    aVar.a(this, i2);
                }
            }
        }
    }

    public final void c(boolean z, boolean z2, boolean z3) {
        int i2 = 0;
        int i3 = (z ? 1 : 2) | (z2 ? 4 : 0);
        if (z3) {
            i2 = 8;
        }
        this.k = i3 | i2;
        requestLayout();
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof b;
    }

    public boolean d(boolean z) {
        if (this.o == z) {
            return false;
        }
        this.o = z;
        refreshDrawableState();
        if (this.p && (getBackground() instanceof ho4)) {
            ho4 ho4 = (ho4) getBackground();
            float dimension = getResources().getDimension(R.dimen.design_appbar_elevation);
            float f2 = z ? 0.0f : dimension;
            if (!z) {
                dimension = 0.0f;
            }
            ValueAnimator valueAnimator = this.s;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(f2, dimension);
            this.s = ofFloat;
            ofFloat.setDuration((long) getResources().getInteger(R.integer.app_bar_elevation_anim_duration));
            this.s.setInterpolator(zj4.f4184a);
            this.s.addUpdateListener(new kk4(this, ho4));
            this.s.start();
        }
        return true;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.u != null && getTopInset() > 0) {
            int save = canvas.save();
            canvas.translate(0.0f, (float) (-this.f));
            this.u.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.u;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    public boolean e(View view) {
        int i2;
        View view2 = null;
        if (this.r == null && (i2 = this.q) != -1) {
            View findViewById = view != null ? view.findViewById(i2) : null;
            if (findViewById == null && (getParent() instanceof ViewGroup)) {
                findViewById = ((ViewGroup) getParent()).findViewById(this.q);
            }
            if (findViewById != null) {
                this.r = new WeakReference<>(findViewById);
            }
        }
        WeakReference<View> weakReference = this.r;
        if (weakReference != null) {
            view2 = weakReference.get();
        }
        if (view2 != null) {
            view = view2;
        }
        return view != null && (view.canScrollVertically(-1) || view.getScrollY() > 0);
    }

    public final boolean f() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        if (childAt.getVisibility() == 8) {
            return false;
        }
        AtomicInteger atomicInteger = r8.f3055a;
        if (!childAt.getFitsSystemWindows()) {
            return true;
        }
        return false;
    }

    public final void g() {
        setWillNotDraw(!(this.u != null && getTopInset() > 0));
    }

    @Override // android.widget.LinearLayout, android.widget.LinearLayout
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new b(-1, -2);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<AppBarLayout> getBehavior() {
        return new Behavior();
    }

    public int getDownNestedPreScrollRange() {
        int i2;
        int i3 = this.h;
        if (i3 != -1) {
            return i3;
        }
        int i4 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            b bVar = (b) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = bVar.f609a;
            if ((i5 & 5) == 5) {
                int i6 = ((LinearLayout.LayoutParams) bVar).topMargin + ((LinearLayout.LayoutParams) bVar).bottomMargin;
                if ((i5 & 8) != 0) {
                    AtomicInteger atomicInteger = r8.f3055a;
                    i2 = i6 + childAt.getMinimumHeight();
                } else if ((i5 & 2) != 0) {
                    AtomicInteger atomicInteger2 = r8.f3055a;
                    i2 = i6 + (measuredHeight - childAt.getMinimumHeight());
                } else {
                    i2 = i6 + measuredHeight;
                }
                if (childCount == 0) {
                    AtomicInteger atomicInteger3 = r8.f3055a;
                    if (childAt.getFitsSystemWindows()) {
                        i2 = Math.min(i2, measuredHeight - getTopInset());
                    }
                }
                i4 += i2;
            } else if (i4 > 0) {
                break;
            }
        }
        int max = Math.max(0, i4);
        this.h = max;
        return max;
    }

    public int getDownNestedScrollRange() {
        int i2 = this.i;
        if (i2 != -1) {
            return i2;
        }
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= childCount) {
                break;
            }
            View childAt = getChildAt(i3);
            b bVar = (b) childAt.getLayoutParams();
            int measuredHeight = ((LinearLayout.LayoutParams) bVar).topMargin + ((LinearLayout.LayoutParams) bVar).bottomMargin + childAt.getMeasuredHeight();
            int i5 = bVar.f609a;
            if ((i5 & 1) == 0) {
                break;
            }
            i4 += measuredHeight;
            if ((i5 & 2) != 0) {
                AtomicInteger atomicInteger = r8.f3055a;
                i4 -= childAt.getMinimumHeight();
                break;
            }
            i3++;
        }
        int max = Math.max(0, i4);
        this.i = max;
        return max;
    }

    public int getLiftOnScrollTargetViewId() {
        return this.q;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        AtomicInteger atomicInteger = r8.f3055a;
        int minimumHeight = getMinimumHeight();
        if (minimumHeight == 0) {
            int childCount = getChildCount();
            minimumHeight = childCount >= 1 ? getChildAt(childCount - 1).getMinimumHeight() : 0;
            if (minimumHeight == 0) {
                return getHeight() / 3;
            }
        }
        return (minimumHeight * 2) + topInset;
    }

    public int getPendingAction() {
        return this.k;
    }

    public Drawable getStatusBarForeground() {
        return this.u;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    public final int getTopInset() {
        c9 c9Var = this.l;
        if (c9Var != null) {
            return c9Var.e();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i2 = this.g;
        if (i2 != -1) {
            return i2;
        }
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= childCount) {
                break;
            }
            View childAt = getChildAt(i3);
            b bVar = (b) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = bVar.f609a;
            if ((i5 & 1) == 0) {
                break;
            }
            int i6 = measuredHeight + ((LinearLayout.LayoutParams) bVar).topMargin + ((LinearLayout.LayoutParams) bVar).bottomMargin + i4;
            if (i3 == 0) {
                AtomicInteger atomicInteger = r8.f3055a;
                if (childAt.getFitsSystemWindows()) {
                    i6 -= getTopInset();
                }
            }
            i4 = i6;
            if ((i5 & 2) != 0) {
                AtomicInteger atomicInteger2 = r8.f3055a;
                i4 -= childAt.getMinimumHeight();
                break;
            }
            i3++;
        }
        int max = Math.max(0, i4);
        this.g = max;
        return max;
    }

    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable background = getBackground();
        if (background instanceof ho4) {
            hd3.N2(this, (ho4) background);
        }
    }

    public int[] onCreateDrawableState(int i2) {
        if (this.t == null) {
            this.t = new int[4];
        }
        int[] iArr = this.t;
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + iArr.length);
        boolean z = this.n;
        int i3 = R.attr.state_liftable;
        if (!z) {
            i3 = -i3;
        }
        iArr[0] = i3;
        iArr[1] = (!z || !this.o) ? -R.attr.state_lifted : R.attr.state_lifted;
        int i4 = R.attr.state_collapsible;
        if (!z) {
            i4 = -i4;
        }
        iArr[2] = i4;
        iArr[3] = (!z || !this.o) ? -R.attr.state_collapsed : R.attr.state_collapsed;
        return LinearLayout.mergeDrawableStates(onCreateDrawableState, iArr);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        WeakReference<View> weakReference = this.r;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.r = null;
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        boolean z2;
        super.onLayout(z, i2, i3, i4, i5);
        AtomicInteger atomicInteger = r8.f3055a;
        boolean z3 = true;
        if (getFitsSystemWindows() && f()) {
            int topInset = getTopInset();
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                r8.o(getChildAt(childCount), topInset);
            }
        }
        this.g = -1;
        this.h = -1;
        this.i = -1;
        this.j = false;
        int childCount2 = getChildCount();
        int i6 = 0;
        while (true) {
            if (i6 >= childCount2) {
                break;
            } else if (((b) getChildAt(i6).getLayoutParams()).b != null) {
                this.j = true;
                break;
            } else {
                i6++;
            }
        }
        Drawable drawable = this.u;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (!this.p) {
            int childCount3 = getChildCount();
            int i7 = 0;
            while (true) {
                if (i7 >= childCount3) {
                    z2 = false;
                    break;
                }
                int i8 = ((b) getChildAt(i7).getLayoutParams()).f609a;
                if ((i8 & 1) == 1 && (i8 & 10) != 0) {
                    z2 = true;
                    break;
                }
                i7++;
            }
            if (!z2) {
                z3 = false;
            }
        }
        if (this.n != z3) {
            this.n = z3;
            refreshDrawableState();
        }
    }

    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i3);
        if (mode != 1073741824) {
            AtomicInteger atomicInteger = r8.f3055a;
            if (getFitsSystemWindows() && f()) {
                int measuredHeight = getMeasuredHeight();
                if (mode == Integer.MIN_VALUE) {
                    measuredHeight = h.r(getTopInset() + getMeasuredHeight(), 0, View.MeasureSpec.getSize(i3));
                } else if (mode == 0) {
                    measuredHeight += getTopInset();
                }
                setMeasuredDimension(getMeasuredWidth(), measuredHeight);
            }
        }
        this.g = -1;
        this.h = -1;
        this.i = -1;
    }

    public void setElevation(float f2) {
        super.setElevation(f2);
        hd3.L2(this, f2);
    }

    public void setExpanded(boolean z) {
        AtomicInteger atomicInteger = r8.f3055a;
        c(z, isLaidOut(), true);
    }

    public void setLiftOnScroll(boolean z) {
        this.p = z;
    }

    public void setLiftOnScrollTargetViewId(int i2) {
        this.q = i2;
        WeakReference<View> weakReference = this.r;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.r = null;
    }

    public void setOrientation(int i2) {
        if (i2 == 1) {
            super.setOrientation(i2);
            return;
        }
        throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
    }

    public void setStatusBarForeground(Drawable drawable) {
        Drawable drawable2 = this.u;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.u = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.u.setState(getDrawableState());
                }
                Drawable drawable4 = this.u;
                AtomicInteger atomicInteger = r8.f3055a;
                h.s0(drawable4, getLayoutDirection());
                this.u.setVisible(getVisibility() == 0, false);
                this.u.setCallback(this);
            }
            g();
            AtomicInteger atomicInteger2 = r8.f3055a;
            postInvalidateOnAnimation();
        }
    }

    public void setStatusBarForegroundColor(int i2) {
        setStatusBarForeground(new ColorDrawable(i2));
    }

    public void setStatusBarForegroundResource(int i2) {
        setStatusBarForeground(u0.b(getContext(), i2));
    }

    @Deprecated
    public void setTargetElevation(float f2) {
        uk4.a(this, f2);
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z = i2 == 0;
        Drawable drawable = this.u;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
    }

    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.u;
    }

    public static class BaseBehavior<T extends AppBarLayout> extends qk4<T> {
        public int j;
        public int k;
        public ValueAnimator l;
        public int m = -1;
        public boolean n;
        public float o;
        public WeakReference<View> p;
        public a q;

        public static abstract class a<T extends AppBarLayout> {
            public abstract boolean a(T t);
        }

        public BaseBehavior() {
        }

        public static boolean I(int i, int i2) {
            return (i & i2) == i2;
        }

        @Override // defpackage.qk4
        public int D() {
            return B() + this.j;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: com.google.android.material.appbar.AppBarLayout$BaseBehavior<T extends com.google.android.material.appbar.AppBarLayout> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x008f  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x0094  */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x00bc  */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x00db  */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x00de  */
        @Override // defpackage.qk4
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int G(androidx.coordinatorlayout.widget.CoordinatorLayout r8, android.view.View r9, int r10, int r11, int r12) {
            /*
            // Method dump skipped, instructions count: 239
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.G(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, int, int, int):int");
        }

        public final void H(CoordinatorLayout coordinatorLayout, T t, int i, float f) {
            int i2;
            int abs = Math.abs(D() - i);
            float abs2 = Math.abs(f);
            if (abs2 > 0.0f) {
                i2 = Math.round((((float) abs) / abs2) * 1000.0f) * 3;
            } else {
                i2 = (int) (((((float) abs) / ((float) t.getHeight())) + 1.0f) * 150.0f);
            }
            int D = D();
            if (D == i) {
                ValueAnimator valueAnimator = this.l;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.l.cancel();
                    return;
                }
                return;
            }
            ValueAnimator valueAnimator2 = this.l;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.l = valueAnimator3;
                valueAnimator3.setInterpolator(zj4.e);
                this.l.addUpdateListener(new lk4(this, coordinatorLayout, t));
            } else {
                valueAnimator2.cancel();
            }
            this.l.setDuration((long) Math.min(i2, 600));
            this.l.setIntValues(D, i);
            this.l.start();
        }

        public final View J(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if ((childAt instanceof h8) || (childAt instanceof ListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        /* JADX WARN: Incorrect args count in method signature: (Landroidx/coordinatorlayout/widget/CoordinatorLayout;TT;Landroid/view/View;II[II)V */
        public void K(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int[] iArr) {
            int i2;
            int i3;
            if (i != 0) {
                if (i < 0) {
                    int i4 = -appBarLayout.getTotalScrollRange();
                    i3 = i4;
                    i2 = appBarLayout.getDownNestedPreScrollRange() + i4;
                } else {
                    i3 = -appBarLayout.getUpNestedPreScrollRange();
                    i2 = 0;
                }
                if (i3 != i2) {
                    iArr[1] = E(coordinatorLayout, appBarLayout, i, i3, i2);
                }
            }
            if (appBarLayout.p) {
                appBarLayout.d(appBarLayout.e(view));
            }
        }

        /* JADX WARN: Incorrect args count in method signature: (Landroidx/coordinatorlayout/widget/CoordinatorLayout;TT;Landroid/view/View;IIIII[I)V */
        /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: com.google.android.material.appbar.AppBarLayout */
        /* JADX WARN: Multi-variable type inference failed */
        public void L(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int[] iArr) {
            if (i < 0) {
                iArr[1] = E(coordinatorLayout, appBarLayout, i, -appBarLayout.getDownNestedScrollRange(), 0);
            }
            if (i == 0) {
                O(coordinatorLayout, appBarLayout);
            }
        }

        /* JADX WARN: Incorrect args count in method signature: (Landroidx/coordinatorlayout/widget/CoordinatorLayout;TT;Landroid/view/View;Landroid/view/View;II)Z */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0027, code lost:
            if (((r4.getTotalScrollRange() != 0) && r3.getHeight() - r5.getHeight() <= r4.getHeight()) != false) goto L_0x002b;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean M(androidx.coordinatorlayout.widget.CoordinatorLayout r3, com.google.android.material.appbar.AppBarLayout r4, android.view.View r5, int r6, int r7) {
            /*
                r2 = this;
                r6 = r6 & 2
                r0 = 1
                r1 = 0
                if (r6 == 0) goto L_0x002a
                boolean r6 = r4.p
                if (r6 != 0) goto L_0x002b
                int r6 = r4.getTotalScrollRange()
                if (r6 == 0) goto L_0x0012
                r6 = 1
                goto L_0x0013
            L_0x0012:
                r6 = 0
            L_0x0013:
                if (r6 == 0) goto L_0x0026
                int r3 = r3.getHeight()
                int r5 = r5.getHeight()
                int r3 = r3 - r5
                int r4 = r4.getHeight()
                if (r3 > r4) goto L_0x0026
                r3 = 1
                goto L_0x0027
            L_0x0026:
                r3 = 0
            L_0x0027:
                if (r3 == 0) goto L_0x002a
                goto L_0x002b
            L_0x002a:
                r0 = 0
            L_0x002b:
                if (r0 == 0) goto L_0x0034
                android.animation.ValueAnimator r3 = r2.l
                if (r3 == 0) goto L_0x0034
                r3.cancel()
            L_0x0034:
                r3 = 0
                r2.p = r3
                r2.k = r7
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.M(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout, android.view.View, int, int):boolean");
        }

        public final void N(CoordinatorLayout coordinatorLayout, T t) {
            int D = D();
            int childCount = t.getChildCount();
            int i = 0;
            while (true) {
                if (i >= childCount) {
                    i = -1;
                    break;
                }
                View childAt = t.getChildAt(i);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                b bVar = (b) childAt.getLayoutParams();
                if (I(bVar.f609a, 32)) {
                    top -= ((LinearLayout.LayoutParams) bVar).topMargin;
                    bottom += ((LinearLayout.LayoutParams) bVar).bottomMargin;
                }
                int i2 = -D;
                if (top <= i2 && bottom >= i2) {
                    break;
                }
                i++;
            }
            if (i >= 0) {
                View childAt2 = t.getChildAt(i);
                b bVar2 = (b) childAt2.getLayoutParams();
                int i3 = bVar2.f609a;
                if ((i3 & 17) == 17) {
                    int i4 = -childAt2.getTop();
                    int i5 = -childAt2.getBottom();
                    if (i == t.getChildCount() - 1) {
                        i5 += t.getTopInset();
                    }
                    if (I(i3, 2)) {
                        AtomicInteger atomicInteger = r8.f3055a;
                        i5 += childAt2.getMinimumHeight();
                    } else if (I(i3, 5)) {
                        AtomicInteger atomicInteger2 = r8.f3055a;
                        int minimumHeight = childAt2.getMinimumHeight() + i5;
                        if (D < minimumHeight) {
                            i4 = minimumHeight;
                        } else {
                            i5 = minimumHeight;
                        }
                    }
                    if (I(i3, 32)) {
                        i4 += ((LinearLayout.LayoutParams) bVar2).topMargin;
                        i5 -= ((LinearLayout.LayoutParams) bVar2).bottomMargin;
                    }
                    if (D < (i5 + i4) / 2) {
                        i4 = i5;
                    }
                    H(coordinatorLayout, t, h.r(i4, -t.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        public final void O(CoordinatorLayout coordinatorLayout, T t) {
            e9.a aVar = e9.a.h;
            r8.s(aVar.a(), coordinatorLayout);
            r8.m(coordinatorLayout, 0);
            e9.a aVar2 = e9.a.i;
            r8.s(aVar2.a(), coordinatorLayout);
            r8.m(coordinatorLayout, 0);
            View J = J(coordinatorLayout);
            if (J != null && t.getTotalScrollRange() != 0 && (((CoordinatorLayout.f) J.getLayoutParams()).f201a instanceof ScrollingViewBehavior)) {
                if (D() != (-t.getTotalScrollRange()) && J.canScrollVertically(1)) {
                    r8.t(coordinatorLayout, aVar, null, new nk4(this, t, false));
                }
                if (D() == 0) {
                    return;
                }
                if (J.canScrollVertically(-1)) {
                    int i = -t.getDownNestedPreScrollRange();
                    if (i != 0) {
                        r8.t(coordinatorLayout, aVar2, null, new mk4(this, coordinatorLayout, t, J, i));
                        return;
                    }
                    return;
                }
                r8.t(coordinatorLayout, aVar2, null, new nk4(this, t, true));
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x0062  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x0070  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void P(androidx.coordinatorlayout.widget.CoordinatorLayout r7, T r8, int r9, int r10, boolean r11) {
            /*
            // Method dump skipped, instructions count: 160
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.P(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout, int, int, boolean):void");
        }

        /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: com.google.android.material.appbar.AppBarLayout$BaseBehavior<T extends com.google.android.material.appbar.AppBarLayout> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c, defpackage.sk4
        public boolean k(CoordinatorLayout coordinatorLayout, View view, int i) {
            int i2;
            AppBarLayout appBarLayout = (AppBarLayout) view;
            super.k(coordinatorLayout, appBarLayout, i);
            int pendingAction = appBarLayout.getPendingAction();
            int i3 = this.m;
            if (i3 >= 0 && (pendingAction & 8) == 0) {
                View childAt = appBarLayout.getChildAt(i3);
                int i4 = -childAt.getBottom();
                if (this.n) {
                    i2 = appBarLayout.getTopInset() + childAt.getMinimumHeight() + i4;
                } else {
                    i2 = Math.round(((float) childAt.getHeight()) * this.o) + i4;
                }
                F(coordinatorLayout, appBarLayout, i2);
            } else if (pendingAction != 0) {
                boolean z = (pendingAction & 4) != 0;
                if ((pendingAction & 2) != 0) {
                    int i5 = -appBarLayout.getUpNestedPreScrollRange();
                    if (z) {
                        H(coordinatorLayout, appBarLayout, i5, 0.0f);
                    } else {
                        F(coordinatorLayout, appBarLayout, i5);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (z) {
                        H(coordinatorLayout, appBarLayout, 0, 0.0f);
                    } else {
                        F(coordinatorLayout, appBarLayout, 0);
                    }
                }
            }
            appBarLayout.k = 0;
            this.m = -1;
            int r = h.r(B(), -appBarLayout.getTotalScrollRange(), 0);
            tk4 tk4 = this.f3223a;
            if (tk4 != null) {
                tk4.b(r);
            } else {
                this.b = r;
            }
            P(coordinatorLayout, appBarLayout, B(), 0, true);
            appBarLayout.b(B());
            O(coordinatorLayout, appBarLayout);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean l(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) appBarLayout.getLayoutParams())).height != -2) {
                return false;
            }
            coordinatorLayout.m(appBarLayout, i, i2, View.MeasureSpec.makeMeasureSpec(0, 0), i4);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ void p(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int[] iArr, int i3) {
            K(coordinatorLayout, (AppBarLayout) view, view2, i2, iArr);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ void r(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int i3, int i4, int i5, int[] iArr) {
            L(coordinatorLayout, (AppBarLayout) view, i4, iArr);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void u(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (parcelable instanceof SavedState) {
                SavedState savedState = (SavedState) parcelable;
                savedState.getSuperState();
                this.m = savedState.f;
                this.o = savedState.g;
                this.n = savedState.h;
                return;
            }
            this.m = -1;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public Parcelable v(CoordinatorLayout coordinatorLayout, View view) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            AbsSavedState absSavedState = View.BaseSavedState.EMPTY_STATE;
            int B = B();
            int childCount = appBarLayout.getChildCount();
            boolean z = false;
            for (int i = 0; i < childCount; i++) {
                View childAt = appBarLayout.getChildAt(i);
                int bottom = childAt.getBottom() + B;
                if (childAt.getTop() + B <= 0 && bottom >= 0) {
                    SavedState savedState = new SavedState(absSavedState);
                    savedState.f = i;
                    AtomicInteger atomicInteger = r8.f3055a;
                    if (bottom == appBarLayout.getTopInset() + childAt.getMinimumHeight()) {
                        z = true;
                    }
                    savedState.h = z;
                    savedState.g = ((float) bottom) / ((float) childAt.getHeight());
                    return savedState;
                }
            }
            return absSavedState;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean x(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i, int i2) {
            return M(coordinatorLayout, (AppBarLayout) view, view2, i, i2);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.android.material.appbar.AppBarLayout$BaseBehavior<T extends com.google.android.material.appbar.AppBarLayout> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void z(CoordinatorLayout coordinatorLayout, View view, View view2, int i) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (this.k == 0 || i == 1) {
                N(coordinatorLayout, appBarLayout);
                if (appBarLayout.p) {
                    appBarLayout.d(appBarLayout.e(view2));
                }
            }
            this.p = new WeakReference<>(view2);
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public static class SavedState extends androidx.customview.view.AbsSavedState {
            public static final Parcelable.Creator<SavedState> CREATOR = new a();
            public int f;
            public float g;
            public boolean h;

            public static class a implements Parcelable.ClassLoaderCreator<SavedState> {
                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // android.os.Parcelable.ClassLoaderCreator
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return new SavedState(parcel, classLoader);
                }

                @Override // android.os.Parcelable.Creator
                public Object[] newArray(int i) {
                    return new SavedState[i];
                }

                @Override // android.os.Parcelable.Creator
                public Object createFromParcel(Parcel parcel) {
                    return new SavedState(parcel, null);
                }
            }

            public SavedState(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.f = parcel.readInt();
                this.g = parcel.readFloat();
                this.h = parcel.readByte() != 0;
            }

            @Override // androidx.customview.view.AbsSavedState
            public void writeToParcel(Parcel parcel, int i) {
                super.writeToParcel(parcel, i);
                parcel.writeInt(this.f);
                parcel.writeFloat(this.g);
                parcel.writeByte(this.h ? (byte) 1 : 0);
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }
        }
    }

    @Override // android.widget.LinearLayout, android.widget.LinearLayout
    /* renamed from: generateDefaultLayoutParams  reason: collision with other method in class */
    public LinearLayout.LayoutParams m7generateDefaultLayoutParams() {
        return new b(-1, -2);
    }

    @Override // android.widget.LinearLayout, android.widget.LinearLayout, android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    @Override // android.widget.LinearLayout, android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: generateLayoutParams  reason: collision with other method in class */
    public LinearLayout.LayoutParams m8generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    public static class b extends LinearLayout.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f609a = 1;
        public Interpolator b;

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AppBarLayout_Layout);
            this.f609a = obtainStyledAttributes.getInt(R.styleable.AppBarLayout_Layout_layout_scrollFlags, 0);
            int i = R.styleable.AppBarLayout_Layout_layout_scrollInterpolator;
            if (obtainStyledAttributes.hasValue(i)) {
                this.b = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(i, 0));
            }
            obtainStyledAttributes.recycle();
        }

        public b(int i, int i2) {
            super(i, i2);
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public b(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }
}
