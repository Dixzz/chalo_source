package defpackage;

import android.annotation.SuppressLint;
import android.view.View;

/* renamed from: xn  reason: default package */
/* compiled from: ViewUtilsApi19 */
public class xn extends co {
    public static boolean e = true;

    @Override // defpackage.co
    public void a(View view) {
    }

    @Override // defpackage.co
    @SuppressLint({"NewApi"})
    public float b(View view) {
        if (e) {
            try {
                return view.getTransitionAlpha();
            } catch (NoSuchMethodError unused) {
                e = false;
            }
        }
        return view.getAlpha();
    }

    @Override // defpackage.co
    public void c(View view) {
    }

    @Override // defpackage.co
    @SuppressLint({"NewApi"})
    public void e(View view, float f) {
        if (e) {
            try {
                view.setTransitionAlpha(f);
                return;
            } catch (NoSuchMethodError unused) {
                e = false;
            }
        }
        view.setAlpha(f);
    }
}
