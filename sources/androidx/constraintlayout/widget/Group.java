package androidx.constraintlayout.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Group extends k4 {
    public Group(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // defpackage.k4
    public void e(AttributeSet attributeSet) {
        super.e(attributeSet);
    }

    @Override // defpackage.k4
    public void g(ConstraintLayout constraintLayout) {
        ConstraintLayout.a aVar = (ConstraintLayout.a) getLayoutParams();
        aVar.l0.G(0);
        aVar.l0.B(0);
    }

    @Override // defpackage.k4
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        c();
    }

    public void setElevation(float f) {
        super.setElevation(f);
        c();
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        c();
    }
}
