package defpackage;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import app.zophop.ui.activities.HomeActivity;
import app.zophop.ui.fragments.HomeScreenMainFragment;
import com.razorpay.AnalyticsConstants;

/* renamed from: bp0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class bp0 implements om0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HomeScreenMainFragment f460a;

    public /* synthetic */ bp0(HomeScreenMainFragment homeScreenMainFragment) {
        this.f460a = homeScreenMainFragment;
    }

    @Override // defpackage.om0
    public final void a() {
        HomeScreenMainFragment homeScreenMainFragment = this.f460a;
        HomeScreenMainFragment.a aVar = HomeScreenMainFragment.v;
        n86.e(homeScreenMainFragment, "this$0");
        it0 it0 = it0.k;
        FragmentManager parentFragmentManager = homeScreenMainFragment.getParentFragmentManager();
        n86.d(parentFragmentManager, "parentFragmentManager");
        Context requireContext = homeScreenMainFragment.requireContext();
        n86.d(requireContext, "requireContext()");
        tu0 tu0 = new tu0(homeScreenMainFragment);
        HomeActivity.a aVar2 = HomeActivity.k;
        n86.e(parentFragmentManager, "manager");
        n86.e(requireContext, AnalyticsConstants.CONTEXT);
        n86.e(tu0, "listener");
        n86.e("Home Screen", "dialogGroupKey");
        it0 it02 = new it0(requireContext, tu0, "Home Screen");
        it02.show(parentFragmentManager, it0.l);
        it02.setCancelable(false);
    }
}
