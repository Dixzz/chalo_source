package defpackage;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import app.zophop.ui.fragments.HomeScreenMainFragment;
import app.zophop.utilities.models.InAppMessageDetails;

/* renamed from: kp0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class kp0 implements om0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HomeScreenMainFragment f2096a;
    public final /* synthetic */ InAppMessageDetails b;

    public /* synthetic */ kp0(HomeScreenMainFragment homeScreenMainFragment, InAppMessageDetails inAppMessageDetails) {
        this.f2096a = homeScreenMainFragment;
        this.b = inAppMessageDetails;
    }

    @Override // defpackage.om0
    public final void a() {
        HomeScreenMainFragment homeScreenMainFragment = this.f2096a;
        InAppMessageDetails inAppMessageDetails = this.b;
        HomeScreenMainFragment.a aVar = HomeScreenMainFragment.v;
        n86.e(homeScreenMainFragment, "this$0");
        n86.e(inAppMessageDetails, "$lMessageDetails");
        FragmentManager parentFragmentManager = homeScreenMainFragment.getParentFragmentManager();
        n86.d(parentFragmentManager, "parentFragmentManager");
        mu0 mu0 = new mu0();
        n86.e(parentFragmentManager, "manager");
        n86.e(inAppMessageDetails, "data");
        n86.e(mu0, "handler");
        Bundle bundle = new Bundle();
        bundle.putParcelable("data", inAppMessageDetails);
        jg1 jg1 = new jg1(mu0);
        jg1.setCancelable(true);
        jg1.setArguments(bundle);
        jg1.show(parentFragmentManager, "inAppMessage");
    }
}
