package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewPropertyAnimator;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.SnackbarContentLayout;
import server.zophop.logicLayer.CsLogic;

/* renamed from: uo4  reason: default package */
/* compiled from: BaseTransientBottomBar */
public class uo4 extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaseTransientBottomBar f3534a;

    public uo4(BaseTransientBottomBar baseTransientBottomBar) {
        this.f3534a = baseTransientBottomBar;
    }

    public void onAnimationEnd(Animator animator) {
        this.f3534a.e();
    }

    public void onAnimationStart(Animator animator) {
        SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) this.f3534a.d;
        snackbarContentLayout.f.setAlpha(0.0f);
        ViewPropertyAnimator alpha = snackbarContentLayout.f.animate().alpha(1.0f);
        long j = (long) CsLogic.ETA_FORCE_UPDATE_REDIS_TTL;
        long j2 = (long) 70;
        alpha.setDuration(j).setStartDelay(j2).start();
        if (snackbarContentLayout.g.getVisibility() == 0) {
            snackbarContentLayout.g.setAlpha(0.0f);
            snackbarContentLayout.g.animate().alpha(1.0f).setDuration(j).setStartDelay(j2).start();
        }
    }
}
