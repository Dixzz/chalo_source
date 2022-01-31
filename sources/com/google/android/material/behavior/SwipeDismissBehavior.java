package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import defpackage.e9;
import defpackage.fa;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.c<V> {

    /* renamed from: a  reason: collision with root package name */
    public fa f614a;
    public b b;
    public boolean c;
    public int d = 2;
    public float e = 0.5f;
    public float f = 0.0f;
    public float g = 0.5f;
    public final fa.c h = new a();

    public class a extends fa.c {

        /* renamed from: a  reason: collision with root package name */
        public int f615a;
        public int b = -1;

        public a() {
        }

        @Override // defpackage.fa.c
        public int a(View view, int i, int i2) {
            int i3;
            int i4;
            int width;
            AtomicInteger atomicInteger = r8.f3055a;
            boolean z = view.getLayoutDirection() == 1;
            int i5 = SwipeDismissBehavior.this.d;
            if (i5 != 0) {
                if (i5 != 1) {
                    i3 = this.f615a - view.getWidth();
                    i4 = view.getWidth() + this.f615a;
                } else if (z) {
                    i3 = this.f615a;
                    width = view.getWidth();
                } else {
                    i3 = this.f615a - view.getWidth();
                    i4 = this.f615a;
                }
                return Math.min(Math.max(i3, i), i4);
            } else if (z) {
                i3 = this.f615a - view.getWidth();
                i4 = this.f615a;
                return Math.min(Math.max(i3, i), i4);
            } else {
                i3 = this.f615a;
                width = view.getWidth();
            }
            i4 = width + i3;
            return Math.min(Math.max(i3, i), i4);
        }

        @Override // defpackage.fa.c
        public int b(View view, int i, int i2) {
            return view.getTop();
        }

        @Override // defpackage.fa.c
        public int c(View view) {
            return view.getWidth();
        }

        @Override // defpackage.fa.c
        public void h(View view, int i) {
            this.b = i;
            this.f615a = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        @Override // defpackage.fa.c
        public void i(int i) {
            b bVar = SwipeDismissBehavior.this.b;
            if (bVar != null) {
                bp4 bp4 = (bp4) bVar;
                Objects.requireNonNull(bp4);
                if (i == 0) {
                    dp4.b().f(bp4.f464a.n);
                } else if (i == 1 || i == 2) {
                    dp4.b().e(bp4.f464a.n);
                }
            }
        }

        @Override // defpackage.fa.c
        public void j(View view, int i, int i2, int i3, int i4) {
            float width = (((float) view.getWidth()) * SwipeDismissBehavior.this.f) + ((float) this.f615a);
            float width2 = (((float) view.getWidth()) * SwipeDismissBehavior.this.g) + ((float) this.f615a);
            float f = (float) i;
            if (f <= width) {
                view.setAlpha(1.0f);
            } else if (f >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.C(0.0f, 1.0f - ((f - width) / (width2 - width)), 1.0f));
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0056, code lost:
            if (java.lang.Math.abs(r8.getLeft() - r7.f615a) >= java.lang.Math.round(((float) r8.getWidth()) * r7.c.e)) goto L_0x002c;
         */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x005b  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x0068  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x0078  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x0085  */
        @Override // defpackage.fa.c
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void k(android.view.View r8, float r9, float r10) {
            /*
            // Method dump skipped, instructions count: 147
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.behavior.SwipeDismissBehavior.a.k(android.view.View, float, float):void");
        }

        @Override // defpackage.fa.c
        public boolean l(View view, int i) {
            int i2 = this.b;
            return (i2 == -1 || i2 == i) && SwipeDismissBehavior.this.B(view);
        }
    }

    public interface b {
    }

    public class c implements Runnable {
        public final View f;
        public final boolean g;

        public c(View view, boolean z) {
            this.f = view;
            this.g = z;
        }

        public void run() {
            b bVar;
            fa faVar = SwipeDismissBehavior.this.f614a;
            if (faVar != null && faVar.j(true)) {
                View view = this.f;
                AtomicInteger atomicInteger = r8.f3055a;
                view.postOnAnimation(this);
            } else if (this.g && (bVar = SwipeDismissBehavior.this.b) != null) {
                ((bp4) bVar).a(this.f);
            }
        }
    }

    public static float C(float f2, float f3, float f4) {
        return Math.min(Math.max(f2, f3), f4);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean A(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        fa faVar = this.f614a;
        if (faVar == null) {
            return false;
        }
        faVar.q(motionEvent);
        return true;
    }

    public boolean B(View view) {
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean j(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z = this.c;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            z = coordinatorLayout.j(v, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.c = z;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.c = false;
        }
        if (!z) {
            return false;
        }
        if (this.f614a == null) {
            this.f614a = new fa(coordinatorLayout.getContext(), coordinatorLayout, this.h);
        }
        return this.f614a.x(motionEvent);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout coordinatorLayout, V v, int i) {
        AtomicInteger atomicInteger = r8.f3055a;
        if (v.getImportantForAccessibility() == 0) {
            v.setImportantForAccessibility(1);
            r8.s(CommonUtils.BYTES_IN_A_MEGABYTE, v);
            r8.m(v, 0);
            if (B(v)) {
                r8.t(v, e9.a.l, null, new vk4(this));
            }
        }
        return false;
    }
}
