package com.google.android.material.snackbar;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import defpackage.dp4;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {
    public static final Handler o = new Handler(Looper.getMainLooper(), new a());
    public static final int[] p = {R.attr.snackbarStyle};
    public static final String q = BaseTransientBottomBar.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public final ViewGroup f630a;
    public final Context b;
    public final i c;
    public final cp4 d;
    public int e;
    public final Runnable f = new b();
    public Rect g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public final AccessibilityManager m;
    public dp4.b n = new e();

    public static class Behavior extends SwipeDismissBehavior<View> {
        public final f i = new f(this);

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public boolean B(View view) {
            Objects.requireNonNull(this.i);
            return view instanceof i;
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean j(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            f fVar = this.i;
            Objects.requireNonNull(fVar);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked == 1 || actionMasked == 3) {
                    dp4.b().f(fVar.f633a);
                }
            } else if (coordinatorLayout.j(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                dp4.b().e(fVar.f633a);
            }
            return super.j(coordinatorLayout, view, motionEvent);
        }
    }

    public static class a implements Handler.Callback {
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                BaseTransientBottomBar baseTransientBottomBar = (BaseTransientBottomBar) message.obj;
                baseTransientBottomBar.c.setOnAttachStateChangeListener(new zo4(baseTransientBottomBar));
                if (baseTransientBottomBar.c.getParent() == null) {
                    ViewGroup.LayoutParams layoutParams = baseTransientBottomBar.c.getLayoutParams();
                    if (layoutParams instanceof CoordinatorLayout.f) {
                        CoordinatorLayout.f fVar = (CoordinatorLayout.f) layoutParams;
                        Behavior behavior = new Behavior();
                        f fVar2 = behavior.i;
                        Objects.requireNonNull(fVar2);
                        fVar2.f633a = baseTransientBottomBar.n;
                        behavior.b = new bp4(baseTransientBottomBar);
                        fVar.b(behavior);
                        fVar.g = 80;
                    }
                    baseTransientBottomBar.l = 0;
                    baseTransientBottomBar.h();
                    baseTransientBottomBar.c.setVisibility(4);
                    baseTransientBottomBar.f630a.addView(baseTransientBottomBar.c);
                }
                i iVar = baseTransientBottomBar.c;
                AtomicInteger atomicInteger = r8.f3055a;
                if (iVar.isLaidOut()) {
                    baseTransientBottomBar.g();
                } else {
                    baseTransientBottomBar.c.setOnLayoutChangeListener(new ap4(baseTransientBottomBar));
                }
                return true;
            } else if (i != 1) {
                return false;
            } else {
                BaseTransientBottomBar baseTransientBottomBar2 = (BaseTransientBottomBar) message.obj;
                int i2 = message.arg1;
                if (!baseTransientBottomBar2.f() || baseTransientBottomBar2.c.getVisibility() != 0) {
                    baseTransientBottomBar2.d(i2);
                } else if (baseTransientBottomBar2.c.getAnimationMode() == 1) {
                    ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
                    ofFloat.setInterpolator(zj4.f4184a);
                    ofFloat.addUpdateListener(new so4(baseTransientBottomBar2));
                    ofFloat.setDuration(75L);
                    ofFloat.addListener(new ro4(baseTransientBottomBar2, i2));
                    ofFloat.start();
                } else {
                    ValueAnimator valueAnimator = new ValueAnimator();
                    valueAnimator.setIntValues(0, baseTransientBottomBar2.c());
                    valueAnimator.setInterpolator(zj4.b);
                    valueAnimator.setDuration(250L);
                    valueAnimator.addListener(new wo4(baseTransientBottomBar2, i2));
                    valueAnimator.addUpdateListener(new xo4(baseTransientBottomBar2));
                    valueAnimator.start();
                }
                return true;
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            Context context;
            BaseTransientBottomBar baseTransientBottomBar = BaseTransientBottomBar.this;
            if (baseTransientBottomBar.c != null && (context = baseTransientBottomBar.b) != null) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
                int i = displayMetrics.heightPixels;
                BaseTransientBottomBar baseTransientBottomBar2 = BaseTransientBottomBar.this;
                int[] iArr = new int[2];
                baseTransientBottomBar2.c.getLocationOnScreen(iArr);
                int height = (i - (baseTransientBottomBar2.c.getHeight() + iArr[1])) + ((int) BaseTransientBottomBar.this.c.getTranslationY());
                BaseTransientBottomBar baseTransientBottomBar3 = BaseTransientBottomBar.this;
                if (height < baseTransientBottomBar3.k) {
                    ViewGroup.LayoutParams layoutParams = baseTransientBottomBar3.c.getLayoutParams();
                    if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                        Handler handler = BaseTransientBottomBar.o;
                        String str = BaseTransientBottomBar.q;
                        return;
                    }
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    int i2 = marginLayoutParams.bottomMargin;
                    BaseTransientBottomBar baseTransientBottomBar4 = BaseTransientBottomBar.this;
                    marginLayoutParams.bottomMargin = (baseTransientBottomBar4.k - height) + i2;
                    baseTransientBottomBar4.c.requestLayout();
                }
            }
        }
    }

    public class c implements m8 {
        public c() {
        }

        @Override // defpackage.m8
        public c9 a(View view, c9 c9Var) {
            BaseTransientBottomBar.this.h = c9Var.b();
            BaseTransientBottomBar.this.i = c9Var.c();
            BaseTransientBottomBar.this.j = c9Var.d();
            BaseTransientBottomBar.this.h();
            return c9Var;
        }
    }

    public class d extends z7 {
        public d() {
        }

        @Override // defpackage.z7
        public void d(View view, e9 e9Var) {
            this.f4141a.onInitializeAccessibilityNodeInfo(view, e9Var.f942a);
            e9Var.f942a.addAction(CommonUtils.BYTES_IN_A_MEGABYTE);
            e9Var.f942a.setDismissable(true);
        }

        @Override // defpackage.z7
        public boolean g(View view, int i, Bundle bundle) {
            if (i != 1048576) {
                return super.g(view, i, bundle);
            }
            BaseTransientBottomBar.this.a();
            return true;
        }
    }

    public class e implements dp4.b {
        public e() {
        }

        @Override // defpackage.dp4.b
        public void a(int i) {
            Handler handler = BaseTransientBottomBar.o;
            handler.sendMessage(handler.obtainMessage(1, i, 0, BaseTransientBottomBar.this));
        }

        @Override // defpackage.dp4.b
        public void show() {
            Handler handler = BaseTransientBottomBar.o;
            handler.sendMessage(handler.obtainMessage(0, BaseTransientBottomBar.this));
        }
    }

    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public dp4.b f633a;

        public f(SwipeDismissBehavior<?> swipeDismissBehavior) {
            swipeDismissBehavior.f = SwipeDismissBehavior.C(0.0f, 0.1f, 1.0f);
            swipeDismissBehavior.g = SwipeDismissBehavior.C(0.0f, 0.6f, 1.0f);
            swipeDismissBehavior.d = 0;
        }
    }

    public interface g {
    }

    public interface h {
    }

    public static class i extends FrameLayout {
        public static final View.OnTouchListener m = new a();
        public h f;
        public g g;
        public int h;
        public final float i;
        public final float j;
        public ColorStateList k;
        public PorterDuff.Mode l;

        public static class a implements View.OnTouchListener {
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        }

        public i(Context context, AttributeSet attributeSet) {
            super(bq4.a(context, attributeSet, 0, 0), attributeSet);
            Drawable drawable;
            Context context2 = getContext();
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R.styleable.SnackbarLayout);
            int i2 = R.styleable.SnackbarLayout_elevation;
            if (obtainStyledAttributes.hasValue(i2)) {
                AtomicInteger atomicInteger = r8.f3055a;
                setElevation((float) obtainStyledAttributes.getDimensionPixelSize(i2, 0));
            }
            this.h = obtainStyledAttributes.getInt(R.styleable.SnackbarLayout_animationMode, 0);
            this.i = obtainStyledAttributes.getFloat(R.styleable.SnackbarLayout_backgroundOverlayColorAlpha, 1.0f);
            setBackgroundTintList(hd3.h1(context2, obtainStyledAttributes, R.styleable.SnackbarLayout_backgroundTint));
            setBackgroundTintMode(hd3.u2(obtainStyledAttributes.getInt(R.styleable.SnackbarLayout_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN));
            this.j = obtainStyledAttributes.getFloat(R.styleable.SnackbarLayout_actionTextColorAlpha, 1.0f);
            obtainStyledAttributes.recycle();
            setOnTouchListener(m);
            setFocusable(true);
            if (getBackground() == null) {
                float dimension = getResources().getDimension(R.dimen.mtrl_snackbar_background_corner_radius);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setCornerRadius(dimension);
                int i3 = R.attr.colorSurface;
                int i4 = R.attr.colorOnSurface;
                gradientDrawable.setColor(hd3.Z1(hd3.g1(this, i3), hd3.g1(this, i4), getBackgroundOverlayColorAlpha()));
                if (this.k != null) {
                    drawable = defpackage.h.H0(gradientDrawable);
                    drawable.setTintList(this.k);
                } else {
                    drawable = defpackage.h.H0(gradientDrawable);
                }
                AtomicInteger atomicInteger2 = r8.f3055a;
                setBackground(drawable);
            }
        }

        public float getActionTextColorAlpha() {
            return this.j;
        }

        public int getAnimationMode() {
            return this.h;
        }

        public float getBackgroundOverlayColorAlpha() {
            return this.i;
        }

        public void onAttachedToWindow() {
            WindowInsets rootWindowInsets;
            super.onAttachedToWindow();
            g gVar = this.g;
            if (gVar != null) {
                zo4 zo4 = (zo4) gVar;
                Objects.requireNonNull(zo4);
                if (Build.VERSION.SDK_INT >= 29 && (rootWindowInsets = zo4.f4196a.c.getRootWindowInsets()) != null) {
                    zo4.f4196a.k = rootWindowInsets.getMandatorySystemGestureInsets().bottom;
                    zo4.f4196a.h();
                }
            }
            AtomicInteger atomicInteger = r8.f3055a;
            requestApplyInsets();
        }

        public void onDetachedFromWindow() {
            boolean z;
            super.onDetachedFromWindow();
            g gVar = this.g;
            if (gVar != null) {
                zo4 zo4 = (zo4) gVar;
                BaseTransientBottomBar baseTransientBottomBar = zo4.f4196a;
                Objects.requireNonNull(baseTransientBottomBar);
                dp4 b = dp4.b();
                dp4.b bVar = baseTransientBottomBar.n;
                synchronized (b.f875a) {
                    if (!b.c(bVar)) {
                        if (!b.d(bVar)) {
                            z = false;
                        }
                    }
                    z = true;
                }
                if (z) {
                    BaseTransientBottomBar.o.post(new yo4(zo4));
                }
            }
        }

        public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
            super.onLayout(z, i2, i3, i4, i5);
            h hVar = this.f;
            if (hVar != null) {
                ap4 ap4 = (ap4) hVar;
                ap4.f276a.c.setOnLayoutChangeListener(null);
                ap4.f276a.g();
            }
        }

        public void setAnimationMode(int i2) {
            this.h = i2;
        }

        public void setBackground(Drawable drawable) {
            setBackgroundDrawable(drawable);
        }

        public void setBackgroundDrawable(Drawable drawable) {
            if (!(drawable == null || this.k == null)) {
                drawable = defpackage.h.H0(drawable.mutate());
                drawable.setTintList(this.k);
                drawable.setTintMode(this.l);
            }
            super.setBackgroundDrawable(drawable);
        }

        public void setBackgroundTintList(ColorStateList colorStateList) {
            this.k = colorStateList;
            if (getBackground() != null) {
                Drawable H0 = defpackage.h.H0(getBackground().mutate());
                H0.setTintList(colorStateList);
                H0.setTintMode(this.l);
                if (H0 != getBackground()) {
                    super.setBackgroundDrawable(H0);
                }
            }
        }

        public void setBackgroundTintMode(PorterDuff.Mode mode) {
            this.l = mode;
            if (getBackground() != null) {
                Drawable H0 = defpackage.h.H0(getBackground().mutate());
                H0.setTintMode(mode);
                if (H0 != getBackground()) {
                    super.setBackgroundDrawable(H0);
                }
            }
        }

        public void setOnAttachStateChangeListener(g gVar) {
            this.g = gVar;
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            setOnTouchListener(onClickListener != null ? null : m);
            super.setOnClickListener(onClickListener);
        }

        public void setOnLayoutChangeListener(h hVar) {
            this.f = hVar;
        }
    }

    public BaseTransientBottomBar(Context context, ViewGroup viewGroup, View view, cp4 cp4) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
        } else if (view == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null content");
        } else if (cp4 != null) {
            this.f630a = viewGroup;
            this.d = cp4;
            this.b = context;
            mn4.c(context, mn4.f2410a, "Theme.AppCompat");
            LayoutInflater from = LayoutInflater.from(context);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(p);
            int resourceId = obtainStyledAttributes.getResourceId(0, -1);
            obtainStyledAttributes.recycle();
            i iVar = (i) from.inflate(resourceId != -1 ? R.layout.mtrl_layout_snackbar : R.layout.design_layout_snackbar, viewGroup, false);
            this.c = iVar;
            if (view instanceof SnackbarContentLayout) {
                SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) view;
                float actionTextColorAlpha = iVar.getActionTextColorAlpha();
                if (actionTextColorAlpha != 1.0f) {
                    snackbarContentLayout.g.setTextColor(hd3.Z1(hd3.g1(snackbarContentLayout, R.attr.colorSurface), snackbarContentLayout.g.getCurrentTextColor(), actionTextColorAlpha));
                }
            }
            iVar.addView(view);
            ViewGroup.LayoutParams layoutParams = iVar.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                this.g = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            }
            AtomicInteger atomicInteger = r8.f3055a;
            iVar.setAccessibilityLiveRegion(1);
            iVar.setImportantForAccessibility(1);
            iVar.setFitsSystemWindows(true);
            r8.w(iVar, new c());
            r8.v(iVar, new d());
            this.m = (AccessibilityManager) context.getSystemService("accessibility");
        } else {
            throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
        }
    }

    public void a() {
        b(3);
    }

    public void b(int i2) {
        dp4 b2 = dp4.b();
        dp4.b bVar = this.n;
        synchronized (b2.f875a) {
            if (b2.c(bVar)) {
                b2.a(b2.c, i2);
            } else if (b2.d(bVar)) {
                b2.a(b2.d, i2);
            }
        }
    }

    public final int c() {
        int height = this.c.getHeight();
        ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? height + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
    }

    public void d(int i2) {
        dp4 b2 = dp4.b();
        dp4.b bVar = this.n;
        synchronized (b2.f875a) {
            if (b2.c(bVar)) {
                b2.c = null;
                if (b2.d != null) {
                    b2.h();
                }
            }
        }
        ViewParent parent = this.c.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.c);
        }
    }

    public void e() {
        dp4 b2 = dp4.b();
        dp4.b bVar = this.n;
        synchronized (b2.f875a) {
            if (b2.c(bVar)) {
                b2.g(b2.c);
            }
        }
    }

    public boolean f() {
        AccessibilityManager accessibilityManager = this.m;
        if (accessibilityManager == null) {
            return true;
        }
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(1);
        if (enabledAccessibilityServiceList == null || !enabledAccessibilityServiceList.isEmpty()) {
            return false;
        }
        return true;
    }

    public final void g() {
        if (f()) {
            this.c.post(new po4(this));
            return;
        }
        if (this.c.getParent() != null) {
            this.c.setVisibility(0);
        }
        e();
    }

    public final void h() {
        Rect rect;
        ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
        if ((layoutParams instanceof ViewGroup.MarginLayoutParams) && (rect = this.g) != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = rect.bottom + this.h;
            marginLayoutParams.leftMargin = rect.left + this.i;
            marginLayoutParams.rightMargin = rect.right + this.j;
            this.c.requestLayout();
            if (Build.VERSION.SDK_INT >= 29) {
                boolean z = false;
                if (this.k > 0) {
                    ViewGroup.LayoutParams layoutParams2 = this.c.getLayoutParams();
                    if ((layoutParams2 instanceof CoordinatorLayout.f) && (((CoordinatorLayout.f) layoutParams2).f201a instanceof SwipeDismissBehavior)) {
                        z = true;
                    }
                }
                if (z) {
                    this.c.removeCallbacks(this.f);
                    this.c.post(this.f);
                }
            }
        }
    }
}
