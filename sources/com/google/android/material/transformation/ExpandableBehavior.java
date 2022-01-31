package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Deprecated
public abstract class ExpandableBehavior extends CoordinatorLayout.c<View> {

    /* renamed from: a  reason: collision with root package name */
    public int f644a = 0;

    public class a implements ViewTreeObserver.OnPreDrawListener {
        public final /* synthetic */ View f;
        public final /* synthetic */ int g;
        public final /* synthetic */ um4 h;

        public a(View view, int i2, um4 um4) {
            this.f = view;
            this.g = i2;
            this.h = um4;
        }

        public boolean onPreDraw() {
            this.f.getViewTreeObserver().removeOnPreDrawListener(this);
            ExpandableBehavior expandableBehavior = ExpandableBehavior.this;
            if (expandableBehavior.f644a == this.g) {
                um4 um4 = this.h;
                expandableBehavior.C((View) um4, this.f, um4.a(), false);
            }
            return false;
        }
    }

    public ExpandableBehavior() {
    }

    public final boolean B(boolean z) {
        if (z) {
            int i = this.f644a;
            return i == 0 || i == 2;
        } else if (this.f644a == 1) {
            return true;
        } else {
            return false;
        }
    }

    public abstract boolean C(View view, View view2, boolean z, boolean z2);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean g(CoordinatorLayout coordinatorLayout, View view, View view2) {
        um4 um4 = (um4) view2;
        if (!B(um4.a())) {
            return false;
        }
        this.f644a = um4.a() ? 1 : 2;
        return C((View) um4, view, um4.a(), true);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout coordinatorLayout, View view, int i) {
        um4 um4;
        AtomicInteger atomicInteger = r8.f3055a;
        if (!view.isLaidOut()) {
            List<View> d = coordinatorLayout.d(view);
            int size = d.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    um4 = null;
                    break;
                }
                View view2 = d.get(i2);
                if (d(coordinatorLayout, view, view2)) {
                    um4 = (um4) view2;
                    break;
                }
                i2++;
            }
            if (um4 != null && B(um4.a())) {
                int i3 = um4.a() ? 1 : 2;
                this.f644a = i3;
                view.getViewTreeObserver().addOnPreDrawListener(new a(view, i3, um4));
            }
        }
        return false;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
