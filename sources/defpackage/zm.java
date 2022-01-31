package defpackage;

import android.animation.ValueAnimator;
import defpackage.bn;

/* renamed from: zm  reason: default package */
/* compiled from: CircularProgressDrawable */
public class zm implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ bn.a f4188a;
    public final /* synthetic */ bn b;

    public zm(bn bnVar, bn.a aVar) {
        this.b = bnVar;
        this.f4188a = aVar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.b.d(floatValue, this.f4188a);
        this.b.a(floatValue, this.f4188a, false);
        this.b.invalidateSelf();
    }
}
