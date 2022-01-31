package defpackage;

import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.view.View;
import com.google.android.material.R;

/* renamed from: uk4  reason: default package */
/* compiled from: ViewUtilsLollipop */
public class uk4 {

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f3517a = {16843848};

    public static void a(View view, float f) {
        int integer = view.getResources().getInteger(R.integer.app_bar_elevation_anim_duration);
        StateListAnimator stateListAnimator = new StateListAnimator();
        long j = (long) integer;
        stateListAnimator.addState(new int[]{16842766, R.attr.state_liftable, -R.attr.state_lifted}, ObjectAnimator.ofFloat(view, "elevation", 0.0f).setDuration(j));
        stateListAnimator.addState(new int[]{16842766}, ObjectAnimator.ofFloat(view, "elevation", f).setDuration(j));
        stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(view, "elevation", 0.0f).setDuration(0L));
        view.setStateListAnimator(stateListAnimator);
    }
}
