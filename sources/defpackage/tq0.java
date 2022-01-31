package defpackage;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import app.zophop.R;
import app.zophop.ui.activities.HomeActivity;
import app.zophop.ui.fragments.HomeScreenMainFragment;

/* renamed from: tq0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class tq0 implements om0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HomeScreenMainFragment f3392a;
    public final /* synthetic */ String b;

    public /* synthetic */ tq0(HomeScreenMainFragment homeScreenMainFragment, String str) {
        this.f3392a = homeScreenMainFragment;
        this.b = str;
    }

    @Override // defpackage.om0
    public final void a() {
        HomeScreenMainFragment homeScreenMainFragment = this.f3392a;
        String str = this.b;
        HomeScreenMainFragment.a aVar = HomeScreenMainFragment.v;
        n86.e(homeScreenMainFragment, "this$0");
        n86.e(str, "$lCopyText");
        FragmentManager parentFragmentManager = homeScreenMainFragment.getParentFragmentManager();
        n86.d(parentFragmentManager, "parentFragmentManager");
        String string = homeScreenMainFragment.getString(R.string.pass_extension_dialog_title);
        String string2 = homeScreenMainFragment.getString(R.string.okay);
        vu0 vu0 = new vu0();
        HomeActivity.a aVar2 = HomeActivity.k;
        n86.e(parentFragmentManager, "manager");
        n86.e(vu0, "listener");
        du0 du0 = new du0();
        new qn0().g = "Home Screen";
        Bundle bundle = new Bundle();
        if (string != null) {
            bundle.putString("extra:title_copy", string);
        }
        bundle.putString("extra:message_copy", str);
        if (string2 != null) {
            bundle.putString("extra:positive_action_copy", string2);
        }
        bundle.putInt("extra:alignment_id", 1);
        bundle.putInt("extra:drawable_id", R.drawable.pass_validity);
        du0.setArguments(bundle);
        du0.u = vu0;
        du0.show(parentFragmentManager, "confirmation_bottomsheet");
        du0.setCancelable(false);
        du0.e(new oq0(du0));
    }
}
