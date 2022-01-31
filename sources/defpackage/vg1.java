package defpackage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;

/* renamed from: vg1  reason: default package */
/* compiled from: SlidingTabStrip */
public class vg1 extends LinearLayout {
    public final int f;
    public final Paint g;
    public final int h;
    public final Paint i = new Paint();
    public int j;
    public float k;
    public bg1 l;
    public final b m;

    /* renamed from: vg1$b */
    /* compiled from: SlidingTabStrip */
    public static class b implements bg1 {

        /* renamed from: a  reason: collision with root package name */
        public int[] f3645a;

        public b() {
        }

        public b(a aVar) {
        }
    }

    public vg1(Context context) {
        super(context, null);
        setWillNotDraw(false);
        float f2 = getResources().getDisplayMetrics().density;
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16842800, typedValue, true);
        int i2 = typedValue.data;
        int argb = Color.argb(38, Color.red(i2), Color.green(i2), Color.blue(i2));
        b bVar = new b(null);
        this.m = bVar;
        bVar.f3645a = new int[]{-13388315};
        this.f = (int) (0.0f * f2);
        Paint paint = new Paint();
        this.g = paint;
        paint.setColor(argb);
        this.h = (int) (f2 * 3.0f);
    }

    public void onDraw(Canvas canvas) {
        int height = getHeight();
        int childCount = getChildCount();
        Object obj = this.l;
        if (obj == null) {
            obj = this.m;
        }
        if (childCount > 0) {
            View childAt = getChildAt(this.j);
            int left = childAt.getLeft();
            int right = childAt.getRight();
            int i2 = this.j;
            b bVar = (b) obj;
            int[] iArr = bVar.f3645a;
            int i3 = iArr[i2 % iArr.length];
            if (this.k > 0.0f && i2 < getChildCount() - 1) {
                int[] iArr2 = bVar.f3645a;
                int i4 = iArr2[(this.j + 1) % iArr2.length];
                if (i3 != i4) {
                    float f2 = this.k;
                    float f3 = 1.0f - f2;
                    i3 = Color.rgb((int) ((((float) Color.red(i3)) * f3) + (((float) Color.red(i4)) * f2)), (int) ((((float) Color.green(i3)) * f3) + (((float) Color.green(i4)) * f2)), (int) ((((float) Color.blue(i3)) * f3) + (((float) Color.blue(i4)) * f2)));
                }
                View childAt2 = getChildAt(this.j + 1);
                float left2 = this.k * ((float) childAt2.getLeft());
                float f4 = this.k;
                left = (int) (((1.0f - f4) * ((float) left)) + left2);
                right = (int) (((1.0f - this.k) * ((float) right)) + (f4 * ((float) childAt2.getRight())));
            }
            this.i.setColor(i3);
            canvas.drawRect((float) left, (float) (height - this.h), (float) right, (float) height, this.i);
        }
        canvas.drawRect(0.0f, (float) (height - this.f), (float) getWidth(), (float) height, this.g);
    }

    public void setCustomTabColorizer(bg1 bg1) {
        this.l = bg1;
        invalidate();
    }

    public void setSelectedIndicatorColors(int... iArr) {
        this.l = null;
        this.m.f3645a = iArr;
        invalidate();
    }
}
