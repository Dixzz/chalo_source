package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class BottomAppBar extends Toolbar implements CoordinatorLayout.b {
    public static final /* synthetic */ int o = 0;
    public Animator f;
    public Animator g;
    public int h;
    public int i;
    public boolean j;
    public int k;
    public int l;
    public boolean m;
    public Behavior n;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public int f;
        public boolean g;

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

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f);
            parcel.writeInt(this.g ? 1 : 0);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f = parcel.readInt();
            this.g = parcel.readInt() != 0;
        }
    }

    public static void a(BottomAppBar bottomAppBar) {
        bottomAppBar.k--;
    }

    private ActionMenuView getActionMenuView() {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    private int getBottomInset() {
        return 0;
    }

    private float getFabTranslationX() {
        return f(this.h);
    }

    private float getFabTranslationY() {
        return -getTopEdgeTreatment().h;
    }

    private int getLeftInset() {
        return 0;
    }

    private int getRightInset() {
        return 0;
    }

    private cl4 getTopEdgeTreatment() {
        throw null;
    }

    /* JADX WARN: Incorrect args count in method signature: (ILjava/util/List<Landroid/animation/Animator;>;)V */
    public void b(int i2) {
        FloatingActionButton c = c();
        if (c != null && !c.j()) {
            this.k++;
            c.i(new xk4(this, i2), true);
        }
    }

    public final FloatingActionButton c() {
        View d = d();
        if (d instanceof FloatingActionButton) {
            return (FloatingActionButton) d;
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x001e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View d() {
        /*
            r4 = this;
            android.view.ViewParent r0 = r4.getParent()
            boolean r0 = r0 instanceof androidx.coordinatorlayout.widget.CoordinatorLayout
            r1 = 0
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            android.view.ViewParent r0 = r4.getParent()
            androidx.coordinatorlayout.widget.CoordinatorLayout r0 = (androidx.coordinatorlayout.widget.CoordinatorLayout) r0
            java.util.List r0 = r0.e(r4)
            java.util.Iterator r0 = r0.iterator()
        L_0x0018:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x002d
            java.lang.Object r2 = r0.next()
            android.view.View r2 = (android.view.View) r2
            boolean r3 = r2 instanceof com.google.android.material.floatingactionbutton.FloatingActionButton
            if (r3 != 0) goto L_0x002c
            boolean r3 = r2 instanceof com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
            if (r3 == 0) goto L_0x0018
        L_0x002c:
            return r2
        L_0x002d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomappbar.BottomAppBar.d():android.view.View");
    }

    public int e(ActionMenuView actionMenuView, int i2, boolean z) {
        if (i2 != 1 || !z) {
            return 0;
        }
        boolean M1 = hd3.M1(this);
        int measuredWidth = M1 ? getMeasuredWidth() : 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if ((childAt.getLayoutParams() instanceof Toolbar.LayoutParams) && (((Toolbar.LayoutParams) childAt.getLayoutParams()).gravity & 8388615) == 8388611) {
                if (M1) {
                    measuredWidth = Math.min(measuredWidth, childAt.getLeft());
                } else {
                    measuredWidth = Math.max(measuredWidth, childAt.getRight());
                }
            }
        }
        return measuredWidth - ((M1 ? actionMenuView.getRight() : actionMenuView.getLeft()) + 0);
    }

    public final float f(int i2) {
        boolean M1 = hd3.M1(this);
        int i3 = 1;
        if (i2 != 1) {
            return 0.0f;
        }
        int measuredWidth = (getMeasuredWidth() / 2) + 0;
        if (M1) {
            i3 = -1;
        }
        return (float) (measuredWidth * i3);
    }

    public final boolean g() {
        FloatingActionButton c = c();
        return c != null && c.k();
    }

    public ColorStateList getBackgroundTint() {
        throw null;
    }

    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().h;
    }

    public int getFabAlignmentMode() {
        return this.h;
    }

    public int getFabAnimationMode() {
        return this.i;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().g;
    }

    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().f;
    }

    public boolean getHideOnScroll() {
        return this.j;
    }

    public final void h() {
        getTopEdgeTreatment().i = getFabTranslationX();
        d();
        if (this.m) {
            g();
        }
        throw null;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        throw null;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (z) {
            Animator animator = this.g;
            if (animator != null) {
                animator.cancel();
            }
            Animator animator2 = this.f;
            if (animator2 != null) {
                animator2.cancel();
            }
            h();
            throw null;
        }
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView != null && this.g == null) {
            actionMenuView.setAlpha(1.0f);
            if (!g()) {
                actionMenuView.setTranslationX((float) e(actionMenuView, 0, false));
            } else {
                actionMenuView.setTranslationX((float) e(actionMenuView, this.h, this.m));
            }
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.h = savedState.f;
        this.m = savedState.g;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f = this.h;
        savedState.g = this.m;
        return savedState;
    }

    public void setBackgroundTint(ColorStateList colorStateList) {
        throw null;
    }

    public void setCradleVerticalOffset(float f2) {
        if (f2 != getCradleVerticalOffset()) {
            cl4 topEdgeTreatment = getTopEdgeTreatment();
            Objects.requireNonNull(topEdgeTreatment);
            if (f2 >= 0.0f) {
                topEdgeTreatment.h = f2;
                throw null;
            }
            throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
        }
    }

    public void setElevation(float f2) {
        throw null;
    }

    public void setFabAlignmentMode(int i2) {
        int i3;
        this.l = 0;
        boolean z = this.m;
        AtomicInteger atomicInteger = r8.f3055a;
        if (!isLaidOut()) {
            int i4 = this.l;
            if (i4 != 0) {
                this.l = 0;
                getMenu().clear();
                inflateMenu(i4);
            }
        } else {
            Animator animator = this.g;
            if (animator != null) {
                animator.cancel();
            }
            ArrayList arrayList = new ArrayList();
            if (!g()) {
                z = false;
                i3 = 0;
            } else {
                i3 = i2;
            }
            ActionMenuView actionMenuView = getActionMenuView();
            if (actionMenuView != null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 1.0f);
                if (Math.abs(actionMenuView.getTranslationX() - ((float) e(actionMenuView, i3, z))) > 1.0f) {
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(actionMenuView, "alpha", 0.0f);
                    ofFloat2.addListener(new zk4(this, actionMenuView, i3, z));
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.setDuration(150L);
                    animatorSet.playSequentially(ofFloat2, ofFloat);
                    arrayList.add(animatorSet);
                } else if (actionMenuView.getAlpha() < 1.0f) {
                    arrayList.add(ofFloat);
                }
            }
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.playTogether(arrayList);
            this.g = animatorSet2;
            animatorSet2.addListener(new yk4(this));
            this.g.start();
        }
        if (this.h != i2 && isLaidOut()) {
            Animator animator2 = this.f;
            if (animator2 != null) {
                animator2.cancel();
            }
            ArrayList arrayList2 = new ArrayList();
            if (this.i == 1) {
                ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(c(), "translationX", f(i2));
                ofFloat3.setDuration(300L);
                arrayList2.add(ofFloat3);
            } else {
                b(i2);
            }
            AnimatorSet animatorSet3 = new AnimatorSet();
            animatorSet3.playTogether(arrayList2);
            this.f = animatorSet3;
            animatorSet3.addListener(new wk4(this));
            this.f.start();
        }
        this.h = i2;
    }

    public void setFabAnimationMode(int i2) {
        this.i = i2;
    }

    public void setFabCradleMargin(float f2) {
        if (f2 != getFabCradleMargin()) {
            getTopEdgeTreatment().g = f2;
            throw null;
        }
    }

    public void setFabCradleRoundedCornerRadius(float f2) {
        if (f2 != getFabCradleRoundedCornerRadius()) {
            getTopEdgeTreatment().f = f2;
            throw null;
        }
    }

    public void setHideOnScroll(boolean z) {
        this.j = z;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public Behavior getBehavior() {
        if (this.n == null) {
            this.n = new Behavior();
        }
        return this.n;
    }

    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {
        public final Rect e = new Rect();
        public WeakReference<BottomAppBar> f;
        public int g;
        public final View.OnLayoutChangeListener h = new a();

        public class a implements View.OnLayoutChangeListener {
            public a() {
            }

            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                if (Behavior.this.f.get() == null || !(view instanceof FloatingActionButton)) {
                    view.removeOnLayoutChangeListener(this);
                    return;
                }
                FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                Behavior.this.e.set(0, 0, floatingActionButton.getMeasuredWidth(), floatingActionButton.getMeasuredHeight());
                throw null;
            }
        }

        public Behavior() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, int] */
        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean k(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, int i) {
            BottomAppBar bottomAppBar2 = bottomAppBar;
            this.f = new WeakReference<>(bottomAppBar2);
            int i2 = BottomAppBar.o;
            View d = bottomAppBar2.d();
            if (d != null) {
                AtomicInteger atomicInteger = r8.f3055a;
                if (!d.isLaidOut()) {
                    CoordinatorLayout.f fVar = (CoordinatorLayout.f) d.getLayoutParams();
                    fVar.d = 49;
                    this.g = ((ViewGroup.MarginLayoutParams) fVar).bottomMargin;
                    if (d instanceof FloatingActionButton) {
                        FloatingActionButton floatingActionButton = (FloatingActionButton) d;
                        floatingActionButton.addOnLayoutChangeListener(this.h);
                        floatingActionButton.d(null);
                        floatingActionButton.e(new bl4(bottomAppBar2));
                        floatingActionButton.f(null);
                    }
                    bottomAppBar2.h();
                    throw null;
                }
            }
            coordinatorLayout.l(bottomAppBar2, i);
            this.f612a = bottomAppBar2.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) bottomAppBar2.getLayoutParams()).bottomMargin;
            return false;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View, android.view.View, int, int] */
        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean x(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, View view, View view2, int i, int i2) {
            if (bottomAppBar.getHideOnScroll()) {
                if (i == 2) {
                    return true;
                }
            }
            return false;
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }
}
