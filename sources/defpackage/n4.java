package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import defpackage.m4;
import java.util.Objects;

/* renamed from: n4  reason: default package */
/* compiled from: Constraints */
public class n4 extends ViewGroup {
    public m4 f;

    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    public m4 getConstraintSet() {
        if (this.f == null) {
            this.f = new m4();
        }
        m4 m4Var = this.f;
        Objects.requireNonNull(m4Var);
        int childCount = getChildCount();
        m4Var.c.clear();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            a aVar = (a) childAt.getLayoutParams();
            int id = childAt.getId();
            if (!m4Var.b || id != -1) {
                if (!m4Var.c.containsKey(Integer.valueOf(id))) {
                    m4Var.c.put(Integer.valueOf(id), new m4.a());
                }
                m4.a aVar2 = m4Var.c.get(Integer.valueOf(id));
                if (childAt instanceof k4) {
                    k4 k4Var = (k4) childAt;
                    aVar2.c(id, aVar);
                    if (k4Var instanceof Barrier) {
                        m4.b bVar = aVar2.d;
                        bVar.d0 = 1;
                        Barrier barrier = (Barrier) k4Var;
                        bVar.b0 = barrier.getType();
                        aVar2.d.e0 = barrier.getReferencedIds();
                        aVar2.d.c0 = barrier.getMargin();
                    }
                }
                aVar2.c(id, aVar);
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
        return this.f;
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ConstraintLayout.a(layoutParams);
    }

    /* renamed from: n4$a */
    /* compiled from: Constraints */
    public static class a extends ConstraintLayout.a {
        public float m0;
        public boolean n0;
        public float o0;
        public float p0;
        public float q0;
        public float r0;
        public float s0;
        public float t0;
        public float u0;
        public float v0;
        public float w0;
        public float x0;
        public float y0;

        public a(int i, int i2) {
            super(i, i2);
            this.m0 = 1.0f;
            this.n0 = false;
            this.o0 = 0.0f;
            this.p0 = 0.0f;
            this.q0 = 0.0f;
            this.r0 = 0.0f;
            this.s0 = 1.0f;
            this.t0 = 1.0f;
            this.u0 = 0.0f;
            this.v0 = 0.0f;
            this.w0 = 0.0f;
            this.x0 = 0.0f;
            this.y0 = 0.0f;
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.m0 = 1.0f;
            this.n0 = false;
            this.o0 = 0.0f;
            this.p0 = 0.0f;
            this.q0 = 0.0f;
            this.r0 = 0.0f;
            this.s0 = 1.0f;
            this.t0 = 1.0f;
            this.u0 = 0.0f;
            this.v0 = 0.0f;
            this.w0 = 0.0f;
            this.x0 = 0.0f;
            this.y0 = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ConstraintSet);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.ConstraintSet_android_alpha) {
                    this.m0 = obtainStyledAttributes.getFloat(index, this.m0);
                } else if (index == R.styleable.ConstraintSet_android_elevation) {
                    this.o0 = obtainStyledAttributes.getFloat(index, this.o0);
                    this.n0 = true;
                } else if (index == R.styleable.ConstraintSet_android_rotationX) {
                    this.q0 = obtainStyledAttributes.getFloat(index, this.q0);
                } else if (index == R.styleable.ConstraintSet_android_rotationY) {
                    this.r0 = obtainStyledAttributes.getFloat(index, this.r0);
                } else if (index == R.styleable.ConstraintSet_android_rotation) {
                    this.p0 = obtainStyledAttributes.getFloat(index, this.p0);
                } else if (index == R.styleable.ConstraintSet_android_scaleX) {
                    this.s0 = obtainStyledAttributes.getFloat(index, this.s0);
                } else if (index == R.styleable.ConstraintSet_android_scaleY) {
                    this.t0 = obtainStyledAttributes.getFloat(index, this.t0);
                } else if (index == R.styleable.ConstraintSet_android_transformPivotX) {
                    this.u0 = obtainStyledAttributes.getFloat(index, this.u0);
                } else if (index == R.styleable.ConstraintSet_android_transformPivotY) {
                    this.v0 = obtainStyledAttributes.getFloat(index, this.v0);
                } else if (index == R.styleable.ConstraintSet_android_translationX) {
                    this.w0 = obtainStyledAttributes.getFloat(index, this.w0);
                } else if (index == R.styleable.ConstraintSet_android_translationY) {
                    this.x0 = obtainStyledAttributes.getFloat(index, this.x0);
                } else if (index == R.styleable.ConstraintSet_android_translationZ) {
                    this.y0 = obtainStyledAttributes.getFloat(index, this.y0);
                }
            }
        }
    }
}
