package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.perf.util.Constants;
import defpackage.pl4;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@Deprecated
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {
    public final Rect c;
    public final RectF d;
    public final RectF e;
    public final int[] f;
    public float g;
    public float h;

    public class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f646a;
        public final /* synthetic */ View b;
        public final /* synthetic */ View c;

        public a(FabTransformationBehavior fabTransformationBehavior, boolean z, View view, View view2) {
            this.f646a = z;
            this.b = view;
            this.c = view2;
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.f646a) {
                this.b.setVisibility(4);
                this.c.setAlpha(1.0f);
                this.c.setVisibility(0);
            }
        }

        public void onAnimationStart(Animator animator) {
            if (this.f646a) {
                this.b.setVisibility(0);
                this.c.setAlpha(0.0f);
                this.c.setVisibility(4);
            }
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public fk4 f647a;
        public hk4 b;
    }

    public FabTransformationBehavior() {
        this.c = new Rect();
        this.d = new RectF();
        this.e = new RectF();
        this.f = new int[2];
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    public AnimatorSet D(View view, View view2, boolean z, boolean z2) {
        b bVar;
        ArrayList arrayList;
        pl4 pl4;
        ArrayList arrayList2;
        Animator animator;
        ObjectAnimator objectAnimator;
        b N = N(view2.getContext(), z);
        if (z) {
            this.g = view.getTranslationX();
            this.h = view.getTranslationY();
        }
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        L(view, view2, z, z2, N, arrayList3);
        RectF rectF = this.d;
        M(view, view2, z, z2, N, arrayList3, rectF);
        float width = rectF.width();
        float height = rectF.height();
        float F = F(view, view2, N.b);
        float G = G(view, view2, N.b);
        Pair<gk4, gk4> E = E(F, G, z, N);
        gk4 gk4 = (gk4) E.first;
        gk4 gk42 = (gk4) E.second;
        Property property = View.TRANSLATION_X;
        float[] fArr = new float[1];
        if (!z) {
            F = this.g;
        }
        fArr[0] = F;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, property, fArr);
        Property property2 = View.TRANSLATION_Y;
        float[] fArr2 = new float[1];
        if (!z) {
            G = this.h;
        }
        fArr2[0] = G;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, property2, fArr2);
        gk4.a(ofFloat);
        gk42.a(ofFloat2);
        arrayList3.add(ofFloat);
        arrayList3.add(ofFloat2);
        boolean z3 = view2 instanceof pl4;
        if (z3 && (view instanceof ImageView)) {
            pl4 pl42 = (pl4) view2;
            Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable != null) {
                drawable.mutate();
                if (z) {
                    if (!z2) {
                        drawable.setAlpha(Constants.MAX_HOST_LENGTH);
                    }
                    objectAnimator = ObjectAnimator.ofInt(drawable, ck4.b, 0);
                } else {
                    objectAnimator = ObjectAnimator.ofInt(drawable, ck4.b, 255);
                }
                objectAnimator.addUpdateListener(new iq4(this, view2));
                N.f647a.d("iconFade").a(objectAnimator);
                arrayList3.add(objectAnimator);
                arrayList4.add(new jq4(this, pl42, drawable));
            }
        }
        if (!z3) {
            bVar = N;
            arrayList = arrayList4;
        } else {
            pl4 pl43 = (pl4) view2;
            hk4 hk4 = N.b;
            RectF rectF2 = this.d;
            RectF rectF3 = this.e;
            I(view, rectF2);
            rectF2.offset(this.g, this.h);
            I(view2, rectF3);
            rectF3.offset(-F(view, view2, hk4), 0.0f);
            float centerX = rectF2.centerX() - rectF3.left;
            hk4 hk42 = N.b;
            RectF rectF4 = this.d;
            RectF rectF5 = this.e;
            I(view, rectF4);
            rectF4.offset(this.g, this.h);
            I(view2, rectF5);
            rectF5.offset(0.0f, -G(view, view2, hk42));
            float centerY = rectF4.centerY() - rectF5.top;
            ((FloatingActionButton) view).g(this.c);
            float width2 = ((float) this.c.width()) / 2.0f;
            gk4 d2 = N.f647a.d("expansion");
            if (z) {
                if (!z2) {
                    pl43.setRevealInfo(new pl4.e(centerX, centerY, width2));
                }
                if (z2) {
                    width2 = pl43.getRevealInfo().c;
                }
                float F0 = hd3.F0(centerX, centerY, 0.0f, 0.0f);
                float F02 = hd3.F0(centerX, centerY, width, 0.0f);
                float F03 = hd3.F0(centerX, centerY, width, height);
                float F04 = hd3.F0(centerX, centerY, 0.0f, height);
                if (F0 <= F02 || F0 <= F03 || F0 <= F04) {
                    F0 = (F02 <= F03 || F02 <= F04) ? F03 > F04 ? F03 : F04 : F02;
                }
                animator = hd3.V(pl43, centerX, centerY, F0);
                animator.addListener(new kq4(this, pl43));
                long j = d2.f1273a;
                int i = (int) centerX;
                int i2 = (int) centerY;
                if (j > 0) {
                    Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view2, i, i2, width2, width2);
                    createCircularReveal.setStartDelay(0);
                    createCircularReveal.setDuration(j);
                    arrayList3.add(createCircularReveal);
                }
                pl4 = pl43;
                arrayList2 = arrayList4;
                bVar = N;
            } else {
                float f2 = pl43.getRevealInfo().c;
                Animator V = hd3.V(pl43, centerX, centerY, width2);
                long j2 = d2.f1273a;
                int i3 = (int) centerX;
                int i4 = (int) centerY;
                if (j2 > 0) {
                    Animator createCircularReveal2 = ViewAnimationUtils.createCircularReveal(view2, i3, i4, f2, f2);
                    createCircularReveal2.setStartDelay(0);
                    createCircularReveal2.setDuration(j2);
                    arrayList3.add(createCircularReveal2);
                }
                long j3 = d2.f1273a;
                long j4 = d2.b;
                fk4 fk4 = N.f647a;
                int i5 = fk4.f1135a.h;
                arrayList2 = arrayList4;
                bVar = N;
                int i6 = 0;
                long j5 = 0;
                while (i6 < i5) {
                    gk4 l = fk4.f1135a.l(i6);
                    j5 = Math.max(j5, l.f1273a + l.b);
                    i6++;
                    i5 = i5;
                    pl43 = pl43;
                    i3 = i3;
                    fk4 = fk4;
                }
                pl4 = pl43;
                long j6 = j3 + j4;
                if (j6 < j5) {
                    Animator createCircularReveal3 = ViewAnimationUtils.createCircularReveal(view2, i3, i4, width2, width2);
                    createCircularReveal3.setStartDelay(j6);
                    createCircularReveal3.setDuration(j5 - j6);
                    arrayList3.add(createCircularReveal3);
                }
                animator = V;
            }
            d2.a(animator);
            arrayList3.add(animator);
            arrayList = arrayList2;
            arrayList.add(new nl4(pl4));
        }
        K(view, view2, z, z2, bVar, arrayList3);
        J(view2, z, z2, bVar, arrayList3);
        AnimatorSet animatorSet = new AnimatorSet();
        hd3.v2(animatorSet, arrayList3);
        animatorSet.addListener(new a(this, z, view2, view));
        int size = arrayList.size();
        for (int i7 = 0; i7 < size; i7++) {
            animatorSet.addListener((Animator.AnimatorListener) arrayList.get(i7));
        }
        return animatorSet;
    }

    public final Pair<gk4, gk4> E(float f2, float f3, boolean z, b bVar) {
        gk4 gk4;
        gk4 gk42;
        int i;
        if (f2 == 0.0f || f3 == 0.0f) {
            gk42 = bVar.f647a.d("translationXLinear");
            gk4 = bVar.f647a.d("translationYLinear");
        } else if ((!z || f3 >= 0.0f) && (z || i <= 0)) {
            gk42 = bVar.f647a.d("translationXCurveDownwards");
            gk4 = bVar.f647a.d("translationYCurveDownwards");
        } else {
            gk42 = bVar.f647a.d("translationXCurveUpwards");
            gk4 = bVar.f647a.d("translationYCurveUpwards");
        }
        return new Pair<>(gk42, gk4);
    }

    public final float F(View view, View view2, hk4 hk4) {
        RectF rectF = this.d;
        RectF rectF2 = this.e;
        I(view, rectF);
        rectF.offset(this.g, this.h);
        I(view2, rectF2);
        Objects.requireNonNull(hk4);
        return (rectF2.centerX() - rectF.centerX()) + 0.0f;
    }

    public final float G(View view, View view2, hk4 hk4) {
        RectF rectF = this.d;
        RectF rectF2 = this.e;
        I(view, rectF);
        rectF.offset(this.g, this.h);
        I(view2, rectF2);
        Objects.requireNonNull(hk4);
        return (rectF2.centerY() - rectF.centerY()) + 0.0f;
    }

    public final float H(b bVar, gk4 gk4, float f2, float f3) {
        long j = gk4.f1273a;
        long j2 = gk4.b;
        gk4 d2 = bVar.f647a.d("expansion");
        float interpolation = gk4.b().getInterpolation(((float) (((d2.f1273a + d2.b) + 17) - j)) / ((float) j2));
        TimeInterpolator timeInterpolator = zj4.f4184a;
        return hj1.a(f3, f2, interpolation, f2);
    }

    public final void I(View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
        int[] iArr = this.f;
        view.getLocationInWindow(iArr);
        rectF.offsetTo((float) iArr[0], (float) iArr[1]);
        rectF.offset((float) ((int) (-view.getTranslationX())), (float) ((int) (-view.getTranslationY())));
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroid/view/View;Landroid/view/View;ZZLcom/google/android/material/transformation/FabTransformationBehavior$b;Ljava/util/List<Landroid/animation/Animator;>;Ljava/util/List<Landroid/animation/Animator$AnimatorListener;>;)V */
    public final void J(View view, boolean z, boolean z2, b bVar, List list) {
        ViewGroup viewGroup;
        ObjectAnimator objectAnimator;
        if (view instanceof ViewGroup) {
            boolean z3 = view instanceof pl4;
            View findViewById = view.findViewById(R.id.mtrl_child_content_container);
            if (findViewById != null) {
                viewGroup = O(findViewById);
            } else if ((view instanceof mq4) || (view instanceof lq4)) {
                viewGroup = O(((ViewGroup) view).getChildAt(0));
            } else {
                viewGroup = O(view);
            }
            if (viewGroup != null) {
                if (z) {
                    if (!z2) {
                        bk4.f445a.set(viewGroup, Float.valueOf(0.0f));
                    }
                    objectAnimator = ObjectAnimator.ofFloat(viewGroup, bk4.f445a, 1.0f);
                } else {
                    objectAnimator = ObjectAnimator.ofFloat(viewGroup, bk4.f445a, 0.0f);
                }
                bVar.f647a.d("contentFade").a(objectAnimator);
                list.add(objectAnimator);
            }
        }
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroid/view/View;Landroid/view/View;ZZLcom/google/android/material/transformation/FabTransformationBehavior$b;Ljava/util/List<Landroid/animation/Animator;>;Ljava/util/List<Landroid/animation/Animator$AnimatorListener;>;)V */
    public final void K(View view, View view2, boolean z, boolean z2, b bVar, List list) {
        ObjectAnimator objectAnimator;
        if (view2 instanceof pl4) {
            pl4 pl4 = (pl4) view2;
            AtomicInteger atomicInteger = r8.f3055a;
            ColorStateList backgroundTintList = view.getBackgroundTintList();
            int colorForState = backgroundTintList != null ? backgroundTintList.getColorForState(view.getDrawableState(), backgroundTintList.getDefaultColor()) : 0;
            int i = 16777215 & colorForState;
            if (z) {
                if (!z2) {
                    pl4.setCircularRevealScrimColor(colorForState);
                }
                objectAnimator = ObjectAnimator.ofInt(pl4, pl4.d.f2825a, i);
            } else {
                objectAnimator = ObjectAnimator.ofInt(pl4, pl4.d.f2825a, colorForState);
            }
            objectAnimator.setEvaluator(ak4.f174a);
            bVar.f647a.d("color").a(objectAnimator);
            list.add(objectAnimator);
        }
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroid/view/View;Landroid/view/View;ZZLcom/google/android/material/transformation/FabTransformationBehavior$b;Ljava/util/List<Landroid/animation/Animator;>;Ljava/util/List<Landroid/animation/Animator$AnimatorListener;>;)V */
    @TargetApi(21)
    public final void L(View view, View view2, boolean z, boolean z2, b bVar, List list) {
        ObjectAnimator objectAnimator;
        AtomicInteger atomicInteger = r8.f3055a;
        float elevation = view2.getElevation() - view.getElevation();
        if (z) {
            if (!z2) {
                view2.setTranslationZ(-elevation);
            }
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, 0.0f);
        } else {
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, -elevation);
        }
        bVar.f647a.d("elevation").a(objectAnimator);
        list.add(objectAnimator);
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroid/view/View;Landroid/view/View;ZZLcom/google/android/material/transformation/FabTransformationBehavior$b;Ljava/util/List<Landroid/animation/Animator;>;Ljava/util/List<Landroid/animation/Animator$AnimatorListener;>;Landroid/graphics/RectF;)V */
    public final void M(View view, View view2, boolean z, boolean z2, b bVar, List list, RectF rectF) {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2;
        float F = F(view, view2, bVar.b);
        float G = G(view, view2, bVar.b);
        Pair<gk4, gk4> E = E(F, G, z, bVar);
        gk4 gk4 = (gk4) E.first;
        gk4 gk42 = (gk4) E.second;
        if (z) {
            if (!z2) {
                view2.setTranslationX(-F);
                view2.setTranslationY(-G);
            }
            objectAnimator2 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, 0.0f);
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, 0.0f);
            float H = H(bVar, gk4, -F, 0.0f);
            float H2 = H(bVar, gk42, -G, 0.0f);
            Rect rect = this.c;
            view2.getWindowVisibleDisplayFrame(rect);
            RectF rectF2 = this.d;
            rectF2.set(rect);
            RectF rectF3 = this.e;
            I(view2, rectF3);
            rectF3.offset(H, H2);
            rectF3.intersect(rectF2);
            rectF.set(rectF3);
        } else {
            objectAnimator2 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, -F);
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, -G);
        }
        gk4.a(objectAnimator2);
        gk42.a(objectAnimator);
        list.add(objectAnimator2);
        list.add(objectAnimator);
    }

    public abstract b N(Context context, boolean z);

    public final ViewGroup O(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean d(CoordinatorLayout coordinatorLayout, View view, View view2) {
        if (view.getVisibility() == 8) {
            throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        } else if (!(view2 instanceof FloatingActionButton)) {
            return false;
        } else {
            int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
            if (expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId()) {
                return true;
            }
            return false;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void f(CoordinatorLayout.f fVar) {
        if (fVar.h == 0) {
            fVar.h = 80;
        }
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new Rect();
        this.d = new RectF();
        this.e = new RectF();
        this.f = new int[2];
    }
}
