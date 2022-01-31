package androidx.viewpager2.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.R;
import defpackage.e9;
import defpackage.fp;
import defpackage.g9;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public final class ViewPager2 extends ViewGroup {
    public final Rect f = new Rect();
    public final Rect g = new Rect();
    public cp h = new cp(3);
    public int i;
    public boolean j = false;
    public RecyclerView.g k = new a();
    public LinearLayoutManager l;
    public int m = -1;
    public Parcelable n;
    public RecyclerView o;
    public wk p;
    public fp q;
    public cp r;
    public dp s;
    public ep t;
    public RecyclerView.j u = null;
    public boolean v = false;
    public boolean w = true;
    public int x = -1;
    public b y = new f();

    public class a extends c {
        public a() {
            super(null);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void a() {
            ViewPager2 viewPager2 = ViewPager2.this;
            viewPager2.j = true;
            viewPager2.q.l = true;
        }
    }

    public abstract class b {
        public b(ViewPager2 viewPager2, a aVar) {
        }

        public abstract void a(cp cpVar, RecyclerView recyclerView);

        public abstract void b();
    }

    public static abstract class c extends RecyclerView.g {
        public c(a aVar) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public final void b(int i, int i2) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public final void c(int i, int i2, Object obj) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public final void d(int i, int i2) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public final void e(int i, int i2, int i3) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public final void f(int i, int i2) {
            a();
        }
    }

    public class d extends LinearLayoutManager {
        public d(Context context) {
            super(1, false);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.m
        public boolean O0(RecyclerView.t tVar, RecyclerView.x xVar, int i, Bundle bundle) {
            Objects.requireNonNull(ViewPager2.this.y);
            return super.O0(tVar, xVar, i, bundle);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.m
        public boolean V0(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            return false;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public void l1(RecyclerView.x xVar, int[] iArr) {
            int offscreenPageLimit = ViewPager2.this.getOffscreenPageLimit();
            if (offscreenPageLimit == -1) {
                super.l1(xVar, iArr);
                return;
            }
            int pageSize = ViewPager2.this.getPageSize() * offscreenPageLimit;
            iArr[0] = pageSize;
            iArr[1] = pageSize;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.m
        public void w0(RecyclerView.t tVar, RecyclerView.x xVar, e9 e9Var) {
            super.w0(tVar, xVar, e9Var);
            Objects.requireNonNull(ViewPager2.this.y);
        }
    }

    public static abstract class e {
        public void a(int i) {
        }

        public void b(int i, float f, int i2) {
        }

        public void c(int i) {
        }
    }

    public class f extends b {

        /* renamed from: a  reason: collision with root package name */
        public final g9 f255a = new a();
        public final g9 b = new b();
        public RecyclerView.g c;

        public class a implements g9 {
            public a() {
            }

            @Override // defpackage.g9
            public boolean a(View view, g9.a aVar) {
                f.this.c(((ViewPager2) view).getCurrentItem() + 1);
                return true;
            }
        }

        public class b implements g9 {
            public b() {
            }

            @Override // defpackage.g9
            public boolean a(View view, g9.a aVar) {
                f.this.c(((ViewPager2) view).getCurrentItem() - 1);
                return true;
            }
        }

        public class c extends c {
            public c() {
                super(null);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.g
            public void a() {
                f.this.d();
            }
        }

        public f() {
            super(ViewPager2.this, null);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.b
        public void a(cp cpVar, RecyclerView recyclerView) {
            AtomicInteger atomicInteger = r8.f3055a;
            recyclerView.setImportantForAccessibility(2);
            this.c = new c();
            if (ViewPager2.this.getImportantForAccessibility() == 0) {
                ViewPager2.this.setImportantForAccessibility(1);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.b
        public void b() {
            d();
        }

        public void c(int i) {
            ViewPager2 viewPager2 = ViewPager2.this;
            if (viewPager2.w) {
                viewPager2.d(i, true);
            }
        }

        public void d() {
            int itemCount;
            ViewPager2 viewPager2 = ViewPager2.this;
            int i = 16908360;
            r8.r(viewPager2, 16908360);
            r8.r(viewPager2, 16908361);
            r8.r(viewPager2, 16908358);
            r8.r(viewPager2, 16908359);
            if (ViewPager2.this.getAdapter() != null && (itemCount = ViewPager2.this.getAdapter().getItemCount()) != 0) {
                ViewPager2 viewPager22 = ViewPager2.this;
                if (viewPager22.w) {
                    if (viewPager22.getOrientation() == 0) {
                        boolean a2 = ViewPager2.this.a();
                        int i2 = a2 ? 16908360 : 16908361;
                        if (a2) {
                            i = 16908361;
                        }
                        if (ViewPager2.this.i < itemCount - 1) {
                            r8.t(viewPager2, new e9.a(i2, null), null, this.f255a);
                        }
                        if (ViewPager2.this.i > 0) {
                            r8.t(viewPager2, new e9.a(i, null), null, this.b);
                            return;
                        }
                        return;
                    }
                    if (ViewPager2.this.i < itemCount - 1) {
                        r8.t(viewPager2, new e9.a(16908359, null), null, this.f255a);
                    }
                    if (ViewPager2.this.i > 0) {
                        r8.t(viewPager2, new e9.a(16908358, null), null, this.b);
                    }
                }
            }
        }
    }

    public interface g {
        void a(View view, float f);
    }

    public class h extends wk {
        public h() {
        }

        @Override // defpackage.wk, defpackage.bl
        public View c(RecyclerView.m mVar) {
            if (ViewPager2.this.s.f873a.m) {
                return null;
            }
            return super.c(mVar);
        }
    }

    public class i extends RecyclerView {
        public i(Context context) {
            super(context, null);
        }

        @Override // androidx.recyclerview.widget.RecyclerView
        public CharSequence getAccessibilityClassName() {
            Objects.requireNonNull(ViewPager2.this.y);
            return super.getAccessibilityClassName();
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setFromIndex(ViewPager2.this.i);
            accessibilityEvent.setToIndex(ViewPager2.this.i);
            accessibilityEvent.setSource(ViewPager2.this);
            accessibilityEvent.setClassName("androidx.viewpager.widget.ViewPager");
        }

        @Override // androidx.recyclerview.widget.RecyclerView
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.w && super.onInterceptTouchEvent(motionEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.w && super.onTouchEvent(motionEvent);
        }
    }

    public static class j implements Runnable {
        public final int f;
        public final RecyclerView g;

        public j(int i, RecyclerView recyclerView) {
            this.f = i;
            this.g = recyclerView;
        }

        public void run() {
            this.g.l0(this.f);
        }
    }

    /* JADX INFO: finally extract failed */
    public ViewPager2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        i iVar = new i(context);
        this.o = iVar;
        AtomicInteger atomicInteger = r8.f3055a;
        iVar.setId(View.generateViewId());
        this.o.setDescendantFocusability(131072);
        d dVar = new d(context);
        this.l = dVar;
        this.o.setLayoutManager(dVar);
        this.o.setScrollingTouchSlop(1);
        int[] iArr = R.styleable.ViewPager2;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, iArr, attributeSet, obtainStyledAttributes, 0, 0);
        }
        try {
            setOrientation(obtainStyledAttributes.getInt(R.styleable.ViewPager2_android_orientation, 0));
            obtainStyledAttributes.recycle();
            this.o.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            RecyclerView recyclerView = this.o;
            ip ipVar = new ip(this);
            if (recyclerView.I == null) {
                recyclerView.I = new ArrayList();
            }
            recyclerView.I.add(ipVar);
            fp fpVar = new fp(this);
            this.q = fpVar;
            this.s = new dp(this, fpVar, this.o);
            h hVar = new h();
            this.p = hVar;
            hVar.a(this.o);
            this.o.g(this.q);
            cp cpVar = new cp(3);
            this.r = cpVar;
            this.q.f1153a = cpVar;
            gp gpVar = new gp(this);
            hp hpVar = new hp(this);
            cpVar.f740a.add(gpVar);
            this.r.f740a.add(hpVar);
            this.y.a(this.r, this.o);
            cp cpVar2 = this.r;
            cpVar2.f740a.add(this.h);
            ep epVar = new ep(this.l);
            this.t = epVar;
            this.r.f740a.add(epVar);
            RecyclerView recyclerView2 = this.o;
            attachViewToParent(recyclerView2, 0, recyclerView2.getLayoutParams());
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public boolean a() {
        return this.l.W() == 1;
    }

    public void b(e eVar) {
        this.h.f740a.add(eVar);
    }

    public final void c() {
        RecyclerView.e adapter;
        if (this.m != -1 && (adapter = getAdapter()) != null) {
            Parcelable parcelable = this.n;
            if (parcelable != null) {
                if (adapter instanceof zo) {
                    ((zo) adapter).b(parcelable);
                }
                this.n = null;
            }
            int max = Math.max(0, Math.min(this.m, adapter.getItemCount() - 1));
            this.i = max;
            this.m = -1;
            this.o.i0(max);
            ((f) this.y).d();
        }
    }

    public boolean canScrollHorizontally(int i2) {
        return this.o.canScrollHorizontally(i2);
    }

    public boolean canScrollVertically(int i2) {
        return this.o.canScrollVertically(i2);
    }

    public void d(int i2, boolean z) {
        RecyclerView.e adapter = getAdapter();
        boolean z2 = false;
        if (adapter == null) {
            if (this.m != -1) {
                this.m = Math.max(i2, 0);
            }
        } else if (adapter.getItemCount() > 0) {
            int min = Math.min(Math.max(i2, 0), adapter.getItemCount() - 1);
            int i3 = this.i;
            if (min == i3) {
                if (this.q.f == 0) {
                    return;
                }
            }
            if (min != i3 || !z) {
                double d2 = (double) i3;
                this.i = min;
                ((f) this.y).d();
                fp fpVar = this.q;
                if (!(fpVar.f == 0)) {
                    fpVar.d();
                    fp.a aVar = fpVar.g;
                    d2 = ((double) aVar.f1154a) + ((double) aVar.b);
                }
                fp fpVar2 = this.q;
                fpVar2.e = z ? 2 : 3;
                fpVar2.m = false;
                if (fpVar2.i != min) {
                    z2 = true;
                }
                fpVar2.i = min;
                fpVar2.b(2);
                if (z2) {
                    fpVar2.a(min);
                }
                if (!z) {
                    this.o.i0(min);
                    return;
                }
                double d3 = (double) min;
                if (Math.abs(d3 - d2) > 3.0d) {
                    this.o.i0(d3 > d2 ? min - 3 : min + 3);
                    RecyclerView recyclerView = this.o;
                    recyclerView.post(new j(min, recyclerView));
                    return;
                }
                this.o.l0(min);
            }
        }
    }

    @Override // android.view.View, android.view.ViewGroup
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        Parcelable parcelable = sparseArray.get(getId());
        if (parcelable instanceof SavedState) {
            int i2 = ((SavedState) parcelable).f;
            sparseArray.put(this.o.getId(), sparseArray.get(i2));
            sparseArray.remove(i2);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        c();
    }

    public void e() {
        wk wkVar = this.p;
        if (wkVar != null) {
            View c2 = wkVar.c(this.l);
            if (c2 != null) {
                int a0 = this.l.a0(c2);
                if (a0 != this.i && getScrollState() == 0) {
                    this.r.c(a0);
                }
                this.j = false;
                return;
            }
            return;
        }
        throw new IllegalStateException("Design assumption violated.");
    }

    public CharSequence getAccessibilityClassName() {
        Objects.requireNonNull(this.y);
        Objects.requireNonNull(this.y);
        return "androidx.viewpager.widget.ViewPager";
    }

    public RecyclerView.e getAdapter() {
        return this.o.getAdapter();
    }

    public int getCurrentItem() {
        return this.i;
    }

    public int getItemDecorationCount() {
        return this.o.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.x;
    }

    public int getOrientation() {
        return this.l.x;
    }

    public int getPageSize() {
        int i2;
        int i3;
        RecyclerView recyclerView = this.o;
        if (getOrientation() == 0) {
            i2 = recyclerView.getWidth() - recyclerView.getPaddingLeft();
            i3 = recyclerView.getPaddingRight();
        } else {
            i2 = recyclerView.getHeight() - recyclerView.getPaddingTop();
            i3 = recyclerView.getPaddingBottom();
        }
        return i2 - i3;
    }

    public int getScrollState() {
        return this.q.f;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo r6) {
        /*
        // Method dump skipped, instructions count: 109
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager2.widget.ViewPager2.onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo):void");
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int measuredWidth = this.o.getMeasuredWidth();
        int measuredHeight = this.o.getMeasuredHeight();
        this.f.left = getPaddingLeft();
        this.f.right = (i4 - i2) - getPaddingRight();
        this.f.top = getPaddingTop();
        this.f.bottom = (i5 - i3) - getPaddingBottom();
        Gravity.apply(8388659, measuredWidth, measuredHeight, this.f, this.g);
        RecyclerView recyclerView = this.o;
        Rect rect = this.g;
        recyclerView.layout(rect.left, rect.top, rect.right, rect.bottom);
        if (this.j) {
            e();
        }
    }

    public void onMeasure(int i2, int i3) {
        measureChild(this.o, i2, i3);
        int measuredWidth = this.o.getMeasuredWidth();
        int measuredHeight = this.o.getMeasuredHeight();
        int measuredState = this.o.getMeasuredState();
        int paddingRight = getPaddingRight() + getPaddingLeft() + measuredWidth;
        int paddingTop = getPaddingTop();
        setMeasuredDimension(ViewGroup.resolveSizeAndState(Math.max(paddingRight, getSuggestedMinimumWidth()), i2, measuredState), ViewGroup.resolveSizeAndState(Math.max(getPaddingBottom() + paddingTop + measuredHeight, getSuggestedMinimumHeight()), i3, measuredState << 16));
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.m = savedState.g;
        this.n = savedState.h;
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f = this.o.getId();
        int i2 = this.m;
        if (i2 == -1) {
            i2 = this.i;
        }
        savedState.g = i2;
        Parcelable parcelable = this.n;
        if (parcelable != null) {
            savedState.h = parcelable;
        } else {
            RecyclerView.e adapter = this.o.getAdapter();
            if (adapter instanceof zo) {
                savedState.h = ((zo) adapter).a();
            }
        }
        return savedState;
    }

    public void onViewAdded(View view) {
        throw new IllegalStateException(ViewPager2.class.getSimpleName() + " does not support direct child views");
    }

    public boolean performAccessibilityAction(int i2, Bundle bundle) {
        int i3;
        Objects.requireNonNull((f) this.y);
        boolean z = false;
        if (!(i2 == 8192 || i2 == 4096)) {
            return super.performAccessibilityAction(i2, bundle);
        }
        f fVar = (f) this.y;
        Objects.requireNonNull(fVar);
        if (i2 == 8192 || i2 == 4096) {
            z = true;
        }
        if (z) {
            if (i2 == 8192) {
                i3 = ViewPager2.this.getCurrentItem() - 1;
            } else {
                i3 = ViewPager2.this.getCurrentItem() + 1;
            }
            fVar.c(i3);
            return true;
        }
        throw new IllegalStateException();
    }

    public void setAdapter(RecyclerView.e eVar) {
        RecyclerView.e adapter = this.o.getAdapter();
        f fVar = (f) this.y;
        Objects.requireNonNull(fVar);
        if (adapter != null) {
            adapter.unregisterAdapterDataObserver(fVar.c);
        }
        if (adapter != null) {
            adapter.unregisterAdapterDataObserver(this.k);
        }
        this.o.setAdapter(eVar);
        this.i = 0;
        c();
        f fVar2 = (f) this.y;
        fVar2.d();
        if (eVar != null) {
            eVar.registerAdapterDataObserver(fVar2.c);
        }
        if (eVar != null) {
            eVar.registerAdapterDataObserver(this.k);
        }
    }

    public void setCurrentItem(int i2) {
        if (!this.s.f873a.m) {
            d(i2, true);
            return;
        }
        throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
    }

    public void setLayoutDirection(int i2) {
        super.setLayoutDirection(i2);
        ((f) this.y).d();
    }

    public void setOffscreenPageLimit(int i2) {
        if (i2 >= 1 || i2 == -1) {
            this.x = i2;
            this.o.requestLayout();
            return;
        }
        throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
    }

    public void setOrientation(int i2) {
        this.l.M1(i2);
        ((f) this.y).d();
    }

    public void setPageTransformer(g gVar) {
        if (gVar != null) {
            if (!this.v) {
                this.u = this.o.getItemAnimator();
                this.v = true;
            }
            this.o.setItemAnimator(null);
        } else if (this.v) {
            this.o.setItemAnimator(this.u);
            this.u = null;
            this.v = false;
        }
        ep epVar = this.t;
        if (gVar != epVar.b) {
            epVar.b = gVar;
            if (gVar != null) {
                fp fpVar = this.q;
                fpVar.d();
                fp.a aVar = fpVar.g;
                double d2 = ((double) aVar.f1154a) + ((double) aVar.b);
                int i2 = (int) d2;
                float f2 = (float) (d2 - ((double) i2));
                this.t.b(i2, f2, Math.round(((float) getPageSize()) * f2));
            }
        }
    }

    public void setUserInputEnabled(boolean z) {
        this.w = z;
        ((f) this.y).d();
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public int f;
        public int g;
        public Parcelable h;

        public static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public Object createFromParcel(Parcel parcel) {
                return Build.VERSION.SDK_INT >= 24 ? new SavedState(parcel, null) : new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public Object[] newArray(int i) {
                return new SavedState[i];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return Build.VERSION.SDK_INT >= 24 ? new SavedState(parcel, classLoader) : new SavedState(parcel);
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f = parcel.readInt();
            this.g = parcel.readInt();
            this.h = parcel.readParcelable(classLoader);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f);
            parcel.writeInt(this.g);
            parcel.writeParcelable(this.h, i);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f = parcel.readInt();
            this.g = parcel.readInt();
            this.h = parcel.readParcelable(null);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }
}
