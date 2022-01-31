package androidx.constraintlayout.helper.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.R;

public class Flow extends q4 {
    public p3 n;

    public Flow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // defpackage.q4, defpackage.k4
    public void e(AttributeSet attributeSet) {
        super.e(attributeSet);
        this.n = new p3();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.ConstraintLayout_Layout_android_orientation) {
                    this.n.J0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_padding) {
                    p3 p3Var = this.n;
                    int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                    p3Var.g0 = dimensionPixelSize;
                    p3Var.h0 = dimensionPixelSize;
                    p3Var.i0 = dimensionPixelSize;
                    p3Var.j0 = dimensionPixelSize;
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingStart) {
                    p3 p3Var2 = this.n;
                    int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                    p3Var2.i0 = dimensionPixelSize2;
                    p3Var2.k0 = dimensionPixelSize2;
                    p3Var2.l0 = dimensionPixelSize2;
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingEnd) {
                    this.n.j0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingLeft) {
                    this.n.k0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingTop) {
                    this.n.g0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingRight) {
                    this.n.l0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingBottom) {
                    this.n.h0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_wrapMode) {
                    this.n.H0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_horizontalStyle) {
                    this.n.r0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_verticalStyle) {
                    this.n.s0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_firstHorizontalStyle) {
                    this.n.t0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_lastHorizontalStyle) {
                    this.n.v0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_firstVerticalStyle) {
                    this.n.u0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_lastVerticalStyle) {
                    this.n.w0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_horizontalBias) {
                    this.n.x0 = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_firstHorizontalBias) {
                    this.n.z0 = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_lastHorizontalBias) {
                    this.n.B0 = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_firstVerticalBias) {
                    this.n.A0 = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_lastVerticalBias) {
                    this.n.C0 = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_verticalBias) {
                    this.n.y0 = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_horizontalAlign) {
                    this.n.F0 = obtainStyledAttributes.getInt(index, 2);
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_verticalAlign) {
                    this.n.G0 = obtainStyledAttributes.getInt(index, 2);
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_horizontalGap) {
                    this.n.D0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_verticalGap) {
                    this.n.E0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_maxElementsWrap) {
                    this.n.I0 = obtainStyledAttributes.getInt(index, -1);
                }
            }
        }
        this.i = this.n;
        j();
    }

    @Override // defpackage.k4
    public void f(n3 n3Var, boolean z) {
        p3 p3Var = this.n;
        int i = p3Var.i0;
        if (i <= 0 && p3Var.j0 <= 0) {
            return;
        }
        if (z) {
            p3Var.k0 = p3Var.j0;
            p3Var.l0 = i;
            return;
        }
        p3Var.k0 = i;
        p3Var.l0 = p3Var.j0;
    }

    @Override // defpackage.q4
    public void k(u3 u3Var, int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (u3Var != null) {
            u3Var.J(mode, size, mode2, size2);
            setMeasuredDimension(u3Var.n0, u3Var.o0);
            return;
        }
        setMeasuredDimension(0, 0);
    }

    @Override // defpackage.k4
    @SuppressLint({"WrongCall"})
    public void onMeasure(int i, int i2) {
        k(this.n, i, i2);
    }

    public void setFirstHorizontalBias(float f) {
        this.n.z0 = f;
        requestLayout();
    }

    public void setFirstHorizontalStyle(int i) {
        this.n.t0 = i;
        requestLayout();
    }

    public void setFirstVerticalBias(float f) {
        this.n.A0 = f;
        requestLayout();
    }

    public void setFirstVerticalStyle(int i) {
        this.n.u0 = i;
        requestLayout();
    }

    public void setHorizontalAlign(int i) {
        this.n.F0 = i;
        requestLayout();
    }

    public void setHorizontalBias(float f) {
        this.n.x0 = f;
        requestLayout();
    }

    public void setHorizontalGap(int i) {
        this.n.D0 = i;
        requestLayout();
    }

    public void setHorizontalStyle(int i) {
        this.n.r0 = i;
        requestLayout();
    }

    public void setMaxElementsWrap(int i) {
        this.n.I0 = i;
        requestLayout();
    }

    public void setOrientation(int i) {
        this.n.J0 = i;
        requestLayout();
    }

    public void setPadding(int i) {
        p3 p3Var = this.n;
        p3Var.g0 = i;
        p3Var.h0 = i;
        p3Var.i0 = i;
        p3Var.j0 = i;
        requestLayout();
    }

    public void setPaddingBottom(int i) {
        this.n.h0 = i;
        requestLayout();
    }

    public void setPaddingLeft(int i) {
        this.n.k0 = i;
        requestLayout();
    }

    public void setPaddingRight(int i) {
        this.n.l0 = i;
        requestLayout();
    }

    public void setPaddingTop(int i) {
        this.n.g0 = i;
        requestLayout();
    }

    public void setVerticalAlign(int i) {
        this.n.G0 = i;
        requestLayout();
    }

    public void setVerticalBias(float f) {
        this.n.y0 = f;
        requestLayout();
    }

    public void setVerticalGap(int i) {
        this.n.E0 = i;
        requestLayout();
    }

    public void setVerticalStyle(int i) {
        this.n.s0 = i;
        requestLayout();
    }

    public void setWrapMode(int i) {
        this.n.H0 = i;
        requestLayout();
    }
}
