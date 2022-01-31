package defpackage;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/* renamed from: zj4  reason: default package */
/* compiled from: AnimationUtils */
public class zj4 {

    /* renamed from: a  reason: collision with root package name */
    public static final TimeInterpolator f4184a = new LinearInterpolator();
    public static final TimeInterpolator b = new fg();
    public static final TimeInterpolator c = new eg();
    public static final TimeInterpolator d = new gg();
    public static final TimeInterpolator e = new DecelerateInterpolator();

    public static int a(int i, int i2, float f) {
        return Math.round(f * ((float) (i2 - i))) + i;
    }
}
