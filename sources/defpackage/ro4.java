package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.snackbar.BaseTransientBottomBar;

/* renamed from: ro4  reason: default package */
/* compiled from: BaseTransientBottomBar */
public class ro4 extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3107a;
    public final /* synthetic */ BaseTransientBottomBar b;

    public ro4(BaseTransientBottomBar baseTransientBottomBar, int i) {
        this.b = baseTransientBottomBar;
        this.f3107a = i;
    }

    public void onAnimationEnd(Animator animator) {
        this.b.d(this.f3107a);
    }
}
