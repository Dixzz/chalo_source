package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import java.util.ArrayList;

/* renamed from: in4  reason: default package */
/* compiled from: StateListAnimator */
public final class in4 {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<b> f1537a = new ArrayList<>();
    public b b = null;
    public ValueAnimator c = null;
    public final Animator.AnimatorListener d = new a();

    /* renamed from: in4$a */
    /* compiled from: StateListAnimator */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        public void onAnimationEnd(Animator animator) {
            in4 in4 = in4.this;
            if (in4.c == animator) {
                in4.c = null;
            }
        }
    }

    /* renamed from: in4$b */
    /* compiled from: StateListAnimator */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final int[] f1539a;
        public final ValueAnimator b;

        public b(int[] iArr, ValueAnimator valueAnimator) {
            this.f1539a = iArr;
            this.b = valueAnimator;
        }
    }

    public void a(int[] iArr, ValueAnimator valueAnimator) {
        b bVar = new b(iArr, valueAnimator);
        valueAnimator.addListener(this.d);
        this.f1537a.add(bVar);
    }
}
