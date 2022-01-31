package defpackage;

import android.content.Context;
import com.google.android.material.R;

/* renamed from: tm4  reason: default package */
/* compiled from: ElevationOverlayProvider */
public class tm4 {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f3378a;
    public final int b;
    public final int c;
    public final float d;

    public tm4(Context context) {
        this.f3378a = hd3.F2(context, R.attr.elevationOverlayEnabled, false);
        this.b = hd3.f1(context, R.attr.elevationOverlayColor, 0);
        this.c = hd3.f1(context, R.attr.colorSurface, 0);
        this.d = context.getResources().getDisplayMetrics().density;
    }
}
