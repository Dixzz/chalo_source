package defpackage;

import android.annotation.SuppressLint;
import android.view.View;

/* renamed from: zn  reason: default package */
/* compiled from: ViewUtilsApi22 */
public class zn extends yn {
    public static boolean h = true;

    @Override // defpackage.co
    @SuppressLint({"NewApi"})
    public void d(View view, int i, int i2, int i3, int i4) {
        if (h) {
            try {
                view.setLeftTopRightBottom(i, i2, i3, i4);
            } catch (NoSuchMethodError unused) {
                h = false;
            }
        }
    }
}
