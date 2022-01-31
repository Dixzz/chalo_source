package defpackage;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.view.View;

/* renamed from: yn  reason: default package */
/* compiled from: ViewUtilsApi21 */
public class yn extends xn {
    public static boolean f = true;
    public static boolean g = true;

    @Override // defpackage.co
    @SuppressLint({"NewApi"})
    public void g(View view, Matrix matrix) {
        if (f) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError unused) {
                f = false;
            }
        }
    }

    @Override // defpackage.co
    @SuppressLint({"NewApi"})
    public void h(View view, Matrix matrix) {
        if (g) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError unused) {
                g = false;
            }
        }
    }
}
