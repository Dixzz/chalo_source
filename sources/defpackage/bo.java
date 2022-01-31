package defpackage;

import android.graphics.Matrix;
import android.view.View;

/* renamed from: bo  reason: default package */
/* compiled from: ViewUtilsApi29 */
public class bo extends ao {
    @Override // defpackage.xn, defpackage.co
    public float b(View view) {
        return view.getTransitionAlpha();
    }

    @Override // defpackage.zn, defpackage.co
    public void d(View view, int i, int i2, int i3, int i4) {
        view.setLeftTopRightBottom(i, i2, i3, i4);
    }

    @Override // defpackage.xn, defpackage.co
    public void e(View view, float f) {
        view.setTransitionAlpha(f);
    }

    @Override // defpackage.co, defpackage.ao
    public void f(View view, int i) {
        view.setTransitionVisibility(i);
    }

    @Override // defpackage.yn, defpackage.co
    public void g(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // defpackage.yn, defpackage.co
    public void h(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
