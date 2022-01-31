package defpackage;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import app.zophop.R;
import app.zophop.ui.activities.HomeActivity;
import app.zophop.ui.fragments.HomeScreenMainFragment;

/* renamed from: tp0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class tp0 implements om0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HomeScreenMainFragment f3387a;
    public final /* synthetic */ String b;

    public /* synthetic */ tp0(HomeScreenMainFragment homeScreenMainFragment, String str) {
        this.f3387a = homeScreenMainFragment;
        this.b = str;
    }

    @Override // defpackage.om0
    public final void a() {
        HomeScreenMainFragment homeScreenMainFragment = this.f3387a;
        String str = this.b;
        HomeScreenMainFragment.a aVar = HomeScreenMainFragment.v;
        n86.e(homeScreenMainFragment, "this$0");
        FragmentManager parentFragmentManager = homeScreenMainFragment.getParentFragmentManager();
        n86.d(parentFragmentManager, "parentFragmentManager");
        String string = homeScreenMainFragment.getString(R.string.change_city_bottom_sheet_text);
        n86.d(string, "getString(R.string.change_city_bottom_sheet_text)");
        String e0 = hj1.e0(new Object[]{str}, 1, string, "java.lang.String.format(format, *args)");
        String string2 = homeScreenMainFragment.getString(R.string.change);
        String string3 = homeScreenMainFragment.getString(R.string.dont_change);
        HomeActivity.a aVar2 = HomeActivity.k;
        n86.e(parentFragmentManager, "manager");
        du0 du0 = new du0();
        new qn0().g = "Home Screen";
        Bundle bundle = new Bundle();
        bundle.putString("extra:title_copy", e0);
        if (string2 != null) {
            bundle.putString("extra:positive_action_copy", string2);
        }
        if (string3 != null) {
            bundle.putString("extra:negative_action_copy", string3);
        }
        bundle.putInt("extra:alignment_id", 1);
        bundle.putInt("extra:drawable_id", R.drawable.city_change);
        du0.setArguments(bundle);
        du0.show(parentFragmentManager, "confirmation_bottomsheet");
        du0.setCancelable(false);
        du0.e(new dp0(du0, homeScreenMainFragment));
        du0.d(new cq0(du0));
        ui1.n0(str, HomeActivity.class.getSimpleName());
    }
}
