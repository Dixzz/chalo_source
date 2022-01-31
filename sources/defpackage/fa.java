package defpackage;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import com.google.firebase.appindexing.Indexable;
import java.util.Arrays;
import java.util.Objects;

/* renamed from: fa  reason: default package */
/* compiled from: ViewDragHelper */
public class fa {
    public static final Interpolator x = new a();

    /* renamed from: a  reason: collision with root package name */
    public int f1107a;
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
    public final int p;
    public int q;
    public OverScroller r;
    public final c s;
    public View t;
    public boolean u;
    public final ViewGroup v;
    public final Runnable w = new b();

    /* renamed from: fa$a */
    /* compiled from: ViewDragHelper */
    public class a implements Interpolator {
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    }

    /* renamed from: fa$b */
    /* compiled from: ViewDragHelper */
    public class b implements Runnable {
        public b() {
        }

        public void run() {
            fa.this.v(0);
        }
    }

    /* renamed from: fa$c */
    /* compiled from: ViewDragHelper */
    public static abstract class c {
        public abstract int a(View view, int i, int i2);

        public abstract int b(View view, int i, int i2);

        public int c(View view) {
            return 0;
        }

        public int d(View view) {
            return 0;
        }

        public void e(int i, int i2) {
        }

        public boolean f(int i) {
            return false;
        }

        public void g(int i, int i2) {
        }

        public void h(View view, int i) {
        }

        public abstract void i(int i);

        public abstract void j(View view, int i, int i2, int i3, int i4);

        public abstract void k(View view, float f, float f2);

        public abstract boolean l(View view, int i);
    }

    public fa(Context context, ViewGroup viewGroup, c cVar) {
        if (cVar != null) {
            this.v = viewGroup;
            this.s = cVar;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            int i2 = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.p = i2;
            this.o = i2;
            this.b = viewConfiguration.getScaledTouchSlop();
            this.m = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.n = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.r = new OverScroller(context, x);
            return;
        }
        throw new IllegalArgumentException("Callback may not be null");
    }

    public static fa k(ViewGroup viewGroup, float f2, c cVar) {
        fa faVar = new fa(viewGroup.getContext(), viewGroup, cVar);
        faVar.b = (int) ((1.0f / f2) * ((float) faVar.b));
        return faVar;
    }

    public void a() {
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

    public void b(View view, int i2) {
        if (view.getParent() == this.v) {
            this.t = view;
            this.c = i2;
            this.s.h(view, i2);
            v(1);
            return;
        }
        StringBuilder i0 = hj1.i0("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (");
        i0.append(this.v);
        i0.append(")");
        throw new IllegalArgumentException(i0.toString());
    }

    public final boolean c(float f2, float f3, int i2, int i3) {
        float abs = Math.abs(f2);
        float abs2 = Math.abs(f3);
        if ((this.h[i2] & i3) != i3 || (this.q & i3) == 0 || (this.j[i2] & i3) == i3 || (this.i[i2] & i3) == i3) {
            return false;
        }
        int i4 = this.b;
        if (abs <= ((float) i4) && abs2 <= ((float) i4)) {
            return false;
        }
        if (abs < abs2 * 0.5f && this.s.f(i3)) {
            int[] iArr = this.j;
            iArr[i2] = iArr[i2] | i3;
            return false;
        } else if ((this.i[i2] & i3) != 0 || abs <= ((float) this.b)) {
            return false;
        } else {
            return true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0040, code lost:
        if ((r7 + (r6 * r6)) > ((float) (r3 * r3))) goto L_0x0042;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0065 A[LOOP:0: B:1:0x0005->B:27:0x0065, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0064 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean d(int r10) {
        /*
        // Method dump skipped, instructions count: 105
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.fa.d(int):boolean");
    }

    public final boolean e(View view, float f2, float f3) {
        if (view == null) {
            return false;
        }
        boolean z = this.s.c(view) > 0;
        boolean z2 = this.s.d(view) > 0;
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

    public final float f(float f2, float f3, float f4) {
        float abs = Math.abs(f2);
        if (abs < f3) {
            return 0.0f;
        }
        if (abs > f4) {
            return f2 > 0.0f ? f4 : -f4;
        }
        return f2;
    }

    public final int g(int i2, int i3, int i4) {
        int abs = Math.abs(i2);
        if (abs < i3) {
            return 0;
        }
        if (abs > i4) {
            return i2 > 0 ? i4 : -i4;
        }
        return i2;
    }

    public final void h(int i2) {
        if (this.d != null && o(i2)) {
            this.d[i2] = 0.0f;
            this.e[i2] = 0.0f;
            this.f[i2] = 0.0f;
            this.g[i2] = 0.0f;
            this.h[i2] = 0;
            this.i[i2] = 0;
            this.j[i2] = 0;
            this.k = (~(1 << i2)) & this.k;
        }
    }

    public final int i(int i2, int i3, int i4) {
        int i5;
        if (i2 == 0) {
            return 0;
        }
        int width = this.v.getWidth();
        float f2 = (float) (width / 2);
        float sin = (((float) Math.sin((double) ((Math.min(1.0f, ((float) Math.abs(i2)) / ((float) width)) - 0.5f) * 0.47123894f))) * f2) + f2;
        int abs = Math.abs(i3);
        if (abs > 0) {
            i5 = Math.round(Math.abs(sin / ((float) abs)) * 1000.0f) * 4;
        } else {
            i5 = (int) (((((float) Math.abs(i2)) / ((float) i4)) + 1.0f) * 256.0f);
        }
        return Math.min(i5, 600);
    }

    public boolean j(boolean z) {
        if (this.f1107a == 2) {
            boolean computeScrollOffset = this.r.computeScrollOffset();
            int currX = this.r.getCurrX();
            int currY = this.r.getCurrY();
            int left = currX - this.t.getLeft();
            int top = currY - this.t.getTop();
            if (left != 0) {
                r8.n(this.t, left);
            }
            if (top != 0) {
                r8.o(this.t, top);
            }
            if (!(left == 0 && top == 0)) {
                this.s.j(this.t, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.r.getFinalX() && currY == this.r.getFinalY()) {
                this.r.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                if (z) {
                    this.v.post(this.w);
                } else {
                    v(0);
                }
            }
        }
        if (this.f1107a == 2) {
            return true;
        }
        return false;
    }

    public final void l(float f2, float f3) {
        this.u = true;
        this.s.k(this.t, f2, f3);
        this.u = false;
        if (this.f1107a == 1) {
            v(0);
        }
    }

    public View m(int i2, int i3) {
        for (int childCount = this.v.getChildCount() - 1; childCount >= 0; childCount--) {
            ViewGroup viewGroup = this.v;
            Objects.requireNonNull(this.s);
            View childAt = viewGroup.getChildAt(childCount);
            if (i2 >= childAt.getLeft() && i2 < childAt.getRight() && i3 >= childAt.getTop() && i3 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public final boolean n(int i2, int i3, int i4, int i5) {
        float f2;
        float f3;
        float f4;
        float f5;
        int left = this.t.getLeft();
        int top = this.t.getTop();
        int i6 = i2 - left;
        int i7 = i3 - top;
        if (i6 == 0 && i7 == 0) {
            this.r.abortAnimation();
            v(0);
            return false;
        }
        View view = this.t;
        int g2 = g(i4, (int) this.n, (int) this.m);
        int g3 = g(i5, (int) this.n, (int) this.m);
        int abs = Math.abs(i6);
        int abs2 = Math.abs(i7);
        int abs3 = Math.abs(g2);
        int abs4 = Math.abs(g3);
        int i8 = abs3 + abs4;
        int i9 = abs + abs2;
        if (g2 != 0) {
            f2 = (float) abs3;
            f3 = (float) i8;
        } else {
            f2 = (float) abs;
            f3 = (float) i9;
        }
        float f6 = f2 / f3;
        if (g3 != 0) {
            f5 = (float) abs4;
            f4 = (float) i8;
        } else {
            f5 = (float) abs2;
            f4 = (float) i9;
        }
        int i10 = i(i6, g2, this.s.c(view));
        float i11 = ((float) i(i7, g3, this.s.d(view))) * (f5 / f4);
        this.r.startScroll(left, top, i6, i7, (int) (i11 + (((float) i10) * f6)));
        v(2);
        return true;
    }

    public boolean o(int i2) {
        return ((1 << i2) & this.k) != 0;
    }

    public final boolean p(int i2) {
        return o(i2);
    }

    public void q(MotionEvent motionEvent) {
        int i2;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            a();
        }
        if (this.l == null) {
            this.l = VelocityTracker.obtain();
        }
        this.l.addMovement(motionEvent);
        int i3 = 0;
        if (actionMasked == 0) {
            float x2 = motionEvent.getX();
            float y = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View m2 = m((int) x2, (int) y);
            t(x2, y, pointerId);
            z(m2, pointerId);
            int i4 = this.h[pointerId];
            int i5 = this.q;
            if ((i4 & i5) != 0) {
                this.s.g(i4 & i5, pointerId);
            }
        } else if (actionMasked == 1) {
            if (this.f1107a == 1) {
                r();
            }
            a();
        } else if (actionMasked != 2) {
            if (actionMasked == 3) {
                if (this.f1107a == 1) {
                    l(0.0f, 0.0f);
                }
                a();
            } else if (actionMasked == 5) {
                int pointerId2 = motionEvent.getPointerId(actionIndex);
                float x3 = motionEvent.getX(actionIndex);
                float y2 = motionEvent.getY(actionIndex);
                t(x3, y2, pointerId2);
                if (this.f1107a == 0) {
                    z(m((int) x3, (int) y2), pointerId2);
                    int i6 = this.h[pointerId2];
                    int i7 = this.q;
                    if ((i6 & i7) != 0) {
                        this.s.g(i6 & i7, pointerId2);
                        return;
                    }
                    return;
                }
                int i8 = (int) x3;
                int i9 = (int) y2;
                View view = this.t;
                if (view != null && i8 >= view.getLeft() && i8 < view.getRight() && i9 >= view.getTop() && i9 < view.getBottom()) {
                    i3 = 1;
                }
                if (i3 != 0) {
                    z(this.t, pointerId2);
                }
            } else if (actionMasked == 6) {
                int pointerId3 = motionEvent.getPointerId(actionIndex);
                if (this.f1107a == 1 && pointerId3 == this.c) {
                    int pointerCount = motionEvent.getPointerCount();
                    while (true) {
                        if (i3 >= pointerCount) {
                            i2 = -1;
                            break;
                        }
                        int pointerId4 = motionEvent.getPointerId(i3);
                        if (pointerId4 != this.c) {
                            View m3 = m((int) motionEvent.getX(i3), (int) motionEvent.getY(i3));
                            View view2 = this.t;
                            if (m3 == view2 && z(view2, pointerId4)) {
                                i2 = this.c;
                                break;
                            }
                        }
                        i3++;
                    }
                    if (i2 == -1) {
                        r();
                    }
                }
                h(pointerId3);
            }
        } else if (this.f1107a != 1) {
            int pointerCount2 = motionEvent.getPointerCount();
            while (i3 < pointerCount2) {
                int pointerId5 = motionEvent.getPointerId(i3);
                if (p(pointerId5)) {
                    float x4 = motionEvent.getX(i3);
                    float y3 = motionEvent.getY(i3);
                    float f2 = x4 - this.d[pointerId5];
                    float f3 = y3 - this.e[pointerId5];
                    s(f2, f3, pointerId5);
                    if (this.f1107a != 1) {
                        View m4 = m((int) x4, (int) y3);
                        if (e(m4, f2, f3) && z(m4, pointerId5)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i3++;
            }
            u(motionEvent);
        } else if (p(this.c)) {
            int findPointerIndex = motionEvent.findPointerIndex(this.c);
            float x5 = motionEvent.getX(findPointerIndex);
            float y4 = motionEvent.getY(findPointerIndex);
            float[] fArr = this.f;
            int i10 = this.c;
            int i11 = (int) (x5 - fArr[i10]);
            int i12 = (int) (y4 - this.g[i10]);
            int left = this.t.getLeft() + i11;
            int top = this.t.getTop() + i12;
            int left2 = this.t.getLeft();
            int top2 = this.t.getTop();
            if (i11 != 0) {
                left = this.s.a(this.t, left, i11);
                r8.n(this.t, left - left2);
            }
            if (i12 != 0) {
                top = this.s.b(this.t, top, i12);
                r8.o(this.t, top - top2);
            }
            if (!(i11 == 0 && i12 == 0)) {
                this.s.j(this.t, left, top, left - left2, top - top2);
            }
            u(motionEvent);
        }
    }

    public final void r() {
        this.l.computeCurrentVelocity(Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL, this.m);
        l(f(this.l.getXVelocity(this.c), this.n, this.m), f(this.l.getYVelocity(this.c), this.n, this.m));
    }

    public final void s(float f2, float f3, int i2) {
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
            this.s.e(i3, i2);
        }
    }

    public final void t(float f2, float f3, int i2) {
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
        if (i5 < this.v.getLeft() + this.o) {
            i3 = 1;
        }
        if (i6 < this.v.getTop() + this.o) {
            i3 |= 4;
        }
        if (i5 > this.v.getRight() - this.o) {
            i3 |= 2;
        }
        if (i6 > this.v.getBottom() - this.o) {
            i3 |= 8;
        }
        iArr7[i2] = i3;
        this.k |= 1 << i2;
    }

    public final void u(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i2 = 0; i2 < pointerCount; i2++) {
            int pointerId = motionEvent.getPointerId(i2);
            if (p(pointerId)) {
                float x2 = motionEvent.getX(i2);
                float y = motionEvent.getY(i2);
                this.f[pointerId] = x2;
                this.g[pointerId] = y;
            }
        }
    }

    public void v(int i2) {
        this.v.removeCallbacks(this.w);
        if (this.f1107a != i2) {
            this.f1107a = i2;
            this.s.i(i2);
            if (this.f1107a == 0) {
                this.t = null;
            }
        }
    }

    public boolean w(int i2, int i3) {
        if (this.u) {
            return n(i2, i3, (int) this.l.getXVelocity(this.c), (int) this.l.getYVelocity(this.c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00dd, code lost:
        if (r12 != r11) goto L_0x00e6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean x(android.view.MotionEvent r17) {
        /*
        // Method dump skipped, instructions count: 315
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.fa.x(android.view.MotionEvent):boolean");
    }

    public boolean y(View view, int i2, int i3) {
        this.t = view;
        this.c = -1;
        boolean n2 = n(i2, i3, 0, 0);
        if (!n2 && this.f1107a == 0 && this.t != null) {
            this.t = null;
        }
        return n2;
    }

    public boolean z(View view, int i2) {
        if (view == this.t && this.c == i2) {
            return true;
        }
        if (view == null || !this.s.l(view, i2)) {
            return false;
        }
        this.c = i2;
        b(view, i2);
        return true;
    }
}
