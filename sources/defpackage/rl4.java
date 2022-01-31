package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.widget.TextView;
import com.google.android.material.R;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: rl4  reason: default package */
/* compiled from: CalendarItemStyle */
public final class rl4 {

    /* renamed from: a  reason: collision with root package name */
    public final Rect f3095a;
    public final ColorStateList b;
    public final ColorStateList c;
    public final ColorStateList d;
    public final int e;
    public final ko4 f;

    public rl4(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i, ko4 ko4, Rect rect) {
        h.n(rect.left);
        h.n(rect.top);
        h.n(rect.right);
        h.n(rect.bottom);
        this.f3095a = rect;
        this.b = colorStateList2;
        this.c = colorStateList;
        this.d = colorStateList3;
        this.e = i;
        this.f = ko4;
    }

    public static rl4 a(Context context, int i) {
        h.m(i != 0, "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, R.styleable.MaterialCalendarItem);
        Rect rect = new Rect(obtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetLeft, 0), obtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetTop, 0), obtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetRight, 0), obtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetBottom, 0));
        ColorStateList h1 = hd3.h1(context, obtainStyledAttributes, R.styleable.MaterialCalendarItem_itemFillColor);
        ColorStateList h12 = hd3.h1(context, obtainStyledAttributes, R.styleable.MaterialCalendarItem_itemTextColor);
        ColorStateList h13 = hd3.h1(context, obtainStyledAttributes, R.styleable.MaterialCalendarItem_itemStrokeColor);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MaterialCalendarItem_itemStrokeWidth, 0);
        ko4 a2 = ko4.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendarItem_itemShapeAppearance, 0), obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendarItem_itemShapeAppearanceOverlay, 0), new bo4((float) 0)).a();
        obtainStyledAttributes.recycle();
        return new rl4(h1, h12, h13, dimensionPixelSize, a2, rect);
    }

    public void b(TextView textView) {
        ho4 ho4 = new ho4();
        ho4 ho42 = new ho4();
        ho4.setShapeAppearanceModel(this.f);
        ho42.setShapeAppearanceModel(this.f);
        ho4.q(this.c);
        ho4.u((float) this.e, this.d);
        textView.setTextColor(this.b);
        RippleDrawable rippleDrawable = new RippleDrawable(this.b.withAlpha(30), ho4, ho42);
        Rect rect = this.f3095a;
        InsetDrawable insetDrawable = new InsetDrawable((Drawable) rippleDrawable, rect.left, rect.top, rect.right, rect.bottom);
        AtomicInteger atomicInteger = r8.f3055a;
        textView.setBackground(insetDrawable);
    }
}
