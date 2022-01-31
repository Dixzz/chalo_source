package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.bottomappbar.BottomAppBar;
import java.util.Objects;

/* renamed from: yk4  reason: default package */
/* compiled from: BottomAppBar */
public class yk4 extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BottomAppBar f4063a;

    public yk4(BottomAppBar bottomAppBar) {
        this.f4063a = bottomAppBar;
    }

    public void onAnimationEnd(Animator animator) {
        BottomAppBar.a(this.f4063a);
        Objects.requireNonNull(this.f4063a);
        this.f4063a.g = null;
    }

    public void onAnimationStart(Animator animator) {
        this.f4063a.k++;
    }
}
