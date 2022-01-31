package com.freshchat.consumer.sdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;
import androidx.appcompat.widget.RtlSpacingHelper;

public class NonScrollableGridView extends GridView {
    public NonScrollableGridView(Context context) {
        super(context);
    }

    public NonScrollableGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NonScrollableGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, RtlSpacingHelper.UNDEFINED));
        getLayoutParams().height = getMeasuredHeight();
    }
}
