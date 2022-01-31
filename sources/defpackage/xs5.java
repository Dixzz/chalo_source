package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.TypedValue;

/* renamed from: xs5  reason: default package */
/* compiled from: BackgroundDrawableBuilder */
public class xs5 {

    /* renamed from: a  reason: collision with root package name */
    public int f3960a = 0;
    public Integer b;
    public Integer c;
    public int d = 0;
    public float e = 0.0f;
    public int f;
    public final Context g;

    public xs5(Context context) {
        this.g = context;
    }

    public Drawable a() {
        int round = Math.round(TypedValue.applyDimension(1, (float) this.d, this.g.getResources().getDisplayMetrics()));
        Integer num = this.b;
        int intValue = num == null ? this.f3960a : num.intValue();
        float applyDimension = TypedValue.applyDimension(1, this.e, this.g.getResources().getDisplayMetrics());
        int i = this.f;
        float[] fArr = new float[8];
        if ((i & 1) == 1) {
            fArr[0] = applyDimension;
            fArr[1] = applyDimension;
        }
        if ((i & 2) == 2) {
            fArr[2] = applyDimension;
            fArr[3] = applyDimension;
        }
        if ((i & 4) == 4) {
            fArr[4] = applyDimension;
            fArr[5] = applyDimension;
        }
        if ((i & 8) == 8) {
            fArr[6] = applyDimension;
            fArr[7] = applyDimension;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadii(fArr);
        gradientDrawable.setColor(this.f3960a);
        gradientDrawable.setStroke(round, intValue);
        Integer num2 = this.c;
        if (num2 == null) {
            return gradientDrawable;
        }
        return new RippleDrawable(ColorStateList.valueOf(num2.intValue()), gradientDrawable, new ShapeDrawable(new RoundRectShape(fArr, null, null)));
    }
}
