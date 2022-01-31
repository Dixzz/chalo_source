package app.zophop.ui.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

public class ResizableImageView extends ImageView {
    public ResizableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onMeasure(int i, int i2) {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            try {
                int size = View.MeasureSpec.getSize(i);
                setMeasuredDimension(size, (int) Math.ceil((double) ((((float) size) * ((float) drawable.getIntrinsicHeight())) / ((float) drawable.getIntrinsicWidth()))));
            } catch (Exception unused) {
                super.onMeasure(i, i2);
            }
        } else {
            super.onMeasure(i, i2);
        }
    }
}
