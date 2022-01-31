package defpackage;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import java.lang.ref.WeakReference;
import java.util.Objects;

/* renamed from: qk4  reason: default package */
/* compiled from: HeaderBehavior */
public abstract class qk4<V extends View> extends sk4<V> {
    public Runnable c;
    public OverScroller d;
    public boolean e;
    public int f = -1;
    public int g;
    public int h = -1;
    public VelocityTracker i;

    /* JADX WARN: Field signature parse error: g */
    /* renamed from: qk4$a */
    /* compiled from: HeaderBehavior */
    public class a implements Runnable {
        public final CoordinatorLayout f;
        public final View g;

        public a(CoordinatorLayout coordinatorLayout, V v) {
            this.f = coordinatorLayout;
            this.g = v;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: qk4 */
        /* JADX WARN: Multi-variable type inference failed */
        public void run() {
            OverScroller overScroller;
            if (this.g != null && (overScroller = qk4.this.d) != null) {
                if (overScroller.computeScrollOffset()) {
                    qk4 qk4 = qk4.this;
                    qk4.F(this.f, this.g, qk4.d.getCurrY());
                    this.g.postOnAnimation(this);
                    return;
                }
                qk4 qk42 = qk4.this;
                CoordinatorLayout coordinatorLayout = this.f;
                View view = this.g;
                AppBarLayout.BaseBehavior baseBehavior = (AppBarLayout.BaseBehavior) qk42;
                Objects.requireNonNull(baseBehavior);
                AppBarLayout appBarLayout = (AppBarLayout) view;
                baseBehavior.N(coordinatorLayout, appBarLayout);
                if (appBarLayout.p) {
                    appBarLayout.d(appBarLayout.e(baseBehavior.J(coordinatorLayout)));
                }
            }
        }
    }

    public qk4() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00f0 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:44:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean A(androidx.coordinatorlayout.widget.CoordinatorLayout r21, V r22, android.view.MotionEvent r23) {
        /*
        // Method dump skipped, instructions count: 245
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.qk4.A(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    public abstract int D();

    public final int E(CoordinatorLayout coordinatorLayout, V v, int i2, int i3, int i4) {
        return G(coordinatorLayout, v, D() - i2, i3, i4);
    }

    public int F(CoordinatorLayout coordinatorLayout, V v, int i2) {
        return G(coordinatorLayout, v, i2, RtlSpacingHelper.UNDEFINED, Integer.MAX_VALUE);
    }

    public abstract int G(CoordinatorLayout coordinatorLayout, V v, int i2, int i3, int i4);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean j(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z;
        View view;
        int findPointerIndex;
        if (this.h < 0) {
            this.h = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.e) {
            int i2 = this.f;
            if (i2 == -1 || (findPointerIndex = motionEvent.findPointerIndex(i2)) == -1) {
                return false;
            }
            int y = (int) motionEvent.getY(findPointerIndex);
            if (Math.abs(y - this.g) > this.h) {
                this.g = y;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.f = -1;
            int x = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            AppBarLayout.BaseBehavior baseBehavior = (AppBarLayout.BaseBehavior) this;
            AppBarLayout appBarLayout = (AppBarLayout) v;
            AppBarLayout.BaseBehavior.a aVar = baseBehavior.q;
            if (aVar != null) {
                z = aVar.a(appBarLayout);
            } else {
                WeakReference<View> weakReference = baseBehavior.p;
                z = weakReference == null || ((view = weakReference.get()) != null && view.isShown() && !view.canScrollVertically(-1));
            }
            boolean z2 = z && coordinatorLayout.j(v, x, y2);
            this.e = z2;
            if (z2) {
                this.g = y2;
                this.f = motionEvent.getPointerId(0);
                if (this.i == null) {
                    this.i = VelocityTracker.obtain();
                }
                OverScroller overScroller = this.d;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.d.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.i;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return false;
    }

    public qk4(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
