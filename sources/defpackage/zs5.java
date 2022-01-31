package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.urbanairship.R;

/* renamed from: zs5  reason: default package */
/* compiled from: BoundedViewDelegate */
public class zs5 {

    /* renamed from: a  reason: collision with root package name */
    public int f4207a;
    public int b;

    public zs5(Context context, AttributeSet attributeSet, int i, int i2) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.UrbanAirshipLayout, i, i2);
            this.f4207a = obtainStyledAttributes.getDimensionPixelSize(R.styleable.UrbanAirshipLayout_urbanAirshipMaxWidth, 0);
            this.b = obtainStyledAttributes.getDimensionPixelSize(R.styleable.UrbanAirshipLayout_urbanAirshipMaxHeight, 0);
            obtainStyledAttributes.recycle();
        }
    }
}
