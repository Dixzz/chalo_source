package defpackage;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import app.zophop.ui.activities.HomeActivity;
import app.zophop.ui.fragments.HomeScreenMainFragment;
import com.razorpay.AnalyticsConstants;

/* renamed from: mp0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class mp0 implements om0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HomeScreenMainFragment f2423a;

    public /* synthetic */ mp0(HomeScreenMainFragment homeScreenMainFragment) {
        this.f2423a = homeScreenMainFragment;
    }

    @Override // defpackage.om0
    public final void a() {
        HomeScreenMainFragment homeScreenMainFragment = this.f2423a;
        HomeScreenMainFragment.a aVar = HomeScreenMainFragment.v;
        n86.e(homeScreenMainFragment, "this$0");
        FragmentManager parentFragmentManager = homeScreenMainFragment.getParentFragmentManager();
        n86.d(parentFragmentManager, "parentFragmentManager");
        Context requireContext = homeScreenMainFragment.requireContext();
        n86.d(requireContext, "requireContext()");
        wu0 wu0 = new wu0(homeScreenMainFragment);
        HomeActivity.a aVar2 = HomeActivity.k;
        n86.e(parentFragmentManager, "manager");
        n86.e(requireContext, AnalyticsConstants.CONTEXT);
        n86.e(wu0, "listener");
        n86.e("Home Screen", "orderedDialogKey");
        gw0 gw0 = new gw0(requireContext, wu0, "Home Screen");
        gw0.show(parentFragmentManager, AnalyticsConstants.SHOW);
        gw0.setCancelable(false);
    }
}
