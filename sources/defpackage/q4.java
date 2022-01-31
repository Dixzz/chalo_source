package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;

/* renamed from: q4  reason: default package */
/* compiled from: VirtualLayout */
public abstract class q4 extends k4 {
    public boolean l;
    public boolean m;

    public q4(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // defpackage.k4
    public void e(AttributeSet attributeSet) {
        super.e(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.ConstraintLayout_Layout_android_visibility) {
                    this.l = true;
                } else if (index == R.styleable.ConstraintLayout_Layout_android_elevation) {
                    this.m = true;
                }
            }
        }
    }

    public void k(u3 u3Var, int i, int i2) {
    }

    @Override // defpackage.k4
    public void onAttachedToWindow() {
        ViewParent parent;
        super.onAttachedToWindow();
        if ((this.l || this.m) && (parent = getParent()) != null && (parent instanceof ConstraintLayout)) {
            ConstraintLayout constraintLayout = (ConstraintLayout) parent;
            int visibility = getVisibility();
            float elevation = getElevation();
            for (int i = 0; i < this.g; i++) {
                View d = constraintLayout.d(this.f[i]);
                if (d != null) {
                    if (this.l) {
                        d.setVisibility(visibility);
                    }
                    if (this.m && elevation > 0.0f) {
                        d.setTranslationZ(d.getTranslationZ() + elevation);
                    }
                }
            }
        }
    }

    public void setElevation(float f) {
        super.setElevation(f);
        c();
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        c();
    }
}
