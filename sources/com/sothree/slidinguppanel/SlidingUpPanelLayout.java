package com.sothree.slidinguppanel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.RtlSpacingHelper;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.sothree.slidinguppanel.ViewDragHelper;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class SlidingUpPanelLayout extends ViewGroup {
    public static final String N = SlidingUpPanelLayout.class.getSimpleName();
    public static PanelState O = PanelState.COLLAPSED;
    public static final int[] P = {16842927};
    public float A;
    public boolean B;
    public boolean C;
    public float D;
    public float E;
    public float F;
    public float G;
    public boolean H;
    public final List<PanelSlideListener> I;
    public View.OnClickListener J;
    public final ViewDragHelper K;
    public boolean L;
    public final Rect M;
    public int f = 400;
    public int g = -1728053248;
    public final Paint h = new Paint();
    public final Drawable i;
    public int j = -1;
    public int k = -1;
    public int l = -1;
    public boolean m;
    public boolean n = false;
    public boolean o = true;
    public View p;
    public int q = -1;
    public View r;
    public int s;
    public ScrollableViewHelper t = new ScrollableViewHelper();
    public View u;
    public View v;
    public PanelState w;
    public PanelState x;
    public float y;
    public int z;

    /* renamed from: com.sothree.slidinguppanel.SlidingUpPanelLayout$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f702a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0015 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001c */
        static {
            /*
                com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelState.values()
                r0 = 5
                int[] r0 = new int[r0]
                com.sothree.slidinguppanel.SlidingUpPanelLayout.AnonymousClass2.f702a = r0
                r1 = 1
                com.sothree.slidinguppanel.SlidingUpPanelLayout$PanelState r2 = com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelState.EXPANDED     // Catch:{ NoSuchFieldError -> 0x000e }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                int[] r0 = com.sothree.slidinguppanel.SlidingUpPanelLayout.AnonymousClass2.f702a     // Catch:{ NoSuchFieldError -> 0x0015 }
                com.sothree.slidinguppanel.SlidingUpPanelLayout$PanelState r2 = com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelState.ANCHORED     // Catch:{ NoSuchFieldError -> 0x0015 }
                r2 = 2
                r0[r2] = r2     // Catch:{ NoSuchFieldError -> 0x0015 }
            L_0x0015:
                int[] r0 = com.sothree.slidinguppanel.SlidingUpPanelLayout.AnonymousClass2.f702a     // Catch:{ NoSuchFieldError -> 0x001c }
                com.sothree.slidinguppanel.SlidingUpPanelLayout$PanelState r2 = com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelState.HIDDEN     // Catch:{ NoSuchFieldError -> 0x001c }
                r2 = 3
                r0[r2] = r2     // Catch:{ NoSuchFieldError -> 0x001c }
            L_0x001c:
                int[] r0 = com.sothree.slidinguppanel.SlidingUpPanelLayout.AnonymousClass2.f702a     // Catch:{ NoSuchFieldError -> 0x0023 }
                com.sothree.slidinguppanel.SlidingUpPanelLayout$PanelState r2 = com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelState.COLLAPSED     // Catch:{ NoSuchFieldError -> 0x0023 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0023 }
            L_0x0023:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sothree.slidinguppanel.SlidingUpPanelLayout.AnonymousClass2.<clinit>():void");
        }
    }

    public class DragHelperCallback extends ViewDragHelper.Callback {
        public DragHelperCallback(AnonymousClass1 r2) {
        }

        @Override // com.sothree.slidinguppanel.ViewDragHelper.Callback
        public int b(View view, int i, int i2) {
            SlidingUpPanelLayout slidingUpPanelLayout = SlidingUpPanelLayout.this;
            String str = SlidingUpPanelLayout.N;
            int e = slidingUpPanelLayout.e(0.0f);
            int e2 = SlidingUpPanelLayout.this.e(1.0f);
            if (SlidingUpPanelLayout.this.m) {
                return Math.min(Math.max(i, e2), e);
            }
            return Math.min(Math.max(i, e), e2);
        }

        @Override // com.sothree.slidinguppanel.ViewDragHelper.Callback
        public int d(View view) {
            return SlidingUpPanelLayout.this.z;
        }

        @Override // com.sothree.slidinguppanel.ViewDragHelper.Callback
        public void h(View view, int i) {
            SlidingUpPanelLayout.this.i();
        }

        @Override // com.sothree.slidinguppanel.ViewDragHelper.Callback
        public void i(int i) {
            SlidingUpPanelLayout slidingUpPanelLayout = SlidingUpPanelLayout.this;
            ViewDragHelper viewDragHelper = slidingUpPanelLayout.K;
            if (viewDragHelper != null && viewDragHelper.f705a == 0) {
                slidingUpPanelLayout.y = slidingUpPanelLayout.f(slidingUpPanelLayout.u.getTop());
                SlidingUpPanelLayout.this.d();
                SlidingUpPanelLayout slidingUpPanelLayout2 = SlidingUpPanelLayout.this;
                float f = slidingUpPanelLayout2.y;
                if (f == 1.0f) {
                    slidingUpPanelLayout2.k();
                    SlidingUpPanelLayout.this.setPanelStateInternal(PanelState.EXPANDED);
                } else if (f == 0.0f) {
                    slidingUpPanelLayout2.setPanelStateInternal(PanelState.COLLAPSED);
                } else if (f < 0.0f) {
                    slidingUpPanelLayout2.setPanelStateInternal(PanelState.HIDDEN);
                    SlidingUpPanelLayout.this.u.setVisibility(4);
                } else {
                    slidingUpPanelLayout2.k();
                    SlidingUpPanelLayout.this.setPanelStateInternal(PanelState.ANCHORED);
                }
            }
        }

        @Override // com.sothree.slidinguppanel.ViewDragHelper.Callback
        public void j(View view, int i, int i2, int i3, int i4) {
            SlidingUpPanelLayout.a(SlidingUpPanelLayout.this, i2);
            SlidingUpPanelLayout.this.invalidate();
        }

        /* JADX WARNING: Removed duplicated region for block: B:31:0x0071  */
        @Override // com.sothree.slidinguppanel.ViewDragHelper.Callback
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void k(android.view.View r6, float r7, float r8) {
            /*
            // Method dump skipped, instructions count: 157
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sothree.slidinguppanel.SlidingUpPanelLayout.DragHelperCallback.k(android.view.View, float, float):void");
        }

        @Override // com.sothree.slidinguppanel.ViewDragHelper.Callback
        public boolean l(View view, int i) {
            SlidingUpPanelLayout slidingUpPanelLayout = SlidingUpPanelLayout.this;
            return !slidingUpPanelLayout.B && view == slidingUpPanelLayout.u;
        }
    }

    public interface PanelSlideListener {
        void a(View view, float f);

        void b(View view, PanelState panelState, PanelState panelState2);
    }

    public enum PanelState {
        EXPANDED,
        COLLAPSED,
        ANCHORED,
        HIDDEN,
        DRAGGING
    }

    public static class SimplePanelSlideListener implements PanelSlideListener {
        @Override // com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelSlideListener
        public void a(View view, float f) {
        }

        @Override // com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelSlideListener
        public void b(View view, PanelState panelState, PanelState panelState2) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0134  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SlidingUpPanelLayout(android.content.Context r10, android.util.AttributeSet r11) {
        /*
        // Method dump skipped, instructions count: 349
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sothree.slidinguppanel.SlidingUpPanelLayout.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    public static void a(SlidingUpPanelLayout slidingUpPanelLayout, int i2) {
        PanelState panelState = slidingUpPanelLayout.w;
        PanelState panelState2 = PanelState.DRAGGING;
        if (panelState != panelState2) {
            slidingUpPanelLayout.x = panelState;
        }
        slidingUpPanelLayout.setPanelStateInternal(panelState2);
        slidingUpPanelLayout.y = slidingUpPanelLayout.f(i2);
        slidingUpPanelLayout.d();
        View view = slidingUpPanelLayout.u;
        synchronized (slidingUpPanelLayout.I) {
            for (PanelSlideListener panelSlideListener : slidingUpPanelLayout.I) {
                panelSlideListener.a(view, slidingUpPanelLayout.y);
            }
        }
        LayoutParams layoutParams = (LayoutParams) slidingUpPanelLayout.v.getLayoutParams();
        int height = ((slidingUpPanelLayout.getHeight() - slidingUpPanelLayout.getPaddingBottom()) - slidingUpPanelLayout.getPaddingTop()) - slidingUpPanelLayout.j;
        if (slidingUpPanelLayout.y <= 0.0f && !slidingUpPanelLayout.n) {
            int paddingBottom = slidingUpPanelLayout.m ? i2 - slidingUpPanelLayout.getPaddingBottom() : ((slidingUpPanelLayout.getHeight() - slidingUpPanelLayout.getPaddingBottom()) - slidingUpPanelLayout.u.getMeasuredHeight()) - i2;
            ((ViewGroup.MarginLayoutParams) layoutParams).height = paddingBottom;
            if (paddingBottom == height) {
                ((ViewGroup.MarginLayoutParams) layoutParams).height = -1;
            }
            slidingUpPanelLayout.v.requestLayout();
        } else if (((ViewGroup.MarginLayoutParams) layoutParams).height != -1 && !slidingUpPanelLayout.n) {
            ((ViewGroup.MarginLayoutParams) layoutParams).height = -1;
            slidingUpPanelLayout.v.requestLayout();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setPanelStateInternal(PanelState panelState) {
        PanelState panelState2 = this.w;
        if (panelState2 != panelState) {
            this.w = panelState;
            synchronized (this.I) {
                for (PanelSlideListener panelSlideListener : this.I) {
                    panelSlideListener.b(this, panelState2, panelState);
                }
            }
            sendAccessibilityEvent(32);
        }
    }

    public void c(PanelSlideListener panelSlideListener) {
        synchronized (this.I) {
            this.I.add(panelSlideListener);
        }
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008a, code lost:
        if (r0.f705a == 2) goto L_0x008c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void computeScroll() {
        /*
        // Method dump skipped, instructions count: 161
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sothree.slidinguppanel.SlidingUpPanelLayout.computeScroll():void");
    }

    @SuppressLint({"NewApi"})
    public final void d() {
        if (this.l > 0) {
            int currentParallaxOffset = getCurrentParallaxOffset();
            AtomicInteger atomicInteger = r8.f3055a;
            this.v.setTranslationY((float) currentParallaxOffset);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x014f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchTouchEvent(android.view.MotionEvent r8) {
        /*
        // Method dump skipped, instructions count: 442
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sothree.slidinguppanel.SlidingUpPanelLayout.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public void draw(Canvas canvas) {
        View view;
        int i2;
        int i3;
        super.draw(canvas);
        if (this.i != null && (view = this.u) != null) {
            int right = view.getRight();
            if (this.m) {
                i3 = this.u.getTop() - this.k;
                i2 = this.u.getTop();
            } else {
                i3 = this.u.getBottom();
                i2 = this.u.getBottom() + this.k;
            }
            this.i.setBounds(this.u.getLeft(), i3, right, i2);
            this.i.draw(canvas);
        }
    }

    public boolean drawChild(Canvas canvas, View view, long j2) {
        boolean z2;
        int save = canvas.save(2);
        View view2 = this.u;
        if (view2 == null || view2 == view) {
            z2 = super.drawChild(canvas, view, j2);
        } else {
            canvas.getClipBounds(this.M);
            if (!this.n) {
                if (this.m) {
                    Rect rect = this.M;
                    rect.bottom = Math.min(rect.bottom, this.u.getTop());
                } else {
                    Rect rect2 = this.M;
                    rect2.top = Math.max(rect2.top, this.u.getBottom());
                }
            }
            if (this.o) {
                canvas.clipRect(this.M);
            }
            z2 = super.drawChild(canvas, view, j2);
            int i2 = this.g;
            if (i2 != 0) {
                float f2 = this.y;
                if (f2 > 0.0f) {
                    this.h.setColor((i2 & 16777215) | (((int) (((float) ((-16777216 & i2) >>> 24)) * f2)) << 24));
                    canvas.drawRect(this.M, this.h);
                }
            }
        }
        canvas.restoreToCount(save);
        return z2;
    }

    public final int e(float f2) {
        View view = this.u;
        int measuredHeight = view != null ? view.getMeasuredHeight() : 0;
        int i2 = (int) (f2 * ((float) this.z));
        if (this.m) {
            return ((getMeasuredHeight() - getPaddingBottom()) - this.j) - i2;
        }
        return (getPaddingTop() - measuredHeight) + this.j + i2;
    }

    public final float f(int i2) {
        int e = e(0.0f);
        return (this.m ? (float) (e - i2) : (float) (i2 - e)) / ((float) this.z);
    }

    public boolean g() {
        return (!this.C || this.u == null || this.w == PanelState.HIDDEN) ? false : true;
    }

    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public float getAnchorPoint() {
        return this.A;
    }

    public int getCoveredFadeColor() {
        return this.g;
    }

    public int getCurrentParallaxOffset() {
        int max = (int) (Math.max(this.y, 0.0f) * ((float) this.l));
        return this.m ? -max : max;
    }

    public int getMinFlingVelocity() {
        return this.f;
    }

    public int getPanelHeight() {
        return this.j;
    }

    public PanelState getPanelState() {
        return this.w;
    }

    public int getShadowHeight() {
        return this.k;
    }

    public final boolean h(View view, int i2, int i3) {
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        getLocationOnScreen(iArr2);
        int i4 = iArr2[0] + i2;
        int i5 = iArr2[1] + i3;
        if (i4 < iArr[0]) {
            return false;
        }
        if (i4 >= view.getWidth() + iArr[0] || i5 < iArr[1]) {
            return false;
        }
        if (i5 < view.getHeight() + iArr[1]) {
            return true;
        }
        return false;
    }

    public void i() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    public boolean j(float f2) {
        if (isEnabled() && this.u != null) {
            int e = e(f2);
            ViewDragHelper viewDragHelper = this.K;
            View view = this.u;
            int left = view.getLeft();
            viewDragHelper.r = view;
            viewDragHelper.c = -1;
            if (viewDragHelper.k(left, e, 0, 0)) {
                i();
                AtomicInteger atomicInteger = r8.f3055a;
                postInvalidateOnAnimation();
                return true;
            }
        }
        return false;
    }

    public void k() {
        int i2;
        int i3;
        int i4;
        int i5;
        if (getChildCount() != 0) {
            int paddingLeft = getPaddingLeft();
            int width = getWidth() - getPaddingRight();
            int paddingTop = getPaddingTop();
            int height = getHeight() - getPaddingBottom();
            View view = this.u;
            int i6 = 0;
            if (view != null) {
                Drawable background = view.getBackground();
                if (background != null && background.getOpacity() == -1) {
                    i5 = this.u.getLeft();
                    i4 = this.u.getRight();
                    i3 = this.u.getTop();
                    i2 = this.u.getBottom();
                    View childAt = getChildAt(0);
                    int max = Math.max(paddingLeft, childAt.getLeft());
                    int max2 = Math.max(paddingTop, childAt.getTop());
                    int min = Math.min(width, childAt.getRight());
                    int min2 = Math.min(height, childAt.getBottom());
                    if (max >= i5 && max2 >= i3 && min <= i4 && min2 <= i2) {
                        i6 = 4;
                    }
                    childAt.setVisibility(i6);
                }
            }
            i5 = 0;
            i4 = 0;
            i3 = 0;
            i2 = 0;
            View childAt2 = getChildAt(0);
            int max3 = Math.max(paddingLeft, childAt2.getLeft());
            int max22 = Math.max(paddingTop, childAt2.getTop());
            int min3 = Math.min(width, childAt2.getRight());
            int min22 = Math.min(height, childAt2.getBottom());
            i6 = 4;
            childAt2.setVisibility(i6);
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.L = true;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.L = true;
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        int i2 = this.q;
        if (i2 != -1) {
            setDragView(findViewById(i2));
        }
        int i3 = this.s;
        if (i3 != -1) {
            setScrollableView(findViewById(i3));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0036, code lost:
        if (r0 != 3) goto L_0x0098;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r12) {
        /*
        // Method dump skipped, instructions count: 412
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sothree.slidinguppanel.SlidingUpPanelLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.L) {
            int ordinal = this.w.ordinal();
            if (ordinal == 0) {
                this.y = 1.0f;
            } else if (ordinal == 2) {
                this.y = this.A;
            } else if (ordinal != 3) {
                this.y = 0.0f;
            } else {
                this.y = f(e(0.0f) + (this.m ? this.j : -this.j));
            }
        }
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (childAt.getVisibility() != 8 || (i6 != 0 && !this.L)) {
                int measuredHeight = childAt.getMeasuredHeight();
                int e = childAt == this.u ? e(this.y) : paddingTop;
                if (!this.m && childAt == this.v && !this.n) {
                    e = e(this.y) + this.u.getMeasuredHeight();
                }
                int i7 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + paddingLeft;
                childAt.layout(i7, e, childAt.getMeasuredWidth() + i7, measuredHeight + e);
            }
        }
        if (this.L) {
            k();
        }
        d();
        this.L = false;
    }

    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (mode != 1073741824 && mode != Integer.MIN_VALUE) {
            throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
        } else if (mode2 == 1073741824 || mode2 == Integer.MIN_VALUE) {
            int childCount = getChildCount();
            if (childCount == 2) {
                this.v = getChildAt(0);
                View childAt = getChildAt(1);
                this.u = childAt;
                if (this.p == null) {
                    setDragView(childAt);
                }
                if (this.u.getVisibility() != 0) {
                    this.w = PanelState.HIDDEN;
                }
                int paddingTop = (size2 - getPaddingTop()) - getPaddingBottom();
                int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
                for (int i8 = 0; i8 < childCount; i8++) {
                    View childAt2 = getChildAt(i8);
                    LayoutParams layoutParams = (LayoutParams) childAt2.getLayoutParams();
                    if (childAt2.getVisibility() != 8 || i8 != 0) {
                        if (childAt2 == this.v) {
                            i5 = (this.n || this.w == PanelState.HIDDEN) ? paddingTop : paddingTop - this.j;
                            i4 = paddingLeft - (((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin);
                        } else {
                            i5 = childAt2 == this.u ? paddingTop - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin : paddingTop;
                            i4 = paddingLeft;
                        }
                        int i9 = ((ViewGroup.MarginLayoutParams) layoutParams).width;
                        if (i9 == -2) {
                            i6 = View.MeasureSpec.makeMeasureSpec(i4, RtlSpacingHelper.UNDEFINED);
                        } else if (i9 == -1) {
                            i6 = View.MeasureSpec.makeMeasureSpec(i4, CommonUtils.BYTES_IN_A_GIGABYTE);
                        } else {
                            i6 = View.MeasureSpec.makeMeasureSpec(i9, CommonUtils.BYTES_IN_A_GIGABYTE);
                        }
                        int i10 = ((ViewGroup.MarginLayoutParams) layoutParams).height;
                        if (i10 == -2) {
                            i7 = View.MeasureSpec.makeMeasureSpec(i5, RtlSpacingHelper.UNDEFINED);
                        } else {
                            float f2 = layoutParams.f704a;
                            if (f2 > 0.0f && f2 < 1.0f) {
                                i5 = (int) (((float) i5) * f2);
                            } else if (i10 != -1) {
                                i5 = i10;
                            }
                            i7 = View.MeasureSpec.makeMeasureSpec(i5, CommonUtils.BYTES_IN_A_GIGABYTE);
                        }
                        childAt2.measure(i6, i7);
                        View view = this.u;
                        if (childAt2 == view) {
                            this.z = view.getMeasuredHeight() - this.j;
                        }
                    }
                }
                setMeasuredDimension(size, size2);
                return;
            }
            throw new IllegalStateException("Sliding up panel layout must have exactly 2 children!");
        } else {
            throw new IllegalStateException("Height must have an exact value or MATCH_PARENT");
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            PanelState panelState = (PanelState) bundle.getSerializable("sliding_state");
            this.w = panelState;
            if (panelState == null) {
                panelState = O;
            }
            this.w = panelState;
            parcelable = bundle.getParcelable("superState");
        }
        super.onRestoreInstanceState(parcelable);
    }

    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("superState", super.onSaveInstanceState());
        PanelState panelState = this.w;
        if (panelState == PanelState.DRAGGING) {
            panelState = this.x;
        }
        bundle.putSerializable("sliding_state", panelState);
        return bundle;
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i3 != i5) {
            this.L = true;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || !g()) {
            return super.onTouchEvent(motionEvent);
        }
        try {
            this.K.l(motionEvent);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void setAnchorPoint(float f2) {
        if (f2 > 0.0f && f2 <= 1.0f) {
            this.A = f2;
            this.L = true;
            requestLayout();
        }
    }

    public void setClipPanel(boolean z2) {
        this.o = z2;
    }

    public void setCoveredFadeColor(int i2) {
        this.g = i2;
        requestLayout();
    }

    public void setDragView(View view) {
        View view2 = this.p;
        if (view2 != null) {
            view2.setOnClickListener(null);
        }
        this.p = view;
        if (view != null) {
            view.setClickable(true);
            this.p.setFocusable(false);
            this.p.setFocusableInTouchMode(false);
            this.p.setOnClickListener(new View.OnClickListener() {
                /* class com.sothree.slidinguppanel.SlidingUpPanelLayout.AnonymousClass1 */

                public void onClick(View view) {
                    PanelState panelState;
                    if (SlidingUpPanelLayout.this.isEnabled() && SlidingUpPanelLayout.this.g()) {
                        SlidingUpPanelLayout slidingUpPanelLayout = SlidingUpPanelLayout.this;
                        PanelState panelState2 = slidingUpPanelLayout.w;
                        PanelState panelState3 = PanelState.EXPANDED;
                        if (panelState2 == panelState3 || panelState2 == (panelState = PanelState.ANCHORED)) {
                            slidingUpPanelLayout.setPanelState(PanelState.COLLAPSED);
                        } else if (slidingUpPanelLayout.A < 1.0f) {
                            slidingUpPanelLayout.setPanelState(panelState);
                        } else {
                            slidingUpPanelLayout.setPanelState(panelState3);
                        }
                    }
                }
            });
        }
    }

    public void setFadeOnClickListener(View.OnClickListener onClickListener) {
        this.J = onClickListener;
    }

    public void setGravity(int i2) {
        if (i2 == 48 || i2 == 80) {
            this.m = i2 == 80;
            if (!this.L) {
                requestLayout();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("gravity must be set to either top or bottom");
    }

    public void setMinFlingVelocity(int i2) {
        this.f = i2;
    }

    public void setOverlayed(boolean z2) {
        this.n = z2;
    }

    public void setPanelHeight(int i2) {
        if (getPanelHeight() != i2) {
            this.j = i2;
            if (!this.L) {
                requestLayout();
            }
            if (getPanelState() == PanelState.COLLAPSED) {
                j(0.0f);
                invalidate();
            }
        }
    }

    public void setPanelState(PanelState panelState) {
        PanelState panelState2;
        PanelState panelState3;
        ViewDragHelper viewDragHelper = this.K;
        if (viewDragHelper.f705a == 2) {
            viewDragHelper.a();
        }
        if (panelState == null || panelState == (panelState2 = PanelState.DRAGGING)) {
            throw new IllegalArgumentException("Panel state cannot be null or DRAGGING.");
        } else if (isEnabled()) {
            boolean z2 = this.L;
            if ((z2 || this.u != null) && panelState != (panelState3 = this.w) && panelState3 != panelState2) {
                if (z2) {
                    setPanelStateInternal(panelState);
                    return;
                }
                if (panelState3 == PanelState.HIDDEN) {
                    this.u.setVisibility(0);
                    requestLayout();
                }
                int ordinal = panelState.ordinal();
                if (ordinal == 0) {
                    j(1.0f);
                } else if (ordinal == 1) {
                    j(0.0f);
                } else if (ordinal == 2) {
                    j(this.A);
                } else if (ordinal == 3) {
                    j(f(e(0.0f) + (this.m ? this.j : -this.j)));
                }
            }
        }
    }

    public void setParallaxOffset(int i2) {
        this.l = i2;
        if (!this.L) {
            requestLayout();
        }
    }

    public void setScrollableView(View view) {
        this.r = view;
    }

    public void setScrollableViewHelper(ScrollableViewHelper scrollableViewHelper) {
        this.t = scrollableViewHelper;
    }

    public void setShadowHeight(int i2) {
        this.k = i2;
        if (!this.L) {
            invalidate();
        }
    }

    public void setTouchEnabled(boolean z2) {
        this.C = z2;
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public static final int[] b = {16843137};

        /* renamed from: a  reason: collision with root package name */
        public float f704a = 0.0f;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b);
            if (obtainStyledAttributes != null) {
                this.f704a = obtainStyledAttributes.getFloat(0, 0.0f);
                obtainStyledAttributes.recycle();
            }
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void setDragView(int i2) {
        this.q = i2;
        setDragView(findViewById(i2));
    }
}
