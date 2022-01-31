package defpackage;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;

/* renamed from: gk4  reason: default package */
/* compiled from: MotionTiming */
public class gk4 {

    /* renamed from: a  reason: collision with root package name */
    public long f1273a = 0;
    public long b = 300;
    public TimeInterpolator c = null;
    public int d = 0;
    public int e = 1;

    public gk4(long j, long j2) {
        this.f1273a = j;
        this.b = j2;
    }

    public void a(Animator animator) {
        animator.setStartDelay(this.f1273a);
        animator.setDuration(this.b);
        animator.setInterpolator(b());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(this.d);
            valueAnimator.setRepeatMode(this.e);
        }
    }

    public TimeInterpolator b() {
        TimeInterpolator timeInterpolator = this.c;
        return timeInterpolator != null ? timeInterpolator : zj4.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof gk4)) {
            return false;
        }
        gk4 gk4 = (gk4) obj;
        if (this.f1273a == gk4.f1273a && this.b == gk4.b && this.d == gk4.d && this.e == gk4.e) {
            return b().getClass().equals(gk4.b().getClass());
        }
        return false;
    }

    public int hashCode() {
        long j = this.f1273a;
        long j2 = this.b;
        return ((((b().getClass().hashCode() + (((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31)) * 31) + this.d) * 31) + this.e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('\n');
        sb.append(gk4.class.getName());
        sb.append('{');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" delay: ");
        sb.append(this.f1273a);
        sb.append(" duration: ");
        sb.append(this.b);
        sb.append(" interpolator: ");
        sb.append(b().getClass());
        sb.append(" repeatCount: ");
        sb.append(this.d);
        sb.append(" repeatMode: ");
        return hj1.X(sb, this.e, "}\n");
    }

    public gk4(long j, long j2, TimeInterpolator timeInterpolator) {
        this.f1273a = j;
        this.b = j2;
        this.c = timeInterpolator;
    }
}
