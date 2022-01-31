package defpackage;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.google.maps.android.R;

/* renamed from: qz4  reason: default package */
/* compiled from: BubbleDrawable */
public class qz4 extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    public final Drawable f3015a;
    public final Drawable b;
    public int c = -1;

    public qz4(Resources resources) {
        this.b = resources.getDrawable(R.drawable.bubble_mask);
        this.f3015a = resources.getDrawable(R.drawable.bubble_shadow);
    }

    public void draw(Canvas canvas) {
        this.b.draw(canvas);
        canvas.drawColor(this.c, PorterDuff.Mode.SRC_IN);
        this.f3015a.draw(canvas);
    }

    public int getOpacity() {
        return -3;
    }

    public boolean getPadding(Rect rect) {
        return this.b.getPadding(rect);
    }

    public void setAlpha(int i) {
        throw new UnsupportedOperationException();
    }

    public void setBounds(int i, int i2, int i3, int i4) {
        this.b.setBounds(i, i2, i3, i4);
        this.f3015a.setBounds(i, i2, i3, i4);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        throw new UnsupportedOperationException();
    }

    public void setBounds(Rect rect) {
        this.b.setBounds(rect);
        this.f3015a.setBounds(rect);
    }
}
