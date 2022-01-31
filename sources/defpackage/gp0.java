package defpackage;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import app.zophop.R;
import app.zophop.ui.activities.HomeActivity;
import app.zophop.ui.fragments.HomeScreenMainFragment;

/* renamed from: gp0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class gp0 implements om0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HomeScreenMainFragment f1293a;

    public /* synthetic */ gp0(HomeScreenMainFragment homeScreenMainFragment) {
        this.f1293a = homeScreenMainFragment;
    }

    @Override // defpackage.om0
    public final void a() {
        HomeScreenMainFragment homeScreenMainFragment = this.f1293a;
        HomeScreenMainFragment.a aVar = HomeScreenMainFragment.v;
        n86.e(homeScreenMainFragment, "this$0");
        FragmentManager parentFragmentManager = homeScreenMainFragment.getParentFragmentManager();
        n86.d(parentFragmentManager, "parentFragmentManager");
        String string = homeScreenMainFragment.getString(R.string.city_not_yet_added);
        String string2 = homeScreenMainFragment.getString(R.string.okay);
        HomeActivity.a aVar2 = HomeActivity.k;
        n86.e(parentFragmentManager, "manager");
        du0 du0 = new du0();
        new qn0().g = "Home Screen";
        Bundle bundle = new Bundle();
        if (string != null) {
            bundle.putString("extra:title_copy", string);
        }
        if (string2 != null) {
            bundle.putString("extra:positive_action_copy", string2);
        }
        bundle.putInt("extra:alignment_id", 1);
        bundle.putInt("extra:drawable_id", R.drawable.city_change);
        du0.setArguments(bundle);
        du0.show(parentFragmentManager, "confirmation_bottomsheet");
        du0.setCancelable(false);
        du0.e(new zq0(du0));
        jz5.b().g(hj1.l("city not supported prompt open", Long.MIN_VALUE, "source", HomeActivity.class.getSimpleName()));
    }
}
