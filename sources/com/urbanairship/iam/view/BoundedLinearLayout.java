package com.urbanairship.iam.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import java.util.Objects;

public class BoundedLinearLayout extends LinearLayout {
    public final zs5 f;
    public final at5 g = new at5();

    public BoundedLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f = new zs5(context, attributeSet, 0, 0);
    }

    public void onMeasure(int i, int i2) {
        zs5 zs5 = this.f;
        Objects.requireNonNull(zs5);
        int size = View.MeasureSpec.getSize(i);
        int i3 = zs5.f4207a;
        if (i3 > 0 && i3 < size) {
            i = View.MeasureSpec.makeMeasureSpec(i3, View.MeasureSpec.getMode(i));
        }
        zs5 zs52 = this.f;
        Objects.requireNonNull(zs52);
        int size2 = View.MeasureSpec.getSize(i2);
        int i4 = zs52.b;
        if (i4 > 0 && i4 < size2) {
            i2 = View.MeasureSpec.makeMeasureSpec(i4, View.MeasureSpec.getMode(i2));
        }
        super.onMeasure(i, i2);
    }

    public void setClipPathBorderRadius(float f2) {
        this.g.a(this, f2);
    }

    public BoundedLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = new zs5(context, attributeSet, i, 0);
    }
}
