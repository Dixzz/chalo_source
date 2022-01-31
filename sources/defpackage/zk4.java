package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.appcompat.widget.ActionMenuView;
import com.google.android.material.bottomappbar.BottomAppBar;
import java.util.Objects;

/* renamed from: zk4  reason: default package */
/* compiled from: BottomAppBar */
public class zk4 extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public boolean f4186a;
    public final /* synthetic */ ActionMenuView b;
    public final /* synthetic */ int c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ BottomAppBar e;

    public zk4(BottomAppBar bottomAppBar, ActionMenuView actionMenuView, int i, boolean z) {
        this.e = bottomAppBar;
        this.b = actionMenuView;
        this.c = i;
        this.d = z;
    }

    public void onAnimationCancel(Animator animator) {
        this.f4186a = true;
    }

    public void onAnimationEnd(Animator animator) {
        if (!this.f4186a) {
            BottomAppBar bottomAppBar = this.e;
            int i = bottomAppBar.l;
            boolean z = i != 0;
            if (i != 0) {
                bottomAppBar.l = 0;
                bottomAppBar.getMenu().clear();
                bottomAppBar.inflateMenu(i);
            }
            BottomAppBar bottomAppBar2 = this.e;
            ActionMenuView actionMenuView = this.b;
            int i2 = this.c;
            boolean z2 = this.d;
            Objects.requireNonNull(bottomAppBar2);
            al4 al4 = new al4(bottomAppBar2, actionMenuView, i2, z2);
            if (z) {
                actionMenuView.post(al4);
            } else {
                al4.run();
            }
        }
    }
}
