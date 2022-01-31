package com.urbanairship.iam.banner;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import defpackage.fa;
import java.util.concurrent.atomic.AtomicInteger;

public class BannerDismissLayout extends FrameLayout {
    public float f;
    public String g = "bottom";
    public fa h;
    public float i;
    public Listener j;

    public interface Listener {
        void a(View view);

        void c(View view, int i);
    }

    public class a implements ViewTreeObserver.OnPreDrawListener {
        public final /* synthetic */ float f;

        public a(float f2) {
            this.f = f2;
        }

        public boolean onPreDraw() {
            BannerDismissLayout.this.setYFraction(this.f);
            BannerDismissLayout.this.getViewTreeObserver().removeOnPreDrawListener(this);
            return true;
        }
    }

    public class b implements ViewTreeObserver.OnPreDrawListener {
        public final /* synthetic */ float f;

        public b(float f2) {
            this.f = f2;
        }

        public boolean onPreDraw() {
            BannerDismissLayout.this.setXFraction(this.f);
            BannerDismissLayout.this.getViewTreeObserver().removeOnPreDrawListener(this);
            return true;
        }
    }

    public class c extends fa.c {

        /* renamed from: a  reason: collision with root package name */
        public int f731a;
        public int b;
        public float c = 0.0f;
        public View d;
        public boolean e = false;

        public c(a aVar) {
        }

        @Override // defpackage.fa.c
        public int a(View view, int i, int i2) {
            return view.getLeft();
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x002a  */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x003c  */
        @Override // defpackage.fa.c
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int b(android.view.View r2, int r3, int r4) {
            /*
                r1 = this;
                com.urbanairship.iam.banner.BannerDismissLayout r2 = com.urbanairship.iam.banner.BannerDismissLayout.this
                java.lang.String r2 = r2.g
                int r4 = r2.hashCode()
                r0 = -1383228885(0xffffffffad8d9a2b, float:-1.6098308E-11)
                if (r4 == r0) goto L_0x001d
                r0 = 115029(0x1c155, float:1.6119E-40)
                if (r4 == r0) goto L_0x0013
                goto L_0x0027
            L_0x0013:
                java.lang.String r4 = "top"
                boolean r2 = r2.equals(r4)
                if (r2 == 0) goto L_0x0027
                r2 = 0
                goto L_0x0028
            L_0x001d:
                java.lang.String r4 = "bottom"
                boolean r2 = r2.equals(r4)
                if (r2 == 0) goto L_0x0027
                r2 = 1
                goto L_0x0028
            L_0x0027:
                r2 = -1
            L_0x0028:
                if (r2 == 0) goto L_0x003c
                float r2 = (float) r3
                int r3 = r1.f731a
                float r3 = (float) r3
                com.urbanairship.iam.banner.BannerDismissLayout r4 = com.urbanairship.iam.banner.BannerDismissLayout.this
                float r4 = r4.f
                float r3 = r3 - r4
                float r2 = java.lang.Math.max(r2, r3)
                int r2 = java.lang.Math.round(r2)
                return r2
            L_0x003c:
                float r2 = (float) r3
                int r3 = r1.f731a
                float r3 = (float) r3
                com.urbanairship.iam.banner.BannerDismissLayout r4 = com.urbanairship.iam.banner.BannerDismissLayout.this
                float r4 = r4.f
                float r3 = r3 + r4
                float r2 = java.lang.Math.min(r2, r3)
                int r2 = java.lang.Math.round(r2)
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.iam.banner.BannerDismissLayout.c.b(android.view.View, int, int):int");
        }

        @Override // defpackage.fa.c
        public void h(View view, int i) {
            this.d = view;
            this.f731a = view.getTop();
            this.b = view.getLeft();
            this.c = 0.0f;
            this.e = false;
        }

        @Override // defpackage.fa.c
        public void i(int i) {
            if (this.d != null) {
                synchronized (this) {
                    Listener listener = BannerDismissLayout.this.j;
                    if (listener != null) {
                        listener.c(this.d, i);
                    }
                    if (i == 0) {
                        if (this.e) {
                            Listener listener2 = BannerDismissLayout.this.j;
                            if (listener2 != null) {
                                listener2.a(this.d);
                            }
                            BannerDismissLayout.this.removeView(this.d);
                        }
                        this.d = null;
                    }
                }
            }
        }

        @Override // defpackage.fa.c
        @SuppressLint({"NewApi"})
        public void j(View view, int i, int i2, int i3, int i4) {
            int height = BannerDismissLayout.this.getHeight();
            int abs = Math.abs(i2 - this.f731a);
            if (height > 0) {
                this.c = ((float) abs) / ((float) height);
            }
            BannerDismissLayout.this.invalidate();
        }

        @Override // defpackage.fa.c
        public void k(View view, float f2, float f3) {
            float abs = Math.abs(f3);
            if (!"top".equals(BannerDismissLayout.this.g) ? this.f731a <= view.getTop() : this.f731a >= view.getTop()) {
                float f4 = this.c;
                this.e = f4 >= 0.4f || abs > BannerDismissLayout.this.i || f4 > 0.1f;
            }
            if (this.e) {
                BannerDismissLayout.this.h.w(this.b, "top".equals(BannerDismissLayout.this.g) ? -view.getHeight() : view.getHeight() + BannerDismissLayout.this.getHeight());
            } else {
                BannerDismissLayout.this.h.w(this.b, this.f731a);
            }
            BannerDismissLayout.this.invalidate();
        }

        @Override // defpackage.fa.c
        public boolean l(View view, int i) {
            return this.d == null;
        }
    }

    public BannerDismissLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        if (!isInEditMode()) {
            this.h = new fa(getContext(), this, new c(null));
            this.i = (float) ViewConfiguration.get(context).getScaledMinimumFlingVelocity();
            this.f = TypedValue.applyDimension(1, 24.0f, context.getResources().getDisplayMetrics());
        }
    }

    public void computeScroll() {
        super.computeScroll();
        fa faVar = this.h;
        if (faVar != null && faVar.j(true)) {
            AtomicInteger atomicInteger = r8.f3055a;
            postInvalidateOnAnimation();
        }
    }

    public float getMinFlingVelocity() {
        return this.i;
    }

    @Keep
    public float getXFraction() {
        int width = getWidth();
        if (width == 0) {
            return 0.0f;
        }
        return getTranslationX() / ((float) width);
    }

    @Keep
    public float getYFraction() {
        int height = getHeight();
        if (height == 0) {
            return 0.0f;
        }
        return getTranslationY() / ((float) height);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        View m;
        if (this.h.x(motionEvent) || super.onInterceptTouchEvent(motionEvent)) {
            return true;
        }
        if (this.h.f1107a != 0 || motionEvent.getActionMasked() != 2 || !this.h.d(2) || (m = this.h.m((int) motionEvent.getX(), (int) motionEvent.getY())) == null || m.canScrollVertically(this.h.b)) {
            return false;
        }
        this.h.b(m, motionEvent.getPointerId(0));
        if (this.h.f1107a == 1) {
            return true;
        }
        return false;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        View m;
        this.h.q(motionEvent);
        if (this.h.t == null && motionEvent.getActionMasked() == 2 && this.h.d(2) && (m = this.h.m((int) motionEvent.getX(), (int) motionEvent.getY())) != null && !m.canScrollVertically(this.h.b)) {
            this.h.b(m, motionEvent.getPointerId(0));
        }
        if (this.h.t != null) {
            return true;
        }
        return false;
    }

    public void setListener(Listener listener) {
        synchronized (this) {
            this.j = listener;
        }
    }

    public void setMinFlingVelocity(float f2) {
        this.i = f2;
    }

    public void setPlacement(String str) {
        this.g = str;
    }

    @Keep
    public void setXFraction(float f2) {
        if (getVisibility() == 0 && getHeight() == 0) {
            getViewTreeObserver().addOnPreDrawListener(new b(f2));
            return;
        }
        setTranslationX(f2 * ((float) getWidth()));
    }

    @Keep
    public void setYFraction(float f2) {
        if (getVisibility() == 0 && getHeight() == 0) {
            getViewTreeObserver().addOnPreDrawListener(new a(f2));
            return;
        }
        setTranslationY(f2 * ((float) getHeight()));
    }
}
