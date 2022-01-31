package defpackage;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import com.google.firebase.perf.util.Constants;

/* renamed from: yn4  reason: default package */
/* compiled from: RippleUtils */
public class yn4 {

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f4071a = {16842919};
    public static final int[] b = {16843623, 16842908};
    public static final int[] c = {16842908};
    public static final int[] d = {16843623};
    public static final int[] e = {16842913, 16842919};
    public static final int[] f = {16842913, 16843623, 16842908};
    public static final int[] g = {16842913, 16842908};
    public static final int[] h = {16842913, 16843623};
    public static final int[] i = {16842913};
    public static final int[] j = {16842910, 16842919};
    public static final String k = yn4.class.getSimpleName();

    public static int a(ColorStateList colorStateList, int[] iArr) {
        int colorForState = colorStateList != null ? colorStateList.getColorForState(iArr, colorStateList.getDefaultColor()) : 0;
        return a6.c(colorForState, Math.min(Color.alpha(colorForState) * 2, (int) Constants.MAX_HOST_LENGTH));
    }

    public static ColorStateList b(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return ColorStateList.valueOf(0);
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 22 && i2 <= 27 && Color.alpha(colorStateList.getDefaultColor()) == 0) {
            Color.alpha(colorStateList.getColorForState(j, 0));
        }
        return colorStateList;
    }

    public static boolean c(int[] iArr) {
        boolean z = false;
        boolean z2 = false;
        for (int i2 : iArr) {
            if (i2 == 16842910) {
                z = true;
            } else if (i2 == 16842908 || i2 == 16842919 || i2 == 16843623) {
                z2 = true;
            }
        }
        return z && z2;
    }
}
