package androidx.drawerlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.customview.view.AbsSavedState;
import defpackage.e9;
import defpackage.fa;
import defpackage.g9;
import defpackage.q5;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class DrawerLayout extends ViewGroup implements ea {
    public static final int[] I = {16843828};
    public static final int[] J = {16842931};
    public static final boolean K = true;
    public static final boolean L = true;
    public static boolean M;
    public float A;
    public Drawable B;
    public Object C;
    public boolean D;
    public final ArrayList<View> E;
    public Rect F;
    public Matrix G;
    public final g9 H = new a();
    public final c f = new c();
    public float g;
    public int h;
    public int i = -1728053248;
    public float j;
    public Paint k = new Paint();
    public final fa l;
    public final fa m;
    public final f n;
    public final f o;
    public int p;
    public boolean q;
    public boolean r = true;
    public int s = 3;
    public int t = 3;
    public int u = 3;
    public int v = 3;
    public boolean w;
    public d x;
    public List<d> y;
    public float z;

    public class a implements g9 {
        public a() {
        }

        @Override // defpackage.g9
        public boolean a(View view, g9.a aVar) {
            if (!DrawerLayout.this.m(view) || DrawerLayout.this.h(view) == 2) {
                return false;
            }
            DrawerLayout.this.c(view);
            return true;
        }
    }

    public class b extends z7 {
        public final Rect d = new Rect();

        public b() {
        }

        @Override // defpackage.z7
        public boolean a(View view, AccessibilityEvent accessibilityEvent) {
            if (accessibilityEvent.getEventType() != 32) {
                return this.f4141a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
            }
            accessibilityEvent.getText();
            View g = DrawerLayout.this.g();
            if (g == null) {
                return true;
            }
            int i = DrawerLayout.this.i(g);
            DrawerLayout drawerLayout = DrawerLayout.this;
            Objects.requireNonNull(drawerLayout);
            AtomicInteger atomicInteger = r8.f3055a;
            Gravity.getAbsoluteGravity(i, drawerLayout.getLayoutDirection());
            return true;
        }

        @Override // defpackage.z7
        public void c(View view, AccessibilityEvent accessibilityEvent) {
            this.f4141a.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName("androidx.drawerlayout.widget.DrawerLayout");
        }

        @Override // defpackage.z7
        public void d(View view, e9 e9Var) {
            if (DrawerLayout.K) {
                this.f4141a.onInitializeAccessibilityNodeInfo(view, e9Var.f942a);
            } else {
                AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain(e9Var.f942a);
                this.f4141a.onInitializeAccessibilityNodeInfo(view, obtain);
                e9Var.c = -1;
                e9Var.f942a.setSource(view);
                AtomicInteger atomicInteger = r8.f3055a;
                ViewParent parentForAccessibility = view.getParentForAccessibility();
                if (parentForAccessibility instanceof View) {
                    e9Var.p((View) parentForAccessibility);
                }
                Rect rect = this.d;
                obtain.getBoundsInScreen(rect);
                e9Var.f942a.setBoundsInScreen(rect);
                e9Var.f942a.setVisibleToUser(obtain.isVisibleToUser());
                e9Var.f942a.setPackageName(obtain.getPackageName());
                e9Var.f942a.setClassName(obtain.getClassName());
                e9Var.f942a.setContentDescription(obtain.getContentDescription());
                e9Var.f942a.setEnabled(obtain.isEnabled());
                e9Var.f942a.setFocused(obtain.isFocused());
                e9Var.f942a.setAccessibilityFocused(obtain.isAccessibilityFocused());
                e9Var.f942a.setSelected(obtain.isSelected());
                e9Var.f942a.addAction(obtain.getActions());
                obtain.recycle();
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = viewGroup.getChildAt(i);
                    if (DrawerLayout.k(childAt)) {
                        e9Var.f942a.addChild(childAt);
                    }
                }
            }
            e9Var.f942a.setClassName("androidx.drawerlayout.widget.DrawerLayout");
            e9Var.f942a.setFocusable(false);
            e9Var.f942a.setFocused(false);
            e9Var.k(e9.a.e);
            e9Var.k(e9.a.f);
        }

        @Override // defpackage.z7
        public boolean f(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (DrawerLayout.K || DrawerLayout.k(view)) {
                return this.f4141a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return false;
        }
    }

    public static final class c extends z7 {
        @Override // defpackage.z7
        public void d(View view, e9 e9Var) {
            this.f4141a.onInitializeAccessibilityNodeInfo(view, e9Var.f942a);
            if (!DrawerLayout.k(view)) {
                e9Var.p(null);
            }
        }
    }

    public interface d {
        void a(View view);

        void b(View view);

        void c(int i);

        void d(View view, float f);
    }

    public class f extends fa.c {

        /* renamed from: a  reason: collision with root package name */
        public final int f207a;
        public fa b;
        public final Runnable c = new a();

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                int i;
                View view;
                f fVar = f.this;
                int i2 = fVar.b.o;
                boolean z = fVar.f207a == 3;
                if (z) {
                    view = DrawerLayout.this.e(3);
                    i = (view != null ? -view.getWidth() : 0) + i2;
                } else {
                    view = DrawerLayout.this.e(5);
                    i = DrawerLayout.this.getWidth() - i2;
                }
                if (view == null) {
                    return;
                }
                if (((z && view.getLeft() < i) || (!z && view.getLeft() > i)) && DrawerLayout.this.h(view) == 0) {
                    fVar.b.y(view, i, view.getTop());
                    ((e) view.getLayoutParams()).c = true;
                    DrawerLayout.this.invalidate();
                    fVar.m();
                    DrawerLayout drawerLayout = DrawerLayout.this;
                    if (!drawerLayout.w) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                        int childCount = drawerLayout.getChildCount();
                        for (int i3 = 0; i3 < childCount; i3++) {
                            drawerLayout.getChildAt(i3).dispatchTouchEvent(obtain);
                        }
                        obtain.recycle();
                        drawerLayout.w = true;
                    }
                }
            }
        }

        public f(int i) {
            this.f207a = i;
        }

        @Override // defpackage.fa.c
        public int a(View view, int i, int i2) {
            if (DrawerLayout.this.b(view, 3)) {
                return Math.max(-view.getWidth(), Math.min(i, 0));
            }
            int width = DrawerLayout.this.getWidth();
            return Math.max(width - view.getWidth(), Math.min(i, width));
        }

        @Override // defpackage.fa.c
        public int b(View view, int i, int i2) {
            return view.getTop();
        }

        @Override // defpackage.fa.c
        public int c(View view) {
            if (DrawerLayout.this.n(view)) {
                return view.getWidth();
            }
            return 0;
        }

        @Override // defpackage.fa.c
        public void e(int i, int i2) {
            View view;
            if ((i & 1) == 1) {
                view = DrawerLayout.this.e(3);
            } else {
                view = DrawerLayout.this.e(5);
            }
            if (view != null && DrawerLayout.this.h(view) == 0) {
                this.b.b(view, i2);
            }
        }

        @Override // defpackage.fa.c
        public boolean f(int i) {
            return false;
        }

        @Override // defpackage.fa.c
        public void g(int i, int i2) {
            DrawerLayout.this.postDelayed(this.c, 160);
        }

        @Override // defpackage.fa.c
        public void h(View view, int i) {
            ((e) view.getLayoutParams()).c = false;
            m();
        }

        @Override // defpackage.fa.c
        public void i(int i) {
            DrawerLayout.this.v(i, this.b.t);
        }

        @Override // defpackage.fa.c
        public void j(View view, int i, int i2, int i3, int i4) {
            float f;
            int width = view.getWidth();
            if (DrawerLayout.this.b(view, 3)) {
                f = (float) (i + width);
            } else {
                f = (float) (DrawerLayout.this.getWidth() - i);
            }
            float f2 = f / ((float) width);
            DrawerLayout.this.s(view, f2);
            view.setVisibility(f2 == 0.0f ? 4 : 0);
            DrawerLayout.this.invalidate();
        }

        @Override // defpackage.fa.c
        public void k(View view, float f, float f2) {
            int i;
            Objects.requireNonNull(DrawerLayout.this);
            float f3 = ((e) view.getLayoutParams()).b;
            int width = view.getWidth();
            if (DrawerLayout.this.b(view, 3)) {
                int i2 = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
                i = (i2 > 0 || (i2 == 0 && f3 > 0.5f)) ? 0 : -width;
            } else {
                int width2 = DrawerLayout.this.getWidth();
                if (f < 0.0f || (f == 0.0f && f3 > 0.5f)) {
                    width2 -= width;
                }
                i = width2;
            }
            this.b.w(i, view.getTop());
            DrawerLayout.this.invalidate();
        }

        @Override // defpackage.fa.c
        public boolean l(View view, int i) {
            return DrawerLayout.this.n(view) && DrawerLayout.this.b(view, this.f207a) && DrawerLayout.this.h(view) == 0;
        }

        public final void m() {
            int i = 3;
            if (this.f207a == 3) {
                i = 5;
            }
            View e = DrawerLayout.this.e(i);
            if (e != null) {
                DrawerLayout.this.c(e);
            }
        }

        public void n() {
            DrawerLayout.this.removeCallbacks(this.c);
        }
    }

    static {
        boolean z2 = true;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 29) {
            z2 = false;
        }
        M = z2;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DrawerLayout(android.content.Context r8, android.util.AttributeSet r9) {
        /*
        // Method dump skipped, instructions count: 223
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    public static String j(int i2) {
        if ((i2 & 3) == 3) {
            return "LEFT";
        }
        return (i2 & 5) == 5 ? "RIGHT" : Integer.toHexString(i2);
    }

    public static boolean k(View view) {
        AtomicInteger atomicInteger = r8.f3055a;
        return (view.getImportantForAccessibility() == 4 || view.getImportantForAccessibility() == 2) ? false : true;
    }

    @Override // defpackage.ea
    public void a() {
        p(8388611, true);
    }

    @Override // android.view.View, android.view.ViewGroup
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        if (getDescendantFocusability() != 393216) {
            int childCount = getChildCount();
            boolean z2 = false;
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (!n(childAt)) {
                    this.E.add(childAt);
                } else if (m(childAt)) {
                    childAt.addFocusables(arrayList, i2, i3);
                    z2 = true;
                }
            }
            if (!z2) {
                int size = this.E.size();
                for (int i5 = 0; i5 < size; i5++) {
                    View view = this.E.get(i5);
                    if (view.getVisibility() == 0) {
                        view.addFocusables(arrayList, i2, i3);
                    }
                }
            }
            this.E.clear();
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
        if (f() != null || n(view)) {
            AtomicInteger atomicInteger = r8.f3055a;
            view.setImportantForAccessibility(4);
        } else {
            AtomicInteger atomicInteger2 = r8.f3055a;
            view.setImportantForAccessibility(1);
        }
        if (!K) {
            r8.v(view, this.f);
        }
    }

    public boolean b(View view, int i2) {
        return (i(view) & i2) == i2;
    }

    public void c(View view) {
        if (n(view)) {
            e eVar = (e) view.getLayoutParams();
            if (this.r) {
                eVar.b = 0.0f;
                eVar.d = 0;
            } else {
                eVar.d |= 4;
                if (b(view, 3)) {
                    this.l.y(view, -view.getWidth(), view.getTop());
                } else {
                    this.m.y(view, getWidth(), view.getTop());
                }
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof e) && super.checkLayoutParams(layoutParams);
    }

    public void computeScroll() {
        int childCount = getChildCount();
        float f2 = 0.0f;
        for (int i2 = 0; i2 < childCount; i2++) {
            f2 = Math.max(f2, ((e) getChildAt(i2).getLayoutParams()).b);
        }
        this.j = f2;
        boolean j2 = this.l.j(true);
        boolean j3 = this.m.j(true);
        if (j2 || j3) {
            AtomicInteger atomicInteger = r8.f3055a;
            postInvalidateOnAnimation();
        }
    }

    public void d(boolean z2) {
        boolean z3;
        int childCount = getChildCount();
        boolean z4 = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            e eVar = (e) childAt.getLayoutParams();
            if (n(childAt) && (!z2 || eVar.c)) {
                int width = childAt.getWidth();
                if (b(childAt, 3)) {
                    z3 = this.l.y(childAt, -width, childAt.getTop());
                } else {
                    z3 = this.m.y(childAt, getWidth(), childAt.getTop());
                }
                z4 |= z3;
                eVar.c = false;
            }
        }
        this.n.n();
        this.o.n();
        if (z4) {
            invalidate();
        }
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        boolean z2;
        if ((motionEvent.getSource() & 2) == 0 || motionEvent.getAction() == 10 || this.j <= 0.0f) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        int childCount = getChildCount();
        if (childCount == 0) {
            return false;
        }
        float x2 = motionEvent.getX();
        float y2 = motionEvent.getY();
        for (int i2 = childCount - 1; i2 >= 0; i2--) {
            View childAt = getChildAt(i2);
            if (this.F == null) {
                this.F = new Rect();
            }
            childAt.getHitRect(this.F);
            if (this.F.contains((int) x2, (int) y2) && !l(childAt)) {
                if (!childAt.getMatrix().isIdentity()) {
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    obtain.offsetLocation((float) (getScrollX() - childAt.getLeft()), (float) (getScrollY() - childAt.getTop()));
                    Matrix matrix = childAt.getMatrix();
                    if (!matrix.isIdentity()) {
                        if (this.G == null) {
                            this.G = new Matrix();
                        }
                        matrix.invert(this.G);
                        obtain.transform(this.G);
                    }
                    z2 = childAt.dispatchGenericMotionEvent(obtain);
                    obtain.recycle();
                } else {
                    float scrollX = (float) (getScrollX() - childAt.getLeft());
                    float scrollY = (float) (getScrollY() - childAt.getTop());
                    motionEvent.offsetLocation(scrollX, scrollY);
                    z2 = childAt.dispatchGenericMotionEvent(motionEvent);
                    motionEvent.offsetLocation(-scrollX, -scrollY);
                }
                if (z2) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean drawChild(Canvas canvas, View view, long j2) {
        int height = getHeight();
        boolean l2 = l(view);
        int width = getWidth();
        int save = canvas.save();
        int i2 = 0;
        if (l2) {
            int childCount = getChildCount();
            int i3 = 0;
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (childAt != view && childAt.getVisibility() == 0) {
                    Drawable background = childAt.getBackground();
                    if ((background != null && background.getOpacity() == -1) && n(childAt) && childAt.getHeight() >= height) {
                        if (b(childAt, 3)) {
                            int right = childAt.getRight();
                            if (right > i3) {
                                i3 = right;
                            }
                        } else {
                            int left = childAt.getLeft();
                            if (left < width) {
                                width = left;
                            }
                        }
                    }
                }
            }
            canvas.clipRect(i3, 0, width, getHeight());
            i2 = i3;
        }
        boolean drawChild = super.drawChild(canvas, view, j2);
        canvas.restoreToCount(save);
        float f2 = this.j;
        if (f2 > 0.0f && l2) {
            int i5 = this.i;
            this.k.setColor((((int) (((float) ((-16777216 & i5) >>> 24)) * f2)) << 24) | (i5 & 16777215));
            canvas.drawRect((float) i2, 0.0f, (float) width, (float) getHeight(), this.k);
        }
        return drawChild;
    }

    public View e(int i2) {
        AtomicInteger atomicInteger = r8.f3055a;
        int absoluteGravity = Gravity.getAbsoluteGravity(i2, getLayoutDirection()) & 7;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if ((i(childAt) & 7) == absoluteGravity) {
                return childAt;
            }
        }
        return null;
    }

    public View f() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((((e) childAt.getLayoutParams()).d & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    public View g() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (n(childAt)) {
                if (n(childAt)) {
                    if (((e) childAt.getLayoutParams()).b > 0.0f) {
                        return childAt;
                    }
                } else {
                    throw new IllegalArgumentException("View " + childAt + " is not a drawer");
                }
            }
        }
        return null;
    }

    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new e(-1, -1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof e) {
            return new e((e) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new e((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new e(layoutParams);
    }

    public float getDrawerElevation() {
        if (L) {
            return this.g;
        }
        return 0.0f;
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.B;
    }

    public int h(View view) {
        if (n(view)) {
            int i2 = ((e) view.getLayoutParams()).f206a;
            AtomicInteger atomicInteger = r8.f3055a;
            int layoutDirection = getLayoutDirection();
            if (i2 == 3) {
                int i3 = this.s;
                if (i3 != 3) {
                    return i3;
                }
                int i4 = layoutDirection == 0 ? this.u : this.v;
                if (i4 != 3) {
                    return i4;
                }
            } else if (i2 == 5) {
                int i5 = this.t;
                if (i5 != 3) {
                    return i5;
                }
                int i6 = layoutDirection == 0 ? this.v : this.u;
                if (i6 != 3) {
                    return i6;
                }
            } else if (i2 == 8388611) {
                int i7 = this.u;
                if (i7 != 3) {
                    return i7;
                }
                int i8 = layoutDirection == 0 ? this.s : this.t;
                if (i8 != 3) {
                    return i8;
                }
            } else if (i2 == 8388613) {
                int i9 = this.v;
                if (i9 != 3) {
                    return i9;
                }
                int i10 = layoutDirection == 0 ? this.t : this.s;
                if (i10 != 3) {
                    return i10;
                }
            }
            return 0;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public int i(View view) {
        int i2 = ((e) view.getLayoutParams()).f206a;
        AtomicInteger atomicInteger = r8.f3055a;
        return Gravity.getAbsoluteGravity(i2, getLayoutDirection());
    }

    public boolean l(View view) {
        return ((e) view.getLayoutParams()).f206a == 0;
    }

    public boolean m(View view) {
        if (n(view)) {
            return (((e) view.getLayoutParams()).d & 1) == 1;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public boolean n(View view) {
        int i2 = ((e) view.getLayoutParams()).f206a;
        AtomicInteger atomicInteger = r8.f3055a;
        int absoluteGravity = Gravity.getAbsoluteGravity(i2, view.getLayoutDirection());
        return ((absoluteGravity & 3) == 0 && (absoluteGravity & 5) == 0) ? false : true;
    }

    public void o(View view, float f2) {
        float f3 = ((e) view.getLayoutParams()).b;
        float width = (float) view.getWidth();
        int i2 = ((int) (width * f2)) - ((int) (f3 * width));
        if (!b(view, 3)) {
            i2 = -i2;
        }
        view.offsetLeftAndRight(i2);
        s(view, f2);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.r = true;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.r = true;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.D && this.B != null) {
            Object obj = this.C;
            int systemWindowInsetTop = obj != null ? ((WindowInsets) obj).getSystemWindowInsetTop() : 0;
            if (systemWindowInsetTop > 0) {
                this.B.setBounds(0, 0, getWidth(), systemWindowInsetTop);
                this.B.draw(canvas);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001b, code lost:
        if (r0 != 3) goto L_0x0036;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r7) {
        /*
        // Method dump skipped, instructions count: 136
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            if (g() != null) {
                keyEvent.startTracking();
                return true;
            }
        }
        return super.onKeyDown(i2, keyEvent);
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            return super.onKeyUp(i2, keyEvent);
        }
        View g2 = g();
        if (g2 != null && h(g2) == 0) {
            d(false);
        }
        if (g2 != null) {
            return true;
        }
        return false;
    }

    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        WindowInsets rootWindowInsets;
        float f2;
        int i6;
        this.q = true;
        int i7 = i4 - i2;
        int childCount = getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (l(childAt)) {
                    int i9 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin;
                    childAt.layout(i9, ((ViewGroup.MarginLayoutParams) eVar).topMargin, childAt.getMeasuredWidth() + i9, childAt.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar).topMargin);
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (b(childAt, 3)) {
                        float f3 = (float) measuredWidth;
                        i6 = (-measuredWidth) + ((int) (eVar.b * f3));
                        f2 = ((float) (measuredWidth + i6)) / f3;
                    } else {
                        float f4 = (float) measuredWidth;
                        int i10 = i7 - ((int) (eVar.b * f4));
                        f2 = ((float) (i7 - i10)) / f4;
                        i6 = i10;
                    }
                    boolean z3 = f2 != eVar.b;
                    int i11 = eVar.f206a & 112;
                    if (i11 == 16) {
                        int i12 = i5 - i3;
                        int i13 = (i12 - measuredHeight) / 2;
                        int i14 = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
                        if (i13 < i14) {
                            i13 = i14;
                        } else {
                            int i15 = i13 + measuredHeight;
                            int i16 = i12 - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
                            if (i15 > i16) {
                                i13 = i16 - measuredHeight;
                            }
                        }
                        childAt.layout(i6, i13, measuredWidth + i6, measuredHeight + i13);
                    } else if (i11 != 80) {
                        int i17 = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
                        childAt.layout(i6, i17, measuredWidth + i6, measuredHeight + i17);
                    } else {
                        int i18 = i5 - i3;
                        childAt.layout(i6, (i18 - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i6, i18 - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin);
                    }
                    if (z3) {
                        s(childAt, f2);
                    }
                    int i19 = eVar.b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i19) {
                        childAt.setVisibility(i19);
                    }
                }
            }
        }
        if (M && (rootWindowInsets = getRootWindowInsets()) != null) {
            b6 i20 = c9.k(rootWindowInsets, null).f535a.i();
            fa faVar = this.l;
            faVar.o = Math.max(faVar.p, i20.f386a);
            fa faVar2 = this.m;
            faVar2.o = Math.max(faVar2.p, i20.c);
        }
        this.q = false;
        this.r = false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0048  */
    @android.annotation.SuppressLint({"WrongConstant"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r17, int r18) {
        /*
        // Method dump skipped, instructions count: 427
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onMeasure(int, int):void");
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        View e2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        int i2 = savedState.f;
        if (!(i2 == 0 || (e2 = e(i2)) == null)) {
            q(e2, true);
        }
        int i3 = savedState.g;
        if (i3 != 3) {
            r(i3, 3);
        }
        int i4 = savedState.h;
        if (i4 != 3) {
            r(i4, 5);
        }
        int i5 = savedState.i;
        if (i5 != 3) {
            r(i5, 8388611);
        }
        int i6 = savedState.j;
        if (i6 != 3) {
            r(i6, 8388613);
        }
    }

    public void onRtlPropertiesChanged(int i2) {
        if (!L) {
            AtomicInteger atomicInteger = r8.f3055a;
            getLayoutDirection();
            getLayoutDirection();
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        int i2 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            e eVar = (e) getChildAt(i2).getLayoutParams();
            int i3 = eVar.d;
            boolean z2 = true;
            boolean z3 = i3 == 1;
            if (i3 != 2) {
                z2 = false;
            }
            if (z3 || z2) {
                savedState.f = eVar.f206a;
            } else {
                i2++;
            }
        }
        savedState.g = this.s;
        savedState.h = this.t;
        savedState.i = this.u;
        savedState.j = this.v;
        return savedState;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0059, code lost:
        if (h(r7) != 2) goto L_0x005c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
        // Method dump skipped, instructions count: 111
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void p(int i2, boolean z2) {
        View e2 = e(i2);
        if (e2 != null) {
            q(e2, z2);
            return;
        }
        StringBuilder i0 = hj1.i0("No drawer view found with gravity ");
        i0.append(j(i2));
        throw new IllegalArgumentException(i0.toString());
    }

    public void q(View view, boolean z2) {
        if (n(view)) {
            e eVar = (e) view.getLayoutParams();
            if (this.r) {
                eVar.b = 1.0f;
                eVar.d = 1;
                u(view, true);
                t(view);
            } else if (z2) {
                eVar.d |= 2;
                if (b(view, 3)) {
                    this.l.y(view, 0, view.getTop());
                } else {
                    this.m.y(view, getWidth() - view.getWidth(), view.getTop());
                }
            } else {
                o(view, 1.0f);
                v(0, view);
                view.setVisibility(0);
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public void r(int i2, int i3) {
        View e2;
        AtomicInteger atomicInteger = r8.f3055a;
        int absoluteGravity = Gravity.getAbsoluteGravity(i3, getLayoutDirection());
        if (i3 == 3) {
            this.s = i2;
        } else if (i3 == 5) {
            this.t = i2;
        } else if (i3 == 8388611) {
            this.u = i2;
        } else if (i3 == 8388613) {
            this.v = i2;
        }
        if (i2 != 0) {
            (absoluteGravity == 3 ? this.l : this.m).a();
        }
        if (i2 == 1) {
            View e3 = e(absoluteGravity);
            if (e3 != null) {
                c(e3);
            }
        } else if (i2 == 2 && (e2 = e(absoluteGravity)) != null) {
            q(e2, true);
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z2) {
        super.requestDisallowInterceptTouchEvent(z2);
        if (z2) {
            d(true);
        }
    }

    public void requestLayout() {
        if (!this.q) {
            super.requestLayout();
        }
    }

    public void s(View view, float f2) {
        e eVar = (e) view.getLayoutParams();
        if (f2 != eVar.b) {
            eVar.b = f2;
            List<d> list = this.y;
            if (list != null) {
                int size = list.size();
                while (true) {
                    size--;
                    if (size >= 0) {
                        this.y.get(size).d(view, f2);
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public void setDrawerElevation(float f2) {
        this.g = f2;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (n(childAt)) {
                float f3 = this.g;
                AtomicInteger atomicInteger = r8.f3055a;
                childAt.setElevation(f3);
            }
        }
    }

    @Deprecated
    public void setDrawerListener(d dVar) {
        List<d> list;
        d dVar2 = this.x;
        if (!(dVar2 == null || dVar2 == null || (list = this.y) == null)) {
            list.remove(dVar2);
        }
        if (dVar != null) {
            if (this.y == null) {
                this.y = new ArrayList();
            }
            this.y.add(dVar);
        }
        this.x = dVar;
    }

    public void setDrawerLockMode(int i2) {
        r(i2, 3);
        r(i2, 5);
    }

    public void setScrimColor(int i2) {
        this.i = i2;
        invalidate();
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.B = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i2) {
        this.B = new ColorDrawable(i2);
        invalidate();
    }

    public final void t(View view) {
        e9.a aVar = e9.a.l;
        r8.s(aVar.a(), view);
        r8.m(view, 0);
        if (m(view) && h(view) != 2) {
            r8.t(view, aVar, null, this.H);
        }
    }

    public final void u(View view, boolean z2) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((z2 || n(childAt)) && (!z2 || childAt != view)) {
                AtomicInteger atomicInteger = r8.f3055a;
                childAt.setImportantForAccessibility(4);
            } else {
                AtomicInteger atomicInteger2 = r8.f3055a;
                childAt.setImportantForAccessibility(1);
            }
        }
    }

    public void v(int i2, View view) {
        View rootView;
        int i3 = this.l.f1107a;
        int i4 = this.m.f1107a;
        int i5 = 2;
        if (i3 == 1 || i4 == 1) {
            i5 = 1;
        } else if (!(i3 == 2 || i4 == 2)) {
            i5 = 0;
        }
        if (view != null && i2 == 0) {
            float f2 = ((e) view.getLayoutParams()).b;
            if (f2 == 0.0f) {
                e eVar = (e) view.getLayoutParams();
                if ((eVar.d & 1) == 1) {
                    eVar.d = 0;
                    List<d> list = this.y;
                    if (list != null) {
                        for (int size = list.size() - 1; size >= 0; size--) {
                            this.y.get(size).b(view);
                        }
                    }
                    u(view, false);
                    t(view);
                    if (hasWindowFocus() && (rootView = getRootView()) != null) {
                        rootView.sendAccessibilityEvent(32);
                    }
                }
            } else if (f2 == 1.0f) {
                e eVar2 = (e) view.getLayoutParams();
                if ((eVar2.d & 1) == 0) {
                    eVar2.d = 1;
                    List<d> list2 = this.y;
                    if (list2 != null) {
                        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
                            this.y.get(size2).a(view);
                        }
                    }
                    u(view, true);
                    t(view);
                    if (hasWindowFocus()) {
                        sendAccessibilityEvent(32);
                    }
                }
            }
        }
        if (i5 != this.p) {
            this.p = i5;
            List<d> list3 = this.y;
            if (list3 != null) {
                for (int size3 = list3.size() - 1; size3 >= 0; size3--) {
                    this.y.get(size3).c(i5);
                }
            }
        }
    }

    public void setStatusBarBackground(int i2) {
        Drawable drawable;
        if (i2 != 0) {
            Context context = getContext();
            Object obj = q5.f2896a;
            drawable = q5.c.b(context, i2);
        } else {
            drawable = null;
        }
        this.B = drawable;
        invalidate();
    }

    public static class e extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f206a = 0;
        public float b;
        public boolean c;
        public int d;

        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.J);
            this.f206a = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public e(int i, int i2) {
            super(i, i2);
        }

        public e(e eVar) {
            super((ViewGroup.MarginLayoutParams) eVar);
            this.f206a = eVar.f206a;
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public int f = 0;
        public int g;
        public int h;
        public int i;
        public int j;

        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
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

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f = parcel.readInt();
            this.g = parcel.readInt();
            this.h = parcel.readInt();
            this.i = parcel.readInt();
            this.j = parcel.readInt();
        }

        @Override // androidx.customview.view.AbsSavedState
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f);
            parcel.writeInt(this.g);
            parcel.writeInt(this.h);
            parcel.writeInt(this.i);
            parcel.writeInt(this.j);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }
}
