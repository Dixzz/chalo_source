package defpackage;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: q9  reason: default package */
/* compiled from: AutoScrollHelper */
public abstract class q9 implements View.OnTouchListener {
    public static final int v = ViewConfiguration.getTapTimeout();
    public final a f;
    public final Interpolator g = new AccelerateInterpolator();
    public final View h;
    public Runnable i;
    public float[] j = {0.0f, 0.0f};
    public float[] k = {Float.MAX_VALUE, Float.MAX_VALUE};
    public int l;
    public int m;
    public float[] n = {0.0f, 0.0f};
    public float[] o = {0.0f, 0.0f};
    public float[] p = {Float.MAX_VALUE, Float.MAX_VALUE};
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;

    /* renamed from: q9$a */
    /* compiled from: AutoScrollHelper */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f2913a;
        public int b;
        public float c;
        public float d;
        public long e = Long.MIN_VALUE;
        public long f = 0;
        public int g = 0;
        public int h = 0;
        public long i = -1;
        public float j;
        public int k;

        public final float a(long j2) {
            long j3 = this.e;
            if (j2 < j3) {
                return 0.0f;
            }
            long j4 = this.i;
            if (j4 < 0 || j2 < j4) {
                return q9.b(((float) (j2 - j3)) / ((float) this.f2913a), 0.0f, 1.0f) * 0.5f;
            }
            float f2 = this.j;
            return (q9.b(((float) (j2 - j4)) / ((float) this.k), 0.0f, 1.0f) * f2) + (1.0f - f2);
        }
    }

    /* renamed from: q9$b */
    /* compiled from: AutoScrollHelper */
    public class b implements Runnable {
        public b() {
        }

        public void run() {
            q9 q9Var = q9.this;
            if (q9Var.t) {
                if (q9Var.r) {
                    q9Var.r = false;
                    a aVar = q9Var.f;
                    Objects.requireNonNull(aVar);
                    long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                    aVar.e = currentAnimationTimeMillis;
                    aVar.i = -1;
                    aVar.f = currentAnimationTimeMillis;
                    aVar.j = 0.5f;
                    aVar.g = 0;
                    aVar.h = 0;
                }
                a aVar2 = q9.this.f;
                if ((aVar2.i > 0 && AnimationUtils.currentAnimationTimeMillis() > aVar2.i + ((long) aVar2.k)) || !q9.this.e()) {
                    q9.this.t = false;
                    return;
                }
                q9 q9Var2 = q9.this;
                if (q9Var2.s) {
                    q9Var2.s = false;
                    Objects.requireNonNull(q9Var2);
                    long uptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    q9Var2.h.onTouchEvent(obtain);
                    obtain.recycle();
                }
                if (aVar2.f != 0) {
                    long currentAnimationTimeMillis2 = AnimationUtils.currentAnimationTimeMillis();
                    float a2 = aVar2.a(currentAnimationTimeMillis2);
                    aVar2.f = currentAnimationTimeMillis2;
                    float f2 = ((float) (currentAnimationTimeMillis2 - aVar2.f)) * ((a2 * 4.0f) + (-4.0f * a2 * a2));
                    aVar2.g = (int) (aVar2.c * f2);
                    int i = (int) (f2 * aVar2.d);
                    aVar2.h = i;
                    ((s9) q9.this).w.scrollListBy(i);
                    View view = q9.this.h;
                    AtomicInteger atomicInteger = r8.f3055a;
                    view.postOnAnimation(this);
                    return;
                }
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
        }
    }

    public q9(View view) {
        a aVar = new a();
        this.f = aVar;
        this.h = view;
        float f2 = Resources.getSystem().getDisplayMetrics().density;
        float[] fArr = this.p;
        float f3 = ((float) ((int) ((1575.0f * f2) + 0.5f))) / 1000.0f;
        fArr[0] = f3;
        fArr[1] = f3;
        float[] fArr2 = this.o;
        float f4 = ((float) ((int) ((f2 * 315.0f) + 0.5f))) / 1000.0f;
        fArr2[0] = f4;
        fArr2[1] = f4;
        this.l = 1;
        float[] fArr3 = this.k;
        fArr3[0] = Float.MAX_VALUE;
        fArr3[1] = Float.MAX_VALUE;
        float[] fArr4 = this.j;
        fArr4[0] = 0.2f;
        fArr4[1] = 0.2f;
        float[] fArr5 = this.n;
        fArr5[0] = 0.001f;
        fArr5[1] = 0.001f;
        this.m = v;
        aVar.f2913a = 500;
        aVar.b = 500;
    }

    public static float b(float f2, float f3, float f4) {
        return f2 > f4 ? f4 : f2 < f3 ? f3 : f2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x003f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final float a(int r4, float r5, float r6, float r7) {
        /*
            r3 = this;
            float[] r0 = r3.j
            r0 = r0[r4]
            float[] r1 = r3.k
            r1 = r1[r4]
            float r0 = r0 * r6
            r2 = 0
            float r0 = b(r0, r2, r1)
            float r1 = r3.c(r5, r0)
            float r6 = r6 - r5
            float r5 = r3.c(r6, r0)
            float r5 = r5 - r1
            int r6 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r6 >= 0) goto L_0x0026
            android.view.animation.Interpolator r6 = r3.g
            float r5 = -r5
            float r5 = r6.getInterpolation(r5)
            float r5 = -r5
            goto L_0x0030
        L_0x0026:
            int r6 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r6 <= 0) goto L_0x0039
            android.view.animation.Interpolator r6 = r3.g
            float r5 = r6.getInterpolation(r5)
        L_0x0030:
            r6 = -1082130432(0xffffffffbf800000, float:-1.0)
            r0 = 1065353216(0x3f800000, float:1.0)
            float r5 = b(r5, r6, r0)
            goto L_0x003a
        L_0x0039:
            r5 = 0
        L_0x003a:
            int r6 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r6 != 0) goto L_0x003f
            return r2
        L_0x003f:
            float[] r0 = r3.n
            r0 = r0[r4]
            float[] r1 = r3.o
            r1 = r1[r4]
            float[] r2 = r3.p
            r4 = r2[r4]
            float r0 = r0 * r7
            if (r6 <= 0) goto L_0x0056
            float r5 = r5 * r0
            float r4 = b(r5, r1, r4)
            return r4
        L_0x0056:
            float r5 = -r5
            float r5 = r5 * r0
            float r4 = b(r5, r1, r4)
            float r4 = -r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.q9.a(int, float, float, float):float");
    }

    public final float c(float f2, float f3) {
        if (f3 == 0.0f) {
            return 0.0f;
        }
        int i2 = this.l;
        if (i2 == 0 || i2 == 1) {
            if (f2 < f3) {
                if (f2 >= 0.0f) {
                    return 1.0f - (f2 / f3);
                }
                return (!this.t || i2 != 1) ? 0.0f : 1.0f;
            }
        } else if (i2 == 2 && f2 < 0.0f) {
            return f2 / (-f3);
        }
    }

    public final void d() {
        int i2 = 0;
        if (this.r) {
            this.t = false;
            return;
        }
        a aVar = this.f;
        Objects.requireNonNull(aVar);
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        int i3 = (int) (currentAnimationTimeMillis - aVar.e);
        int i4 = aVar.b;
        if (i3 > i4) {
            i2 = i4;
        } else if (i3 >= 0) {
            i2 = i3;
        }
        aVar.k = i2;
        aVar.j = aVar.a(currentAnimationTimeMillis);
        aVar.i = currentAnimationTimeMillis;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean e() {
        /*
            r9 = this;
            q9$a r0 = r9.f
            float r1 = r0.d
            float r2 = java.lang.Math.abs(r1)
            float r1 = r1 / r2
            int r1 = (int) r1
            float r0 = r0.c
            float r2 = java.lang.Math.abs(r0)
            float r0 = r0 / r2
            int r0 = (int) r0
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0053
            r4 = r9
            s9 r4 = (defpackage.s9) r4
            android.widget.ListView r4 = r4.w
            int r5 = r4.getCount()
            if (r5 != 0) goto L_0x0023
        L_0x0021:
            r1 = 0
            goto L_0x0051
        L_0x0023:
            int r6 = r4.getChildCount()
            int r7 = r4.getFirstVisiblePosition()
            int r8 = r7 + r6
            if (r1 <= 0) goto L_0x0041
            if (r8 < r5) goto L_0x0050
            int r6 = r6 - r2
            android.view.View r1 = r4.getChildAt(r6)
            int r1 = r1.getBottom()
            int r4 = r4.getHeight()
            if (r1 > r4) goto L_0x0050
            goto L_0x0021
        L_0x0041:
            if (r1 >= 0) goto L_0x0021
            if (r7 > 0) goto L_0x0050
            android.view.View r1 = r4.getChildAt(r3)
            int r1 = r1.getTop()
            if (r1 < 0) goto L_0x0050
            goto L_0x0021
        L_0x0050:
            r1 = 1
        L_0x0051:
            if (r1 != 0) goto L_0x0054
        L_0x0053:
            r2 = 0
        L_0x0054:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.q9.e():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0013, code lost:
        if (r0 != 3) goto L_0x007f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
        // Method dump skipped, instructions count: 128
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.q9.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
