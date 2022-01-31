package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.perf.util.Constants;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: kk  reason: default package */
/* compiled from: FastScroller */
public class kk extends RecyclerView.l implements RecyclerView.q {
    public static final int[] D = {16842919};
    public static final int[] E = new int[0];
    public int A;
    public final Runnable B;
    public final RecyclerView.r C;

    /* renamed from: a  reason: collision with root package name */
    public final int f2069a;
    public final int b;
    public final StateListDrawable c;
    public final Drawable d;
    public final int e;
    public final int f;
    public final StateListDrawable g;
    public final Drawable h;
    public final int i;
    public final int j;
    public int k;
    public int l;
    public float m;
    public int n;
    public int o;
    public float p;
    public int q = 0;
    public int r = 0;
    public RecyclerView s;
    public boolean t = false;
    public boolean u = false;
    public int v = 0;
    public int w = 0;
    public final int[] x = new int[2];
    public final int[] y = new int[2];
    public final ValueAnimator z;

    /* renamed from: kk$a */
    /* compiled from: FastScroller */
    public class a implements Runnable {
        public a() {
        }

        public void run() {
            kk kkVar = kk.this;
            int i = kkVar.A;
            if (i == 1) {
                kkVar.z.cancel();
            } else if (i != 2) {
                return;
            }
            kkVar.A = 3;
            ValueAnimator valueAnimator = kkVar.z;
            valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
            kkVar.z.setDuration((long) 500);
            kkVar.z.start();
        }
    }

    /* renamed from: kk$b */
    /* compiled from: FastScroller */
    public class b extends RecyclerView.r {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            kk kkVar = kk.this;
            int computeHorizontalScrollOffset = recyclerView.computeHorizontalScrollOffset();
            int computeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
            int computeVerticalScrollRange = kkVar.s.computeVerticalScrollRange();
            int i3 = kkVar.r;
            kkVar.t = computeVerticalScrollRange - i3 > 0 && i3 >= kkVar.f2069a;
            int computeHorizontalScrollRange = kkVar.s.computeHorizontalScrollRange();
            int i4 = kkVar.q;
            boolean z = computeHorizontalScrollRange - i4 > 0 && i4 >= kkVar.f2069a;
            kkVar.u = z;
            boolean z2 = kkVar.t;
            if (z2 || z) {
                if (z2) {
                    float f = (float) i3;
                    kkVar.l = (int) ((((f / 2.0f) + ((float) computeVerticalScrollOffset)) * f) / ((float) computeVerticalScrollRange));
                    kkVar.k = Math.min(i3, (i3 * i3) / computeVerticalScrollRange);
                }
                if (kkVar.u) {
                    float f2 = (float) computeHorizontalScrollOffset;
                    float f3 = (float) i4;
                    kkVar.o = (int) ((((f3 / 2.0f) + f2) * f3) / ((float) computeHorizontalScrollRange));
                    kkVar.n = Math.min(i4, (i4 * i4) / computeHorizontalScrollRange);
                }
                int i5 = kkVar.v;
                if (i5 == 0 || i5 == 1) {
                    kkVar.h(1);
                }
            } else if (kkVar.v != 0) {
                kkVar.h(0);
            }
        }
    }

    /* renamed from: kk$c */
    /* compiled from: FastScroller */
    public class c extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public boolean f2071a = false;

        public c() {
        }

        public void onAnimationCancel(Animator animator) {
            this.f2071a = true;
        }

        public void onAnimationEnd(Animator animator) {
            if (this.f2071a) {
                this.f2071a = false;
            } else if (((Float) kk.this.z.getAnimatedValue()).floatValue() == 0.0f) {
                kk kkVar = kk.this;
                kkVar.A = 0;
                kkVar.h(0);
            } else {
                kk kkVar2 = kk.this;
                kkVar2.A = 2;
                kkVar2.s.invalidate();
            }
        }
    }

    /* renamed from: kk$d */
    /* compiled from: FastScroller */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            kk.this.c.setAlpha(floatValue);
            kk.this.d.setAlpha(floatValue);
            kk.this.s.invalidate();
        }
    }

    public kk(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i2, int i3, int i4) {
        boolean z2 = false;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.z = ofFloat;
        this.A = 0;
        this.B = new a();
        b bVar = new b();
        this.C = bVar;
        this.c = stateListDrawable;
        this.d = drawable;
        this.g = stateListDrawable2;
        this.h = drawable2;
        this.e = Math.max(i2, stateListDrawable.getIntrinsicWidth());
        this.f = Math.max(i2, drawable.getIntrinsicWidth());
        this.i = Math.max(i2, stateListDrawable2.getIntrinsicWidth());
        this.j = Math.max(i2, drawable2.getIntrinsicWidth());
        this.f2069a = i3;
        this.b = i4;
        stateListDrawable.setAlpha(Constants.MAX_HOST_LENGTH);
        drawable.setAlpha(Constants.MAX_HOST_LENGTH);
        ofFloat.addListener(new c());
        ofFloat.addUpdateListener(new d());
        RecyclerView recyclerView2 = this.s;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                RecyclerView.m mVar = recyclerView2.r;
                if (mVar != null) {
                    mVar.n("Cannot remove item decoration during a scroll  or layout");
                }
                recyclerView2.u.remove(this);
                if (recyclerView2.u.isEmpty()) {
                    recyclerView2.setWillNotDraw(recyclerView2.getOverScrollMode() == 2 ? true : z2);
                }
                recyclerView2.Q();
                recyclerView2.requestLayout();
                RecyclerView recyclerView3 = this.s;
                recyclerView3.v.remove(this);
                if (recyclerView3.w == this) {
                    recyclerView3.w = null;
                }
                List<RecyclerView.r> list = this.s.p0;
                if (list != null) {
                    list.remove(bVar);
                }
                d();
            }
            this.s = recyclerView;
            recyclerView.f(this);
            this.s.v.add(this);
            this.s.g(bVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void a(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.v != 0) {
            if (motionEvent.getAction() == 0) {
                boolean f2 = f(motionEvent.getX(), motionEvent.getY());
                boolean e2 = e(motionEvent.getX(), motionEvent.getY());
                if (f2 || e2) {
                    if (e2) {
                        this.w = 1;
                        this.p = (float) ((int) motionEvent.getX());
                    } else if (f2) {
                        this.w = 2;
                        this.m = (float) ((int) motionEvent.getY());
                    }
                    h(2);
                }
            } else if (motionEvent.getAction() == 1 && this.v == 2) {
                this.m = 0.0f;
                this.p = 0.0f;
                h(1);
                this.w = 0;
            } else if (motionEvent.getAction() == 2 && this.v == 2) {
                i();
                if (this.w == 1) {
                    float x2 = motionEvent.getX();
                    int[] iArr = this.y;
                    int i2 = this.b;
                    iArr[0] = i2;
                    iArr[1] = this.q - i2;
                    float max = Math.max((float) iArr[0], Math.min((float) iArr[1], x2));
                    if (Math.abs(((float) this.o) - max) >= 2.0f) {
                        int g2 = g(this.p, max, iArr, this.s.computeHorizontalScrollRange(), this.s.computeHorizontalScrollOffset(), this.q);
                        if (g2 != 0) {
                            this.s.scrollBy(g2, 0);
                        }
                        this.p = max;
                    }
                }
                if (this.w == 2) {
                    float y2 = motionEvent.getY();
                    int[] iArr2 = this.x;
                    int i3 = this.b;
                    iArr2[0] = i3;
                    iArr2[1] = this.r - i3;
                    float max2 = Math.max((float) iArr2[0], Math.min((float) iArr2[1], y2));
                    if (Math.abs(((float) this.l) - max2) >= 2.0f) {
                        int g3 = g(this.m, max2, iArr2, this.s.computeVerticalScrollRange(), this.s.computeVerticalScrollOffset(), this.r);
                        if (g3 != 0) {
                            this.s.scrollBy(0, g3);
                        }
                        this.m = max2;
                    }
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public boolean b(RecyclerView recyclerView, MotionEvent motionEvent) {
        int i2 = this.v;
        if (i2 == 1) {
            boolean f2 = f(motionEvent.getX(), motionEvent.getY());
            boolean e2 = e(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() == 0 && (f2 || e2)) {
                if (e2) {
                    this.w = 1;
                    this.p = (float) ((int) motionEvent.getX());
                } else if (f2) {
                    this.w = 2;
                    this.m = (float) ((int) motionEvent.getY());
                }
                h(2);
                return true;
            }
        } else if (i2 == 2) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void c(boolean z2) {
    }

    public final void d() {
        this.s.removeCallbacks(this.B);
    }

    public boolean e(float f2, float f3) {
        if (f3 >= ((float) (this.r - this.i))) {
            int i2 = this.o;
            int i3 = this.n;
            return f2 >= ((float) (i2 - (i3 / 2))) && f2 <= ((float) ((i3 / 2) + i2));
        }
    }

    public boolean f(float f2, float f3) {
        RecyclerView recyclerView = this.s;
        AtomicInteger atomicInteger = r8.f3055a;
        if (recyclerView.getLayoutDirection() == 1) {
            if (f2 > ((float) this.e)) {
                return false;
            }
        } else if (f2 < ((float) (this.q - this.e))) {
            return false;
        }
        int i2 = this.l;
        int i3 = this.k / 2;
        if (f3 < ((float) (i2 - i3)) || f3 > ((float) (i3 + i2))) {
            return false;
        }
        return true;
    }

    public final int g(float f2, float f3, int[] iArr, int i2, int i3, int i4) {
        int i5 = iArr[1] - iArr[0];
        if (i5 == 0) {
            return 0;
        }
        int i6 = i2 - i4;
        int i7 = (int) (((f3 - f2) / ((float) i5)) * ((float) i6));
        int i8 = i3 + i7;
        if (i8 >= i6 || i8 < 0) {
            return 0;
        }
        return i7;
    }

    public void h(int i2) {
        if (i2 == 2 && this.v != 2) {
            this.c.setState(D);
            d();
        }
        if (i2 == 0) {
            this.s.invalidate();
        } else {
            i();
        }
        if (this.v == 2 && i2 != 2) {
            this.c.setState(E);
            d();
            this.s.postDelayed(this.B, (long) 1200);
        } else if (i2 == 1) {
            d();
            this.s.postDelayed(this.B, (long) 1500);
        }
        this.v = i2;
    }

    public void i() {
        int i2 = this.A;
        if (i2 != 0) {
            if (i2 == 3) {
                this.z.cancel();
            } else {
                return;
            }
        }
        this.A = 1;
        ValueAnimator valueAnimator = this.z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        this.z.setDuration(500L);
        this.z.setStartDelay(0);
        this.z.start();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.x xVar) {
        if (this.q != this.s.getWidth() || this.r != this.s.getHeight()) {
            this.q = this.s.getWidth();
            this.r = this.s.getHeight();
            h(0);
        } else if (this.A != 0) {
            if (this.t) {
                int i2 = this.q;
                int i3 = this.e;
                int i4 = i2 - i3;
                int i5 = this.l;
                int i6 = this.k;
                int i7 = i5 - (i6 / 2);
                this.c.setBounds(0, 0, i3, i6);
                this.d.setBounds(0, 0, this.f, this.r);
                RecyclerView recyclerView2 = this.s;
                AtomicInteger atomicInteger = r8.f3055a;
                boolean z2 = true;
                if (recyclerView2.getLayoutDirection() != 1) {
                    z2 = false;
                }
                if (z2) {
                    this.d.draw(canvas);
                    canvas.translate((float) this.e, (float) i7);
                    canvas.scale(-1.0f, 1.0f);
                    this.c.draw(canvas);
                    canvas.scale(-1.0f, 1.0f);
                    canvas.translate((float) (-this.e), (float) (-i7));
                } else {
                    canvas.translate((float) i4, 0.0f);
                    this.d.draw(canvas);
                    canvas.translate(0.0f, (float) i7);
                    this.c.draw(canvas);
                    canvas.translate((float) (-i4), (float) (-i7));
                }
            }
            if (this.u) {
                int i8 = this.r;
                int i9 = this.i;
                int i10 = i8 - i9;
                int i11 = this.o;
                int i12 = this.n;
                int i13 = i11 - (i12 / 2);
                this.g.setBounds(0, 0, i12, i9);
                this.h.setBounds(0, 0, this.q, this.j);
                canvas.translate(0.0f, (float) i10);
                this.h.draw(canvas);
                canvas.translate((float) i13, 0.0f);
                this.g.draw(canvas);
                canvas.translate((float) (-i13), (float) (-i10));
            }
        }
    }
}
