package defpackage;

import androidx.constraintlayout.widget.ConstraintLayout;
import app.zophop.ui.activities.HomeActivity;
import app.zophop.ui.fragments.HomeScreenMainFragment;
import com.google.android.material.card.MaterialCardView;
import java.util.Objects;

/* renamed from: yp0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class yp0 implements Runnable {
    public final /* synthetic */ HomeScreenMainFragment f;

    public /* synthetic */ yp0(HomeScreenMainFragment homeScreenMainFragment) {
        this.f = homeScreenMainFragment;
    }

    public final void run() {
        HomeScreenMainFragment homeScreenMainFragment = this.f;
        HomeScreenMainFragment.a aVar = HomeScreenMainFragment.v;
        n86.e(homeScreenMainFragment, "this$0");
        T t = homeScreenMainFragment.f;
        n86.c(t);
        ((cy) t).O.b.setVisibility(8);
        T t2 = homeScreenMainFragment.f;
        n86.c(t2);
        ((cy) t2).z.b.setVisibility(8);
        T t3 = homeScreenMainFragment.f;
        n86.c(t3);
        ((cy) t3).s.b.setVisibility(8);
        T t4 = homeScreenMainFragment.f;
        n86.c(t4);
        cy cyVar = (cy) t4;
        MaterialCardView materialCardView = cyVar.b;
        n86.d(materialCardView, "disruptionCard");
        boolean z = true;
        if (!(materialCardView.getVisibility() == 0)) {
            ConstraintLayout constraintLayout = cyVar.E;
            n86.d(constraintLayout, "recentSearchesContainer");
            if (!(constraintLayout.getVisibility() == 0)) {
                ConstraintLayout constraintLayout2 = cyVar.M;
                n86.d(constraintLayout2, "yourPlansContainer");
                if (!(constraintLayout2.getVisibility() == 0)) {
                    ConstraintLayout constraintLayout3 = cyVar.x;
                    n86.d(constraintLayout3, "productListContainer");
                    if (!(constraintLayout3.getVisibility() == 0)) {
                        ConstraintLayout constraintLayout4 = cyVar.q;
                        n86.d(constraintLayout4, "nearestBusStopContainer");
                        if (!(constraintLayout4.getVisibility() == 0)) {
                            ConstraintLayout constraintLayout5 = cyVar.h;
                            n86.d(constraintLayout5, "homeScreenMapContainer");
                            if (!(constraintLayout5.getVisibility() == 0)) {
                                ConstraintLayout constraintLayout6 = cyVar.u;
                                n86.d(constraintLayout6, "partnerCardContainer");
                                if (!(constraintLayout6.getVisibility() == 0)) {
                                    z = false;
                                }
                            }
                        }
                    }
                }
            }
        }
        if (!z) {
            ve activity = homeScreenMainFragment.c();
            Objects.requireNonNull(activity, "null cannot be cast to non-null type app.zophop.ui.activities.HomeActivity");
            ((HomeActivity) activity).k0();
            T t5 = homeScreenMainFragment.f;
            n86.c(t5);
            ConstraintLayout constraintLayout7 = ((cy) t5).o.c;
            n86.d(constraintLayout7, "viewBinding.loadingScreen.loadingScreenContainer");
            constraintLayout7.setVisibility(0);
        }
    }
}
