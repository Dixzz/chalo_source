package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public class FabTransformationScrimBehavior extends ExpandableTransformationBehavior {
    public final gk4 c = new gk4(75, 150);
    public final gk4 d = new gk4(0, 150);

    public class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f648a;
        public final /* synthetic */ View b;

        public a(FabTransformationScrimBehavior fabTransformationScrimBehavior, boolean z, View view) {
            this.f648a = z;
            this.b = view;
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.f648a) {
                this.b.setVisibility(4);
            }
        }

        public void onAnimationStart(Animator animator) {
            if (this.f648a) {
                this.b.setVisibility(0);
            }
        }
    }

    public FabTransformationScrimBehavior() {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean A(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        return false;
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    public AnimatorSet D(View view, View view2, boolean z, boolean z2) {
        ArrayList arrayList = new ArrayList();
        new ArrayList();
        E(view2, z, z2, arrayList);
        AnimatorSet animatorSet = new AnimatorSet();
        hd3.v2(animatorSet, arrayList);
        animatorSet.addListener(new a(this, z, view2));
        return animatorSet;
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroid/view/View;ZZLjava/util/List<Landroid/animation/Animator;>;Ljava/util/List<Landroid/animation/Animator$AnimatorListener;>;)V */
    public final void E(View view, boolean z, boolean z2, List list) {
        ObjectAnimator objectAnimator;
        gk4 gk4 = z ? this.c : this.d;
        if (z) {
            if (!z2) {
                view.setAlpha(0.0f);
            }
            objectAnimator = ObjectAnimator.ofFloat(view, View.ALPHA, 1.0f);
        } else {
            objectAnimator = ObjectAnimator.ofFloat(view, View.ALPHA, 0.0f);
        }
        gk4.a(objectAnimator);
        list.add(objectAnimator);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean d(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return view2 instanceof FloatingActionButton;
    }

    public FabTransformationScrimBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
