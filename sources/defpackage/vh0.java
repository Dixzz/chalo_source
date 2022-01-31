package defpackage;

import android.os.Bundle;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import app.zophop.R;
import app.zophop.models.mTicketing.CardRechargeConfiguration;
import app.zophop.ui.activities.cardRecharge.CardRechargeActivity;
import java.util.Objects;

/* renamed from: vh0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class vh0 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CardRechargeActivity f3648a;

    public /* synthetic */ vh0(CardRechargeActivity cardRechargeActivity) {
        this.f3648a = cardRechargeActivity;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        CardRechargeActivity cardRechargeActivity = this.f3648a;
        CardRechargeConfiguration cardRechargeConfiguration = (CardRechargeConfiguration) obj;
        int i = CardRechargeActivity.o;
        n86.e(cardRechargeActivity, "this$0");
        if (cardRechargeConfiguration != null) {
            LinearLayout linearLayout = ((yv) cardRechargeActivity.f0()).d;
            n86.d(linearLayout, "viewBinding.skeletonLoaderLayout");
            linearLayout.setVisibility(8);
            LinearLayout linearLayout2 = ((yv) cardRechargeActivity.f0()).c;
            n86.d(linearLayout2, "viewBinding.connectionErrorView");
            linearLayout2.setVisibility(8);
            Bundle bundle = new Bundle();
            bundle.putParcelable("arg_cardRechargeConfiguration", cardRechargeConfiguration);
            n86.e(bundle, "lArgBundle");
            Fragment H = cardRechargeActivity.getSupportFragmentManager().H(R.id.card_recharge_nav_host_fragment);
            Objects.requireNonNull(H, "null cannot be cast to non-null type androidx.navigation.fragment.NavHostFragment");
            NavHostFragment navHostFragment = (NavHostFragment) H;
            NavController e = navHostFragment.e();
            n86.d(e, "lNavHostFragment.navController");
            n86.e(e, "<set-?>");
            cardRechargeActivity.k = e;
            jj e2 = navHostFragment.e().e();
            n86.d(e2, "lNavHostFragment.navController.navInflater");
            gj c = e2.c(R.navigation.nav_graph_card_recharge);
            n86.d(c, "lNavGraphInflater.inflat….nav_graph_card_recharge)");
            c.A(R.id.cardDetailsFragment);
            cardRechargeActivity.p0().i(c, bundle);
            cardRechargeActivity.setSupportActionBar(((yv) cardRechargeActivity.f0()).e);
            h.B0(cardRechargeActivity, cardRechargeActivity.p0(), cardRechargeActivity.l);
        }
    }
}
