package com.mixpanel.android.takeoverinapp;

import android.content.Context;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ImageView;

public class MiniCircleImageView extends ImageView {
    public Paint f;

    public MiniCircleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint(1);
        this.f = paint;
        if (Build.VERSION.SDK_INT >= 23) {
            paint.setColor(getResources().getColor(17170443, null));
        } else {
            paint.setColor(getResources().getColor(17170443));
        }
        this.f.setStyle(Paint.Style.STROKE);
        this.f.setStrokeWidth(TypedValue.applyDimension(1, 2.0f, getResources().getDisplayMetrics()));
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }
}
