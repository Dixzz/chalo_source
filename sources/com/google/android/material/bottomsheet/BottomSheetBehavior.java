package com.google.android.material.bottomsheet;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.firebase.appindexing.Indexable;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import defpackage.e9;
import defpackage.fa;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.c<V> {
    public static final int Q = R.style.Widget_Design_BottomSheet_Modal;
    public boolean A;
    public int B;
    public boolean C;
    public int D;
    public int E;
    public int F;
    public WeakReference<V> G;
    public WeakReference<View> H;
    public final ArrayList<c> I = new ArrayList<>();
    public VelocityTracker J;
    public int K;
    public int L;
    public boolean M;
    public Map<View, Integer> N;
    public int O = -1;
    public final fa.c P = new b();

    /* renamed from: a  reason: collision with root package name */
    public int f617a = 0;
    public boolean b = true;
    public float c;
    public int d;
    public boolean e;
    public int f;
    public int g;
    public boolean h;
    public ho4 i;
    public int j;
    public boolean k;
    public ko4 l;
    public boolean m;
    public BottomSheetBehavior<V>.d n = null;
    public ValueAnimator o;
    public int p;
    public int q;
    public int r;
    public float s = 0.5f;
    public int t;
    public float u = -1.0f;
    public boolean v;
    public boolean w;
    public boolean x = true;
    public int y = 4;
    public fa z;

    public class a implements Runnable {
        public final /* synthetic */ View f;
        public final /* synthetic */ int g;

        public a(View view, int i) {
            this.f = view;
            this.g = i;
        }

        public void run() {
            BottomSheetBehavior.this.O(this.f, this.g);
        }
    }

    public class b extends fa.c {
        public b() {
        }

        @Override // defpackage.fa.c
        public int a(View view, int i, int i2) {
            return view.getLeft();
        }

        @Override // defpackage.fa.c
        public int b(View view, int i, int i2) {
            int I = BottomSheetBehavior.this.I();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return h.r(i, I, bottomSheetBehavior.v ? bottomSheetBehavior.F : bottomSheetBehavior.t);
        }

        @Override // defpackage.fa.c
        public int d(View view) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            if (bottomSheetBehavior.v) {
                return bottomSheetBehavior.F;
            }
            return bottomSheetBehavior.t;
        }

        @Override // defpackage.fa.c
        public void i(int i) {
            if (i == 1) {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (bottomSheetBehavior.x) {
                    bottomSheetBehavior.N(1);
                }
            }
        }

        @Override // defpackage.fa.c
        public void j(View view, int i, int i2, int i3, int i4) {
            BottomSheetBehavior.this.F(i2);
        }

        @Override // defpackage.fa.c
        public void k(View view, float f, float f2) {
            int i;
            int i2 = 4;
            if (f2 < 0.0f) {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (bottomSheetBehavior.b) {
                    i = bottomSheetBehavior.q;
                } else {
                    int top = view.getTop();
                    BottomSheetBehavior bottomSheetBehavior2 = BottomSheetBehavior.this;
                    int i3 = bottomSheetBehavior2.r;
                    if (top > i3) {
                        i = i3;
                        i2 = 6;
                        BottomSheetBehavior.this.R(view, i2, i, true);
                    }
                    i = bottomSheetBehavior2.p;
                }
            } else {
                BottomSheetBehavior bottomSheetBehavior3 = BottomSheetBehavior.this;
                if (bottomSheetBehavior3.v && bottomSheetBehavior3.Q(view, f2)) {
                    if (Math.abs(f) >= Math.abs(f2) || f2 <= 500.0f) {
                        int top2 = view.getTop();
                        BottomSheetBehavior bottomSheetBehavior4 = BottomSheetBehavior.this;
                        if (!(top2 > (bottomSheetBehavior4.I() + bottomSheetBehavior4.F) / 2)) {
                            BottomSheetBehavior bottomSheetBehavior5 = BottomSheetBehavior.this;
                            if (bottomSheetBehavior5.b) {
                                i = bottomSheetBehavior5.q;
                            } else if (Math.abs(view.getTop() - BottomSheetBehavior.this.p) < Math.abs(view.getTop() - BottomSheetBehavior.this.r)) {
                                i = BottomSheetBehavior.this.p;
                            } else {
                                i = BottomSheetBehavior.this.r;
                                i2 = 6;
                                BottomSheetBehavior.this.R(view, i2, i, true);
                            }
                        }
                    }
                    i = BottomSheetBehavior.this.F;
                    i2 = 5;
                    BottomSheetBehavior.this.R(view, i2, i, true);
                } else if (f2 == 0.0f || Math.abs(f) > Math.abs(f2)) {
                    int top3 = view.getTop();
                    BottomSheetBehavior bottomSheetBehavior6 = BottomSheetBehavior.this;
                    if (!bottomSheetBehavior6.b) {
                        int i4 = bottomSheetBehavior6.r;
                        if (top3 < i4) {
                            if (top3 < Math.abs(top3 - bottomSheetBehavior6.t)) {
                                i = BottomSheetBehavior.this.p;
                            } else {
                                i = BottomSheetBehavior.this.r;
                            }
                        } else if (Math.abs(top3 - i4) < Math.abs(top3 - BottomSheetBehavior.this.t)) {
                            i = BottomSheetBehavior.this.r;
                        } else {
                            i = BottomSheetBehavior.this.t;
                            BottomSheetBehavior.this.R(view, i2, i, true);
                        }
                        i2 = 6;
                        BottomSheetBehavior.this.R(view, i2, i, true);
                    } else if (Math.abs(top3 - bottomSheetBehavior6.q) < Math.abs(top3 - BottomSheetBehavior.this.t)) {
                        i = BottomSheetBehavior.this.q;
                    } else {
                        i = BottomSheetBehavior.this.t;
                        BottomSheetBehavior.this.R(view, i2, i, true);
                    }
                } else {
                    BottomSheetBehavior bottomSheetBehavior7 = BottomSheetBehavior.this;
                    if (bottomSheetBehavior7.b) {
                        i = bottomSheetBehavior7.t;
                    } else {
                        int top4 = view.getTop();
                        if (Math.abs(top4 - BottomSheetBehavior.this.r) < Math.abs(top4 - BottomSheetBehavior.this.t)) {
                            i = BottomSheetBehavior.this.r;
                            i2 = 6;
                        } else {
                            i = BottomSheetBehavior.this.t;
                        }
                    }
                    BottomSheetBehavior.this.R(view, i2, i, true);
                }
            }
            i2 = 3;
            BottomSheetBehavior.this.R(view, i2, i, true);
        }

        @Override // defpackage.fa.c
        public boolean l(View view, int i) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i2 = bottomSheetBehavior.y;
            if (i2 == 1 || bottomSheetBehavior.M) {
                return false;
            }
            if (i2 == 3 && bottomSheetBehavior.K == i) {
                WeakReference<View> weakReference = bottomSheetBehavior.H;
                View view2 = weakReference != null ? weakReference.get() : null;
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            WeakReference<V> weakReference2 = BottomSheetBehavior.this.G;
            if (weakReference2 == null || weakReference2.get() != view) {
                return false;
            }
            return true;
        }
    }

    public static abstract class c {
        public abstract void a(View view, float f);

        public abstract void b(View view, int i);
    }

    public class d implements Runnable {
        public final View f;
        public boolean g;
        public int h;

        public d(View view, int i2) {
            this.f = view;
            this.h = i2;
        }

        public void run() {
            fa faVar = BottomSheetBehavior.this.z;
            if (faVar == null || !faVar.j(true)) {
                BottomSheetBehavior.this.N(this.h);
            } else {
                View view = this.f;
                AtomicInteger atomicInteger = r8.f3055a;
                view.postOnAnimation(this);
            }
            this.g = false;
        }
    }

    public BottomSheetBehavior() {
    }

    public static <V extends View> BottomSheetBehavior<V> H(V v2) {
        ViewGroup.LayoutParams layoutParams = v2.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.f) {
            CoordinatorLayout.c cVar = ((CoordinatorLayout.f) layoutParams).f201a;
            if (cVar instanceof BottomSheetBehavior) {
                return (BottomSheetBehavior) cVar;
            }
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean A(CoordinatorLayout coordinatorLayout, V v2, MotionEvent motionEvent) {
        if (!v2.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.y == 1 && actionMasked == 0) {
            return true;
        }
        fa faVar = this.z;
        if (faVar != null) {
            faVar.q(motionEvent);
        }
        if (actionMasked == 0) {
            this.K = -1;
            VelocityTracker velocityTracker = this.J;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.J = null;
            }
        }
        if (this.J == null) {
            this.J = VelocityTracker.obtain();
        }
        this.J.addMovement(motionEvent);
        if (this.z != null && actionMasked == 2 && !this.A) {
            float abs = Math.abs(((float) this.L) - motionEvent.getY());
            fa faVar2 = this.z;
            if (abs > ((float) faVar2.b)) {
                faVar2.b(v2, motionEvent.getPointerId(motionEvent.getActionIndex()));
            }
        }
        return !this.A;
    }

    public void B(c cVar) {
        if (!this.I.contains(cVar)) {
            this.I.add(cVar);
        }
    }

    public final void C() {
        int D2 = D();
        if (this.b) {
            this.t = Math.max(this.F - D2, this.q);
        } else {
            this.t = this.F - D2;
        }
    }

    public final int D() {
        int i2;
        if (this.e) {
            return Math.min(Math.max(this.f, this.F - ((this.E * 9) / 16)), this.D);
        }
        if (this.k || (i2 = this.j) <= 0) {
            return this.d;
        }
        return Math.max(this.d, i2 + this.g);
    }

    public final void E(Context context, AttributeSet attributeSet, boolean z2, ColorStateList colorStateList) {
        if (this.h) {
            this.l = ko4.b(context, attributeSet, R.attr.bottomSheetStyle, Q).a();
            ho4 ho4 = new ho4(this.l);
            this.i = ho4;
            ho4.f.b = new tm4(context);
            ho4.y();
            if (!z2 || colorStateList == null) {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(16842801, typedValue, true);
                this.i.setTint(typedValue.data);
                return;
            }
            this.i.q(colorStateList);
        }
    }

    public void F(int i2) {
        float f2;
        float f3;
        V v2 = this.G.get();
        if (!(v2 == null || this.I.isEmpty())) {
            int i3 = this.t;
            if (i2 > i3 || i3 == I()) {
                int i4 = this.t;
                f2 = (float) (i4 - i2);
                f3 = (float) (this.F - i4);
            } else {
                int i5 = this.t;
                f2 = (float) (i5 - i2);
                f3 = (float) (i5 - I());
            }
            float f4 = f2 / f3;
            for (int i6 = 0; i6 < this.I.size(); i6++) {
                this.I.get(i6).a(v2, f4);
            }
        }
    }

    public View G(View view) {
        AtomicInteger atomicInteger = r8.f3055a;
        if (view.isNestedScrollingEnabled()) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View G2 = G(viewGroup.getChildAt(i2));
            if (G2 != null) {
                return G2;
            }
        }
        return null;
    }

    public int I() {
        return this.b ? this.q : this.p;
    }

    public final void J(V v2, e9.a aVar, int i2) {
        r8.t(v2, aVar, null, new fl4(this, i2));
    }

    public void K(boolean z2) {
        if (this.v != z2) {
            this.v = z2;
            if (!z2 && this.y == 5) {
                M(4);
            }
            S();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void L(int r4) {
        /*
            r3 = this;
            r0 = 1
            r1 = -1
            r2 = 0
            if (r4 != r1) goto L_0x000c
            boolean r4 = r3.e
            if (r4 != 0) goto L_0x0015
            r3.e = r0
            goto L_0x001f
        L_0x000c:
            boolean r1 = r3.e
            if (r1 != 0) goto L_0x0017
            int r1 = r3.d
            if (r1 == r4) goto L_0x0015
            goto L_0x0017
        L_0x0015:
            r0 = 0
            goto L_0x001f
        L_0x0017:
            r3.e = r2
            int r4 = java.lang.Math.max(r2, r4)
            r3.d = r4
        L_0x001f:
            if (r0 == 0) goto L_0x0024
            r3.V(r2)
        L_0x0024:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.L(int):void");
    }

    public void M(int i2) {
        if (i2 != this.y) {
            if (this.G != null) {
                P(i2);
            } else if (i2 == 4 || i2 == 3 || i2 == 6 || (this.v && i2 == 5)) {
                this.y = i2;
            }
        }
    }

    public void N(int i2) {
        V v2;
        if (this.y != i2) {
            this.y = i2;
            WeakReference<V> weakReference = this.G;
            if (!(weakReference == null || (v2 = weakReference.get()) == null)) {
                if (i2 == 3) {
                    U(true);
                } else if (i2 == 6 || i2 == 5 || i2 == 4) {
                    U(false);
                }
                T(i2);
                for (int i3 = 0; i3 < this.I.size(); i3++) {
                    this.I.get(i3).b(v2, i2);
                }
                S();
            }
        }
    }

    public void O(View view, int i2) {
        int i3;
        int i4;
        if (i2 == 4) {
            i3 = this.t;
        } else if (i2 == 6) {
            i3 = this.r;
            if (this.b && i3 <= (i4 = this.q)) {
                i2 = 3;
                i3 = i4;
            }
        } else if (i2 == 3) {
            i3 = I();
        } else if (!this.v || i2 != 5) {
            throw new IllegalArgumentException(hj1.I("Illegal state argument: ", i2));
        } else {
            i3 = this.F;
        }
        R(view, i2, i3, false);
    }

    public final void P(int i2) {
        V v2 = this.G.get();
        if (v2 != null) {
            ViewParent parent = v2.getParent();
            if (parent != null && parent.isLayoutRequested()) {
                AtomicInteger atomicInteger = r8.f3055a;
                if (v2.isAttachedToWindow()) {
                    v2.post(new a(v2, i2));
                    return;
                }
            }
            O(v2, i2);
        }
    }

    public boolean Q(View view, float f2) {
        if (this.w) {
            return true;
        }
        if (view.getTop() < this.t) {
            return false;
        }
        if (Math.abs(((f2 * 0.1f) + ((float) view.getTop())) - ((float) this.t)) / ((float) D()) > 0.5f) {
            return true;
        }
        return false;
    }

    public void R(View view, int i2, int i3, boolean z2) {
        fa faVar = this.z;
        if (faVar != null && (!z2 ? faVar.y(view, view.getLeft(), i3) : faVar.w(view.getLeft(), i3))) {
            N(2);
            T(i2);
            if (this.n == null) {
                this.n = new d(view, i2);
            }
            BottomSheetBehavior<V>.d dVar = this.n;
            if (!dVar.g) {
                dVar.h = i2;
                AtomicInteger atomicInteger = r8.f3055a;
                view.postOnAnimation(dVar);
                this.n.g = true;
                return;
            }
            dVar.h = i2;
            return;
        }
        N(i2);
    }

    public final void S() {
        V v2;
        int i2;
        WeakReference<V> weakReference = this.G;
        if (weakReference != null && (v2 = weakReference.get()) != null) {
            r8.s(524288, v2);
            r8.m(v2, 0);
            r8.s(262144, v2);
            r8.m(v2, 0);
            r8.s(CommonUtils.BYTES_IN_A_MEGABYTE, v2);
            r8.m(v2, 0);
            int i3 = this.O;
            if (i3 != -1) {
                r8.s(i3, v2);
                r8.m(v2, 0);
            }
            int i4 = 6;
            if (this.y != 6) {
                String string = v2.getResources().getString(R.string.bottomsheet_action_expand_halfway);
                fl4 fl4 = new fl4(this, 6);
                List<e9.a> j2 = r8.j(v2);
                int i5 = 0;
                while (true) {
                    if (i5 >= j2.size()) {
                        int i6 = -1;
                        int i7 = 0;
                        while (true) {
                            int[] iArr = r8.f;
                            if (i7 >= iArr.length || i6 != -1) {
                                i2 = i6;
                            } else {
                                int i8 = iArr[i7];
                                boolean z2 = true;
                                for (int i9 = 0; i9 < j2.size(); i9++) {
                                    z2 &= j2.get(i9).a() != i8;
                                }
                                if (z2) {
                                    i6 = i8;
                                }
                                i7++;
                            }
                        }
                        i2 = i6;
                    } else if (TextUtils.equals(string, j2.get(i5).b())) {
                        i2 = j2.get(i5).a();
                        break;
                    } else {
                        i5++;
                    }
                }
                if (i2 != -1) {
                    r8.a(v2, new e9.a(null, i2, string, fl4, null));
                }
                this.O = i2;
            }
            if (this.v && this.y != 5) {
                J(v2, e9.a.l, 5);
            }
            int i10 = this.y;
            if (i10 == 3) {
                if (this.b) {
                    i4 = 4;
                }
                J(v2, e9.a.k, i4);
            } else if (i10 == 4) {
                if (this.b) {
                    i4 = 3;
                }
                J(v2, e9.a.j, i4);
            } else if (i10 == 6) {
                J(v2, e9.a.k, 4);
                J(v2, e9.a.j, 3);
            }
        }
    }

    public final void T(int i2) {
        ValueAnimator valueAnimator;
        if (i2 != 2) {
            boolean z2 = i2 == 3;
            if (this.m != z2) {
                this.m = z2;
                if (this.i != null && (valueAnimator = this.o) != null) {
                    if (valueAnimator.isRunning()) {
                        this.o.reverse();
                        return;
                    }
                    float f2 = z2 ? 0.0f : 1.0f;
                    this.o.setFloatValues(1.0f - f2, f2);
                    this.o.start();
                }
            }
        }
    }

    public final void U(boolean z2) {
        WeakReference<V> weakReference = this.G;
        if (weakReference != null) {
            ViewParent parent = weakReference.get().getParent();
            if (parent instanceof CoordinatorLayout) {
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
                int childCount = coordinatorLayout.getChildCount();
                if (z2) {
                    if (this.N == null) {
                        this.N = new HashMap(childCount);
                    } else {
                        return;
                    }
                }
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = coordinatorLayout.getChildAt(i2);
                    if (childAt != this.G.get() && z2) {
                        this.N.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                    }
                }
                if (!z2) {
                    this.N = null;
                }
            }
        }
    }

    public final void V(boolean z2) {
        V v2;
        if (this.G != null) {
            C();
            if (this.y == 4 && (v2 = this.G.get()) != null) {
                if (z2) {
                    P(this.y);
                } else {
                    v2.requestLayout();
                }
            }
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void f(CoordinatorLayout.f fVar) {
        this.G = null;
        this.z = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void i() {
        this.G = null;
        this.z = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean j(CoordinatorLayout coordinatorLayout, V v2, MotionEvent motionEvent) {
        fa faVar;
        if (!v2.isShown() || !this.x) {
            this.A = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        View view = null;
        if (actionMasked == 0) {
            this.K = -1;
            VelocityTracker velocityTracker = this.J;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.J = null;
            }
        }
        if (this.J == null) {
            this.J = VelocityTracker.obtain();
        }
        this.J.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x2 = (int) motionEvent.getX();
            this.L = (int) motionEvent.getY();
            if (this.y != 2) {
                WeakReference<View> weakReference = this.H;
                View view2 = weakReference != null ? weakReference.get() : null;
                if (view2 != null && coordinatorLayout.j(view2, x2, this.L)) {
                    this.K = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.M = true;
                }
            }
            this.A = this.K == -1 && !coordinatorLayout.j(v2, x2, this.L);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.M = false;
            this.K = -1;
            if (this.A) {
                this.A = false;
                return false;
            }
        }
        if (!this.A && (faVar = this.z) != null && faVar.x(motionEvent)) {
            return true;
        }
        WeakReference<View> weakReference2 = this.H;
        if (weakReference2 != null) {
            view = weakReference2.get();
        }
        if (actionMasked != 2 || view == null || this.A || this.y == 1 || coordinatorLayout.j(view, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.z == null || Math.abs(((float) this.L) - motionEvent.getY()) <= ((float) this.z.b)) {
            return false;
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout coordinatorLayout, V v2, int i2) {
        ho4 ho4;
        AtomicInteger atomicInteger = r8.f3055a;
        if (coordinatorLayout.getFitsSystemWindows() && !v2.getFitsSystemWindows()) {
            v2.setFitsSystemWindows(true);
        }
        if (this.G == null) {
            this.f = coordinatorLayout.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
            if (Build.VERSION.SDK_INT >= 29 && !this.k && !this.e) {
                r8.w(v2, new on4(new el4(this), new rn4(v2.getPaddingStart(), v2.getPaddingTop(), v2.getPaddingEnd(), v2.getPaddingBottom())));
                if (v2.isAttachedToWindow()) {
                    v2.requestApplyInsets();
                } else {
                    v2.addOnAttachStateChangeListener(new pn4());
                }
            }
            this.G = new WeakReference<>(v2);
            if (this.h && (ho4 = this.i) != null) {
                v2.setBackground(ho4);
            }
            ho4 ho42 = this.i;
            if (ho42 != null) {
                float f2 = this.u;
                if (f2 == -1.0f) {
                    f2 = v2.getElevation();
                }
                ho42.p(f2);
                boolean z2 = this.y == 3;
                this.m = z2;
                this.i.r(z2 ? 0.0f : 1.0f);
            }
            S();
            if (v2.getImportantForAccessibility() == 0) {
                v2.setImportantForAccessibility(1);
            }
        }
        if (this.z == null) {
            this.z = new fa(coordinatorLayout.getContext(), coordinatorLayout, this.P);
        }
        int top = v2.getTop();
        coordinatorLayout.l(v2, i2);
        this.E = coordinatorLayout.getWidth();
        this.F = coordinatorLayout.getHeight();
        int height = v2.getHeight();
        this.D = height;
        this.q = Math.max(0, this.F - height);
        this.r = (int) ((1.0f - this.s) * ((float) this.F));
        C();
        int i3 = this.y;
        if (i3 == 3) {
            r8.o(v2, I());
        } else if (i3 == 6) {
            r8.o(v2, this.r);
        } else if (this.v && i3 == 5) {
            r8.o(v2, this.F);
        } else if (i3 == 4) {
            r8.o(v2, this.t);
        } else if (i3 == 1 || i3 == 2) {
            r8.o(v2, top - v2.getTop());
        }
        this.H = new WeakReference<>(G(v2));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean n(CoordinatorLayout coordinatorLayout, V v2, View view, float f2, float f3) {
        WeakReference<View> weakReference = this.H;
        if (weakReference == null || view != weakReference.get() || this.y == 3) {
            return false;
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void p(CoordinatorLayout coordinatorLayout, V v2, View view, int i2, int i3, int[] iArr, int i4) {
        if (i4 != 1) {
            WeakReference<View> weakReference = this.H;
            if (view == (weakReference != null ? weakReference.get() : null)) {
                int top = v2.getTop();
                int i5 = top - i3;
                if (i3 > 0) {
                    if (i5 < I()) {
                        iArr[1] = top - I();
                        r8.o(v2, -iArr[1]);
                        N(3);
                    } else if (this.x) {
                        iArr[1] = i3;
                        r8.o(v2, -i3);
                        N(1);
                    } else {
                        return;
                    }
                } else if (i3 < 0 && !view.canScrollVertically(-1)) {
                    int i6 = this.t;
                    if (i5 > i6 && !this.v) {
                        iArr[1] = top - i6;
                        r8.o(v2, -iArr[1]);
                        N(4);
                    } else if (this.x) {
                        iArr[1] = i3;
                        r8.o(v2, -i3);
                        N(1);
                    } else {
                        return;
                    }
                }
                F(v2.getTop());
                this.B = i3;
                this.C = true;
            }
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void r(CoordinatorLayout coordinatorLayout, V v2, View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void u(CoordinatorLayout coordinatorLayout, V v2, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        savedState.getSuperState();
        int i2 = this.f617a;
        if (i2 != 0) {
            if (i2 == -1 || (i2 & 1) == 1) {
                this.d = savedState.g;
            }
            if (i2 == -1 || (i2 & 2) == 2) {
                this.b = savedState.h;
            }
            if (i2 == -1 || (i2 & 4) == 4) {
                this.v = savedState.i;
            }
            if (i2 == -1 || (i2 & 8) == 8) {
                this.w = savedState.j;
            }
        }
        int i3 = savedState.f;
        if (i3 == 1 || i3 == 2) {
            this.y = 4;
        } else {
            this.y = i3;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public Parcelable v(CoordinatorLayout coordinatorLayout, V v2) {
        return new SavedState((Parcelable) View.BaseSavedState.EMPTY_STATE, (BottomSheetBehavior<?>) this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean x(CoordinatorLayout coordinatorLayout, V v2, View view, View view2, int i2, int i3) {
        this.B = 0;
        this.C = false;
        if ((i2 & 2) != 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void z(CoordinatorLayout coordinatorLayout, V v2, View view, int i2) {
        int i3;
        float f2;
        int i4 = 3;
        if (v2.getTop() == I()) {
            N(3);
            return;
        }
        WeakReference<View> weakReference = this.H;
        if (weakReference != null && view == weakReference.get() && this.C) {
            if (this.B > 0) {
                if (this.b) {
                    i3 = this.q;
                } else {
                    int top = v2.getTop();
                    int i5 = this.r;
                    if (top > i5) {
                        i3 = i5;
                    } else {
                        i3 = this.p;
                    }
                }
                R(v2, i4, i3, false);
                this.C = false;
            }
            if (this.v) {
                VelocityTracker velocityTracker = this.J;
                if (velocityTracker == null) {
                    f2 = 0.0f;
                } else {
                    velocityTracker.computeCurrentVelocity(Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL, this.c);
                    f2 = this.J.getYVelocity(this.K);
                }
                if (Q(v2, f2)) {
                    i3 = this.F;
                    i4 = 5;
                    R(v2, i4, i3, false);
                    this.C = false;
                }
            }
            if (this.B == 0) {
                int top2 = v2.getTop();
                if (!this.b) {
                    int i6 = this.r;
                    if (top2 < i6) {
                        if (top2 < Math.abs(top2 - this.t)) {
                            i3 = this.p;
                            R(v2, i4, i3, false);
                            this.C = false;
                        }
                        i3 = this.r;
                    } else if (Math.abs(top2 - i6) < Math.abs(top2 - this.t)) {
                        i3 = this.r;
                    } else {
                        i3 = this.t;
                    }
                } else if (Math.abs(top2 - this.q) < Math.abs(top2 - this.t)) {
                    i3 = this.q;
                    R(v2, i4, i3, false);
                    this.C = false;
                } else {
                    i3 = this.t;
                }
            } else if (this.b) {
                i3 = this.t;
            } else {
                int top3 = v2.getTop();
                if (Math.abs(top3 - this.r) < Math.abs(top3 - this.t)) {
                    i3 = this.r;
                } else {
                    i3 = this.t;
                }
            }
            i4 = 4;
            R(v2, i4, i3, false);
            this.C = false;
            i4 = 6;
            R(v2, i4, i3, false);
            this.C = false;
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public final int f;
        public int g;
        public boolean h;
        public boolean i;
        public boolean j;

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
                return new SavedState(parcel, (ClassLoader) null);
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f = parcel.readInt();
            this.g = parcel.readInt();
            boolean z = false;
            this.h = parcel.readInt() == 1;
            this.i = parcel.readInt() == 1;
            this.j = parcel.readInt() == 1 ? true : z;
        }

        @Override // androidx.customview.view.AbsSavedState
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f);
            parcel.writeInt(this.g);
            parcel.writeInt(this.h ? 1 : 0);
            parcel.writeInt(this.i ? 1 : 0);
            parcel.writeInt(this.j ? 1 : 0);
        }

        public SavedState(Parcelable parcelable, BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.f = bottomSheetBehavior.y;
            this.g = bottomSheetBehavior.d;
            this.h = bottomSheetBehavior.b;
            this.i = bottomSheetBehavior.v;
            this.j = bottomSheetBehavior.w;
        }
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i2;
        this.g = context.getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BottomSheetBehavior_Layout);
        this.h = obtainStyledAttributes.hasValue(R.styleable.BottomSheetBehavior_Layout_shapeAppearance);
        int i3 = R.styleable.BottomSheetBehavior_Layout_backgroundTint;
        boolean hasValue = obtainStyledAttributes.hasValue(i3);
        if (hasValue) {
            E(context, attributeSet, hasValue, hd3.h1(context, obtainStyledAttributes, i3));
        } else {
            E(context, attributeSet, hasValue, null);
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.o = ofFloat;
        ofFloat.setDuration(500L);
        this.o.addUpdateListener(new dl4(this));
        this.u = obtainStyledAttributes.getDimension(R.styleable.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        int i4 = R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight;
        TypedValue peekValue = obtainStyledAttributes.peekValue(i4);
        if (peekValue == null || (i2 = peekValue.data) != -1) {
            L(obtainStyledAttributes.getDimensionPixelSize(i4, -1));
        } else {
            L(i2);
        }
        K(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        this.k = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_gestureInsetBottomIgnored, false);
        boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true);
        if (this.b != z2) {
            this.b = z2;
            if (this.G != null) {
                C();
            }
            N((!this.b || this.y != 6) ? this.y : 3);
            S();
        }
        this.w = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false);
        this.x = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_draggable, true);
        this.f617a = obtainStyledAttributes.getInt(R.styleable.BottomSheetBehavior_Layout_behavior_saveFlags, 0);
        float f2 = obtainStyledAttributes.getFloat(R.styleable.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, 0.5f);
        if (f2 <= 0.0f || f2 >= 1.0f) {
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.s = f2;
        if (this.G != null) {
            this.r = (int) ((1.0f - f2) * ((float) this.F));
        }
        int i5 = R.styleable.BottomSheetBehavior_Layout_behavior_expandedOffset;
        TypedValue peekValue2 = obtainStyledAttributes.peekValue(i5);
        if (peekValue2 == null || peekValue2.type != 16) {
            int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(i5, 0);
            if (dimensionPixelOffset >= 0) {
                this.p = dimensionPixelOffset;
            } else {
                throw new IllegalArgumentException("offset must be greater than or equal to 0");
            }
        } else {
            int i6 = peekValue2.data;
            if (i6 >= 0) {
                this.p = i6;
            } else {
                throw new IllegalArgumentException("offset must be greater than or equal to 0");
            }
        }
        obtainStyledAttributes.recycle();
        this.c = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
