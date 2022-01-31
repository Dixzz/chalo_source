package defpackage;

import android.view.View;
import androidx.fragment.app.Fragment;
import defpackage.t6;

/* renamed from: we  reason: default package */
/* compiled from: FragmentAnim */
public class we implements t6.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Fragment f3765a;

    public we(Fragment fragment) {
        this.f3765a = fragment;
    }

    @Override // defpackage.t6.a
    public void a() {
        if (this.f3765a.getAnimatingAway() != null) {
            View animatingAway = this.f3765a.getAnimatingAway();
            this.f3765a.setAnimatingAway(null);
            animatingAway.clearAnimation();
        }
        this.f3765a.setAnimator(null);
    }
}
