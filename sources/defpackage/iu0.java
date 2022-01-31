package defpackage;

import androidx.fragment.app.FragmentManager;
import app.zophop.ui.activities.cardRecharge.CardRechargeActivity;
import app.zophop.ui.fragments.HomeScreenMainFragment;
import com.razorpay.AnalyticsConstants;
import defpackage.ak0;
import java.util.Objects;

/* renamed from: iu0  reason: default package */
/* compiled from: HomeScreenMainFragment.kt */
public final class iu0 implements ak0.c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HomeScreenMainFragment f1572a;

    public iu0(HomeScreenMainFragment homeScreenMainFragment) {
        this.f1572a = homeScreenMainFragment;
    }

    @Override // defpackage.ak0.c
    public void a() {
        HomeScreenMainFragment homeScreenMainFragment = this.f1572a;
        HomeScreenMainFragment.a aVar = HomeScreenMainFragment.v;
        Objects.requireNonNull(homeScreenMainFragment);
        ed1 ed1 = new ed1("ocr homescreen card recharge card", Long.MIN_VALUE);
        ed1.a("source", "sourceHomeScreen");
        ui1.m0(ed1);
        if (xt.f3961a.l().h.has("keyWasOnlineCardRechargeTutorialShown")) {
            ve activity = this.f1572a.c();
            if (activity != null) {
                CardRechargeActivity.s0("sourceHomeScreen", activity);
                return;
            }
            return;
        }
        HomeScreenMainFragment homeScreenMainFragment2 = this.f1572a;
        FragmentManager parentFragmentManager = homeScreenMainFragment2.getParentFragmentManager();
        n86.d(parentFragmentManager, "parentFragmentManager");
        uu0 uu0 = new uu0(homeScreenMainFragment2);
        n86.e(parentFragmentManager, "manager");
        n86.e(uu0, "listener");
        vy0 vy0 = new vy0(uu0);
        vy0.show(parentFragmentManager, AnalyticsConstants.SHOW);
        vy0.setCancelable(false);
    }
}
