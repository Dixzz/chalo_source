package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.perf.util.Constants;
import defpackage.q5;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CollapsingToolbarLayout extends FrameLayout {
    public static final int C = R.style.Widget_Design_CollapsingToolbar;
    public int A;
    public c9 B;
    public boolean f = true;
    public int g;
    public ViewGroup h;
    public View i;
    public View j;
    public int k;
    public int l;
    public int m;
    public int n;
    public final Rect o = new Rect();
    public final en4 p;
    public boolean q;
    public boolean r;
    public Drawable s;
    public Drawable t;
    public int u;
    public boolean v;
    public ValueAnimator w;
    public long x;
    public int y = -1;
    public AppBarLayout.c z;

    public class b implements AppBarLayout.c {
        public b() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.a
        public void a(AppBarLayout appBarLayout, int i) {
            CollapsingToolbarLayout collapsingToolbarLayout = CollapsingToolbarLayout.this;
            collapsingToolbarLayout.A = i;
            c9 c9Var = collapsingToolbarLayout.B;
            int e = c9Var != null ? c9Var.e() : 0;
            int childCount = CollapsingToolbarLayout.this.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = CollapsingToolbarLayout.this.getChildAt(i2);
                a aVar = (a) childAt.getLayoutParams();
                tk4 d = CollapsingToolbarLayout.d(childAt);
                int i3 = aVar.f610a;
                if (i3 == 1) {
                    d.b(h.r(-i, 0, CollapsingToolbarLayout.this.c(childAt)));
                } else if (i3 == 2) {
                    d.b(Math.round(((float) (-i)) * aVar.b));
                }
            }
            CollapsingToolbarLayout.this.f();
            CollapsingToolbarLayout collapsingToolbarLayout2 = CollapsingToolbarLayout.this;
            if (collapsingToolbarLayout2.t != null && e > 0) {
                AtomicInteger atomicInteger = r8.f3055a;
                collapsingToolbarLayout2.postInvalidateOnAnimation();
            }
            int height = CollapsingToolbarLayout.this.getHeight();
            CollapsingToolbarLayout collapsingToolbarLayout3 = CollapsingToolbarLayout.this;
            AtomicInteger atomicInteger2 = r8.f3055a;
            CollapsingToolbarLayout.this.p.w(((float) Math.abs(i)) / ((float) ((height - collapsingToolbarLayout3.getMinimumHeight()) - e)));
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CollapsingToolbarLayout(android.content.Context r10, android.util.AttributeSet r11) {
        /*
        // Method dump skipped, instructions count: 287
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.CollapsingToolbarLayout.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    public static int b(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return view.getMeasuredHeight();
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return view.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public static tk4 d(View view) {
        int i2 = R.id.view_offset_helper;
        tk4 tk4 = (tk4) view.getTag(i2);
        if (tk4 != null) {
            return tk4;
        }
        tk4 tk42 = new tk4(view);
        view.setTag(i2, tk42);
        return tk42;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:34:0x0028 */
    public final void a() {
        if (this.f) {
            ViewGroup viewGroup = null;
            this.h = null;
            this.i = null;
            int i2 = this.g;
            if (i2 != -1) {
                ViewGroup viewGroup2 = (ViewGroup) findViewById(i2);
                this.h = viewGroup2;
                if (viewGroup2 != null) {
                    ViewParent parent = viewGroup2.getParent();
                    View view = viewGroup2;
                    while (parent != this && parent != null) {
                        if (parent instanceof View) {
                            view = (View) parent;
                        }
                        parent = parent.getParent();
                        view = view;
                    }
                    this.i = view;
                }
            }
            if (this.h == null) {
                int childCount = getChildCount();
                int i3 = 0;
                while (true) {
                    if (i3 >= childCount) {
                        break;
                    }
                    View childAt = getChildAt(i3);
                    if ((childAt instanceof Toolbar) || (childAt instanceof android.widget.Toolbar)) {
                        viewGroup = (ViewGroup) childAt;
                        break;
                    }
                    i3++;
                }
                this.h = viewGroup;
            }
            e();
            this.f = false;
        }
    }

    public final int c(View view) {
        return ((getHeight() - d(view).b) - view.getHeight()) - ((FrameLayout.LayoutParams) ((a) view.getLayoutParams())).bottomMargin;
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    public void draw(Canvas canvas) {
        Drawable drawable;
        super.draw(canvas);
        a();
        if (this.h == null && (drawable = this.s) != null && this.u > 0) {
            drawable.mutate().setAlpha(this.u);
            this.s.draw(canvas);
        }
        if (this.q && this.r) {
            this.p.g(canvas);
        }
        if (this.t != null && this.u > 0) {
            c9 c9Var = this.B;
            int e = c9Var != null ? c9Var.e() : 0;
            if (e > 0) {
                this.t.setBounds(0, -this.A, getWidth(), e - this.A);
                this.t.mutate().setAlpha(this.u);
                this.t.draw(canvas);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0018, code lost:
        r3 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean drawChild(android.graphics.Canvas r5, android.view.View r6, long r7) {
        /*
            r4 = this;
            android.graphics.drawable.Drawable r0 = r4.s
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x002d
            int r3 = r4.u
            if (r3 <= 0) goto L_0x002d
            android.view.View r3 = r4.i
            if (r3 == 0) goto L_0x0014
            if (r3 != r4) goto L_0x0011
            goto L_0x0014
        L_0x0011:
            if (r6 != r3) goto L_0x001a
            goto L_0x0018
        L_0x0014:
            android.view.ViewGroup r3 = r4.h
            if (r6 != r3) goto L_0x001a
        L_0x0018:
            r3 = 1
            goto L_0x001b
        L_0x001a:
            r3 = 0
        L_0x001b:
            if (r3 == 0) goto L_0x002d
            android.graphics.drawable.Drawable r0 = r0.mutate()
            int r3 = r4.u
            r0.setAlpha(r3)
            android.graphics.drawable.Drawable r0 = r4.s
            r0.draw(r5)
            r0 = 1
            goto L_0x002e
        L_0x002d:
            r0 = 0
        L_0x002e:
            boolean r5 = super.drawChild(r5, r6, r7)
            if (r5 != 0) goto L_0x0038
            if (r0 == 0) goto L_0x0037
            goto L_0x0038
        L_0x0037:
            r1 = 0
        L_0x0038:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.CollapsingToolbarLayout.drawChild(android.graphics.Canvas, android.view.View, long):boolean");
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.t;
        boolean z2 = false;
        if (drawable != null && drawable.isStateful()) {
            z2 = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.s;
        if (drawable2 != null && drawable2.isStateful()) {
            z2 |= drawable2.setState(drawableState);
        }
        en4 en4 = this.p;
        if (en4 != null) {
            z2 |= en4.y(drawableState);
        }
        if (z2) {
            invalidate();
        }
    }

    public final void e() {
        View view;
        if (!this.q && (view = this.j) != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.j);
            }
        }
        if (this.q && this.h != null) {
            if (this.j == null) {
                this.j = new View(getContext());
            }
            if (this.j.getParent() == null) {
                this.h.addView(this.j, -1, -1);
            }
        }
    }

    public final void f() {
        if (this.s != null || this.t != null) {
            setScrimsShown(getHeight() + this.A < getScrimVisibleHeightTrigger());
        }
    }

    @Override // android.widget.FrameLayout, android.widget.FrameLayout
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new a(-1, -1);
    }

    public int getCollapsedTitleGravity() {
        return this.p.h;
    }

    public Typeface getCollapsedTitleTypeface() {
        Typeface typeface = this.p.s;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public Drawable getContentScrim() {
        return this.s;
    }

    public int getExpandedTitleGravity() {
        return this.p.g;
    }

    public int getExpandedTitleMarginBottom() {
        return this.n;
    }

    public int getExpandedTitleMarginEnd() {
        return this.m;
    }

    public int getExpandedTitleMarginStart() {
        return this.k;
    }

    public int getExpandedTitleMarginTop() {
        return this.l;
    }

    public Typeface getExpandedTitleTypeface() {
        Typeface typeface = this.p.t;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public int getMaxLines() {
        return this.p.Y;
    }

    public int getScrimAlpha() {
        return this.u;
    }

    public long getScrimAnimationDuration() {
        return this.x;
    }

    public int getScrimVisibleHeightTrigger() {
        int i2 = this.y;
        if (i2 >= 0) {
            return i2;
        }
        c9 c9Var = this.B;
        int e = c9Var != null ? c9Var.e() : 0;
        AtomicInteger atomicInteger = r8.f3055a;
        int minimumHeight = getMinimumHeight();
        if (minimumHeight > 0) {
            return Math.min((minimumHeight * 2) + e, getHeight());
        }
        return getHeight() / 3;
    }

    public Drawable getStatusBarScrim() {
        return this.t;
    }

    public CharSequence getTitle() {
        if (this.q) {
            return this.p.x;
        }
        return null;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            AtomicInteger atomicInteger = r8.f3055a;
            setFitsSystemWindows(((View) parent).getFitsSystemWindows());
            if (this.z == null) {
                this.z = new b();
            }
            AppBarLayout appBarLayout = (AppBarLayout) parent;
            AppBarLayout.c cVar = this.z;
            if (appBarLayout.m == null) {
                appBarLayout.m = new ArrayList();
            }
            if (cVar != null && !appBarLayout.m.contains(cVar)) {
                appBarLayout.m.add(cVar);
            }
            requestApplyInsets();
        }
    }

    public void onDetachedFromWindow() {
        List<AppBarLayout.a> list;
        ViewParent parent = getParent();
        AppBarLayout.c cVar = this.z;
        if (!(cVar == null || !(parent instanceof AppBarLayout) || (list = ((AppBarLayout) parent).m) == null || cVar == null)) {
            list.remove(cVar);
        }
        super.onDetachedFromWindow();
    }

    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        CharSequence charSequence;
        View view;
        int i6;
        int i7;
        int i8;
        int i9;
        super.onLayout(z2, i2, i3, i4, i5);
        c9 c9Var = this.B;
        if (c9Var != null) {
            int e = c9Var.e();
            int childCount = getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = getChildAt(i10);
                AtomicInteger atomicInteger = r8.f3055a;
                if (!childAt.getFitsSystemWindows() && childAt.getTop() < e) {
                    r8.o(childAt, e);
                }
            }
        }
        int childCount2 = getChildCount();
        for (int i11 = 0; i11 < childCount2; i11++) {
            tk4 d = d(getChildAt(i11));
            d.b = d.f3370a.getTop();
            d.c = d.f3370a.getLeft();
        }
        if (this.q && (view = this.j) != null) {
            AtomicInteger atomicInteger2 = r8.f3055a;
            boolean z3 = view.isAttachedToWindow() && this.j.getVisibility() == 0;
            this.r = z3;
            if (z3) {
                boolean z4 = getLayoutDirection() == 1;
                View view2 = this.i;
                if (view2 == null) {
                    view2 = this.h;
                }
                int c = c(view2);
                fn4.a(this, this.j, this.o);
                ViewGroup viewGroup = this.h;
                if (viewGroup instanceof Toolbar) {
                    Toolbar toolbar = (Toolbar) viewGroup;
                    i8 = toolbar.getTitleMarginStart();
                    i7 = toolbar.getTitleMarginEnd();
                    i6 = toolbar.getTitleMarginTop();
                    i9 = toolbar.getTitleMarginBottom();
                } else if (Build.VERSION.SDK_INT < 24 || !(viewGroup instanceof android.widget.Toolbar)) {
                    i9 = 0;
                    i8 = 0;
                    i7 = 0;
                    i6 = 0;
                } else {
                    android.widget.Toolbar toolbar2 = (android.widget.Toolbar) viewGroup;
                    i8 = toolbar2.getTitleMarginStart();
                    i7 = toolbar2.getTitleMarginEnd();
                    i6 = toolbar2.getTitleMarginTop();
                    i9 = toolbar2.getTitleMarginBottom();
                }
                en4 en4 = this.p;
                Rect rect = this.o;
                int i12 = rect.left + (z4 ? i7 : i8);
                int i13 = rect.top + c + i6;
                int i14 = rect.right;
                if (!z4) {
                    i8 = i7;
                }
                int i15 = i14 - i8;
                int i16 = (rect.bottom + c) - i9;
                if (!en4.n(en4.e, i12, i13, i15, i16)) {
                    en4.e.set(i12, i13, i15, i16);
                    en4.E = true;
                    en4.l();
                }
                en4 en42 = this.p;
                int i17 = z4 ? this.m : this.k;
                int i18 = this.o.top + this.l;
                int i19 = (i4 - i2) - (z4 ? this.k : this.m);
                int i20 = (i5 - i3) - this.n;
                if (!en4.n(en42.d, i17, i18, i19, i20)) {
                    en42.d.set(i17, i18, i19, i20);
                    en42.E = true;
                    en42.l();
                }
                this.p.m();
            }
        }
        if (this.h != null && this.q && TextUtils.isEmpty(this.p.x)) {
            ViewGroup viewGroup2 = this.h;
            if (viewGroup2 instanceof Toolbar) {
                charSequence = ((Toolbar) viewGroup2).getTitle();
            } else {
                charSequence = viewGroup2 instanceof android.widget.Toolbar ? ((android.widget.Toolbar) viewGroup2).getTitle() : null;
            }
            setTitle(charSequence);
        }
        f();
        int childCount3 = getChildCount();
        for (int i21 = 0; i21 < childCount3; i21++) {
            d(getChildAt(i21)).a();
        }
    }

    public void onMeasure(int i2, int i3) {
        a();
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i3);
        c9 c9Var = this.B;
        int e = c9Var != null ? c9Var.e() : 0;
        if (mode == 0 && e > 0) {
            super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + e, CommonUtils.BYTES_IN_A_GIGABYTE));
        }
        ViewGroup viewGroup = this.h;
        if (viewGroup != null) {
            View view = this.i;
            if (view == null || view == this) {
                setMinimumHeight(b(viewGroup));
            } else {
                setMinimumHeight(b(view));
            }
        }
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        Drawable drawable = this.s;
        if (drawable != null) {
            drawable.setBounds(0, 0, i2, i3);
        }
    }

    public void setCollapsedTitleGravity(int i2) {
        en4 en4 = this.p;
        if (en4.h != i2) {
            en4.h = i2;
            en4.m();
        }
    }

    public void setCollapsedTitleTextAppearance(int i2) {
        this.p.o(i2);
    }

    public void setCollapsedTitleTextColor(int i2) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setCollapsedTitleTypeface(Typeface typeface) {
        this.p.r(typeface);
    }

    public void setContentScrim(Drawable drawable) {
        Drawable drawable2 = this.s;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.s = drawable3;
            if (drawable3 != null) {
                drawable3.setBounds(0, 0, getWidth(), getHeight());
                this.s.setCallback(this);
                this.s.setAlpha(this.u);
            }
            AtomicInteger atomicInteger = r8.f3055a;
            postInvalidateOnAnimation();
        }
    }

    public void setContentScrimColor(int i2) {
        setContentScrim(new ColorDrawable(i2));
    }

    public void setContentScrimResource(int i2) {
        Context context = getContext();
        Object obj = q5.f2896a;
        setContentScrim(q5.c.b(context, i2));
    }

    public void setExpandedTitleColor(int i2) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setExpandedTitleGravity(int i2) {
        en4 en4 = this.p;
        if (en4.g != i2) {
            en4.g = i2;
            en4.m();
        }
    }

    public void setExpandedTitleMarginBottom(int i2) {
        this.n = i2;
        requestLayout();
    }

    public void setExpandedTitleMarginEnd(int i2) {
        this.m = i2;
        requestLayout();
    }

    public void setExpandedTitleMarginStart(int i2) {
        this.k = i2;
        requestLayout();
    }

    public void setExpandedTitleMarginTop(int i2) {
        this.l = i2;
        requestLayout();
    }

    public void setExpandedTitleTextAppearance(int i2) {
        this.p.s(i2);
    }

    public void setExpandedTitleTextColor(ColorStateList colorStateList) {
        en4 en4 = this.p;
        if (en4.k != colorStateList) {
            en4.k = colorStateList;
            en4.m();
        }
    }

    public void setExpandedTitleTypeface(Typeface typeface) {
        this.p.v(typeface);
    }

    public void setMaxLines(int i2) {
        en4 en4 = this.p;
        if (i2 != en4.Y) {
            en4.Y = i2;
            en4.f();
            en4.m();
        }
    }

    public void setScrimAlpha(int i2) {
        ViewGroup viewGroup;
        if (i2 != this.u) {
            if (!(this.s == null || (viewGroup = this.h) == null)) {
                AtomicInteger atomicInteger = r8.f3055a;
                viewGroup.postInvalidateOnAnimation();
            }
            this.u = i2;
            AtomicInteger atomicInteger2 = r8.f3055a;
            postInvalidateOnAnimation();
        }
    }

    public void setScrimAnimationDuration(long j2) {
        this.x = j2;
    }

    public void setScrimVisibleHeightTrigger(int i2) {
        if (this.y != i2) {
            this.y = i2;
            f();
        }
    }

    public void setScrimsShown(boolean z2) {
        AtomicInteger atomicInteger = r8.f3055a;
        int i2 = 0;
        boolean z3 = isLaidOut() && !isInEditMode();
        if (this.v != z2) {
            int i3 = Constants.MAX_HOST_LENGTH;
            if (z3) {
                if (!z2) {
                    i3 = 0;
                }
                a();
                ValueAnimator valueAnimator = this.w;
                if (valueAnimator == null) {
                    ValueAnimator valueAnimator2 = new ValueAnimator();
                    this.w = valueAnimator2;
                    valueAnimator2.setDuration(this.x);
                    this.w.setInterpolator(i3 > this.u ? zj4.c : zj4.d);
                    this.w.addUpdateListener(new pk4(this));
                } else if (valueAnimator.isRunning()) {
                    this.w.cancel();
                }
                this.w.setIntValues(this.u, i3);
                this.w.start();
            } else {
                if (z2) {
                    i2 = Constants.MAX_HOST_LENGTH;
                }
                setScrimAlpha(i2);
            }
            this.v = z2;
        }
    }

    public void setStatusBarScrim(Drawable drawable) {
        Drawable drawable2 = this.t;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.t = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.t.setState(getDrawableState());
                }
                Drawable drawable4 = this.t;
                AtomicInteger atomicInteger = r8.f3055a;
                h.s0(drawable4, getLayoutDirection());
                this.t.setVisible(getVisibility() == 0, false);
                this.t.setCallback(this);
                this.t.setAlpha(this.u);
            }
            AtomicInteger atomicInteger2 = r8.f3055a;
            postInvalidateOnAnimation();
        }
    }

    public void setStatusBarScrimColor(int i2) {
        setStatusBarScrim(new ColorDrawable(i2));
    }

    public void setStatusBarScrimResource(int i2) {
        Context context = getContext();
        Object obj = q5.f2896a;
        setStatusBarScrim(q5.c.b(context, i2));
    }

    public void setTitle(CharSequence charSequence) {
        this.p.z(charSequence);
        setContentDescription(getTitle());
    }

    public void setTitleEnabled(boolean z2) {
        if (z2 != this.q) {
            this.q = z2;
            setContentDescription(getTitle());
            e();
            requestLayout();
        }
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z2 = i2 == 0;
        Drawable drawable = this.t;
        if (!(drawable == null || drawable.isVisible() == z2)) {
            this.t.setVisible(z2, false);
        }
        Drawable drawable2 = this.s;
        if (drawable2 != null && drawable2.isVisible() != z2) {
            this.s.setVisible(z2, false);
        }
    }

    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.s || drawable == this.t;
    }

    @Override // android.widget.FrameLayout, android.widget.FrameLayout
    /* renamed from: generateDefaultLayoutParams  reason: collision with other method in class */
    public FrameLayout.LayoutParams m9generateDefaultLayoutParams() {
        return new a(-1, -1);
    }

    @Override // android.widget.FrameLayout, android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    public void setCollapsedTitleTextColor(ColorStateList colorStateList) {
        en4 en4 = this.p;
        if (en4.l != colorStateList) {
            en4.l = colorStateList;
            en4.m();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    public static class a extends FrameLayout.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f610a = 0;
        public float b = 0.5f;

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CollapsingToolbarLayout_Layout);
            this.f610a = obtainStyledAttributes.getInt(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
            this.b = obtainStyledAttributes.getFloat(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5f);
            obtainStyledAttributes.recycle();
        }

        public a(int i, int i2) {
            super(i, i2);
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }
}
