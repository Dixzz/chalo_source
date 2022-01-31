package defpackage;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;

/* renamed from: bn4  reason: default package */
/* compiled from: FloatingActionButtonImplLollipop */
public class bn4 extends ym4 {
    public bn4(FloatingActionButton floatingActionButton, ao4 ao4) {
        super(floatingActionButton, ao4);
    }

    @Override // defpackage.ym4
    public float c() {
        return this.s.getElevation();
    }

    @Override // defpackage.ym4
    public void d(Rect rect) {
        if (FloatingActionButton.this.o) {
            super.d(rect);
        } else if (!r()) {
            int sizeDimension = (0 - this.s.getSizeDimension()) / 2;
            rect.set(sizeDimension, sizeDimension, sizeDimension, sizeDimension);
        } else {
            rect.set(0, 0, 0, 0);
        }
    }

    @Override // defpackage.ym4
    public void g() {
    }

    @Override // defpackage.ym4
    public void h() {
        t();
        throw null;
    }

    @Override // defpackage.ym4
    public void i(int[] iArr) {
        if (Build.VERSION.SDK_INT != 21) {
            return;
        }
        if (this.s.isEnabled()) {
            this.s.setElevation(this.d);
            if (this.s.isPressed()) {
                this.s.setTranslationZ(this.f);
            } else if (this.s.isFocused() || this.s.isHovered()) {
                this.s.setTranslationZ(this.e);
            } else {
                this.s.setTranslationZ(0.0f);
            }
        } else {
            this.s.setElevation(0.0f);
            this.s.setTranslationZ(0.0f);
        }
    }

    @Override // defpackage.ym4
    public void j(float f, float f2, float f3) {
        int i = Build.VERSION.SDK_INT;
        if (i == 21) {
            this.s.refreshDrawableState();
        } else {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(ym4.A, u(f, f3));
            stateListAnimator.addState(ym4.B, u(f, f2));
            stateListAnimator.addState(ym4.C, u(f, f2));
            stateListAnimator.addState(ym4.D, u(f, f2));
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(this.s, "elevation", f).setDuration(0L));
            if (i >= 22 && i <= 24) {
                FloatingActionButton floatingActionButton = this.s;
                arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, View.TRANSLATION_Z, floatingActionButton.getTranslationZ()).setDuration(100L));
            }
            arrayList.add(ObjectAnimator.ofFloat(this.s, View.TRANSLATION_Z, 0.0f).setDuration(100L));
            animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
            animatorSet.setInterpolator(ym4.z);
            stateListAnimator.addState(ym4.E, animatorSet);
            stateListAnimator.addState(ym4.F, u(0.0f, 0.0f));
            this.s.setStateListAnimator(stateListAnimator);
        }
        if (p()) {
            t();
            throw null;
        }
    }

    @Override // defpackage.ym4
    public boolean m() {
        return false;
    }

    @Override // defpackage.ym4
    public void o(ColorStateList colorStateList) {
    }

    @Override // defpackage.ym4
    public boolean p() {
        return FloatingActionButton.this.o || !r();
    }

    @Override // defpackage.ym4
    public void s() {
    }

    public final Animator u(float f, float f2) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.s, "elevation", f).setDuration(0L)).with(ObjectAnimator.ofFloat(this.s, View.TRANSLATION_Z, f2).setDuration(100L));
        animatorSet.setInterpolator(ym4.z);
        return animatorSet;
    }
}
