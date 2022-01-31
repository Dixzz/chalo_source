package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.snackbar.BaseTransientBottomBar;

/* renamed from: qo4  reason: default package */
/* compiled from: BaseTransientBottomBar */
public class qo4 extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaseTransientBottomBar f2968a;

    public qo4(BaseTransientBottomBar baseTransientBottomBar) {
        this.f2968a = baseTransientBottomBar;
    }

    public void onAnimationEnd(Animator animator) {
        this.f2968a.e();
    }
}
