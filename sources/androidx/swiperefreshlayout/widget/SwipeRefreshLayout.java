package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.ListView;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.perf.util.Constants;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import defpackage.bn;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class SwipeRefreshLayout extends ViewGroup implements k8, j8, h8 {
    public static final String Q = SwipeRefreshLayout.class.getSimpleName();
    public static final int[] R = {16842766};
    public int A;
    public int B;
    public int C;
    public int D;
    public bn E;
    public Animation F;
    public Animation G;
    public Animation H;
    public Animation I;
    public boolean J;
    public int K;
    public g L;
    public boolean M;
    public Animation.AnimationListener N = new a();
    public final Animation O = new e();
    public final Animation P = new f();
    public View f;
    public h g;
    public boolean h = false;
    public int i;
    public float j = -1.0f;
    public float k;
    public final l8 l;
    public final i8 m;
    public final int[] n = new int[2];
    public final int[] o = new int[2];
    public final int[] p = new int[2];
    public boolean q;
    public int r;
    public int s;
    public float t;
    public float u;
    public boolean v;
    public int w = -1;
    public final DecelerateInterpolator x;
    public ym y;
    public int z = -1;

    public class a implements Animation.AnimationListener {
        public a() {
        }

        public void onAnimationEnd(Animation animation) {
            h hVar;
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (swipeRefreshLayout.h) {
                swipeRefreshLayout.E.setAlpha(Constants.MAX_HOST_LENGTH);
                SwipeRefreshLayout.this.E.start();
                SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
                if (swipeRefreshLayout2.J && (hVar = swipeRefreshLayout2.g) != null) {
                    fv5 fv5 = fv5.this;
                    tj5 tj5 = fv5.j;
                    if (tj5 != null) {
                        tj5.cancel();
                    }
                    fv5.j = fv5.h.b(null, new iv5(fv5));
                    SwipeRefreshLayout swipeRefreshLayout3 = fv5.f;
                    if (swipeRefreshLayout3 != null) {
                        swipeRefreshLayout3.setRefreshing(true);
                    }
                }
                SwipeRefreshLayout swipeRefreshLayout4 = SwipeRefreshLayout.this;
                swipeRefreshLayout4.s = swipeRefreshLayout4.y.getTop();
                return;
            }
            swipeRefreshLayout.h();
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    public class b extends Animation {
        public b() {
        }

        public void applyTransformation(float f2, Transformation transformation) {
            SwipeRefreshLayout.this.setAnimationProgress(1.0f - f2);
        }
    }

    public class c extends Animation {
        public final /* synthetic */ int f;
        public final /* synthetic */ int g;

        public c(int i, int i2) {
            this.f = i;
            this.g = i2;
        }

        public void applyTransformation(float f2, Transformation transformation) {
            bn bnVar = SwipeRefreshLayout.this.E;
            int i = this.f;
            bnVar.setAlpha((int) ((((float) (this.g - i)) * f2) + ((float) i)));
        }
    }

    public class d implements Animation.AnimationListener {
        public d() {
        }

        public void onAnimationEnd(Animation animation) {
            Objects.requireNonNull(SwipeRefreshLayout.this);
            SwipeRefreshLayout.this.l(null);
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    public class e extends Animation {
        public e() {
        }

        public void applyTransformation(float f2, Transformation transformation) {
            Objects.requireNonNull(SwipeRefreshLayout.this);
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            int abs = swipeRefreshLayout.C - Math.abs(swipeRefreshLayout.B);
            SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
            int i = swipeRefreshLayout2.A;
            SwipeRefreshLayout.this.setTargetOffsetTopAndBottom((i + ((int) (((float) (abs - i)) * f2))) - swipeRefreshLayout2.y.getTop());
            bn bnVar = SwipeRefreshLayout.this.E;
            float f3 = 1.0f - f2;
            bn.a aVar = bnVar.f;
            if (f3 != aVar.p) {
                aVar.p = f3;
            }
            bnVar.invalidateSelf();
        }
    }

    public class f extends Animation {
        public f() {
        }

        public void applyTransformation(float f2, Transformation transformation) {
            SwipeRefreshLayout.this.f(f2);
        }
    }

    public interface g {
        boolean a(SwipeRefreshLayout swipeRefreshLayout, View view);
    }

    public interface h {
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = ViewConfiguration.get(context).getScaledTouchSlop();
        this.r = getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.x = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.K = (int) (displayMetrics.density * 40.0f);
        this.y = new ym(getContext());
        bn bnVar = new bn(getContext());
        this.E = bnVar;
        bnVar.c(1);
        this.y.setImageDrawable(this.E);
        this.y.setVisibility(8);
        addView(this.y);
        setChildrenDrawingOrderEnabled(true);
        int i2 = (int) (displayMetrics.density * 64.0f);
        this.C = i2;
        this.j = (float) i2;
        this.l = new l8();
        this.m = new i8(this);
        setNestedScrollingEnabled(true);
        int i3 = -this.K;
        this.s = i3;
        this.B = i3;
        f(1.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
    }

    private void setColorViewAlpha(int i2) {
        this.y.getBackground().setAlpha(i2);
        bn bnVar = this.E;
        bnVar.f.t = i2;
        bnVar.invalidateSelf();
    }

    public boolean a() {
        g gVar = this.L;
        if (gVar != null) {
            return gVar.a(this, this.f);
        }
        View view = this.f;
        if (view instanceof ListView) {
            return ((ListView) view).canScrollList(-1);
        }
        return view.canScrollVertically(-1);
    }

    public final void b() {
        if (this.f == null) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                if (!childAt.equals(this.y)) {
                    this.f = childAt;
                    return;
                }
            }
        }
    }

    public final void c(float f2) {
        if (f2 > this.j) {
            i(true, true);
            return;
        }
        this.h = false;
        bn bnVar = this.E;
        bn.a aVar = bnVar.f;
        aVar.e = 0.0f;
        aVar.f = 0.0f;
        bnVar.invalidateSelf();
        d dVar = new d();
        this.A = this.s;
        this.P.reset();
        this.P.setDuration(200);
        this.P.setInterpolator(this.x);
        ym ymVar = this.y;
        ymVar.f = dVar;
        ymVar.clearAnimation();
        this.y.startAnimation(this.P);
        bn bnVar2 = this.E;
        bn.a aVar2 = bnVar2.f;
        if (aVar2.n) {
            aVar2.n = false;
        }
        bnVar2.invalidateSelf();
    }

    public final boolean d(Animation animation) {
        return animation != null && animation.hasStarted() && !animation.hasEnded();
    }

    public boolean dispatchNestedFling(float f2, float f3, boolean z2) {
        return this.m.a(f2, f3, z2);
    }

    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.m.b(f2, f3);
    }

    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return this.m.c(i2, i3, iArr, iArr2, 0);
    }

    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return this.m.e(i2, i3, i4, i5, iArr);
    }

    public final void e(float f2) {
        bn bnVar = this.E;
        bn.a aVar = bnVar.f;
        if (!aVar.n) {
            aVar.n = true;
        }
        bnVar.invalidateSelf();
        float min = Math.min(1.0f, Math.abs(f2 / this.j));
        float max = (((float) Math.max(((double) min) - 0.4d, (double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) * 5.0f) / 3.0f;
        float abs = Math.abs(f2) - this.j;
        int i2 = this.D;
        if (i2 <= 0) {
            i2 = this.C;
        }
        float f3 = (float) i2;
        double max2 = (double) (Math.max(0.0f, Math.min(abs, f3 * 2.0f) / f3) / 4.0f);
        float pow = ((float) (max2 - Math.pow(max2, 2.0d))) * 2.0f;
        int i3 = this.B + ((int) ((f3 * min) + (f3 * pow * 2.0f)));
        if (this.y.getVisibility() != 0) {
            this.y.setVisibility(0);
        }
        this.y.setScaleX(1.0f);
        this.y.setScaleY(1.0f);
        if (f2 < this.j) {
            if (this.E.f.t > 76 && !d(this.H)) {
                this.H = j(this.E.f.t, 76);
            }
        } else if (this.E.f.t < 255 && !d(this.I)) {
            this.I = j(this.E.f.t, Constants.MAX_HOST_LENGTH);
        }
        bn bnVar2 = this.E;
        float min2 = Math.min(0.8f, max * 0.8f);
        bn.a aVar2 = bnVar2.f;
        aVar2.e = 0.0f;
        aVar2.f = min2;
        bnVar2.invalidateSelf();
        bn bnVar3 = this.E;
        float min3 = Math.min(1.0f, max);
        bn.a aVar3 = bnVar3.f;
        if (min3 != aVar3.p) {
            aVar3.p = min3;
        }
        bnVar3.invalidateSelf();
        bn bnVar4 = this.E;
        bnVar4.f.g = ((pow * 2.0f) + ((max * 0.4f) - 16.0f)) * 0.5f;
        bnVar4.invalidateSelf();
        setTargetOffsetTopAndBottom(i3 - this.s);
    }

    public void f(float f2) {
        int i2 = this.A;
        setTargetOffsetTopAndBottom((i2 + ((int) (((float) (this.B - i2)) * f2))) - this.y.getTop());
    }

    public final void g(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.w) {
            this.w = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }

    public int getChildDrawingOrder(int i2, int i3) {
        int i4 = this.z;
        if (i4 < 0) {
            return i3;
        }
        if (i3 == i2 - 1) {
            return i4;
        }
        return i3 >= i4 ? i3 + 1 : i3;
    }

    public int getNestedScrollAxes() {
        return this.l.a();
    }

    public int getProgressCircleDiameter() {
        return this.K;
    }

    public int getProgressViewEndOffset() {
        return this.C;
    }

    public int getProgressViewStartOffset() {
        return this.B;
    }

    public void h() {
        this.y.clearAnimation();
        this.E.stop();
        this.y.setVisibility(8);
        setColorViewAlpha(Constants.MAX_HOST_LENGTH);
        setTargetOffsetTopAndBottom(this.B - this.s);
        this.s = this.y.getTop();
    }

    public boolean hasNestedScrollingParent() {
        return this.m.h(0);
    }

    public final void i(boolean z2, boolean z3) {
        if (this.h != z2) {
            this.J = z3;
            b();
            this.h = z2;
            if (z2) {
                int i2 = this.s;
                Animation.AnimationListener animationListener = this.N;
                this.A = i2;
                this.O.reset();
                this.O.setDuration(200);
                this.O.setInterpolator(this.x);
                if (animationListener != null) {
                    this.y.f = animationListener;
                }
                this.y.clearAnimation();
                this.y.startAnimation(this.O);
                return;
            }
            l(this.N);
        }
    }

    public boolean isNestedScrollingEnabled() {
        return this.m.d;
    }

    public final Animation j(int i2, int i3) {
        c cVar = new c(i2, i3);
        cVar.setDuration(300);
        ym ymVar = this.y;
        ymVar.f = null;
        ymVar.clearAnimation();
        this.y.startAnimation(cVar);
        return cVar;
    }

    public final void k(float f2) {
        float f3 = this.u;
        int i2 = this.i;
        if (f2 - f3 > ((float) i2) && !this.v) {
            this.t = f3 + ((float) i2);
            this.v = true;
            this.E.setAlpha(76);
        }
    }

    public void l(Animation.AnimationListener animationListener) {
        b bVar = new b();
        this.G = bVar;
        bVar.setDuration(150);
        ym ymVar = this.y;
        ymVar.f = animationListener;
        ymVar.clearAnimation();
        this.y.startAnimation(this.G);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int findPointerIndex;
        b();
        int actionMasked = motionEvent.getActionMasked();
        if (!isEnabled() || a() || this.h || this.q) {
            return false;
        }
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i2 = this.w;
                    if (i2 == -1 || (findPointerIndex = motionEvent.findPointerIndex(i2)) < 0) {
                        return false;
                    }
                    k(motionEvent.getY(findPointerIndex));
                } else if (actionMasked != 3) {
                    if (actionMasked == 6) {
                        g(motionEvent);
                    }
                }
            }
            this.v = false;
            this.w = -1;
        } else {
            setTargetOffsetTopAndBottom(this.B - this.y.getTop());
            int pointerId = motionEvent.getPointerId(0);
            this.w = pointerId;
            this.v = false;
            int findPointerIndex2 = motionEvent.findPointerIndex(pointerId);
            if (findPointerIndex2 < 0) {
                return false;
            }
            this.u = motionEvent.getY(findPointerIndex2);
        }
        return this.v;
    }

    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() != 0) {
            if (this.f == null) {
                b();
            }
            View view = this.f;
            if (view != null) {
                int paddingLeft = getPaddingLeft();
                int paddingTop = getPaddingTop();
                view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
                int measuredWidth2 = this.y.getMeasuredWidth();
                int measuredHeight2 = this.y.getMeasuredHeight();
                int i6 = measuredWidth / 2;
                int i7 = measuredWidth2 / 2;
                int i8 = this.s;
                this.y.layout(i6 - i7, i8, i6 + i7, measuredHeight2 + i8);
            }
        }
    }

    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.f == null) {
            b();
        }
        View view = this.f;
        if (view != null) {
            view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), CommonUtils.BYTES_IN_A_GIGABYTE), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), CommonUtils.BYTES_IN_A_GIGABYTE));
            this.y.measure(View.MeasureSpec.makeMeasureSpec(this.K, CommonUtils.BYTES_IN_A_GIGABYTE), View.MeasureSpec.makeMeasureSpec(this.K, CommonUtils.BYTES_IN_A_GIGABYTE));
            this.z = -1;
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                if (getChildAt(i4) == this.y) {
                    this.z = i4;
                    return;
                }
            }
        }
    }

    public boolean onNestedFling(View view, float f2, float f3, boolean z2) {
        return dispatchNestedFling(f2, f3, z2);
    }

    public boolean onNestedPreFling(View view, float f2, float f3) {
        return dispatchNestedPreFling(f2, f3);
    }

    @Override // defpackage.j8
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr, int i4) {
        if (i4 == 0) {
            onNestedPreScroll(view, i2, i3, iArr);
        }
    }

    @Override // defpackage.k8
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        if (i6 == 0) {
            int i7 = iArr[1];
            int[] iArr2 = this.o;
            if (i6 == 0) {
                this.m.d(i2, i3, i4, i5, iArr2, i6, iArr);
            }
            int i8 = i5 - (iArr[1] - i7);
            int i9 = i8 == 0 ? i5 + this.o[1] : i8;
            if (i9 < 0 && !a()) {
                float abs = this.k + ((float) Math.abs(i9));
                this.k = abs;
                e(abs);
                iArr[1] = iArr[1] + i8;
            }
        }
    }

    @Override // defpackage.j8
    public void onNestedScrollAccepted(View view, View view2, int i2, int i3) {
        if (i3 == 0) {
            onNestedScrollAccepted(view, view2, i2);
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setRefreshing(savedState.f);
    }

    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.h);
    }

    @Override // defpackage.j8
    public boolean onStartNestedScroll(View view, View view2, int i2, int i3) {
        if (i3 == 0) {
            return onStartNestedScroll(view, view2, i2);
        }
        return false;
    }

    @Override // defpackage.j8
    public void onStopNestedScroll(View view, int i2) {
        if (i2 == 0) {
            onStopNestedScroll(view);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (!isEnabled() || a() || this.h || this.q) {
            return false;
        }
        if (actionMasked == 0) {
            this.w = motionEvent.getPointerId(0);
            this.v = false;
        } else if (actionMasked == 1) {
            int findPointerIndex = motionEvent.findPointerIndex(this.w);
            if (findPointerIndex < 0) {
                return false;
            }
            if (this.v) {
                this.v = false;
                c((motionEvent.getY(findPointerIndex) - this.t) * 0.5f);
            }
            this.w = -1;
            return false;
        } else if (actionMasked == 2) {
            int findPointerIndex2 = motionEvent.findPointerIndex(this.w);
            if (findPointerIndex2 < 0) {
                return false;
            }
            float y2 = motionEvent.getY(findPointerIndex2);
            k(y2);
            if (this.v) {
                float f2 = (y2 - this.t) * 0.5f;
                if (f2 <= 0.0f) {
                    return false;
                }
                getParent().requestDisallowInterceptTouchEvent(true);
                e(f2);
            }
        } else if (actionMasked == 3) {
            return false;
        } else {
            if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                if (actionIndex < 0) {
                    return false;
                }
                this.w = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                g(motionEvent);
            }
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z2) {
        ViewParent parent;
        View view = this.f;
        if (view != null) {
            AtomicInteger atomicInteger = r8.f3055a;
            if (!view.isNestedScrollingEnabled()) {
                if (!this.M && (parent = getParent()) != null) {
                    parent.requestDisallowInterceptTouchEvent(z2);
                    return;
                }
                return;
            }
        }
        super.requestDisallowInterceptTouchEvent(z2);
    }

    public void setAnimationProgress(float f2) {
        this.y.setScaleX(f2);
        this.y.setScaleY(f2);
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(int... iArr) {
        b();
        bn bnVar = this.E;
        bn.a aVar = bnVar.f;
        aVar.i = iArr;
        aVar.a(0);
        bnVar.f.a(0);
        bnVar.invalidateSelf();
    }

    public void setColorSchemeResources(int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr2[i2] = q5.b(context, iArr[i2]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setDistanceToTriggerSync(int i2) {
        this.j = (float) i2;
    }

    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
        if (!z2) {
            h();
        }
    }

    @Deprecated
    public void setLegacyRequestDisallowInterceptTouchEventEnabled(boolean z2) {
        this.M = z2;
    }

    public void setNestedScrollingEnabled(boolean z2) {
        i8 i8Var = this.m;
        if (i8Var.d) {
            View view = i8Var.c;
            AtomicInteger atomicInteger = r8.f3055a;
            view.stopNestedScroll();
        }
        i8Var.d = z2;
    }

    public void setOnChildScrollUpCallback(g gVar) {
        this.L = gVar;
    }

    public void setOnRefreshListener(h hVar) {
        this.g = hVar;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i2) {
        setProgressBackgroundColorSchemeResource(i2);
    }

    public void setProgressBackgroundColorSchemeColor(int i2) {
        this.y.setBackgroundColor(i2);
    }

    public void setProgressBackgroundColorSchemeResource(int i2) {
        setProgressBackgroundColorSchemeColor(q5.b(getContext(), i2));
    }

    public void setRefreshing(boolean z2) {
        if (!z2 || this.h == z2) {
            i(z2, false);
            return;
        }
        this.h = z2;
        setTargetOffsetTopAndBottom((this.C + this.B) - this.s);
        this.J = false;
        Animation.AnimationListener animationListener = this.N;
        this.y.setVisibility(0);
        this.E.setAlpha(Constants.MAX_HOST_LENGTH);
        cn cnVar = new cn(this);
        this.F = cnVar;
        cnVar.setDuration((long) this.r);
        if (animationListener != null) {
            this.y.f = animationListener;
        }
        this.y.clearAnimation();
        this.y.startAnimation(this.F);
    }

    public void setSize(int i2) {
        if (i2 == 0 || i2 == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i2 == 0) {
                this.K = (int) (displayMetrics.density * 56.0f);
            } else {
                this.K = (int) (displayMetrics.density * 40.0f);
            }
            this.y.setImageDrawable(null);
            this.E.c(i2);
            this.y.setImageDrawable(this.E);
        }
    }

    public void setSlingshotDistance(int i2) {
        this.D = i2;
    }

    public void setTargetOffsetTopAndBottom(int i2) {
        this.y.bringToFront();
        r8.o(this.y, i2);
        this.s = this.y.getTop();
    }

    public boolean startNestedScroll(int i2) {
        return this.m.i(i2, 0);
    }

    public void stopNestedScroll() {
        this.m.j(0);
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public final boolean f;

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

        public SavedState(Parcelable parcelable, boolean z) {
            super(parcelable);
            this.f = z;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.f ? (byte) 1 : 0);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f = parcel.readByte() != 0;
        }
    }

    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        if (i3 > 0) {
            float f2 = this.k;
            if (f2 > 0.0f) {
                float f3 = (float) i3;
                if (f3 > f2) {
                    iArr[1] = (int) f2;
                    this.k = 0.0f;
                } else {
                    this.k = f2 - f3;
                    iArr[1] = i3;
                }
                e(this.k);
            }
        }
        int[] iArr2 = this.n;
        if (dispatchNestedPreScroll(i2 - iArr[0], i3 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    public void onNestedScrollAccepted(View view, View view2, int i2) {
        this.l.f2183a = i2;
        startNestedScroll(i2 & 2);
        this.k = 0.0f;
        this.q = true;
    }

    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return isEnabled() && !this.h && (i2 & 2) != 0;
    }

    public void onStopNestedScroll(View view) {
        this.l.b(0);
        this.q = false;
        float f2 = this.k;
        if (f2 > 0.0f) {
            c(f2);
            this.k = 0.0f;
        }
        stopNestedScroll();
    }

    @Override // defpackage.j8
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5, int i6) {
        onNestedScroll(view, i2, i3, i4, i5, i6, this.p);
    }

    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        onNestedScroll(view, i2, i3, i4, i5, 0, this.p);
    }
}
