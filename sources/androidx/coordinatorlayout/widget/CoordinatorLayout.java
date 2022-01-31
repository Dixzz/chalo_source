package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.R;
import androidx.customview.view.AbsSavedState;
import com.google.firebase.perf.util.Constants;
import defpackage.q5;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class CoordinatorLayout extends ViewGroup implements j8, k8 {
    public static final Class<?>[] A = {Context.class, AttributeSet.class};
    public static final ThreadLocal<Map<String, Constructor<c>>> B = new ThreadLocal<>();
    public static final Comparator<View> C = new h();
    public static final v7<Rect> D = new x7(12);
    public static final String z;
    public final List<View> f = new ArrayList();
    public final r4<View> g = new r4<>();
    public final List<View> h = new ArrayList();
    public final List<View> i = new ArrayList();
    public Paint j;
    public final int[] k = new int[2];
    public final int[] l = new int[2];
    public boolean m;
    public boolean n;
    public int[] o;
    public View p;
    public View q;
    public g r;
    public boolean s;
    public c9 t;
    public boolean u;
    public Drawable v;
    public ViewGroup.OnHierarchyChangeListener w;
    public m8 x;
    public final l8 y = new l8();

    public class a implements m8 {
        public a() {
        }

        @Override // defpackage.m8
        public c9 a(View view, c9 c9Var) {
            c cVar;
            CoordinatorLayout coordinatorLayout = CoordinatorLayout.this;
            if (!Objects.equals(coordinatorLayout.t, c9Var)) {
                coordinatorLayout.t = c9Var;
                boolean z = true;
                boolean z2 = c9Var.e() > 0;
                coordinatorLayout.u = z2;
                if (z2 || coordinatorLayout.getBackground() != null) {
                    z = false;
                }
                coordinatorLayout.setWillNotDraw(z);
                if (!c9Var.g()) {
                    int childCount = coordinatorLayout.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        View childAt = coordinatorLayout.getChildAt(i);
                        AtomicInteger atomicInteger = r8.f3055a;
                        if (childAt.getFitsSystemWindows() && (cVar = ((f) childAt.getLayoutParams()).f201a) != null) {
                            c9Var = cVar.e(c9Var);
                            if (c9Var.g()) {
                                break;
                            }
                        }
                    }
                }
                coordinatorLayout.requestLayout();
            }
            return c9Var;
        }
    }

    public interface b {
        c getBehavior();
    }

    public static abstract class c<V extends View> {
        public c() {
        }

        public boolean A(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, Rect rect) {
            return false;
        }

        /* JADX WARN: Incorrect args count in method signature: (Landroidx/coordinatorlayout/widget/CoordinatorLayout;TV;)I */
        public int b() {
            return -16777216;
        }

        /* JADX WARN: Incorrect args count in method signature: (Landroidx/coordinatorlayout/widget/CoordinatorLayout;TV;)F */
        public float c() {
            return 0.0f;
        }

        public boolean d(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        /* JADX WARN: Incorrect args count in method signature: (Landroidx/coordinatorlayout/widget/CoordinatorLayout;TV;Lc9;)Lc9; */
        public c9 e(c9 c9Var) {
            return c9Var;
        }

        public void f(f fVar) {
        }

        public boolean g(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public void h(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public void i() {
        }

        public boolean j(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean k(CoordinatorLayout coordinatorLayout, V v, int i) {
            return false;
        }

        public boolean l(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3, int i4) {
            return false;
        }

        /* JADX WARN: Incorrect args count in method signature: (Landroidx/coordinatorlayout/widget/CoordinatorLayout;TV;Landroid/view/View;FFZ)Z */
        public boolean m() {
            return false;
        }

        public boolean n(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
            return false;
        }

        /* JADX WARN: Incorrect args count in method signature: (Landroidx/coordinatorlayout/widget/CoordinatorLayout;TV;Landroid/view/View;II[I)V */
        @Deprecated
        public void o() {
        }

        public void p(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr, int i3) {
            if (i3 == 0) {
                o();
            }
        }

        /* JADX WARN: Incorrect args count in method signature: (Landroidx/coordinatorlayout/widget/CoordinatorLayout;TV;Landroid/view/View;IIII)V */
        @Deprecated
        public void q() {
        }

        public void r(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
            iArr[0] = iArr[0] + i3;
            iArr[1] = iArr[1] + i4;
            if (i5 == 0) {
                q();
            }
        }

        /* JADX WARN: Incorrect args count in method signature: (Landroidx/coordinatorlayout/widget/CoordinatorLayout;TV;Landroid/view/View;Landroid/view/View;I)V */
        @Deprecated
        public void s() {
        }

        public boolean t(CoordinatorLayout coordinatorLayout, V v, Rect rect, boolean z) {
            return false;
        }

        public void u(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        }

        public Parcelable v(CoordinatorLayout coordinatorLayout, V v) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        /* JADX WARN: Incorrect args count in method signature: (Landroidx/coordinatorlayout/widget/CoordinatorLayout;TV;Landroid/view/View;Landroid/view/View;I)Z */
        @Deprecated
        public boolean w() {
            return false;
        }

        public boolean x(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
            if (i2 == 0) {
                return w();
            }
            return false;
        }

        /* JADX WARN: Incorrect args count in method signature: (Landroidx/coordinatorlayout/widget/CoordinatorLayout;TV;Landroid/view/View;)V */
        @Deprecated
        public void y() {
        }

        public void z(CoordinatorLayout coordinatorLayout, V v, View view, int i) {
            if (i == 0) {
                y();
            }
        }

        public c(Context context, AttributeSet attributeSet) {
        }
    }

    @Deprecated
    @Retention(RetentionPolicy.RUNTIME)
    public @interface d {
        Class<? extends c> value();
    }

    public class e implements ViewGroup.OnHierarchyChangeListener {
        public e() {
        }

        public void onChildViewAdded(View view, View view2) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.w;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.k(2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.w;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    public class g implements ViewTreeObserver.OnPreDrawListener {
        public g() {
        }

        public boolean onPreDraw() {
            CoordinatorLayout.this.k(0);
            return true;
        }
    }

    public static class h implements Comparator<View>, j$.util.Comparator {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // j$.util.Comparator, java.util.Comparator
        public int compare(View view, View view2) {
            AtomicInteger atomicInteger = r8.f3055a;
            float z = view.getZ();
            float z2 = view2.getZ();
            if (z > z2) {
                return -1;
            }
            return z < z2 ? 1 : 0;
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ Comparator<View> reversed() {
            return Comparator.CC.$default$reversed(this);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function) {
            return Comparator.CC.$default$thenComparing(this, function);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, function, comparator);
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.Comparator] */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ java.util.Comparator<View> thenComparing(java.util.Comparator<? super View> comparator) {
            return Comparator.CC.$default$thenComparing(this, comparator);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
            return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
            return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
            return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
        }
    }

    static {
        Package r0 = CoordinatorLayout.class.getPackage();
        z = r0 != null ? r0.getName() : null;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CoordinatorLayout(android.content.Context r10, android.util.AttributeSet r11) {
        /*
        // Method dump skipped, instructions count: 176
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    public static Rect a() {
        Rect b2 = D.b();
        return b2 == null ? new Rect() : b2;
    }

    public final void b(f fVar, Rect rect, int i2, int i3) {
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i2) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin));
        int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i3) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin));
        rect.set(max, max2, i2 + max, i3 + max2);
    }

    public void c(View view, boolean z2, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z2) {
            f(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof f) && super.checkLayoutParams(layoutParams);
    }

    public List<View> d(View view) {
        r4<View> r4Var = this.g;
        int i2 = r4Var.b.h;
        ArrayList arrayList = null;
        for (int i3 = 0; i3 < i2; i3++) {
            ArrayList<T> l2 = r4Var.b.l(i3);
            if (l2 != null && l2.contains(view)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(r4Var.b.h(i3));
            }
        }
        this.i.clear();
        if (arrayList != null) {
            this.i.addAll(arrayList);
        }
        return this.i;
    }

    public boolean drawChild(Canvas canvas, View view, long j2) {
        f fVar = (f) view.getLayoutParams();
        c cVar = fVar.f201a;
        if (cVar != null) {
            float c2 = cVar.c();
            if (c2 > 0.0f) {
                if (this.j == null) {
                    this.j = new Paint();
                }
                this.j.setColor(fVar.f201a.b());
                Paint paint = this.j;
                int round = Math.round(c2 * 255.0f);
                if (round < 0) {
                    round = 0;
                } else if (round > 255) {
                    round = Constants.MAX_HOST_LENGTH;
                }
                paint.setAlpha(round);
                int save = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect((float) view.getLeft(), (float) view.getTop(), (float) view.getRight(), (float) view.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect((float) getPaddingLeft(), (float) getPaddingTop(), (float) (getWidth() - getPaddingRight()), (float) (getHeight() - getPaddingBottom()), this.j);
                canvas.restoreToCount(save);
            }
        }
        return super.drawChild(canvas, view, j2);
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.v;
        boolean z2 = false;
        if (drawable != null && drawable.isStateful()) {
            z2 = false | drawable.setState(drawableState);
        }
        if (z2) {
            invalidate();
        }
    }

    public List<View> e(View view) {
        ArrayList<T> orDefault = this.g.b.getOrDefault(view, null);
        this.i.clear();
        if (orDefault != null) {
            this.i.addAll(orDefault);
        }
        return this.i;
    }

    public void f(View view, Rect rect) {
        ThreadLocal<Matrix> threadLocal = s4.f3180a;
        rect.set(0, 0, view.getWidth(), view.getHeight());
        ThreadLocal<Matrix> threadLocal2 = s4.f3180a;
        Matrix matrix = threadLocal2.get();
        if (matrix == null) {
            matrix = new Matrix();
            threadLocal2.set(matrix);
        } else {
            matrix.reset();
        }
        s4.a(this, view, matrix);
        ThreadLocal<RectF> threadLocal3 = s4.b;
        RectF rectF = threadLocal3.get();
        if (rectF == null) {
            rectF = new RectF();
            threadLocal3.set(rectF);
        }
        rectF.set(rect);
        matrix.mapRect(rectF);
        rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
    }

    public final void g(int i2, Rect rect, Rect rect2, f fVar, int i3, int i4) {
        int i5;
        int i6;
        int i7 = fVar.c;
        if (i7 == 0) {
            i7 = 17;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(i7, i2);
        int i8 = fVar.d;
        if ((i8 & 7) == 0) {
            i8 |= 8388611;
        }
        if ((i8 & 112) == 0) {
            i8 |= 48;
        }
        int absoluteGravity2 = Gravity.getAbsoluteGravity(i8, i2);
        int i9 = absoluteGravity & 7;
        int i10 = absoluteGravity & 112;
        int i11 = absoluteGravity2 & 7;
        int i12 = absoluteGravity2 & 112;
        if (i11 == 1) {
            i5 = rect.left + (rect.width() / 2);
        } else if (i11 != 5) {
            i5 = rect.left;
        } else {
            i5 = rect.right;
        }
        if (i12 == 16) {
            i6 = rect.top + (rect.height() / 2);
        } else if (i12 != 80) {
            i6 = rect.top;
        } else {
            i6 = rect.bottom;
        }
        if (i9 == 1) {
            i5 -= i3 / 2;
        } else if (i9 != 5) {
            i5 -= i3;
        }
        if (i10 == 16) {
            i6 -= i4 / 2;
        } else if (i10 != 80) {
            i6 -= i4;
        }
        rect2.set(i5, i6, i3 + i5, i4 + i6);
    }

    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new f(-2, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new f(getContext(), attributeSet);
    }

    public final List<View> getDependencySortedChildren() {
        o();
        return Collections.unmodifiableList(this.f);
    }

    public final c9 getLastWindowInsets() {
        return this.t;
    }

    public int getNestedScrollAxes() {
        return this.y.a();
    }

    public Drawable getStatusBarBackground() {
        return this.v;
    }

    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingBottom() + getPaddingTop());
    }

    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingRight() + getPaddingLeft());
    }

    public final int h(int i2) {
        int[] iArr = this.o;
        if (iArr == null) {
            String str = "No keylines defined for " + this + " - attempted index lookup " + i2;
            return 0;
        } else if (i2 >= 0 && i2 < iArr.length) {
            return iArr[i2];
        } else {
            String str2 = "Keyline index " + i2 + " out of range for " + this;
            return 0;
        }
    }

    public f i(View view) {
        f fVar = (f) view.getLayoutParams();
        if (!fVar.b) {
            if (view instanceof b) {
                fVar.b(((b) view).getBehavior());
                fVar.b = true;
            } else {
                d dVar = null;
                for (Class<?> cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                    dVar = (d) cls.getAnnotation(d.class);
                    if (dVar != null) {
                        break;
                    }
                }
                if (dVar != null) {
                    try {
                        fVar.b((c) dVar.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                    } catch (Exception unused) {
                        dVar.value().getName();
                    }
                }
                fVar.b = true;
            }
        }
        return fVar;
    }

    public boolean j(View view, int i2, int i3) {
        Rect a2 = a();
        f(view, a2);
        try {
            return a2.contains(i2, i3);
        } finally {
            a2.setEmpty();
            D.a(a2);
        }
    }

    public final void k(int i2) {
        int i3;
        Rect rect;
        int i4;
        boolean z2;
        boolean z3;
        boolean z4;
        int width;
        int i5;
        int i6;
        int i7;
        int height;
        int i8;
        int i9;
        int i10;
        Rect rect2;
        int i11;
        int i12;
        int i13;
        f fVar;
        c cVar;
        AtomicInteger atomicInteger = r8.f3055a;
        int layoutDirection = getLayoutDirection();
        int size = this.f.size();
        Rect a2 = a();
        Rect a3 = a();
        Rect a4 = a();
        int i14 = 0;
        while (i14 < size) {
            View view = this.f.get(i14);
            f fVar2 = (f) view.getLayoutParams();
            if (i2 == 0 && view.getVisibility() == 8) {
                i4 = size;
                rect = a4;
                i3 = i14;
            } else {
                int i15 = 0;
                while (i15 < i14) {
                    if (fVar2.l == this.f.get(i15)) {
                        f fVar3 = (f) view.getLayoutParams();
                        if (fVar3.k != null) {
                            Rect a5 = a();
                            Rect a6 = a();
                            Rect a7 = a();
                            f(fVar3.k, a5);
                            c(view, false, a6);
                            int measuredWidth = view.getMeasuredWidth();
                            i13 = size;
                            int measuredHeight = view.getMeasuredHeight();
                            i12 = i14;
                            i11 = i15;
                            rect2 = a4;
                            fVar = fVar2;
                            g(layoutDirection, a5, a7, fVar3, measuredWidth, measuredHeight);
                            boolean z5 = (a7.left == a6.left && a7.top == a6.top) ? false : true;
                            b(fVar3, a7, measuredWidth, measuredHeight);
                            int i16 = a7.left - a6.left;
                            int i17 = a7.top - a6.top;
                            if (i16 != 0) {
                                r8.n(view, i16);
                            }
                            if (i17 != 0) {
                                r8.o(view, i17);
                            }
                            if (z5 && (cVar = fVar3.f201a) != null) {
                                cVar.g(this, view, fVar3.k);
                            }
                            a5.setEmpty();
                            v7<Rect> v7Var = D;
                            v7Var.a(a5);
                            a6.setEmpty();
                            v7Var.a(a6);
                            a7.setEmpty();
                            v7Var.a(a7);
                            i15 = i11 + 1;
                            fVar2 = fVar;
                            size = i13;
                            i14 = i12;
                            a4 = rect2;
                        }
                    }
                    i11 = i15;
                    i13 = size;
                    rect2 = a4;
                    i12 = i14;
                    fVar = fVar2;
                    i15 = i11 + 1;
                    fVar2 = fVar;
                    size = i13;
                    i14 = i12;
                    a4 = rect2;
                }
                i3 = i14;
                c(view, true, a3);
                if (fVar2.g != 0 && !a3.isEmpty()) {
                    int absoluteGravity = Gravity.getAbsoluteGravity(fVar2.g, layoutDirection);
                    int i18 = absoluteGravity & 112;
                    if (i18 == 48) {
                        a2.top = Math.max(a2.top, a3.bottom);
                    } else if (i18 == 80) {
                        a2.bottom = Math.max(a2.bottom, getHeight() - a3.top);
                    }
                    int i19 = absoluteGravity & 7;
                    if (i19 == 3) {
                        a2.left = Math.max(a2.left, a3.right);
                    } else if (i19 == 5) {
                        a2.right = Math.max(a2.right, getWidth() - a3.left);
                    }
                }
                if (fVar2.h != 0 && view.getVisibility() == 0) {
                    AtomicInteger atomicInteger2 = r8.f3055a;
                    if (view.isLaidOut() && view.getWidth() > 0 && view.getHeight() > 0) {
                        f fVar4 = (f) view.getLayoutParams();
                        c cVar2 = fVar4.f201a;
                        Rect a8 = a();
                        Rect a9 = a();
                        a9.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
                        if (cVar2 == null || !cVar2.a(this, view, a8)) {
                            a8.set(a9);
                        } else if (!a9.contains(a8)) {
                            StringBuilder i0 = hj1.i0("Rect should be within the child's bounds. Rect:");
                            i0.append(a8.toShortString());
                            i0.append(" | Bounds:");
                            i0.append(a9.toShortString());
                            throw new IllegalArgumentException(i0.toString());
                        }
                        a9.setEmpty();
                        v7<Rect> v7Var2 = D;
                        v7Var2.a(a9);
                        if (a8.isEmpty()) {
                            a8.setEmpty();
                            v7Var2.a(a8);
                        } else {
                            int absoluteGravity2 = Gravity.getAbsoluteGravity(fVar4.h, layoutDirection);
                            if ((absoluteGravity2 & 48) != 48 || (i9 = (a8.top - ((ViewGroup.MarginLayoutParams) fVar4).topMargin) - fVar4.j) >= (i10 = a2.top)) {
                                z3 = false;
                            } else {
                                r(view, i10 - i9);
                                z3 = true;
                            }
                            if ((absoluteGravity2 & 80) == 80 && (height = ((getHeight() - a8.bottom) - ((ViewGroup.MarginLayoutParams) fVar4).bottomMargin) + fVar4.j) < (i8 = a2.bottom)) {
                                r(view, height - i8);
                                z3 = true;
                            }
                            if (!z3) {
                                r(view, 0);
                            }
                            if ((absoluteGravity2 & 3) != 3 || (i6 = (a8.left - ((ViewGroup.MarginLayoutParams) fVar4).leftMargin) - fVar4.i) >= (i7 = a2.left)) {
                                z4 = false;
                            } else {
                                q(view, i7 - i6);
                                z4 = true;
                            }
                            if ((absoluteGravity2 & 5) == 5 && (width = ((getWidth() - a8.right) - ((ViewGroup.MarginLayoutParams) fVar4).rightMargin) + fVar4.i) < (i5 = a2.right)) {
                                q(view, width - i5);
                                z4 = true;
                            }
                            if (!z4) {
                                q(view, 0);
                            }
                            a8.setEmpty();
                            v7Var2.a(a8);
                        }
                    }
                }
                if (i2 != 2) {
                    rect = a4;
                    rect.set(((f) view.getLayoutParams()).q);
                    if (rect.equals(a3)) {
                        i4 = size;
                    } else {
                        ((f) view.getLayoutParams()).q.set(a3);
                    }
                } else {
                    rect = a4;
                }
                i4 = size;
                for (int i20 = i3 + 1; i20 < i4; i20++) {
                    View view2 = this.f.get(i20);
                    f fVar5 = (f) view2.getLayoutParams();
                    c cVar3 = fVar5.f201a;
                    if (cVar3 != null && cVar3.d(this, view2, view)) {
                        if (i2 != 0 || !fVar5.p) {
                            if (i2 != 2) {
                                z2 = cVar3.g(this, view2, view);
                            } else {
                                cVar3.h(this, view2, view);
                                z2 = true;
                            }
                            if (i2 == 1) {
                                fVar5.p = z2;
                            }
                        } else {
                            fVar5.p = false;
                        }
                    }
                }
            }
            i14 = i3 + 1;
            size = i4;
            a4 = rect;
        }
        a2.setEmpty();
        v7<Rect> v7Var3 = D;
        v7Var3.a(a2);
        a3.setEmpty();
        v7Var3.a(a3);
        a4.setEmpty();
        v7Var3.a(a4);
    }

    public void l(View view, int i2) {
        f fVar = (f) view.getLayoutParams();
        View view2 = fVar.k;
        int i3 = 0;
        if (view2 == null && fVar.f != -1) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        } else if (view2 != null) {
            Rect a2 = a();
            Rect a3 = a();
            try {
                f(view2, a2);
                f fVar2 = (f) view.getLayoutParams();
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                g(i2, a2, a3, fVar2, measuredWidth, measuredHeight);
                b(fVar2, a3, measuredWidth, measuredHeight);
                view.layout(a3.left, a3.top, a3.right, a3.bottom);
            } finally {
                a2.setEmpty();
                v7<Rect> v7Var = D;
                v7Var.a(a2);
                a3.setEmpty();
                v7Var.a(a3);
            }
        } else {
            int i4 = fVar.e;
            if (i4 >= 0) {
                f fVar3 = (f) view.getLayoutParams();
                int i5 = fVar3.c;
                if (i5 == 0) {
                    i5 = 8388661;
                }
                int absoluteGravity = Gravity.getAbsoluteGravity(i5, i2);
                int i6 = absoluteGravity & 7;
                int i7 = absoluteGravity & 112;
                int width = getWidth();
                int height = getHeight();
                int measuredWidth2 = view.getMeasuredWidth();
                int measuredHeight2 = view.getMeasuredHeight();
                if (i2 == 1) {
                    i4 = width - i4;
                }
                int h2 = h(i4) - measuredWidth2;
                if (i6 == 1) {
                    h2 += measuredWidth2 / 2;
                } else if (i6 == 5) {
                    h2 += measuredWidth2;
                }
                if (i7 == 16) {
                    i3 = 0 + (measuredHeight2 / 2);
                } else if (i7 == 80) {
                    i3 = measuredHeight2 + 0;
                }
                int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar3).leftMargin, Math.min(h2, ((width - getPaddingRight()) - measuredWidth2) - ((ViewGroup.MarginLayoutParams) fVar3).rightMargin));
                int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar3).topMargin, Math.min(i3, ((height - getPaddingBottom()) - measuredHeight2) - ((ViewGroup.MarginLayoutParams) fVar3).bottomMargin));
                view.layout(max, max2, measuredWidth2 + max, measuredHeight2 + max2);
                return;
            }
            f fVar4 = (f) view.getLayoutParams();
            Rect a4 = a();
            a4.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar4).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar4).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) fVar4).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) fVar4).bottomMargin);
            if (this.t != null) {
                AtomicInteger atomicInteger = r8.f3055a;
                if (getFitsSystemWindows() && !view.getFitsSystemWindows()) {
                    a4.left = this.t.c() + a4.left;
                    a4.top = this.t.e() + a4.top;
                    a4.right -= this.t.d();
                    a4.bottom -= this.t.b();
                }
            }
            Rect a5 = a();
            int i8 = fVar4.c;
            if ((i8 & 7) == 0) {
                i8 |= 8388611;
            }
            if ((i8 & 112) == 0) {
                i8 |= 48;
            }
            Gravity.apply(i8, view.getMeasuredWidth(), view.getMeasuredHeight(), a4, a5, i2);
            view.layout(a5.left, a5.top, a5.right, a5.bottom);
            a4.setEmpty();
            v7<Rect> v7Var2 = D;
            v7Var2.a(a4);
            a5.setEmpty();
            v7Var2.a(a5);
        }
    }

    public void m(View view, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    public final boolean n(MotionEvent motionEvent, int i2) {
        boolean z2;
        int actionMasked = motionEvent.getActionMasked();
        List<View> list = this.h;
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i3 = childCount - 1; i3 >= 0; i3--) {
            list.add(getChildAt(isChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i3) : i3));
        }
        java.util.Comparator<View> comparator = C;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
        int size = list.size();
        MotionEvent motionEvent2 = null;
        boolean z3 = false;
        boolean z4 = false;
        for (int i4 = 0; i4 < size; i4++) {
            View view = list.get(i4);
            f fVar = (f) view.getLayoutParams();
            c cVar = fVar.f201a;
            boolean z5 = true;
            if (!(z3 || z4) || actionMasked == 0) {
                if (!z3 && cVar != null) {
                    if (i2 == 0) {
                        z3 = cVar.j(this, view, motionEvent);
                    } else if (i2 == 1) {
                        z3 = cVar.A(this, view, motionEvent);
                    }
                    if (z3) {
                        this.p = view;
                    }
                }
                c cVar2 = fVar.f201a;
                if (cVar2 == null) {
                    fVar.m = false;
                }
                boolean z6 = fVar.m;
                if (z6) {
                    z2 = true;
                } else {
                    z2 = (cVar2 != null && cVar2.c() > 0.0f) | z6;
                    fVar.m = z2;
                }
                if (!z2 || z6) {
                    z5 = false;
                }
                if (z2 && !z5) {
                    break;
                }
                z4 = z5;
            } else if (cVar != null) {
                if (motionEvent2 == null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                }
                if (i2 == 0) {
                    cVar.j(this, view, motionEvent2);
                } else if (i2 == 1) {
                    cVar.A(this, view, motionEvent2);
                }
            }
        }
        list.clear();
        return z3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0073, code lost:
        if (r5 != false) goto L_0x00ca;
     */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x016a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0110  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void o() {
        /*
        // Method dump skipped, instructions count: 454
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.o():void");
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        p(false);
        if (this.s) {
            if (this.r == null) {
                this.r = new g();
            }
            getViewTreeObserver().addOnPreDrawListener(this.r);
        }
        if (this.t == null) {
            AtomicInteger atomicInteger = r8.f3055a;
            if (getFitsSystemWindows()) {
                requestApplyInsets();
            }
        }
        this.n = true;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        p(false);
        if (this.s && this.r != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.r);
        }
        View view = this.q;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.n = false;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.u && this.v != null) {
            c9 c9Var = this.t;
            int e2 = c9Var != null ? c9Var.e() : 0;
            if (e2 > 0) {
                this.v.setBounds(0, 0, getWidth(), e2);
                this.v.draw(canvas);
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            p(true);
        }
        boolean n2 = n(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            p(true);
        }
        return n2;
    }

    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        c cVar;
        AtomicInteger atomicInteger = r8.f3055a;
        int layoutDirection = getLayoutDirection();
        int size = this.f.size();
        for (int i6 = 0; i6 < size; i6++) {
            View view = this.f.get(i6);
            if (view.getVisibility() != 8 && ((cVar = ((f) view.getLayoutParams()).f201a) == null || !cVar.k(this, view, layoutDirection))) {
                l(view, layoutDirection);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0180, code lost:
        if (r0.l(r30, r20, r8, r21, r23, 0) == false) goto L_0x0190;
     */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0161  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0183  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r31, int r32) {
        /*
        // Method dump skipped, instructions count: 494
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    public boolean onNestedFling(View view, float f2, float f3, boolean z2) {
        c cVar;
        int childCount = getChildCount();
        boolean z3 = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.a(0) && (cVar = fVar.f201a) != null) {
                    z3 |= cVar.m();
                }
            }
        }
        if (z3) {
            k(1);
        }
        return z3;
    }

    public boolean onNestedPreFling(View view, float f2, float f3) {
        c cVar;
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.a(0) && (cVar = fVar.f201a) != null) {
                    z2 |= cVar.n(this, childAt, view, f2, f3);
                }
            }
        }
        return z2;
    }

    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        onNestedPreScroll(view, i2, i3, iArr, 0);
    }

    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        onNestedScroll(view, i2, i3, i4, i5, 0, this.l);
    }

    public void onNestedScrollAccepted(View view, View view2, int i2) {
        onNestedScrollAccepted(view, view2, i2, 0);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        SparseArray<Parcelable> sparseArray = savedState.f;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            int id = childAt.getId();
            c cVar = i(childAt).f201a;
            if (!(id == -1 || cVar == null || (parcelable2 = sparseArray.get(id)) == null)) {
                cVar.u(this, childAt, parcelable2);
            }
        }
    }

    public Parcelable onSaveInstanceState() {
        Parcelable v2;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            int id = childAt.getId();
            c cVar = ((f) childAt.getLayoutParams()).f201a;
            if (!(id == -1 || cVar == null || (v2 = cVar.v(this, childAt)) == null)) {
                sparseArray.append(id, v2);
            }
        }
        savedState.f = sparseArray;
        return savedState;
    }

    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return onStartNestedScroll(view, view2, i2, 0);
    }

    public void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0012, code lost:
        if (r3 != false) goto L_0x0016;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r18.getActionMasked()
            android.view.View r3 = r0.p
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L_0x0015
            boolean r3 = r0.n(r1, r4)
            if (r3 == 0) goto L_0x0029
            goto L_0x0016
        L_0x0015:
            r3 = 0
        L_0x0016:
            android.view.View r6 = r0.p
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$f r6 = (androidx.coordinatorlayout.widget.CoordinatorLayout.f) r6
            androidx.coordinatorlayout.widget.CoordinatorLayout$c r6 = r6.f201a
            if (r6 == 0) goto L_0x0029
            android.view.View r7 = r0.p
            boolean r6 = r6.A(r0, r7, r1)
            goto L_0x002a
        L_0x0029:
            r6 = 0
        L_0x002a:
            android.view.View r7 = r0.p
            r8 = 0
            if (r7 != 0) goto L_0x0035
            boolean r1 = super.onTouchEvent(r18)
            r6 = r6 | r1
            goto L_0x0048
        L_0x0035:
            if (r3 == 0) goto L_0x0048
            long r11 = android.os.SystemClock.uptimeMillis()
            r13 = 3
            r14 = 0
            r15 = 0
            r16 = 0
            r9 = r11
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16)
            super.onTouchEvent(r8)
        L_0x0048:
            if (r8 == 0) goto L_0x004d
            r8.recycle()
        L_0x004d:
            if (r2 == r4) goto L_0x0052
            r1 = 3
            if (r2 != r1) goto L_0x0055
        L_0x0052:
            r0.p(r5)
        L_0x0055:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p(boolean z2) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            c cVar = ((f) childAt.getLayoutParams()).f201a;
            if (cVar != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z2) {
                    cVar.j(this, childAt, obtain);
                } else {
                    cVar.A(this, childAt, obtain);
                }
                obtain.recycle();
            }
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            ((f) getChildAt(i3).getLayoutParams()).m = false;
        }
        this.p = null;
        this.m = false;
    }

    public final void q(View view, int i2) {
        f fVar = (f) view.getLayoutParams();
        int i3 = fVar.i;
        if (i3 != i2) {
            r8.n(view, i2 - i3);
            fVar.i = i2;
        }
    }

    public final void r(View view, int i2) {
        f fVar = (f) view.getLayoutParams();
        int i3 = fVar.j;
        if (i3 != i2) {
            r8.o(view, i2 - i3);
            fVar.j = i2;
        }
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        c cVar = ((f) view.getLayoutParams()).f201a;
        if (cVar == null || !cVar.t(this, view, rect, z2)) {
            return super.requestChildRectangleOnScreen(view, rect, z2);
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z2) {
        super.requestDisallowInterceptTouchEvent(z2);
        if (z2 && !this.m) {
            p(false);
            this.m = true;
        }
    }

    public final void s() {
        AtomicInteger atomicInteger = r8.f3055a;
        if (getFitsSystemWindows()) {
            if (this.x == null) {
                this.x = new a();
            }
            r8.w(this, this.x);
            setSystemUiVisibility(1280);
            return;
        }
        r8.w(this, null);
    }

    public void setFitsSystemWindows(boolean z2) {
        super.setFitsSystemWindows(z2);
        s();
    }

    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.w = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = this.v;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.v = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.v.setState(getDrawableState());
                }
                Drawable drawable4 = this.v;
                AtomicInteger atomicInteger = r8.f3055a;
                defpackage.h.s0(drawable4, getLayoutDirection());
                this.v.setVisible(getVisibility() == 0, false);
                this.v.setCallback(this);
            }
            AtomicInteger atomicInteger2 = r8.f3055a;
            postInvalidateOnAnimation();
        }
    }

    public void setStatusBarBackgroundColor(int i2) {
        setStatusBarBackground(new ColorDrawable(i2));
    }

    public void setStatusBarBackgroundResource(int i2) {
        Drawable drawable;
        if (i2 != 0) {
            Context context = getContext();
            Object obj = q5.f2896a;
            drawable = q5.c.b(context, i2);
        } else {
            drawable = null;
        }
        setStatusBarBackground(drawable);
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z2 = i2 == 0;
        Drawable drawable = this.v;
        if (drawable != null && drawable.isVisible() != z2) {
            this.v.setVisible(z2, false);
        }
    }

    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.v;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof f) {
            return new f((f) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new f((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new f(layoutParams);
    }

    @Override // defpackage.j8
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr, int i4) {
        c cVar;
        int i5;
        int i6;
        int childCount = getChildCount();
        boolean z2 = false;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.a(i4) && (cVar = fVar.f201a) != null) {
                    int[] iArr2 = this.k;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    cVar.p(this, childAt, view, i2, i3, iArr2, i4);
                    int[] iArr3 = this.k;
                    if (i2 > 0) {
                        i5 = Math.max(i7, iArr3[0]);
                    } else {
                        i5 = Math.min(i7, iArr3[0]);
                    }
                    i7 = i5;
                    int[] iArr4 = this.k;
                    if (i3 > 0) {
                        i6 = Math.max(i8, iArr4[1]);
                    } else {
                        i6 = Math.min(i8, iArr4[1]);
                    }
                    i8 = i6;
                    z2 = true;
                }
            }
        }
        iArr[0] = i7;
        iArr[1] = i8;
        if (z2) {
            k(1);
        }
    }

    @Override // defpackage.j8
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5, int i6) {
        onNestedScroll(view, i2, i3, i4, i5, 0, this.l);
    }

    @Override // defpackage.j8
    public void onNestedScrollAccepted(View view, View view2, int i2, int i3) {
        c cVar;
        l8 l8Var = this.y;
        if (i3 == 1) {
            l8Var.b = i2;
        } else {
            l8Var.f2183a = i2;
        }
        this.q = view2;
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            f fVar = (f) getChildAt(i4).getLayoutParams();
            if (fVar.a(i3) && (cVar = fVar.f201a) != null && i3 == 0) {
                cVar.s();
            }
        }
    }

    @Override // defpackage.j8
    public boolean onStartNestedScroll(View view, View view2, int i2, int i3) {
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                c cVar = fVar.f201a;
                if (cVar != null) {
                    boolean x2 = cVar.x(this, childAt, view, view2, i2, i3);
                    z2 |= x2;
                    fVar.c(i3, x2);
                } else {
                    fVar.c(i3, false);
                }
            }
        }
        return z2;
    }

    @Override // defpackage.j8
    public void onStopNestedScroll(View view, int i2) {
        l8 l8Var = this.y;
        if (i2 == 1) {
            l8Var.b = 0;
        } else {
            l8Var.f2183a = 0;
        }
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            f fVar = (f) childAt.getLayoutParams();
            if (fVar.a(i2)) {
                c cVar = fVar.f201a;
                if (cVar != null) {
                    cVar.z(this, childAt, view, i2);
                }
                fVar.c(i2, false);
                fVar.p = false;
            }
        }
        this.q = null;
    }

    @Override // defpackage.k8
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        c cVar;
        int i7;
        int i8;
        int childCount = getChildCount();
        boolean z2 = false;
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.a(i6) && (cVar = fVar.f201a) != null) {
                    int[] iArr2 = this.k;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    cVar.r(this, childAt, view, i2, i3, i4, i5, i6, iArr2);
                    int[] iArr3 = this.k;
                    if (i4 > 0) {
                        i7 = Math.max(i9, iArr3[0]);
                    } else {
                        i7 = Math.min(i9, iArr3[0]);
                    }
                    i9 = i7;
                    if (i5 > 0) {
                        i8 = Math.max(i10, this.k[1]);
                    } else {
                        i8 = Math.min(i10, this.k[1]);
                    }
                    i10 = i8;
                    z2 = true;
                }
            }
        }
        iArr[0] = iArr[0] + i9;
        iArr[1] = iArr[1] + i10;
        if (z2) {
            k(1);
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public SparseArray<Parcelable> f;

        public static class a implements Parcelable.ClassLoaderCreator<SavedState> {
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
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.f = new SparseArray<>(readInt);
            for (int i = 0; i < readInt; i++) {
                this.f.append(iArr[i], readParcelableArray[i]);
            }
        }

        @Override // androidx.customview.view.AbsSavedState
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            SparseArray<Parcelable> sparseArray = this.f;
            int size = sparseArray != null ? sparseArray.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i2 = 0; i2 < size; i2++) {
                iArr[i2] = this.f.keyAt(i2);
                parcelableArr[i2] = this.f.valueAt(i2);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public static class f extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public c f201a;
        public boolean b = false;
        public int c = 0;
        public int d = 0;
        public int e = -1;
        public int f = -1;
        public int g = 0;
        public int h = 0;
        public int i;
        public int j;
        public View k;
        public View l;
        public boolean m;
        public boolean n;
        public boolean o;
        public boolean p;
        public final Rect q = new Rect();

        public f(int i2, int i3) {
            super(i2, i3);
        }

        public boolean a(int i2) {
            if (i2 == 0) {
                return this.n;
            }
            if (i2 != 1) {
                return false;
            }
            return this.o;
        }

        public void b(c cVar) {
            c cVar2 = this.f201a;
            if (cVar2 != cVar) {
                if (cVar2 != null) {
                    cVar2.i();
                }
                this.f201a = cVar;
                this.b = true;
                if (cVar != null) {
                    cVar.f(this);
                }
            }
        }

        public void c(int i2, boolean z) {
            if (i2 == 0) {
                this.n = z;
            } else if (i2 == 1) {
                this.o = z;
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v17, resolved type: java.lang.Class<?> */
        /* JADX WARN: Multi-variable type inference failed */
        public f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            c cVar;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CoordinatorLayout_Layout);
            this.c = obtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.f = obtainStyledAttributes.getResourceId(R.styleable.CoordinatorLayout_Layout_layout_anchor, -1);
            this.d = obtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.e = obtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_Layout_layout_keyline, -1);
            this.g = obtainStyledAttributes.getInt(R.styleable.CoordinatorLayout_Layout_layout_insetEdge, 0);
            this.h = obtainStyledAttributes.getInt(R.styleable.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
            int i2 = R.styleable.CoordinatorLayout_Layout_layout_behavior;
            boolean hasValue = obtainStyledAttributes.hasValue(i2);
            this.b = hasValue;
            if (hasValue) {
                String string = obtainStyledAttributes.getString(i2);
                String str = CoordinatorLayout.z;
                if (TextUtils.isEmpty(string)) {
                    cVar = null;
                } else {
                    if (string.startsWith(".")) {
                        string = context.getPackageName() + string;
                    } else if (string.indexOf(46) < 0) {
                        String str2 = CoordinatorLayout.z;
                        if (!TextUtils.isEmpty(str2)) {
                            string = str2 + '.' + string;
                        }
                    }
                    try {
                        ThreadLocal<Map<String, Constructor<c>>> threadLocal = CoordinatorLayout.B;
                        Map<String, Constructor<c>> map = threadLocal.get();
                        if (map == null) {
                            map = new HashMap<>();
                            threadLocal.set(map);
                        }
                        Constructor<c> constructor = map.get(string);
                        if (constructor == null) {
                            constructor = Class.forName(string, false, context.getClassLoader()).getConstructor(CoordinatorLayout.A);
                            constructor.setAccessible(true);
                            map.put(string, constructor);
                        }
                        cVar = constructor.newInstance(context, attributeSet);
                    } catch (Exception e2) {
                        throw new RuntimeException(hj1.S("Could not inflate Behavior subclass ", string), e2);
                    }
                }
                this.f201a = cVar;
            }
            obtainStyledAttributes.recycle();
            c cVar2 = this.f201a;
            if (cVar2 != null) {
                cVar2.f(this);
            }
        }

        public f(f fVar) {
            super((ViewGroup.MarginLayoutParams) fVar);
        }

        public f(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public f(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }
}
