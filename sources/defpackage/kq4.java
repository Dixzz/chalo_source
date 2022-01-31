package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.transformation.FabTransformationBehavior;
import defpackage.pl4;

/* renamed from: kq4  reason: default package */
/* compiled from: FabTransformationBehavior */
public class kq4 extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ pl4 f2105a;

    public kq4(FabTransformationBehavior fabTransformationBehavior, pl4 pl4) {
        this.f2105a = pl4;
    }

    public void onAnimationEnd(Animator animator) {
        pl4.e revealInfo = this.f2105a.getRevealInfo();
        revealInfo.c = Float.MAX_VALUE;
        this.f2105a.setRevealInfo(revealInfo);
    }
}
