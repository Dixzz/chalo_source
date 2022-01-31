package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import com.google.android.material.R;

/* renamed from: sl4  reason: default package */
/* compiled from: CalendarStyle */
public final class sl4 {

    /* renamed from: a  reason: collision with root package name */
    public final rl4 f3224a;
    public final rl4 b;
    public final rl4 c;
    public final rl4 d;
    public final rl4 e;
    public final rl4 f;
    public final rl4 g;
    public final Paint h;

    public sl4(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(hd3.G2(context, R.attr.materialCalendarStyle, wl4.class.getCanonicalName()), R.styleable.MaterialCalendar);
        this.f3224a = rl4.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_dayStyle, 0));
        this.g = rl4.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_dayInvalidStyle, 0));
        this.b = rl4.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_daySelectedStyle, 0));
        this.c = rl4.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_dayTodayStyle, 0));
        ColorStateList h1 = hd3.h1(context, obtainStyledAttributes, R.styleable.MaterialCalendar_rangeFillColor);
        this.d = rl4.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_yearStyle, 0));
        this.e = rl4.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_yearSelectedStyle, 0));
        this.f = rl4.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_yearTodayStyle, 0));
        Paint paint = new Paint();
        this.h = paint;
        paint.setColor(h1.getDefaultColor());
        obtainStyledAttributes.recycle();
    }
}
