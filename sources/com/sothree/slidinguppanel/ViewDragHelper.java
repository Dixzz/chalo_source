package com.sothree.slidinguppanel;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import com.google.firebase.appindexing.Indexable;
import java.util.Arrays;
import java.util.Objects;

public class ViewDragHelper {
    public static final Interpolator v = new Interpolator() {
        /* class com.sothree.slidinguppanel.ViewDragHelper.AnonymousClass1 */

        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public int f705a;
    public int b;
    public int c = -1;
    public float[] d;
    public float[] e;
    public float[] f;
    public float[] g;
    public int[] h;
    public int[] i;
    public int[] j;
    public int k;
    public VelocityTracker l;
    public float m;
    public float n;
    public int o;
    public t9 p;
    public final Callback q;
    public View r;
    public boolean s;
    public final ViewGroup t;
    public final Runnable u = new Runnable() {
        /* class com.sothree.slidinguppanel.ViewDragHelper.AnonymousClass2 */

        public void run() {
            ViewDragHelper.this.q(0);
        }
    };

    public static abstract class Callback {
        public int a() {
            return 0;
        }

        public int b(View view, int i, int i2) {
            return 0;
        }

        public int c() {
            return 0;
        }

        public int d(View view) {
            return 0;
        }

        public void e() {
        }

        public boolean f() {
            return false;
        }

        public void g() {
        }

        public void h(View view, int i) {
        }

        public void i(int i) {
        }

        public void j(View view, int i, int i2, int i3, int i4) {
        }

        public void k(View view, float f, float f2) {
        }

        public abstract boolean l(View view, int i);
    }

    public ViewDragHelper(Context context, ViewGroup viewGroup, Interpolator interpolator, Callback callback) {
        if (callback != null) {
            this.t = viewGroup;
            this.q = callback;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.b = viewConfiguration.getScaledTouchSlop();
            this.m = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.n = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.p = new t9(context, interpolator == null ? v : interpolator);
            return;
        }
        throw new IllegalArgumentException("Callback may not be null");
    }

    public void a() {
        b();
        if (this.f705a == 2) {
            int a2 = this.p.a();
            int b2 = this.p.b();
            this.p.f3320a.abortAnimation();
            int a3 = this.p.a();
            int b3 = this.p.b();
            this.q.j(this.r, a3, b3, a3 - a2, b3 - b2);
        }
        q(0);
    }

    public void b() {
        this.c = -1;
        float[] fArr = this.d;
        if (fArr != null) {
            Arrays.fill(fArr, 0.0f);
            Arrays.fill(this.e, 0.0f);
            Arrays.fill(this.f, 0.0f);
            Arrays.fill(this.g, 0.0f);
            Arrays.fill(this.h, 0);
            Arrays.fill(this.i, 0);
            Arrays.fill(this.j, 0);
            this.k = 0;
        }
        VelocityTracker velocityTracker = this.l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.l = null;
        }
    }

    public final boolean c(float f2, float f3, int i2, int i3) {
        float abs = Math.abs(f2);
        float abs2 = Math.abs(f3);
        if ((this.h[i2] & i3) != i3 || (0 & i3) == 0 || (this.j[i2] & i3) == i3 || (this.i[i2] & i3) == i3) {
            return false;
        }
        int i4 = this.b;
        if (abs <= ((float) i4) && abs2 <= ((float) i4)) {
            return false;
        }
        if (abs < abs2 * 0.5f && this.q.f()) {
            int[] iArr = this.j;
            iArr[i2] = iArr[i2] | i3;
            return false;
        } else if ((this.i[i2] & i3) != 0 || abs <= ((float) this.b)) {
            return false;
        } else {
            return true;
        }
    }

    public final boolean d(View view, float f2, float f3) {
        if (view == null) {
            return false;
        }
        boolean z = this.q.c() > 0;
        boolean z2 = this.q.d(view) > 0;
        if (z && z2) {
            float f4 = f3 * f3;
            int i2 = this.b;
            if (f4 + (f2 * f2) > ((float) (i2 * i2))) {
                return true;
            }
            return false;
        } else if (z) {
            if (Math.abs(f2) > ((float) this.b)) {
                return true;
            }
            return false;
        } else if (!z2 || Math.abs(f3) <= ((float) this.b)) {
            return false;
        } else {
            return true;
        }
    }

    public final float e(float f2, float f3, float f4) {
        float abs = Math.abs(f2);
        if (abs < f3) {
            return 0.0f;
        }
        if (abs > f4) {
            return f2 > 0.0f ? f4 : -f4;
        }
        return f2;
    }

    public final int f(int i2, int i3, int i4) {
        int abs = Math.abs(i2);
        if (abs < i3) {
            return 0;
        }
        if (abs > i4) {
            return i2 > 0 ? i4 : -i4;
        }
        return i2;
    }

    public final void g(int i2) {
        float[] fArr = this.d;
        if (fArr != null && fArr.length > i2) {
            fArr[i2] = 0.0f;
            this.e[i2] = 0.0f;
            this.f[i2] = 0.0f;
            this.g[i2] = 0.0f;
            this.h[i2] = 0;
            this.i[i2] = 0;
            this.j[i2] = 0;
            this.k = (~(1 << i2)) & this.k;
        }
    }

    public final int h(int i2, int i3, int i4) {
        int i5;
        if (i2 == 0) {
            return 0;
        }
        int width = this.t.getWidth();
        float f2 = (float) (width / 2);
        float sin = (((float) Math.sin((double) ((float) (((double) (Math.min(1.0f, ((float) Math.abs(i2)) / ((float) width)) - 0.5f)) * 0.4712389167638204d)))) * f2) + f2;
        int abs = Math.abs(i3);
        if (abs > 0) {
            i5 = Math.round(Math.abs(sin / ((float) abs)) * 1000.0f) * 4;
        } else {
            i5 = (int) (((((float) Math.abs(i2)) / ((float) i4)) + 1.0f) * 256.0f);
        }
        return Math.min(i5, 600);
    }

    public final void i(float f2, float f3) {
        this.s = true;
        this.q.k(this.r, f2, f3);
        this.s = false;
        if (this.f705a == 1) {
            q(0);
        }
    }

    public View j(int i2, int i3) {
        for (int childCount = this.t.getChildCount() - 1; childCount >= 0; childCount--) {
            ViewGroup viewGroup = this.t;
            Objects.requireNonNull(this.q);
            View childAt = viewGroup.getChildAt(childCount);
            if (i2 >= childAt.getLeft() && i2 < childAt.getRight() && i3 >= childAt.getTop() && i3 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public final boolean k(int i2, int i3, int i4, int i5) {
        float f2;
        float f3;
        float f4;
        float f5;
        int left = this.r.getLeft();
        int top = this.r.getTop();
        int i6 = i2 - left;
        int i7 = i3 - top;
        if (i6 == 0 && i7 == 0) {
            this.p.f3320a.abortAnimation();
            q(0);
            return false;
        }
        View view = this.r;
        int f6 = f(i4, (int) this.n, (int) this.m);
        int f7 = f(i5, (int) this.n, (int) this.m);
        int abs = Math.abs(i6);
        int abs2 = Math.abs(i7);
        int abs3 = Math.abs(f6);
        int abs4 = Math.abs(f7);
        int i8 = abs3 + abs4;
        int i9 = abs + abs2;
        if (f6 != 0) {
            f2 = (float) abs3;
            f3 = (float) i8;
        } else {
            f2 = (float) abs;
            f3 = (float) i9;
        }
        float f8 = f2 / f3;
        if (f7 != 0) {
            f5 = (float) abs4;
            f4 = (float) i8;
        } else {
            f5 = (float) abs2;
            f4 = (float) i9;
        }
        int h2 = h(i6, f6, this.q.c());
        this.p.f3320a.startScroll(left, top, i6, i7, (int) ((((float) h(i7, f7, this.q.d(view))) * (f5 / f4)) + (((float) h2) * f8)));
        q(2);
        return true;
    }

    public void l(MotionEvent motionEvent) {
        int i2;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            b();
        }
        if (this.l == null) {
            this.l = VelocityTracker.obtain();
        }
        this.l.addMovement(motionEvent);
        int i3 = 0;
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View j2 = j((int) x, (int) y);
            o(x, y, pointerId);
            r(j2, pointerId);
            if ((this.h[pointerId] & 0) != 0) {
                this.q.g();
            }
        } else if (actionMasked == 1) {
            if (this.f705a == 1) {
                m();
            }
            b();
        } else if (actionMasked != 2) {
            if (actionMasked == 3) {
                if (this.f705a == 1) {
                    i(0.0f, 0.0f);
                }
                b();
            } else if (actionMasked == 5) {
                int pointerId2 = motionEvent.getPointerId(actionIndex);
                float x2 = motionEvent.getX(actionIndex);
                float y2 = motionEvent.getY(actionIndex);
                o(x2, y2, pointerId2);
                if (this.f705a == 0) {
                    r(j((int) x2, (int) y2), pointerId2);
                    if ((this.h[pointerId2] & 0) != 0) {
                        this.q.g();
                        return;
                    }
                    return;
                }
                int i4 = (int) x2;
                int i5 = (int) y2;
                View view = this.r;
                if (view != null && i4 >= view.getLeft() && i4 < view.getRight() && i5 >= view.getTop() && i5 < view.getBottom()) {
                    i3 = 1;
                }
                if (i3 != 0) {
                    r(this.r, pointerId2);
                }
            } else if (actionMasked == 6) {
                int pointerId3 = motionEvent.getPointerId(actionIndex);
                if (this.f705a == 1 && pointerId3 == this.c) {
                    int pointerCount = motionEvent.getPointerCount();
                    while (true) {
                        if (i3 >= pointerCount) {
                            i2 = -1;
                            break;
                        }
                        int pointerId4 = motionEvent.getPointerId(i3);
                        if (pointerId4 != this.c) {
                            View j3 = j((int) motionEvent.getX(i3), (int) motionEvent.getY(i3));
                            View view2 = this.r;
                            if (j3 == view2 && r(view2, pointerId4)) {
                                i2 = this.c;
                                break;
                            }
                        }
                        i3++;
                    }
                    if (i2 == -1) {
                        m();
                    }
                }
                g(pointerId3);
            }
        } else if (this.f705a == 1) {
            int findPointerIndex = motionEvent.findPointerIndex(this.c);
            float x3 = motionEvent.getX(findPointerIndex);
            float y3 = motionEvent.getY(findPointerIndex);
            float[] fArr = this.f;
            int i6 = this.c;
            int i7 = (int) (x3 - fArr[i6]);
            int i8 = (int) (y3 - this.g[i6]);
            int left = this.r.getLeft() + i7;
            int top = this.r.getTop() + i8;
            int left2 = this.r.getLeft();
            int top2 = this.r.getTop();
            if (i7 != 0) {
                left = this.q.a();
                this.r.offsetLeftAndRight(left - left2);
            }
            if (i8 != 0) {
                top = this.q.b(this.r, top, i8);
                this.r.offsetTopAndBottom(top - top2);
            }
            if (!(i7 == 0 && i8 == 0)) {
                this.q.j(this.r, left, top, left - left2, top - top2);
            }
            p(motionEvent);
        } else {
            int pointerCount2 = motionEvent.getPointerCount();
            while (i3 < pointerCount2) {
                int pointerId5 = motionEvent.getPointerId(i3);
                float x4 = motionEvent.getX(i3);
                float y4 = motionEvent.getY(i3);
                float f2 = x4 - this.d[pointerId5];
                float f3 = y4 - this.e[pointerId5];
                n(f2, f3, pointerId5);
                if (this.f705a != 1) {
                    View j4 = j((int) this.d[pointerId5], (int) this.e[pointerId5]);
                    if (d(j4, f2, f3) && r(j4, pointerId5)) {
                        break;
                    }
                    i3++;
                } else {
                    break;
                }
            }
            p(motionEvent);
        }
    }

    public final void m() {
        this.l.computeCurrentVelocity(Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL, this.m);
        i(e(this.l.getXVelocity(this.c), this.n, this.m), e(this.l.getYVelocity(this.c), this.n, this.m));
    }

    public final void n(float f2, float f3, int i2) {
        int i3 = 1;
        if (!c(f2, f3, i2, 1)) {
            i3 = 0;
        }
        if (c(f3, f2, i2, 4)) {
            i3 |= 4;
        }
        if (c(f2, f3, i2, 2)) {
            i3 |= 2;
        }
        if (c(f3, f2, i2, 8)) {
            i3 |= 8;
        }
        if (i3 != 0) {
            int[] iArr = this.i;
            iArr[i2] = iArr[i2] | i3;
            this.q.e();
        }
    }

    public final void o(float f2, float f3, int i2) {
        float[] fArr = this.d;
        int i3 = 0;
        if (fArr == null || fArr.length <= i2) {
            int i4 = i2 + 1;
            float[] fArr2 = new float[i4];
            float[] fArr3 = new float[i4];
            float[] fArr4 = new float[i4];
            float[] fArr5 = new float[i4];
            int[] iArr = new int[i4];
            int[] iArr2 = new int[i4];
            int[] iArr3 = new int[i4];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.d = fArr2;
            this.e = fArr3;
            this.f = fArr4;
            this.g = fArr5;
            this.h = iArr;
            this.i = iArr2;
            this.j = iArr3;
        }
        float[] fArr9 = this.d;
        this.f[i2] = f2;
        fArr9[i2] = f2;
        float[] fArr10 = this.e;
        this.g[i2] = f3;
        fArr10[i2] = f3;
        int[] iArr7 = this.h;
        int i5 = (int) f2;
        int i6 = (int) f3;
        if (i5 < this.t.getLeft() + this.o) {
            i3 = 1;
        }
        if (i6 < this.t.getTop() + this.o) {
            i3 |= 4;
        }
        if (i5 > this.t.getRight() - this.o) {
            i3 |= 2;
        }
        if (i6 > this.t.getBottom() - this.o) {
            i3 |= 8;
        }
        iArr7[i2] = i3;
        this.k |= 1 << i2;
    }

    public final void p(MotionEvent motionEvent) {
        float[] fArr;
        int pointerCount = motionEvent.getPointerCount();
        for (int i2 = 0; i2 < pointerCount; i2++) {
            int pointerId = motionEvent.getPointerId(i2);
            float x = motionEvent.getX(i2);
            float y = motionEvent.getY(i2);
            float[] fArr2 = this.f;
            if (fArr2 != null && (fArr = this.g) != null && fArr2.length > pointerId && fArr.length > pointerId) {
                fArr2[pointerId] = x;
                fArr[pointerId] = y;
            }
        }
    }

    public void q(int i2) {
        if (this.f705a != i2) {
            this.f705a = i2;
            this.q.i(i2);
            if (this.f705a == 0) {
                this.r = null;
            }
        }
    }

    public boolean r(View view, int i2) {
        if (view == this.r && this.c == i2) {
            return true;
        }
        if (view == null || !this.q.l(view, i2)) {
            return false;
        }
        this.c = i2;
        if (view.getParent() == this.t) {
            this.r = view;
            this.c = i2;
            this.q.h(view, i2);
            q(1);
            return true;
        }
        StringBuilder i0 = hj1.i0("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (");
        i0.append(this.t);
        i0.append(")");
        throw new IllegalArgumentException(i0.toString());
    }
}
