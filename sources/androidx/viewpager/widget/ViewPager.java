package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.customview.view.AbsSavedState;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.appindexing.Indexable;
import com.google.firebase.perf.util.Constants;
import defpackage.q5;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class ViewPager extends ViewGroup {
    public static final int[] e0 = {16842931};
    public static final Comparator<e> f0 = new a();
    public static final Interpolator g0 = new b();
    public static final l h0 = new l();
    public boolean A;
    public int B = 1;
    public boolean C;
    public boolean D;
    public int E;
    public int F;
    public int G;
    public float H;
    public float I;
    public float J;
    public float K;
    public int L = -1;
    public VelocityTracker M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public EdgeEffect R;
    public EdgeEffect S;
    public boolean T = true;
    public boolean U;
    public int V;
    public List<i> W;
    public i a0;
    public List<h> b0;
    public final Runnable c0 = new c();
    public int d0 = 0;
    public int f;
    public final ArrayList<e> g = new ArrayList<>();
    public final e h = new e();
    public final Rect i = new Rect();
    public ro j;
    public int k;
    public int l = -1;
    public Parcelable m = null;
    public ClassLoader n = null;
    public Scroller o;
    public boolean p;
    public j q;
    public int r;
    public Drawable s;
    public int t;
    public int u;
    public float v = -3.4028235E38f;
    public float w = Float.MAX_VALUE;
    public int x;
    public boolean y;
    public boolean z;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public int f;
        public Parcelable g;
        public ClassLoader h;

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

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            StringBuilder i0 = hj1.i0("FragmentPager.SavedState{");
            i0.append(Integer.toHexString(System.identityHashCode(this)));
            i0.append(" position=");
            return hj1.X(i0, this.f, "}");
        }

        @Override // androidx.customview.view.AbsSavedState
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f);
            parcel.writeParcelable(this.g, i);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? SavedState.class.getClassLoader() : classLoader;
            this.f = parcel.readInt();
            this.g = parcel.readParcelable(classLoader);
            this.h = classLoader;
        }
    }

    public static class a implements Comparator<e>, j$.util.Comparator {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // j$.util.Comparator, java.util.Comparator
        public int compare(e eVar, e eVar2) {
            return eVar.b - eVar2.b;
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ Comparator<e> reversed() {
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
        public /* synthetic */ java.util.Comparator<e> thenComparing(java.util.Comparator<? super e> comparator) {
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

    public static class b implements Interpolator {
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            ViewPager.this.setScrollState(0);
            ViewPager viewPager = ViewPager.this;
            viewPager.q(viewPager.k);
        }
    }

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    public @interface d {
    }

    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public Object f250a;
        public int b;
        public boolean c;
        public float d;
        public float e;
    }

    public class g extends z7 {
        public g() {
        }

        @Override // defpackage.z7
        public void c(View view, AccessibilityEvent accessibilityEvent) {
            ro roVar;
            this.f4141a.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            ro roVar2 = ViewPager.this.j;
            boolean z = true;
            if (roVar2 == null || roVar2.d() <= 1) {
                z = false;
            }
            accessibilityEvent.setScrollable(z);
            if (accessibilityEvent.getEventType() == 4096 && (roVar = ViewPager.this.j) != null) {
                accessibilityEvent.setItemCount(roVar.d());
                accessibilityEvent.setFromIndex(ViewPager.this.k);
                accessibilityEvent.setToIndex(ViewPager.this.k);
            }
        }

        @Override // defpackage.z7
        public void d(View view, e9 e9Var) {
            this.f4141a.onInitializeAccessibilityNodeInfo(view, e9Var.f942a);
            e9Var.f942a.setClassName(ViewPager.class.getName());
            ro roVar = ViewPager.this.j;
            e9Var.f942a.setScrollable(roVar != null && roVar.d() > 1);
            if (ViewPager.this.canScrollHorizontally(1)) {
                e9Var.f942a.addAction(4096);
            }
            if (ViewPager.this.canScrollHorizontally(-1)) {
                e9Var.f942a.addAction(RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST);
            }
        }

        @Override // defpackage.z7
        public boolean g(View view, int i, Bundle bundle) {
            if (super.g(view, i, bundle)) {
                return true;
            }
            if (i != 4096) {
                if (i != 8192 || !ViewPager.this.canScrollHorizontally(-1)) {
                    return false;
                }
                ViewPager viewPager = ViewPager.this;
                viewPager.setCurrentItem(viewPager.k - 1);
                return true;
            } else if (!ViewPager.this.canScrollHorizontally(1)) {
                return false;
            } else {
                ViewPager viewPager2 = ViewPager.this;
                viewPager2.setCurrentItem(viewPager2.k + 1);
                return true;
            }
        }
    }

    public interface h {
        void a(ViewPager viewPager, ro roVar, ro roVar2);
    }

    public interface i {
        void a(int i, float f, int i2);

        void b(int i);

        void c(int i);
    }

    public class j extends DataSetObserver {
        public j() {
        }

        public void onChanged() {
            ViewPager.this.e();
        }

        public void onInvalidated() {
            ViewPager.this.e();
        }
    }

    public static class k implements i {
        @Override // androidx.viewpager.widget.ViewPager.i
        public void a(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void b(int i) {
        }
    }

    public static class l implements java.util.Comparator<View>, j$.util.Comparator {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // j$.util.Comparator, java.util.Comparator
        public int compare(View view, View view2) {
            f fVar = (f) view.getLayoutParams();
            f fVar2 = (f) view2.getLayoutParams();
            boolean z = fVar.f251a;
            if (z != fVar2.f251a) {
                return z ? 1 : -1;
            }
            return fVar.e - fVar2.e;
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ java.util.Comparator<View> reversed() {
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

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context2 = getContext();
        this.o = new Scroller(context2, g0);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context2);
        float f2 = context2.getResources().getDisplayMetrics().density;
        this.G = viewConfiguration.getScaledPagingTouchSlop();
        this.N = (int) (400.0f * f2);
        this.O = viewConfiguration.getScaledMaximumFlingVelocity();
        this.R = new EdgeEffect(context2);
        this.S = new EdgeEffect(context2);
        this.P = (int) (25.0f * f2);
        this.Q = (int) (2.0f * f2);
        this.E = (int) (f2 * 16.0f);
        r8.v(this, new g());
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        r8.w(this, new so(this));
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void setScrollingCacheEnabled(boolean z2) {
        if (this.z != z2) {
            this.z = z2;
        }
    }

    public e a(int i2, int i3) {
        e eVar = new e();
        eVar.b = i2;
        eVar.f250a = this.j.f(this, i2);
        Objects.requireNonNull(this.j);
        eVar.d = 1.0f;
        if (i3 < 0 || i3 >= this.g.size()) {
            this.g.add(eVar);
        } else {
            this.g.add(i3, eVar);
        }
        return eVar;
    }

    @Override // android.view.View, android.view.ViewGroup
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        e h2;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getVisibility() == 0 && (h2 = h(childAt)) != null && h2.b == this.k) {
                    childAt.addFocusables(arrayList, i2, i3);
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if ((i3 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) {
            arrayList.add(this);
        }
    }

    @Override // android.view.View, android.view.ViewGroup
    public void addTouchables(ArrayList<View> arrayList) {
        e h2;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (h2 = h(childAt)) != null && h2.b == this.k) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        f fVar = (f) layoutParams;
        boolean z2 = fVar.f251a | (view.getClass().getAnnotation(d.class) != null);
        fVar.f251a = z2;
        if (!this.y) {
            super.addView(view, i2, layoutParams);
        } else if (!z2) {
            fVar.d = true;
            addViewInLayout(view, i2, layoutParams);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean b(int r7) {
        /*
        // Method dump skipped, instructions count: 192
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.b(int):boolean");
    }

    public boolean c(View view, boolean z2, int i2, int i3, int i4) {
        int i5;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i6 = i3 + scrollX;
                if (i6 >= childAt.getLeft() && i6 < childAt.getRight() && (i5 = i4 + scrollY) >= childAt.getTop() && i5 < childAt.getBottom() && c(childAt, true, i2, i6 - childAt.getLeft(), i5 - childAt.getTop())) {
                    return true;
                }
            }
        }
        if (!z2 || !view.canScrollHorizontally(-i2)) {
            return false;
        }
        return true;
    }

    public boolean canScrollHorizontally(int i2) {
        if (this.j == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i2 < 0) {
            if (scrollX > ((int) (((float) clientWidth) * this.v))) {
                return true;
            }
            return false;
        } else if (i2 <= 0 || scrollX >= ((int) (((float) clientWidth) * this.w))) {
            return false;
        } else {
            return true;
        }
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof f) && super.checkLayoutParams(layoutParams);
    }

    public void computeScroll() {
        this.p = true;
        if (this.o.isFinished() || !this.o.computeScrollOffset()) {
            d(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.o.getCurrX();
        int currY = this.o.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!o(currX)) {
                this.o.abortAnimation();
                scrollTo(0, currY);
            }
        }
        AtomicInteger atomicInteger = r8.f3055a;
        postInvalidateOnAnimation();
    }

    public final void d(boolean z2) {
        boolean z3 = this.d0 == 2;
        if (z3) {
            setScrollingCacheEnabled(false);
            if (!this.o.isFinished()) {
                this.o.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.o.getCurrX();
                int currY = this.o.getCurrY();
                if (!(scrollX == currX && scrollY == currY)) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        o(currX);
                    }
                }
            }
        }
        this.A = false;
        for (int i2 = 0; i2 < this.g.size(); i2++) {
            e eVar = this.g.get(i2);
            if (eVar.c) {
                eVar.c = false;
                z3 = true;
            }
        }
        if (!z3) {
            return;
        }
        if (z2) {
            Runnable runnable = this.c0;
            AtomicInteger atomicInteger = r8.f3055a;
            postOnAnimation(runnable);
            return;
        }
        this.c0.run();
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchKeyEvent(android.view.KeyEvent r6) {
        /*
            r5 = this;
            boolean r0 = super.dispatchKeyEvent(r6)
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x005d
            int r0 = r6.getAction()
            if (r0 != 0) goto L_0x005a
            int r0 = r6.getKeyCode()
            r3 = 21
            r4 = 2
            if (r0 == r3) goto L_0x0048
            r3 = 22
            if (r0 == r3) goto L_0x0036
            r3 = 61
            if (r0 == r3) goto L_0x0020
            goto L_0x005a
        L_0x0020:
            boolean r0 = r6.hasNoModifiers()
            if (r0 == 0) goto L_0x002b
            boolean r6 = r5.b(r4)
            goto L_0x005b
        L_0x002b:
            boolean r6 = r6.hasModifiers(r2)
            if (r6 == 0) goto L_0x005a
            boolean r6 = r5.b(r2)
            goto L_0x005b
        L_0x0036:
            boolean r6 = r6.hasModifiers(r4)
            if (r6 == 0) goto L_0x0041
            boolean r6 = r5.n()
            goto L_0x005b
        L_0x0041:
            r6 = 66
            boolean r6 = r5.b(r6)
            goto L_0x005b
        L_0x0048:
            boolean r6 = r6.hasModifiers(r4)
            if (r6 == 0) goto L_0x0053
            boolean r6 = r5.m()
            goto L_0x005b
        L_0x0053:
            r6 = 17
            boolean r6 = r5.b(r6)
            goto L_0x005b
        L_0x005a:
            r6 = 0
        L_0x005b:
            if (r6 == 0) goto L_0x005e
        L_0x005d:
            r1 = 1
        L_0x005e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        e h2;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (h2 = h(childAt)) != null && h2.b == this.k && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    public void draw(Canvas canvas) {
        ro roVar;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean z2 = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (roVar = this.j) != null && roVar.d() > 1)) {
            if (!this.R.isFinished()) {
                int save = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float) (getPaddingTop() + (-height)), this.v * ((float) width));
                this.R.setSize(height, width);
                z2 = false | this.R.draw(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.S.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.w + 1.0f)) * ((float) width2));
                this.S.setSize(height2, width2);
                z2 |= this.S.draw(canvas);
                canvas.restoreToCount(save2);
            }
        } else {
            this.R.finish();
            this.S.finish();
        }
        if (z2) {
            AtomicInteger atomicInteger = r8.f3055a;
            postInvalidateOnAnimation();
        }
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.s;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    public void e() {
        int d2 = this.j.d();
        this.f = d2;
        boolean z2 = this.g.size() < (this.B * 2) + 1 && this.g.size() < d2;
        int i2 = this.k;
        for (int i3 = 0; i3 < this.g.size(); i3++) {
            ro roVar = this.j;
            Object obj = this.g.get(i3).f250a;
            Objects.requireNonNull(roVar);
        }
        Collections.sort(this.g, f0);
        if (z2) {
            int childCount = getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                f fVar = (f) getChildAt(i4).getLayoutParams();
                if (!fVar.f251a) {
                    fVar.c = 0.0f;
                }
            }
            v(i2, false, true, 0);
            requestLayout();
        }
    }

    public final void f(int i2) {
        i iVar = this.a0;
        if (iVar != null) {
            iVar.c(i2);
        }
        List<i> list = this.W;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                i iVar2 = this.W.get(i3);
                if (iVar2 != null) {
                    iVar2.c(i2);
                }
            }
        }
    }

    public final Rect g(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left = viewGroup.getLeft() + rect.left;
            rect.right = viewGroup.getRight() + rect.right;
            rect.top = viewGroup.getTop() + rect.top;
            rect.bottom = viewGroup.getBottom() + rect.bottom;
            parent = viewGroup.getParent();
        }
        return rect;
    }

    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new f();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public ro getAdapter() {
        return this.j;
    }

    public int getChildDrawingOrder(int i2, int i3) {
        throw null;
    }

    public int getCurrentItem() {
        return this.k;
    }

    public int getOffscreenPageLimit() {
        return this.B;
    }

    public int getPageMargin() {
        return this.r;
    }

    public e h(View view) {
        for (int i2 = 0; i2 < this.g.size(); i2++) {
            e eVar = this.g.get(i2);
            if (this.j.g(view, eVar.f250a)) {
                return eVar;
            }
        }
        return null;
    }

    public final e i() {
        int i2;
        int clientWidth = getClientWidth();
        float f2 = 0.0f;
        float scrollX = clientWidth > 0 ? ((float) getScrollX()) / ((float) clientWidth) : 0.0f;
        float f3 = clientWidth > 0 ? ((float) this.r) / ((float) clientWidth) : 0.0f;
        e eVar = null;
        float f4 = 0.0f;
        int i3 = -1;
        int i4 = 0;
        boolean z2 = true;
        while (i4 < this.g.size()) {
            e eVar2 = this.g.get(i4);
            if (!z2 && eVar2.b != (i2 = i3 + 1)) {
                eVar2 = this.h;
                eVar2.e = f2 + f4 + f3;
                eVar2.b = i2;
                Objects.requireNonNull(this.j);
                eVar2.d = 1.0f;
                i4--;
            }
            f2 = eVar2.e;
            float f5 = eVar2.d + f2 + f3;
            if (!z2 && scrollX < f2) {
                return eVar;
            }
            if (scrollX < f5 || i4 == this.g.size() - 1) {
                return eVar2;
            }
            i3 = eVar2.b;
            f4 = eVar2.d;
            i4++;
            eVar = eVar2;
            z2 = false;
        }
        return eVar;
    }

    public e j(int i2) {
        for (int i3 = 0; i3 < this.g.size(); i3++) {
            e eVar = this.g.get(i3);
            if (eVar.b == i2) {
                return eVar;
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0064  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void k(int r13, float r14, int r15) {
        /*
        // Method dump skipped, instructions count: 143
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.k(int, float, int):void");
    }

    public final void l(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.L) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.H = motionEvent.getX(i2);
            this.L = motionEvent.getPointerId(i2);
            VelocityTracker velocityTracker = this.M;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    public boolean m() {
        int i2 = this.k;
        if (i2 <= 0) {
            return false;
        }
        this.A = false;
        v(i2 - 1, true, false, 0);
        return true;
    }

    public boolean n() {
        ro roVar = this.j;
        if (roVar == null || this.k >= roVar.d() - 1) {
            return false;
        }
        this.A = false;
        v(this.k + 1, true, false, 0);
        return true;
    }

    public final boolean o(int i2) {
        if (this.g.size() != 0) {
            e i3 = i();
            int clientWidth = getClientWidth();
            int i4 = this.r;
            int i5 = clientWidth + i4;
            float f2 = (float) clientWidth;
            int i6 = i3.b;
            float f3 = ((((float) i2) / f2) - i3.e) / (i3.d + (((float) i4) / f2));
            this.U = false;
            k(i6, f3, (int) (((float) i5) * f3));
            if (this.U) {
                return true;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        } else if (this.T) {
            return false;
        } else {
            this.U = false;
            k(0, 0.0f, 0);
            if (this.U) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.T = true;
    }

    public void onDetachedFromWindow() {
        removeCallbacks(this.c0);
        Scroller scroller = this.o;
        if (scroller != null && !scroller.isFinished()) {
            this.o.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0065  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDraw(android.graphics.Canvas r18) {
        /*
        // Method dump skipped, instructions count: 173
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onDraw(android.graphics.Canvas):void");
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & Constants.MAX_HOST_LENGTH;
        if (action == 3 || action == 1) {
            t();
            return false;
        }
        if (action != 0) {
            if (this.C) {
                return true;
            }
            if (this.D) {
                return false;
            }
        }
        if (action == 0) {
            float x2 = motionEvent.getX();
            this.J = x2;
            this.H = x2;
            float y2 = motionEvent.getY();
            this.K = y2;
            this.I = y2;
            this.L = motionEvent.getPointerId(0);
            this.D = false;
            this.p = true;
            this.o.computeScrollOffset();
            if (this.d0 != 2 || Math.abs(this.o.getFinalX() - this.o.getCurrX()) <= this.Q) {
                d(false);
                this.C = false;
            } else {
                this.o.abortAnimation();
                this.A = false;
                q(this.k);
                this.C = true;
                s(true);
                setScrollState(1);
            }
        } else if (action == 2) {
            int i2 = this.L;
            if (i2 != -1) {
                int findPointerIndex = motionEvent.findPointerIndex(i2);
                float x3 = motionEvent.getX(findPointerIndex);
                float f2 = x3 - this.H;
                float abs = Math.abs(f2);
                float y3 = motionEvent.getY(findPointerIndex);
                float abs2 = Math.abs(y3 - this.K);
                int i3 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
                if (i3 != 0) {
                    float f3 = this.H;
                    if (!((f3 < ((float) this.F) && i3 > 0) || (f3 > ((float) (getWidth() - this.F)) && f2 < 0.0f)) && c(this, false, (int) f2, (int) x3, (int) y3)) {
                        this.H = x3;
                        this.I = y3;
                        this.D = true;
                        return false;
                    }
                }
                int i4 = this.G;
                if (abs > ((float) i4) && abs * 0.5f > abs2) {
                    this.C = true;
                    s(true);
                    setScrollState(1);
                    float f4 = this.J;
                    float f5 = (float) this.G;
                    this.H = i3 > 0 ? f4 + f5 : f4 - f5;
                    this.I = y3;
                    setScrollingCacheEnabled(true);
                } else if (abs2 > ((float) i4)) {
                    this.D = true;
                }
                if (this.C && p(x3)) {
                    AtomicInteger atomicInteger = r8.f3055a;
                    postInvalidateOnAnimation();
                }
            }
        } else if (action == 6) {
            l(motionEvent);
        }
        if (this.M == null) {
            this.M = VelocityTracker.obtain();
        }
        this.M.addMovement(motionEvent);
        return this.C;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        /*
        // Method dump skipped, instructions count: 286
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r14, int r15) {
        /*
        // Method dump skipped, instructions count: 243
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onMeasure(int, int):void");
    }

    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        int i3;
        int i4;
        e h2;
        int childCount = getChildCount();
        int i5 = -1;
        if ((i2 & 2) != 0) {
            i5 = childCount;
            i4 = 0;
            i3 = 1;
        } else {
            i4 = childCount - 1;
            i3 = -1;
        }
        while (i4 != i5) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() == 0 && (h2 = h(childAt)) != null && h2.b == this.k && childAt.requestFocus(i2, rect)) {
                return true;
            }
            i4 += i3;
        }
        return false;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        ro roVar = this.j;
        if (roVar != null) {
            roVar.h(savedState.g, savedState.h);
            v(savedState.f, false, true, 0);
            return;
        }
        this.l = savedState.f;
        this.m = savedState.g;
        this.n = savedState.h;
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f = this.k;
        ro roVar = this.j;
        if (roVar != null) {
            savedState.g = roVar.i();
        }
        return savedState;
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4) {
            int i6 = this.r;
            r(i2, i4, i6, i6);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        ro roVar;
        boolean z2 = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (roVar = this.j) == null || roVar.d() == 0) {
            return false;
        }
        if (this.M == null) {
            this.M = VelocityTracker.obtain();
        }
        this.M.addMovement(motionEvent);
        int action = motionEvent.getAction() & Constants.MAX_HOST_LENGTH;
        if (action == 0) {
            this.o.abortAnimation();
            this.A = false;
            q(this.k);
            float x2 = motionEvent.getX();
            this.J = x2;
            this.H = x2;
            float y2 = motionEvent.getY();
            this.K = y2;
            this.I = y2;
            this.L = motionEvent.getPointerId(0);
        } else if (action != 1) {
            if (action == 2) {
                if (!this.C) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.L);
                    if (findPointerIndex == -1) {
                        z2 = t();
                    } else {
                        float x3 = motionEvent.getX(findPointerIndex);
                        float abs = Math.abs(x3 - this.H);
                        float y3 = motionEvent.getY(findPointerIndex);
                        float abs2 = Math.abs(y3 - this.I);
                        if (abs > ((float) this.G) && abs > abs2) {
                            this.C = true;
                            s(true);
                            float f2 = this.J;
                            this.H = x3 - f2 > 0.0f ? f2 + ((float) this.G) : f2 - ((float) this.G);
                            this.I = y3;
                            setScrollState(1);
                            setScrollingCacheEnabled(true);
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                    }
                }
                if (this.C) {
                    z2 = false | p(motionEvent.getX(motionEvent.findPointerIndex(this.L)));
                }
            } else if (action != 3) {
                if (action == 5) {
                    int actionIndex = motionEvent.getActionIndex();
                    this.H = motionEvent.getX(actionIndex);
                    this.L = motionEvent.getPointerId(actionIndex);
                } else if (action == 6) {
                    l(motionEvent);
                    this.H = motionEvent.getX(motionEvent.findPointerIndex(this.L));
                }
            } else if (this.C) {
                u(this.k, true, 0, false);
                z2 = t();
            }
        } else if (this.C) {
            VelocityTracker velocityTracker = this.M;
            velocityTracker.computeCurrentVelocity(Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL, (float) this.O);
            int xVelocity = (int) velocityTracker.getXVelocity(this.L);
            this.A = true;
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            e i2 = i();
            float f3 = (float) clientWidth;
            float f4 = ((float) this.r) / f3;
            int i3 = i2.b;
            float f5 = ((((float) scrollX) / f3) - i2.e) / (i2.d + f4);
            if (Math.abs((int) (motionEvent.getX(motionEvent.findPointerIndex(this.L)) - this.J)) <= this.P || Math.abs(xVelocity) <= this.N) {
                i3 += (int) (f5 + (i3 >= this.k ? 0.4f : 0.6f));
            } else if (xVelocity <= 0) {
                i3++;
            }
            if (this.g.size() > 0) {
                ArrayList<e> arrayList = this.g;
                i3 = Math.max(this.g.get(0).b, Math.min(i3, arrayList.get(arrayList.size() - 1).b));
            }
            v(i3, true, true, xVelocity);
            z2 = t();
        }
        if (z2) {
            AtomicInteger atomicInteger = r8.f3055a;
            postInvalidateOnAnimation();
        }
        return true;
    }

    public final boolean p(float f2) {
        boolean z2;
        boolean z3;
        float f3 = this.H - f2;
        this.H = f2;
        float scrollX = ((float) getScrollX()) + f3;
        float clientWidth = (float) getClientWidth();
        float f4 = this.v * clientWidth;
        float f5 = this.w * clientWidth;
        boolean z4 = false;
        e eVar = this.g.get(0);
        ArrayList<e> arrayList = this.g;
        e eVar2 = arrayList.get(arrayList.size() - 1);
        if (eVar.b != 0) {
            f4 = eVar.e * clientWidth;
            z2 = false;
        } else {
            z2 = true;
        }
        if (eVar2.b != this.j.d() - 1) {
            f5 = eVar2.e * clientWidth;
            z3 = false;
        } else {
            z3 = true;
        }
        if (scrollX < f4) {
            if (z2) {
                this.R.onPull(Math.abs(f4 - scrollX) / clientWidth);
                z4 = true;
            }
            scrollX = f4;
        } else if (scrollX > f5) {
            if (z3) {
                this.S.onPull(Math.abs(scrollX - f5) / clientWidth);
                z4 = true;
            }
            scrollX = f5;
        }
        int i2 = (int) scrollX;
        this.H = (scrollX - ((float) i2)) + this.H;
        scrollTo(i2, getScrollY());
        o(i2);
        return z4;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0056, code lost:
        if (r5 == r6) goto L_0x005d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void q(int r15) {
        /*
        // Method dump skipped, instructions count: 914
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.q(int):void");
    }

    public final void r(int i2, int i3, int i4, int i5) {
        if (i3 <= 0 || this.g.isEmpty()) {
            e j2 = j(this.k);
            int min = (int) ((j2 != null ? Math.min(j2.e, this.w) : 0.0f) * ((float) ((i2 - getPaddingLeft()) - getPaddingRight())));
            if (min != getScrollX()) {
                d(false);
                scrollTo(min, getScrollY());
            }
        } else if (!this.o.isFinished()) {
            this.o.setFinalX(getCurrentItem() * getClientWidth());
        } else {
            scrollTo((int) ((((float) getScrollX()) / ((float) (((i3 - getPaddingLeft()) - getPaddingRight()) + i5))) * ((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i4))), getScrollY());
        }
    }

    public void removeView(View view) {
        if (this.y) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public final void s(boolean z2) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z2);
        }
    }

    public void setAdapter(ro roVar) {
        ro roVar2 = this.j;
        if (roVar2 != null) {
            synchronized (roVar2) {
                roVar2.b = null;
            }
            this.j.k(this);
            for (int i2 = 0; i2 < this.g.size(); i2++) {
                e eVar = this.g.get(i2);
                this.j.b(this, eVar.b, eVar.f250a);
            }
            this.j.c(this);
            this.g.clear();
            int i3 = 0;
            while (i3 < getChildCount()) {
                if (!((f) getChildAt(i3).getLayoutParams()).f251a) {
                    removeViewAt(i3);
                    i3--;
                }
                i3++;
            }
            this.k = 0;
            scrollTo(0, 0);
        }
        ro roVar3 = this.j;
        this.j = roVar;
        this.f = 0;
        if (roVar != null) {
            if (this.q == null) {
                this.q = new j();
            }
            ro roVar4 = this.j;
            j jVar = this.q;
            synchronized (roVar4) {
                roVar4.b = jVar;
            }
            this.A = false;
            boolean z2 = this.T;
            this.T = true;
            this.f = this.j.d();
            if (this.l >= 0) {
                this.j.h(this.m, this.n);
                v(this.l, false, true, 0);
                this.l = -1;
                this.m = null;
                this.n = null;
            } else if (!z2) {
                q(this.k);
            } else {
                requestLayout();
            }
        }
        List<h> list = this.b0;
        if (!(list == null || list.isEmpty())) {
            int size = this.b0.size();
            for (int i4 = 0; i4 < size; i4++) {
                this.b0.get(i4).a(this, roVar3, roVar);
            }
        }
    }

    public void setCurrentItem(int i2) {
        this.A = false;
        v(i2, !this.T, false, 0);
    }

    public void setOffscreenPageLimit(int i2) {
        if (i2 < 1) {
            i2 = 1;
        }
        if (i2 != this.B) {
            this.B = i2;
            q(this.k);
        }
    }

    @Deprecated
    public void setOnPageChangeListener(i iVar) {
        this.a0 = iVar;
    }

    public void setPageMargin(int i2) {
        int i3 = this.r;
        this.r = i2;
        int width = getWidth();
        r(width, width, i2, i3);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.s = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setScrollState(int i2) {
        if (this.d0 != i2) {
            this.d0 = i2;
            i iVar = this.a0;
            if (iVar != null) {
                iVar.b(i2);
            }
            List<i> list = this.W;
            if (list != null) {
                int size = list.size();
                for (int i3 = 0; i3 < size; i3++) {
                    i iVar2 = this.W.get(i3);
                    if (iVar2 != null) {
                        iVar2.b(i2);
                    }
                }
            }
        }
    }

    public final boolean t() {
        this.L = -1;
        this.C = false;
        this.D = false;
        VelocityTracker velocityTracker = this.M;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.M = null;
        }
        this.R.onRelease();
        this.S.onRelease();
        if (this.R.isFinished() || this.S.isFinished()) {
            return true;
        }
        return false;
    }

    public final void u(int i2, boolean z2, int i3, boolean z3) {
        int i4;
        int i5;
        e j2 = j(i2);
        int max = j2 != null ? (int) (Math.max(this.v, Math.min(j2.e, this.w)) * ((float) getClientWidth())) : 0;
        if (z2) {
            if (getChildCount() == 0) {
                setScrollingCacheEnabled(false);
            } else {
                Scroller scroller = this.o;
                if (scroller != null && !scroller.isFinished()) {
                    i4 = this.p ? this.o.getCurrX() : this.o.getStartX();
                    this.o.abortAnimation();
                    setScrollingCacheEnabled(false);
                } else {
                    i4 = getScrollX();
                }
                int scrollY = getScrollY();
                int i6 = max - i4;
                int i7 = 0 - scrollY;
                if (i6 == 0 && i7 == 0) {
                    d(false);
                    q(this.k);
                    setScrollState(0);
                } else {
                    setScrollingCacheEnabled(true);
                    setScrollState(2);
                    int clientWidth = getClientWidth();
                    int i8 = clientWidth / 2;
                    float f2 = (float) clientWidth;
                    float f3 = (float) i8;
                    float sin = (((float) Math.sin((double) ((Math.min(1.0f, (((float) Math.abs(i6)) * 1.0f) / f2) - 0.5f) * 0.47123894f))) * f3) + f3;
                    int abs = Math.abs(i3);
                    if (abs > 0) {
                        i5 = Math.round(Math.abs(sin / ((float) abs)) * 1000.0f) * 4;
                    } else {
                        Objects.requireNonNull(this.j);
                        i5 = (int) (((((float) Math.abs(i6)) / ((f2 * 1.0f) + ((float) this.r))) + 1.0f) * 100.0f);
                    }
                    int min = Math.min(i5, 600);
                    this.p = false;
                    this.o.startScroll(i4, scrollY, i6, i7, min);
                    AtomicInteger atomicInteger = r8.f3055a;
                    postInvalidateOnAnimation();
                }
            }
            if (z3) {
                f(i2);
                return;
            }
            return;
        }
        if (z3) {
            f(i2);
        }
        d(false);
        scrollTo(max, 0);
        o(max);
    }

    public void v(int i2, boolean z2, boolean z3, int i3) {
        ro roVar = this.j;
        boolean z4 = false;
        if (roVar == null || roVar.d() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z3 || this.k != i2 || this.g.size() == 0) {
            if (i2 < 0) {
                i2 = 0;
            } else if (i2 >= this.j.d()) {
                i2 = this.j.d() - 1;
            }
            int i4 = this.B;
            int i5 = this.k;
            if (i2 > i5 + i4 || i2 < i5 - i4) {
                for (int i6 = 0; i6 < this.g.size(); i6++) {
                    this.g.get(i6).c = true;
                }
            }
            if (this.k != i2) {
                z4 = true;
            }
            if (this.T) {
                this.k = i2;
                if (z4) {
                    f(i2);
                }
                requestLayout();
                return;
            }
            q(i2);
            u(i2, z2, i3, z4);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.s;
    }

    public static class f extends ViewGroup.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public boolean f251a;
        public int b;
        public float c = 0.0f;
        public boolean d;
        public int e;
        public int f;

        public f() {
            super(-1, -1);
        }

        public f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.e0);
            this.b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new f(getContext(), attributeSet);
    }

    public void setPageMarginDrawable(int i2) {
        Context context = getContext();
        Object obj = q5.f2896a;
        setPageMarginDrawable(q5.c.b(context, i2));
    }
}
