package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.fragment.R;
import java.util.ArrayList;
import java.util.Iterator;

public final class FragmentContainerView extends FrameLayout {
    public ArrayList<View> f;
    public ArrayList<View> g;
    public View.OnApplyWindowInsetsListener h;
    public boolean i = true;

    public FragmentContainerView(Context context) {
        super(context);
    }

    public final void a(View view) {
        ArrayList<View> arrayList = this.g;
        if (arrayList != null && arrayList.contains(view)) {
            if (this.f == null) {
                this.f = new ArrayList<>();
            }
            this.f.add(view);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        Object tag = view.getTag(R.id.fragment_container_view_tag);
        if ((tag instanceof Fragment ? (Fragment) tag : null) != null) {
            super.addView(view, i2, layoutParams);
            return;
        }
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    public boolean addViewInLayout(View view, int i2, ViewGroup.LayoutParams layoutParams, boolean z) {
        Object tag = view.getTag(R.id.fragment_container_view_tag);
        if ((tag instanceof Fragment ? (Fragment) tag : null) != null) {
            return super.addViewInLayout(view, i2, layoutParams, z);
        }
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    public WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        c9 c9Var;
        c9 k = c9.k(windowInsets, null);
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.h;
        if (onApplyWindowInsetsListener != null) {
            c9Var = c9.j(onApplyWindowInsetsListener.onApplyWindowInsets(this, windowInsets));
        } else {
            c9Var = r8.p(this, k);
        }
        if (!c9Var.g()) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                r8.e(getChildAt(i2), c9Var);
            }
        }
        return windowInsets;
    }

    public void dispatchDraw(Canvas canvas) {
        if (this.i && this.f != null) {
            for (int i2 = 0; i2 < this.f.size(); i2++) {
                super.drawChild(canvas, this.f.get(i2), getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    public boolean drawChild(Canvas canvas, View view, long j) {
        ArrayList<View> arrayList;
        if (!this.i || (arrayList = this.f) == null || arrayList.size() <= 0 || !this.f.contains(view)) {
            return super.drawChild(canvas, view, j);
        }
        return false;
    }

    public void endViewTransition(View view) {
        ArrayList<View> arrayList = this.g;
        if (arrayList != null) {
            arrayList.remove(view);
            ArrayList<View> arrayList2 = this.f;
            if (arrayList2 != null && arrayList2.remove(view)) {
                this.i = true;
            }
        }
        super.endViewTransition(view);
    }

    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        return windowInsets;
    }

    public void removeAllViewsInLayout() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            a(getChildAt(childCount));
        }
        super.removeAllViewsInLayout();
    }

    public void removeDetachedView(View view, boolean z) {
        if (z) {
            a(view);
        }
        super.removeDetachedView(view, z);
    }

    public void removeView(View view) {
        a(view);
        super.removeView(view);
    }

    public void removeViewAt(int i2) {
        a(getChildAt(i2));
        super.removeViewAt(i2);
    }

    public void removeViewInLayout(View view) {
        a(view);
        super.removeViewInLayout(view);
    }

    public void removeViews(int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            a(getChildAt(i4));
        }
        super.removeViews(i2, i3);
    }

    public void removeViewsInLayout(int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            a(getChildAt(i4));
        }
        super.removeViewsInLayout(i2, i3);
    }

    public void setDrawDisappearingViewsLast(boolean z) {
        this.i = z;
    }

    public void setLayoutTransition(LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        this.h = onApplyWindowInsetsListener;
    }

    public void startViewTransition(View view) {
        if (view.getParent() == this) {
            if (this.g == null) {
                this.g = new ArrayList<>();
            }
            this.g.add(view);
        }
        super.startViewTransition(view);
    }

    public FragmentContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        String str;
        if (attributeSet != null) {
            String classAttribute = attributeSet.getClassAttribute();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FragmentContainerView);
            if (classAttribute == null) {
                classAttribute = obtainStyledAttributes.getString(R.styleable.FragmentContainerView_android_name);
                str = "android:name";
            } else {
                str = "class";
            }
            obtainStyledAttributes.recycle();
            if (classAttribute != null && !isInEditMode()) {
                throw new UnsupportedOperationException("FragmentContainerView must be within a FragmentActivity to use " + str + "=\"" + classAttribute + "\"");
            }
        }
    }

    public FragmentContainerView(Context context, AttributeSet attributeSet, FragmentManager fragmentManager) {
        super(context, attributeSet);
        View view;
        String classAttribute = attributeSet.getClassAttribute();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FragmentContainerView);
        classAttribute = classAttribute == null ? obtainStyledAttributes.getString(R.styleable.FragmentContainerView_android_name) : classAttribute;
        String string = obtainStyledAttributes.getString(R.styleable.FragmentContainerView_android_tag);
        obtainStyledAttributes.recycle();
        int id = getId();
        Fragment H = fragmentManager.H(id);
        if (classAttribute != null && H == null) {
            if (id <= 0) {
                throw new IllegalStateException(hj1.T("FragmentContainerView must have an android:id to add Fragment ", classAttribute, string != null ? hj1.S(" with tag ", string) : ""));
            }
            Fragment a2 = fragmentManager.K().a(context.getClassLoader(), classAttribute);
            a2.onInflate(context, attributeSet, (Bundle) null);
            ke keVar = new ke(fragmentManager);
            keVar.p = true;
            a2.mContainer = this;
            keVar.f(getId(), a2, string, 1);
            if (!keVar.g) {
                keVar.h = false;
                keVar.q.D(keVar, true);
            } else {
                throw new IllegalStateException("This transaction is already being added to the back stack");
            }
        }
        Iterator it = ((ArrayList) fragmentManager.c.f()).iterator();
        while (it.hasNext()) {
            kf kfVar = (kf) it.next();
            Fragment fragment = kfVar.c;
            if (fragment.mContainerId == getId() && (view = fragment.mView) != null && view.getParent() == null) {
                fragment.mContainer = this;
                kfVar.b();
            }
        }
    }
}
