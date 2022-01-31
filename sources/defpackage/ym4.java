package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: ym4  reason: default package */
/* compiled from: FloatingActionButtonImpl */
public class ym4 {
    public static final int[] A = {16842919, 16842910};
    public static final int[] B = {16843623, 16842908, 16842910};
    public static final int[] C = {16842908, 16842910};
    public static final int[] D = {16843623, 16842910};
    public static final int[] E = {16842910};
    public static final int[] F = new int[0];
    public static final TimeInterpolator z = zj4.c;

    /* renamed from: a  reason: collision with root package name */
    public ko4 f4068a;
    public boolean b;
    public boolean c = true;
    public float d;
    public float e;
    public float f;
    public final in4 g;
    public fk4 h;
    public fk4 i;
    public Animator j;
    public fk4 k;
    public fk4 l;
    public float m;
    public float n = 1.0f;
    public int o = 0;
    public ArrayList<Animator.AnimatorListener> p;
    public ArrayList<Animator.AnimatorListener> q;
    public ArrayList<e> r;
    public final FloatingActionButton s;
    public final ao4 t;
    public final Rect u = new Rect();
    public final RectF v = new RectF();
    public final RectF w = new RectF();
    public final Matrix x = new Matrix();
    public ViewTreeObserver.OnPreDrawListener y;

    /* renamed from: ym4$a */
    /* compiled from: FloatingActionButtonImpl */
    public class a extends ek4 {
        public a() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [float, java.lang.Object, java.lang.Object] */
        @Override // android.animation.TypeEvaluator
        public Matrix evaluate(float f, Matrix matrix, Matrix matrix2) {
            ym4.this.n = f;
            matrix.getValues(this.f984a);
            matrix2.getValues(this.b);
            for (int i = 0; i < 9; i++) {
                float[] fArr = this.b;
                float f2 = fArr[i];
                float[] fArr2 = this.f984a;
                fArr[i] = ((f2 - fArr2[i]) * f) + fArr2[i];
            }
            this.c.setValues(this.b);
            return this.c;
        }
    }

    /* renamed from: ym4$b */
    /* compiled from: FloatingActionButtonImpl */
    public class b extends h {
        public b(ym4 ym4) {
            super(null);
        }

        @Override // defpackage.ym4.h
        public float a() {
            return 0.0f;
        }
    }

    /* renamed from: ym4$c */
    /* compiled from: FloatingActionButtonImpl */
    public class c extends h {
        public c() {
            super(null);
        }

        @Override // defpackage.ym4.h
        public float a() {
            ym4 ym4 = ym4.this;
            return ym4.d + ym4.e;
        }
    }

    /* renamed from: ym4$d */
    /* compiled from: FloatingActionButtonImpl */
    public class d extends h {
        public d() {
            super(null);
        }

        @Override // defpackage.ym4.h
        public float a() {
            ym4 ym4 = ym4.this;
            return ym4.d + ym4.f;
        }
    }

    /* renamed from: ym4$e */
    /* compiled from: FloatingActionButtonImpl */
    public interface e {
        void a();

        void b();
    }

    /* renamed from: ym4$f */
    /* compiled from: FloatingActionButtonImpl */
    public interface f {
    }

    /* renamed from: ym4$g */
    /* compiled from: FloatingActionButtonImpl */
    public class g extends h {
        public g() {
            super(null);
        }

        @Override // defpackage.ym4.h
        public float a() {
            return ym4.this.d;
        }
    }

    /* renamed from: ym4$h */
    /* compiled from: FloatingActionButtonImpl */
    public abstract class h extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        public boolean f4069a;
        public float b;

        public h(wm4 wm4) {
        }

        public abstract float a();

        public void onAnimationEnd(Animator animator) {
            Objects.requireNonNull(ym4.this);
            this.f4069a = false;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!this.f4069a) {
                Objects.requireNonNull(ym4.this);
                this.b = a();
                this.f4069a = true;
            }
            ym4 ym4 = ym4.this;
            valueAnimator.getAnimatedFraction();
            Objects.requireNonNull(ym4);
        }
    }

    public ym4(FloatingActionButton floatingActionButton, ao4 ao4) {
        this.s = floatingActionButton;
        this.t = ao4;
        in4 in4 = new in4();
        this.g = in4;
        in4.a(A, b(new d()));
        in4.a(B, b(new c()));
        in4.a(C, b(new c()));
        in4.a(D, b(new c()));
        in4.a(E, b(new g()));
        in4.a(F, b(new b(this)));
        this.m = floatingActionButton.getRotation();
    }

    public final AnimatorSet a(fk4 fk4, float f2, float f3, float f4) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.s, View.ALPHA, f2);
        fk4.d("opacity").a(ofFloat);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.s, View.SCALE_X, f3);
        fk4.d("scale").a(ofFloat2);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 == 26) {
            ofFloat2.setEvaluator(new zm4(this));
        }
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.s, View.SCALE_Y, f3);
        fk4.d("scale").a(ofFloat3);
        if (i2 == 26) {
            ofFloat3.setEvaluator(new zm4(this));
        }
        arrayList.add(ofFloat3);
        this.x.reset();
        this.s.getDrawable();
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.s, new dk4(), new a(), new Matrix(this.x));
        fk4.d("iconScale").a(ofObject);
        arrayList.add(ofObject);
        AnimatorSet animatorSet = new AnimatorSet();
        hd3.v2(animatorSet, arrayList);
        return animatorSet;
    }

    public final ValueAnimator b(h hVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(z);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(hVar);
        valueAnimator.addUpdateListener(hVar);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }

    public float c() {
        throw null;
    }

    public void d(Rect rect) {
        int i2 = 0;
        if (this.b) {
            i2 = (0 - this.s.getSizeDimension()) / 2;
        }
        float c2 = this.c ? c() + this.f : 0.0f;
        int max = Math.max(i2, (int) Math.ceil((double) c2));
        int max2 = Math.max(i2, (int) Math.ceil((double) (c2 * 1.5f)));
        rect.set(max, max2, max, max2);
    }

    public boolean e() {
        if (this.s.getVisibility() == 0) {
            if (this.o == 1) {
                return true;
            }
            return false;
        } else if (this.o != 2) {
            return true;
        } else {
            return false;
        }
    }

    public boolean f() {
        if (this.s.getVisibility() != 0) {
            if (this.o == 2) {
                return true;
            }
            return false;
        } else if (this.o != 1) {
            return true;
        } else {
            return false;
        }
    }

    public void g() {
        throw null;
    }

    public void h() {
        throw null;
    }

    public void i(int[] iArr) {
        throw null;
    }

    public void j(float f2, float f3, float f4) {
        throw null;
    }

    public void k() {
        ArrayList<e> arrayList = this.r;
        if (arrayList != null) {
            Iterator<e> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }
    }

    public void l() {
        ArrayList<e> arrayList = this.r;
        if (arrayList != null) {
            Iterator<e> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    public boolean m() {
        throw null;
    }

    public final void n(float f2) {
        this.n = f2;
        Matrix matrix = this.x;
        matrix.reset();
        this.s.getDrawable();
        this.s.setImageMatrix(matrix);
    }

    public void o(ColorStateList colorStateList) {
        throw null;
    }

    public boolean p() {
        throw null;
    }

    public final boolean q() {
        FloatingActionButton floatingActionButton = this.s;
        AtomicInteger atomicInteger = r8.f3055a;
        return floatingActionButton.isLaidOut() && !this.s.isInEditMode();
    }

    public final boolean r() {
        return !this.b || this.s.getSizeDimension() >= 0;
    }

    public void s() {
        throw null;
    }

    public final void t() {
        Rect rect = this.u;
        d(rect);
        h.o(null, "Didn't initialize content background");
        if (p()) {
            InsetDrawable insetDrawable = new InsetDrawable((Drawable) null, rect.left, rect.top, rect.right, rect.bottom);
            FloatingActionButton.b bVar = (FloatingActionButton.b) this.t;
            Objects.requireNonNull(bVar);
            ym4.super.setBackgroundDrawable(insetDrawable);
        } else {
            Objects.requireNonNull((FloatingActionButton.b) this.t);
        }
        ao4 ao4 = this.t;
        int i2 = rect.left;
        Objects.requireNonNull(FloatingActionButton.this);
        throw null;
    }
}
