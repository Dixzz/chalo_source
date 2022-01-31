package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.TooltipCompat;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.R;
import com.google.android.material.badge.BadgeDrawable;
import defpackage.e9;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@ViewPager.d
public class TabLayout extends HorizontalScrollView {
    public static final int V = R.style.Widget_Design_TabLayout;
    public static final v7<g> W = new x7(16);
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public boolean F;
    public boolean G;
    public int H;
    public boolean I;
    public fp4 J;
    public c K;
    public final ArrayList<c> L = new ArrayList<>();
    public c M;
    public ValueAnimator N;
    public ViewPager O;
    public ro P;
    public DataSetObserver Q;
    public h R;
    public b S;
    public boolean T;
    public final v7<i> U = new w7(12);
    public final ArrayList<g> f = new ArrayList<>();
    public g g;
    public final f h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public ColorStateList n;
    public ColorStateList o;
    public ColorStateList p;
    public Drawable q = new GradientDrawable();
    public int r = 0;
    public PorterDuff.Mode s;
    public float t;
    public float u;
    public final int v;
    public int w = Integer.MAX_VALUE;
    public final int x;
    public final int y;
    public final int z;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TabLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
        }
    }

    public class b implements ViewPager.h {

        /* renamed from: a  reason: collision with root package name */
        public boolean f635a;

        public b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.h
        public void a(ViewPager viewPager, ro roVar, ro roVar2) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.O == viewPager) {
                tabLayout.l(roVar2, this.f635a);
            }
        }
    }

    @Deprecated
    public interface c<T extends g> {
        void a(T t);

        void b(T t);

        void c(T t);
    }

    public interface d extends c<g> {
    }

    public class e extends DataSetObserver {
        public e() {
        }

        public void onChanged() {
            TabLayout.this.i();
        }

        public void onInvalidated() {
            TabLayout.this.i();
        }
    }

    public class f extends LinearLayout {
        public ValueAnimator f;
        public int g = -1;
        public float h;
        public int i = -1;

        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ View f637a;
            public final /* synthetic */ View b;

            public a(View view, View view2) {
                this.f637a = view;
                this.b = view2;
            }

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.c(this.f637a, this.b, valueAnimator.getAnimatedFraction());
            }
        }

        public class b extends AnimatorListenerAdapter {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ int f638a;

            public b(int i) {
                this.f638a = i;
            }

            public void onAnimationEnd(Animator animator) {
                f.this.g = this.f638a;
            }

            public void onAnimationStart(Animator animator) {
                f.this.g = this.f638a;
            }
        }

        public f(Context context) {
            super(context);
            setWillNotDraw(false);
        }

        public final void a() {
            View childAt = getChildAt(this.g);
            TabLayout tabLayout = TabLayout.this;
            fp4 fp4 = tabLayout.J;
            Drawable drawable = tabLayout.q;
            Objects.requireNonNull(fp4);
            RectF a2 = fp4.a(tabLayout, childAt);
            drawable.setBounds((int) a2.left, drawable.getBounds().top, (int) a2.right, drawable.getBounds().bottom);
        }

        public void b(int i2) {
            Rect bounds = TabLayout.this.q.getBounds();
            TabLayout.this.q.setBounds(bounds.left, 0, bounds.right, i2);
            requestLayout();
        }

        public final void c(View view, View view2, float f2) {
            if (view != null && view.getWidth() > 0) {
                TabLayout tabLayout = TabLayout.this;
                tabLayout.J.b(tabLayout, view, view2, f2, tabLayout.q);
            } else {
                Drawable drawable = TabLayout.this.q;
                drawable.setBounds(-1, drawable.getBounds().top, -1, TabLayout.this.q.getBounds().bottom);
            }
            AtomicInteger atomicInteger = r8.f3055a;
            postInvalidateOnAnimation();
        }

        public final void d(boolean z, int i2, int i3) {
            View childAt = getChildAt(this.g);
            View childAt2 = getChildAt(i2);
            if (childAt2 == null) {
                a();
                return;
            }
            a aVar = new a(childAt, childAt2);
            if (z) {
                ValueAnimator valueAnimator = new ValueAnimator();
                this.f = valueAnimator;
                valueAnimator.setInterpolator(zj4.b);
                valueAnimator.setDuration((long) i3);
                valueAnimator.setFloatValues(0.0f, 1.0f);
                valueAnimator.addUpdateListener(aVar);
                valueAnimator.addListener(new b(i2));
                valueAnimator.start();
                return;
            }
            this.f.removeAllUpdateListeners();
            this.f.addUpdateListener(aVar);
        }

        public void draw(Canvas canvas) {
            int height = TabLayout.this.q.getBounds().height();
            if (height < 0) {
                height = TabLayout.this.q.getIntrinsicHeight();
            }
            int i2 = TabLayout.this.D;
            int i3 = 0;
            if (i2 == 0) {
                i3 = getHeight() - height;
                height = getHeight();
            } else if (i2 == 1) {
                i3 = (getHeight() - height) / 2;
                height = (getHeight() + height) / 2;
            } else if (i2 != 2) {
                if (i2 != 3) {
                    height = 0;
                } else {
                    height = getHeight();
                }
            }
            if (TabLayout.this.q.getBounds().width() > 0) {
                Rect bounds = TabLayout.this.q.getBounds();
                TabLayout.this.q.setBounds(bounds.left, i3, bounds.right, height);
                TabLayout tabLayout = TabLayout.this;
                Drawable drawable = tabLayout.q;
                if (tabLayout.r != 0) {
                    drawable = defpackage.h.H0(drawable);
                    if (Build.VERSION.SDK_INT == 21) {
                        drawable.setColorFilter(TabLayout.this.r, PorterDuff.Mode.SRC_IN);
                    } else {
                        drawable.setTint(TabLayout.this.r);
                    }
                }
                drawable.draw(canvas);
            }
            super.draw(canvas);
        }

        public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
            super.onLayout(z, i2, i3, i4, i5);
            ValueAnimator valueAnimator = this.f;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                a();
            } else {
                d(false, this.g, -1);
            }
        }

        public void onMeasure(int i2, int i3) {
            super.onMeasure(i2, i3);
            if (View.MeasureSpec.getMode(i2) == 1073741824) {
                TabLayout tabLayout = TabLayout.this;
                boolean z = true;
                if (tabLayout.B == 1 || tabLayout.E == 2) {
                    int childCount = getChildCount();
                    int i4 = 0;
                    for (int i5 = 0; i5 < childCount; i5++) {
                        View childAt = getChildAt(i5);
                        if (childAt.getVisibility() == 0) {
                            i4 = Math.max(i4, childAt.getMeasuredWidth());
                        }
                    }
                    if (i4 > 0) {
                        if (i4 * childCount <= getMeasuredWidth() - (((int) hd3.K0(getContext(), 16)) * 2)) {
                            boolean z2 = false;
                            for (int i6 = 0; i6 < childCount; i6++) {
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i6).getLayoutParams();
                                if (layoutParams.width != i4 || layoutParams.weight != 0.0f) {
                                    layoutParams.width = i4;
                                    layoutParams.weight = 0.0f;
                                    z2 = true;
                                }
                            }
                            z = z2;
                        } else {
                            TabLayout tabLayout2 = TabLayout.this;
                            tabLayout2.B = 0;
                            tabLayout2.q(false);
                        }
                        if (z) {
                            super.onMeasure(i2, i3);
                        }
                    }
                }
            }
        }

        public void onRtlPropertiesChanged(int i2) {
            super.onRtlPropertiesChanged(i2);
            if (Build.VERSION.SDK_INT < 23 && this.i != i2) {
                requestLayout();
                this.i = i2;
            }
        }
    }

    public static class g {

        /* renamed from: a  reason: collision with root package name */
        public Drawable f639a;
        public CharSequence b;
        public CharSequence c;
        public int d = -1;
        public View e;
        public TabLayout f;
        public i g;
        public int h = -1;

        public g a(CharSequence charSequence) {
            if (TextUtils.isEmpty(this.c) && !TextUtils.isEmpty(charSequence)) {
                this.g.setContentDescription(charSequence);
            }
            this.b = charSequence;
            b();
            return this;
        }

        public void b() {
            i iVar = this.g;
            if (iVar != null) {
                iVar.f();
            }
        }
    }

    public static class h implements ViewPager.i {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<TabLayout> f640a;
        public int b;
        public int c;

        public h(TabLayout tabLayout) {
            this.f640a = new WeakReference<>(tabLayout);
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void a(int i, float f, int i2) {
            TabLayout tabLayout = this.f640a.get();
            if (tabLayout != null) {
                int i3 = this.c;
                boolean z = false;
                boolean z2 = i3 != 2 || this.b == 1;
                if (!(i3 == 2 && this.b == 0)) {
                    z = true;
                }
                tabLayout.m(i, f, z2, z);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void b(int i) {
            this.b = this.c;
            this.c = i;
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void c(int i) {
            TabLayout tabLayout = this.f640a.get();
            if (tabLayout != null && tabLayout.getSelectedTabPosition() != i && i < tabLayout.getTabCount()) {
                int i2 = this.c;
                tabLayout.k(tabLayout.g(i), i2 == 0 || (i2 == 2 && this.b == 0));
            }
        }
    }

    public final class i extends LinearLayout {
        public static final /* synthetic */ int q = 0;
        public g f;
        public TextView g;
        public ImageView h;
        public View i;
        public BadgeDrawable j;
        public View k;
        public TextView l;
        public ImageView m;
        public Drawable n;
        public int o = 2;

        public i(Context context) {
            super(context);
            q8 q8Var;
            g(context);
            int i2 = TabLayout.this.i;
            int i3 = TabLayout.this.j;
            int i4 = TabLayout.this.k;
            int i5 = TabLayout.this.l;
            AtomicInteger atomicInteger = r8.f3055a;
            setPaddingRelative(i2, i3, i4, i5);
            setGravity(17);
            setOrientation(!TabLayout.this.F ? 1 : 0);
            setClickable(true);
            Context context2 = getContext();
            int i6 = Build.VERSION.SDK_INT;
            if (i6 >= 24) {
                q8Var = new q8(PointerIcon.getSystemIcon(context2, 1002));
            } else {
                q8Var = new q8(null);
            }
            if (i6 >= 24) {
                setPointerIcon((PointerIcon) q8Var.f2911a);
            }
        }

        private BadgeDrawable getBadge() {
            return this.j;
        }

        private BadgeDrawable getOrCreateBadge() {
            if (this.j == null) {
                Context context = getContext();
                int i2 = BadgeDrawable.w;
                int i3 = BadgeDrawable.v;
                BadgeDrawable badgeDrawable = new BadgeDrawable(context);
                int[] iArr = R.styleable.Badge;
                FrameLayout frameLayout = null;
                mn4.a(context, null, i2, i3);
                mn4.b(context, null, iArr, i2, i3, new int[0]);
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, iArr, i2, i3);
                int i4 = obtainStyledAttributes.getInt(R.styleable.Badge_maxCharacterCount, 4);
                BadgeDrawable.SavedState savedState = badgeDrawable.m;
                if (savedState.j != i4) {
                    savedState.j = i4;
                    badgeDrawable.p = ((int) Math.pow(10.0d, ((double) i4) - 1.0d)) - 1;
                    badgeDrawable.h.d = true;
                    badgeDrawable.g();
                    badgeDrawable.invalidateSelf();
                }
                int i5 = R.styleable.Badge_number;
                if (obtainStyledAttributes.hasValue(i5)) {
                    int max = Math.max(0, obtainStyledAttributes.getInt(i5, 0));
                    BadgeDrawable.SavedState savedState2 = badgeDrawable.m;
                    if (savedState2.i != max) {
                        savedState2.i = max;
                        badgeDrawable.h.d = true;
                        badgeDrawable.g();
                        badgeDrawable.invalidateSelf();
                    }
                }
                int defaultColor = hd3.h1(context, obtainStyledAttributes, R.styleable.Badge_backgroundColor).getDefaultColor();
                badgeDrawable.m.f = defaultColor;
                ColorStateList valueOf = ColorStateList.valueOf(defaultColor);
                ho4 ho4 = badgeDrawable.g;
                if (ho4.f.d != valueOf) {
                    ho4.q(valueOf);
                    badgeDrawable.invalidateSelf();
                }
                int i6 = R.styleable.Badge_badgeTextColor;
                if (obtainStyledAttributes.hasValue(i6)) {
                    int defaultColor2 = hd3.h1(context, obtainStyledAttributes, i6).getDefaultColor();
                    badgeDrawable.m.g = defaultColor2;
                    if (badgeDrawable.h.f2086a.getColor() != defaultColor2) {
                        badgeDrawable.h.f2086a.setColor(defaultColor2);
                        badgeDrawable.invalidateSelf();
                    }
                }
                int i7 = obtainStyledAttributes.getInt(R.styleable.Badge_badgeGravity, 8388661);
                BadgeDrawable.SavedState savedState3 = badgeDrawable.m;
                if (savedState3.n != i7) {
                    savedState3.n = i7;
                    WeakReference<View> weakReference = badgeDrawable.t;
                    if (!(weakReference == null || weakReference.get() == null)) {
                        View view = badgeDrawable.t.get();
                        WeakReference<FrameLayout> weakReference2 = badgeDrawable.u;
                        if (weakReference2 != null) {
                            frameLayout = weakReference2.get();
                        }
                        badgeDrawable.f(view, frameLayout);
                    }
                }
                badgeDrawable.m.p = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Badge_horizontalOffset, 0);
                badgeDrawable.g();
                badgeDrawable.m.q = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Badge_verticalOffset, 0);
                badgeDrawable.g();
                obtainStyledAttributes.recycle();
                this.j = badgeDrawable;
            }
            d();
            BadgeDrawable badgeDrawable2 = this.j;
            if (badgeDrawable2 != null) {
                return badgeDrawable2;
            }
            throw new IllegalStateException("Unable to create badge");
        }

        public final boolean a() {
            return this.j != null;
        }

        public final void b(View view) {
            if (a() && view != null) {
                setClipChildren(false);
                setClipToPadding(false);
                ViewGroup viewGroup = (ViewGroup) getParent();
                if (viewGroup != null) {
                    viewGroup.setClipChildren(false);
                    viewGroup.setClipToPadding(false);
                }
                BadgeDrawable badgeDrawable = this.j;
                Rect rect = new Rect();
                view.getDrawingRect(rect);
                badgeDrawable.setBounds(rect);
                badgeDrawable.f(view, null);
                if (badgeDrawable.c() != null) {
                    badgeDrawable.c().setForeground(badgeDrawable);
                } else {
                    view.getOverlay().add(badgeDrawable);
                }
                this.i = view;
            }
        }

        public final void c() {
            if (a()) {
                setClipChildren(true);
                setClipToPadding(true);
                ViewGroup viewGroup = (ViewGroup) getParent();
                if (viewGroup != null) {
                    viewGroup.setClipChildren(true);
                    viewGroup.setClipToPadding(true);
                }
                View view = this.i;
                if (view != null) {
                    BadgeDrawable badgeDrawable = this.j;
                    if (badgeDrawable != null) {
                        if (badgeDrawable.c() != null) {
                            badgeDrawable.c().setForeground(null);
                        } else {
                            view.getOverlay().remove(badgeDrawable);
                        }
                    }
                    this.i = null;
                }
            }
        }

        public final void d() {
            g gVar;
            g gVar2;
            if (a()) {
                if (this.k != null) {
                    c();
                    return;
                }
                ImageView imageView = this.h;
                if (imageView == null || (gVar2 = this.f) == null || gVar2.f639a == null) {
                    if (this.g == null || (gVar = this.f) == null) {
                        c();
                        return;
                    }
                    Objects.requireNonNull(gVar);
                    View view = this.i;
                    TextView textView = this.g;
                    if (view != textView) {
                        c();
                        b(this.g);
                        return;
                    }
                    e(textView);
                } else if (this.i != imageView) {
                    c();
                    b(this.h);
                } else {
                    e(imageView);
                }
            }
        }

        public void drawableStateChanged() {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.n;
            boolean z = false;
            if (drawable != null && drawable.isStateful()) {
                z = false | this.n.setState(drawableState);
            }
            if (z) {
                invalidate();
                TabLayout.this.invalidate();
            }
        }

        public final void e(View view) {
            if (a() && view == this.i) {
                BadgeDrawable badgeDrawable = this.j;
                Rect rect = new Rect();
                view.getDrawingRect(rect);
                badgeDrawable.setBounds(rect);
                badgeDrawable.f(view, null);
            }
        }

        public final void f() {
            Drawable drawable;
            g gVar = this.f;
            Drawable drawable2 = null;
            View view = gVar != null ? gVar.e : null;
            if (view != null) {
                ViewParent parent = view.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(view);
                    }
                    addView(view);
                }
                this.k = view;
                TextView textView = this.g;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.h;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.h.setImageDrawable(null);
                }
                TextView textView2 = (TextView) view.findViewById(16908308);
                this.l = textView2;
                if (textView2 != null) {
                    this.o = textView2.getMaxLines();
                }
                this.m = (ImageView) view.findViewById(16908294);
            } else {
                View view2 = this.k;
                if (view2 != null) {
                    removeView(view2);
                    this.k = null;
                }
                this.l = null;
                this.m = null;
            }
            boolean z = false;
            if (this.k == null) {
                if (this.h == null) {
                    ImageView imageView2 = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_icon, (ViewGroup) this, false);
                    this.h = imageView2;
                    addView(imageView2, 0);
                }
                if (!(gVar == null || (drawable = gVar.f639a) == null)) {
                    drawable2 = defpackage.h.H0(drawable).mutate();
                }
                if (drawable2 != null) {
                    drawable2.setTintList(TabLayout.this.o);
                    PorterDuff.Mode mode = TabLayout.this.s;
                    if (mode != null) {
                        drawable2.setTintMode(mode);
                    }
                }
                if (this.g == null) {
                    TextView textView3 = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_text, (ViewGroup) this, false);
                    this.g = textView3;
                    addView(textView3);
                    this.o = this.g.getMaxLines();
                }
                defpackage.h.w0(this.g, TabLayout.this.m);
                ColorStateList colorStateList = TabLayout.this.n;
                if (colorStateList != null) {
                    this.g.setTextColor(colorStateList);
                }
                h(this.g, this.h);
                d();
                ImageView imageView3 = this.h;
                if (imageView3 != null) {
                    imageView3.addOnLayoutChangeListener(new hp4(this, imageView3));
                }
                TextView textView4 = this.g;
                if (textView4 != null) {
                    textView4.addOnLayoutChangeListener(new hp4(this, textView4));
                }
            } else {
                TextView textView5 = this.l;
                if (!(textView5 == null && this.m == null)) {
                    h(textView5, this.m);
                }
            }
            if (gVar != null && !TextUtils.isEmpty(gVar.c)) {
                setContentDescription(gVar.c);
            }
            if (gVar != null) {
                TabLayout tabLayout = gVar.f;
                if (tabLayout != null) {
                    if (tabLayout.getSelectedTabPosition() == gVar.d) {
                        z = true;
                    }
                } else {
                    throw new IllegalArgumentException("Tab not attached to a TabLayout");
                }
            }
            setSelected(z);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r7v0, types: [com.google.android.material.tabs.TabLayout$i, android.widget.LinearLayout, android.view.View] */
        /* JADX WARN: Type inference failed for: r3v5, types: [android.graphics.drawable.RippleDrawable] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void g(android.content.Context r8) {
            /*
            // Method dump skipped, instructions count: 130
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.i.g(android.content.Context):void");
        }

        public int getContentHeight() {
            View[] viewArr = {this.g, this.h, this.k};
            int i2 = 0;
            int i3 = 0;
            boolean z = false;
            for (int i4 = 0; i4 < 3; i4++) {
                View view = viewArr[i4];
                if (view != null && view.getVisibility() == 0) {
                    i3 = z ? Math.min(i3, view.getTop()) : view.getTop();
                    i2 = z ? Math.max(i2, view.getBottom()) : view.getBottom();
                    z = true;
                }
            }
            return i2 - i3;
        }

        public int getContentWidth() {
            View[] viewArr = {this.g, this.h, this.k};
            int i2 = 0;
            int i3 = 0;
            boolean z = false;
            for (int i4 = 0; i4 < 3; i4++) {
                View view = viewArr[i4];
                if (view != null && view.getVisibility() == 0) {
                    i3 = z ? Math.min(i3, view.getLeft()) : view.getLeft();
                    i2 = z ? Math.max(i2, view.getRight()) : view.getRight();
                    z = true;
                }
            }
            return i2 - i3;
        }

        public g getTab() {
            return this.f;
        }

        public final void h(TextView textView, ImageView imageView) {
            Drawable drawable;
            g gVar = this.f;
            CharSequence charSequence = null;
            Drawable mutate = (gVar == null || (drawable = gVar.f639a) == null) ? null : defpackage.h.H0(drawable).mutate();
            g gVar2 = this.f;
            CharSequence charSequence2 = gVar2 != null ? gVar2.b : null;
            if (imageView != null) {
                if (mutate != null) {
                    imageView.setImageDrawable(mutate);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
            }
            boolean z = !TextUtils.isEmpty(charSequence2);
            if (textView != null) {
                if (z) {
                    textView.setText(charSequence2);
                    Objects.requireNonNull(this.f);
                    textView.setVisibility(0);
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText((CharSequence) null);
                }
            }
            if (imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                int K0 = (!z || imageView.getVisibility() != 0) ? 0 : (int) hd3.K0(getContext(), 8);
                if (TabLayout.this.F) {
                    if (K0 != marginLayoutParams.getMarginEnd()) {
                        marginLayoutParams.setMarginEnd(K0);
                        marginLayoutParams.bottomMargin = 0;
                        imageView.setLayoutParams(marginLayoutParams);
                        imageView.requestLayout();
                    }
                } else if (K0 != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = K0;
                    marginLayoutParams.setMarginEnd(0);
                    imageView.setLayoutParams(marginLayoutParams);
                    imageView.requestLayout();
                }
            }
            g gVar3 = this.f;
            if (gVar3 != null) {
                charSequence = gVar3.c;
            }
            if (!z) {
                charSequence2 = charSequence;
            }
            TooltipCompat.setTooltipText(this, charSequence2);
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            Context context;
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            BadgeDrawable badgeDrawable = this.j;
            if (badgeDrawable != null && badgeDrawable.isVisible()) {
                CharSequence contentDescription = getContentDescription();
                StringBuilder sb = new StringBuilder();
                sb.append((Object) contentDescription);
                sb.append(", ");
                BadgeDrawable badgeDrawable2 = this.j;
                Object obj = null;
                if (badgeDrawable2.isVisible()) {
                    if (!badgeDrawable2.e()) {
                        obj = badgeDrawable2.m.k;
                    } else if (badgeDrawable2.m.l > 0 && (context = badgeDrawable2.f.get()) != null) {
                        int d = badgeDrawable2.d();
                        int i2 = badgeDrawable2.p;
                        obj = d <= i2 ? context.getResources().getQuantityString(badgeDrawable2.m.l, badgeDrawable2.d(), Integer.valueOf(badgeDrawable2.d())) : context.getString(badgeDrawable2.m.m, Integer.valueOf(i2));
                    }
                }
                sb.append(obj);
                accessibilityNodeInfo.setContentDescription(sb.toString());
            }
            accessibilityNodeInfo.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) e9.c.a(0, 1, this.f.d, 1, false, isSelected()).f945a);
            if (isSelected()) {
                accessibilityNodeInfo.setClickable(false);
                accessibilityNodeInfo.removeAction((AccessibilityNodeInfo.AccessibilityAction) e9.a.g.f943a);
            }
            accessibilityNodeInfo.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", getResources().getString(R.string.item_view_role_description));
        }

        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0094, code lost:
            if (((r0 / r2.getPaint().getTextSize()) * r2.getLineWidth(0)) > ((float) ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()))) goto L_0x0096;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onMeasure(int r8, int r9) {
            /*
            // Method dump skipped, instructions count: 167
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.i.onMeasure(int, int):void");
        }

        public boolean performClick() {
            boolean performClick = super.performClick();
            if (this.f == null) {
                return performClick;
            }
            if (!performClick) {
                playSoundEffect(0);
            }
            g gVar = this.f;
            TabLayout tabLayout = gVar.f;
            if (tabLayout != null) {
                tabLayout.k(gVar, true);
                return true;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public void setSelected(boolean z) {
            if (isSelected() != z) {
            }
            super.setSelected(z);
            TextView textView = this.g;
            if (textView != null) {
                textView.setSelected(z);
            }
            ImageView imageView = this.h;
            if (imageView != null) {
                imageView.setSelected(z);
            }
            View view = this.k;
            if (view != null) {
                view.setSelected(z);
            }
        }

        public void setTab(g gVar) {
            if (gVar != this.f) {
                this.f = gVar;
                f();
            }
        }
    }

    public static class j implements d {

        /* renamed from: a  reason: collision with root package name */
        public final ViewPager f641a;

        public j(ViewPager viewPager) {
            this.f641a = viewPager;
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void a(g gVar) {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void b(g gVar) {
            this.f641a.setCurrentItem(gVar.d);
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void c(g gVar) {
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TabLayout(android.content.Context r12, android.util.AttributeSet r13) {
        /*
        // Method dump skipped, instructions count: 474
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    private int getDefaultHeight() {
        int size = this.f.size();
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                g gVar = this.f.get(i2);
                if (gVar != null && gVar.f639a != null && !TextUtils.isEmpty(gVar.b)) {
                    z2 = true;
                    break;
                }
                i2++;
            } else {
                break;
            }
        }
        return (!z2 || this.F) ? 48 : 72;
    }

    private int getTabMinWidth() {
        int i2 = this.x;
        if (i2 != -1) {
            return i2;
        }
        int i3 = this.E;
        if (i3 == 0 || i3 == 2) {
            return this.z;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.h.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void setSelectedTabView(int i2) {
        int childCount = this.h.getChildCount();
        if (i2 < childCount) {
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = this.h.getChildAt(i3);
                boolean z2 = true;
                childAt.setSelected(i3 == i2);
                if (i3 != i2) {
                    z2 = false;
                }
                childAt.setActivated(z2);
                i3++;
            }
        }
    }

    public void a(g gVar, boolean z2) {
        int size = this.f.size();
        if (gVar.f == this) {
            gVar.d = size;
            this.f.add(size, gVar);
            int size2 = this.f.size();
            while (true) {
                size++;
                if (size >= size2) {
                    break;
                }
                this.f.get(size).d = size;
            }
            i iVar = gVar.g;
            iVar.setSelected(false);
            iVar.setActivated(false);
            f fVar = this.h;
            int i2 = gVar.d;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            p(layoutParams);
            fVar.addView(iVar, i2, layoutParams);
            if (z2) {
                TabLayout tabLayout = gVar.f;
                if (tabLayout != null) {
                    tabLayout.k(gVar, true);
                    return;
                }
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            return;
        }
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    public void addView(View view) {
        b(view);
    }

    public final void b(View view) {
        if (view instanceof gp4) {
            gp4 gp4 = (gp4) view;
            g h2 = h();
            Objects.requireNonNull(gp4);
            if (!TextUtils.isEmpty(gp4.getContentDescription())) {
                h2.c = gp4.getContentDescription();
                h2.b();
            }
            a(h2, this.f.isEmpty());
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    public final void c(int i2) {
        boolean z2;
        if (i2 != -1) {
            if (getWindowToken() != null) {
                AtomicInteger atomicInteger = r8.f3055a;
                if (isLaidOut()) {
                    f fVar = this.h;
                    int childCount = fVar.getChildCount();
                    int i3 = 0;
                    while (true) {
                        if (i3 >= childCount) {
                            z2 = false;
                            break;
                        } else if (fVar.getChildAt(i3).getWidth() <= 0) {
                            z2 = true;
                            break;
                        } else {
                            i3++;
                        }
                    }
                    if (!z2) {
                        int scrollX = getScrollX();
                        int e2 = e(i2, 0.0f);
                        if (scrollX != e2) {
                            f();
                            this.N.setIntValues(scrollX, e2);
                            this.N.start();
                        }
                        f fVar2 = this.h;
                        int i4 = this.C;
                        ValueAnimator valueAnimator = fVar2.f;
                        if (valueAnimator != null && valueAnimator.isRunning()) {
                            fVar2.f.cancel();
                        }
                        fVar2.d(true, i2, i4);
                        return;
                    }
                }
            }
            m(i2, 0.0f, true, true);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0033, code lost:
        if (r0 != 2) goto L_0x0044;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d() {
        /*
            r5 = this;
            int r0 = r5.E
            r1 = 2
            r2 = 0
            if (r0 == 0) goto L_0x000b
            if (r0 != r1) goto L_0x0009
            goto L_0x000b
        L_0x0009:
            r0 = 0
            goto L_0x0014
        L_0x000b:
            int r0 = r5.A
            int r3 = r5.i
            int r0 = r0 - r3
            int r0 = java.lang.Math.max(r2, r0)
        L_0x0014:
            com.google.android.material.tabs.TabLayout$f r3 = r5.h
            java.util.concurrent.atomic.AtomicInteger r4 = defpackage.r8.f3055a
            r3.setPaddingRelative(r0, r2, r2, r2)
            int r0 = r5.E
            r2 = 1
            if (r0 == 0) goto L_0x002d
            if (r0 == r2) goto L_0x0025
            if (r0 == r1) goto L_0x0025
            goto L_0x0044
        L_0x0025:
            int r0 = r5.B
            com.google.android.material.tabs.TabLayout$f r0 = r5.h
            r0.setGravity(r2)
            goto L_0x0044
        L_0x002d:
            int r0 = r5.B
            if (r0 == 0) goto L_0x003c
            if (r0 == r2) goto L_0x0036
            if (r0 == r1) goto L_0x003c
            goto L_0x0044
        L_0x0036:
            com.google.android.material.tabs.TabLayout$f r0 = r5.h
            r0.setGravity(r2)
            goto L_0x0044
        L_0x003c:
            com.google.android.material.tabs.TabLayout$f r0 = r5.h
            r1 = 8388611(0x800003, float:1.1754948E-38)
            r0.setGravity(r1)
        L_0x0044:
            r5.q(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.d():void");
    }

    public final int e(int i2, float f2) {
        int i3 = this.E;
        int i4 = 0;
        if (i3 != 0 && i3 != 2) {
            return 0;
        }
        View childAt = this.h.getChildAt(i2);
        int i5 = i2 + 1;
        View childAt2 = i5 < this.h.getChildCount() ? this.h.getChildAt(i5) : null;
        int width = childAt != null ? childAt.getWidth() : 0;
        if (childAt2 != null) {
            i4 = childAt2.getWidth();
        }
        int left = ((width / 2) + childAt.getLeft()) - (getWidth() / 2);
        int i6 = (int) (((float) (width + i4)) * 0.5f * f2);
        AtomicInteger atomicInteger = r8.f3055a;
        return getLayoutDirection() == 0 ? left + i6 : left - i6;
    }

    public final void f() {
        if (this.N == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.N = valueAnimator;
            valueAnimator.setInterpolator(zj4.b);
            this.N.setDuration((long) this.C);
            this.N.addUpdateListener(new a());
        }
    }

    public g g(int i2) {
        if (i2 < 0 || i2 >= getTabCount()) {
            return null;
        }
        return this.f.get(i2);
    }

    public int getSelectedTabPosition() {
        g gVar = this.g;
        if (gVar != null) {
            return gVar.d;
        }
        return -1;
    }

    public int getTabCount() {
        return this.f.size();
    }

    public int getTabGravity() {
        return this.B;
    }

    public ColorStateList getTabIconTint() {
        return this.o;
    }

    public int getTabIndicatorAnimationMode() {
        return this.H;
    }

    public int getTabIndicatorGravity() {
        return this.D;
    }

    public int getTabMaxWidth() {
        return this.w;
    }

    public int getTabMode() {
        return this.E;
    }

    public ColorStateList getTabRippleColor() {
        return this.p;
    }

    public Drawable getTabSelectedIndicator() {
        return this.q;
    }

    public ColorStateList getTabTextColors() {
        return this.n;
    }

    public g h() {
        g b2 = W.b();
        if (b2 == null) {
            b2 = new g();
        }
        b2.f = this;
        v7<i> v7Var = this.U;
        i b3 = v7Var != null ? v7Var.b() : null;
        if (b3 == null) {
            b3 = new i(getContext());
        }
        b3.setTab(b2);
        b3.setFocusable(true);
        b3.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(b2.c)) {
            b3.setContentDescription(b2.b);
        } else {
            b3.setContentDescription(b2.c);
        }
        b2.g = b3;
        int i2 = b2.h;
        if (i2 != -1) {
            b3.setId(i2);
        }
        return b2;
    }

    public void i() {
        int currentItem;
        j();
        ro roVar = this.P;
        if (roVar != null) {
            int d2 = roVar.d();
            for (int i2 = 0; i2 < d2; i2++) {
                g h2 = h();
                h2.a(this.P.e(i2));
                a(h2, false);
            }
            ViewPager viewPager = this.O;
            if (viewPager != null && d2 > 0 && (currentItem = viewPager.getCurrentItem()) != getSelectedTabPosition() && currentItem < getTabCount()) {
                k(g(currentItem), true);
            }
        }
    }

    public void j() {
        int childCount = this.h.getChildCount();
        while (true) {
            childCount--;
            if (childCount < 0) {
                break;
            }
            i iVar = (i) this.h.getChildAt(childCount);
            this.h.removeViewAt(childCount);
            if (iVar != null) {
                iVar.setTab(null);
                iVar.setSelected(false);
                this.U.a(iVar);
            }
            requestLayout();
        }
        Iterator<g> it = this.f.iterator();
        while (it.hasNext()) {
            g next = it.next();
            it.remove();
            next.f = null;
            next.g = null;
            next.f639a = null;
            next.h = -1;
            next.b = null;
            next.c = null;
            next.d = -1;
            next.e = null;
            W.a(next);
        }
        this.g = null;
    }

    public void k(g gVar, boolean z2) {
        g gVar2 = this.g;
        if (gVar2 != gVar) {
            int i2 = gVar != null ? gVar.d : -1;
            if (z2) {
                if ((gVar2 == null || gVar2.d == -1) && i2 != -1) {
                    m(i2, 0.0f, true, true);
                } else {
                    c(i2);
                }
                if (i2 != -1) {
                    setSelectedTabView(i2);
                }
            }
            this.g = gVar;
            if (gVar2 != null) {
                for (int size = this.L.size() - 1; size >= 0; size--) {
                    this.L.get(size).c(gVar2);
                }
            }
            if (gVar != null) {
                for (int size2 = this.L.size() - 1; size2 >= 0; size2--) {
                    this.L.get(size2).b(gVar);
                }
            }
        } else if (gVar2 != null) {
            for (int size3 = this.L.size() - 1; size3 >= 0; size3--) {
                this.L.get(size3).a(gVar);
            }
            c(gVar.d);
        }
    }

    public void l(ro roVar, boolean z2) {
        DataSetObserver dataSetObserver;
        ro roVar2 = this.P;
        if (!(roVar2 == null || (dataSetObserver = this.Q) == null)) {
            roVar2.f3106a.unregisterObserver(dataSetObserver);
        }
        this.P = roVar;
        if (z2 && roVar != null) {
            if (this.Q == null) {
                this.Q = new e();
            }
            roVar.f3106a.registerObserver(this.Q);
        }
        i();
    }

    public void m(int i2, float f2, boolean z2, boolean z3) {
        int round = Math.round(((float) i2) + f2);
        if (round >= 0 && round < this.h.getChildCount()) {
            if (z3) {
                f fVar = this.h;
                ValueAnimator valueAnimator = fVar.f;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    fVar.f.cancel();
                }
                fVar.g = i2;
                fVar.h = f2;
                fVar.c(fVar.getChildAt(i2), fVar.getChildAt(fVar.g + 1), fVar.h);
            }
            ValueAnimator valueAnimator2 = this.N;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.N.cancel();
            }
            scrollTo(e(i2, f2), 0);
            if (z2) {
                setSelectedTabView(round);
            }
        }
    }

    public final void n(ViewPager viewPager, boolean z2, boolean z3) {
        List<ViewPager.h> list;
        List<ViewPager.i> list2;
        ViewPager viewPager2 = this.O;
        if (viewPager2 != null) {
            h hVar = this.R;
            if (!(hVar == null || (list2 = viewPager2.W) == null)) {
                list2.remove(hVar);
            }
            b bVar = this.S;
            if (!(bVar == null || (list = this.O.b0) == null)) {
                list.remove(bVar);
            }
        }
        c cVar = this.M;
        if (cVar != null) {
            this.L.remove(cVar);
            this.M = null;
        }
        if (viewPager != null) {
            this.O = viewPager;
            if (this.R == null) {
                this.R = new h(this);
            }
            h hVar2 = this.R;
            hVar2.c = 0;
            hVar2.b = 0;
            if (viewPager.W == null) {
                viewPager.W = new ArrayList();
            }
            viewPager.W.add(hVar2);
            j jVar = new j(viewPager);
            this.M = jVar;
            if (!this.L.contains(jVar)) {
                this.L.add(jVar);
            }
            ro adapter = viewPager.getAdapter();
            if (adapter != null) {
                l(adapter, z2);
            }
            if (this.S == null) {
                this.S = new b();
            }
            b bVar2 = this.S;
            bVar2.f635a = z2;
            if (viewPager.b0 == null) {
                viewPager.b0 = new ArrayList();
            }
            viewPager.b0.add(bVar2);
            m(viewPager.getCurrentItem(), 0.0f, true, true);
        } else {
            this.O = null;
            l(null, false);
        }
        this.T = z3;
    }

    public final void o() {
        int size = this.f.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f.get(i2).b();
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable background = getBackground();
        if (background instanceof ho4) {
            hd3.N2(this, (ho4) background);
        }
        if (this.O == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                n((ViewPager) parent, true, true);
            }
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.T) {
            setupWithViewPager(null);
            this.T = false;
        }
    }

    public void onDraw(Canvas canvas) {
        i iVar;
        Drawable drawable;
        for (int i2 = 0; i2 < this.h.getChildCount(); i2++) {
            View childAt = this.h.getChildAt(i2);
            if ((childAt instanceof i) && (drawable = (iVar = (i) childAt).n) != null) {
                drawable.setBounds(iVar.getLeft(), iVar.getTop(), iVar.getRight(), iVar.getBottom());
                iVar.n.draw(canvas);
            }
        }
        super.onDraw(canvas);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) e9.b.a(1, getTabCount(), false, 1).f944a);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0073, code lost:
        if (r0 != 2) goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007e, code lost:
        if (r7.getMeasuredWidth() != getMeasuredWidth()) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0080, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008a, code lost:
        if (r7.getMeasuredWidth() < getMeasuredWidth()) goto L_0x0080;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r7, int r8) {
        /*
        // Method dump skipped, instructions count: 174
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.onMeasure(int, int):void");
    }

    public final void p(LinearLayout.LayoutParams layoutParams) {
        if (this.E == 1 && this.B == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
            return;
        }
        layoutParams.width = -2;
        layoutParams.weight = 0.0f;
    }

    public void q(boolean z2) {
        for (int i2 = 0; i2 < this.h.getChildCount(); i2++) {
            View childAt = this.h.getChildAt(i2);
            childAt.setMinimumWidth(getTabMinWidth());
            p((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z2) {
                childAt.requestLayout();
            }
        }
    }

    public void setElevation(float f2) {
        super.setElevation(f2);
        hd3.L2(this, f2);
    }

    public void setInlineLabel(boolean z2) {
        if (this.F != z2) {
            this.F = z2;
            for (int i2 = 0; i2 < this.h.getChildCount(); i2++) {
                View childAt = this.h.getChildAt(i2);
                if (childAt instanceof i) {
                    i iVar = (i) childAt;
                    iVar.setOrientation(!TabLayout.this.F ? 1 : 0);
                    TextView textView = iVar.l;
                    if (textView == null && iVar.m == null) {
                        iVar.h(iVar.g, iVar.h);
                    } else {
                        iVar.h(textView, iVar.m);
                    }
                }
            }
            d();
        }
    }

    public void setInlineLabelResource(int i2) {
        setInlineLabel(getResources().getBoolean(i2));
    }

    @Deprecated
    public void setOnTabSelectedListener(d dVar) {
        setOnTabSelectedListener((c) dVar);
    }

    public void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        f();
        this.N.addListener(animatorListener);
    }

    public void setSelectedTabIndicator(Drawable drawable) {
        if (this.q != drawable) {
            if (drawable == null) {
                drawable = new GradientDrawable();
            }
            this.q = drawable;
        }
    }

    public void setSelectedTabIndicatorColor(int i2) {
        this.r = i2;
    }

    public void setSelectedTabIndicatorGravity(int i2) {
        if (this.D != i2) {
            this.D = i2;
            f fVar = this.h;
            AtomicInteger atomicInteger = r8.f3055a;
            fVar.postInvalidateOnAnimation();
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i2) {
        this.h.b(i2);
    }

    public void setTabGravity(int i2) {
        if (this.B != i2) {
            this.B = i2;
            d();
        }
    }

    public void setTabIconTint(ColorStateList colorStateList) {
        if (this.o != colorStateList) {
            this.o = colorStateList;
            o();
        }
    }

    public void setTabIconTintResource(int i2) {
        setTabIconTint(u0.a(getContext(), i2));
    }

    public void setTabIndicatorAnimationMode(int i2) {
        this.H = i2;
        if (i2 == 0) {
            this.J = new fp4();
        } else if (i2 == 1) {
            this.J = new ep4();
        } else {
            throw new IllegalArgumentException(i2 + " is not a valid TabIndicatorAnimationMode");
        }
    }

    public void setTabIndicatorFullWidth(boolean z2) {
        this.G = z2;
        f fVar = this.h;
        AtomicInteger atomicInteger = r8.f3055a;
        fVar.postInvalidateOnAnimation();
    }

    public void setTabMode(int i2) {
        if (i2 != this.E) {
            this.E = i2;
            d();
        }
    }

    public void setTabRippleColor(ColorStateList colorStateList) {
        if (this.p != colorStateList) {
            this.p = colorStateList;
            for (int i2 = 0; i2 < this.h.getChildCount(); i2++) {
                View childAt = this.h.getChildAt(i2);
                if (childAt instanceof i) {
                    Context context = getContext();
                    int i3 = i.q;
                    ((i) childAt).g(context);
                }
            }
        }
    }

    public void setTabRippleColorResource(int i2) {
        setTabRippleColor(u0.a(getContext(), i2));
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.n != colorStateList) {
            this.n = colorStateList;
            o();
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(ro roVar) {
        l(roVar, false);
    }

    public void setUnboundedRipple(boolean z2) {
        if (this.I != z2) {
            this.I = z2;
            for (int i2 = 0; i2 < this.h.getChildCount(); i2++) {
                View childAt = this.h.getChildAt(i2);
                if (childAt instanceof i) {
                    Context context = getContext();
                    int i3 = i.q;
                    ((i) childAt).g(context);
                }
            }
        }
    }

    public void setUnboundedRippleResource(int i2) {
        setUnboundedRipple(getResources().getBoolean(i2));
    }

    public void setupWithViewPager(ViewPager viewPager) {
        n(viewPager, true, false);
    }

    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i2) {
        b(view);
    }

    @Override // android.widget.FrameLayout, android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    @Deprecated
    public void setOnTabSelectedListener(c cVar) {
        c cVar2 = this.K;
        if (cVar2 != null) {
            this.L.remove(cVar2);
        }
        this.K = cVar;
        if (cVar != null && !this.L.contains(cVar)) {
            this.L.add(cVar);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        b(view);
    }

    public void setSelectedTabIndicator(int i2) {
        if (i2 != 0) {
            setSelectedTabIndicator(u0.b(getContext(), i2));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        b(view);
    }
}
