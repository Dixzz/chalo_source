package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewPropertyAnimator;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.SnackbarContentLayout;
import server.zophop.logicLayer.CsLogic;

/* renamed from: wo4  reason: default package */
/* compiled from: BaseTransientBottomBar */
public class wo4 extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3816a;
    public final /* synthetic */ BaseTransientBottomBar b;

    public wo4(BaseTransientBottomBar baseTransientBottomBar, int i) {
        this.b = baseTransientBottomBar;
        this.f3816a = i;
    }

    public void onAnimationEnd(Animator animator) {
        this.b.d(this.f3816a);
    }

    public void onAnimationStart(Animator animator) {
        SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) this.b.d;
        snackbarContentLayout.f.setAlpha(1.0f);
        ViewPropertyAnimator alpha = snackbarContentLayout.f.animate().alpha(0.0f);
        long j = (long) CsLogic.ETA_FORCE_UPDATE_REDIS_TTL;
        long j2 = (long) 0;
        alpha.setDuration(j).setStartDelay(j2).start();
        if (snackbarContentLayout.g.getVisibility() == 0) {
            snackbarContentLayout.g.setAlpha(1.0f);
            snackbarContentLayout.g.animate().alpha(0.0f).setDuration(j).setStartDelay(j2).start();
        }
    }
}
