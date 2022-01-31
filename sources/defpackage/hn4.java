package defpackage;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.google.android.material.R;

/* renamed from: hn4  reason: default package */
/* compiled from: ForegroundLinearLayout */
public class hn4 extends LinearLayoutCompat {
    public Drawable f;
    public final Rect g;
    public final Rect h;
    public int i;
    public boolean j;
    public boolean k;

    public hn4(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.f;
        if (drawable != null) {
            if (this.k) {
                this.k = false;
                Rect rect = this.g;
                Rect rect2 = this.h;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.j) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.i, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @TargetApi(21)
    public void drawableHotspotChanged(float f2, float f3) {
        super.drawableHotspotChanged(f2, f3);
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.setHotspot(f2, f3);
        }
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f;
        if (drawable != null && drawable.isStateful()) {
            this.f.setState(getDrawableState());
        }
    }

    public Drawable getForeground() {
        return this.f;
    }

    public int getForegroundGravity() {
        return this.i;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.k = z | this.k;
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.k = true;
    }

    public void setForeground(Drawable drawable) {
        Drawable drawable2 = this.f;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.f);
            }
            this.f = drawable;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.i == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    public void setForegroundGravity(int i2) {
        if (this.i != i2) {
            if ((8388615 & i2) == 0) {
                i2 |= 8388611;
            }
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.i = i2;
            if (i2 == 119 && this.f != null) {
                this.f.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f;
    }

    public hn4(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.g = new Rect();
        this.h = new Rect();
        this.i = 119;
        this.j = true;
        this.k = false;
        int[] iArr = R.styleable.ForegroundLinearLayout;
        mn4.a(context, attributeSet, i2, 0);
        mn4.b(context, attributeSet, iArr, i2, 0, new int[0]);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i2, 0);
        this.i = obtainStyledAttributes.getInt(R.styleable.ForegroundLinearLayout_android_foregroundGravity, this.i);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.ForegroundLinearLayout_android_foreground);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.j = obtainStyledAttributes.getBoolean(R.styleable.ForegroundLinearLayout_foregroundInsidePadding, true);
        obtainStyledAttributes.recycle();
    }
}
