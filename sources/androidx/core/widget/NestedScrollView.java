package androidx.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.appcompat.widget.RtlSpacingHelper;
import com.google.firebase.appindexing.Indexable;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import defpackage.e9;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class NestedScrollView extends FrameLayout implements k8, h8 {
    public static final a F = new a();
    public static final int[] G = {16843130};
    public SavedState A;
    public final l8 B;
    public final i8 C;
    public float D;
    public b E;
    public long f;
    public final Rect g = new Rect();
    public OverScroller h = new OverScroller(getContext());
    public EdgeEffect i;
    public EdgeEffect j;
    public int k;
    public boolean l = true;
    public boolean m = false;
    public View n = null;
    public boolean o = false;
    public VelocityTracker p;
    public boolean q;
    public boolean r = true;
    public int s;
    public int t;
    public int u;
    public int v = -1;
    public final int[] w = new int[2];
    public final int[] x = new int[2];
    public int y;
    public int z;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public int f;

        public class a implements Parcelable.Creator<SavedState> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            StringBuilder i0 = hj1.i0("HorizontalScrollView.SavedState{");
            i0.append(Integer.toHexString(System.identityHashCode(this)));
            i0.append(" scrollPosition=");
            return hj1.X(i0, this.f, "}");
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f = parcel.readInt();
        }
    }

    public static class a extends z7 {
        @Override // defpackage.z7
        public void c(View view, AccessibilityEvent accessibilityEvent) {
            this.f4141a.onInitializeAccessibilityEvent(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            accessibilityEvent.setMaxScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setMaxScrollY(nestedScrollView.getScrollRange());
        }

        @Override // defpackage.z7
        public void d(View view, e9 e9Var) {
            int scrollRange;
            this.f4141a.onInitializeAccessibilityNodeInfo(view, e9Var.f942a);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            e9Var.f942a.setClassName(ScrollView.class.getName());
            if (nestedScrollView.isEnabled() && (scrollRange = nestedScrollView.getScrollRange()) > 0) {
                e9Var.f942a.setScrollable(true);
                if (nestedScrollView.getScrollY() > 0) {
                    e9Var.a(e9.a.i);
                    e9Var.a(e9.a.m);
                }
                if (nestedScrollView.getScrollY() < scrollRange) {
                    e9Var.a(e9.a.h);
                    e9Var.a(e9.a.n);
                }
            }
        }

        @Override // defpackage.z7
        public boolean g(View view, int i, Bundle bundle) {
            if (super.g(view, i, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            if (i != 4096) {
                if (i == 8192 || i == 16908344) {
                    int max = Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (max == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.v(0 - nestedScrollView.getScrollX(), max - nestedScrollView.getScrollY(), ListPopupWindow.EXPAND_LIST_TIMEOUT, true);
                    return true;
                } else if (i != 16908346) {
                    return false;
                }
            }
            int min = Math.min(nestedScrollView.getScrollY() + ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
            if (min == nestedScrollView.getScrollY()) {
                return false;
            }
            nestedScrollView.v(0 - nestedScrollView.getScrollX(), min - nestedScrollView.getScrollY(), ListPopupWindow.EXPAND_LIST_TIMEOUT, true);
            return true;
        }
    }

    public interface b {
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public NestedScrollView(android.content.Context r6, android.util.AttributeSet r7) {
        /*
        // Method dump skipped, instructions count: 124
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    public static int c(int i2, int i3, int i4) {
        if (i3 >= i4 || i2 < 0) {
            return 0;
        }
        return i3 + i2 > i4 ? i4 - i3 : i2;
    }

    private float getVerticalScrollFactorCompat() {
        if (this.D == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                this.D = typedValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.D;
    }

    public static boolean m(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        if (!(parent instanceof ViewGroup) || !m((View) parent, view2)) {
            return false;
        }
        return true;
    }

    public final void a() {
        this.h.abortAnimation();
        this.C.j(1);
    }

    public void addView(View view) {
        if (getChildCount() <= 0) {
            super.addView(view);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public boolean b(int i2) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i2);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus == null || !n(findNextFocus, maxScrollAmount, getHeight())) {
            if (i2 == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i2 == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getHeight() + getScrollY()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i2 != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            f(maxScrollAmount);
        } else {
            findNextFocus.getDrawingRect(this.g);
            offsetDescendantRectToMyCoords(findNextFocus, this.g);
            f(d(this.g));
            findNextFocus.requestFocus(i2);
        }
        if (findFocus != null && findFocus.isFocused() && (!n(findFocus, 0, getHeight()))) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    public void computeScroll() {
        if (!this.h.isFinished()) {
            this.h.computeScrollOffset();
            int currY = this.h.getCurrY();
            int i2 = currY - this.z;
            this.z = currY;
            int[] iArr = this.x;
            boolean z2 = false;
            iArr[1] = 0;
            e(0, i2, iArr, null, 1);
            int i3 = i2 - this.x[1];
            int scrollRange = getScrollRange();
            if (i3 != 0) {
                int scrollY = getScrollY();
                q(0, i3, getScrollX(), scrollY, 0, scrollRange, 0, 0);
                int scrollY2 = getScrollY() - scrollY;
                int i4 = i3 - scrollY2;
                int[] iArr2 = this.x;
                iArr2[1] = 0;
                this.C.f(0, scrollY2, 0, i4, this.w, 1, iArr2);
                i3 = i4 - this.x[1];
            }
            if (i3 != 0) {
                int overScrollMode = getOverScrollMode();
                if (overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0)) {
                    z2 = true;
                }
                if (z2) {
                    h();
                    if (i3 < 0) {
                        if (this.i.isFinished()) {
                            this.i.onAbsorb((int) this.h.getCurrVelocity());
                        }
                    } else if (this.j.isFinished()) {
                        this.j.onAbsorb((int) this.h.getCurrVelocity());
                    }
                }
                a();
            }
            if (!this.h.isFinished()) {
                AtomicInteger atomicInteger = r8.f3055a;
                postInvalidateOnAnimation();
                return;
            }
            this.C.j(1);
        }
    }

    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    public int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int max = Math.max(0, bottom - height);
        if (scrollY < 0) {
            return bottom - scrollY;
        }
        return scrollY > max ? bottom + (scrollY - max) : bottom;
    }

    public int d(Rect rect) {
        int i2;
        int i3;
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i5 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i4 - verticalFadingEdgeLength : i4;
        int i6 = rect.bottom;
        if (i6 > i5 && rect.top > scrollY) {
            if (rect.height() > height) {
                i3 = rect.top - scrollY;
            } else {
                i3 = rect.bottom - i5;
            }
            return Math.min(i3 + 0, (childAt.getBottom() + layoutParams.bottomMargin) - i4);
        } else if (rect.top >= scrollY || i6 >= i5) {
            return 0;
        } else {
            if (rect.height() > height) {
                i2 = 0 - (i5 - rect.bottom);
            } else {
                i2 = 0 - (scrollY - rect.top);
            }
            return Math.max(i2, -getScrollY());
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || i(keyEvent);
    }

    public boolean dispatchNestedFling(float f2, float f3, boolean z2) {
        return this.C.a(f2, f3, z2);
    }

    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.C.b(f2, f3);
    }

    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return e(i2, i3, iArr, iArr2, 0);
    }

    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return this.C.e(i2, i3, i4, i5, iArr);
    }

    public void draw(Canvas canvas) {
        int i2;
        super.draw(canvas);
        if (this.i != null) {
            int scrollY = getScrollY();
            int i3 = 0;
            if (!this.i.isFinished()) {
                int save = canvas.save();
                int width = getWidth();
                int height = getHeight();
                int min = Math.min(0, scrollY);
                if (getClipToPadding()) {
                    width -= getPaddingRight() + getPaddingLeft();
                    i2 = getPaddingLeft() + 0;
                } else {
                    i2 = 0;
                }
                if (getClipToPadding()) {
                    height -= getPaddingBottom() + getPaddingTop();
                    min += getPaddingTop();
                }
                canvas.translate((float) i2, (float) min);
                this.i.setSize(width, height);
                if (this.i.draw(canvas)) {
                    AtomicInteger atomicInteger = r8.f3055a;
                    postInvalidateOnAnimation();
                }
                canvas.restoreToCount(save);
            }
            if (!this.j.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = getHeight();
                int max = Math.max(getScrollRange(), scrollY) + height2;
                if (getClipToPadding()) {
                    width2 -= getPaddingRight() + getPaddingLeft();
                    i3 = 0 + getPaddingLeft();
                }
                if (getClipToPadding()) {
                    height2 -= getPaddingBottom() + getPaddingTop();
                    max -= getPaddingBottom();
                }
                canvas.translate((float) (i3 - width2), (float) max);
                canvas.rotate(180.0f, (float) width2, 0.0f);
                this.j.setSize(width2, height2);
                if (this.j.draw(canvas)) {
                    AtomicInteger atomicInteger2 = r8.f3055a;
                    postInvalidateOnAnimation();
                }
                canvas.restoreToCount(save2);
            }
        }
    }

    public boolean e(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        return this.C.c(i2, i3, iArr, iArr2, i4);
    }

    public final void f(int i2) {
        if (i2 == 0) {
            return;
        }
        if (this.r) {
            v(0, i2, ListPopupWindow.EXPAND_LIST_TIMEOUT, false);
        } else {
            scrollBy(0, i2);
        }
    }

    public final void g() {
        this.o = false;
        r();
        this.C.j(0);
        EdgeEffect edgeEffect = this.i;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            this.j.onRelease();
        }
    }

    public float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return ((float) bottom) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (((float) getHeight()) * 0.5f);
    }

    public int getNestedScrollAxes() {
        return this.B.a();
    }

    public int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    public float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return ((float) scrollY) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    public final void h() {
        if (getOverScrollMode() == 2) {
            this.i = null;
            this.j = null;
        } else if (this.i == null) {
            Context context = getContext();
            this.i = new EdgeEffect(context);
            this.j = new EdgeEffect(context);
        }
    }

    public boolean hasNestedScrollingParent() {
        return l(0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0038  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean i(android.view.KeyEvent r7) {
        /*
        // Method dump skipped, instructions count: 253
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.i(android.view.KeyEvent):boolean");
    }

    public boolean isNestedScrollingEnabled() {
        return this.C.d;
    }

    public void j(int i2) {
        if (getChildCount() > 0) {
            this.h.fling(getScrollX(), getScrollY(), 0, i2, 0, 0, RtlSpacingHelper.UNDEFINED, Integer.MAX_VALUE, 0, 0);
            s(true);
        }
    }

    public boolean k(int i2) {
        int childCount;
        boolean z2 = i2 == 130;
        int height = getHeight();
        Rect rect = this.g;
        rect.top = 0;
        rect.bottom = height;
        if (z2 && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            this.g.bottom = getPaddingBottom() + childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
            Rect rect2 = this.g;
            rect2.top = rect2.bottom - height;
        }
        Rect rect3 = this.g;
        return t(i2, rect3.top, rect3.bottom);
    }

    public boolean l(int i2) {
        return this.C.g(i2) != null;
    }

    public void measureChild(View view, int i2, int i3) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        view.measure(FrameLayout.getChildMeasureSpec(i2, getPaddingRight() + getPaddingLeft(), layoutParams.width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    public void measureChildWithMargins(View view, int i2, int i3, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(FrameLayout.getChildMeasureSpec(i2, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i3, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    public final boolean n(View view, int i2, int i3) {
        view.getDrawingRect(this.g);
        offsetDescendantRectToMyCoords(view, this.g);
        return this.g.bottom + i2 >= getScrollY() && this.g.top - i2 <= getScrollY() + i3;
    }

    public final void o(int i2, int i3, int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i2);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.C.d(0, scrollY2, 0, i2 - scrollY2, null, i3, iArr);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.m = false;
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0 && motionEvent.getAction() == 8 && !this.o) {
            float axisValue = motionEvent.getAxisValue(9);
            if (axisValue != 0.0f) {
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                int verticalScrollFactorCompat = scrollY - ((int) (axisValue * getVerticalScrollFactorCompat()));
                if (verticalScrollFactorCompat < 0) {
                    scrollRange = 0;
                } else if (verticalScrollFactorCompat <= scrollRange) {
                    scrollRange = verticalScrollFactorCompat;
                }
                if (scrollRange != scrollY) {
                    super.scrollTo(getScrollX(), scrollRange);
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00d0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r12) {
        /*
        // Method dump skipped, instructions count: 255
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        int i6 = 0;
        this.l = false;
        View view = this.n;
        if (view != null && m(view, this)) {
            u(this.n);
        }
        this.n = null;
        if (!this.m) {
            if (this.A != null) {
                scrollTo(getScrollX(), this.A.f);
                this.A = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                i6 = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            }
            int paddingTop = ((i5 - i3) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int c = c(scrollY, paddingTop, i6);
            if (c != scrollY) {
                scrollTo(getScrollX(), c);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.m = true;
    }

    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.q && View.MeasureSpec.getMode(i3) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(FrameLayout.getChildMeasureSpec(i2, getPaddingRight() + getPaddingLeft() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, CommonUtils.BYTES_IN_A_GIGABYTE));
            }
        }
    }

    public boolean onNestedFling(View view, float f2, float f3, boolean z2) {
        if (z2) {
            return false;
        }
        dispatchNestedFling(0.0f, f3, true);
        j((int) f3);
        return true;
    }

    public boolean onNestedPreFling(View view, float f2, float f3) {
        return dispatchNestedPreFling(f2, f3);
    }

    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        e(i2, i3, iArr, null, 0);
    }

    @Override // defpackage.k8
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        o(i5, i6, iArr);
    }

    public void onNestedScrollAccepted(View view, View view2, int i2) {
        this.B.f2183a = i2;
        w(2, 0);
    }

    public void onOverScrolled(int i2, int i3, boolean z2, boolean z3) {
        super.scrollTo(i2, i3);
    }

    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        View view;
        if (i2 == 2) {
            i2 = 130;
        } else if (i2 == 1) {
            i2 = 33;
        }
        if (rect == null) {
            view = FocusFinder.getInstance().findNextFocus(this, null, i2);
        } else {
            view = FocusFinder.getInstance().findNextFocusFromRect(this, rect, i2);
        }
        if (view != null && !(true ^ n(view, 0, getHeight()))) {
            return view.requestFocus(i2, rect);
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
        this.A = savedState;
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f = getScrollY();
        return savedState;
    }

    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        b bVar = this.E;
        if (bVar != null) {
            z zVar = (z) bVar;
            AlertController.c(this, zVar.f4104a, zVar.b);
        }
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        View findFocus = findFocus();
        if (findFocus != null && this != findFocus && n(findFocus, 0, i5)) {
            findFocus.getDrawingRect(this.g);
            offsetDescendantRectToMyCoords(findFocus, this.g);
            f(d(this.g));
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return (i2 & 2) != 0;
    }

    @Override // defpackage.j8
    public boolean onStartNestedScroll(View view, View view2, int i2, int i3) {
        return (i2 & 2) != 0;
    }

    public void onStopNestedScroll(View view) {
        this.B.f2183a = 0;
        x(0);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        if (this.p == null) {
            this.p = VelocityTracker.obtain();
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.y = 0;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(0.0f, (float) this.y);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                VelocityTracker velocityTracker = this.p;
                velocityTracker.computeCurrentVelocity(Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL, (float) this.u);
                int yVelocity = (int) velocityTracker.getYVelocity(this.v);
                if (Math.abs(yVelocity) >= this.t) {
                    int i2 = -yVelocity;
                    float f2 = (float) i2;
                    if (!dispatchNestedPreFling(0.0f, f2)) {
                        dispatchNestedFling(0.0f, f2, true);
                        j(i2);
                    }
                } else if (this.h.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    AtomicInteger atomicInteger = r8.f3055a;
                    postInvalidateOnAnimation();
                }
                this.v = -1;
                g();
            } else if (actionMasked == 2) {
                int findPointerIndex = motionEvent.findPointerIndex(this.v);
                if (findPointerIndex != -1) {
                    int y2 = (int) motionEvent.getY(findPointerIndex);
                    int i3 = this.k - y2;
                    if (!this.o && Math.abs(i3) > this.s) {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.o = true;
                        i3 = i3 > 0 ? i3 - this.s : i3 + this.s;
                    }
                    int i4 = i3;
                    if (this.o) {
                        if (e(0, i4, this.x, this.w, 0)) {
                            i4 -= this.x[1];
                            this.y += this.w[1];
                        }
                        this.k = y2 - this.w[1];
                        int scrollY = getScrollY();
                        int scrollRange = getScrollRange();
                        int overScrollMode = getOverScrollMode();
                        boolean z2 = overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0);
                        if (q(0, i4, 0, getScrollY(), 0, scrollRange, 0, 0) && !l(0)) {
                            this.p.clear();
                        }
                        int scrollY2 = getScrollY() - scrollY;
                        int[] iArr = this.x;
                        iArr[1] = 0;
                        this.C.f(0, scrollY2, 0, i4 - scrollY2, this.w, 0, iArr);
                        int i5 = this.k;
                        int[] iArr2 = this.w;
                        this.k = i5 - iArr2[1];
                        this.y += iArr2[1];
                        if (z2) {
                            int i6 = i4 - this.x[1];
                            h();
                            int i7 = scrollY + i6;
                            if (i7 < 0) {
                                this.i.onPull(((float) i6) / ((float) getHeight()), motionEvent.getX(findPointerIndex) / ((float) getWidth()));
                                if (!this.j.isFinished()) {
                                    this.j.onRelease();
                                }
                            } else if (i7 > scrollRange) {
                                this.j.onPull(((float) i6) / ((float) getHeight()), 1.0f - (motionEvent.getX(findPointerIndex) / ((float) getWidth())));
                                if (!this.i.isFinished()) {
                                    this.i.onRelease();
                                }
                            }
                            EdgeEffect edgeEffect = this.i;
                            if (edgeEffect != null && (!edgeEffect.isFinished() || !this.j.isFinished())) {
                                AtomicInteger atomicInteger2 = r8.f3055a;
                                postInvalidateOnAnimation();
                            }
                        }
                    }
                }
            } else if (actionMasked == 3) {
                if (this.o && getChildCount() > 0 && this.h.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    AtomicInteger atomicInteger3 = r8.f3055a;
                    postInvalidateOnAnimation();
                }
                this.v = -1;
                g();
            } else if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                this.k = (int) motionEvent.getY(actionIndex);
                this.v = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                p(motionEvent);
                this.k = (int) motionEvent.getY(motionEvent.findPointerIndex(this.v));
            }
        } else if (getChildCount() == 0) {
            return false;
        } else {
            boolean z3 = !this.h.isFinished();
            this.o = z3;
            if (z3 && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (!this.h.isFinished()) {
                a();
            }
            this.k = (int) motionEvent.getY();
            this.v = motionEvent.getPointerId(0);
            w(2, 0);
        }
        VelocityTracker velocityTracker2 = this.p;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    public final void p(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.v) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.k = (int) motionEvent.getY(i2);
            this.v = motionEvent.getPointerId(i2);
            VelocityTracker velocityTracker = this.p;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0083 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean q(int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20) {
        /*
        // Method dump skipped, instructions count: 135
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.q(int, int, int, int, int, int, int, int):boolean");
    }

    public final void r() {
        VelocityTracker velocityTracker = this.p;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.p = null;
        }
    }

    public void requestChildFocus(View view, View view2) {
        if (!this.l) {
            u(view2);
        } else {
            this.n = view2;
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        int d = d(rect);
        boolean z3 = d != 0;
        if (z3) {
            if (z2) {
                scrollBy(0, d);
            } else {
                v(0, d, ListPopupWindow.EXPAND_LIST_TIMEOUT, false);
            }
        }
        return z3;
    }

    public void requestDisallowInterceptTouchEvent(boolean z2) {
        if (z2) {
            r();
        }
        super.requestDisallowInterceptTouchEvent(z2);
    }

    public void requestLayout() {
        this.l = true;
        super.requestLayout();
    }

    public final void s(boolean z2) {
        if (z2) {
            w(2, 1);
        } else {
            this.C.j(1);
        }
        this.z = getScrollY();
        AtomicInteger atomicInteger = r8.f3055a;
        postInvalidateOnAnimation();
    }

    public void scrollTo(int i2, int i3) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int c = c(i2, (getWidth() - getPaddingLeft()) - getPaddingRight(), childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
            int c2 = c(i3, (getHeight() - getPaddingTop()) - getPaddingBottom(), childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin);
            if (c != getScrollX() || c2 != getScrollY()) {
                super.scrollTo(c, c2);
            }
        }
    }

    public void setFillViewport(boolean z2) {
        if (z2 != this.q) {
            this.q = z2;
            requestLayout();
        }
    }

    public void setNestedScrollingEnabled(boolean z2) {
        i8 i8Var = this.C;
        if (i8Var.d) {
            View view = i8Var.c;
            AtomicInteger atomicInteger = r8.f3055a;
            view.stopNestedScroll();
        }
        i8Var.d = z2;
    }

    public void setOnScrollChangeListener(b bVar) {
        this.E = bVar;
    }

    public void setSmoothScrollingEnabled(boolean z2) {
        this.r = z2;
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public boolean startNestedScroll(int i2) {
        return this.C.i(i2, 0);
    }

    public void stopNestedScroll() {
        this.C.j(0);
    }

    public final boolean t(int i2, int i3, int i4) {
        boolean z2;
        int height = getHeight();
        int scrollY = getScrollY();
        int i5 = height + scrollY;
        boolean z3 = i2 == 33;
        ArrayList focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z4 = false;
        for (int i6 = 0; i6 < size; i6++) {
            View view2 = (View) focusables.get(i6);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i3 < bottom && top < i4) {
                boolean z5 = i3 < top && bottom < i4;
                if (view == null) {
                    view = view2;
                    z4 = z5;
                } else {
                    boolean z6 = (z3 && top < view.getTop()) || (!z3 && bottom > view.getBottom());
                    if (z4) {
                        if (z5) {
                            if (!z6) {
                            }
                        }
                    } else if (z5) {
                        view = view2;
                        z4 = true;
                    } else if (!z6) {
                    }
                    view = view2;
                }
            }
        }
        if (view == null) {
            view = this;
        }
        if (i3 < scrollY || i4 > i5) {
            f(z3 ? i3 - scrollY : i4 - i5);
            z2 = true;
        } else {
            z2 = false;
        }
        if (view != findFocus()) {
            view.requestFocus(i2);
        }
        return z2;
    }

    public final void u(View view) {
        view.getDrawingRect(this.g);
        offsetDescendantRectToMyCoords(view, this.g);
        int d = d(this.g);
        if (d != 0) {
            scrollBy(0, d);
        }
    }

    public final void v(int i2, int i3, int i4, boolean z2) {
        if (getChildCount() != 0) {
            if (AnimationUtils.currentAnimationTimeMillis() - this.f > 250) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                int scrollY = getScrollY();
                OverScroller overScroller = this.h;
                int scrollX = getScrollX();
                overScroller.startScroll(scrollX, scrollY, 0, Math.max(0, Math.min(i3 + scrollY, Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom())))) - scrollY, i4);
                s(z2);
            } else {
                if (!this.h.isFinished()) {
                    a();
                }
                scrollBy(i2, i3);
            }
            this.f = AnimationUtils.currentAnimationTimeMillis();
        }
    }

    public boolean w(int i2, int i3) {
        return this.C.i(i2, i3);
    }

    public void x(int i2) {
        this.C.j(i2);
    }

    @Override // defpackage.j8
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr, int i4) {
        e(i2, i3, iArr, null, i4);
    }

    @Override // defpackage.j8
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5, int i6) {
        o(i5, i6, null);
    }

    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        o(i5, 0, null);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2) {
        if (getChildCount() <= 0) {
            super.addView(view, i2);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // defpackage.j8
    public void onNestedScrollAccepted(View view, View view2, int i2, int i3) {
        l8 l8Var = this.B;
        if (i3 == 1) {
            l8Var.b = i2;
        } else {
            l8Var.f2183a = i2;
        }
        w(2, i3);
    }

    @Override // defpackage.j8
    public void onStopNestedScroll(View view, int i2) {
        l8 l8Var = this.B;
        if (i2 == 1) {
            l8Var.b = 0;
        } else {
            l8Var.f2183a = 0;
        }
        x(i2);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i2, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }
}
