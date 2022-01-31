package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.stateful.ExtendableSavedState;
import defpackage.ym4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class FloatingActionButton extends sn4 implements um4, oo4, CoordinatorLayout.b {
    public ColorStateList g;
    public PorterDuff.Mode h;
    public ColorStateList i;
    public PorterDuff.Mode j;
    public ColorStateList k;
    public int l;
    public int m;
    public int n;
    public boolean o;
    public ym4 p;

    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static abstract class a {
        public void a(FloatingActionButton floatingActionButton) {
        }

        public void b(FloatingActionButton floatingActionButton) {
        }
    }

    public class b implements ao4 {
        public b() {
        }
    }

    public class c<T extends FloatingActionButton> implements ym4.e {

        /* renamed from: a  reason: collision with root package name */
        public final ik4<T> f628a;

        public c(ik4<T> ik4) {
            this.f628a = ik4;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ik4<T extends com.google.android.material.floatingactionbutton.FloatingActionButton> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // defpackage.ym4.e
        public void a() {
            this.f628a.b(FloatingActionButton.this);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ik4<T extends com.google.android.material.floatingactionbutton.FloatingActionButton> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // defpackage.ym4.e
        public void b() {
            this.f628a.a(FloatingActionButton.this);
        }

        public boolean equals(Object obj) {
            return (obj instanceof c) && ((c) obj).f628a.equals(this.f628a);
        }

        public int hashCode() {
            return this.f628a.hashCode();
        }
    }

    private ym4 getImpl() {
        if (this.p == null) {
            this.p = new bn4(this, new b());
        }
        return this.p;
    }

    @Override // defpackage.um4
    public boolean a() {
        throw null;
    }

    public void d(Animator.AnimatorListener animatorListener) {
        ym4 impl = getImpl();
        if (impl.q == null) {
            impl.q = new ArrayList<>();
        }
        impl.q.add(null);
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().i(getDrawableState());
    }

    public void e(Animator.AnimatorListener animatorListener) {
        ym4 impl = getImpl();
        if (impl.p == null) {
            impl.p = new ArrayList<>();
        }
        impl.p.add(animatorListener);
    }

    public void f(ik4<? extends FloatingActionButton> ik4) {
        ym4 impl = getImpl();
        c cVar = new c(null);
        if (impl.r == null) {
            impl.r = new ArrayList<>();
        }
        impl.r.add(cVar);
    }

    @Deprecated
    public boolean g(Rect rect) {
        AtomicInteger atomicInteger = r8.f3055a;
        if (!isLaidOut()) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        throw null;
    }

    public ColorStateList getBackgroundTintList() {
        return this.g;
    }

    public PorterDuff.Mode getBackgroundTintMode() {
        return this.h;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<FloatingActionButton> getBehavior() {
        return new Behavior();
    }

    public float getCompatElevation() {
        return getImpl().c();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().e;
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().f;
    }

    public Drawable getContentBackground() {
        Objects.requireNonNull(getImpl());
        return null;
    }

    public int getCustomSize() {
        return this.m;
    }

    public int getExpandedComponentIdHint() {
        throw null;
    }

    public fk4 getHideMotionSpec() {
        return getImpl().l;
    }

    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.k;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    public ColorStateList getRippleColorStateList() {
        return this.k;
    }

    public ko4 getShapeAppearanceModel() {
        ko4 ko4 = getImpl().f4068a;
        Objects.requireNonNull(ko4);
        return ko4;
    }

    public fk4 getShowMotionSpec() {
        return getImpl().k;
    }

    public int getSize() {
        return this.l;
    }

    public int getSizeDimension() {
        return h(this.l);
    }

    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    public ColorStateList getSupportImageTintList() {
        return this.i;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        return this.j;
    }

    public boolean getUseCompatPadding() {
        return this.o;
    }

    public final int h(int i2) {
        int i3 = this.m;
        if (i3 != 0) {
            return i3;
        }
        Resources resources = getResources();
        if (i2 != -1) {
            if (i2 != 1) {
                return resources.getDimensionPixelSize(R.dimen.design_fab_size_normal);
            }
            return resources.getDimensionPixelSize(R.dimen.design_fab_size_mini);
        } else if (Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470) {
            return h(1);
        } else {
            return h(0);
        }
    }

    public void i(a aVar, boolean z) {
        vm4 vm4;
        ym4 impl = getImpl();
        if (aVar == null) {
            vm4 = null;
        } else {
            vm4 = new vm4(this, aVar);
        }
        if (!impl.e()) {
            Animator animator = impl.j;
            if (animator != null) {
                animator.cancel();
            }
            if (impl.q()) {
                fk4 fk4 = impl.l;
                if (fk4 == null) {
                    if (impl.i == null) {
                        impl.i = fk4.b(impl.s.getContext(), R.animator.design_fab_hide_motion_spec);
                    }
                    fk4 = impl.i;
                    Objects.requireNonNull(fk4);
                }
                AnimatorSet a2 = impl.a(fk4, 0.0f, 0.0f, 0.0f);
                a2.addListener(new wm4(impl, z, vm4));
                ArrayList<Animator.AnimatorListener> arrayList = impl.q;
                if (arrayList != null) {
                    Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                    while (it.hasNext()) {
                        a2.addListener(it.next());
                    }
                }
                a2.start();
                return;
            }
            impl.s.b(z ? 8 : 4, z);
            if (vm4 != null) {
                vm4.f3664a.a(vm4.b);
            }
        }
    }

    public boolean j() {
        return getImpl().e();
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().g();
    }

    public boolean k() {
        return getImpl().f();
    }

    public final void l() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            ColorStateList colorStateList = this.i;
            if (colorStateList == null) {
                h.s(drawable);
                return;
            }
            int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
            PorterDuff.Mode mode = this.j;
            if (mode == null) {
                mode = PorterDuff.Mode.SRC_IN;
            }
            drawable.mutate().setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(colorForState, mode));
        }
    }

    public void m(a aVar, boolean z) {
        vm4 vm4;
        ym4 impl = getImpl();
        if (aVar == null) {
            vm4 = null;
        } else {
            vm4 = new vm4(this, aVar);
        }
        if (!impl.f()) {
            Animator animator = impl.j;
            if (animator != null) {
                animator.cancel();
            }
            if (impl.q()) {
                if (impl.s.getVisibility() != 0) {
                    impl.s.setAlpha(0.0f);
                    impl.s.setScaleY(0.0f);
                    impl.s.setScaleX(0.0f);
                    impl.n(0.0f);
                }
                fk4 fk4 = impl.k;
                if (fk4 == null) {
                    if (impl.h == null) {
                        impl.h = fk4.b(impl.s.getContext(), R.animator.design_fab_show_motion_spec);
                    }
                    fk4 = impl.h;
                    Objects.requireNonNull(fk4);
                }
                AnimatorSet a2 = impl.a(fk4, 1.0f, 1.0f, 1.0f);
                a2.addListener(new xm4(impl, z, vm4));
                ArrayList<Animator.AnimatorListener> arrayList = impl.p;
                if (arrayList != null) {
                    Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                    while (it.hasNext()) {
                        a2.addListener(it.next());
                    }
                }
                a2.start();
                return;
            }
            impl.s.b(0, z);
            impl.s.setAlpha(1.0f);
            impl.s.setScaleY(1.0f);
            impl.s.setScaleX(1.0f);
            impl.n(1.0f);
            if (vm4 != null) {
                vm4.f3664a.b(vm4.b);
            }
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ym4 impl = getImpl();
        if (impl.m()) {
            ViewTreeObserver viewTreeObserver = impl.s.getViewTreeObserver();
            if (impl.y == null) {
                impl.y = new an4(impl);
            }
            viewTreeObserver.addOnPreDrawListener(impl.y);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ym4 impl = getImpl();
        ViewTreeObserver viewTreeObserver = impl.s.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = impl.y;
        if (onPreDrawListener != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            impl.y = null;
        }
    }

    public void onMeasure(int i2, int i3) {
        this.n = (getSizeDimension() + 0) / 2;
        getImpl().t();
        throw null;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ExtendableSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ExtendableSavedState extendableSavedState = (ExtendableSavedState) parcelable;
        super.onRestoreInstanceState(extendableSavedState.getSuperState());
        Objects.requireNonNull(extendableSavedState.f.getOrDefault("expandableWidgetHelper", null));
        throw null;
    }

    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (onSaveInstanceState == null) {
            onSaveInstanceState = new Bundle();
        }
        new ExtendableSavedState(onSaveInstanceState);
        throw null;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            g(null);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setBackgroundColor(int i2) {
    }

    public void setBackgroundDrawable(Drawable drawable) {
    }

    public void setBackgroundResource(int i2) {
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.g != colorStateList) {
            this.g = colorStateList;
            Objects.requireNonNull(getImpl());
        }
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.h != mode) {
            this.h = mode;
            Objects.requireNonNull(getImpl());
        }
    }

    public void setCompatElevation(float f) {
        ym4 impl = getImpl();
        if (impl.d != f) {
            impl.d = f;
            impl.j(f, impl.e, impl.f);
        }
    }

    public void setCompatElevationResource(int i2) {
        setCompatElevation(getResources().getDimension(i2));
    }

    public void setCompatHoveredFocusedTranslationZ(float f) {
        ym4 impl = getImpl();
        if (impl.e != f) {
            impl.e = f;
            impl.j(impl.d, f, impl.f);
        }
    }

    public void setCompatHoveredFocusedTranslationZResource(int i2) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i2));
    }

    public void setCompatPressedTranslationZ(float f) {
        ym4 impl = getImpl();
        if (impl.f != f) {
            impl.f = f;
            impl.j(impl.d, impl.e, f);
        }
    }

    public void setCompatPressedTranslationZResource(int i2) {
        setCompatPressedTranslationZ(getResources().getDimension(i2));
    }

    public void setCustomSize(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("Custom size must be non-negative");
        } else if (i2 != this.m) {
            this.m = i2;
            requestLayout();
        }
    }

    public void setElevation(float f) {
        super.setElevation(f);
        Objects.requireNonNull(getImpl());
    }

    public void setEnsureMinTouchTargetSize(boolean z) {
        if (z != getImpl().b) {
            getImpl().b = z;
            requestLayout();
        }
    }

    public void setExpandedComponentIdHint(int i2) {
        throw null;
    }

    public void setHideMotionSpec(fk4 fk4) {
        getImpl().l = fk4;
    }

    public void setHideMotionSpecResource(int i2) {
        setHideMotionSpec(fk4.b(getContext(), i2));
    }

    public void setImageDrawable(Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            ym4 impl = getImpl();
            impl.n(impl.n);
            if (this.i != null) {
                l();
            }
        }
    }

    public void setImageResource(int i2) {
        throw null;
    }

    public void setRippleColor(int i2) {
        setRippleColor(ColorStateList.valueOf(i2));
    }

    public void setScaleX(float f) {
        super.setScaleX(f);
        getImpl().k();
    }

    public void setScaleY(float f) {
        super.setScaleY(f);
        getImpl().k();
    }

    public void setShadowPaddingEnabled(boolean z) {
        ym4 impl = getImpl();
        impl.c = z;
        impl.t();
        throw null;
    }

    @Override // defpackage.oo4
    public void setShapeAppearanceModel(ko4 ko4) {
        getImpl().f4068a = ko4;
    }

    public void setShowMotionSpec(fk4 fk4) {
        getImpl().k = fk4;
    }

    public void setShowMotionSpecResource(int i2) {
        setShowMotionSpec(fk4.b(getContext(), i2));
    }

    public void setSize(int i2) {
        this.m = 0;
        if (i2 != this.l) {
            this.l = i2;
            requestLayout();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.i != colorStateList) {
            this.i = colorStateList;
            l();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.j != mode) {
            this.j = mode;
            l();
        }
    }

    public void setTranslationX(float f) {
        super.setTranslationX(f);
        getImpl().l();
    }

    public void setTranslationY(float f) {
        super.setTranslationY(f);
        getImpl().l();
    }

    public void setTranslationZ(float f) {
        super.setTranslationZ(f);
        getImpl().l();
    }

    public void setUseCompatPadding(boolean z) {
        if (this.o != z) {
            this.o = z;
            getImpl().h();
        }
    }

    @Override // defpackage.sn4
    public void setVisibility(int i2) {
        super.setVisibility(i2);
    }

    public static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.c<T> {

        /* renamed from: a  reason: collision with root package name */
        public Rect f626a;
        public boolean b;

        public BaseBehavior() {
            this.b = true;
        }

        public boolean B(FloatingActionButton floatingActionButton, Rect rect) {
            Objects.requireNonNull(floatingActionButton);
            floatingActionButton.getLeft();
            throw null;
        }

        public final boolean C(View view, FloatingActionButton floatingActionButton) {
            CoordinatorLayout.f fVar = (CoordinatorLayout.f) floatingActionButton.getLayoutParams();
            if (this.b && fVar.f == view.getId() && floatingActionButton.getUserSetVisibility() == 0) {
                return true;
            }
            return false;
        }

        public final boolean D(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (!C(appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.f626a == null) {
                this.f626a = new Rect();
            }
            Rect rect = this.f626a;
            fn4.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.i(null, false);
                return true;
            }
            floatingActionButton.m(null, false);
            return true;
        }

        public final boolean E(View view, FloatingActionButton floatingActionButton) {
            if (!C(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) floatingActionButton.getLayoutParams())).topMargin) {
                floatingActionButton.i(null, false);
                return true;
            }
            floatingActionButton.m(null, false);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, Rect rect) {
            return B((FloatingActionButton) view, rect);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void f(CoordinatorLayout.f fVar) {
            if (fVar.h == 0) {
                fVar.h = 80;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean g(CoordinatorLayout coordinatorLayout, View view, View view2) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            if (view2 instanceof AppBarLayout) {
                D(coordinatorLayout, (AppBarLayout) view2, floatingActionButton);
            } else {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams instanceof CoordinatorLayout.f ? ((CoordinatorLayout.f) layoutParams).f201a instanceof BottomSheetBehavior : false) {
                    E(view2, floatingActionButton);
                }
            }
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean k(CoordinatorLayout coordinatorLayout, View view, int i) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            List<View> d = coordinatorLayout.d(floatingActionButton);
            int size = d.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view2 = d.get(i2);
                if (!(view2 instanceof AppBarLayout)) {
                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                    if ((layoutParams instanceof CoordinatorLayout.f ? ((CoordinatorLayout.f) layoutParams).f201a instanceof BottomSheetBehavior : false) && E(view2, floatingActionButton)) {
                        break;
                    }
                } else if (D(coordinatorLayout, (AppBarLayout) view2, floatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.l(floatingActionButton, i);
            return true;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FloatingActionButton_Behavior_Layout);
            this.b = obtainStyledAttributes.getBoolean(R.styleable.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            obtainStyledAttributes.recycle();
        }
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.k != colorStateList) {
            this.k = colorStateList;
            getImpl().o(this.k);
        }
    }
}
