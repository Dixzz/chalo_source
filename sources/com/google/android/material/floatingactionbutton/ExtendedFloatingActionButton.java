package com.google.android.material.floatingactionbutton;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class ExtendedFloatingActionButton extends MaterialButton implements CoordinatorLayout.b {
    public static final /* synthetic */ int w = 0;
    public boolean v;

    public static class a extends Property<View, Float> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public Float get(View view) {
            return Float.valueOf((float) view.getLayoutParams().width);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(View view, Float f) {
            View view2 = view;
            view2.getLayoutParams().width = f.intValue();
            view2.requestLayout();
        }
    }

    public static class b extends Property<View, Float> {
        public b(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public Float get(View view) {
            return Float.valueOf((float) view.getLayoutParams().height);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(View view, Float f) {
            View view2 = view;
            view2.getLayoutParams().height = f.intValue();
            view2.requestLayout();
        }
    }

    public static class c extends Property<View, Float> {
        public c(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public Float get(View view) {
            AtomicInteger atomicInteger = r8.f3055a;
            return Float.valueOf((float) view.getPaddingStart());
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(View view, Float f) {
            View view2 = view;
            int intValue = f.intValue();
            int paddingTop = view2.getPaddingTop();
            AtomicInteger atomicInteger = r8.f3055a;
            view2.setPaddingRelative(intValue, paddingTop, view2.getPaddingEnd(), view2.getPaddingBottom());
        }
    }

    public static class d extends Property<View, Float> {
        public d(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public Float get(View view) {
            AtomicInteger atomicInteger = r8.f3055a;
            return Float.valueOf((float) view.getPaddingEnd());
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(View view, Float f) {
            View view2 = view;
            AtomicInteger atomicInteger = r8.f3055a;
            view2.setPaddingRelative(view2.getPaddingStart(), view2.getPaddingTop(), f.intValue(), view2.getPaddingBottom());
        }
    }

    static {
        new a(Float.class, "width");
        new b(Float.class, "height");
        new c(Float.class, "paddingStart");
        new d(Float.class, "paddingEnd");
    }

    public static void i(ExtendedFloatingActionButton extendedFloatingActionButton, cn4 cn4) {
        Objects.requireNonNull(extendedFloatingActionButton);
        throw null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<ExtendedFloatingActionButton> getBehavior() {
        return null;
    }

    public int getCollapsedPadding() {
        return (getCollapsedSize() - getIconSize()) / 2;
    }

    public int getCollapsedSize() {
        return 0;
    }

    public fk4 getExtendMotionSpec() {
        throw null;
    }

    public fk4 getHideMotionSpec() {
        throw null;
    }

    public fk4 getShowMotionSpec() {
        throw null;
    }

    public fk4 getShrinkMotionSpec() {
        throw null;
    }

    @Override // com.google.android.material.button.MaterialButton
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void setAnimateShowBeforeLayout(boolean z) {
        this.v = z;
    }

    public void setExtendMotionSpec(fk4 fk4) {
        throw null;
    }

    public void setExtendMotionSpecResource(int i) {
        setExtendMotionSpec(fk4.b(getContext(), i));
    }

    public void setExtended(boolean z) {
        if (z) {
            throw null;
        }
    }

    public void setHideMotionSpec(fk4 fk4) {
        throw null;
    }

    public void setHideMotionSpecResource(int i) {
        setHideMotionSpec(fk4.b(getContext(), i));
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(i, i2, i3, i4);
    }

    public void setPaddingRelative(int i, int i2, int i3, int i4) {
        super.setPaddingRelative(i, i2, i3, i4);
    }

    public void setShowMotionSpec(fk4 fk4) {
        throw null;
    }

    public void setShowMotionSpecResource(int i) {
        setShowMotionSpec(fk4.b(getContext(), i));
    }

    public void setShrinkMotionSpec(fk4 fk4) {
        throw null;
    }

    public void setShrinkMotionSpecResource(int i) {
        setShrinkMotionSpec(fk4.b(getContext(), i));
    }

    @Override // android.widget.TextView
    public void setTextColor(int i) {
        super.setTextColor(i);
        getTextColors();
    }

    public static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.c<T> {

        /* renamed from: a  reason: collision with root package name */
        public Rect f625a;
        public boolean b;
        public boolean c;

        public ExtendedFloatingActionButtonBehavior() {
            this.b = false;
            this.c = true;
        }

        public final boolean B(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            CoordinatorLayout.f fVar = (CoordinatorLayout.f) extendedFloatingActionButton.getLayoutParams();
            if ((this.b || this.c) && fVar.f == view.getId()) {
                return true;
            }
            return false;
        }

        public final boolean C(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!B(appBarLayout, extendedFloatingActionButton)) {
                return false;
            }
            if (this.f625a == null) {
                this.f625a = new Rect();
            }
            Rect rect = this.f625a;
            fn4.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                if (this.c) {
                    int i = ExtendedFloatingActionButton.w;
                    Objects.requireNonNull(extendedFloatingActionButton);
                } else {
                    int i2 = ExtendedFloatingActionButton.w;
                    Objects.requireNonNull(extendedFloatingActionButton);
                }
                ExtendedFloatingActionButton.i(extendedFloatingActionButton, null);
                return true;
            }
            if (this.c) {
                int i3 = ExtendedFloatingActionButton.w;
                Objects.requireNonNull(extendedFloatingActionButton);
            } else {
                int i4 = ExtendedFloatingActionButton.w;
                Objects.requireNonNull(extendedFloatingActionButton);
            }
            ExtendedFloatingActionButton.i(extendedFloatingActionButton, null);
            return true;
        }

        public final boolean D(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!B(view, extendedFloatingActionButton)) {
                return false;
            }
            if (view.getTop() < (extendedFloatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) extendedFloatingActionButton.getLayoutParams())).topMargin) {
                if (this.c) {
                    int i = ExtendedFloatingActionButton.w;
                } else {
                    int i2 = ExtendedFloatingActionButton.w;
                }
                ExtendedFloatingActionButton.i(extendedFloatingActionButton, null);
                return true;
            }
            if (this.c) {
                int i3 = ExtendedFloatingActionButton.w;
            } else {
                int i4 = ExtendedFloatingActionButton.w;
            }
            ExtendedFloatingActionButton.i(extendedFloatingActionButton, null);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, Rect rect) {
            ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) view;
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void f(CoordinatorLayout.f fVar) {
            if (fVar.h == 0) {
                fVar.h = 80;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean g(CoordinatorLayout coordinatorLayout, View view, View view2) {
            ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) view;
            if (view2 instanceof AppBarLayout) {
                C(coordinatorLayout, (AppBarLayout) view2, extendedFloatingActionButton);
            } else {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams instanceof CoordinatorLayout.f ? ((CoordinatorLayout.f) layoutParams).f201a instanceof BottomSheetBehavior : false) {
                    D(view2, extendedFloatingActionButton);
                }
            }
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean k(CoordinatorLayout coordinatorLayout, View view, int i) {
            ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) view;
            List<View> d = coordinatorLayout.d(extendedFloatingActionButton);
            int size = d.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view2 = d.get(i2);
                if (!(view2 instanceof AppBarLayout)) {
                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                    if ((layoutParams instanceof CoordinatorLayout.f ? ((CoordinatorLayout.f) layoutParams).f201a instanceof BottomSheetBehavior : false) && D(view2, extendedFloatingActionButton)) {
                        break;
                    }
                } else if (C(coordinatorLayout, (AppBarLayout) view2, extendedFloatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.l(extendedFloatingActionButton, i);
            return true;
        }

        public ExtendedFloatingActionButtonBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExtendedFloatingActionButton_Behavior_Layout);
            this.b = obtainStyledAttributes.getBoolean(R.styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoHide, false);
            this.c = obtainStyledAttributes.getBoolean(R.styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoShrink, true);
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.widget.TextView
    public void setTextColor(ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        getTextColors();
    }
}
