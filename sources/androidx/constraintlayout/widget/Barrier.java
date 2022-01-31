package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

public class Barrier extends k4 {
    public int l;
    public int m;
    public k3 n;

    public Barrier(Context context) {
        super(context);
        super.setVisibility(8);
    }

    @Override // defpackage.k4
    public void e(AttributeSet attributeSet) {
        super.e(attributeSet);
        this.n = new k3();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.ConstraintLayout_Layout_barrierDirection) {
                    setType(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_barrierAllowsGoneWidgets) {
                    this.n.h0 = obtainStyledAttributes.getBoolean(index, true);
                } else if (index == R.styleable.ConstraintLayout_Layout_barrierMargin) {
                    this.n.i0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                }
            }
        }
        this.i = this.n;
        j();
    }

    @Override // defpackage.k4
    public void f(n3 n3Var, boolean z) {
        int i = this.l;
        this.m = i;
        if (z) {
            if (i == 5) {
                this.m = 1;
            } else if (i == 6) {
                this.m = 0;
            }
        } else if (i == 5) {
            this.m = 0;
        } else if (i == 6) {
            this.m = 1;
        }
        if (n3Var instanceof k3) {
            ((k3) n3Var).g0 = this.m;
        }
    }

    public int getMargin() {
        return this.n.i0;
    }

    public int getType() {
        return this.l;
    }

    public void setAllowsGoneWidget(boolean z) {
        this.n.h0 = z;
    }

    public void setDpMargin(int i) {
        this.n.i0 = (int) ((((float) i) * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void setMargin(int i) {
        this.n.i0 = i;
    }

    public void setType(int i) {
        this.l = i;
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }
}
