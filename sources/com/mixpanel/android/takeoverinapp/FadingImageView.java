package com.mixpanel.android.takeoverinapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

public class FadingImageView extends ImageView {
    public Matrix f = new Matrix();
    public Paint g = new Paint();
    public Shader h;
    public Paint i;
    public Shader j;
    public int k;
    public int l;
    public boolean m;

    public FadingImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, 0.0f, 1.0f, new int[]{-16777216, -16777216, -452984832, 0}, new float[]{0.0f, 0.2f, 0.4f, 1.0f}, Shader.TileMode.CLAMP);
        this.h = linearGradient;
        this.g.setShader(linearGradient);
        this.g.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.i = new Paint();
        LinearGradient linearGradient2 = new LinearGradient(0.0f, 0.0f, 0.0f, 1.0f, new int[]{0, 0, -16777216, -16777216}, new float[]{0.0f, 0.85f, 0.98f, 1.0f}, Shader.TileMode.CLAMP);
        this.j = linearGradient2;
        this.i.setShader(linearGradient2);
        this.g.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    public void draw(Canvas canvas) {
        int i2;
        if (this.m) {
            Rect clipBounds = canvas.getClipBounds();
            if (Build.VERSION.SDK_INT >= 26) {
                i2 = canvas.saveLayer(0.0f, 0.0f, (float) clipBounds.width(), (float) clipBounds.height(), null);
            } else {
                i2 = canvas.saveLayer(0.0f, 0.0f, (float) clipBounds.width(), (float) clipBounds.height(), null, 31);
            }
            super.draw(canvas);
            canvas.drawRect(0.0f, 0.0f, (float) this.l, (float) this.k, this.g);
            canvas.restoreToCount(i2);
            return;
        }
        super.draw(canvas);
    }

    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.m) {
            this.k = getMeasuredHeight();
            this.l = getMeasuredWidth();
            this.f.setScale(1.0f, (float) View.MeasureSpec.getSize(i3));
            this.h.setLocalMatrix(this.f);
            this.j.setLocalMatrix(this.f);
        }
    }
}
