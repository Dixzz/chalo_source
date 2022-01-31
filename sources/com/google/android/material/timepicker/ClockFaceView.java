package com.google.android.material.timepicker;

import android.content.res.ColorStateList;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.SparseArray;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import com.google.android.material.timepicker.ClockHandView;
import defpackage.e9;

public class ClockFaceView extends eq4 implements ClockHandView.c {
    public final Rect A = new Rect();
    public final RectF B = new RectF();
    public final SparseArray<TextView> C;
    public final z7 D;
    public final int[] E;
    public final float[] F;
    public final int G;
    public String[] H;
    public float I;
    public final ColorStateList J;
    public final ClockHandView z;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ClockFaceView(android.content.Context r9, android.util.AttributeSet r10) {
        /*
        // Method dump skipped, instructions count: 286
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.timepicker.ClockFaceView.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    @Override // com.google.android.material.timepicker.ClockHandView.c
    public void a(float f, boolean z2) {
        if (Math.abs(this.I - f) > 0.001f) {
            this.I = f;
            k();
        }
    }

    public final void k() {
        RadialGradient radialGradient;
        RectF rectF = this.z.o;
        for (int i = 0; i < this.C.size(); i++) {
            TextView textView = this.C.get(i);
            if (textView != null) {
                textView.getDrawingRect(this.A);
                this.A.offset(textView.getPaddingLeft(), textView.getPaddingTop());
                offsetDescendantRectToMyCoords(textView, this.A);
                this.B.set(this.A);
                if (!RectF.intersects(rectF, this.B)) {
                    radialGradient = null;
                } else {
                    radialGradient = new RadialGradient(rectF.centerX() - this.B.left, rectF.centerY() - this.B.top, 0.5f * rectF.width(), this.E, this.F, Shader.TileMode.CLAMP);
                }
                textView.getPaint().setShader(radialGradient);
                textView.invalidate();
            }
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) e9.b.a(1, this.H.length, false, 1).f944a);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void onLayout(boolean z2, int i, int i2, int i3, int i4) {
        super.onLayout(z2, i, i2, i3, i4);
        k();
    }
}
