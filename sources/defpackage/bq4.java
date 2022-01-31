package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.R;

/* renamed from: bq4  reason: default package */
/* compiled from: MaterialThemeOverlay */
public class bq4 {

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f468a = {16842752, R.attr.theme};
    public static final int[] b = {R.attr.materialThemeOverlay};

    public static Context a(Context context, AttributeSet attributeSet, int i, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b, i, i2);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        boolean z = (context instanceof d1) && ((d1) context).f776a == resourceId;
        if (resourceId == 0 || z) {
            return context;
        }
        d1 d1Var = new d1(context, resourceId);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, f468a);
        int resourceId2 = obtainStyledAttributes2.getResourceId(0, 0);
        int resourceId3 = obtainStyledAttributes2.getResourceId(1, 0);
        obtainStyledAttributes2.recycle();
        if (resourceId2 == 0) {
            resourceId2 = resourceId3;
        }
        if (resourceId2 != 0) {
            d1Var.getTheme().applyStyle(resourceId2, true);
        }
        return d1Var;
    }
}
