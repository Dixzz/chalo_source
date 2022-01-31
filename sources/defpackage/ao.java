package defpackage;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;

/* renamed from: ao  reason: default package */
/* compiled from: ViewUtilsApi23 */
public class ao extends zn {
    public static boolean i = true;

    @Override // defpackage.co
    @SuppressLint({"NewApi"})
    public void f(View view, int i2) {
        if (Build.VERSION.SDK_INT == 28) {
            super.f(view, i2);
        } else if (i) {
            try {
                view.setTransitionVisibility(i2);
            } catch (NoSuchMethodError unused) {
                i = false;
            }
        }
    }
}
