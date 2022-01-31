package app.zophop.utilities.external.loader_view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import app.zophop.utilities.R;

public class LoadingSpinnerView extends View {
    public int f;
    public float g;
    public ud1 h;

    public LoadingSpinnerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.LoadingSpinnerView);
        this.f = obtainStyledAttributes.getColor(R.styleable.LoadingSpinnerView_loaderColor, -1);
        this.g = obtainStyledAttributes.getDimension(R.styleable.LoadingSpinnerView_loaderThickness, -1.0f);
        if (this.f == -1) {
            this.f = getResources().getColor(R.color.loader_color);
        }
        if (this.g == -1.0f) {
            this.g = getResources().getDimension(R.dimen.loader_thickness);
        }
        ud1 ud1 = new ud1(this.f, this.g);
        this.h = ud1;
        ud1.setCallback(this);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.h.draw(canvas);
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.h.setBounds(0, 0, i, i2);
    }

    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            this.h.start();
        } else {
            this.h.stop();
        }
    }

    public boolean verifyDrawable(Drawable drawable) {
        return drawable == this.h || super.verifyDrawable(drawable);
    }
}
