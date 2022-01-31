package defpackage;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import java.util.ArrayList;
import java.util.List;

/* renamed from: fk4  reason: default package */
/* compiled from: MotionSpec */
public class fk4 {

    /* renamed from: a  reason: collision with root package name */
    public final u2<String, gk4> f1135a = new u2<>();
    public final u2<String, PropertyValuesHolder[]> b = new u2<>();

    public static fk4 a(Context context, TypedArray typedArray, int i) {
        int resourceId;
        if (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0) {
            return null;
        }
        return b(context, resourceId);
    }

    public static fk4 b(Context context, int i) {
        try {
            Animator loadAnimator = AnimatorInflater.loadAnimator(context, i);
            if (loadAnimator instanceof AnimatorSet) {
                return c(((AnimatorSet) loadAnimator).getChildAnimations());
            }
            if (loadAnimator == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(loadAnimator);
            return c(arrayList);
        } catch (Exception unused) {
            Integer.toHexString(i);
            return null;
        }
    }

    public static fk4 c(List<Animator> list) {
        fk4 fk4 = new fk4();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Animator animator = list.get(i);
            if (animator instanceof ObjectAnimator) {
                ObjectAnimator objectAnimator = (ObjectAnimator) animator;
                fk4.b.put(objectAnimator.getPropertyName(), objectAnimator.getValues());
                String propertyName = objectAnimator.getPropertyName();
                long startDelay = objectAnimator.getStartDelay();
                long duration = objectAnimator.getDuration();
                TimeInterpolator interpolator = objectAnimator.getInterpolator();
                if ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) {
                    interpolator = zj4.b;
                } else if (interpolator instanceof AccelerateInterpolator) {
                    interpolator = zj4.c;
                } else if (interpolator instanceof DecelerateInterpolator) {
                    interpolator = zj4.d;
                }
                gk4 gk4 = new gk4(startDelay, duration, interpolator);
                gk4.d = objectAnimator.getRepeatCount();
                gk4.e = objectAnimator.getRepeatMode();
                fk4.f1135a.put(propertyName, gk4);
            } else {
                throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
            }
        }
        return fk4;
    }

    public gk4 d(String str) {
        if (this.f1135a.getOrDefault(str, null) != null) {
            return this.f1135a.getOrDefault(str, null);
        }
        throw new IllegalArgumentException();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof fk4)) {
            return false;
        }
        return this.f1135a.equals(((fk4) obj).f1135a);
    }

    public int hashCode() {
        return this.f1135a.hashCode();
    }

    public String toString() {
        return '\n' + fk4.class.getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.f1135a + "}\n";
    }
}
